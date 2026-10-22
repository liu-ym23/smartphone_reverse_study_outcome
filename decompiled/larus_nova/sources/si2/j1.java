package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2SkuInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class j1 implements am3.c<ECV2SkuInfo> {
    public j1() {
    }

    public static ECV2SkuInfo a(am3.g r100) throws Exception {
        ECV2SkuInfo r101 = new ECV2SkuInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.skuId = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.stockNum = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.price = r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.couponPrice = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2SkuInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
