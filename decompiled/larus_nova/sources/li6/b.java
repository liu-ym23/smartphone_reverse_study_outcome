package li6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f509374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f509375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f509376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f509377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f509378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f509379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f509380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f509381h;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f509374a, r101.f509374a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509375b, r101.f509375b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509376c, r101.f509376c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509377d, r101.f509377d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f509378e, r101.f509378e) == true) goto L16;
        return false;
    L16:
        if (this.f509379f == r101.f509379f) goto L18;
        return false;
    L18:
        if (this.f509380g == r101.f509380g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f509381h, r101.f509381h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509374a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509375b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f509376c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f509377d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f509378e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((((r112 + r114) * 31) + this.f509379f) * 31) + this.f509380g) * 31;
        String r116 = this.f509381h;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRTCEngineConfig(rtcAppId=" + this.f509374a + ", rtcChannelId=" + this.f509375b + ", rtcAppSign=" + this.f509376c + ", rtcToken=" + this.f509377d + ", rtcUserId=" + this.f509378e + ", rtcUserIdMode=" + this.f509379f + ", rtcVendor=" + this.f509380g + ", userId=" + this.f509381h + ")";
    }

    public b(int r100) {
        this.f509374a = null;
        this.f509375b = null;
        this.f509376c = null;
        this.f509377d = null;
        this.f509378e = null;
        this.f509379f = 0;
        this.f509380g = 0;
        this.f509381h = null;
    }
}
