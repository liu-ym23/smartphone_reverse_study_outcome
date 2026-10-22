package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.g;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<c> implements g<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    final BiFunction<T, T, T> reducer;
    T value;

    @Override // wwc.b
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.parent.innerComplete(this.value);
        return;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.done = true;
        this.parent.innerError(r100);
    }

    @Override // wwc.b
    public void onNext(T r100) {
        if (this.done == true) goto L14;
        T r101 = this.value;
        if (r101 != null) goto L12;
        this.value = r100;
        return;
    L12:
        this.value = (T) ObjectHelper.requireNonNull(this.reducer.apply(r101, r100), "The reducer returned a null value");
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        SubscriptionHelper.setOnce(this, r100, Long.MAX_VALUE);
    }

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> r100, BiFunction<T, T, T> r101) {
        this.parent = r100;
        this.reducer = r101;
    }
}
