package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
public class ExecutorsEnhance {

    public static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService executorService;

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executorService.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executorService.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.executorService.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.executorService.shutdownNow();
        }

        public DelegatedExecutorService(ExecutorService r100) {
            this.executorService = r100;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.executorService.execute(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) throws InterruptedException {
            return this.executorService.invokeAll(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r100) throws InterruptedException, ExecutionException {
            return (T) this.executorService.invokeAny(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable r100) {
            return this.executorService.submit(r100);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> r100) {
            return this.executorService.submit(r100);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
            return this.executorService.awaitTermination(r100, r101);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable r100, T r101) {
            return this.executorService.submit(r100, r101);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException {
            return this.executorService.invokeAll(r100, r101, r102);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.executorService.invokeAny(r100, r101, r102);
        }
    }

    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        public void finalize() {
            super.shutdown();
        }

        public FinalizableDelegatedExecutorService(ExecutorService r100) {
            super(r100);
        }
    }

    public ExecutorsEnhance() {
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory r100) {
        ThreadPoolExcutorEnhance r101 = new ThreadPoolExcutorEnhance(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        r101.allowCoreThreadTimeOut(true);
        return new FinalizableDelegatedExecutorService(r101);
    }
}
