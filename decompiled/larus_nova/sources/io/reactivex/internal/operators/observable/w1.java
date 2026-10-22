package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class w1<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f494701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<R> f494702c;

    public static final class a<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super R> f494703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f494704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public R f494705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Disposable f494706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494707e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494706d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494706d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494707e == false) goto L5;
            return;
        L5:
            this.f494707e = true;
            this.f494703a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494707e == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494707e = true;
            this.f494703a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494707e == false) goto L5;
            return;
        L5:
            R r101 = this.f494705c;
            R r102 = (R) ObjectHelper.requireNonNull(this.f494704b.apply(r101, r100), "The accumulator returned a null value");
            this.f494705c = r102;
            this.f494703a.onNext(r102);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494706d.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494706d, r100) == false) goto L6;
            this.f494706d = r100;
            this.f494703a.onSubscribe(this);
            this.f494703a.onNext(this.f494705c);
            return;
        }

        public a(Observer<? super R> r100, BiFunction<R, ? super T, R> r101, R r102) {
            this.f494703a = r100;
            this.f494704b = r101;
            this.f494705c = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        Object r101 = ObjectHelper.requireNonNull(this.f494702c.call(), "The seed supplied is null");     // Catch: Throwable -> L5
        this.f494245a.subscribe(new a(r100, this.f494701b, r101));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }

    public w1(ObservableSource<T> r100, Callable<R> r101, BiFunction<R, ? super T, R> r102) {
        super(r100);
        this.f494701b = r102;
        this.f494702c = r101;
    }
}
