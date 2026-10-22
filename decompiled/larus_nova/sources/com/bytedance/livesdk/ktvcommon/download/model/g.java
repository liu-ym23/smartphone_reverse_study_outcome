package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f255984b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f255983a, r101.f255983a) == true) goto L8;
        return false;
    L8:
        if (this.f255984b == r101.f255984b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f255983a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f255984b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "FileInfo(path=" + this.f255983a + ", lastModified=" + this.f255984b + ")";
    }

    public g(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f255983a = r100;
        this.f255984b = r101;
    }
}
