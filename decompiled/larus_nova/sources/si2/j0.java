package si2;

import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class j0 implements am3.c<AuctionInfo> {
    public j0() {
    }

    public static AuctionInfo a(am3.g r100) throws Exception {
        AuctionInfo r101 = new AuctionInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r101.introPriceLabel = am3.h.c(r100);
        goto L3
    L8:
        r101.currentUser = l0.a(r100);
        goto L3
    L9:
        r101.endTime = r100.j();
        goto L3
    L10:
        r101.atmosphere = i0.a(r100);
        goto L3
    L11:
        r101.priceLabel = am3.h.c(r100);
        goto L3
    L12:
        r101.price = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final AuctionInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
