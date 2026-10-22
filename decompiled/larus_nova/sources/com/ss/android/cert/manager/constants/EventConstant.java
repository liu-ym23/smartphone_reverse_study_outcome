package com.ss.android.cert.manager.constants;

/* JADX INFO: loaded from: classes34.dex */
public class EventConstant {

    public interface Event {
        public static final String AUTH_SDK_NETWORK_REQUEST = "auth_sdk_network_request";
        public static final String AUTH_VERIFY_END = "auth_verify_end";
        public static final String AUTH_VERIFY_START = "auth_verify_start";
        public static final String AUTH_VIDEO_CHECKING_RESULT = "auth_video_checking_result";
        public static final String BYTED_CERT_CAMERA_INIT_ERROR = "byted_cert_camera_init_error";
        public static final String BYTED_CERT_CERTIFICATION_JSB_RESULT = "byted_cert_certification_jsb_result";
        public static final String CERT_DO_STILL_LIVENESS = "cert_do_still_liveness";
        public static final String CERT_MODEL_PRELOAD = "cert_model_preload";
        public static final String CERT_MODEL_PRELOAD_START = "cert_model_preload_start";
        public static final String CERT_MODEL_UPDATE = "cert_model_update";
        public static final String CERT_MOTION_TYPES = "cert_motion_types";
        public static final String CERT_OFFLINE_FACE_VERIFY = "cert_offline_face_verify";
        public static final String CERT_START_BYTED_CERT = "cert_start_byted_cert";
        public static final String CERT_START_FACE_LIVE = "cert_start_face_live";
        public static final String CERT_START_FACE_LIVE_INTERNAL = "cert_start_face_live_internal";
        public static final String CONFIRM_BACK_POPUP = "confirm_back_popup";
        public static final String EVENT_AUTH_NOTIFY_DIALOG = "auth_notify_dialog";
        public static final String EVENT_AUTH_NOTIFY_DIALOG_CLICK = "auth_notify_dialog_click";
        public static final String EVENT_FACE_ACTION_RESULT = "face_action_result";
        public static final String EVENT_FACE_ACTION_START = "face_action_start";
        public static final String EVENT_FACE_DETECTION_FALLBACK = "face_detection_fallback";
        public static final String EVENT_FACE_DETECTION_INIT_REQUEST = "face_detection_init_request";
        public static final String EVENT_FACE_MODULE_LOAD_RESULT = "face_module_load_result";
        public static final String EVENT_FACE_PEND_RESULT = "face_pend_result";
        public static final String EVENT_FACE_PEND_START = "face_pend_start";
        public static final String EVENT_FACE_REFLECTION_COLOR_CHANGE = "face_reflection_color_change";
        public static final String EVENT_FACE_REFLECTION_END = "face_reflection_end";
        public static final String EVENT_FACE_REFLECTION_START = "face_reflection_start";
        public static final String EVENT_FACE_SIDE_CHANNEL_DETECT_RESULT = "face_side_channel_detect_result";
        public static final String EVENT_FACE_SIDE_CHANNEL_DETECT_SET_PARAMS = "face_side_channel_detect_set_params";
        public static final String EVENT_FACE_SIDE_CHANNEL_DETECT_START = "face_side_channel_detect_start";
        public static final String EVENT_FACE_WAITFACE_RESULT = "face_waitface_result";
        public static final String EVENT_FACE_WAITFACE_START = "face_waitface_start";
        public static final String EVENT_FACE_WARMUP_RESULT = "face_warmup_result";
        public static final String EVENT_FACE_WARMUP_START = "face_warmup_start";
        public static final String EVENT_NFC_END = "event_nfc_end";
        public static final String EVENT_NFC_OPENED = "OPENED";
        public static final String EVENT_NFC_START = "event_nfc_start";
        public static final String EVENT_NFC_UN_OPENED = "UN_OPENED";
        public static final String EVENT_RANDOM_CODE_REQUEST_RESULT = "random_code_request_result";
        public static final String EVENT_UPLOAD_PREVIEW_CLICK = "upload_preview_click";
        public static final String EVENT_UPLOAD_PREVIEW_SHOW = "upload_preview_show";
        public static final String EVENT_VIDEO_RECORD_PERMISSION = "video_record_permission";
        public static final String EVENT_VIDEO_RECORD_PREPARE_CLICK = "video_record_prepare_click";
        public static final String EVENT_VIDEO_RECORD_PREPARE_SHOW = "video_record_prepare_show";
        public static final String FACE_DETECTION_CAMERA_PERMIT = "face_detection_camera_permit";
        public static final String FACE_DETECTION_ENTER = "face_detection_enter";
        public static final String FACE_DETECTION_FAIL_POPUP = "face_detection_fail_popup";
        public static final String FACE_DETECTION_FINAL_RESULT = "face_detection_final_result";
        public static final String FACE_DETECTION_IMAGE_RESULT = "face_detection_image_result";
        public static final String FACE_DETECTION_LIVE_RESULT = "face_detection_live_result";
        public static final String FACE_DETECTION_OPEN_CAMERA = "face_detection_open_camera";
        public static final String FACE_DETECTION_PROMPT = "face_detection_prompt";
        public static final String FACE_DETECTION_SDK_RETURN = "face_detection_sdk_return";
        public static final String FACE_DETECTION_START = "face_detection_start";
        public static final String FACE_DETECTION_START_WEB_REQ = "face_detection_start_web_req";
        public static final String FACE_DETECTION_VIDEO_ERROR = "face_detection_video_error";
        public static final String FACE_DETECTION_VIDEO_QUALITY = "face_detection_video_quality";
        public static final String FACE_DETECTION_VIDEO_RESULT = "face_detection_video_result";
        public static final String FACE_RETAIN_POPUP = "face_retain_popup";
        public static final String FACE_RETAIN_POPUP_CLICK = "face_retain_popup_click";
        public static final String ID_CARD_PHOTO_UPLOAD_ALERT_CLICK = "id_card_photo_upload_alert_click";
        public static final String ID_CARD_PHOTO_UPLOAD_ALERT_SHOW = "id_card_photo_upload_alert_show";
        public static final String ID_CARD_PHOTO_UPLOAD_CAMERA_BUTTON = "id_card_photo_upload_camera_button";
        public static final String ID_CARD_PHOTO_UPLOAD_CAMERA_PERMIT = "id_card_photo_upload_camera_permit";
        public static final String ID_CARD_PHOTO_UPLOAD_SELECT_FINISH = "id_card_photo_upload_select_finish";
        public static final String MANUAL_DETECTION_CAMERA_PERMIT = "manual_detection_camera_permit";
        public static final String MANUAL_DETECTION_CAMERA_SHOW = "manual_detection_camera_show";
        public static final String MANUAL_DETECTION_PHOTO_RESULT = "manual_detection_photo_result";
        public static final String OCR_TAKE_PHOTO_CLICK = "ocr_take_photo_click";
        public static final String OCR_TAKE_PHOTO_SHOW = "ocr_take_photo_show";
        public static final String RETURN_PREVIOUS_PAGE = "return_previous_page";
        public static final String SDK_EXCEPTION = "byted_cert_sdk_exception";
        public static final String SDK_FINAL_RESULT = "sdk_final_result";
    }

