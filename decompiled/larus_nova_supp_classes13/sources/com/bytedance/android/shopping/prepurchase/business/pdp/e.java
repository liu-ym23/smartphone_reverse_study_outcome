package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.shopping.prepurchase.arch.container.state.h {
    public final AnchorV4Param a;
    public final a b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
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
        AnchorV4Param r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpGlobalState(inputParam=" + this.a + ", containerState=" + this.b + ")";
    }

    public e(AnchorV4Param r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "inputParam");
        Intrinsics.checkNotNullParameter(r3, "containerState");
        this.a = r2;
        this.b = r3;
    }
}
