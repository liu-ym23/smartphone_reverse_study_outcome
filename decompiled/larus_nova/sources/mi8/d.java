package mi8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f514114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f514115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f514116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f514117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f514118h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f514111a, r101.f514111a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514112b, r101.f514112b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514113c, r101.f514113c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514114d, r101.f514114d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514115e, r101.f514115e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f514116f, r101.f514116f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f514117g, r101.f514117g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f514118h, r101.f514118h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f514111a.hashCode() * 31;
        String r101 = this.f514112b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f514113c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f514114d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f514115e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f514116f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f514117g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f514118h;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
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
        return "MoaGrantingCardViewInput(cardID=" + this.f514111a + ", iconURLLight=" + this.f514112b + ", iconURLDark=" + this.f514113c + ", sourceName=" + this.f514114d + ", title=" + this.f514115e + ", subtitle=" + this.f514116f + ", refuseTitle=" + this.f514117g + ", allowTitle=" + this.f514118h + ')';
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "cardID");
        this.f514111a = r100;
        this.f514112b = r101;
        this.f514113c = r102;
        this.f514114d = r103;
        this.f514115e = r104;
        this.f514116f = r105;
        this.f514117g = r106;
        this.f514118h = r107;
    }
}
