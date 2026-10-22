package u2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f548393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f548397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f548398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f548399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f548400h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f548393a, r101.f548393a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548394b, r101.f548394b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548395c, r101.f548395c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548396d, r101.f548396d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f548397e, r101.f548397e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548398f, r101.f548398f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f548399g, r101.f548399g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f548400h, r101.f548400h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f548393a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f548394b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((r103 + r105) * 31) + this.f548395c.hashCode()) * 31) + this.f548396d.hashCode()) * 31) + this.f548397e.hashCode()) * 31) + this.f548398f.hashCode()) * 31;
        String r107 = this.f548399g;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f548400h.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalGrantingDialogConfig(iconRes=" + this.f548393a + ", iconResUrl=" + this.f548394b + ", applicationName=" + this.f548395c + ", mainTitle=" + this.f548396d + ", subtitle=" + this.f548397e + ", confirmText=" + this.f548398f + ", confirmSubText=" + this.f548399g + ", cancelText=" + this.f548400h + ')';
    }

    public /* synthetic */ i(Integer r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, null, r116);
    }

    public i(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "applicationName");
        Intrinsics.checkNotNullParameter(r103, "mainTitle");
        Intrinsics.checkNotNullParameter(r104, "subtitle");
        Intrinsics.checkNotNullParameter(r105, "confirmText");
        Intrinsics.checkNotNullParameter(r107, "cancelText");
        this.f548393a = r100;
        this.f548394b = r101;
        this.f548395c = r102;
        this.f548396d = r103;
        this.f548397e = r104;
        this.f548398f = r105;
        this.f548399g = r106;
        this.f548400h = r107;
    }
}
