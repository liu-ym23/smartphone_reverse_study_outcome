package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class j2 implements am3.c<e0> {
    public j2() {
    }

    @Override // am3.c
    public final e0 decode(am3.g r100) throws Exception {
        e0 r101 = new e0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        switch(r103) {
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
        r101.atmosphereInfo = h0.a(r100);
        goto L3
    L8:
        r101.auctionAtmosphere = i0.a(r100);
        goto L3
    L9:
        r101.auctionInfo = j0.a(r100);
        goto L3
    L10:
        r101.hotAtmosphere = a1.a(r100);
        goto L3
    L11:
        r101.productInfo = g2.a(r100);
        goto L3
    L12:
        r101.requestInfo = l2.a(r100);
        goto L3
    L13:
        r101.actionType = r100.i();
        goto L3
    L14:
        r101.updateTs = r100.j();
        goto L3
    L15:
        r101.channelId = r100.j();
        goto L3
    L16:
        r101.channelType = r100.j();
        goto L3
    L17:
        r101.promotionId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }
}
