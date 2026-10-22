package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = null;
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    public static /* synthetic */ void a(ConstantObservable r0, Observable.Observer r1) {
        r0.lambda$addObserver$0(r1);
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r1) {
    }

    static {
        NULL_OBSERVABLE = new ConstantObservable(null);
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    private ConstantObservable(T r1) {
        this.mValueFuture = Futures.immediateFuture(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$addObserver$0(Observable.Observer r2) {
        r2.onNewData(this.mValueFuture.get());     // Catch: InterruptedException -> L4 Throwable -> L6
        return;
    L6:
        e = move-exception;
        r2.onError(e);
    }

    public static <U> Observable<U> withValue(U r1) {
        if (r1 != null) goto L6;
        return NULL_OBSERVABLE;
    L6:
        return new ConstantObservable(r1);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r3, final Observable.Observer<? super T> r4) {
        this.mValueFuture.addListener(new i(this, r4), r3);
    }
}
