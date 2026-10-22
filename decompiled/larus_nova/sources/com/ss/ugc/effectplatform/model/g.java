package com.ss.ugc.effectplatform.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceListModel.ResourceListBean f457423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f457424b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f457423a, r101.f457423a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f457424b, r101.f457424b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ResourceListModel.ResourceListBean r100 = this.f457423a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f457424b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResourceDownloadedBean(resourceBean=" + this.f457423a + ", localFilePath=" + this.f457424b + ")";
    }

    public g() {
        this(new ResourceListModel.ResourceListBean(null, null, null, 7, null), "");
    }

    public g(ResourceListModel.ResourceListBean r100, String r101) {
        this.f457423a = r100;
        this.f457424b = r101;
    }
}
