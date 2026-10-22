package dt;

import com.bytedance.ies.sve_core.s;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f469993c;

    public h() {
        this(false, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (this.f469991a == r101.f469991a) goto L8;
        return false;
    L8:
        if (this.f469992b == r101.f469992b) goto L10;
        return false;
    L10:
        if (this.f469993c == r101.f469993c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r100 = this.f469991a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f469992b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((r103 + r101) * 31) + this.f469993c;
    }

    public final String toString() {
        return "SimpleNetworkState(loading=" + this.f469991a + ", success=" + this.f469992b + ", errorCode=" + this.f469993c + ")";
    }

    public h(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this.f469991a = r100;
        this.f469992b = r101;
        this.f469993c = 0;
    }
}
