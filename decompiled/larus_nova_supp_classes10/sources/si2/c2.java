package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c2 implements am3.c<a0> {
    public c2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        a0 r0 = new a0();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L24;
        if (r3 != 1) goto L8;
        r0.msgType = r6.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.bubbleType = r6.i();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.promotionId = r6.j();
        goto L3
    L12:
        if (r3 != 5) goto L14;
        r0.delayParam = y0.a(r6);
        goto L3
    L14:
        if (r3 != 6) goto L16;
        r0.productInfo = d1.a(r6);
        goto L3
    L16:
        if (r3 != 7) goto L17;
        r0.openPriceTriggerInfo = c1.a(r6);
        goto L3
    L17:
        am3.h.e(r6);
        goto L3
    L24:
        r6.d(r1);
        return r0;
    }
}
