package com.larus.dora.obric.device_management.device_home;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraObricGlassesMode f339232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraObricEnvironmentMemory f339233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f339234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f339235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f339236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<DoraObricGlassesBusinessState> f339237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y1 f339238k;

    public g3() {
        this(false, false, false, false, null, null, null, false, false, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g3) == true) goto L8;
        return false;
    L8:
        g3 r101 = (g3) r100;
        if (this.f339228a == r101.f339228a) goto L12;
        return false;
    L12:
        if (this.f339229b == r101.f339229b) goto L15;
        return false;
    L15:
        if (this.f339230c == r101.f339230c) goto L18;
        return false;
    L18:
        if (this.f339231d == r101.f339231d) goto L21;
        return false;
    L21:
        if (this.f339232e == r101.f339232e) goto L24;
        return false;
    L24:
        if (this.f339233f == r101.f339233f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f339234g, r101.f339234g) == true) goto L30;
        return false;
    L30:
        if (this.f339235h == r101.f339235h) goto L33;
        return false;
    L33:
        if (this.f339236i == r101.f339236i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f339237j, r101.f339237j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f339238k, r101.f339238k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f339228a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f339229b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f339230c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f339231d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((((r106 + r107) * 31) + this.f339232e.hashCode()) * 31) + this.f339233f.hashCode()) * 31;
        Boolean r109 = this.f339234g;
        if (r109 != null) goto L21;
        int r110 = 0;
    L22:
        int r111 = (r108 + r110) * 31;
        if (this.f339235h == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.f339236i == true) goto L31;
        r100 = 1237;
    L31:
        return ((((r113 + r100) * 31) + this.f339237j.hashCode()) * 31) + this.f339238k.hashCode();
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = r109.hashCode();
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
        return "DoraObricGlassesModeSource(isGlasses=" + this.f339228a + ", isConnected=" + this.f339229b + ", modeSupported=" + this.f339230c + ", switchSupported=" + this.f339231d + ", confirmedMode=" + this.f339232e + ", environmentMemory=" + this.f339233f + ", environmentMemorySwitchEnabled=" + this.f339234g + ", environmentMemoryReady=" + this.f339235h + ", environmentMemoryDeviceAvailable=" + this.f339236i + ", activeScenes=" + this.f339237j + ", deviceLight=" + this.f339238k + ')';
    }

    public g3(boolean r100, boolean r101, boolean r102, boolean r103, DoraObricGlassesMode r104, DoraObricEnvironmentMemory r105, Boolean r110, boolean r111, boolean r112, Set r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = DoraObricGlassesMode.UNKNOWN;
    L18:
        if ((r114 & 32) == 0) goto L20;
        r105 = DoraObricEnvironmentMemory.UNKNOWN;
    L20:
        y1.a r106 = null;
        if ((r114 & 64) == 0) goto L24;
        r110 = null;
    L24:
        if ((r114 & 128) == 0) goto L27;
        r111 = true;
    L27:
        if ((r114 & 256) == 0) goto L30;
        r112 = true;
    L30:
        if ((r114 & 512) == 0) goto L33;
        r113 = SetsKt.emptySet();
    L33:
        if ((r114 & 1024) == 0) goto L35;
        r106 = y1.a.f339389a;
    L35:
        Intrinsics.checkNotNullParameter(r104, "confirmedMode");
        Intrinsics.checkNotNullParameter(r105, "environmentMemory");
        Intrinsics.checkNotNullParameter(r113, "activeScenes");
        Intrinsics.checkNotNullParameter(r106, "deviceLight");
        this.f339228a = r100;
        this.f339229b = r101;
        this.f339230c = r102;
        this.f339231d = r103;
        this.f339232e = r104;
        this.f339233f = r105;
        this.f339234g = r110;
        this.f339235h = r111;
        this.f339236i = r112;
        this.f339237j = r113;
        this.f339238k = r106;
    }
}
