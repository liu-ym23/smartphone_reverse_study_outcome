package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageAnalysis extends UseCase {
    public static final int COORDINATE_SYSTEM_ORIGINAL = 0;
    public static final int COORDINATE_SYSTEM_SENSOR = 2;
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
    public static final Defaults DEFAULT_CONFIG = null;
    private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
    private static final Boolean DEFAULT_ONE_PIXEL_SHIFT_ENABLED = null;
    private static final int DEFAULT_OUTPUT_IMAGE_FORMAT = 1;
    private static final boolean DEFAULT_OUTPUT_IMAGE_ROTATION_ENABLED = false;
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int OUTPUT_IMAGE_FORMAT_RGBA_8888 = 2;
    public static final int OUTPUT_IMAGE_FORMAT_YUV_420_888 = 1;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private DeferrableSurface mDeferrableSurface;
    final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;
    SessionConfig.Builder mSessionConfigBuilder;
    private Analyzer mSubscribedAnalyzer;

    public interface Analyzer {

        /* JADX INFO: renamed from: androidx.camera.core.ImageAnalysis$Analyzer$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Size $default$getDefaultTargetResolution(Analyzer r0) {
                return null;
            }

            public static int $default$getTargetCoordinateSystem(Analyzer r0) {
                return 0;
            }

            public static void $default$updateTransform(Analyzer r0, Matrix r1) {
            }
        }

        void analyze(ImageProxy r1);

        Size getDefaultTargetResolution();

        int getTargetCoordinateSystem();

        void updateTransform(Matrix r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BackpressureStrategy {
    }

    public static final class Builder implements ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder>, UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, Builder>, ImageInputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public ImageAnalysisConfig getUseCaseConfig() {
            return new ImageAnalysisConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public ImageAnalysis build() {
            ImageAnalysisConfig r0 = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(r0);
            return new ImageAnalysis(r0);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ Object build() {
            return build();
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ UseCaseConfig getUseCaseConfig() {
            return getUseCaseConfig();
        }

        private Builder(MutableOptionsBundle r4) {
            this.mMutableConfig = r4;
            Class r5 = (Class) r4.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r5 != null) goto L5;
        L9:
            setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
            setTargetClass(ImageAnalysis.class);
            return;
        L5:
            if (r5.equals(ImageAnalysis.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r5);
        }

        public static Builder fromConfig(Config r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public Builder setBackgroundExecutor(Executor r3) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, r3);
            return this;
        }

        public Builder setBackpressureStrategy(int r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(r3));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCaptureType(UseCaseConfigFactory.CaptureType r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setCustomOrderedResolutions(List<Size> r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultCaptureConfig(CaptureConfig r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setDefaultResolution(Size r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultSessionConfig(SessionConfig r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public Builder setDynamicRange(DynamicRange r3) {
            if (Objects.equals(DynamicRange.SDR, r3) == false) goto L7;
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, r3);
            return this;
        L7:
            throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setHighResolutionDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        public Builder setImageQueueDepth(int r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(r3));
            return this;
        }

        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setMaxResolution(Size r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setMirrorMode(int r2) {
            throw new UnsupportedOperationException("setMirrorMode is not supported.");
        }

        public Builder setOnePixelShiftEnabled(boolean r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_ONE_PIXEL_SHIFT_ENABLED, Boolean.valueOf(r3));
            return this;
        }

        public Builder setOutputImageFormat(int r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_FORMAT, Integer.valueOf(r3));
            return this;
        }

        public Builder setOutputImageRotationEnabled(boolean r3) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, Boolean.valueOf(r3));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setResolutionSelector(ResolutionSelector r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSurfaceOccupancyPriority(int r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(r3));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetAspectRatio(int r3) {
            if (r3 != (-1)) goto L5;
            r3 = 0;
        L5:
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(r3));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetClass(Class<ImageAnalysis> r4) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r4);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r4.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String r3) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetResolution(Size r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetRotation(int r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r3));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setZslDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        public static Builder fromConfig(ImageAnalysisConfig r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public /* bridge */ /* synthetic */ Builder setBackgroundExecutor(Executor r1) {
            return setBackgroundExecutor(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1) {
            return setCaptureOptionUnpacker(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCaptureType(UseCaseConfigFactory.CaptureType r1) {
            return setCaptureType(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCustomOrderedResolutions(List r1) {
            return setCustomOrderedResolutions(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultCaptureConfig(CaptureConfig r1) {
            return setDefaultCaptureConfig(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultResolution(Size r1) {
            return setDefaultResolution(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultSessionConfig(SessionConfig r1) {
            return setDefaultSessionConfig(r1);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDynamicRange(DynamicRange r1) {
            return setDynamicRange(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setHighResolutionDisabled(boolean r1) {
            return setHighResolutionDisabled(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setMaxResolution(Size r1) {
            return setMaxResolution(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setMirrorMode(int r1) {
            return setMirrorMode(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setResolutionSelector(ResolutionSelector r1) {
            return setResolutionSelector(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r1) {
            return setSessionOptionUnpacker(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(List r1) {
            return setSupportedResolutions(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSurfaceOccupancyPriority(int r1) {
            return setSurfaceOccupancyPriority(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetAspectRatio(int r1) {
            return setTargetAspectRatio(r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetClass(Class r1) {
            return setTargetClass(r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetName(String r1) {
            return setTargetName(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetResolution(Size r1) {
            return setTargetResolution(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetRotation(int r1) {
            return setTargetRotation(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setZslDisabled(boolean r1) {
            return setZslDisabled(r1);
        }
    }

    public static final class Defaults implements ConfigProvider<ImageAnalysisConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageAnalysisConfig DEFAULT_CONFIG = null;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
        private static final Size DEFAULT_TARGET_RESOLUTION = null;

        public Defaults() {
        }

        static {
            Size r0 = new Size(640, 480);
            DEFAULT_TARGET_RESOLUTION = r0;
            DynamicRange r1 = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = r1;
            ResolutionSelector r2 = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(new ResolutionStrategy(SizeUtil.RESOLUTION_VGA, 1)).build();
            DEFAULT_RESOLUTION_SELECTOR = r2;
            DEFAULT_CONFIG = new Builder().setDefaultResolution(r0).setSurfaceOccupancyPriority(1).setTargetAspectRatio(0).setResolutionSelector(r2).setDynamicRange(r1).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public ImageAnalysisConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputImageFormat {
    }

    public static /* synthetic */ void a(ImageAnalysis r0, SessionConfig r1, SessionConfig.SessionError r2) {
        r0.lambda$createPipeline$2(r1, r2);
    }

    public static /* synthetic */ void b(SafeCloseImageReaderProxy r0, SafeCloseImageReaderProxy r1) {
        lambda$createPipeline$1(r0, r1);
    }

    public static /* synthetic */ void c(Analyzer r0, ImageProxy r1) {
        lambda$setAnalyzer$3(r0, r1);
    }

    public static /* synthetic */ List d(Size r0, List r1, int r2) {
        return lambda$onMergeConfig$0(r0, r1, r2);
    }

    static {
        DEFAULT_CONFIG = new Defaults();
        DEFAULT_ONE_PIXEL_SHIFT_ENABLED = null;
    }

    public void clearAnalyzer() {
        Object r0 = this.mAnalysisLock;
        monitor-enter(r0);
        this.mImageAnalysisAbstractAnalyzer.setAnalyzer(null, null);     // Catch: Throwable -> L10
        if (this.mSubscribedAnalyzer == null) goto L7;
        notifyInactive();     // Catch: Throwable -> L10
    L7:
        this.mSubscribedAnalyzer = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        this.mImageAnalysisAbstractAnalyzer.attach();
    }

    public String toString() {
        return "ImageAnalysis:" + getName();
    }

    private void tryUpdateRelativeRotation() {
        CameraInternal r0 = getCamera();
        if (r0 == null) goto L6;
        this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(getRelativeRotation(r0));
        return;
    }

    public void clearPipeline() {
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
        this.mCloseableErrorListener = null;
    L5:
        DeferrableSurface r1 = this.mDeferrableSurface;
        if (r1 == null) goto L9;
        r1.close();
        this.mDeferrableSurface = null;
        return;
    }

    public Executor getBackgroundExecutor() {
        ImageAnalysisConfig r0 = (ImageAnalysisConfig) getCurrentConfig();
        r0.getClass();
        return ThreadConfig.CC.$default$getBackgroundExecutor(r0, null);
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getBackpressureStrategy(0);
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getImageQueueDepth(6);
    }

    public Boolean getOnePixelShiftEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOnePixelShiftEnabled(DEFAULT_ONE_PIXEL_SHIFT_ENABLED);
    }

    public int getOutputImageFormat() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOutputImageFormat(1);
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isOutputImageRotationEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).isOutputImageRotationEnabled(Boolean.FALSE).booleanValue();
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.detach();
    }

    public ImageAnalysis(ImageAnalysisConfig r3) {
        super(r3);
        this.mAnalysisLock = new Object();
        if (((ImageAnalysisConfig) getCurrentConfig()).getBackpressureStrategy(0) != 1) goto L5;
        this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisBlockingAnalyzer();
    L6:
        this.mImageAnalysisAbstractAnalyzer.setOutputImageFormat(getOutputImageFormat());
        this.mImageAnalysisAbstractAnalyzer.setOutputImageRotationEnabled(isOutputImageRotationEnabled());
        return;
    L5:
        Executor r1 = CameraXExecutors.highPriorityExecutor();
        r3.getClass();
        this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisNonBlockingAnalyzer(ThreadConfig.CC.$default$getBackgroundExecutor(r3, r1));
        goto L6
    }

    private boolean isFlipWH(CameraInternal r3) {
        if (isOutputImageRotationEnabled() == true) goto L5;
        return false;
    L5:
        if ((getRelativeRotation(r3) % 180) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r1) {
        return Builder.fromConfig(r1);
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r5) {
        this.mSessionConfigBuilder.addImplementationOptions(r5);
        Object[] r2 = {this.mSessionConfigBuilder.build()};
        ArrayList r0 = new ArrayList(1);
        Object r1 = r2[0];
        Objects.requireNonNull(r1);
        r0.add(r1);
        updateSessionConfig(Collections.unmodifiableList(r0));
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(r5).build();
    }

    @Override // androidx.camera.core.UseCase
    public void setSensorToBufferTransformMatrix(Matrix r2) {
        super.setSensorToBufferTransformMatrix(r2);
        this.mImageAnalysisAbstractAnalyzer.setSensorToBufferTransformMatrix(r2);
    }

    public void setTargetRotation(int r1) {
        if (setTargetRotationInternal(r1) == false) goto L6;
        tryUpdateRelativeRotation();
        return;
    }

    @Override // androidx.camera.core.UseCase
    public void setViewPortCropRect(Rect r2) {
        super.setViewPortCropRect(r2);
        this.mImageAnalysisAbstractAnalyzer.setViewPortCropRect(r2);
    }

    private static /* synthetic */ void lambda$createPipeline$1(SafeCloseImageReaderProxy r0, SafeCloseImageReaderProxy r1) {
        r0.safeClose();
        if (r1 == null) goto L6;
        r1.safeClose();
        return;
    }

    private /* synthetic */ void lambda$createPipeline$2(SessionConfig r3, SessionConfig.SessionError r4) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.clearCache();
        SessionConfig.Builder r5 = createPipeline(getCameraId(), (ImageAnalysisConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = r5;
        Object[] r0 = {r5.build()};
        ArrayList r6 = new ArrayList(1);
        Object r7 = r0[0];
        Objects.requireNonNull(r7);
        r6.add(r7);
        updateSessionConfig(Collections.unmodifiableList(r6));
        notifyReset();
    }

    private static /* synthetic */ void lambda$setAnalyzer$3(Analyzer r0, ImageProxy r1) {
        r0.analyze(r1);
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r4, UseCaseConfigFactory r5) {
        Defaults r0 = DEFAULT_CONFIG;
        ImageAnalysisConfig r1 = r0.getConfig();
        r1.getClass();
        Config r6 = r5.getConfig(UseCaseConfig.CC.$default$getCaptureType(r1), 1);
        if (r4 == false) goto L5;
        r6 = Config.CC.mergeConfigs(r6, r0.getConfig());
    L5:
        if (r6 != null) goto L8;
        return null;
    L8:
        return getUseCaseConfigBuilder(r6).getUseCaseConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r6, UseCaseConfig.Builder<?, ?, ?> r7) {
        Boolean r0 = getOnePixelShiftEnabled();
        boolean r1 = r6.getCameraQuirks().contains(OnePixelShiftQuirk.class);
        ImageAnalysisAbstractAnalyzer r2 = this.mImageAnalysisAbstractAnalyzer;
        if (r0 == null) goto L6;
        r1 = r0.booleanValue();
    L6:
        r2.setOnePixelShiftEnabled(r1);
        Object r3 = this.mAnalysisLock;
        monitor-enter(r3);
        Analyzer r4 = this.mSubscribedAnalyzer;     // Catch: Throwable -> L37
        if (r4 == null) goto L11;
        final Size r5 = r4.getDefaultTargetResolution();     // Catch: Throwable -> L37
    L12:
        monitor-exit(r3);     // Catch: Throwable -> L37
        if (r5 != null) goto L17;
        return r7.getUseCaseConfig();
    L17:
        if ((r6.getSensorRotationDegrees(((Integer) r7.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, 0)).intValue()) % 180) != 90) goto L19;
        r5 = new Size(r5.getHeight(), r5.getWidth());
    L19:
        UseCaseConfig r8 = r7.getUseCaseConfig();
        Config.Option<Size> r9 = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
        if (r8.containsOption(r9) == true) goto L22;
        r7.getMutableConfig().insertOption(r9, r5);
    L22:
        UseCaseConfig r10 = r7.getUseCaseConfig();
        Config.Option r11 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r10.containsOption(r11) == false) goto L36;
        ResolutionSelector r12 = (ResolutionSelector) getAppConfig().retrieveOption(r11, null);
        if (r12 != null) goto L27;
        ResolutionSelector.Builder r13 = new ResolutionSelector.Builder();
    L28:
        if (r12 != null) goto L30;
    L31:
        r13.setResolutionStrategy(new ResolutionStrategy(r5, 1));
    L32:
        if (r12 != null) goto L34;
        r13.setResolutionFilter(new k(r5));
    L34:
        r7.getMutableConfig().insertOption(r11, r13.build());
        goto L36
    L30:
        if (r12.getResolutionStrategy() != null) goto L32;
    L27:
        r13 = ResolutionSelector.Builder.fromResolutionSelector(r12);
    L36:
        return r7.getUseCaseConfig();
    L11:
        r5 = null;
    L37:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r4, StreamSpec r5) {
        SessionConfig.Builder r6 = createPipeline(getCameraId(), (ImageAnalysisConfig) getCurrentConfig(), r4);
        this.mSessionConfigBuilder = r6;
        Object[] r1 = {r6.build()};
        ArrayList r7 = new ArrayList(1);
        Object r0 = r1[0];
        Objects.requireNonNull(r0);
        r7.add(r0);
        updateSessionConfig(Collections.unmodifiableList(r7));
        return r4;
    }

    public void setAnalyzer(Executor r4, final Analyzer r5) {
        Object r0 = this.mAnalysisLock;
        monitor-enter(r0);
        this.mImageAnalysisAbstractAnalyzer.setAnalyzer(r4, new l(r5));     // Catch: Throwable -> L10
        if (this.mSubscribedAnalyzer != null) goto L7;
        notifyActive();     // Catch: Throwable -> L10
    L7:
        this.mSubscribedAnalyzer = r5;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ List lambda$onMergeConfig$0(Size r0, List r1, int r2) {
        ArrayList r3 = new ArrayList(r1);
        if (r3.contains(r0) == false) goto L5;
        r3.remove(r0);
        ListProtector.add(r3, 0, r0);
    L5:
        return r3;
    }

    public SessionConfig.Builder createPipeline(String r11, ImageAnalysisConfig r12, StreamSpec r13) {
        Threads.checkMainThread();
        Size r14 = r13.getResolution();
        Executor r0 = CameraXExecutors.highPriorityExecutor();
        r12.getClass();
        Executor r1 = (Executor) Preconditions.checkNotNull(ThreadConfig.CC.$default$getBackgroundExecutor(r12, r0));
        boolean r2 = true;
        if (getBackpressureStrategy() != 1) goto L5;
        int r7 = getImageQueueDepth();
    L7:
        if (r12.getImageReaderProxyProvider() == null) goto L9;
        final SafeCloseImageReaderProxy r3 = new SafeCloseImageReaderProxy(r12.getImageReaderProxyProvider().newInstance(r14.getWidth(), r14.getHeight(), getImageFormat(), r7, 0));
    L11:
        if (getCamera() == null) goto L13;
        boolean r4 = isFlipWH(getCamera());
    L14:
        if (r4 == false) goto L16;
        int r5 = r14.getHeight();
    L17:
        if (r4 == false) goto L19;
        int r6 = r14.getWidth();
    L21:
        if (getOutputImageFormat() != 2) goto L23;
        int r8 = 1;
    L25:
        if (getImageFormat() == 35) goto L27;
    L29:
        boolean r9 = false;
    L31:
        if (getImageFormat() == 35) goto L33;
    L39:
        r2 = false;
    L41:
        if (r9 == true) goto L45;
        if (r2 == true) goto L45;
        final SafeCloseImageReaderProxy r10 = null;
    L46:
        if (r10 == null) goto L48;
        this.mImageAnalysisAbstractAnalyzer.setProcessedImageReaderProxy(r10);
    L48:
        tryUpdateRelativeRotation();
        r3.setOnImageAvailableListener(this.mImageAnalysisAbstractAnalyzer, r1);
        SessionConfig.Builder r15 = SessionConfig.Builder.createFrom(r12, r13.getResolution());
        if (r13.getImplementationOptions() == null) goto L51;
        r15.addImplementationOptions(r13.getImplementationOptions());
    L51:
        DeferrableSurface r16 = this.mDeferrableSurface;
        if (r16 == null) goto L54;
        r16.close();
    L54:
        ImmediateSurface r17 = new ImmediateSurface(r3.getSurface(), r14, getImageFormat());
        this.mDeferrableSurface = r17;
        r17.getTerminationFuture().addListener(new i(r3, r10), CameraXExecutors.mainThreadExecutor());
        r15.setExpectedFrameRateRange(r13.getExpectedFrameRateRange());
        r15.addSurface(this.mDeferrableSurface, r13.getDynamicRange(), null, -1);
        SessionConfig.CloseableErrorListener r18 = this.mCloseableErrorListener;
        if (r18 == null) goto L57;
        r18.close();
    L57:
        SessionConfig.CloseableErrorListener r19 = new SessionConfig.CloseableErrorListener(new j(this));
        this.mCloseableErrorListener = r19;
        r15.setErrorListener(r19);
        return r15;
    L45:
        r10 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r5, r6, r8, r3.getMaxImages()));
        goto L46
    L33:
        if (getCamera() == null) goto L37;
        if (getRelativeRotation(getCamera()) != 0) goto L41;
    L37:
        if (Boolean.TRUE.equals(getOnePixelShiftEnabled()) == false) goto L39;
    L27:
        if (getOutputImageFormat() != 2) goto L29;
        r9 = true;
        goto L31
    L23:
        r8 = 35;
        goto L25
    L19:
        r6 = r14.getHeight();
        goto L21
    L16:
        r5 = r14.getWidth();
        goto L17
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r14.getWidth(), r14.getHeight(), getImageFormat(), r7));
        goto L11
    L5:
        r7 = 4;
        goto L7
    }
}
