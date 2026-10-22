package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f330749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f330750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f330751d;

    public k0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.f330748a == r101.f330748a) goto L12;
        return false;
    L12:
        if (this.f330749b == r101.f330749b) goto L15;
        return false;
    L15:
        if (this.f330750c == r101.f330750c) goto L18;
        return false;
    L18:
        if (this.f330751d == r101.f330751d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330748a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f330749b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f330750c;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f330751d;
    }

    public final String toString() {
        return "FileAccessUsage(knownBytes=" + this.f330748a + ", used7dBytes=" + this.f330749b + ", used30dBytes=" + this.f330750c + ", knownFileCount=" + this.f330751d + ')';
    }

    public /* synthetic */ k0(int r100) {
        this(0, 0, 0, 0);
    }

    public final k0 a(k0 r110) {
        Intrinsics.checkNotNullParameter(r110, "other");
        long r100 = l0.a(this.f330748a, r110.f330748a);
        long r101 = l0.a(this.f330749b, r110.f330749b);
        long r102 = l0.a(this.f330750c, r110.f330750c);
        int r103 = this.f330751d;
        int r111 = r110.f330751d;
        int r104 = Integer.MAX_VALUE;
        if ((Integer.MAX_VALUE - r103) < r111) goto L7;
        r104 = r103 + r111;
    L7:
        return new k0(r100, r101, r102, r104);
    }

    public k0(long r100, long r101, long r102, int r103) {
        this.f330748a = r100;
        this.f330749b = r101;
        this.f330750c = r102;
        this.f330751d = r103;
    }
}
