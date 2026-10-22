package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f474430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0 f474431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f474432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n0 f474433g;

    public final void a() {
        this.f474433g = null;
    }

    public final void b() {
        this.f474432f = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f474427a, r101.f474427a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474428b, r101.f474428b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474429c, r101.f474429c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474430d, r101.f474430d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474431e, r101.f474431e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474432f, r101.f474432f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474433g, r101.f474433g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474427a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f474428b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f474429c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.f474430d.hashCode()) * 31) + this.f474431e.hashCode()) * 31;
        String r110 = this.f474432f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        n0 r113 = this.f474433g;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfProductMarketingStyle1UIData(bgColor=" + this.f474427a + ", bgBorder=" + this.f474428b + ", leftBgColor=" + this.f474429c + ", leftIcon=" + this.f474430d + ", leftText=" + this.f474431e + ", leftSplitterImageStr=" + this.f474432f + ", leftExtendText=" + this.f474433g + ')';
    }

    public s(String r100, String r101, f r102, n0 r103, String r104, n0 r105) {
        Intrinsics.checkNotNullParameter(r102, "leftIcon");
        Intrinsics.checkNotNullParameter(r103, "leftText");
        this.f474427a = r100;
        this.f474428b = "#00000000";
        this.f474429c = r101;
        this.f474430d = r102;
        this.f474431e = r103;
        this.f474432f = r104;
        this.f474433g = r105;
    }
}
