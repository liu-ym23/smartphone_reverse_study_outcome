package com.larus.dora.obric.device_management.device_home;

/* JADX INFO: loaded from: classes27.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339359d;

    public s1() {
        boolean r100 = false;
        this(r100, r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s1) == true) goto L8;
        return false;
    L8:
        s1 r101 = (s1) r100;
        if (this.f339356a == r101.f339356a) goto L12;
        return false;
    L12:
        if (this.f339357b == r101.f339357b) goto L15;
        return false;
    L15:
        if (this.f339358c == r101.f339358c) goto L18;
        return false;
    L18:
        if (this.f339359d == r101.f339359d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f339356a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f339357b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f339358c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f339359d == true) goto L19;
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
        return "DoraObricDeviceHomeUsageEvidence(hasBoundGlasses=" + this.f339356a + ", hasBoundEarbuds=" + this.f339357b + ", hasBoundGlassesHistory=" + this.f339358c + ", hasDiaryData=" + this.f339359d + ')';
    }

    public /* synthetic */ s1(boolean r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102, false);
    }

    public static s1 a(s1 r100, boolean r101, boolean r102, int r103) {
        boolean r104 = false;
        if ((r103 & 1) == 0) goto L5;
        boolean r105 = r100.f339356a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r104 = r100.f339357b;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = r100.f339358c;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = r100.f339359d;
    L15:
        r100.getClass();
        return new s1(r105, r104, r101, r102);
    L5:
        r105 = false;
        goto L7
    }

    public s1(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f339356a = r100;
        this.f339357b = r101;
        this.f339358c = r102;
        this.f339359d = r103;
    }
}
