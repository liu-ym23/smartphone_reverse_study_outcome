package com.larus.dora.obric.device_management.device_home;

/* JADX INFO: loaded from: classes27.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339370d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f339367a == r101.f339367a) goto L12;
        return false;
    L12:
        if (this.f339368b == r101.f339368b) goto L15;
        return false;
    L15:
        if (this.f339369c == r101.f339369c) goto L18;
        return false;
    L18:
        if (this.f339370d == r101.f339370d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f339367a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f339368b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f339369c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f339370d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeFeatureSet(showGFeatures=" + this.f339367a + ", showEarbudsFeatures=" + this.f339368b + ", showDiaryTab=" + this.f339369c + ", showHealthTab=" + this.f339370d + ')';
    }

    public u(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f339367a = r100;
        this.f339368b = r101;
        this.f339369c = r102;
        this.f339370d = r103;
    }
}
