package si2;

import com.bytedance.android.livesdk.livecommerce.model.ProductNumAtmosphere;

/* JADX INFO: loaded from: classes10.dex */
public final class i2 implements am3.c<ProductNumAtmosphere> {
    public i2() {
    }

    public static ProductNumAtmosphere a(am3.g r100) throws Exception {
        ProductNumAtmosphere r101 = new ProductNumAtmosphere();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.leftIcon = r1.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.background = r1.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.type = (int) r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.num = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ProductNumAtmosphere decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
