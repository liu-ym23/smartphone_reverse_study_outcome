package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadFileUriProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.ApkInstallDetector;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.appdownloader.util.package_info.PackageInfoUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.lang.ref.SoftReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadUtils {
    public static final String BIND_APP_EXTRA = "bind_app";
    private static final String DEFAULT_CHANNEL_ID = "111111";
    private static final String DEFAULT_CHANNEL_NAME = "channel_appdownloader";
    public static final String MIUI_SECURITY_NAME = "com.miui.enterprise.service.EntInstallService";
    public static final String MIUI_SECURITY_PKG = "com.miui.securitycore";
    public static final int START_VIEW_INTENT_AND_INSTALLED = 3;
    public static final int START_VIEW_INTENT_FAILED = 0;
    public static final int START_VIEW_INTENT_INTERCEPT = 2;
    public static final int START_VIEW_INTENT_SUCCESS = 1;
    private static final String TAG = "AppDownloadUtils";
    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_COMPLETE = 3;
    public static final int TYPE_PREPARE = 4;
    public static final int TYPE_WAITING = 2;
    private static SoftReference<Activity> activityRef;
    private static Map<String, String> mAppInstallStats;
    private static NotificationChannel mNotificationChannel;
    private static boolean mStatsEnabled;
    private static Object mStatsLock;
    private static int sStartViewIntentResult;

    public AppDownloadUtils() {
    }

    public static int getPackageInfoFlag() {
        return 16384;
    }

    static {
        mStatsLock = new Object();
        mAppInstallStats = new LinkedHashMap();
        mNotificationChannel = null;
    }

    public static List<String> getApplicationMimeTypes() {
        ArrayList r100 = new ArrayList(2);
        r100.add("application/vnd.android.package-archive");
        r100.add(Constants.MIME_PATCH);
        return r100;
    }

    public static Activity popActivity() {
        SoftReference<Activity> r100 = activityRef;
        if (r100 != null) goto L5;
        Activity r101 = null;
    L6:
        activityRef = null;
        return r101;
    L5:
        r101 = r100.get();
        goto L6
    }

    private static void reportStats() {
        Object r100 = mStatsLock;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mAppInstallStats.isEmpty() == false) goto L23;
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L23:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L14
        r101.put("reportStats", "Report with schedule");     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, String>> r102 = mAppInstallStats.entrySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Throwable -> L14
        r101.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L14
        goto L10
    L12:
        AppDownloader.getInstance().getAppInstallMonitorListener().onMonitorSend(r101);     // Catch: Throwable -> L14
    L16:
        mAppInstallStats.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        goto L16
    }

    public static String getAppDownloadPath() {
        return DownloadUtils.getDownloadPath();
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void access$000() {
        reportStats();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_AppDownloadUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ int access$102(int r100) {
        sStartViewIntentResult = r100;
        return r100;
    }

    private static void beginStats(int r100) {
        if (AppDownloader.getInstance().getAppInstallMonitorListener() != null) goto L5;
        return;
    L5:
        int r101 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_REPORT_STATS_DELAY_TIME_S);
        if (r101 > 0) goto L8;
        return;
    L8:
        mStatsEnabled = true;
        Object r102 = mStatsLock;
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L11:
        if (mAppInstallStats.isEmpty() == false) goto L13;
    L17:
        mAppInstallStats.put(String.valueOf(r100), "id");     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).submitScheduleTask(new AnonymousClass1(), r101, TimeUnit.SECONDS);
        return;
    L13:
        if (mAppInstallStats.containsKey(String.valueOf(r100)) == false) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L16:
        mAppInstallStats.put("reportStats", "Possible concurrent installation");     // Catch: Throwable -> L21
        reportStats();     // Catch: Throwable -> L21
        goto L17
    }

    public static String bytesToHuman(long r100) {
        return bytesToHuman(r100, true);
    }

    public static String bytesToHumanOnSpaceError(long r100) {
        long[] r101 = {DownloadConstants.TB, 1073741824, 1048576, 1024, 1};
        String[] r102 = {"TB", "GB", "MB", "KB", "B"};
        if (r100 < 1) goto L5;
        int r103 = 0;
    L7:
        if (r103 >= 5) goto L12;
        long r104 = r101[r103];
        if (r100 >= r104) goto L16;
        r103 = r103 + 1;
        goto L7
    L16:
        return formatOnSpaceError(r100, r104, r102[r103]);
    L12:
        return null;
    L5:
        return "0 " + r102[4];
    }

    public static boolean canNotAutoInstall(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return false;
    L13:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L10
        if (r101.optBoolean(BIND_APP_EXTRA, false) == true) goto L9;
        if (r101.optBoolean(Constants.AUTO_INSTALL_WITH_NOTIFICATION, true) == false) goto L9;
    L12:
        return false;
    L9:
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static JSONObject createJSONObject(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        return new JSONObject(r100);
    L11:
        return null;
    }

    public static String getAppDownloadPath(Context r100) {
        return getAppDownloadPath();
    }

    public static String getNotificationChannelId(Context r100) {
    L7:
        th = move-exception;
        th.printStackTrace();
    L9:
        return DEFAULT_CHANNEL_ID;
    L4:
        if (mNotificationChannel != null) goto L9;
        NotificationChannel r101 = new NotificationChannel(DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME, 3);     // Catch: Throwable -> L7
        mNotificationChannel = r101;     // Catch: Throwable -> L7
        r101.setSound(null, null);     // Catch: Throwable -> L7
        mNotificationChannel.setShowBadge(false);     // Catch: Throwable -> L7
        ((NotificationManager) r100.getSystemService("notification")).createNotificationChannel(mNotificationChannel);     // Catch: Throwable -> L7
        goto L9
    }

    public static int getNotificationType(int r100) {
        if (r100 != 0) goto L6;
        return 0;
    L6:
        if (r100 != (-2)) goto L10;
        return 2;
    L10:
        if (r100 != 1) goto L14;
        return 4;
    L14:
        if (DownloadStatus.isDownloading(r100) == false) goto L16;
    L23:
        return 1;
    L16:
        if (r100 == 11) goto L23;
        if (DownloadStatus.isDownloadOver(r100) == false) goto L22;
        return 3;
    L22:
        return 0;
    }

    public static String getPackageInfoLog(PackageInfo r100) {
        if (r100 != null) goto L6;
        return "PackageInfo is null";
    L6:
        return "PackageInfo: packageName:" + r100.packageName + " versionCode:" + r100.versionCode + " versionName:" + r100.versionName;
    }

    public static boolean isApkMineType(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals("application/vnd.android.package-archive") == false) goto L7;
        return true;
    }

    public static boolean isApkValid(DownloadInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ("application/vnd.android.package-archive".equals(r100.getMimeType()) == false) goto L9;
        return true;
    L9:
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L14;
        if (r100.getUrl().endsWith(".apk") == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r100.getName()) == false) goto L16;
        return false;
    L16:
        if (r100.getName().endsWith(".apk") == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static boolean isBindApp(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return false;
    L12:
        if (new JSONObject(r100).optBoolean(BIND_APP_EXTRA, false) == false) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static boolean isMaterialNotification(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        TypedArray r101 = null;
        int r102 = r100.getResources().getColor(AppResourceUtils.getNotificationTitleColor());     // Catch: Throwable -> L12
        r101 = r100.obtainStyledAttributes(AppResourceUtils.getNotificationTitleStyle(), new int[]{AppResourceUtils.getAndroidTextColor(), AppResourceUtils.getAndroidTextSize()});     // Catch: Throwable -> L12
        if (r102 != r101.getColor(0, 0)) goto L21;
        r101.recycle();     // Catch: Throwable -> L16
    L9:
        return true;
    L21:
        r101.recycle();     // Catch: Throwable -> L15
    L14:
        return false;
    L12:
        if (r101 == null) goto L14;
        goto L14
    }

    public static void pushActivity(Activity r100) {
        activityRef = new SoftReference(r100);
    }

    public static void safeFinish(Activity r100) {
        if (r100 == null) goto L12;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r100.isFinishing() == true) goto L13;
        r100.finish();     // Catch: Exception -> L7
        return;
    L13:
        return;
    }

    public static void addStats(String r100, String r101) {
        if (mStatsEnabled == false) goto L15;
        if (r100 == null) goto L18;
        if (r101 == null) goto L19;
        Object r102 = mStatsLock;
        monitor-enter(r102);
        mAppInstallStats.put(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L19:
        return;
    L18:
        return;
    }

    public static String bytesToHuman(long r110, boolean r111) {
        long[] r100 = {DownloadConstants.TB, 1073741824, 1048576, 1024, 1};
        String[] r101 = {"TB", "GB", "MB", "KB", "B"};
        if (r110 < 1) goto L5;
        int r102 = 0;
    L7:
        if (r102 >= 5) goto L12;
        long r103 = r100[r102];
        if (r110 >= r103) goto L16;
        r102 = r102 + 1;
        goto L7
    L16:
        return format(r110, r103, r101[r102], r111);
    L12:
        return null;
    L5:
        return "0 " + r101[4];
    }

    private static Process com_ss_android_socialbase_appdownloader_AppDownloadUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static String createFileName(AppTaskBuilder r100, boolean r101) {
        String r102 = r100.getUrl();
        String r103 = r100.getSaveName();
        String r104 = r100.getName();
        if (TextUtils.isEmpty(r103) == false) goto L6;
        r103 = getValidName(r102, r104, r100.getMimeType(), r101);
    L6:
        if (r103.length() > 255) goto L8;
        return r103;
    L8:
        return r103.substring(r103.length() - 255);
    }

    public static int dp2px(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_AppDownloadUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int getApkFileVersionCode(Context r100, DownloadInfo r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (TextUtils.isEmpty(r101.getSavePath()) == true) goto L17;
        if (TextUtils.isEmpty(r101.getName()) == true) goto L17;
        int r102 = r101.getAppVersionCode();
        if (r102 <= 0) goto L19;
        return r102;
    L19:
        PackageInfo r103 = parseApkFile(r100, r101, r101.getSavePath(), r101.getName());     // Catch: Throwable -> L18
        if (r103 == null) goto L17;
        int r104 = r103.versionCode;     // Catch: Throwable -> L18
        r101.setAppVersionCode(r104);     // Catch: Throwable -> L18
        return r104;
    L17:
        return 0;
    }

    public static PackageInfo getPackageInfo(DownloadInfo r100, File r101) {
        if (r100 == null) goto L4;
        PackageInfo r102 = r100.getPackageInfo();
        if (DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_APP_PACKAGE_INFO_CACHE) <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L15;
        if (r102 != null) goto L15;
        r102 = r100.getPackageInfoWithCache();
        if (r102 == null) goto L15;
        r100.setPackageInfo(r102);
        return r102;
    L15:
        if (r102 != null) goto L22;
        r102 = PackageInfoUtils.getPackageInfo(DownloadComponentManager.getAppContext(), r101, getPackageInfoFlag());
        r100.setPackageInfo(r102);
        if (r103 == false) goto L22;
        if (r102 == null) goto L22;
        r100.setPackageInfoToCache(r102);
        if (DownloadUtils.isMainThread() == true) goto L22;
        Downloader.getInstance(DownloadComponentManager.getAppContext()).updateDownloadInfo(r100);
    L22:
        return r102;
    L8:
        r103 = false;
        goto L9
    L4:
        return PackageInfoUtils.getPackageInfo(DownloadComponentManager.getAppContext(), r101, getPackageInfoFlag());
    }

    public static String getRedirectDir(String r100, DownloadSetting r101) {
        if (r101 == null) goto L22;
        JSONObject r102 = r101.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (r102 == null) goto L22;
        String r103 = r102.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (TextUtils.isEmpty(r103) == true) goto L11;
        if (r103.startsWith(HTTP.URL_DEFAULT) == false) goto L11;
        r103 = r103.substring(1);
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        return r103;
    L13:
        if (r103.contains("%s") == true) goto L24;
        String r104 = r103 + r100;
    L15:
        r103 = r104;
    L20:
        if (r103.length() > 255) goto L28;
        return r103;
    L28:
        return r103.substring(r103.length() - 255);
    L24:
        r104 = String.format(r103, new Object[]{r100});     // Catch: Throwable -> L18
    L22:
        return "";
    }

    public static boolean isApkInstalled(Context r100, DownloadInfo r101) {
        return isApkInstalled(r100, r101, true);
    }

    public static boolean isApkInstalledByFile(Context r100, DownloadInfo r101) {
        if (r100 == null) goto L11;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101.getSavePath()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r101.getName()) == false) goto L10;
        return false;
    L10:
        return isApkInstalled(r100, r101, parseApkFile(r100, r101, r101.getSavePath(), r101.getName()));
    L11:
        return false;
    }

    public static boolean isApkInstalledByLaunchIntent(Context r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        if (r102.getLaunchIntentForPackage(r101) == null) goto L17;
        return true;
    L17:
        return false;
    L12:
        e = move-exception;
        addStats("isApkInstalledByLaunchIntent", "Error:" + e + " packageName:" + r101);
        e.printStackTrace();
        goto L14
    }

    public static boolean isPackageNameValid(DownloadInfo r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100.getPackageName()) == true) goto L11;
        if (r101.equals(r100.getPackageName()) == false) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r100.getName()) == false) goto L13;
    L15:
        return false;
    L13:
        if (isPackageNameEqualsWithApk(DownloadComponentManager.getAppContext(), r100, r101) == false) goto L15;
        return true;
    }

    private static void reportViaMonitorListener(String r100, String r101) {
        IDownloadMonitorListener r102 = DownloadComponentManager.getDownloadMonitorListener();
        if (r102 != null) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("message", r101);     // Catch: JSONException -> L9
    L7:
        r102.monitorEvent(r100, r103, null, null);
    }

    private static void sendInstallPrepareViewResultEvent(DownloadInfo r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r102 = new JSONObject();
        if (r101 == false) goto L8;
        int r103 = 1;
    L15:
        r102.put("by_user", r103);     // Catch: Exception -> L11
        r102.put("real_package_name", r100.getFilePackageName());     // Catch: Exception -> L11
    L13:
        DownloadComponentManager.getEventListener().onEvent(r100.getId(), "install_prepare_view_result", r102);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L8:
        r103 = 2;
        goto L15
    }

    public static int startPackageInstaller(Context r100, Intent r101) {
        if (AppInstallStatsReporter.isEnabled() == false) goto L28;
        AppInstallStatsReporter.report();
    L28:
        addStats("startPackageInstaller_1", "Intent:" + r101);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "startPackageInstaller", "Intent:" + r101);     // Catch: Throwable -> L15
    L10:
        if (AppDownloader.getInstance().getInstallAppHandler() != null) goto L12;
    L26:
        IDownloadAppInstallHandler r102 = AppDownloader.getInstance().getAppInstallHandler();     // Catch: Throwable -> L23
        if (r102 == null) goto L20;
        r102.startActivity(r100, r101);     // Catch: Throwable -> L23
    L21:
        addStats("startPackageInstaller_4", "Install success");     // Catch: Throwable -> L23
        return 1;
    L20:
        r100.startActivity(r101);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        addStats("startPackageInstaller_5", "Error:" + th);
        Logger.globalError(TAG, "startPackageInstaller", "Error2:" + th);
        return 0;
    L12:
        if (AppDownloader.getInstance().getInstallAppHandler().installApp(r101) == false) goto L26;
        addStats("startPackageInstaller_2", "InstallAppHandler");     // Catch: Throwable -> L15
        return 1;
    L15:
        th = move-exception;
        Logger.globalError(TAG, "startPackageInstaller", "Error1:" + th);
        addStats("startPackageInstaller_3", "Error:" + th);
        goto L26
    }

    private static boolean validateExternalMD5(Context r100, DownloadInfo r101) {
        if (DownloadFileUtils.isExternalDownloadEnabled() == true) goto L5;
    L23:
        return true;
    L5:
        if (DownloadFileUtils.isMediaUri(r101.getSavePath()) == false) goto L23;
        if (TextUtils.isEmpty(r101.getMd5()) == true) goto L23;
        if (DownloadUtils.isMd5Valid(DownloadUtils.checkMd5Status(r101.getSavePath(), r101.getName(), r101.getMd5())) == true) goto L12;
        addStats("validateExternalMD5", "Uri Md5 verification failed" + r101.getMd5());
        IAppDownloadMonitorListener r102 = AppDownloader.getInstance().getAppDownloadMonitorListener();
        if (r102 == null) goto L19;
        BaseException r103 = new BaseException(2005, "Uri Md5 verification failed" + r101.getMd5());
        r102.onAppDownloadMonitorSend(r101, r103, r103.getErrorCode());
    L19:
        if (Logger.debugScene(r101) == false) goto L21;
        Logger.taskDebug(TAG, r101, "realStartViewIntent", "Uri Md5 verification failed " + r101.getMd5());
    L21:
        r101.setMd5(null);
        Downloader.getInstance(r100).updateDownloadInfo(r101);
        DownloadUtils.deleteAllDownloadFiles(r101);
        return false;
    L12:
        if (Logger.debugScene(r101) == false) goto L14;
        Logger.taskDebug(TAG, r101, "realStartViewIntent", "Uri Md5 verification success");
    L14:
        return true;
    }

    private static PackageInfo getPackageInfo(Context r100, String r101) {
        return r100.getPackageManager().getPackageInfo(r101, getPackageInfoFlag());
    L4:
        e = move-exception;
        addStats("getPackageInfo", "Error:" + e + " packageName:" + r101);
        return null;
    }

    public static /* synthetic */ int access$200(Context r100, int r101, boolean r102) {
        return startViewIntentInner(r100, r101, r102);
    }

    public static /* synthetic */ void access$400(DownloadInfo r100, boolean r101, int r102) {
        sendInstallViewResultEvent(r100, r101, r102);
    }

    public static void createDownloadTask(DownloadInfo r100, boolean r101, boolean r102) {
        AppTaskBuilder r103 = new AppTaskBuilder(DownloadComponentManager.getAppContext(), r100.getUrl()).name(r100.getTitle()).saveName(r100.getName()).savePath(r100.getSavePath()).showNotification(r100.isShowNotification()).autoInstallWithoutNotification(r100.isAutoInstallWithoutNotification());
        if (r100.isOnlyWifi() == true) goto L7;
        if (r102 == true) goto L7;
        boolean r104 = false;
    L8:
        AppTaskBuilder r105 = r103.needWifi(r104).extra(r100.getExtra()).mimeType(r100.getMimeType()).headers(r100.getExtraHeaders()).autoResumed(true);
        if (r100.getMonitorScene() != null) goto L11;
        String r106 = "createDownloadTask";
    L12:
        AppTaskBuilder r107 = r105.monitorScene(r106).setCacheLifeTimeMax(r100.getCacheLifeTimeMax()).retryCount(r100.getRetryCount()).backUpUrlRetryCount(r100.getBackUpUrlRetryCount()).backUpUrls(r100.getBackUpUrls()).minProgressTimeMsInterval(r100.getMinProgressTimeMsInterval()).maxProgressCount(r100.getMaxProgressCount()).showNotificationForAutoResumed(r101).needHttpsToHttpRetry(r100.isNeedHttpsToHttpRetry()).packageName(r100.getPackageName()).md5(r100.getMd5()).expectFileLength(r100.getExpectFileLength()).needDefaultHttpServiceBackUp(r100.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(r100.isNeedIndependentProcess()).enqueueType(r100.getEnqueueType()).force(r100.isForce()).pcdnUrls(r100.getPcdnUrls()).cdnUrls(r100.getCdnUrls()).downloadSetting(createJSONObject(r100.getDownloadSettingString())).iconUrl(r100.getIconUrl()).executorGroup(r100.getExecutorGroup()).autoInstall(r100.isAutoInstall()).taskKey(r100.getTaskKey()).ignoreInterceptor(r100.isIgnoreInterceptor());
        AppDownloader.getInstance().addDownloadTask(r107);
        return;
    L11:
        r106 = r100.getMonitorScene();
    L7:
        r104 = true;
        goto L8
    }

    public static boolean forbidInstallWhenPkgNameError(Context r100, DownloadInfo r101, PackageInfo r110) {
        if (r110 != null) goto L4;
        return false;
    L4:
        if (r110.packageName.equals(r101.getPackageName()) == true) goto L24;
        IAppDownloadEventHandler r102 = AppDownloader.getInstance().getAppDownloadEventHandler();
        if (r102 == null) goto L15;
        r102.handleAppInstallError(r101.getId(), 8, r101.getPackageName(), r110.packageName, "");
        if ((r102 instanceof AbsAppDownloadEventHandler) == false) goto L13;
        if (((AbsAppDownloadEventHandler) r102).isForbidInvalidatePackageInstall(r101) == false) goto L15;
        return true;
    L13:
        if (r102.isForbidInvalidatePackageInstall() == false) goto L15;
        return true;
    L15:
        IDownloadNotificationEventListener r103 = Downloader.getInstance(r100).getDownloadNotificationEventListener(r101.getId());
        if (r103 == null) goto L25;
        r103.onNotificationEvent(8, r101, r110.packageName, "");
        IAppDownloadDepend r104 = AppDownloader.getInstance().getAppDownloadDepend();
        if ((r104 instanceof AbsAppDownloadDepend) == true) goto L20;
        return false;
    L20:
        if (((AbsAppDownloadDepend) r104).isForbiddenInstallForInvalidatePackageName(r101) == false) goto L27;
        return true;
    L27:
        return false;
    L25:
        return false;
    L24:
        return false;
    }

    private static String formatOnSpaceError(long r100, long r101, String r102) {
        double r103 = r100;
        if (r101 <= 1) goto L6;
        r103 = r103 / r101;
    L6:
        if ("MB".equals(r102) == false) goto L10;
        return new DecimalFormat("#").format(r103) + r102;
    L10:
        return new DecimalFormat("#.##").format(r103) + r102;
    }

    public static String getValidName(String r100, String r101, String r102) {
        return getValidName(r100, r101, r102, false);
    }

    public static boolean isApkInstalled(Context r100, DownloadInfo r101, boolean r102) {
        if (r101 != null) goto L5;
        return false;
    L5:
        String r103 = r101.getPackageName();
        int r104 = r101.getAppVersionCode();
        if (r104 > 0) goto L11;
        if (r102 == false) goto L11;
        return isApkInstalledByFile(r100, r101);
    L11:
        PackageInfo r105 = getPackageInfo(r100, r103);
        if (r105 != null) goto L15;
        return false;
    L15:
        if (isApkInstalledByLaunchIntent(r100, r103) == true) goto L18;
        return false;
    L18:
        if (DownloadSetting.obtain(r101.getId()).optInt(DownloadSettingKeys.INSTALL_WITH_SAME_VERSION_CODE, 0) != 1) goto L24;
        if (r104 >= r105.versionCode) goto L27;
        return true;
    L27:
        return false;
    L24:
        if (r104 > r105.versionCode) goto L28;
        return true;
    L28:
        return false;
    }

    public static boolean isPackageNameEqualsWithApk(Context r110, DownloadInfo r111, String r112) {
        if (r110 != null) goto L45;
        return false;
    L45:
        DownloadFile r100 = new DownloadFile(r111.getSavePath(), r111.getName());     // Catch: Exception -> L42
        PackageInfo r101 = null;
        if (r100.exists() == true) goto L8;
        String r102 = DownloadUtils.getString(r111.getTempCacheData().get(Constants.EXTRA_APK_PACKAGE_NAME), null);     // Catch: Exception -> L42
        int r113 = DownloadUtils.getInt(r111.getTempCacheData().get(Constants.EXTRA_APK_VERSION_CODE), 0);     // Catch: Exception -> L42
        if (r102 != null) goto L28;
    L41:
        return false;
    L28:
        if (TextUtils.isEmpty(r102) == true) goto L41;
        if (r102.equals(r112) == true) goto L46;
        return false;
    L46:
        r101 = r110.getPackageManager().getPackageInfo(r112, getPackageInfoFlag());     // Catch: PackageManager.NameNotFoundException -> L35 Exception -> L42
    L36:
        if (r101 != null) goto L39;
        return false;
    L39:
        if (r113 == r101.versionCode) goto L51;
        return false;
    L51:
        return true;
    L8:
        if (Logger.debugScene(r111) == false) goto L10;
        Logger.taskDebug(TAG, r111, "isPackageNameEqualsWithApk", "fileName:" + r111.getName() + " apkFileSize：" + r100.length() + " fileUrl：" + r111.getUrl());     // Catch: Exception -> L42
    L10:
        PackageInfo r114 = getPackageInfo(r111, r100.getFile());     // Catch: Exception -> L42
        if (r114 != null) goto L14;
        return false;
    L14:
        if (r114.packageName.equals(r112) == true) goto L16;
        return false;
    L16:
        int r115 = r114.versionCode;     // Catch: Exception -> L42
        r101 = r110.getPackageManager().getPackageInfo(r112, getPackageInfoFlag());     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L42
    L20:
        if (r101 != null) goto L23;
        return false;
    L23:
        if (r115 == r101.versionCode) goto L51;
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static int proxyStartViewIntent(Context r100, int r101, boolean r102) {
        beginStats(r101);
        if (AppInstallStatsReporter.isEnabled() == false) goto L5;
        AppInstallStatsReporter.addStats(r101, "AppDownloadUtils_proxyStartViewIntent", "Stack:" + Log.getStackTraceString(new Throwable()));
    L5:
        addStats("proxyStartViewIntent_1", "ByUser:" + r102);
        DownloadInfo r103 = Downloader.getInstance(r100).getDownloadInfo(r101);
        if (r103 == null) goto L11;
        if (r103.isHasDoInstallation() == true) goto L11;
        r103.setHasDoInstallation(true);
        Downloader.getInstance(r100).updateDownloadInfo(r103);
    L11:
        if (DownloadSetting.obtain(r101).optInt("install_prepare_view_result", 1) != 1) goto L14;
        sendInstallPrepareViewResultEvent(r103, r102);
    L14:
        if (isApkValid(r103) == false) goto L25;
        addStats("proxyStartViewIntent_2", "Run ApkValid url:" + r103.getUrl() + " curBytes:" + r103.getCurBytes() + " totalBytes:" + r103.getTotalBytes());
        if (TextUtils.isEmpty(r103.getSavePath()) == false) goto L18;
    L24:
        addStats("proxyStartViewIntent_3", "Run ApkValid and info error:" + r103.toDetailString());
    L28:
        sendInstallViewResultEvent(r103, r102, 2);
        return 2;
    L18:
        if (TextUtils.isEmpty(r103.getName()) == true) goto L24;
        DownloadFile r104 = new DownloadFile(r103.getSavePath(), r103.getName());
        if (r104.exists() == false) goto L23;
        startInstallView(r100, r101, r102, r104, r103);
        return 1;
    L23:
        addStats("proxyStartViewIntent_5", "File Not Found:" + r103.toDetailString());
        goto L28
    L25:
        addStats("proxyStartViewIntent_4", "ApkInvalid:" + r103);
        if (Logger.debugScene(r103) == false) goto L28;
        Logger.taskDebug(TAG, r103, "installApk", "App invalid");
        goto L28
    }

    private static void sendInstallViewResultEvent(DownloadInfo r100, boolean r101, int r102) {
        if (r100 != null) goto L6;
        addStats("sendInstallViewResultEvent_1", "DownloadInfo is null");
        return;
    L6:
        JSONObject r103 = new JSONObject();
        if (r101 == false) goto L10;
        int r104 = 1;
    L17:
        r103.put("by_user", r104);     // Catch: Exception -> L13
        r103.put("view_result", r102);     // Catch: Exception -> L13
        r103.put("real_package_name", r100.getFilePackageName());     // Catch: Exception -> L13
        addStats("sendInstallViewResultEvent_2", "Stats:" + r103.toString());     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onEvent(r100.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, r103);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        addStats("sendInstallViewResultEvent_2", "Error:" + e);
        goto L15
    L10:
        r104 = 2;
        goto L17
    }

    public static boolean silentInstallOnMiui(Context r100, int r101, File r102) {
        if (DownloadSetting.obtain(r101).optInt(DownloadSettingKeys.BACK_MIUI_SILENT_INSTALL, 1) != 1) goto L6;
        return false;
    L6:
        if (RomUtils.isMiuiV10() == true) goto L11;
        if (RomUtils.isMiuiV11() == true) goto L11;
        return false;
    L11:
        if (SystemUtils.checkServiceExists(r100, MIUI_SECURITY_PKG, MIUI_SECURITY_NAME) == false) goto L17;
        Intent r103 = new Intent();
        r103.setComponent(new ComponentName(MIUI_SECURITY_PKG, MIUI_SECURITY_NAME));
        Bundle r104 = new Bundle();
        r104.putInt("userId", 0);
        r104.putInt(ForwardDependency$ForwardLocation.FLAG, 256);
        r104.putString("apkPath", r102.getPath());
        r104.putString("installerPkg", MIUI_SECURITY_PKG);
        r103.putExtras(r104);
        addStats("silentInstallOnMiui_1", "Intent:" + r103);
        r100.startService(r103);     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        addStats("silentInstallOnMiui_2", "Error:" + e);
        e.printStackTrace();
    L17:
        return false;
    }

    public static int startViewIntent(final Context r100, final int r101, final boolean r102) {
        beginStats(r101);
        if (AppInstallStatsReporter.isEnabled() == false) goto L5;
        AppInstallStatsReporter.addStats(r101, "AppDownloadUtils_startViewIntent", "Stack:" + Log.getStackTraceString(new Throwable()));
    L5:
        IBeforeAppInstallInterceptor r103 = AppDownloader.getInstance().getBeforeAppInstallInterceptor();
        if (r103 != null) goto L9;
        addStats("startViewIntent_1", "Run");
        return startViewIntentInner(r100, r101, r102);
    L9:
        DownloadInfo r104 = Downloader.getInstance(r100).getDownloadInfo(r101);
        sStartViewIntentResult = 1;
        addStats("startViewIntent_2", "Run");
        r103.intercept(r104, new AnonymousClass2(r100, r101, r102));
        addStats("startViewIntent_3", "Run res:" + sStartViewIntentResult);
        return sStartViewIntentResult;
    }

    private static int startViewIntentInner(Context r100, int r101, boolean r102) {
        if (DownloadSetting.obtain(r101).optInt(DownloadSettingKeys.NOTIFICATION_OPT_2) != 1) goto L5;
        DownloadNotificationManager.getInstance().cancelNotification(r101);
    L5:
        safeFinish(popActivity());
        return proxyStartViewIntent(r100, r101, r102);
    }

    public static boolean isApkInstalled(Context r100, DownloadInfo r101, PackageInfo r102) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "isApkInstalled", "Run" + r101);
    L6:
        return isApkInstalled(r100, r101, r102, false);
    }

    public static boolean isApkInstalled(Context r100, String r101, String r102) {
        return isApkInstalled(r100, null, parseApkFile(r100, null, r101, r102));
    }

    private static String format(long r100, long r101, String r102, boolean r103) {
        double r104 = r100;
        if (r101 <= 1) goto L6;
        r104 = r104 / r101;
    L6:
        if (r103 == true) goto L15;
        if ("GB".equals(r102) == true) goto L15;
        if ("TB".equals(r102) == true) goto L15;
        return new DecimalFormat("#").format(r104) + " " + r102;
    L15:
        return new DecimalFormat("#.##").format(r104) + " " + r102;
    }

    public static String getValidName(String r100, String r101, String r102, boolean r103) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Uri r104 = UriProtector.parse(r100);
        if (r103 == true) goto L9;
        String r105 = r104.getLastPathSegment();
        if (TextUtils.isEmpty(r105) == true) goto L16;
        r101 = r105;
    L21:
        if (isApkMineType(r102) == true) goto L23;
        return r101;
    L23:
        if (r101.endsWith(".apk") == false) goto L25;
        return r101;
    L25:
        return r101.concat(".apk");
    L16:
        if (TextUtils.isEmpty(r101) == false) goto L21;
    L18:
        r101 = "default.apk";
        goto L21
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L21;
        if (TextUtils.isEmpty(r104.getLastPathSegment()) == true) goto L18;
        r101 = r104.getLastPathSegment();
        goto L21
    }

    public static boolean isApkInstalled(Context r100, DownloadInfo r101, PackageInfo r102, boolean r103) {
        if (r102 != null) goto L5;
        return false;
    L5:
        String r104 = r102.packageName;
        int r105 = r102.versionCode;
        if (r101 == null) goto L8;
        r101.setAppVersionCode(r105);
    L8:
        PackageInfo r106 = getPackageInfo(r100, r104);
        if (r106 != null) goto L12;
        return false;
    L12:
        if (isApkInstalledByLaunchIntent(r100, r104) == true) goto L14;
        return false;
    L14:
        int r107 = r106.versionCode;
        if (r103 == false) goto L19;
        if (r105 >= r107) goto L28;
        return true;
    L28:
        return false;
    L19:
        if (r101 != null) goto L21;
    L25:
        if (r105 > r107) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (DownloadSetting.obtain(r101.getId()).optInt(DownloadSettingKeys.INSTALL_WITH_SAME_VERSION_CODE, 0) != 1) goto L25;
        if (r105 >= r107) goto L29;
        return true;
    L29:
        return false;
    }

    public static PackageInfo parseApkFile(Context r100, DownloadInfo r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L15:
        return null;
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        DownloadFile r104 = new DownloadFile(r102, r103);
        if (r104.exists() == true) goto L11;
        return null;
    L11:
        if (Logger.debugScene(r101) == false) goto L14;
        Logger.taskDebug(TAG, r101, "parseApkFile", "IsApkInstalled apkFileSize：fileName:" + r104.getPath() + " apkFileSize" + r104.length());
    L14:
        return getPackageInfo(r101, r104.getFile());
    }

    public static boolean isApkInstalled(Context r100, String r101, String r102, boolean r103) {
        return isApkInstalled(r100, null, parseApkFile(r100, null, r101, r102), r103);
    }

    public static /* synthetic */ int access$300(Context r100, int r101, boolean r102, DownloadInfo r103, File r104) {
        return realStartViewIntent(r100, r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v7 */
    private static Intent buildViewIntent(Context r100, DownloadInfo r101, File r102, boolean r103, int[] r104) {
        addStats("buildViewIntent_1", "Run");
        Uri r105 = getUriForFile(r101, Downloader.getInstance(r100).getDownloadFileUriProvider(r101.getId()), r100, AppDownloader.getInstance().getFileProviderAuthority(), r102);
        if (r105 != null) goto L6;
        addStats("buildViewIntent_2", "LocalUri is null");
        return null;
    L6:
        addStats("buildViewIntent_3", "LocalUri:" + r105);
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r106.addFlags(1);
    L9:
        r106.setDataAndType(r105, "application/vnd.android.package-archive");
        String r107 = RomUtils.getSysPackageInstaller(r100);
        if (TextUtils.isEmpty(r107) == true) goto L12;
        r106.setPackage(r107);
    L12:
        IAppDownloadEventHandler r108 = AppDownloader.getInstance().getAppDownloadEventHandler();
        if (r108 == null) goto L15;
        boolean r109 = r108.installIntercept(r101.getId(), r103);
    L16:
        IDownloadNotificationEventListener r110 = Downloader.getInstance(r100).getDownloadNotificationEventListener(r101.getId());
        ?? r111 = r109;
        if (r110 == null) goto L19;
        r111 = r110.interceptAfterNotificationSuccess(r103);
    L19:
        r104[0] = r111;
        if (r111 == 0) goto L23;
        addStats("buildViewIntent_4", "Intercept");
        return null;
    L23:
        return r106;
    L15:
        r109 = false;
        goto L16
    }

    public static Uri getUriForFile(DownloadInfo r100, IDownloadFileUriProvider r101, Context r102, String r110, File r111) {
        StringBuilder r103 = new StringBuilder("Authority:");
        r103.append(r110);
        r103.append(" apkFile:");
        String r104 = "null";
        if (r111 == null) goto L5;
        String r105 = r111.getAbsolutePath();
    L6:
        r103.append(r105);
        addStats("getUriForFile_1", r103.toString());
        if (Logger.debugScene(r100) == false) goto L13;
        StringBuilder r106 = new StringBuilder("Authority:");
        r106.append(r110);
        r106.append(" apkFile:");
        if (r111 == null) goto L11;
        r104 = r111.getAbsolutePath();
    L11:
        r106.append(r104);
        Logger.taskDebug(TAG, r100, "getUriForFile", r106.toString());
    L13:
        if (DownloadFileUtils.isExternalDownloadEnabled() == true) goto L15;
    L18:
        Uri r107 = null;
        if (DownloadFileUtils.isScopedStorage() == false) goto L34;
        if (DownloadFileUtils.isMediaUri(r100.getSavePath()) == false) goto L26;
        if (DownloadFileUtils.exists(UriProtector.parse(r100.getSavePath())) == false) goto L26;
        r107 = UriProtector.parse(r100.getSavePath());
    L26:
        if (Build.VERSION.SDK_INT >= 29) goto L28;
    L30:
        if (r107 == null) goto L34;
        addStats("getUriForFile_2", "LocalUri:" + r107);
        return r107;
    L28:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r111.getPath()) == false) goto L30;
        r107 = DownloadFileUtils.getUriFromFilePath(r111.getPath());
    L34:
        if (r101 != null) goto L64;
        IAppDownloadFileUriProvider r108 = AppDownloader.getInstance().getAppFileUriProvider();
        if (r108 != null) goto L61;
    L45:
        if (r107 == null) goto L63;
    L59:
        addStats("getUriForFile_6", "LocalUri" + r107);
        return r107;
    L63:
        int r109 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L57
        if (r109 >= 24) goto L49;
    L51:
        if (r109 >= 24) goto L53;
    L55:
        Uri r112 = Uri.fromFile(r111);     // Catch: Throwable -> L57
    L56:
        r107 = r112;
        goto L59
    L53:
        if (TextUtils.isEmpty(r110) == true) goto L55;
        r112 = FileProvider.getUriForFile(r102, r110, r111);     // Catch: Throwable -> L57
        goto L56
    L49:
        if (TextUtils.isEmpty(r110) == false) goto L51;
        r110 = DownloadSetting.obtain(r100.getId()).optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FILE_PROVIDER_AUTHORITY);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
        addStats("getUriForFile_5", "Error:" + th);
        Logger.taskError(TAG, r100.getId(), "getUriForFile", "Error for system FileProvider:" + th);
        goto L59
    L61:
        r107 = r108.getUriForFile(r100.getId(), r110, r111.getAbsolutePath());     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        addStats("getUriForFile_4", "Error:" + th);
        Logger.taskError(TAG, r100.getId(), "getUriForFile", "Error for appFileUriProvider:" + th);
        goto L45
    L64:
        r107 = r101.getUriForFile(r110, r111.getAbsolutePath());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        addStats("getUriForFile_3", "Error:" + th);
        goto L45
    L15:
        if (DownloadFileUtils.isMediaUri(r100.getSavePath()) == false) goto L18;
        return UriProtector.parse(r100.getSavePath());
    L5:
        r105 = "null";
        goto L6
    }

    private static int realStartViewIntent(Context r100, int r110, boolean r111, DownloadInfo r112, File r113) {
        StringBuilder r101 = new StringBuilder("Path:");
        if (r113 == null) goto L5;
        String r102 = r113.getAbsolutePath();
    L6:
        r101.append(r102);
        addStats("realStartViewIntent_1", r101.toString());
        File r103 = DownloadDirUtils.getDataDirectory(false);
        if (r103 != null) goto L9;
    L24:
        addStats("realStartViewIntent_11", "Before Parse PackageInfo");
        PackageInfo r104 = getPackageInfo(r112, r113);     // Catch: Throwable -> L32
        if (r104 != null) goto L98;
    L31:
        th = null;
    L35:
        addStats("realStartViewIntent_4", getPackageInfoLog(r104));
        if (Logger.debugScene(r112) == false) goto L39;
        Logger.taskDebug(TAG, r112, "realStartViewIntent", getPackageInfoLog(r104));
    L39:
        if (AppDownloader.getInstance().getAppDownloadMonitorListener() == null) goto L44;
        if (r104 != null) goto L42;
        BaseException r105 = new BaseException(2001, th);
        AppDownloader.getInstance().getAppDownloadMonitorListener().onAppDownloadMonitorSend(r112, r105, r105.getErrorCode());
        goto L44
    L42:
        AppDownloader.getInstance().getAppDownloadMonitorListener().onAppDownloadMonitorSend(r112, null, 11);
    L44:
        if (forbidInstallWhenPkgNameError(r100, r112, r104) == false) goto L49;
        addStats("realStartViewIntent_5", "ForbidInstall");
        if (Logger.debugScene(r112) == false) goto L48;
        Logger.taskDebug(TAG, r112, "realStartViewIntent", "Forbid install");
    L48:
        return 2;
    L49:
        if (r104 == null) goto L51;
        r112.getTempCacheData().put(Constants.EXTRA_APK_PACKAGE_NAME, r104.packageName);
        r112.getTempCacheData().put(Constants.EXTRA_APK_VERSION_CODE, Integer.valueOf(r104.versionCode));
    L51:
        int[] r106 = new int[1];
        if (isApkInstalled(r100, r112, r104) == false) goto L57;
        addStats("realStartViewIntent_6", "IsApkInstalled");
        Intent r114 = r100.getPackageManager().getLaunchIntentForPackage(r104.packageName);
        if (Logger.debugScene(r112) == false) goto L66;
        Logger.taskDebug(TAG, r112, "realStartViewIntent", "Apk installed");
    L66:
        if (r114 != null) goto L75;
        if (Logger.debugScene(r112) == false) goto L70;
        Logger.taskDebug(TAG, r112, "realStartViewIntent", "Intent is null");
    L70:
        addStats("realStartViewIntent_8", "Intent is null");
        if (r106[0] != 1) goto L108;
        return 2;
    L108:
        return 0;
    L75:
        if (DownloadSetting.obtain(r112.getId()).optInt(DownloadSettingKeys.APP_INSTALL_REMOVE_FLAG_ACTIVITY_NEW_TASK) > 0) goto L78;
        r114.addFlags(268435456);
    L78:
        if (r112.getLinkMode() <= 0) goto L83;
        if (DownloadSetting.obtain(r112.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) != 1) goto L83;
        r114.putExtra("android.intent.extra.RETURN_RESULT", true);
    L83:
        if (r106[0] != 0) goto L87;
        addStats("realStartViewIntent_9", "AntiHijack:" + r114 + " byUser:" + r111);
        boolean r115 = AhUtils.antiHijack(r100, r112, r114, r111);
        StringBuilder r116 = new StringBuilder("res:");
        r116.append(r115);
        addStats("realStartViewIntent_10", r116.toString());
        if (r115 == false) goto L87;
        return 1;
    L87:
        String r117 = r112.getInstallBizType();
        if (TextUtils.isEmpty(r117) == true) goto L90;
        r114.putExtra(SpJsonConstants.KEY_INSTALL_BIZ_TYPE, r117);
    L90:
        String r118 = r112.getInstallCertId();
        if (TextUtils.isEmpty(r118) == true) goto L93;
        r114.putExtra(SpJsonConstants.KEY_INSTALL_CERT_ID, r118);
    L93:
        String r119 = r112.getInstallBizParamsJson();
        if (TextUtils.isEmpty(r119) == true) goto L97;
        r114.putExtra(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON, r119);
    L97:
        return startPackageInstaller(r100, r114);
    L57:
        if (validateExternalMD5(r100, r112) == true) goto L59;
        return 0;
    L59:
        ApkInstallDetector.getInstance().start(r100, r112, r104);
        addStats("realStartViewIntent_7", "IsApkUnInstalled");
        if (r111 == false) goto L62;
    L65:
        r114 = buildViewIntent(r100, r112, r113, r111, r106);
        goto L66
    L62:
        if (silentInstallOnMiui(r100, r110, r113) == false) goto L65;
        r112.getTempCacheData().put(Constants.EXTRA_SILENT_INSTALL_SUCCEED, Boolean.TRUE);
        return 1;
    L98:
        r112.setFilePackageName(r104.packageName);     // Catch: Throwable -> L29
    L29:
        th = th;
    L34:
        Logger.taskError(TAG, r110, "realStartViewIntent", "Error:" + th);
        addStats("realStartViewIntent_3", "Error:" + th);
    L32:
        th = th;
        r104 = null;
        goto L34
    L9:
        if (r113.getPath().startsWith(r103.getAbsolutePath()) == false) goto L24;
        Process r107 = com_ss_android_socialbase_appdownloader_AppDownloadUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "chmod 555 " + r113.getAbsolutePath());     // Catch: Throwable -> L15
        r107.waitFor();     // Catch: Throwable -> L13
    L12:
        r107.destroy();
    L13:
        th = th;
    L102:
        th.printStackTrace();     // Catch: Throwable -> L20
        addStats("realStartViewIntent_2", "Error:" + th);     // Catch: Throwable -> L20
        Logger.taskError(TAG, r110, "realStartViewIntent", "Error:" + th);     // Catch: Throwable -> L20
        if (r107 == null) goto L24;
    L20:
        th = move-exception;
        if (r107 == null) goto L23;
        r107.destroy();
    L23:
        throw th;
    L15:
        th = th;
        r107 = null;
        goto L102
    L5:
        r102 = "null";
        goto L6
    }

    private static void startInstallView(final Context r100, final int r101, final boolean r102, final DownloadFile r110, final DownloadInfo r111) {
        DownloadComponentManager.submitIOTask(new AnonymousClass3(r100, r101, r102, r111, r110));
    }
}
