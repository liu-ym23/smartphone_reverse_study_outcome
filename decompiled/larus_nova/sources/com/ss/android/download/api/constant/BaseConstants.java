package com.ss.android.download.api.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface BaseConstants {
    public static final int ACTION_TYPE_BUTTON = 2;
    public static final int ACTION_TYPE_ITEM = 1;
    public static final String CATEGORY_UMENG = "umeng";
    public static final String DOWNLOAD_DIR = "ByteDownload";
    public static final String EVENT_LABEL_AD_EXTRA_DATA = "ad_extra_data";
    public static final String EVENT_LABEL_EXTRA = "extra";
    public static final String EVENT_LABEL_IS_AD_EVENT = "is_ad_event";
    public static final String EVENT_LABEL_LOG_EXTRA = "log_extra";
    public static final int EVENT_SOURCE_SDK_INSIDE = 2;
    public static final int EVENT_SOURCE_USER = 1;
    public static final String GAME_INFO_LIVE_UNION = "live_union";
    public static final String GAME_INFO_PRODUCT_TYPE = "product_type";
    public static final String HW_APP_ID_CHANNELID_SHARE = "share";
    public static final String HW_APP_ID_FROM_UNIFORM = "hw_app_id";
    public static final String HW_APP_ID_PATTERN = "^C\\d+$";
    public static final String KEY_COMPLIANCE_DATA = "compliance_data";
    public static final String KLLK_PROMOTION_COLOROS_PKG_INFO = "com.coloros.browser";
    public static final String KLLK_PROMOTION_HEYTAP_PKG_INFO = "com.heytap.browser";
    public static final String KLLK_PROMOTION_NORMAL_PKG_INFO = "com.android.browser";
    public static final String MARKET_PREFIX = "market://details?id=";
    public static final String MARKET_PREFIX_SAMSUNG = "samsungapps://productDetail/";
    public static final String MARKET_SCHEME_HONOR = "honormarket";
    public static final String MARKET_SCHEME_HUAWEI = "appmarket";
    public static final String MARKET_SCHEME_HW_HONOR = "hiapplink";
    public static final String MARKET_SCHEME_MEIZU = "mstore";
    public static final String MARKET_SCHEME_OPPO = "oppomarket";
    public static final String MARKET_SCHEME_OPPO_1 = "opos";
    public static final String MARKET_SCHEME_SAMSUNG = "samsungapps";
    public static final String MARKET_SCHEME_VIVO = "vivomarket";
    public static final String MARKET_SCHEME_VIVO_1 = "gomarket";
    public static final String MARKET_SCHEME_XIAOMI = "mimarket";
    public static final String MARKET_URI_AUTHORITY_DETAIL = "details";
    public static final String MARKET_URI_AUTHORITY_SEARCH = "search";
    public static final long MB_VALUE = 1048576;
    public static final String PERMISSION_READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    public static final String PERMISSION_READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String PERMISSION_READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String ROM_OPPO_UPPER_CONSTANT = "OPPO";
    public static final String SCHEME_HTTPS = "https";
    public static final String SCHEME_MARKET = "market";
    public static final String START_ONLY_FOR_ANDROID = "start_only_for_android";
    public static final int TTDOWNLOADER_AID = 6103;
    public static final String VIVO_MARKET_NEED_COMMENT = "need_comment";
    public static final String VIVO_MARKET_OPT_URI_AUTHORITY = "details";
    public static final String VIVO_MARKET_OPT_URI_PARAM_ID = "id";
    public static final String VIVO_V2_REQUIRED_MARKET_VERSION = "8.7.2.0";

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
        public static final int BTN = 2;
        public static final int DOWNLOAD_COMPLIANCE_DIALOG = 3;
        public static final int ITEM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MiuiDetailStyle {
        public static final String MIUI_OPT_DETAIL_STYLE_1 = "1";
        public static final String MIUI_OPT_DETAIL_STYLE_2 = "2";
        public static final String MIUI_OPT_DETAIL_STYLE_3 = "3";
        public static final String MIUI_OPT_DETAIL_STYLE_4 = "4";
        public static final String MIUI_OPT_DETAIL_STYLE_5 = "5";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SetDownloadModelScene {
        public static final int SCENE_ACTION = 1;
        public static final int SCENE_BIND = 0;
        public static final int SCENE_DETAIL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SlardarHeaderKey {
        public static final String SLARDAR_KEY_APP_VERSION = "app_version";
        public static final String SLARDAR_KEY_CHANNEL = "channel";
        public static final String SLARDAR_KEY_DEVICE_ID = "device_id";
        public static final String SLARDAR_KEY_HOST_AID = "host_aid";
        public static final String SLARDAR_KEY_PACKAGE_NAME = "package_name";
        public static final String SLARDAR_KEY_SDK_VERSION = "sdk_version";
        public static final String SLARDAR_KEY_UPDATE_VERSION_CODE = "update_version_code";
    }

    public interface Time {
        public static final int DAY = 86400000;
        public static final int HOUR = 3600000;
        public static final int MINUTE = 60000;
        public static final int SECOND = 1000;
        public static final int WEEK = 604800000;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ToastScene {
        public static final int JUMP_MARKET_SUCCESS = 8;
        public static final int JUMP_OPPO_BROWSER_SUCCESS = 12;
        public static final int LP_APP_INFO_ERROR = 6;
        public static final int MARKET_NEW_INTERFACE_ERROR = 14;
        public static final int MIUI_HALF_PAGE_JUMP_DELAY = 13;
        public static final int MONITOR_ERROR = 7;
        public static final int NETWORK_NOT_AVAILABLE = 5;
        public static final int NO_STORAGE_PERMISSION = 1;
        public static final int OPEN_APP_FAILED = 4;
        public static final int OPEN_WEB_NULL = 10;
        public static final int ORDER_DOWNLOAD_FAILED = 9;
        public static final int ORDER_DOWNLOAD_NOT_UNIFORM = 11;
        public static final int PACKAGE_NAME_ERROR = 3;
        public static final int START_DOWNLOAD = 2;
    }
}
