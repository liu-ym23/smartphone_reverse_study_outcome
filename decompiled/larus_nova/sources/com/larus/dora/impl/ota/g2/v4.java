package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 {
    private final BlockReason blockReason;
    private final boolean debug;
    private final FailureReason failure;
    private final OtaMode mode;
    private final String observedVersion;
    private final long operationId;
    private final String ownerId;
    private final OtaMode pendingType;
    private final InstallPhase phase;
    private final int progress;
    private final int stage;
    private final int typeDeclareRetries;
    private final long typeDeclareRetryAt;
    private final boolean uploadStarted;
    private final long watchdogAt;

    public v4() {
        this(null, null, 0, null, null, false, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v4) == true) goto L8;
        return false;
    L8:
        v4 r101 = (v4) r100;
        if (this.phase == r101.phase) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.operationId == r101.operationId) goto L18;
        return false;
    L18:
        if (this.mode == r101.mode) goto L21;
        return false;
    L21:
        if (this.stage == r101.stage) goto L24;
        return false;
    L24:
        if (this.progress == r101.progress) goto L27;
        return false;
    L27:
        if (this.uploadStarted == r101.uploadStarted) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.observedVersion, r101.observedVersion) == true) goto L33;
        return false;
    L33:
        if (this.pendingType == r101.pendingType) goto L36;
        return false;
    L36:
        if (this.typeDeclareRetryAt == r101.typeDeclareRetryAt) goto L39;
        return false;
    L39:
        if (this.typeDeclareRetries == r101.typeDeclareRetries) goto L42;
        return false;
    L42:
        if (this.watchdogAt == r101.watchdogAt) goto L45;
        return false;
    L45:
        if (this.blockReason == r101.blockReason) goto L48;
        return false;
    L48:
        if (this.failure == r101.failure) goto L51;
        return false;
    L51:
        if (this.debug == r101.debug) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.phase.hashCode() * 31) + this.ownerId.hashCode()) * 31;
        long r101 = this.operationId;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.mode.hashCode()) * 31) + this.stage) * 31) + this.progress) * 31;
        int r103 = 1231;
        if (this.uploadStarted == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        String r106 = this.observedVersion;
        int r107 = 0;
        if (r106 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r105 + r108) * 31;
        OtaMode r110 = this.pendingType;
        if (r110 == null) goto L14;
        r107 = r110.hashCode();
    L14:
        int r111 = (r109 + r107) * 31;
        long r112 = this.typeDeclareRetryAt;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.typeDeclareRetries) * 31;
        long r114 = this.watchdogAt;
        int r115 = (((((r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.blockReason.hashCode()) * 31) + this.failure.hashCode()) * 31;
        if (this.debug == true) goto L19;
        r103 = 1237;
    L19:
        return r115 + r103;
    L9:
        r108 = r106.hashCode();
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "InstallState(phase=" + this.phase + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", mode=" + this.mode + ", stage=" + this.stage + ", progress=" + this.progress + ", uploadStarted=" + this.uploadStarted + ", observedVersion=" + this.observedVersion + ", pendingType=" + this.pendingType + ", typeDeclareRetryAt=" + this.typeDeclareRetryAt + ", typeDeclareRetries=" + this.typeDeclareRetries + ", watchdogAt=" + this.watchdogAt + ", blockReason=" + this.blockReason + ", failure=" + this.failure + ", debug=" + this.debug + ')';
    }

    public final BlockReason b() {
        return this.blockReason;
    }

    public final boolean c() {
        return this.debug;
    }

    public final FailureReason d() {
        return this.failure;
    }

    public final OtaMode e() {
        return this.mode;
    }

    public final String f() {
        return this.observedVersion;
    }

    public final long g() {
        return this.operationId;
    }

    public final String h() {
        return this.ownerId;
    }

    public final OtaMode i() {
        return this.pendingType;
    }

    public final InstallPhase j() {
        return this.phase;
    }

    public final int k() {
        return this.progress;
    }

    public final int l() {
        return this.stage;
    }

    public final int m() {
        return this.typeDeclareRetries;
    }

    public final long n() {
        return this.typeDeclareRetryAt;
    }

    public final boolean o() {
        return this.uploadStarted;
    }

    public final long p() {
        return this.watchdogAt;
    }

    public /* synthetic */ v4(InstallPhase r210, String r211, long r212, OtaMode r213, BlockReason r214, boolean r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        InstallPhase r100 = InstallPhase.IDLE;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r216 & 8) == 0) goto L17;
        OtaMode r103 = OtaMode.SILENT_G2;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r216 & 4096) == 0) goto L25;
        BlockReason r110 = BlockReason.NONE;
    L27:
        if ((r216 & 8192) == 0) goto L29;
        FailureReason r105 = FailureReason.NONE;
    L30:
        FailureReason r111 = r105;
        if ((r216 & 16384) == 0) goto L33;
        boolean r217 = false;
    L34:
        this(r100, r101, r102, r103, r104, 0, false, null, null, 0, 0, 0, r110, r111, r217);
        return;
    L33:
        r217 = r215;
        goto L34
    L29:
        r105 = null;
        goto L30
    L25:
        r110 = r214;
        goto L27
    L21:
        r104 = 0;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public v4(InstallPhase r100, String r101, long r110, OtaMode r111, int r112, int r113, boolean r114, String r115, OtaMode r116, long r117, int r210, long r211, BlockReason r212, FailureReason r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r212, "blockReason");
        Intrinsics.checkNotNullParameter(r213, "failure");
        this.phase = r100;
        this.ownerId = r101;
        this.operationId = r110;
        this.mode = r111;
        this.stage = r112;
        this.progress = r113;
        this.uploadStarted = r114;
        this.observedVersion = r115;
        this.pendingType = r116;
        this.typeDeclareRetryAt = r117;
        this.typeDeclareRetries = r210;
        this.watchdogAt = r211;
        this.blockReason = r212;
        this.failure = r213;
        this.debug = r214;
    }

    public static v4 a(v4 r110, InstallPhase r210, long r211, OtaMode r212, int r213, int r214, boolean r215, String r216, OtaMode r217, long r218, int r310, long r311, BlockReason r312, FailureReason r313, boolean r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        InstallPhase r100 = r110.phase;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.ownerId;
    L11:
        if ((r315 & 4) == 0) goto L13;
        long r102 = r110.operationId;
    L15:
        if ((r315 & 8) == 0) goto L17;
        OtaMode r103 = r110.mode;
    L19:
        if ((r315 & 16) == 0) goto L21;
        int r104 = r110.stage;
    L23:
        if ((r315 & 32) == 0) goto L25;
        int r105 = r110.progress;
    L27:
        if ((r315 & 64) == 0) goto L29;
        boolean r106 = r110.uploadStarted;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r111 = r110.observedVersion;
    L35:
        if ((r315 & 256) == 0) goto L37;
        OtaMode r112 = r110.pendingType;
    L39:
        if ((r315 & 512) == 0) goto L41;
        long r113 = r110.typeDeclareRetryAt;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        int r114 = r110.typeDeclareRetries;
    L46:
        int r115 = r114;
        if ((r315 & 2048) == 0) goto L49;
        long r116 = r110.watchdogAt;
    L50:
        long r117 = r116;
        if ((r315 & 4096) == 0) goto L53;
        BlockReason r118 = r110.blockReason;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        FailureReason r119 = r110.failure;
    L59:
        if ((r315 & 16384) == 0) goto L61;
        boolean r107 = r110.debug;
    L62:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        Intrinsics.checkNotNullParameter(r103, "mode");
        Intrinsics.checkNotNullParameter(r118, "blockReason");
        Intrinsics.checkNotNullParameter(r119, "failure");
        return new v4(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r115, r117, r118, r119, r107);
    L61:
        r107 = r314;
        goto L62
    L57:
        r119 = r313;
        goto L59
    L53:
        r118 = r312;
        goto L55
    L49:
        r116 = r311;
        goto L50
    L45:
        r114 = r310;
        goto L46
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r111 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
