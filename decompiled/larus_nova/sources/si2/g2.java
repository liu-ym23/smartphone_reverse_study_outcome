package si2;

import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class g2 implements am3.c<ProductInfo> {
    public g2() {
    }

    public static ProductInfo a(am3.g r100) throws Exception {
        ProductInfo r101 = new ProductInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.title = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.cover = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ProductInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
