package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f568541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f568542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f568543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f568544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f568545h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f568538a, r101.f568538a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568539b, r101.f568539b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568540c, r101.f568540c) == true) goto L18;
        return false;
    L18:
        if (this.f568541d == r101.f568541d) goto L21;
        return false;
    L21:
        if (this.f568542e == r101.f568542e) goto L24;
        return false;
    L24:
        if (this.f568543f == r101.f568543f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f568544g, r101.f568544g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f568545h, r101.f568545h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f568538a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f568539b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f568540c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.f568541d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.f568542e == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f568543f == true) goto L27;
        r109 = 1237;
    L27:
        return ((((r113 + r109) * 31) + this.f568544g.hashCode()) * 31) + this.f568545h.hashCode();
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendTemplateParams(parentToken=" + this.f568538a + ", module=" + this.f568539b + ", subModule=" + this.f568540c + ", isFolder=" + this.f568541d + ", isFromEmpty=" + this.f568542e + ", showTitleBg=" + this.f568543f + ", createSelectResultJson=" + this.f568544g + ", spaceId=" + this.f568545h + ')';
    }

    public b(String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r105, "createSelectResultJson");
        Intrinsics.checkNotNullParameter(r106, "spaceId");
        this.f568538a = r100;
        this.f568539b = r101;
        this.f568540c = r102;
        this.f568541d = r103;
        this.f568542e = r104;
        this.f568543f = false;
        this.f568544g = r105;
        this.f568545h = r106;
    }
}
