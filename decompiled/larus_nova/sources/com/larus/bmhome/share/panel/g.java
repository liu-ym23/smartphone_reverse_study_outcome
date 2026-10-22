package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313903d;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f313900a, r101.f313900a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313901b, r101.f313901b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313902c, r101.f313902c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313903d, r101.f313903d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f313900a.hashCode() * 31) + this.f313901b.hashCode()) * 31) + this.f313902c.hashCode()) * 31) + this.f313903d.hashCode();
    }

    public final String toString() {
        return "NewShareData(newQRCodeUrl=" + this.f313900a + ", oldQRCodeUrl=" + this.f313901b + ", newShareUrl=" + this.f313902c + ", oldShareUrl=" + this.f313903d + ')';
    }

    public /* synthetic */ g(int r100) {
        this("", "", "", "");
    }

    public g(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "newQRCodeUrl");
        Intrinsics.checkNotNullParameter(r101, "oldQRCodeUrl");
        Intrinsics.checkNotNullParameter(r102, "newShareUrl");
        Intrinsics.checkNotNullParameter(r103, "oldShareUrl");
        this.f313900a = r100;
        this.f313901b = r101;
        this.f313902c = r102;
        this.f313903d = r103;
    }
}
