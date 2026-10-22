package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    public static /* synthetic */ void a(Callable r100) {
        lambda$wrapTask$0(r100);
    }

    public abstract <T> Callable<T> wrapTask(Callable<T> r100);

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public WrappingExecutorService(ExecutorService r100) {
        r100.getClass();
        this.delegate = r100;
    }

    private static void lambda$wrapTask$0(Callable r100) {
        r100.call();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Platform.restoreInterruptIfIsInterruptedException(e);
        Object r101 = com.google.common.base.u.f274740a;
        if ((e instanceof RuntimeException) == true) goto L14;
        if ((e instanceof Error) == true) goto L12;
        throw new RuntimeException(e);
    L12:
        throw ((Error) e);
    L14:
        throw ((RuntimeException) e);
    }

    private <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> r100) {
        ImmutableList.a r101 = ImmutableList.builder();
        Iterator<? extends Callable<T>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.b(wrapTask(r102.next()));
        goto L4
    L7:
        return r101.e();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.delegate.execute(wrapTask(r100));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r100));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r100) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(wrapTasks(r100));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r100) {
        ExecutorService r101 = this.delegate;
        r100.getClass();
        return r101.submit(wrapTask(r100));
    }

    public Runnable wrapTask(Runnable r100) {
        final Callable r101 = wrapTask(Executors.callable(r100, null));
        return new e0(r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r100) {
        return this.delegate.submit(wrapTask(r100));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        return this.delegate.awaitTermination(r100, r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r100, @ParametricNullness T r101) {
        return this.delegate.submit(wrapTask(r100), r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r100), r101, r102);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(wrapTasks(r100), r101, r102);
    }
}
