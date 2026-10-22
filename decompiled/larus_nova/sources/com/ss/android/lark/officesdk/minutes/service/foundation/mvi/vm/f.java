package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f433872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f433873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f433874c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f433872a, r101.f433872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433873b, r101.f433873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f433874c, r101.f433874c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f433872a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f433873b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f433874c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple3(a=" + this.f433872a + ", b=" + this.f433873b + ", c=" + this.f433874c + ')';
    }

    public f(A r100, B r101, C r102) {
        this.f433872a = r100;
        this.f433873b = r101;
        this.f433874c = r102;
    }
}
