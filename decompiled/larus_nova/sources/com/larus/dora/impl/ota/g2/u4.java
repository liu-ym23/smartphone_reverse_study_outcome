package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u4 {
    private final boolean debug;
    private final e device;
    private final InstallOwnerKind kind;
    private final OtaMode mode;
    private final String requestId;
    private final long requestedAt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u4) == true) goto L8;
        return false;
    L8:
        u4 r101 = (u4) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (this.requestedAt == r101.requestedAt) goto L18;
        return false;
    L18:
        if (this.kind == r101.kind) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L24;
        return false;
    L24:
        if (this.debug == r101.debug) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.device.hashCode() * 31) + this.mode.hashCode()) * 31;
        long r101 = this.requestedAt;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.kind.hashCode()) * 31) + this.requestId.hashCode()) * 31;
        if (this.debug == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "InstallRequest(device=" + this.device + ", mode=" + this.mode + ", requestedAt=" + this.requestedAt + ", kind=" + this.kind + ", requestId=" + this.requestId + ", debug=" + this.debug + ')';
    }

    public final boolean a() {
        return this.debug;
    }

    public final e b() {
        return this.device;
    }

    public final InstallOwnerKind c() {
        return this.kind;
    }

    public final OtaMode d() {
        return this.mode;
    }

    public final String e() {
        return this.requestId;
    }

    public u4(e r100, OtaMode r101, long r102, InstallOwnerKind r103, String r104, boolean r105, int r106) {
        if ((r106 & 8) == 0) goto L9;
        if (r101 != OtaMode.MANUAL) goto L7;
        r103 = InstallOwnerKind.G2_MANUAL;
        goto L9
    L7:
        r103 = InstallOwnerKind.G2_SILENT;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = "";
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r103, "kind");
        Intrinsics.checkNotNullParameter(r104, "requestId");
        this.device = r100;
        this.mode = r101;
        this.requestedAt = r102;
        this.kind = r103;
        this.requestId = r104;
        this.debug = r105;
    }
}
