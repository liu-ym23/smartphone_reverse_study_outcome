package com.larus.uaigc.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f373008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f373009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f373010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f373011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f373012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f373013f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f373008a, r101.f373008a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f373009b, r101.f373009b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f373010c, r101.f373010c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f373011d, r101.f373011d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f373012e, r101.f373012e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f373013f, r101.f373013f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f373008a.hashCode() * 31) + this.f373009b.hashCode()) * 31) + this.f373010c.hashCode()) * 31) + this.f373011d.hashCode()) * 31) + this.f373012e.hashCode()) * 31) + this.f373013f.hashCode();
    }

    public final String toString() {
        return "EnterpriseFileDownloadContext(url=" + this.f373008a + ", subScene=" + this.f373009b + ", fileType=" + this.f373010c + ", language=" + this.f373011d + ", scene=" + this.f373012e + ", contentType=" + this.f373013f + ')';
    }

    public e0(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "subScene");
        Intrinsics.checkNotNullParameter(r102, "fileType");
        Intrinsics.checkNotNullParameter(r103, "language");
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r105, "contentType");
        this.f373008a = r100;
        this.f373009b = r101;
        this.f373010c = r102;
        this.f373011d = r103;
        this.f373012e = r104;
        this.f373013f = r105;
    }
}
