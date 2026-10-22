package com.bytedance.badger.x;

/* JADX INFO: loaded from: classes47.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f199431b;

    public z(boolean r100, boolean r101) {
        this.f199430a = r100;
        this.f199431b = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof z) == false) goto L17;
        z r101 = (z) r100;
        if (this.f199430a != r101.f199430a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f199431b != r101.f199431b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f199430a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f199431b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "DeviceSupportInfo(isSupportProvider=" + this.f199430a + ", isSupportService=" + this.f199431b + ")";
    }
}
