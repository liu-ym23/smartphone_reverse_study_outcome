package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {
    public final double a;
    public final double b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final String k;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L13;
        int r12 = 0;
    L14:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L17;
        int r16 = 0;
    L18:
        int r17 = (r13 + r16) * 31;
        String r18 = this.g;
        if (r18 != null) goto L21;
        int r19 = 0;
    L22:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 != null) goto L25;
        int r22 = 0;
    L26:
        int r23 = (r20 + r22) * 31;
        String r24 = this.i;
        if (r24 != null) goto L29;
        int r26 = 0;
    L30:
        int r27 = (((r23 + r26) * 31) + this.j) * 31;
        String r28 = this.k;
        if (r28 == null) goto L35;
        r5 = r28.hashCode();
    L35:
        return r27 + r5;
    L29:
        r26 = r24.hashCode();
        goto L30
    L25:
        r22 = r21.hashCode();
        goto L26
    L21:
        r19 = r18.hashCode();
        goto L22
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r11.hashCode();
        goto L14
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonLocationInfo(latitude=" + this.a + ", longitude=" + this.b + ", name=" + this.c + ", address=" + this.d + ", province=" + this.e + ", city=" + this.f + ", district=" + this.g + ", street=" + this.h + ", streetNumber=" + this.i + ", errorCode=" + this.j + ", errorMsg=" + this.k + ')';
    }

    public o(double r1, double r3, String r5, String r6, String r7, String r8, String r9, String r10, String r11, int r12, String r13) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
    }
}
