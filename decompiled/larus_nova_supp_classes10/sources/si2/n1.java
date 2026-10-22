package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCouponInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n1 implements am3.c<ECV2UpdatedCouponInfo> {
    public n1() {
    }

    public static ECV2UpdatedCouponInfo a(am3.g r5) throws Exception {
        ECV2UpdatedCouponInfo r0 = new ECV2UpdatedCouponInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L21;
        if (r3 != 1) goto L8;
        r0.tag = am3.h.c(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.couponUrl = am3.h.c(r5);
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.couponApplet = am3.h.c(r5);
        goto L3
    L12:
        if (r3 != 4) goto L14;
        r0.isValid = am3.h.a(r5);
        goto L3
    L14:
        if (r3 != 5) goto L15;
        r0.couponMetaId = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