    public interface Key {
        public static final String ACTION_TYPE = "action_type";
        public static final String AGE_LARGER_14 = "age_larger_14";
        public static final String ALL_MODULE = "all_module";
        public static final String ALREADY_HAS_PERMISSION = "already_has_permission";
        public static final String APP_ID = "app_id";
        public static final String AUTH_VERSION = "auth_version";
        public static final String BACK_POSITION = "back_position";
        public static final String BACK_RESULT = "back_result";
        public static final String BUTTON = "button";
        public static final String BYTED_CERT_LANGUAGE = "byted_cert_language";
        public static final String CAMERA_PERMIT = "camera_permit";
        public static final String CERT_CODE = "cert_code";
        public static final String CERT_SUB_CODE = "cert_sub_code";
        public static final String COLOR = "color_list";
        public static final String COLOR_DETECTION_RESULT = "color_detection_result";
        public static final String COLOR_PROMPT_INFO = "color_prompt_info";
        public static final String COLOR_PROMPT_RESULT = "color_prompt_result";
        public static final String DETECTION_TYPE = "detection_type";
        public static final String DURATION = "duration";
        public static final String DURING_QUERY_INIT = "during_query_init";
        public static final String DURING_QUERY_LIVE = "during_query_live";
        public static final String DURING_START_ACTIVITY = "during_start_activity";
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MSG = "error_msg";
        public static final String ERROR_STACK = "error_stack";
        public static final String EVENT_EXTRA = "extra";
        public static final String EXCEPTION_MSG = "exception_msg";
        public static final String EXCEPTION_STACK_TRACE = "exception_stack_trace";
        public static final String FACE_DETECTION_VIEW_TYPE = "face_detection_view_type";
        public static final String FACE_DETECT_TIMESTAMP = "face_detect_timestamp";
        public static final String FAIL_REASON = "fail_reason";
        public static final String FALLBACK_ACTION_DONE = "action_done";
        public static final String FALLBACK_MOTION_TYPES = "fallback_motion_types";
        public static final String FULL_FLOW_TIMESTAMP = "full_flow_timestamp";
        public static final String INTERRUPT_TIMES = "interrupt_times";
        public static final String IS_FINISH = "is_finish";
        public static final String LAST_MODULE = "last_module";
        public static final String LOG_ID = "log_id";
        public static final String MIC_PERMIT = "mic_permit";
        public static final String MODE = "mode";
        public static final String MODULE = "module";
        public static final String PARAMS_FOR_SPECIAL = "params_for_special";
        public static final String PROMPT_INFO = "prompt_info";
        public static final String PROMPT_RESULT = "prompt_result";
        public static final String RAW_DATA = "raw_data";
        public static final String READ_NUMBER = "read_number";
        public static final String REQUIRE_LIST = "require_list";
        public static final String RESULT = "result";
        public static final String RETAIN_BUTTON = "button";
        public static final String RETAIN_PROMPT = "prompt";
        public static final String SCENE = "scene";
        public static final String SDK_RESULT = "sdk_result";
        public static final String SDK_VERSION = "sdk_version";
        public static final String SKD_PROCESS = "skd_process";
        public static final String TICKET = "ticket";
        public static final String TOTAL_DURATION = "total_duration";
        public static final String UC_VERIFY_ACTION_TIME = "uc_verify_action_time";
        public static final String UPLOAD_RETRY_TIMES = "upload_retry_times";
        public static final String URL_PATH = "url_path";
        public static final String VERIFY_DETECTION_TYPE = "verify_detection_type";
        public static final String VERIFY_SOURCE = "verify_source";
        public static final String VIDEO_DETECTION_RESULT = "video_detection_result";
        public static final String VIDEO_PROMPT_INFO = "video_prompt_info";
        public static final String VIDEO_PROMPT_RESULT = "video_prompt_result";
        public static final String VIDEO_RETRY_TIMES = "video_retry_times";
        public static final String WEB_REQ_RESULT = "web_req_result";
    }

