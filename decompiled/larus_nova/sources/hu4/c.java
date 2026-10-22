package hu4;

import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f487245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f487246b;

    public c(m r100, d r101) {
        this.f487245a = r100;
        this.f487246b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        String r102 = r101.getMessage();
        if (r102 == null) goto L6;
    L7:
        d25.d.g(r102, this.f487245a);
        tt5.a.e(this.f487246b.f487247a, "handle: ", r101, false);
        return;
    L6:
        r102 = "";
        goto L7
    }
}
