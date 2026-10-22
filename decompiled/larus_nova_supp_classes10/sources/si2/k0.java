package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 implements am3.c<a> {
    public k0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        a r0 = new a();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L14;
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r0.preBidRefreshInfo = am3.h.c(r6);
        goto L3
    L8:
        r0.priceRefreshInfo = am3.h.c(r6);
        goto L3
    L9:
        r0.endTimeRefreshInfo = u1.a(r6);
        goto L3
    L10:
        r0.jumpSchema = am3.h.c(r6);
        goto L3
    L11:
        r0.actionType = r6.i();
        goto L3
    L12:
        r0.auctionId = r6.j();
        goto L3
    L13:
        r0.productId = r6.j();
        goto L3
    L6:
        am3.h.e(r6);
        goto L3
    L14:
        r6.d(r1);
        return r0;
    }
}
