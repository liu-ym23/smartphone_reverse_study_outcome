package xb6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f563126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f563127b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f563126a, r101.f563126a) == true) goto L8;
        return false;
    L8:
        if (this.f563127b == r101.f563127b) goto L16;
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
        b r100 = this.f563126a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f563127b;
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
        return "Interceptor(interceptor=" + this.f563126a + ", isGlobal=" + this.f563127b + ")";
    }

    public e(b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f563126a = r100;
        this.f563127b = r101;
    }
}
