package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {

    @CheckForNull
    private volatile InterruptibleTask<?> task;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            ListenableFuture<V> r100 = this.callable.call();
            com.google.common.base.m.k(r100, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return r100;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ Object runInterruptibly() throws Exception {
            return runInterruptibly();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable r100) {
            this.this$0.setException(r100);
        }

        public void afterRanInterruptiblySuccess(ListenableFuture<V> r100) {
            this.this$0.setFuture(r100);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ void afterRanInterruptiblySuccess(Object r100) {
            afterRanInterruptiblySuccess((ListenableFuture) r100);
        }

        public TrustedFutureInterruptibleAsyncTask(TrustedListenableFutureTask r100, AsyncCallable<V> r101) {
            this.this$0 = r100;
            r101.getClass();
            this.callable = r101;
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable r100) {
            this.this$0.setException(r100);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(@ParametricNullness V r100) {
            this.this$0.set(r100);
        }

        public TrustedFutureInterruptibleTask(TrustedListenableFutureTask r100, Callable<V> r101) {
            this.this$0 = r100;
            r101.getClass();
            this.callable = r101;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        InterruptibleTask<?> r100 = this.task;
        if (r100 == null) goto L7;
        return "task=[" + r100 + "]";
    L7:
        return super.pendingToString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> r100 = this.task;
        if (r100 == null) goto L5;
        r100.run();
    L5:
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        super.afterDone();
        if (wasInterrupted() == false) goto L7;
        InterruptibleTask<?> r100 = this.task;
        if (r100 == null) goto L7;
        r100.interruptTask();
    L7:
        this.task = null;
    }

    public TrustedListenableFutureTask(AsyncCallable<V> r100) {
        this.task = new TrustedFutureInterruptibleAsyncTask(this, r100);
    }

    public static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> r100) {
        return new TrustedListenableFutureTask(r100);
    }

    public TrustedListenableFutureTask(Callable<V> r100) {
        this.task = new TrustedFutureInterruptibleTask(this, r100);
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> r100) {
        return new TrustedListenableFutureTask(r100);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable r100, @ParametricNullness V r101) {
        return new TrustedListenableFutureTask(Executors.callable(r100, r101));
    }
}
