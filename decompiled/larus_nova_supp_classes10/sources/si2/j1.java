package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2SkuInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j1 implements am3.c<ECV2SkuInfo> {
    public j1() {
    }

    public static ECV2SkuInfo a(am3.g r5) throws Exception {
        ECV2SkuInfo r0 = new ECV2SkuInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L18;
        if (r3 != 1) goto L8;
        r0.skuId = am3.h.c(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.stockNum = r5.j();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.price = r5.j();
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.couponPrice = r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
