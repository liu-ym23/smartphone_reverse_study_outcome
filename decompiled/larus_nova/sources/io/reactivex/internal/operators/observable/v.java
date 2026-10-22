package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class v<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends io.reactivex.o<R>> f494685b;

    public static final class a<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super R> f494686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends io.reactivex.o<R>> f494687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f494688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Disposable f494689d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494689d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494689d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494688c == false) goto L5;
            return;
        L5:
            this.f494688c = true;
            this.f494686a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494688c == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494688c = true;
            this.f494686a.onError(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494688c == true) goto L5;
            io.reactivex.o r101 = (io.reactivex.o) ObjectHelper.requireNonNull(this.f494687b.apply(r100), "The selector returned a null Notification");     // Catch: Throwable -> L22
            if (r101.d() == false) goto L15;
            this.f494689d.dispose();
            onError(r101.b());
            return;
        L15:
            if (r101.f495052a != null) goto L17;
            boolean r102 = true;
        L18:
            if (r102 == false) goto L20;
            this.f494689d.dispose();
            onComplete();
            return;
        L20:
            this.f494686a.onNext((Object) r101.c());
            return;
        L17:
            r102 = false;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494689d.dispose();
            onError(th);
            return;
        L5:
            if ((r100 instanceof io.reactivex.o) == false) goto L27;
            io.reactivex.o r103 = (io.reactivex.o) r100;
            if (r103.d() == false) goto L28;
            RxJavaPlugins.onError(r103.b());
            return;
        L28:
            return;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494689d, r100) == false) goto L6;
            this.f494689d = r100;
            this.f494686a.onSubscribe(this);
            return;
        }

        public a(Observer<? super R> r100, Function<? super T, ? extends io.reactivex.o<R>> r101) {
            this.f494686a = r100;
            this.f494687b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        this.f494245a.subscribe(new a(r100, this.f494685b));
    }

    public v(ObservableSource<T> r100, Function<? super T, ? extends io.reactivex.o<R>> r101) {
        super(r100);
        this.f494685b = r101;
    }
}
