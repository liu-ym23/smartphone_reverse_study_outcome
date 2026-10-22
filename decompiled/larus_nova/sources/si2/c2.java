package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class c2 implements am3.c<a0> {
    public c2() {
    }

    @Override // am3.c
    public final a0 decode(am3.g r100) throws Exception {
        a0 r101 = new a0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        if (r103 != 1) goto L8;
        r101.msgType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.bubbleType = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.promotionId = r100.j();
        goto L3
    L12:
        if (r103 != 5) goto L14;
        r101.delayParam = y0.a(r100);
        goto L3
    L14:
        if (r103 != 6) goto L16;
        r101.productInfo = d1.a(r100);
        goto L3
    L16:
        if (r103 != 7) goto L17;
        r101.openPriceTriggerInfo = c1.a(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r102);
        return r101;
    }
}
