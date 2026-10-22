package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f330532b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f330531a, r101.f330531a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330532b, r101.f330532b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330531a.hashCode() * 31;
        Long r101 = this.f330532b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DiskCacheCategorySize(business=" + this.f330531a + ", sizeBytes=" + this.f330532b + ')';
    }

    public g(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "business");
        this.f330531a = r100;
        this.f330532b = r101;
    }
}
