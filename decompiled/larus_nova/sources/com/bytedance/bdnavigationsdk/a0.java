package com.bytedance.bdnavigationsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f199989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f199990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f199991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f199992f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f199987a, r101.f199987a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f199988b, r101.f199988b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f199989c, r101.f199989c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f199990d, r101.f199990d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f199991e, r101.f199991e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f199992f, r101.f199992f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f199987a.hashCode() * 31) + this.f199988b.hashCode()) * 31) + this.f199989c.hashCode()) * 31) + this.f199990d.hashCode()) * 31) + this.f199991e.hashCode()) * 31;
        Integer r101 = this.f199992f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BDNASystemInfo(devicePlatform=" + this.f199987a + ", deviceBrand=" + this.f199988b + ", deviceModel=" + this.f199989c + ", appVersion=" + this.f199990d + ", osVersion=" + this.f199991e + ", osApi=" + this.f199992f + ")";
    }

    public a0(String r100, String r101, String r102, String r103, String r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "devicePlatform");
        Intrinsics.checkNotNullParameter(r101, "deviceBrand");
        Intrinsics.checkNotNullParameter(r102, "deviceModel");
        Intrinsics.checkNotNullParameter(r103, "appVersion");
        Intrinsics.checkNotNullParameter(r104, "osVersion");
        this.f199987a = r100;
        this.f199988b = r101;
        this.f199989c = r102;
        this.f199990d = r103;
        this.f199991e = r104;
        this.f199992f = r105;
    }
}
