package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeToFlowable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaybeSource<T> f493805a;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements io.reactivex.k<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        Disposable upstream;

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public MaybeToFlowableSubscriber(wwc.b<? super T> r100) {
            super(r100);
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
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
            complete(r100);
        }
    }

    public MaybeToFlowable(MaybeSource<T> r100) {
        this.f493805a = r100;
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(wwc.b<? super T> r100) {
        this.f493805a.subscribe(new MaybeToFlowableSubscriber(r100));
    }
}
