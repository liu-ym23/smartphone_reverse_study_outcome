package n75;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import ttc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements FlowableEmitter<T> {
    public final FlowableEmitter<T> a;

    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    public final long requested() {
        return this.a.requested();
    }

    public final FlowableEmitter<T> serialize() {
        return this.a.serialize();
    }

    public final void onComplete() {
        if (isCancelled() == true) goto L6;
        this.a.onComplete();
        return;
    }

    public a(FlowableEmitter<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        this.a = r2;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        if (isCancelled() == true) goto L6;
        this.a.onError(r2);
        return;
    }

    public final void onNext(T r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (isCancelled() == true) goto L6;
        this.a.onNext(r2);
        return;
    }

    public final void setCancellable(c r2) {
        this.a.setCancellable(r2);
    }

    public final void setDisposable(Disposable r2) {
        this.a.setDisposable(r2);
    }

    public final boolean tryOnError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        return this.a.tryOnError(r2);
    }
}
