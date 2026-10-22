package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.TargetConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, ImageInputConfig {
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER = null;
    public static final Config.Option<UseCaseConfigFactory.CaptureType> OPTION_CAPTURE_TYPE = null;
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG = null;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG = null;
    public static final Config.Option<Boolean> OPTION_HIGH_RESOLUTION_DISABLED = null;
    public static final Config.Option<Integer> OPTION_PREVIEW_STABILIZATION_MODE = null;
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER = null;
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY = null;
    public static final Config.Option<Range<Integer>> OPTION_TARGET_FRAME_RATE = null;
    public static final Config.Option<Integer> OPTION_VIDEO_STABILIZATION_MODE = null;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.UseCaseConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T extends UseCase> {
        public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig r1) {
            return (CaptureConfig.OptionUnpacker) r1.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
        }

        public static UseCaseConfigFactory.CaptureType $default$getCaptureType(UseCaseConfig r1) {
            return (UseCaseConfigFactory.CaptureType) r1.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
        }

        public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig r1) {
            return (CaptureConfig) r1.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
        }

        public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig r1) {
            return (SessionConfig) r1.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
        }

        public static int $default$getPreviewStabilizationMode(UseCaseConfig r2) {
            return ((Integer) r2.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
        }

        public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig r1) {
            return (SessionConfig.OptionUnpacker) r1.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
        }

        public static int $default$getSurfaceOccupancyPriority(UseCaseConfig r1) {
            return ((Integer) r1.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
        }

        public static Range $default$getTargetFrameRate(UseCaseConfig r1) {
            return (Range) r1.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
        }

        public static int $default$getVideoStabilizationMode(UseCaseConfig r2) {
            return ((Integer) r2.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
        }

        public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig r1, CaptureConfig.OptionUnpacker r2) {
            return (CaptureConfig.OptionUnpacker) r1.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, r2);
        }

        public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig r1, CaptureConfig r2) {
            return (CaptureConfig) r1.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r2);
        }

        public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig r1, SessionConfig r2) {
            return (SessionConfig) r1.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r2);
        }

        public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig r1, SessionConfig.OptionUnpacker r2) {
            return (SessionConfig.OptionUnpacker) r1.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r2);
        }

        public static int $default$getSurfaceOccupancyPriority(UseCaseConfig r1, int r2) {
            return ((Integer) r1.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(r2))).intValue();
        }

        public static Range $default$getTargetFrameRate(UseCaseConfig r1, Range r2) {
            return (Range) r1.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, r2);
        }

        public static boolean $default$isHighResolutionDisabled(UseCaseConfig r1, boolean r2) {
            return ((Boolean) r1.retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r2))).booleanValue();
        }

        public static boolean $default$isZslDisabled(UseCaseConfig r1, boolean r2) {
            return ((Boolean) r1.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r2))).booleanValue();
        }
    }

    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends TargetConfig.Builder<T, B>, ExtendableBuilder<T> {
        C getUseCaseConfig();

        B setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1);

        B setCaptureType(UseCaseConfigFactory.CaptureType r1);

        B setDefaultCaptureConfig(CaptureConfig r1);

        B setDefaultSessionConfig(SessionConfig r1);

        B setHighResolutionDisabled(boolean r1);

        B setSessionOptionUnpacker(SessionConfig.OptionUnpacker r1);

        B setSurfaceOccupancyPriority(int r1);

        B setZslDisabled(boolean r1);
    }

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker();

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1);

    UseCaseConfigFactory.CaptureType getCaptureType();

    CaptureConfig getDefaultCaptureConfig();

    CaptureConfig getDefaultCaptureConfig(CaptureConfig r1);

    SessionConfig getDefaultSessionConfig();

    SessionConfig getDefaultSessionConfig(SessionConfig r1);

    int getPreviewStabilizationMode();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker r1);

    int getSurfaceOccupancyPriority();

    int getSurfaceOccupancyPriority(int r1);

    Range<Integer> getTargetFrameRate();

    Range<Integer> getTargetFrameRate(Range<Integer> r1);

    int getVideoStabilizationMode();

    boolean isHighResolutionDisabled(boolean r1);

    boolean isZslDisabled(boolean r1);

    static {
        OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
        OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
        OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
        OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);
        Class r0 = Integer.TYPE;
        OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create("camerax.core.useCase.surfaceOccupancyPriority", r0);
        OPTION_TARGET_FRAME_RATE = Config.Option.create("camerax.core.useCase.targetFrameRate", Range.class);
        Class r1 = Boolean.TYPE;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.useCase.zslDisabled", r1);
        OPTION_HIGH_RESOLUTION_DISABLED = Config.Option.create("camerax.core.useCase.highResolutionDisabled", r1);
        OPTION_CAPTURE_TYPE = Config.Option.create("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
        OPTION_PREVIEW_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.previewStabilizationMode", r0);
        OPTION_VIDEO_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.videoStabilizationMode", r0);
    }
}
