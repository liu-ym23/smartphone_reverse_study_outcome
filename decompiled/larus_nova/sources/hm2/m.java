package hm2;

import io.reactivex.functions.Consumer;
import zg1.k1;

/* JADX INFO: loaded from: classes11.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f485876a;

    public m(l r100) {
        this.f485876a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((k1) r100).f571866a == false) goto L11;
        com.ss.ugc.live.sdk.msg.network.l r101 = this.f485876a.f485849h;
        if ((r101 instanceof im2.k) == true) goto L7;
        r101 = null;
    L7:
        im2.k r102 = (im2.k) r101;
        if (r102 == null) goto L12;
        r102.b("login status changed");
        return;
    L12:
        return;
    }
}
