package com.bytedance.ee.bear.office.common.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f235426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OfficeUploadFileType f235428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OfficeUploadStatus f235429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f235430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f235431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f235432g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f235426a, r101.f235426a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235427b, r101.f235427b) == true) goto L15;
        return false;
    L15:
        if (this.f235428c == r101.f235428c) goto L18;
        return false;
    L18:
        if (this.f235429d == r101.f235429d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235430e, r101.f235430e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235431f, r101.f235431f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235432g, r101.f235432g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f235426a.hashCode() * 31) + this.f235427b.hashCode()) * 31) + this.f235428c.hashCode()) * 31) + this.f235429d.hashCode()) * 31;
        String r101 = this.f235430e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f235431f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f235432g;
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
        return "OfficeUploadItem(itemId=" + this.f235426a + ", fileName=" + this.f235427b + ", fileType=" + this.f235428c + ", status=" + this.f235429d + ", errorMessage=" + this.f235430e + ", bytesTotal=" + this.f235431f + ", bytesTransferred=" + this.f235432g + ')';
    }

    public /* synthetic */ u(String r100, String r110, OfficeUploadFileType r111, OfficeUploadStatus r112, Long r113, Long r114) {
        this(r100, r110, r111, r112, null, r113, r114);
    }

    public u(String r100, String r101, OfficeUploadFileType r102, OfficeUploadStatus r103, String r104, Long r105, Long r106) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "fileType");
        Intrinsics.checkNotNullParameter(r103, "status");
        this.f235426a = r100;
        this.f235427b = r101;
        this.f235428c = r102;
        this.f235429d = r103;
        this.f235430e = r104;
        this.f235431f = r105;
        this.f235432g = r106;
    }
}
