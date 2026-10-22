package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.ec.core.arch.state.b {
    public final boolean a;
    public final String b;

    public b() {
        boolean r1 = false;
        this(r1, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.b;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "SaasCouponLoginState(isLogin=" + this.a + ", descInside=" + this.b + ")";
    }

    public /* synthetic */ b(boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        String r4 = "";
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public b(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "descInside");
        this.a = r2;
        this.b = r3;
    }
}
