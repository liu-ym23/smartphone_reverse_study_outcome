package mn0;

import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f514511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Triple<Boolean, Integer, Integer> f514512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f514513c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f514511a == r101.f514511a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f514512b, r101.f514512b) == true) goto L10;
        return false;
    L10:
        if (this.f514513c == r101.f514513c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f514511a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        Triple<Boolean, Integer, Integer> r104 = this.f514512b;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f514513c;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "{needAdjustXScreen = " + this.f514511a + ", livePlayerVideoSizeAdapt = " + this.f514512b + '}';
    }

    public a(Triple r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "livePlayerVideoSizeAdapt");
        this.f514511a = false;
        this.f514512b = r100;
        this.f514513c = r101;
    }
}
