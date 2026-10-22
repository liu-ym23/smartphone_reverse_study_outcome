package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q {
    public final String a;
    public final String b;
    public final double c;
    public final double d;
    public final Integer e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r9.c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r9.d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = Double.doubleToLongBits(this.c);
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = Double.doubleToLongBits(this.d);
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        Integer r11 = this.e;
        if (r11 == null) goto L15;
        r1 = r11.hashCode();
    L15:
        return r10 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonLocationParams(name=" + this.a + ", address=" + this.b + ", latitude=" + this.c + ", longitude=" + this.d + ", scale=" + this.e + ')';
    }

    public q(String r1, String r2, double r3, double r5, Integer r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
    }
}
