package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f474393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f474395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f474397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f474398g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f474392a, r101.f474392a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474393b, r101.f474393b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474394c, r101.f474394c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474395d, r101.f474395d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474396e, r101.f474396e) == true) goto L24;
        return false;
    L24:
        if (this.f474397f == r101.f474397f) goto L27;
        return false;
    L27:
        if (this.f474398g == r101.f474398g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474392a.hashCode() * 31;
        Float r101 = this.f474393b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f474394c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f474395d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f474396e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        int r113 = 1231;
        if (this.f474397f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f474398g == true) goto L27;
        r113 = 1237;
    L27:
        return r115 + r113;
    L21:
        r114 = 1237;
        goto L22
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
        return "ShelfTextUIData(text=" + this.f474392a + ", textSize=" + this.f474393b + ", textColor=" + this.f474394c + ", fontWeight=" + this.f474395d + ", fontFamily=" + this.f474396e + ", strike=" + this.f474397f + ", underline=" + this.f474398g + ')';
    }

    public n0(String r100, String r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f474392a = r100;
        this.f474393b = null;
        this.f474394c = r101;
        this.f474395d = null;
        this.f474396e = null;
        this.f474397f = false;
        this.f474398g = false;
    }
}
