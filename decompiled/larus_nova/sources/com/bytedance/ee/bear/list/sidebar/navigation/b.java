package com.bytedance.ee.bear.list.sidebar.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f229619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f229620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f229621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f229622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f229623e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f229619a == r101.f229619a) goto L12;
        return false;
    L12:
        if (this.f229620b == r101.f229620b) goto L15;
        return false;
    L15:
        if (this.f229621c == r101.f229621c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f229622d, r101.f229622d) == true) goto L21;
        return false;
    L21:
        if (this.f229623e == r101.f229623e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f229619a * 31) + this.f229620b) * 31) + this.f229621c) * 31) + this.f229622d.hashCode()) * 31) + this.f229623e;
    }

    public final String toString() {
        return "SidebarNavigationItem(id=" + this.f229619a + ", iconRes=" + this.f229620b + ", bgColor=" + this.f229621c + ", title=" + this.f229622d + ", tintColor=" + this.f229623e + ')';
    }

    public /* synthetic */ b(int r100, int r101, int r102, String r110) {
        this(r100, r101, r102, r110, 0);
    }

    public b(int r100, int r101, int r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r103, "title");
        this.f229619a = r100;
        this.f229620b = r101;
        this.f229621c = r102;
        this.f229622d = r103;
        this.f229623e = r104;
    }
}
