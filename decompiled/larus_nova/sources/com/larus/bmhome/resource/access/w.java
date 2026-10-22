package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f313762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f313763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceMediaType f313764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f313765d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f313762a, r101.f313762a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313763b, r101.f313763b) == true) goto L15;
        return false;
    L15:
        if (this.f313764c == r101.f313764c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313765d, r101.f313765d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f313762a.hashCode() * 31) + this.f313763b.hashCode()) * 31) + this.f313764c.hashCode()) * 31) + this.f313765d.hashCode();
    }

    public final String toString() {
        return "ResourceAccessRequest(scene=" + this.f313762a + ", resourceInput=" + this.f313763b + ", mediaType=" + this.f313764c + ", bizContext=" + this.f313765d + ')';
    }

    public static w a(w r100, j0.b r101, g0 r102) {
        x r103 = r100.f313762a;
        ResourceMediaType r104 = r100.f313764c;
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r101, "resourceInput");
        Intrinsics.checkNotNullParameter(r104, "mediaType");
        Intrinsics.checkNotNullParameter(r102, "bizContext");
        return new w(r103, r101, r104, r102);
    }

    public w(x r100, j0 r101, ResourceMediaType r102, g0 r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "resourceInput");
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "bizContext");
        this.f313762a = r100;
        this.f313763b = r101;
        this.f313764c = r102;
        this.f313765d = r103;
    }
}
