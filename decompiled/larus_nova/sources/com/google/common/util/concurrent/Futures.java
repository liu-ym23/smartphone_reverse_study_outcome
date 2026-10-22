package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_common_util_concurrent_Futures$CallbackListener__run$___twin___() {
            Future<V> r100 = this.future;
            if ((r100 instanceof InternalFutureFailureAccess) == false) goto L19;
            Throwable r101 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r100);
            if (r101 == null) goto L19;
            this.callback.onFailure(r101);
            return;
        L19:
            Object r102 = Futures.getDone(this.future);     // Catch: Error -> L11 RuntimeException -> L13 ExecutionException -> L16
            this.callback.onSuccess(r102);
            return;
        L11:
            e = e;
        L14:
            this.callback.onFailure(e);
            return;
        L13:
            e = e;
        L16:
            e = move-exception;
            this.callback.onFailure(e.getCause());
        }

        public String toString() {
            com.google.common.base.j.a r100 = com.google.common.base.j.b(this);
            r100.d(this.callback);
            return r100.toString();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(CallbackListener r100) {
            r100.com_google_common_util_concurrent_Futures$CallbackListener__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public CallbackListener(Future<V> r100, FutureCallback<? super V> r101) {
            this.future = r100;
            this.callback = r101;
        }
    }

    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        private FutureCombiner(boolean r100, ImmutableList<ListenableFuture<? extends V>> r101) {
            this.allMustSucceed = r100;
            this.futures = r101;
        }

        public <C> ListenableFuture<C> call(Callable<C> r100, Executor r101) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r101, r100);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> r100, Executor r101) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r101, r100);
        }

        public ListenableFuture<?> run(final Runnable r100, Executor r101) {
            return call(new AnonymousClass1(this, r100), r101);
        }

        public /* synthetic */ FutureCombiner(boolean r100, ImmutableList r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {

        @CheckForNull
        private InCompletionOrderState<T> state;

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.state = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            InCompletionOrderState<T> r100 = this.state;
            if (r100 != null) goto L5;
            return null;
        L5:
            return "inputCount=[" + InCompletionOrderState.access$400(r100).length + "], remaining=[" + InCompletionOrderState.access$500(r100).get() + "]";
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> r100) {
            this.state = r100;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean r100) {
            InCompletionOrderState<T> r101 = this.state;
            if (super.cancel(r100) == false) goto L6;
            Objects.requireNonNull(r101);
            InCompletionOrderState.access$300(r101, r100);
            return true;
        L6:
            return false;
        }

        public /* synthetic */ InCompletionOrderFuture(InCompletionOrderState r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.wasCancelled == false) goto L16;
            ListenableFuture<? extends T>[] r100 = this.inputFutures;
            int r101 = r100.length;
            int r102 = 0;
        L7:
            if (r102 >= r101) goto L17;
            ListenableFuture<? extends T> r103 = r100[r102];
            if (r103 == null) goto L11;
            r103.cancel(this.shouldInterrupt);
        L11:
            r102 = r102 + 1;
            goto L7
        L17:
            return;
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] r100) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = r100;
            this.incompleteOutputCount = new AtomicInteger(r100.length);
        }

        public static /* synthetic */ ListenableFuture[] access$400(InCompletionOrderState r100) {
            return r100.inputFutures;
        }

        public static /* synthetic */ AtomicInteger access$500(InCompletionOrderState r100) {
            return r100.incompleteOutputCount;
        }

        private void recordOutputCancellation(boolean r100) {
            this.wasCancelled = true;
            if (r100 == true) goto L5;
            this.shouldInterrupt = false;
        L5:
            recordCompletion();
        }

        public /* synthetic */ InCompletionOrderState(ListenableFuture[] r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ void access$300(InCompletionOrderState r100, boolean r101) {
            r100.recordOutputCancellation(r101);
        }

        private void recordInputCompletion(ImmutableList<AbstractFuture<T>> r100, int r101) {
            ListenableFuture<? extends T> r102 = this.inputFutures[r101];
            Objects.requireNonNull(r102);
            ListenableFuture<? extends T> r103 = r102;
            this.inputFutures[r101] = null;
            int r104 = this.delegateIndex;
        L4:
            if (r104 >= r100.size()) goto L10;
            if (r100.get(r104).setFuture(r103) == true) goto L7;
            r104 = r104 + 1;
            goto L4
        L7:
            recordCompletion();
            this.delegateIndex = r104 + 1;
            return;
        L10:
            this.delegateIndex = r100.size();
        }

        public static /* synthetic */ void access$600(InCompletionOrderState r100, ImmutableList r101, int r102) {
            r100.recordInputCompletion(r101, r102);
        }
    }

    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {

        @CheckForNull
        private ListenableFuture<V> delegate;

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_Futures$NonCancellationPropagatingFuture_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_common_util_concurrent_Futures$NonCancellationPropagatingFuture__run$___twin___() {
            ListenableFuture<V> r100 = this.delegate;
            if (r100 == null) goto L6;
            setFuture(r100);
            return;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            ListenableFuture<V> r100 = this.delegate;
            if (r100 != null) goto L5;
            return null;
        L5:
            return "delegate=[" + r100 + "]";
        }

        public NonCancellationPropagatingFuture(ListenableFuture<V> r100) {
            this.delegate = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_Futures$NonCancellationPropagatingFuture_com_larus_apm_impl_protector_RunnableLancet_run(NonCancellationPropagatingFuture r100) {
            r100.com_google_common_util_concurrent_Futures$NonCancellationPropagatingFuture__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ void a(Future r100) {
        lambda$scheduleAsync$0(r100);
    }

    public static /* synthetic */ void b(InCompletionOrderState r100, ImmutableList r101, int r102) {
        lambda$inCompletionOrder$1(r100, r101, r102);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        ImmediateFuture.ImmediateCancelledFuture<Object> r100 = ImmediateFuture.ImmediateCancelledFuture.INSTANCE;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    private Futures() {
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return ImmediateFuture.NULL;
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> r100) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r100), true);
    }

    @ParametricNullness
    public static <V> V getDone(Future<V> r100) throws ExecutionException {
        com.google.common.base.m.s(r100.isDone(), "Future was expected to be done: %s", r100);
        return (V) Uninterruptibles.getUninterruptibly(r100);
    }

    @ParametricNullness
    public static <V> V getUnchecked(Future<V> r100) {
        r100.getClass();
        return (V) Uninterruptibles.getUninterruptibly(r100);
    L5:
        e = move-exception;
        wrapAndThrowUnchecked(e.getCause());
        throw new AssertionError();
    }

    private static <T> ListenableFuture<? extends T>[] gwtCompatibleToArray(Iterable<? extends ListenableFuture<? extends T>> r100) {
        if ((r100 instanceof Collection) == false) goto L5;
        Collection r101 = (Collection) r100;
    L7:
        return (ListenableFuture[]) r101.toArray(new ListenableFuture[0]);
    L5:
        r101 = ImmutableList.copyOf(r100);
        goto L7
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r100) {
        r100.getClass();
        return new ImmediateFuture.ImmediateFailedFuture(r100);
    }

    public static <V> ListenableFuture<V> immediateFuture(@ParametricNullness V r100) {
        if (r100 != null) goto L6;
        return (ListenableFuture<V>) ImmediateFuture.NULL;
    L6:
        return new ImmediateFuture(r100);
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> r100) {
        ListenableFuture[] r101 = gwtCompatibleToArray(r100);
        AnonymousClass1 r102 = null;
        final InCompletionOrderState r103 = new InCompletionOrderState(r101, r102);
        ImmutableList.a r104 = ImmutableList.builderWithExpectedSize(r101.length);
        final int r105 = 0;
        int r106 = 0;
    L4:
        if (r106 >= r101.length) goto L6;
        r104.b(new InCompletionOrderFuture(r103, r102));
        r106 = r106 + 1;
        goto L4
    L6:
        final ImmutableList<ListenableFuture<T>> r107 = r104.e();
    L8:
        if (r105 >= r101.length) goto L10;
        r101[r105].addListener(new u(r103, r107, r105), MoreExecutors.directExecutor());
        r105 = r105 + 1;
        goto L8
    L10:
        return r107;
    }

    private static /* synthetic */ void lambda$scheduleAsync$0(Future r100) {
        r100.cancel(false);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> r100) {
        if (r100.isDone() == false) goto L5;
        return r100;
    L5:
        NonCancellationPropagatingFuture r101 = new NonCancellationPropagatingFuture(r100);
        r100.addListener(r101, MoreExecutors.directExecutor());
        return r101;
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> r100) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r100), false);
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> r100) {
        boolean r101 = false;
        return new FutureCombiner(r101, ImmutableList.copyOf(r100), null);
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> r100) {
        boolean r101 = true;
        return new FutureCombiner(r101, ImmutableList.copyOf(r100), null);
    }

    private static void wrapAndThrowUnchecked(Throwable r100) {
        if ((r100 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r100);
    L7:
        throw new UncheckedExecutionException(r100);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... r100) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r100), true);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... r100) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r100), false);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... r100) {
        boolean r101 = false;
        return new FutureCombiner(r101, ImmutableList.copyOf(r100), null);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... r100) {
        boolean r101 = true;
        return new FutureCombiner(r101, ImmutableList.copyOf(r100), null);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r100, Class<X> r101) throws Exception {
        return (V) FuturesGetChecked.getChecked(r100, r101);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> r100, final com.google.common.base.g<? super I, ? extends O> r101) {
        r100.getClass();
        r101.getClass();
        return new AnonymousClass1(r100, r101);
    }

    public static ListenableFuture<Void> submit(Runnable r100, Executor r101) {
        TrustedListenableFutureTask r102 = TrustedListenableFutureTask.create(r100, null);
        r101.execute(r102);
        return r102;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> r100, Executor r101) {
        TrustedListenableFutureTask r102 = TrustedListenableFutureTask.create(r100);
        r101.execute(r102);
        return r102;
    }

    public static <O> ListenableFuture<O> submit(Callable<O> r100, Executor r101) {
        TrustedListenableFutureTask r102 = TrustedListenableFutureTask.create(r100);
        r101.execute(r102);
        return r102;
    }

    public static <V> void addCallback(ListenableFuture<V> r100, FutureCallback<? super V> r101, Executor r102) {
        r101.getClass();
        r100.addListener(new CallbackListener(r100, r101), r102);
    }

    private static /* synthetic */ void lambda$inCompletionOrder$1(InCompletionOrderState r100, ImmutableList r101, int r102) {
        InCompletionOrderState.access$600(r100, r101, r102);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r100, com.google.common.base.g<? super I, ? extends O> r101, Executor r102) {
        return AbstractTransformFuture.create(r100, r101, r102);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> r100, AsyncFunction<? super I, ? extends O> r101, Executor r102) {
        return AbstractTransformFuture.create(r100, r101, r102);
    }

    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> r100, Class<X> r101, com.google.common.base.g<? super X, ? extends V> r102, Executor r103) {
        return AbstractCatchingFuture.create(r100, r101, r102, r103);
    }

    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> r100, Class<X> r101, AsyncFunction<? super X, ? extends V> r102, Executor r103) {
        return AbstractCatchingFuture.create(r100, r101, r102, r103);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r100, Class<X> r101, long r102, TimeUnit r103) throws Exception {
        return (V) FuturesGetChecked.getChecked(r100, r101, r102, r103);
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> r100, long r101, TimeUnit r102, ScheduledExecutorService r103) {
        TrustedListenableFutureTask r104 = TrustedListenableFutureTask.create(r100);
        final ScheduledFuture<?> r105 = r103.schedule(r104, r101, r102);
        r104.addListener(new t(r105), MoreExecutors.directExecutor());
        return r104;
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> r100, long r101, TimeUnit r102, ScheduledExecutorService r103) {
        if (r100.isDone() == false) goto L6;
        return r100;
    L6:
        return TimeoutFuture.create(r100, r101, r102, r103);
    }
}
