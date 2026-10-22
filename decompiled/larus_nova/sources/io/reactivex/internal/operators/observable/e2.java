package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class e2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494339b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f494341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f494343d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494342c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494342c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494341b == true) goto L6;
            this.f494341b = true;
            this.f494342c.dispose();
            this.f494340a.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494341b == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494341b = true;
            this.f494342c.dispose();
            this.f494340a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494341b == true) goto L14;
            long r101 = this.f494343d;
            long r102 = r101 - 1;
            this.f494343d = r102;
            if (r101 > 0) goto L7;
            return;
        L7:
            if (r102 != 0) goto L9;
            boolean r103 = true;
        L10:
            this.f494340a.onNext(r100);
            if (r103 == false) goto L16;
            onComplete();
            return;
        L16:
            return;
        L9:
            r103 = false;
            goto L10
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494342c, r100) == false) goto L9;
            this.f494342c = r100;
            if (this.f494343d != 0) goto L7;
            this.f494341b = true;
            r100.dispose();
            EmptyDisposable.complete(this.f494340a);
            return;
        L7:
            this.f494340a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, long r101) {
            this.f494340a = r100;
            this.f494343d = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494339b));
    }

    public e2(ObservableSource<T> r100, long r101) {
        super(r100);
        this.f494339b = r101;
    }
}
