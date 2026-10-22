package com.larus.dora.impl.ota.g2;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.heytap.mcssdk.constant.MessageConstant;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b5 {
    private final Map<e, f> devices;
    private final k downloadOwner;
    private final z4 externalLegacyInstall;
    private final boolean featureEnabled;
    private final long installCooldownMs;
    private final t4 installOwner;
    private final List<u4> installQueue;
    private final List<y4> legacyDownloadQueue;
    private final long nextOperationId;
    private final h5 pendingTerminal;
    private final List<e> predownloadQueue;
    private final long recoveryBlockedUntil;
    private final t5 wifiLease;
    private final u5 window;

    public b5() {
        this(0, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r101 = (b5) r100;
        if (this.featureEnabled == r101.featureEnabled) goto L12;
        return false;
    L12:
        if (this.installCooldownMs == r101.installCooldownMs) goto L15;
        return false;
    L15:
        if (this.recoveryBlockedUntil == r101.recoveryBlockedUntil) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.window, r101.window) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.downloadOwner, r101.downloadOwner) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.predownloadQueue, r101.predownloadQueue) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.legacyDownloadQueue, r101.legacyDownloadQueue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.installOwner, r101.installOwner) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.wifiLease, r101.wifiLease) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.externalLegacyInstall, r101.externalLegacyInstall) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.installQueue, r101.installQueue) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pendingTerminal, r101.pendingTerminal) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.devices, r101.devices) == true) goto L48;
        return false;
    L48:
        if (this.nextOperationId == r101.nextOperationId) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        if (this.featureEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.installCooldownMs;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.recoveryBlockedUntil;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.window.hashCode()) * 31;
        k r105 = this.downloadOwner;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (((((r104 + r107) * 31) + this.predownloadQueue.hashCode()) * 31) + this.legacyDownloadQueue.hashCode()) * 31;
        t4 r109 = this.installOwner;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        t5 r112 = this.wifiLease;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        z4 r115 = this.externalLegacyInstall;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (((r114 + r116) * 31) + this.installQueue.hashCode()) * 31;
        h5 r118 = this.pendingTerminal;
        if (r118 == null) goto L26;
        r106 = r118.hashCode();
    L26:
        int r119 = (((r117 + r106) * 31) + this.devices.hashCode()) * 31;
        long r120 = this.nextOperationId;
        return r119 + ((int) (r120 ^ (r120 >>> 32)));
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OtaEngineState(featureEnabled=" + this.featureEnabled + ", installCooldownMs=" + this.installCooldownMs + ", recoveryBlockedUntil=" + this.recoveryBlockedUntil + ", window=" + this.window + ", downloadOwner=" + this.downloadOwner + ", predownloadQueue=" + this.predownloadQueue + ", legacyDownloadQueue=" + this.legacyDownloadQueue + ", installOwner=" + this.installOwner + ", wifiLease=" + this.wifiLease + ", externalLegacyInstall=" + this.externalLegacyInstall + ", installQueue=" + this.installQueue + ", pendingTerminal=" + this.pendingTerminal + ", devices=" + this.devices + ", nextOperationId=" + this.nextOperationId + ')';
    }

    public final Pair<Long, b5> q() {
        return TuplesKt.to(Long.valueOf(this.nextOperationId), a(this, false, 0, 0, null, null, null, null, null, null, null, null, null, null, this.nextOperationId + 1, 8191));
    }

    public final Map<e, f> c() {
        return this.devices;
    }

    public final k d() {
        return this.downloadOwner;
    }

    public final z4 e() {
        return this.externalLegacyInstall;
    }

    public final boolean f() {
        return this.featureEnabled;
    }

    public final long g() {
        return this.installCooldownMs;
    }

    public final t4 h() {
        return this.installOwner;
    }

    public final List<u4> i() {
        return this.installQueue;
    }

    public final List<y4> j() {
        return this.legacyDownloadQueue;
    }

    public final long k() {
        return this.nextOperationId;
    }

    public final h5 l() {
        return this.pendingTerminal;
    }

    public final List<e> m() {
        return this.predownloadQueue;
    }

    public final long n() {
        return this.recoveryBlockedUntil;
    }

    public final t5 o() {
        return this.wifiLease;
    }

    public final u5 p() {
        return this.window;
    }

    public final f b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f r101 = this.devices.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new f(r100, null, null, null, null, 262142);
    }

    public /* synthetic */ b5(long r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        boolean r100 = true;
    L6:
        long r101 = 0;
        if ((r211 & 2) == 0) goto L9;
        long r102 = 1800000;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        u5 r104 = new u5(null, 0, 0, false, null, 2047);
    L19:
        if ((r211 & 32) == 0) goto L21;
        List r110 = CollectionsKt.emptyList();
    L23:
        if ((r211 & 64) == 0) goto L25;
        List r111 = CollectionsKt.emptyList();
    L27:
        if ((r211 & 1024) == 0) goto L29;
        List r112 = CollectionsKt.emptyList();
    L31:
        if ((r211 & 4096) == 0) goto L33;
        Map r113 = MapsKt.emptyMap();
    L35:
        if ((r211 & 8192) == 0) goto L37;
        r101 = 1;
    L37:
        this(r100, r102, r103, r104, null, r110, r111, null, null, null, r112, null, r113, r101);
        return;
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final b5 r(e r210, Function1<? super f, f> r211) {
        Intrinsics.checkNotNullParameter(r210, "key");
        Intrinsics.checkNotNullParameter(r211, "update");
        return a(this, false, 0, 0, null, null, null, null, null, null, null, null, null, MapsKt.plus(this.devices, TuplesKt.to(r210, r211.invoke(b(r210)))), 0, MessageConstant.CommandId.COMMAND_ERROR);
    }

    public b5(boolean r100, long r110, long r111, u5 r112, k r113, List<e> r114, List<y4> r115, t4 r116, t5 r117, z4 r210, List<u4> r211, h5 r212, Map<e, f> r213, long r214) {
        Intrinsics.checkNotNullParameter(r112, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r114, "predownloadQueue");
        Intrinsics.checkNotNullParameter(r115, "legacyDownloadQueue");
        Intrinsics.checkNotNullParameter(r211, "installQueue");
        Intrinsics.checkNotNullParameter(r213, "devices");
        this.featureEnabled = r100;
        this.installCooldownMs = r110;
        this.recoveryBlockedUntil = r111;
        this.window = r112;
        this.downloadOwner = r113;
        this.predownloadQueue = r114;
        this.legacyDownloadQueue = r115;
        this.installOwner = r116;
        this.wifiLease = r117;
        this.externalLegacyInstall = r210;
        this.installQueue = r211;
        this.pendingTerminal = r212;
        this.devices = r213;
        this.nextOperationId = r214;
    }

    public static b5 a(b5 r110, boolean r111, long r112, long r210, u5 r211, k r212, List r213, List r214, t4 r215, t5 r216, z4 r217, List r218, h5 r310, Map r311, long r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        boolean r100 = r110.featureEnabled;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.installCooldownMs;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.recoveryBlockedUntil;
    L15:
        if ((r313 & 8) == 0) goto L17;
        u5 r103 = r110.window;
    L19:
        if ((r313 & 16) == 0) goto L21;
        k r104 = r110.downloadOwner;
    L23:
        if ((r313 & 32) == 0) goto L25;
        List r105 = r110.predownloadQueue;
    L27:
        if ((r313 & 64) == 0) goto L29;
        List r113 = r110.legacyDownloadQueue;
    L31:
        if ((r313 & 128) == 0) goto L33;
        t4 r114 = r110.installOwner;
    L35:
        if ((r313 & 256) == 0) goto L37;
        t5 r115 = r110.wifiLease;
    L39:
        if ((r313 & 512) == 0) goto L41;
        z4 r116 = r110.externalLegacyInstall;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        List r117 = r110.installQueue;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        h5 r118 = r110.pendingTerminal;
    L50:
        h5 r314 = r118;
        if ((r313 & 4096) == 0) goto L53;
        Map r119 = r110.devices;
    L54:
        t5 r219 = r115;
        z4 r220 = r116;
        if ((r313 & 8192) == 0) goto L57;
        long r120 = r110.nextOperationId;
    L58:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r105, "predownloadQueue");
        Intrinsics.checkNotNullParameter(r113, "legacyDownloadQueue");
        Intrinsics.checkNotNullParameter(r117, "installQueue");
        Intrinsics.checkNotNullParameter(r119, "devices");
        return new b5(r100, r101, r102, r103, r104, r105, r113, r114, r219, r220, r117, r314, r119, r120);
    L57:
        r120 = r312;
        goto L58
    L53:
        r119 = r311;
        goto L54
    L49:
        r118 = r310;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
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
