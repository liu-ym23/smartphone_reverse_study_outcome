package com.bytedance.lark.lark_bitable_android;

/* JADX INFO: loaded from: classes43.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f253082c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f253080a == r101.f253080a) goto L12;
        return false;
    L12:
        if (this.f253081b == r101.f253081b) goto L15;
        return false;
    L15:
        if (this.f253082c == r101.f253082c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f253080a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f253081b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f253082c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HomepageTagConfig(showTemplate=" + this.f253080a + ", showExternal=" + this.f253081b + ", showFileRiskTag=" + this.f253082c + ')';
    }

    public l0(boolean r100, boolean r101, boolean r102) {
        this.f253080a = r100;
        this.f253081b = r101;
        this.f253082c = r102;
    }
}
