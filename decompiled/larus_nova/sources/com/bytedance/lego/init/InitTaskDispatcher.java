package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InitTaskDispatcher implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f254496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InitTaskManager f254497b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f254498c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f254499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f254500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CountDownLatch f254501f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<InitPeriod> f254502g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<InitPeriod> f254503h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f254504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<m> f254505j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f254506k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f254507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CopyOnWriteArrayList<m> f254508m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Handler f254509n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final InitTaskDispatcher f254510o = null;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bf6.f f254511a;

        @Override // java.lang.Runnable
        public final void run() {
            InitTaskDispatcher r100 = InitTaskDispatcher.f254510o;
            bf6.f r101 = this.f254511a;
            r100.getClass();
            InitTaskDispatcher.d(r101);
        }

        @Override // com.bytedance.lego.init.m
        public final bf6.f p() {
            return this.f254511a;
        }

        public a(bf6.f r100) {
            this.f254511a = r100;
        }
    }

    static {
        f254496a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitTaskDispatcher.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f254510o = new InitTaskDispatcher();
        f254497b = new InitTaskManager();
        f254498c = LazyKt.lazy(LazyThreadSafetyMode.NONE, InitTaskDispatcher$executor$2.INSTANCE);
        f254501f = new CountDownLatch(1);
        f254502g = new ArrayList();
        f254503h = new ArrayList();
        f254505j = new ArrayList();
        f254506k = new Object();
        f254508m = new CopyOnWriteArrayList();
        f254509n = new Handler(Looper.getMainLooper());
    }

    public InitTaskDispatcher() {
    }

    public static void b() {
    L2:
        InitTaskManager r100 = f254497b;
        bf6.f r101 = InitTaskManager.takeNonUiTaskIfExist$default(r100, null, 1, null);
        if (r101 == null) goto L23;
        if (Intrinsics.areEqual("init_shceduler_internal_task", r101.f18825b) == true) goto L22;
        if (com.bytedance.lego.init.util.e.a(r101) == false) goto L22;
        a r102 = new a(r101);
        if (r101.f18828e == false) goto L14;
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L14;
        f254508m.add(r102);
        int r103 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b(r101.f18824a + " skip directly.");
        r100.onTaskComplete(r101);
    L14:
        Lazy r104 = f254498c;
        KProperty r105 = f254496a[0];
        ((ThreadPoolExecutor) r104.getValue()).execute(r102);
        Object r106 = f254506k;
        monitor-enter(r106);
        ((ArrayList) f254505j).add(r102);     // Catch: Throwable -> L19
        monitor-exit(r106);
    L19:
        th = move-exception;
        throw th;
    L22:
        int r107 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b(r101.f18824a + " complete directly.");
        r100.onTaskComplete(r101);
        goto L2
    L23:
        com.bytedance.lego.init.util.c.c("", "异步调度线程 end.");
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static void d(bf6.f r100) {
        boolean r101 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        int r102 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.c("", "TaskStart - " + r100 + "  isUIThread:" + r101);
        long r103 = System.currentTimeMillis();
        r100.f18835l = r103;
        InitMonitor.INSTANCE.monitorTaskStart(r100, r101);
        com.bytedance.lego.init.util.f.b(r100);
        bf6.d r104 = r100.f18826c;     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r104.run();     // Catch: Exception -> L11
    L19:
        int r105 = com.bytedance.lego.init.util.f.f254573a;
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L23;
        TraceCompat.endSection();
    L23:
        InitMonitor r106 = InitMonitor.INSTANCE;
        r106.monitorTaskEnd(r100, r101);
        r106.monitorCosTime(r100, System.currentTimeMillis() - r103, r101);
        com.bytedance.lego.init.util.c.b("Task " + r100.f18824a + " done. cos " + (System.currentTimeMillis() - r103) + "ms.");
        f254497b.onTaskComplete(r100);
        return;
    L6:
        Object r107 = a(r100.f18825b).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
        if (r107 == null) goto L10;
        ((bf6.d) r107).run();     // Catch: Exception -> L11
        goto L19
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        int r108 = com.bytedance.lego.init.util.c.f254571a;
        e.printStackTrace();
        Objects.toString(Unit.INSTANCE);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L15;
    L18:
        InitMonitor r109 = InitMonitor.INSTANCE;
        r109.ensureNotReachHere(e, "RUN_TASK_EXCEPTION:" + r100.f18825b);
        Category r110 = Category.RUN_TAK_EXCEPTION;
        String r111 = r100.f18825b + ":" + e.getClass().getName();
        JSONObject r112 = new JSONObject();
        r112.put("exception_detail", Log.getStackTraceString(e));
        r109.monitorEvent(r110, r111, r112);
        goto L19
    L15:
        if ((e instanceof ClassNotFoundException) == true) goto L18;
        throw e;
    }

    public static void e(bf6.f r100) {
        InitMonitor r101 = InitMonitor.INSTANCE;
        r101.onTaskTimeout(r100.f18824a);
        Category r102 = Category.TASK_TIMEOUT_EXCEPTION;
        String r103 = r100.f18824a;
        JSONObject r104 = new JSONObject();
        r104.put(DyPayConstant.KEY_START_TIME, r100.f18835l);
        r104.put("curTime", System.currentTimeMillis());
        r101.monitorEvent(r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, bf6.f] */
    /* JADX WARN: Type inference failed for: r0v60, types: [T, bf6.f] */
    public final void c(InitPeriod r110, boolean r210) {
        long r100 = System.currentTimeMillis();
        if (r210 == false) goto L5;
        String r101 = "-END";
    L6:
        String r102 = r101;
        ArrayList r103 = (ArrayList) f254502g;
        if (r103.contains(r110) == true) goto L21;
        Iterator r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L18;
        Object r105 = r104.next();
        if (((InitPeriod) r105).getValue() < r110.getValue()) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L11;
    L20:
        if (((InitPeriod) r105) != null) goto L21;
        if (r210 == false) goto L24;
        ((ArrayList) f254502g).add(r110);
    L24:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L27;
        return;
    L27:
        InitMonitor r108 = InitMonitor.INSTANCE;
        r108.monitorStart(r110.name() + r102, true);
        int r109 = com.bytedance.lego.init.util.f.f254573a;
        com.bytedance.lego.init.util.f.a("onPeriod-" + r110.name() + r102);
        if (f254499d == true) goto L31;
        int r111 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b("wait init countdownlatch " + r110.name());
        long r112 = System.currentTimeMillis();
        f254501f.await();
        r108.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r112, true);
        com.bytedance.lego.init.util.c.a("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r112));
    L31:
        if (f254507l == false) goto L35;
        int r113 = com.bytedance.lego.init.util.c.f254571a;
        return;
    L35:
        if (f254500e == true) goto L38;
        int r114 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.a("InitTaskDispatcher", "startAsyncTask");
        com.bytedance.lego.init.util.f.a("startAsyncTask");
        ThreadMethodProxy.start(new PthreadThreadV2(this, "InitTaskDispatcher"));
        f254500e = true;
        com.bytedance.lego.init.util.f.c();
    L38:
        int r115 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b("onPeriod: " + r110.name() + r102);
    L40:
        if (((ArrayList) f254503h).contains(r110) == true) goto L126;
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        if (r210 == false) goto L102;
        ?? r117 = f254497b.takeUiTaskIfExist(0);
        r116.element = r117;
        if (r117 != 0) goto L69;
        Object r118 = f254506k;
        monitor-enter(r118);
        Iterator r119 = ((ArrayList) f254505j).iterator();     // Catch: Throwable -> L65
    L50:
        if (r119.hasNext() == false) goto L60;
        m r120 = (m) r119.next();     // Catch: Throwable -> L65
        InitTaskManager r121 = f254497b;     // Catch: Throwable -> L65
        float r122 = r121.getPriorityByTaskId(r120.p().f18824a);     // Catch: Throwable -> L65
        if (r122 <= 0) goto L50;
        if (r120.p().f18834k.getValue() > r110.getValue()) goto L50;
        if (r122 <= r121.getPriorityByTaskId(r110.name() + "_END")) goto L50;
        r119.remove();     // Catch: Throwable -> L65
        f254510o.getClass();     // Catch: Throwable -> L65
        Lazy r123 = f254498c;     // Catch: Throwable -> L65
        KProperty r124 = f254496a[0];     // Catch: Throwable -> L65
        if (((ThreadPoolExecutor) r123.getValue()).remove(r120) == false) goto L50;
        int r125 = com.bytedance.lego.init.util.c.f254571a;     // Catch: Throwable -> L65
        com.bytedance.lego.init.util.c.b("execute async-task:" + r120.p().f18824a + " in UIThread.");     // Catch: Throwable -> L65
    L61:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r118);
        if (r120 == null) goto L69;
        r120.run();
        f254504i = System.currentTimeMillis();
        goto L69
    L60:
        r120 = null;
    L65:
        th = move-exception;
        throw th;
    L69:
        if (((bf6.f) r116.element) != null) goto L100;
        if ((System.currentTimeMillis() - f254504i) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L98;
        com.bytedance.lego.init.util.c.b("UIThread wait timeout.");
        f254510o.getClass();
        StringBuilder r127 = new StringBuilder();     // Catch: Exception -> L80
        Iterator<T> r128 = f254497b.getTaskDependencyById(r110.name() + "_END").iterator();     // Catch: Exception -> L80
    L76:
        if (r128.hasNext() == false) goto L78;
        r127.append(((String) r128.next()) + ' ');     // Catch: Exception -> L80
        goto L76
    L78:
        InitMonitor r129 = InitMonitor.INSTANCE;     // Catch: Exception -> L80
        Category r130 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L80
        String r131 = r110.name();     // Catch: Exception -> L80
        JSONObject r132 = new JSONObject();     // Catch: Exception -> L80
        r132.put("dependencyTasks", r127.toString());     // Catch: Exception -> L80
        r129.monitorEvent(r130, r131, r132);     // Catch: Exception -> L80
    L128:
        Iterator<T> r133 = f254497b.getTaskDependencyById(r110.name() + "_END").iterator();     // Catch: Exception -> L93
    L84:
        if (r133.hasNext() == false) goto L98;
        String r134 = (String) r133.next();     // Catch: Exception -> L93
        InitTaskManager r135 = f254497b;     // Catch: Exception -> L93
        bf6.f r136 = r135.getInitTaskInfoById(r134);     // Catch: Exception -> L93
        if (r136 == null) goto L84;
        long r137 = System.currentTimeMillis() - r136.f18835l;     // Catch: Exception -> L93
        if (r136.f18835l <= 0) goto L84;
        if (r137 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L84;
        r135.onTaskComplete(r136);     // Catch: Exception -> L93
        f254510o.getClass();     // Catch: Exception -> L93
        e(r136);     // Catch: Exception -> L93
        int r138 = com.bytedance.lego.init.util.c.f254571a;     // Catch: Exception -> L93
        com.bytedance.lego.init.util.c.b("Task " + r136.f18824a + " timeout, is forced to complete.");     // Catch: Exception -> L93
    L93:
        e = move-exception;
        e.printStackTrace();
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L97;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "letTimeoutTaskCompele");
        goto L98
    L97:
        throw e;
    L80:
        e = move-exception;
        e.printStackTrace();
        InitMonitor.INSTANCE.ensureNotReachHere(e, "sendPeriodTimeoutException");
    L98:
        Unit r139 = Unit.INSTANCE;
    L100:
        if (((bf6.f) r116.element) == null) goto L40;
    L105:
        long r140 = System.currentTimeMillis();
        if (Intrinsics.areEqual("init_shceduler_internal_task", ((bf6.f) r116.element).f18825b) == false) goto L108;
    L116:
        int r141 = com.bytedance.lego.init.util.f.f254573a;
        com.bytedance.lego.init.util.f.b((bf6.f) r116.element);
        int r142 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b(((bf6.f) r116.element).f18824a + " complete directly. cos " + (System.currentTimeMillis() - r140) + "ms");
        f254497b.onTaskComplete((bf6.f) r116.element);
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L121;
        TraceCompat.endSection();
    L121:
        if (Intrinsics.areEqual("init_shceduler_internal_task", ((bf6.f) r116.element).f18825b) == true) goto L123;
    L125:
        f254504i = System.currentTimeMillis();
        goto L40
    L123:
        if (Intrinsics.areEqual(r110.name() + "_END", ((bf6.f) r116.element).f18824a) == false) goto L125;
        InitMonitor.INSTANCE.monitorCosTime("wait: " + r110.name(), System.currentTimeMillis() - f254504i, true);
        com.bytedance.lego.init.util.c.b("wait: " + r110.name() + ' ' + (System.currentTimeMillis() - f254504i) + "ms.");
        ((ArrayList) f254503h).add(r110);
        goto L126
    L108:
        if (com.bytedance.lego.init.util.e.a((bf6.f) r116.element) == false) goto L116;
        if (((bf6.f) r116.element).f18828e == true) goto L113;
    L115:
        d((bf6.f) r116.element);
        goto L125
    L113:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L115;
        f254508m.add(new k(r116));
        int r143 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.b(((bf6.f) r116.element).f18824a + " skip directly.");
        f254497b.onTaskComplete((bf6.f) r116.element);
        goto L125
    L102:
        ?? r144 = f254497b.takeUiTaskIfExist(0);
        if (r144 == 0) goto L126;
        r116.element = r144;
    L126:
        com.bytedance.lego.init.util.f.c();
        InitMonitor r145 = InitMonitor.INSTANCE;
        r145.monitorEnd(r110.name() + r102, true);
        r145.monitorCosTime("onPeriod-" + r110.name() + r102, System.currentTimeMillis() - r100, true);
        return;
    L15:
        r106 = false;
        goto L16
    L18:
        r105 = null;
    L21:
        r107 = false;
        goto L25
    L5:
        r101 = "-START";
        goto L6
    }
}
