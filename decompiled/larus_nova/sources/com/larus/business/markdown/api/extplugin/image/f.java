package com.larus.business.markdown.api.extplugin.image;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f320464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f320465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f320466c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f320464a, r101.f320464a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f320465b, r101.f320465b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f320466c, r101.f320466c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f320464a.hashCode() * 31) + this.f320465b.hashCode()) * 31) + this.f320466c.hashCode();
    }

    public final String toString() {
        return "ImageInfo(imageUrl=" + this.f320464a + ", imageUri=" + this.f320465b + ", imageThumbUrl=" + this.f320466c + ')';
    }

    public f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r101, "imageUri");
        Intrinsics.checkNotNullParameter(r102, "imageThumbUrl");
        this.f320464a = r100;
        this.f320465b = r101;
        this.f320466c = r102;
    }
}
