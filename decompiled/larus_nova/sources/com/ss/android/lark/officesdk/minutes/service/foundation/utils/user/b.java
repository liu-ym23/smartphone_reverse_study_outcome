package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f434088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f434089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f434090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f434091f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f434086a, r101.f434086a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434087b, r101.f434087b) == true) goto L15;
        return false;
    L15:
        if (this.f434088c == r101.f434088c) goto L18;
        return false;
    L18:
        if (this.f434089d == r101.f434089d) goto L21;
        return false;
    L21:
        if (this.f434090e == r101.f434090e) goto L24;
        return false;
    L24:
        if (this.f434091f == r101.f434091f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f434086a.hashCode() * 31) + this.f434087b.hashCode()) * 31) + this.f434088c) * 31) + this.f434089d) * 31) + this.f434090e) * 31) + this.f434091f;
    }

    public final String toString() {
        return "MmAvatarConfig(key=" + this.f434086a + ", userId=" + this.f434087b + ", targetWidth=" + this.f434088c + ", targetHeight=" + this.f434089d + ", placeHoldResId=" + this.f434090e + ", errorResId=" + this.f434091f + ')';
    }

    public b(String r100, String r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.f434086a = r100;
        this.f434087b = r101;
        this.f434088c = r102;
        this.f434089d = r103;
        this.f434090e = r104;
        this.f434091f = r105;
    }
}
