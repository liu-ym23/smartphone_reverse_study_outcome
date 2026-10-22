package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class g<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494355b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super Boolean> f494356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f494357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494359d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494358c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494358c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494359d == true) goto L6;
            this.f494359d = true;
            this.f494356a.onNext(Boolean.FALSE);
            this.f494356a.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494359d == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494359d = true;
            this.f494356a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494359d == false) goto L12;
            return;
        L12:
            if (this.f494357b.test(r100) == false) goto L14;
            this.f494359d = true;
            this.f494358c.dispose();
            this.f494356a.onNext(Boolean.TRUE);
            this.f494356a.onComplete();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494358c.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494358c, r100) == false) goto L6;
            this.f494358c = r100;
            this.f494356a.onSubscribe(this);
            return;
        }

        public a(Observer<? super Boolean> r100, Predicate<? super T> r101) {
            this.f494356a = r100;
            this.f494357b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Boolean> r100) {
        this.f494245a.subscribe(new a(r100, this.f494355b));
    }

    public g(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494355b = r101;
    }
}
