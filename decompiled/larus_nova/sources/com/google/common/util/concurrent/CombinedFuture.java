package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    @CheckForNull
    private CombinedFuture<V>.CombinedFutureInterruptibleTask<?> task;

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

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

        public void setValue(ListenableFuture<V> r100) {
            this.this$0.setFuture(r100);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object r100) {
            setValue((ListenableFuture) r100);
        }

        public AsyncCallableInterruptibleTask(CombinedFuture r100, AsyncCallable<V> r101, Executor r102) {
            this.this$0 = r100;
            super(r100, r102);
            r101.getClass();
            this.callable = r101;
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(@ParametricNullness V r100) {
            this.this$0.set(r100);
        }

        public CallableInterruptibleTask(CombinedFuture r100, Callable<V> r101, Executor r102) {
            this.this$0 = r100;
            super(r100, r102);
            r101.getClass();
            this.callable = r101;
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;

        public abstract void setValue(@ParametricNullness T r100);

        public final void execute() {
            this.listenerExecutor.execute(this);     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            this.this$0.setException(e);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblyFailure(Throwable r100) {
            CombinedFuture.access$002(this.this$0, null);
            if ((r100 instanceof ExecutionException) == false) goto L6;
            this.this$0.setException(((ExecutionException) r100).getCause());
            return;
        L6:
            if ((r100 instanceof CancellationException) == false) goto L8;
            this.this$0.cancel(false);
            return;
        L8:
            this.this$0.setException(r100);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblySuccess(@ParametricNullness T r100) {
            CombinedFuture.access$002(this.this$0, null);
            setValue(r100);
        }

        public CombinedFutureInterruptibleTask(CombinedFuture r100, Executor r101) {
            this.this$0 = r100;
            r101.getClass();
            this.listenerExecutor = r101;
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void collectOneValue(int r100, @CheckForNull Object r101) {
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void handleAllCompleted() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> r100 = this.task;
        if (r100 == null) goto L6;
        r100.execute();
        return;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void interruptTask() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> r100 = this.task;
        if (r100 == null) goto L6;
        r100.interruptTask();
        return;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void releaseResources(AggregateFuture.ReleaseResourcesReason r100) {
        super.releaseResources(r100);
        if (r100 != AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) goto L6;
        this.task = null;
        return;
    }

    public static /* synthetic */ CombinedFutureInterruptibleTask access$002(CombinedFuture r100, CombinedFutureInterruptibleTask r101) {
        r100.task = r101;
        return r101;
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> r100, boolean r101, Executor r102, AsyncCallable<V> r103) {
        super(r100, r101, false);
        this.task = new AsyncCallableInterruptibleTask(this, r103, r102);
        init();
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> r100, boolean r101, Executor r102, Callable<V> r103) {
        super(r100, r101, false);
        this.task = new CallableInterruptibleTask(this, r103, r102);
        init();
    }
}
