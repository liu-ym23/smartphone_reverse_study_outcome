package z82;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f570895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f570896b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f570895a == r101.f570895a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f570896b, r101.f570896b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f570895a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.f570896b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "PkProgressBarOption(transForPkBar=" + this.f570895a + ", pkBarHeight=" + this.f570896b + ')';
    }

    public c(Integer r100) {
        this.f570895a = false;
        this.f570896b = r100;
    }
}
