package qg6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f532867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532868b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (this.f532867a == r101.f532867a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f532868b, r101.f532868b) == true) goto L16;
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
        boolean r100 = this.f532867a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f532868b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "InterceptMultiLinkResult(isIntercept=" + this.f532867a + ", interceptReason=" + this.f532868b + ")";
    }

    public h(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "interceptReason");
        this.f532867a = r100;
        this.f532868b = r101;
    }
}
