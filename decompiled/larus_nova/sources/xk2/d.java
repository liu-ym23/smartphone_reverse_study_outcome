package xk2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564189a;

    public d(a r100) {
        this.f564189a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a.a(this.f564189a, null);
    }
}
