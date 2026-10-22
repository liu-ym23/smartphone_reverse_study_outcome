package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {
    private AsyncFunction<? super I, ? extends O> mFunction;
    private ListenableFuture<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel;
    private final CountDownLatch mOutputCreated;
    volatile ListenableFuture<? extends O> mOutputFuture;

    public void androidx_camera_core_impl_utils_futures_ChainingListenableFuture__run$___twin___() {
        Object r1 = Futures.getUninterruptibly(this.mInputFuture);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16 ExecutionException -> L18 CancellationException -> L20
        final ListenableFuture<? extends O> r2 = this.mFunction.apply(r1);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        this.mOutputFuture = r2;     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        if (isCancelled() == false) goto L9;
        r2.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        this.mOutputFuture = null;     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L7:
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        return;
    L9:
        r2.addListener(new AnonymousClass1(this, r2), CameraXExecutors.directExecutor());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L24:
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        return;
    L20:
        cancel(false);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L18:
        e = move-exception;
        setException(e.getCause());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L12:
        e = move-exception;
        setException(e);     // Catch: Throwable -> L10
    L16:
        e = move-exception;
        setException(e.getCause());     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        setException(e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_camera_core_impl_utils_futures_ChainingListenableFuture_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain
    public O get() throws InterruptedException, ExecutionException {
        if (isDone() == true) goto L11;
        ListenableFuture<? extends I> r0 = this.mInputFuture;
        if (r0 == null) goto L7;
        r0.get();
    L7:
        this.mOutputCreated.await();
        ListenableFuture<? extends O> r1 = this.mOutputFuture;
        if (r1 == null) goto L11;
        r1.get();
    L11:
        return (O) super.get();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_camera_core_impl_utils_futures_ChainingListenableFuture_com_larus_apm_impl_protector_RunnableLancet_run(ChainingListenableFuture r1) {
        r1.androidx_camera_core_impl_utils_futures_ChainingListenableFuture__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private <E> E takeUninterruptibly(BlockingQueue<E> r2) {
        boolean r0 = false;
    L12:
        E r3 = r2.take();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r3;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain
    public boolean cancel(boolean r3) {
        if (super.cancel(r3) == false) goto L6;
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(r3));
        cancel(this.mInputFuture, r3);
        cancel(this.mOutputFuture, r3);
        return true;
    L6:
        return false;
    }

    public ChainingListenableFuture(AsyncFunction<? super I, ? extends O> r3, ListenableFuture<? extends I> r4) {
        this.mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
        this.mOutputCreated = new CountDownLatch(1);
        this.mFunction = (AsyncFunction) Preconditions.checkNotNull(r3);
        this.mInputFuture = (ListenableFuture) Preconditions.checkNotNull(r4);
    }

    private void cancel(Future<?> r1, boolean r2) {
        if (r1 == null) goto L5;
        r1.cancel(r2);
        return;
    }

    private <E> void putUninterruptibly(BlockingQueue<E> r2, E r3) {
        boolean r0 = false;
    L12:
        r2.put(r3);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain
    public O get(long r8, TimeUnit r10) throws TimeoutException, ExecutionException, InterruptedException {
        if (isDone() == true) goto L18;
        TimeUnit r0 = TimeUnit.NANOSECONDS;
        if (r10 == r0) goto L7;
        r8 = r0.convert(r8, r10);
        r10 = r0;
    L7:
        ListenableFuture<? extends I> r1 = this.mInputFuture;
        if (r1 == null) goto L10;
        long r3 = System.nanoTime();
        r1.get(r8, r10);
        r8 = r8 - Math.max(0, System.nanoTime() - r3);
    L10:
        long r4 = System.nanoTime();
        if (this.mOutputCreated.await(r8, r10) == false) goto L16;
        r8 = r8 - Math.max(0, System.nanoTime() - r4);
        ListenableFuture<? extends O> r2 = this.mOutputFuture;
        if (r2 == null) goto L18;
        r2.get(r8, r10);
        goto L18
    L16:
        throw new TimeoutException();
    L18:
        return (O) super.get(r8, r10);
    }
}
