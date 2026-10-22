package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.generate.PeriodTaskCollector__android_app;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0004H\u0001¢\u0006\u0004\b!\u0010\u001fJ\b\u0010#\u001a\u00020\u0004H\u0007J\u000f\u0010'\u001a\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010*\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0011\u0010,\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b+\u0010)J\u000f\u00100\u001a\u00020-H\u0000¢\u0006\u0004\b.\u0010/J\u0006\u00101\u001a\u00020$R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0000X\u0080D¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "Lcom/bytedance/lego/init/config/TaskConfig;", "config", "", "Lcom/bytedance/lego/init/f;", "proxy", "setServiceManagerProxy", "initTasks", "initPeriodTask", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "Lcom/bytedance/lego/init/model/InitPeriod;", "period", "onPeriodStart", "onPeriodEnd", "startDispatchDelayTask", "startDispatchIdleTask", "onFeedShow", "Landroid/app/Activity;", "mainActivity", "registerMainActivity", "splashActivity", "registerSplashActivity", "getMainActivity$initscheduler_release", "()Landroid/app/Activity;", "getMainActivity", "getSplashActivity$initscheduler_release", "getSplashActivity", "unRegisterMainActivity$initscheduler_release", "()V", "unRegisterMainActivity", "unRegisterSplashActivity$initscheduler_release", "unRegisterSplashActivity", "afterPrivacyPopupWindow", "", "isDebug$initscheduler_release", "()Z", "isDebug", "getExecutorService$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutorService", "getExecutorServiceOrNull$initscheduler_release", "getExecutorServiceOrNull", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode", "enableCatchException", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "Ljava/lang/ref/WeakReference;", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "splashActivityWR", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "INIT_SCHEDULER_CATEGORY", "Ljava/lang/String;", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "<init>", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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
        InitTaskDispatcher.f254510o.getClass();     // Catch: Exception -> L4
        com.bytedance.lego.init.util.c.b("startPrivacyTask");     // Catch: Exception -> L4
        j.a(InitTaskDispatcher$startPrivacyTask$1.INSTANCE);     // Catch: Exception -> L4
    L8:
        TaskConfig r100 = config;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L11:
        r100.setAgreePrivacyPopupWindow(true);
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
        WeakReference<Activity> r100 = mainActivityWR;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> r100 = splashActivityWR;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @JvmStatic
    public static final void initPeriodTask() {
        com.bytedance.lego.init.util.f.a("initPeriodTask");
        Map<ExecutionPeriod, List<bf6.g>> r100 = l.f254532a;
        if (o.f254556d != null) goto L11;
        o.f254556d = new ArrayList();
        ArrayList r101 = (ArrayList) o.f254553a;
        if (r101.isEmpty() == false) goto L7;
        r101.clear();
        r101.add(new PeriodTaskCollector__android_app());
    L7:
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((e) r102.next()).collectPeriodTask(o.f254556d);
    L11:
        Iterator r103 = ((ArrayList) o.f254556d).iterator();
    L13:
        if (r103.hasNext() == false) goto L20;
        bf6.g r104 = (bf6.g) r103.next();
        Map<ExecutionPeriod, List<bf6.g>> r105 = l.f254532a;
        r104.getClass();
        List<bf6.g> r106 = (List) ((LinkedHashMap) r105).get(ExecutionPeriod.from(null));
        if (r106 != null) goto L18;
        r106 = new ArrayList();
        r105.put(ExecutionPeriod.from(null), r106);
        Unit r107 = Unit.INSTANCE;
    L18:
        r106.add(r104);
        goto L13
    L20:
        if (INSTANCE.isDebug$initscheduler_release() == false) goto L33;
        StringBuilder r108 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator r109 = ((LinkedHashMap) l.f254532a).entrySet().iterator();
    L24:
        if (r109.hasNext() == false) goto L32;
        Map.Entry r110 = (Map.Entry) r109.next();
        if ((!((Collection) r110.getValue()).isEmpty()) == false) goto L24;
        r108.append(((ExecutionPeriod) r110.getKey()).name() + ": ");
        Iterator r111 = ((Iterable) r110.getValue()).iterator();
    L29:
        if (r111.hasNext() == false) goto L31;
        ((bf6.g) r111.next()).getClass();
        r108.append("null ");
        goto L29
    L31:
        r108.append("\n");
        goto L24
    L32:
        int r112 = com.bytedance.lego.init.util.c.f254571a;
        com.bytedance.lego.init.util.c.a("PeriodTaskManager", r108.toString());
    L33:
        Unit r113 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
    }

    @JvmStatic
    public static final void initTasks() {
        com.bytedance.lego.init.util.f.a("initTasks");
        InitTaskDispatcher.f254510o.getClass();
        if (InitTaskDispatcher.f254499d == true) goto L11;
        long r100 = System.currentTimeMillis();
        int r101 = com.bytedance.lego.init.util.c.f254571a;
        InitScheduler r102 = INSTANCE;
        if (r102.isDebug$initscheduler_release() == false) goto L8;
        com.bytedance.lego.init.util.c.c("InitTaskDispatcher", "InitTaskDispatcher.init start");
    L8:
        InitMonitor r103 = InitMonitor.INSTANCE;
        r103.monitorStart("InitTaskDispatcher.init", false);
        com.bytedance.lego.init.util.f.a("InitTaskDispatcher.initInternal");
        InitTaskDispatcher.f254497b.init();
        InitTaskDispatcher.f254499d = true;
        InitTaskDispatcher.f254501f.countDown();
        Unit r104 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
        r103.monitorEnd("InitTaskDispatcher.init", false);
        r103.monitorCosTime("InitTaskDispatcher.init", System.currentTimeMillis() - r100, false);
        if (r102.isDebug$initscheduler_release() == false) goto L11;
        com.bytedance.lego.init.util.c.a("InitTaskDispatcher", "InitTaskDispatcher.init done. cos: " + (System.currentTimeMillis() - r100) + "ms.");
    L11:
        Unit r105 = Unit.INSTANCE;
        com.bytedance.lego.init.util.f.c();
    }

    @JvmStatic
    public static final void onFeedShow() {
        TaskConfig r100 = config;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r100.isDebug();
        b r101 = b.f254519d;     // Catch: Exception -> L19
        monitor-enter(r101);     // Catch: Exception -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L9:
        if (b.f254518c == false) goto L13;
        monitor-exit(r101);     // Catch: Exception -> L19
        return;
    L13:
        b.f254518c = true;     // Catch: Throwable -> L16
        ThreadMethodProxy.start(new PthreadThreadV2(a.f254514a, "A-FeedShowTaskDispatcher"));     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Exception -> L19
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
        TaskConfig r100 = config;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r100.isDebug();
        DelayTaskDispatcher.f254489h.c();     // Catch: Exception -> L8
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
        IdleTaskConfig r100 = h.f254522a;     // Catch: Exception -> L4
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
        WeakReference<Activity> r100 = mainActivityWR;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> r100 = splashActivityWR;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public final boolean enableCatchException() {
        TaskConfig r100 = config;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r100.getCatchException();
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig r100 = config;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        return r100;
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor r100 = taskExecutor;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r100;
    L7:
        TaskConfig r101 = config;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L10:
        ThreadPoolExecutor r102 = r101.getTaskExecutor();
        if (r102 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r102;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor r100 = taskExecutor;
        if (r100 == null) goto L13;
        return r100;
    L13:
        TaskConfig r101 = config;     // Catch: Exception -> L10
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L10
    L8:
        return r101.getTaskExecutor();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig r100 = config;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L6:
        return r100.getMode();
    }

    public final boolean isDebug$initscheduler_release() {
        TaskConfig r100 = config;     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Exception -> L7
    L5:
        return r100.isDebug();
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    @JvmStatic
    public static final void config(TaskConfig r100) {
        config = r100;
        IdleTaskConfig r101 = h.f254522a;
        IdleTaskConfig r102 = r100.getIdleTaskConfig();
        if (INSTANCE.getConfig$initscheduler_release().isMainProcess() == false) goto L8;
        h.f254528g = false;
        h.f254522a = r102;
        if (r102.getAutoIdleTask() == false) goto L8;
        h.f254527f.postDelayed(g.f254521a, h.f254522a.getBootFinishTimeOut());
    L8:
        IdleTaskMonitor r103 = IdleTaskMonitor.f254541e;
        long r104 = r100.getApplicationStartTime();
        r103.getClass();
        IdleTaskMonitor.f254540d = r104;
    }

    @JvmStatic
    public static final void onPeriodEnd(InitPeriod r100) {
        InitTaskDispatcher.f254510o.c(r100, true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r101 = InitMonitor.INSTANCE;
        Category r102 = Category.ON_PERIOD_EXCEPTION;
        String r103 = r100.name();
        JSONObject r104 = new JSONObject();
        r104.put("exception_detail", Log.getStackTraceString(e));
        r101.monitorEvent(r102, r103, r104);
        TaskConfig r105 = config;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L9:
        if (r105.getCatchException() == false) goto L12;
        r101.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r100.name());
        return;
    L12:
        throw e;
    }

    @JvmStatic
    public static final void onPeriodStart(InitPeriod r100) {
        TaskConfig r101 = config;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L5:
        r101.isDebug();
        InitTaskDispatcher.f254510o.c(r100, false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        InitMonitor r102 = InitMonitor.INSTANCE;
        Category r103 = Category.ON_PERIOD_EXCEPTION;
        String r104 = r100.name();
        JSONObject r105 = new JSONObject();
        r105.put("exception_detail", Log.getStackTraceString(e));
        r102.monitorEvent(r103, r104, r105);
        TaskConfig r106 = config;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L13:
        if (r106.getCatchException() == false) goto L16;
        r102.ensureNotReachHere(e, "ON_PERIOD_EXCEPTION:" + r100.name());
        return;
    L16:
        throw e;
    }

    @JvmStatic
    public static final void registerMainActivity(Activity r100) {
        mainActivityWR = new WeakReference(r100);
        boolean r101 = r100 instanceof LifecycleOwner;
        Lifecycle r102 = null;
        Object r103 = r100;
        if (r101 == true) goto L5;
        r103 = null;
    L5:
        LifecycleOwner r104 = (LifecycleOwner) r103;
        if (r104 == null) goto L8;
        r102 = r104.getLifecycle();
    L8:
        if (r102 == null) goto L12;
        Map<ExecutionPeriod, List<bf6.g>> r105 = l.f254532a;
        r102.addObserver(new PeriodTaskManager$registerMain$1());
        return;
    L12:
        throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity r100) {
        splashActivityWR = new WeakReference(r100);
        boolean r101 = r100 instanceof LifecycleOwner;
        Lifecycle r102 = null;
        Object r103 = r100;
        if (r101 == true) goto L5;
        r103 = null;
    L5:
        LifecycleOwner r104 = (LifecycleOwner) r103;
        if (r104 == null) goto L8;
        r102 = r104.getLifecycle();
    L8:
        if (r102 == null) goto L12;
        Map<ExecutionPeriod, List<bf6.g>> r105 = l.f254532a;
        r102.addObserver(new PeriodTaskManager$registerSplash$1());
        return;
    L12:
        throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor r100) {
        taskExecutor = r100;
    }

    @JvmStatic
    public static final void setServiceManagerProxy(f r100) {
        f r101 = n.f254551a;
        n.f254551a = r100;
    }

    public final void setConfig$initscheduler_release(TaskConfig r100) {
        config = r100;
    }
}
