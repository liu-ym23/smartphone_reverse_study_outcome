package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = null;

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> mCallback;
        final Future<V> mFuture;

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_utils_futures_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_camera_core_impl_utils_futures_Futures$CallbackListener__run$___twin___() {
            Object r0 = Futures.getDone(this.mFuture);     // Catch: Error -> L5 RuntimeException -> L7 ExecutionException -> L10
            this.mCallback.onSuccess(r0);
            return;
        L5:
            e = e;
        L8:
            this.mCallback.onFailure(e);
            return;
        L7:
            e = e;
        L10:
            e = move-exception;
            Throwable r1 = e.getCause();
            if (r1 != null) goto L14;
            this.mCallback.onFailure(e);
            return;
        L14:
            this.mCallback.onFailure(r1);
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + "," + this.mCallback;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_utils_futures_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(CallbackListener r1) {
            r1.androidx_camera_core_impl_utils_futures_Futures$CallbackListener__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public CallbackListener(Future<V> r1, FutureCallback<? super V> r2) {
            this.mFuture = r1;
            this.mCallback = r2;
        }
    }

    private Futures() {
    }

    public static /* synthetic */ Object a(ListenableFuture r0, ScheduledExecutorService r1, long r2, CallbackToFutureAdapter.Completer r4) {
        return lambda$makeTimeoutFuture$3(r0, r1, r2, r4);
    }

    public static /* synthetic */ Object b(ListenableFuture r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$nonCancellationPropagating$0(r0, r1);
    }

    public static /* synthetic */ Object c(ListenableFuture r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$transformAsyncOnCompletion$8(r0, r1);
    }

    public static /* synthetic */ void d(CallbackToFutureAdapter.Completer r0, Object r1, boolean r2, ListenableFuture r3) {
        lambda$makeTimeoutFuture$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void e(CallbackToFutureAdapter.Completer r0) {
        lambda$transformAsyncOnCompletion$7(r0);
    }

    public static /* synthetic */ void f(ScheduledFuture r0) {
        lambda$makeTimeoutFuture$5(r0);
    }

    public static /* synthetic */ Object g(ListenableFuture r0, ScheduledExecutorService r1, Object r2, boolean r3, long r4, CallbackToFutureAdapter.Completer r6) {
        return lambda$makeTimeoutFuture$6(r0, r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ Boolean h(CallbackToFutureAdapter.Completer r0, ListenableFuture r1, long r2) {
        return lambda$makeTimeoutFuture$1(r0, r1, r2);
    }

    public static /* synthetic */ void i(ScheduledFuture r0) {
        lambda$makeTimeoutFuture$2(r0);
    }

    static {
        IDENTITY_FUNCTION = new AnonymousClass2();
    }

    public static <V> ListenableFuture<List<V>> allAsList(Collection<? extends ListenableFuture<? extends V>> r3) {
        return new ListFuture(new ArrayList(r3), true, CameraXExecutors.directExecutor());
    }

    public static <V> V getDone(Future<V> r3) throws ExecutionException {
        Preconditions.checkState(r3.isDone(), "Future was expected to be done, " + r3);
        return (V) getUninterruptibly(r3);
    }

    public static <V> V getUninterruptibly(Future<V> r1) throws ExecutionException {
        boolean r0 = false;
    L12:
        V r2 = r1.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r2;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r1) {
        return new ImmediateFuture.ImmediateFailedFuture(r1);
    }

    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(Throwable r1) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(r1);
    }

    public static <V> ListenableFuture<V> immediateFuture(V r1) {
        if (r1 != null) goto L6;
        return ImmediateFuture.nullFuture();
    L6:
        return new ImmediateFuture.ImmediateSuccessfulFuture(r1);
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$2(ScheduledFuture r1) {
        r1.cancel(true);
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$5(ScheduledFuture r1) {
        r1.cancel(true);
    }

    private static /* synthetic */ void lambda$transformAsyncOnCompletion$7(CallbackToFutureAdapter.Completer r1) {
        r1.set(null);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(final ListenableFuture<V> r1) {
        Preconditions.checkNotNull(r1);
        if (r1.isDone() == false) goto L6;
        return r1;
    L6:
        return CallbackToFutureAdapter.getFuture(new g(r1));
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Collection<? extends ListenableFuture<? extends V>> r3) {
        return new ListFuture(new ArrayList(r3), false, CameraXExecutors.directExecutor());
    }

    public static <V> ListenableFuture<Void> transformAsyncOnCompletion(final ListenableFuture<V> r1) {
        return CallbackToFutureAdapter.getFuture(new e(r1));
    }

    private static /* synthetic */ Object lambda$nonCancellationPropagating$0(ListenableFuture r3, CallbackToFutureAdapter.Completer r4) throws Exception {
        propagateTransform(false, r3, IDENTITY_FUNCTION, r4, CameraXExecutors.directExecutor());
        return "nonCancellationPropagating[" + r3 + "]";
    }

    private static /* synthetic */ Object lambda$transformAsyncOnCompletion$8(ListenableFuture r1, final CallbackToFutureAdapter.Completer r2) throws Exception {
        r1.addListener(new c(r2), CameraXExecutors.directExecutor());
        return "transformVoidFuture [" + r1 + "]";
    }

    public static <V> void propagate(ListenableFuture<V> r2, CallbackToFutureAdapter.Completer<V> r3) {
        propagateTransform(r2, IDENTITY_FUNCTION, r3, CameraXExecutors.directExecutor());
    }

    public static <V> void addCallback(ListenableFuture<V> r1, FutureCallback<? super V> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        r1.addListener(new CallbackListener(r1, r2), r3);
    }

    private static /* synthetic */ Boolean lambda$makeTimeoutFuture$1(CallbackToFutureAdapter.Completer r3, ListenableFuture r4, long r5) throws Exception {
        return Boolean.valueOf(r3.setException(new TimeoutException("Future[" + r4 + "] is not done within " + r5 + " ms.")));
    }

    public static <V> ListenableFuture<V> makeTimeoutFuture(final long r1, final ScheduledExecutorService r3, final ListenableFuture<V> r4) {
        return CallbackToFutureAdapter.getFuture(new d(r4, r3, r1));
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r1, final Function<? super I, ? extends O> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        return transformAsync(r1, new AnonymousClass1(r2), r3);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> r1, AsyncFunction<? super I, ? extends O> r2, Executor r3) {
        ChainingListenableFuture r0 = new ChainingListenableFuture(r2, r1);
        r1.addListener(r0, r3);
        return r0;
    }

    private static /* synthetic */ Object lambda$makeTimeoutFuture$3(final ListenableFuture r1, ScheduledExecutorService r2, final long r3, final CallbackToFutureAdapter.Completer r5) throws Exception {
        propagate(r1, r5);
        if (r1.isDone() == true) goto L6;
        final ScheduledFuture r4 = r2.schedule(new a(r5, r1, r3), r3, TimeUnit.MILLISECONDS);
        r1.addListener(new b(r4), CameraXExecutors.directExecutor());
    L6:
        return "TimeoutFuture[" + r1 + "]";
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$4(CallbackToFutureAdapter.Completer r0, Object r1, boolean r2, ListenableFuture r3) {
        r0.set(r1);
        if (r2 == false) goto L6;
        r3.cancel(true);
        return;
    }

    public static <I, O> void propagateTransform(ListenableFuture<I> r1, Function<? super I, ? extends O> r2, CallbackToFutureAdapter.Completer<O> r3, Executor r4) {
        propagateTransform(true, r1, r2, r3, r4);
    }

    public static <V> ListenableFuture<V> makeTimeoutFuture(final long r8, final ScheduledExecutorService r10, final V r11, final boolean r12, final ListenableFuture<V> r13) {
        return CallbackToFutureAdapter.getFuture(new f(r13, r10, r11, r12, r8));
    }

    private static <I, O> void propagateTransform(boolean r1, final ListenableFuture<I> r2, final Function<? super I, ? extends O> r3, final CallbackToFutureAdapter.Completer<O> r4, Executor r5) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        addCallback(r2, new AnonymousClass3(r4, r3), r5);
        if (r1 == false) goto L6;
        r4.addCancellationListener(new AnonymousClass4(r2), CameraXExecutors.directExecutor());
        return;
    }

    private static /* synthetic */ Object lambda$makeTimeoutFuture$6(final ListenableFuture r1, ScheduledExecutorService r2, final Object r3, final boolean r4, long r5, final CallbackToFutureAdapter.Completer r7) throws Exception {
        propagate(r1, r7);
        if (r1.isDone() == true) goto L6;
        final ScheduledFuture<?> r6 = r2.schedule(new h(r7, r3, r4, r1), r5, TimeUnit.MILLISECONDS);
        r1.addListener(new i(r6), CameraXExecutors.directExecutor());
    L6:
        return "TimeoutFuture[" + r1 + "]";
    }
}
