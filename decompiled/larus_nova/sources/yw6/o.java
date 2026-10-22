package yw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f569343c;

    public /* synthetic */ o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f569341a, r101.f569341a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569342b, r101.f569342b) == true) goto L15;
        return false;
    L15:
        if (this.f569343c == r101.f569343c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f569341a.hashCode() * 31) + this.f569342b.hashCode()) * 31) + this.f569343c;
    }

    public final String toString() {
        return "GoodsDetailExitState(closeMethod=" + this.f569341a + ", projectDetailType=" + this.f569342b + ", realExitScene=" + this.f569343c + ')';
    }

    public o(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "closeMethod");
        Intrinsics.checkNotNullParameter(r101, "projectDetailType");
        this.f569341a = r100;
        this.f569342b = r101;
        this.f569343c = r102;
    }
}
