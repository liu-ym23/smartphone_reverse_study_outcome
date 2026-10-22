package com.larus.dora.impl.ota.g2;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private final BlockReason blockReason;
    private final long downloadedBytes;
    private final FailureReason failure;
    private final long lastSpaceBytes;
    private final int lastSpacePercent;
    private final OtaMode mode;
    private final boolean onlyWifi;
    private final long operationId;
    private final DownloadPhase phase;
    private final d5 pkg;
    private final g5 replacement;
    private final boolean requestedForInstall;

    public l() {
        this(null, 0, null, null, false, false, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.phase == r101.phase) goto L12;
        return false;
    L12:
        if (this.operationId == r101.operationId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L18;
        return false;
    L18:
        if (this.mode == r101.mode) goto L21;
        return false;
    L21:
        if (this.downloadedBytes == r101.downloadedBytes) goto L24;
        return false;
    L24:
        if (this.lastSpaceBytes == r101.lastSpaceBytes) goto L27;
        return false;
    L27:
        if (this.lastSpacePercent == r101.lastSpacePercent) goto L30;
        return false;
    L30:
        if (this.requestedForInstall == r101.requestedForInstall) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.replacement, r101.replacement) == true) goto L36;
        return false;
    L36:
        if (this.onlyWifi == r101.onlyWifi) goto L39;
        return false;
    L39:
        if (this.blockReason == r101.blockReason) goto L42;
        return false;
    L42:
        if (this.failure == r101.failure) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.phase.hashCode() * 31;
        long r101 = this.operationId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        d5 r103 = this.pkg;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((r102 + r105) * 31) + this.mode.hashCode()) * 31;
        long r107 = this.downloadedBytes;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.lastSpaceBytes;
        int r110 = (((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.lastSpacePercent) * 31;
        int r111 = 1231;
        if (this.requestedForInstall == false) goto L9;
        int r112 = 1231;
    L10:
        int r113 = (r110 + r112) * 31;
        g5 r114 = this.replacement;
        if (r114 == null) goto L14;
        r104 = r114.hashCode();
    L14:
        int r115 = (r113 + r104) * 31;
        if (this.onlyWifi == true) goto L19;
        r111 = 1237;
    L19:
        return ((((r115 + r111) * 31) + this.blockReason.hashCode()) * 31) + this.failure.hashCode();
    L9:
        r112 = 1237;
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "DownloadState(phase=" + this.phase + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ", mode=" + this.mode + ", downloadedBytes=" + this.downloadedBytes + ", lastSpaceBytes=" + this.lastSpaceBytes + ", lastSpacePercent=" + this.lastSpacePercent + ", requestedForInstall=" + this.requestedForInstall + ", replacement=" + this.replacement + ", onlyWifi=" + this.onlyWifi + ", blockReason=" + this.blockReason + ", failure=" + this.failure + ')';
    }

    public final int n() {
        d5 r100 = this.pkg;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.e() > 0) goto L8;
        return 0;
    L8:
        return RangesKt.coerceIn((int) ((this.downloadedBytes * ((long) 100)) / this.pkg.e()), 0, 100);
    }

    public final BlockReason b() {
        return this.blockReason;
    }

    public final long c() {
        return this.downloadedBytes;
    }

    public final FailureReason d() {
        return this.failure;
    }

    public final long e() {
        return this.lastSpaceBytes;
    }

    public final int f() {
        return this.lastSpacePercent;
    }

    public final OtaMode g() {
        return this.mode;
    }

    public final boolean h() {
        return this.onlyWifi;
    }

    public final long i() {
        return this.operationId;
    }

    public final DownloadPhase j() {
        return this.phase;
    }

    public final d5 k() {
        return this.pkg;
    }

    public final g5 l() {
        return this.replacement;
    }

    public final boolean m() {
        return this.requestedForInstall;
    }

    public /* synthetic */ l(DownloadPhase r110, long r210, d5 r211, OtaMode r212, boolean r213, boolean r214, BlockReason r215, FailureReason r216, int r217) {
        if ((r217 & 1) == 0) goto L5;
        DownloadPhase r100 = DownloadPhase.IDLE;
    L7:
        if ((r217 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r217 & 4) == 0) goto L13;
        d5 r102 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        OtaMode r103 = OtaMode.SILENT_G2;
    L19:
        if ((r217 & 128) == 0) goto L21;
        boolean r111 = false;
    L23:
        if ((r217 & 512) == 0) goto L25;
        boolean r112 = true;
    L27:
        if ((r217 & 1024) == 0) goto L29;
        BlockReason r113 = BlockReason.NONE;
    L31:
        if ((r217 & 2048) == 0) goto L33;
        FailureReason r114 = FailureReason.NONE;
    L34:
        this(r100, r101, r102, r103, 0, 0, 0, r111, null, r112, r113, r114);
        return;
    L33:
        r114 = r216;
        goto L34
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r111 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public l(DownloadPhase r100, long r101, d5 r110, OtaMode r111, long r112, long r113, int r114, boolean r115, g5 r116, boolean r210, BlockReason r211, FailureReason r212) {
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r211, "blockReason");
        Intrinsics.checkNotNullParameter(r212, "failure");
        this.phase = r100;
        this.operationId = r101;
        this.pkg = r110;
        this.mode = r111;
        this.downloadedBytes = r112;
        this.lastSpaceBytes = r113;
        this.lastSpacePercent = r114;
        this.requestedForInstall = r115;
        this.replacement = r116;
        this.onlyWifi = r210;
        this.blockReason = r211;
        this.failure = r212;
    }

    public static l a(l r110, DownloadPhase r111, long r112, OtaMode r210, long r211, long r212, int r213, boolean r214, g5 r215, boolean r216, BlockReason r217, FailureReason r310, int r311) {
        if ((r311 & 1) == 0) goto L5;
        DownloadPhase r100 = r110.phase;
    L7:
        if ((r311 & 2) == 0) goto L9;
        long r101 = r110.operationId;
    L11:
        if ((r311 & 4) == 0) goto L13;
        d5 r102 = r110.pkg;
    L15:
        if ((r311 & 8) == 0) goto L17;
        OtaMode r103 = r110.mode;
    L19:
        if ((r311 & 16) == 0) goto L21;
        long r104 = r110.downloadedBytes;
    L23:
        if ((r311 & 32) == 0) goto L25;
        long r105 = r110.lastSpaceBytes;
    L27:
        if ((r311 & 64) == 0) goto L29;
        int r113 = r110.lastSpacePercent;
    L31:
        if ((r311 & 128) == 0) goto L33;
        boolean r114 = r110.requestedForInstall;
    L35:
        if ((r311 & 256) == 0) goto L37;
        g5 r115 = r110.replacement;
    L39:
        if ((r311 & 512) == 0) goto L41;
        boolean r116 = r110.onlyWifi;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        BlockReason r117 = r110.blockReason;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        FailureReason r106 = r110.failure;
    L50:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "phase");
        Intrinsics.checkNotNullParameter(r103, "mode");
        Intrinsics.checkNotNullParameter(r117, "blockReason");
        Intrinsics.checkNotNullParameter(r106, "failure");
        return new l(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r106);
    L49:
        r106 = r310;
        goto L50
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
