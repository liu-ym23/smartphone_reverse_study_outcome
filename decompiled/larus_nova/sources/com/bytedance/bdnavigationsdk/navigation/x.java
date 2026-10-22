package com.bytedance.bdnavigationsdk.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.network.route.p f200114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Exception f200115d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f200112a, r101.f200112a) == true) goto L12;
        return false;
    L12:
        if (this.f200113b == r101.f200113b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200114c, r101.f200114c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200115d, r101.f200115d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f200112a.hashCode() * 31) + this.f200113b) * 31;
        com.bytedance.bdnavigationsdk.network.route.p r101 = this.f200114c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Exception r105 = this.f200115d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RouteUpdateResult(routeUpdateId=" + this.f200112a + ", reason=" + this.f200113b + ", routeResponse=" + this.f200114c + ", exception=" + this.f200115d + ")";
    }

    public x(String r100, int r101, com.bytedance.bdnavigationsdk.network.route.p r102, Exception r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "routeUpdateId");
        this.f200112a = r100;
        this.f200113b = r101;
        this.f200114c = r102;
        this.f200115d = r103;
    }
}
