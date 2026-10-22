package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.TraceCompat;
import bf6.d;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.c;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import el9.a;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class InitTaskDispatcher implements Runnable {
    public static final /* synthetic */ KProperty[] a = null;
    public static final InitTaskManager b = null;
    public static final Lazy c = null;
    public static boolean d;
    public static boolean e;
    public static final CountDownLatch f = null;
    public static final List<InitPeriod> g = null;
    public static final List<InitPeriod> h = null;
    public static long i;
    public static final List<m> j = null;
    public static final Object k = null;
    public static boolean l;
    public static final CopyOnWriteArrayList<m> m = null;
    public static final Handler n = null;
    public static final InitTaskDispatcher o = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitTaskDispatcher.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        o = new InitTaskDispatcher();
        b = new InitTaskManager();
        c = LazyKt.lazy(LazyThreadSafetyMode.NONE, InitTaskDispatcher$executor$2.INSTANCE);
        f = new CountDownLatch(1);
        g = new ArrayList();
        h = new ArrayList();
        j = new ArrayList();
        k = new Object();
        m = new CopyOnWriteArrayList();
        n = new Handler(Looper.getMainLooper());
    }

    public InitTaskDispatcher() {
    }

    public static void b() {
    L2:
        InitTaskManager r0 = b;
        bf6.f r1 = InitTaskManager.takeNonUiTaskIfExist$default(r0, null, 1, null);
        if (r1 == null) goto L23;
        if (Intrinsics.areEqual("init_shceduler_internal_task", r1.b) == true) goto L22;
        if (com.bytedance.lego.init.util.e.a(r1) == false) goto L22;
        m r2 = new a(r1);
        if (r1.e == false) goto L14;
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L14;
        m.add(r2);
        int r3 = c.a;
        c.b(r1.a + " skip directly.");
        r0.onTaskComplete(r1);
    L14:
        Lazy r4 = c;
        KProperty r5 = a[0];
        ((ThreadPoolExecutor) r4.getValue()).execute(r2);
        Object r6 = k;
        monitor-enter(r6);
        ((ArrayList) j).add(r2);     // Catch: Throwable -> L19
        monitor-exit(r6);
    L19:
        th = move-exception;
        throw th;
    L22:
        int r7 = c.a;
        c.b(r1.a + " complete directly.");
        r0.onTaskComplete(r1);
        goto L2
    L23:
        c.c(XmlPullParser.NO_NAMESPACE, "异步调度线程 end.");
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
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void d(bf6.f r9) {
        boolean r0 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        int r1 = c.a;
        c.c(XmlPullParser.NO_NAMESPACE, "TaskStart - " + r9 + "  isUIThread:" + r0);
        long r2 = System.currentTimeMillis();
        r9.l = r2;
        InitMonitor.INSTANCE.monitorTaskStart(r9, r0);
        com.bytedance.lego.init.util.f.b(r9);
        d r3 = r9.c;     // Catch: Exception -> L11
        if (r3 == null) goto L6;
        r3.run();     // Catch: Exception -> L11
    L19:
        int r4 = com.bytedance.lego.init.util.f.a;
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L23;
        TraceCompat.endSection();
    L23:
        InitMonitor r5 = InitMonitor.INSTANCE;
        r5.monitorTaskEnd(r9, r0);
        r5.monitorCosTime(r9, System.currentTimeMillis() - r2, r0);
        c.b("Task " + r9.a + " done. cos " + (System.currentTimeMillis() - r2) + "ms.");
        b.onTaskComplete(r9);
        return;
    L6:
        Object r6 = a(r9.b).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
        if (r6 == null) goto L10;
        ((d) r6).run();     // Catch: Exception -> L11
        goto L19
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        int r7 = c.a;
        e.printStackTrace();
        Objects.toString(Unit.INSTANCE);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L15;
    L18:
        InitMonitor r8 = InitMonitor.INSTANCE;
        r8.ensureNotReachHere(e, "RUN_TASK_EXCEPTION:" + r9.b);
        Category r10 = Category.RUN_TAK_EXCEPTION;
        String r11 = r9.b + ":" + e.getClass().getName();
        JSONObject r12 = new JSONObject();
        r12.put("exception_detail", Log.getStackTraceString(e));
        r8.monitorEvent(r10, r11, r12);
        goto L19
    L15:
        if ((e instanceof ClassNotFoundException) == true) goto L18;
        throw e;
    }

    public static void e(bf6.f r7) {
        InitMonitor r0 = InitMonitor.INSTANCE;
        r0.onTaskTimeout(r7.a);
        Category r1 = Category.TASK_TIMEOUT_EXCEPTION;
        String r2 = r7.a;
        JSONObject r3 = new JSONObject();
        r3.put("startTime", r7.l);
        r3.put("curTime", System.currentTimeMillis());
        r0.monitorEvent(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, bf6.f] */
    /* JADX WARN: Type inference failed for: r0v60, types: [T, bf6.f] */
    public final void c(InitPeriod r19, boolean r20) {
        long r2 = System.currentTimeMillis();
        if (r20 == false) goto L5;
        String r0 = "-END";
    L6:
        String r4 = r0;
        ArrayList r1 = (ArrayList) g;
        if (r1.contains(r19) == true) goto L21;
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        if (((InitPeriod) r5).getValue() < r19.getValue()) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L11;
    L20:
        if (((InitPeriod) r5) != null) goto L21;
        if (r20 == false) goto L24;
        ((ArrayList) g).add(r19);
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L27;
        return;
    L27:
        InitMonitor r7 = InitMonitor.INSTANCE;
        r7.monitorStart(r19.name() + r4, true);
        int r9 = com.bytedance.lego.init.util.f.a;
        com.bytedance.lego.init.util.f.a("onPeriod-" + r19.name() + r4);
        if (d == true) goto L31;
        int r10 = c.a;
        c.b("wait init countdownlatch " + r19.name());
        long r11 = System.currentTimeMillis();
        f.await();
        r7.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - r11, true);
        c.a("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - r11));
    L31:
        if (l == false) goto L35;
        int r12 = c.a;
        return;
    L35:
        if (e == true) goto L38;
        int r13 = c.a;
        c.a("InitTaskDispatcher", "startAsyncTask");
        com.bytedance.lego.init.util.f.a("startAsyncTask");
        ThreadMethodProxy.start(new PthreadThreadV2(this, "InitTaskDispatcher"));
        e = true;
        com.bytedance.lego.init.util.f.c();
    L38:
        int r14 = c.a;
        c.b("onPeriod: " + r19.name() + r4);
    L40:
        if (((ArrayList) h).contains(r19) == true) goto L126;
        Ref$ObjectRef r15 = new Ref$ObjectRef();
        if (r20 == false) goto L102;
        ?? r16 = b.takeUiTaskIfExist(0);
        r15.element = r16;
        if (r16 != 0) goto L69;
        Object r17 = k;
        monitor-enter(r17);
        Iterator r18 = ((ArrayList) j).iterator();     // Catch: Throwable -> L65
    L50:
        if (r18.hasNext() == false) goto L60;
        Runnable r110 = (m) r18.next();     // Catch: Throwable -> L65
        InitTaskManager r111 = b;     // Catch: Throwable -> L65
        float r112 = r111.getPriorityByTaskId(r110.p().a);     // Catch: Throwable -> L65
        if (r112 <= 0) goto L50;
        if (r110.p().k.getValue() > r19.getValue()) goto L50;
        if (r112 <= r111.getPriorityByTaskId(r19.name() + "_END")) goto L50;
        r18.remove();     // Catch: Throwable -> L65
        o.getClass();     // Catch: Throwable -> L65
        Lazy r113 = c;     // Catch: Throwable -> L65
        KProperty r114 = a[0];     // Catch: Throwable -> L65
        if (((ThreadPoolExecutor) r113.getValue()).remove(r110) == false) goto L50;
        int r21 = c.a;     // Catch: Throwable -> L65
        c.b("execute async-task:" + r110.p().a + " in UIThread.");     // Catch: Throwable -> L65
    L61:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r17);
        if (r110 == null) goto L69;
        r110.run();
        i = System.currentTimeMillis();
        goto L69
    L60:
        r110 = null;
    L65:
        th = move-exception;
        throw th;
    L69:
        if (((bf6.f) r15.element) != null) goto L100;
        if ((System.currentTimeMillis() - i) < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L98;
        c.b("UIThread wait timeout.");
        o.getClass();
        StringBuilder r23 = new StringBuilder();     // Catch: Exception -> L80
        Iterator<T> r24 = b.getTaskDependencyById(r19.name() + "_END").iterator();     // Catch: Exception -> L80
    L76:
        if (r24.hasNext() == false) goto L78;
        r23.append(((String) r24.next()) + ' ');     // Catch: Exception -> L80
        goto L76
    L78:
        InitMonitor r25 = InitMonitor.INSTANCE;     // Catch: Exception -> L80
        Category r115 = Category.PERIOD_TIMEOUT_EXCEPTION;     // Catch: Exception -> L80
        String r116 = r19.name();     // Catch: Exception -> L80
        JSONObject r117 = new JSONObject();     // Catch: Exception -> L80
        r117.put("dependencyTasks", r23.toString());     // Catch: Exception -> L80
        r25.monitorEvent(r115, r116, r117);     // Catch: Exception -> L80
    L128:
        Iterator<T> r26 = b.getTaskDependencyById(r19.name() + "_END").iterator();     // Catch: Exception -> L93
    L84:
        if (r26.hasNext() == false) goto L98;
        String r28 = (String) r26.next();     // Catch: Exception -> L93
        InitTaskManager r118 = b;     // Catch: Exception -> L93
        bf6.f r29 = r118.getInitTaskInfoById(r28);     // Catch: Exception -> L93
        if (r29 == null) goto L84;
        long r119 = System.currentTimeMillis() - r29.l;     // Catch: Exception -> L93
        if (r29.l <= 0) goto L84;
        if (r119 < InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) goto L84;
        r118.onTaskComplete(r29);     // Catch: Exception -> L93
        o.getClass();     // Catch: Exception -> L93
        e(r29);     // Catch: Exception -> L93
        int r30 = c.a;     // Catch: Exception -> L93
        c.b("Task " + r29.a + " timeout, is forced to complete.");     // Catch: Exception -> L93
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
        Unit r31 = Unit.INSTANCE;
    L100:
        if (((bf6.f) r15.element) == null) goto L40;
    L105:
        long r32 = System.currentTimeMillis();
        if (Intrinsics.areEqual("init_shceduler_internal_task", ((bf6.f) r15.element).b) == false) goto L108;
    L116:
        int r33 = com.bytedance.lego.init.util.f.a;
        com.bytedance.lego.init.util.f.b((bf6.f) r15.element);
        int r34 = c.a;
        c.b(((bf6.f) r15.element).a + " complete directly. cos " + (System.currentTimeMillis() - r32) + "ms");
        b.onTaskComplete((bf6.f) r15.element);
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L121;
        TraceCompat.endSection();
    L121:
        if (Intrinsics.areEqual("init_shceduler_internal_task", ((bf6.f) r15.element).b) == true) goto L123;
    L125:
        i = System.currentTimeMillis();
        goto L40
    L123:
        if (Intrinsics.areEqual(r19.name() + "_END", ((bf6.f) r15.element).a) == false) goto L125;
        InitMonitor.INSTANCE.monitorCosTime("wait: " + r19.name(), System.currentTimeMillis() - i, true);
        c.b("wait: " + r19.name() + ' ' + (System.currentTimeMillis() - i) + "ms.");
        ((ArrayList) h).add(r19);
        goto L126
    L108:
        if (com.bytedance.lego.init.util.e.a((bf6.f) r15.element) == false) goto L116;
        if (((bf6.f) r15.element).e == true) goto L113;
    L115:
        d((bf6.f) r15.element);
        goto L125
    L113:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow() == true) goto L115;
        m.add(new k(r15));
        int r35 = c.a;
        c.b(((bf6.f) r15.element).a + " skip directly.");
        b.onTaskComplete((bf6.f) r15.element);
        goto L125
    L102:
        ?? r36 = b.takeUiTaskIfExist(0);
        if (r36 == 0) goto L126;
        r15.element = r36;
    L126:
        com.bytedance.lego.init.util.f.c();
        InitMonitor r37 = InitMonitor.INSTANCE;
        r37.monitorEnd(r19.name() + r4, true);
        r37.monitorCosTime("onPeriod-" + r19.name() + r4, System.currentTimeMillis() - r2, true);
        return;
    L15:
        r8 = false;
        goto L16
    L18:
        r5 = null;
    L21:
        r6 = false;
        goto L25
    L5:
        r0 = "-START";
        goto L6
    }
}
