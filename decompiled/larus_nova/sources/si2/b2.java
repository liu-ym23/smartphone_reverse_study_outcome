package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class b2 implements am3.c<z> {
    public b2() {
    }

    @Override // am3.c
    public final z decode(am3.g r100) throws Exception {
        z r101 = new z();
        r101.productIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L16;
        switch(r103) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        r101.taskInfo = k1.a(r100);
        goto L3
    L8:
        r101.couponInfo = w0.a(r100);
        goto L3
    L9:
        r101.lotteryInfoList = b1.a(r100);
        goto L3
    L10:
        r101.winLotteryInfo = t1.a(r100);
        goto L3
    L11:
        r101.redpackActivityInfo = h1.a(r100);
        goto L3
    L12:
        r101.auctionInfo = com.bytedance.android.livesdk.livecommerce.model.d.a(r100);
        goto L3
    L13:
        r101.auctionSuccess = q0.a(r100);
        goto L3
    L14:
        r101.productIds.add(Long.valueOf(r100.j()));
        goto L3
    L15:
        r101.msgType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r102);
        return r101;
    }
}
