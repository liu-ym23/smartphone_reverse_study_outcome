package com.larus.dora.impl.log.g;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f336132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f336133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f336134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f336135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f336136e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f336132a == r101.f336132a) goto L12;
        return false;
    L12:
        if (this.f336133b == r101.f336133b) goto L15;
        return false;
    L15:
        if (this.f336134c == r101.f336134c) goto L18;
        return false;
    L18:
        if (this.f336135d == r101.f336135d) goto L21;
        return false;
    L21:
        if (this.f336136e == r101.f336136e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f336132a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f336133b) * 31;
        long r102 = this.f336134c;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f336135d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f336136e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "LogInfo(startTime=" + this.f336132a + ", logType=" + this.f336133b + ", totalSize=" + this.f336134c + ", batchCount=" + this.f336135d + ", startOffset=" + this.f336136e + ')';
    }

    public k(long r100, int r101, long r102, long r103) {
        this.f336132a = r100;
        this.f336133b = r101;
        this.f336134c = r102;
        this.f336135d = 16;
        this.f336136e = r103;
    }
}
