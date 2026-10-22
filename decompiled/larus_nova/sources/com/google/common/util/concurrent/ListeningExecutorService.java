package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use TestingExecutors.sameThreadScheduledExecutor, or wrap a real Executor from java.util.concurrent.Executors with MoreExecutors.listeningDecorator")
@ElementTypesAreNonnullByDefault
public interface ListeningExecutorService extends ExecutorService {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ListeningExecutorService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ Future $default$submit(ListeningExecutorService r100, Runnable r101) {
            return r100.submit(r101);
        }

        public static /* bridge */ /* synthetic */ Future $default$submit(ListeningExecutorService r100, Callable r101) {
            return r100.submit(r101);
        }

        public static /* bridge */ /* synthetic */ Future $default$submit(ListeningExecutorService r100, Runnable r101, @ParametricNullness Object r102) {
            return r100.submit(r101, r102);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) throws InterruptedException;

    @Override // java.util.concurrent.ExecutorService
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException;

    ListenableFuture<?> submit(Runnable r100);

    <T> ListenableFuture<T> submit(Runnable r100, @ParametricNullness T r101);

    <T> ListenableFuture<T> submit(Callable<T> r100);

    /* bridge */ /* synthetic */ Future submit(Runnable r100);

    /* bridge */ /* synthetic */ Future submit(Runnable r100, @ParametricNullness Object r101);

    /* bridge */ /* synthetic */ Future submit(Callable r100);
}
