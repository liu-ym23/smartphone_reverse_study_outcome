package io.reactivex.internal.operators.single;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class SingleFlatMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleSource<T> f494764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f494765b;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, io.reactivex.b, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final io.reactivex.b downstream;
        final Function<? super T, ? extends CompletableSource> mapper;

        @Override // io.reactivex.b
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r100) {
            DisposableHelper.replace(this, r100);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r100) {
            CompletableSource r101 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r100), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r101.subscribe(this);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }

        public FlatMapCompletableObserver(io.reactivex.b r100, Function<? super T, ? extends CompletableSource> r101) {
            this.downstream = r100;
            this.mapper = r101;
        }
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        FlatMapCompletableObserver r101 = new FlatMapCompletableObserver(r100, this.f494765b);
        r100.onSubscribe(r101);
        this.f494764a.subscribe(r101);
    }

    public SingleFlatMapCompletable(SingleSource<T> r100, Function<? super T, ? extends CompletableSource> r101) {
        this.f494764a = r100;
        this.f494765b = r101;
    }
}
