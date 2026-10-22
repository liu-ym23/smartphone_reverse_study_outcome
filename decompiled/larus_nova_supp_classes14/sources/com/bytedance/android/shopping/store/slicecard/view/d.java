package com.bytedance.android.shopping.store.slicecard.view;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final int[] a;
    public final float[] b;
    public final float c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int[] r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = Arrays.hashCode(r0);
    L6:
        int r3 = r2 * 31;
        float[] r4 = this.b;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return ((r3 + r1) * 31) + Float.floatToIntBits(this.c);
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GradientSpec(colors=" + Arrays.toString(this.a) + ", positions=" + Arrays.toString(this.b) + ", orientation=" + this.c + ")";
    }

    public d(int[] r2, float[] r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
