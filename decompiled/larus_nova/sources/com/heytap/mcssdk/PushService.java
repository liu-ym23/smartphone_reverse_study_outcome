package com.heytap.mcssdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.e.d;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import com.mcs.aidl.INotifiPermissionCallback;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PushService implements b {
    private static final String ACTION_NOTIFICATION_ADVANCE = "com.heytap.mcs.action.NOTIFICATION_ADVANCE";
    private static final int ANDROID_T_SDK_VERSION_CODE = 32;
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_VERSION_CODE = "versionCode";
    private static final String APP_VERSION_NAME = "versionName";
    private static final int DEFAULT_API_MAX_COUNT = 2;
    private static final String EVENT_ID = "eventID";
    private static final String EXTRA = "extra";
    private static final String GLOBAL_ID = "globalID";
    private static final String KEY_CALLBACK = "result_callback";
    private static final int MAX_HOUR_IN_DAY = 23;
    private static final int MAX_MIN_IN_HOUR = 59;
    private static final int MCS_SUPPORT_VERSION = 1019;
    private static final String MESSAGE_ID = "messageID";
    private static final String MESSAGE_TYPE = "messageType";
    public static final String MINI_PROGRAM_PKG = "miniProgramPkg";
    private static final int[] NEW_MCS_PACKAGE = null;
    private static String NEW_MCS_RECEIVE_SDK_ACTION = null;
    private static final String NEW_MCS_RECEIVE_SDK_ACTION_Base64 = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final int[] OLD_MCS_PACKAGE = null;
    private static final int[] OLD_MCS_RECEIVE_SDK_ACTION = null;
    private static final String PUSH_SDK_VERSION = "pushSdkVersion";
    private static final int SDK_INT_24 = 24;
    private static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    private static final int SYSTEM_UID = 1000;
    private static final String TAG = null;
    private static final String TASK_ID = "taskID";
    private static final String TYPE = "type";
    private static int sCount;
    private static boolean sIsNewMcsPkg;
    private static String sMcsPkgName;
    private ConcurrentHashMap<Integer, com.heytap.mcssdk.c.a> mAppLimitMap;
    private String mAuthCode;
    private Context mContext;
    private ICallBackResultService mICallBackResultService;
    private IGetAppNotificationCallBackService mIGetAppNotificationCallBackService;
    private ISetAppNotificationCallBackService mISetAppNotificationCallBackService;
    private List<d> mParsers;
    private PermissionCallbackProxy mPermissionCallback;
    private List<com.heytap.mcssdk.f.c> mProcessors;
    private String mRegisterID;
    private String mVerifyCode;
    private boolean needStaticRegister;

    public static final class PermissionCallbackProxy extends INotifiPermissionCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f276255a = 2000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private INotificationPermissionCallback f276256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f276257c;

        public PermissionCallbackProxy() {
            this.f276257c = 0;
        }

        private boolean b() {
            if ((SystemClock.elapsedRealtime() - this.f276257c) > 2000) goto L5;
            return true;
        L5:
            return false;
        }

        private void c() {
            this.f276257c = SystemClock.elapsedRealtime();
        }

        private void d() {
            this.f276257c = 0;
        }

        public void a() {
            d();
            this.f276256b = null;
        }

        public boolean a(INotificationPermissionCallback r100) {
            if (b() == false) goto L6;
            return false;
        L6:
            c();
            this.f276256b = r100;
            return true;
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onFail(int r100, String r101) {
            d();
            INotificationPermissionCallback r102 = this.f276256b;
            if (r102 == null) goto L5;
            r102.onFail(r100, r101);
        L5:
            this.f276256b = null;
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onSuccess() {
            d();
            INotificationPermissionCallback r100 = this.f276256b;
            if (r100 == null) goto L5;
            r100.onSuccess();
        L5:
            this.f276256b = null;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PushService f276258a = null;

        static {
            f276258a = new PushService(null);
        }

        private a() {
        }

        public static /* synthetic */ PushService a() {
            return f276258a;
        }
    }

    static {
        TAG = "PushService";
        OLD_MCS_PACKAGE = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
        OLD_MCS_RECEIVE_SDK_ACTION = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
        NEW_MCS_PACKAGE = new int[]{99, 111, 109, 46, 104, 101, 121, 116, 97, 112, 46, 109, 99, 115};
        NEW_MCS_RECEIVE_SDK_ACTION = "";
        sCount = 0;
    }

    private PushService() {
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        this.mRegisterID = null;
        this.needStaticRegister = true;
        this.mPermissionCallback = new PermissionCallbackProxy();
        monitor-enter(PushService.class);
        int r100 = sCount;     // Catch: Throwable -> L12
        if (r100 > 0) goto L11;
        sCount = r100 + 1;     // Catch: Throwable -> L12
        monitor-exit(PushService.class);     // Catch: Throwable -> L12
        addParser(new com.heytap.mcssdk.e.b());
        addParser(new com.heytap.mcssdk.e.a());
        addProcessor(new com.heytap.mcssdk.f.b());
        addProcessor(new com.heytap.mcssdk.f.a());
        this.mAppLimitMap = new ConcurrentHashMap();
        return;
    L11:
        throw new RuntimeException("PushService can't create again!");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ PushService(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ Context access$100(PushService r100) {
        return r100.mContext;
    }

    private com.heytap.mcssdk.c.a addCommandToMap(int r100) {
        if (this.mAppLimitMap.containsKey(Integer.valueOf(r100)) == false) goto L9;
        com.heytap.mcssdk.c.a r101 = this.mAppLimitMap.get(Integer.valueOf(r100));
        if (checkTimeNeedUpdate(r101) == false) goto L7;
        r101.a(1);
        r101.a(System.currentTimeMillis());
        String r102 = "addCommandToMap : appLimitBean.setCount(1)";
    L8:
        com.heytap.mcssdk.utils.d.b(r102);
        return r101;
    L7:
        r101.a(r101.b() + 1);
        r102 = "addCommandToMap :appLimitBean.getCount() + 1";
        goto L8
    L9:
        com.heytap.mcssdk.c.a r103 = new com.heytap.mcssdk.c.a(System.currentTimeMillis(), 1);
        this.mAppLimitMap.put(Integer.valueOf(r100), r103);
        com.heytap.mcssdk.utils.d.b("addCommandToMap :appBean is null");
        return r103;
    }

    private synchronized void addParser(d r100) {
        monitor-enter(this);
        if (r100 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.mParsers.add(r100);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void addProcessor(com.heytap.mcssdk.f.c r100) {
        monitor-enter(this);
        if (r100 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.mProcessors.add(r100);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private boolean checkAll() {
        if (checkContext() == true) goto L5;
    L7:
        return false;
    L5:
        if (checkRegisterID() == false) goto L7;
        return true;
    }

    private boolean checkContext() {
        if (this.mContext == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkRegisterID() {
        if (this.mRegisterID == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkTimeNeedUpdate(com.heytap.mcssdk.c.a r100) {
        long r101 = r100.a();
        long r102 = System.currentTimeMillis();
        com.heytap.mcssdk.utils.d.b("checkTimeNeedUpdate : lastedTime " + r101 + " currentTime:" + r102);
        if ((r102 - r101) <= 1000) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkTop(Activity r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        int r102 = Build.VERSION.SDK_INT;
        List<ActivityManager.AppTask> r103 = r101.getAppTasks();
        if (r103 != null) goto L5;
    L13:
        List<ActivityManager.RunningTaskInfo> r104 = r101.getRunningTasks(1);
        if (r104 != null) goto L16;
    L18:
        return false;
    L16:
        if (r104.size() <= 0) goto L18;
        ActivityManager.RunningTaskInfo r105 = (ActivityManager.RunningTaskInfo) ListProtector.get(r104, 0);
        String r106 = r100.getClass().getName();
        ComponentName r107 = r105.topActivity;
    L12:
        return r106.equals(r107.getClassName());
    L5:
        if (r103.size() <= 0) goto L13;
        ActivityManager.AppTask r108 = (ActivityManager.AppTask) ListProtector.get(r103, 0);
        if (r102 < 23) goto L13;
        if (r108.getTaskInfo().topActivity == null) goto L13;
        r106 = r100.getClass().getName();
        r107 = r108.getTaskInfo().topActivity;
        goto L12
    }

    public static PushService getInstance() {
        return a.a();
    }

    private Intent getIntent(int r100, String r101, JSONObject r102) {
        Intent r103 = new Intent();
        r103.setAction(getReceiveSdkAction(this.mContext));
        r103.setPackage(getMcsPackageName(this.mContext));
        r103.putExtra("type", r100);
        JSONObject r104 = new JSONObject();
        Context r105 = this.mContext;     // Catch: Throwable -> L10 Exception -> L15
        r104.putOpt(APP_VERSION_NAME, Utils.getVersionName(r105, r105.getPackageName()));     // Catch: Throwable -> L10 Exception -> L15
        Context r106 = this.mContext;     // Catch: Throwable -> L10 Exception -> L15
        r104.putOpt("versionCode", Integer.valueOf(Utils.getVersionCode(r106, r106.getPackageName())));     // Catch: Throwable -> L10 Exception -> L15
        if (r102 == null) goto L13;
        Iterator<String> r107 = r102.keys();     // Catch: Throwable -> L10 Exception -> L15
    L7:
        if (r107.hasNext() == false) goto L13;
        String r108 = r107.next();     // Catch: Throwable -> L10 Exception -> L15
        r104.putOpt(r108, r102.get(r108));     // Catch: Throwable -> L10 Exception -> L15
    L10:
        th = move-exception;
        r103.putExtra("extra", r104.toString());
        throw th;
    L13:
        r103.putExtra("extra", r104.toString());
        r103.putExtra("params", r101);
        r103.putExtra("appPackage", this.mContext.getPackageName());
        r103.putExtra(com.heytap.mcssdk.constant.b.f276376z, this.mAuthCode);
        r103.putExtra(com.heytap.mcssdk.constant.b.A, this.mVerifyCode);
        r103.putExtra(com.heytap.mcssdk.constant.b.B, this.mRegisterID);
        r103.putExtra(com.heytap.mcssdk.constant.b.C, getSDKVersionName());
        r103.putExtra(com.heytap.mcssdk.constant.b.E, getUserId(this.mContext));
        return r103;
    }

    private String getMcsPackageNameInner(Context r110) {
        String r100 = TAG;
        com.heytap.mcssdk.utils.d.b(r100, "getMcsPackageNameInner -- ");
        String r101 = null;
        if (Build.VERSION.SDK_INT < 24) goto L24;
        PackageManager r111 = r110.getPackageManager();
        String r102 = Utils.getString(NEW_MCS_PACKAGE);     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
        boolean r103 = false;
        ApplicationInfo r104 = r111.getApplicationInfo(r102, 0);     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
        if (r104 != null) goto L8;
    L18:
        return r101;
    L8:
        if ((r104.flags & 1) != 1) goto L10;
        boolean r105 = true;
    L11:
        int r112 = r111.getPackageUid("android", 0);     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
        int r106 = r104.uid;     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
        int r113 = g.a();     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
        if (g.a(r106, r113) != r112) goto L14;
        r103 = true;
    L14:
        if (r105 == true) goto L16;
        if (r103 == true) goto L16;
    L17:
        com.heytap.mcssdk.utils.d.b(r100, "getMcsPackageNameInner packageUid = " + r106 + ", systemUid = " + r112 + ", userId = " + r113);     // Catch: Exception -> L19 PackageManager.NameNotFoundException -> L22 Throwable -> L25
    L16:
        r101 = r102;
        goto L17
    L10:
        r105 = false;
    L19:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e(TAG, "Error in get mcs package name:" + e.getMessage());     // Catch: Throwable -> L25
        return r101;
    L22:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e(TAG, "NameNotFoundException in get mcs package name:" + e.getMessage());     // Catch: Throwable -> L25
    L24:
        return r101;
    }

    public static int getSDKVersionCode() {
        return com.heytap.mcssdk.a.f276264f;
    }

    public static String getSDKVersionName() {
        return com.heytap.mcssdk.a.f276265g;
    }

    private int getUserId(Context r100) {
        return ((Integer) Context.class.getMethod("getUserId", new Class[0]).invoke(r100, new Object[0])).intValue();
    L5:
        return 0;
    }

    private boolean isSupportPushInner(Context r100) {
        if (this.mContext != null) goto L5;
        this.mContext = r100.getApplicationContext();
    L5:
        String r101 = getMcsPackageName(this.mContext);
        if (Utils.isExistPackage(this.mContext, r101) == true) goto L8;
    L12:
        boolean r102 = false;
    L13:
        com.heytap.mcssdk.utils.d.b(TAG, "isSupportPushInner -- " + r102);
        return r102;
    L8:
        if (Utils.getVersionCode(this.mContext, r101) < 1019) goto L12;
        if (Utils.isSupportPush(this.mContext, r101, SUPPORT_OPEN_PUSH) == false) goto L12;
        r102 = true;
        goto L13
    }

    private static void onAppStart(Context r100) {
        StatUtil.statisticMessage(r100, new MessageStat(r100.getPackageName(), "app_start", null));
    }

    private void startMcsService(int r100, String r101, JSONObject r102) {
        if (checkCommandLimit(r100) == true) goto L5;
        this.mContext.startService(getIntent(r100, r101, r102));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e("startMcsService--Exception" + e.getMessage());
        return;
    L5:
        if (this.mICallBackResultService == null) goto L15;
        this.mICallBackResultService.onError(getErrorCode(r100), "api_call_too_frequently", this.mContext.getPackageName(), getMiniProgramPkgFromJSON(r102));
        return;
    }

    private void startMcsService(int r100, JSONObject r101) {
        startMcsService(r100, "", r101);
    }

    public void bindMcsService(int r100) {
        if (checkCommandLimit(r100) == false) goto L8;
        ICallBackResultService r101 = this.mICallBackResultService;
        if (r101 == null) goto L10;
        r101.onError(getErrorCode(r100), "api_call_too_frequently", this.mContext.getPackageName(), "");
        return;
    L10:
        return;
    L8:
        final Intent r102 = getIntent(r100, "", null);
        this.mContext.bindService(r102, new AnonymousClass1(this, r102), 1);
    }

    @Override // com.heytap.mcssdk.b
    public void cancelNotification(JSONObject r100) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    public boolean checkCommandLimit(int r100) {
        com.heytap.mcssdk.c.a r101 = addCommandToMap(r100);
        if (r100 != 12291) goto L5;
        return false;
    L5:
        if (r100 != 12312) goto L7;
        return false;
    L7:
        if (r101.b() <= 2) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotificationAdvanceCallback() {
        this.mPermissionCallback.a();
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotificationType(JSONObject r100) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotifications(JSONObject r100) {
        if (checkContext() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.b
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService r100) {
        if (checkContext() == false) goto L6;
        this.mISetAppNotificationCallBackService = r100;
        startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        return;
    L6:
        if (getPushCallback() == null) goto L10;
        this.mISetAppNotificationCallBackService.onSetAppNotificationSwitch(-2);
        return;
    }

    @Override // com.heytap.mcssdk.b
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService r100) {
        if (checkContext() == false) goto L5;
        this.mISetAppNotificationCallBackService = r100;
        startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        return;
    L5:
        ISetAppNotificationCallBackService r101 = this.mISetAppNotificationCallBackService;
        if (r101 == null) goto L10;
        r101.onSetAppNotificationSwitch(-2);
        return;
    }

    public Map<Integer, com.heytap.mcssdk.c.a> getAppLimitMap() {
        return this.mAppLimitMap;
    }

    @Override // com.heytap.mcssdk.b
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService r100) {
        if (checkContext() == false) goto L5;
        this.mIGetAppNotificationCallBackService = r100;
        startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        return;
    L5:
        IGetAppNotificationCallBackService r101 = this.mIGetAppNotificationCallBackService;
        if (r101 == null) goto L10;
        r101.onGetAppNotificationSwitch(-2, 0);
        return;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getErrorCode(int r100) {
        switch(r100) {
            case 12289: goto L40;
            case 12290: goto L38;
            case 12291: goto L36;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 12298: goto L34;
            case 12299: goto L32;
            case 12300: goto L30;
            default: goto L4;
        };
    L4:
        switch(r100) {
            case 12306: goto L28;
            case 12307: goto L26;
            case 12308: goto L24;
            case 12309: goto L22;
            case 12310: goto L20;
            case 12311: goto L18;
            case 12312: goto L16;
            case 12313: goto L14;
            default: goto L5;
        };
    L5:
        switch(r100) {
            case 12316: goto L12;
            case 12317: goto L10;
            case 12318: goto L8;
            default: goto L6;
        };
    L6:
        return 0;
    L8:
        return -17;
    L10:
        return -16;
    L12:
        return -15;
    L14:
        return -12;
    L16:
        return -13;
    L18:
        return -9;
    L20:
        return -8;
    L22:
        return -5;
    L24:
        return -7;
    L26:
        return -6;
    L28:
        return -10;
    L30:
        return -4;
    L32:
        return -3;
    L34:
        return -11;
    L36:
        return -14;
    L38:
        return -2;
    L40:
        return -1;
    }

    public String getMcsPackageName(Context r100) {
        if (sMcsPkgName != null) goto L10;
        String r101 = getMcsPackageNameInner(r100);
        if (r101 != null) goto L7;
        sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
        boolean r102 = false;
    L8:
        sIsNewMcsPkg = r102;
        goto L10
    L7:
        sMcsPkgName = r101;
        r102 = true;
    L10:
        return sMcsPkgName;
    }

    public String getMiniProgramPkgFromJSON(JSONObject r100) {
        if (r100 != null) goto L11;
        return "";
    L11:
        return r100.optString("miniProgramPkg");
    L7:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b("Error happened in getMiniProgramPkgFromJSON() :" + e.getMessage());     // Catch: Throwable -> L10
    L9:
        return "";
    }

    @Override // com.heytap.mcssdk.b
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.b
    public void getNotificationStatus(JSONObject r100) {
        if (checkAll() == false) goto L6;
        startMcsService(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, r100);
        return;
    L6:
        if (getPushCallback() == null) goto L10;
        getPushCallback().onGetNotificationStatus(-2, 0);
        return;
    }

    public List<d> getParsers() {
        return this.mParsers;
    }

    public List<com.heytap.mcssdk.f.c> getProcessors() {
        return this.mProcessors;
    }

    public ICallBackResultService getPushCallback() {
        return this.mICallBackResultService;
    }

    public IGetAppNotificationCallBackService getPushGetAppNotificationCallBack() {
        return this.mIGetAppNotificationCallBackService;
    }

    public ISetAppNotificationCallBackService getPushSetAppNotificationCallBack() {
        return this.mISetAppNotificationCallBackService;
    }

    public void getPushStatus() {
        if (checkAll() == false) goto L6;
        startMcsService(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        return;
    L6:
        if (getPushCallback() == null) goto L10;
        getPushCallback().onGetPushStatus(-2, 0);
        return;
    }

    public int getPushVersionCode() {
        if (checkContext() == false) goto L6;
        Context r100 = this.mContext;
        return Utils.getVersionCode(r100, getMcsPackageName(r100));
    L6:
        return 0;
    }

    public String getPushVersionName() {
        if (checkContext() == false) goto L6;
        Context r100 = this.mContext;
        return Utils.getVersionName(r100, getMcsPackageName(r100));
    L6:
        return "";
    }

    public String getReceiveSdkAction(Context r100) {
        if (sMcsPkgName != null) goto L6;
        getMcsPackageNameInner(r100);
    L6:
        if (sIsNewMcsPkg == false) goto L13;
        if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION) == false) goto L11;
        NEW_MCS_RECEIVE_SDK_ACTION = new String(com.heytap.mcssdk.a.a.b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
    L11:
        return NEW_MCS_RECEIVE_SDK_ACTION;
    L13:
        return Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
    }

    @Override // com.heytap.mcssdk.b
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.b
    public void getRegister(JSONObject r100) {
        if (checkContext() == false) goto L6;
        startMcsService(12289, r100);
        return;
    L6:
        if (getPushCallback() == null) goto L10;
        getPushCallback().onRegister(-2, null, null, null);
        return;
    }

    @Override // com.heytap.mcssdk.b
    public String getRegisterID() {
        return this.mRegisterID;
    }

    public PushService init(Context r100, boolean r101) {
        if (r100 == null) goto L6;
        innerInit(r100);
        new com.heytap.mcssdk.b.a().a(this.mContext);
        com.heytap.mcssdk.utils.d.f(r101);
        return this;
    L6:
        throw new IllegalArgumentException("context can't be null");
    }

    public void innerInit(Context r100) {
        this.mContext = r100.getApplicationContext();
        if (sMcsPkgName != null) goto L10;
        String r101 = getMcsPackageNameInner(r100);
        if (r101 != null) goto L7;
        sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
        boolean r102 = false;
    L8:
        sIsNewMcsPkg = r102;
        return;
    L7:
        sMcsPkgName = r101;
        r102 = true;
        goto L8
    }

    public boolean isSupportPushByClient(Context r100) {
        return isSupportPushInner(r100);
    }

    @Override // com.heytap.mcssdk.b
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.b
    public void openNotificationSettings(JSONObject r100) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.b
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.b
    public void pausePush(JSONObject r100) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.b
    public void register(Context r100, String r101, String r102, ICallBackResultService r110) {
        register(r100, r101, r102, null, r110);
    }

    @Override // com.heytap.mcssdk.b
    public void register(Context r100, String r101, String r102, JSONObject r103, ICallBackResultService r104) {
        if (r100 != null) goto L8;
        if (r104 == null) goto L29;
        r104.onRegister(-2, null, null, null);
        return;
    L29:
        return;
    L8:
        if (this.mContext != null) goto L11;
        this.mContext = r100.getApplicationContext();
    L11:
        if (Utils.isSupportPushByClient(this.mContext) == true) goto L16;
        if (r104 == null) goto L30;
        r104.onRegister(-2, null, null, null);
        return;
    L30:
        return;
    L16:
        if (this.needStaticRegister == false) goto L18;
        com.heytap.mcssdk.utils.d.b("registerAction:", "Will static push_register event :");
        StatisticUtils.statisticEvent(this.mContext, "push_register");
        this.needStaticRegister = false;
    L18:
        this.mAuthCode = r101;
        this.mVerifyCode = r102;
        this.mICallBackResultService = r104;
        if (r103 != null) goto L27;
        r103 = new JSONObject();
    L27:
        r103.putOpt(DBDefinition.APP_VERSION_CODE, Integer.valueOf(Utils.getVersionCode(r100)));     // Catch: JSONException -> L23
        r103.putOpt("appVersionName", Utils.getVersionName(r100));     // Catch: JSONException -> L23
    L25:
        startMcsService(12289, r103);
        return;
    L23:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e("register-Exception:" + e.getMessage());
        goto L25
    }

    @Override // com.heytap.mcssdk.b
    public void requestNotificationAdvance(Activity r100, INotificationPermissionCallback r101, int r102) {
        if (r100 != null) goto L8;
        if (r101 == null) goto L35;
        r101.onFail(2000, null);
        return;
    L35:
        return;
    L8:
        if (checkCommandLimit(MessageConstant.CommandId.COMMAND_NOTIFICATION_ADVANCE) == false) goto L13;
        if (r101 == null) goto L36;
        r101.onFail(2004, null);
        return;
    L36:
        return;
    L13:
        if (checkTop(r100) == true) goto L18;
        if (r101 == null) goto L37;
        r101.onFail(2001, null);
        return;
    L37:
        return;
    L18:
        if (com_heytap_mcssdk_PushService_android_app_Activity_checkPermission(r100, "android.permission.POST_NOTIFICATIONS", Process.myPid(), Process.myUid()) != 0) goto L23;
        if (r101 == null) goto L38;
        r101.onFail(2002, null);
        return;
    L38:
        return;
    L23:
        if (this.mPermissionCallback.a(r101) == true) goto L27;
        if (r101 == null) goto L39;
        r101.onFail(2003, null);
        return;
    L39:
        return;
    L27:
        Intent r103 = new Intent();
        r103.setAction(ACTION_NOTIFICATION_ADVANCE);
        r103.setPackage(getMcsPackageName(r100));
        Bundle r104 = new Bundle();
        r104.putBinder(KEY_CALLBACK, this.mPermissionCallback);
        r103.putExtras(r104);
        r103.putExtra(com.heytap.mcssdk.constant.b.E, getUserId(this.mContext));
        r100.startActivityForResult(r103, r102);     // Catch: ActivityNotFoundException -> L30
        return;
    L30:
        if (r101 == null) goto L40;
        r101.onFail(2005, null);
        return;
    }

    @Override // com.heytap.mcssdk.b
    public void requestNotificationPermission() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 32) goto L7;
        com.heytap.mcssdk.utils.d.b(TAG, "requestNotificationPermission() will return due to Android T device , current device Android SDK version code is :" + r100);
        return;
    L7:
        if (checkContext() == false) goto L9;
        bindMcsService(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        return;
    L9:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.b
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.b
    public void resumePush(JSONObject r100) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_RESUME_PUSH, r100);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    public void setAppKeySecret(String r100, String r101) {
        this.mAuthCode = r100;
        this.mVerifyCode = r101;
    }

    @Override // com.heytap.mcssdk.b
    public void setNotificationType(int r100) {
        setNotificationType(r100, null);
    }

    @Override // com.heytap.mcssdk.b
    public void setNotificationType(int r100, JSONObject r101) {
        if (checkAll() == false) goto L5;
        startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, r100 + "", r101);
        return;
    L5:
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, "please call the register first!");
    }

    public void setPushCallback(ICallBackResultService r100) {
        this.mICallBackResultService = r100;
    }

    @Override // com.heytap.mcssdk.b
    public void setPushTime(List<Integer> r100, int r101, int r110, int r111, int r112) {
        setPushTime(r100, r101, r110, r111, r112, null);
    }

    @Override // com.heytap.mcssdk.b
    public void setPushTime(List<Integer> r100, int r101, int r102, int r103, int r104, JSONObject r105) {
        if (checkAll() == false) goto L22;
        if (r100 == null) goto L20;
        if (r100.size() <= 0) goto L20;
        if (r101 < 0) goto L20;
        if (r102 < 0) goto L20;
        if (r103 < r101) goto L20;
        if (r103 > 23) goto L20;
        if (r104 < r102) goto L20;
        if (r104 > 59) goto L20;
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L17
        r106.put("weekDays", com.heytap.mcssdk.c.b.a(r100));     // Catch: JSONException -> L17
        r106.put("startHour", r101);     // Catch: JSONException -> L17
        r106.put("startMin", r102);     // Catch: JSONException -> L17
        r106.put("endHour", r103);     // Catch: JSONException -> L17
        r106.put("endMin", r104);     // Catch: JSONException -> L17
        startMcsService(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, r106.toString(), r105);     // Catch: JSONException -> L17
        return;
    L17:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.f276415a, e.getLocalizedMessage());
        return;
    L20:
        throw new IllegalArgumentException("params are not all right,please check params");
    L22:
        if (getPushCallback() == null) goto L28;
        getPushCallback().onSetPushTime(-2, "please call the register first!");
        return;
    }

    @Override // com.heytap.mcssdk.b
    public void setRegisterID(String r100) {
        this.mRegisterID = r100;
    }

    @Override // com.heytap.mcssdk.b
    public void unRegister() {
        unRegister(null);
    }

    public void unRegister(Context r100, String r101, String r102, JSONObject r103, ICallBackResultService r104) {
        this.mAuthCode = r101;
        this.mVerifyCode = r102;
        this.mContext = r100.getApplicationContext();
        this.mICallBackResultService = r104;
        unRegister(r103);
    }

    @Override // com.heytap.mcssdk.b
    public void unRegister(JSONObject r100) {
        if (checkContext() == false) goto L6;
        startMcsService(12290, r100);
        return;
    L6:
        if (getPushCallback() == null) goto L10;
        String r101 = getMiniProgramPkgFromJSON(r100);
        getPushCallback().onUnRegister(-2, this.mContext.getPackageName(), r101);
        return;
    }

    private static int com_heytap_mcssdk_PushService_android_app_Activity_checkPermission(Activity r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_heytap_mcssdk_PushService_android_app_Activity_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/app/Activity", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
