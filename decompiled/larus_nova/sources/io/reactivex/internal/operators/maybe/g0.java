package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class g0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super Disposable> f493853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Consumer<? super T> f493854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Consumer<? super Throwable> f493855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Action f493856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Action f493857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Action f493858g;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g0<T> f493860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493861c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493860b.f493858g.run();     // Catch: Throwable -> L4
        L6:
            this.f493861c.dispose();
            this.f493861c = DisposableHelper.DISPOSED;
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493861c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            Disposable r100 = this.f493861c;
            DisposableHelper r101 = DisposableHelper.DISPOSED;
            if (r100 != r101) goto L15;
            return;
        L15:
            this.f493860b.f493856e.run();     // Catch: Throwable -> L12
            this.f493861c = r101;
            this.f493859a.onComplete();
            this.f493860b.f493857f.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            b(th);
        }

        public final void b(Throwable r100) {
            this.f493860b.f493855d.accept(r100);     // Catch: Throwable -> L4
        L6:
            this.f493861c = DisposableHelper.DISPOSED;
            this.f493859a.onError(r100);
            this.f493860b.f493857f.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100 = new CompositeException(new Throwable[]{r100, th});
            goto L6
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            if (this.f493861c != DisposableHelper.DISPOSED) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            b(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493861c, r100) == false) goto L11;
            this.f493860b.f493853b.accept(r100);     // Catch: Throwable -> L6
            this.f493861c = r100;
            this.f493859a.onSubscribe(this);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100.dispose();
            this.f493861c = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.f493859a);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            Disposable r101 = this.f493861c;
            DisposableHelper r102 = DisposableHelper.DISPOSED;
            if (r101 != r102) goto L15;
            return;
        L15:
            this.f493860b.f493854c.accept(r100);     // Catch: Throwable -> L12
            this.f493861c = r102;
            this.f493859a.onSuccess(r100);
            this.f493860b.f493857f.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            b(th);
        }

        public a(io.reactivex.k<? super T> r100, g0<T> r101) {
            this.f493859a = r100;
            this.f493860b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this));
    }

    public g0(MaybeSource<T> r100, Consumer<? super Disposable> r101, Consumer<? super T> r102, Consumer<? super Throwable> r103, Action r104, Action r105, Action r106) {
        super(r100);
        this.f493853b = r101;
        this.f493854c = r102;
        this.f493855d = r103;
        this.f493856e = r104;
        this.f493857f = r105;
        this.f493858g = r106;
    }
}
