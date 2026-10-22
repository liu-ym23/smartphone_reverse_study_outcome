package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class n<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends U> f494552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ttc.a<? super U, ? super T> f494553c;

    public static final class a<T, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super U> f494554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ttc.a<? super U, ? super T> f494555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final U f494556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Disposable f494557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494558e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494557d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494557d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494558e == false) goto L5;
            return;
        L5:
            this.f494558e = true;
            this.f494554a.onNext(this.f494556c);
            this.f494554a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494558e == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494558e = true;
            this.f494554a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494558e == false) goto L10;
            return;
        L10:
            this.f494555b.accept(this.f494556c, r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            this.f494557d.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494557d, r100) == false) goto L6;
            this.f494557d = r100;
            this.f494554a.onSubscribe(this);
            return;
        }

        public a(Observer<? super U> r100, U r101, ttc.a<? super U, ? super T> r102) {
            this.f494554a = r100;
            this.f494555b = r102;
            this.f494556c = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        Object r101 = ObjectHelper.requireNonNull(this.f494552b.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L5
        this.f494245a.subscribe(new a(r100, r101, this.f494553c));
        return;
    L5:
        th = move-exception;
        EmptyDisposable.error(th, r100);
    }

    public n(ObservableSource<T> r100, Callable<? extends U> r101, ttc.a<? super U, ? super T> r102) {
        super(r100);
        this.f494552b = r101;
        this.f494553c = r102;
    }
}
