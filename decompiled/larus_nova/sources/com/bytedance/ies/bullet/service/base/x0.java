package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f247930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247932d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f247929a, r101.f247929a) == true) goto L12;
        return false;
    L12:
        if (this.f247930b == r101.f247930b) goto L15;
        return false;
    L15:
        if (this.f247931c == r101.f247931c) goto L18;
        return false;
    L18:
        if (this.f247932d == r101.f247932d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f247929a.hashCode() * 31) + this.f247930b) * 31;
        int r101 = 1231;
        if (this.f247931c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f247932d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreloadImageConfig(url=" + this.f247929a + ", priority=" + this.f247930b + ", serial=" + this.f247931c + ", enableMemory=" + this.f247932d + ')';
    }

    public x0(String r100, int r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f247929a = r100;
        this.f247930b = r101;
        this.f247931c = r102;
        this.f247932d = r103;
    }
}
