package com.bytedance.ee.bear.middleground.comment.input;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements kn4.g.a {
    public final /* synthetic */ AsideInputComment a;

    public final void b() {
    }

    public final void c() {
    }

    public i(AsideInputComment r1) {
        this.a = r1;
    }

    public final void a(bo4.a r4) {
        AsideInputComment r0 = this.a;
        if (r0.X.e.is_whole == false) goto L6;
        if (r4 == null) goto L6;
        r4.d = -1;
    L6:
        r0.O(r4);
        this.a.e().G(r4);
        this.a.b.i0().invoke(r4);
        final AsideInputComment r1 = this.a;
        if (r1.a.B == false) goto L13;
        if (r4 == null) goto L14;
        String r5 = r4.e;
        if (r5 == null) goto L15;
        r1.h.f(r5, new AsideInputComment$handleAtWindow$3$onSelectedAt$1$1(r1));
        return;
    L15:
        return;
    L14:
        return;
    }
}
