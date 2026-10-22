package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class q1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f494609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f494610c;

    public static final class a<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f494612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f494613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SequentialDisposable f494614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f494616f;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494616f == false) goto L5;
            return;
        L5:
            this.f494616f = true;
            this.f494615e = true;
            this.f494611a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494615e == true) goto L5;
            this.f494615e = true;
            if (this.f494613c == true) goto L13;
        L25:
            ObservableSource<? extends T> r101 = this.f494612b.apply(r100);     // Catch: Throwable -> L22
            if (r101 != null) goto L20;
            NullPointerException r102 = new NullPointerException("Observable is null");
            r102.initCause(r100);
            this.f494611a.onError(r102);
            return;
        L20:
            r101.subscribe(this);
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494611a.onError(new CompositeException(new Throwable[]{r100, th}));
            return;
        L13:
            if ((r100 instanceof Exception) == true) goto L25;
            this.f494611a.onError(r100);
            return;
        L5:
            if (this.f494616f == false) goto L8;
            RxJavaPlugins.onError(r100);
            return;
        L8:
            this.f494611a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494616f == false) goto L5;
            return;
        L5:
            this.f494611a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f494614d.replace(r100);
        }

        public a(Observer<? super T> r100, Function<? super Throwable, ? extends ObservableSource<? extends T>> r101, boolean r102) {
            this.f494611a = r100;
            this.f494612b = r101;
            this.f494613c = r102;
            this.f494614d = new SequentialDisposable();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        a r101 = new a(r100, this.f494609b, this.f494610c);
        r100.onSubscribe(r101.f494614d);
        this.f494245a.subscribe(r101);
    }

    public q1(ObservableSource<T> r100, Function<? super Throwable, ? extends ObservableSource<? extends T>> r101, boolean r102) {
        super(r100);
        this.f494609b = r101;
        this.f494610c = r102;
    }
}
