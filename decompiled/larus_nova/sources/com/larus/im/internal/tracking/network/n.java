package com.larus.im.internal.tracking.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f350429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f350430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f350431c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f350429a == r101.f350429a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350430b, r101.f350430b) == true) goto L15;
        return false;
    L15:
        if (this.f350431c == r101.f350431c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f350429a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f350430b.hashCode()) * 31) + this.f350431c;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "NetworkTrackCenterConfig(enabled=" + this.f350429a + ", sampling=" + this.f350430b + ", maxActiveContextCount=" + this.f350431c + ')';
    }

    public n(boolean r100, z r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "sampling");
        this.f350429a = r100;
        this.f350430b = r101;
        this.f350431c = r102;
    }
}
