package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t4 {
    private final boolean armed;
    private final e device;
    private final InstallOwnerKind kind;
    private final String ownerId;
    private final OwnerPhase phase;
    private final d5 pkg;
    private final long reconnectDeadline;
    private final boolean restoredAwaitingReconnect;
    private final String sourceVersion;
    private final long startedAt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r101 = (t4) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.kind == r101.kind) goto L18;
        return false;
    L18:
        if (this.phase == r101.phase) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L24;
        return false;
    L24:
        if (this.armed == r101.armed) goto L27;
        return false;
    L27:
        if (this.startedAt == r101.startedAt) goto L30;
        return false;
    L30:
        if (this.reconnectDeadline == r101.reconnectDeadline) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceVersion, r101.sourceVersion) == true) goto L36;
        return false;
    L36:
        if (this.restoredAwaitingReconnect == r101.restoredAwaitingReconnect) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.device.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.kind.hashCode()) * 31) + this.phase.hashCode()) * 31;
        d5 r101 = this.pkg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.armed == false) goto L9;
        int r106 = 1231;
    L10:
        long r107 = this.startedAt;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.reconnectDeadline;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.sourceVersion;
        if (r111 == null) goto L14;
        r102 = r111.hashCode();
    L14:
        int r112 = (r110 + r102) * 31;
        if (this.restoredAwaitingReconnect == true) goto L19;
        r105 = 1237;
    L19:
        return r112 + r105;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstallOwner(device=" + this.device + ", ownerId=" + this.ownerId + ", kind=" + this.kind + ", phase=" + this.phase + ", pkg=" + this.pkg + ", armed=" + this.armed + ", startedAt=" + this.startedAt + ", reconnectDeadline=" + this.reconnectDeadline + ", sourceVersion=" + this.sourceVersion + ", restoredAwaitingReconnect=" + this.restoredAwaitingReconnect + ')';
    }

    public final boolean b() {
        return this.armed;
    }

    public final e c() {
        return this.device;
    }

    public final InstallOwnerKind d() {
        return this.kind;
    }

    public final String e() {
        return this.ownerId;
    }

    public final OwnerPhase f() {
        return this.phase;
    }

    public final d5 g() {
        return this.pkg;
    }

    public final long h() {
        return this.reconnectDeadline;
    }

    public final boolean i() {
        return this.restoredAwaitingReconnect;
    }

    public final String j() {
        return this.sourceVersion;
    }

    public static t4 a(t4 r110, OwnerPhase r111, boolean r112, long r210, boolean r211, int r212) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        e r101 = r110.device;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = r110.ownerId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        InstallOwnerKind r103 = r110.kind;
    L15:
        if ((r212 & 8) == 0) goto L17;
        OwnerPhase r104 = r110.phase;
    L19:
        if ((r212 & 16) == 0) goto L21;
        d5 r105 = r110.pkg;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r113 = r110.armed;
    L27:
        if ((r212 & 64) == 0) goto L29;
        long r114 = r110.startedAt;
    L31:
        if ((r212 & 128) == 0) goto L33;
        long r115 = r110.reconnectDeadline;
    L35:
        if ((r212 & 256) == 0) goto L37;
        r100 = r110.sourceVersion;
    L37:
        String r116 = r100;
        if ((r212 & 512) == 0) goto L40;
        boolean r117 = r110.restoredAwaitingReconnect;
    L41:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "device");
        Intrinsics.checkNotNullParameter(r102, "ownerId");
        Intrinsics.checkNotNullParameter(r103, "kind");
        Intrinsics.checkNotNullParameter(r104, "phase");
        return new t4(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117);
    L40:
        r117 = r211;
        goto L41
    L33:
        r115 = r210;
        goto L35
    L29:
        r114 = 0;
        goto L31
    L25:
        r113 = r112;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r111;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ t4(e r110, String r111, InstallOwnerKind r112, OwnerPhase r113, d5 r114, long r115, String r210, int r211) {
        if ((r211 & 256) == 0) goto L5;
        String r116 = null;
    L6:
        this(r110, r111, r112, r113, r114, false, r115, 0, r116, false);
        return;
    L5:
        r116 = r210;
        goto L6
    }

    public t4(e r100, String r101, InstallOwnerKind r102, OwnerPhase r103, d5 r104, boolean r105, long r106, long r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        Intrinsics.checkNotNullParameter(r102, "kind");
        Intrinsics.checkNotNullParameter(r103, "phase");
        this.device = r100;
        this.ownerId = r101;
        this.kind = r102;
        this.phase = r103;
        this.pkg = r104;
        this.armed = r105;
        this.startedAt = r106;
        this.reconnectDeadline = r110;
        this.sourceVersion = r111;
        this.restoredAwaitingReconnect = r112;
    }
}
