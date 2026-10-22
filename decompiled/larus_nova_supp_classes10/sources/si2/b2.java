package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b2 implements am3.c<z> {
    public b2() {
    }

    public final Object decode(am3.g r7) throws Exception {
        z r0 = new z();
        r0.productIds = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L16;
        switch(r3) {
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
        r0.taskInfo = k1.a(r7);
        goto L3
    L8:
        r0.couponInfo = w0.a(r7);
        goto L3
    L9:
        r0.lotteryInfoList = b1.a(r7);
        goto L3
    L10:
        r0.winLotteryInfo = t1.a(r7);
        goto L3
    L11:
        r0.redpackActivityInfo = h1.a(r7);
        goto L3
    L12:
        r0.auctionInfo = com.bytedance.android.livesdk.livecommerce.model.d.a(r7);
        goto L3
    L13:
        r0.auctionSuccess = q0.a(r7);
        goto L3
    L14:
        r0.productIds.add(Long.valueOf(r7.j()));
        goto L3
    L15:
        r0.msgType = r7.i();
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L16:
        r7.d(r1);
        return r0;
    }
}
