package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e2 implements am3.c<c0> {
    public e2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        c0 r0 = new c0();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.schema = am3.h.c(r6);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.createTime = r6.j();
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.promotionId = r6.j();
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r1);
        return r0;
    }
}
