package com.larksuite.framework.thread;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;

/* JADX INFO: loaded from: classes24.dex */
public class CoreThreadPool {
    private static final String ASYNC_TASK_POOLNAME = "lk-asynctask";
    private static final int BACKGROUND_HANDLER_MAX_DELAY_TIME = 2000;
    private static final int BACKGROUND_HANDLER_MAX_RUNTIME = 1000;
    public static final String DEFAULT_CPU_POOLNAME = "lk-cpu";
    public static final String DEFAULT_IO_POOLNAME = "lk-io";
    public static final String DEFAULT_PREFIX = "lk-";
    public static final String DEFAULT_SCHEDULE_POOLNAME = "lk-schedule";
    private static final int NEW_THREAD_HANDLER_MAX_DELAY_TIME = 2000;
    private static final int NEW_THREAD_HANDLER_MAX_RUNTIME = 5000;
    private static final int NON_BLOCKING_HANDLER_MAX_DELAY_TIME = 500;
    private static final int NON_BLOCKING_HANDLER_MAX_RUNTIME = 200;
    private static final int SERIAL_TASK_MAX_DELAY_TIME = 1000;
    private static final int SERIAL_TASK_MAX_RUNTIME = 500;
    static final String TAG = "CoreThreadPool";
    public static long mAppToBackTime = 0;
    public static a mCoreThreadPoolDep = null;
    public static volatile boolean mDuringCoreScene = false;
    public static boolean mIsDebug = false;
    public static volatile boolean sAppFront = true;
    protected static volatile Handler sBackgroundHandler = null;
    protected static HandlerThread sBackgroundHandlerThread = null;
    private static volatile CoreThreadPool sCoreThreadPoolInst = null;
    protected static volatile Handler sHighPriorityHandler = null;
    protected static HandlerThread sHighPriorityHandlerThread = null;
    private static boolean sNeedMonitor = true;
    protected static volatile Handler sNonblockingHandler;
    protected static HandlerThread sNonblockingHandlerThread;
    private p mCacheThreadPool;
    private p mFixedThreadPool;
    private b mSceneDependency;
    private ScheduledExecutorService mScheduleThreadPool;
    private Executor mUIExecutor;

    public interface a {
        boolean a();

        void b();

        Context getContext();
    }

    public interface b {
    }

    public static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f285720a;

