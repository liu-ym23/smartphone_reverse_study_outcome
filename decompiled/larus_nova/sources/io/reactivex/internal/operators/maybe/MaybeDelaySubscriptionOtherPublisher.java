package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Publisher<U> f493746b;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final io.reactivex.k<? super T> downstream;

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        public DelayMaybeObserver(io.reactivex.k<? super T> r100) {
            this.downstream = r100;
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }
    }

    public static final class a<T> implements io.reactivex.g<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelayMaybeObserver<T> f493747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MaybeSource<T> f493748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public wwc.c f493749c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493749c.cancel();
            this.f493749c = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.f493747a);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f493747a.get());
        }

        @Override // wwc.b
        public final void onComplete() {
            wwc.c r100 = this.f493749c;
            SubscriptionHelper r101 = SubscriptionHelper.CANCELLED;
            if (r100 == r101) goto L6;
            this.f493749c = r101;
            MaybeSource<T> r102 = this.f493748b;
            this.f493748b = null;
            r102.subscribe(this.f493747a);
            return;
        }

        @Override // wwc.b
        public final void onError(Throwable r100) {
            wwc.c r101 = this.f493749c;
            SubscriptionHelper r102 = SubscriptionHelper.CANCELLED;
            if (r101 == r102) goto L5;
            this.f493749c = r102;
            this.f493747a.downstream.onError(r100);
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }

        @Override // wwc.b
        public final void onNext(Object r100) {
            wwc.c r101 = this.f493749c;
            SubscriptionHelper r102 = SubscriptionHelper.CANCELLED;
            if (r101 == r102) goto L6;
            r101.cancel();
            this.f493749c = r102;
            MaybeSource<T> r103 = this.f493748b;
            this.f493748b = null;
            r103.subscribe(this.f493747a);
            return;
        }

        @Override // io.reactivex.g, wwc.b
        public final void onSubscribe(wwc.c r100) {
            if (SubscriptionHelper.validate(this.f493749c, r100) == false) goto L6;
            this.f493749c = r100;
            this.f493747a.downstream.onSubscribe(this);
            r100.request(Long.MAX_VALUE);
            return;
        }

        public a(io.reactivex.k<? super T> r100, MaybeSource<T> r101) {
            this.f493747a = new DelayMaybeObserver(r100);
            this.f493748b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493746b.subscribe(new a(r100, this.f493817a));
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> r100, Publisher<U> r101) {
        super(r100);
        this.f493746b = r101;
    }
}
