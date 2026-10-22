package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class h2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494379b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f494381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494383d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494382c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494382c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494383d == false) goto L5;
            return;
        L5:
            this.f494383d = true;
            this.f494380a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494383d == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494383d = true;
            this.f494380a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494383d == false) goto L14;
            return;
        L14:
            if (this.f494381b.test(r100) == true) goto L9;
            this.f494383d = true;
            this.f494382c.dispose();
            this.f494380a.onComplete();
            return;
        L9:
            this.f494380a.onNext(r100);
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494382c.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494382c, r100) == false) goto L6;
            this.f494382c = r100;
            this.f494380a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, Predicate<? super T> r101) {
            this.f494380a = r100;
            this.f494381b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494379b));
    }

    public h2(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494379b = r101;
    }
}
