package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
@ElementTypesAreNonnullByDefault
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    public static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        public TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean r100) {
            return super.cancel(r100);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r100, Executor r101) {
            super.addListener(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r100, r101);
        }
    }

    public FluentFuture() {
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> r100) {
        if ((r100 instanceof FluentFuture) == false) goto L6;
        return (FluentFuture) r100;
    L6:
        return new ForwardingFluentFuture(r100);
    }

    public static <V> FluentFuture<V> from(FluentFuture<V> r100) {
        r100.getClass();
        return r100;
    }

    public final void addCallback(FutureCallback<? super V> r100, Executor r101) {
        Futures.addCallback(this, r100, r101);
    }

    public final <T> FluentFuture<T> transform(com.google.common.base.g<? super V, T> r100, Executor r101) {
        return (FluentFuture) Futures.transform(this, r100, r101);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> r100, Executor r101) {
        return (FluentFuture) Futures.transformAsync(this, r100, r101);
    }

    public final <X extends Throwable> FluentFuture<V> catching(Class<X> r100, com.google.common.base.g<? super X, ? extends V> r101, Executor r102) {
        return (FluentFuture) Futures.catching(this, r100, r101, r102);
    }

    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> r100, AsyncFunction<? super X, ? extends V> r101, Executor r102) {
        return (FluentFuture) Futures.catchingAsync(this, r100, r101, r102);
    }

    public final FluentFuture<V> withTimeout(long r100, TimeUnit r101, ScheduledExecutorService r102) {
        return (FluentFuture) Futures.withTimeout(this, r100, r101, r102);
    }
}
