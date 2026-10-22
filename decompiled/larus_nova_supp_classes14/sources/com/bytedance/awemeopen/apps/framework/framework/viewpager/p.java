package com.bytedance.awemeopen.apps.framework.framework.viewpager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public final int a;
    public final float b;
    public final long c;
    public final boolean d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + Float.floatToIntBits(this.b)) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        boolean r3 = this.d;
        ?? r4 = r3;
        if (r3 == false) goto L6;
        r4 = 1;
    L6:
        return r2 + r4;
    }

    public final String toString() {
        return "SlidesProgressInfo(position=" + this.a + ", progress=" + this.b + ", duration=" + this.c + ", changeByDrag=" + this.d + ')';
    }

    public p(int r1, float r2, long r3, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
