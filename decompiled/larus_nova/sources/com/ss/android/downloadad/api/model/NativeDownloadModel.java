package com.ss.android.downloadad.api.model;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ComplianceDataItem;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.utils.ToolUtils;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class NativeDownloadModel {
    private long availableSpaceBytes;
    private AdDownloadController downloadController;
    private AdDownloadEventConfig downloadEventConfig;
    private AdDownloadModel downloadModel;
    private int funnelType;
    public final AtomicBoolean hasDoRandomClickStartPercent;
    public final AtomicBoolean hasDoRebootMarketInstallFinishCheck;
    public final AtomicBoolean hasDoingInstallFinishEvent;
    public final AtomicBoolean hasInsertAppendInfoInApk;
    public final AtomicBoolean hasInterceptClickStartByNoWifi;
    public final AtomicBoolean hasRealStartDownload;
    public final AtomicBoolean hasSendDownloadFailedFinally;
    public final AtomicBoolean hasSendInstallCorrect;
    public final AtomicBoolean hasSendInstallFinish;
    public final AtomicBoolean hasSendInstallFinishHijack;
    public final AtomicBoolean hasSendInstallFinishHijackInInstallCorrect;
    private boolean isCheckMarketSign;
    private transient boolean isCheckingOrderMessageRetain;
    private transient boolean isCheckingUnFinishedRetain;
    private transient boolean isCheckingUnInstalledRetain;
    private int mApplinkEventSendCount;
    private String mBeforeInstallFailedCodes;
    private JSONObject mCancelDownloadExtraJson;
    private boolean mCheckingMarketDownloadPushRetain;
    private long mClickDownloadSize;
    private long mClickDownloadTime;
    private int mClickPauseTimes;
    private boolean mDeeplinkAfterBackApp;
    private int mDownloadFailedSendCount;
    private int mDownloadFailedTimes;
    private String mDownloadFinishReason;
    private long mDownloadFinishTimeStamp;
    private int mDownloadId;
    private long mDownloadPauseTimeStamp;
    private int mDownloadStatus;
    private boolean mEnableAppLinkSdk;
    private boolean mEnableDownloadProcessChainOpt;
    private boolean mEnablePause;
    private boolean mEnableSegmentDownload;
    private long mFirstJumpInstallTime;
    private long mFirstMarketOpenSuccessTimestamp;
    private boolean mHandleNoEnoughSpaceDownload;
    private boolean mHandleNoEnoughSpaceInstall;
    private int mHasShowPauseOptimiseDialogCount;
    private boolean mInstallAfterBackApp;
    private boolean mInstallAfterCleanSpace;
    private long mInstallCorrectTimeStamp;
    private int mInstallFailedSendCount;
    public JSONObject mInstallFinishHijackAppData;
    private int mIsActionManually;
    private boolean mIsCleanSpaceBeforeDownload;
    private boolean mIsDisableShowDialog;
    private boolean mIsForceCancelDownload;
    private boolean mIsFromGameUnionLive;
    private transient boolean mIsListeningInstallCorrect;
    private transient boolean mIsListeningInstallFinish;
    private boolean mIsManualPaused;
    private boolean mIsManualUnInstalled;
    private boolean mIsPackageDownloadFromRollback;
    private boolean mIsShowApkSizeRetain;
    private boolean mIsShowAppDialog;
    private boolean mIsShowCancelApkSizeRetain;
    private boolean mIsShowDownloadPercentRetain;
    private boolean mIsUpdateDownload;
    private int mJumpInstallCount;
    private long mJumpInstallTime;
    private boolean mJumpRollbackLandingPageResult;
    private int mLastFailedErrCode;
    private String mLastFailedErrMsg;
    private int mLastFailedResumeCount;
    private boolean mMarketDownloadOffShelf;
    private int mMarketEventSendCount;
    private int mMarketInstallFinishCheckRounds;
    private long mMarketInstallFinishCheckTimeStamp;
    private int mPackageDownloadRollbackScene;
    private int mRandomClickStartPercent;
    private long mRecentDownloadResumeTime;
    private int mSendInstallFinishWay;
    private long mShowMarketDownloadPushTimestamp;
    private long mStartInstallFinishLoopTimeStamp;
    private long mTimeStamp;
    private long mUnFinishedPushRetainTimeStamp;
    private long mUnInstalledOrderDownloadMessageRetainTimeStamp;
    private long mUnInstalledOrderDownloadPushRetainTimeStamp;
    private long mUnInstalledPushRetainTimeStamp;
    public final AtomicBoolean needGenerateInstallFinishHijack;
    private int scene;

    public interface JsonKey {
        public static final String AD_DOWNLOAD_CONTROLLER = "ad_download_controller";
        public static final String AD_DOWNLOAD_EVENT_CONFIG = "ad_download_event_config";
        public static final String AD_DOWNLOAD_MODEL = "ad_download_model";
        public static final String APPLINK_EVENT_SEND_COUNT = "applink_event_send_count";
        public static final String APP_ICON = "mAppIcon";
        public static final String APP_NAME = "mAppName";
        public static final String APP_PKG_INFO = "app_pkg_info";
        public static final String AUTO_DOWNLOAD_ON_CARD_SHOW = "isAutoDownloadOnCardShow";
        public static final String BEFORE_INSTALL_FAILED_CODE = "mBeforeInstallFailedCodes";
        public static final String CALL_SCENE = "call_scene";
        public static final String CANCEL_DOWNLOAD_EXTRA_JSON = "cancel_download_extra_json";
        public static final String CHECKING_MARKET_DOWNLOAD_PUSH_RETAIN = "checking_market_download_push_retain";
        public static final String CLICK_DOWNLOAD_SIZE = "clickDownloadSize";
        public static final String CLICK_DOWNLOAD_TIME = "clickDownloadTime";
        public static final String CLICK_PAUSE_TIMES = "mClickPauseTimes";
        public static final String COMPLIANCE_DATA = "compliance_data";
        public static final String DISTINCT_DIRECTORY = "distinct_directory";
        public static final String DOWNLOAD_FAILED_SEND_COUNT = "download_failed_send_count";
        public static final String DOWNLOAD_FAILED_TIMES = "mDownloadFailedTimes";
        public static final String DOWNLOAD_FINISH_DATE = "download_finish_date";
        public static final String DOWNLOAD_FINISH_REASON = "downloadFinishReason";
        public static final String DOWNLOAD_FINISH_TIMESTAMP = "download_finish_timestamp";
        public static final String DOWNLOAD_HANDLER_TASKKEY = "download_handler_taskkey";
        public static final String DOWNLOAD_ID = "mDownloadId";
        public static final String DOWNLOAD_MODE = "mDownloadMode";
        public static final String DOWNLOAD_PAUSE_TIMESTAMP = "download_pause_timestamp";
        public static final String DOWNLOAD_SCENE = "mDownloadScene";
        public static final String DOWNLOAD_SETTINGS = "mDownloadSettings";
        public static final String DOWNLOAD_START_DATE = "download_start_date";
        public static final String DOWNLOAD_STATUS = "mDownloadStatus";
        public static final String DOWNLOAD_URL = "mDownloadUrl";
        public static final String ENABLE_AH = "enable_ah";
        public static final String ENABLE_AM = "enable_am";
        public static final String ENABLE_APPLINK_SDK = "enable_applink_sdk";
        public static final String ENABLE_BACK_DIALOG = "mEnableBackDialog";
        public static final String ENABLE_CLICK_START_OPT_FOR_GAME_UNION = "enable_click_start_opt_for_game_union";
        public static final String ENABLE_COMPLIANCE_DIALOG = "enableShowComplianceDialog";
        public static final String ENABLE_DOWNLOAD_HANDLER_TASKKEY = "enable_download_handler_taskkey";
        public static final String ENABLE_DOWNLOAD_PROCESS_CHAIN_OPT = "enable_download_process_chain_opt";
        public static final String ENABLE_NEW_ACTIVITY = "enable_new_activity";
        public static final String ENABLE_PAUSE = "enable_pause";
        public static final String ENABLE_SEGMENT_DOWNLOAD = "enable_segment_download";
        public static final String EVENT_EXTRA = "mEventExtra";
        public static final String EVENT_REFER = "mEventRefer";
        public static final String EVENT_TAG = "mEventTag";
        public static final String EXTRA = "mExtras";
        public static final String EXTRA_EVENT_OBJECT = "mExtraEventObject";
        public static final String EXT_VALUE = "mExtValue";
        public static final String FILE_PATH = "file_path";
        public static final String FIRST_JUMP_INSTALL_TIME = "mFirstJumpInstallTime";
        public static final String FIRST_MARKET_OPEN_SUCCESS_TIMESTAMP = "first_market_open_success_timestamp";
        public static final String FUNNEL_TYPE = "funnelType";
        public static final String HAS_DOING_INSTALL_FINISH_EVENT = "hasDoingInstallFinishEvent";
        public static final String HAS_DO_RANDOM_CLICK_START_PERCENT = "has_do_random_click_start_percent";
        public static final String HAS_DO_REBOOT_MARKET_INSTALL_FINISH_CHECK = "hasDoRebootMarketInstallFinishCheck";
        public static final String HAS_INSERT_APPEND_INFO_IN_APK = "has_insert_append_info_in_apk";
        public static final String HAS_INTERCEPT_CLICK_START_BY_NO_WIFI = "has_intercept_click_start_by_no_wifi";
        public static final String HAS_REAL_START_DOWNLOAD = "has_real_start_download";
        public static final String HAS_SEND_DOWNLOAD_FAILED_FINALLY = "hasSendDownloadFailedFinally";
        public static final String HAS_SEND_INSTALL_FINISH = "hasSendInstallFinish";
        public static final String HAS_SEND_INSTALL_FINISH_CORRECT = "has_send_install_finish_correct";
        public static final String HAS_SEND_INSTALL_FINISH_HIJACK = "has_send_install_finish_hijack";
        public static final String HAS_SEND_INSTALL_FINISH_HIJACK_IN_INSTALL_CORRECT = "has_send_install_finish_correct_in_install_correct";
        public static final String HAS_SHOWN_PKG_INFO = "has_shown_pkg_info";
        public static final String ID = "mId";
        public static final String IGNORE_INTERCEPT = "mIgnoreIntercept";
        public static final String INSTALLED_DATE = "installed_date";
        public static final String INSTALL_AFTER_CLEAN = "installAfterCleanSpace";
        public static final String INSTALL_CORRECT_TIMESTAMP = "install_correct_timestamp";
        public static final String INSTALL_FAILED_SEND_COUNT = "install_failed_send_count";
        public static final String INSTALL_FINISH_HIJACK_APP_DATA = "install_finish_hijack_app_data";
        public static final String INTENT_JUMP_BROWSWE_SUCCESS = "intent_jump_browser_success";
        public static final String IS_ACTION_MANUALLY = "is_action_manually";
        public static final String IS_AD = "mIsAd";
        public static final String IS_FORCE_CANCEL_DOWNLOAD = "is_force_cancel_download";
        public static final String IS_FROM_DOWNLOAD_MANAGEMENT = "is_from_download_management";
        public static final String IS_FROM_GAME_UNION_LIVE = "is_from_game_union_live";
        public static final String IS_LISTENING_INSTALL_FINISH = "is_listening_install_finish";
        public static final String IS_MANUAL_PAUSED = "is_manual_paused";
        public static final String IS_MANUAL_UNINSTALLED = "is_manualy_uninstalled";
        public static final String IS_ORDER_DOWNLOAD = "is_order_download";
        public static final String IS_PACKAGE_DOWNLOAD_FROM_ROLLBACK = "package_download_from_rollback";
        public static final String IS_UPDATE_DOWNLOAD = "mIsUpdateDownload";
        public static final String IS_V3_EVENT = "mIsV3Event";
        public static final String JUMP_INSTALL_COUNT = "jump_install_count";
        public static final String JUMP_INSTALL_TIME = "mJumpInstallTime";
        public static final String JUMP_ROLLBACK_LANDING_PAGE_RESULT = "jump_rollback_landing_page_result";
        public static final String LAST_FAILED_CODE = "mLastFailedErrCode";
        public static final String LAST_FAILED_MSG = "mLastFailedErrMsg";
        public static final String LAST_FAILED_RESUME_COUNT = "mLastFailedResumeCount";
        public static final String LINK_MODE = "mLinkMode";
        public static final String LOG_EXTRA = "mLogExtra";
        public static final String MARKET_DOWNLOAD_OFF_SHELF = "market_download_off_shelf";
        public static final String MARKET_EVENT_SEND_COUNT = "market_event_send_count";
        public static final String MARKET_INSTALL_FINISH_CHECK_ROUNDS = "market_install_finish_check_rounds";
        public static final String MARKET_INSTALL_FINISH_CHECK_START_TIMESTAMP = "market_install_finish_check_start_timestamp";
        public static final String MIME_TYPE = "mOriginMimeType";
        public static final String MODEL_TYPE = "mModelType";
        public static final String NATIVE_DOWNLOAD_MODEL_V2 = "native_download_model_v2";
        public static final String NEED_GENERATE_INSTALL_FINISH_HIJACK_PARAM = "need_generate_install_finish_hijack_param";
        public static final String OPEN_URL = "mOpenUrl";
        public static final String ORDER_ID = "order_id";
        public static final String PACKAGE_DOWNLOAD_ROLLBACK_SCENE = "package_download_rollback_scene";
        public static final String PACKAGE_NAME = "mPackageName";
        public static final String PARAMS_JSON = "mParamsJson";
        public static final String RANDOM_CLICK_START_PERCENT = "random_click_start_percent";
        public static final String RECENT_DOWNLOAD_RESUME_TIME = "mRecentDownloadResumeTime";
        public static final String SCENE = "mScene";
        public static final String SEND_INSTALL_FINISH_WAY = "mSendInstallFinishWay";
        public static final String SHOW_MARKET_DOWNLOAD_PUSH_TIMESTAMP = "show_market_download_push_timestamp";
        public static final String TASKKEY_OBJECT = "taskkey_object";
        public static final String TIME_STAMP = "mTimeStamp";
        public static final String UNFINISHED_PUSH_RETAIN_TIMESTAMP = "unfinished_push_retain_timestamp";
        public static final String UNINSTALLED_ORDER_DOWNLOAD_MESSAGE_RETAIN_TIMESTAMP = "uninstalled_order_download_message_retain_timestamp";
        public static final String UNINSTALLED_ORDER_DOWNLOAD_PUSH_RETAIN_TIMESTAMP = "uninstalled_order_download_push_retain_timestamp";
        public static final String UNINSTALLED_PUSH_RETAIN_TIMESTAMP = "uninstalled_push_retain_timestamp";
        public static final String VERSION_CODE = "mVersionCode";
        public static final String VERSION_NAME = "mVersionName";
        public static final String WEB_URL = "webUrl";
    }

    public synchronized void increaseClickPauseTimes() {
        monitor-enter(this);
        this.mClickPauseTimes++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void increaseDownloadFailedTimes() {
        monitor-enter(this);
        this.mDownloadFailedTimes++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean enableBackDialog() {
        return this.downloadController.isEnableBackDialog();
    }

    public boolean enableNewActivity() {
        return this.downloadController.enableNewActivity();
    }

    public boolean enableShowComplianceDialog() {
        return this.downloadController.enableShowComplianceDialog();
    }

    public int geModelType() {
        return this.downloadModel.getModelType();
    }

    public String getAppIcon() {
        return this.downloadModel.getAppIcon();
    }

    public String getAppName() {
        return this.downloadModel.getName();
    }

    public JSONObject getAppPkgInfo() {
        return this.downloadEventConfig.getAppPkgInfo();
    }

    public int getCallScene() {
        return this.downloadModel.getCallScene();
    }

    public List<String> getClickTrackUrl() {
        return this.downloadModel.getClickTrackUrl();
    }

    public ComplianceDataItem getComplianceItem() {
        return new ComplianceDataItem(this.downloadModel.getComplianceData());
    }

    public long getDownloadFinishDate() {
        return this.downloadModel.getDownloadFinishDate();
    }

    public String getDownloadHandlerTaskKey() {
        return this.downloadModel.getDownloadHandlerTaskKey();
    }

    public int getDownloadMode() {
        return this.downloadController.getDownloadMode();
    }

    public int getDownloadScene() {
        return this.downloadEventConfig.getDownloadScene();
    }

    public JSONObject getDownloadSettings() {
        return this.downloadModel.getDownloadSettings();
    }

    public long getDownloadStartDate() {
        return this.downloadModel.getDownloadStartDate();
    }

    public String getDownloadUrl() {
        return this.downloadModel.getDownloadUrl();
    }

    public JSONObject getEventExtra() {
        return this.downloadEventConfig.getExtraJson();
    }

    public String getEventRefer() {
        return this.downloadEventConfig.getRefer();
    }

    public String getEventTag() {
        return this.downloadEventConfig.getClickButtonTag();
    }

    public long getExtValue() {
        return this.downloadModel.getExtraValue();
    }

    public JSONObject getExtra() {
        return this.downloadModel.getExtra();
    }

    public Object getExtraEventObject() {
        return this.downloadEventConfig.getExtraEventObject();
    }

    public String getFilePath() {
        return this.downloadModel.getFilePath();
    }

    public int getFunnelType() {
        return this.downloadModel.getFunnelType();
    }

    public long getId() {
        return this.downloadModel.getId();
    }

    public boolean getIgnoreIntercept() {
        return this.downloadModel.ignoreIntercept();
    }

    public long getInstalledDate() {
        return this.downloadModel.getInstalledDate();
    }

    public boolean getIsFromDownloadManagement() {
        return this.downloadModel.isFromDownloadManagement();
    }

    public int getIsOrderDownload() {
        return this.downloadModel.getIsOrderDownload();
    }

    public int getLinkMode() {
        return this.downloadController.getLinkMode();
    }

    public String getLogExtra() {
        return this.downloadModel.getLogExtra();
    }

    public String getMimeType() {
        return this.downloadModel.getMimeType();
    }

    public String getOpenUrl() {
        DeepLink r100 = this.downloadModel.getDeepLink();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOpenUrl();
    }

    public String getOrderId() {
        return this.downloadModel.getOrderId();
    }

    public String getPackageName() {
        return this.downloadModel.getPackageName();
    }

    public JSONObject getParamsJson() {
        return this.downloadEventConfig.getParamsJson();
    }

    public long getRecentDownloadResumeTime() {
        long r100 = this.mRecentDownloadResumeTime;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.mTimeStamp;
    }

    public JSONObject getTaskKeyObject() {
        return this.downloadModel.getTaskKeyObject();
    }

    public int getVersionCode() {
        return this.downloadModel.getVersionCode();
    }

    public String getVersionName() {
        return this.downloadModel.getVersionName();
    }

    public String getWebUrl() {
        DeepLink r100 = this.downloadModel.getDeepLink();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getWebUrl();
    }

    public boolean hasShowPkgInfo() {
        return this.downloadEventConfig.hasShowPkgInfo();
    }

    public boolean isAd() {
        return this.downloadModel.isAd();
    }

    public boolean isAutoDownloadOnCardShow() {
        return this.downloadController.isAutoDownloadOnCardShow();
    }

    public boolean isDistinctDirectory() {
        return this.downloadModel.distinctDir();
    }

    public boolean isEnableClickStartOptForGameUnion() {
        return this.downloadController.isEnableClickStartOptForGameUnion();
    }

    public boolean isEnableDownloadHandlerTaskKey() {
        return this.downloadController.isEnableDownloadHandlerTaskKey();
    }

    public boolean isPatchApplyHandled() {
        return this.downloadModel.shouldDownloadWithPatchApply();
    }

    public boolean isV3Event() {
        return this.downloadEventConfig.isEnableV3Event();
    }

    public boolean notValid() {
        AdDownloadModel r100 = this.downloadModel;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (this.downloadEventConfig != null) goto L7;
        return true;
    L7:
        if (this.downloadController != null) goto L10;
        return true;
    L10:
        if (r100.isAd() == true) goto L12;
    L14:
        return false;
    L12:
        if (this.downloadModel.getId() > 0) goto L14;
        return true;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        int r101 = 1;
        r100.put(JsonKey.NATIVE_DOWNLOAD_MODEL_V2, 1);     // Catch: Exception -> L12
        r100.put(JsonKey.DOWNLOAD_STATUS, this.mDownloadStatus);     // Catch: Exception -> L12
        r100.put(JsonKey.TIME_STAMP, this.mTimeStamp);     // Catch: Exception -> L12
        r100.put(JsonKey.DOWNLOAD_ID, this.mDownloadId);     // Catch: Exception -> L12
        r100.put(JsonKey.SCENE, this.scene);     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_DOING_INSTALL_FINISH_EVENT, this.hasDoingInstallFinishEvent.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_SEND_INSTALL_FINISH, this.hasSendInstallFinish.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_DO_REBOOT_MARKET_INSTALL_FINISH_CHECK, this.hasDoRebootMarketInstallFinishCheck.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_SEND_DOWNLOAD_FAILED_FINALLY, this.hasSendDownloadFailedFinally.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_SEND_INSTALL_FINISH_CORRECT, this.hasSendInstallCorrect.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_SEND_INSTALL_FINISH_HIJACK, this.hasSendInstallFinishHijack.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_SEND_INSTALL_FINISH_HIJACK_IN_INSTALL_CORRECT, this.hasSendInstallFinishHijackInInstallCorrect.get());     // Catch: Exception -> L12
        r100.put(JsonKey.NEED_GENERATE_INSTALL_FINISH_HIJACK_PARAM, this.needGenerateInstallFinishHijack.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_REAL_START_DOWNLOAD, this.hasRealStartDownload.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_INTERCEPT_CLICK_START_BY_NO_WIFI, this.hasInterceptClickStartByNoWifi.get());     // Catch: Exception -> L12
        r100.put(JsonKey.HAS_INSERT_APPEND_INFO_IN_APK, this.hasInsertAppendInfoInApk.get());     // Catch: Exception -> L12
        r100.put(JsonKey.UNFINISHED_PUSH_RETAIN_TIMESTAMP, this.mUnFinishedPushRetainTimeStamp);     // Catch: Exception -> L12
        r100.put(JsonKey.IS_LISTENING_INSTALL_FINISH, this.mIsListeningInstallFinish);     // Catch: Exception -> L12
        r100.put(JsonKey.UNINSTALLED_PUSH_RETAIN_TIMESTAMP, this.mUnInstalledPushRetainTimeStamp);     // Catch: Exception -> L12
        r100.put(JsonKey.UNINSTALLED_ORDER_DOWNLOAD_PUSH_RETAIN_TIMESTAMP, this.mUnInstalledOrderDownloadPushRetainTimeStamp);     // Catch: Exception -> L12
        r100.put(JsonKey.UNINSTALLED_ORDER_DOWNLOAD_MESSAGE_RETAIN_TIMESTAMP, this.mUnInstalledOrderDownloadMessageRetainTimeStamp);     // Catch: Exception -> L12
        r100.put(JsonKey.LAST_FAILED_CODE, this.mLastFailedErrCode);     // Catch: Exception -> L12
        r100.put(JsonKey.LAST_FAILED_MSG, this.mLastFailedErrMsg);     // Catch: Exception -> L12
        r100.put(JsonKey.DOWNLOAD_FAILED_TIMES, this.mDownloadFailedTimes);     // Catch: Exception -> L12
        long r102 = this.mRecentDownloadResumeTime;     // Catch: Exception -> L12
        if (r102 != 0) goto L6;
        r102 = this.mTimeStamp;     // Catch: Exception -> L12
    L6:
        r100.put(JsonKey.RECENT_DOWNLOAD_RESUME_TIME, r102);     // Catch: Exception -> L12
        r100.put(JsonKey.CLICK_PAUSE_TIMES, this.mClickPauseTimes);     // Catch: Exception -> L12
        r100.put(JsonKey.JUMP_INSTALL_TIME, this.mJumpInstallTime);     // Catch: Exception -> L12
        r100.put(JsonKey.FIRST_JUMP_INSTALL_TIME, this.mFirstJumpInstallTime);     // Catch: Exception -> L12
        r100.put(JsonKey.LAST_FAILED_RESUME_COUNT, this.mLastFailedResumeCount);     // Catch: Exception -> L12
        r100.put(JsonKey.IS_UPDATE_DOWNLOAD, this.mIsUpdateDownload);     // Catch: Exception -> L12
        r100.put(JsonKey.DOWNLOAD_FINISH_REASON, this.mDownloadFinishReason);     // Catch: Exception -> L12
        r100.put(JsonKey.CLICK_DOWNLOAD_TIME, this.mClickDownloadTime);     // Catch: Exception -> L12
        r100.put(JsonKey.CLICK_DOWNLOAD_SIZE, this.mClickDownloadSize);     // Catch: Exception -> L12
        r100.put(JsonKey.INSTALL_AFTER_CLEAN, this.mInstallAfterCleanSpace);     // Catch: Exception -> L12
        r100.put(JsonKey.FUNNEL_TYPE, this.funnelType);     // Catch: Exception -> L12
        if (this.mEnablePause == true) goto L10;
        r101 = 0;
    L10:
        r100.put("enable_pause", r101);     // Catch: Exception -> L12
        r100.putOpt(JsonKey.JUMP_INSTALL_COUNT, Integer.valueOf(this.mJumpInstallCount));     // Catch: Exception -> L12
        r100.put("download_failed_send_count", this.mDownloadFailedSendCount);     // Catch: Exception -> L12
        r100.put("install_failed_send_count", this.mInstallFailedSendCount);     // Catch: Exception -> L12
        r100.put("market_event_send_count", this.mMarketEventSendCount);     // Catch: Exception -> L12
        r100.put("applink_event_send_count", this.mApplinkEventSendCount);     // Catch: Exception -> L12
        r100.putOpt(JsonKey.DOWNLOAD_PAUSE_TIMESTAMP, Long.valueOf(this.mDownloadPauseTimeStamp));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.DOWNLOAD_FINISH_TIMESTAMP, Long.valueOf(this.mDownloadFinishTimeStamp));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.MARKET_INSTALL_FINISH_CHECK_START_TIMESTAMP, Long.valueOf(this.mMarketInstallFinishCheckTimeStamp));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.INSTALL_CORRECT_TIMESTAMP, Long.valueOf(this.mInstallCorrectTimeStamp));     // Catch: Exception -> L12
        r100.putOpt("is_action_manually", Integer.valueOf(this.mIsActionManually));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.INSTALL_FINISH_HIJACK_APP_DATA, this.mInstallFinishHijackAppData);     // Catch: Exception -> L12
        r100.putOpt(JsonKey.HAS_DO_RANDOM_CLICK_START_PERCENT, Boolean.valueOf(this.hasDoRandomClickStartPercent.get()));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.RANDOM_CLICK_START_PERCENT, Integer.valueOf(this.mRandomClickStartPercent));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.SEND_INSTALL_FINISH_WAY, Integer.valueOf(this.mSendInstallFinishWay));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.BEFORE_INSTALL_FAILED_CODE, this.mBeforeInstallFailedCodes);     // Catch: Exception -> L12
        r100.putOpt(JsonKey.IS_FROM_GAME_UNION_LIVE, Boolean.valueOf(this.mIsFromGameUnionLive));     // Catch: Exception -> L12
        r100.putOpt("enable_applink_sdk", Boolean.valueOf(this.mEnableAppLinkSdk));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.CANCEL_DOWNLOAD_EXTRA_JSON, this.mCancelDownloadExtraJson);     // Catch: Exception -> L12
        r100.putOpt(JsonKey.IS_FORCE_CANCEL_DOWNLOAD, Boolean.valueOf(this.mIsForceCancelDownload));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.ENABLE_SEGMENT_DOWNLOAD, Boolean.valueOf(this.mEnableSegmentDownload));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.ENABLE_DOWNLOAD_PROCESS_CHAIN_OPT, Boolean.valueOf(this.mEnableDownloadProcessChainOpt));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.IS_PACKAGE_DOWNLOAD_FROM_ROLLBACK, Boolean.valueOf(this.mIsPackageDownloadFromRollback));     // Catch: Exception -> L12
        r100.putOpt("package_download_rollback_scene", Integer.valueOf(this.mPackageDownloadRollbackScene));     // Catch: Exception -> L12
        r100.putOpt("jump_rollback_landing_page_result", Boolean.valueOf(this.mJumpRollbackLandingPageResult));     // Catch: Exception -> L12
        r100.putOpt("market_download_off_shelf", Boolean.valueOf(this.mMarketDownloadOffShelf));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.FIRST_MARKET_OPEN_SUCCESS_TIMESTAMP, Long.valueOf(this.mFirstMarketOpenSuccessTimestamp));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.CHECKING_MARKET_DOWNLOAD_PUSH_RETAIN, Boolean.valueOf(this.mCheckingMarketDownloadPushRetain));     // Catch: Exception -> L12
        r100.putOpt(JsonKey.SHOW_MARKET_DOWNLOAD_PUSH_TIMESTAMP, Long.valueOf(this.mShowMarketDownloadPushTimestamp));     // Catch: Exception -> L12
        r100.putOpt("market_install_finish_check_rounds", Integer.valueOf(this.mMarketInstallFinishCheckRounds));     // Catch: Exception -> L12
        r100.put(JsonKey.AD_DOWNLOAD_MODEL, this.downloadModel.toJson());     // Catch: Exception -> L12
        r100.put(JsonKey.AD_DOWNLOAD_EVENT_CONFIG, this.downloadEventConfig.toJson());     // Catch: Exception -> L12
        r100.put(JsonKey.AD_DOWNLOAD_CONTROLLER, this.downloadController.toJson());     // Catch: Exception -> L12
    L14:
        return r100;
    L12:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "NativeDownloadModel toJson");
        goto L14
    }

    private NativeDownloadModel() {
        this.mDownloadStatus = 1;
        this.mDownloadFailedTimes = 0;
        this.mClickPauseTimes = 0;
        this.mFirstJumpInstallTime = 0;
        this.mIsUpdateDownload = false;
        this.mEnablePause = true;
        this.hasDoingInstallFinishEvent = new AtomicBoolean(false);
        this.hasSendInstallFinish = new AtomicBoolean(false);
        this.hasDoRebootMarketInstallFinishCheck = new AtomicBoolean(false);
        this.hasSendDownloadFailedFinally = new AtomicBoolean(false);
        this.hasSendInstallCorrect = new AtomicBoolean(false);
        this.hasSendInstallFinishHijack = new AtomicBoolean(false);
        this.hasSendInstallFinishHijackInInstallCorrect = new AtomicBoolean(false);
        this.needGenerateInstallFinishHijack = new AtomicBoolean(false);
        this.hasRealStartDownload = new AtomicBoolean(false);
        this.hasInterceptClickStartByNoWifi = new AtomicBoolean(false);
        this.hasInsertAppendInfoInApk = new AtomicBoolean(false);
        this.hasDoRandomClickStartPercent = new AtomicBoolean(false);
        this.mJumpInstallCount = 0;
        this.mIsActionManually = 2;
        this.mIsManualPaused = false;
        this.availableSpaceBytes = -1;
        this.mIsListeningInstallCorrect = false;
        this.isCheckingUnFinishedRetain = false;
        this.isCheckingUnInstalledRetain = false;
        this.isCheckingOrderMessageRetain = false;
        this.mUnFinishedPushRetainTimeStamp = -1;
        this.mUnInstalledPushRetainTimeStamp = -1;
        this.mUnInstalledOrderDownloadPushRetainTimeStamp = -1;
        this.mUnInstalledOrderDownloadMessageRetainTimeStamp = -1;
        this.mIsFromGameUnionLive = false;
        this.mHasShowPauseOptimiseDialogCount = 0;
        this.mSendInstallFinishWay = 0;
        this.mRandomClickStartPercent = 0;
        this.mFirstMarketOpenSuccessTimestamp = 0;
        this.isCheckMarketSign = true;
    }

    public boolean enableDownloadProcessChainOpt() {
        return this.mEnableDownloadProcessChainOpt;
    }

    public boolean enableSegmentDownload() {
        return this.mEnableSegmentDownload;
    }

    public AdDownloadModel generateDownloadModel() {
        return this.downloadModel;
    }

    public int getActionManually() {
        return this.mIsActionManually;
    }

    public int getApplinkEventSendCount() {
        return this.mApplinkEventSendCount;
    }

    public long getAvailableSpaceBytes() {
        return this.availableSpaceBytes;
    }

    public String getBeforeInstallFailedCodes() {
        return this.mBeforeInstallFailedCodes;
    }

    public JSONObject getCancelDownloadExtraJson() {
        return this.mCancelDownloadExtraJson;
    }

    public long getClickDownloadSize() {
        return this.mClickDownloadSize;
    }

    public long getClickDownloadTime() {
        return this.mClickDownloadTime;
    }

    public int getClickPauseTimes() {
        return this.mClickPauseTimes;
    }

    public AdDownloadController getController() {
        return this.downloadController;
    }

    public int getDownloadFailedSendCount() {
        return this.mDownloadFailedSendCount;
    }

    public int getDownloadFailedTimes() {
        return this.mDownloadFailedTimes;
    }

    public String getDownloadFinishReason() {
        return this.mDownloadFinishReason;
    }

    public long getDownloadFinishTimeStamp() {
        return this.mDownloadFinishTimeStamp;
    }

    public int getDownloadId() {
        return this.mDownloadId;
    }

    public long getDownloadPauseTimeStamp() {
        return this.mDownloadPauseTimeStamp;
    }

    public int getDownloadStatus() {
        return this.mDownloadStatus;
    }

    public AdDownloadEventConfig getEvent() {
        return this.downloadEventConfig;
    }

    public long getFirstJumpInstallTime() {
        return this.mFirstJumpInstallTime;
    }

    public long getFirstMarketOpenSuccessTimestamp() {
        return this.mFirstMarketOpenSuccessTimestamp;
    }

    public int getHasShowPauseOptimiseDialogCount() {
        return this.mHasShowPauseOptimiseDialogCount;
    }

    public long getInstallCorrectTimeStamp() {
        return this.mInstallCorrectTimeStamp;
    }

    public int getInstallFailedSendCount() {
        return this.mInstallFailedSendCount;
    }

    public JSONObject getInstallFinishHijackAppData() {
        return this.mInstallFinishHijackAppData;
    }

    public int getInstallScene() {
        return this.scene;
    }

    public int getJumpInstallCount() {
        return this.mJumpInstallCount;
    }

    public long getJumpInstallTime() {
        return this.mJumpInstallTime;
    }

    public int getLastFailedErrCode() {
        return this.mLastFailedErrCode;
    }

    public String getLastFailedErrMsg() {
        return this.mLastFailedErrMsg;
    }

    public int getLastFailedResumeCount() {
        return this.mLastFailedResumeCount;
    }

    public int getMarketEventSendCount() {
        return this.mMarketEventSendCount;
    }

    public int getMarketInstallFinishCheckRounds() {
        return this.mMarketInstallFinishCheckRounds;
    }

    public long getMarketInstallFinishCheckTimeStamp() {
        return this.mMarketInstallFinishCheckTimeStamp;
    }

    public AdDownloadModel getModel() {
        return this.downloadModel;
    }

    public int getPackageDownloadRollbackScene() {
        return this.mPackageDownloadRollbackScene;
    }

    public int getRandomClickStartPercent() {
        return this.mRandomClickStartPercent;
    }

    public int getSendInstallFinishWay() {
        return this.mSendInstallFinishWay;
    }

    public long getShowMarketDownloadPushTimestamp() {
        return this.mShowMarketDownloadPushTimestamp;
    }

    public long getStartInstallFinishLoopTimeStamp() {
        return this.mStartInstallFinishLoopTimeStamp;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public long getUnFinishedPushRetainTimeStamp() {
        return this.mUnFinishedPushRetainTimeStamp;
    }

    public long getUnInstalledOrderDownloadMessageRetainTimeStamp() {
        return this.mUnInstalledOrderDownloadMessageRetainTimeStamp;
    }

    public long getUnInstalledOrderDownloadPushRetainTimeStamp() {
        return this.mUnInstalledOrderDownloadPushRetainTimeStamp;
    }

    public long getUnInstalledPushRetainTimeStamp() {
        return this.mUnInstalledPushRetainTimeStamp;
    }

    public boolean isCheckMarketSign() {
        return this.isCheckMarketSign;
    }

    public boolean isCheckingMarketDownloadPushRetain() {
        return this.mCheckingMarketDownloadPushRetain;
    }

    public boolean isCheckingOrderMessageRetain() {
        return this.isCheckingOrderMessageRetain;
    }

    public boolean isCheckingUnFinishedRetain() {
        return this.isCheckingUnFinishedRetain;
    }

    public boolean isCheckingUnInstalledRetain() {
        return this.isCheckingUnInstalledRetain;
    }

    public boolean isDeeplinkAfterBackApp() {
        return this.mDeeplinkAfterBackApp;
    }

    public boolean isDisableShowDialog() {
        return this.mIsDisableShowDialog;
    }

    public boolean isEnableAppLinkSdk() {
        return this.mEnableAppLinkSdk;
    }

    public boolean isForceCancelDownload() {
        return this.mIsForceCancelDownload;
    }

    public boolean isFromGameUnionLive() {
        return this.mIsFromGameUnionLive;
    }

    public boolean isHandleNoEnoughSpaceDownload() {
        return this.mHandleNoEnoughSpaceDownload;
    }

    public boolean isHandleNoEnoughSpaceInstall() {
        return this.mHandleNoEnoughSpaceInstall;
    }

    public boolean isInstallAfterBackApp() {
        return this.mInstallAfterBackApp;
    }

    public boolean isInstallAfterCleanSpace() {
        return this.mInstallAfterCleanSpace;
    }

    public boolean isIsCleanSpaceBeforeDownload() {
        return this.mIsCleanSpaceBeforeDownload;
    }

    public boolean isIsShowDownloadPercentRetain() {
        return this.mIsShowDownloadPercentRetain;
    }

    public boolean isJumpRollbackLandingPageResult() {
        return this.mJumpRollbackLandingPageResult;
    }

    public boolean isListeningInstallCorrect() {
        return this.mIsListeningInstallCorrect;
    }

    public boolean isListeningInstallFinish() {
        return this.mIsListeningInstallFinish;
    }

    public boolean isManualPaused() {
        return this.mIsManualPaused;
    }

    public boolean isManualUnInstalled() {
        return this.mIsManualUnInstalled;
    }

    public boolean isMarketDownloadOffShelf() {
        return this.mMarketDownloadOffShelf;
    }

    public boolean isPackageDownloadFromRollback() {
        return this.mIsPackageDownloadFromRollback;
    }

    public boolean isShowApkSizeRetain() {
        return this.mIsShowApkSizeRetain;
    }

    public boolean isShowAppDialog() {
        return this.mIsShowAppDialog;
    }

    public boolean isShowCancelApkSizeRetain() {
        return this.mIsShowCancelApkSizeRetain;
    }

    public boolean isUpdateDownload() {
        return this.mIsUpdateDownload;
    }

    public static NativeDownloadModel fromJson(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        NativeDownloadModel r101 = new NativeDownloadModel();
        r101.setDownloadStatus(r100.optInt(JsonKey.DOWNLOAD_STATUS));     // Catch: Exception -> L15
        r101.setTimeStamp(ToolUtils.optLong(r100, JsonKey.TIME_STAMP));     // Catch: Exception -> L15
        r101.setDownloadId(r100.optInt(JsonKey.DOWNLOAD_ID));     // Catch: Exception -> L15
        r101.setInstallScene(r100.optInt(JsonKey.SCENE));     // Catch: Exception -> L15
        r101.hasDoingInstallFinishEvent.set(r100.optBoolean(JsonKey.HAS_DOING_INSTALL_FINISH_EVENT));     // Catch: Exception -> L15
        r101.hasSendInstallFinish.set(r100.optBoolean(JsonKey.HAS_SEND_INSTALL_FINISH));     // Catch: Exception -> L15
        r101.hasDoRebootMarketInstallFinishCheck.set(r100.optBoolean(JsonKey.HAS_DO_REBOOT_MARKET_INSTALL_FINISH_CHECK));     // Catch: Exception -> L15
        r101.hasSendDownloadFailedFinally.set(r100.optBoolean(JsonKey.HAS_SEND_DOWNLOAD_FAILED_FINALLY));     // Catch: Exception -> L15
        r101.hasSendInstallCorrect.set(r100.optBoolean(JsonKey.HAS_SEND_INSTALL_FINISH_CORRECT));     // Catch: Exception -> L15
        r101.hasSendInstallFinishHijack.set(r100.optBoolean(JsonKey.HAS_SEND_INSTALL_FINISH_HIJACK));     // Catch: Exception -> L15
        r101.needGenerateInstallFinishHijack.set(r100.optBoolean(JsonKey.NEED_GENERATE_INSTALL_FINISH_HIJACK_PARAM));     // Catch: Exception -> L15
        r101.hasRealStartDownload.set(r100.optBoolean(JsonKey.HAS_REAL_START_DOWNLOAD));     // Catch: Exception -> L15
        r101.hasInterceptClickStartByNoWifi.set(r100.optBoolean(JsonKey.HAS_INTERCEPT_CLICK_START_BY_NO_WIFI));     // Catch: Exception -> L15
        r101.hasSendInstallFinishHijackInInstallCorrect.set(r100.optBoolean(JsonKey.HAS_SEND_INSTALL_FINISH_HIJACK_IN_INSTALL_CORRECT));     // Catch: Exception -> L15
        r101.hasInsertAppendInfoInApk.set(r100.optBoolean(JsonKey.HAS_INSERT_APPEND_INFO_IN_APK));     // Catch: Exception -> L15
        r101.hasDoRandomClickStartPercent.set(r100.optBoolean(JsonKey.HAS_DO_RANDOM_CLICK_START_PERCENT));     // Catch: Exception -> L15
        r101.setIsListeningInstallFinish(r100.optBoolean(JsonKey.IS_LISTENING_INSTALL_FINISH));     // Catch: Exception -> L15
        r101.setUnFinishedPushRetainTimeStamp(r100.optLong(JsonKey.UNFINISHED_PUSH_RETAIN_TIMESTAMP));     // Catch: Exception -> L15
        r101.setUnInstalledPushRetainTimeStamp(r100.optLong(JsonKey.UNINSTALLED_PUSH_RETAIN_TIMESTAMP));     // Catch: Exception -> L15
        r101.setUnInstalledOrderDownloadPushRetainTimeStamp(r100.optLong(JsonKey.UNINSTALLED_ORDER_DOWNLOAD_PUSH_RETAIN_TIMESTAMP));     // Catch: Exception -> L15
        r101.setUnInstalledOrderDownloadMessageRetainTimeStamp(r100.optLong(JsonKey.UNINSTALLED_ORDER_DOWNLOAD_MESSAGE_RETAIN_TIMESTAMP));     // Catch: Exception -> L15
        r101.setLastFailedErrCode(r100.optInt(JsonKey.LAST_FAILED_CODE));     // Catch: Exception -> L15
        r101.setLastFailedErrMsg(r100.optString(JsonKey.LAST_FAILED_MSG));     // Catch: Exception -> L15
        r101.setDownloadFailedTimes(r100.optInt(JsonKey.DOWNLOAD_FAILED_TIMES, 0));     // Catch: Exception -> L15
        r101.setRecentDownloadResumeTime(ToolUtils.optLong(r100, JsonKey.RECENT_DOWNLOAD_RESUME_TIME));     // Catch: Exception -> L15
        r101.setClickPauseTimes(r100.optInt(JsonKey.CLICK_PAUSE_TIMES));     // Catch: Exception -> L15
        r101.setJumpInstallTime(ToolUtils.optLong(r100, JsonKey.JUMP_INSTALL_TIME));     // Catch: Exception -> L15
        r101.setFirstJumpInstallTime(ToolUtils.optLong(r100, JsonKey.FIRST_JUMP_INSTALL_TIME));     // Catch: Exception -> L15
        r101.setLastFailedResumeCount(r100.optInt(JsonKey.LAST_FAILED_RESUME_COUNT));     // Catch: Exception -> L15
        r101.setDownloadFinishReason(r100.optString(JsonKey.DOWNLOAD_FINISH_REASON));     // Catch: Exception -> L15
        r101.setClickDownloadSize(r100.optLong(JsonKey.CLICK_DOWNLOAD_SIZE));     // Catch: Exception -> L15
        r101.setClickDownloadTime(r100.optLong(JsonKey.CLICK_DOWNLOAD_TIME));     // Catch: Exception -> L15
        r101.setIsUpdateDownload(r100.optBoolean(JsonKey.IS_UPDATE_DOWNLOAD));     // Catch: Exception -> L15
        r101.setInstallAfterCleanSpace(r100.optBoolean(JsonKey.INSTALL_AFTER_CLEAN));     // Catch: Exception -> L15
        r101.setFunnelType(r100.optInt(JsonKey.FUNNEL_TYPE, 1));     // Catch: Exception -> L15
        if (r100.optInt("enable_pause", 1) != 1) goto L9;
        boolean r102 = true;
    L10:
        r101.setEnablePause(r102);     // Catch: Exception -> L15
        r101.setDownloadFailedSendCount(r100.optInt("download_failed_send_count", 0));     // Catch: Exception -> L15
        r101.setInstallFailedSendCount(r100.optInt("install_failed_send_count", 0));     // Catch: Exception -> L15
        r101.setMarketEventSendCount(r100.optInt("market_event_send_count", 0));     // Catch: Exception -> L15
        r101.setApplinkEventSendCount(r100.optInt("applink_event_send_count", 0));     // Catch: Exception -> L15
        r101.setJumpInstallCount(r100.optInt(JsonKey.JUMP_INSTALL_COUNT, 0));     // Catch: Exception -> L15
        r101.setDownloadPauseTimeStamp(r100.optLong(JsonKey.DOWNLOAD_PAUSE_TIMESTAMP, 0));     // Catch: Exception -> L15
        r101.setDownloadFinishTimeStamp(r100.optLong(JsonKey.DOWNLOAD_FINISH_TIMESTAMP, 0));     // Catch: Exception -> L15
        r101.setMarketInstallFinishCheckTimeStamp(r100.optLong(JsonKey.MARKET_INSTALL_FINISH_CHECK_START_TIMESTAMP, 0));     // Catch: Exception -> L15
        r101.setInstallCorrectTimeStamp(r100.optLong(JsonKey.INSTALL_CORRECT_TIMESTAMP));     // Catch: Exception -> L15
        r101.setIsActionManually(r100.optInt("is_action_manually", 1));     // Catch: Exception -> L15
        r101.setInstallFinishHijackAppData(r100.optJSONObject(JsonKey.INSTALL_FINISH_HIJACK_APP_DATA));     // Catch: Exception -> L15
        r101.setRandomClickStartPercent(r100.optInt(JsonKey.RANDOM_CLICK_START_PERCENT));     // Catch: Exception -> L15
        r101.setSendInstallFinishWay(r100.optInt(JsonKey.SEND_INSTALL_FINISH_WAY));     // Catch: Exception -> L15
        r101.setBeforeInstallFailedCodes(r100.optString(JsonKey.BEFORE_INSTALL_FAILED_CODE));     // Catch: Exception -> L15
        r101.setIsFromGameUnionLive(r100.optBoolean(JsonKey.IS_FROM_GAME_UNION_LIVE));     // Catch: Exception -> L15
        r101.setEnableAppLinkSdk(r100.optBoolean("enable_applink_sdk"));     // Catch: Exception -> L15
        r101.setCancelDownloadExtraJson(r100.optJSONObject(JsonKey.CANCEL_DOWNLOAD_EXTRA_JSON));     // Catch: Exception -> L15
        r101.setIsForceCancelDownload(r100.optBoolean(JsonKey.IS_FORCE_CANCEL_DOWNLOAD));     // Catch: Exception -> L15
        r101.setEnableSegmentDownload(r100.optBoolean(JsonKey.ENABLE_SEGMENT_DOWNLOAD));     // Catch: Exception -> L15
        r101.setEnableDownloadProcessChainOpt(r100.optBoolean(JsonKey.ENABLE_DOWNLOAD_PROCESS_CHAIN_OPT));     // Catch: Exception -> L15
        r101.setPackageDownloadFromRollback(r100.optBoolean(JsonKey.IS_PACKAGE_DOWNLOAD_FROM_ROLLBACK));     // Catch: Exception -> L15
        r101.setPackageDownloadRollbackScene(r100.optInt("package_download_rollback_scene"));     // Catch: Exception -> L15
        r101.setJumpRollbackLandingPageResult(r100.optBoolean("jump_rollback_landing_page_result"));     // Catch: Exception -> L15
        r101.setMarketDownloadOffShelf(r100.optBoolean("market_download_off_shelf"));     // Catch: Exception -> L15
        r101.setFirstMarketOpenSuccessTimestamp(r100.optLong(JsonKey.FIRST_MARKET_OPEN_SUCCESS_TIMESTAMP));     // Catch: Exception -> L15
        r101.setCheckingMarketDownloadPushRetain(r100.optBoolean(JsonKey.CHECKING_MARKET_DOWNLOAD_PUSH_RETAIN));     // Catch: Exception -> L15
        r101.setShowMarketDownloadPushTimestamp(r100.optLong(JsonKey.SHOW_MARKET_DOWNLOAD_PUSH_TIMESTAMP));     // Catch: Exception -> L15
        r101.setMarketInstallFinishCheckRounds(r100.optInt("market_install_finish_check_rounds"));     // Catch: Exception -> L15
        if (r100.optInt(JsonKey.NATIVE_DOWNLOAD_MODEL_V2) != 1) goto L13;
        parseNativeModelV2(r100, r101);     // Catch: Exception -> L15
    L18:
    L17:
        return r101;
    L13:
        parseNativeModelV1(r100, r101);     // Catch: Exception -> L15
        goto L18
    L9:
        r102 = false;
    L15:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "NativeDownloadModel fromJson");
        goto L17
    }

    private static AdDownloadController parseDownloadController(JSONObject r100) {
        AdDownloadController.Builder r101 = new AdDownloadController.Builder();
        r101.setEnableBackDialog(r100.optBoolean(JsonKey.ENABLE_BACK_DIALOG));
        r101.setLinkMode(r100.optInt(JsonKey.LINK_MODE));
        r101.setDownloadMode(r100.optInt(JsonKey.DOWNLOAD_MODE));
        boolean r102 = true;
        r101.setEnableShowComplianceDialog(r100.optBoolean(JsonKey.ENABLE_COMPLIANCE_DIALOG, true));
        r101.setIsAutoDownloadOnCardShow(r100.optBoolean(JsonKey.AUTO_DOWNLOAD_ON_CARD_SHOW));
        if (r100.optInt("enable_new_activity", 1) != 1) goto L5;
        boolean r103 = true;
    L6:
        r101.setEnableNewActivity(r103);
        if (r100.optInt("enable_ah", 1) != 1) goto L9;
        boolean r104 = true;
    L10:
        r101.setEnableAH(r104);
        if (r100.optInt("enable_am", 1) == 1) goto L14;
        r102 = false;
    L14:
        r101.setEnableAM(r102);
        r101.setEnableDownloadHandlerTaskKey(r100.optBoolean("enable_download_handler_taskkey"));
        r101.setEnableClickStartOptForGameUnion(r100.optBoolean("enable_click_start_opt_for_game_union"));
        return r101.build();
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    private static AdDownloadEventConfig parseDownloadEventConfig(JSONObject r100) {
        AdDownloadEventConfig.Builder r101 = new AdDownloadEventConfig.Builder();
        r101.setIsEnableV3Event(r100.optBoolean(JsonKey.IS_V3_EVENT));
        r101.setClickButtonTag(r100.optString(JsonKey.EVENT_TAG));
        r101.setRefer(r100.optString(JsonKey.EVENT_REFER));
        r101.setExtraJson(r100.optJSONObject(JsonKey.EVENT_EXTRA));
        r101.setDownloadScene(r100.optInt(JsonKey.DOWNLOAD_SCENE));
        r101.setParamsJson(r100.optJSONObject(JsonKey.PARAMS_JSON));
        r101.setExtraEventObject(r100.opt(JsonKey.EXTRA_EVENT_OBJECT));
        boolean r102 = true;
        if (r100.optInt("has_shown_pkg_info") == 1) goto L6;
        r102 = false;
    L6:
        r101.hasShowPkgInfo(r102);
        r101.setAppPkgInfo(r100.optJSONObject("app_pkg_info"));
        return r101.build();
    }

    private static AdDownloadModel parseDownloadModel(JSONObject r100) {
        AdDownloadModel.Builder r101 = new AdDownloadModel.Builder();
        r101.setId(ToolUtils.optLong(r100, JsonKey.ID));
        r101.setExtraValue(ToolUtils.optLong(r100, JsonKey.EXT_VALUE));
        r101.setLogExtra(r100.optString(JsonKey.LOG_EXTRA));
        r101.setPackageName(r100.optString(JsonKey.PACKAGE_NAME));
        boolean r102 = true;
        r101.setIsAd(r100.optBoolean(JsonKey.IS_AD, true));
        r101.setVersionCode(r100.optInt(JsonKey.VERSION_CODE));
        r101.setVersionName(r100.optString(JsonKey.VERSION_NAME));
        r101.setDownloadUrl(r100.optString(JsonKey.DOWNLOAD_URL));
        r101.setDeepLink(new DeepLink(r100.optString(JsonKey.OPEN_URL), r100.optString(JsonKey.WEB_URL), ""));
        r101.setModelType(r100.optInt(JsonKey.MODEL_TYPE));
        r101.setAppName(r100.optString(JsonKey.APP_NAME));
        r101.setAppIcon(r100.optString(JsonKey.APP_ICON));
        r101.setMimeType(r100.optString(JsonKey.MIME_TYPE));
        r101.setExtra(r100.optJSONObject(JsonKey.EXTRA));
        r101.setCallScene(r100.optInt("call_scene", 0));
        r101.setComplianceData(r100.optString("compliance_data"));
        r101.setDownloadSettings(r100.optJSONObject(JsonKey.DOWNLOAD_SETTINGS));
        if (r100.optInt(JsonKey.IGNORE_INTERCEPT, 0) != 1) goto L5;
        boolean r103 = true;
    L6:
        r101.setIgnoreIntercept(r103);
        r101.setInstalledDate(r100.optLong("installed_date"));
        r101.setDownloadStartDate(r100.optLong("download_start_date"));
        r101.setDownloadFinishDate(r100.optLong("download_finish_date"));
        if (r100.optInt(JsonKey.IS_FROM_DOWNLOAD_MANAGEMENT, 0) == 1) goto L10;
        r102 = false;
    L10:
        r101.setIsDownloadManagement(r102);
        r101.setDownloadHandlerTaskKey(r100.optString("download_handler_taskkey"));
        r101.setDistinctDir(r100.optBoolean("distinct_directory"));
        r101.setTaskKeyObject(r100.optJSONObject("taskkey_object"));
        r101.setFilePath(r100.optString("file_path"));
        r101.setIsOrderDownload(r100.optInt("is_order_download"));
        r101.setOrderId(r100.optString("order_id"));
        return r101.build();
    L5:
        r103 = false;
        goto L6
    }

    public void setApplinkEventSendCount(int r100) {
        this.mApplinkEventSendCount = r100;
    }

    public void setAvailableSpaceBytes(long r100) {
        this.availableSpaceBytes = r100;
    }

    public void setBeforeInstallFailedCodes(String r100) {
        this.mBeforeInstallFailedCodes = r100;
    }

    public void setCancelDownloadExtraJson(JSONObject r100) {
        this.mCancelDownloadExtraJson = r100;
    }

    public void setCheckMarketSign(boolean r100) {
        this.isCheckMarketSign = r100;
    }

    public void setCheckingMarketDownloadPushRetain(boolean r100) {
        this.mCheckingMarketDownloadPushRetain = r100;
    }

    public void setCheckingOrderMessageRetain(boolean r100) {
        this.isCheckingOrderMessageRetain = r100;
    }

    public void setCheckingUnFinishedRetain(boolean r100) {
        this.isCheckingUnFinishedRetain = r100;
    }

    public void setCheckingUnInstalledRetain(boolean r100) {
        this.isCheckingUnInstalledRetain = r100;
    }

    public void setClickDownloadSize(long r100) {
        this.mClickDownloadSize = r100;
    }

    public void setClickDownloadTime(long r100) {
        this.mClickDownloadTime = r100;
    }

    public void setClickPauseTimes(int r100) {
        this.mClickPauseTimes = r100;
    }

    public void setDeeplinkAfterBackApp(boolean r100) {
        this.mDeeplinkAfterBackApp = r100;
    }

    public void setDownloadFailedSendCount(int r100) {
        this.mDownloadFailedSendCount = r100;
    }

    public void setDownloadFailedTimes(int r100) {
        this.mDownloadFailedTimes = r100;
    }

    public void setDownloadFinishReason(String r100) {
        this.mDownloadFinishReason = r100;
    }

    public void setDownloadFinishTimeStamp(long r100) {
        this.mDownloadFinishTimeStamp = r100;
    }

    public void setDownloadId(int r100) {
        this.mDownloadId = r100;
    }

    public void setDownloadPauseTimeStamp(long r100) {
        this.mDownloadPauseTimeStamp = r100;
    }

    public void setDownloadStatus(int r100) {
        this.mDownloadStatus = r100;
    }

    public void setEnableAppLinkSdk(boolean r100) {
        this.mEnableAppLinkSdk = r100;
    }

    public void setEnableDownloadProcessChainOpt(boolean r100) {
        this.mEnableDownloadProcessChainOpt = r100;
    }

    public void setEnablePause(boolean r100) {
        this.mEnablePause = r100;
    }

    public void setEnableSegmentDownload(boolean r100) {
        this.mEnableSegmentDownload = r100;
    }

    public void setFirstJumpInstallTime(long r100) {
        this.mFirstJumpInstallTime = r100;
    }

    public void setFirstMarketOpenSuccessTimestamp(long r100) {
        this.mFirstMarketOpenSuccessTimestamp = r100;
    }

    public void setFunnelType(int r100) {
        this.funnelType = r100;
    }

    public void setHandleNoEnoughSpaceDownload(boolean r100) {
        this.mHandleNoEnoughSpaceDownload = r100;
    }

    public void setHandleNoEnoughSpaceInstall(boolean r100) {
        this.mHandleNoEnoughSpaceInstall = r100;
    }

    public void setHasShowPauseOptimiseDialogCount(int r100) {
        this.mHasShowPauseOptimiseDialogCount = r100;
    }

    public void setInstallAfterBackApp(boolean r100) {
        this.mInstallAfterBackApp = r100;
    }

    public void setInstallAfterCleanSpace(boolean r100) {
        this.mInstallAfterCleanSpace = r100;
    }

    public void setInstallCorrectTimeStamp(long r100) {
        this.mInstallCorrectTimeStamp = r100;
    }

    public void setInstallFailedSendCount(int r100) {
        this.mInstallFailedSendCount = r100;
    }

    public void setInstallFinishHijackAppData(JSONObject r100) {
        this.mInstallFinishHijackAppData = r100;
    }

    public void setInstallScene(int r100) {
        this.scene = r100;
    }

    public void setIsActionManually(int r100) {
        this.mIsActionManually = r100;
    }

    public void setIsCleanSpaceBeforeDownload(boolean r100) {
        this.mIsCleanSpaceBeforeDownload = r100;
    }

    public void setIsDisableShowDialog(boolean r100) {
        this.mIsDisableShowDialog = r100;
    }

    public void setIsForceCancelDownload(boolean r100) {
        this.mIsForceCancelDownload = r100;
    }

    public void setIsFromGameUnionLive(boolean r100) {
        this.mIsFromGameUnionLive = r100;
    }

    public void setIsListeningInstallCorrect(boolean r100) {
        this.mIsListeningInstallCorrect = r100;
    }

    public void setIsListeningInstallFinish(boolean r100) {
        this.mIsListeningInstallFinish = r100;
    }

    public void setIsManualPaused(boolean r100) {
        this.mIsManualPaused = r100;
    }

    public void setIsManualUnInstalled(boolean r100) {
        this.mIsManualUnInstalled = r100;
    }

    public void setIsShowApkSizeRetain(boolean r100) {
        this.mIsShowApkSizeRetain = r100;
    }

    public void setIsShowAppDialog(boolean r100) {
        this.mIsShowAppDialog = r100;
    }

    public void setIsShowCancelApkSizeRetain(boolean r100) {
        this.mIsShowCancelApkSizeRetain = r100;
    }

    public void setIsShowDownloadPercentRetain(boolean r100) {
        this.mIsShowDownloadPercentRetain = r100;
    }

    public void setIsUpdateDownload(boolean r100) {
        this.mIsUpdateDownload = r100;
    }

    public void setJumpInstallCount(int r100) {
        this.mJumpInstallCount = r100;
    }

    public void setJumpInstallTime(long r100) {
        this.mJumpInstallTime = r100;
    }

    public void setJumpRollbackLandingPageResult(boolean r100) {
        this.mJumpRollbackLandingPageResult = r100;
    }

    public void setLastFailedErrCode(int r100) {
        this.mLastFailedErrCode = r100;
    }

    public void setLastFailedErrMsg(String r100) {
        this.mLastFailedErrMsg = r100;
    }

    public void setLastFailedResumeCount(int r100) {
        this.mLastFailedResumeCount = r100;
    }

    public void setMarketDownloadOffShelf(boolean r100) {
        this.mMarketDownloadOffShelf = r100;
    }

    public void setMarketEventSendCount(int r100) {
        this.mMarketEventSendCount = r100;
    }

    public void setMarketInstallFinishCheckRounds(int r100) {
        this.mMarketInstallFinishCheckRounds = r100;
    }

    public void setMarketInstallFinishCheckTimeStamp(long r100) {
        this.mMarketInstallFinishCheckTimeStamp = r100;
    }

    public void setPackageDownloadFromRollback(boolean r100) {
        this.mIsPackageDownloadFromRollback = r100;
    }

    public void setPackageDownloadRollbackScene(int r100) {
        this.mPackageDownloadRollbackScene = r100;
    }

    public void setRandomClickStartPercent(int r100) {
        this.mRandomClickStartPercent = r100;
    }

    public void setRecentDownloadResumeTime(long r100) {
        this.mRecentDownloadResumeTime = r100;
    }

    public void setSendInstallFinishWay(int r100) {
        this.mSendInstallFinishWay = r100;
    }

    public void setShowMarketDownloadPushTimestamp(long r100) {
        this.mShowMarketDownloadPushTimestamp = r100;
    }

    public void setStartInstallFinishLoopTimeStamp(long r100) {
        this.mStartInstallFinishLoopTimeStamp = r100;
    }

    public void setTimeStamp(long r100) {
        if (r100 <= 0) goto L6;
        this.mTimeStamp = r100;
        return;
    }

    public void setUnFinishedPushRetainTimeStamp(long r100) {
        this.mUnFinishedPushRetainTimeStamp = r100;
    }

    public void setUnInstalledOrderDownloadMessageRetainTimeStamp(long r100) {
        this.mUnInstalledOrderDownloadMessageRetainTimeStamp = r100;
    }

    public void setUnInstalledOrderDownloadPushRetainTimeStamp(long r100) {
        this.mUnInstalledOrderDownloadPushRetainTimeStamp = r100;
    }

    public void setUnInstalledPushRetainTimeStamp(long r100) {
        this.mUnInstalledPushRetainTimeStamp = r100;
    }

    public void updateDownloadController(AdDownloadController r100) {
        this.downloadController = r100;
    }

    public void updateDownloadEventConfig(AdDownloadEventConfig r100) {
        this.downloadEventConfig = r100;
    }

    public void updateDownloadModel(AdDownloadModel r100) {
        this.downloadModel = r100;
    }

    private static void parseNativeModelV1(JSONObject r100, NativeDownloadModel r101) {
        r101.downloadModel = parseDownloadModel(r100);
        r101.downloadEventConfig = parseDownloadEventConfig(r100);
        r101.downloadController = parseDownloadController(r100);
    }

    private static void parseNativeModelV2(JSONObject r100, NativeDownloadModel r101) {
        r101.downloadModel = AdDownloadModel.fromJson(r100.optJSONObject(JsonKey.AD_DOWNLOAD_MODEL));
        r101.downloadEventConfig = AdDownloadEventConfig.fromJson(r100.optJSONObject(JsonKey.AD_DOWNLOAD_EVENT_CONFIG));
        r101.downloadController = AdDownloadController.fromJson(r100.optJSONObject(JsonKey.AD_DOWNLOAD_CONTROLLER));
    }

    public NativeDownloadModel(DownloadModel r100, DownloadEventConfig r101, DownloadController r102) {
        this(r100, r101, r102, 0);
    }

    public NativeDownloadModel(DownloadModel r100, DownloadEventConfig r101, DownloadController r102, int r110) {
        this.mDownloadStatus = 1;
        this.mDownloadFailedTimes = 0;
        this.mClickPauseTimes = 0;
        this.mFirstJumpInstallTime = 0;
        this.mIsUpdateDownload = false;
        this.mEnablePause = true;
        this.hasDoingInstallFinishEvent = new AtomicBoolean(false);
        this.hasSendInstallFinish = new AtomicBoolean(false);
        this.hasDoRebootMarketInstallFinishCheck = new AtomicBoolean(false);
        this.hasSendDownloadFailedFinally = new AtomicBoolean(false);
        this.hasSendInstallCorrect = new AtomicBoolean(false);
        this.hasSendInstallFinishHijack = new AtomicBoolean(false);
        this.hasSendInstallFinishHijackInInstallCorrect = new AtomicBoolean(false);
        this.needGenerateInstallFinishHijack = new AtomicBoolean(false);
        this.hasRealStartDownload = new AtomicBoolean(false);
        this.hasInterceptClickStartByNoWifi = new AtomicBoolean(false);
        this.hasInsertAppendInfoInApk = new AtomicBoolean(false);
        this.hasDoRandomClickStartPercent = new AtomicBoolean(false);
        this.mJumpInstallCount = 0;
        this.mIsActionManually = 2;
        this.mIsManualPaused = false;
        this.availableSpaceBytes = -1;
        this.mIsListeningInstallCorrect = false;
        this.isCheckingUnFinishedRetain = false;
        this.isCheckingUnInstalledRetain = false;
        this.isCheckingOrderMessageRetain = false;
        this.mUnFinishedPushRetainTimeStamp = -1;
        this.mUnInstalledPushRetainTimeStamp = -1;
        this.mUnInstalledOrderDownloadPushRetainTimeStamp = -1;
        this.mUnInstalledOrderDownloadMessageRetainTimeStamp = -1;
        this.mIsFromGameUnionLive = false;
        this.mHasShowPauseOptimiseDialogCount = 0;
        this.mSendInstallFinishWay = 0;
        this.mRandomClickStartPercent = 0;
        this.mFirstMarketOpenSuccessTimestamp = 0;
        this.isCheckMarketSign = true;
        this.downloadEventConfig = (AdDownloadEventConfig) r101;
        this.downloadController = (AdDownloadController) r102;
        this.downloadModel = (AdDownloadModel) r100;
        this.mDownloadId = r110;
        long r103 = System.currentTimeMillis();
        this.mTimeStamp = r103;
        this.mRecentDownloadResumeTime = r103;
    }
}
