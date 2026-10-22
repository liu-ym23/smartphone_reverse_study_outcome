package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f486546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f486547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486550e;

    public b5() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r101 = (b5) r100;
        if (Intrinsics.areEqual(this.f486546a, r101.f486546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486547b, r101.f486547b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486548c, r101.f486548c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486549d, r101.f486549d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486550e, r101.f486550e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f486546a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f486547b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486548c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f486549d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f486550e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "VideoStreamingConfig(enable=" + this.f486546a + ", showEntrance=" + this.f486547b + ", transport=" + this.f486548c + ", controlMode=" + this.f486549d + ", activeLink=" + this.f486550e + ')';
    }

    public b5(Boolean r100, Boolean r101, String r102, String r103, String r104) {
        this.f486546a = r100;
        this.f486547b = r101;
        this.f486548c = r102;
        this.f486549d = r103;
        this.f486550e = r104;
    }
}
