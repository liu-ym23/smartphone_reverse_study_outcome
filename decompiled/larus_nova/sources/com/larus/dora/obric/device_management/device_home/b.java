package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f339178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f339179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f339180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f339181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f339182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DoraObricEnvironmentMemoryLabel f339183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoraObricEnvironmentMemoryIcon f339184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DoraObricEnvironmentMemoryTextStyle f339185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f339186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DoraObricDeviceBusinessStatus f339187n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f339174a == r101.f339174a) goto L12;
        return false;
    L12:
        if (this.f339175b == r101.f339175b) goto L15;
        return false;
    L15:
        if (this.f339176c == r101.f339176c) goto L18;
        return false;
    L18:
        if (this.f339177d == r101.f339177d) goto L21;
        return false;
    L21:
        if (this.f339178e == r101.f339178e) goto L24;
        return false;
    L24:
        if (this.f339179f == r101.f339179f) goto L27;
        return false;
    L27:
        if (this.f339180g == r101.f339180g) goto L30;
        return false;
    L30:
        if (this.f339181h == r101.f339181h) goto L33;
        return false;
    L33:
        if (this.f339182i == r101.f339182i) goto L36;
        return false;
    L36:
        if (this.f339183j == r101.f339183j) goto L39;
        return false;
    L39:
        if (this.f339184k == r101.f339184k) goto L42;
        return false;
    L42:
        if (this.f339185l == r101.f339185l) goto L45;
        return false;
    L45:
        if (this.f339186m == r101.f339186m) goto L48;
        return false;
    L48:
        if (this.f339187n == r101.f339187n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f339174a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f339175b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f339176c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f339177d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f339178e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f339179f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f339180g == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f339181h == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.f339182i == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (((((((r116 + r117) * 31) + this.f339183j.hashCode()) * 31) + this.f339184k.hashCode()) * 31) + this.f339185l.hashCode()) * 31;
        if (this.f339186m == true) goto L42;
        r100 = 1237;
    L42:
        int r119 = (r118 + r100) * 31;
        DoraObricDeviceBusinessStatus r120 = this.f339187n;
        if (r120 != null) goto L45;
        int r121 = 0;
    L47:
        return r119 + r121;
    L45:
        r121 = r120.hashCode();
        goto L47
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
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
        return "DoraObricDeviceCardAdapterPresentation(useGlassesModeControls=" + this.f339174a + ", showModeEntry=" + this.f339175b + ", showLegacyModeTag=" + this.f339176c + ", showTopSettingsButton=" + this.f339177d + ", showLegacySettingsButton=" + this.f339178e + ", showEnvironmentMemoryStatus=" + this.f339179f + ", isEnvironmentMemoryControlEnabled=" + this.f339180g + ", isEnvironmentMemoryContentEnabled=" + this.f339181h + ", isEnvironmentMemoryActive=" + this.f339182i + ", environmentMemoryLabel=" + this.f339183j + ", environmentMemoryIcon=" + this.f339184k + ", environmentMemoryTextStyle=" + this.f339185l + ", tintEnvironmentMemoryIconWithTextColor=" + this.f339186m + ", businessStatus=" + this.f339187n + ')';
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, DoraObricEnvironmentMemoryLabel r111, DoraObricEnvironmentMemoryIcon r112, DoraObricEnvironmentMemoryTextStyle r113, DoraObricDeviceBusinessStatus r114) {
        Intrinsics.checkNotNullParameter(r111, "environmentMemoryLabel");
        Intrinsics.checkNotNullParameter(r112, "environmentMemoryIcon");
        Intrinsics.checkNotNullParameter(r113, "environmentMemoryTextStyle");
        this.f339174a = r100;
        this.f339175b = r101;
        this.f339176c = r102;
        this.f339177d = r103;
        this.f339178e = r104;
        this.f339179f = r105;
        this.f339180g = r106;
        this.f339181h = r107;
        this.f339182i = r110;
        this.f339183j = r111;
        this.f339184k = r112;
        this.f339185l = r113;
        this.f339186m = true;
        this.f339187n = r114;
    }
}
