package com.ss.android.lark.maintab.export;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabAppInfo.BizType f431610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TabAppType f431611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f431612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TabAppInfo.CustomNavigationAppLogoType f431613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f431614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f431615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f431616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f431617i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f431609a, r101.f431609a) == true) goto L12;
        return false;
    L12:
        if (this.f431610b == r101.f431610b) goto L15;
        return false;
    L15:
        if (this.f431611c == r101.f431611c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f431612d, r101.f431612d) == true) goto L21;
        return false;
    L21:
        if (this.f431613e == r101.f431613e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f431614f, r101.f431614f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f431615g, r101.f431615g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f431616h, r101.f431616h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f431609a.hashCode() * 31) + this.f431610b.hashCode()) * 31) + this.f431611c.hashCode()) * 31) + this.f431612d.hashCode()) * 31) + this.f431613e.hashCode()) * 31) + this.f431614f.hashCode()) * 31) + this.f431615g.hashCode()) * 31;
        String r101 = this.f431616h;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "bizType:" + this.f431610b + ", appType:" + this.f431611c + ", name:" + this.f431612d + ", logoType:" + this.f431613e + ", logoContent:" + this.f431614f + ", bizAppId:" + this.f431616h + ", extraMap:null, nameMap:nulloriginalName:nullsubType:" + this.f431617i;
    }

    public a(String r100, TabAppInfo.BizType r101, TabAppType r102, String r103, TabAppInfo.CustomNavigationAppLogoType r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "bizType");
        Intrinsics.checkNotNullParameter(r102, "appType");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, "logoType");
        Intrinsics.checkNotNullParameter(r105, "logoContent");
        Intrinsics.checkNotNullParameter(r106, "url");
        this.f431609a = r100;
        this.f431610b = r101;
        this.f431611c = r102;
        this.f431612d = r103;
        this.f431613e = r104;
        this.f431614f = r105;
        this.f431615g = r106;
        this.f431616h = r107;
    }
}
