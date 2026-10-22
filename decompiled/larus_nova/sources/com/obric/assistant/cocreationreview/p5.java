package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f387652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ModuleKey f387653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f387654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f387655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f387656g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p5) == true) goto L8;
        return false;
    L8:
        p5 r101 = (p5) r100;
        if (Intrinsics.areEqual(this.f387650a, r101.f387650a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387651b, r101.f387651b) == true) goto L15;
        return false;
    L15:
        if (this.f387652c == r101.f387652c) goto L18;
        return false;
    L18:
        if (this.f387653d == r101.f387653d) goto L21;
        return false;
    L21:
        if (this.f387654e == r101.f387654e) goto L24;
        return false;
    L24:
        if (this.f387655f == r101.f387655f) goto L27;
        return false;
    L27:
        if (this.f387656g == r101.f387656g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f387650a.hashCode() * 31) + this.f387651b.hashCode()) * 31) + this.f387652c) * 31;
        ModuleKey r101 = this.f387653d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f387654e) * 31;
        if (this.f387655f == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f387656g;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModuleTabState(id=" + this.f387650a + ", text=" + this.f387651b + ", iconRes=" + this.f387652c + ", module=" + this.f387653d + ", count=" + this.f387654e + ", selected=" + this.f387655f + ", accentColor=" + this.f387656g + ')';
    }

    public p5(String r100, String r101, int r102, ModuleKey r103, int r104, boolean r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f387650a = r100;
        this.f387651b = r101;
        this.f387652c = r102;
        this.f387653d = r103;
        this.f387654e = r104;
        this.f387655f = r105;
        this.f387656g = r106;
    }
}
