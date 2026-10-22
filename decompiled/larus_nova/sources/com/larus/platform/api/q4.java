package com.larus.platform.api;

/* JADX INFO: loaded from: classes31.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365249c;

    public q4() {
        this(false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q4) == true) goto L8;
        return false;
    L8:
        q4 r101 = (q4) r100;
        if (this.f365247a == r101.f365247a) goto L12;
        return false;
    L12:
        if (this.f365248b == r101.f365248b) goto L15;
        return false;
    L15:
        if (this.f365249c == r101.f365249c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365247a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f365248b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f365249c == true) goto L15;
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
        return "OfficeSdkInitState(initTriggered=" + this.f365247a + ", globalReady=" + this.f365248b + ", userReady=" + this.f365249c + ')';
    }

    public q4(boolean r100, boolean r101, boolean r102) {
        this.f365247a = r100;
        this.f365248b = r101;
        this.f365249c = r102;
    }
}
