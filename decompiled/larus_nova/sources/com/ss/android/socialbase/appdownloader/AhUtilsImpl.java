package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.appdownloader.ah.AbsDevicePlan;
import com.ss.android.socialbase.appdownloader.ah.AndroidUnknownSourcePlan;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.android.socialbase.appdownloader.ah.M1UnknownSourcePlan;
import com.ss.android.socialbase.appdownloader.ah.V4DevicePlan;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.socialbase.appdownloader.util.AnUtils;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
import tb2.c;

/* JADX INFO: loaded from: classes38.dex */
public class AhUtilsImpl {
    private static final String TAG = null;
    private static AppStatusObserver sLastObserver;
    private static AhUtils.OnAhAttemptListener sOnAhAttemptListener;

    public static class AppStatusObserver implements AppStatusManager.AppStatusChangeListener {
        private JSONObject antiConfig;
        private final QueryHandlerImpl queryHandlerImpl;
        private final int queryInterval;

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int r100 = this.antiConfig.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message r101 = Message.obtain();
            r101.what = 1;
            QueryHandlerImpl.access$300(this.queryHandlerImpl).sendMessage(r101);
            if (r100 > 0) goto L5;
            return;
        L5:
            if (r100 >= 60) goto L9;
            Message r102 = Message.obtain();
            r102.what = 2;
            QueryHandlerImpl.access$300(this.queryHandlerImpl).sendMessageDelayed(r102, r100 * 1000);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (QueryHandlerImpl.access$200(this.queryHandlerImpl) == true) goto L5;
            Message r100 = Message.obtain();
            r100.what = 2;
            QueryHandlerImpl.access$300(this.queryHandlerImpl).sendMessage(r100);
        L5:
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            AhUtilsImpl.access$402(null);
        }

