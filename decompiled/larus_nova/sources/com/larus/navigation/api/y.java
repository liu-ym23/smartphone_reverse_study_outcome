package com.larus.navigation.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f359719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f359720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f359721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f359722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f359723e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Double.compare(this.f359719a, r101.f359719a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f359720b, r101.f359720b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359721c, r101.f359721c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359722d, r101.f359722d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f359723e, r101.f359723e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f359719a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f359720b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f359721c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f359722d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f359723e;
        if (r111 == null) goto L15;
        r105 = r111.hashCode();
    L15:
        return r110 + r105;
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationWayPoint(latitude=" + this.f359719a + ", longitude=" + this.f359720b + ", poiId=" + this.f359721c + ", poiType=" + this.f359722d + ", poiName=" + this.f359723e + ')';
    }

    public y(double r100, double r101, String r102, String r103, String r104) {
        this.f359719a = r100;
        this.f359720b = r101;
        this.f359721c = r102;
        this.f359722d = r103;
        this.f359723e = r104;
        boolean r105 = true;
        if ((-90.0d) <= r100) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L20;
        if ((-180.0d) <= r101) goto L12;
    L14:
        r105 = false;
    L15:
        if (r105 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException(("longitude must be in range [-180.0, 180.0], was " + r101).toString());
    L12:
        if (r101 > 180.0d) goto L14;
    L20:
        throw new IllegalArgumentException(("latitude must be in range [-90.0, 90.0], was " + r100).toString());
    L5:
        if (r100 > 90.0d) goto L7;
        r106 = true;
        goto L8
    }
}
