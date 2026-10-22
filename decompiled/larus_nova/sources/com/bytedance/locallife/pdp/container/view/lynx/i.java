package com.bytedance.locallife.pdp.container.view.lynx;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f261327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f261328b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f261327a == r101.f261327a) goto L12;
        return false;
    L12:
        if (this.f261328b == r101.f261328b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f261327a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f261328b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LoadResultStats(hasPreloaded=" + this.f261327a + ", hasAddedToScreen=" + this.f261328b + ')';
    }

    public i(boolean r100, boolean r101) {
        this.f261327a = r100;
        this.f261328b = r101;
    }
}
