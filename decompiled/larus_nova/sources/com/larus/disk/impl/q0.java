package com.larus.disk.impl;

/* JADX INFO: loaded from: classes27.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f330793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f330794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f330795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f330796e;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (this.f330792a == r101.f330792a) goto L12;
        return false;
    L12:
        if (this.f330793b == r101.f330793b) goto L15;
        return false;
    L15:
        if (this.f330794c == r101.f330794c) goto L18;
        return false;
    L18:
        if (this.f330795d == r101.f330795d) goto L21;
        return false;
    L21:
        if (this.f330796e == r101.f330796e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330792a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f330793b;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f330794c) * 31;
        long r104 = this.f330795d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f330796e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "NativeHookStats(successCount=" + this.f330792a + ", failureCount=" + this.f330793b + ", lastErrorCode=" + this.f330794c + ", hookedSymbolMask=" + this.f330795d + ", failedSymbolMask=" + this.f330796e + ')';
    }

    public /* synthetic */ q0(int r110) {
        this(0, 0, 0, 0, 0);
    }

    public q0(long r100, long r101, int r102, long r103, long r104) {
        this.f330792a = r100;
        this.f330793b = r101;
        this.f330794c = r102;
        this.f330795d = r103;
        this.f330796e = r104;
    }
}
