package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FutureChain<V> implements ListenableFuture<V> {
    CallbackToFutureAdapter.Completer<V> mCompleter;
    private final ListenableFuture<V> mDelegate;

    public V get() throws InterruptedException, ExecutionException {
        return (V) this.mDelegate.get();
    }

    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this));
    }

    public FutureChain(ListenableFuture<V> r1) {
        this.mDelegate = (ListenableFuture) Preconditions.checkNotNull(r1);
    }

    public static <V> FutureChain<V> from(ListenableFuture<V> r1) {
        if ((r1 instanceof FutureChain) == false) goto L6;
        return (FutureChain) r1;
    L6:
        return new FutureChain(r1);
    }

    public boolean cancel(boolean r2) {
        return this.mDelegate.cancel(r2);
    }

    boolean set(V r2) {
        CallbackToFutureAdapter.Completer<V> r0 = this.mCompleter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.set(r2);
    }

    boolean setException(Throwable r2) {
        CallbackToFutureAdapter.Completer<V> r0 = this.mCompleter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.setException(r2);
    }

    public final void addCallback(FutureCallback<? super V> r1, Executor r2) {
        Futures.addCallback(this, r1, r2);
    }

    public void addListener(Runnable r2, Executor r3) {
        this.mDelegate.addListener(r2, r3);
    }

    public V get(long r2, TimeUnit r4) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) this.mDelegate.get(r2, r4);
    }

    public final <T> FutureChain<T> transform(Function<? super V, T> r1, Executor r2) {
        return (FutureChain) Futures.transform(this, r1, r2);
    }

    public final <T> FutureChain<T> transformAsync(AsyncFunction<? super V, T> r1, Executor r2) {
        return (FutureChain) Futures.transformAsync(this, r1, r2);
    }
}
