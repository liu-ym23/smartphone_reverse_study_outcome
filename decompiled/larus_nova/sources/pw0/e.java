package pw0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f530826a;

    public e(f r100) {
        this.f530826a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = this.f530826a;
        r101.finishWithFailure((Throwable) r100);
    }
}
