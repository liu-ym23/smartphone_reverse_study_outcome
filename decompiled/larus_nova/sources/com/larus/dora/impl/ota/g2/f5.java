package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f5 {
    private final long effectId;
    private final long expiresAt;
    private final d5 manualOnlyIdentity;
    private final ManualOnlyReason manualOnlyReason;
    private final PackagePhase phase;
    private final FailureReason reason;
    private final e5 spec;
    private final long touchedAt;
    private final long validatedAt;

    public f5() {
        this(null, null, 0, 0, 0, 0, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f5) == true) goto L8;
        return false;
    L8:
        f5 r101 = (f5) r100;
        if (this.phase == r101.phase) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spec, r101.spec) == true) goto L15;
        return false;
    L15:
        if (this.touchedAt == r101.touchedAt) goto L18;
        return false;
    L18:
        if (this.validatedAt == r101.validatedAt) goto L21;
        return false;
    L21:
        if (this.expiresAt == r101.expiresAt) goto L24;
        return false;
    L24:
        if (this.effectId == r101.effectId) goto L27;
        return false;
    L27:
        if (this.reason == r101.reason) goto L30;
        return false;
    L30:
        if (this.manualOnlyReason == r101.manualOnlyReason) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.manualOnlyIdentity, r101.manualOnlyIdentity) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.phase.hashCode() * 31;
        e5 r101 = this.spec;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.touchedAt;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.validatedAt;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.expiresAt;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.effectId;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.reason.hashCode()) * 31;
        ManualOnlyReason r112 = this.manualOnlyReason;
        if (r112 != null) goto L9;
        int r113 = 0;
    L10:
        int r114 = (r111 + r113) * 31;
        d5 r115 = this.manualOnlyIdentity;
        if (r115 == null) goto L15;
        r102 = r115.hashCode();
    L15:
        return r114 + r102;
    L9:
        r113 = r112.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PackageState(phase=" + this.phase + ", spec=" + this.spec + ", touchedAt=" + this.touchedAt + ", validatedAt=" + this.validatedAt + ", expiresAt=" + this.expiresAt + ", effectId=" + this.effectId + ", reason=" + this.reason + ", manualOnlyReason=" + this.manualOnlyReason + ", manualOnlyIdentity=" + this.manualOnlyIdentity + ')';
    }

    public final long b() {
        return this.effectId;
    }

    public final long c() {
        return this.expiresAt;
    }

    public final d5 d() {
        return this.manualOnlyIdentity;
    }

    public final ManualOnlyReason e() {
        return this.manualOnlyReason;
    }

    public final PackagePhase f() {
        return this.phase;
    }

    public final FailureReason g() {
        return this.reason;
    }

    public final e5 h() {
        return this.spec;
    }

    public final long i() {
        return this.touchedAt;
    }

    public f5(PackagePhase r100, e5 r101, long r102, long r103, long r104, long r110, FailureReason r111, ManualOnlyReason r112, d5 r113) {
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r111, "reason");
        this.phase = r100;
        this.spec = r101;
        this.touchedAt = r102;
        this.validatedAt = r103;
        this.expiresAt = r104;
        this.effectId = r110;
        this.reason = r111;
        this.manualOnlyReason = r112;
        this.manualOnlyIdentity = r113;
    }

    public /* synthetic */ f5(PackagePhase r110, e5 r111, long r112, long r113, long r210, long r211, FailureReason r212, ManualOnlyReason r213, d5 r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        PackagePhase r100 = PackagePhase.NONE;
    L6:
        d5 r101 = null;
        if ((r215 & 2) == 0) goto L9;
        e5 r102 = null;
    L10:
        long r103 = 0;
        if ((r215 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r215 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r215 & 16) == 0) goto L21;
        long r114 = 0;
    L23:
        if ((r215 & 32) != 0) goto L27;
        r103 = r211;
    L27:
        if ((r215 & 64) == 0) goto L29;
        FailureReason r106 = FailureReason.NONE;
    L31:
        if ((r215 & 128) == 0) goto L33;
        ManualOnlyReason r115 = null;
    L35:
        if ((r215 & 256) != 0) goto L38;
        r101 = r214;
    L38:
        this(r100, r102, r104, r105, r114, r103, r106, r115, r101);
        return;
    L33:
        r115 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L21:
        r114 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }

    public static f5 a(f5 r110, PackagePhase r111, e5 r112, long r210, long r211, long r212, FailureReason r213, ManualOnlyReason r214, d5 r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        PackagePhase r100 = r110.phase;
    L7:
        if ((r216 & 2) == 0) goto L9;
        e5 r101 = r110.spec;
    L11:
        if ((r216 & 4) == 0) goto L13;
        long r102 = r110.touchedAt;
    L15:
        if ((r216 & 8) == 0) goto L17;
        long r103 = r110.validatedAt;
    L18:
        long r104 = r103;
        if ((r216 & 16) == 0) goto L21;
        long r113 = r110.expiresAt;
    L23:
        if ((r216 & 32) == 0) goto L25;
        long r114 = r110.effectId;
    L27:
        if ((r216 & 64) == 0) goto L29;
        FailureReason r115 = r110.reason;
    L31:
        if ((r216 & 128) == 0) goto L33;
        ManualOnlyReason r116 = r110.manualOnlyReason;
    L35:
        if ((r216 & 256) == 0) goto L37;
        d5 r117 = r110.manualOnlyIdentity;
    L38:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r115, "reason");
        return new f5(r100, r101, r102, r104, r113, r114, r115, r116, r117);
    L37:
        r117 = r215;
        goto L38
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r113 = r211;
        goto L23
    L17:
        r103 = 0;
        goto L18
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
