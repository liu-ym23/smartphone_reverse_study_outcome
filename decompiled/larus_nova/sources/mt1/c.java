package mt1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f515604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515605b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f515604a == r101.f515604a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f515605b, r101.f515605b) == true) goto L16;
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
        boolean r100 = this.f515604a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f515605b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "ShowRecommendReasonDialogEvent(isFirstRecommend=" + this.f515604a + ", entranceName=" + this.f515605b + ")";
    }

    public c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "entranceName");
        this.f515604a = r100;
        this.f515605b = r101;
    }
}
