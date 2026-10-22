package com.ss.android.downloadlib.addownload.compliance;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {

    public interface APPSTORE_ERROR {
        public static final int APPSTORE_PERMIT_IS_ZERO = 302;
        public static final int APPSTORE_SUCCESS = -1;
        public static final int JUMP_ERROR = 304;
        public static final int PARAM_BUILD_ERROR = 301;
        public static final int REQUEST_FAIL = 305;
        public static final int RESPONSE_EMPTY = 303;
    }

    public interface APPSTORE_ERROR_MIUI_NEW {
        public static final int NO_NETWORK_FACTORY = 401;
        public static final int REQUEST_ERROR = 402;
        public static final int RESPONSE_CODE_NOT_SUCCESS = 403;
        public static final int RESPONSE_EMPTY = 404;
        public static final int RESPONSE_NO_MIUI_DEEPLINK = 405;
    }

    public interface APPSTORE_ERROR_MIUI_NEW_FOR_WEB {
        public static final int WEB_NO_NETWORK_FACTORY = 501;
        public static final int WEB_REQUEST_ERROR = 502;
        public static final int WEB_RESPONSE_CODE_NOT_SUCCESS = 503;
        public static final int WEB_RESPONSE_EMPTY = 504;
        public static final int WEB_RESPONSE_NO_MIUI_DEEPLINK = 505;
    }

    public interface LP_ERROR {
        public static final int APPSTORE_SUCCESS = -1;
        public static final int APP_INFO_INCOMPLETE = 106;
        public static final int COMPLIANCE_RESPONSE_CACHE_ERROR = 110;
        public static final int CREATE_DIALOG_FAILED = 109;
        public static final int DOWNLOAD_NOT_PERMIT = 102;
        public static final int DOWNLOAD_SUCCESS = -2;
        public static final int DOWNLOAD_URL_IS_MARKET = 113;
        public static final int JUMP_DETAIL_LP = -3;
        public static final int NULL_HANDLER = 112;
        public static final int NULL_HIJACK_URL = 104;
        public static final int NULL_ICON = 108;
        public static final int PARAM_BUILD_ERROR = 101;
        public static final int REPLACE_URL_FAILED = 111;
        public static final int REQUEST_FAIL = 107;
        public static final int RESPONSE_CODE_NOT_SUCCESS = 105;
        public static final int RESPONSE_EMPTY = 103;
    }

    public interface UNITY_ERROR {
        public static final int APP_INFO_INCOMPLETE = 204;
        public static final int BITMAP_CACHE_ERROR = 203;
        public static final int INTERCEPT_INNER_TRY_START_DOWNLOAD = 206;
        public static final int MISTAKE_CLICK = 205;
        public static final int NULL_DEEPLINK = 201;
        public static final int NULL_WEB_URL = 202;
    }
}
