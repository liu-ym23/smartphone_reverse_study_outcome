package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class l<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Publisher<T> f492976a;

    public static final class a<T> implements io.reactivex.g<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public wwc.c f492978b;

        @Override // wwc.b
        public final void onNext(T r100) {
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f492978b.cancel();
            this.f492978b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.f492978b != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // wwc.b
        public final void onComplete() {
            this.f492977a.onComplete();
        }

        public a(io.reactivex.b r100) {
            this.f492977a = r100;
        }

        @Override // wwc.b
        public final void onError(Throwable r100) {
            this.f492977a.onError(r100);
        }

        @Override // io.reactivex.g, wwc.b
        public final void onSubscribe(wwc.c r100) {
            if (SubscriptionHelper.validate(this.f492978b, r100) == false) goto L6;
            this.f492978b = r100;
            this.f492977a.onSubscribe(this);
            r100.request(Long.MAX_VALUE);
            return;
        }
    }

    public l(Publisher<T> r100) {
        this.f492976a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492976a.subscribe(new a(r100));
    }
}
