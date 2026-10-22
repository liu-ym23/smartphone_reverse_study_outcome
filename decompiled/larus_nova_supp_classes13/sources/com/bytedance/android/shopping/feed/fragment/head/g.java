package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.view.CouponView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final AnchorV3Param a;
    public final FrameLayout b;
    public final Context c;
    public final CouponView d;
    public final ProductFeedContentFragment e;
    public final View f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L20;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        AnchorV3Param r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FrameLayout r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Context r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + 0) * 31;
        CouponView r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ProductFeedContentFragment r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        View r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
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
        return "TopBarData(anchorV3Param=" + this.a + ", container=" + this.b + ", context=" + this.c + ", searchDataCenter=null, bottomCouponView=" + this.d + ", contentFragment=" + this.e + ", touchOutFeedView=" + this.f + ")";
    }

    public final Context getContext() {
        return this.c;
    }

    public g(AnchorV3Param r2, FrameLayout r3, Context r4, CouponView r5, ProductFeedContentFragment r6, View r7) {
        Intrinsics.checkNotNullParameter(r2, "anchorV3Param");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
