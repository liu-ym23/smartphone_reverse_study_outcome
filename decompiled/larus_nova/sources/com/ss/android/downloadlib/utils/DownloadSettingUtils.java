package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import androidx.camera.core.RetryPolicy;
import androidx.camera.video.AudioStats;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadSettingUtils {
    public static final String TAG = null;

    public DownloadSettingUtils() {
    }

    static {
        TAG = "DownloadSettingUtils";
    }

    public static boolean checkEnableDownloadChainOpt() {
        TTDownloadSettingsModel r100 = TTDownloadSettingsAdapter.INSTANCE.get();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getEnableDownloadChainProcessOpt() != 1) goto L7;
        return true;
    }

    public static JSONObject generateSegmentSettings() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("thread_count", 4);     // Catch: JSONException -> L5
        r100.putOpt(DownloadSettingKeys.SegmentConfig.IP_STRATEGY, 2);     // Catch: JSONException -> L5
        r100.putOpt(DownloadSettingKeys.SegmentConfig.RATIO_SEGMENT, 1);     // Catch: JSONException -> L5
    L6:
        return r100;
    L5:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "generateSegmentSettings", "在构建分块下载配置时出现问题");
        goto L6
    }

    public static JSONObject getAdSettingJson() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 == null) goto L6;
        return r100.getTTDownloaderAdSettings().optJSONObject("ad");
    L6:
        return new JSONObject();
    }

    public static long getInstallInterval() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 == null) goto L5;
        long r101 = r100.getTTDownloaderAdSettings().optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_START_INSTALL_INTERVAL);
    L7:
        if (r101 != 0) goto L10;
        return 300000;
    L10:
        return r101;
    L5:
        r101 = 0;
        goto L7
    }

    public static long getNextInstallMinInterval() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 == null) goto L5;
        long r101 = r100.getTTDownloaderAdSettings().optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_NEXT_INSTALL_MIN_INTERVAL);
    L7:
        if (r101 != 0) goto L10;
        return 10000;
    L10:
        return r101;
    L5:
        r101 = 0;
        goto L7
    }

    public static long interceptInnerTryStartDownloadTimeMs() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
    L5:
        return r100.getTTDownloaderAdSettings().optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.INTERCEPT_INNER_START_DOWNLOAD, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
    }

    public static boolean isEnableStartInstallAgain() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_IS_ENABLE_START_INSTALL_AGAIN) != 1) goto L7;
        return true;
    }

    public static boolean enablePopUpUnInstalledModel() {
        JSONObject r100 = getAdSettingJson();
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 == null) goto L9;
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNINSTALLED_RETAIN_WITH_POP_UP, 0) != 1) goto L9;
    L10:
        return true;
    L9:
        if (r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNINSTALLED_RETAIN_WITH_POP_UP, 0) == 1) goto L10;
        return false;
    }

    public static boolean enablePopUpUnfinishedModel() {
        JSONObject r100 = getAdSettingJson();
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 == null) goto L9;
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNFINISHED_RETAIN_WITH_POP_UP, 0) != 1) goto L9;
    L10:
        return true;
    L9:
        if (r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNFINISHED_RETAIN_WITH_POP_UP, 0) == 1) goto L10;
        return false;
    }

    public static boolean enablePushUnInstalledModel() {
        JSONObject r100 = getAdSettingJson();
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 == null) goto L9;
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNINSTALLED_RETAIN_WITH_PUSH, 0) != 1) goto L9;
    L10:
        return true;
    L9:
        if (r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNINSTALLED_RETAIN_WITH_PUSH, 0) == 1) goto L10;
        return false;
    }

    public static boolean enablePushUnfinishedModel() {
        JSONObject r100 = getAdSettingJson();
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 == null) goto L9;
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNFINISHED_RETAIN_WITH_PUSH, 0) != 1) goto L9;
    L10:
        return true;
    L9:
        if (r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.UNFINISHED_RETAIN_WITH_PUSH, 0) == 1) goto L10;
        return false;
    }

    private static JSONObject appendFailDownloadResumeSetting(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        TTDownloaderLogger r102 = TTDownloaderLogger.INSTANCE;
        String r103 = TAG;
        r102.innerLogD(r103, "checkDownloadSetting", "ad结构下的settings为" + r100);
        ToolUtils.safePut(r101, "failed_resume_max_hours", Double.valueOf(r100.optDouble("failed_resume_max_hours", 72.0d)));
        ToolUtils.safePut(r101, "failed_resume_min_hours", Double.valueOf(r100.optDouble("failed_resume_min_hours", 12.0d)));
        ToolUtils.safePut(r101, "failed_resume_max_count", Integer.valueOf(r100.optInt("failed_resume_max_count", 0)));
        ToolUtils.safePut(r101, com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.AUTO_INSTALL_WHEN_RESUME, Integer.valueOf(r100.optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.AUTO_INSTALL_WHEN_RESUME, 0)));
        ToolUtils.safePut(r101, "failed_resume_need_wait_wifi", Integer.valueOf(r100.optInt("failed_resume_need_wait_wifi", 0)));
        r102.innerLogD(r103, "checkDownloadSetting", "在接口方法内返回的任务级settings为" + r101);
        return r101;
    }

    public static boolean checkEnableGetRedirectDownloadUrl(NativeDownloadModel r100) {
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_GET_REDIRECT_DOWNLOAD_URL, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean checkEnableStarFailDownloadResume(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_ENABLE_STAR_NON_AD_FAIL_DOWNLOAD_RESUME, 0) == 1) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_ENABLE_STAR_NON_AD_FAIL_DOWNLOAD_RESUME, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean checkIfInsertAppendInApkEnabled(NativeDownloadModel r100) {
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_INSERT_APPEND_IN_APK, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean checkIfOverrideEnabled(NativeDownloadModel r100) {
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_CHANNEL_OVERRIDE, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean checkInstallFinishComplianceOptRollBack(NativeDownloadModel r100) {
        if (r100 == null) goto L10;
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_DOWNLOAD_INSTALL_FINISH_OPT_ROLLBACK_SWITCH, 0) == 1) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (GlobalInfo.getDownloadSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_DOWNLOAD_INSTALL_FINISH_OPT_ROLLBACK_SWITCH, 0) == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public static boolean checkJumpManagementOpen(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
    L31:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "check jump management open error");
        return false;
    L5:
        if (r100.isFromGameUnionLive() == false) goto L17;
        JSONObject r102 = getAdSettingJson();     // Catch: Exception -> L31
        if (r102 == null) goto L13;
        if (r102.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L35;
        return true;
    L35:
        return false;
    L13:
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r100.isAd() == true) goto L25;
        JSONObject r103 = getAdSettingJson();     // Catch: Exception -> L31
        if (r103 != null) goto L21;
        return false;
    L21:
        if (r103.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L37;
        return true;
    L37:
        return false;
    L25:
        if (DownloadSetting.obtain(r100.getDownloadId()).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SWITCH, 0) == 1) goto L29;
        if (r101 != null) goto L28;
        return false;
    L28:
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SWITCH, 0) == 1) goto L29;
        return false;
    L29:
        return true;
    }

    public static JSONObject checkNonAdFailResumeDownload(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        JSONObject r102 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (checkEnableStarFailDownloadResume(r100) == false) goto L15;
        boolean r103 = ToolUtils.checkFromStar(r100);
        TTDownloaderLogger r104 = TTDownloaderLogger.INSTANCE;
        String r105 = TAG;
        r104.innerLogD(r105, "checkDownloadSetting", "是否来自星图?" + r103);
        if (r103 == false) goto L14;
        r104.innerLogD(r105, "checkDownloadSetting", "需要针对星图场景优化settings注入策略");
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_ENABLE_STAR_NON_AD_FAIL_DOWNLOAD_RESUME, null, r100);
        if (r101 == null) goto L13;
        r102 = r101.getTTDownloaderAdSettings().optJSONObject("ad");
    L13:
        return appendFailDownloadResumeSetting(r102);
    L14:
        r104.innerLogD(r105, "checkDownloadSetting", "不符合优化场景，不进行处理");
    L15:
        return null;
    }

    public static boolean checkPackageNameEnableOrderMessage(NativeDownloadModel r100) {
        JSONArray r101 = getSetting(r100).optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_PACKAGE_NAME_WHITE_LIST_FOR_ORDER_DOWNLOAD_MESSAGE_RETAIN);
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "checkPackageNameEnableOrderMessage", "获取的预约下载站内信挽留白名单为:" + r101);
        return checkWhiteList(r101, r100.getPackageName());
    }

    public static boolean checkQuickAppOpenDelayCheckOpen(DownloadModel r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_NEED_DO_DELAY_CHECK_FOR_QUICK_APP, 0) != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean checkSpecialAppLinkOpenUrlScheme(String r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r101 == null) goto L5;
        JSONArray r102 = r101.getTTDownloaderAdSettings().optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_OPEN_URL_SCHEME_WHITE_LIST);
    L7:
        return checkWhiteList(r102, r100);
    L5:
        r102 = null;
        goto L7
    }

    public static boolean checkSpecialAppLinkOptOpen(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_ENABLE_SPECIAL_APPLINK_OPT, 0) != 1) goto L13;
        return true;
    L5:
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_ENABLE_SPECIAL_APPLINK_OPT, 0) == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public static boolean checkSpecialAppLinkPackageName(String r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r101 == null) goto L5;
        JSONArray r102 = r101.getTTDownloaderAdSettings().optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_PACKAGE_NAME_WHITE_LIST);
    L7:
        return checkWhiteList(r102, r100);
    L5:
        r102 = null;
        goto L7
    }

    public static boolean cleanAppCacheDir(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_CLEAN_APP_CACHE_DIR, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean cleanSpaceBeforeDownloadSwitch(int r100) {
        if (DownloadSetting.obtain(r100).optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_CLEAN_SPACE_BEFORE_DOWNLOAD_SWITCH, 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean cleanSpaceEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_EXEC_CLEAR_SPACE_SWITCH, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean enableBpeaCert(long r100) {
        NativeDownloadModel r101 = ModelManager.getInstance().getNativeDownloadModel(r100);
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_JUMP_INTENT_BPEA_CERT, 0) != 1) goto L10;
        return true;
    L5:
        if (getSetting(r101).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_JUMP_INTENT_BPEA_CERT, 0) != 1) goto L6;
        return true;
    }

    public static boolean fetchApkSizeSwitch(int r100) {
        if (DownloadSetting.obtain(r100).optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_FETCH_APK_SIZE_SWITCH, 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getFetchApkHeadTimeout(int r100) {
        return DownloadSetting.obtain(r100).optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_FETCH_APK_HEAD_TIME_OUT, 800);
    }

    public static boolean getInstallGuideEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_SWITCH, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean getInstallGuideHuaweiEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_HUAWEI, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String getInstallGuideLottieUrlHuawei(int r100) {
        return DownloadSetting.obtain(r100).optString(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_LOTTIE_URL_HUAWEI);
    }

    public static String getInstallGuideLottieUrlOppo(int r100) {
        return DownloadSetting.obtain(r100).optString(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_LOTTIE_URL_OPPO);
    }

    public static String getInstallGuideLottieUrlVivo(int r100) {
        return DownloadSetting.obtain(r100).optString(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_LOTTIE_URL_VIVO);
    }

    public static String getInstallGuideLottieUrlXiaomi(int r100) {
        return DownloadSetting.obtain(r100).optString(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_LOTTIE_URL_XIAOMI);
    }

    public static boolean getInstallGuideOppoEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_OPPO, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static long getInstallGuideShowTime(int r100) {
        return DownloadSetting.obtain(r100).optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_SHOW_TIME, 3000);
    }

    public static boolean getInstallGuideVivoEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_VIVO, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean getInstallGuideXiaomiEnable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_XIAOMI, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int getInstallHijackDays(int r100) {
        return DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_HIJACK_DAYS, 15);
    }

    public static int getInstallHijackInterval(int r100) {
        return DownloadSetting.obtain(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_GUIDE_INTERVAL, 3);
    }

    public static double getInstallHijackRatio(int r100) {
        return DownloadSetting.obtain(r100).optDouble(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_INSTALL_HIJACK_RATIO, 0.5d);
    }

    public static int getPauseOptimiseCount(NativeDownloadModel r100) {
        if (r100.isAd() == true) goto L10;
        if (getAdSettingJson() != null) goto L7;
        return 2;
    L7:
        return getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SHOW_DIALOG_COUNT, 2);
    L10:
        return getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_SHOW_DIALOG_COUNT, 2);
    }

    public static int getSavePathType(DownloadModel r100) {
        return getSavePathType(getSetting(r100));
    }

    public static DownloadSetting getSetting(NativeDownloadModel r100) {
        if (r100 != null) goto L6;
        return DownloadSetting.obtainGlobal();
    L6:
        if (r100.getDownloadId() == 0) goto L10;
        return DownloadSetting.obtain(r100.getDownloadId());
    L10:
        if (r100.isAd() == false) goto L14;
        return DownloadSetting.obtain(getAdSettingJson());
    L14:
        if (r100.getDownloadSettings() == null) goto L18;
        return DownloadSetting.obtain(r100.getDownloadSettings());
    L18:
        return DownloadSetting.obtainGlobal();
    }

    public static long getStorageMinSize(int r100) {
        return DownloadSetting.obtain(r100).optLong(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_STORAGE_MIN_SIZE, 0);
    }

    public static JSONObject getTaskSettingJson(DownloadModel r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isAd() == false) goto L10;
        return ToolUtils.mergeJson(new JSONObject[]{getAdSettingJson(), r100.getDownloadSettings()});
    L10:
        return r100.getDownloadSettings();
    }

    public static double minInstallSize(int r100) {
        return DownloadSetting.obtain(r100).optDouble(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_MIN_INSTALL_SIZE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static boolean pauseCancelReserveOnWifiIsOpen(NativeDownloadModel r100) {
        if (r100.isFromGameUnionLive() == false) goto L16;
        JSONObject r101 = getAdSettingJson();
        if (r101 == null) goto L12;
        if (r101.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_WIFI_RETAIN_SWITCH, 0) == 1) goto L32;
        return false;
    L32:
        return true;
    L12:
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_WIFI_RETAIN_SWITCH, 0) != 1) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (r100.isAd() == true) goto L26;
        JSONObject r102 = getAdSettingJson();
        if (r102 != null) goto L20;
        return false;
    L20:
        if (r102.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_WIFI_RETAIN_SWITCH, 0) == 1) goto L33;
        return false;
    L33:
        return true;
    L26:
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_WIFI_RETAIN_SWITCH, 0) == 1) goto L28;
    L30:
        return false;
    L28:
        if (r100.enableNewActivity() == false) goto L30;
        return true;
    }

    public static boolean pauseReserveOnWifiIsOpen(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r101 == null) goto L7;
        if (r101.getTTDownloaderAdSettings().optInt("pause_reserve_on_wifi", 0) != 1) goto L7;
    L9:
        if (r100.enableNewActivity() == true) goto L13;
    L11:
        return false;
    L13:
        return true;
    L7:
        if (getSetting(r100).optInt("pause_reserve_on_wifi", 0) != 1) goto L11;
        goto L11
    }

    public static boolean shouldModifyApkName(DownloadSetting r100) {
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KLLK_NEED_RENAME_APK, 0) != 1) goto L7;
        return true;
    }

    public static boolean shouldOpenMarketBySettings(boolean r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r101 != null) goto L5;
    L17:
        return false;
    L5:
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_DISABLE_MARKET) == 1) goto L17;
        if (r100 == false) goto L12;
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_DISABLE_LP_MARKET) != 1) goto L12;
        return false;
    L12:
        if (r101.getTTDownloaderAdSettings().optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SMARTISAN_DISABLE_MARKET, 1) == 1) goto L14;
    L16:
        return true;
    L14:
        if (RomUtils.isSmartisan() == false) goto L16;
        return false;
    }

    public static boolean shouldRequestAppStorePermit(DownloadModel r100) {
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_APPSTORE_PERMIT_REQUEST, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean shouldRollbackLandingPage(DownloadModel r100) {
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.ENABLE_APPSTORE_COMPLIANCE_ROLLBACK, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean whetherDisableInGameLive(NativeDownloadModel r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = "";
    L8:
        if (DownloadSetting.obtain(r100.getDownloadId()).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_DISABLE_GAME_LIVE, 0) == 1) goto L12;
        if (getSetting(r100).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_DISABLE_GAME_LIVE, 0) == 1) goto L12;
        return false;
    L12:
        if (r100.getCallScene() == 8) goto L14;
        return false;
    L14:
        if (TextUtils.equals(r101, BaseConstants.GAME_INFO_LIVE_UNION) == false) goto L19;
        return true;
    L19:
        return false;
    L4:
        if (r100.getExtra() == null) goto L6;
        r101 = r100.getExtra().optString("product_type");
        goto L8
    }

    public static int getSavePathType(DownloadSetting r100) {
        return r100.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SAVE_PATH_TYPE, 0);
    }

    public static DownloadSetting getSetting(DownloadModel r100) {
        return DownloadSetting.obtain(getTaskSettingJson(r100));
    }

    public static boolean checkEnableSegmentDownload(DownloadModel r100, JSONObject r101) {
        JSONObject r102 = getTaskSettingJson(r100);
        boolean r103 = false;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.optInt("ad_segment_download_switch", 0) != 1) goto L8;
        boolean r104 = true;
    L9:
        ToolUtils.safePut(r101, "ad_segment_download_switch", Boolean.valueOf(r104));
        TTDownloaderLogger r105 = TTDownloaderLogger.INSTANCE;
        String r106 = TAG;
        r105.innerLogD(r106, "checkEnableSegmentDownload", "当前是否命中分块下载的开关:" + r104);
        if (r104 == false) goto L16;
        JSONArray r107 = r102.optJSONArray("ad_segment_download_white_list");
        ToolUtils.safePut(r101, "ad_segment_download_white_list", r107);
        r105.innerLogD(r106, "checkEnableSegmentDownload", "获取到的分块下载包名白名单为:" + r107);
        if (r102.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_ENABLE_PACKAGE_NAME_FUZZY_MAPPING, 0) != 1) goto L15;
        r103 = true;
    L15:
        return checkWhiteList(r107, r100.getPackageName(), r103);
    L16:
        return false;
    L8:
        r104 = false;
        goto L9
    }

    public static boolean checkPackageDownloadPriority(DownloadModel r100, JSONObject r101) {
        JSONObject r102 = getTaskSettingJson(r100);
        boolean r103 = false;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_AD_PACKAGE_DOWNLOAD_MAX_PRIORITY_SWITCH, 0) != 1) goto L8;
        r103 = true;
    L8:
        ToolUtils.safePut(r101, EventConstants.ExtraJson.EXTRA_AD_PACKAGE_DOWNLOAD_PRIORITY_SWITCH, Boolean.valueOf(r103));
        TTDownloaderLogger r104 = TTDownloaderLogger.INSTANCE;
        String r105 = TAG;
        r104.innerLogD(r105, "checkPackageDownloadPriority", "当前是否命中提高下载优先级的开关:" + r103);
        if (r103 == false) goto L11;
        return true;
    L11:
        JSONArray r106 = r102.optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_AD_PACKAGE_DOWNLOAD_MAX_PRIORITY_WHITE_LIST);
        ToolUtils.safePut(r101, EventConstants.ExtraJson.EXTRA_AD_PACKAGE_DOWNLOAD_PRIORITY_WHITE_LIST, r106);
        r104.innerLogD(r105, "checkPackageDownloadPriority", "获取到提高下载优先级的白名单为:" + r106);
        return checkWhiteList(r106, r100.getPackageName());
    }

    public static boolean checkSpecialAppLinkOpenUrlScheme(NativeDownloadModel r100, String r101) {
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L7;
        if (r102 == null) goto L6;
        JSONArray r103 = r102.getTTDownloaderAdSettings().optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_OPEN_URL_SCHEME_WHITE_LIST);
    L9:
        return checkWhiteList(r103, r101);
    L6:
        r103 = null;
        goto L9
    L7:
        r103 = getSetting(r100).optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_OPEN_URL_SCHEME_WHITE_LIST);
        goto L9
    }

    public static boolean checkSpecialAppLinkPackageName(NativeDownloadModel r100, String r101) {
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L7;
        if (r102 == null) goto L6;
        JSONArray r103 = r102.getTTDownloaderAdSettings().optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_PACKAGE_NAME_WHITE_LIST);
    L9:
        return checkWhiteList(r103, r101);
    L6:
        r103 = null;
        goto L9
    L7:
        r103 = getSetting(r100).optJSONArray(com.ss.android.downloadlib.constants.DownloadSettingKeys.KEY_SPECIAL_APPLINK_PACKAGE_NAME_WHITE_LIST);
        goto L9
    }

    private static boolean checkWhiteList(JSONArray r100, String r101) {
        return checkWhiteList(r100, r101, false);
    }

    public static boolean enableLandingPageDownloadBugfix(DownloadModel r100, DownloadModel r101) {
        if (r100.getDeepLink() != null) goto L5;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
    L16:
        return false;
    L14:
        if (getSetting(r101).optInt(com.ss.android.downloadlib.constants.DownloadSettingKeys.BUGFIX_LANDING_PAGE_ACTION_NO_MODEL, 1) != 1) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r100.getDeepLink().getWebUrl()) == true) goto L11;
        if (r101.getDeepLink() == null) goto L11;
        if (TextUtils.equals(r100.getDeepLink().getWebUrl(), r101.getDeepLink().getWebUrl()) == false) goto L11;
        r102 = true;
        goto L12
    }

    private static boolean checkWhiteList(JSONArray r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
    L25:
        return false;
    L5:
        if (r100.length() <= 0) goto L25;
        int r103 = 0;
    L8:
        if (r103 >= r100.length()) goto L25;
        String r104 = r100.optString(r103);
        if (r102 == false) goto L21;
        String[] r105 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r106 = r104.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r107 = r105.length;
        int r108 = r106.length;
        if (r107 == r108) goto L14;
        if (r107 <= r108) goto L24;
        if (TextUtils.equals(r105[r107 - 1], AdBaseConstants.BYTEDANCE_PACKAGE_NAME_SUFFIX) == false) goto L24;
        return TextUtils.equals(r101.substring(0, (r107 - 9) - 2), r104);
    L24:
        r103 = r103 + 1;
        goto L8
    L14:
        return TextUtils.equals(r101.replaceAll("\\d+$", ""), r104);
    L21:
        if (TextUtils.equals(r104, r101) == false) goto L24;
        return true;
    }

    public static boolean enableRuntimeAbility(JSONObject r100, String r101, String r102) {
        if (r100 == null) goto L10;
        JSONObject r103 = r100.optJSONObject(r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        if (r103.optInt(r102, 0) != 1) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
