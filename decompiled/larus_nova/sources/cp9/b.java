package cp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f464728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464729b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f464728a == r101.f464728a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464729b, r101.f464729b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f464728a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f464729b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PerfDegradeResult(accepted=" + this.f464728a + ", reason=" + this.f464729b + ')';
    }

    public b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f464728a = r100;
        this.f464729b = r101;
    }
}
