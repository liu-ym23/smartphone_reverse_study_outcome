package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f474370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f474371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f474372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f474373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f474374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474375g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f474369a, r101.f474369a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474370b, r101.f474370b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474371c, r101.f474371c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474372d, r101.f474372d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474373e, r101.f474373e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474374f, r101.f474374f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474375g, r101.f474375g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474369a.hashCode() * 31;
        Float r101 = this.f474370b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Float r105 = this.f474371c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.f474372d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Float r111 = this.f474373e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Float r114 = this.f474374f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f474375g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
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
        return "ShelfRichTextImageUIData(url=" + this.f474369a + ", width=" + this.f474370b + ", height=" + this.f474371c + ", cornerRadius=" + this.f474372d + ", offsetLeft=" + this.f474373e + ", offsetRight=" + this.f474374f + ", align=" + this.f474375g + ')';
    }

    public l0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f474369a = r100;
        this.f474370b = null;
        this.f474371c = null;
        this.f474372d = null;
        this.f474373e = null;
        this.f474374f = null;
        this.f474375g = null;
    }
}
