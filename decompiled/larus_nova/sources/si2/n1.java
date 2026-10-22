package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCouponInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class n1 implements am3.c<ECV2UpdatedCouponInfo> {
    public n1() {
    }

    public static ECV2UpdatedCouponInfo a(am3.g r100) throws Exception {
        ECV2UpdatedCouponInfo r101 = new ECV2UpdatedCouponInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.tag = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.couponUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.couponApplet = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.isValid = am3.h.a(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.couponMetaId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2UpdatedCouponInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
