package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> delegate;

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Future delegate() {
            return delegate();
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }

        public SimpleForwardingListenableFuture(ListenableFuture<V> r100) {
            r100.getClass();
            this.delegate = r100;
        }
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
    public abstract ListenableFuture<? extends V> delegate();

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public ForwardingListenableFuture() {
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Future delegate() {
        return delegate();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        delegate().addListener(r100, r101);
    }
}