    public interface MSSecEvent {
        public static final String CAMERA_CREATE = "camera_create";
        public static final String CAMERA_PREVIEW = "camera_preview";
    }

    public interface Value {
        public static final String ALERT_SHOW = "alert_show";
        public static final String ALIYUN = "aliyun";
        public static final String AUTH_VERSION_2 = "2.0";
        public static final String AUTH_VERSION_3 = "3.0";
        public static final String BACK_CANCEL = "back_cancel";
        public static final String BACK_CONFIRM = "back_confirm";
        public static final String CANCEL = "cancel";
        public static final String FACE_DETECTION_COLOR = "face_detection_color";
        public static final String FACE_DETECTION_COLOR_QUALITY = "face_detection_color_quality";
        public static final String FACE_DETECT_FAIL = "face_detect_fail";
        public static final String FAIL = "fail";
        public static final String HAS_PERMISSION = "has_permission";
        public static final String LIVE_DETECT = "detection";
        public static final String LOAD_MODEL = "load_model";
        public static final String NO_PERMISSION = "no_permission";
        public static final String PROMPT_FAIL = "2";
        public static final String PROMPT_SHOW = "0";
        public static final String PROMPT_SUCCESS = "1";
        public static final String QUIT = "quit";
        public static final String RETAIN_SHOW = "retain_show";
        public static final String RETRY = "retry";
        public static final String SELF = "byte";
        public static final String SUCCESS = "success";
        public static final String UC_LOGIN = "uc_login";
        public static final String UPLOAD_FAIL = "upload_fail";
        public static final String VALUE_FALSE = "0";
        public static final String VALUE_TRUE = "1";
        public static final String WEB_REQ_FAIL = "web_req_fail";
        public static final String WEB_REQ_SUCCESS = "web_req_success";
        public static final String ZHIFUBAO = "zhifubao";
    }

    public EventConstant() {
    }
}
