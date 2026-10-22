package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes41.dex */
public final class c0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f494285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f494286d;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f494288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f494289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f494290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Disposable f494291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f494292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f494293g;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494291e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494291e.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494293g == true) goto L13;
            this.f494293g = true;
            T r100 = this.f494289c;
            if (r100 == null) goto L7;
        L9:
            if (r100 == null) goto L11;
            this.f494287a.onNext(r100);
        L11:
            this.f494287a.onComplete();
            return;
        L7:
            if (this.f494290d == false) goto L9;
            this.f494287a.onError(new NoSuchElementException());
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494293g == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494293g = true;
            this.f494287a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494293g == false) goto L5;
            return;
        L5:
            long r101 = this.f494292f;
            if (r101 != this.f494288b) goto L9;
            this.f494293g = true;
            this.f494291e.dispose();
            this.f494287a.onNext(r100);
            this.f494287a.onComplete();
            return;
        L9:
            this.f494292f = r101 + 1;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494291e, r100) == false) goto L6;
            this.f494291e = r100;
            this.f494287a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, long r101, T r102, boolean r103) {
            this.f494287a = r100;
            this.f494288b = r101;
            this.f494289c = r102;
            this.f494290d = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494284b, this.f494285c, this.f494286d));
    }

    public c0(ObservableSource<T> r100, long r101, T r102, boolean r103) {
        super(r100);
        this.f494284b = r101;
        this.f494285c = r102;
        this.f494286d = r103;
    }
}
