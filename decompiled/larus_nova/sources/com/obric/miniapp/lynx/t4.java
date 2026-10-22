package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f398290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f398292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f398293d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r101 = (t4) r100;
        if (Intrinsics.areEqual(this.f398290a, r101.f398290a) == true) goto L12;
        return false;
    L12:
        if (this.f398291b == r101.f398291b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f398292c, r101.f398292c) == true) goto L18;
        return false;
    L18:
        if (this.f398293d == r101.f398293d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f398290a.hashCode() * 31) + this.f398291b) * 31) + this.f398292c.hashCode()) * 31;
        if (this.f398293d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MiniAppDialogActionItem(title=" + this.f398290a + ", buttonStyleResId=" + this.f398291b + ", eventType=" + this.f398292c + ", disabled=" + this.f398293d + ')';
    }

    public t4(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        this.f398290a = r100;
        this.f398291b = r101;
        this.f398292c = r102;
        this.f398293d = r103;
    }
}
