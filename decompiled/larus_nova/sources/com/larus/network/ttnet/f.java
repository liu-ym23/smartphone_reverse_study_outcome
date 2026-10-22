package com.larus.network.ttnet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f360230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f360231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f360233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f360234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f360235g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f360229a, r101.f360229a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f360230b, r101.f360230b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360231c, r101.f360231c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f360232d, r101.f360232d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f360233e, r101.f360233e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f360234f, r101.f360234f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f360235g, r101.f360235g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f360229a.hashCode() * 31;
        Boolean r101 = this.f360230b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f360231c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f360232d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f360233e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f360234f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f360235g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetInfo(networkType=" + this.f360229a + ", isRoaming=" + this.f360230b + ", simCountry=" + this.f360231c + ", netCountry=" + this.f360232d + ", simOperatorName=" + this.f360233e + ", netOperatorName=" + this.f360234f + ", airplaneMode=" + this.f360235g + ')';
    }

    public f(String r100, Boolean r101, String r102, String r103, String r104, String r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r100, "networkType");
        this.f360229a = r100;
        this.f360230b = r101;
        this.f360231c = r102;
        this.f360232d = r103;
        this.f360233e = r104;
        this.f360234f = r105;
        this.f360235g = r106;
    }
}
