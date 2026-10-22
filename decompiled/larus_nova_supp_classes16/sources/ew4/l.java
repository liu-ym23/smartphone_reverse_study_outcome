package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final String f;
    public final boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c) * 31) + this.d) * 31;
        long r5 = this.e;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.f;
        if (r7 == null) goto L10;
        r2 = r7.hashCode();
    L10:
        int r8 = (r6 + r2) * 31;
        if (this.g == false) goto L13;
        int r9 = 1231;
    L15:
        return r8 + r9;
    L13:
        r9 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonFileBean(path=" + this.a + ", mimeType=" + this.b + ", width=" + this.c + ", height=" + this.d + ", size=" + this.e + ", compressPath=" + this.f + ", isOrigin=" + this.g + ')';
    }

    public l(String r2, String r3, int r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = null;
        this.g = false;
    }
}
