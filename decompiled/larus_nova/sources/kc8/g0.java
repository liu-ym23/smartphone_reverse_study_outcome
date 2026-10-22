package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f502491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f502492d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f502489a, r101.f502489a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502490b, r101.f502490b) == true) goto L15;
        return false;
    L15:
        if (this.f502491c == r101.f502491c) goto L18;
        return false;
    L18:
        if (this.f502492d == r101.f502492d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f502489a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f502490b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f502491c) * 31) + this.f502492d;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalCreationImageResource(url=" + this.f502489a + ", urlV2=" + this.f502490b + ", width=" + this.f502491c + ", height=" + this.f502492d + ')';
    }

    public g0(String r100, String r101, int r102, int r103) {
        this.f502489a = r100;
        this.f502490b = r101;
        this.f502491c = r102;
        this.f502492d = r103;
    }
}
