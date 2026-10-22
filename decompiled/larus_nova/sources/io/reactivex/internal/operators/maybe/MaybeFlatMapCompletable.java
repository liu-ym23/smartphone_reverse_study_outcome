package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeFlatMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaybeSource<T> f493762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f493763b;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, io.reactivex.b, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final io.reactivex.b downstream;
        final Function<? super T, ? extends CompletableSource> mapper;

        @Override // io.reactivex.k
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

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            DisposableHelper.replace(this, r100);
        }

        @Override // io.reactivex.k
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
        FlatMapCompletableObserver r101 = new FlatMapCompletableObserver(r100, this.f493763b);
        r100.onSubscribe(r101);
        this.f493762a.subscribe(r101);
    }

    public MaybeFlatMapCompletable(MaybeSource<T> r100, Function<? super T, ? extends CompletableSource> r101) {
        this.f493762a = r100;
        this.f493763b = r101;
    }
}
