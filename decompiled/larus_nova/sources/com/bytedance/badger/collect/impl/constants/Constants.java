package com.bytedance.badger.collect.impl.constants;

/* JADX INFO: loaded from: classes47.dex */
public class Constants {

    public interface EventName {
        public static final String LOADER_MONITOR = "loader_monitor";
        public static final String MIGRATE_MONITOR = "migrate_monitor";
        public static final String MOBILE_GET_SING = "mobile_get_sign_event";
        public static final String MOBILE_GET_TOKEN = "mobile_get_token_event";
        public static final String MOBILE_INIT = "mobile_init_event";
        public static final String MOBILE_REPORT = "mobile_report_event";
        public static final String MOBILE_WIFI_SWITCH = "mobile_wifi_switch_event";
        public static final String SETTINGS = "kite_settings";
        public static final String UAID_MONITOR = "uaid_monitor";
        public static final String WORKER = "kite_worker";
    }

    public interface Keys {
        public static final String AUTH_URL = "authurl";
        public static final String DATA = "data";
        public static final String ERROR = "errorMsg";
        public static final String HEADER = "header";
        public static final String KEY_CLIENT_TIME = "client_time";
        public static final String KEY_FETCH_CONFIG = "fetch_config";
        public static final String KEY_HTTP_CODE = "httpCode";
        public static final String KEY_MOBILE_PSEUDO_CODE_TOKEN = "mobile_pseudo_code_token";
        public static final String KEY_PSEUDO_CODE = "key_pseudo_code";
        public static final String KEY_SET_COOKIE = "Set-Cookie";
        public static final String KEY_X_TT_LOGID = "X-Tt-Logid";
        public static final String KITE_SETTINGS = "kite_settings";
        public static final String METHOD_GET = "GET";
        public static final String METHOD_POST = "POST";
        public static final String REQ_ID = "req_id";
        public static final String SP_D_DATA = "d_data";
        public static final String SP_NAME = "badger_device_sdk";
        public static final String VERSION = "version";
        public static final String duration = "duration";
    }

    public interface NetworkOperator {
        public static final String MOBILE_OPERATOR = "China_Mobile";
        public static final String NETWORK_TYPE_MOBILE = "NETWORK_TYPE_MOBILE";
        public static final String NETWORK_TYPE_NO_NET = "NETWORK_TYPE_NO_NET";
        public static final String NETWORK_TYPE_UNKNOWN = "NETWORK_TYPE_UNKNOWN";
        public static final String NETWORK_TYPE_WIFI = "NETWORK_TYPE_WIFI";
        public static final String NETWORK_TYPE_WIFI_AND_MOBILE = "NETWORK_TYPE_WIFI_AND_MOBILE";
        public static final String OTHERS_OPERATOR = "others operator";
        public static final String SIM_CARD_NOT_READY = "sim card not ready";
        public static final String TELECOM_OPERATOR = "China_Telecom";
        public static final String UNICOM_OPERATOR = "China_Unicom";
        public static final String UNKNOWN_OPERATOR = "unknown operator";
    }

    public interface OperatorKey {
        public static final String AUTH_URL = "authurl";
        public static final String CODE = "code";
        public static final String KEY_APP_ID = "appId";
        public static final String KEY_CARRIER = "carrier";
        public static final String KEY_COST_TIME = "time";
        public static final String KEY_HTTP_CODE = "httpCode";
        public static final String KEY_NETWORK_STATUS = "networkStatus";
        public static final String KEY_RESULT_CODE = "resultCode";
        public static final String KEY_RESULT_MSG = "resultMsg";
        public static final String KEY_TOKEN = "token";
        public static final String KEY_UAID = "uaid";
        public static final String KEY_VENDOR = "vendor";
        public static final String MSG = "msg";
        public static final String PROVINCE = "province";
    }

    public interface PATHS {
        public static final String HOST_PSEUDO_CODE = "https://i.snssdk.com";
        public static final String HOST_REPORT_CENTER_TOKEN = "https://relation.zijieapi.com";
        public static final String PATH_DEVICE_SDK_KITE = "/service/2/device_sdk/kite/";
        public static final String PATH_DEVICE_STATS_COLLECT = "/service/3/device_sdk/stats_collect/";
        public static final String PATH_GET_MOBILE_SIGN_POST = "/activity/carrier_flow/mobile/get_sign_post/";
        public static final String PATH_REPORT_CENTER_TOKEN = "/cross/pseudo_code_wifi";
        public static final String PATH_SETTINGS = "/service/settings/v3/";
        public static final String PATH_UAID_TOKEN = "/uaid/token";
        public static final String PATH_UAID_VERIFICATION = "/uaid/verification";
        public static final String URL_GET_MOBILE_TOKEN = "http://wap.cmpassport.com/openapi/wabpGetUseInfo?";
    }

    public interface StatusCode {
        public static final Integer ERROR_SDK_VERSION_LOW = null;
        public static final Integer FAILED = null;
        public static final Integer SUCCESS = null;

        static {
            SUCCESS = 0;
            FAILED = -1000;
            ERROR_SDK_VERSION_LOW = -1001;
        }
    }

    public interface TAGS {
        public static final String EVENT = "[event] ";
        public static final String INIT = "[init] ";
        public static final String KITE = "[Collect] ";
        public static final String NETWORK = "[network] ";
        public static final String NETWORK_MONITOR = "[network_monitor] ";
        public static final String NETWORK_SWITCH = "[network_switch] ";
        public static final String PSEUDO = "[pseudo] ";
        public static final String WIFI_TO_CELLULAR_NETWORK = "[wifi_to_cellular_network] ";
        public static final String WORKER = "[worker] ";
    }

    public interface Values {
        public static final String BADGER_COLLECT = "badger_collect_impl";
        public static final int DEFAULT_CAPACITY = 4;
        public static final String SETTINGS_ID = "kite_sdk";
        public static final String SETTINGS_SDK_NAME = "kite_device_android";
    }

    public Constants() {
    }
}
