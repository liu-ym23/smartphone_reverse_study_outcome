package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.DelayTime;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class DelayTaskDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<DelayTime, PriorityQueue<DelayTaskInfo>> f254482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f254483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AtomicInteger f254484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f254485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f254486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f254487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f254488g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DelayTaskDispatcher f254489h = null;

    public DelayTaskDispatcher() {
    }

    static {
        f254489h = new DelayTaskDispatcher();
        f254482a = new LinkedHashMap();
        f254484c = new AtomicInteger(0);
        f254487f = -1;
        f254488g = new Handler(Looper.getMainLooper(), DelayTaskDispatcher$mainHandler$1.f254491a);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f254485d == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        f254485d = true;     // Catch: Throwable -> L12
        f254487f = System.currentTimeMillis();     // Catch: Throwable -> L12
        int r100 = com.bytedance.lego.init.util.c.f254571a;     // Catch: Throwable -> L12
        com.bytedance.lego.init.util.c.a("DelayTaskDispatcher", "start, curTime: " + f254487f);     // Catch: Throwable -> L12
        com.bytedance.lego.init.monitor.a r101 = com.bytedance.lego.init.monitor.a.f254547c;     // Catch: Throwable -> L12
        long r102 = f254487f;     // Catch: Throwable -> L12
        r101.getClass();     // Catch: Throwable -> L12
        com.bytedance.lego.init.monitor.a.f254546b = r102;     // Catch: Throwable -> L12
        Handler r103 = f254488g;     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1000, 3000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1001, 5000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1002, KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1003, 15000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1004, 30000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1005, 60000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1006, 120000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1007, 300000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1008, 600000);     // Catch: Throwable -> L12
        r103.sendEmptyMessageDelayed(1009, 900000);     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public static final void a(PriorityQueue r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isEmpty()) == false) goto L8;
        final DelayTaskInfo r101 = (DelayTaskInfo) r100.poll();
        j.a(new DelayTaskDispatcher$dispatchTask$1(r101));
        goto L4
    }

    public static final void b(DelayTaskInfo r100, boolean r101) {
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.a.f254547c.getClass();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.a.d(r100, r101);     // Catch: Exception -> L14
        int r103 = com.bytedance.lego.init.util.c.f254571a;     // Catch: Exception -> L14
        com.bytedance.lego.init.util.c.a("DelayTaskDispatcher", r100.taskId + " start. startTimeFromOnCreateEnd: " + (r102 - f254487f));     // Catch: Exception -> L14
        com.bytedance.lego.init.util.c.a("DelayTaskDispatcher", r100.taskId + " run. isUIThread: " + r101);     // Catch: Exception -> L14
        r100.task.run();     // Catch: Exception -> L14
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.a.c(r100, r101);     // Catch: Exception -> L14
        long r105 = r104 - r102;     // Catch: Exception -> L14
        if (r101 == false) goto L6;
        String r106 = "Main:Task-" + r100.taskId;     // Catch: Exception -> L14
    L7:
        com.bytedance.lego.init.monitor.a.a(r106, r105);     // Catch: Exception -> L14
        com.bytedance.lego.init.util.c.a("DelayTaskDispatcher", r100.taskId + " end. endTimeFromOnCreateEnd: " + (r104 - f254487f) + ", cos " + r105 + " ms.");     // Catch: Exception -> L14
        if (f254484c.incrementAndGet() != f254483b) goto L24;
        com.bytedance.lego.init.util.c.a("DelayTaskDispatcher", "sendMonitorData");     // Catch: Exception -> L11
        j.a(DelayTaskDispatcher$sendMonitorData$1.INSTANCE);     // Catch: Exception -> L11
    L25:
        return;
    L11:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "DELAY_TASK_MONITOR_EXCEPTION");     // Catch: Exception -> L14
        return;
    L24:
        return;
    L6:
        r106 = "Async:Task-" + r100.taskId;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        int r107 = com.bytedance.lego.init.util.c.f254571a;
        String r108 = r100.taskId;
        Log.getStackTraceString(e);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L19;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_DELAY_TASK_EXCEPTION:" + r100.taskId);
        return;
    L19:
        throw e;
    }
}
