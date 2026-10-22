package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class c2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494295b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f494297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494299d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494298c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494298c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494296a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494296a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494299d == false) goto L12;
            this.f494296a.onNext(r100);
            return;
        L12:
            if (this.f494297b.test(r100) == true) goto L15;
            this.f494299d = true;
            this.f494296a.onNext(r100);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494298c.dispose();
            this.f494296a.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494298c, r100) == false) goto L6;
            this.f494298c = r100;
            this.f494296a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, Predicate<? super T> r101) {
            this.f494296a = r100;
            this.f494297b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494295b));
    }

    public c2(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494295b = r101;
    }
}
