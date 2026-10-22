package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricDeviceModeEntryLabel f339396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f339400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraObricDeviceModeIndicator f339401f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (this.f339396a == r101.f339396a) goto L12;
        return false;
    L12:
        if (this.f339397b == r101.f339397b) goto L15;
        return false;
    L15:
        if (this.f339398c == r101.f339398c) goto L18;
        return false;
    L18:
        if (this.f339399d == r101.f339399d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f339400e, r101.f339400e) == 0) goto L24;
        return false;
    L24:
        if (this.f339401f == r101.f339401f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f339396a.hashCode() * 31;
        int r101 = 1231;
        if (this.f339397b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f339398c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f339399d == true) goto L15;
        r101 = 1237;
    L15:
        return ((((r105 + r101) * 31) + Float.floatToIntBits(this.f339400e)) * 31) + this.f339401f.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceModeEntryPresentation(label=" + this.f339396a + ", isEnabled=" + this.f339397b + ", isInteractive=" + this.f339398c + ", showChevron=" + this.f339399d + ", contentAlpha=" + this.f339400e + ", indicator=" + this.f339401f + ')';
    }

    public z1(DoraObricDeviceModeEntryLabel r100, boolean r101, boolean r102, boolean r103, float r104, DoraObricDeviceModeIndicator r105) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r105, "indicator");
        this.f339396a = r100;
        this.f339397b = r101;
        this.f339398c = r102;
        this.f339399d = r103;
        this.f339400e = r104;
        this.f339401f = r105;
    }
}
