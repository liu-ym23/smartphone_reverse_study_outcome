package qe1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f532617a;

    public b(e r100) {
        this.f532617a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        re1.a r102 = this.f532617a.f532621b;
        if (r102 == null) goto L6;
        r102.c((Exception) r101);
        return;
    }
}
