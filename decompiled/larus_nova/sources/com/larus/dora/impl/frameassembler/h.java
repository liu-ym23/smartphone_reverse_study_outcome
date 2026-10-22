package com.larus.dora.impl.frameassembler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f335840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f335841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f335842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f335843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f335844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f335845f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f335840a, r101.f335840a) == true) goto L12;
        return false;
    L12:
        if (this.f335841b == r101.f335841b) goto L15;
        return false;
    L15:
        if (this.f335842c == r101.f335842c) goto L18;
        return false;
    L18:
        if (this.f335843d == r101.f335843d) goto L21;
        return false;
    L21:
        if (this.f335844e == r101.f335844e) goto L24;
        return false;
    L24:
        if (this.f335845f == r101.f335845f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f335840a.hashCode() * 31;
        long r101 = this.f335841b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f335842c;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f335843d) * 31;
        if (this.f335844e == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r104 + r105) * 31;
        long r107 = this.f335845f;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r105 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraSessionContext(key=" + this.f335840a + ", createdAtMillis=" + this.f335841b + ", lastUpdatedAtMillis=" + this.f335842c + ", expectedTotalSeq=" + this.f335843d + ", usingDisk=" + this.f335844e + ", receivedBytes=" + this.f335845f + ')';
    }

    public h(i r100, long r101, long r102, int r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f335840a = r100;
        this.f335841b = r101;
        this.f335842c = r102;
        this.f335843d = r103;
        this.f335844e = r104;
        this.f335845f = r105;
    }
}
