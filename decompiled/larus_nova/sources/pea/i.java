package pea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528800c;

    public /* synthetic */ i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f528798a, r101.f528798a) == true) goto L12;
        return false;
    L12:
        if (this.f528799b == r101.f528799b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528800c, r101.f528800c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528798a.hashCode() * 31) + this.f528799b) * 31;
        String r101 = this.f528800c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "GRIcon(pic=" + this.f528798a + ", picResId=" + this.f528799b + ", packageName=" + this.f528800c + ')';
    }

    public i(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pic");
        this.f528798a = r100;
        this.f528799b = r101;
        this.f528800c = r102;
    }
}
