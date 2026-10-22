package com.larus.dora.impl.frameassembler;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f335846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f335847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f335848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f335849d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f335846a == r101.f335846a) goto L12;
        return false;
    L12:
        if (this.f335847b == r101.f335847b) goto L15;
        return false;
    L15:
        if (this.f335848c == r101.f335848c) goto L18;
        return false;
    L18:
        if (this.f335849d == r101.f335849d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f335846a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f335847b;
        return ((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f335848c) * 31) + this.f335849d;
    }

    public final String toString() {
        return "DoraSessionKey(dataId=" + this.f335846a + ", associateId=" + this.f335847b + ", scene=" + this.f335848c + ", type=" + this.f335849d + ')';
    }

    public final int getType() {
        return this.f335849d;
    }

    public i(long r100, long r101, int r102, int r103) {
        this.f335846a = r100;
        this.f335847b = r101;
        this.f335848c = r102;
        this.f335849d = r103;
    }
}
