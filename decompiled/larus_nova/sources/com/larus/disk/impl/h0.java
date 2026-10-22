package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f330687b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f330686a == r101.f330686a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330687b, r101.f330687b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330686a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f330687b.hashCode();
    }

    public final String toString() {
        return "FileAccessFileSnapshot(sizeBytes=" + this.f330686a + ", usage=" + this.f330687b + ')';
    }

    public h0(long r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r101, "usage");
        this.f330686a = r100;
        this.f330687b = r101;
    }
}
