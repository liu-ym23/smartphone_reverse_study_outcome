package com.bytedance.kmp.performance.platform;

/* JADX INFO: loaded from: classes19.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f252812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f252814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f252815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f252816e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f252812a == r101.f252812a) goto L12;
        return false;
    L12:
        if (this.f252813b == r101.f252813b) goto L15;
        return false;
    L15:
        if (this.f252814c == r101.f252814c) goto L18;
        return false;
    L18:
        if (this.f252815d == r101.f252815d) goto L21;
        return false;
    L21:
        if (this.f252816e == r101.f252816e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f252812a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f252813b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f252814c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f252815d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f252816e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "ProcessCpuTimes(utime=" + this.f252812a + ", stime=" + this.f252813b + ", cutime=" + this.f252814c + ", cstime=" + this.f252815d + ", total=" + this.f252816e + ')';
    }

    public x(long r100, long r101, long r102, long r103) {
        this.f252812a = r100;
        this.f252813b = r101;
        this.f252814c = r102;
        this.f252815d = r103;
        this.f252816e = ((r100 + r101) + r102) + r103;
    }
}
