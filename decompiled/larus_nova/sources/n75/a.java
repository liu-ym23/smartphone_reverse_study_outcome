package n75;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import ttc.c;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements FlowableEmitter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowableEmitter<T> f518204a;

    @Override // io.reactivex.FlowableEmitter
    public final boolean isCancelled() {
        return this.f518204a.isCancelled();
    }

    @Override // io.reactivex.FlowableEmitter
    public final long requested() {
        return this.f518204a.requested();
    }

    @Override // io.reactivex.FlowableEmitter
    public final FlowableEmitter<T> serialize() {
        return this.f518204a.serialize();
    }

    @Override // io.reactivex.Emitter
    public final void onComplete() {
        if (isCancelled() == true) goto L6;
        this.f518204a.onComplete();
        return;
    }

    public a(FlowableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f518204a = r100;
    }

    @Override // io.reactivex.Emitter
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (isCancelled() == true) goto L6;
        this.f518204a.onError(r100);
        return;
    }

    @Override // io.reactivex.Emitter
    public final void onNext(T r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (isCancelled() == true) goto L6;
        this.f518204a.onNext(r100);
        return;
    }

    @Override // io.reactivex.FlowableEmitter
    public final void setCancellable(c r100) {
        this.f518204a.setCancellable(r100);
    }

    @Override // io.reactivex.FlowableEmitter
    public final void setDisposable(Disposable r100) {
        this.f518204a.setDisposable(r100);
    }

    @Override // io.reactivex.FlowableEmitter
    public final boolean tryOnError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        return this.f518204a.tryOnError(r100);
    }
}
