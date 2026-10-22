package com.ss.android.downloadad.api.download;

import android.text.TextUtils;
import com.ss.android.ad.applinksdk.model.BizLineType;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.QuickAppModel;
import com.ss.android.download.api.utils.ToolUtils;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AdDownloadModel implements DownloadModel {
    private BizLineType bizLineType;
    protected boolean isComplianceDataFromLogExtra;
    protected String mAppIcon;
    protected String mAppName;
    protected boolean mAutoInstall;
    protected boolean mAutoInstallWithoutNotification;
    protected List<String> mBackupUrls;
    protected int mCallScene;
    protected List<String> mClickTrackUrl;
    protected String mComplianceData;
    protected DeepLink mDeepLink;
    protected boolean mDistinctDir;
    protected long mDownloadFinishDate;
    protected String mDownloadHandlerTaskKey;
    protected JSONObject mDownloadSettings;
    protected long mDownloadStartDate;
    protected String mDownloadUrl;
    protected boolean mEnablePause;
    protected int mExecutorGroup;
    protected long mExpectFileLength;
    protected JSONObject mExtra;
    protected long mExtraValue;
    protected String mFileName;
    protected String mFilePath;
    protected IDownloadFileUriProvider mFileUriProvider;
    protected int mFunnelType;
    protected int mHasDoInstallation;
    private boolean mHasSendClickIdByContentProvider;
    protected Map<String, String> mHeaders;
    protected long mId;
    protected boolean mIgnoreIntercept;
    protected boolean mIndependentProcess;
    protected long mInstalledDate;
    protected boolean mIsAd;
    protected boolean mIsDownloadManagement;
    protected boolean mIsInExternalPublicDir;
    protected boolean mIsOrderAndShelved;
    private int mIsOrderDownload;
    protected boolean mIsShowNotification;
    protected boolean mIsShowToast;
    protected String mLogExtra;
    protected String mMd5;
    protected String mMimeType;
    protected int mModelType;
    protected boolean mNeedWifi;
    protected String mNotificationJumpUrl;
    private String mOrderId;
    protected String mPackageName;
    protected QuickAppModel mQuickAppModel;
    protected String mSdkMonitorScene;
    protected String mStartToast;
    protected int mTaskKeyCallScene;
    protected JSONObject mTaskKeyObject;
    protected long mThrottleNetSpeed;
    protected int mVersionCode;
    protected String mVersionName;

    public static final class Builder {
        AdDownloadModel model;

        public Builder() {
            this.model = new AdDownloadModel();
        }

        public AdDownloadModel build() {
            return this.model;
        }

        public Builder setAdId(long r100) {
            return setId(r100);
        }

        public Builder setAppIcon(String r100) {
            this.model.mAppIcon = r100;
            return this;
        }

        public Builder setAppName(String r100) {
            this.model.mAppName = r100;
            return this;
        }

        public Builder setAutoInstall(boolean r100) {
            this.model.mAutoInstall = r100;
            return this;
        }

        public Builder setAutoInstallWithoutNotification(boolean r100) {
            this.model.mAutoInstallWithoutNotification = r100;
            return this;
        }

        public Builder setBackupUrls(List<String> r100) {
            this.model.mBackupUrls = r100;
            return this;
        }

        public Builder setBizLineType(BizLineType r100) {
            AdDownloadModel.access$202(this.model, r100);
            return this;
        }

        public Builder setCallScene(int r100) {
            this.model.mCallScene = r100;
            return this;
        }

        public Builder setClickTrackUrl(List<String> r100) {
            this.model.mClickTrackUrl = r100;
            return this;
        }

        public Builder setComplianceData(String r100) {
            this.model.mComplianceData = r100;
            return this;
        }

        public Builder setDeepLink(DeepLink r100) {
            this.model.mDeepLink = r100;
            return this;
        }

        public Builder setDistinctDir(boolean r100) {
            this.model.mDistinctDir = r100;
            return this;
        }

        public Builder setDownloadFinishDate(long r100) {
            this.model.mDownloadFinishDate = r100;
            return this;
        }

        public Builder setDownloadHandlerTaskKey(String r100) {
            this.model.mDownloadHandlerTaskKey = r100;
            return this;
        }

        public Builder setDownloadSettings(JSONObject r100) {
            this.model.mDownloadSettings = r100;
            return this;
        }

        public Builder setDownloadStartDate(long r100) {
            this.model.mDownloadStartDate = r100;
            return this;
        }

        public Builder setDownloadUrl(String r100) {
            this.model.mDownloadUrl = r100;
            return this;
        }

        public Builder setEnablePause(boolean r100) {
            this.model.mEnablePause = r100;
            return this;
        }

        public Builder setExecutorGroup(int r100) {
            this.model.mExecutorGroup = r100;
            return this;
        }

        public Builder setExpectFileLength(long r100) {
            this.model.mExpectFileLength = r100;
            return this;
        }

        public Builder setExtra(JSONObject r100) {
            this.model.mExtra = r100;
            return this;
        }

        public Builder setExtraValue(long r100) {
            this.model.mExtraValue = r100;
            return this;
        }

        public Builder setFileName(String r100) {
            this.model.mFileName = r100;
            return this;
        }

        public Builder setFilePath(String r100) {
            this.model.mFilePath = r100;
            return this;
        }

        public Builder setFileUriProvider(IDownloadFileUriProvider r100) {
            this.model.mFileUriProvider = r100;
            return this;
        }

        public Builder setFunnelType(int r100) {
            this.model.mFunnelType = r100;
            return this;
        }

        public Builder setHasDoInstallation(int r100) {
            this.model.mHasDoInstallation = r100;
            return this;
        }

        public Builder setHeaders(Map<String, String> r100) {
            this.model.mHeaders = r100;
            return this;
        }

        public Builder setId(long r100) {
            this.model.mId = r100;
            return this;
        }

        public Builder setIgnoreIntercept(boolean r100) {
            this.model.mIgnoreIntercept = r100;
            return this;
        }

        public Builder setInstalledDate(long r100) {
            this.model.mInstalledDate = r100;
            return this;
        }

        public Builder setIsAd(boolean r100) {
            this.model.mIsAd = r100;
            return this;
        }

        public Builder setIsDownloadManagement(boolean r100) {
            this.model.mIsDownloadManagement = r100;
            return this;
        }

        public Builder setIsInExternalPublicDir(boolean r100) {
            this.model.mIsInExternalPublicDir = r100;
            return this;
        }

        public Builder setIsOrderDownload(int r100) {
            AdDownloadModel.access$002(this.model, r100);
            return this;
        }

        public Builder setIsShowNotification(boolean r100) {
            this.model.mIsShowNotification = r100;
            return this;
        }

        public Builder setIsShowToast(boolean r100) {
            this.model.mIsShowToast = r100;
            return this;
        }

        public Builder setLogExtra(String r100) {
            this.model.mLogExtra = r100;
            return this;
        }

        public Builder setMd5(String r100) {
            this.model.mMd5 = r100;
            return this;
        }

        public Builder setMimeType(String r100) {
            this.model.mMimeType = r100;
            return this;
        }

        public Builder setModelType(int r100) {
            this.model.mModelType = r100;
            return this;
        }

        public Builder setNeedIndependentProcess(boolean r100) {
            this.model.mIndependentProcess = r100;
            return this;
        }

        public Builder setNeedWifi(boolean r100) {
            this.model.mNeedWifi = r100;
            return this;
        }

        public Builder setNotificationJumpUrl(String r100) {
            this.model.mNotificationJumpUrl = r100;
            return this;
        }

        public Builder setOrderId(String r100) {
            AdDownloadModel.access$102(this.model, r100);
            return this;
        }

        public Builder setPackageName(String r100) {
            this.model.mPackageName = r100;
            return this;
        }

        public Builder setQuickAppModel(QuickAppModel r100) {
            this.model.mQuickAppModel = r100;
            return this;
        }

        public Builder setSdkMonitorScene(String r100) {
            this.model.mSdkMonitorScene = r100;
            return this;
        }

        public Builder setStartToast(String r100) {
            this.model.mStartToast = r100;
            return this;
        }

        public Builder setTaskKeyCallScene(int r100) {
            this.model.mTaskKeyCallScene = r100;
            return this;
        }

        public Builder setTaskKeyObject(JSONObject r100) {
            this.model.mTaskKeyObject = r100;
            return this;
        }

        public Builder setThrottleNetSpeed(long r100) {
            this.model.mThrottleNetSpeed = r100;
            return this;
        }

        public Builder setVersionCode(int r100) {
            this.model.mVersionCode = r100;
            return this;
        }

        public Builder setVersionName(String r100) {
            this.model.mVersionName = r100;
            return this;
        }
    }

    public interface JsonKey {
        public static final String APP_ICON = "app_icon";
        public static final String APP_NAME = "app_name";
        public static final String AUTO_INSTALL = "auto_install";
        public static final String AUTO_INSTALL_WITHOUT_NOTIFY = "auto_install_without_notify";
        public static final String BACKUP_URLS = "backup_urls";
        public static final String BIZ_LINE_TYPE = "biz_line_type";
        public static final String CALL_SCENE = "call_scene";
        public static final String CLICK_TRACK_URLS = "click_track_urls";
        public static final String COMPLIANCE_DATA = "compliance_data";
        public static final String DISTINCT_DIR = "distinct_dir";
        public static final String DOWNLOAD_FINISH_DATE = "download_finish_date";
        public static final String DOWNLOAD_HANDLER_TASKKEY = "download_handler_taskkey";
        public static final String DOWNLOAD_SETTINGS = "download_settings";
        public static final String DOWNLOAD_START_DATE = "download_start_date";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String ENABLE_PAUSE = "enable_pause";
        public static final String EXECUTOR_GROUP = "executor_group";
        public static final String EXPECT_FILE_LENGTH = "expect_file_length";
        public static final String EXTRA = "extra";
        public static final String EXT_VALUE = "ext_value";
        public static final String FILE_NAME = "file_name";
        public static final String FILE_PATH = "file_path";
        public static final String HAS_DO_INSTALLATION = "has_do_installation";
        public static final String HAS_SEND_CLICK_ID_BY_CONTENT_PROVIDER = "has_send_click_id_by_content_provider";
        public static final String HEADER_KEYS = "header_keys";
        public static final String HEADER_VALUES = "header_values";
        public static final String ID = "id";
        public static final String IGNORE_INTERCEPT = "ignore_intercept";
        public static final String INDEPENDENT_PROCESS = "independent_process";
        public static final String INSTALLED_DATE = "installed_date";
        public static final String IS_AD = "is_ad";
        public static final String IS_DOWNLOAD_MANAGEMENT = "is_download_management";
        public static final String IS_ORDER_DOWNLOAD = "is_order_download";
        public static final String IS_SHOW_TOAST = "is_show_toast";
        public static final String LOG_EXTRA = "log_extra";
        public static final String MD5 = "md5";
        public static final String MIME_TYPE = "mime_type";
        public static final String MODEL_TYPE = "model_type";
        public static final String NEED_WIFI = "need_wifi";
        public static final String NOTIFICATION_JUMP_URL = "notification_jump_url";
        public static final String OPEN_URL = "open_url";
        public static final String ORDER_ID = "order_id";
        public static final String PACKAGE_NAME = "package_name";
        public static final String QUICK_APP_URL = "quick_app_url";
        public static final String SDK_MONITOR_SCENE = "sdk_monitor_scene";
        public static final String SHOW_NOTIFICATION = "show_notification";
        public static final String START_TOAST = "start_toast";
        public static final String TASKKEY_CALL_SCENE = "taskkey_call_scene";
        public static final String TASKKEY_OBJECT = "taskkey_object";
        public static final String VERSION_CODE = "version_code";
        public static final String VERSION_NAME = "version_name";
        public static final String WEB_URL = "web_url";
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        this.mNeedWifi = true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return true;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("id", this.mId);     // Catch: Exception -> L93
        int r101 = 1;
        if (this.mIsAd == false) goto L6;
        int r102 = 1;
    L7:
        r100.put("is_ad", r102);     // Catch: Exception -> L93
        r100.putOpt(JsonKey.MODEL_TYPE, Integer.valueOf(this.mModelType));     // Catch: Exception -> L93
        r100.putOpt("mime_type", this.mMimeType);     // Catch: Exception -> L93
        r100.putOpt("ext_value", Long.valueOf(this.mExtraValue));     // Catch: Exception -> L93
        r100.putOpt("log_extra", this.mLogExtra);     // Catch: Exception -> L93
        r100.putOpt("package_name", this.mPackageName);     // Catch: Exception -> L93
        r100.putOpt("download_url", this.mDownloadUrl);     // Catch: Exception -> L93
        r100.putOpt("app_name", this.mAppName);     // Catch: Exception -> L93
        r100.putOpt("app_icon", this.mAppIcon);     // Catch: Exception -> L93
        if (this.mIsShowToast == false) goto L10;
        int r103 = 1;
    L11:
        r100.putOpt(JsonKey.IS_SHOW_TOAST, Integer.valueOf(r103));     // Catch: Exception -> L93
        if (this.mIsShowNotification == false) goto L14;
        int r104 = 1;
    L15:
        r100.putOpt("show_notification", Integer.valueOf(r104));     // Catch: Exception -> L93
        if (this.mNeedWifi == false) goto L18;
        int r105 = 1;
    L19:
        r100.put(JsonKey.NEED_WIFI, r105);     // Catch: Exception -> L93
        r100.put("md5", this.mMd5);     // Catch: Exception -> L93
        r100.put("expect_file_length", this.mExpectFileLength);     // Catch: Exception -> L93
        if (this.mIndependentProcess == false) goto L22;
        int r106 = 1;
    L23:
        r100.put(JsonKey.INDEPENDENT_PROCESS, r106);     // Catch: Exception -> L93
        r100.put("version_code", this.mVersionCode);     // Catch: Exception -> L93
        r100.putOpt("version_name", this.mVersionName);     // Catch: Exception -> L93
        r100.putOpt("file_path", this.mFilePath);     // Catch: Exception -> L93
        r100.putOpt("file_name", this.mFileName);     // Catch: Exception -> L93
        r100.putOpt("notification_jump_url", this.mNotificationJumpUrl);     // Catch: Exception -> L93
        if (this.mAutoInstallWithoutNotification == false) goto L26;
        int r107 = 1;
    L27:
        r100.putOpt(JsonKey.AUTO_INSTALL_WITHOUT_NOTIFY, Integer.valueOf(r107));     // Catch: Exception -> L93
        r100.putOpt("executor_group", Integer.valueOf(this.mExecutorGroup));     // Catch: Exception -> L93
        r100.putOpt(JsonKey.START_TOAST, this.mStartToast);     // Catch: Exception -> L93
        r100.putOpt(JsonKey.SDK_MONITOR_SCENE, this.mSdkMonitorScene);     // Catch: Exception -> L93
        if (this.mAutoInstall == false) goto L30;
        int r108 = 1;
    L31:
        r100.putOpt("auto_install", Integer.valueOf(r108));     // Catch: Exception -> L93
        if (this.mDistinctDir == false) goto L34;
        int r109 = 1;
    L35:
        r100.putOpt(JsonKey.DISTINCT_DIR, Integer.valueOf(r109));     // Catch: Exception -> L93
        if (this.mEnablePause == false) goto L38;
        int r110 = 1;
    L39:
        r100.putOpt("enable_pause", Integer.valueOf(r110));     // Catch: Exception -> L93
        r100.putOpt("call_scene", Integer.valueOf(this.mCallScene));     // Catch: Exception -> L93
        r100.putOpt("ignore_intercept", Boolean.valueOf(this.mIgnoreIntercept));     // Catch: Exception -> L93
        r100.putOpt("compliance_data", this.mComplianceData);     // Catch: Exception -> L93
        r100.putOpt("installed_date", Long.valueOf(this.mInstalledDate));     // Catch: Exception -> L93
        r100.putOpt("download_start_date", Long.valueOf(this.mDownloadStartDate));     // Catch: Exception -> L93
        r100.putOpt("download_finish_date", Long.valueOf(this.mDownloadFinishDate));     // Catch: Exception -> L93
        r100.putOpt(JsonKey.HAS_DO_INSTALLATION, Integer.valueOf(this.mHasDoInstallation));     // Catch: Exception -> L93
        if (this.mIsDownloadManagement == true) goto L43;
        r101 = 0;
    L43:
        r100.putOpt(JsonKey.IS_DOWNLOAD_MANAGEMENT, Integer.valueOf(r101));     // Catch: Exception -> L93
        r100.putOpt(JsonKey.TASKKEY_CALL_SCENE, Integer.valueOf(this.mTaskKeyCallScene));     // Catch: Exception -> L93
        r100.putOpt("is_order_download", Integer.valueOf(this.mIsOrderDownload));     // Catch: Exception -> L93
        r100.putOpt("order_id", this.mOrderId);     // Catch: Exception -> L93
        r100.putOpt(JsonKey.BIZ_LINE_TYPE, this.bizLineType);     // Catch: Exception -> L93
        Object r111 = this.mTaskKeyObject;     // Catch: Exception -> L93
        if (r111 == null) goto L46;
        r100.putOpt("taskkey_object", r111);     // Catch: Exception -> L93
    L46:
        r100.putOpt("download_handler_taskkey", this.mDownloadHandlerTaskKey);     // Catch: Exception -> L93
        Object r112 = this.mDownloadSettings;     // Catch: Exception -> L93
        if (r112 == null) goto L49;
        r100.put(JsonKey.DOWNLOAD_SETTINGS, r112);     // Catch: Exception -> L93
    L49:
        List<String> r113 = this.mBackupUrls;     // Catch: Exception -> L93
        if (r113 != null) goto L52;
    L60:
        DeepLink r114 = this.mDeepLink;     // Catch: Exception -> L93
        if (r114 != null) goto L63;
    L68:
        QuickAppModel r115 = this.mQuickAppModel;     // Catch: Exception -> L93
        if (r115 == null) goto L71;
        r100.putOpt(JsonKey.QUICK_APP_URL, r115.getQuickOpenUrl());     // Catch: Exception -> L93
    L71:
        List<String> r116 = this.mClickTrackUrl;     // Catch: Exception -> L93
        if (r116 != null) goto L74;
    L80:
        Object r117 = this.mExtra;     // Catch: Exception -> L93
        if (r117 == null) goto L83;
        r100.put("extra", r117);     // Catch: Exception -> L93
    L83:
        Map<String, String> r118 = this.mHeaders;     // Catch: Exception -> L93
        if (r118 != null) goto L86;
    L95:
        return r100;
    L86:
        if (r118.isEmpty() == true) goto L95;
        JSONArray r119 = new JSONArray();     // Catch: Exception -> L93
        JSONArray r120 = new JSONArray();     // Catch: Exception -> L93
        Iterator<Map.Entry<String, String>> r121 = this.mHeaders.entrySet().iterator();     // Catch: Exception -> L93
    L89:
        if (r121.hasNext() == false) goto L91;
        Map.Entry<String, String> r122 = r121.next();     // Catch: Exception -> L93
        r119.put(r122.getKey());     // Catch: Exception -> L93
        r120.put(r122.getKey());     // Catch: Exception -> L93
        goto L89
    L91:
        r100.put(JsonKey.HEADER_KEYS, r119);     // Catch: Exception -> L93
        r100.put(JsonKey.HEADER_VALUES, r120);     // Catch: Exception -> L93
        goto L95
    L74:
        if (r116.isEmpty() == true) goto L80;
        JSONArray r123 = new JSONArray();     // Catch: Exception -> L93
        Iterator<String> r124 = this.mClickTrackUrl.iterator();     // Catch: Exception -> L93
    L77:
        if (r124.hasNext() == false) goto L79;
        r123.put(r124.next());     // Catch: Exception -> L93
        goto L77
    L79:
        r100.put(JsonKey.CLICK_TRACK_URLS, r123);     // Catch: Exception -> L93
        goto L80
    L63:
        if (TextUtils.isEmpty(r114.getOpenUrl()) == true) goto L66;
        r100.put("open_url", this.mDeepLink.getOpenUrl());     // Catch: Exception -> L93
    L66:
        if (TextUtils.isEmpty(this.mDeepLink.getWebUrl()) == true) goto L68;
        r100.put("web_url", this.mDeepLink.getWebUrl());     // Catch: Exception -> L93
        goto L68
    L52:
        if (r113.isEmpty() == true) goto L60;
        JSONArray r125 = new JSONArray();     // Catch: Exception -> L93
        Iterator<String> r126 = this.mBackupUrls.iterator();     // Catch: Exception -> L93
    L55:
        if (r126.hasNext() == false) goto L59;
        String r127 = r126.next();     // Catch: Exception -> L93
        if (TextUtils.isEmpty(r127) == true) goto L55;
        r125.put(r127);     // Catch: Exception -> L93
        goto L55
    L59:
        r100.put(JsonKey.BACKUP_URLS, r125);     // Catch: Exception -> L93
        goto L60
    L38:
        r110 = 0;
        goto L39
    L34:
        r109 = 0;
        goto L35
    L30:
        r108 = 0;
        goto L31
    L26:
        r107 = 0;
        goto L27
    L22:
        r106 = 0;
        goto L23
    L18:
        r105 = 0;
        goto L19
    L14:
        r104 = 0;
        goto L15
    L10:
        r103 = 0;
        goto L11
    L6:
        r102 = 0;
    L93:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadModel toJson");
        goto L95
    }

    public AdDownloadModel() {
        this.mIsAd = true;
        this.mIsShowToast = true;
        this.mIsShowNotification = true;
        this.mAutoInstall = true;
        this.mNeedWifi = false;
        this.mExecutorGroup = 2;
        this.mEnablePause = true;
        this.mCallScene = 0;
        this.mIsDownloadManagement = false;
        this.mIgnoreIntercept = false;
        this.mHasDoInstallation = 0;
        this.mFunnelType = 1;
        this.isComplianceDataFromLogExtra = true;
        this.mIsOrderAndShelved = false;
        this.mTaskKeyCallScene = -1;
        this.mHasSendClickIdByContentProvider = false;
        this.mIsOrderDownload = 0;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getComplianceData() {
        if (isAd() == false) goto L8;
        if (TextUtils.isEmpty(this.mComplianceData) == false) goto L8;
        this.mComplianceData = ToolUtils.getComplianceDataFromLogExtra(getLogExtra());
        this.isComplianceDataFromLogExtra = true;
    L8:
        return this.mComplianceData;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        return ToolUtils.shouldDownloadWithPatchApply(DownloadSetting.obtain(getDownloadSettings()), getMimeType());
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean autoInstallWithoutNotification() {
        return this.mAutoInstallWithoutNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean distinctDir() {
        return this.mDistinctDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean enablePause() {
        return this.mEnablePause;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getAppIcon() {
        return this.mAppIcon;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getBackupUrls() {
        return this.mBackupUrls;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public BizLineType getBizLineType() {
        return this.bizLineType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getCallScene() {
        return this.mCallScene;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public DeepLink getDeepLink() {
        return this.mDeepLink;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public IDownloadFileUriProvider getDownloadFileUriProvider() {
        return this.mFileUriProvider;
    }

    public long getDownloadFinishDate() {
        return this.mDownloadFinishDate;
    }

    public String getDownloadHandlerTaskKey() {
        return this.mDownloadHandlerTaskKey;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getDownloadSettings() {
        return this.mDownloadSettings;
    }

    public long getDownloadStartDate() {
        return this.mDownloadStartDate;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getExecutorGroup() {
        return this.mExecutorGroup;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExpectFileLength() {
        return this.mExpectFileLength;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getExtra() {
        return this.mExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getFunnelType() {
        return this.mFunnelType;
    }

    public int getHasDoInstallation() {
        return this.mHasDoInstallation;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        return this.mId;
    }

    public long getInstalledDate() {
        return this.mInstalledDate;
    }

    public int getIsOrderDownload() {
        return this.mIsOrderDownload;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getLogExtra() {
        return this.mLogExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMd5() {
        return this.mMd5;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        return this.mModelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getName() {
        return this.mAppName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getNotificationJumpUrl() {
        return this.mNotificationJumpUrl;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public QuickAppModel getQuickAppModel() {
        return this.mQuickAppModel;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getSdkMonitorScene() {
        return this.mSdkMonitorScene;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getStartToast() {
        return this.mStartToast;
    }

    public int getTaskKeyCallScene() {
        return this.mTaskKeyCallScene;
    }

    public JSONObject getTaskKeyObject() {
        return this.mTaskKeyObject;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getThrottleNetSpeed() {
        return this.mThrottleNetSpeed;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getVersionName() {
        return this.mVersionName;
    }

    public boolean hasSendClickIdByContentProvider() {
        return this.mHasSendClickIdByContentProvider;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean ignoreIntercept() {
        return this.mIgnoreIntercept;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        return this.mIsAd;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAutoInstall() {
        return this.mAutoInstall;
    }

    public boolean isComplianceDataFromLogExtra() {
        return this.isComplianceDataFromLogExtra;
    }

    public boolean isFromDownloadManagement() {
        return this.mIsDownloadManagement;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        return this.mNeedWifi;
    }

    public boolean isOrderAndShelved() {
        return this.mIsOrderAndShelved;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean needIndependentProcess() {
        return this.mIndependentProcess;
    }

    public static AdDownloadModel fromJson(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Builder r101 = new Builder();
        Builder r102 = r101.setAdId(ToolUtils.optLong(r100, "id"));     // Catch: Exception -> L52
        boolean r103 = true;
        if (r100.optInt("is_ad", 1) != 1) goto L9;
        boolean r104 = true;
    L10:
        Builder r105 = r102.setIsAd(r104).setModelType(r100.optInt(JsonKey.MODEL_TYPE)).setMimeType(r100.optString("mime_type")).setExtraValue(ToolUtils.optLong(r100, "ext_value")).setLogExtra(r100.optString("log_extra")).setPackageName(r100.optString("package_name")).setDownloadUrl(r100.optString("download_url")).setAppName(r100.optString("app_name")).setAppIcon(r100.optString("app_icon"));     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.IS_SHOW_TOAST, 1) != 1) goto L13;
        boolean r106 = true;
    L14:
        Builder r107 = r105.setIsShowToast(r106);     // Catch: Exception -> L52
        if (r100.optInt("show_notification", 1) != 1) goto L17;
        boolean r108 = true;
    L18:
        Builder r109 = r107.setIsShowNotification(r108).setExecutorGroup(r100.optInt("executor_group"));     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.NEED_WIFI) != 1) goto L21;
        boolean r110 = true;
    L22:
        Builder r111 = r109.setNeedWifi(r110).setMd5(r100.optString("md5")).setExpectFileLength(r100.optLong("expect_file_length"));     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.INDEPENDENT_PROCESS) != 1) goto L25;
        boolean r112 = true;
    L26:
        Builder r113 = r111.setNeedIndependentProcess(r112).setVersionCode(r100.optInt("version_code")).setVersionName(r100.optString("version_name")).setFilePath(r100.optString("file_path")).setFileName(r100.optString("file_name")).setNotificationJumpUrl(r100.optString("notification_jump_url"));     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.AUTO_INSTALL_WITHOUT_NOTIFY) != 1) goto L29;
        boolean r114 = true;
    L30:
        Builder r115 = r113.setAutoInstallWithoutNotification(r114).setDownloadSettings(r100.optJSONObject(JsonKey.DOWNLOAD_SETTINGS)).setExtra(r100.optJSONObject("extra")).setStartToast(r100.optString(JsonKey.START_TOAST)).setSdkMonitorScene(r100.optString(JsonKey.SDK_MONITOR_SCENE));     // Catch: Exception -> L52
        if (r100.optInt("auto_install", 1) != 1) goto L33;
        boolean r116 = true;
    L34:
        Builder r117 = r115.setAutoInstall(r116);     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.DISTINCT_DIR) != 1) goto L37;
        boolean r118 = true;
    L38:
        Builder r119 = r117.setDistinctDir(r118);     // Catch: Exception -> L52
        if (r100.optInt("enable_pause", 1) != 1) goto L41;
        boolean r120 = true;
    L42:
        Builder r121 = r119.setEnablePause(r120).setCallScene(r100.optInt("call_scene", 0));     // Catch: Exception -> L52
        if (r100.optInt("ignore_intercept", 0) != 1) goto L45;
        boolean r122 = true;
    L46:
        Builder r123 = r121.setIgnoreIntercept(r122).setComplianceData(r100.optString("compliance_data")).setInstalledDate(r100.optLong("installed_date")).setDownloadStartDate(r100.optLong("download_start_date")).setDownloadFinishDate(r100.optLong("download_finish_date")).setHasDoInstallation(r100.optInt(JsonKey.HAS_DO_INSTALLATION, 0));     // Catch: Exception -> L52
        if (r100.optInt(JsonKey.IS_DOWNLOAD_MANAGEMENT, 0) == 1) goto L50;
        r103 = false;
    L50:
        r123.setIsDownloadManagement(r103).setTaskKeyCallScene(r100.optInt(JsonKey.TASKKEY_CALL_SCENE, -1)).setTaskKeyObject(r100.optJSONObject("taskkey_object")).setDownloadHandlerTaskKey(r100.optString("download_handler_taskkey")).setIsOrderDownload(r100.optInt("is_order_download")).setOrderId(r100.optString("order_id"));     // Catch: Exception -> L52
        appendDeepLinkFromJson(r100, r101);     // Catch: Exception -> L52
        appendQuickAppUrlFromJson(r100, r101);     // Catch: Exception -> L52
        appendTrackUrlFromJson(r100, r101);     // Catch: Exception -> L52
        appendHeaderMapFromJson(r100, r101);     // Catch: Exception -> L52
        appendBackupUrlsFromJson(r100, r101);     // Catch: Exception -> L52
    L55:
        return r101.build();
    L45:
        r122 = false;
        goto L46
    L41:
        r120 = false;
        goto L42
    L37:
        r118 = false;
        goto L38
    L33:
        r116 = false;
        goto L34
    L29:
        r114 = false;
        goto L30
    L25:
        r112 = false;
        goto L26
    L21:
        r110 = false;
        goto L22
    L17:
        r108 = false;
        goto L18
    L13:
        r106 = false;
        goto L14
    L9:
        r104 = false;
    L52:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadModel fromJson");
        goto L55
    }

    public AdDownloadModel setAdId(long r100) {
        return setId(r100);
    }

    public AdDownloadModel setAppIcon(String r100) {
        this.mAppIcon = r100;
        return this;
    }

    public void setAppName(String r100) {
        this.mAppName = r100;
    }

    public AdDownloadModel setAutoInstallWithoutNotification(boolean r100) {
        this.mAutoInstallWithoutNotification = r100;
        return this;
    }

    public AdDownloadModel setBackupUrls(List<String> r100) {
        this.mBackupUrls = r100;
        return this;
    }

    public void setBizLineType(BizLineType r100) {
        this.bizLineType = r100;
    }

    public AdDownloadModel setCallScene(int r100) {
        this.mCallScene = r100;
        return this;
    }

    public AdDownloadModel setClickTrackUrl(List<String> r100) {
        this.mClickTrackUrl = r100;
        return this;
    }

    public AdDownloadModel setComplianceData(String r100) {
        this.mComplianceData = r100;
        this.isComplianceDataFromLogExtra = false;
        return this;
    }

    public AdDownloadModel setDeepLink(DeepLink r100) {
        this.mDeepLink = r100;
        return this;
    }

    public void setDistinctDir(boolean r100) {
        this.mDistinctDir = r100;
    }

    public AdDownloadModel setDownloadFinishDate(long r100) {
        this.mDownloadFinishDate = r100;
        return this;
    }

    public void setDownloadHandlerTaskKey(String r100) {
        this.mDownloadHandlerTaskKey = r100;
    }

    public void setDownloadSettings(JSONObject r100) {
        this.mDownloadSettings = r100;
    }

    public AdDownloadModel setDownloadStartDate(long r100) {
        this.mDownloadStartDate = r100;
        return this;
    }

    public AdDownloadModel setDownloadUrl(String r100) {
        this.mDownloadUrl = r100;
        return this;
    }

    public void setExpectFileLength(long r100) {
        this.mExpectFileLength = r100;
    }

    public void setExtra(JSONObject r100) {
        this.mExtra = r100;
    }

    public void setExtraValue(long r100) {
        this.mExtraValue = r100;
    }

    public AdDownloadModel setFileName(String r100) {
        this.mFileName = r100;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public /* bridge */ /* synthetic */ DownloadModel setFilePath(String r100) {
        return setFilePath(r100);
    }

    public AdDownloadModel setFileUriProvider(IDownloadFileUriProvider r100) {
        this.mFileUriProvider = r100;
        return this;
    }

    public AdDownloadModel setFunnelType(int r100) {
        this.mFunnelType = r100;
        return this;
    }

    public AdDownloadModel setHasDoInstallation(int r100) {
        this.mHasDoInstallation = r100;
        return this;
    }

    public void setHasSendClickIdByContentProvider(boolean r100) {
        this.mHasSendClickIdByContentProvider = r100;
    }

    public AdDownloadModel setHeaders(Map<String, String> r100) {
        this.mHeaders = r100;
        return this;
    }

    public AdDownloadModel setId(long r100) {
        this.mId = r100;
        return this;
    }

    public void setIgnoreIntercept(boolean r100) {
        this.mIgnoreIntercept = r100;
    }

    public AdDownloadModel setInstalledDate(long r100) {
        this.mInstalledDate = r100;
        return this;
    }

    public AdDownloadModel setIsAd(boolean r100) {
        this.mIsAd = r100;
        return this;
    }

    public AdDownloadModel setIsDownloadManagement(boolean r100) {
        this.mIsDownloadManagement = r100;
        return this;
    }

    public void setIsOrderAndShelved(boolean r100) {
        this.mIsOrderAndShelved = r100;
    }

    public void setIsOrderDownload(int r100) {
        this.mIsOrderDownload = r100;
    }

    public AdDownloadModel setIsShowNotification(boolean r100) {
        this.mIsShowNotification = r100;
        return this;
    }

    public void setIsShowToast(boolean r100) {
        this.mIsShowToast = r100;
    }

    public AdDownloadModel setLogExtra(String r100) {
        this.mLogExtra = r100;
        return this;
    }

    public void setMd5(String r100) {
        this.mMd5 = r100;
    }

    public AdDownloadModel setMimeType(String r100) {
        this.mMimeType = r100;
        return this;
    }

    public AdDownloadModel setModelType(int r100) {
        this.mModelType = r100;
        return this;
    }

    public AdDownloadModel setNeedIndependentProcess(boolean r100) {
        this.mIndependentProcess = r100;
        return this;
    }

    public void setNeedWifi(boolean r100) {
        this.mNeedWifi = r100;
    }

    public AdDownloadModel setNotificationJumpUrl(String r100) {
        this.mNotificationJumpUrl = r100;
        return this;
    }

    public void setOrderId(String r100) {
        this.mOrderId = r100;
    }

    public AdDownloadModel setPackageName(String r100) {
        this.mPackageName = r100;
        return this;
    }

    public AdDownloadModel setQuickAppModel(QuickAppModel r100) {
        this.mQuickAppModel = r100;
        return this;
    }

    public void setSdkMonitorScene(String r100) {
        this.mSdkMonitorScene = r100;
    }

    public void setStartToast(String r100) {
        this.mStartToast = r100;
    }

    public void setTaskKeyCallScene(int r100) {
        this.mTaskKeyCallScene = r100;
    }

    public void setTaskKeyObject(JSONObject r100) {
        this.mTaskKeyObject = r100;
    }

    public AdDownloadModel setVersionCode(int r100) {
        this.mVersionCode = r100;
        return this;
    }

    public AdDownloadModel setVersionName(String r100) {
        this.mVersionName = r100;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public AdDownloadModel setFilePath(String r100) {
        this.mFilePath = r100;
        return this;
    }

    public static /* synthetic */ int access$002(AdDownloadModel r100, int r101) {
        r100.mIsOrderDownload = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(AdDownloadModel r100, String r101) {
        r100.mOrderId = r101;
        return r101;
    }

    public static /* synthetic */ BizLineType access$202(AdDownloadModel r100, BizLineType r101) {
        r100.bizLineType = r101;
        return r101;
    }

    private static void appendBackupUrlsFromJson(JSONObject r100, Builder r101) {
        JSONArray r102 = r100.optJSONArray(JsonKey.BACKUP_URLS);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length() <= 0) goto L14;
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L8:
        if (r104 >= r102.length()) goto L10;
        r103.add(r102.optString(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        r101.setBackupUrls(r103);
        return;
    }

    private static void appendDeepLinkFromJson(JSONObject r100, Builder r101) {
        r101.setDeepLink(new DeepLink(r100.optString("open_url"), r100.optString("web_url"), null));
    }

    private static void appendHeaderMapFromJson(JSONObject r100, Builder r101) {
        JSONArray r102 = r100.optJSONArray(JsonKey.HEADER_KEYS);
        JSONArray r103 = r100.optJSONArray(JsonKey.HEADER_VALUES);
        if (r102 == null) goto L12;
        if (r103 == null) goto L13;
        HashMap r104 = new HashMap();
        int r105 = 0;
    L7:
        if (r105 >= r102.length()) goto L9;
        r104.put(r102.optString(r105), r103.optString(r105));
        r105 = r105 + 1;
        goto L7
    L9:
        r101.setHeaders(r104);
        return;
    L13:
        return;
    }

    private static void appendQuickAppUrlFromJson(JSONObject r100, Builder r101) {
        String r102 = r100.optString(JsonKey.QUICK_APP_URL);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101.setQuickAppModel(new QuickAppModel.Builder().setOpenUrl(r102).build());
        return;
    }

    private static void appendTrackUrlFromJson(JSONObject r100, Builder r101) {
        JSONArray r102 = r100.optJSONArray(JsonKey.CLICK_TRACK_URLS);
        if (r102 == null) goto L11;
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L6:
        if (r104 >= r102.length()) goto L8;
        r103.add(r102.optString(r104));
        r104 = r104 + 1;
        goto L6
    L8:
        r101.setClickTrackUrl(r103);
        return;
    }
}
