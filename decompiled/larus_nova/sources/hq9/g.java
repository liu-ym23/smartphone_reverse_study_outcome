package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f486606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f486607b;

    public g() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f486606a, r101.f486606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486607b, r101.f486607b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        d0 r100 = this.f486606a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b1 r104 = this.f486607b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AndroidConfig(capabilities=" + this.f486606a + ", features=" + this.f486607b + ')';
    }

    public g(d0 r100, b1 r101) {
        this.f486606a = r100;
        this.f486607b = r101;
    }
}
