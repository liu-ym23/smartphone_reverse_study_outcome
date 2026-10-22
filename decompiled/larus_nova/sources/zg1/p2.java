package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571911b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p2) == false) goto L10;
        p2 r101 = (p2) r100;
        if (Intrinsics.areEqual(this.f571910a, r101.f571910a) == true) goto L8;
        return false;
    L8:
        if (this.f571911b == r101.f571911b) goto L16;
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
        String r100 = this.f571910a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f571911b;
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
        return "RecoverVoiceBgEvent(source=" + this.f571910a + ", visible=" + this.f571911b + ")";
    }

    public p2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f571910a = r100;
        this.f571911b = true;
    }
}
