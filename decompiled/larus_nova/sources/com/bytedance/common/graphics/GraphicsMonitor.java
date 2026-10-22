package com.bytedance.common.graphics;

import com.bytedance.monitor.collector.c;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import uu3.a;

/* JADX INFO: loaded from: classes15.dex */
public class GraphicsMonitor {
    private static final long COLLECT_WINDOWS = 100;
    private static final String MTK = "mt";
    private static final long POLL_INTERVAL = 15000;
    private static ScheduledFuture<?> gpuFuture = null;
    private static double gpuLoadDataOnce = -1.0d;
    private static ScheduledExecutorService gpuScheduleService;
    private static boolean isInit;
    private static boolean isInitGraphicsLoad;
    private static volatile boolean isPause;
    private static a lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    public GraphicsMonitor() {
    }

    private static native void closeStatistical();

    private static native double getStatisticOnceData();

    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        c.h(xu3.a.getContext());     // Catch: Throwable -> L5
        startHook();     // Catch: Throwable -> L5
        gpuScheduleService = PThreadExecutorsUtils.newScheduledThreadPool(0, new DefaultThreadFactory("GraphicsMonitor"));     // Catch: Throwable -> L5
        return;
    L5:
        isInitGraphicsLoad = false;
    }

    private static native void openStatistical();

    private static native boolean startHook();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r100 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L14
        sCollectInterval = 15000;     // Catch: Throwable -> L14
        sCollectWindow = 100;     // Catch: Throwable -> L14
        a r100 = (a) qu3.c.a(a.class);     // Catch: Throwable -> L14
        lifecycleService = r100;     // Catch: Throwable -> L14
        r100.a(new AnonymousClass1());     // Catch: Throwable -> L14
        if (lifecycleService.isForeground() == false) goto L12;
        isPause = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(GraphicsMonitor.class);
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r100 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r100;
    L7:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L11;
        initGraphicsLoad();     // Catch: Throwable -> L22
    L11:
        ScheduledExecutorService r100 = gpuScheduleService;     // Catch: Throwable -> L22
        if (r100 != null) goto L15;
        monitor-exit(GraphicsMonitor.class);
        return;
    L15:
        int r101 = startTime + 1;     // Catch: Throwable -> L22
        startTime = r101;     // Catch: Throwable -> L22
        if (r101 <= 1) goto L19;
        monitor-exit(GraphicsMonitor.class);
        return;
    L19:
        Runnable r102 = new AnonymousClass2();     // Catch: Throwable -> L22
        long r103 = sCollectInterval;     // Catch: Throwable -> L22
        gpuFuture = r100.scheduleWithFixedDelay(r102, r103, r103, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        monitor-exit(GraphicsMonitor.class);
    }

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L19:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L19;
        int r100 = startTime - 1;     // Catch: Throwable -> L21
        startTime = r100;     // Catch: Throwable -> L21
        if (r100 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r101 = gpuFuture;     // Catch: Throwable -> L21
        if (r101 == null) goto L16;
        r101.cancel(true);     // Catch: Throwable -> L21
    L16:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L21
        monitor-exit(GraphicsMonitor.class);
    }

    public static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    public static /* synthetic */ boolean access$000() {
        return isPause;
    }

    public static /* synthetic */ void access$100() {
        openStatistical();
    }

    public static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    public static /* synthetic */ void access$300() {
        closeStatistical();
    }

    public static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    public static /* synthetic */ boolean access$002(boolean r100) {
        isPause = r100;
        return r100;
    }

    public static /* synthetic */ double access$402(double r100) {
        gpuLoadDataOnce = r100;
        return r100;
    }
}
