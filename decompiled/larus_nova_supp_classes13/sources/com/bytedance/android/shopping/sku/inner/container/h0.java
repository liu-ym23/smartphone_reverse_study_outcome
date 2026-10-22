package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h0 {
    public String a;
    public ph3.a b;
    public ProductSelectPoiInfo c;
    public volatile p d;
    public final ul.f e;

    public h0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h0) == false) goto L16;
        h0 r4 = (h0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ph3.a r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ProductSelectPoiInfo r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        p r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ul.f r13 = this.e;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuYataStaticState(couponId=" + this.a + ", cartInfo=" + this.b + ", poiInfo=" + this.c + ", clickAfterUplink=" + this.d + ", skuPageState=" + this.e + ")";
    }

    public h0(int r2) {
        ul.f r3 = new ul.f();
        Intrinsics.checkNotNullParameter(r3, "skuPageState");
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = r3;
    }
}
