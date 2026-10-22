package com.larus.bmhome.auth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f295800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f295801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f295802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f295803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f295804f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (Intrinsics.areEqual(this.f295799a, r101.f295799a) == true) goto L12;
        return false;
    L12:
        if (this.f295800b == r101.f295800b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295801c, r101.f295801c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295802d, r101.f295802d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295803e, r101.f295803e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295804f, r101.f295804f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f295799a.hashCode() * 31;
        if (this.f295800b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        h0 r103 = this.f295801c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        e0 r107 = this.f295802d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        j0 r110 = this.f295803e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        b r113 = this.f295804f;
        if (r113 == null) goto L23;
        r104 = r113.hashCode();
    L23:
        return r112 + r104;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SplitLaunchCacheSnapshot(userId=" + this.f295799a + ", isLogin=" + this.f295800b + ", core=" + this.f295801c + ", basic=" + this.f295802d + ", im=" + this.f295803e + ", audio=" + this.f295804f + ')';
    }

    public g1(String r100, boolean r101, h0 r102, e0 r103, j0 r104, b r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f295799a = r100;
        this.f295800b = r101;
        this.f295801c = r102;
        this.f295802d = r103;
        this.f295803e = r104;
        this.f295804f = r105;
    }
}
