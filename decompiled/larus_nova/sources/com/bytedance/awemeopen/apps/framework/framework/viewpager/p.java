package com.bytedance.awemeopen.apps.framework.framework.viewpager;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f197072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f197073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f197074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f197075d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f197072a == r101.f197072a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f197073b, r101.f197073b) == 0) goto L15;
        return false;
    L15:
        if (this.f197074c == r101.f197074c) goto L18;
        return false;
    L18:
        if (this.f197075d == r101.f197075d) goto L20;
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
        int r100 = ((this.f197072a * 31) + Float.floatToIntBits(this.f197073b)) * 31;
        long r101 = this.f197074c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        boolean r103 = this.f197075d;
        ?? r104 = r103;
        if (r103 == false) goto L6;
        r104 = 1;
    L6:
        return r102 + r104;
    }

    public final String toString() {
        return "SlidesProgressInfo(position=" + this.f197072a + ", progress=" + this.f197073b + ", duration=" + this.f197074c + ", changeByDrag=" + this.f197075d + ')';
    }

    public p(int r100, float r101, long r102, boolean r103) {
        this.f197072a = r100;
        this.f197073b = r101;
        this.f197074c = r102;
        this.f197075d = r103;
    }
}
