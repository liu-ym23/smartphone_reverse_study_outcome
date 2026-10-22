package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT = null;
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE = null;
    public static final Config.Option<Integer> OPTION_FLASH_MODE = null;
    public static final Config.Option<Integer> OPTION_FLASH_TYPE = null;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE = null;
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = null;
    public static final Config.Option<Integer> OPTION_JPEG_COMPRESSION_QUALITY = null;
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES = null;
    public static final Config.Option<Integer> OPTION_OUTPUT_FORMAT = null;
    public static final Config.Option<Boolean> OPTION_POSTVIEW_ENABLED = null;
    public static final Config.Option<ResolutionSelector> OPTION_POSTVIEW_RESOLUTION_SELECTOR = null;
    public static final Config.Option<ImageCapture.ScreenFlash> OPTION_SCREEN_FLASH = null;
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER = null;
    private final OptionsBundle mConfig;

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option r1) {
        return ReadableConfig.CC.$default$containsOption(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String r1, Config.OptionMatcher r2) {
        ReadableConfig.CC.$default$findOptions(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getAppTargetRotation(int r1) {
        return ImageOutputConfig.CC.$default$getAppTargetRotation(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1) {
        return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return UseCaseConfig.CC.$default$getCaptureType(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getCustomOrderedResolutions() {
        return ImageOutputConfig.CC.$default$getCustomOrderedResolutions(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getCustomOrderedResolutions(List r1) {
        return ImageOutputConfig.CC.$default$getCustomOrderedResolutions(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig r1) {
        return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getDefaultResolution() {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getDefaultResolution(Size r1) {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig r1) {
        return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ DynamicRange getDynamicRange() {
        return ImageInputConfig.CC.$default$getDynamicRange(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getMaxResolution() {
        return ImageOutputConfig.CC.$default$getMaxResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getMaxResolution(Size r1) {
        return ImageOutputConfig.CC.$default$getMaxResolution(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getMirrorMode(int r1) {
        return ImageOutputConfig.CC.$default$getMirrorMode(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option r1) {
        return ReadableConfig.CC.$default$getOptionPriority(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getPreviewStabilizationMode() {
        return UseCaseConfig.CC.$default$getPreviewStabilizationMode(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option r1) {
        return ReadableConfig.CC.$default$getPriorities(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ ResolutionSelector getResolutionSelector() {
        return ImageOutputConfig.CC.$default$getResolutionSelector(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ ResolutionSelector getResolutionSelector(ResolutionSelector r1) {
        return ImageOutputConfig.CC.$default$getResolutionSelector(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker r1) {
        return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getSupportedResolutions() {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getSupportedResolutions(List r1) {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSurfaceOccupancyPriority() {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSurfaceOccupancyPriority(int r1) {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$getTargetAspectRatio(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class getTargetClass() {
        return TargetConfig.CC.$default$getTargetClass(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class getTargetClass(Class r1) {
        return TargetConfig.CC.$default$getTargetClass(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ Range getTargetFrameRate() {
        return UseCaseConfig.CC.$default$getTargetFrameRate(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ Range getTargetFrameRate(Range r1) {
        return UseCaseConfig.CC.$default$getTargetFrameRate(this, r1);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return TargetConfig.CC.$default$getTargetName(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String r1) {
        return TargetConfig.CC.$default$getTargetName(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getTargetResolution() {
        return ImageOutputConfig.CC.$default$getTargetResolution(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getTargetResolution(Size r1) {
        return ImageOutputConfig.CC.$default$getTargetResolution(this, r1);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetRotation() {
        return ImageOutputConfig.CC.$default$getTargetRotation(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetRotation(int r1) {
        return ImageOutputConfig.CC.$default$getTargetRotation(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getVideoStabilizationMode() {
        return UseCaseConfig.CC.$default$getVideoStabilizationMode(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ boolean hasDynamicRange() {
        return ImageInputConfig.CC.$default$hasDynamicRange(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ boolean hasTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$hasTargetAspectRatio(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isHighResolutionDisabled(boolean r1) {
        return UseCaseConfig.CC.$default$isHighResolutionDisabled(this, r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isZslDisabled(boolean r1) {
        return UseCaseConfig.CC.$default$isZslDisabled(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return ReadableConfig.CC.$default$listOptions(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r1) {
        return ReadableConfig.CC.$default$retrieveOption(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r1, Object r2) {
        return ReadableConfig.CC.$default$retrieveOption(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option r1, Config.OptionPriority r2) {
        return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, r1, r2);
    }

    static {
        Class r0 = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", r0);
        OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", r0);
        OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", Integer.class);
        OPTION_OUTPUT_FORMAT = Config.Option.create("camerax.core.imageCapture.outputFormat", Integer.class);
        OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        OPTION_FLASH_TYPE = Config.Option.create("camerax.core.imageCapture.flashType", r0);
        OPTION_JPEG_COMPRESSION_QUALITY = Config.Option.create("camerax.core.imageCapture.jpegCompressionQuality", r0);
        OPTION_SCREEN_FLASH = Config.Option.create("camerax.core.imageCapture.screenFlash", ImageCapture.ScreenFlash.class);
        OPTION_POSTVIEW_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.useCase.postviewResolutionSelector", ResolutionSelector.class);
        OPTION_POSTVIEW_ENABLED = Config.Option.create("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    }

    public Integer getBufferFormat() {
        return (Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_BUFFER_FORMAT);
    }

    public CaptureBundle getCaptureBundle() {
        return (CaptureBundle) ReadableConfig.CC.$default$retrieveOption(this, OPTION_CAPTURE_BUNDLE);
    }

    public int getCaptureMode() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_IMAGE_CAPTURE_MODE)).intValue();
    }

    public int getFlashMode() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_FLASH_MODE)).intValue();
    }

    public int getFlashType() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_FLASH_TYPE)).intValue();
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) ReadableConfig.CC.$default$retrieveOption(this, OPTION_IMAGE_READER_PROXY_PROVIDER, null);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    @Override // androidx.camera.core.internal.IoConfig
    public Executor getIoExecutor() {
        return (Executor) ReadableConfig.CC.$default$retrieveOption(this, IoConfig.OPTION_IO_EXECUTOR);
    }

    public int getJpegQuality() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_JPEG_COMPRESSION_QUALITY)).intValue();
    }

    public int getMaxCaptureStages() {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_MAX_CAPTURE_STAGES)).intValue();
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) ReadableConfig.CC.$default$retrieveOption(this, OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return (ImageCapture.ScreenFlash) ReadableConfig.CC.$default$retrieveOption(this, OPTION_SCREEN_FLASH, null);
    }

    public boolean hasCaptureMode() {
        return ReadableConfig.CC.$default$containsOption(this, OPTION_IMAGE_CAPTURE_MODE);
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) ReadableConfig.CC.$default$retrieveOption(this, OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue();
    }

    public boolean isSoftwareJpegEncoderRequested() {
        return ((Boolean) ReadableConfig.CC.$default$retrieveOption(this, OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public ImageCaptureConfig(OptionsBundle r1) {
        this.mConfig = r1;
    }

    public Integer getBufferFormat(Integer r2) {
        return (Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_BUFFER_FORMAT, r2);
    }

    public CaptureBundle getCaptureBundle(CaptureBundle r2) {
        return (CaptureBundle) ReadableConfig.CC.$default$retrieveOption(this, OPTION_CAPTURE_BUNDLE, r2);
    }

    public int getFlashMode(int r2) {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_FLASH_MODE, Integer.valueOf(r2))).intValue();
    }

    public int getFlashType(int r2) {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_FLASH_TYPE, Integer.valueOf(r2))).intValue();
    }

    @Override // androidx.camera.core.internal.IoConfig
    public Executor getIoExecutor(Executor r2) {
        return (Executor) ReadableConfig.CC.$default$retrieveOption(this, IoConfig.OPTION_IO_EXECUTOR, r2);
    }

    public int getJpegQuality(int r2) {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(r2))).intValue();
    }

    public int getMaxCaptureStages(int r2) {
        return ((Integer) ReadableConfig.CC.$default$retrieveOption(this, OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(r2))).intValue();
    }
}
