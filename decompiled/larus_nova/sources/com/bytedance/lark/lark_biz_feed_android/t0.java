package com.bytedance.lark.lark_biz_feed_android;

/* JADX INFO: loaded from: classes8.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253200b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.f253199a == r101.f253199a) goto L12;
        return false;
    L12:
        if (this.f253200b == r101.f253200b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f253199a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f253200b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ListStatus(isLoading=" + this.f253199a + ", isEmpty=" + this.f253200b + ')';
    }

    public t0(boolean r100, boolean r101) {
        this.f253199a = r100;
        this.f253200b = r101;
    }
}
