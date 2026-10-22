package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final Integer a;
    public final String b;
    public final String c;
    public final long d;
    public final int e;
    public final int f;
    public final long g;
    public final String h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.d;
        int r8 = (((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31;
        long r9 = this.g;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r11 = this.h;
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
        return "CommentSelectedImage(id=" + this.a + ", path=" + this.b + ", mimeType=" + this.c + ", duration=" + this.d + ", width=" + this.e + ", height=" + this.f + ", size=" + this.g + ", fileName=" + this.h + ')';
    }

    public f(Integer r2, String r3, String r4, int r5, int r6, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 0;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
    }
}
