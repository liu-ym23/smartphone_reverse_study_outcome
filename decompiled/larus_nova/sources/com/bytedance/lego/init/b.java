package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AtomicInteger f254516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<FeedShowTaskInfo> f254517b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f254518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f254519d = null;

    public b() {
    }

    static {
        f254519d = new b();
        f254516a = new AtomicInteger(0);
        f254517b = new ArrayList();
    }

    public static final void a(FeedShowTaskInfo r100, boolean r101) {
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.b.f254550c.getClass();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.b.b(r100, r101);     // Catch: Exception -> L14
        int r103 = com.bytedance.lego.init.util.c.f254571a;     // Catch: Exception -> L14
        com.bytedance.lego.init.util.c.a("FeedShowTaskDispatcher", r100.taskId + " start. isUIThread: " + r101);     // Catch: Exception -> L14
        r100.task.run();     // Catch: Exception -> L14
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L14
        com.bytedance.lego.init.monitor.b.a(r100, r101);     // Catch: Exception -> L14
        long r105 = r104 - r102;     // Catch: Exception -> L14
        if (r101 == false) goto L6;
        String r106 = "Main:Task-" + r100.taskId;     // Catch: Exception -> L14
    L7:
        com.bytedance.lego.init.monitor.b.f254549b.add(new Pair(r106, Long.valueOf(r105)));     // Catch: Exception -> L14
        com.bytedance.lego.init.util.c.a("FeedShowTaskDispatcher", r100.taskId + " end. cos " + r105 + " ms.");     // Catch: Exception -> L14
        if (f254516a.incrementAndGet() != ((ArrayList) f254517b).size()) goto L24;
        com.bytedance.lego.init.util.c.a("FeedShowTaskDispatcher", "sendMonitorData");     // Catch: Exception -> L11
        com.bytedance.lego.init.monitor.b.c();     // Catch: Exception -> L11
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
        e.printStackTrace();
        int r107 = com.bytedance.lego.init.util.c.f254571a;
        String r108 = r100.taskId;
        Log.getStackTraceString(e);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L19;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "RUN_FEED_SHOW_TASK_EXCEPTION:" + r100.taskId);
        return;
    L19:
        throw e;
    }
}
