package com.ss.android.downloadad.api.constant;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface AdBaseConstants extends BaseConstants {
    public static final String BOOKING_OFFICIAL_NOTIFICATION = "booking_official_notification";
    public static final String BYTEDANCE_PACKAGE_NAME_SUFFIX = "bytedance";
    public static final String CANCEL_PAUSE_BUTTON_TEXT = "管理";
    public static final int DEFAULT_BACKGROUND_INSTALL_DETECT_LIMIT_S = 120;
    public static final int DEFAULT_BROADCAST_CHECK_TIME = 600;
    public static final int DEFAULT_CONCURRENT_COUNT = 0;
    public static final int DEFAULT_INSTALL_DETECT_COUNT = 300;
    public static final int DEFAULT_INSTALL_DETECT_INTERVAL_MS = 2000;
    public static final int DEFAULT_INSTALL_FINISH_TRY_COUNT = 15;
    public static final int DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS = 20000;
    public static final long DEFAULT_INSTALL_FINISH_TRY_SUM_TIMESTAMP = 600000;
    public static final int DEFAULT_JUMP_MARKET_DELAY = 1000;
    public static final int DOWNLOAD_AFTER_JUMP = 1;
    public static final int DOWNLOAD_IMMEDIATELY = 0;
    public static final String DOWNLOAD_MANAGEMENT_CENTER_REFER = "download_center";
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_AND_ITEM_CLICK = 3;
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_CLICK = 2;
    public static final int DOWNLOAD_SCENE_DETAIL = 1;
    public static final int DOWNLOAD_SCENE_NORMAL = 0;
    public static final int ENABLE_DEEP_LINK_ONLY = 2;
    public static final int ENABLE_NORMAL_AND_DEEP_LINK = 1;
    public static final int ENABLE_NORMAL_LINK_ONLY = 0;
    public static final String HTTP_DOMAIN_AD = "https://i.snssdk.com/";
    public static final String HTTP_PATH_QUERY_SCHEME_LIST = "api/ad/v1/scheme/query/";
    public static final String HTTP_PATH_REPORT_SCHEME_LIST = "api/ad/v1/scheme/report/";
    public static final int MARKET_INTENT_JUMP_DO_NOT_PROHIBIT_TOAST = 1;
    public static final int MARKET_INTENT_JUMP_PROHIBIT_TOAST = 2;
    public static final int MARKET_JUMP_PROHIBIT_TOAST = 3;
    public static final String MARKET_OPEN_BRIDGE_ACTIVITY = "com.bytedance.ads.convert.BDBridgeActivity";
    public static final String MARKET_OPEN_CLICK_ID = "click_id";
    public static final String MARKET_OPEN_INTENT_EXTRA = "intent_extra";
    public static final String MARKET_OPEN_INTENT_OPEN_URL = "open_url";
    public static final int MAX_PACKAGE_DOWNLOAD_PRIORITY = 5;
    public static final String MIME_APK = "application/vnd.android.package-archive";
    public static final String MIUI_MARKET_DM_STATUS = "com.xiaomi.market.DIRECT_MAIL_STATUS";
    public static final int ORDER_DOWNLOADER_SCENE = 1;
    public static final int ORDER_URL_EMPTY = 1;
    public static final int RECOMMEND_EVENT_EXTRA_VALUE = 3;
    public static final String RECORD_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    public static final int SEND_INSTALL_FINISH_BY_DOWNLOADER_POLLING_THREAD = 1;
    public static final int SEND_INSTALL_FINISH_BY_MIUI_MARKET_BROADCAST = 4;
    public static final int SEND_INSTALL_FINISH_BY_REBOOT_BACKUP = 3;
    public static final int SEND_INSTALL_FINISH_BY_TTDOWNLOADER_POLLING_THREAD = 2;
    public static final int STATUS_DOWNLOAD_FINISH = 2;
    public static final int STATUS_START_DOWNLOAD = 1;
    public static final String TTDOWNLOADER_SDK_NAME = "download_ad";
    public static final String TT_DOWNLOAD_CENTER_REFER = "download_center";
    public static final int TYPE_GAME = 2;
    public static final int TYPE_RECOMMEND_DOWNLOAD_MODEL = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AddClickIdSource {
        public static final int ADD_CLICK_ID_APP_OPEN = 1;
        public static final int ADD_CLICK_ID_URL_OPEN = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppLinkBusinessScene {
        public static final int AD_COMPLIANCE_APPLINK = 5;
        public static final int AD_OUT_WEB_APPLINK = 6;
        public static final int AUTO_DEEPLINK_APPLINK = 4;
        public static final int MARKET_DIALOG_APPLINK = 3;
        public static final int NORMAL_CLICK_APPLINK = 1;
        public static final int NOTIFICATION_APPLINK = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppLinkLinkActionConfigScene {
        public static final int JUMP_BACKGROUND_OPEN = 2;
        public static final int JUMP_MARKET = 1;
        public static final int JUMP_URL_OPEN = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppLinkSceneConstants {
        public static final int KEY_DEEPLINK_APPLINK_OPEN = 2;
        public static final int KEY_PACKAGE_APPLINK_OPEN = 1;
    }

    public @interface CallScene {
        public static final int ANCHNOR = 4;
        public static final int BUSINESS = 3;
        public static final int DEFAULT = 0;
        public static final int DOUYIN_MINI_PROGRAM = 11;
        public static final int DOWNLOAD_APP_LIST = 9;
        public static final int DOWNLOAD_MANAGEMENT_CENTER = 10;
        public static final int GAME_STATION = 8;
        public static final int LIVE = 1;
        public static final int ONE_PAGE = 2;
        public static final int ORDER_DOWNLOAD = 1000;
        public static final int ORDER_DOWNLOAD_DIRECT = 1001;
        public static final int SCENE_GAME_ADVERT = 6;
        public static final int SCENE_SEARCH = 7;
        public static final int SMALL_VIDEO = 5;
        public static final int UNKNOWN_SPECIAL_FOR_LANDING_PAGE = 100;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClickIdContentProviderClearCode {
        public static final int DELETE_FAILED = 3;
        public static final int MEET_EXCEPTION = 4;
        public static final int NO_EXPIRED_RECORD_FOUND = 2;
        public static final int NO_RECORD_EXISTED = 1;
        public static final int SUCCESS_CODE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClickIdContentProviderCode {
        public static final int DO_INSERT_ERROR = 5;
        public static final int EMPTY_TARGET_PACKAGE_NAME = 4;
        public static final int HAS_FINISH_INSERT = 6;
        public static final int NO_CLICK_ID_FROM_LOG_EXTRA = 3;
        public static final int NO_DOWNLOAD_MODEL = 1;
        public static final int SETTING_NOT_OPEN = 2;
        public static final int SUCCESS_CODE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClickIdSource {
        public static final int FROM_EXTRA = 2;
        public static final int FROM_LOG_EXTRA = 1;
    }

    public @interface ComplianceDialogDownloadStatus {
        public static final int DIALOG_CLICK_DOWNLOAD_CONTINUE = 3;
        public static final int DIALOG_CLICK_DOWNLOAD_INSTALL = 4;
        public static final int DIALOG_CLICK_DOWNLOAD_PAUSED = 2;
        public static final int DIALOG_CLICK_DOWNLOAD_START = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadAdMonitorScene {
        public static final String AD_SEGMENT_DOWNLOAD_MONITOR_SCENE = "ad_segment_download";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadAdRuntimeAbilityControlKey {
        public static final String ENABLE_INNER_DEFAULT_IMPL = "enable_inner_default_impl";
        public static final String ENABLE_RUNTIME = "enable_runtime";
        public static final String ENABLE_RUNTIME_DIALOG = "enable_runtime_dialog";
        public static final String ENABLE_RUNTIME_FOR_AD_EVENT = "enable_runtime_for_ad_event";
        public static final String ENABLE_RUNTIME_FOR_USER_EVENT = "enable_runtime_for_user_event";
        public static final String ENABLE_RUNTIME_OPT_NETWORK_EXECUTE = "enable_runtime_opt_network_execute";
        public static final String ENABLE_RUNTIME_TOAST = "enable_runtime_toast";
        public static final String ENABLE_SEND_ALOG = "enable_send_alog";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadAdRuntimeDependKey {
        public static final String AD_RUNTIME_ABILITY_ALOG = "adLog";
        public static final String AD_RUNTIME_ABILITY_CHECKER = "adChecker";
        public static final String AD_RUNTIME_ABILITY_EVENT = "adEvent";
        public static final String AD_RUNTIME_ABILITY_IMAGE = "adImage";
        public static final String AD_RUNTIME_ABILITY_NETWORK = "adNetwork";
        public static final String AD_RUNTIME_ABILITY_PERMISSION = "adPermission";
        public static final String AD_RUNTIME_ABILITY_SDK_MONITOR = "adSdkMonitor";
        public static final String AD_RUNTIME_ABILITY_SETTINGS = "adSettings";
        public static final String AD_RUNTIME_ABILITY_UI_STYLE = "adUiStyle";
        public static final String AD_RUNTIME_ABILITY_USER_INFO = "adUserInfo";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadBPEACertSource {
        public static final int BPEA_CERT_SOURCE_AMPLANS = 3;
        public static final int BPEA_CERT_SOURCE_APPLINK = 1;
        public static final int BPEA_CERT_SOURCE_MARKET = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadBPEACertToken {
        public static final String DOWNLOAD_BPEA_CERT_AMPLANS = "bpea-ad_download_amplans";
        public static final String DOWNLOAD_BPEA_CERT_APPLINK = "bpea-ad_download_applink";
        public static final String DOWNLOAD_BPEA_CERT_MARKET = "bpea-ad_download_market";
    }

    public @interface DownloadConfigureName {
        public static final String AD = "ad";
        public static final String PANGOLIN = "pangolin";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadEventModelConstants {
        public static final String CATEGORY = "category";
        public static final String EXT_VALUE = "ext_value";
        public static final String REFER = "refer";
        public static final String TAG = "tag";
        public static final String VALUE = "value";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadExtraInfoKey {
        public static final String EXTRA_APPLINK_INTERCEPT_RESULT_CODE = "applink_intercept_result_code";
        public static final String EXTRA_MARKET_JUMP_ROLLBACK_ROLLING_PAGE_RESULT = "market_jump_rollback_rolling_page_result";
        public static final String EXTRA_MARKET_OFF_SHELF_SIGH = "market_off_shelf_sign";
        public static final String EXTRA_QUICK_APP_APPLINK_FAILED_SIGN = "quick_app_applink_failed_sign";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadExtraKeys {
        public static final String LANDING_PAGE_USE_EXISTED_MODEL = "landing_page_use_existed_model";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadManagementTab {
        public static final int DOWNLOADING_TAB = 2;
        public static final int DOWNLOADING_TAB_LIMITED = 1;
        public static final int DOWNLOAD_FINISH_TAB = 3;
        public static final int INSTALLED_TAB = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadManualActionCode {
        public static final int IS_MANUAL_ACTION = 1;
        public static final int NOT_MANUAL_ACTION = 0;
        public static final int NO_MANUAL_ACTION_CODE = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadMode {
        public static final int DOWNLOAD = 0;
        public static final int DOWNLOAD_AND_JUMP = 1;
        public static final int OPEN_MARKET_WITH_CLICK_ALL = 3;
        public static final int OPEN_MARKET_WITH_CLICK_BTN = 2;
        public static final int OPEN_WEB = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadReverseExperimentTag {
        public static final String AD_CHECK_INSTALL_CANCELED_EXPERIMENT = "check_install_canceled_enable";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadScene {
        public static final int DETAIL = 1;
        public static final int NORMAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadStoreCode {
        public static final int MARKET_TYPE_HUAWEI = 3;
        public static final int MARKET_TYPE_OPPO = 1;
        public static final int MARKET_TYPE_VIVO = 2;
        public static final int MARKET_TYPE_XIAOMI = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExternalAction {
        public static final int ORDER_DOWNLOAD = 173;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FirstHalfProgressOptFormulaType {
        public static final int FIRST_HALF_FORMULA_LOG_CALCULATION = 2;
        public static final int FIRST_HALF_FORMULA_SQRT_CALCULATION = 1;
    }

    public @interface FunnelType {
        public static final int APP_LINK = 4;
        public static final int DOWNLOAD = 1;
        public static final int MARKET = 2;
        public static final int OPEN_WEB = 5;
        public static final int QUICK_APP = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GenerateInstallFinishHijackParamScene {
        public static final int FROM_INSTALL_CORRECT = 1;
        public static final int FROM_INSTALL_FINISH_HIJACK = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GetClickIdNatureResult {
        public static final int RESULT_NO_CLICK_ID_NATURE_IN_EXTRA = 3;
        public static final int RESULT_NO_EXTRA = 2;
        public static final int RESULT_SUCCESS = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GetClickIdResult {
        public static final int RESULT_NO_CLICK_ID_IN_LOG_EXTRA = 3;
        public static final int RESULT_NO_LOG_EXTRA = 2;
        public static final int RESULT_SUCCESS = 1;
    }

    public @interface InfoErrorCode {
        public static final String WEB_URL_NULL = "001";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InnerAppLinkFailedReason {
        public static final int INNER_APPLINK_FAILED_EMPTY_RESOLVE_INFO = 5001;
        public static final int INNER_APPLINK_FAILED_EXCEPTION = 5000;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InsertAppendInfoInApkFailCode {
        public static final int FAIL_DOWNLOAD_INFO_NULL = 1;
        public static final int FAIL_GET_APPEND_INFO_ERROR = 5;
        public static final int FAIL_GET_APPEND_INFO_PAIR = 7;
        public static final int FAIL_GET_OFFSET_VALUE_ERROR = 4;
        public static final int FAIL_INSERT_INFO_IN_APK_EXCEPTION = 6;
        public static final int FAIL_NATiVE_DOWNLOAD_MODEL_NULL = 2;
        public static final int FAIL_NO_APK_TARGET_FILEPATH = 8;
        public static final int FAIL_NO_REDIRECT_PARTIAL_URL = 3;
        public static final int SUCCESS_INSERT_APPEND = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallFinishCheckSource {
        public static final int CHECK_FOR_MARKET_DOWNLOAD = 2;
        public static final int CHECK_FOR_PACKAGE_DOWNLOAD = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallJumpSource {
        public static final int INSTALL_AUTO_JUMP = 1;
        public static final int INSTALL_MANUAL_JUMP = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface JumpBridgeActivityApplinkOptScene {
        public static final int OPEN_BY_OPENURL_SCENE = 2;
        public static final int OPEN_BY_PACKAGE_SCENE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface JumpMarketSource {
        public static final int LANDING_PAGE_SCENE = 2;
        public static final int NORMAL_SCENE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkMode {
        public static final int ENABLE_AUTO_OPEN = 1;
        public static final int ENABLE_AUTO_OPEN2 = 2;
        public static final int NORMAL_AND_DEEP = 0;
    }

    public @interface ListenerMoveResult {
        public static final int MOVE = 1;
        public static final int NO_MOVE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MarketInstallFailedSource {
        public static final int FROM_BROADCAST = 1;
        public static final int FROM_FIRST_ROUND_THREAD = 2;
        public static final int FROM_SECOND_ROUND_THREAD = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MarketInstallFinishOptSource {
        public static final int MIUI_BROADCAST = 5;
        public static final int NORMAL_BROADCAST = 1;
        public static final int NORMAL_THREAD_POLLING = 2;
        public static final int REBOOT_BROADCAST = 3;
        public static final int REBOOT_INSTALL_CHECKED = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MarketOpenScene {
        public static final int HW_MARKET_PAGE_OPT_1 = 4;
        public static final int MEIZU_MARKET_AUTO_DOWNLOAD = 2;
        public static final int MIUI_MARKET_2_ADAPTATION = 5;
        public static final int NORMAL_OPEN_MARKET = 1;
        public static final int VIVO_MARKET_PAGE_OPT_1 = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MiuiMarketListenerOptExtra {
        public static final String MIUI_BROADCAST_PACKAGE_NAME = "packageName";
        public static final String MIUI_BROADCAST_STATUS_CODE = "statusCode";
        public static final String MIUI_CONTENT_PROVIDER_PROGRESS = "progress";
        public static final String MIUI_CONTENT_PROVIDER_STATUS = "status";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MiuiMarketStatusCode {
        public static final int MARKET_CTA_CHECK_FAILED = 1001;
        public static final int MARKET_DEEPLINK_SUCCESS_IN_DETAIL_PAGE = 5001;
        public static final int MARKET_DOWNLOADING = 3003;
        public static final int MARKET_DOWNLOAD_FINISH = 3002;
        public static final int MARKET_DOWNLOAD_NOT_START = 3000;
        public static final int MARKET_DOWNLOAD_START = 3001;
        public static final int MARKET_INSTALL_FINISH = 3008;
        public static final int MARKET_INTERFACE_QUERY_FAILED = 1004;
        public static final int MARKET_START_INSTALL = 3007;
        public static final int MARLET_PERMISSION_CHECK_FAILED = 1005;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MiuiNewMarketResult {
        public static final int REAL_OPEN_MARKET_SUCCESS = 1;
        public static final int ROLL_BACK_DOWNLOAD = 3;
        public static final int ROLL_BACK_WEB = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MiuiNewMarketResultForWeb {
        public static final int REAL_OPEN_MARKET_SUCCESS_WEB = 1;
        public static final int ROLL_BACK_DIALOG_WEB = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModelType {
        public static final int AD = 0;
        public static final int BROWSER = 3;
        public static final int GAME = 2;
        public static final int RECOMMEND_AD = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoAppLinkInterceptCode {
        public static final int APPLINK_INSTALL_APP_FAILED = 4;
        public static final int DOWNGRADE_TO_PACKAGE_DOWNLOAD = 3;
        public static final int DO_NOT_HANDLE_INTERCEPT_RESULT = -1;
        public static final int JUMP_ROLLBACK_LANDING_PAGE = 2;
        public static final int NORMAL_DO_INTERCEPT = 0;
        public static final int NORMAL_PACKAGE_DOWNLOAD = 1;
        public static final int QUICK_APP_APPLINK_FAILED = 5;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpenAppScene {
        public static final int APP_LINK = 0;
        public static final int INSTALLER = 1;
        public static final int MARKET = 2;
        public static final int QUICK_APP = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderDownloadMessageRetainCheckScene {
        public static final int ALIVE = 1;
        public static final int REBOOT_AFTER_CHECK_TIME = 3;
        public static final int REBOOT_BEFORE_CHECK_TIME = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderDownloadMessageRetainCode {
        public static final int CHECK_APP_INSTALLED = 3;
        public static final int INVALID_CHECK_TIME = 4;
        public static final int NO_DOWNLOAD_MODEL_OR_INFO = 1;
        public static final int REQUEST_MESSAGE_SERVICE_ERROR = 2;
        public static final int SUCCESS_CODE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderDownloadPushRetainCode {
        public static final int HAS_SHOW_PUSH_TODAY = 3;
        public static final int NO_DOWNLOAD_MODEL_OR_INFO = 1;
        public static final int NO_INSERT_PUSH_ABILITY = 4;
        public static final int PUSH_TIME_INVALID = 5;
        public static final int SETTING_NOT_OPEN = 2;
        public static final int SUCCESS_CODE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressOptFormulaType {
        public static final int FORMULA_LAMBER_CALCULATION = 3;
        public static final int FORMULA_LOG_CALCULATION = 2;
        public static final int FORMULA_PIECEWISE_FUNCTION_CALCULATION = 4;
        public static final int FORMULA_SQRT_CALCULATION = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RandomClickStartPercentStrategy {
        public static final int STRATEGY_RANGE_2_TO_4 = 1;
        public static final int STRATEGY_RANGE_3_TO_6 = 2;
        public static final int STRATEGY_RANGE_4_TO_8 = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordDate {
        public static final int DOWNLOAD_FINISH = 2;
        public static final int DOWNLOAD_PAUSE = 4;
        public static final int DOWNLOAD_START = 1;
        public static final int INSTALLED = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestDownloadComplianceCustomScene {
        public static final int DOWNLOAD_HW_MARKET_OPT = 2;
        public static final int DOWNLOAD_MIUI_NEW_MARKET = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondHalfProgressOptFormulaPower {
        public static final double SECOND_HALF_FORMULA_PROPERTY_1 = 3.0d;
        public static final double SECOND_HALF_FORMULA_PROPERTY_2 = 4.0d;
        public static final double SECOND_HALF_FORMULA_PROPERTY_3 = 5.0d;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondHalfProgressOptFormulaProperty {
        public static final double SECOND_HALF_FORMULA_PROPERTY_1 = 4.0E-4d;
        public static final double SECOND_HALF_FORMULA_PROPERTY_2 = 8.0E-6d;
        public static final double SECOND_HALF_FORMULA_PROPERTY_3 = 1.6E-7d;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondHalfProgressOptFormulaType {
        public static final int SECOND_HALF_FORMULA_TYPE_1 = 1;
        public static final int SECOND_HALF_FORMULA_TYPE_2 = 2;
        public static final int SECOND_HALF_FORMULA_TYPE_3 = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SendEventInterceptCode {
        public static final int NO_WIFI_CLICK_START_INTERCEPT = 2;
        public static final int NO_WIFI_DOWNLOAD_FAILED_INTERCEPT = 1;
        public static final int REAL_START_DOWNLOAD_FOR_NO_WIFI = 3;
    }

    public @interface ShowComplianceDialogScene {
        public static final int NORMAL_SHOW_DIALOG_IN_FEED = 1;
        public static final int NO_DIALOG_IN_FEED = 0;
        public static final int SPECIAL_SHOW_DIALOG_IN_FEED = 2;
    }

    public @interface SlardarMonitorUrls {
        public static final List<String> SLARDAR_DEFAULT_CONFIG_URLS = null;
        public static final List<String> SLARDAR_DEFAULT_REPORT_URLS = null;

        static {
            SLARDAR_DEFAULT_CONFIG_URLS = Arrays.asList(new String[]{"https://mon.snssdk.com/monitor/appmonitor/v2/settings", "https://monsetting.toutiao.com/monitor/appmonitor/v2/settings"});
            SLARDAR_DEFAULT_REPORT_URLS = Arrays.asList(new String[]{ReportConstant.DEFAULT_URL_REPORT, "https://mon.toutiao.com/monitor/collect/", "https://mon.toutiaocloud.com/monitor/collect/", "https://mon.toutiaocloud.net/monitor/collect/"});
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpecialApplinkOptScene {
        public static final int NEW_INNER_PACKAGE_OPEN = 5;
        public static final int NEW_INNER_URL_OPEN = 6;
        public static final int NEW_OUTSIDE_PACKAGE_OPEN = 9;
        public static final int NEW_OUTSIDE_URL_OPEN = 10;
        public static final int OLD_INNER_BACKGROUND_PACKAGE_OPEN = 3;
        public static final int OLD_INNER_BACKGROUND_URL_OPEN = 4;
        public static final int OLD_INNER_PACKAGE_OPEN = 1;
        public static final int OLD_INNER_URL_OPEN = 2;
        public static final int OLD_OUTSIDE_PACKAGE_OPEN = 7;
        public static final int OLD_OUTSIDE_URL_OPEN = 8;
    }

    static {
        DEFAULT_CONCURRENT_COUNT = Runtime.getRuntime().availableProcessors() + 1;
    }
}
