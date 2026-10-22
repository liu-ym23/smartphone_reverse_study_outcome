package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f536002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f536003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f536004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f536005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f536006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f536007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f536008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f536009h;

    public n() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f536002a, r101.f536002a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536003b, r101.f536003b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536004c, r101.f536004c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536005d, r101.f536005d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f536006e, r101.f536006e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f536007f, r101.f536007f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f536008g, r101.f536008g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f536009h, r101.f536009h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Double r100 = this.f536002a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f536003b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f536004c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f536005d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.f536006e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.f536007f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.f536008g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f536009h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocationUpdateResult(latitude=" + this.f536002a + ", longitude=" + this.f536003b + ", speed=" + this.f536004c + ", accuracy=" + this.f536005d + ", altitude=" + this.f536006e + ", verticalAccuracy=" + this.f536007f + ", horizontalAccuracy=" + this.f536008g + ", city=" + this.f536009h + ')';
    }

    public n(Double r100, Double r101, Float r102, Float r103, Double r104, Float r105, Float r106, String r107) {
        this.f536002a = r100;
        this.f536003b = r101;
        this.f536004c = r102;
        this.f536005d = r103;
        this.f536006e = r104;
        this.f536007f = r105;
        this.f536008g = r106;
        this.f536009h = r107;
    }
}
