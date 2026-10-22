package g79;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f480335d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f480332a, r101.f480332a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480333b, r101.f480333b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f480334c, r101.f480334c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f480335d, r101.f480335d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f480332a.hashCode() * 31;
        String r101 = this.f480333b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f480334c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f480335d.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DrivePreloadToken(preloadId=" + this.f480332a + ", requestId=" + this.f480333b + ", requestKeyHash=" + this.f480334c + ", startState=" + this.f480335d + ')';
    }

    public a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "preloadId");
        Intrinsics.checkNotNullParameter(r103, "startState");
        this.f480332a = r100;
        this.f480333b = r101;
        this.f480334c = r102;
        this.f480335d = r103;
    }
}
