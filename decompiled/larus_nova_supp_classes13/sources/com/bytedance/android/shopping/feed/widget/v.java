package com.bytedance.android.shopping.feed.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v {
    public final d63.l a;
    public final rd3.a b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v) == false) goto L10;
        v r4 = (v) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        d63.l r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        rd3.a r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductFeedHeaderVO(headerBanner=" + this.a + ", anchorInflowFeedItem=" + this.b + ")";
    }

    public v(d63.l r2, rd3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "headerBanner");
        this.a = r2;
        this.b = r3;
    }
}
