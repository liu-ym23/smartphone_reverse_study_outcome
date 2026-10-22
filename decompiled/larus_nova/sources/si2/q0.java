package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;

/* JADX INFO: loaded from: classes10.dex */
public final class q0 implements am3.c<ECV2AuctionSuccess> {
    public q0() {
    }

    public static ECV2AuctionSuccess a(am3.g r100) throws Exception {
        ECV2AuctionSuccess r101 = new ECV2AuctionSuccess();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        switch(r103) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L7:
        r101.depositInfo = am3.h.c(r100);
        goto L3
    L8:
        r101.bizId = r100.i();
        goto L3
    L9:
        r101.leftPaymentTime = r100.j();
        goto L3
    L10:
        r101.freightCollect = am3.h.c(r100);
        goto L3
    L11:
        r101.jumpUrl = am3.h.c(r100);
        goto L3
    L12:
        r101.buttonLabel = am3.h.c(r100);
        goto L3
    L13:
        r101.total = r100.j();
        goto L3
    L14:
        r101.freight = r100.j();
        goto L3
    L15:
        r101.charge = r100.j();
        goto L3
    L16:
        r101.price = r100.j();
        goto L3
    L17:
        r101.productPic = am3.h.c(r100);
        goto L3
    L18:
        r101.productName = am3.h.c(r100);
        goto L3
    L19:
        r101.productId = r100.j();
        goto L3
    L20:
        r101.title = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2AuctionSuccess decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
