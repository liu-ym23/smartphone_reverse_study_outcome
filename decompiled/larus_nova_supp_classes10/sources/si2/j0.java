package si2;

import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 implements am3.c<AuctionInfo> {
    public j0() {
    }

    public static AuctionInfo a(am3.g r5) throws Exception {
        AuctionInfo r0 = new AuctionInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L13;
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r0.introPriceLabel = am3.h.c(r5);
        goto L3
    L8:
        r0.currentUser = l0.a(r5);
        goto L3
    L9:
        r0.endTime = r5.j();
        goto L3
    L10:
        r0.atmosphere = i0.a(r5);
        goto L3
    L11:
        r0.priceLabel = am3.h.c(r5);
        goto L3
    L12:
        r0.price = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
