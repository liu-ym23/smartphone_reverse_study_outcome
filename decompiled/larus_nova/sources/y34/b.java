package y34;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f565848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565849b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f565848a == r101.f565848a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565849b, r101.f565849b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f565848a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f565849b.hashCode();
    }

    public final String toString() {
        return "InterceptResult(intercepted=" + this.f565848a + ", failReason=" + this.f565849b + ')';
    }

    public b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "failReason");
        this.f565848a = r100;
        this.f565849b = r101;
    }
}
