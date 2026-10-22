package yp0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f568697b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f568696a, r101.f568696a) == true) goto L8;
        return false;
    L8:
        if (this.f568697b == r101.f568697b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f568696a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f568697b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "GroupTitle(title=" + this.f568696a + ", topMargin=" + this.f568697b + ")";
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f568696a = r100;
        this.f568697b = r101;
    }
}
