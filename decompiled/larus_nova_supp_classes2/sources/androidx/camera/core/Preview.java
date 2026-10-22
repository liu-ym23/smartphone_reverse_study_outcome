package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.capability.PreviewCapabilitiesImpl;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Preview extends UseCase {
    public static final Defaults DEFAULT_CONFIG = null;
    private static final Executor DEFAULT_SURFACE_PROVIDER_EXECUTOR = null;
    private static final String TAG = "Preview";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    SurfaceRequest mCurrentSurfaceRequest;
    private SurfaceProcessorNode mNode;
    SessionConfig.Builder mSessionConfigBuilder;
    private DeferrableSurface mSessionDeferrableSurface;
    private SurfaceProvider mSurfaceProvider;
    private Executor mSurfaceProviderExecutor;

    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder>, ImageOutputConfig.Builder<Builder>, ImageInputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public PreviewConfig getUseCaseConfig() {
            return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public Preview build() {
            PreviewConfig r0 = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(r0);
            return new Preview(r0);
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
            Class r0 = (Class) r4.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r0 != null) goto L5;
        L9:
            setCaptureType(UseCaseConfigFactory.CaptureType.PREVIEW);
            setTargetClass(Preview.class);
            Config.Option<Integer> r1 = ImageOutputConfig.OPTION_MIRROR_MODE;
            if (((Integer) r4.retrieveOption(r1, -1)).intValue() != (-1)) goto L13;
            r4.insertOption(r1, 2);
            return;
        L13:
            return;
        L5:
            if (r0.equals(Preview.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r0);
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
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setHighResolutionDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r3));
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
        public Builder setMirrorMode(int r3) {
            if (Build.VERSION.SDK_INT < 33) goto L5;
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(r3));
        L5:
            return this;
        }

        public Builder setPreviewStabilizationEnabled(boolean r3) {
            MutableConfig r0 = getMutableConfig();
            Config.Option<Integer> r1 = UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE;
            if (r3 == false) goto L5;
            int r4 = 2;
        L6:
            r0.insertOption(r1, Integer.valueOf(r4));
            return this;
        L5:
            r4 = 1;
            goto L6
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
        public Builder setTargetClass(Class<Preview> r4) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r4);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r4.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        public Builder setTargetFrameRate(Range<Integer> r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, r3);
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
        public Builder setTargetRotation(int r4) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r4));
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(r4));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setZslDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        public static Builder fromConfig(PreviewConfig r1) {
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

    public static final class Defaults implements ConfigProvider<PreviewConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final PreviewConfig DEFAULT_CONFIG = null;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        private static final int DEFAULT_MIRROR_MODE = 2;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

        public Defaults() {
        }

        static {
            ResolutionSelector r0 = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = r0;
            DynamicRange r1 = DynamicRange.UNSPECIFIED;
            DEFAULT_DYNAMIC_RANGE = r1;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(2).setTargetAspectRatio(0).setResolutionSelector(r0).setDynamicRange(r1).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        public static /* synthetic */ DynamicRange access$000() {
            return DEFAULT_DYNAMIC_RANGE;
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public PreviewConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public interface SurfaceProvider {
        void onSurfaceRequested(SurfaceRequest r1);
    }

    public static /* synthetic */ void a(Preview r0, CameraInternal r1) {
        r0.lambda$createPipeline$0(r1);
    }

    public static /* synthetic */ void b(Preview r0, SessionConfig r1, SessionConfig.SessionError r2) {
        r0.lambda$addCameraSurfaceAndErrorListener$1(r1, r2);
    }

    public static /* synthetic */ void c(SurfaceProvider r0, SurfaceRequest r1) {
        lambda$sendSurfaceRequest$2(r0, r1);
    }

    static {
        DEFAULT_CONFIG = new Defaults();
        DEFAULT_SURFACE_PROVIDER_EXECUTOR = CameraXExecutors.mainThreadExecutor();
    }

    private void clearPipeline() {
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
        this.mCloseableErrorListener = null;
    L5:
        DeferrableSurface r1 = this.mSessionDeferrableSurface;
        if (r1 == null) goto L8;
        r1.close();
        this.mSessionDeferrableSurface = null;
    L8:
        SurfaceProcessorNode r2 = this.mNode;
        if (r2 == null) goto L11;
        r2.release();
        this.mNode = null;
    L11:
        SurfaceEdge r3 = this.mCameraEdge;
        if (r3 == null) goto L14;
        r3.close();
        this.mCameraEdge = null;
    L14:
        this.mCurrentSurfaceRequest = null;
    }

    public SurfaceEdge getCameraEdge() {
        SurfaceEdge r0 = this.mCameraEdge;
        Objects.requireNonNull(r0);
        return r0;
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r0 = new HashSet();
        r0.add(1);
        return r0;
    }

    public String toString() {
        return "Preview:" + getName();
    }

    private void sendSurfaceRequest() {
        sendTransformationInfoIfReady();
        final SurfaceProvider r0 = (SurfaceProvider) Preconditions.checkNotNull(this.mSurfaceProvider);
        final SurfaceRequest r1 = (SurfaceRequest) Preconditions.checkNotNull(this.mCurrentSurfaceRequest);
        this.mSurfaceProviderExecutor.execute(new z(r0, r1));
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal r0 = getCamera();
        SurfaceEdge r1 = this.mCameraEdge;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r1.updateTransformation(getRelativeRotation(r0, isMirroringRequired(r0)), getAppTargetRotation());
        return;
    L8:
        return;
    }

    public DynamicRange getDynamicRange() {
        if (getCurrentConfig().hasDynamicRange() == false) goto L6;
        return getCurrentConfig().getDynamicRange();
    L6:
        return Defaults.access$000();
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isPreviewStabilizationEnabled() {
        if (getCurrentConfig().getPreviewStabilizationMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        clearPipeline();
    }

    public Preview(PreviewConfig r1) {
        super(r1);
        this.mSurfaceProviderExecutor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
    }

    private Rect getCropRect(Size r4) {
        if (getViewPortCropRect() != null) goto L5;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new Rect(0, 0, r4.getWidth(), r4.getHeight());
    L5:
        return getViewPortCropRect();
    }

    public static PreviewCapabilities getPreviewCapabilities(CameraInfo r0) {
        return PreviewCapabilitiesImpl.from(r0);
    }

    private /* synthetic */ void lambda$createPipeline$0(CameraInternal r2) {
        onAppEdgeInvalidated(this.mCameraEdge, r2);
    }

    private boolean shouldMirror(CameraInternal r2) {
        if (r2.getHasTransform() == true) goto L5;
    L7:
        return false;
    L5:
        if (isMirroringRequired(r2) == false) goto L7;
        return true;
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

    public void setSurfaceProvider(SurfaceProvider r2) {
        setSurfaceProvider(DEFAULT_SURFACE_PROVIDER_EXECUTOR, r2);
    }

    public void setTargetRotation(int r1) {
        if (setTargetRotationInternal(r1) == false) goto L6;
        sendTransformationInfoIfReady();
        return;
    }

    @Override // androidx.camera.core.UseCase
    public void setViewPortCropRect(Rect r1) {
        super.setViewPortCropRect(r1);
        sendTransformationInfoIfReady();
    }

    private void addCameraSurfaceAndErrorListener(SessionConfig.Builder r4, StreamSpec r5) {
        if (this.mSurfaceProvider == null) goto L5;
        r4.addSurface(this.mSessionDeferrableSurface, r5.getDynamicRange(), getPhysicalCameraId(), getMirrorModeInternal());
    L5:
        SessionConfig.CloseableErrorListener r6 = this.mCloseableErrorListener;
        if (r6 == null) goto L8;
        r6.close();
    L8:
        SessionConfig.CloseableErrorListener r7 = new SessionConfig.CloseableErrorListener(new c0(this));
        this.mCloseableErrorListener = r7;
        r4.setErrorListener(r7);
    }

    private SessionConfig.Builder createPipeline(PreviewConfig r13, StreamSpec r14) {
        Threads.checkMainThread();
        CameraInternal r0 = getCamera();
        Objects.requireNonNull(r0);
        final CameraInternal r1 = r0;
        clearPipeline();
        if (this.mCameraEdge != null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2);
        Matrix r6 = getSensorToBufferTransformMatrix();
        boolean r7 = r1.getHasTransform();
        Rect r8 = getCropRect(r14.getResolution());
        Objects.requireNonNull(r8);
        this.mCameraEdge = new SurfaceEdge(1, 34, r14, r6, r7, r8, getRelativeRotation(r1, isMirroringRequired(r1)), getAppTargetRotation(), shouldMirror(r1));
        CameraEffect r3 = getEffect();
        if (r3 == null) goto L9;
        this.mNode = new SurfaceProcessorNode(r1, r3.createSurfaceProcessorInternal());
        this.mCameraEdge.addOnInvalidatedListener(new a0(this));
        OutConfig r4 = OutConfig.of(this.mCameraEdge);
        SurfaceProcessorNode.In r5 = SurfaceProcessorNode.In.of(this.mCameraEdge, Collections.singletonList(r4));
        SurfaceEdge r9 = this.mNode.transform2(r5).get(r4);
        Objects.requireNonNull(r9);
        r9.addOnInvalidatedListener(new b0(this, r1));
        this.mCurrentSurfaceRequest = r9.createSurfaceRequest(r1);
        this.mSessionDeferrableSurface = this.mCameraEdge.getDeferrableSurface();
    L11:
        if (this.mSurfaceProvider == null) goto L13;
        sendSurfaceRequest();
    L13:
        SessionConfig.Builder r10 = SessionConfig.Builder.createFrom(r13, r14.getResolution());
        r10.setExpectedFrameRateRange(r14.getExpectedFrameRateRange());
        r13.getClass();
        r10.setPreviewStabilization(UseCaseConfig.CC.$default$getPreviewStabilizationMode(r13));
        if (r14.getImplementationOptions() == null) goto L16;
        r10.addImplementationOptions(r14.getImplementationOptions());
    L16:
        addCameraSurfaceAndErrorListener(r10, r14);
        return r10;
    L9:
        this.mCameraEdge.addOnInvalidatedListener(new a0(this));
        SurfaceRequest r11 = this.mCameraEdge.createSurfaceRequest(r1);
        this.mCurrentSurfaceRequest = r11;
        this.mSessionDeferrableSurface = r11.getDeferrableSurface();
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$addCameraSurfaceAndErrorListener$1(SessionConfig r1, SessionConfig.SessionError r2) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), getAttachedStreamSpec());
        notifyReset();
    }

    private static /* synthetic */ void lambda$sendSurfaceRequest$2(SurfaceProvider r0, SurfaceRequest r1) {
        r0.onSurfaceRequested(r1);
    }

    private void onAppEdgeInvalidated(SurfaceEdge r2, CameraInternal r3) {
        Threads.checkMainThread();
        if (r3 != getCamera()) goto L6;
        r2.invalidate();
        return;
    }

    private void updateConfigAndOutput(PreviewConfig r3, StreamSpec r4) {
        SessionConfig.Builder r5 = createPipeline(r3, r4);
        this.mSessionConfigBuilder = r5;
        Object[] r0 = {r5.build()};
        ArrayList r6 = new ArrayList(1);
        Object r7 = r0[0];
        Objects.requireNonNull(r7);
        r6.add(r7);
        updateSessionConfig(Collections.unmodifiableList(r6));
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r4, UseCaseConfigFactory r5) {
        Defaults r0 = DEFAULT_CONFIG;
        PreviewConfig r1 = r0.getConfig();
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

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r3, UseCaseConfig.Builder<?, ?, ?> r4) {
        r4.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        return r4.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r1, StreamSpec r2) {
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), r1);
        return r1;
    }

    public void setSurfaceProvider(Executor r1, SurfaceProvider r2) {
        Threads.checkMainThread();
        if (r2 != null) goto L5;
        this.mSurfaceProvider = null;
        notifyInactive();
        return;
    L5:
        this.mSurfaceProvider = r2;
        this.mSurfaceProviderExecutor = r1;
        if (getAttachedSurfaceResolution() == null) goto L8;
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), getAttachedStreamSpec());
        notifyReset();
    L8:
        notifyActive();
    }
}
