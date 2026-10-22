package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f234120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f234121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f234122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f234123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f234124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f234125f;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f234120a, r101.f234120a) == true) goto L12;
        return false;
    L12:
        if (this.f234121b == r101.f234121b) goto L15;
        return false;
    L15:
        if (this.f234122c == r101.f234122c) goto L18;
        return false;
    L18:
        if (this.f234123d == r101.f234123d) goto L21;
        return false;
    L21:
        if (this.f234124e == r101.f234124e) goto L24;
        return false;
    L24:
        if (this.f234125f == r101.f234125f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f234120a.hashCode() * 31;
        int r101 = 1231;
        if (this.f234121b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f234122c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f234123d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f234124e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f234125f == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResponseBannerParam(msg=" + this.f234120a + ", showBtn=" + this.f234121b + ", showClose=" + this.f234122c + ", showBanner=" + this.f234123d + ", autoBanner=" + this.f234124e + ", isForceSecret=" + this.f234125f + ')';
    }

    public o(int r100) {
        Intrinsics.checkNotNullParameter("", "msg");
        this.f234120a = "";
        this.f234121b = false;
        this.f234122c = false;
        this.f234123d = false;
        this.f234124e = false;
        this.f234125f = false;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f234120a = r100;
    }
}
