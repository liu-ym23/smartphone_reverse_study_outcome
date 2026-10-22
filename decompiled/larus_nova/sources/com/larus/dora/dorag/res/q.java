package com.larus.dora.dorag.res;

/* JADX INFO: loaded from: classes27.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f331860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f331861b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f331860a == r101.f331860a) goto L12;
        return false;
    L12:
        if (this.f331861b == r101.f331861b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f331860a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f331861b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "TimedMmtTargetBitrate(bitrateBps=" + this.f331860a + ", timeMs=" + this.f331861b + ')';
    }

    public q(long r100, long r101) {
        this.f331860a = r100;
        this.f331861b = r101;
    }
}
