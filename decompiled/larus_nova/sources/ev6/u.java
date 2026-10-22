package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f474442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f474443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0 f474444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f474445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n0 f474446f;

    public final void b() {
        this.f474446f = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f474441a, r101.f474441a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474442b, r101.f474442b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474443c, r101.f474443c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474444d, r101.f474444d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474445e, r101.f474445e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474446f, r101.f474446f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474441a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f474442b.hashCode()) * 31;
        f r104 = this.f474443c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        n0 r107 = this.f474444d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f474445e.hashCode()) * 31;
        n0 r110 = this.f474446f;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ShelfProductMarketingStyle3UIData(contentBgColor=" + this.f474441a + ", prefixImage=" + this.f474442b + ", leftBgUrl=" + this.f474443c + ", leftText=" + this.f474444d + ", leftCurveImage=" + this.f474445e + ", rightText=" + this.f474446f + ')';
    }

    public final f a() {
        return this.f474445e;
    }

    public u(String r100, f r101, f r102, n0 r103, f r104, n0 r105) {
        Intrinsics.checkNotNullParameter(r101, "prefixImage");
        Intrinsics.checkNotNullParameter(r104, "leftCurveImage");
        this.f474441a = r100;
        this.f474442b = r101;
        this.f474443c = r102;
        this.f474444d = r103;
        this.f474445e = r104;
        this.f474446f = r105;
    }
}
