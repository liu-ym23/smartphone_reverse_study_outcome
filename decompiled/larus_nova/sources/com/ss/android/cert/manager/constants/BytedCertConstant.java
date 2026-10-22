package com.ss.android.cert.manager.constants;

import com.bytedance.sdk.account.platform.api.IGoogleService;

/* JADX INFO: loaded from: classes5.dex */
public class BytedCertConstant {
    public static final int H5_COMPRESS_RATE = 85;
    public static final String[] SENSITIVE_KEY_SETS = null;
    public static final String VERSION = "4.7.7-rc.13";

    /* JADX INFO: loaded from: classes34.dex */
    public interface BeautyIntensity {
        public static final int MIDDLE_BEAUTY = 40;
        public static final int NO_BEAUTY = 0;
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface CertKey {
        public static final String ALGO_ACTION_VERSION = "algo_action_version";
        public static final String ALL = "all";
        public static final String APP_ID = "cert_app_id";
        public static final String BACKEND_DECISION = "backend_decision";
        public static final String BYTED_CERT_LANGUAGE = "byted_cert_language";
        public static final String CANCEL = "cancel";
        public static final String DEVICE_SUPPORT_CN_NET_AUTH = "device_support_ca";
        public static final String DEVICE_SUPPORT_NFC = "device_support_nfc";
        public static final String ENTER_METHOD = "enter_method";
        public static final String EVENT_EXTRA = "extra";
        public static final String EVENT_PARAMS = "eventParams";
        public static final String FACE_DETECT_INFO = "face_detect_info";
        public static final String FLOW = "flow";
        public static final String IDENTITY_CODE = "identity_code";
        public static final String IDENTITY_NAME = "identity_name";
        public static final String LIVE_DETECT_OPTIMIZE = "live_detect_optimize";
        public static final String LIVE_TYPE = "liveness_type";
        public static final String MODE = "mode";
        public static final String ONLY_CLIENT = "only_client";
        public static final String PAGE_PREPARE_TIPS = "page_prepare_tips";
        public static final String PAGE_PREPARE_TITLE = "page_prepare_title";
        public static final String SCENE = "scene";
        public static final String SDK_CODE = "sdk_code";
        public static final String SDK_SUB_CODE = "sdk_sub_code";
        public static final String SDK_VERSION = "sdk_version";
        public static final String SHOW_AUTH_ERROR = "show_auth_error";
        public static final String SHOW_PROTECT_FACE_LOGO = "show_protect_face_logo";
        public static final String SUPPORT_CHANNELS = "support_channels";
        public static final String SUPPORT_LIVENESS_TYPES = "support_liveness_types";
        public static final String TICKET = "ticket";
        public static final String USE_NEW_API = "use_new_api";
        public static final String USE_SYSTEM_V2 = "use_system_v2";
        public static final String VERIFY_CHANNEL = "verify_channel";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface CertValue {
        public static final String CERTIFICATE_SUCCESS = "certificate_success";
        public static final String TYPE_DIALOG_FACE = "dialog_face";
        public static final String TYPE_FULL_FACE = "full_face";
        public static final String TYPE_PERCENT_FACE = "percent_face";
        public static final String VALUE_ALICLOUD = "aliCloud";
        public static final String VALUE_BYTE = "byte";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface IntentKey {
        public static final String FLOW_ID = "flow_id";
        public static final String LANGUAGE = "language";
        public static final String VIEW_TYPE = "view_type";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface JsbKey {
        public static final String CERT_JSB_NAMESPACE = "bytedcert.";
        public static final String EVENT_NFC_END = "bytedcert.nfcEnd";
        public static final String EVENT_NFC_READ = "bytedcert.nfcReading";
        public static final String EVENT_ON_BACK_PRESSED = "bytedcert.onBackPressed";
        public static final String METHOD_ADD_EVENT_LISTENER = "bytedcert.addEvtListener";
        public static final String METHOD_BYTED_CERT_FETCH = "bytedcert.fetch";
        public static final String METHOD_CAN_I_USE_NFC = "bytedcert.caniuseNFC";
        public static final String METHOD_CLOSE_PAGE = "bytedcert.closePage";
        public static final String METHOD_CLOSE_USER_IDENTITY_FLOW = "bytedcert.closeUserIdentityFlow";
        public static final String METHOD_DO_OCR = "bytedcert.doOCR";
        public static final String METHOD_DO_REQUEST = "bytedcert.doRequest";
        public static final String METHOD_HIDE_LOADING = "bytedcert.hideLoading";
        public static final String METHOD_LAUNCH_FLOW = "bytedcert.launchFlow";
        public static final String METHOD_MANUALLY_VERIFY = "bytedcert.manualVerify";
        public static final String METHOD_NOTIFY_CONFIRM_STATUS = "bytedcert.notifyConfirmStatus";
        public static final String METHOD_OPEN_AND_CLOSE = "bytedcert.openAndClose";
        public static final String METHOD_OPEN_CN_NET_AUTH = "bytedcert.openCNNetAuth";
        public static final String METHOD_OPEN_FACE_LIVE = "bytedcert.openLiveCert";
        public static final String METHOD_OPEN_LOGIN_PAGE = "bytedcert.openLoginPage";
        public static final String METHOD_OPEN_PAGE = "bytedcert.openPage";
        public static final String METHOD_OPEN_VIDEO_CERT = "bytedcert.openVideoCert";
        public static final String METHOD_OPEN_VIDEO_RECORD = "bytedcert.openVideoRecord";
        public static final String METHOD_PRE_MANUAL_CHECK = "bytedcert.preManualCheck";
        public static final String METHOD_REMOVE_EVENT_LISTENER = "bytedcert.removeEvtListener";
        public static final String METHOD_SEND_EVENT = "bytedcert.sendEvent";
        public static final String METHOD_SEND_LOG = "bytedcert.sendLog";
        public static final String METHOD_SET_CERT_STATUS = "bytedcert.setCertStatus";
        public static final String METHOD_SET_PAGE_LOADED = "bytedcert.setPageLoaded";
        public static final String METHOD_SHOW_DIALOG = "bytedcert.dialogShow";
        public static final String METHOD_SHOW_LOADING = "bytedcert.showLoading";
        public static final String METHOD_START_NFC = "bytedcert.startNFC";
        public static final String METHOD_STOP_NFC = "bytedcert.stopNFC";
        public static final String METHOD_SWITCH_LANGUAGE = "bytedcert.switchLanguage";
        public static final String METHOD_TAKE_OCR_PHOTO = "bytedcert.takeOCRPhoto";
        public static final String METHOD_TAKE_PHOTO = "bytedcert.takePhoto";
        public static final String METHOD_TOAST = "bytedcert.toast";
        public static final String METHOD_TRACK_FLOW_ABILITY = "bytedcert.trackFlowAbility";
        public static final String METHOD_UPLOAD = "bytedcert.upload";
        public static final String METHOD_UPLOAD_EVENT = "bytedcert.uploadEvent";
        public static final String METHOD_UPLOAD_PHOTO = "bytedcert.uploadPhoto";
        public static final String METHOD_WEB_EVENT = "bytedcert.webEvent";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface KeyTimestamp {
        public static final String FACE_CAMERA_SETUP = "face_camera_setup";
        public static final String FACE_COMPARE_END = "face_compare_end";
        public static final String FACE_COMPARE_START = "face_compare_start";
        public static final String FACE_DETECT_OPEN = "face_detect_open";
        public static final String FACE_LIVENESS_END = "face_liveness_end";
        public static final String FACE_LIVENESS_FALLBACK = "face_liveness_fallback";
        public static final String FACE_PAGE_NOTIFY = "face_page_notify";
        public static final String FACE_QEURY_RESULT = "face_qeury_result";
        public static final String FACE_SMASH_DID_SETUP = "face_smash_did_setup";
        public static final String FACE_SMASH_LOADED = "face_smash_loaded";
        public static final String FACE_SMASH_PRE_LOAD = "face_smash_pre_load";
        public static final String FACE_SMASH_PRE_SETUP = "face_smash_pre_setup";
        public static final String FACE_VIDEO_RECORD_UPLOAD = "face_video_record_upload";
        public static final String FLOW_END = "flow_end";
        public static final String FLOW_START = "flow_start";
        public static final String TIMESTAMP_NFC_CONNECTED = "nfc_connected";
        public static final String TIMESTAMP_NFC_END = "nfc_end";
        public static final String WEBVIEW_DID_LOAD = "webview_did_load";
        public static final String WEBVIEW_START_LOAD = "webview_start_load";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface LiveType {
        public static final String DEFAULT_TYPES = "motion,video,still";
        public static final String LIVE_TYPE_ACTION = "motion";
        public static final String LIVE_TYPE_MOTION_WITH_REFLECTION = "motion_with_reflection";
        public static final String LIVE_TYPE_STILL = "still";
        public static final String LIVE_TYPE_VIDEO = "video";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface LivenessInfoConfigKey {
        public static final String COLOR = "c";
        public static final String DETECT_TYPE = "dt";
        public static final String ENABLE = "e";
        public static final String FRAME_NUM = "fn";
        public static final String KEY = "si";
        public static final String THRESHOLD = "t";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface MotionType {
        public static final int NOD_HEAD = 2;
        public static final int OPEN_MOUTH = 1;
        public static final int SHARK_HEAD = 3;
        public static final int WINK = 0;
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface NFC {
        public static final String ID_CARD = "id_card";
        public static final String PASSPORT = "passport";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface ReflectionConfigKey {
        public static final String COLOR_ARRAY = "a";
        public static final String COLOR_COUNT = "c";
        public static final String ENABLE = "e";
        public static final String KEY = "r";
        public static final String PER_FRAME_NUM = "p";
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface SmashConfigFlag {
        public static final int ACTION_LIVENESS_INFO_MODE = 40;
        public static final int ACTION_LIVENESS_INFO_SUB_MODE = 43;
        public static final int ACTION_LIVENESS_INFO_SWITCH = 39;
        public static final int ACTION_LIVENESS_INFO_THRESH = 42;
        public static final int ACTION_LIVENESS_INFO_TIME = 41;
        public static final int REFLECTION_COLOR_COUNT = 36;
        public static final int REFLECTION_ENABLE = 33;
        public static final int REFLECTION_FRAME_COUNT = 34;
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface WebInfo {
        public static final String ENTRY_PAGE_ADDRESS = "entry_page_address";
        public static final String WEB_TITLE = "web_title";
        public static final String WEB_TYPE_ANNIEX = "anniex";
        public static final String WEB_TYPE_CERT_WEB = "default";
        public static final String WEB_TYPE_NEW_CERT_WEB = "cert_web";
        public static final String WEB_URL = "web_url";
    }

    public BytedCertConstant() {
    }

    static {
        SENSITIVE_KEY_SETS = new String[]{IGoogleService.ResponseKey.PHONE_NUMBER, "bank_card_number", "children_identity_name", "children_birthday", CertKey.IDENTITY_NAME, CertKey.IDENTITY_CODE, "mobile", "guardian_identity_name", "guardian_identity_code", "guardian_mobile"};
    }
}
