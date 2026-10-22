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

/* JADX INFO: loaded from: classes.dex */
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
        IBinder r100 = BinderProvider.queryBinder(Mira.getAppContext(), UriProtector.parse(CONTENT_URI));
        if (r100 != null) goto L8;
        return null;
    L8:
        if (r100.isBinderAlive() == false) goto L18;
        r100.linkToDeath(new AnonymousClass1(), 0);     // Catch: RemoteException -> L11
        sIsConnected = true;     // Catch: RemoteException -> L11
        MiraLogger.i(MiraLogger.TAG_PPM, "PluginPackageManager generatePluginPackageManager success.");     // Catch: RemoteException -> L11
        return IPluginPackageManager.Stub.asInterface(r100);
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
        int r100 = 0;
    L33:
    L26:
        th = move-exception;
        throw th;
    L11:
        if (sInstance != null) goto L24;
        if (r100 <= 0) goto L23;
        if (r100 > 3) goto L15;
        Thread.sleep(200);     // Catch: InterruptedException -> L20 Throwable -> L26
    L22:
        MiraLogger.i(MiraLogger.TAG_PPM, "PluginPackageManager retry connect host process: " + r100);     // Catch: Throwable -> L26
        goto L23
    L20:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager connect host InterruptedException.", e);     // Catch: Throwable -> L26
        goto L22
    L15:
        MiraLogger.w(MiraLogger.TAG_PPM, "PluginPackageManager connect host process failed.");     // Catch: Throwable -> L26
    L23:
        sInstance = generatePluginPackageManager();     // Catch: Throwable -> L26
        r100 = r100 + 1;     // Catch: Throwable -> L26
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

    public static /* synthetic */ boolean access$002(boolean r100) {
        sIsConnected = r100;
        return r100;
    }

    public static boolean checkPluginInstalled(String r100) {
        return getInstance().checkPluginInstalled(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager checkPluginInstalled failed.", e);
        return false;
    }

    public static String generateContextPackageName(String r100) {
        return getInstance().generateContextPackageName(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager generateContextPackageName failed.", e);
        return r100;
    }

    public static int getInstalledPluginVersion(String r100) {
        return getInstance().getInstalledPluginVersion(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getInstalledPluginVersion failed.", e);
        return -1;
    }

    public static Plugin getPlugin(String r100) {
        return getInstance().getPlugin(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPlugin failed.", e);
        return null;
    }

    public static int getPluginStatus(String r100) {
        return getInstance().getPluginStatus(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPluginStatus failed.", e);
        return 0;
    }

    public static boolean isPluginPackage(String r100) {
        return getInstance().isPluginPackage(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager isPluginPackage failed.", e);
        return false;
    }

    public static boolean resolve(Plugin r100) {
        return getInstance().resolve(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolve failed.", e);
        return false;
    }

    public static boolean shareResources(String r100) {
        return getInstance().shareResources(r100);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager shareResources failed.", e);
        return false;
    }

    public static int deletePackage(String r100, int r101) {
        return getInstance().deletePackage(r100, r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager deletePackage failed.", e);
        return 0;
    }

    public static ActivityInfo getActivityInfo(ComponentName r100, int r101) {
        ActivityInfo r102 = getInstance().getActivityInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        if (isPluginPackage(r100.getPackageName()) == false) goto L14;
        ActivityInfo r103 = new ActivityInfo();
        r103.packageName = r100.getPackageName();
        return r103;
    L14:
        return r102;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getActivityInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static ApplicationInfo getApplicationInfo(String r100, int r101) {
        ApplicationInfo r102 = getInstance().getApplicationInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 != null) goto L11;
        if (isPluginPackage(r100) == false) goto L11;
        r102 = new ApplicationInfo();
        r102.packageName = r100;
    L11:
        return FixMultiUserUtils.fix(r102);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getApplicationInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static PackageInfo getPackageInfo(String r100, int r101) {
        PackageInfo r102 = getInstance().getPackageInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 != null) goto L11;
        if (isPluginPackage(r100) == false) goto L11;
        r102 = new PackageInfo();
        r102.packageName = r100;
    L11:
        return FixMultiUserUtils.fix(r102);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getPackageInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static ProviderInfo getProviderInfo(ComponentName r100, int r101) {
        ProviderInfo r102 = getInstance().getProviderInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        if (isPluginPackage(r100.getPackageName()) == false) goto L14;
        ProviderInfo r103 = new ProviderInfo();
        r103.packageName = r100.getPackageName();
        return r103;
    L14:
        return r102;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getProviderInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static ActivityInfo getReceiverInfo(ComponentName r100, int r101) {
        ActivityInfo r102 = getInstance().getReceiverInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        if (isPluginPackage(r100.getPackageName()) == false) goto L14;
        ActivityInfo r103 = new ActivityInfo();
        r103.packageName = r100.getPackageName();
        return r103;
    L14:
        return r102;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getReceiverInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static List<ReceiverInfo> getReceivers(String r100, int r101) {
        return getInstance().getReceivers(r100, r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getReceivers failed.", e);
        return Collections.emptyList();
    }

    public static ServiceInfo getServiceInfo(ComponentName r100, int r101) {
        ServiceInfo r102 = getInstance().getServiceInfo(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        if (isPluginPackage(r100.getPackageName()) == false) goto L14;
        ServiceInfo r103 = new ServiceInfo();
        r103.packageName = r100.getPackageName();
        return r103;
    L14:
        return r102;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getServiceInfo failed.", e);
        r102 = null;
        goto L6
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r100, int r101) {
        return getInstance().queryIntentActivities(r100, r100.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager queryIntentActivities failed.", e);
        return null;
    }

    public static List<ResolveInfo> queryIntentServices(Intent r100, int r101) {
        return getInstance().queryIntentServices(r100, r100.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager queryIntentServices failed.", e);
        return null;
    }

    public static ProviderInfo resolveContentProvider(String r100, int r101) {
        return getInstance().resolveContentProvider(r100, r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveContentProvider failed.", e);
        return null;
    }

    public static ResolveInfo resolveIntent(Intent r100, int r101) {
        return getInstance().resolveIntent(r100, r100.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveIntent failed.", e);
        return null;
    }

    public static ResolveInfo resolveService(Intent r100, int r101) {
        return getInstance().resolveService(r100, r100.resolveTypeIfNeeded(Mira.getAppContext().getContentResolver()), r101);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager resolveService failed.", e);
        return null;
    }

    public static List<ProviderInfo> getProviders(String r100, String r101, int r102) {
        return getInstance().getProviders(r100, r101, r102);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager getProviders failed.", e);
        return null;
    }

    public static int installPackage(String r100, boolean r101, int r102) {
        return getInstance().installPackage(r100, r101, r102);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installPackage failed.", e);
        return 0;
    }

    public static boolean syncInstallPackage(String r100, boolean r101, int r102) {
        return getInstance().syncInstallPackage(r100, r101, r102);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installPackage failed.", e);
        return false;
    }

    public static int installCompatPackage(String r100, String r101, String r102, boolean r103, int r110) {
        return getInstance().installCompatPackage(r100, r101, r102, r103, r110);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installCompatPackage failed.", e);
        return 0;
    }

    public static boolean syncInstallCompatPackage(String r100, String r101, String r102, boolean r103, int r110) {
        return getInstance().syncInstallCompatPackage(r100, r101, r102, r103, r110);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PPM, "PluginPackageManager installCompatPackage failed.", e);
        return false;
    }
}
