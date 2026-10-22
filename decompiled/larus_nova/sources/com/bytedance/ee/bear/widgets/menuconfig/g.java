package com.bytedance.ee.bear.widgets.menuconfig;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f240257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f240258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f240259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f240260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f240261e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f240257a, r101.f240257a) == true) goto L12;
        return false;
    L12:
        if (this.f240258b == r101.f240258b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f240259c, r101.f240259c) == true) goto L18;
        return false;
    L18:
        if (this.f240260d == r101.f240260d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f240261e, r101.f240261e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f240257a.hashCode() * 31;
        if (this.f240258b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f240259c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r102 + r105) * 31) + this.f240260d) * 31;
        String r107 = this.f240261e;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSpaceMenuItem(itemId=" + this.f240257a + ", visible=" + this.f240258b + ", groupId=" + this.f240259c + ", order=" + this.f240260d + ", subMenuId=" + this.f240261e + ')';
    }

    public g(String r100, boolean r101, String r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        this.f240257a = r100;
        this.f240258b = r101;
        this.f240259c = r102;
        this.f240260d = r103;
        this.f240261e = r104;
    }
}
