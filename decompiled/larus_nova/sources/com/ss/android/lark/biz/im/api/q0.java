package com.ss.android.lark.biz.im.api;

/* JADX INFO: loaded from: classes34.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410438b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (this.f410437a == r101.f410437a) goto L12;
        return false;
    L12:
        if (this.f410438b == r101.f410438b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f410437a * 31) + this.f410438b;
    }

    public final String toString() {
        return "InitialReadPosition(unreadCount=" + this.f410437a + ", lastReadPosition=" + this.f410438b + ')';
    }

    public q0(int r100, int r101) {
        this.f410437a = r100;
        this.f410438b = r101;
    }
}
