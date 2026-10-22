package com.bytedance.locallife.dito.helper;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f258310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f258311b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f258310a == r101.f258310a) goto L12;
        return false;
    L12:
        if (this.f258311b == r101.f258311b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f258310a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f258311b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "OffsetData(changed=" + this.f258310a + ", scrollOffset=" + this.f258311b + ')';
    }

    public e(boolean r100, int r101) {
        this.f258310a = r100;
        this.f258311b = r101;
    }
}
