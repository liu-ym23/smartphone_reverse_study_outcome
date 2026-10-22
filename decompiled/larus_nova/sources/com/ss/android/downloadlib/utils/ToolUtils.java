package com.ss.android.downloadlib.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import com.ss.android.ad.applinksdk.model.AppLinkEventConfig;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.download.api.runtime.IAdPermissionProvider;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.download.api.utils.MarketUriUtils;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.applink.AdMarketOpenSubManager;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import ira.d;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ToolUtils {
    private static final int CACHE_SIZE = 73;
    private static final double COLOR_MAX = 120.0d;
    private static Object[] EMPTY = null;
    private static final int FLAGS_GET_ONLY_FROM_ANDROID = 16777216;
    private static final long G = 1073741824;
    static final char[] HEX_CHARS = null;
    private static final long K = 1024;
    private static final long M = 1048576;
    private static final long T = 1099511627776L;
    public static final String TAG = "ToolUtils";
    private static PackageInfo hostPackageInfo;

    /* JADX INFO: renamed from: pm, reason: collision with root package name */
    private static PackageManager f408344pm;
    private static Object[] sCache;
    private static String sPACKAGE_NAME;

    static {
        EMPTY = new Object[0];
        sCache = new Object[73];
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        sPACKAGE_NAME = null;
    }

    public ToolUtils() {
    }

    public static int idealByteArraySize(int r100) {
        int r101 = 4;
    L4:
        if (r101 >= 32) goto L9;
        int r102 = (1 << r101) - 12;
        if (r100 <= r102) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return r100;
    }

    public static boolean whetherNeedOptScopedStoragePermission() {
    L22:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (f408344pm != null) goto L7;
        f408344pm = GlobalInfo.getContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L22
    L7:
        if (hostPackageInfo != null) goto L9;
        hostPackageInfo = f408344pm.getPackageInfo(GlobalInfo.getContext().getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L22
    L9:
        PackageInfo r100 = hostPackageInfo;     // Catch: PackageManager.NameNotFoundException -> L22
        if (r100 == null) goto L18;
        ApplicationInfo r101 = r100.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L22
        if (r101 == null) goto L18;
        if (r101.targetSdkVersion < 30) goto L26;
        return true;
    L26:
        return false;
    L18:
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_GET_APPLICATION_INFO_FAILED, null, null);     // Catch: PackageManager.NameNotFoundException -> L22
        if (Build.VERSION.SDK_INT < 30) goto L27;
        return true;
    L27:
        return false;
    }

    public static String getPackageName() {
        if (TextUtils.isEmpty(sPACKAGE_NAME) == false) goto L8;
        if (GlobalInfo.getContext() == null) goto L8;
        sPACKAGE_NAME = GlobalInfo.getContext().getPackageName();     // Catch: Exception -> L9
    L8:
        return sPACKAGE_NAME;
    }

    public static void tryMoveAppToFront() {
        IAdPermissionProvider r100 = (IAdPermissionProvider) DownloadAdRuntimeProvider.getInnerService(IAdPermissionProvider.class);
        if (r100 == null) goto L22;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r100.hasPermissions(GlobalInfo.getContext(), Arrays.asList(new String[]{"android.permission.REORDER_TASKS"})) == true) goto L23;
        ActivityManager r101 = (ActivityManager) GlobalInfo.getContext().getSystemService("activity");     // Catch: Exception -> L14
        Iterator<ActivityManager.RunningTaskInfo> r102 = r101.getRunningTasks(20).iterator();     // Catch: Exception -> L14
    L9:
        if (r102.hasNext() == false) goto L25;
        ActivityManager.RunningTaskInfo r103 = r102.next();     // Catch: Exception -> L14
        if (GlobalInfo.getContext().getPackageName().equals(r103.topActivity.getPackageName()) == false) goto L9;
        INVOKEVIRTUAL_com_ss_android_downloadlib_utils_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront(r101, r103.id, 1);     // Catch: Exception -> L14
        return;
    L25:
        return;
    L23:
        return;
    }

    public static boolean checkWhetherWifi() {
        DeviceBandwidthSampler.updateNetworkStatus();
        return DeviceBandwidthSampler.isWifi();
    }

    public static boolean checkWritePermission() {
        if (PermissionUtils.whetherNeedOptReadWritePermission() == false) goto L15;
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L7;
    L12:
        return true;
    L7:
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_AUDIO) == true) goto L12;
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == true) goto L12;
        return false;
    L15:
        return PermissionUtils.hasPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static long getTodayMillis() {
        Calendar r100 = Calendar.getInstance();
        r100.set(11, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
        return r100.getTimeInMillis();
    }

    public static boolean isMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean whetherTopActivitySingleTask() {
        ActivityManager r100 = (ActivityManager) GlobalInfo.getContext().getSystemService("activity");
        PackageManager r101 = GlobalInfo.getContext().getPackageManager();
        List<ActivityManager.RunningTaskInfo> r102 = r100.getRunningTasks(1);
        if (r102 != null) goto L16;
    L15:
        return false;
    L16:
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        if (r102.size() <= 0) goto L15;
        Iterator<ActivityManager.RunningTaskInfo> r103 = r100.getRunningTasks(((ActivityManager.RunningTaskInfo) ListProtector.get(r102, 0)).numActivities).iterator();     // Catch: Exception -> L13
    L8:
        if (r103.hasNext() == false) goto L15;
        if (r101.getActivityInfo(r103.next().topActivity, 128).launchMode != 2) goto L8;
        return true;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_downloadlib_utils_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String bytesToHuman(long r100) {
        long[] r101 = {1099511627776L, 1073741824, 1048576, 1024, 1};
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
        return format(r100, r104, r102[r103]);
    L12:
        return null;
    L5:
        return "0 " + r102[4];
    }

    public static boolean checkFromStar(NativeDownloadModel r100) {
        JSONObject r101 = r100.getModel().getExtra();
        if (r101 != null) goto L12;
        return false;
    L12:
        String r102 = r101.optString(EventConstants.ExtraJson.EXTRA_STAR_ATLAS_LOG_EXTRA);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r102) == true) goto L9;
        return new JSONObject(r102).optBoolean(EventConstants.ExtraJson.EXTRA_IS_STAR);
    L9:
        return false;
    L10:
        TTDownloaderMonitor.inst().monitorDataError(false, true, "解析星图场景数据时发生异常");
        return false;
    }

    public static boolean checkWritePermission(boolean r100) {
        if (r100 == false) goto L14;
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L6;
    L11:
        return true;
    L6:
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_AUDIO) == true) goto L11;
        if (PermissionUtils.hasPermission(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == true) goto L11;
        return false;
    L14:
        return PermissionUtils.hasPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static JSONObject copyJson(JSONObject r100) {
        return com.ss.android.download.api.utils.ToolUtils.copyJson(r100);
    }

    public static boolean exists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        return new PolarisFileWrapper(r100).exists();
    }

    public static PackageInfo getApkFilePackageInfo(NativeDownloadModel r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DownloadInfo r101 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r100.getDownloadId());
        if (r101 != null) goto L11;
        return null;
    L11:
        return AppDownloadUtils.parseApkFile(GlobalInfo.getContext(), r101, r101.getSavePath(), r101.getName());
    L10:
        return null;
    }

    public static JSONObject getBaseJson(NativeDownloadModel r100) {
        JSONObject r101 = new JSONObject();
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L34;
        return r101;
    L34:
        copyJson(r100.getExtra(), r101);     // Catch: Exception -> L31
        copyJson(r100.getEventExtra(), r101);     // Catch: Exception -> L31
        r101.putOpt(EventConstants.ExtraJson.TTDOWNLOADER, 1);     // Catch: Exception -> L31
        r101.putOpt("download_url", r100.getDownloadUrl());     // Catch: Exception -> L31
        r101.putOpt("package_name", r100.getPackageName());     // Catch: Exception -> L31
        r101.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));     // Catch: Exception -> L31
        r101.putOpt("rom_name", RomUtils.getName());     // Catch: Exception -> L31
        r101.putOpt("rom_version", RomUtils.getVersion());     // Catch: Exception -> L31
        r101.putOpt("funnel_type", Integer.valueOf(getRealFunnelType(r100)));     // Catch: Exception -> L31
        r101.putOpt("os", RomUtils.getOs());     // Catch: Exception -> L31
        r101.putOpt("call_scene", Integer.valueOf(r100.getCallScene()));     // Catch: Exception -> L31
        r101.putOpt("download_scene", Integer.valueOf(r100.getDownloadScene()));     // Catch: Exception -> L31
        r101.putOpt("download_mode", Integer.valueOf(r100.getDownloadMode()));     // Catch: Exception -> L31
        if (r102 != null) goto L8;
    L10:
        int r103 = 2;
    L11:
        r101.putOpt("settings_enable", Integer.valueOf(r103));     // Catch: Exception -> L31
        r101.putOpt("is_order_download", Integer.valueOf(r100.getIsOrderDownload()));     // Catch: Exception -> L31
        EventAppendUtils.appendDownloadSdkBasicInfo(r101);     // Catch: Exception -> L31
        EventAppendUtils.appendDownloadKeyStrategyInfo(r101, r100);     // Catch: Exception -> L31
        if (getRealFunnelType(r100) != 2) goto L15;
        EventAppendUtils.appendMarketParams(r101, r100);     // Catch: Exception -> L31
    L15:
        if (RomUtils.isHarmony() == false) goto L17;
        EventAppendUtils.appendHarmonyOsInfo(r101);     // Catch: Exception -> L31
    L19:
        if (RomUtils.isMiui() == false) goto L22;
        EventAppendUtils.appendMIUIPureModeInfo(r101);     // Catch: Exception -> L31
    L22:
        if (r100.getComplianceItem() == null) goto L25;
        EventAppendUtils.appendComplianceInfo(r101, r100);     // Catch: Exception -> L31
    L25:
        if (r100.getDownloadScene() != 0) goto L27;
        EventAppendUtils.appendFeedPkgInfo(r101, r100);     // Catch: Exception -> L31
    L27:
        EventAppendUtils.appendOrderDownloadInfo(r101, r100);     // Catch: Exception -> L31
        EventAppendUtils.appendExtraUserInfo(r101);     // Catch: Exception -> L31
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_DISABLE_TAG_AND_REFER_IN_AD_EXTRA_DATA, 0) != 1) goto L33;
        r101.remove("tag");     // Catch: Exception -> L31
        r101.remove("refer");     // Catch: Exception -> L31
    L33:
        return r101;
    L17:
        EventAppendUtils.appendPureModeSupportInfo(r101);     // Catch: Exception -> L31
        goto L19
    L8:
        if (r102.getTTDownloaderAdSettings().length() <= 0) goto L10;
        r103 = 1;
    L31:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "getBaseJson");
        goto L33
    }

    public static long getExternalAvailableSpaceBytes(long r100) {
        return getAvailableSpaceBytes(GlobalInfo.getContext().getExternalCacheDir(), r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static File getExternalStorageFile(Context r100) {
        if (whetherNeedOptScopedStoragePermission() == true) goto L7;
        return Environment.getExternalStorageDirectory();
    L7:
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getExternalFilesDir(null);
    }

    public static String getFilteredDownloadUrl(String r100) {
        return UriProtector.parse(r100).getLastPathSegment();
    }

    public static <T> T getNonNull(T... r100) {
        if (r100 == null) goto L13;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        T r103 = r100[r102];
        if (r103 != null) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        return r103;
    L11:
        throw new IllegalArgumentException("args is null");
    L13:
        throw new IllegalArgumentException("args is null");
    }

    public static String getNotEmptyStr(String... r100) {
        return com.ss.android.download.api.utils.ToolUtils.getNotEmptyStr(r100);
    }

    public static int getRealFunnelType(NativeDownloadModel r100) {
        if (AdMarketOpenSubManager.getInstance().canOpenMarket(r100, true, null) == false) goto L7;
        return 2;
    L7:
        if (r100.getController().getDownloadMode() != 4) goto L11;
        return 5;
    L11:
        return r100.getFunnelType();
    }

    public static long getReportableSpaceMB(long r100) {
        return DownloadUtils.getReportableSpaceMB(r100);
    }

    public static String getSizeStr(long r100) {
        DecimalFormat r101 = new DecimalFormat("0.00");
        if (r100 < 1073741824) goto L6;
        return (r100 / 1073741824) + "G";
    L6:
        if (r100 < 1048576) goto L9;
        return (r100 / 1048576) + "M";
    L9:
        return r101.format(r100 / 1048576.0f) + "M";
    }

    public static int getTargetSdkVersion(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).applicationInfo.targetSdkVersion;
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static long getTotalSpaceBytes(File r100) {
        if (r100 != null) goto L10;
        return -1;
    L10:
        return new StatFs(r100.getAbsolutePath()).getTotalBytes();
    L7:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String hexToString(String r100) {
        return DownloadUtils.hexToString(r100);
    }

    public static int idealLongArraySize(int r100) {
        return idealByteArraySize(r100 * 8) / 8;
    }

    public static boolean isAppActivatedByPKG(String r100) {
        Context r101 = GlobalInfo.getContext();
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (isInstalledApp(r101, r100) == true) goto L31;
        return false;
    L31:
    L28:
        e = move-exception;
        e.printStackTrace();
        return true;
    L10:
        if (Build.VERSION.SDK_INT >= 29) goto L12;
    L17:
        File r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath(), "android/data/" + r100);     // Catch: Exception -> L28
    L19:
        if (r103.exists() == true) goto L21;
        return false;
    L21:
        long r104 = FileUtils.getLastModifiedTime(r103);     // Catch: Exception -> L28
        PackageInfo r105 = r101.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L28
        if (r105 == null) goto L27;
        if (r105.lastUpdateTime >= r104) goto L27;
        return true;
    L27:
        return false;
    L12:
        if (r101.getApplicationInfo().targetSdkVersion < 29) goto L17;
        if (r102 == null) goto L17;
        if (r102.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.KEY_GET_EXT_DIR_MODE) != 1) goto L17;
        r103 = getExtDir(r101, r100);     // Catch: Exception -> L28
        goto L19
    }

    public static boolean isAppActivatedByUrl(String r100) {
        if (f408344pm != null) goto L5;
        f408344pm = GlobalInfo.getContext().getPackageManager();
    L5:
        ComponentName r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r100)).resolveActivity(f408344pm);
        if (r101 != null) goto L8;
    L10:
        String r102 = null;
    L12:
        return isAppActivatedByPKG(r102);
    L8:
        if (r101.getPackageName() == null) goto L10;
        r102 = r101.getPackageName();
        Logger.d("ToolUtils", "activity.resolvePackageName-->" + r102);
        goto L12
    }

    public static boolean isDownloadFileExist(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (new PolarisFileWrapper(r100).exists() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isInstalledApp(DownloadModel r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return getInstalledAppInfo(r100.getPackageName(), r100.getVersionCode(), r100.getVersionName()).isInstall();
    }

    public static boolean isNetworkAvailable(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isNoSpaceLeftStatus(BaseException r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getErrorCode();
        String r102 = r100.getMessage();
        if (r101 != 1006) goto L8;
        return true;
    L8:
        if (r101 != 1052) goto L10;
        return true;
    L10:
        if (r101 == 1023) goto L18;
        if (r101 == 1039) goto L18;
        if (r101 == 1040) goto L18;
        if (r101 == 1036) goto L18;
    L22:
        return false;
    L18:
        if (TextUtils.isEmpty(r102) == true) goto L22;
        if (r102.contains(DownloadConstants.ERROR_MSG_NO_SPACE_LEFT) == false) goto L22;
        return true;
    }

    public static boolean isOpenUrlValid(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (f408344pm != null) goto L8;
        f408344pm = GlobalInfo.getContext().getPackageManager();
    L8:
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r100));
        PackageManager r102 = f408344pm;     // Catch: Throwable -> L16
        if (r102 == null) goto L15;
        if (r101.resolveActivity(r102) == null) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isUpdateAppForGame(NativeDownloadModel r100) {
        if (r100 != null) goto L35;
        return false;
    L35:
        String r101 = r100.getPackageName();     // Catch: Exception -> L32
        int r102 = r100.getVersionCode();     // Catch: Exception -> L32
        String r103 = r100.getVersionName();     // Catch: Exception -> L32
        DownloadInstallInfo r104 = new DownloadInstallInfo();     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return false;
    L9:
        if (f408344pm != null) goto L12;
        f408344pm = GlobalInfo.getContext().getPackageManager();     // Catch: Exception -> L32
    L12:
        if (isInstalledApp(GlobalInfo.getContext(), r101) == false) goto L30;
        PackageInfo r105 = f408344pm.getPackageInfo(r101, 0);     // Catch: Exception -> L32
        if (r105 == null) goto L30;
        r104.setVersionCode(r105.versionCode);     // Catch: Exception -> L32
        r104.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_NORMAL);     // Catch: Exception -> L32
        IAdDownloadCheckerProvider r106 = (IAdDownloadCheckerProvider) DownloadAdRuntimeProvider.getInnerService(IAdDownloadCheckerProvider.class);     // Catch: Exception -> L32
        if (r106 != null) goto L18;
    L22:
        if (r106 != null) goto L30;
        IAdDownloadCheckerProvider r107 = GlobalInfo.getDownloadCheckerFactory();     // Catch: Exception -> L32
        if (r107 == null) goto L30;
        if (r107.isOpenUpgradeChecker() == false) goto L30;
        if (isAppNewVersion(r105.versionCode, r102, r105.versionName, r103) == true) goto L30;
        r104.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_UPGRADE);     // Catch: Exception -> L32
        goto L30
    L18:
        if (r106.isOpenUpgradeChecker() == false) goto L22;
        if (isAppNewVersion(r105.versionCode, r102, r105.versionName, r103) == true) goto L22;
        r104.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_UPGRADE);     // Catch: Exception -> L32
    L30:
        return r104.isInstall();
    L32:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isWifi(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static Uri jointIgnoreInterceptInMarketScheme(Uri r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.JOINT_IGNORE_INTERCEPT_IN_SCHEME, 0) != 1) goto L18;
        String r101 = MarketUriUtils.getPackageNameFromUri(r100);
        if (r101 != null) goto L9;
        TTDownloaderMonitor.inst().monitorDataError(false, true, "jointIgnoreIntercept package = null");
        return r100;
    L9:
        DownloadModel r102 = ModelManager.getInstance().getDownloadModel(r101);
        if (r102 != null) goto L14;
        TTDownloaderMonitor.inst().monitorDataError(false, true, "jointIgnoreIntercept downloadModel = null");
        return r100;
    L14:
        if (DownloadInsideHelper.callSceneIsAdComplianceData(r102) == true) goto L16;
        return r100;
    L16:
        return r100.buildUpon().appendQueryParameter(DownloadConstants.MARKET_IGNORE_INTERCEPT, "1").build();
    L18:
        return r100;
    }

    public static HashMap<String, String> jsonToMap(JSONObject r100) {
        HashMap<String, String> r101 = new HashMap();
        if (r100 != null) goto L13;
    L12:
        return r101;
    L13:
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L10
    L6:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();     // Catch: Exception -> L10
        r101.put(r103, r100.optString(r103));     // Catch: Exception -> L10
        goto L6
    L9:
        return r101;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static String md5Hex(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20 Exception -> L27
        if (r102 != null) goto L6;
        return null;
    L6:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 Exception -> L27
    L41:
        byte[] r104 = new byte[8192];     // Catch: Throwable -> L18 Exception -> L34
    L9:
        int r105 = r103.read(r104, 0, 8192);     // Catch: Throwable -> L18 Exception -> L34
        if (r105 <= 0) goto L12;
        r102.update(r104, 0, r105);     // Catch: Throwable -> L18 Exception -> L34
        goto L9
    L12:
        String r106 = toHexString(r102.digest());     // Catch: Throwable -> L18 Exception -> L34
        r103.close();     // Catch: IOException -> L15
    L17:
        return r106;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L18:
        th = th;
        r101 = r103;
    L21:
        if (r101 != null) goto L35;
    L26:
        throw th;
    L35:
        r101.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (r103 != null) goto L39;
    L33:
        return null;
    L39:
        r103.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L27:
        r103 = null;
    L20:
        th = th;
        goto L21
    }

    public static JSONObject mergeJson(JSONObject... r100) {
        return com.ss.android.download.api.utils.ToolUtils.mergeJson(r100);
    }

    public static String toHexString(byte[] r100) {
        return toHexString(r100, 0, r100.length);
    }

    public static NativeDownloadModel transferDownloadInfoIntoNativeDownloadModel(DownloadInfo r100) {
        int r101 = 0;
        AdDownloadModel.Builder r102 = new AdDownloadModel.Builder().setId(r100.getUrl().hashCode()).setDownloadUrl(r100.getUrl()).setPackageName(r100.getPackageName()).setIsAd(false).setVersionCode(r100.getAppVersionCode()).setMimeType(r100.getMimeType()).setAppName(r100.getName()).setAppIcon(r100.getIconUrl()).setIgnoreIntercept(r100.isIgnoreInterceptor()).setInstalledDate(r100.getInstalledTimeStamp());     // Catch: JSONException -> L21
        if (r100.isHasDoInstallation() == false) goto L6;
        r101 = 1;
    L6:
        AdDownloadModel r103 = r102.setHasDoInstallation(r101).build();     // Catch: JSONException -> L21
        if (r100.getExtra() == null) goto L15;
        if (r100.getExtra() == "") goto L15;
        JSONObject r104 = new JSONObject(r100.getExtra());     // Catch: JSONException -> L21
        r103.setExtra(r104);     // Catch: JSONException -> L21
        if (r104.optString("business_type") == "") goto L15;
        r103.setModelType(CastIntegerProtector.parseInt(r104.optString("business_type")));     // Catch: JSONException -> L21
    L15:
        if (r100.getDownloadSettingString() != null) goto L17;
    L19:
        return new NativeDownloadModel(r103, new AdDownloadEventConfig.Builder().build(), new AdDownloadController.Builder().setLinkMode(r100.getLinkMode()).build(), r100.getId());
    L17:
        if (r100.getDownloadSettingString() == "") goto L19;
        r103.setDownloadSettings(new JSONObject(r100.getDownloadSettingString()));     // Catch: JSONException -> L21
    L21:
        return null;
    }

    public static boolean isInstalledApp(NativeDownloadModel r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return getInstalledAppInfo(r100.getPackageName(), r100.getVersionCode(), r100.getVersionName()).isInstall();
    }

    public static String md5Hex(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r101.digest());
    }

    public static int compareVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L35;
        if (TextUtils.isEmpty(r101) == true) goto L35;
        if (r100.equals(r101) == false) goto L11;
        return 0;
    L11:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L36
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L36
        int r104 = Math.min(r102.length, r103.length);     // Catch: Exception -> L36
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r104) goto L17;
        r106 = CastIntegerProtector.parseInt(r102[r105]) - CastIntegerProtector.parseInt(r103[r105]);     // Catch: Exception -> L36
        if (r106 != 0) goto L17;
        r105 = r105 + 1;     // Catch: Exception -> L36
    L17:
        if (r106 != 0) goto L32;
        int r107 = r105;
    L20:
        if (r107 >= r102.length) goto L25;
        if (CastIntegerProtector.parseInt(r102[r107]) > 0) goto L23;
        r107 = r107 + 1;     // Catch: Exception -> L36
        goto L20
    L23:
        return 1;
    L25:
        if (r105 >= r103.length) goto L31;
        if (CastIntegerProtector.parseInt(r103[r105]) > 0) goto L29;
        r105 = r105 + 1;
        goto L25
    L29:
        return -1;
    L31:
        return 0;
    L32:
        if (r106 <= 0) goto L45;
        return 1;
    L45:
        return -1;
    L35:
        return -2;
    }

    public static JSONObject copyJson(JSONObject r100, JSONObject r101) {
        return com.ss.android.download.api.utils.ToolUtils.copyJson(r100, r101);
    }

    public static int dp2px(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_ss_android_downloadlib_utils_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static JSONObject generateAppLinkDataReport(d r100, AppLinkEventConfig r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102 = mergeJson(new JSONObject[]{r102, r100.a()});
    L5:
        if (r101 != null) goto L7;
        return r102;
    L7:
        return mergeJson(new JSONObject[]{r102, r101.a()});
    }

    public static Drawable getApkIconFromApk(Context r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PackageManager r102 = r100.getPackageManager();
        PackageInfo r103 = r102.getPackageArchiveInfo(r101, 0);
        if (r103 == null) goto L14;
        ApplicationInfo r104 = r103.applicationInfo;
        r104.sourceDir = r101;
        r104.publicSourceDir = r101;
        return r104.loadIcon(r102);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static Drawable getAppIcon(Context r100, String r101) {
        if (r100 != null) goto L4;
    L7:
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        PackageManager r102 = r100.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L9
        return r102.getApplicationInfo(r101, 0).loadIcon(r102);
    }

    public static String getAppNameFromApK(Context r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        PackageManager r102 = r100.getPackageManager();
        PackageInfo r103 = r102.getPackageArchiveInfo(r101, 0);
        if (r103 == null) goto L12;
        ApplicationInfo r104 = r103.applicationInfo;
        r104.sourceDir = r101;
        r104.publicSourceDir = r101;
        return r104.loadLabel(r102).toString();
    L12:
        return null;
    L13:
        return null;
    }

    public static long getAvailableSpaceBytes(File r100, long r101) {
        if (r100 != null) goto L9;
        return r101;
    L9:
        return DownloadUtils.getAvailableSpaceBytes(r100.getAbsolutePath());
    L6:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }

    public static String getDownloadAppPackageName(Context r100, String r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Exception -> L14
        if (r102.exists() == false) goto L20;
        PackageInfo r103 = r100.getPackageManager().getPackageArchiveInfo(r102.getAbsolutePath(), 0);     // Catch: Exception -> L14
        if (r103 != null) goto L12;
        return "";
    L12:
        return r103.packageName;
    L20:
        return "";
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L22:
        return "";
    }

    public static File getExtDir(Context r100, String r101) {
        String r102 = null;
        File r103 = r100.getExternalFilesDir(null).getParentFile();
        if (r103 == null) goto L5;
        r102 = r103.getParent();
    L5:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102 + File.separator + r101);
        StringBuilder r105 = new StringBuilder("getExtDir: file.toString()-->");
        r105.append(r104.toString());
        Logger.d("ToolUtils", r105.toString());
        return r104;
    }

    public static String getFixLengthString(String r100, int r101) {
        if (r101 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return r100;
    L8:
        if (r100.length() > r101) goto L11;
        return r100;
    L11:
        return r100.substring(0, r101);
    }

    public static Intent getLaunchIntentForPackage(Context r100, String r101) {
        Intent r102 = r100.getPackageManager().getLaunchIntentForPackage(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.hasCategory("android.intent.category.LAUNCHER") == true) goto L8;
        r102.addCategory("android.intent.category.LAUNCHER");
    L8:
        r102.setPackage(null);
        r102.addFlags(2097152);
        r102.addFlags(268435456);
        return r102;
    }

    public static String getPackageNameFromApk(Context r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PackageInfo r102 = r100.getPackageManager().getPackageArchiveInfo(r101, 0);
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102.applicationInfo.packageName;
    L14:
        return null;
    }

    public static String getQueryMap(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r100.contains("?") == true) goto L10;
    L14:
        String[] r102 = r100.split("&");
        HashMap r103 = new HashMap();
        int r104 = r102.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L18;
        String r106 = r102[r105];
        r103.put(r106.split(ContainerUtils.KEY_VALUE_DELIMITER)[0], r106.split(ContainerUtils.KEY_VALUE_DELIMITER)[1]);
        r105 = r105 + 1;
        goto L15
    L18:
        return (String) r103.get(r101);
    L10:
        if (r100.indexOf("?") >= r100.length()) goto L14;
        r100 = r100.substring(r100.indexOf("?") + 1);
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return null;
    }

    public static Signature[] getSignaturesByApkFilePath(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageArchiveInfo(r101, 64);     // Catch: Throwable -> L6
        if (r102 == null) goto L12;
        return r102.signatures;
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Signature[] getSignaturesByPackageName(Context r100, String r101) {
        if (r100 == null) goto L13;
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: Throwable -> L7
        if (r102 == null) goto L14;
        return r102.signatures;
    L14:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    L13:
        return null;
    }

    public static int getVersionCode(Context r100, String r101) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r102 == null) goto L15;
        return r102.versionCode;
    L15:
        return -1;
    L16:
        return -1;
    L14:
        return -1;
    }

    public static String getVersionName(Context r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r102 == null) goto L15;
        return r102.versionName;
    L15:
        return "";
    L16:
        return "";
    L14:
        return "";
    }

    public static boolean isApkFileInstalled(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        String r102 = getPackageNameFromApk(r100, r101);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return false;
    L10:
        if (isInstalledApp(r100, r102) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static boolean isApkInstalled(Context r100, String r101) {
        if (r100 == null) goto L29;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L34;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Exception -> L22
        if (r102.exists() == false) goto L31;
        PackageInfo r103 = r100.getPackageManager().getPackageArchiveInfo(r102.getAbsolutePath(), 0);     // Catch: Exception -> L22
        if (r103 != null) goto L13;
        return false;
    L13:
        String r104 = r103.packageName;     // Catch: Exception -> L22
        int r105 = r103.versionCode;     // Catch: Exception -> L22
        PackageInfo r106 = r100.getPackageManager().getPackageInfo(r104, 0);     // Catch: PackageManager.NameNotFoundException -> L16 Exception -> L22
    L17:
        if (r106 == null) goto L35;
        if (r105 <= r106.versionCode) goto L33;
        return false;
    L33:
        return true;
    L35:
        return false;
    L16:
        r106 = null;
        goto L17
    L31:
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();
        return false;
    L34:
        return false;
    L29:
        return false;
    }

    public static boolean isColorSimilar(int r100, int r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        int r102 = r100 | (-16777216);
        int r103 = r101 | (-16777216);
        int r104 = Color.red(r102) - Color.red(r103);
        int r105 = Color.green(r102) - Color.green(r103);
        int r106 = Color.blue(r102) - Color.blue(r103);
        if (Math.sqrt(((r104 * r104) + (r105 * r105)) + (r106 * r106)) < COLOR_MAX) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isGameUnionLive(JSONObject r100, long r101) {
        if (r100 != null) goto L5;
    L7:
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(r101);
        if (r102 != null) goto L10;
    L12:
        return false;
    L10:
        if (r102.isFromGameUnionLive() == false) goto L12;
        return true;
    L5:
        if (TextUtils.equals(r100.optString("product_type"), BaseConstants.GAME_INFO_LIVE_UNION) == false) goto L7;
        return true;
    }

    public static boolean isInstalledApp(Context r100, String r101) {
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L6;
        r100 = GlobalInfo.getContext();
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L33;
        return false;
    L33:
        if (r100.getPackageManager().getPackageInfo(r101, 0) == null) goto L14;
        boolean r103 = true;
    L15:
        if (r102 == null) goto L30;
        if (r102.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.BugFix.FIX_APP_INSTALLED_CHECK, 1) != 1) goto L30;
        if (r100.getPackageManager().getLaunchIntentForPackage(r101) == null) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == r103) goto L30;
        TTDownloaderMonitor.inst().monitorDataError(false, true, "app installed incorrect");     // Catch: Exception -> L25
        return r104;
    L25:
        e = e;
        r103 = r104;
    L28:
        TTDownloaderMonitor.inst().monitorException(true, false, e, e.getMessage());
        goto L30
    L21:
        r104 = false;
    L27:
        e = e;
    L30:
        return r103;
    L14:
        r103 = false;
        goto L15
    }

    public static boolean isIntentAvailable(Context r100, Intent r101) {
        if (r100 == null) goto L13;
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(r101, 65536);     // Catch: Exception -> L10
        if (r102 == null) goto L14;
        if (r102.isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    public static boolean isSignatureMatch(Signature[] r100, Signature[] r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        if (r100.length == r101.length) goto L12;
        return false;
    L12:
        int r102 = 0;
    L14:
        if (r102 >= r100.length) goto L24;
        Signature r103 = r100[r102];
        if (r103 == null) goto L18;
    L19:
        if (r103 == null) goto L23;
        if (r103.equals(r101[r102]) == true) goto L23;
    L22:
        return false;
    L23:
        r102 = r102 + 1;
        goto L14
    L18:
        if (r101[r102] != null) goto L22;
    L24:
        return true;
    L25:
        return false;
    }

    public static long optLong(JSONObject r100, String r101) {
        return com.ss.android.download.api.utils.ToolUtils.optLong(r100, r101);
    }

    public static int px2dp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_ss_android_downloadlib_utils_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static boolean isInstalledApp(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        r100 = GlobalInfo.getContext();
    L7:
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(r101, 65536);
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.size() <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    public static void INVOKEVIRTUAL_com_ss_android_downloadlib_utils_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront(ActivityManager r100, int r101, int r102) {
        if (r101 == 0) goto L5;
        r100.moveTaskToFront(r101, r102);
        return;
    L5:
        ActivityManagerLancet.handleFakeMoveTaskToFront(r102);
    }

    private static String format(long r100, long r101, String r102) {
        double r103 = r100;
        if (r101 <= 1) goto L6;
        r103 = r103 / r101;
    L6:
        return new DecimalFormat("#.##").format(r103) + " " + r102;
    }

    public static JSONObject generateTLoggerReport(DownloadModel r100, DownloadController r101, DownloadEventConfig r102) {
        JSONObject r103 = new JSONObject();
        if ((r100 instanceof AdDownloadModel) == false) goto L6;
        r103 = mergeJson(new JSONObject[]{r103, ((AdDownloadModel) r100).toJson()});
    L6:
        if ((r101 instanceof AdDownloadController) == false) goto L9;
        r103 = mergeJson(new JSONObject[]{r103, ((AdDownloadController) r101).toJson()});
    L9:
        if ((r102 instanceof AdDownloadEventConfig) == true) goto L11;
        return r103;
    L11:
        return mergeJson(new JSONObject[]{r103, ((AdDownloadEventConfig) r102).toJson()});
    }

    public static DownloadInstallInfo getInstalledAppInfo(String r100, int r101, String r102) {
        DownloadInstallInfo r103 = new DownloadInstallInfo();
        if (TextUtils.isEmpty(r100) == false) goto L35;
        return r103;
    L35:
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L6:
        if (f408344pm != null) goto L9;
        f408344pm = GlobalInfo.getContext().getPackageManager();     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
    L9:
        if (isInstalledApp(GlobalInfo.getContext(), r100) == false) goto L33;
        PackageInfo r104 = f408344pm.getPackageInfo(r100, 0);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        if (r104 == null) goto L33;
        r103.setVersionCode(r104.versionCode);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        r103.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_NORMAL);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        IAdDownloadCheckerProvider r105 = (IAdDownloadCheckerProvider) DownloadAdRuntimeProvider.getInnerService(IAdDownloadCheckerProvider.class);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        if (r105 != null) goto L15;
    L19:
        if (r105 != null) goto L33;
        TTDownloadSettingsModel r106 = TTDownloadSettingsAdapter.INSTANCE.get();     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        IAdDownloadCheckerProvider r107 = GlobalInfo.getDownloadCheckerFactory();     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        if (r107 == null) goto L33;
        if (r107.isOpenUpgradeChecker() == false) goto L33;
        if (r106 == null) goto L33;
        if (r106.getFixUpdateDelete() != 1) goto L33;
        if (isAppNewVersion(r104.versionCode, r101, r104.versionName, r102) == true) goto L33;
        r103.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_UPGRADE);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
        goto L33
    L15:
        if (r105.isOpenUpgradeChecker() == false) goto L19;
        if (isAppNewVersion(r104.versionCode, r101, r104.versionName, r102) == true) goto L19;
        r103.setInstallStatus(DownloadInstallInfo.DOWNLOAD_INSTALL_UPGRADE);     // Catch: Exception -> L31 PackageManager.NameNotFoundException -> L34
    L33:
        return r103;
    }

    public static int getInstalledAppStatus(String r100, int r101, String r102) {
        int r103 = DownloadInstallInfo.DOWNLOAD_INSTALL_DEFAULT;
        if (TextUtils.isEmpty(r100) == false) goto L17;
        return r103;
    L17:
    L14:
        e = move-exception;
        e.printStackTrace();
        return r103;
    L6:
        if (f408344pm != null) goto L8;
        f408344pm = GlobalInfo.getContext().getPackageManager();     // Catch: Exception -> L14
    L8:
        PackageInfo r104 = f408344pm.getPackageInfo(r100, 0);     // Catch: Exception -> L14
        if (r104 == null) goto L19;
        int r105 = DownloadInstallInfo.DOWNLOAD_INSTALL_NORMAL;     // Catch: Exception -> L14
        if (isAppNewVersion(r104.versionCode, r101, r104.versionName, r102) == true) goto L20;
        return DownloadInstallInfo.DOWNLOAD_INSTALL_UPGRADE;
    L20:
        return r105;
    L19:
        return r103;
    }

    public static String getTagValue(String r100, String r101, NativeDownloadModel r102) {
        if (r102.getExtra() == null) goto L5;
        String r103 = getNotEmptyStr(new String[]{r100, r102.getEventTag(), r102.getExtra().optString("tag"), EventConstants.Tag.EMBEDED_AD});
    L6:
        TTDownloadSettingsModel r104 = TTDownloadSettingsAdapter.INSTANCE.get();
        if ("click".equals(r101) == true) goto L17;
        Regex r105 = v6.a.f553365a;
        if (v6.a.b(r102.getLogExtra()) == true) goto L14;
        if (r104 == null) goto L17;
        if (r104.getEnableDefaultTag() != 1) goto L17;
    L14:
        if ("live_ad".equals(r103) == false) goto L16;
        return r103;
    L16:
        return EventConstants.Tag.EMBEDED_AD;
    L17:
        return r103;
    L5:
        r103 = getNotEmptyStr(new String[]{r100, r102.getEventTag(), EventConstants.Tag.EMBEDED_AD});
        goto L6
    }

    public static boolean isInstalledApp(String r100, int r101, String r102) {
        return getInstalledAppInfo(r100, r101, r102).isInstall();
    }

    public static boolean isInstalledAppNeedUpgrade(String r100, int r101, String r102) {
        return getInstalledAppInfo(r100, r101, r102).isNeedUpgrade();
    }

    public static boolean isInstalledPackageMatch(Context r100, String r101, String r102) {
        if (isPackageMatchApk(r100, r101, r102) == false) goto L5;
    L8:
        return true;
    L5:
        if (isInstalledApp(r100, r102) == true) goto L8;
        return false;
    }

    public static boolean isPackageMatchApk(Context r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L38;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Exception -> L26
        if (r103.exists() == false) goto L35;
        PackageInfo r104 = r100.getPackageManager().getPackageArchiveInfo(r103.getAbsolutePath(), 0);     // Catch: Exception -> L26
        if (r104 != null) goto L15;
        return false;
    L15:
        if (r104.packageName.equals(r102) == true) goto L17;
        return false;
    L17:
        int r105 = r104.versionCode;     // Catch: Exception -> L26
        PackageInfo r106 = r100.getPackageManager().getPackageInfo(r102, 0);     // Catch: PackageManager.NameNotFoundException -> L20 Exception -> L26
    L21:
        if (r106 == null) goto L39;
        if (r105 == r106.versionCode) goto L37;
        return false;
    L37:
        return true;
    L39:
        return false;
    L20:
        r106 = null;
        goto L21
    L35:
        return false;
    L26:
        e = move-exception;
        e.printStackTrace();
        return false;
    L38:
        return false;
    }

    public static void safePut(JSONObject r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.putOpt(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L15;
        if (r110 < 0) goto L13;
        if ((r110 + r111) > r100.length) goto L13;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= r111) goto L11;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L8
    L11:
        return new String(r102, 0, r101);
    L13:
        throw new NullPointerException("bytes is null");
    L15:
        throw new NullPointerException("bytes is null");
    }

    private static boolean isAppNewVersion(int r100, int r101, String r102, String r103) {
        if (r101 == 0) goto L5;
    L7:
        if (r101 <= 0) goto L11;
        if (r100 < r101) goto L11;
        return true;
    L11:
        if (compareVersion(r102, r103) < 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return true;
    }
}
