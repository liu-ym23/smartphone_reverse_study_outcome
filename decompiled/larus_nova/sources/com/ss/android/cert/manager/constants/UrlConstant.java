package com.ss.android.cert.manager.constants;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public class UrlConstant {
    private static String DEBUG_H5URL = null;
    private static final String FACE_COMPARE_AUTHENTICATION_PATH = "/user_info/authentication/v1/face_compare";
    private static final String FACE_COMPARE_PATH_NEW = "/ucenter_auth/face_compare";
    private static final String FACE_COMPARE_RESULT_PATH = "/ucenter_auth/auth_face_compare";
    private static final String FACE_COMPARE_VERIFICATION_PATH = "/user_info/verification/v1/face_compare";
    private static final String FACE_INIT_PATH = "/ucenter_auth/face_init";
    private static String GECKO_HOST = null;
    private static final String GET_AUTH_DECISION = "/ucenter_auth/get_auth_decision";
    private static final String GET_VIDEO_SHOOT_CONFIG_PATH = "/ucenter_auth/get_video_shoot_config";
    private static final String GREY_STRATEGY_PATH = "/ucenter_auth/get_grayscale_strategy";
    private static String HOST = "i.snssdk.com";
    private static final String LIVE_DETECT_PATH = "/user_info/common/v1/live_detect";
    private static final String LIVE_DETECT_PATH_NEW = "/ucenter_auth/live_detect";
    private static final String MANUAL_CHECK_PATH = "/user_info/verification/v1/manual_check";
    private static final String MANUAL_CHECK_PATH_NEW = "/ucenter_auth/manual_check";
    private static final String OCR_PATH = "/user_info/common/v1/ocr";
    private static final String OCR_PATH_MANUAL = "/ucenter_auth/ocr";
    private static final String OCR_PATH_V2 = "/user_info/common/v2/ocr";
    private static final String OCR_PATH_V2_NEW = "/ucenter_auth/ocr";
    private static final String PRE_MANUAL_CHECK = "/user_info/common/v1/pre_manual_check";
    private static final String QUERY_PATH = "/ucenter_auth/query";
    private static final String REFERENCE_IMAGE = "/user_info/verification/v1/reference_image";
    private static final String SAVE_CERT_VIDEO_TO_UCENTER_PATH = "/ucenter_auth/save_cert_video";
    private static String SCHEME = "https://";
    private static final String SDK_INIT_PATH = "/user_info/common/v1/sdk_init";
    private static final String SDK_INIT_PATH_NEW = "/ucenter_auth/sdk_init";
    private static final String UPLOAD_ERROR_FACE_LOG = "/user_info/common/v1/live_detect/upload";
    private static final String UPLOAD_ERROR_FACE_LOG_PATH_NEW = "/ucenter_auth/live_detect/upload";
    private static final String UPLOAD_SHOOT_VIDEO_PATH = "/ucenter_auth/upload_shoot_video";
    private static final String UPLOAD_VIDEO_PATH = "/user_info/common/v1/video_live_detect/validate";
    private static final String UPLOAD_VIDEO_TO_SENSITIVE_PATH = "/user_info/resource/upload";
    public static final String VALIDATE_FACE_COMPARE = "/user_info/common/v1/validate_face_compare";
    private static final String VIDEO_LIVE_DETECT_PATH = "/user_info/common/v1/video_live_detect";
    private static String env;
    private static EnvType envType;

    /* JADX INFO: renamed from: com.ss.android.cert.manager.constants.UrlConstant$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$cert$manager$constants$UrlConstant$EnvType = null;

        static {
            int[] r100 = new int[EnvType.values().length];
            $SwitchMap$com$ss$android$cert$manager$constants$UrlConstant$EnvType = r100;
            r100[EnvType.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$android$cert$manager$constants$UrlConstant$EnvType[EnvType.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$cert$manager$constants$UrlConstant$EnvType[EnvType.PRODUCT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum EnvType extends Enum<EnvType> {
        private static final /* synthetic */ EnvType[] $VALUES = null;
        public static final EnvType BOE = null;
        public static final EnvType PPE = null;
        public static final EnvType PRODUCT = null;

        static {
            EnvType r100 = new EnvType("PRODUCT", 0);
            PRODUCT = r100;
            EnvType r101 = new EnvType("PPE", 1);
            PPE = r101;
            EnvType r102 = new EnvType("BOE", 2);
            BOE = r102;
            $VALUES = new EnvType[]{r100, r101, r102};
        }

        public static EnvType[] values() {
            return (EnvType[]) $VALUES.clone();
        }

        public static EnvType valueOf(String r100) {
            return (EnvType) a.a(EnvType.class, r100);
        }

        private EnvType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public UrlConstant() {
    }

    public static String getAuthDecisionPath() {
        return GET_AUTH_DECISION;
    }

    public static String getFaceCompareAuthenticationPath() {
        return FACE_COMPARE_AUTHENTICATION_PATH;
    }

    public static String getFaceComparePath() {
        return FACE_COMPARE_PATH_NEW;
    }

    public static String getFaceCompareResultPath() {
        return FACE_COMPARE_RESULT_PATH;
    }

    public static String getFaceCompareVerificationPath() {
        return FACE_COMPARE_VERIFICATION_PATH;
    }

    public static String getFaceInitPath() {
        return FACE_INIT_PATH;
    }

    public static String getGreyStrategyPath() {
        return GREY_STRATEGY_PATH;
    }

    public static String getLiveDetectPath(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        return LIVE_DETECT_PATH_NEW;
    L5:
        if (r101 == false) goto L8;
        return VIDEO_LIVE_DETECT_PATH;
    L8:
        return LIVE_DETECT_PATH;
    }

    public static String getManualCheckPath(boolean r100) {
        if (r100 == false) goto L5;
        return MANUAL_CHECK_PATH_NEW;
    L5:
        return MANUAL_CHECK_PATH;
    }

    public static String getOcrPath() {
        return OCR_PATH;
    }

    public static String getOcrPathManual() {
        return "/ucenter_auth/ocr";
    }

    public static String getOcrPathV2(boolean r100) {
        if (r100 == false) goto L5;
        return "/ucenter_auth/ocr";
    L5:
        return OCR_PATH_V2;
    }

    public static String getPreManualCheck() {
        return PRE_MANUAL_CHECK;
    }

    public static String getQueryPath() {
        return QUERY_PATH;
    }

    public static String getReferenceImage() {
        return REFERENCE_IMAGE;
    }

    public static String getSaveCertVideoPath() {
        return SAVE_CERT_VIDEO_TO_UCENTER_PATH;
    }

    public static String getSdkInitPath(boolean r100) {
        if (r100 == false) goto L5;
        return SDK_INIT_PATH_NEW;
    L5:
        return SDK_INIT_PATH;
    }

    public static String getUploadErrorFaceLog(boolean r100) {
        if (r100 == false) goto L5;
        return UPLOAD_ERROR_FACE_LOG_PATH_NEW;
    L5:
        return UPLOAD_ERROR_FACE_LOG;
    }

    public static String getUploadShootVideoPath() {
        return UPLOAD_SHOOT_VIDEO_PATH;
    }

    public static String getUploadVideoPath() {
        return UPLOAD_VIDEO_PATH;
    }

    public static String getUploadVideoToSensitivePath() {
        return UPLOAD_VIDEO_TO_SENSITIVE_PATH;
    }

    public static String getVideoShootConfigPath() {
        return GET_VIDEO_SHOOT_CONFIG_PATH;
    }

    static {
        envType = EnvType.PRODUCT;
        env = null;
        GECKO_HOST = "gecko.zijieapi.com";
    }

    public static String getBaseUrl() {
        return SCHEME + HOST;
    }

    public static String getDebugH5url() {
        return DEBUG_H5URL;
    }

    public static String getEnv() {
        return env;
    }

    public static EnvType getEnvType() {
        return envType;
    }

    public static String getGeckoHost() {
        return GECKO_HOST;
    }

    public static String getHost() {
        return HOST;
    }

    public static String getSCHEME() {
        return SCHEME;
    }

    public static void setDebugH5url(String r100) {
        DEBUG_H5URL = r100;
    }

    public static void setGeckoHost(String r100) {
        GECKO_HOST = r100;
    }

    public static void setHost(String r100) {
        HOST = r100;
    }

    public static void setScheme(String r100) {
        SCHEME = r100;
    }

    public static void setEnv(EnvType r100, String r101, String r102) {
        envType = r100;
        HOST = r101;
        int r103 = AnonymousClass1.$SwitchMap$com$ss$android$cert$manager$constants$UrlConstant$EnvType[r100.ordinal()];
        if (r103 != 1) goto L5;
    L10:
        env = r102;
        return;
    L5:
        if (r103 == 2) goto L10;
        if (r103 != 3) goto L13;
        env = null;
        return;
    }
}
