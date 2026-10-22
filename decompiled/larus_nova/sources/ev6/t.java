package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0 f474437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f474438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n0 f474439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474440g;

    public final void b() {
        this.f474439f = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f474434a, r101.f474434a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474435b, r101.f474435b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474436c, r101.f474436c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474437d, r101.f474437d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474438e, r101.f474438e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474439f, r101.f474439f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474440g, r101.f474440g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474434a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f474435b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f474436c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.f474437d.hashCode()) * 31) + this.f474438e.hashCode()) * 31;
        n0 r110 = this.f474439f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f474440g;
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
        return "ShelfProductMarketingStyle2UIData(bgColor=" + this.f474434a + ", bgBorder=" + this.f474435b + ", prefixBgColor=" + this.f474436c + ", leftText=" + this.f474437d + ", leftCurveImage=" + this.f474438e + ", rightText=" + this.f474439f + ", rightBgColor=" + this.f474440g + ')';
    }

    public final f a() {
        return this.f474438e;
    }

    public t(String r100, String r101, String r102, n0 r103, f r104, n0 r105) {
        Intrinsics.checkNotNullParameter(r103, "leftText");
        Intrinsics.checkNotNullParameter(r104, "leftCurveImage");
        this.f474434a = r100;
        this.f474435b = r101;
        this.f474436c = r102;
        this.f474437d = r103;
        this.f474438e = r104;
        this.f474439f = r105;
        this.f474440g = null;
    }
}
