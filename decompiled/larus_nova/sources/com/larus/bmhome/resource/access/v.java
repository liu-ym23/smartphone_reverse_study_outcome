package com.larus.bmhome.resource.access;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f313756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f313757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f313758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f313759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f313760e;

    public v() {
        this(false, false, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f313756a == r101.f313756a) goto L12;
        return false;
    L12:
        if (this.f313757b == r101.f313757b) goto L15;
        return false;
    L15:
        if (this.f313758c == r101.f313758c) goto L18;
        return false;
    L18:
        if (this.f313759d == r101.f313759d) goto L21;
        return false;
    L21:
        if (this.f313760e == r101.f313760e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f313756a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f313757b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f313758c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f313759d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f313760e == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceAccessOptions(enablePreprocess=" + this.f313756a + ", enableLocalDetect=" + this.f313757b + ", enableReview=" + this.f313758c + ", allowRemoteResolve=" + this.f313759d + ", allowRemoteFallback=" + this.f313760e + ')';
    }

    public v(boolean r100, boolean r101, boolean r102, int r103) {
        boolean r104 = false;
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r103 & 8) == 0) goto L14;
        boolean r105 = true;
    L16:
        if ((r103 & 16) == 0) goto L18;
        r104 = true;
    L18:
        this.f313756a = r100;
        this.f313757b = r101;
        this.f313758c = r102;
        this.f313759d = r105;
        this.f313760e = r104;
        return;
    L14:
        r105 = false;
        goto L16
    }
}
