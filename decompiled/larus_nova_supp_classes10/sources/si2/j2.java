package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j2 implements am3.c<e0> {
    public j2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        e0 r0 = new e0();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L18;
        switch(r3) {
            case 1: goto L17;
            case 2: goto L6;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        r0.atmosphereInfo = h0.a(r6);
        goto L3
    L8:
        r0.auctionAtmosphere = i0.a(r6);
        goto L3
    L9:
        r0.auctionInfo = j0.a(r6);
        goto L3
    L10:
        r0.hotAtmosphere = a1.a(r6);
        goto L3
    L11:
        r0.productInfo = g2.a(r6);
        goto L3
    L12:
        r0.requestInfo = l2.a(r6);
        goto L3
    L13:
        r0.actionType = r6.i();
        goto L3
    L14:
        r0.updateTs = r6.j();
        goto L3
    L15:
        r0.channelId = r6.j();
        goto L3
    L16:
        r0.channelType = r6.j();
        goto L3
    L17:
        r0.promotionId = r6.j();
        goto L3
    L6:
        am3.h.e(r6);
        goto L3
    L18:
        r6.d(r1);
        return r0;
    }
}
