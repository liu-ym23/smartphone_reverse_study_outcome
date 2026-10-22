package pn1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f529956a;

    public e(a r100) {
        this.f529956a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = this.f529956a.f529947e;
        r101.c((Throwable) r100);
    }
}
