package com.bytedance.mira.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.BinderProvider;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.util.FixMultiUserUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginPackageManager {
    private static String CONTENT_URI = null;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "PluginPackageManager";
    private static IPluginPackageManager sInstance;
    private static volatile boolean sIsConnected;

    public PluginPackageManager() {
    }

    private static IPluginPackageManager generatePluginPackageManager() {
        if (TextUtils.isEmpty(CONTENT_URI) == false) goto L5;
        CONTENT_URI = String.format("content://%s.pm.PPMP/call", new Object[]{Mira.getAppContext().getPackageName()});
    L5:
        IBinder r1 = BinderProvider.queryBinder(Mira.getAppContext(), UriProtector.parse(CONTENT_URI));
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.isBinderAlive() == false) goto L18;
        r1.linkToDeath(new AnonymousClass1(), 0);     // Catch: RemoteException -> L11
        sIsConnected = true;     // Catch: RemoteException -> L11
        MiraLogger.i(MiraLogger.TAG_PPM, "PluginPackageManager generatePluginPackageManager success.");     // Catch: RemoteException -> L11
        return IPluginPackageManager.Stub.asInterface(r1);
    L11:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager generatePluginPackageManager failed.", e);
        return null;
    L18:
        return null;
    }

    private static IPluginPackageManager getInstance() {
        if (sIsConnected == true) goto L6;
        sInstance = null;
    L6:
        if (sInstance != null) goto L30;
        monitor-enter(PluginPackageManager.class);
        int r1 = 0;
    L33:
    L26:
        th = move-exception;
        throw th;
    L11:
        if (sInstance != null) goto L24;
        if (r1 <= 0) goto L23;
        if (r1 > 3) goto L15;
        Thread.sleep(200);     // Catch: InterruptedException -> L20 Throwable -> L26
    L22:
        MiraLogger.i(MiraLogger.TAG_PPM, "PluginPackageManager retry connect host process: " + r1);     // Catch: Throwable -> L26
        goto L23
    L20:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager connect host InterruptedException.", e);     // Catch: Throwable -> L26
        goto L22
    L15:
        MiraLogger.w(MiraLogger.TAG_PPM, "PluginPackageManager connect host process failed.");     // Catch: Throwable -> L26
    L23:
        sInstance = generatePluginPackageManager();     // Catch: Throwable -> L26
        r1 = r1 + 1;     // Catch: Throwable -> L26
    L24:
        monitor-exit(PluginPackageManager.class);     // Catch: Throwable -> L26
    L30:
        return sInstance;
    }

    public static List<String> getExistedPluginPackageNames() {
        return getInstance().getExistedPluginPackageNames();
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getExistedPluginPackageNames failed.", e);
        return new ArrayList();
    }

    public static List<String> getInstalledPackageNames() {
        return getInstance().getInstalledPackageNames();
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getInstalledPackageNames failed.", e);
        return null;
    }

    public static List<Plugin> getPluginList() {
        return getInstance().getPluginList();
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPluginList failed.", e);
        return null;
    }

    public static /* synthetic */ boolean access$002(boolean r0) {
        sIsConnected = r0;
        return r0;
    }

    public static boolean checkPluginInstalled(String r2) {
        return getInstance().checkPluginInstalled(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager checkPluginInstalled failed.", e);
        return false;
    }

    public static String generateContextPackageName(String r3) {
        return getInstance().generateContextPackageName(r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager generateContextPackageName failed.", e);
        return r3;
    }

    public static int getInstalledPluginVersion(String r2) {
        return getInstance().getInstalledPluginVersion(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getInstalledPluginVersion failed.", e);
        return -1;
    }

    public static Plugin getPlugin(String r2) {
        return getInstance().getPlugin(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPlugin failed.", e);
        return null;
    }

    public static int getPluginStatus(String r2) {
        return getInstance().getPluginStatus(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPluginStatus failed.", e);
        return 0;
    }

    public static boolean isPluginPackage(String r2) {
        return getInstance().isPluginPackage(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager isPluginPackage failed.", e);
        return false;
    }

    public static boolean resolve(Plugin r2) {
        return getInstance().resolve(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolve failed.", e);
        return false;
    }

    public static boolean shareResources(String r2) {
        return getInstance().shareResources(r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager shareResources failed.", e);
        return false;
    }

    public static int deletePackage(String r1, int r2) {
        return getInstance().deletePackage(r1, r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager deletePackage failed.", e);
        return 0;
    }

    public static ActivityInfo getActivityInfo(ComponentName r2, int r3) {
        ActivityInfo r4 = getInstance().getActivityInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        if (isPluginPackage(r2.getPackageName()) == false) goto L14;
        ActivityInfo r5 = new ActivityInfo();
        r5.packageName = r2.getPackageName();
        return r5;
    L14:
        return r4;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getActivityInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static ApplicationInfo getApplicationInfo(String r2, int r3) {
        ApplicationInfo r4 = getInstance().getApplicationInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 != null) goto L11;
        if (isPluginPackage(r2) == false) goto L11;
        r4 = new ApplicationInfo();
        r4.packageName = r2;
    L11:
        return FixMultiUserUtils.fix(r4);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getApplicationInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static PackageInfo getPackageInfo(String r2, int r3) {
        PackageInfo r4 = getInstance().getPackageInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 != null) goto L11;
        if (isPluginPackage(r2) == false) goto L11;
        r4 = new PackageInfo();
        r4.packageName = r2;
    L11:
        return FixMultiUserUtils.fix(r4);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPackageInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static ProviderInfo getProviderInfo(ComponentName r2, int r3) {
        ProviderInfo r4 = getInstance().getProviderInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        if (isPluginPackage(r2.getPackageName()) == false) goto L14;
        ProviderInfo r5 = new ProviderInfo();
        r5.packageName = r2.getPackageName();
        return r5;
    L14:
        return r4;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getProviderInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static ActivityInfo getReceiverInfo(ComponentName r2, int r3) {
        ActivityInfo r4 = getInstance().getReceiverInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        if (isPluginPackage(r2.getPackageName()) == false) goto L14;
        ActivityInfo r5 = new ActivityInfo();
        r5.packageName = r2.getPackageName();
        return r5;
    L14:
        return r4;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getReceiverInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static List<ReceiverInfo> getReceivers(String r1, int r2) {
        return getInstance().getReceivers(r1, r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getReceivers failed.", e);
        return Collections.emptyList();
    }

    public static ServiceInfo getServiceInfo(ComponentName r2, int r3) {
        ServiceInfo r4 = getInstance().getServiceInfo(r2, r3);     // Catch: Exception -> L4
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        if (isPluginPackage(r2.getPackageName()) == false) goto L14;
        ServiceInfo r5 = new ServiceInfo();
        r5.packageName = r2.getPackageName();
        return r5;
    L14:
        return r4;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getServiceInfo failed.", e);
        r4 = null;
        goto L6
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r2, int r3) {
        return getInstance().queryIntentActivities(r2, r2.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager queryIntentActivities failed.", e);
        return null;
    }

    public static List<ResolveInfo> queryIntentServices(Intent r2, int r3) {
        return getInstance().queryIntentServices(r2, r2.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager queryIntentServices failed.", e);
        return null;
    }

    public static ProviderInfo resolveContentProvider(String r1, int r2) {
        return getInstance().resolveContentProvider(r1, r2);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveContentProvider failed.", e);
        return null;
    }

    public static ResolveInfo resolveIntent(Intent r2, int r3) {
        return getInstance().resolveIntent(r2, r2.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveIntent failed.", e);
        return null;
    }

    public static ResolveInfo resolveService(Intent r2, int r3) {
        return getInstance().resolveService(r2, r2.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveService failed.", e);
        return null;
    }

    public static List<ProviderInfo> getProviders(String r1, String r2, int r3) {
        return getInstance().getProviders(r1, r2, r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getProviders failed.", e);
        return null;
    }

    public static int installPackage(String r1, boolean r2, int r3) {
        return getInstance().installPackage(r1, r2, r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installPackage failed.", e);
        return 0;
    }

    public static boolean syncInstallPackage(String r1, boolean r2, int r3) {
        return getInstance().syncInstallPackage(r1, r2, r3);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installPackage failed.", e);
        return false;
    }

    public static int installCompatPackage(String r6, String r7, String r8, boolean r9, int r10) {
        return getInstance().installCompatPackage(r6, r7, r8, r9, r10);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installCompatPackage failed.", e);
        return 0;
    }

    public static boolean syncInstallCompatPackage(String r6, String r7, String r8, boolean r9, int r10) {
        return getInstance().syncInstallCompatPackage(r6, r7, r8, r9, r10);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installCompatPackage failed.", e);
        return false;
    }
}
