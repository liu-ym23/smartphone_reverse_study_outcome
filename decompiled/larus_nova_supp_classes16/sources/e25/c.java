package e25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final long j;
    public final long k;
    public final long l;
    public long m;
    public final int n;
    public final int o;
    public final String p;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        String r14 = this.i;
        if (r14 != null) goto L21;
        int r16 = 0;
    L22:
        long r17 = this.j;
        int r18 = (((r13 + r16) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        long r19 = this.k;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.l;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.m;
        int r24 = (((((r22 + ((int) (r23 ^ (r23 >>> 32)))) * 31) + this.n) * 31) + this.o) * 31;
        String r26 = this.p;
        if (r26 == null) goto L27;
        r2 = r26.hashCode();
    L27:
        return r24 + r2;
    L21:
        r16 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreloadReportParams(fileType=" + this.a + ", loadType=" + this.b + ", loadFrom=" + this.c + ", subFrom=" + this.d + ", loaderType=" + this.e + ", priority=" + this.f + ", resultKey=" + this.g + ", resultCode=" + this.h + ", resultMsg=" + this.i + ", startTime=" + this.j + ", triggerTime=" + this.k + ", taskManagerEnqueueTime=" + this.l + ", preloadManagerEnqueueTime=" + this.m + ", length=" + this.n + ", retry=" + this.o + ", sheetId=" + this.p + ')';
    }

    public c(int r4, String r5, String r6, String r7, String r8, int r9, int r10, int r11, String r12, long r13, long r16, long r17, long r19, int r21, int r22, String r23) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r16;
        this.l = r17;
        this.m = r19;
        this.n = r21;
        this.o = r22;
        this.p = r23;
    }
}
