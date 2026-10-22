package com.larus.office.card.urlpreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f362052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f362053b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f362052a, r101.f362052a) == true) goto L12;
        return false;
    L12:
        if (this.f362053b == r101.f362053b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f362052a.hashCode() * 31;
        if (this.f362053b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeUrlPreviewInfo(previewId=" + this.f362052a + ", needLocalPreview=" + this.f362053b + ')';
    }

    public z0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        this.f362052a = r100;
        this.f362053b = r101;
    }
}
