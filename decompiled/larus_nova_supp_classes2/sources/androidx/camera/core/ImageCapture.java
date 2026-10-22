package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.ScreenFlashWrapper;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    public static final int CAPTURE_MODE_ZERO_SHUTTER_LAG = 2;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final Defaults DEFAULT_CONFIG = null;
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = null;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    public static final int FLASH_MODE_SCREEN = 3;
    private static final int FLASH_MODE_UNKNOWN = -1;
    public static final int FLASH_TYPE_ONE_SHOT_FLASH = 0;
    public static final int FLASH_TYPE_USE_TORCH_AS_FLASH = 1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    public static final int OUTPUT_FORMAT_JPEG = 0;
    public static final int OUTPUT_FORMAT_JPEG_ULTRA_HDR = 1;
    public static final long SCREEN_FLASH_UI_APPLY_TIMEOUT_SECONDS = 3;
    private static final String TAG = "ImageCapture";
    private final int mCaptureMode;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio;
    private int mFlashMode;
    private final int mFlashType;
    private final ImageCaptureControl mImageCaptureControl;
    private ImagePipeline mImagePipeline;
    private final AtomicReference<Integer> mLockedFlashMode;
    private ScreenFlashWrapper mScreenFlashWrapper;
    SessionConfig.Builder mSessionConfigBuilder;
    private TakePictureManager mTakePictureManager;

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder>, ImageInputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public ImageCapture build() {
            Integer r0 = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (r0 == null) goto L6;
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, r0);
        L9:
            ImageCaptureConfig r1 = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(r1);
            ImageCapture r2 = new ImageCapture(r1);
            Size r3 = (Size) getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null);
            if (r3 == null) goto L12;
            r2.setCropAspectRatio(new Rational(r3.getWidth(), r3.getHeight()));
        L12:
            Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(IoConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
            MutableConfig r4 = getMutableConfig();
            Config.Option<Integer> r5 = ImageCaptureConfig.OPTION_FLASH_MODE;
            if (r4.containsOption(r5) == false) goto L33;
            Integer r6 = (Integer) getMutableConfig().retrieveOption(r5);
            if (r6 == null) goto L32;
            if (r6.intValue() == 0) goto L25;
            if (r6.intValue() == 1) goto L25;
            if (r6.intValue() == 3) goto L25;
            if (r6.intValue() != 2) goto L32;
        L25:
            if (r6.intValue() != 3) goto L33;
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, null) != null) goto L33;
            throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
        L32:
            throw new IllegalArgumentException("The flash mode is not allowed to set: " + r6);
        L33:
            return r2;
        L6:
            if (ImageCapture.access$000(getMutableConfig()) == false) goto L8;
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            goto L9
        L8:
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            goto L9
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
            setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
            setTargetClass(ImageCapture.class);
            return;
        L5:
            if (r5.equals(ImageCapture.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r5);
        }

        public static Builder fromConfig(Config r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        public Builder setBufferFormat(int r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(r3));
            return this;
        }

        public Builder setCaptureMode(int r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(r3));
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

        public Builder setFlashMode(int r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(r3));
            return this;
        }

        public Builder setFlashType(int r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_TYPE, Integer.valueOf(r3));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setHighResolutionDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.IoConfig.Builder
        public Builder setIoExecutor(Executor r3) {
            getMutableConfig().insertOption(IoConfig.OPTION_IO_EXECUTOR, r3);
            return this;
        }

        public Builder setJpegQuality(int r4) {
            Preconditions.checkArgumentInRange(r4, 1, 100, "jpegQuality");
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(r4));
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

        public Builder setOutputFormat(int r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, Integer.valueOf(r3));
            return this;
        }

        public Builder setPostviewEnabled(boolean r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.valueOf(r3));
            return this;
        }

        public Builder setPostviewResolutionSelector(ResolutionSelector r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setResolutionSelector(ResolutionSelector r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r3);
            return this;
        }

        public Builder setScreenFlash(ScreenFlash r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r3);
            return this;
        }

        public Builder setSoftwareJpegEncoderRequested(boolean r3) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.valueOf(r3));
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
        public Builder setTargetClass(Class<ImageCapture> r4) {
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

        public static Builder fromConfig(ImageCaptureConfig r1) {
            return new Builder(MutableOptionsBundle.from(r1));
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

        @Override // androidx.camera.core.internal.IoConfig.Builder
        public /* bridge */ /* synthetic */ Builder setIoExecutor(Executor r1) {
            return setIoExecutor(r1);
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

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageCaptureConfig DEFAULT_CONFIG = null;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        private static final int DEFAULT_OUTPUT_FORMAT = 0;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        public Defaults() {
        }

        static {
            ResolutionSelector r0 = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = r0;
            DynamicRange r1 = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = r1;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).setResolutionSelector(r0).setOutputFormat(0).setDynamicRange(r1).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashType {
    }

    public static class ImageCaptureCapabilitiesImpl implements ImageCaptureCapabilities {
        private final CameraInfo mCameraInfo;

        private boolean isUltraHdrSupported() {
            CameraInfo r0 = this.mCameraInfo;
            if ((r0 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r0).getSupportedOutputFormats().contains(4101);
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public Set<Integer> getSupportedOutputFormats() {
            HashSet r0 = new HashSet();
            r0.add(0);
            if (isUltraHdrSupported() == false) goto L5;
            r0.add(1);
        L5:
            return r0;
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isCaptureProcessProgressSupported() {
            CameraInfo r0 = this.mCameraInfo;
            if ((r0 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r0).isCaptureProcessProgressSupported();
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isPostviewSupported() {
            CameraInfo r0 = this.mCameraInfo;
            if ((r0 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r0).isPostviewSupported();
        }

        public ImageCaptureCapabilitiesImpl(CameraInfo r1) {
            this.mCameraInfo = r1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageCaptureError {
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedHorizontalSet;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.mIsReversedHorizontal + ", mIsReversedVertical=" + this.mIsReversedVertical + ", mLocation=" + this.mLocation + "}";
        }

        public Metadata() {
            this.mIsReversedHorizontalSet = false;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public boolean isReversedHorizontalSet() {
            return this.mIsReversedHorizontalSet;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setLocation(Location r1) {
            this.mLocation = r1;
        }

        public void setReversedHorizontal(boolean r1) {
            this.mIsReversedHorizontal = r1;
            this.mIsReversedHorizontalSet = true;
        }

        public void setReversedVertical(boolean r1) {
            this.mIsReversedVertical = r1;
        }
    }

    public static abstract class OnImageCapturedCallback {
        public OnImageCapturedCallback() {
        }

        public void onCaptureProcessProgressed(int r1) {
        }

        public void onCaptureStarted() {
        }

        public void onCaptureSuccess(ImageProxy r1) {
        }

        public void onError(ImageCaptureException r1) {
        }

        public void onPostviewBitmapAvailable(Bitmap r1) {
        }
    }

    public interface OnImageSavedCallback {

        /* JADX INFO: renamed from: androidx.camera.core.ImageCapture$OnImageSavedCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureProcessProgressed(OnImageSavedCallback r0, int r1) {
            }

            public static void $default$onCaptureStarted(OnImageSavedCallback r0) {
            }

            public static void $default$onPostviewBitmapAvailable(OnImageSavedCallback r0, Bitmap r1) {
            }
        }

        void onCaptureProcessProgressed(int r1);

        void onCaptureStarted();

        void onError(ImageCaptureException r1);

        void onImageSaved(OutputFileResults r1);

        void onPostviewBitmapAvailable(Bitmap r1);
    }

    public static final class OutputFileOptions {
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }

            public Builder(File r1) {
                this.mFile = r1;
            }

            public Builder setMetadata(Metadata r1) {
                this.mMetadata = r1;
                return this;
            }

            public Builder(OutputStream r1) {
                this.mOutputStream = r1;
            }

            public Builder(ContentResolver r1, Uri r2, ContentValues r3) {
                this.mContentResolver = r1;
                this.mSaveCollection = r2;
                this.mContentValues = r3;
            }
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.mFile + ", mContentResolver=" + this.mContentResolver + ", mSaveCollection=" + this.mSaveCollection + ", mContentValues=" + this.mContentValues + ", mOutputStream=" + this.mOutputStream + ", mMetadata=" + this.mMetadata + "}";
        }

        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        public File getFile() {
            return this.mFile;
        }

        public Metadata getMetadata() {
            return this.mMetadata;
        }

        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        public OutputFileOptions(File r1, ContentResolver r2, Uri r3, ContentValues r4, OutputStream r5, Metadata r6) {
            this.mFile = r1;
            this.mContentResolver = r2;
            this.mSaveCollection = r3;
            this.mContentValues = r4;
            this.mOutputStream = r5;
            if (r6 != null) goto L5;
            r6 = new Metadata();
        L5:
            this.mMetadata = r6;
        }
    }

    public static class OutputFileResults {
        private final Uri mSavedUri;

        public Uri getSavedUri() {
            return this.mSavedUri;
        }

        public OutputFileResults(Uri r1) {
            this.mSavedUri = r1;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputFormat {
    }

    public interface ScreenFlash {
        void apply(long r1, ScreenFlashListener r3);

        void clear();
    }

    public interface ScreenFlashListener {
        void onCompleted();
    }

    public static /* synthetic */ Void a(List r0) {
        return lambda$submitStillCaptureRequest$4(r0);
    }

    public static /* synthetic */ void b(ImageCapture r0, SessionConfig r1, SessionConfig.SessionError r2) {
        r0.lambda$createPipeline$3(r1, r2);
    }

    public static /* synthetic */ void c(ImageReaderProxy r0) {
        lambda$new$0(r0);
    }

    private void clearPipeline() {
        clearPipeline(false);
    }

    public static /* synthetic */ void d(ImageCapture r0, Executor r1, OnImageCapturedCallback r2) {
        r0.lambda$takePicture$1(r1, r2);
    }

    public static /* synthetic */ void e(ImageCapture r0, OutputFileOptions r1, Executor r2, OnImageSavedCallback r3) {
        r0.lambda$takePicture$2(r1, r2, r3);
    }

    private static /* synthetic */ Void lambda$submitStillCaptureRequest$4(List r0) {
        return null;
    }

    static {
        DEFAULT_CONFIG = new Defaults();
        EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    }

    private void abortImageCaptureRequests() {
        this.mScreenFlashWrapper.completePendingTasks();
        TakePictureManager r0 = this.mTakePictureManager;
        if (r0 == null) goto L6;
        r0.abortRequests();
        return;
    }

    private void setScreenFlashToCameraControl() {
        setScreenFlashToCameraControl(this.mScreenFlashWrapper);
    }

    private void trySetFlashModeToCameraControl() {
        AtomicReference<Integer> r0 = this.mLockedFlashMode;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockedFlashMode.get() == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        getCameraControl().setFlashMode(getFlashMode());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public int getFlashMode() {
        AtomicReference<Integer> r0 = this.mLockedFlashMode;
        monitor-enter(r0);
        int r1 = this.mFlashMode;     // Catch: Throwable -> L10
        if (r1 != (-1)) goto L8;
        r1 = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public ScreenFlash getScreenFlash() {
        return this.mScreenFlashWrapper.getBaseScreenFlash();
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r0 = new HashSet();
        r0.add(4);
        return r0;
    }

    public TakePictureManager getTakePictureManager() {
        TakePictureManager r0 = this.mTakePictureManager;
        Objects.requireNonNull(r0);
        return r0;
    }

    public boolean isProcessingPipelineEnabled() {
        if (this.mImagePipeline != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mTakePictureManager == null) goto L7;
        return true;
    }

    public void lockFlashMode() {
        AtomicReference<Integer> r0 = this.mLockedFlashMode;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockedFlashMode.get() == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // androidx.camera.core.UseCase
    public void onCameraControlReady() {
        Logger.d(TAG, "onCameraControlReady");
        trySetFlashModeToCameraControl();
        setScreenFlashToCameraControl();
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    public void unlockFlashMode() {
        AtomicReference<Integer> r0 = this.mLockedFlashMode;
        monitor-enter(r0);
        Integer r1 = this.mLockedFlashMode.getAndSet(null);     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        if (r1.intValue() == getFlashMode()) goto L11;
        trySetFlashModeToCameraControl();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private int getCameraLens() {
        CameraInternal r0 = getCamera();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getCameraInfo().getLensFacing();
    }

    private int getJpegQualityInternal() {
        ImageCaptureConfig r0 = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> r1 = ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY;
        r0.getClass();
        if (ReadableConfig.CC.$default$containsOption(r0, r1) == true) goto L5;
        int r2 = this.mCaptureMode;
        if (r2 != 0) goto L9;
        return 100;
    L9:
        if (r2 != 1) goto L11;
        return 95;
    L11:
        if (r2 != 2) goto L14;
        return 95;
    L14:
        throw new IllegalStateException("CaptureMode " + this.mCaptureMode + " is invalid");
    L5:
        return r0.getJpegQuality();
    }

    private SessionProcessor getSessionProcessor() {
        return getCamera().getExtendedConfig().getSessionProcessor(null);
    }

    private Rect getTakePictureCropRect() {
        Rect r0 = getViewPortCropRect();
        Size r1 = getAttachedSurfaceResolution();
        Objects.requireNonNull(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (ImageUtil.isAspectRatioValid(this.mCropAspectRatio) == false) goto L14;
        CameraInternal r2 = getCamera();
        Objects.requireNonNull(r2);
        int r3 = getRelativeRotation(r2);
        Rational r4 = new Rational(this.mCropAspectRatio.getDenominator(), this.mCropAspectRatio.getNumerator());
        if (TransformUtils.is90or270(r3) == true) goto L11;
        r4 = this.mCropAspectRatio;
    L11:
        Rect r5 = ImageUtil.computeCropRectFromAspectRatio(r1, r4);
        Objects.requireNonNull(r5);
        return r5;
    L14:
        return new Rect(0, 0, r1.getWidth(), r1.getHeight());
    }

    private boolean isSessionProcessorEnabledInCurrentCamera() {
        if (getCamera() != null) goto L6;
        return false;
    L6:
        if (getCamera().getExtendedConfig().getSessionProcessor(null) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public int getJpegQuality() {
        return getJpegQualityInternal();
    }

    public int getOutputFormat() {
        return ((Integer) Preconditions.checkNotNull((Integer) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, 0))).intValue();
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
    }

    public ImageCaptureLatencyEstimate getRealtimeCaptureLatencyEstimate() {
        CameraInternal r0 = getCamera();
        if (r0 == null) goto L5;
        Pair<Long, Long> r1 = r0.getExtendedConfig().getSessionProcessor().getRealtimeCaptureLatency();
        if (r1 != null) goto L11;
        return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
    L11:
        return new ImageCaptureLatencyEstimate(((Long) r1.first).longValue(), ((Long) r1.second).longValue());
    L5:
        return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    @Override // androidx.camera.core.UseCase
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal r0 = getCamera();
        Size r1 = getAttachedSurfaceResolution();
        if (r0 == null) goto L13;
        if (r1 == null) goto L15;
        Rect r2 = getViewPortCropRect();
        Rational r3 = this.mCropAspectRatio;
        if (r2 != null) goto L11;
        if (r3 == null) goto L10;
        r2 = ImageUtil.computeCropRectFromAspectRatio(r1, r3);
        goto L11
    L10:
        r2 = new Rect(0, 0, r1.getWidth(), r1.getHeight());
    L11:
        int r4 = getRelativeRotation(r0);
        Objects.requireNonNull(r2);
        return new ResolutionInfo(r1, r2, r4);
    L15:
        return null;
    L13:
        return null;
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
        if (getFlashMode() == 3) goto L5;
        return;
    L5:
        if (getCameraLens() != 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        abortImageCaptureRequests();
        clearPipeline();
        setScreenFlashToCameraControl(null);
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        abortImageCaptureRequests();
    }

    public ImageCapture(ImageCaptureConfig r2) {
        super(r2);
        this.mClosingListener = new q();
        this.mLockedFlashMode = new AtomicReference(null);
        this.mFlashMode = -1;
        this.mCropAspectRatio = null;
        this.mImageCaptureControl = new AnonymousClass1(this);
        ImageCaptureConfig r3 = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> r0 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        r3.getClass();
        if (ReadableConfig.CC.$default$containsOption(r3, r0) == false) goto L5;
        this.mCaptureMode = r3.getCaptureMode();
    L6:
        this.mFlashType = r3.getFlashType(0);
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(r3.getScreenFlash());
        return;
    L5:
        this.mCaptureMode = 1;
        goto L6
    }

    public static /* synthetic */ boolean access$000(MutableConfig r0) {
        return isOutputFormatUltraHdr(r0);
    }

    private void clearPipeline(boolean r3) {
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
        this.mCloseableErrorListener = null;
    L5:
        ImagePipeline r1 = this.mImagePipeline;
        if (r1 == null) goto L8;
        r1.close();
        this.mImagePipeline = null;
    L8:
        if (r3 == true) goto L13;
        TakePictureManager r4 = this.mTakePictureManager;
        if (r4 == null) goto L14;
        r4.abortRequests();
        this.mTakePictureManager = null;
        return;
    L14:
        return;
    }

    public static int getError(Throwable r1) {
        if ((r1 instanceof CameraClosedException) == false) goto L7;
        return 3;
    L7:
        if ((r1 instanceof ImageCaptureException) == true) goto L9;
        return 0;
    L9:
        return ((ImageCaptureException) r1).getImageCaptureError();
    }

    public static ImageCaptureCapabilities getImageCaptureCapabilities(CameraInfo r1) {
        return new ImageCaptureCapabilitiesImpl(r1);
    }

    private static boolean isOutputFormatUltraHdr(MutableConfig r2) {
        return Objects.equals(r2.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 1);
    }

    private static /* synthetic */ void lambda$new$0(ImageReaderProxy r1) {
        ImageProxy r2 = r1.acquireLatestImage();     // Catch: IllegalStateException -> L15
        Objects.toString(r2);     // Catch: Throwable -> L7
        if (r2 == null) goto L14;
        r2.close();     // Catch: IllegalStateException -> L15
        return;
    L14:
        return;
    L7:
        th = move-exception;
        if (r2 != null) goto L16;
    L13:
        throw th;     // Catch: IllegalStateException -> L15
    L16:
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L15
    }

    private void setScreenFlashToCameraControl(ScreenFlash r2) {
        getCameraControl().setScreenFlash(r2);
    }

    public boolean enforceSoftwareJpegConstraints(MutableConfig r8) {
        Boolean r0 = Boolean.TRUE;
        Config.Option<Boolean> r1 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean r2 = Boolean.FALSE;
        boolean r3 = false;
        if (r0.equals(r8.retrieveOption(r1, r2)) == true) goto L5;
    L16:
        return r3;
    L5:
        if (isSessionProcessorEnabledInCurrentCamera() == false) goto L7;
        Logger.w(TAG, "Software JPEG cannot be used with Extensions.");
        boolean r4 = false;
    L8:
        Integer r5 = (Integer) r8.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (r5 != null) goto L11;
    L13:
        r3 = r4;
    L14:
        if (r3 == true) goto L16;
        Logger.w(TAG, "Unable to support software JPEG. Disabling.");
        r8.insertOption(r1, r2);
        goto L16
    L11:
        if (r5.intValue() == 256) goto L13;
        Logger.w(TAG, "Software JPEG cannot be used with non-JPEG output buffer format.");
        goto L14
    L7:
        r4 = true;
        goto L8
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

    public void setCropAspectRatio(Rational r1) {
        this.mCropAspectRatio = r1;
    }

    public void setFlashMode(int r4) {
        Logger.d(TAG, "setFlashMode: flashMode = " + r4);
        if (r4 != 0) goto L5;
    L23:
        AtomicReference<Integer> r0 = this.mLockedFlashMode;
        monitor-enter(r0);
        this.mFlashMode = r4;     // Catch: Throwable -> L28
        trySetFlashModeToCameraControl();     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L22;
        if (this.mScreenFlashWrapper.getBaseScreenFlash() == null) goto L20;
        if (getCamera() == null) goto L23;
        if (getCameraLens() == 0) goto L23;
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L20:
        throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
    L22:
        throw new IllegalArgumentException("Invalid flash mode: " + r4);
    }

    public void setScreenFlash(ScreenFlash r1) {
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(r1);
        setScreenFlashToCameraControl();
    }

    public void setTargetRotation(int r3) {
        int r0 = getTargetRotation();
        if (setTargetRotationInternal(r3) == true) goto L5;
        return;
    L5:
        if (this.mCropAspectRatio == null) goto L9;
        int r1 = CameraOrientationUtil.surfaceRotationToDegrees(r0);
        this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio(Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(r3) - r1), this.mCropAspectRatio);
        return;
    }

    public ListenableFuture<Void> submitStillCaptureRequest(List<CaptureConfig> r4) {
        Threads.checkMainThread();
        return Futures.transform(getCameraControl().submitStillCaptureRequests(r4, this.mCaptureMode, this.mFlashType), new s(), CameraXExecutors.directExecutor());
    }

    private static boolean isImageFormatSupported(List<Pair<Integer, Size[]>> r3, int r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<Pair<Integer, Size[]>> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (((Integer) r5.next().first).equals(Integer.valueOf(r4)) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ void lambda$createPipeline$3(SessionConfig r3, SessionConfig.SessionError r4) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        this.mTakePictureManager.pause();
        clearPipeline(true);
        SessionConfig.Builder r5 = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = r5;
        Object[] r0 = {r5.build()};
        ArrayList r6 = new ArrayList(1);
        Object r7 = r0[0];
        Objects.requireNonNull(r7);
        r6.add(r7);
        updateSessionConfig(Collections.unmodifiableList(r6));
        notifyReset();
        this.mTakePictureManager.resume();
    }

    private /* synthetic */ void lambda$takePicture$1(Executor r1, OnImageCapturedCallback r2) {
        takePicture(r1, r2);
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r4, UseCaseConfigFactory r5) {
        Defaults r0 = DEFAULT_CONFIG;
        ImageCaptureConfig r1 = r0.getConfig();
        r1.getClass();
        Config r6 = r5.getConfig(UseCaseConfig.CC.$default$getCaptureType(r1), getCaptureMode());
        if (r4 == false) goto L5;
        r6 = Config.CC.mergeConfigs(r6, r0.getConfig());
    L5:
        if (r6 != null) goto L8;
        return null;
    L8:
        return getUseCaseConfigBuilder(r6).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r5, UseCaseConfig.Builder<?, ?, ?> r6) {
        if (r5.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class) == false) goto L8;
        Boolean r7 = Boolean.FALSE;
        MutableConfig r0 = r6.getMutableConfig();
        Config.Option<Boolean> r1 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean r2 = Boolean.TRUE;
        if (r7.equals(r0.retrieveOption(r1, r2)) == false) goto L7;
        Logger.w(TAG, "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
        goto L8
    L7:
        Logger.i(TAG, "Requesting software JPEG due to device quirk.");
        r6.getMutableConfig().insertOption(r1, r2);
    L8:
        boolean r8 = enforceSoftwareJpegConstraints(r6.getMutableConfig());
        Integer r3 = (Integer) r6.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        int r4 = 35;
        if (r3 == null) goto L23;
        if (isSessionProcessorEnabledInCurrentCamera() == true) goto L13;
    L16:
        boolean r9 = true;
    L17:
        Preconditions.checkArgument(r9, "Cannot set non-JPEG buffer format with Extensions enabled.");
        MutableConfig r10 = r6.getMutableConfig();
        Config.Option<Integer> r11 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (r8 == true) goto L21;
        r4 = r3.intValue();
    L21:
        r10.insertOption(r11, Integer.valueOf(r4));
    L37:
        return r6.getUseCaseConfig();
    L13:
        if (r3.intValue() == 256) goto L16;
        r9 = false;
        goto L17
    L23:
        if (isOutputFormatUltraHdr(r6.getMutableConfig()) == false) goto L25;
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
        goto L37
    L25:
        if (r8 == false) goto L27;
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        goto L37
    L27:
        List r12 = (List) r6.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
        if (r12 != null) goto L31;
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
        goto L37
    L31:
        if (isImageFormatSupported(r12, 256) == false) goto L34;
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
        goto L37
    L34:
        if (isImageFormatSupported(r12, 35) == false) goto L37;
        r6.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        goto L37
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r4, StreamSpec r5) {
        SessionConfig.Builder r6 = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), r4);
        this.mSessionConfigBuilder = r6;
        Object[] r1 = {r6.build()};
        ArrayList r7 = new ArrayList(1);
        Object r0 = r1[0];
        Objects.requireNonNull(r0);
        r7.add(r0);
        updateSessionConfig(Collections.unmodifiableList(r7));
        notifyActive();
        return r4;
    }

    public void takePicture(final Executor r3, final OnImageCapturedCallback r4) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        CameraXExecutors.mainThreadExecutor().execute(new u(this, r3, r4));
        return;
    L6:
        takePictureInternal(r3, r4, null, null);
    }

    private SessionConfig.Builder createPipeline(String r19, ImageCaptureConfig r20, StreamSpec r21) {
        Threads.checkMainThread();
        String.format("createPipeline(cameraId: %s, streamSpec: %s)", new Object[]{r19, r21});
        Size r8 = r21.getResolution();
        CameraInternal r2 = getCamera();
        Objects.requireNonNull(r2);
        boolean r10 = !r2.getHasTransform();
        if (this.mImagePipeline == null) goto L5;
        Preconditions.checkState(r10);
        this.mImagePipeline.close();
    L5:
        int r5 = 35;
        if (((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue() == false) goto L28;
        SessionProcessor r3 = getSessionProcessor();
        if (r3 == null) goto L28;
        ResolutionSelector r11 = (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
        Map<Integer, List<Size>> r4 = r3.getSupportedPostviewSize(r8);
        List<Size> r7 = r4.get(35);
        if (r7 != null) goto L12;
    L15:
        r5 = 256;
        List<Size> r12 = r4.get(256);
    L16:
        if (r12 != null) goto L18;
    L27:
        int r13 = r5;
        Size r14 = null;
    L29:
        this.mImagePipeline = new ImagePipeline(r20, r8, getEffect(), r10, r14, r13);
        if (this.mTakePictureManager != null) goto L32;
        this.mTakePictureManager = new TakePictureManager(this.mImageCaptureControl);
    L32:
        this.mTakePictureManager.setImagePipeline(this.mImagePipeline);
        SessionConfig.Builder r6 = this.mImagePipeline.createSessionConfigBuilder(r21.getResolution());
        if (Build.VERSION.SDK_INT < 23) goto L40;
        if (getCaptureMode() != 2) goto L40;
        if (r21.getZslDisabled() == true) goto L40;
        getCameraControl().addZslConfig(r6);
    L40:
        if (r21.getImplementationOptions() == null) goto L42;
        r6.addImplementationOptions(r21.getImplementationOptions());
    L42:
        SessionConfig.CloseableErrorListener r1 = this.mCloseableErrorListener;
        if (r1 == null) goto L45;
        r1.close();
    L45:
        SessionConfig.CloseableErrorListener r9 = new SessionConfig.CloseableErrorListener(new t(this));
        this.mCloseableErrorListener = r9;
        r6.setErrorListener(r9);
        return r6;
    L18:
        if (r12.isEmpty() == true) goto L27;
        if (r11 == null) goto L25;
        Collections.sort(r12, new CompareSizesByArea(true));
        CameraInternal r15 = getCamera();
        Rect r16 = r15.getCameraControlInternal().getSensorRect();
        CameraInfoInternal r17 = r15.getCameraInfoInternal();
        List<Size> r18 = SupportedOutputSizesSorter.sortSupportedOutputSizesByResolutionSelector(r11, r12, null, getTargetRotation(), new Rational(r16.width(), r16.height()), r17.getSensorRotationDegrees(), r17.getLensFacing());
        if (r18.isEmpty() == true) goto L24;
        Size r22 = (Size) ListProtector.get(r18, 0);
    L26:
        r14 = r22;
        r13 = r5;
        goto L29
    L24:
        throw new IllegalArgumentException("The postview ResolutionSelector cannot select a valid size for the postview.");
    L25:
        r22 = (Size) Collections.max(r12, new CompareSizesByArea());
        goto L26
    L12:
        if (r7.isEmpty() == true) goto L15;
        r12 = r7;
    L28:
        r14 = null;
        r13 = 35;
        goto L29
    }

    private /* synthetic */ void lambda$takePicture$2(OutputFileOptions r1, Executor r2, OnImageSavedCallback r3) {
        takePicture(r1, r2, r3);
    }

    private void sendInvalidCameraError(Executor r4, OnImageCapturedCallback r5, OnImageSavedCallback r6) {
        ImageCaptureException r7 = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null);
        if (r5 == null) goto L5;
        r5.onError(r7);
        return;
    L5:
        if (r6 == null) goto L9;
        r6.onError(r7);
        return;
    L9:
        throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
    }

    public void takePicture(final OutputFileOptions r3, final Executor r4, final OnImageSavedCallback r5) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        CameraXExecutors.mainThreadExecutor().execute(new r(this, r3, r4, r5));
        return;
    L6:
        takePictureInternal(r4, null, r5, r3);
    }

    private void takePictureInternal(Executor r15, OnImageCapturedCallback r16, OnImageSavedCallback r17, OutputFileOptions r18) {
        Threads.checkMainThread();
        if (getFlashMode() == 3) goto L5;
    L9:
        CameraInternal r1 = getCamera();
        if (r1 != null) goto L13;
        sendInvalidCameraError(r15, r16, r17);
        return;
    L13:
        TakePictureManager r2 = this.mTakePictureManager;
        Objects.requireNonNull(r2);
        r2.offerRequest(TakePictureRequest.of(r15, r16, r17, r18, getTakePictureCropRect(), getSensorToBufferTransformMatrix(), getRelativeRotation(r1), getJpegQualityInternal(), getCaptureMode(), this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks()));
        return;
    L5:
        if (this.mScreenFlashWrapper.getBaseScreenFlash() != null) goto L9;
        throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
    }

    public static Rect computeDispatchCropRect(Rect r0, Rational r1, int r2, Size r3, int r4) {
        if (r0 != null) goto L4;
        if (r1 == null) goto L14;
        if ((r4 % 180) == 0) goto L10;
        r1 = new Rational(r1.getDenominator(), r1.getNumerator());
    L10:
        if (ImageUtil.isAspectRatioValid(r3, r1) == false) goto L14;
        Rect r5 = ImageUtil.computeCropRectFromAspectRatio(r3, r1);
        Objects.requireNonNull(r5);
        return r5;
    L14:
        return new Rect(0, 0, r3.getWidth(), r3.getHeight());
    L4:
        return ImageUtil.computeCropRectFromDispatchInfo(r0, r2, r3, r4);
    }
}
