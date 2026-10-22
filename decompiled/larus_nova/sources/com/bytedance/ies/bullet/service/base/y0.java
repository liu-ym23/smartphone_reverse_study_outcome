package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f247934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f247937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f247938f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f247933a, r101.f247933a) == true) goto L12;
        return false;
    L12:
        if (this.f247934b == r101.f247934b) goto L15;
        return false;
    L15:
        if (this.f247935c == r101.f247935c) goto L18;
        return false;
    L18:
        if (this.f247936d == r101.f247936d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f247937e, r101.f247937e) == true) goto L24;
        return false;
    L24:
        if (this.f247938f == r101.f247938f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f247933a.hashCode() * 31) + this.f247934b) * 31;
        int r101 = 1231;
        if (this.f247935c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f247936d == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((r103 + r101) * 31) + this.f247937e.hashCode()) * 31;
        long r105 = this.f247938f;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreloadJsConfig(url=" + this.f247933a + ", priority=" + this.f247934b + ", serial=" + this.f247935c + ", enableMemory=" + this.f247936d + ", memoryPriority=" + this.f247937e + ", expire=" + this.f247938f + ')';
    }

    public y0(String r100, int r101, boolean r102, boolean r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r104, "memoryPriority");
        this.f247933a = r100;
        this.f247934b = r101;
        this.f247935c = r102;
        this.f247936d = r103;
        this.f247937e = r104;
        this.f247938f = r105;
    }
}
