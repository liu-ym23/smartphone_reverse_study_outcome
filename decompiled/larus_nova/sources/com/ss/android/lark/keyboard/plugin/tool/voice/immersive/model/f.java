package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f430379b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f430378a == r101.f430378a) goto L12;
        return false;
    L12:
        if (this.f430379b == r101.f430379b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f430378a * 31;
        if (this.f430379b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ElapseCountDownData(countDown=" + this.f430378a + ", shouldHideWaveBar=" + this.f430379b + ')';
    }

    public f(int r100, boolean r101) {
        this.f430378a = r100;
        this.f430379b = r101;
    }
}
