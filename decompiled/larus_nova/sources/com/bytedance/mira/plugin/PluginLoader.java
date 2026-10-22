package com.bytedance.mira.plugin;

import android.R;
import android.app.Application;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.MiraPluginBeforeLoadListener;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.core.PluginClassLoader;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.factory.ClassLoaderFactory;
import com.bytedance.mira.factory.MakeApplicationFactory;
import com.bytedance.mira.factory.NativeClassLoaderManager;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.helper.ContextImplHelper;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.hook.MiraHookManager;
import com.bytedance.mira.log.JobWatcher;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.multidex.PluginMultiDexCompat;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.trip.opt.Turbo;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mira.pm.ReceiverInfo;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dalvik.system.BaseDexClassLoader;
import el9.a;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class PluginLoader {
    private static final String TAG = "PluginLoader";
    public static Map<String, PluginClassLoader> sCachedPluginClassLoader;
    private static Object sInstance;
    private static final Handler sMainHandler = null;
    private Handler mHandler;

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Class access$002(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
        sCachedPluginClassLoader = new ConcurrentHashMap(1);
    }

    private static boolean checkEnableTurboClassDef() {
        MiraParam r100 = MiraManager.getInstance().getParam();
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.isEnableClassDefOpt() == false) goto L9;
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L9;
        return true;
    }

    private static boolean checkEnableTurboCrc32() {
        MiraParam r100 = MiraManager.getInstance().getParam();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEnableOptCrc32() == false) goto L7;
        return true;
    }

    private static void restoreApplicationConfig() {
        if (OSUtil.isAndroidRHigher() == true) goto L8;
        return;
    L8:
        Field r100 = DoubleReflector.getField(INVOKESTATIC_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.security.net.config.ApplicationConfig"), "sInstance");     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
        r100.set(null, sInstance);     // Catch: Exception -> L7
        return;
    }

    private static void saveApplicationConfig() {
        if (OSUtil.isAndroidRHigher() == true) goto L8;
        return;
    L8:
        Field r100 = DoubleReflector.getField(INVOKESTATIC_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.security.net.config.ApplicationConfig"), "sInstance");     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
        sInstance = r100.get(null);     // Catch: Exception -> L7
        r100.set(null, null);     // Catch: Exception -> L7
        return;
    }

    public PluginLoader(Handler r100) {
        this.mHandler = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$002(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$002(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static Resources addHostResources(ApplicationInfo r100) {
        final Resources r101 = MiraResourcesManager.getInstance().addPluginPath(r100.sourceDir, r100.packageName);
        if (OSUtil.isAndroidMHigher() == false) goto L5;
        Mira.getAppContext().registerComponentCallbacks(new AnonymousClass3(r101));
    L5:
        return r101;
    }

    public static String getPackageName(PluginClassLoader r100) {
        if (sCachedPluginClassLoader.containsValue(r100) == false) goto L11;
        Iterator<Map.Entry<String, PluginClassLoader>> r101 = sCachedPluginClassLoader.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<String, PluginClassLoader> r102 = r101.next();
        if (r102.getValue() != r100) goto L6;
        return r102.getKey();
    L16:
        return null;
    L11:
        return null;
    }

    public static PluginClassLoader getPluginClassLoader(String r100) {
        return sCachedPluginClassLoader.get(r100);
    }

    private static void realOldMakeApplication(Object r100) throws Exception {
        MethodUtils.invokeMethod(r100, "makeApplication", new Object[]{Boolean.FALSE, null}, new Class[]{Boolean.TYPE, Instrumentation.class});
    }

    private static void registerReceivers(ApplicationInfo r110) {
        List<ReceiverInfo> r100 = PluginPackageManager.getReceivers(r110.packageName, 0);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L44;
        PluginClassLoader r101 = sCachedPluginClassLoader.get(r110.packageName);
        PackageManager r102 = Mira.getAppContext().getPackageManager();
        Iterator<ReceiverInfo> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L45;
        ReceiverInfo r104 = r103.next();
        String r105 = Mira.getAppContext().getPackageName();
        Intent r106 = new Intent();
        r106.setComponent(new ComponentName(r105, r104.name));
        List<ResolveInfo> r107 = r102.queryBroadcastReceivers(r106, R.attr.theme);
        if (r107 != null) goto L12;
    L30:
        BroadcastReceiver r108 = (BroadcastReceiver) INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, r104.name).newInstance();     // Catch: Exception -> L27
        Iterator<IntentFilter> r109 = r104.intentFilters.iterator();     // Catch: Exception -> L27
    L16:
        if (r109.hasNext() == false) goto L25;
        IntentFilter r111 = r109.next();     // Catch: Exception -> L27
        if (OSUtil.isAndroidUHigher() == true) goto L20;
        INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Mira.getAppContext(), r108, r111);     // Catch: Exception -> L27
        goto L16
    L20:
        if (r104.exported == false) goto L22;
        int r112 = 2;
    L23:
        INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Mira.getAppContext(), r108, r111, r112);     // Catch: Exception -> L27
        goto L16
    L22:
        r112 = 4;
        goto L23
    L25:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader registerReceivers, " + r108 + ", " + r110.packageName);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader registerReceivers failed, " + r104.name + "pkg = " + r110.packageName, e);
        goto L8
    L12:
        if (r107.size() <= 0) goto L30;
    L45:
        return;
    }

    private static void takeTurboCrc32(Plugin r100) {
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader takeTurboCrc32, " + r100.mPackageName + "-" + r100.mVersionCode + ", result=" + Turbo.optZipExtraCrc32());
    }

    private static void tryInjectPluginSplitPathFromHost(Object r100) {
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.enableSameToHostSplitPath() == false) goto L15;
        Field r102 = FieldUtils.getField(r100.getClass(), "mSplitResDirs");     // Catch: Exception -> L9
        Object r103 = r102.get(ActivityThreadHelper.getCachedLoadedApk(Mira.getAppContext().getPackageName()));     // Catch: Exception -> L9
        r102.set(r100, r103);     // Catch: Exception -> L9
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp tryInjectPluginSplitPathFromHost success, path=" + r103);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp tryInjectPluginSplitPathFromHost fail, err.", e);
        return;
    }

    private void waitInstallIfNeed(Plugin r100) {
        if (r100.isInstalling() == false) goto L30;
    L23:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader waitInstallIfNeed failed, pkg = " + r100.mPackageName, th);
        return;
    L5:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L7;
        long r101 = 300000;
    L11:
        Object r102 = r100.waitLock;     // Catch: Throwable -> L23
        monitor-enter(r102);     // Catch: Throwable -> L23
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader waitInstallIfNeed, pkg = " + r100.mPackageName + ", time = " + r101);     // Catch: Throwable -> L20
        if (r100.isInstalling() == true) goto L16;
    L18:
        monitor-exit(r102);     // Catch: Throwable -> L20
    L31:
        return;
    L16:
        if (r100.installingCount.get() <= 0) goto L18;
        r100.waitLock.wait(r101);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L7:
        if (MiraManager.getInstance().isAppOnCreatedEnd() == false) goto L9;
        r101 = 3000;
        goto L11
    L9:
        r101 = MiraManager.getInstance().getParam().getLoadPluginWaitTimeOut();     // Catch: Throwable -> L23
        goto L11
    }

    public boolean loadPlugin(String r100) {
        return loadPlugin(r100, null);
    }

    public void loadPluginsByClassName(String r110) {
        Iterator<Plugin> r100 = PluginManager.getInstance().listPlugins().iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        Plugin r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.mLifeCycle == 8) goto L4;
        String r102 = r101.mPackageName;
        if (r110.startsWith(r102 + ".") == true) goto L12;
        Iterator<String> r103 = r101.mExtraPackages.iterator();
    L15:
        if (r103.hasNext() == false) goto L4;
        String r104 = r103.next();
        if (r110.startsWith(r104 + ".") == false) goto L15;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadPluginsByClassName, class = " + r110 + ", pluginExtraPackage + " + r104);
        loadPlugin(r102);
        goto L15
    L12:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadPluginsByClassName, class = " + r110 + ", pluginPkg + " + r101.mPackageName);
        loadPlugin(r102);
        goto L4
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private static void clearApplicationsCache(Object r100, ApplicationInfo r101) {
        if (OSUtil.isAndroidTHigher() == false) goto L25;
        if (r100 == null) goto L26;
        Object r102 = FieldUtils.readField(r100, "sApplications");     // Catch: Exception -> L19
        if (r102 != null) goto L9;
        return;
    L9:
        monitor-enter(r102);     // Catch: Exception -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L11:
        if ((r102 instanceof ArrayMap) == false) goto L13;
        ((ArrayMap) r102).clear();     // Catch: Throwable -> L16
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L16
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader clearApplicationsCache success, pkg = " + r101.packageName + " >>> " + r102);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader clearApplicationsCache fail, pkg = " + r101.packageName, e);
        return;
    L26:
        return;
    }

    public static synchronized boolean launchPluginApp(String r210, ComponentInfo r211) {
        monitor-enter(PluginLoader.class);
    L115:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r210) == true) goto L112;
        if (PluginManager.getInstance().isPluginPackage(r210) == false) goto L112;
        Plugin r100 = PluginManager.getInstance().getPlugin(r210);     // Catch: Throwable -> L115
        if (r100 != null) goto L16;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, plugin[" + r210 + "] not exist !!!");     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L16:
        if (r100.isInstalled() == true) goto L21;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, plugin[" + r210 + "] not installed !!!");     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L21:
        if (r100.isResolved() == true) goto L24;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, resolve plugin apk[" + PluginPackageManager.resolve(r100) + "] " + r210);     // Catch: Throwable -> L115
    L24:
        final ApplicationInfo r101 = PluginPackageManager.getApplicationInfo(r210, 0);     // Catch: Throwable -> L115
        if (r101 != null) goto L27;
    L108:
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, pluginAppInfo empty, " + r101);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L27:
        if (TextUtils.isEmpty(r101.className) == true) goto L108;
        if (TextUtils.isEmpty(r101.className) == false) goto L34;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, pluginAppInfo.className empty, " + r101);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L34:
        Map r102 = ActivityThreadHelper.getCachedLoadedApkMap();     // Catch: Throwable -> L115
        if (r102 != null) goto L40;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, get ActivityThread.mPackages failed, " + r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L40:
        if (r102.get(r101.packageName) == null) goto L44;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, already launched, " + r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return true;
    L44:
        final Object r103 = ActivityThreadHelper.createLoadedApk(r101);     // Catch: Throwable -> L115
        if (r103 != null) goto L50;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, loadedApk is null, " + r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L50:
        if (TextUtils.isEmpty(r101.sourceDir) == false) goto L56;
        String r104 = PluginDirHelper.getSourceFile(r101.packageName, PluginPackageManager.getInstalledPluginVersion(r101.packageName));     // Catch: Throwable -> L115
        r101.sourceDir = r104;     // Catch: Throwable -> L115
        if (TextUtils.isEmpty(r104) == false) goto L56;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, pluginAppInfo.sourceDir is empty, " + r101.packageName);     // Catch: Throwable -> L115
        ActivityThreadHelper.removePluginLoadedApk(r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L56:
        final String r105 = PluginPackageManager.generateContextPackageName(r101.packageName);     // Catch: Throwable -> L115
        PolarisFileWrapper r110 = new PolarisFileWrapper(PluginDirHelper.getDalvikCacheDir(r100.mPackageName, r100.mVersionCode));     // Catch: Throwable -> L115
        if (r110.exists() == true) goto L59;
        r110.mkdirs();     // Catch: Throwable -> L115
    L59:
        PluginClassLoader r106 = createPluginClassLoader(r100, r101, r110);     // Catch: Throwable -> L115
        if (r106 != null) goto L64;
        ActivityThreadHelper.removePluginLoadedApk(r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L64:
        MiraParam r111 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L115
        Resources r112 = null;
        if (r111 != null) goto L67;
    L77:
        if (r111 == null) goto L81;
        if (r111.shareRes() == true) goto L81;
    L84:
        boolean r107 = false;
    L118:
        FieldUtils.writeField(r103, NativeDownloadModel.JsonKey.PACKAGE_NAME, r105);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp hook replace loadedApk.mPackageName=hostPkgName, " + r101.packageName);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        FieldUtils.writeField(r103, "mClassLoader", Mira.getAppContext().getClassLoader());     // Catch: IllegalAccessException -> L105 Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp hook replace loadedApk.mClassLoader=hostClassLoader, " + r101.packageName);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        if (r111 != null) goto L88;
    L91:
        if (r107 == false) goto L93;
        NewMiraResourcesManager.getInstance().addStrongRef(r101.packageName, r103);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        NewMiraResourcesManager.getInstance().installLoadedApk(r103);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp hook replace loadedApk with new Method," + r101.packageName);     // Catch: IllegalAccessException -> L105 Throwable -> L115
    L93:
        sCachedPluginClassLoader.put(r101.packageName, r106);     // Catch: Throwable -> L115
        ThreadMethodProxy.currentThread().setContextClassLoader(r106);     // Catch: Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp set currentThread ContextClassLoader, " + r101.packageName);     // Catch: Throwable -> L115
        if (r211 == null) goto L96;
        ProcessHelper.setProcessName(r211.processName);     // Catch: Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp Process.setArgV0(" + r211.processName + "), " + r101.packageName);     // Catch: Throwable -> L115
    L96:
        if (r211 == null) goto L98;
        final String r108 = r211.processName;     // Catch: Throwable -> L115
    L99:
        installContentProviders(Mira.getAppContext(), r101.packageName, r108);     // Catch: Throwable -> L115
        registerDexFile(r101.packageName, r106);     // Catch: Throwable -> L115
        if (Looper.myLooper() != Looper.getMainLooper()) goto L102;
        makeApplication(r103, r108, r105, r101);     // Catch: Throwable -> L115
    L103:
        monitor-exit(PluginLoader.class);
        return true;
    L102:
        sMainHandler.post(new AnonymousClass2(r103, r108, r105, r101));     // Catch: Throwable -> L115
        goto L103
    L98:
        r108 = r101.processName;     // Catch: Throwable -> L115
        goto L99
    L88:
        if (r111.enableOptResourcesArch() == true) goto L91;
        if (r112 == null) goto L93;
        FieldUtils.writeField(r103, "mResources", r112);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        tryInjectPluginSplitPathFromHost(r103);     // Catch: IllegalAccessException -> L105 Throwable -> L115
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp hook replace loadedApk.mResources=" + r112 + ", " + r101.packageName);     // Catch: IllegalAccessException -> L105 Throwable -> L115
    L105:
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, hook replace loadedApk failed, " + r101.packageName);     // Catch: Throwable -> L115
        ActivityThreadHelper.removePluginLoadedApk(r101.packageName);     // Catch: Throwable -> L115
        return false;
    L81:
        if (PluginPackageManager.shareResources(r101.packageName) == false) goto L84;
        NewMiraResourcesManager.getInstance().addAssetPath(r101.packageName, r101.sourceDir);     // Catch: Throwable -> L115
        r107 = true;
        goto L118
    L67:
        if (r111.enableOptResourcesArch() == true) goto L77;
        if (r111.shareRes() == false) goto L84;
        if (PluginPackageManager.shareResources(r101.packageName) == false) goto L84;
        r112 = addHostResources(r101);     // Catch: Throwable -> L115
        if (r112 != null) goto L84;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, addHostResources failed, " + r101.packageName);     // Catch: Throwable -> L115
        ActivityThreadHelper.removePluginLoadedApk(r101.packageName);     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    L112:
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader launchPluginApp, pkgName[" + r210 + "] must be valid !!!");     // Catch: Throwable -> L115
        monitor-exit(PluginLoader.class);
        return false;
    }

    private void modifyStatusFromMainProcess(Plugin r100, String r101) {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L5;
        return;
    L5:
        if (r100.isUninstalled() == false) goto L17;
        Plugin r102 = PluginPackageManager.getPlugin(r101);
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isInstalled() == true) goto L11;
        return;
    L11:
        if (r102.isResolved() == false) goto L13;
        int r103 = 7;
    L14:
        r100.mLifeCycle = r103;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader modifyStatusFromMainProcess, RESOLVED, pkg = " + r101);
        return;
    L13:
        r103 = 4;
        goto L14
    }

    private static void realMakeApplication(Object r100, ApplicationInfo r101) throws Exception {
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoaderused new func ==> loadedApk.makeApplication(false, null), " + r101.packageName);
        realNewMakeApplication(r100, r101);
        return;
    L11:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoaderused old func ==> loadedApk.makeApplication(false, null), " + r101.packageName);
        realOldMakeApplication(r100);
        return;
    L5:
        if (r102.enableOptMakeApplication() == false) goto L7;
        r103 = true;
        goto L9
    }

    private static void realNewMakeApplication(Object r100, ApplicationInfo r101) throws Exception {
        MakeApplicationFactory.makeApplication(r100, r101);
    }

    private static void registerDexFile(String r100, ClassLoader r101) {
        INVOKESTATIC_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100 + ".R", true, r101);     // Catch: Throwable -> L5
        StringBuilder r102 = new StringBuilder("PluginLoader registerDexFile Success, ");     // Catch: Throwable -> L5
        r102.append(r100);     // Catch: Throwable -> L5
        MiraLogger.i(MiraLogger.TAG_LOAD, r102.toString());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader registerDexFile Fail, " + r100, th);
    }

    private static void takeTurboClassDef(PluginClassLoader r100, Plugin r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader takeTurboClassDef, " + r101.mPackageName + "-" + r101.mVersionCode + ", result=" + Turbo.optClassDef((BaseDexClassLoader) r100.getInnerClassloader(), PluginDirHelper.getClassDefCacheDir(r101.mPackageName, r101.mVersionCode)));
    }

    public boolean loadPlugin(String r110, ComponentInfo r111) {
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, pkg = " + r110);
        if (NativeClassLoaderManager.enableMiraInit() == true) goto L6;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, mira not init, pkg = " + r110);
        return false;
    L6:
        final Plugin r100 = PluginManager.getInstance().getPlugin(r110);
        if (r100 != null) goto L10;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = " + r110);
        return false;
    L10:
        modifyStatusFromMainProcess(r100, r110);
        if (r100.isActive() == false) goto L14;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, ACTIVE, " + r110);
        return true;
    L14:
        waitInstallIfNeed(r100);
        if (r100.isUninstalled() == false) goto L19;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, " + r110);
        return false;
    L19:
        if (r100.isActive() == false) goto L22;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, ACTIVE, " + r110);
        return true;
    L22:
        monitor-enter(r100);
    L55:
        th = move-exception;
        throw th;
    L24:
        if (r100.isActive() == false) goto L28;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader loadPlugin, ACTIVE, " + r110);     // Catch: Throwable -> L55
        monitor-exit(r100);     // Catch: Throwable -> L55
        return true;
    L28:
        List<MiraPluginBeforeLoadListener> r101 = MiraManager.getInstance().getPluginEventBeforeLoadListeners();     // Catch: Throwable -> L55
        if (r101 != null) goto L31;
    L36:
        JobWatcher r102 = JobWatcher.start(MiraLogger.TAG_LOAD, TAG, "loadPlugin:" + r110);     // Catch: Throwable -> L55
        PluginEventManager.getInstance().notifyPluginEvent(30000, r100.mPackageName, r100.mVersionCode, System.currentTimeMillis());     // Catch: Throwable -> L55
        if (r100.isUnresolved() == false) goto L44;
        r100.mLifeCycle = 5;     // Catch: Throwable -> L55
        boolean r103 = PluginPackageManager.resolve(r100);     // Catch: Throwable -> L55
        if (r103 == false) goto L41;
        r100.mLifeCycle = 7;     // Catch: Throwable -> L55
    L42:
        r102.record("resolve:" + r103);     // Catch: Throwable -> L55
        goto L44
    L41:
        r100.mLifeCycle = 6;     // Catch: Throwable -> L55
        RuntimeException r112 = new RuntimeException("plugin:" + r100.mPackageName + " versionCode:" + r100.mVersionCode + "resolve failed.");     // Catch: Throwable -> L55
        r112.setStackTrace(ThreadMethodProxy.currentThread().getStackTrace());     // Catch: Throwable -> L55
        PluginEventManager.getInstance().notifyPluginErrorEvent(32001, r100.mPackageName, r100.mVersionCode, r112, System.currentTimeMillis());     // Catch: Throwable -> L55
    L44:
        if (r100.isResolvedExactly() == false) goto L49;
        boolean r113 = launchPluginApp(r110, r111);     // Catch: Throwable -> L55
        r102.finish("launchPluginApp:" + r113);     // Catch: Throwable -> L55
        if (r113 == false) goto L48;
        PluginEventManager.getInstance().notifyPluginSuccessEvent(31000, r100.mPackageName, r100.mVersionCode, r102.getDuration(), System.currentTimeMillis());     // Catch: Throwable -> L55
        r100.mLifeCycle = 8;     // Catch: Throwable -> L55
        goto L49
    L48:
        RuntimeException r104 = new RuntimeException("plugin:" + r100.mPackageName + " versionCode:" + r100.mVersionCode + "load failed.");     // Catch: Throwable -> L55
        r104.setStackTrace(ThreadMethodProxy.currentThread().getStackTrace());     // Catch: Throwable -> L55
        PluginEventManager.getInstance().notifyPluginErrorEvent(32000, r100.mPackageName, r100.mVersionCode, r104, System.currentTimeMillis());     // Catch: Throwable -> L55
    L49:
        monitor-exit(r100);     // Catch: Throwable -> L55
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadFinished, " + r100);
        if (r100.isActive() == false) goto L54;
        MiraLogger.d(MiraLogger.TAG_LOAD, "PluginLoader postResult, ACTIVE " + r100.mPackageName);
        this.mHandler.post(new AnonymousClass1(this, r100));
        return true;
    L54:
        return false;
    L31:
        if (r101.size() <= 0) goto L36;
        Iterator<MiraPluginBeforeLoadListener> r105 = r101.iterator();     // Catch: Throwable -> L55
    L34:
        if (r105.hasNext() == false) goto L36;
        r105.next().onBeforeLoad(r100.mPackageName);     // Catch: Throwable -> L55
        goto L34
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_plugin_PluginLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    private static PluginClassLoader createPluginClassLoader(Plugin r110, ApplicationInfo r111, File r112) {
        PluginClassLoader r100 = sCachedPluginClassLoader.get(r111.packageName);
        String r101 = r111.sourceDir;
        if (r100 == null) goto L5;
    L58:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader createPluginClassLoader, " + r111.packageName + " >> " + r100);
        return r100;
    L5:
        if (checkEnableTurboCrc32() == false) goto L7;
        takeTurboCrc32(r110);
    L7:
        boolean r102 = false;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111.sourceDir);     // Catch: Throwable -> L15
        if (r103.exists() == true) goto L11;
    L13:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader createPluginClassLoader, " + r111.packageName + " >> ensure file not write success~");     // Catch: Throwable -> L15
    L17:
        String r113 = r111.nativeLibraryDir;
        if (PluginMultiDexCompat.isNeedExtract() == false) goto L34;
        if (r110 != null) goto L21;
        String r104 = "";
    L22:
        if (r110 != null) goto L24;
        int r105 = 0;
    L26:
        if (PluginMultiDexCompat.isPluginExtract(r104, r105) == false) goto L60;
    L30:
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        String r106 = PluginMultiDexCompat.buildMultiDexPath(r110.mPackageName, r110.mVersionCode);
    L35:
        String r107 = r106;
        if ("com.ss.android.video".equals(r111.packageName) == false) goto L38;
    L51:
        PluginClassLoader r114 = ClassLoaderFactory.createNewPluginClassLoader(r107, r112.getPath(), r113, ClassLoader.getSystemClassLoader().getParent());
    L52:
        r100 = r114;
        if (checkEnableTurboClassDef() == false) goto L55;
        takeTurboClassDef(r100, r110);
    L55:
        ClassLoader r115 = ClassLoaderFactory.getInnerClassloader(r100);
        SoLoader.createClassLoaderNamespace(Mira.getAppContext(), r115);
        SoLoader.registerClassLoader(r115, r111.packageName);
        if (Looper.getMainLooper() == Looper.myLooper()) goto L58;
        SoLoader.checkPluginLinkedByPkg(r111.packageName);
        goto L58
    L38:
        if ("com.ss.android.wenda".equals(r111.packageName) == true) goto L51;
        if ("com.ss.android.ugc".equals(r111.packageName) == true) goto L51;
        if ("com.bytedance.concernrelated".equals(r111.packageName) == true) goto L51;
        if ("com.ss.android.dynamicdocker".equals(r111.packageName) == true) goto L51;
        if (r110 != null) goto L48;
    L50:
        r114 = ClassLoaderFactory.createPluginClassLoader(r110, r111.packageName, r107, r112.getPath(), r113, ClassLoader.getSystemClassLoader().getParent());
        goto L52
    L48:
        if (r110.mLoadAsHostClass == false) goto L50;
        r114 = ClassLoaderFactory.createNewPluginClassLoader(r107, r112.getPath(), r113, ClassLoader.getSystemClassLoader().getParent());
        goto L52
    L33:
        r106 = r111.sourceDir;
        goto L35
    L60:
        PluginMultiDexCompat.extract(new PolarisFileWrapper(r101), r104, r105);     // Catch: IOException -> L29
    L24:
        r105 = r110.mVersionCode;
        goto L26
    L21:
        r104 = r110.mPackageName;
        goto L22
    L34:
        r106 = r111.sourceDir;
        goto L35
    L11:
        if (r103.canWrite() == false) goto L13;
        r103.setWritable(false, false);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader createPluginClassLoader, " + r111.packageName + " >> ensure file not write fail~", th);
        goto L17
    }

    private static boolean installContentProviders(Context r100, String r101, String r102) {
        List<ProviderInfo> r103 = PluginPackageManager.getProviders(r101, r102, 0);
        if (r103 != null) goto L5;
        return true;
    L5:
        if (r103.size() <= 0) goto L24;
        Iterator<ProviderInfo> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        ProviderInfo r105 = r104.next();
        if (r100.getPackageManager().resolveContentProvider(r105.authority, 16777216) == null) goto L13;
        r104.remove();
    L13:
        if (TextUtils.equals(r105.applicationInfo.packageName, r100.getPackageName()) == true) goto L8;
        r105.applicationInfo.packageName = r100.getPackageName();
        goto L8
    L15:
        ActivityThreadHelper.installContentProviders(r100, r103);
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader installContentProviders, " + r103 + ", " + r101);
        return true;
    L24:
        return true;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_mira_plugin_PluginLoader_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r111, null, null, 3, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, r111);
    L35:
        return r100.registerReceiver(r101, r110, r111);
    }

    public static /* synthetic */ void access$000(Object r100, String r101, CharSequence r102, ApplicationInfo r103) {
        makeApplication(r100, r101, r102, r103);
    }

    private static void makeApplication(Object r100, String r110, CharSequence r111, ApplicationInfo r112) {
        MiraLogger.d(MiraLogger.TAG_LOAD, "PluginLoader makeApplication, " + r112.packageName);
        clearApplicationsCache(r100, r112);
        Application r101 = null;
        Application r102 = (Application) FieldUtils.readField(r100, "mApplication");     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        MiraLogger.w(MiraLogger.TAG_LOAD, "PluginLoader makeApplication, loadedApk.mApplication=null, " + r112.packageName);     // Catch: Throwable -> L9
        return;
    L7:
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadedApk.makeApplication(false, null), " + r112.packageName);     // Catch: Throwable -> L9
        realMakeApplication(r100, r112);     // Catch: Throwable -> L9
        registerReceivers(r112);     // Catch: Throwable -> L9
    L27:
        Application r103 = (Application) FieldUtils.readField(r100, "mApplication");     // Catch: Exception -> L20
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader loadedApk.mApplication = " + r103 + ", " + r112.packageName);     // Catch: Exception -> L18
        if (TextUtils.equals(r111, Mira.getAppContext().getPackageName()) == true) goto L34;
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader hackExternalDirsInContextImpl, mExternalFilesDir and mExternalCacheDir, " + r112.packageName);     // Catch: Exception -> L18
        ContextImplHelper.hackContextImplExternalDirs(r103.getBaseContext());     // Catch: Exception -> L18
    L34:
        MiraLogger.d(MiraLogger.TAG_LOAD, "PluginLoader ensure MiraInstrumentation hook, " + r112.packageName);     // Catch: Exception -> L24
        MiraHookManager.getInstance().installMiraInstrumentation();     // Catch: Exception -> L24
        MiraLogger.i(MiraLogger.TAG_LOAD, "PluginLoader callApplicationOnCreate(pluginApplication), " + r112.packageName);     // Catch: Exception -> L24
        MethodUtils.invokeMethod(ActivityThreadHelper.getInstrumentation(), "callApplicationOnCreate", new Object[]{r103}, new Class[]{Application.class});     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader callApplicationOnCreate failed, pkg = " + r112.packageName, e);
        return;
    L18:
        e = e;
        r102 = r103;
    L21:
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader hackExternalDirsInContextImpl failed.", e);
        r103 = r102;
    L20:
        e = e;
    L9:
        th = th;
        r101 = r102;
    L12:
        MiraLogger.e(MiraLogger.TAG_LOAD, "PluginLoader makeApplication failed, pkg = " + r112.packageName, th);
        r102 = r101;
    L11:
        th = th;
        goto L12
    }
}
