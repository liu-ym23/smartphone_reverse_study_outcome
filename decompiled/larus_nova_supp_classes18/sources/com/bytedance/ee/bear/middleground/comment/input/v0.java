package com.bytedance.ee.bear.middleground.comment.input;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v0 implements kn4.g.a {
    public final /* synthetic */ InputComment a;

    public final void b() {
    }

    public final void c() {
    }

    public v0(InputComment r1) {
        this.a = r1;
    }

    public final void a(final bo4.a r5) {
        InputComment r0 = this.a;
        if (r0.i0.e.is_whole == false) goto L6;
        if (r5 == null) goto L6;
        r5.d = -1;
    L6:
        ve5.e r1 = r0.H();
        if (r5 == null) goto L9;
        String r2 = r5.e;
    L10:
        boolean r3 = false;
        if (r5 == null) goto L13;
        int r4 = r5.y;
    L14:
        r1.c(r2, r4);
        if (r5 != null) goto L17;
    L19:
        if (r3 == false) goto L21;
        this.a.H().h(r5);
    L21:
        this.a.p.G(r5);
        this.a.b.i0().invoke(r5);
        final InputComment r6 = this.a;
        if (r6.a.B == false) goto L28;
        if (r5 == null) goto L29;
        String r7 = r5.e;
        if (r7 == null) goto L30;
        r6.j.f(r7, new InputComment$initDefaultData$4$onSelectedAt$1$1(r6, r5));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L17:
        if (r5.y != 4) goto L19;
        r3 = true;
        goto L19
    L13:
        r4 = 0;
        goto L14
    L9:
        r2 = null;
        goto L10
    }
}
