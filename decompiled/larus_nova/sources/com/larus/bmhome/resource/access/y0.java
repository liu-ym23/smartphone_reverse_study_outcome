package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f313779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceMediaType f313780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313781d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f313778a, r101.f313778a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313779b, r101.f313779b) == true) goto L15;
        return false;
    L15:
        if (this.f313780c == r101.f313780c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313781d, r101.f313781d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f313778a.hashCode() * 31;
        x r101 = this.f313779b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ResourceMediaType r105 = this.f313780c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f313781d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceTaskQuery(fileIdentifier=" + this.f313778a + ", scene=" + this.f313779b + ", mediaType=" + this.f313780c + ", bizScope=" + this.f313781d + ')';
    }

    public y0(String r100, x r101, ResourceMediaType r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        this.f313778a = r100;
        this.f313779b = r101;
        this.f313780c = r102;
        this.f313781d = r103;
    }
}
