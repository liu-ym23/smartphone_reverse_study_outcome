package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Number a;
    public final Number b;
    public final String c;
    public final String d;
    public final Number[] e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L16;
        c r4 = (c) r3;
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
        Number r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Number r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Number[] r13 = this.e;
        if (r13 == null) goto L22;
        r1 = Arrays.hashCode(r13);
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
        return "AnchorPendantLayout(width=" + this.a + ", height=" + this.b + ", showAt=" + this.c + ", gravity=" + this.d + ", margins=" + Arrays.toString(this.e) + ")";
    }

    public c(Number r2, Number r3, String r4, String r5, Number[] r6) {
        Intrinsics.checkNotNullParameter(r2, "width");
        Intrinsics.checkNotNullParameter(r3, "height");
        Intrinsics.checkNotNullParameter(r4, "showAt");
        Intrinsics.checkNotNullParameter(r5, "gravity");
        Intrinsics.checkNotNullParameter(r6, "margins");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
