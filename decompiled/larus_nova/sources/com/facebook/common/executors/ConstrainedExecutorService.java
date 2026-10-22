package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class ConstrainedExecutorService extends AbstractExecutorService {
    private static final Class<?> TAG = null;
    private final Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final AtomicInteger mMaxQueueSize;
    private final String mName;
    private final AtomicInteger mPendingWorkers;
    private final Worker mTaskRunner;
    private final BlockingQueue<Runnable> mWorkQueue;

    /* JADX INFO: renamed from: com.facebook.common.executors.ConstrainedExecutorService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class Worker implements Runnable {
        final /* synthetic */ ConstrainedExecutorService this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_facebook_common_executors_ConstrainedExecutorService$Worker_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_facebook_common_executors_ConstrainedExecutorService$Worker__run$___twin___() {
            Runnable r100 = (Runnable) ConstrainedExecutorService.access$100(this.this$0).poll();     // Catch: Throwable -> L12
            if (r100 == null) goto L6;
            r100.run();     // Catch: Throwable -> L12
        L7:
            int r101 = ConstrainedExecutorService.access$400(this.this$0).decrementAndGet();
            if (ConstrainedExecutorService.access$100(this.this$0).isEmpty() == true) goto L10;
            ConstrainedExecutorService.access$500(this.this$0);
            return;
        L10:
            FLog.v(ConstrainedExecutorService.access$200(), "%s: worker finished; %d workers left", ConstrainedExecutorService.access$300(this.this$0), Integer.valueOf(r101));
            return;
        L6:
            FLog.v(ConstrainedExecutorService.access$200(), "%s: Worker has nothing to run", ConstrainedExecutorService.access$300(this.this$0));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            int r102 = ConstrainedExecutorService.access$400(this.this$0).decrementAndGet();
            if (ConstrainedExecutorService.access$100(this.this$0).isEmpty() == true) goto L16;
            ConstrainedExecutorService.access$500(this.this$0);
        L17:
            throw th;
        L16:
            FLog.v(ConstrainedExecutorService.access$200(), "%s: worker finished; %d workers left", ConstrainedExecutorService.access$300(this.this$0), Integer.valueOf(r102));
            goto L17
        }

        private Worker(ConstrainedExecutorService r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_facebook_common_executors_ConstrainedExecutorService$Worker_com_larus_apm_impl_protector_RunnableLancet_run(Worker r100) {
            r100.com_facebook_common_executors_ConstrainedExecutorService$Worker__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ Worker(ConstrainedExecutorService r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    static {
        TAG = ConstrainedExecutorService.class;
    }

    private void startWorkerIfNeeded() {
        int r100 = this.mPendingWorkers.get();
    L4:
        if (r100 >= this.mMaxConcurrency) goto L12;
        int r101 = r100 + 1;
        if (this.mPendingWorkers.compareAndSet(r100, r101) == true) goto L7;
        FLog.v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
        r100 = this.mPendingWorkers.get();
        goto L4
    L7:
        FLog.v(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(r101), Integer.valueOf(this.mMaxConcurrency));
        this.mExecutor.execute(this.mTaskRunner);
        return;
    }

    public boolean isIdle() {
        if (this.mWorkQueue.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingWorkers.get() != 0) goto L7;
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Class access$200() {
        return TAG;
    }

    public static /* synthetic */ BlockingQueue access$100(ConstrainedExecutorService r100) {
        return r100.mWorkQueue;
    }

    public static /* synthetic */ String access$300(ConstrainedExecutorService r100) {
        return r100.mName;
    }

    public static /* synthetic */ AtomicInteger access$400(ConstrainedExecutorService r100) {
        return r100.mPendingWorkers;
    }

    public static /* synthetic */ void access$500(ConstrainedExecutorService r100) {
        r100.startWorkerIfNeeded();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (r100 == null) goto L15;
        if (this.mWorkQueue.offer(r100) == false) goto L13;
        int r101 = this.mWorkQueue.size();
        int r102 = this.mMaxQueueSize.get();
        if (r101 > r102) goto L8;
    L10:
        startWorkerIfNeeded();
        return;
    L8:
        if (this.mMaxQueueSize.compareAndSet(r102, r101) == false) goto L10;
        FLog.v(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(r101));
        goto L10
    L13:
        throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
    L15:
        throw new NullPointerException("runnable parameter is null");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public ConstrainedExecutorService(String r100, int r101, Executor r102, BlockingQueue<Runnable> r103) {
        if (r101 <= 0) goto L7;
        this.mName = r100;
        this.mExecutor = r102;
        this.mMaxConcurrency = r101;
        this.mWorkQueue = r103;
        this.mTaskRunner = new Worker(this, null);
        this.mPendingWorkers = new AtomicInteger(0);
        this.mMaxQueueSize = new AtomicInteger(0);
        return;
    L7:
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String r100, int r101, int r102, Executor r103) {
        return new ConstrainedExecutorService(r100, r101, r103, new LinkedBlockingQueue(r102));
    }
}
