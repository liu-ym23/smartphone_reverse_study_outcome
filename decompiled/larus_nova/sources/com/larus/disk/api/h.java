package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f330536d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f330533a, r101.f330533a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330534b, r101.f330534b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330535c, r101.f330535c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330536d, r101.f330536d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f330533a.hashCode() * 31) + this.f330534b.hashCode()) * 31) + this.f330535c.hashCode()) * 31;
        Long r101 = this.f330536d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DiskRegisteredCacheEntry(business=" + this.f330533a + ", bizTag=" + this.f330534b + ", path=" + this.f330535c + ", sizeBytes=" + this.f330536d + ')';
    }

    public h(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r101, "bizTag");
        Intrinsics.checkNotNullParameter(r102, "path");
        this.f330533a = r100;
        this.f330534b = r101;
        this.f330535c = r102;
        this.f330536d = r103;
    }
}