        public c() {
            this.f285720a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            qqb.b r101 = qqb.c.a(r100);
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
            r101.run();
            return;
        L5:
            this.f285720a.post(r101);
        }
    }

    public static Handler getBackgroundHandler() {
        if (sBackgroundHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sBackgroundHandler != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("lark_background_sub", 10);     // Catch: Throwable -> L11
        sBackgroundHandlerThread = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        sBackgroundHandler = new w(sBackgroundHandlerThread.getLooper(), "lark_background_sub");     // Catch: Throwable -> L11
        w r101 = (w) sBackgroundHandler;     // Catch: Throwable -> L11
        r101.f285809a = 2000;     // Catch: Throwable -> L11
        r101.f285810b = 1000;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sBackgroundHandler;
    }

    public static boolean getCoreThreadPoolServiceSwitch() {
        a r100 = mCoreThreadPoolDep;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    public static CoreThreadPool getDefault() {
        if (sCoreThreadPoolInst != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sCoreThreadPoolInst != null) goto L9;
        sCoreThreadPoolInst = new CoreThreadPool();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sCoreThreadPoolInst;
    }

    public static Handler getNonblockingHandler() {
        if (sNonblockingHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sNonblockingHandler != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("lark_nonblocking_sub");     // Catch: Throwable -> L11
        sNonblockingHandlerThread = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        sNonblockingHandler = new w(sNonblockingHandlerThread.getLooper(), "lark_nonblocking_sub");     // Catch: Throwable -> L11
        w r101 = (w) sNonblockingHandler;     // Catch: Throwable -> L11
        r101.f285809a = 500;     // Catch: Throwable -> L11
        r101.f285810b = 200;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sNonblockingHandler;
    }

    public static Handler getSerialTaskHandler() {
        if (sHighPriorityHandler != null) goto L15;
        monitor-enter(CoreThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sHighPriorityHandler != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("lark_sub");     // Catch: Throwable -> L11
        sHighPriorityHandlerThread = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        sHighPriorityHandler = new w(sHighPriorityHandlerThread.getLooper(), "lark_sub");     // Catch: Throwable -> L11
        w r101 = (w) sHighPriorityHandler;     // Catch: Throwable -> L11
        r101.f285809a = 1000;     // Catch: Throwable -> L11
        r101.f285810b = 500;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoreThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sHighPriorityHandler;
    }

    public String getCurScene() {
        b r100 = this.mSceneDependency;
        if (r100 != null) goto L7;
        return "";
    L7:
        return ((com.ss.android.lark.monitor.p) r100).f432425a.d();
    }

    private CoreThreadPool() {
        this.mCacheThreadPool = new d(new SynchronousQueue(), new n(DEFAULT_IO_POOLNAME, 1));
        this.mFixedThreadPool = new com.larksuite.framework.thread.b(DEFAULT_CPU_POOLNAME, com.larksuite.framework.thread.b.f285730j, com.larksuite.framework.thread.b.f285731k, new LinkedBlockingDeque(512), new n(DEFAULT_CPU_POOLNAME, 3));
        this.mScheduleThreadPool = new g(DEFAULT_SCHEDULE_POOLNAME, 3, new n(DEFAULT_SCHEDULE_POOLNAME));
        this.mUIExecutor = new c();
    }

    public static boolean needMonitorTask() {
        return sNeedMonitor;
    }

    public ExecutorService getCachedThreadPool() {
        return this.mCacheThreadPool;
    }

    public ExecutorService getFixedThreadPool() {
        return this.mFixedThreadPool;
    }

    public ScheduledExecutorService getScheduleThreadPool() {
        return this.mScheduleThreadPool;
    }

    public Executor getUIExecutor() {
        return this.mUIExecutor;
    }

    public boolean isDuringCoreScene() {
        return mDuringCoreScene;
    }

    public static Handler newThreadHandler(String r100) {
        return newThreadHandler(r100, null);
    }

    private static void reflectAsyncTaskPool(ExecutorService r100) {
        Objects.toString(AsyncTask.THREAD_POOL_EXECUTOR);     // Catch: Throwable -> L4
        Field r101 = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");     // Catch: Throwable -> L4
        r101.setAccessible(true);     // Catch: Throwable -> L4
        r101.set(null, r100);     // Catch: Throwable -> L4
        Objects.toString(AsyncTask.THREAD_POOL_EXECUTOR);     // Catch: Throwable -> L4
        return;
    }

    public static void setAppCoreScene(boolean r100) {
        mDuringCoreScene = r100;
    }

    public static void setAppFrontStats(boolean r100) {
        sAppFront = r100;
        if (r100 == false) goto L5;
        mAppToBackTime = 0;
        b0.d();
        return;
    L5:
        mAppToBackTime = System.currentTimeMillis();
        b0.f285737d = 0;
        b0.f285738e = 0;
        monitor-enter(b0.class);
        Log.i("TestThreadPoolDelay", "stopScheduleThreadPoolTest");     // Catch: Throwable -> L12
        ScheduledFuture<?> r101 = b0.f285736c;     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.cancel(true);     // Catch: Throwable -> L12
        b0.f285736c = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(b0.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setDebug(boolean r100) {
        mIsDebug = r100;
    }

    public static void setDenpency(a r100) {
        mCoreThreadPoolDep = r100;
    }

    public static void setNeedMonitor(boolean r100) {
        sNeedMonitor = r100;
    }

    public ScheduledExecutorService getSingleScheduledThreadPool(String r100) {
        return new j(r100, new n("lk-ssc-" + r100));
    }

    public ExecutorService newSerialCpuDensityThreadPool(String r100) {
        return new h(r100, 1);
    }

    public ExecutorService newSerialHighPriorityThreadPool(String r100) {
        return new h(r100, 0);
    }

    public ExecutorService newSerialIODensityThreadPool(String r100) {
        return new h(r100, 2);
    }

    public void setSceneDependency(b r100) {
        this.mSceneDependency = r100;
    }

    public static Handler newThreadHandler(String r100, Handler.Callback r101) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("lk_th_" + r100);
        ThreadMethodProxy.start(r102);
        w r103 = new w(r102.getLooper(), r101);
        r103.f285809a = 2000;
        r103.f285810b = 5000;
        return r103;
    }

    public ExecutorService newCpuThreadPool(String r100, int r101, int r110) {
        return new com.larksuite.framework.thread.b(r100, r101, r110, new LinkedBlockingDeque(512), new n(r100 + "-lk-cpu", 3));
    }
}
