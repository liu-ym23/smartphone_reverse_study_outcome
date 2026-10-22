package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f522305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f522307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f522310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f522311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f522312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f522313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f522314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f522315k;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f522305a == r101.f522305a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522306b, r101.f522306b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522307c, r101.f522307c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522308d, r101.f522308d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522309e, r101.f522309e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f522310f, r101.f522310f) == true) goto L27;
        return false;
    L27:
        if (this.f522311g == r101.f522311g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f522312h, r101.f522312h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f522313i, r101.f522313i) == true) goto L36;
        return false;
    L36:
        if (this.f522314j == r101.f522314j) goto L39;
        return false;
    L39:
        if (this.f522315k == r101.f522315k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f522305a * 31;
        String r101 = this.f522306b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f522307c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f522308d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f522309e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f522310f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        int r117 = 1231;
        if (this.f522311g == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f522312h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f522313i;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        int r124 = (r122 + r102) * 31;
        if (this.f522314j == false) goto L37;
        int r125 = 1231;
    L38:
        int r126 = (r124 + r125) * 31;
        if (this.f522315k == true) goto L43;
        r117 = 1237;
    L43:
        return r126 + r117;
    L37:
        r125 = 1237;
        goto L38
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = 1237;
        goto L26
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
        return "AppInfo(appId=" + this.f522305a + ", appName=" + this.f522306b + ", versionCode=" + this.f522307c + ", versionName=" + this.f522308d + ", channel=" + this.f522309e + ", language=" + this.f522310f + ", isTeenMode=" + this.f522311g + ", appTheme=" + this.f522312h + ", updateVersionCode=" + this.f522313i + ", isVsFullScreen=" + this.f522314j + ", isDouyinLightMode=" + this.f522315k + ')';
    }

    public a(int r100) {
        this.f522305a = 0;
        this.f522306b = null;
        this.f522307c = null;
        this.f522308d = null;
        this.f522309e = null;
        this.f522310f = null;
        this.f522311g = false;
        this.f522312h = null;
        this.f522313i = null;
        this.f522314j = false;
        this.f522315k = false;
    }
}
