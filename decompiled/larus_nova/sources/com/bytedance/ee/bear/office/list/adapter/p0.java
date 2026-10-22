package com.bytedance.ee.bear.office.list.adapter;

/* JADX INFO: loaded from: classes18.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f235833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f235834b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (this.f235833a == r101.f235833a) goto L12;
        return false;
    L12:
        if (this.f235834b == r101.f235834b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f235833a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f235834b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeUploadMenuState(visible=" + this.f235833a + ", enabled=" + this.f235834b + ')';
    }

    public p0(boolean r100, boolean r101) {
        this.f235833a = r100;
        this.f235834b = r101;
    }
}
