package com.larus.bmhome.view;

/* JADX INFO: loaded from: classes26.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f316929b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f4) == true) goto L8;
        return false;
    L8:
        f4 r101 = (f4) r100;
        if (this.f316928a == r101.f316928a) goto L12;
        return false;
    L12:
        if (this.f316929b == r101.f316929b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316928a * 31;
        if (this.f316929b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SelectButtonState(index=" + this.f316928a + ", selected=" + this.f316929b + ')';
    }

    public f4(int r100, boolean r101) {
        this.f316928a = r100;
        this.f316929b = r101;
    }
}
