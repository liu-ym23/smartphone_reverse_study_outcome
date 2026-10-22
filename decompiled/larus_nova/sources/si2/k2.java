package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class k2 implements am3.c<f0> {
    public k2() {
    }

    @Override // am3.c
    public final f0 decode(am3.g r100) throws Exception {
        f0 r101 = new f0();
        r101.productIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        switch(r103) {
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
        r101.bidInfo = t0.a(r100);
        goto L3
    L8:
        r101.promotionHeaderInteraction = com.bytedance.android.livesdk.livecommerce.model.y.a(r100);
        goto L3
    L9:
        r101.canSold = am3.h.a(r100);
        goto L3
    L10:
        r101.hotAtmosphere = a1.a(r100);
        goto L3
    L11:
        r101.updatedGroupInfo = o1.a(r100);
        goto L3
    L12:
        r101.updatedCommentaryVideoInfo = m1.a(r100);
        goto L3
    L13:
        r101.updatedSkuInfo = q1.a(r100);
        goto L3
    L14:
        r101.timeStamp = r100.j();
        goto L3
    L15:
        r101.campaignInfo = l1.a(r100);
        goto L3
    L16:
        r101.couponInfo = n1.a(r100);
        goto L3
    L17:
        r101.soldOut = am3.h.a(r100);
        goto L3
    L18:
        r101.productInfo = p1.a(r100);
        goto L3
    L19:
        r101.updateType = r100.i();
        goto L3
    L20:
        r101.productIds.add(Long.valueOf(r100.j()));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }
}
