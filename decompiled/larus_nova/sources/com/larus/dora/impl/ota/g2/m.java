package com.larus.dora.impl.ota.g2;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    private final boolean connected;
    private final long freeBytes;
    private final int glassesBattery;
    private final boolean glassesCharging;
    private final boolean glassesWearing;
    private final boolean gpsOk;
    private final boolean hotspotOff;
    private final boolean inCompanion;
    private final boolean inQuery;
    private final boolean internetAvailable;
    private final boolean locationPermission;
    private final boolean locationRequired;
    private final boolean nearbyPermission;
    private final int phoneBattery;
    private final boolean phoneOnWifi;
    private final boolean vpnOk;
    private final boolean wifiEnabled;

    public m() {
        this(0);
    }

    public static m a(boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, int r215, boolean r216, boolean r217, int r218, boolean r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, long r316) {
        return new m(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.connected == r101.connected) goto L12;
        return false;
    L12:
        if (this.inCompanion == r101.inCompanion) goto L15;
        return false;
    L15:
        if (this.inQuery == r101.inQuery) goto L18;
        return false;
    L18:
        if (this.phoneOnWifi == r101.phoneOnWifi) goto L21;
        return false;
    L21:
        if (this.internetAvailable == r101.internetAvailable) goto L24;
        return false;
    L24:
        if (this.phoneBattery == r101.phoneBattery) goto L27;
        return false;
    L27:
        if (this.glassesWearing == r101.glassesWearing) goto L30;
        return false;
    L30:
        if (this.glassesCharging == r101.glassesCharging) goto L33;
        return false;
    L33:
        if (this.glassesBattery == r101.glassesBattery) goto L36;
        return false;
    L36:
        if (this.nearbyPermission == r101.nearbyPermission) goto L39;
        return false;
    L39:
        if (this.locationPermission == r101.locationPermission) goto L42;
        return false;
    L42:
        if (this.locationRequired == r101.locationRequired) goto L45;
        return false;
    L45:
        if (this.wifiEnabled == r101.wifiEnabled) goto L48;
        return false;
    L48:
        if (this.hotspotOff == r101.hotspotOff) goto L51;
        return false;
    L51:
        if (this.vpnOk == r101.vpnOk) goto L54;
        return false;
    L54:
        if (this.gpsOk == r101.gpsOk) goto L57;
        return false;
    L57:
        if (this.freeBytes == r101.freeBytes) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.connected == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.inCompanion == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.inQuery == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.phoneOnWifi == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.internetAvailable == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (((r108 + r109) * 31) + this.phoneBattery) * 31;
        if (this.glassesWearing == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.glassesCharging == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (((r112 + r113) * 31) + this.glassesBattery) * 31;
        if (this.nearbyPermission == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.locationPermission == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.locationRequired == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.wifiEnabled == false) goto L45;
        int r121 = 1231;
    L46:
        int r122 = (r120 + r121) * 31;
        if (this.hotspotOff == false) goto L49;
        int r123 = 1231;
    L50:
        int r124 = (r122 + r123) * 31;
        if (this.vpnOk == false) goto L53;
        int r125 = 1231;
    L54:
        int r126 = (r124 + r125) * 31;
        if (this.gpsOk == true) goto L58;
        r100 = 1237;
    L58:
        int r127 = (r126 + r100) * 31;
        long r128 = this.freeBytes;
        return r127 + ((int) (r128 ^ (r128 >>> 32)));
    L53:
        r125 = 1237;
        goto L54
    L49:
        r123 = 1237;
        goto L50
    L45:
        r121 = 1237;
        goto L46
    L41:
        r119 = 1237;
        goto L42
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
        return "EnvironmentSnapshot(connected=" + this.connected + ", inCompanion=" + this.inCompanion + ", inQuery=" + this.inQuery + ", phoneOnWifi=" + this.phoneOnWifi + ", internetAvailable=" + this.internetAvailable + ", phoneBattery=" + this.phoneBattery + ", glassesWearing=" + this.glassesWearing + ", glassesCharging=" + this.glassesCharging + ", glassesBattery=" + this.glassesBattery + ", nearbyPermission=" + this.nearbyPermission + ", locationPermission=" + this.locationPermission + ", locationRequired=" + this.locationRequired + ", wifiEnabled=" + this.wifiEnabled + ", hotspotOff=" + this.hotspotOff + ", vpnOk=" + this.vpnOk + ", gpsOk=" + this.gpsOk + ", freeBytes=" + this.freeBytes + ')';
    }

    public final boolean b() {
        return this.connected;
    }

    public final long c() {
        return this.freeBytes;
    }

    public final int d() {
        return this.glassesBattery;
    }

    public final boolean e() {
        return this.glassesCharging;
    }

    public final boolean f() {
        return this.glassesWearing;
    }

    public final boolean g() {
        return this.gpsOk;
    }

    public final boolean h() {
        return this.hotspotOff;
    }

    public final boolean i() {
        return this.inCompanion;
    }

    public final boolean j() {
        return this.inQuery;
    }

    public final boolean k() {
        return this.internetAvailable;
    }

    public final boolean l() {
        return this.locationPermission;
    }

    public final boolean m() {
        return this.locationRequired;
    }

    public final boolean n() {
        return this.nearbyPermission;
    }

    public final int o() {
        return this.phoneBattery;
    }

    public final boolean p() {
        return this.phoneOnWifi;
    }

    public final boolean q() {
        return this.vpnOk;
    }

    public final boolean r() {
        return this.wifiEnabled;
    }

    public /* synthetic */ m(int r210) {
        this(false, false, false, false, false, -1, true, false, -1, false, false, false, false, true, true, true, 0);
    }

    public m(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, boolean r110, boolean r111, int r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, long r210) {
        this.connected = r100;
        this.inCompanion = r101;
        this.inQuery = r102;
        this.phoneOnWifi = r103;
        this.internetAvailable = r104;
        this.phoneBattery = r105;
        this.glassesWearing = r110;
        this.glassesCharging = r111;
        this.glassesBattery = r112;
        this.nearbyPermission = r113;
        this.locationPermission = r114;
        this.locationRequired = r115;
        this.wifiEnabled = r116;
        this.hotspotOff = r117;
        this.vpnOk = r118;
        this.gpsOk = r119;
        this.freeBytes = r210;
    }
}
