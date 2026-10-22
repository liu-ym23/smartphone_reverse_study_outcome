package com.larus.bmhome.chat.bubble.floating;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BubbleBannerStyle f297480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f297481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f297483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f297484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f297485f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f297480a == r101.f297480a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297481b, r101.f297481b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297482c, r101.f297482c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297483d, r101.f297483d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f297484e, r101.f297484e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f297485f, r101.f297485f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f297480a.hashCode() * 31;
        String r101 = this.f297481b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f297482c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f297483d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f297484e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f297485f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerUI(style=" + this.f297480a + ", title=" + this.f297481b + ", icon=" + this.f297482c + ", subtitle=" + this.f297483d + ", buttonText=" + this.f297484e + ", jumpSchema=" + this.f297485f + ')';
    }

    public a(BubbleBannerStyle r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f297480a = r100;
        this.f297481b = r101;
        this.f297482c = r102;
        this.f297483d = r103;
        this.f297484e = r104;
        this.f297485f = r105;
    }
}
