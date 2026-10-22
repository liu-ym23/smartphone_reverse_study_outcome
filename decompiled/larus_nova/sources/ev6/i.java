package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f474330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f474331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f474332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f474333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f474335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f474336g;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Float.compare(this.f474330a, r101.f474330a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474331b, r101.f474331b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f474332c, r101.f474332c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474333d, r101.f474333d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474334e, r101.f474334e) == true) goto L24;
        return false;
    L24:
        if (this.f474335f == r101.f474335f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474336g, r101.f474336g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f474330a) * 31;
        String r101 = this.f474331b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + Float.floatToIntBits(this.f474332c)) * 31;
        String r105 = this.f474333d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f474334e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f474335f == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        String r113 = this.f474336g;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return r112 + r102;
    L17:
        r111 = 1237;
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
        return "ShelfProductActionAreaUIData(width=" + this.f474330a + ", bgImageUrl=" + this.f474331b + ", btnWidth=" + this.f474332c + ", btnContent=" + this.f474333d + ", btnOpacity=" + this.f474334e + ", btnClickable=" + this.f474335f + ", btnClickToast=" + this.f474336g + ')';
    }

    public final float a() {
        return this.f474330a;
    }

    public i(int r100) {
        this.f474330a = 80.0f;
        this.f474331b = null;
        this.f474332c = 80.0f;
        this.f474333d = null;
        this.f474334e = null;
        this.f474335f = true;
        this.f474336g = null;
    }

    public final void b(String r100) {
        this.f474331b = r100;
    }

    public final void c(String r100) {
        this.f474336g = r100;
    }

    public final void d(boolean r100) {
        this.f474335f = r100;
    }

    public final void e(String r100) {
        this.f474333d = r100;
    }

    public final void f(String r100) {
        this.f474334e = r100;
    }

    public final void g(float r100) {
        this.f474332c = r100;
    }

    public final void h(float r100) {
        this.f474330a = r100;
    }
}
