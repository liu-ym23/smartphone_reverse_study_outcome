package com.larus.dora.impl.device.scan;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f334268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f334269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f334270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f334271f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f334266a, r101.f334266a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334267b, r101.f334267b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f334268c, r101.f334268c) == true) goto L18;
        return false;
    L18:
        if (this.f334269d == r101.f334269d) goto L21;
        return false;
    L21:
        if (this.f334270e == r101.f334270e) goto L24;
        return false;
    L24:
        if (this.f334271f == r101.f334271f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f334266a.hashCode() * 31) + this.f334267b.hashCode()) * 31) + this.f334268c.hashCode()) * 31) + this.f334269d) * 31) + this.f334270e) * 31) + this.f334271f;
    }

    public final String toString() {
        return "ScanDeviceModel(mac=" + this.f334266a + ", name=" + this.f334267b + ", sn=" + this.f334268c + ", sku=" + this.f334269d + ", linkState=" + this.f334270e + ", type=" + this.f334271f + ')';
    }

    public final int getType() {
        return this.f334271f;
    }

    public j(String r100, String r101, String r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "sn");
        this.f334266a = r100;
        this.f334267b = r101;
        this.f334268c = r102;
        this.f334269d = r103;
        this.f334270e = r104;
        this.f334271f = r105;
    }
}
