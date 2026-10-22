package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeFlatMapNotification<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f493766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> f493767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends MaybeSource<? extends R>> f493768d;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final io.reactivex.k<? super R> downstream;
        final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        public final class a implements io.reactivex.k<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlatMapMaybeObserver f493769a;

            @Override // io.reactivex.k
            public final void onComplete() {
                this.f493769a.downstream.onComplete();
            }

            public a(FlatMapMaybeObserver r100) {
                this.f493769a = r100;
            }

            @Override // io.reactivex.k
            public final void onError(Throwable r100) {
                this.f493769a.downstream.onError(r100);
            }

            @Override // io.reactivex.k
            public final void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this.f493769a, r100);
            }

            @Override // io.reactivex.k
            public final void onSuccess(R r100) {
                this.f493769a.downstream.onSuccess(r100);
            }
        }

        @Override // io.reactivex.k
        public void onComplete() {
            MaybeSource r100 = (MaybeSource) ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource");     // Catch: Exception -> L5
            r100.subscribe(new a(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            ((MaybeSource) ObjectHelper.requireNonNull(this.onErrorMapper.apply(r100), "The onErrorMapper returned a null MaybeSource")).subscribe(new a(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(new CompositeException(new Throwable[]{r100, e}));
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            MaybeSource r101 = (MaybeSource) ObjectHelper.requireNonNull(this.onSuccessMapper.apply(r100), "The onSuccessMapper returned a null MaybeSource");     // Catch: Exception -> L5
            r101.subscribe(new a(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
        }

        public FlatMapMaybeObserver(io.reactivex.k<? super R> r100, Function<? super T, ? extends MaybeSource<? extends R>> r101, Function<? super Throwable, ? extends MaybeSource<? extends R>> r102, Callable<? extends MaybeSource<? extends R>> r103) {
            this.downstream = r100;
            this.onSuccessMapper = r101;
            this.onErrorMapper = r102;
            this.onCompleteSupplier = r103;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super R> r100) {
        this.f493817a.subscribe(new FlatMapMaybeObserver(r100, this.f493766b, this.f493767c, this.f493768d));
    }

    public MaybeFlatMapNotification(MaybeSource<T> r100, Function<? super T, ? extends MaybeSource<? extends R>> r101, Function<? super Throwable, ? extends MaybeSource<? extends R>> r102, Callable<? extends MaybeSource<? extends R>> r103) {
        super(r100);
        this.f493766b = r101;
        this.f493767c = r102;
        this.f493768d = r103;
    }
}
