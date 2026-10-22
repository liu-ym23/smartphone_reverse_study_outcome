package vg3;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o0 {
    public final int[] a;
    public final int b;

    public final int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public final String toString() {
        return "VisibleInfo(lastPositions=" + Arrays.toString(this.a) + ", totalCount=" + this.b + ')';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(o0.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L21;
        o0 r6 = (o0) r5;
        if (this.b == r6.b) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.a, r6.a) == true) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.prepurchase.business.pdp.intf.VisibleInfo");
    L8:
        r2 = null;
        goto L10
    }

    public o0(int[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "lastPositions");
        this.a = r2;
        this.b = r3;
    }
}
