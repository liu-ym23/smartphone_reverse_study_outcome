package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class e<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494324b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super Boolean> f494325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f494326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494328d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494327c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494327c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494328d == false) goto L5;
            return;
        L5:
            this.f494328d = true;
            this.f494325a.onNext(Boolean.TRUE);
            this.f494325a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494328d == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494328d = true;
            this.f494325a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494328d == false) goto L12;
            return;
        L12:
            if (this.f494326b.test(r100) == true) goto L14;
            this.f494328d = true;
            this.f494327c.dispose();
            this.f494325a.onNext(Boolean.FALSE);
            this.f494325a.onComplete();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494327c.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494327c, r100) == false) goto L6;
            this.f494327c = r100;
            this.f494325a.onSubscribe(this);
            return;
        }

        public a(Observer<? super Boolean> r100, Predicate<? super T> r101) {
            this.f494325a = r100;
            this.f494326b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Boolean> r100) {
        this.f494245a.subscribe(new a(r100, this.f494324b));
    }

    public e(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494324b = r101;
    }
}
