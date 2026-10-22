package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action f493754b;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.k<? super T> downstream;
        final Action onFinally;
        Disposable upstream;

        public void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
            runFinally();
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
            this.downstream.onSuccess(r100);
            runFinally();
        }

        public DoFinallyObserver(io.reactivex.k<? super T> r100, Action r101) {
            this.downstream = r100;
            this.onFinally = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new DoFinallyObserver(r100, this.f493754b));
    }

    public MaybeDoFinally(MaybeSource<T> r100, Action r101) {
        super(r100);
        this.f493754b = r101;
    }
}
