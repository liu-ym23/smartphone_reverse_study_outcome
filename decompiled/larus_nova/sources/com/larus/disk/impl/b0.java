package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f330619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f330620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f330621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f330622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f330623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f330624h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f330617a, r101.f330617a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330618b, r101.f330618b) == true) goto L15;
        return false;
    L15:
        if (this.f330619c == r101.f330619c) goto L18;
        return false;
    L18:
        if (this.f330620d == r101.f330620d) goto L21;
        return false;
    L21:
        if (this.f330621e == r101.f330621e) goto L24;
        return false;
    L24:
        if (this.f330622f == r101.f330622f) goto L27;
        return false;
    L27:
        if (this.f330623g == r101.f330623g) goto L30;
        return false;
    L30:
        if (this.f330624h == r101.f330624h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330617a.hashCode() * 31;
        String r101 = this.f330618b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f330619c) * 31;
        long r104 = this.f330620d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f330621e;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f330622f;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f330623g;
        return ((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f330624h;
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiskPathUsageSnapshot(path=" + this.f330617a + ", parentPath=" + this.f330618b + ", pathLevel=" + this.f330619c + ", storageBytes=" + this.f330620d + ", accessKnownBytes=" + this.f330621e + ", accessed7dBytes=" + this.f330622f + ", accessed30dBytes=" + this.f330623g + ", accessTrackedFileCount=" + this.f330624h + ')';
    }

    public b0(String r100, String r101, int r102, long r103, long r104, long r105, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f330617a = r100;
        this.f330618b = r101;
        this.f330619c = r102;
        this.f330620d = r103;
        this.f330621e = r104;
        this.f330622f = r105;
        this.f330623g = r110;
        this.f330624h = r111;
    }
}
