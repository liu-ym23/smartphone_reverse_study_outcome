package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {
    public static final a Companion = null;
    private final boolean captivePortal;
    private final boolean cellular;
    private final boolean ethernet;
    private final boolean internet;
    private final String networkId;
    private final boolean validated;
    private final boolean vpn;
    private final boolean wifi;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.networkId, r101.networkId) == true) goto L12;
        return false;
    L12:
        if (this.wifi == r101.wifi) goto L15;
        return false;
    L15:
        if (this.cellular == r101.cellular) goto L18;
        return false;
    L18:
        if (this.ethernet == r101.ethernet) goto L21;
        return false;
    L21:
        if (this.vpn == r101.vpn) goto L24;
        return false;
    L24:
        if (this.internet == r101.internet) goto L27;
        return false;
    L27:
        if (this.validated == r101.validated) goto L30;
        return false;
    L30:
        if (this.captivePortal == r101.captivePortal) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.networkId.hashCode() * 31;
        int r101 = 1231;
        if (this.wifi == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.cellular == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.ethernet == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.vpn == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.internet == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.validated == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.captivePortal == true) goto L31;
        r101 = 1237;
    L31:
        return r113 + r101;
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "G2OtaNetworkSignature(networkId=" + this.networkId + ", wifi=" + this.wifi + ", cellular=" + this.cellular + ", ethernet=" + this.ethernet + ", vpn=" + this.vpn + ", internet=" + this.internet + ", validated=" + this.validated + ", captivePortal=" + this.captivePortal + ')';
    }

    public final boolean a() {
        return this.internet;
    }

    public final String b() {
        return this.networkId;
    }

    public final boolean c() {
        return this.validated;
    }

    public final boolean d() {
        return this.wifi;
    }

    public l0(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "networkId");
        this.networkId = r100;
        this.wifi = r101;
        this.cellular = r102;
        this.ethernet = r103;
        this.vpn = r104;
        this.internet = r105;
        this.validated = r106;
        this.captivePortal = r107;
    }
}
