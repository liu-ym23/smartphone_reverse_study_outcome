package mb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f512762b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f512761a, r101.f512761a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512762b, r101.f512762b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512761a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f512762b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportNode(path=" + this.f512761a + ", param=" + this.f512762b + ")";
    }

    public g(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f512761a = r100;
        this.f512762b = r101;
    }
}
