package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class e2 implements am3.c<c0> {
    public e2() {
    }

    @Override // am3.c
    public final c0 decode(am3.g r100) throws Exception {
        c0 r101 = new c0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.schema = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.createTime = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.promotionId = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
