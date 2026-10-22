package com.ss.android.ugc.bytex.pthread.base;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PThreadExecutorsUtils {

    public static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService e;

        public DelegatedExecutorService(ExecutorService r1) {
            this.e = r1;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r2, TimeUnit r4) {
            return this.e.awaitTermination(r2, r4);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            this.e.execute(r2);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r2) {
            return this.e.invokeAll(r2);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r2, long r3, TimeUnit r5) {
            return this.e.invokeAll(r2, r3, r5);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r2) {
            return (T) this.e.invokeAny(r2);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r2, long r3, TimeUnit r5) {
            return (T) this.e.invokeAny(r2, r3, r5);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.e.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.e.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.e.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.e.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable r2) {
            return this.e.submit(r2);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable r2, T r3) {
            return this.e.submit(r2, r3);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> r2) {
            return this.e.submit(r2);
        }
    }

    public static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        private final ScheduledExecutorService e;

        public DelegatedScheduledExecutorService(ScheduledExecutorService r1) {
            super(r1);
            this.e = r1;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable r2, long r3, TimeUnit r5) {
            return this.e.schedule(r2, r3, r5);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> r2, long r3, TimeUnit r5) {
            return this.e.schedule(r2, r3, r5);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable r8, long r9, long r11, TimeUnit r13) {
            return this.e.scheduleAtFixedRate(r8, r9, r11, r13);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r8, long r9, long r11, TimeUnit r13) {
            return this.e.scheduleWithFixedDelay(r8, r9, r11, r13);
        }
    }

    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        public FinalizableDelegatedExecutorService(ExecutorService r1) {
            super(r1);
        }

        public void finalize() {
            super.shutdown();
        }
    }

    private PThreadExecutorsUtils() {
    }

    public static ExecutorService newCachedThreadPool() {
        return new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory r9) {
        return new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r9);
    }

    public static ExecutorService newFixedThreadPool(int r8) {
        return new PThreadPoolExecutor(r8, r8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newFixedThreadPool(int r9, ThreadFactory r10) {
        return new PThreadPoolExecutor(r9, r9, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), r10);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r1) {
        return new PThreadScheduledThreadPoolExecutor(r1);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r1, ThreadFactory r2) {
        return new PThreadScheduledThreadPoolExecutor(r1, r2);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory r10) {
        return new FinalizableDelegatedExecutorService(new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), r10));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory r3) {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, r3));
    }
}