        public AppStatusObserver(Context r100, Intent r110, int r111, JSONObject r112, ConditionCheckCallable r113) {
            this.antiConfig = r112;
            int r114 = r112.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.queryInterval = r114;
            this.queryHandlerImpl = new QueryHandlerImpl(r100, r110, r111, r113, r114);
        }
    }

    public interface ConditionCheckCallable {
        boolean isConditionFit(Context r100);
    }

    public static class QueryCallable implements Callable<Boolean> {
        private final ConditionCheckCallable mConditionCheck;
        private final Context mContext;
        private final Handler mainHandler;
        private final long queryInterval;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            ConditionCheckCallable r100 = this.mConditionCheck;     // Catch: Throwable -> L21
            if (r100 == null) goto L18;
            long r101 = this.queryInterval;     // Catch: Throwable -> L21
            if (r101 <= 0) goto L18;
            if (r101 > 10000) goto L18;
            Context r102 = this.mContext;     // Catch: Throwable -> L21
            if (r102 == null) goto L12;
            boolean r103 = r100.isConditionFit(r102);     // Catch: Throwable -> L21
        L13:
            Message r104 = Message.obtain();     // Catch: Throwable -> L21
            if (r103 == false) goto L16;
            r104.what = 2;     // Catch: Throwable -> L21
            this.mainHandler.sendMessage(r104);     // Catch: Throwable -> L21
            goto L20
        L16:
            r104.what = 1;     // Catch: Throwable -> L21
            this.mainHandler.sendMessageDelayed(r104, this.queryInterval);     // Catch: Throwable -> L21
            goto L20
        L12:
            r103 = false;
        L18:
            return Boolean.FALSE;
        L20:
            return Boolean.FALSE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        public QueryCallable(Handler r100, Context r101, ConditionCheckCallable r102, long r103) {
            this.mContext = r101;
            this.mConditionCheck = r102;
            this.mainHandler = r100;
            this.queryInterval = r103;
        }
    }

    public static class QueryHandlerImpl implements WeakDownloadHandler.IHandler {
        public static final int WHAT_CANCEL_FUTURE_AND_START_ACTIVITY = 2;
        public static final int WHAT_QUERY_NEXT = 1;
        public static int currentStatus;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private static int f449569id;
        private final ConditionCheckCallable conditionCheck;
        private final Context context;
        private Future<Boolean> future;
        private boolean isOriginActivityStarted;
        private final Handler mainHandler;
        private final Intent originIntent;
        private final long queryInterval;

        public static /* synthetic */ boolean access$200(QueryHandlerImpl r100) {
            return r100.isOriginActivityStarted;
        }

        public static /* synthetic */ Handler access$300(QueryHandlerImpl r100) {
            return r100.mainHandler;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message r100) {
            if (r100 == null) goto L39;
            int r101 = r100.what;
            boolean r102 = true;
            if (r101 != 1) goto L13;
            long r103 = this.queryInterval;
            if (r103 > 0) goto L8;
            return;
        L8:
            if (r103 > 10000) goto L38;
            currentStatus = 1;
            this.future = DownloadComponentManager.getCPUThreadExecutor().submit(new QueryCallable(this.mainHandler, this.context, this.conditionCheck, this.queryInterval));
            return;
        L38:
            return;
        L13:
            if (r101 != 2) goto L41;
            currentStatus = 2;
            this.mainHandler.removeMessages(2);
            this.mainHandler.removeMessages(1);
            Future<Boolean> r104 = this.future;
            if (r104 == null) goto L18;
            r104.cancel(true);
        L18:
            if (this.isOriginActivityStarted == false) goto L20;
        L32:
            int r105 = f449569id;
            if (this.originIntent == null) goto L36;
            r102 = false;
        L36:
            AhUtilsImpl.access$600(r105, r102, AhUtilsImpl.isUnknownSourceEnabled(this.context));
            return;
        L20:
            if (Build.VERSION.SDK_INT >= 29) goto L22;
        L23:
            Intent r106 = this.originIntent;
            if (r106 == null) goto L26;
            AhUtilsImpl.access$500(this.context, r106);
        L31:
            this.isOriginActivityStarted = true;
            goto L32
        L26:
            DownloadInfo r107 = Downloader.getInstance(this.context).getDownloadInfo(f449569id);
            if (r107 == null) goto L31;
            if (r107.isDownloadOverStatus() == false) goto L31;
            AppDownloadUtils.proxyStartViewIntent(this.context, f449569id, false);
            goto L31
        L22:
            if (AppStatusManager.getInstance().isAppForeground() == false) goto L32;
        L41:
            return;
        }

        public QueryHandlerImpl(Context r100, Intent r101, int r102, ConditionCheckCallable r103, long r104) {
            this.isOriginActivityStarted = false;
            this.context = r100;
            this.originIntent = r101;
            f449569id = r102;
            this.conditionCheck = r103;
            this.mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.queryInterval = r104;
        }
    }

    public AhUtilsImpl() {
    }

    static {
        TAG = "AhUtilsImpl";
    }

    public static /* synthetic */ boolean access$000(Context r100) {
        return isXiaomiUnknownSourcesEnabled(r100);
    }

    public static /* synthetic */ boolean access$100(Context r100) {
        return isAndroidOUnknownSourcesEnabled(r100);
    }

    public static /* synthetic */ AppStatusObserver access$402(AppStatusObserver r100) {
        sLastObserver = r100;
        return r100;
    }

    private static boolean checkDeviceRomMatch(JSONObject r100) {
        return AnUtils.checkDeviceRomMatch(r100);
    }

    private static AhAttempt checkHwUnknownSourceConfig(JSONObject r100) {
        AhAttempt r101 = new AhAttempt();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.anti_plan_type = AhUtils.Plan.JUMP_UNKNOWN_SOURCE_HW;
        if (checkDeviceRomMatch(r100) == false) goto L8;
        r101.error_code = 0;
    L9:
        return r101;
    L8:
        r101.error_code = 2;
        goto L9
    }

    public static boolean checkOsApiLevel(JSONObject r100) {
        return AnUtils.checkOsApiLevel(r100);
    }

    public static boolean checkSecure(JSONObject r100) {
        return AnUtils.checkSecure(r100);
    }

    public static int getSavePathRedirectedCode(DownloadSetting r100) {
        JSONObject r101 = r100.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (r101 == null) goto L5;
        boolean r102 = !TextUtils.isEmpty(r101.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME));
    L6:
        if (r102 == true) goto L9;
        return 5;
    L9:
        JSONArray r103 = r100.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        int r104 = -1;
        if (r103 == null) goto L40;
        int r105 = r103.length();
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L40;
        JSONObject r107 = r103.optJSONObject(r106);
        if (AnUtils.checkAnConfig(r107) == false) goto L39;
        String r108 = r107.optString("type");
        if (AhUtils.Plan.JUMP_FILE_MANAGER.equals(r108) == false) goto L18;
    L36:
        r104 = checkJumpFileManagerConfig(r107, r100).error_code;
        if (r104 != 0) goto L39;
        return 0;
    L18:
        if (AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM.equals(r108) == true) goto L36;
        if (AhUtils.Plan.JUMP_FILE_MANAGER2.equals(r108) == true) goto L36;
        if (AhUtils.Plan.JUMP_FILE_MANAGER3.equals(r108) == true) goto L36;
        if (AhUtils.Plan.JUMP_FILE_MANAGER4.equals(r108) == true) goto L36;
        if (AhUtils.Plan.CUSTOM_SAVE_PATH.equalsIgnoreCase(r108) == true) goto L35;
        if (AhUtils.Plan.CUSTOM_INSTALLER_MI.equalsIgnoreCase(r108) == true) goto L35;
        if (AhUtils.Plan.JUMP_BROWSER_INSTALLER.equalsIgnoreCase(r108) == false) goto L39;
        r104 = checkBrowserInstallConfig(r107, r100).error_code;
        if (r104 != 0) goto L39;
    L35:
        return 0;
    L39:
        r106 = r106 + 1;
    L40:
        return r104;
    L5:
        r102 = false;
        goto L6
    }

    private static boolean isAndroidOUnknownSourcesEnabled(Context r100) {
        if (r100 != null) goto L8;
        return true;
    L8:
        return r100.getPackageManager().canRequestPackageInstalls();
    L7:
        return true;
    }

    public static boolean isUnknownSourceEnabled(Context r100) {
        if (r100 != null) goto L19;
        return true;
    L19:
        if (RomUtils.isMiui() == false) goto L12;
        if (Build.VERSION.SDK_INT >= 26) goto L12;
        return isXiaomiUnknownSourcesEnabled(r100);
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        if (r100.getApplicationInfo().targetSdkVersion < 26) goto L17;
        return isAndroidOUnknownSourcesEnabled(r100);
    L17:
        return true;
    }

    private static boolean isXiaomiUnknownSourcesEnabled(Context r100) {
        if (r100 != null) goto L11;
        return true;
    L11:
        if (Settings.Secure.getInt(r100.getContentResolver(), "install_non_market_apps", 1) > 0) goto L13;
        return false;
    L13:
        return true;
    L14:
        return true;
    }

    public static String parseThrowable(Throwable r100) {
        String r101 = r100.toString();
        if (r101.length() > 800) goto L5;
        return r101;
    L5:
        return r101.substring(0, 500);
    }

    public static void setOnAhAttemptListener(AhUtils.OnAhAttemptListener r100) {
        sOnAhAttemptListener = r100;
    }

    public static /* synthetic */ boolean access$500(Context r100, Intent r101) {
        return tryStartActivity(r100, r101);
    }

    private static void appendErrorCode(AhAttempt r100, int r101) {
        int r102 = r100.error_code;
        if (r102 == (-1)) goto L5;
        r100.error_code = (r102 * 10) + r101;
        return;
    L5:
        r100.error_code = r101;
    }

    public static AhAttempt checkBrowserInstallConfig(JSONObject r100, DownloadSetting r101) {
        AhAttempt r102 = new AhAttempt();
        if (r100 != null) goto L5;
        return r102;
    L5:
        r102.anti_plan_type = r100.optString("type");
        r102.device_plans = DevicePlans.DEVICE_PLAN_VIVO_BI;
        if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), DevicePlans.DEVICE_PLAN_VIVO_BI, r100, r101) == false) goto L8;
        r102.error_code = 0;
    L9:
        return r102;
    L8:
        appendErrorCode(r102, 3);
        goto L9
    }

    public static AhAttempt checkJumpFileManagerConfig(JSONObject r100, DownloadSetting r101) {
        AhAttempt r102 = new AhAttempt();
        if (r100 != null) goto L5;
        return r102;
    L5:
        String r103 = r100.optString("type");
        r102.anti_plan_type = r103;
        if (AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM.equals(r103) == false) goto L12;
        r102.device_plans = "custom";
        if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), "custom", r100, r101) == false) goto L11;
        r102.error_code = 0;
        return r102;
    L11:
        appendErrorCode(r102, 3);
    L21:
        return r102;
    L12:
        String r104 = r100.optString("device_plans");
        r102.device_plans = r104;
        if (TextUtils.isEmpty(r104) == true) goto L21;
        String[] r105 = r104.split(",");
        int r106 = r105.length;
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L21;
        String r108 = r105[r107];
        if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), r108, r100, r101) == true) goto L18;
        appendErrorCode(r102, 3);
        r107 = r107 + 1;
        goto L15
    L18:
        r102.error_code = 0;
        return r102;
    }

    public static boolean enableJumpUnKnownSource(Context r100, JSONObject r110) {
        if (r100 == null) goto L16;
        if (r110 == null) goto L19;
        SharedPreferences r101 = r100.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
        long r102 = r101.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0);
        int r103 = r101.getInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, 0);
        if (r110.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL_BY_SEQ) != 1) goto L9;
        long r104 = (new int[]{1, 1, 2, 3, 5, 8, 13, 21, 30}[r103 % 9] * 60) * 24;
    L10:
        long r105 = (System.currentTimeMillis() - r102) / 60000;
        if (r104 > 0) goto L13;
        return false;
    L13:
        if (r105 < r104) goto L18;
        return true;
    L18:
        return false;
    L9:
        r104 = r110.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0);
        goto L10
    L19:
        return false;
    L16:
        return false;
    }

    public static void sendGuideAuthDialogCancelEvent(int r100, JSONObject r101) {
        int r102 = 1;
        if (r101.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) != 1) goto L5;
        boolean r103 = true;
    L6:
        JSONObject r104 = new JSONObject();
        if (r103 == true) goto L17;
        r102 = 2;
    L17:
        r104.put("scene", r102);     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onUnityEvent(r100, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, r104);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    public static void sendGuideAuthDialogConfirmEvent(int r100, JSONObject r101) {
        int r102 = 1;
        if (r101.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) != 1) goto L5;
        boolean r103 = true;
    L6:
        JSONObject r104 = new JSONObject();
        if (r103 == true) goto L17;
        r102 = 2;
    L17:
        r104.put("scene", r102);     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onUnityEvent(r100, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, r104);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    private static void sendGuideAuthDialogShowEvent(int r100, JSONObject r101) {
        int r102 = 1;
        if (r101.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) != 1) goto L5;
        boolean r103 = true;
    L6:
        JSONObject r104 = new JSONObject();
        if (r103 == true) goto L17;
        r102 = 2;
    L17:
        r104.put("scene", r102);     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onUnityEvent(r100, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, r104);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    public static void sendGuideAuthOpenSettingEvent(int r100, JSONObject r101) {
        int r102 = 1;
        if (r101.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) != 1) goto L5;
        boolean r103 = true;
    L6:
        JSONObject r104 = new JSONObject();
        if (r103 == true) goto L17;
        r102 = 2;
    L17:
        r104.put("scene", r102);     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onUnityEvent(r100, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, r104);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    private static boolean tryStartActivity(Context r100, Intent r101) {
        return tryStartActivity(r100, r101, true, true);
    }

    public static /* synthetic */ void access$600(int r100, boolean r101, boolean r102) {
        sendGuideAuthResultEvent(r100, r101, r102);
    }

    private static boolean createDescFile(File r100, DownloadInfo r101, JSONObject r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r103 = r100.getPath();
        JSONObject r104 = DownloadSetting.obtain(r101.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        PolarisFileWrapper r105 = null;
        if (r104 == null) goto L8;
        String r106 = r104.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
    L10:
        if (TextUtils.isEmpty(r106) == false) goto L12;
    L14:
        if (r105 != null) goto L22;
        return true;
    L22:
    L19:
        return false;
    L16:
        if (r105.createNewFile() == false) goto L24;
        r105.deleteOnExit();     // Catch: IOException -> L19
        return true;
    L24:
        return true;
    L12:
        if (TextUtils.isEmpty(r106) == true) goto L14;
        r105 = new PolarisFileWrapper(r103 + File.separator + r106);
        goto L14
    L8:
        r106 = null;
        goto L10
    }

    private static void sendGuideAuthResultEvent(int r100, boolean r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        int r104 = 1;
        if (r101 == false) goto L6;
        int r105 = 1;
    L17:
        r103.put("scene", r105);     // Catch: Exception -> L13
        if (r102 == true) goto L11;
        r104 = 2;
    L11:
        r103.put("result_code", r104);     // Catch: Exception -> L13
    L15:
        DownloadComponentManager.getEventListener().onUnityEvent(r100, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, r103);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L6:
        r105 = 2;
        goto L17
    }

    public static boolean tryStartActivity(Context r100, Intent r101, boolean r102) {
        return tryStartActivity(r100, r101, r102, true);
    }

    public static boolean antiHijack(Context r100, DownloadInfo r101, Intent r102, boolean r103) {
        JSONArray r104 = DownloadSetting.obtain(r101.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (r104 == null) goto L12;
        int r105 = r104.length();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L18;
        JSONObject r107 = r104.optJSONObject(r106);
        if (AnUtils.checkAnConfig(r107) == false) goto L11;
        if (runAntiHijack(r100, r101, r102, r107, r103) == false) goto L11;
        return true;
    L11:
        r106 = r106 + 1;
        goto L5
    L18:
        return false;
    L12:
        return false;
    }

    private static AhAttempt checkMInstallConfig(JSONObject r100, String r101, Context r102, DownloadSetting r103) {
        AhAttempt r104 = new AhAttempt();
        if (r100 != null) goto L5;
    L18:
        return r104;
    L5:
        if (RomUtils.isMiui() == false) goto L18;
        r104.anti_plan_type = r100.optString("type");
        if (r103.optInt(LocationInfoConst.LIGHT_LOCATION_UPLOAD_CELL_KEY, 0) != 1) goto L12;
        r104.error_code = 0;
        return r104;
    L12:
        if (isUnknownSourceEnabled(r102) == false) goto L15;
        r104.error_code = 2;
        goto L18
    L15:
        if (AnUtils.queryPackageInfo(r101) == null) goto L17;
        r104.error_code = 0;
        goto L18
    L17:
        r104.error_code = 9;
        goto L18
    }

    private static boolean jumpCustomBrowserPage(Context r100, DownloadInfo r101, JSONObject r102, AhAttempt r103) {
        if (r100 == null) goto L27;
        if (r102 == null) goto L27;
        String r104 = r101.getSavePath();
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return false;
    L9:
        r103.real_device_plan = "custom";
        AbsDevicePlan r105 = DevicePlans.createDevicePlan(r100, "custom", r102, r101);
        if (r105 != null) goto L12;
    L26:
        r103.error_code = 3;
        goto L27
    L12:
        if (r105.isValid() == false) goto L26;
        Intent r106 = r105.getJumpIntent();
        if (r106 != null) goto L18;
        return false;
    L18:
        if (createDescFile(new PolarisFileWrapper(r104), r101, r102) == true) goto L20;
        r103.error_code = 6;
    L25:
        return false;
    L20:
        if (tryStartActivity(r100, r106) == false) goto L23;
        r103.error_code = 0;
        return true;
    L23:
        r103.error_code = 1;
    L27:
        return false;
    }

    private static boolean jumpFileManagerPage(Context r100, DownloadInfo r110, JSONObject r111, AhAttempt r112) {
        if (r100 == null) goto L32;
        if (r111 == null) goto L32;
        String r101 = r111.optString("device_plans");
        r112.device_plans = r101;
        if (TextUtils.isEmpty(r101) == true) goto L32;
        String[] r102 = r101.split(",");
        String r103 = r110.getSavePath();
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return false;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        StringBuilder r105 = new StringBuilder();
        int r106 = r102.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L27;
        String r108 = r102[r107];
        AbsDevicePlan r109 = DevicePlans.createDevicePlan(r100, r108, r111, r110);
        if (r109 == null) goto L26;
        Intent r113 = r109.getJumpIntent();
        if (r113 != null) goto L18;
        appendErrorCode(r112, 3);
        r105.append(r108);
        r105.append(" resolveActivity failed! ");
        goto L26
    L18:
        if (createDescFile(r104, r110, r111) == false) goto L24;
        boolean r114 = true;
        tryStartActivity(r100, r113, false);     // Catch: Throwable -> L22
    L28:
        if (r114 == true) goto L30;
        r112.error_msg = r105.toString();
    L31:
        return r114;
    L30:
        r112.real_device_plan = r108;
        r112.error_code = 0;
    L22:
        th = move-exception;
        r105.append(r108);
        r105.append(" startActivity failed : ");
        r105.append(parseThrowable(th));
        appendErrorCode(r112, 1);
        goto L26
    L24:
        appendErrorCode(r112, 6);
        r105.append(r108);
        r105.append(" createDescFile failed! ");
    L26:
        r105.append(c.DEFAULT_TEXT);
        r107 = r107 + 1;
        goto L12
    L27:
        r108 = null;
        r114 = false;
    L32:
        return false;
    }

    public static boolean realJumpUnknownSource(Context r100, Intent r101, int r102, JSONObject r103) {
        if (RomUtils.isMiui() == false) goto L14;
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        if (isXiaomiUnknownSourcesEnabled(r100) == true) goto L14;
        M1UnknownSourcePlan r104 = new M1UnknownSourcePlan(r100);     // Catch: Throwable -> L24
        if (r104.isValid() == false) goto L23;
        monitor(r100, r101, r102, r103, new AnonymousClass1());     // Catch: Throwable -> L24
        return tryStartActivity(r100, r104.getJumpIntent());
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L23;
        if (r100.getApplicationInfo().targetSdkVersion < 26) goto L23;
        if (isAndroidOUnknownSourcesEnabled(r100) == true) goto L23;
        AndroidUnknownSourcePlan r105 = new AndroidUnknownSourcePlan(r100);     // Catch: Throwable -> L24
        if (r105.isValid() == false) goto L23;
        monitor(r100, r101, r102, r103, new AnonymousClass2());     // Catch: Throwable -> L24
        return tryStartActivity(r100, r105.getJumpIntent());
    L23:
        return false;
    }

    public static boolean tryStartActivity(Context r100, Intent r101, boolean r102, boolean r103) {
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        if (AppInstallStatsReporter.isEnabled() == false) goto L9;
        AppInstallStatsReporter.report();
    L9:
        IDownloadAppInstallHandler r104 = AppDownloader.getInstance().getAppInstallHandler();
        if (r102 == true) goto L25;
        r101.putExtra("start_only_for_android", true);
        if (r104 == null) goto L22;
        if (r103 == false) goto L22;
        r104.startActivity(r100, r101);
    L23:
        return true;
    L22:
        r100.startActivity(r101);
        goto L23
    L25:
        r101.putExtra("start_only_for_android", true);     // Catch: Throwable -> L17
        if (r104 == null) goto L15;
        if (r103 == false) goto L15;
        r104.startActivity(r100, r101);     // Catch: Throwable -> L17
    L16:
        return true;
    L15:
        r100.startActivity(r101);     // Catch: Throwable -> L17
    L17:
        return false;
    L24:
        return false;
    }

    private static void monitor(Context r100, Intent r101, int r102, JSONObject r110, ConditionCheckCallable r111) {
        if (sLastObserver == null) goto L5;
        AppStatusManager.getInstance().unregisterAppSwitchListener(sLastObserver);
        sLastObserver = null;
    L5:
        sLastObserver = new AppStatusObserver(r100, r101, r102, r110, r111);
        AppStatusManager.getInstance().registerAppSwitchListener(sLastObserver);
    }

    private static boolean runAntiHijack(Context r110, DownloadInfo r111, Intent r112, JSONObject r113, boolean r210) {
        boolean r100 = false;
        if (r113 == null) goto L133;
        if (r111 == null) goto L133;
        AhAttempt r101 = new AhAttempt();
        String r102 = r113.optString("type");
        if (TextUtils.isEmpty(r102) == true) goto L133;
        DownloadSetting r103 = DownloadSetting.obtain(r111);
        r101.anti_plan_type = r102;
        r102.getClass();
        boolean r114 = true;
        switch(r102.hashCode()) {
            case -985763637: goto L48;
            case -985763636: goto L44;
            case -985763635: goto L40;
            case -985763634: goto L36;
            case -985763633: goto L32;
            case -985763632: goto L28;
            case -985763631: goto L24;
            case -985763630: goto L20;
            case -985763629: goto L16;
            case -985763628: goto L12;
            default: goto L10;
        };
    L10:
        byte r104 = -1;
    L51:
        switch(r104) {
            case 0: goto L112;
            case 1: goto L104;
            case 2: goto L87;
            case 3: goto L79;
            case 4: goto L112;
            case 5: goto L114;
            case 6: goto L74;
            case 7: goto L60;
            case 8: goto L53;
            case 9: goto L114;
            default: goto L128;
        };
    L53:
        r101 = checkHwUnknownSourceConfig(r113);
        if (r101.error_code != 0) goto L128;
        if (enableJumpUnKnownSource(r110, r113) == false) goto L59;
        boolean r105 = tryShowUnknownSource(r110, r112, r113, r111.getId(), r101);
    L78:
        r100 = r105;
        goto L128
    L59:
        r111.getTempCacheData().put(Constants.AhConstants.ANTI_CONFIG, r113);
        goto L128
    L60:
        String r106 = DecryptUtils.decrypt(r103.optString("bh"), r103.optString("s"));
        AhAttempt r107 = checkMInstallConfig(r113, r106, r110, r103);
        if (r107.error_code == 0) goto L63;
        r101 = r107;
        goto L128
    L63:
        String r108 = r110.getPackageName();
        if (AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), r110, r106) == true) goto L134;
        r101.error_code = 11;
        goto L128
    L134:
        AppDownloadUtils.startPackageInstaller(r110, r112);     // Catch: Throwable -> L67
        r101.error_code = 0;     // Catch: Throwable -> L67
        AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), r110, r108);
    L83:
        r100 = true;
    L67:
        th = move-exception;
        r101.error_code = 1;     // Catch: Throwable -> L70
        r101.error_msg = th.toString();     // Catch: Throwable -> L70
        AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), r110, r108);
    L70:
        th = move-exception;
        AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), r110, r108);
        throw th;
    L74:
        AhAttempt r109 = checkBrowserInstallConfig(r113, r103);
        if (r109.error_code != 0) goto L106;
        r105 = tryBrowserInstaller(r110, r111, r113, r101, r103);
    L106:
        r101 = r109;
        goto L128
    L79:
        r101.anti_plan_type = AhUtils.Plan.CUSTOM_SAVE_PATH;
        if (RomUtils.isVivo() == true) goto L138;
        r101.error_code = 2;
        goto L128
    L138:
        AppDownloadUtils.startPackageInstaller(r110, r112);     // Catch: Throwable -> L84
        r101.error_code = 0;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        r101.error_code = 4;
        r101.error_msg = th.toString();
        goto L128
    L104:
        r109 = checkJumpFileManagerConfig(r113, r103);
        if (r109.error_code != 0) goto L106;
        if (r111.isSavePathRedirected() == true) goto L110;
        r101.error_code = r111.getAntiHijackErrorCode(-1);
        goto L128
    L110:
        r105 = jumpCustomBrowserPage(r110, r111, r113, r101);
    L114:
        AhAttempt r115 = checkJumpFileManagerConfig(r113, r103);
        if (r115.error_code == 0) goto L118;
        r101 = r115;
        goto L128
    L118:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER3) == false) goto L123;
        if (TextUtils.isEmpty(r111.getDBJsonString(DbJsonConstants.CONTENT_URI)) == false) goto L123;
        r101.error_code = r111.getAntiHijackErrorCode(10);
    L123:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER4) == true) goto L125;
    L127:
        r105 = jumpFileManagerPage(r110, r111, r113, r101);
        goto L78
    L125:
        if (V4DevicePlan.isSavePathCorrect(r111) == true) goto L127;
        r101.error_code = r111.getAntiHijackErrorCode(7);
    L128:
        if (r100 == false) goto L131;
        r111.getTempCacheData().put(AhAttempt.JSON_TITLE, r101.getJsonString());
    L131:
        if (sOnAhAttemptListener == null) goto L133;
        r111.getTempCacheData().put("intent", r112);
        sOnAhAttemptListener.onAhAttemptResult(r111, r101);
        goto L133
    L87:
        if (Build.VERSION.SDK_INT >= 26) goto L91;
        if (RomUtils.isMiui() == false) goto L128;
    L91:
        if (r113.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL, 0) != 1) goto L93;
        boolean r116 = true;
    L94:
        if (r116 == true) goto L97;
        if (r210 == false) goto L128;
    L97:
        if (r113.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1) goto L100;
        r114 = false;
    L100:
        if (r114 == true) goto L128;
        if (enableJumpUnKnownSource(r110, r113) == false) goto L128;
        r105 = tryShowUnknownSource(r110, r112, r113, r111.getId(), r101);
        goto L78
    L93:
        r116 = false;
        goto L94
    L112:
        if (r111.isSavePathRedirected() == true) goto L114;
        r101.error_code = r111.getAntiHijackErrorCode(-1);
        goto L128
    L12:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER4) == false) goto L10;
        r104 = 9;
        goto L51
    L16:
        if (r102.equals(AhUtils.Plan.JUMP_UNKNOWN_SOURCE_HW) == false) goto L10;
        r104 = 8;
        goto L51
    L20:
        if (r102.equals(AhUtils.Plan.CUSTOM_INSTALLER_MI) == false) goto L10;
        r104 = 7;
        goto L51
    L24:
        if (r102.equals(AhUtils.Plan.JUMP_BROWSER_INSTALLER) == false) goto L10;
        r104 = 6;
        goto L51
    L28:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER3) == false) goto L10;
        r104 = 5;
        goto L51
    L32:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER2) == false) goto L10;
        r104 = 4;
        goto L51
    L36:
        if (r102.equals(AhUtils.Plan.CUSTOM_SAVE_PATH) == false) goto L10;
        r104 = 3;
        goto L51
    L40:
        if (r102.equals(AhUtils.Plan.JUMP_UNKNOWN_SOURCE) == false) goto L10;
        r104 = 2;
        goto L51
    L44:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM) == false) goto L10;
        r104 = 1;
        goto L51
    L48:
        if (r102.equals(AhUtils.Plan.JUMP_FILE_MANAGER) == false) goto L10;
        r104 = 0;
    L133:
        return r100;
    }

    private static boolean tryBrowserInstaller(Context r100, DownloadInfo r101, JSONObject r102, AhAttempt r103, DownloadSetting r104) {
        String r105 = r102.optString("type");
        r103.anti_plan_type = r105;
        Intent r106 = DevicePlans.createDevicePlan(r100, DevicePlans.DEVICE_PLAN_VIVO_BI, r102, r101).getJumpIntent();
        StringBuilder r107 = new StringBuilder();
        boolean r108 = tryStartActivity(r100, r106);     // Catch: Throwable -> L5
    L7:
        if (r108 == true) goto L9;
        r103.error_msg = r107.toString();
    L10:
        return true;
    L9:
        r103.error_code = 0;
    L5:
        th = move-exception;
        r107.append(r105);
        r107.append(" startActivity failed : ");
        r107.append(parseThrowable(th));
        appendErrorCode(r103, 1);
        r108 = false;
        goto L7
    }

    public static boolean tryShowUnknownSource(Context r100, Intent r101, JSONObject r102, int r103, AhAttempt r104) {
        if (r100 == null) goto L29;
        if (r102 == null) goto L29;
        if (isUnknownSourceEnabled(r100) == true) goto L29;
        if (r102.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) != 1) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L23;
    L18:
        th = move-exception;
        if (r104 == null) goto L21;
        r104.error_code = 1;
        r104.error_msg = "tryShowUnknownSourceDialog" + parseThrowable(th);
    L21:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L28;
        SharedPreferences r107 = r100.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
        SharedPreferences.Editor r108 = r107.edit();
        int r109 = (r107.getInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, 0) + 1) % 9;
        r108.putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis());
        r108.putInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, r109).apply();
    L28:
        return r106;
    L15:
        if (tryStartActivity(r100, JumpUnknownSourceActivity.getIntent(r100, r101, r102, r103), false, false) == false) goto L25;
        sendGuideAuthDialogShowEvent(r103, r102);     // Catch: Throwable -> L18
    L25:
        r106 = true;
        goto L26
    L23:
        if (realJumpUnknownSource(r100, r101, r103, r102) == false) goto L25;
        sendGuideAuthOpenSettingEvent(r103, r102);
        goto L25
    L11:
        r105 = false;
    L29:
        return false;
    }
}
