package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f241541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f241542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WikiInfo f241543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f241544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f241545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f241546i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f241538a, r101.f241538a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241539b, r101.f241539b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f241540c, r101.f241540c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f241541d, r101.f241541d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f241542e, r101.f241542e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f241543f, r101.f241543f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f241544g, r101.f241544g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f241545h, r101.f241545h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f241546i, r101.f241546i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f241538a.hashCode() * 31) + this.f241539b.hashCode()) * 31;
        String r101 = this.f241540c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f241541d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f241542e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        WikiInfo r111 = this.f241543f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f241544g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f241545h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return ((r116 + r102) * 31) + this.f241546i.hashCode();
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "NavigationParams(openType=" + this.f241538a + ", targetToken=" + this.f241539b + ", targetSpaceId=" + this.f241540c + ", targetSpaceName=" + this.f241541d + ", title=" + this.f241542e + ", wikiInfo=" + this.f241543f + ", targetUniqueUiId=" + this.f241544g + ", from=" + this.f241545h + ", visibleSpaceId=" + this.f241546i + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, WikiInfo r105, String r106, String r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r112 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r112 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r112 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r112 & 64) == 0) goto L18;
        r106 = null;
    L18:
        if ((r112 & 128) == 0) goto L21;
        r110 = null;
    L21:
        if ((r112 & 256) == 0) goto L23;
        r111 = "";
    L23:
        Intrinsics.checkNotNullParameter(r100, "openType");
        Intrinsics.checkNotNullParameter(r101, "targetToken");
        Intrinsics.checkNotNullParameter(r111, "visibleSpaceId");
        this.f241538a = r100;
        this.f241539b = r101;
        this.f241540c = r102;
        this.f241541d = r103;
        this.f241542e = r104;
        this.f241543f = r105;
        this.f241544g = r106;
        this.f241545h = r110;
        this.f241546i = r111;
    }
}
