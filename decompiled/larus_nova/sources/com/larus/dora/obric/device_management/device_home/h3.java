package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraObricGlassesMode f339249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f339250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f339251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f339252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DoraObricEnvironmentMemory f339253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DoraObricEnvironmentMemoryState f339254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f339255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f339256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DoraObricGlassesBusinessState f339257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final y1 f339258m;

    public h3() {
        this(false, false, false, null, false, false, false, null, null, null, false, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r101 = (h3) r100;
        if (this.f339246a == r101.f339246a) goto L12;
        return false;
    L12:
        if (this.f339247b == r101.f339247b) goto L15;
        return false;
    L15:
        if (this.f339248c == r101.f339248c) goto L18;
        return false;
    L18:
        if (this.f339249d == r101.f339249d) goto L21;
        return false;
    L21:
        if (this.f339250e == r101.f339250e) goto L24;
        return false;
    L24:
        if (this.f339251f == r101.f339251f) goto L27;
        return false;
    L27:
        if (this.f339252g == r101.f339252g) goto L30;
        return false;
    L30:
        if (this.f339253h == r101.f339253h) goto L33;
        return false;
    L33:
        if (this.f339254i == r101.f339254i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f339255j, r101.f339255j) == true) goto L39;
        return false;
    L39:
        if (this.f339256k == r101.f339256k) goto L42;
        return false;
    L42:
        if (this.f339257l == r101.f339257l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f339258m, r101.f339258m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f339246a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f339247b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f339248c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f339249d.hashCode()) * 31;
        if (this.f339250e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f339251f == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f339252g == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((((r110 + r111) * 31) + this.f339253h.hashCode()) * 31) + this.f339254i.hashCode()) * 31;
        Boolean r113 = this.f339255j;
        if (r113 != null) goto L29;
        int r114 = 0;
    L30:
        int r115 = (r112 + r114) * 31;
        if (this.f339256k == true) goto L35;
        r100 = 1237;
    L35:
        return ((((r115 + r100) * 31) + this.f339257l.hashCode()) * 31) + this.f339258m.hashCode();
    L29:
        r114 = r113.hashCode();
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
        return "DoraObricGlassesModeUiState(isVisible=" + this.f339246a + ", hideLegacyModeTag=" + this.f339247b + ", isDisconnected=" + this.f339248c + ", confirmedMode=" + this.f339249d + ", isModeControlSupported=" + this.f339250e + ", isModeControlEnabled=" + this.f339251f + ", showEnvironmentMemory=" + this.f339252g + ", environmentMemory=" + this.f339253h + ", environmentMemoryState=" + this.f339254i + ", environmentMemorySwitchEnabled=" + this.f339255j + ", environmentMemoryReady=" + this.f339256k + ", businessState=" + this.f339257l + ", deviceLight=" + this.f339258m + ')';
    }

    public h3(boolean r110, boolean r111, boolean r112, DoraObricGlassesMode r113, boolean r210, boolean r211, boolean r212, DoraObricEnvironmentMemory r213, DoraObricEnvironmentMemoryState r214, Boolean r215, boolean r216, DoraObricGlassesBusinessState r217, y1 r218, int r219) {
        boolean r100 = false;
        if ((r219 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r219 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r219 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r219 & 8) == 0) goto L17;
        DoraObricGlassesMode r104 = DoraObricGlassesMode.UNKNOWN;
    L19:
        if ((r219 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r219 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r219 & 64) != 0) goto L31;
        r100 = r212;
    L31:
        if ((r219 & 128) == 0) goto L33;
        DoraObricEnvironmentMemory r107 = DoraObricEnvironmentMemory.UNKNOWN;
    L35:
        if ((r219 & 256) == 0) goto L37;
        DoraObricEnvironmentMemoryState r114 = DoraObricEnvironmentMemoryState.UNKNOWN;
    L39:
        if ((r219 & 512) == 0) goto L41;
        Boolean r115 = null;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        boolean r116 = true;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        DoraObricGlassesBusinessState r117 = DoraObricGlassesBusinessState.IDLE;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        y1 r108 = y1.a.f339389a;
    L54:
        Intrinsics.checkNotNullParameter(r104, "confirmedMode");
        Intrinsics.checkNotNullParameter(r107, "environmentMemory");
        Intrinsics.checkNotNullParameter(r114, "environmentMemoryState");
        Intrinsics.checkNotNullParameter(r117, "businessState");
        Intrinsics.checkNotNullParameter(r108, "deviceLight");
        this.f339246a = r101;
        this.f339247b = r102;
        this.f339248c = r103;
        this.f339249d = r104;
        this.f339250e = r105;
        this.f339251f = r106;
        this.f339252g = r100;
        this.f339253h = r107;
        this.f339254i = r114;
        this.f339255j = r115;
        this.f339256k = r116;
        this.f339257l = r117;
        this.f339258m = r108;
        return;
    L53:
        r108 = r218;
        goto L54
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
