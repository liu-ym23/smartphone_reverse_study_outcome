package com.google.common.util.concurrent;

import com.google.common.collect.o0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingFuture<V> extends o0 implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        private final Future<V> delegate;

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public final Future<V> delegate() {
            return this.delegate;
        }

        public SimpleForwardingFuture(Future<V> r100) {
            r100.getClass();
            this.delegate = r100;
        }
    }

    @Override // com.google.common.collect.o0
    public abstract Future<? extends V> delegate();

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    public ForwardingFuture() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return delegate().cancel(r100);
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate().get(r100, r101);
    }
}
