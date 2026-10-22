package com.larus.office.card.urlpreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f362054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeUrlPreviewResolution f362055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f362056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f362057d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (this.f362054a == r101.f362054a) goto L12;
        return false;
    L12:
        if (this.f362055b == r101.f362055b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f362056c, r101.f362056c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f362057d, r101.f362057d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f362054a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f362055b.hashCode()) * 31;
        String r102 = this.f362056c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Boolean r106 = this.f362057d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeUrlPreviewRenderSignature(compact=" + this.f362054a + ", resolution=" + this.f362055b + ", previewId=" + this.f362056c + ", needLocalPreview=" + this.f362057d + ')';
    }

    public z1(boolean r100, OfficeUrlPreviewResolution r101, String r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "resolution");
        this.f362054a = r100;
        this.f362055b = r101;
        this.f362056c = r102;
        this.f362057d = r103;
    }
}
