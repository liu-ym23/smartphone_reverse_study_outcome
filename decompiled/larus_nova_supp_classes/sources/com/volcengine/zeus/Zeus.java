package com.volcengine.zeus;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Zeus {
    private static volatile boolean onPrivacyAgreed;
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = null;
    static final Object wait = null;

    public static class f extends ZeusPluginStateListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ c c;
        public final /* synthetic */ CountDownLatch d;

        @Override // com.volcengine.zeus.ZeusPluginStateListener
        public final void onStateChangeOnCurThread(String r4, int r5, Object... r6) {
            if (TextUtils.equals(r4, this.a) == true) goto L6;
            return;
        L6:
            if (r5 == 9) goto L10;
            if (r5 == 10) goto L10;
            return;
        L10:
            if (this.b.compareAndSet(false, true) == false) goto L25;
            Zeus.unregisterPluginStateListener(this);
            if (r5 != 9) goto L14;
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad success, pkg=" + this.a);
            this.c.onLoadSuccess();
        L22:
            this.d.countDown();
            return;
        L14:
            if (r6 != null) goto L16;
        L20:
            String r7 = "unknown error";
        L21:
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad failed, pkg=" + this.a + ", error=" + r7);
            this.c.b(this.a, r7);
            goto L22
        L16:
            if (r6.length <= 0) goto L20;
            Object r8 = r6[0];
            if (r8 == null) goto L20;
            r7 = r8.toString();
            goto L21
        }

        public f(String r1, AtomicBoolean r2, c r3, CountDownLatch r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static class h implements Runnable {
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ ZeusPluginStateListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ c f;

        public final void a() {
        L9:
            e = move-exception;
            ThreadMethodProxy.currentThread().interrupt();
            if (this.c.compareAndSet(false, true) == false) goto L18;
            Zeus.unregisterPluginStateListener(this.d);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad interrupted, pkg=" + this.e, e);
            this.f.a(this.e, this.b);
            return;
        L18:
            return;
        L4:
            if (this.a.await(this.b, TimeUnit.MILLISECONDS) == false) goto L6;
            return;
        L6:
            if (this.c.compareAndSet(false, true) == false) goto L17;
            Zeus.unregisterPluginStateListener(this.d);     // Catch: InterruptedException -> L9
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "runAfterLoad timeout, pkg=" + this.e + ", timeout=" + this.b);     // Catch: InterruptedException -> L9
            this.f.a(this.e, this.b);     // Catch: InterruptedException -> L9
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

        public h(CountDownLatch r1, long r2, AtomicBoolean r4, f r5, String r6, c r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static class i implements d {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ ZeusPluginStateListener b;
        public final /* synthetic */ CountDownLatch c;
        public final /* synthetic */ String d;

        @Override // com.volcengine.zeus.d
        public final void cancel() {
            if (this.a.compareAndSet(false, true) == false) goto L6;
            Zeus.unregisterPluginStateListener(this.b);
            this.c.countDown();
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad canceled, pkg=" + this.d);
            return;
        }

        public i(AtomicBoolean r1, f r2, CountDownLatch r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
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
        a.a();
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
        String r0 = dqc.b.f();
        return ((Integer) ((HashMap) dqc.b.b).get(r0)).intValue();
    }

    public static String getZeusDid() {
        String r0 = GlobalParam.getInstance().getDid();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return com.volcengine.zeus.i.a().a;
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

    public static void addPluginEventCallback(ZeusPluginEventCallback r2) {
        com.volcengine.zeus.i r0 = com.volcengine.zeus.i.a();
        if (r2 != null) goto L5;
        r0.getClass();
        return;
    L5:
        List<ZeusPluginEventCallback> r1 = r0.c;
        monitor-enter(r1);
        ((ArrayList) r0.c).add(r2);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void fetchPlugin(String r2) {
        if (com.volcengine.zeus.download.f.b == null) goto L5;
    L14:
        com.volcengine.zeus.download.f.b.a(r2, false);
        return;
    L5:
        monitor-enter(com.volcengine.zeus.download.f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.volcengine.zeus.download.f.b != null) goto L9;
        com.volcengine.zeus.download.f.b = new com.volcengine.zeus.download.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.volcengine.zeus.download.f.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static int getInstalledPluginVersion(String r3) {
        Plugin r0 = PluginManager.getInstance().getPlugin(r3);
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = r0.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + r3 + " = " + r1);
        return r1;
    }

    public static int getMaxInstallVer(String r1) {
        if (dqc.d.d(getAppApplication()) == true) goto L5;
        return -1;
    L5:
        return getPlugin(r1).getInstalledMaxVer();
    }

    public static Plugin getPlugin(String r1) {
        return getPlugin(r1, true);
    }

    public static void installInternalPlugin(String r2) {
        Plugin r3 = getPlugin(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.shouldInstallInternalPlugin(false) == false) goto L9;
        r3.installInternalPlugin(false, true);
        return;
    }

    public static boolean isPluginInstalled(String r1) {
        Plugin r2 = PluginManager.getInstance().getPlugin(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isInstalled() == false) goto L7;
        return true;
    }

    public static boolean isPluginLoaded(String r1) {
        return PluginManager.getInstance().isLoaded(r1);
    }

    public static boolean loadPlugin(String r1) {
        return PluginManager.getInstance().loadPlugin(r1);
    }

    public static void loadPluginCrossProcess(String r1) {
        int r0 = com.volcengine.zeus.h.a;
        Intrinsics.checkNotNullParameter(r1, "pluginPackageName");
        com.volcengine.zeus.h.a(r1, true);
    }

    public static void registerPluginStateListener(ZeusPluginStateListener r1) {
        ((CopyOnWriteArrayList) com.volcengine.zeus.i.a().b).add(r1);
    }

    public static void reloadPlugin(String r1) {
        PluginProcessManager.INSTANCE.killPluginProcesses(r1);
        loadPluginCrossProcess(r1);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback r2) {
        com.volcengine.zeus.i r0 = com.volcengine.zeus.i.a();
        if (r2 != null) goto L5;
        r0.getClass();
        return;
    L5:
        List<ZeusPluginEventCallback> r1 = r0.c;
        monitor-enter(r1);
        ((ArrayList) r0.c).remove(r2);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void setAppContext(Application r2) {
        if (r2 != null) goto L4;
    L8:
        sApplication = r2;
        return;
    L4:
        if (TextUtils.equals(r2.getClass().getSimpleName(), "PluginApplicationWrapper") == false) goto L8;
        sApplication = (Application) FieldUtils.readField(r2, "mOriginApplication");     // Catch: Throwable -> L7
        return;
    L7:
        sApplication = r2;
    }

    public static boolean tryLoadPluginFromInstallStateSnapshot(String r1) {
        return PluginManager.getInstance().tryLoadPluginFromInstallStateSnapshot(r1);
    }

    public static void unInstallPlugin(String r1) {
        PluginManager.getInstance().unInstallPackage(r1);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener r1) {
        List<ZeusPluginStateListener> r0 = com.volcengine.zeus.i.a().b;
        if (r0 == null) goto L6;
        ((CopyOnWriteArrayList) r0).remove(r1);
        return;
    }

    public static boolean waitInit(int r3) {
        if (com.volcengine.zeus.i.a().a == false) goto L6;
        return true;
    L6:
        Object r0 = wait;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (com.volcengine.zeus.i.a().a == false) goto L22;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return com.volcengine.zeus.i.a().a;
    L22:
        if (r3 != (-1)) goto L13;
        r0.wait();     // Catch: InterruptedException -> L20 Throwable -> L17
    L21:
        goto L14
    L13:
        r0.wait(r3);     // Catch: InterruptedException -> L20 Throwable -> L17
        goto L21
    }

    public static void addExternalAssetsForPlugin(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        Plugin r4 = getPlugin(r2);
        if (r4 == null) goto L14;
        Resources r5 = r4.mResources;
        if (r5 == null) goto L15;
        AssetManager r6 = r5.getAssets();
        new jqc.a().c(r6, r3, false);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean awaitLoad(String r17, long r18) {
        boolean r8 = false;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        if (GlobalParam.getInstance().isDebug() == true) goto L8;
        return false;
    L8:
        throw new IllegalStateException("awaitLoad should never be called in main thread");
    L10:
        if (TextUtils.isEmpty(r17) == false) goto L13;
        return true;
    L13:
        if (isPluginLoaded(r17) == false) goto L15;
        return true;
    L15:
        Plugin r6 = PluginManager.getInstance().getPlugin(r17);
        if (r6 != null) goto L20;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "plugin is null, not await, pkg=" + r17);
        return false;
    L20:
        if (r6.getMigrationHandler().isMigrationNeeded(r17) == false) goto L23;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "migrationNeeded not await, pkg=" + r17);
        return false;
    L23:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad start, pkg=" + r17 + ", timeout=" + r18);
        Queue<Runnable> r7 = p.a;
        Runnable r9 = new a(r17);
        Intrinsics.checkNotNullParameter(r9, "runnable");
        p.c.post(r9);
        CountDownLatch r10 = new CountDownLatch(1);
        AtomicBoolean r11 = new AtomicBoolean(false);
        boolean[] r12 = {false};
        b r13 = new b(r17, r12, r11, r10);
        registerPluginStateListener(r13);
        if (isPluginLoaded(r17) == false) goto L60;
        if (r11.compareAndSet(false, true) == false) goto L60;
        unregisterPluginStateListener(r13);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad loaded after register, pkg=" + r17);
        return true;
    L60:
        if (r18 > 0) goto L32;
        r10.await();     // Catch: Throwable -> L42 InterruptedException -> L44
    L39:
        if (r11.compareAndSet(false, true) == false) goto L50;
    L48:
        unregisterPluginStateListener(r13);
    L50:
        if (r12[0] == false) goto L52;
    L53:
        r8 = true;
    L54:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "awaitLoad finish, pkg=" + r17 + ", result=" + r8);
        return r8;
    L52:
        if (isPluginLoaded(r17) == false) goto L54;
    L32:
        if (r10.await(r18, TimeUnit.MILLISECONDS) == true) goto L39;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "awaitLoad timeout, pkg=" + r17 + ", timeout=" + r18);     // Catch: Throwable -> L42 InterruptedException -> L44
        Thread r2 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());     // Catch: Throwable -> L42 InterruptedException -> L44
        if (r2.getState() == Thread.State.RUNNABLE) goto L39;
        IllegalStateException r3 = new IllegalStateException("awaitLoad timeout with main thread blocking, pkg=" + r17);     // Catch: Throwable -> L42 InterruptedException -> L44
        r3.setStackTrace(r2.getStackTrace());     // Catch: Throwable -> L42 InterruptedException -> L44
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "awaitLoad timeout with main thread blocking", r3);     // Catch: Throwable -> L42 InterruptedException -> L44
        if (GlobalParam.getInstance().isDebug() == false) goto L39;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L42 InterruptedException -> L44
    L44:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L42
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "awaitLoad interrupted, pkg=" + r17, e);     // Catch: Throwable -> L42
        if (r11.compareAndSet(false, true) == false) goto L50;
    L42:
        th = move-exception;
        if (r11.compareAndSet(false, true) == false) goto L59;
        unregisterPluginStateListener(r13);
    L59:
        throw th;
    }

    public static void fetchPlugin(String r2, boolean r3) {
        if (com.volcengine.zeus.download.f.b == null) goto L5;
    L14:
        com.volcengine.zeus.download.f.b.a(r2, r3);
        return;
    L5:
        monitor-enter(com.volcengine.zeus.download.f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.volcengine.zeus.download.f.b != null) goto L9;
        com.volcengine.zeus.download.f.b = new com.volcengine.zeus.download.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.volcengine.zeus.download.f.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static Plugin getPlugin(String r1, boolean r2) {
        return PluginManager.getInstance().getPlugin(r1, r2);
    }

    public static void init(Application r14, boolean r15) {
        long r0 = System.currentTimeMillis();
        long r2 = System.currentTimeMillis();
        com.volcengine.zeus.i.a().b(r14, r15);
        long r8 = System.currentTimeMillis() - r2;
        boolean r16 = r.a;
        PolarisFileWrapper r17 = new PolarisFileWrapper("/proc/sys/kernel/random/boot_id");
        String r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        BufferedReader r6 = null;
        r5 = null;
        if (r17.exists() == false) goto L40;
        if (r17.canRead() == false) goto L40;
        BufferedReader r3 = new BufferedReader(new PolarisFileReaderWrapper(r17));     // Catch: Throwable -> L30 Exception -> L34
        String r18 = r3.readLine();     // Catch: Throwable -> L27 Exception -> L29
        if (TextUtils.isEmpty(r18) == true) goto L78;
        int r7 = r18.length() - 1;     // Catch: Throwable -> L27 Exception -> L29
        int r9 = 0;
        boolean r10 = false;
    L10:
        if (r9 > r7) goto L25;
        if (r10 == true) goto L13;
        int r11 = r9;
    L15:
        if (Intrinsics.compare(r18.charAt(r11), 32) > 0) goto L17;
        boolean r12 = true;
    L18:
        if (r10 == false) goto L19;
        if (r12 == false) goto L25;
        r7 = r7 - 1;     // Catch: Throwable -> L27 Exception -> L29
        goto L10
    L19:
        if (r12 == false) goto L20;
        r9 = r9 + 1;     // Catch: Throwable -> L27 Exception -> L29
        goto L10
    L20:
        r10 = true;
        goto L10
    L17:
        r12 = false;
        goto L18
    L13:
        r11 = r7;
    L25:
        r5 = r18.subSequence(r9, r7 + 1).toString();     // Catch: Throwable -> L27 Exception -> L29
    L78:
        r3.close();     // Catch: IOException -> L38
    L27:
        th = th;
        r6 = r3;
    L31:
        if (r6 != null) goto L76;
    L33:
        throw th;
    L76:
        r6.close();     // Catch: IOException -> L70
    L35:
        if (r3 == null) goto L40;
    L34:
        r3 = null;
    L30:
        th = th;
    L40:
        if (TextUtils.isEmpty(r5) == true) goto L48;
        String r19 = t.c().e().getString("last_boot_id", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r19) == false) goto L45;
        r.a = true;
        t.c().q(r5);
    L57:
        long r13 = System.currentTimeMillis();
        PreInstallTask.i.getClass();
        Intrinsics.checkNotNullParameter(r14, "context");
        if (PreInstallTask.g.compareAndSet(false, true) == true) goto L60;
        ZeusLogger.i("ZeusPreInstallTask", "already init");
    L61:
        long r110 = System.currentTimeMillis() - r13;
        Object r111 = wait;
        monitor-enter(r111);
        r111.notifyAll();     // Catch: Throwable -> L67
        monitor-exit(r111);     // Catch: Throwable -> L67
        reportInitCost(System.currentTimeMillis() - r0, r8, r110);
        return;
    L67:
        th = move-exception;
        throw th;
    L60:
        ZeusLogger.i("ZeusPreInstallTask", "init");
        PreInstallTask.Companion.c();
        goto L61
    L45:
        if (TextUtils.equals(r5, r19) == true) goto L47;
        r.a = true;
        t.c().q(r5);
        goto L57
    L47:
        r.a = false;
        goto L57
    L48:
        long r112 = 10000;
        long r20 = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / r112) * r112;
        String r113 = t.c().e().getString("last_boot_id", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r113) == false) goto L72;
        r.a = true;
        t.c().q(String.valueOf(r20));
        goto L57
    L72:
    L56:
        r.a = true;
        t.c().q(String.valueOf(r20));
        goto L57
    L52:
        if (Math.abs(r20 - CastLongProtector.parseLong(r113)) <= 60000) goto L54;
        r.a = true;     // Catch: Exception -> L56
        t.c().q(String.valueOf(r20));     // Catch: Exception -> L56
    L71:
        goto L57
    L54:
        r.a = false;     // Catch: Exception -> L56
        goto L71
    }

    public static void installInternalPlugin(String r1, boolean r2) {
        Plugin r3 = getPlugin(r1);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.shouldInstallInternalPlugin(false, r2) == false) goto L9;
        r3.installInternalPlugin(false, true);
        return;
    }

    public static boolean loadOrAwaitLoad(String r2, long r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        return loadPlugin(r2);
    L7:
        return awaitLoad(r2, r3);
    }

    public static void loadPluginCrossProcess(String r0, boolean r1) {
        com.volcengine.zeus.h.a(r0, r1);
    }

    public static void requestPluginInfo(List<String> r2, com.volcengine.zeus.download.g r3) {
        ExecutorCompletionService r4 = new ExecutorCompletionService(dqc.e.a);
        dqc.e.b(new com.volcengine.zeus.download.h(r2, r4));
        Iterator<String> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.submit(new com.volcengine.zeus.download.i(r5.next()));
        goto L4
    }

    public static void setAllowInstallVersion(String r0, int r1) {
        Plugin r2 = getPlugin(r0);
        if (r2 == null) goto L6;
        r2.setAllowInstallVersion(r1);
        return;
    }

    public static boolean syncInstallPlugin(String r1, String r2) {
        IPackageManager r0 = ServerManagerHelper.getPackageManager();
        if (r0 == null) goto L12;
        return r0.syncInstallPackage(r1, r2);
    L6:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
        return false;
    L12:
        return false;
    }

    public static void preInstallPluginFromHostApk(String r10, long r11, com.volcengine.zeus.plugin.preinstall.a r13) {
        int r0 = com.volcengine.zeus.h.a;
        Intrinsics.checkNotNullParameter(r10, "hostApkPath");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZeusKt.preInstallPluginFromHostApkAsync.1(r10, r11, r13, null), 3, null);
    }

    private static void reportInitCost(long r6, long r8, long r10) {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L4
        r5.put("zeus_manager_init_cost", r8);     // Catch: Exception -> L4
        r5.put("pre_install_init_cost", r10);     // Catch: Exception -> L4
        r.a(null, null, "init", r6, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "report init cost failed", e);
    }

    public static d runAfterLoad(String r12, c r13, long r14) {
        if (r13 != null) goto L6;
        return new c();
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r13.b(r12, "pluginPackageName is empty");
        return new d();
    L10:
        if (isPluginLoaded(r12) == false) goto L13;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad already loaded, pkg=" + r12);
        r13.onLoadSuccess();
        return new e();
    L13:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad start, pkg=" + r12 + ", timeout=" + r14);
        CountDownLatch r0 = new CountDownLatch(1);
        AtomicBoolean r10 = new AtomicBoolean(false);
        f r11 = new f(r12, r10, r13, r0);
        registerPluginStateListener(r11);
        if (isPluginLoaded(r12) == false) goto L20;
        if (r10.compareAndSet(false, true) == false) goto L20;
        unregisterPluginStateListener(r11);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "runAfterLoad loaded after register, pkg=" + r12);
        r13.onLoadSuccess();
        return new g();
    L20:
        if (r14 <= 0) goto L23;
        dqc.e.b(new h(r0, r14, r10, r11, r12, r13));
    L23:
        return new i(r10, r11, r0, r12);
    }

    public static void setAllowDownloadPlugin(String r1, int r2, boolean r3) {
        PluginManager.getInstance().setAllowDownloadPlugin(r1, r2, r3);
    }
}
