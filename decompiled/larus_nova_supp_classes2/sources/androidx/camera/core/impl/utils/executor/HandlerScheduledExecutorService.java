package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class HandlerScheduledExecutorService extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance;
    private final Handler mHandler;

    public static class HandlerScheduledFuture<V> implements RunnableScheduledFuture<V> {
        final AtomicReference<CallbackToFutureAdapter.Completer<V>> mCompleter;
        private final ListenableFuture<V> mDelegate;
        private final long mRunAtMillis;
        private final Callable<V> mTask;

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return (V) this.mDelegate.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.mDelegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.mDelegate.isDone();
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            CallbackToFutureAdapter.Completer<V> r0 = this.mCompleter.getAndSet(null);
            if (r0 == null) goto L11;
            r0.set(this.mTask.call());     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            r0.setException(e);
            return;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r2) {
            return this.mDelegate.cancel(r2);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Delayed r6) {
            TimeUnit r0 = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(r0), r6.getDelay(r0));
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit r5) {
            return r5.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Delayed r1) {
            return compareTo2(r1);
        }

        @Override // java.util.concurrent.Future
        public V get(long r2, TimeUnit r4) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) this.mDelegate.get(r2, r4);
        }

        public HandlerScheduledFuture(final Handler r3, long r4, final Callable<V> r6) {
            this.mCompleter = new AtomicReference(null);
            this.mRunAtMillis = r4;
            this.mTask = r6;
            this.mDelegate = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this, r3, r6));
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
        sThreadLocalInstance = new AnonymousClass1();
    }

    private RejectedExecutionException createPostFailedException() {
        return new RejectedExecutionException(this.mHandler + " is shutting down");
    }

    public static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService r0 = sThreadLocalInstance.get();
        if (r0 != null) goto L9;
        Looper r1 = Looper.myLooper();
        if (r1 == null) goto L8;
        HandlerScheduledExecutorService r2 = new HandlerScheduledExecutorService(new Handler(r1));
        sThreadLocalInstance.set(r2);
        return r2;
    L8:
        throw new IllegalStateException("Current thread has no looper!");
    L9:
        return r0;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    public HandlerScheduledExecutorService(Handler r1) {
        this.mHandler = r1;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        if (this.mHandler.post(r2) == false) goto L6;
        return;
    L6:
        throw createPostFailedException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r4, long r5, TimeUnit r7) {
        long r0 = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(r5, r7);
        HandlerScheduledFuture r6 = new HandlerScheduledFuture(this.mHandler, r0, r4);
        if (this.mHandler.postAtTime(r6, r0) == false) goto L6;
        return r6;
    L6:
        return Futures.immediateFailedScheduledFuture(createPostFailedException());
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(final Runnable r2, long r3, TimeUnit r5) {
        return schedule(new AnonymousClass2(this, r2), r3, r5);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService does not yet support fixed-delay scheduling.");
    }
}
