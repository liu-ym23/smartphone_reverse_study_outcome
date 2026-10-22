package com.ss.mediakit.net;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLThreadPool {
    private static final String TAG = "AVMDLThreadPool";
    private static final int THREADPOOL_MAX_RUNNING_TASK_SIZE = 64;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables;
    private static Deque<AsyncRunnable> mRunningRunnables;

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_mediakit_net_AVMDLThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_mediakit_net_AVMDLThreadPool$AsyncRunnable__run$___twin___() {
            this.mRunnable.run();
            AVMDLThreadPool.access$000(this);
        }

        public AsyncRunnable(Runnable r100) {
            this.mRunnable = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_mediakit_net_AVMDLThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncRunnable r100) {
            r100.com_ss_mediakit_net_AVMDLThreadPool$AsyncRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AVMDLThreadPool() {
    }

    static {
        mReadyRunnables = new ArrayDeque();
        mRunningRunnables = new ArrayDeque();
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
        if (mExecutorInstance != null) goto L15;
        monitor-enter(AVMDLThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mExecutorInstance != null) goto L9;
        mExecutorInstance = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TAG));     // Catch: Throwable -> L11
    L9:
        monitor-exit(AVMDLThreadPool.class);     // Catch: Throwable -> L11
    L15:
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
        monitor-enter(AVMDLThreadPool.class);
        mRunningRunnables.remove(r100);     // Catch: Throwable -> L7
        _promoteRunnable();     // Catch: Throwable -> L7
        monitor-exit(AVMDLThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(AsyncRunnable r100) {
        _finished(r100);
    }

    public static synchronized Future addExecuteTask(Runnable r100) {
        monitor-enter(AVMDLThreadPool.class);
        if (r100 != null) goto L22;
        monitor-exit(AVMDLThreadPool.class);
        return null;
    L22:
    L19:
        th = move-exception;
        throw th;
    L9:
        if (mExecutorInstance != null) goto L11;
        getExecutorInstance();     // Catch: Throwable -> L19
    L11:
        AVMDLLog.d(TAG, "addExecuteTask,cur thread num:" + getPoolSize());     // Catch: Throwable -> L19
        AsyncRunnable r101 = new AsyncRunnable(r100);     // Catch: Throwable -> L19
        if (mRunningRunnables.size() < 64) goto L16;
        mReadyRunnables.add(r101);     // Catch: Throwable -> L19
        monitor-exit(AVMDLThreadPool.class);
        return null;
    L16:
        mRunningRunnables.add(r101);     // Catch: Throwable -> L19
        Future<?> r102 = mExecutorInstance.submit(r101);     // Catch: Throwable -> L19
        monitor-exit(AVMDLThreadPool.class);
        return r102;
    }

    public static void setExecutorInstance(ThreadPoolExecutor r100) {
        monitor-enter(AVMDLThreadPool.class);
        mExecutorInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLThreadPool.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
