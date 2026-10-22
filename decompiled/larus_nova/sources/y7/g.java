package y7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566571d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f566568a == r101.f566568a) goto L12;
        return false;
    L12:
        if (this.f566569b == r101.f566569b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566570c, r101.f566570c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566571d, r101.f566571d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f566568a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f566569b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.f566570c.hashCode()) * 31;
        String r104 = this.f566571d;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfflineState(offline=" + this.f566568a + ", useForest=" + this.f566569b + ", resFrom=" + this.f566570c + ", version=" + this.f566571d + ')';
    }

    public g(boolean r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "resFrom");
        this.f566568a = r100;
        this.f566569b = r101;
        this.f566570c = r102;
        this.f566571d = r103;
    }
}
