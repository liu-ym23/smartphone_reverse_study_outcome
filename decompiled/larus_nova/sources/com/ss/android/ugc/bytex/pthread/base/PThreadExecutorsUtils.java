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

/* JADX INFO: loaded from: classes.dex */
public class PThreadExecutorsUtils {

    public static class DelegatedExecutorService extends AbstractExecutorService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ExecutorService f454359e;

        public DelegatedExecutorService(ExecutorService r100) {
            this.f454359e = r100;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r100, TimeUnit r101) {
            return this.f454359e.awaitTermination(r100, r101);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.f454359e.execute(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) {
            return this.f454359e.invokeAll(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) {
            return this.f454359e.invokeAll(r100, r101, r102);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r100) {
            return (T) this.f454359e.invokeAny(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) {
            return (T) this.f454359e.invokeAny(r100, r101, r102);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f454359e.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f454359e.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f454359e.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.f454359e.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable r100) {
            return this.f454359e.submit(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable r100, T r101) {
            return this.f454359e.submit(r100, r101);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> r100) {
            return this.f454359e.submit(r100);
        }
    }

    public static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f454360e;

        public DelegatedScheduledExecutorService(ScheduledExecutorService r100) {
            super(r100);
            this.f454360e = r100;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
            return this.f454360e.schedule(r100, r101, r102);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
            return this.f454360e.schedule(r100, r101, r102);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r110, TimeUnit r111) {
            return this.f454360e.scheduleAtFixedRate(r100, r101, r110, r111);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r110, TimeUnit r111) {
            return this.f454360e.scheduleWithFixedDelay(r100, r101, r110, r111);
        }
    }

    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        public FinalizableDelegatedExecutorService(ExecutorService r100) {
            super(r100);
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

    public static ExecutorService newCachedThreadPool(ThreadFactory r100) {
        return new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r100);
    }

    public static ExecutorService newFixedThreadPool(int r100) {
        return new PThreadPoolExecutor(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newFixedThreadPool(int r100, ThreadFactory r110) {
        return new PThreadPoolExecutor(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), r110);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r100) {
        return new PThreadScheduledThreadPoolExecutor(r100);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r100, ThreadFactory r101) {
        return new PThreadScheduledThreadPoolExecutor(r100, r101);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory r110) {
        return new FinalizableDelegatedExecutorService(new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), r110));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory r100) {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, r100));
    }
}
