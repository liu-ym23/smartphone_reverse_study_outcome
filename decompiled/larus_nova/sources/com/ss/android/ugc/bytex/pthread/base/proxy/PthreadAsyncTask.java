package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.os.AsyncTask;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public abstract class PthreadAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR = null;
    public static ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    /* JADX INFO: renamed from: com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SerialExecutor implements Executor {
        Runnable mActive;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque();
        }

        public /* synthetic */ SerialExecutor(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable r100) {
            monitor-enter(this);
            this.mTasks.offer(new AnonymousClass1(this, r100));     // Catch: Throwable -> L8
            if (this.mActive != null) goto L6;
            scheduleNext();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public synchronized void scheduleNext() {
            monitor-enter(this);
            Runnable r100 = this.mTasks.poll();     // Catch: Throwable -> L8
            this.mActive = r100;     // Catch: Throwable -> L8
            if (r100 == null) goto L6;
            PthreadAsyncTask.THREAD_POOL_EXECUTOR.execute(r100);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        THREAD_POOL_EXECUTOR = new PThreadPoolExecutor(15, 15, 3, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("PthreadAsyncTask"));
        SERIAL_EXECUTOR = new SerialExecutor(null);
    }

    public PthreadAsyncTask() {
    }

    public static void execute(Runnable r100) {
        THREAD_POOL_EXECUTOR.execute(r100);
    }

    public static void setMaxAsyncTaskThreadCount(int r100) {
        THREAD_POOL_EXECUTOR.setCorePoolSize(r100);
        THREAD_POOL_EXECUTOR.setMaximumPoolSize(r100);
    }

    public final AsyncTask<Params, Progress, Result> execute1(Params... r100) {
        return executeOnExecutor(THREAD_POOL_EXECUTOR, r100);
    }
}
