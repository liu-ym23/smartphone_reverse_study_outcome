package com.larus.profile.impl.view;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f366917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f366918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f366919c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f366917a == r101.f366917a) goto L12;
        return false;
    L12:
        if (this.f366918b == r101.f366918b) goto L15;
        return false;
    L15:
        if (this.f366919c == r101.f366919c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f366917a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f366918b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f366919c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "ProfileEditFirstFrameTiming(drawEndMs=" + this.f366917a + ", measureDurationNs=" + this.f366918b + ", layoutDurationNs=" + this.f366919c + ')';
    }

    public i(long r100, long r101, long r102) {
        this.f366917a = r100;
        this.f366918b = r101;
        this.f366919c = r102;
    }
}
