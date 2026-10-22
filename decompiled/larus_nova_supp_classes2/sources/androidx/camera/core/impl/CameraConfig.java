package androidx.camera.core.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraConfig extends ReadableConfig {
    public static final Config.Option<Boolean> OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED = null;
    public static final Config.Option<Identifier> OPTION_COMPATIBILITY_ID = null;
    public static final Config.Option<Boolean> OPTION_POSTVIEW_SUPPORTED = null;
    public static final Config.Option<SessionProcessor> OPTION_SESSION_PROCESSOR = null;
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = null;
    public static final Config.Option<Integer> OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = null;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = null;
    public static final int REQUIRED_RULE_COEXISTING_PREVIEW_AND_IMAGE_CAPTURE = 1;
    public static final int REQUIRED_RULE_NONE = 0;

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static SessionProcessor $default$getSessionProcessor(CameraConfig r1) {
            return (SessionProcessor) r1.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR);
        }

        public static int $default$getUseCaseCombinationRequiredRule(CameraConfig r2) {
            return ((Integer) r2.retrieveOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue();
        }

        public static UseCaseConfigFactory $default$getUseCaseConfigFactory(CameraConfig r2) {
            return (UseCaseConfigFactory) r2.retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
        }

        public static boolean $default$isCaptureProcessProgressSupported(CameraConfig r2) {
            return ((Boolean) r2.retrieveOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, Boolean.FALSE)).booleanValue();
        }

        public static boolean $default$isPostviewSupported(CameraConfig r2) {
            return ((Boolean) r2.retrieveOption(CameraConfig.OPTION_POSTVIEW_SUPPORTED, Boolean.FALSE)).booleanValue();
        }

        public static SessionProcessor $default$getSessionProcessor(CameraConfig r1, SessionProcessor r2) {
            return (SessionProcessor) r1.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR, r2);
        }
    }

    public interface Builder<B> {
        B setCaptureProcessProgressSupported(boolean r1);

        B setCompatibilityId(Identifier r1);

        B setPostviewSupported(boolean r1);

        B setSessionProcessor(SessionProcessor r1);

        B setUseCaseCombinationRequiredRule(int r1);

        B setUseCaseConfigFactory(UseCaseConfigFactory r1);

        B setZslDisabled(boolean r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequiredRule {
    }

    Identifier getCompatibilityId();

    SessionProcessor getSessionProcessor();

    SessionProcessor getSessionProcessor(SessionProcessor r1);

    int getUseCaseCombinationRequiredRule();

    UseCaseConfigFactory getUseCaseConfigFactory();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();

    static {
        OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
        OPTION_COMPATIBILITY_ID = Config.Option.create("camerax.core.camera.compatibilityId", Identifier.class);
        OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = Config.Option.create("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
        OPTION_SESSION_PROCESSOR = Config.Option.create("camerax.core.camera.SessionProcessor", SessionProcessor.class);
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.camera.isZslDisabled", Boolean.class);
        OPTION_POSTVIEW_SUPPORTED = Config.Option.create("camerax.core.camera.isPostviewSupported", Boolean.class);
        OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED = Config.Option.create("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class);
    }
}
