package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class g2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494365b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f494367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494369d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494368c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494368c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494369d == true) goto L6;
            this.f494369d = true;
            this.f494366a.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494369d == true) goto L5;
            this.f494369d = true;
            this.f494366a.onError(r100);
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494369d == true) goto L13;
            this.f494366a.onNext(r100);
            if (this.f494367b.test(r100) == false) goto L14;
            this.f494369d = true;
            this.f494368c.dispose();
            this.f494366a.onComplete();
            return;
        L14:
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494368c.dispose();
            onError(th);
            return;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494368c, r100) == false) goto L6;
            this.f494368c = r100;
            this.f494366a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, Predicate<? super T> r101) {
            this.f494366a = r100;
            this.f494367b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494365b));
    }

    public g2(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494365b = r101;
    }
}
