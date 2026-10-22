package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricDeviceHomeDeviceCardType f339330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f339332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f339333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f339334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f339335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f339336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f339337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DoraResourceDeviceType f339338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f339339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f339340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f339341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f339342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f339343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f339344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f339345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f339346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f339347r;

    public r() {
        String r100 = null;
        this(r100, r100, r100, 262143);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f339330a == r101.f339330a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339331b, r101.f339331b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f339332c, r101.f339332c) == true) goto L18;
        return false;
    L18:
        if (this.f339333d == r101.f339333d) goto L21;
        return false;
    L21:
        if (this.f339334e == r101.f339334e) goto L24;
        return false;
    L24:
        if (this.f339335f == r101.f339335f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f339336g, r101.f339336g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f339337h, r101.f339337h) == true) goto L33;
        return false;
    L33:
        if (this.f339338i == r101.f339338i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f339339j, r101.f339339j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f339340k, r101.f339340k) == true) goto L42;
        return false;
    L42:
        if (this.f339341l == r101.f339341l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f339342m, r101.f339342m) == true) goto L48;
        return false;
    L48:
        if (this.f339343n == r101.f339343n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f339344o, r101.f339344o) == true) goto L54;
        return false;
    L54:
        if (this.f339345p == r101.f339345p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f339346q, r101.f339346q) == true) goto L60;
        return false;
    L60:
        if (this.f339347r == r101.f339347r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f339330a.hashCode() * 31) + this.f339331b.hashCode()) * 31) + this.f339332c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f339333d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f339334e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f339335f) * 31;
        String r106 = this.f339336g;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f339337h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DoraResourceDeviceType r113 = this.f339338i;
        if (r113 == null) goto L22;
        r107 = r113.hashCode();
    L22:
        int r114 = (((((r112 + r107) * 31) + this.f339339j.hashCode()) * 31) + this.f339340k.hashCode()) * 31;
        if (this.f339341l == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (((r114 + r115) * 31) + this.f339342m.hashCode()) * 31;
        if (this.f339343n == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (((r116 + r117) * 31) + this.f339344o.hashCode()) * 31;
        if (this.f339345p == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (((r118 + r119) * 31) + this.f339346q.hashCode()) * 31;
        if (this.f339347r == true) goto L39;
        r101 = 1237;
    L39:
        return r120 + r101;
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeDeviceCardUiState(type=" + this.f339330a + ", deviceName=" + this.f339331b + ", connectedText=" + this.f339332c + ", isConnected=" + this.f339333d + ", isConnecting=" + this.f339334e + ", imageResId=" + this.f339335f + ", imageResourceName=" + this.f339336g + ", imageFallbackResourceName=" + this.f339337h + ", imageResourceDeviceType=" + this.f339338i + ", modeText=" + this.f339339j + ", glassesBatteryText=" + this.f339340k + ", isGlassesCharging=" + this.f339341l + ", leftBatteryText=" + this.f339342m + ", isLeftCharging=" + this.f339343n + ", rightBatteryText=" + this.f339344o + ", isRightCharging=" + this.f339345p + ", boxBatteryText=" + this.f339346q + ", isBoxCharging=" + this.f339347r + ')';
    }

    public final DoraObricDeviceHomeDeviceCardType getType() {
        return this.f339330a;
    }

    public /* synthetic */ r(String r210, String r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        DoraObricDeviceHomeDeviceCardType r100 = DoraObricDeviceHomeDeviceCardType.GLASSES;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r213 & 512) == 0) goto L17;
        String r110 = "";
    L19:
        if ((r213 & 1024) == 0) goto L21;
        String r111 = "";
    L23:
        if ((r213 & 4096) == 0) goto L25;
        String r112 = "";
    L27:
        if ((r213 & 16384) == 0) goto L29;
        String r113 = "";
    L31:
        if ((r213 & 65536) == 0) goto L33;
        String r214 = "";
    L34:
        this(r100, r101, r102, false, false, 0, null, null, null, r110, r111, false, r112, false, r113, false, r214, false);
        return;
    L33:
        r214 = null;
        goto L34
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = null;
        goto L27
    L21:
        r111 = r212;
        goto L23
    L17:
        r110 = null;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public r(DoraObricDeviceHomeDeviceCardType r110, String r111, String r112, boolean r113, boolean r114, int r115, String r116, String r117, DoraResourceDeviceType r118, String r210, String r211, boolean r212, String r213, boolean r214, String r215, boolean r216, String r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "deviceName");
        Intrinsics.checkNotNullParameter(r112, "connectedText");
        Intrinsics.checkNotNullParameter(r210, "modeText");
        Intrinsics.checkNotNullParameter(r211, "glassesBatteryText");
        Intrinsics.checkNotNullParameter(r213, "leftBatteryText");
        Intrinsics.checkNotNullParameter(r215, "rightBatteryText");
        Intrinsics.checkNotNullParameter(r217, "boxBatteryText");
        this.f339330a = r110;
        this.f339331b = r111;
        this.f339332c = r112;
        this.f339333d = r113;
        this.f339334e = r114;
        this.f339335f = r115;
        this.f339336g = r116;
        this.f339337h = r117;
        this.f339338i = r118;
        this.f339339j = r210;
        this.f339340k = r211;
        this.f339341l = r212;
        this.f339342m = r213;
        this.f339343n = r214;
        this.f339344o = r215;
        this.f339345p = r216;
        this.f339346q = r217;
        this.f339347r = r218;
    }
}
