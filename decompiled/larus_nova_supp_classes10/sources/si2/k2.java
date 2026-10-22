package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k2 implements am3.c<f0> {
    public k2() {
    }

    public final Object decode(am3.g r7) throws Exception {
        f0 r0 = new f0();
        r0.productIds = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L21;
        switch(r3) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L6;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            case 15: goto L7;
            default: goto L6;
        };
    L7:
        r0.bidInfo = t0.a(r7);
        goto L3
    L8:
        r0.promotionHeaderInteraction = com.bytedance.android.livesdk.livecommerce.model.y.a(r7);
        goto L3
    L9:
        r0.canSold = am3.h.a(r7);
        goto L3
    L10:
        r0.hotAtmosphere = a1.a(r7);
        goto L3
    L11:
        r0.updatedGroupInfo = o1.a(r7);
        goto L3
    L12:
        r0.updatedCommentaryVideoInfo = m1.a(r7);
        goto L3
    L13:
        r0.updatedSkuInfo = q1.a(r7);
        goto L3
    L14:
        r0.timeStamp = r7.j();
        goto L3
    L15:
        r0.campaignInfo = l1.a(r7);
        goto L3
    L16:
        r0.couponInfo = n1.a(r7);
        goto L3
    L17:
        r0.soldOut = am3.h.a(r7);
        goto L3
    L18:
        r0.productInfo = p1.a(r7);
        goto L3
    L19:
        r0.updateType = r7.i();
        goto L3
    L20:
        r0.productIds.add(Long.valueOf(r7.j()));
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L21:
        r7.d(r1);
        return r0;
    }
}
