package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public final Integer a;
    public final int[] b;
    public final float[] c;
    public final float d;
    public final Typeface e;
    public final float f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L18;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r4.f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        int[] r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = Arrays.hashCode(r4);
    L10:
        int r6 = (r3 + r5) * 31;
        float[] r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = Arrays.hashCode(r7);
    L14:
        int r9 = (((r6 + r8) * 31) + Float.floatToIntBits(this.d)) * 31;
        Typeface r10 = this.e;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return ((r9 + r1) * 31) + Float.floatToIntBits(this.f);
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
        return "ResolvedTextStyle(solidColor=" + this.a + ", gradientColors=" + Arrays.toString(this.b) + ", gradientPositions=" + Arrays.toString(this.c) + ", textSizePx=" + this.d + ", typeface=" + this.e + ", gradientOrientation=" + this.f + ")";
    }

    public e(Integer r1, int[] r2, float[] r3, float r4, Typeface r5, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
