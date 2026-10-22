package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeDelayOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Publisher<U> f493742b;

    public static final class OtherSubscriber<T> extends AtomicReference<wwc.c> implements io.reactivex.g<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final io.reactivex.k<? super T> downstream;
        Throwable error;
        T value;

        @Override // wwc.b
        public void onComplete() {
            Throwable r100 = this.error;
            if (r100 == null) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            T r101 = this.value;
            if (r101 == null) goto L8;
            this.downstream.onSuccess(r101);
            return;
        L8:
            this.downstream.onComplete();
        }

        public OtherSubscriber(io.reactivex.k<? super T> r100) {
            this.downstream = r100;
        }

        @Override // wwc.b
        public void onError(Throwable r100) {
            Throwable r101 = this.error;
            if (r101 != null) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            this.downstream.onError(new CompositeException(new Throwable[]{r101, r100}));
        }

        @Override // wwc.b
        public void onNext(Object r100) {
            wwc.c r101 = get();
            SubscriptionHelper r102 = SubscriptionHelper.CANCELLED;
            if (r101 == r102) goto L6;
            lazySet(r102);
            r101.cancel();
            onComplete();
            return;
        }

        @Override // io.reactivex.g, wwc.b
        public void onSubscribe(wwc.c r100) {
            SubscriptionHelper.setOnce(this, r100, Long.MAX_VALUE);
        }
    }

    public static final class a<T, U> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OtherSubscriber<T> f493743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Publisher<U> f493744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493745c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493745c.dispose();
            this.f493745c = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.f493743a);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.f493743a.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493745c = DisposableHelper.DISPOSED;
            this.f493744b.subscribe(this.f493743a);
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493745c = DisposableHelper.DISPOSED;
            OtherSubscriber<T> r101 = this.f493743a;
            r101.error = r100;
            this.f493744b.subscribe(r101);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493745c, r100) == false) goto L6;
            this.f493745c = r100;
            this.f493743a.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493745c = DisposableHelper.DISPOSED;
            OtherSubscriber<T> r101 = this.f493743a;
            r101.value = r100;
            this.f493744b.subscribe(r101);
        }

        public a(io.reactivex.k<? super T> r100, Publisher<U> r101) {
            this.f493743a = new OtherSubscriber(r100);
            this.f493744b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493742b));
    }

    public MaybeDelayOtherPublisher(MaybeSource<T> r100, Publisher<U> r101) {
        super(r100);
        this.f493742b = r101;
    }
}
