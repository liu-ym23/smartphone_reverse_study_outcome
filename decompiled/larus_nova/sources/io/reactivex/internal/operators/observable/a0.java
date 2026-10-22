package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class a0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super T> f494246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Consumer<? super Throwable> f494247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Action f494248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Action f494249e;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Consumer<? super T> f494251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Consumer<? super Throwable> f494252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Action f494253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Action f494254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Disposable f494255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f494256g;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494255f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494255f.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494256g == false) goto L15;
            return;
        L15:
            this.f494253d.run();     // Catch: Throwable -> L12
            this.f494256g = true;
            this.f494250a.onComplete();
            this.f494254e.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494256g == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494256g = true;
            this.f494252c.accept(r100);     // Catch: Throwable -> L9
        L11:
            this.f494250a.onError(r100);
            this.f494254e.run();     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100 = new CompositeException(new Throwable[]{r100, th});
            goto L11
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494256g == false) goto L11;
            return;
        L11:
            this.f494251b.accept(r100);     // Catch: Throwable -> L8
            this.f494250a.onNext(r100);
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494255f.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494255f, r100) == false) goto L6;
            this.f494255f = r100;
            this.f494250a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, Consumer<? super T> r101, Consumer<? super Throwable> r102, Action r103, Action r104) {
            this.f494250a = r100;
            this.f494251b = r101;
            this.f494252c = r102;
            this.f494253d = r103;
            this.f494254e = r104;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494246b, this.f494247c, this.f494248d, this.f494249e));
    }

    public a0(ObservableSource<T> r100, Consumer<? super T> r101, Consumer<? super Throwable> r102, Action r103, Action r104) {
        super(r100);
        this.f494246b = r101;
        this.f494247c = r102;
        this.f494248d = r103;
        this.f494249e = r104;
    }
}
