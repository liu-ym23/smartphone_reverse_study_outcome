package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i<A, B, C, D, E, F> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f433884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f433885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f433886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f433887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f433888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F f433889f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f433884a, r101.f433884a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433885b, r101.f433885b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f433886c, r101.f433886c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f433887d, r101.f433887d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f433888e, r101.f433888e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f433889f, r101.f433889f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f433884a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f433885b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f433886c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f433887d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f433888e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        F r116 = this.f433889f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple6(a=" + this.f433884a + ", b=" + this.f433885b + ", c=" + this.f433886c + ", d=" + this.f433887d + ", e=" + this.f433888e + ", f=" + this.f433889f + ')';
    }

    public i(A r100, B r101, C r102, D r103, E r104, F r105) {
        this.f433884a = r100;
        this.f433885b = r101;
        this.f433886c = r102;
        this.f433887d = r103;
        this.f433888e = r104;
        this.f433889f = r105;
    }
}
