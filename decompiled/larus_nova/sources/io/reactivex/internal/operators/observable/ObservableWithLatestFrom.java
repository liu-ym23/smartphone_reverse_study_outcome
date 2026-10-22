package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f494228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObservableSource<? extends U> f494229c;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Observer<? super R> downstream;
        final AtomicReference<Disposable> other;
        final AtomicReference<Disposable> upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            U r101 = get();
            if (r101 == null) goto L11;
            Object r102 = ObjectHelper.requireNonNull(this.combiner.apply(r100, r101), "The combiner returned a null value");     // Catch: Throwable -> L6
            this.downstream.onNext(r102);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this.upstream, r100);
        }

        public void otherError(Throwable r100) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(r100);
        }

        public boolean setOther(Disposable r100) {
            return DisposableHelper.setOnce(this.other, r100);
        }

        public WithLatestFromObserver(Observer<? super R> r100, BiFunction<? super T, ? super U, ? extends R> r101) {
            this.upstream = new AtomicReference();
            this.other = new AtomicReference();
            this.downstream = r100;
            this.combiner = r101;
        }
    }

    public final class a implements Observer<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WithLatestFromObserver<T, U, R> f494230a;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        public a(WithLatestFromObserver r100) {
            this.f494230a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494230a.otherError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(U r100) {
            this.f494230a.lazySet(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f494230a.setOther(r100);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        io.reactivex.observers.f r101 = new io.reactivex.observers.f(r100);
        WithLatestFromObserver r102 = new WithLatestFromObserver(r101, this.f494228b);
        r101.onSubscribe(r102);
        this.f494229c.subscribe(new a(r102));
        this.f494245a.subscribe(r102);
    }

    public ObservableWithLatestFrom(ObservableSource<T> r100, BiFunction<? super T, ? super U, ? extends R> r101, ObservableSource<? extends U> r102) {
        super(r100);
        this.f494228b = r101;
        this.f494229c = r102;
    }
}
