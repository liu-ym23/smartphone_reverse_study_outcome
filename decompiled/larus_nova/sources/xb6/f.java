package xb6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb6.f f563128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f563129b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f563128a, r101.f563128a) == true) goto L8;
        return false;
    L8:
        if (this.f563129b == r101.f563129b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        vb6.f r100 = this.f563128a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f563129b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "Listener(listener=" + this.f563128a + ", isGlobal=" + this.f563129b + ")";
    }

    public f(vb6.f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f563128a = r100;
        this.f563129b = r101;
    }
}
