package ma3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public final m a;
    public final int b;
    public final int c;
    public final Integer d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L14;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        m r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        Integer r4 = this.d;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowRequestParams(req=" + this.a + ", bTypeNew=" + this.b + ", subBType=" + this.c + ", shape=" + this.d + ")";
    }

    public f(m r2, int r3, int r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "req");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
