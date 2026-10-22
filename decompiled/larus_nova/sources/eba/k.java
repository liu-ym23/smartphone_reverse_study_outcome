package eba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jba.e f471955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jba.c f471956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f471957c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f471955a, r101.f471955a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471956b, r101.f471956b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471957c, r101.f471957c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f471955a.hashCode() * 31) + this.f471956b.hashCode()) * 31) + this.f471957c.hashCode();
    }

    public final String toString() {
        return "ObricListeningChildWindowAppearance(layoutSpec=" + this.f471955a + ", cornerRadii=" + this.f471956b + ", geometryTrace=" + this.f471957c + ')';
    }

    public k(jba.e r100, jba.c r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutSpec");
        Intrinsics.checkNotNullParameter(r101, "cornerRadii");
        Intrinsics.checkNotNullParameter(r102, "geometryTrace");
        this.f471955a = r100;
        this.f471956b = r101;
        this.f471957c = r102;
    }
}
