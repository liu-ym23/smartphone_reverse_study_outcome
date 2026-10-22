package com.larksuite.component.ui.layout;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f284227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284231e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f284227a == r101.f284227a) goto L12;
        return false;
    L12:
        if (this.f284228b == r101.f284228b) goto L15;
        return false;
    L15:
        if (this.f284229c == r101.f284229c) goto L18;
        return false;
    L18:
        if (this.f284230d == r101.f284230d) goto L21;
        return false;
    L21:
        if (this.f284231e == r101.f284231e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f284227a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((r100 * 31) + this.f284228b) * 31) + this.f284229c) * 31) + this.f284230d) * 31) + this.f284231e;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "OnLayoutData(changed=" + this.f284227a + ", l=" + this.f284228b + ", t=" + this.f284229c + ", r=" + this.f284230d + ", b=" + this.f284231e + ')';
    }

    public c() {
        this.f284227a = false;
        this.f284228b = 0;
        this.f284229c = 0;
        this.f284230d = 0;
        this.f284231e = 0;
    }
}
