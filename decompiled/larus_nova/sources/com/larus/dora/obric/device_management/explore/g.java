package com.larus.dora.obric.device_management.explore;

import com.bytedance.dora.annotation.ProductNameType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f339515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductNameType f339516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z49.b f339517c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f339515a == r101.f339515a) goto L12;
        return false;
    L12:
        if (this.f339516b == r101.f339516b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f339517c, r101.f339517c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f339515a * 31;
        ProductNameType r101 = this.f339516b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f339517c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricExploreDeviceRequest(order=" + this.f339515a + ", productType=" + this.f339516b + ", device=" + this.f339517c + ')';
    }

    public g(int r100, ProductNameType r101, z49.b r102) {
        Intrinsics.checkNotNullParameter(r102, "device");
        this.f339515a = r100;
        this.f339516b = r101;
        this.f339517c = r102;
    }
}
