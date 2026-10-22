package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ManualCacheCleanStatus f330539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f330540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f330541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f330542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ManualCacheCleanError f330543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f330544f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f330539a == r101.f330539a) goto L12;
        return false;
    L12:
        if (this.f330540b == r101.f330540b) goto L15;
        return false;
    L15:
        if (this.f330541c == r101.f330541c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330542d, r101.f330542d) == true) goto L21;
        return false;
    L21:
        if (this.f330543e == r101.f330543e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f330544f, r101.f330544f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330539a.hashCode() * 31;
        long r101 = this.f330540b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f330541c;
        return ((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f330542d.hashCode()) * 31) + this.f330543e.hashCode()) * 31) + this.f330544f.hashCode();
    }

    public final String toString() {
        return "ManualCacheCleanResult(status=" + this.f330539a + ", beforeBytes=" + this.f330540b + ", remainingBytes=" + this.f330541c + ", operationId=" + this.f330542d + ", error=" + this.f330543e + ", failureOwner=" + this.f330544f + ')';
    }

    public j(ManualCacheCleanStatus r100, long r101, long r102, String r103, ManualCacheCleanError r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r103, "operationId");
        Intrinsics.checkNotNullParameter(r104, "error");
        Intrinsics.checkNotNullParameter(r105, "failureOwner");
        this.f330539a = r100;
        this.f330540b = r101;
        this.f330541c = r102;
        this.f330542d = r103;
        this.f330543e = r104;
        this.f330544f = r105;
    }
}
