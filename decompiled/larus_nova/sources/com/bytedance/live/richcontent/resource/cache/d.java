package com.bytedance.live.richcontent.resource.cache;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourceCache$CacheType f255792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceCache$ReferenceType f255793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f255794d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f255791a, r101.f255791a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255792b, r101.f255792b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255793c, r101.f255793c) == true) goto L12;
        return false;
    L12:
        if (this.f255794d == r101.f255794d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f255791a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ResourceCache$CacheType r104 = this.f255792b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ResourceCache$ReferenceType r107 = this.f255793c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f255794d;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheParams(name=" + this.f255791a + ", cacheType=" + this.f255792b + ", referenceType=" + this.f255793c + ", maxSize=" + this.f255794d + ")";
    }

    public d(String r100, ResourceCache$CacheType r101, ResourceCache$ReferenceType r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        Intrinsics.checkNotNullParameter(r102, "referenceType");
        this.f255791a = r100;
        this.f255792b = r101;
        this.f255793c = r102;
        this.f255794d = r103;
    }
}
