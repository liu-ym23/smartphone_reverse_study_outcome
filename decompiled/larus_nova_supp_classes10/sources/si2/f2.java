package si2;

import com.bytedance.android.livesdk.livecommerce.model.ProductAtmosphere;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f2 implements am3.c<ProductAtmosphere> {
    public f2() {
    }

    public static ProductAtmosphere a(am3.g r5) throws Exception {
        ProductAtmosphere r0 = new ProductAtmosphere();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.atmosphereType = r5.i();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.numAtmosphere = i2.a(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
