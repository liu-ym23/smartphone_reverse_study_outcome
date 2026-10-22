package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface ComplianceConstants {
    public static final int AID_DOWNLOAD_SDK = 6103;
    public static final String API_POST_COMPLIANCE = "/customer/api/app/uniform";
    public static final String API_POST_COMPLIANCE_APPSTORE_PERMIT = "/customer/api/app/appstore_permit";
    public static final String API_POST_MARKET_OPT_COMPLIANCE = "/customer/api/app/deep_link";
    public static final String API_POST_ORDER_DOWNLOAD_BOOKING_NOTIFY = "/booking/notify";
    public static final String BACKGROUND_COLOR_APP_ICON = "#EBEBEB";
    public static final String DEFAULT_WEB_REGEX = ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+";
    public static final String HOST = "https://apps.bytesfield.com";
    public static final String HOST_BACKUP = "https://apps.bytesfield-b.com";

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppstorePermitStatus {
        public static final int DENY = 0;
        public static final int PERMIT = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplianceRequest {
        public static final String CALL_SCENE = "call_scene";
        public static final String CHECK_ID = "check_id";
        public static final String DETAIL_STYLE = "detail_style";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String ID = "id";
        public static final String KEY_COMPLIANCE_DATA = "compliance_data";
        public static final String MARKET_STORE = "store";
        public static final String ORDER_ID = "order_id";
        public static final String PACKAGE_NAME = "package_name";
        public static final int REQUEST_INITIAL_VALUE = 0;
        public static final int REQUEST_MAX_RETRY_COUNT = 6;
        public static final String SENDER_PACKAGE_NAME = "sender_package_name";
        public static final String SENDER_VERSION = "sender_version";
        public static final String WEB_URL = "web_url";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadPermitStatus {
        public static final int DENY = 0;
        public static final int PERMIT = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadUniform {
        public static final int COMPLIANCE = 1;
        public static final int UNCOMPLIANCE = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HijackStatus {
        public static final int HIJACK = 1;
        public static final int UNHIJACK = 0;
    }
}
