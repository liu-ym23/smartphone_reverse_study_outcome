package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f247921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f247924e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f247920a, r101.f247920a) == true) goto L12;
        return false;
    L12:
        if (this.f247921b == r101.f247921b) goto L15;
        return false;
    L15:
        if (this.f247922c == r101.f247922c) goto L18;
        return false;
    L18:
        if (this.f247923d == r101.f247923d) goto L21;
        return false;
    L21:
        if (this.f247924e == r101.f247924e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f247920a.hashCode() * 31) + this.f247921b) * 31;
        int r101 = 1231;
        if (this.f247922c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f247923d == true) goto L10;
        r101 = 1237;
    L10:
        long r104 = this.f247924e;
        return ((r103 + r101) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreloadFontConfig(url=" + this.f247920a + ", priority=" + this.f247921b + ", serial=" + this.f247922c + ", enableMemory=" + this.f247923d + ", expire=" + this.f247924e + ')';
    }

    public v0(String r100, int r101, boolean r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f247920a = r100;
        this.f247921b = r101;
        this.f247922c = r102;
        this.f247923d = r103;
        this.f247924e = r104;
    }
}
