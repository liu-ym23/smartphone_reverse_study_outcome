package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f522318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f522319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f522320e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f522316a, r101.f522316a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522317b, r101.f522317b) == true) goto L15;
        return false;
    L15:
        if (this.f522318c == r101.f522318c) goto L18;
        return false;
    L18:
        if (this.f522319d == r101.f522319d) goto L21;
        return false;
    L21:
        if (this.f522320e == r101.f522320e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522316a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522317b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f522318c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f522319d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f522320e == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeviceInfo(carrier=" + this.f522316a + ", deviceId=" + this.f522317b + ", isPad=" + this.f522318c + ", isFoldScreen=" + this.f522319d + ", isDigHoleScreen=" + this.f522320e + ')';
    }

    public b(int r100) {
        this.f522316a = null;
        this.f522317b = null;
        this.f522318c = false;
        this.f522319d = false;
        this.f522320e = false;
    }
}
