package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class r1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f494631b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f494633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494634c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494634c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494634c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494632a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            T r101 = this.f494633b.apply(r100);     // Catch: Throwable -> L8
            if (r101 != null) goto L6;
            NullPointerException r102 = new NullPointerException("The supplied value is null");
            r102.initCause(r100);
            this.f494632a.onError(r102);
            return;
        L6:
            this.f494632a.onNext(r101);
            this.f494632a.onComplete();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494632a.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494632a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494634c, r100) == false) goto L6;
            this.f494634c = r100;
            this.f494632a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, Function<? super Throwable, ? extends T> r101) {
            this.f494632a = r100;
            this.f494633b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494631b));
    }

    public r1(ObservableSource<T> r100, Function<? super Throwable, ? extends T> r101) {
        super(r100);
        this.f494631b = r101;
    }
}
