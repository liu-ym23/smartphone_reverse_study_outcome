package sl9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f542497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f542501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f542502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f542503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f542504h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f542497a, r101.f542497a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542498b, r101.f542498b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f542499c, r101.f542499c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542500d, r101.f542500d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f542501e, r101.f542501e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f542502f, r101.f542502f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f542503g, r101.f542503g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f542504h, r101.f542504h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f542497a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f542498b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.f542499c.hashCode()) * 31) + this.f542500d.hashCode()) * 31) + this.f542501e.hashCode()) * 31) + this.f542502f.hashCode()) * 31) + this.f542503g.hashCode()) * 31;
        String r107 = this.f542504h;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonDialogConfig(iconRes=" + this.f542497a + ", iconResUrl=" + this.f542498b + ", applicationName=" + this.f542499c + ", mainTitle=" + this.f542500d + ", subtitle=" + this.f542501e + ", cancelText=" + this.f542502f + ", confirmText=" + this.f542503g + ", confirmSubText=" + this.f542504h + ')';
    }

    public l(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "applicationName");
        Intrinsics.checkNotNullParameter(r103, "mainTitle");
        Intrinsics.checkNotNullParameter(r104, "subtitle");
        Intrinsics.checkNotNullParameter(r105, "cancelText");
        Intrinsics.checkNotNullParameter(r106, "confirmText");
        this.f542497a = r100;
        this.f542498b = r101;
        this.f542499c = r102;
        this.f542500d = r103;
        this.f542501e = r104;
        this.f542502f = r105;
        this.f542503g = r106;
        this.f542504h = r107;
    }
}
