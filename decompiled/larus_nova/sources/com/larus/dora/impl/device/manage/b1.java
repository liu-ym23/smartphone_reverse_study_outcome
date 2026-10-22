package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b1 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f333702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f333703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f333704f;

    public b1() {
        boolean r100 = false;
        this(r100, r100, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f333699a, r101.f333699a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333700b, r101.f333700b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333701c, r101.f333701c) == true) goto L18;
        return false;
    L18:
        if (this.f333702d == r101.f333702d) goto L21;
        return false;
    L21:
        if (this.f333703e == r101.f333703e) goto L24;
        return false;
    L24:
        if (this.f333704f == r101.f333704f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f333699a.hashCode() * 31) + this.f333700b.hashCode()) * 31) + this.f333701c.hashCode()) * 31) + this.f333702d) * 31;
        int r101 = 1231;
        if (this.f333703e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f333704f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SodaBannerItem(id=" + this.f333699a + ", title=" + this.f333700b + ", subTitle=" + this.f333701c + ", bannerType=" + this.f333702d + ", isVisible=" + this.f333703e + ", hasFirmwareUpdateItemAbove=" + this.f333704f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333699a;
    }

    public /* synthetic */ b1(boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r100 = "SodaBannerItem";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r103 = 1;
    L19:
        if ((r112 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r105 = false;
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r111;
        goto L26
    L21:
        r104 = r110;
        goto L23
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public b1(String r100, String r101, String r102, int r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subTitle");
        this.f333699a = r100;
        this.f333700b = r101;
        this.f333701c = r102;
        this.f333702d = r103;
        this.f333703e = r104;
        this.f333704f = r105;
    }
}
