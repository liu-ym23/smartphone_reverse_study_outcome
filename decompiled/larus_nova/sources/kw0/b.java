package kw0;

import io.reactivex.functions.Consumer;
import yo2.e;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f506375a;

    public b(a r100) {
        this.f506375a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        e r102 = this.f506375a.f506373d;
        if (r102 == null) goto L6;
        r102.d();
        return;
    }
}
