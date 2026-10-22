package com.bytedance.mira.am;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.BinderProvider;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PluginActivityManager {
    private static String CONTENT_URI = null;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "PluginActivityManager";
    private static IPluginActivityManager sInstance;
    private static volatile boolean sIsConnected;
    private static final Object sLockObject = null;

    public PluginActivityManager() {
    }

    static {
        sLockObject = new Object();
    }

    private static IPluginActivityManager getInstance() {
        if (sIsConnected == true) goto L6;
        sInstance = null;
    L6:
        if (sInstance != null) goto L30;
        Object r100 = sLockObject;
        monitor-enter(r100);
        int r101 = 0;
    L31:
    L26:
        th = move-exception;
        throw th;
    L11:
        if (sInstance != null) goto L24;
        if (r101 <= 0) goto L23;
        if (r101 > 3) goto L15;
        Thread.sleep(200);     // Catch: InterruptedException -> L20 Throwable -> L26
    L22:
        MiraLogger.i(MiraLogger.TAG_PAM, "PluginActivityManager retry connect host process: " + r101);     // Catch: Throwable -> L26
        goto L23
    L20:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager connect host InterruptedException.", e);     // Catch: Throwable -> L26
        goto L22
    L15:
        MiraLogger.w(MiraLogger.TAG_PAM, "PluginActivityManager connect host process failed.");     // Catch: Throwable -> L26
    L23:
        sInstance = generatePluginActivityManager();     // Catch: Throwable -> L26
        r101 = r101 + 1;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r100);     // Catch: Throwable -> L26
    L30:
        return sInstance;
    }

    private static IPluginActivityManager generatePluginActivityManager() {
        if (TextUtils.isEmpty(CONTENT_URI) == false) goto L5;
        CONTENT_URI = String.format("content://%s.am.PAMP/call", new Object[]{Mira.getAppContext().getPackageName()});
    L5:
        IBinder r100 = BinderProvider.queryBinder(Mira.getAppContext(), UriProtector.parse(CONTENT_URI));
        if (r100 != null) goto L8;
        return null;
    L8:
        if (r100.isBinderAlive() == false) goto L18;
        r100.linkToDeath(new AnonymousClass1(), 0);     // Catch: RemoteException -> L11
        sIsConnected = true;     // Catch: RemoteException -> L11
        MiraLogger.i(MiraLogger.TAG_PAM, "PluginActivityManager generatePluginActivityManager success.");     // Catch: RemoteException -> L11
        return IPluginActivityManager.Stub.asInterface(r100);
    L11:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager generatePluginPackageManager failed.", e);
        return null;
    L18:
        return null;
    }

    public static /* synthetic */ boolean access$002(boolean r100) {
        sIsConnected = r100;
        return r100;
    }

    public static ServiceInfo getTargetService(ServiceInfo r100) {
        return getInstance().getTargetService(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager getTargetService failed.", e);
        return null;
    }

    public static boolean isStubActivity(ActivityInfo r100) {
        return getInstance().isStubActivity(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager isStubActivity failed.", e);
        return false;
    }

    public static boolean isStubProvider(ProviderInfo r100) {
        return getInstance().isStubProvider(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager isStubProvider failed.", e);
        return false;
    }

    public static boolean isStubReceiver(ActivityInfo r100) {
        return getInstance().isStubReceiver(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager isStubReceiver failed.", e);
        return false;
    }

    public static boolean isStubService(ServiceInfo r100) {
        return getInstance().isStubService(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager isStubService failed.", e);
        return false;
    }

    public static ActivityInfo selectStubActivity(ActivityInfo r100) {
        return getInstance().selectStubActivity(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager selectStubActivity failed.", e);
        return null;
    }

    public static ProviderInfo selectStubProvider(ProviderInfo r100) {
        return getInstance().selectStubProvider(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager selectStubProvider failed.", e);
        return null;
    }

    public static ActivityInfo selectStubReceiver(ActivityInfo r100) {
        return getInstance().selectStubReceiver(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager selectStubReceiver failed.", e);
        return null;
    }

    public static ServiceInfo selectStubService(ServiceInfo r100) {
        return getInstance().selectStubService(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager selectStubService failed.", e);
        return null;
    }

    public static void shareStubProcess(List<String> r100) {
        getInstance().shareStubProcess(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager shareStubProcess failed.", e);
    }

    public static void activityCreated(ActivityInfo r100, ActivityInfo r101) {
        getInstance().activityCreated(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager activityCreated failed.", e);
    }

    public static void activityDestroy(ActivityInfo r100, ActivityInfo r101) {
        getInstance().activityDestroy(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager activityDestroy failed.", e);
    }

    public static void receiverFinished(ActivityInfo r100, ActivityInfo r101) {
        getInstance().receiverFinished(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager receiverFinished failed.", e);
    }

    public static void runInStubProcess(String r100, String r101) {
        getInstance().runInStubProcess(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager runInStubProcess failed.", e);
    }

    public static void serviceCreated(ServiceInfo r100, ServiceInfo r101) {
        getInstance().serviceCreated(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager serviceCreated failed.", e);
    }

    public static void serviceDestroy(ServiceInfo r100, ServiceInfo r101) {
        getInstance().serviceDestroy(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager serviceDestroy failed.", e);
    }

    public static void activityOnNewIntent(ActivityInfo r100, ActivityInfo r101, Intent r102) {
        getInstance().activityOnNewIntent(r100, r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager activityOnNewIntent failed.", e);
    }

    public static void applicationCreated(ApplicationInfo r100, String r101, int r102, IApplicationThread r103) {
        getInstance().applicationCreated(r100, r101, r102, r103);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManager applicationCreated failed.", e);
    }
}
