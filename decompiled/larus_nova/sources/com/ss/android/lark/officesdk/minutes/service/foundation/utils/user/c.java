package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f434094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f434095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f434096e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f434092a, r101.f434092a) == true) goto L12;
        return false;
    L12:
        if (this.f434093b == r101.f434093b) goto L15;
        return false;
    L15:
        if (this.f434094c == r101.f434094c) goto L18;
        return false;
    L18:
        if (this.f434095d == r101.f434095d) goto L21;
        return false;
    L21:
        if (this.f434096e == r101.f434096e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f434092a.hashCode() * 31) + this.f434093b) * 31) + this.f434094c) * 31) + this.f434095d) * 31) + this.f434096e;
    }

    public final String toString() {
        return "MmAvatarUrlConfig(url=" + this.f434092a + ", targetWidth=" + this.f434093b + ", targetHeight=" + this.f434094c + ", placeHoldResId=" + this.f434095d + ", errorResId=" + this.f434096e + ')';
    }

    public c(String r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f434092a = r100;
        this.f434093b = r101;
        this.f434094c = r102;
        this.f434095d = r103;
        this.f434096e = r104;
    }
}
