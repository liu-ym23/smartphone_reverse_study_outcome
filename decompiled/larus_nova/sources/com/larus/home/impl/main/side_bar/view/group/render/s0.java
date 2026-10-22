package com.larus.home.impl.main.side_bar.view.group.render;

/* JADX INFO: loaded from: classes29.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f345709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f345710b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (this.f345709a == r101.f345709a) goto L12;
        return false;
    L12:
        if (this.f345710b == r101.f345710b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f345709a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f345710b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "TimeBucketRange(startTime=" + this.f345709a + ", endTime=" + this.f345710b + ')';
    }

    public s0(long r100, long r101) {
        this.f345709a = r100;
        this.f345710b = r101;
    }
}
