package com.ss.ttvideoengine.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public class EngineThreadPool {
    private static final String TAG = "EngineThreadPool";
    private static final int THREADPOOL_ALIVE_TIME_SEC = 60;
    private static final int THREADPOOL_CORE_POOL_SIZE = 0;
    private static final int THREADPOOL_MAX_POOL_SIZE = Integer.MAX_VALUE;
    private static final int THREADPOOL_MAX_RUNNING_TASK_SIZE = 5;
    private static volatile boolean mEnableLockOptimize;
    private static volatile boolean mEnableThreadPoolOptimize;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables;
    private static Deque<AsyncRunnable> mRunningRunnables;

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable__run$___twin___() {
            this.mRunnable.run();
            EngineThreadPool.access$000(this);
        }

        public AsyncRunnable(Runnable r100) {
            this.mRunnable = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncRunnable r100) {
            r100.com_ss_ttvideoengine_utils_EngineThreadPool$AsyncRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public EngineThreadPool() {
    }

    static {
        mReadyRunnables = new ArrayDeque();
        mRunningRunnables = new ArrayDeque();
        mEnableThreadPoolOptimize = true;
    }

    private static void _promoteRunnable() {
        if (mReadyRunnables.size() <= 0) goto L8;
        Iterator<AsyncRunnable> r100 = mReadyRunnables.iterator();
        if (r100.hasNext() == false) goto L9;
        AsyncRunnable r101 = r100.next();
        r100.remove();
        mRunningRunnables.add(r101);
        mExecutorInstance.execute(r101);
        return;
    L9:
        return;
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance != null) goto L18;
        monitor-enter(EngineThreadPool.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (mExecutorInstance == null) goto L9;
    L12:
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (mEnableThreadPoolOptimize == false) goto L11;
        TTVideoEngineInternalLog.i(TAG, "mEnableThreadPoolOptimize true");     // Catch: Throwable -> L14
        mExecutorInstance = new PThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(TAG));     // Catch: Throwable -> L14
        mExecutorInstance.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L14
        goto L12
    L11:
        mExecutorInstance = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TAG));     // Catch: Throwable -> L14
    L18:
        return mExecutorInstance;
    }

    public static int getPoolSize() {
        if (mExecutorInstance != null) goto L6;
        getExecutorInstance();
    L6:
        return mExecutorInstance.getPoolSize();
    }

    public static void shutdown() {
        if (mExecutorInstance == null) goto L6;
        mExecutorInstance.shutdown();
        return;
    }

    private static synchronized void _finished(AsyncRunnable r100) {
        monitor-enter(EngineThreadPool.class);
        mRunningRunnables.remove(r100);     // Catch: Throwable -> L7
        _promoteRunnable();     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(AsyncRunnable r100) {
        _finished(r100);
    }

    public static Future addExecuteTask(Runnable r100) {
        if (mEnableLockOptimize == false) goto L7;
        return addExecuteTaskInternal(r100);
    L7:
        monitor-enter(EngineThreadPool.class);
        Future r101 = addExecuteTaskInternal(r100);     // Catch: Throwable -> L11
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L11
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    private static Future addExecuteTaskInternal(Runnable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (mExecutorInstance != null) goto L30;
        getExecutorInstance();
    L30:
        TTVideoEngineInternalLog.i(TAG, "addExecuteTask,pool size:" + getPoolSize() + ", active:" + mExecutorInstance.getActiveCount());     // Catch: Exception -> L10
    L13:
        if (mEnableThreadPoolOptimize == false) goto L17;
        return mExecutorInstance.submit(r100);
    L17:
        monitor-enter(EngineThreadPool.class);
        TTVideoEngineInternalLog.i(TAG, "running:" + mRunningRunnables.size() + ", ready:" + mReadyRunnables.size());     // Catch: Throwable -> L26
        AsyncRunnable r101 = new AsyncRunnable(r100);     // Catch: Throwable -> L26
        if (mRunningRunnables.size() < 5) goto L23;
        mReadyRunnables.add(r101);     // Catch: Throwable -> L26
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L26
        return null;
    L23:
        mRunningRunnables.add(r101);     // Catch: Throwable -> L26
        Future<?> r102 = mExecutorInstance.submit(r101);     // Catch: Throwable -> L26
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L26
        return r102;
    L26:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static void setExecutorInstance(ThreadPoolExecutor r100) {
        monitor-enter(EngineThreadPool.class);
        mExecutorInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setOptimizeEnabled(boolean r100) {
        monitor-enter(EngineThreadPool.class);
        mEnableThreadPoolOptimize = r100;     // Catch: Throwable -> L7
        monitor-exit(EngineThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setOptimizeLock(boolean r100) {
        mEnableLockOptimize = r100;
    }

    public static Future addExecuteTaskSync(Runnable r100, long r101) {
        if (mEnableLockOptimize == false) goto L7;
        return addExecuteTaskSyncInternal(r100, r101);
    L7:
        monitor-enter(EngineThreadPool.class);
        Future r102 = addExecuteTaskSyncInternal(r100, r101);     // Catch: Throwable -> L11
        monitor-exit(EngineThreadPool.class);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    private static Future addExecuteTaskSyncInternal(Runnable r100, long r101) {
        TTVideoEngineInternalLog.i(TAG, "addExecuteTaskSync timeout:" + r101);
        Future r102 = addExecuteTaskInternal(r100);
        if (r102 != null) goto L8;
    L7:
        return r102;
    L8:
        r102.get(r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6
    L6:
        TTVideoEngineInternalLog.e(TAG, "set surface time out");
        goto L7
    }
}
