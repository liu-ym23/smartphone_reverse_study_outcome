package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import bf6.g;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.generate.PeriodTaskCollector__android_app;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.c;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0004H\u0001¢\u0006\u0004\b!\u0010\u001fJ\b\u0010#\u001a\u00020\u0004H\u0007J\u000f\u0010'\u001a\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010*\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0011\u0010,\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b+\u0010)J\u000f\u00100\u001a\u00020-H\u0000¢\u0006\u0004\b.\u0010/J\u0006\u00101\u001a\u00020$R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0000X\u0080D¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", XmlPullParser.NO_NAMESPACE, "Lcom/bytedance/lego/init/config/TaskConfig;", "config", XmlPullParser.NO_NAMESPACE, "Lcom/bytedance/lego/init/f;", "proxy", "setServiceManagerProxy", "initTasks", "initPeriodTask", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "Lcom/bytedance/lego/init/model/InitPeriod;", "period", "onPeriodStart", "onPeriodEnd", "startDispatchDelayTask", "startDispatchIdleTask", "onFeedShow", "Landroid/app/Activity;", "mainActivity", "registerMainActivity", "splashActivity", "registerSplashActivity", "getMainActivity$initscheduler_release", "()Landroid/app/Activity;", "getMainActivity", "getSplashActivity$initscheduler_release", "getSplashActivity", "unRegisterMainActivity$initscheduler_release", "()V", "unRegisterMainActivity", "unRegisterSplashActivity$initscheduler_release", "unRegisterSplashActivity", "afterPrivacyPopupWindow", XmlPullParser.NO_NAMESPACE, "isDebug$initscheduler_release", "()Z", "isDebug", "getExecutorService$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutorService", "getExecutorServiceOrNull$initscheduler_release", "getExecutorServiceOrNull", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode", "enableCatchException", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "Ljava/lang/ref/WeakReference;", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "splashActivityWR", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", XmlPullParser.NO_NAMESPACE, "INIT_SCHEDULER_CATEGORY", "Ljava/lang/String;", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "<init>", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class InitScheduler {
    private static final String INIT_SCHEDULER_CATEGORY = "init_scheduler";
    public static final InitScheduler INSTANCE = null;
    public static TaskConfig config;
    private static WeakReference<Activity> mainActivityWR;
    private static WeakReference<Activity> splashActivityWR;
    private static ThreadPoolExecutor taskExecutor;

    private InitScheduler() {
    }

    static {
        INSTANCE = new InitScheduler();
        INIT_SCHEDULER_CATEGORY = "init_scheduler";
    }

    @JvmStatic
    public static final void afterPrivacyPopupWindow() {
        InitTaskDispatcher.o.getClass();     // Catch: Exception -> L4
        c.b("startPrivacyTask");     // Catch: Exception -> L4
        j.a(InitTaskDispatcher.startPrivacyTask.1.INSTANCE);     // Catch: Exception -> L4
    L8:
        TaskConfig r0 = config;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L11:
        r0.setAgreePrivacyPopupWindow(true);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        goto L8
    L13:
        throw e;
    }

    @JvmStatic
    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @JvmStatic
    public static final void initPeriodTask() {
        com.bytedance.lego.init.util.f.a("initPeriodTask");
        Map<ExecutionPeriod, List<g>> r0 = l.a;
        if (o.d != null) goto L11;
        o.d = new ArrayList();
        ArrayList r1 = (ArrayList) o.a;
        if (r1.isEmpty() == false) goto L7;
        r1.clear();
        r1.add(new PeriodTaskCollector__android_app());
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((e) r2.next()).collectPeriodTask(o.d);
    L11:
        Iterator r3 = ((ArrayList) o.d).iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        g r4 = (g) r3.next();
        Map<ExecutionPeriod, List<g>> r5 = l.a;
        r4.getClass();
        List<g> r6 = (List) ((LinkedHashMap) r5).get(ExecutionPeriod.from(null));
        if (r6 != null) goto L18;
        r6 = new ArrayList();
        r5.put(ExecutionPeriod.from(null), r6);
        Unit r7 = Unit.INSTANCE;
    L18:
        r6.add(r4);
        goto L13
    L20:
        if (INSTANCE.isDebug$initscheduler_release() == false) goto L33;
        StringBuilder r8 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator r9 = ((LinkedHashMap) l.a).entrySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L32;
        Map.Entry r10 = (Map.Entry) r9.next();
        if ((!((Collection) r10.getValue()).isEmpty()) == false) goto L24;
        r8.append(((ExecutionPeriod) r10.getKey()).name() + ": ");
        Iterator r11 = ((Iterable) r10.getValue()).iterator();
    L29:
        if (r11.hasNext() == false) goto L31;
        ((g) r11.next()).getClass();
        r8.append("null ");
        goto L29
    L31:
        r8.append("\n");
        goto L24
    L32:
        int r12 = c.a;
        c.a("PeriodTaskManager", r8.toString());
    L33:
        Unit r13 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
    }

    @JvmStatic
    public static final void initTasks() {
        com.bytedance.lego.init.util.f.a("initTasks");
        InitTaskDispatcher.o.getClass();
        if (InitTaskDispatcher.d == true) goto L11;
        long r0 = System.currentTimeMillis();
        int r2 = c.a;
        InitScheduler r3 = INSTANCE;
        if (r3.isDebug$initscheduler_release() == false) goto L8;
        c.c("InitTaskDispatcher", "InitTaskDispatcher.init start");
    L8:
        InitMonitor r4 = InitMonitor.INSTANCE;
        r4.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        com.bytedance.lego.init.util.f.a("InitTaskDispatcher.initInternal");
        InitTaskDispatcher.b.init();
        InitTaskDispatcher.d = true;
        InitTaskDispatcher.f.countDown();
        Unit r7 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
        r4.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        r4.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - r0, false);
        if (r3.isDebug$initscheduler_release() == false) goto L11;
        c.a("InitTaskDispatcher", "InitTaskDispatcher.init done. cos: " + (System.currentTimeMillis() - r0) + "ms.");
    L11:
        Unit r1 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
    }

    @JvmStatic
    public static final void onFeedShow() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        b r1 = b.d;     // Catch: Exception -> L19
        monitor-enter(r1);     // Catch: Exception -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L9:
        if (b.c == false) goto L13;
        monitor-exit(r1);     // Catch: Exception -> L19
        return;
    L13:
        b.c = true;     // Catch: Throwable -> L16
        ThreadMethodProxy.start(new PthreadThreadV2(a.a, "A-FeedShowTaskDispatcher"));     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L24;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_FEED_SHOW_TASK_DISPATCHER");
        return;
    L24:
        throw e;
    }

    @JvmStatic
    public static final void startDispatchDelayTask() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        DelayTaskDispatcher.h.c();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L13;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
        return;
    L13:
        throw e;
    }

    @JvmStatic
    public static final void startDispatchIdleTask() {
        IdleTaskConfig r0 = h.a;     // Catch: Exception -> L4
        h.a();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (INSTANCE.enableCatchException() == false) goto L9;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "START_IDLE_TASK_DISPATCHER");
        return;
    L9:
        throw e;
    }

    @JvmStatic
    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> r0 = mainActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r0 = splashActivityWR;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r0 = config;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r0.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        return r0;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r0 = taskExecutor;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0;
    L7:
        TaskConfig r1 = config;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        ThreadPoolExecutor r2 = r1.getTaskExecutor();
        if (r2 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r2;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r0 = taskExecutor;
        if (r0 == null) goto L13;
        return r0;
    L13:
        TaskConfig r1 = config;     // Catch: Exception -> L10
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L10
    L8:
        return r1.getTaskExecutor();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r0 = config;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r0.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r0 = config;     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L7
    L5:
        return r0.isDebug();
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    @JvmStatic
    public static final void config(TaskConfig r4) {
        config = r4;
        IdleTaskConfig r0 = h.a;
        IdleTaskConfig r1 = r4.getIdleTaskConfig();
        if (INSTANCE.getConfig$initscheduler_release().isMainProcess() == false) goto L8;
        h.g = false;
        h.a = r1;
        if (r1.getAutoIdleTask() == false) goto L8;
        h.f.postDelayed(g.a, h.a.getBootFinishTimeOut());
    L8:
        IdleTaskMonitor r2 = IdleTaskMonitor.e;
        long r3 = r4.getApplicationStartTime();
        r2.getClass();
        IdleTaskMonitor.d = r3;
    }

    @JvmStatic
    public static final void onPeriodEnd(InitPeriod r7) {
        InitTaskDispatcher.o.c(r7, true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r1 = InitMonitor.INSTANCE;
        Category r2 = Category.ON_PERIOD_EXCEPTION;
        String r3 = r7.name();
        JSONObject r4 = new JSONObject();
        r4.put("exception_detail", Log.getStackTraceString(e));
        r1.monitorEvent(r2, r3, r4);
        TaskConfig r5 = config;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L9:
        if (r5.getCatchException() == false) goto L12;
        r1.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r7.name());
        return;
    L12:
        throw e;
    }

    @JvmStatic
    public static final void onPeriodStart(InitPeriod r8) {
        TaskConfig r0 = config;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r0.isDebug();
        InitTaskDispatcher.o.c(r8, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r2 = InitMonitor.INSTANCE;
        Category r3 = Category.ON_PERIOD_EXCEPTION;
        String r4 = r8.name();
        JSONObject r5 = new JSONObject();
        r5.put("exception_detail", Log.getStackTraceString(e));
        r2.monitorEvent(r3, r4, r5);
        TaskConfig r6 = config;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L13:
        if (r6.getCatchException() == false) goto L16;
        r2.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r8.name());
        return;
    L16:
        throw e;
    }

    @JvmStatic
    public static final void registerMainActivity(Activity r2) {
        mainActivityWR = new WeakReference(r2);
        boolean r0 = r2 instanceof LifecycleOwner;
        Lifecycle r1 = null;
        Object r3 = r2;
        if (r0 == true) goto L5;
        r3 = null;
    L5:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 == null) goto L8;
        r1 = r4.getLifecycle();
    L8:
        if (r1 == null) goto L12;
        Map<ExecutionPeriod, List<g>> r5 = l.a;
        r1.addObserver(new PeriodTaskManager.registerMain.1());
        return;
    L12:
        throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity r2) {
        splashActivityWR = new WeakReference(r2);
        boolean r0 = r2 instanceof LifecycleOwner;
        Lifecycle r1 = null;
        Object r3 = r2;
        if (r0 == true) goto L5;
        r3 = null;
    L5:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 == null) goto L8;
        r1 = r4.getLifecycle();
    L8:
        if (r1 == null) goto L12;
        Map<ExecutionPeriod, List<g>> r5 = l.a;
        r1.addObserver(new PeriodTaskManager.registerSplash.1());
        return;
    L12:
        throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor r0) {
        taskExecutor = r0;
    }

    @JvmStatic
    public static final void setServiceManagerProxy(f r1) {
        f r0 = n.a;
        n.a = r1;
    }

    public final void setConfig$initscheduler_release(TaskConfig r1) {
        config = r1;
    }
}
