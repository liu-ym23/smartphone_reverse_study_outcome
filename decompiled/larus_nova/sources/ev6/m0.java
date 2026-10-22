package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f474383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f474384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f474385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f474387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f474388g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f474382a, r101.f474382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474383b, r101.f474383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474384c, r101.f474384c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474385d, r101.f474385d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474386e, r101.f474386e) == true) goto L24;
        return false;
    L24:
        if (this.f474387f == r101.f474387f) goto L27;
        return false;
    L27:
        if (this.f474388g == r101.f474388g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474382a.hashCode() * 31;
        Float r101 = this.f474383b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f474384c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f474385d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f474386e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        int r113 = 1231;
        if (this.f474387f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f474388g == true) goto L27;
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
        return "ShelfRichTextTextUIData(text=" + this.f474382a + ", textSize=" + this.f474383b + ", textColor=" + this.f474384c + ", fontWeight=" + this.f474385d + ", fontFamily=" + this.f474386e + ", strike=" + this.f474387f + ", underline=" + this.f474388g + ')';
    }

    public final void a(String r100) {
        this.f474386e = r100;
    }

    public final void b(String r100) {
        this.f474384c = r100;
    }

    public final void c(Float r100) {
        this.f474383b = r100;
    }

    public m0(String r100, Float r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 32) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f474382a = r100;
        this.f474383b = r101;
        this.f474384c = null;
        this.f474385d = null;
        this.f474386e = null;
        this.f474387f = r102;
        this.f474388g = false;
    }
}
