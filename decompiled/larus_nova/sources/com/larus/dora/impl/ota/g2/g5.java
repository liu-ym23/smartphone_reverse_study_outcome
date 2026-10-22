package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g5 {
    private final ManualOnlyReason manualOnlyReason;
    private final OtaMode mode;
    private final boolean onlyWifi;
    private final long operationId;
    private final e5 pkg;
    private final boolean requestedForInstall;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g5) == true) goto L8;
        return false;
    L8:
        g5 r101 = (g5) r100;
        if (this.operationId == r101.operationId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L15;
        return false;
    L15:
        if (this.mode == r101.mode) goto L18;
        return false;
    L18:
        if (this.requestedForInstall == r101.requestedForInstall) goto L21;
        return false;
    L21:
        if (this.onlyWifi == r101.onlyWifi) goto L24;
        return false;
    L24:
        if (this.manualOnlyReason == r101.manualOnlyReason) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.operationId;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.pkg.hashCode()) * 31) + this.mode.hashCode()) * 31;
        int r102 = 1231;
        if (this.requestedForInstall == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.onlyWifi == true) goto L10;
        r102 = 1237;
    L10:
        int r105 = (r104 + r102) * 31;
        ManualOnlyReason r106 = this.manualOnlyReason;
        if (r106 != null) goto L13;
        int r107 = 0;
    L15:
        return r105 + r107;
    L13:
        r107 = r106.hashCode();
        goto L15
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingDownload(operationId=" + this.operationId + ", pkg=" + this.pkg + ", mode=" + this.mode + ", requestedForInstall=" + this.requestedForInstall + ", onlyWifi=" + this.onlyWifi + ", manualOnlyReason=" + this.manualOnlyReason + ')';
    }

    public final ManualOnlyReason b() {
        return this.manualOnlyReason;
    }

    public final OtaMode c() {
        return this.mode;
    }

    public final boolean d() {
        return this.onlyWifi;
    }

    public final long e() {
        return this.operationId;
    }

    public final e5 f() {
        return this.pkg;
    }

    public final boolean g() {
        return this.requestedForInstall;
    }

    public static g5 a(g5 r100, OtaMode r101) {
        long r102 = r100.operationId;
        e5 r103 = r100.pkg;
        boolean r104 = r100.requestedForInstall;
        boolean r105 = r100.onlyWifi;
        ManualOnlyReason r106 = r100.manualOnlyReason;
        Intrinsics.checkNotNullParameter(r103, "pkg");
        Intrinsics.checkNotNullParameter(r101, "mode");
        return new g5(r102, r103, r101, r104, r105, r106);
    }

    public g5(long r100, e5 r101, OtaMode r102, boolean r103, boolean r104, ManualOnlyReason r105) {
        Intrinsics.checkNotNullParameter(r101, "pkg");
        Intrinsics.checkNotNullParameter(r102, "mode");
        this.operationId = r100;
        this.pkg = r101;
        this.mode = r102;
        this.requestedForInstall = r103;
        this.onlyWifi = r104;
        this.manualOnlyReason = r105;
    }
}
