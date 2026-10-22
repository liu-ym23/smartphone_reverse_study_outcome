package com.volcengine.zeus;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.apm.ApmUtils;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.plugin.preinstall.PreInstallTask;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.service.server.PluginProcessManager;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqc.p;
import mqc.r;
import mqc.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Zeus {
    private static volatile boolean onPrivacyAgreed;
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = null;
    static final Object wait = null;

    /* JADX INFO: loaded from: classes6.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462637a;

        @Override // java.lang.Runnable
        public final void run() {
            Zeus.loadPlugin(this.f462637a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100) {
            this.f462637a = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class b extends ZeusPluginStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f462639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f462640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462641d;

        @Override // com.volcengine.zeus.ZeusPluginStateListener
        public final void onStateChangeOnCurThread(String r100, int r101, Object... r102) {
            if (TextUtils.equals(r100, this.f462638a) == true) goto L6;
            return;
        L6:
            if (r101 != 9) goto L8;
        L9:
            boolean[] r103 = this.f462639b;
            if (r101 != 9) goto L12;
            boolean r104 = true;
        L13:
            r103[0] = r104;
            if (this.f462640c.compareAndSet(false, true) == false) goto L18;
            Zeus.unregisterPluginStateListener(this);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad event, pkg=" + this.f462638a + ", loaded=" + this.f462639b[0]);
            this.f462641d.countDown();
            return;
        L18:
            return;
        L12:
            r104 = false;
            goto L13
        L8:
            if (r101 == 10) goto L9;
        }

        public b(String r100, boolean[] r101, AtomicBoolean r102, CountDownLatch r103) {
            this.f462638a = r100;
            this.f462639b = r101;
            this.f462640c = r102;
            this.f462641d = r103;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class c implements com.volcengine.zeus.d {
        public c() {
        }

        @Override // com.volcengine.zeus.d
        public final void cancel() {
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class d implements com.volcengine.zeus.d {
        public d() {
        }

        @Override // com.volcengine.zeus.d
        public final void cancel() {
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class e implements com.volcengine.zeus.d {
        public e() {
        }

        @Override // com.volcengine.zeus.d
        public final void cancel() {
        }
    }

    public static class f extends ZeusPluginStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f462643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.volcengine.zeus.c f462644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462645d;

        @Override // com.volcengine.zeus.ZeusPluginStateListener
        public final void onStateChangeOnCurThread(String r100, int r101, Object... r102) {
            if (TextUtils.equals(r100, this.f462642a) == true) goto L6;
            return;
        L6:
            if (r101 == 9) goto L10;
            if (r101 == 10) goto L10;
            return;
        L10:
            if (this.f462643b.compareAndSet(false, true) == false) goto L25;
            Zeus.unregisterPluginStateListener(this);
            if (r101 != 9) goto L14;
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad success, pkg=" + this.f462642a);
            this.f462644c.onLoadSuccess();
        L22:
            this.f462645d.countDown();
            return;
        L14:
            if (r102 != null) goto L16;
        L20:
            String r103 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        L21:
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad failed, pkg=" + this.f462642a + ", error=" + r103);
            this.f462644c.b(this.f462642a, r103);
            goto L22
        L16:
            if (r102.length <= 0) goto L20;
            Object r104 = r102[0];
            if (r104 == null) goto L20;
            r103 = r104.toString();
            goto L21
        }

        public f(String r100, AtomicBoolean r101, com.volcengine.zeus.c r102, CountDownLatch r103) {
            this.f462642a = r100;
            this.f462643b = r101;
            this.f462644c = r102;
            this.f462645d = r103;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class g implements com.volcengine.zeus.d {
        public g() {
        }

        @Override // com.volcengine.zeus.d
        public final void cancel() {
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f462647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f462648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ZeusPluginStateListener f462649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f462650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.volcengine.zeus.c f462651f;

        public final void a() {
        L9:
            e = move-exception;
            ThreadMethodProxy.currentThread().interrupt();
            if (this.f462648c.compareAndSet(false, true) == false) goto L18;
            Zeus.unregisterPluginStateListener(this.f462649d);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad interrupted, pkg=" + this.f462650e, e);
            this.f462651f.a(this.f462650e, this.f462647b);
            return;
        L18:
            return;
        L4:
            if (this.f462646a.await(this.f462647b, TimeUnit.MILLISECONDS) == false) goto L6;
            return;
        L6:
            if (this.f462648c.compareAndSet(false, true) == false) goto L17;
            Zeus.unregisterPluginStateListener(this.f462649d);     // Catch: InterruptedException -> L9
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad timeout, pkg=" + this.f462650e + ", timeout=" + this.f462647b);     // Catch: InterruptedException -> L9
            this.f462651f.a(this.f462650e, this.f462647b);     // Catch: InterruptedException -> L9
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(CountDownLatch r100, long r101, AtomicBoolean r102, f r103, String r104, com.volcengine.zeus.c r105) {
            this.f462646a = r100;
            this.f462647b = r101;
            this.f462648c = r102;
            this.f462649d = r103;
            this.f462650e = r104;
            this.f462651f = r105;
        }
    }

    public static class i implements com.volcengine.zeus.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f462652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ZeusPluginStateListener f462653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f462655d;

        @Override // com.volcengine.zeus.d
        public final void cancel() {
            if (this.f462652a.compareAndSet(false, true) == false) goto L6;
            Zeus.unregisterPluginStateListener(this.f462653b);
            this.f462654c.countDown();
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad canceled, pkg=" + this.f462655d);
            return;
        }

        public i(AtomicBoolean r100, f r101, CountDownLatch r102, String r103) {
            this.f462652a = r100;
            this.f462653b = r101;
            this.f462654c = r102;
            this.f462655d = r103;
        }
    }

    public Zeus() {
    }

    static {
        serverManagerHashMap = new HashMap();
        wait = new Object();
        onPrivacyAgreed = false;
    }

    public static Application getAppApplication() {
        if (sApplication != null) goto L7;
        com.volcengine.zeus.a.a();
        sApplication = (Application) MethodUtils.invokeMethod(dqc.a.b(), "getApplication", new Object[0]);     // Catch: Throwable -> L8
    L7:
        return sApplication;
    }

    public static synchronized void onPrivacyAgreed() {
        monitor-enter(Zeus.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (onPrivacyAgreed == false) goto L8;
        monitor-exit(Zeus.class);
        return;
    L8:
        ApmUtils.getApmInstance().init();     // Catch: Throwable -> L11
        onPrivacyAgreed = true;     // Catch: Throwable -> L11
        monitor-exit(Zeus.class);
    }

    public static Map<String, Plugin> getAllPlugins() {
        return PluginManager.getInstance().getAllPlugins();
    }

    public static String getHostAbi() {
        return dqc.b.f();
    }

    public static int getHostAbiBit() {
        String r100 = dqc.b.f();
        return ((Integer) ((HashMap) dqc.b.f469729b).get(r100)).intValue();
    }

    public static String getZeusDid() {
        String r100 = GlobalParam.getInstance().getDid();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        return ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return com.volcengine.zeus.i.a().f462709a;
    }

    public static void installFromDownloadDir() {
        if (dqc.d.d(getAppApplication()) == false) goto L6;
        PluginManager.getInstance().installFromDownloadDir(false);
        return;
    }

    public static void installFromPushDir() {
        if (dqc.d.d(getAppApplication()) == false) goto L6;
        PluginManager.getInstance().installFromDownloadDir(true);
        return;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static void triggerBgDexOpt() {
        com.volcengine.zeus.oat.f.a();
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback r100) {
        com.volcengine.zeus.i r101 = com.volcengine.zeus.i.a();
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        List<ZeusPluginEventCallback> r102 = r101.f462711c;
        monitor-enter(r102);
        ((ArrayList) r101.f462711c).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void fetchPlugin(String r100) {
        if (com.volcengine.zeus.download.f.f462683b == null) goto L5;
    L14:
        com.volcengine.zeus.download.f.f462683b.a(r100, false);
        return;
    L5:
        monitor-enter(com.volcengine.zeus.download.f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.volcengine.zeus.download.f.f462683b != null) goto L9;
        com.volcengine.zeus.download.f.f462683b = new com.volcengine.zeus.download.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.volcengine.zeus.download.f.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static int getInstalledPluginVersion(String r100) {
        Plugin r101 = PluginManager.getInstance().getPlugin(r100);
        if (r101 != null) goto L6;
        return -1;
    L6:
        int r102 = r101.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + r100 + " = " + r102);
        return r102;
    }

    public static int getMaxInstallVer(String r100) {
        if (dqc.d.d(getAppApplication()) == true) goto L5;
        return -1;
    L5:
        return getPlugin(r100).getInstalledMaxVer();
    }

    public static Plugin getPlugin(String r100) {
        return getPlugin(r100, true);
    }

    public static void installInternalPlugin(String r100) {
        Plugin r101 = getPlugin(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.shouldInstallInternalPlugin(false) == false) goto L9;
        r101.installInternalPlugin(false, true);
        return;
    }

    public static boolean isPluginInstalled(String r100) {
        Plugin r101 = PluginManager.getInstance().getPlugin(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isInstalled() == false) goto L7;
        return true;
    }

    public static boolean isPluginLoaded(String r100) {
        return PluginManager.getInstance().isLoaded(r100);
    }

    public static boolean loadPlugin(String r100) {
        return PluginManager.getInstance().loadPlugin(r100);
    }

    public static void loadPluginCrossProcess(String r100) {
        int r101 = com.volcengine.zeus.h.f462707a;
        Intrinsics.checkNotNullParameter(r100, "pluginPackageName");
        com.volcengine.zeus.h.a(r100, true);
    }

    public static void registerPluginStateListener(ZeusPluginStateListener r100) {
        ((CopyOnWriteArrayList) com.volcengine.zeus.i.a().f462710b).add(r100);
    }

    public static void reloadPlugin(String r100) {
        PluginProcessManager.INSTANCE.killPluginProcesses(r100);
        loadPluginCrossProcess(r100);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback r100) {
        com.volcengine.zeus.i r101 = com.volcengine.zeus.i.a();
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        List<ZeusPluginEventCallback> r102 = r101.f462711c;
        monitor-enter(r102);
        ((ArrayList) r101.f462711c).remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void setAppContext(Application r100) {
        if (r100 != null) goto L4;
    L8:
        sApplication = r100;
        return;
    L4:
        if (TextUtils.equals(r100.getClass().getSimpleName(), "PluginApplicationWrapper") == false) goto L8;
        sApplication = (Application) FieldUtils.readField(r100, "mOriginApplication");     // Catch: Throwable -> L7
        return;
    L7:
        sApplication = r100;
    }

    public static boolean tryLoadPluginFromInstallStateSnapshot(String r100) {
        return PluginManager.getInstance().tryLoadPluginFromInstallStateSnapshot(r100);
    }

    public static void unInstallPlugin(String r100) {
        PluginManager.getInstance().unInstallPackage(r100);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener r100) {
        List<ZeusPluginStateListener> r101 = com.volcengine.zeus.i.a().f462710b;
        if (r101 == null) goto L6;
        ((CopyOnWriteArrayList) r101).remove(r100);
        return;
    }

    public static boolean waitInit(int r100) {
        if (com.volcengine.zeus.i.a().f462709a == false) goto L6;
        return true;
    L6:
        Object r101 = wait;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (com.volcengine.zeus.i.a().f462709a == false) goto L22;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return com.volcengine.zeus.i.a().f462709a;
    L22:
        if (r100 != (-1)) goto L13;
        r101.wait();     // Catch: InterruptedException -> L20 Throwable -> L17
    L21:
        goto L14
    L13:
        r101.wait(r100);     // Catch: InterruptedException -> L20 Throwable -> L17
        goto L21
    }

    public static void addExternalAssetsForPlugin(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        Plugin r102 = getPlugin(r100);
        if (r102 == null) goto L14;
        Resources r103 = r102.mResources;
        if (r103 == null) goto L15;
        AssetManager r104 = r103.getAssets();
        new jqc.a().c(r104, r101, false);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean awaitLoad(String r110, long r111) {
        boolean r100 = false;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        if (GlobalParam.getInstance().isDebug() == true) goto L8;
        return false;
    L8:
        throw new IllegalStateException("awaitLoad should never be called in main thread");
    L10:
        if (TextUtils.isEmpty(r110) == false) goto L13;
        return true;
    L13:
        if (isPluginLoaded(r110) == false) goto L15;
        return true;
    L15:
        Plugin r101 = PluginManager.getInstance().getPlugin(r110);
        if (r101 != null) goto L20;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "plugin is null, not await, pkg=" + r110);
        return false;
    L20:
        if (r101.getMigrationHandler().isMigrationNeeded(r110) == false) goto L23;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "migrationNeeded not await, pkg=" + r110);
        return false;
    L23:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad start, pkg=" + r110 + ", timeout=" + r111);
        Queue<Runnable> r102 = p.f514963a;
        a r103 = new a(r110);
        Intrinsics.checkNotNullParameter(r103, "runnable");
        p.f514965c.post(r103);
        CountDownLatch r104 = new CountDownLatch(1);
        AtomicBoolean r112 = new AtomicBoolean(false);
        boolean[] r113 = {false};
        b r114 = new b(r110, r113, r112, r104);
        registerPluginStateListener(r114);
        if (isPluginLoaded(r110) == false) goto L60;
        if (r112.compareAndSet(false, true) == false) goto L60;
        unregisterPluginStateListener(r114);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad loaded after register, pkg=" + r110);
        return true;
    L60:
        if (r111 > 0) goto L32;
        r104.await();     // Catch: Throwable -> L42 InterruptedException -> L44
    L39:
        if (r112.compareAndSet(false, true) == false) goto L50;
    L48:
        unregisterPluginStateListener(r114);
    L50:
        if (r113[0] == false) goto L52;
    L53:
        r100 = true;
    L54:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad finish, pkg=" + r110 + ", result=" + r100);
        return r100;
    L52:
        if (isPluginLoaded(r110) == false) goto L54;
    L32:
        if (r104.await(r111, TimeUnit.MILLISECONDS) == true) goto L39;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "awaitLoad timeout, pkg=" + r110 + ", timeout=" + r111);     // Catch: Throwable -> L42 InterruptedException -> L44
        Thread r105 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());     // Catch: Throwable -> L42 InterruptedException -> L44
        if (r105.getState() == Thread.State.RUNNABLE) goto L39;
        IllegalStateException r106 = new IllegalStateException("awaitLoad timeout with main thread blocking, pkg=" + r110);     // Catch: Throwable -> L42 InterruptedException -> L44
        r106.setStackTrace(r105.getStackTrace());     // Catch: Throwable -> L42 InterruptedException -> L44
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "awaitLoad timeout with main thread blocking", r106);     // Catch: Throwable -> L42 InterruptedException -> L44
        if (GlobalParam.getInstance().isDebug() == false) goto L39;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L42 InterruptedException -> L44
    L44:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L42
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "awaitLoad interrupted, pkg=" + r110, e);     // Catch: Throwable -> L42
        if (r112.compareAndSet(false, true) == false) goto L50;
    L42:
        th = move-exception;
        if (r112.compareAndSet(false, true) == false) goto L59;
        unregisterPluginStateListener(r114);
    L59:
        throw th;
    }

    public static void fetchPlugin(String r100, boolean r101) {
        if (com.volcengine.zeus.download.f.f462683b == null) goto L5;
    L14:
        com.volcengine.zeus.download.f.f462683b.a(r100, r101);
        return;
    L5:
        monitor-enter(com.volcengine.zeus.download.f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.volcengine.zeus.download.f.f462683b != null) goto L9;
        com.volcengine.zeus.download.f.f462683b = new com.volcengine.zeus.download.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.volcengine.zeus.download.f.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static Plugin getPlugin(String r100, boolean r101) {
        return PluginManager.getInstance().getPlugin(r100, r101);
    }

    public static void init(Application r110, boolean r111) {
        long r100 = System.currentTimeMillis();
        long r101 = System.currentTimeMillis();
        com.volcengine.zeus.i.a().b(r110, r111);
        long r102 = System.currentTimeMillis() - r101;
        boolean r112 = r.f514968a;
        PolarisFileWrapper r113 = new PolarisFileWrapper("/proc/sys/kernel/random/boot_id");
        String r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        BufferedReader r104 = null;
        r103 = null;
        if (r113.exists() == false) goto L40;
        if (r113.canRead() == false) goto L40;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r113));     // Catch: Throwable -> L30 Exception -> L34
        String r114 = r105.readLine();     // Catch: Throwable -> L27 Exception -> L29
        if (TextUtils.isEmpty(r114) == true) goto L78;
        int r106 = r114.length() - 1;     // Catch: Throwable -> L27 Exception -> L29
        int r107 = 0;
        boolean r115 = false;
    L10:
        if (r107 > r106) goto L25;
        if (r115 == true) goto L13;
        int r116 = r107;
    L15:
        if (Intrinsics.compare(r114.charAt(r116), 32) > 0) goto L17;
        boolean r117 = true;
    L18:
        if (r115 == false) goto L19;
        if (r117 == false) goto L25;
        r106 = r106 - 1;     // Catch: Throwable -> L27 Exception -> L29
        goto L10
    L19:
        if (r117 == false) goto L20;
        r107 = r107 + 1;     // Catch: Throwable -> L27 Exception -> L29
        goto L10
    L20:
        r115 = true;
        goto L10
    L17:
        r117 = false;
        goto L18
    L13:
        r116 = r106;
    L25:
        r103 = r114.subSequence(r107, r106 + 1).toString();     // Catch: Throwable -> L27 Exception -> L29
    L78:
        r105.close();     // Catch: IOException -> L38
    L27:
        th = th;
        r104 = r105;
    L31:
        if (r104 != null) goto L76;
    L33:
        throw th;
    L76:
        r104.close();     // Catch: IOException -> L70
    L35:
        if (r105 == null) goto L40;
    L34:
        r105 = null;
    L30:
        th = th;
    L40:
        if (TextUtils.isEmpty(r103) == true) goto L48;
        String r118 = t.c().e().getString("last_boot_id", "");
        if (TextUtils.isEmpty(r118) == false) goto L45;
        r.f514968a = true;
        t.c().q(r103);
    L57:
        long r108 = System.currentTimeMillis();
        PreInstallTask.f462815i.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (PreInstallTask.f462813g.compareAndSet(false, true) == true) goto L60;
        ZeusLogger.i("ZeusPreInstallTask", "already init");
    L61:
        long r119 = System.currentTimeMillis() - r108;
        Object r120 = wait;
        monitor-enter(r120);
        r120.notifyAll();     // Catch: Throwable -> L67
        monitor-exit(r120);     // Catch: Throwable -> L67
        reportInitCost(System.currentTimeMillis() - r100, r102, r119);
        return;
    L67:
        th = move-exception;
        throw th;
    L60:
        ZeusLogger.i("ZeusPreInstallTask", "init");
        PreInstallTask.Companion.c();
        goto L61
    L45:
        if (TextUtils.equals(r103, r118) == true) goto L47;
        r.f514968a = true;
        t.c().q(r103);
        goto L57
    L47:
        r.f514968a = false;
        goto L57
    L48:
        long r121 = 10000;
        long r109 = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / r121) * r121;
        String r122 = t.c().e().getString("last_boot_id", "");
        if (TextUtils.isEmpty(r122) == false) goto L72;
        r.f514968a = true;
        t.c().q(String.valueOf(r109));
        goto L57
    L72:
    L56:
        r.f514968a = true;
        t.c().q(String.valueOf(r109));
        goto L57
    L52:
        if (Math.abs(r109 - CastLongProtector.parseLong(r122)) <= 60000) goto L54;
        r.f514968a = true;     // Catch: Exception -> L56
        t.c().q(String.valueOf(r109));     // Catch: Exception -> L56
    L71:
        goto L57
    L54:
        r.f514968a = false;     // Catch: Exception -> L56
        goto L71
    }

    public static void installInternalPlugin(String r100, boolean r101) {
        Plugin r102 = getPlugin(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.shouldInstallInternalPlugin(false, r101) == false) goto L9;
        r102.installInternalPlugin(false, true);
        return;
    }

    public static boolean loadOrAwaitLoad(String r100, long r101) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        return loadPlugin(r100);
    L7:
        return awaitLoad(r100, r101);
    }

    public static void loadPluginCrossProcess(String r100, boolean r101) {
        com.volcengine.zeus.h.a(r100, r101);
    }

    public static void requestPluginInfo(List<String> r100, com.volcengine.zeus.download.g r101) {
        ExecutorCompletionService r102 = new ExecutorCompletionService(dqc.e.f469735a);
        dqc.e.b(new com.volcengine.zeus.download.h(r100, r102));
        Iterator<String> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.submit(new com.volcengine.zeus.download.i(r103.next()));
        goto L4
    }

    public static void setAllowInstallVersion(String r100, int r101) {
        Plugin r102 = getPlugin(r100);
        if (r102 == null) goto L6;
        r102.setAllowInstallVersion(r101);
        return;
    }

    public static boolean syncInstallPlugin(String r100, String r101) {
        IPackageManager r102 = ServerManagerHelper.getPackageManager();
        if (r102 == null) goto L12;
        return r102.syncInstallPackage(r100, r101);
    L6:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
        return false;
    L12:
        return false;
    }

    public static void preInstallPluginFromHostApk(String r110, long r111, com.volcengine.zeus.plugin.preinstall.a r112) {
        int r100 = com.volcengine.zeus.h.f462707a;
        Intrinsics.checkNotNullParameter(r110, "hostApkPath");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZeusKt$preInstallPluginFromHostApkAsync$1(r110, r111, r112, null), 3, null);
    }

    private static void reportInitCost(long r100, long r101, long r110) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put("zeus_manager_init_cost", r101);     // Catch: Exception -> L4
        r102.put("pre_install_init_cost", r110);     // Catch: Exception -> L4
        r.a(null, null, "init", r100, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "report init cost failed", e);
    }

    public static com.volcengine.zeus.d runAfterLoad(String r110, com.volcengine.zeus.c r111, long r112) {
        if (r111 != null) goto L6;
        return new c();
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L10;
        r111.b(r110, "pluginPackageName is empty");
        return new d();
    L10:
        if (isPluginLoaded(r110) == false) goto L13;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad already loaded, pkg=" + r110);
        r111.onLoadSuccess();
        return new e();
    L13:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad start, pkg=" + r110 + ", timeout=" + r112);
        CountDownLatch r100 = new CountDownLatch(1);
        AtomicBoolean r113 = new AtomicBoolean(false);
        f r114 = new f(r110, r113, r111, r100);
        registerPluginStateListener(r114);
        if (isPluginLoaded(r110) == false) goto L20;
        if (r113.compareAndSet(false, true) == false) goto L20;
        unregisterPluginStateListener(r114);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad loaded after register, pkg=" + r110);
        r111.onLoadSuccess();
        return new g();
    L20:
        if (r112 <= 0) goto L23;
        dqc.e.b(new h(r100, r112, r113, r114, r110, r111));
    L23:
        return new i(r113, r114, r100, r110);
    }

    public static void setAllowDownloadPlugin(String r100, int r101, boolean r102) {
        PluginManager.getInstance().setAllowDownloadPlugin(r100, r101, r102);
    }
}
