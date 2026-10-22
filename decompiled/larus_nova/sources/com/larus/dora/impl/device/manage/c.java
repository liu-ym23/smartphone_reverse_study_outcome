package com.larus.dora.impl.device.manage;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DeviceMode f333708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f333709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f333710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f333711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f333712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f333713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f333714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f333715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f333716l;

    public c() {
        this(null, null, null, false, false, false, false, false, 0, 0, false, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f333705a, r101.f333705a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333706b, r101.f333706b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333707c, r101.f333707c) == true) goto L18;
        return false;
    L18:
        if (this.f333708d == r101.f333708d) goto L21;
        return false;
    L21:
        if (this.f333709e == r101.f333709e) goto L24;
        return false;
    L24:
        if (this.f333710f == r101.f333710f) goto L27;
        return false;
    L27:
        if (this.f333711g == r101.f333711g) goto L30;
        return false;
    L30:
        if (this.f333712h == r101.f333712h) goto L33;
        return false;
    L33:
        if (this.f333713i == r101.f333713i) goto L36;
        return false;
    L36:
        if (this.f333714j == r101.f333714j) goto L39;
        return false;
    L39:
        if (this.f333715k == r101.f333715k) goto L42;
        return false;
    L42:
        if (this.f333716l == r101.f333716l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f333705a.hashCode() * 31) + this.f333706b.hashCode()) * 31) + this.f333707c.hashCode()) * 31) + this.f333708d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f333709e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f333710f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f333711g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f333712h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f333713i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (((((r109 + r110) * 31) + this.f333714j) * 31) + this.f333715k) * 31;
        if (this.f333716l == true) goto L27;
        r101 = 1237;
    L27:
        return r111 + r101;
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
        return "DoraGDeviceManagementDeviceItem(id=" + this.f333705a + ", deviceName=" + this.f333706b + ", deviceMac=" + this.f333707c + ", deviceMode=" + this.f333708d + ", isBound=" + this.f333709e + ", isConnected=" + this.f333710f + ", isCharging=" + this.f333711g + ", isGlassCharging=" + this.f333712h + ", isBoxCharging=" + this.f333713i + ", glassBattery=" + this.f333714j + ", boxBattery=" + this.f333715k + ", isConnecting=" + this.f333716l + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333705a;
    }

    public c(String r100, String r101, DeviceMode r102, boolean r103, boolean r104, boolean r105, boolean r110, boolean r111, int r112, int r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r106 = "DoraGDeviceManagementDeviceItem";
    L7:
        if ((r115 & 2) == 0) goto L10;
        r100 = "我的眼镜";
    L10:
        if ((r115 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r115 & 8) == 0) goto L16;
        r102 = DeviceMode.NORMAL;
    L16:
        if ((r115 & 16) == 0) goto L19;
        r103 = true;
    L19:
        if ((r115 & 32) == 0) goto L22;
        r104 = true;
    L22:
        if ((r115 & 64) == 0) goto L25;
        r105 = false;
    L25:
        if ((r115 & 128) == 0) goto L28;
        r110 = false;
    L28:
        if ((r115 & 256) == 0) goto L31;
        r111 = false;
    L31:
        if ((r115 & 512) == 0) goto L34;
        r112 = 50;
    L34:
        if ((r115 & 1024) == 0) goto L37;
        r113 = -1;
    L37:
        if ((r115 & 2048) == 0) goto L39;
        r114 = false;
    L39:
        Intrinsics.checkNotNullParameter(r106, "id");
        Intrinsics.checkNotNullParameter(r100, "deviceName");
        Intrinsics.checkNotNullParameter(r101, "deviceMac");
        Intrinsics.checkNotNullParameter(r102, "deviceMode");
        this.f333705a = r106;
        this.f333706b = r100;
        this.f333707c = r101;
        this.f333708d = r102;
        this.f333709e = r103;
        this.f333710f = r104;
        this.f333711g = r105;
        this.f333712h = r110;
        this.f333713i = r111;
        this.f333714j = r112;
        this.f333715k = r113;
        this.f333716l = r114;
        return;
    L5:
        r106 = null;
        goto L7
    }
}
