package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class AsyncProcessor<T> extends a<T> {

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
        public void cancel() {
            if (super.tryCancel() == true) goto L6;
            return;
        L6:
            throw null;
        }

        public void onComplete() {
            if (isCancelled() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r100) {
            if (isCancelled() == false) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            this.downstream.onError(r100);
        }

        public AsyncSubscription(wwc.b<? super T> r100, AsyncProcessor<T> r101) {
            super(r100);
        }
    }
}
