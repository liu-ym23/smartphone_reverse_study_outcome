package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private final int productId;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    private final String f337618sn;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f337618sn, r101.f337618sn) == true) goto L12;
        return false;
    L12:
        if (this.productId == r101.productId) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f337618sn.hashCode() * 31) + this.productId;
    }

    public final String toString() {
        return "DeviceKey(sn=" + this.f337618sn + ", productId=" + this.productId + ')';
    }

    public final int a() {
        return this.productId;
    }

    public final String b() {
        return this.f337618sn;
    }

    public e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        this.f337618sn = r100;
        this.productId = r101;
    }
}
