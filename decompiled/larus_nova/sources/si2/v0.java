package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponActivityData;

/* JADX INFO: loaded from: classes10.dex */
public final class v0 implements am3.c<ECV2CouponActivityData> {
    public v0() {
    }

    public static ECV2CouponActivityData a(am3.g r100) throws Exception {
        ECV2CouponActivityData r101 = new ECV2CouponActivityData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.activityType = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.beforeText = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.beforeButton = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.afterText = am3.h.c(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.afterButton = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2CouponActivityData decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
