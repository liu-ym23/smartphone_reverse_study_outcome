package com.bytedance.ug.sdk.luckycat.impl.utils;

/* JADX INFO: loaded from: classes22.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f271524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271525b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof t) == false) goto L17;
        t r101 = (t) r100;
        if (this.f271524a != r101.f271524a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f271525b != r101.f271525b) goto L14;
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

    public final int hashCode() {
        return (this.f271524a * 31) + this.f271525b;
    }

    public final String toString() {
        return "ScreenInfo(width=" + this.f271524a + ", height=" + this.f271525b + ")";
    }

    public t(int r100, int r101) {
        this.f271524a = r100;
        this.f271525b = r101;
    }
}
