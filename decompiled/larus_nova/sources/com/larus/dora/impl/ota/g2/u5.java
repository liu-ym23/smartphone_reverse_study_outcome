package com.larus.dora.impl.ota.g2;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u5 {
    private final Map<e, Integer> attemptCount;
    private final Set<e> attempted;
    private final Set<e> availableUpdate;
    private final long end;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f337736id;
    private final Map<e, BlockReason> latestBlock;
    private final Map<e, FailureReason> latestFailure;
    private final Set<e> manualEntered;
    private final boolean open;
    private final long start;
    private final Set<e> succeeded;

    public u5() {
        this(null, 0, 0, false, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u5) == true) goto L8;
        return false;
    L8:
        u5 r101 = (u5) r100;
        if (Intrinsics.areEqual(this.f337736id, r101.f337736id) == true) goto L12;
        return false;
    L12:
        if (this.start == r101.start) goto L15;
        return false;
    L15:
        if (this.end == r101.end) goto L18;
        return false;
    L18:
        if (this.open == r101.open) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.manualEntered, r101.manualEntered) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.availableUpdate, r101.availableUpdate) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.attempted, r101.attempted) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.succeeded, r101.succeeded) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.latestBlock, r101.latestBlock) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.attemptCount, r101.attemptCount) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.latestFailure, r101.latestFailure) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f337736id.hashCode() * 31;
        long r101 = this.start;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.end;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.open == false) goto L5;
        int r105 = 1231;
    L7:
        return ((((((((((((((r104 + r105) * 31) + this.manualEntered.hashCode()) * 31) + this.availableUpdate.hashCode()) * 31) + this.attempted.hashCode()) * 31) + this.succeeded.hashCode()) * 31) + this.latestBlock.hashCode()) * 31) + this.attemptCount.hashCode()) * 31) + this.latestFailure.hashCode();
    L5:
        r105 = 1237;
        goto L7
    }

    public final String toString() {
        return "WindowState(id=" + this.f337736id + ", start=" + this.start + ", end=" + this.end + ", open=" + this.open + ", manualEntered=" + this.manualEntered + ", availableUpdate=" + this.availableUpdate + ", attempted=" + this.attempted + ", succeeded=" + this.succeeded + ", latestBlock=" + this.latestBlock + ", attemptCount=" + this.attemptCount + ", latestFailure=" + this.latestFailure + ')';
    }

    public final Map<e, Integer> b() {
        return this.attemptCount;
    }

    public final Set<e> c() {
        return this.attempted;
    }

    public final Set<e> d() {
        return this.availableUpdate;
    }

    public final String e() {
        return this.f337736id;
    }

    public final Map<e, BlockReason> f() {
        return this.latestBlock;
    }

    public final Map<e, FailureReason> g() {
        return this.latestFailure;
    }

    public final Set<e> h() {
        return this.manualEntered;
    }

    public final boolean i() {
        return this.open;
    }

    public final Set<e> j() {
        return this.succeeded;
    }

    public /* synthetic */ u5(String r110, long r111, long r210, boolean r211, Set r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r213 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r213 & 16) == 0) goto L21;
        Set r112 = SetsKt.emptySet();
    L23:
        if ((r213 & 32) == 0) goto L25;
        Set r113 = SetsKt.emptySet();
    L27:
        if ((r213 & 64) == 0) goto L29;
        Set r114 = SetsKt.emptySet();
    L31:
        if ((r213 & 128) == 0) goto L33;
        Set r115 = SetsKt.emptySet();
    L35:
        if ((r213 & 256) == 0) goto L37;
        Map r116 = MapsKt.emptyMap();
    L39:
        if ((r213 & 512) == 0) goto L41;
        Map r117 = MapsKt.emptyMap();
    L43:
        if ((r213 & 1024) == 0) goto L45;
        Map r104 = MapsKt.emptyMap();
    L46:
        this(r100, r101, r102, r103, r112, r113, r114, r115, r116, r117, r104);
        return;
    L45:
        r104 = null;
        goto L46
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r112 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static u5 a(u5 r110, Set r111, Set r112, Set r210, Set r211, Map r212, Map r213, Map r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = r110.f337736id;
    L6:
        String r101 = r100;
        if ((r215 & 2) == 0) goto L9;
        long r102 = r110.start;
    L11:
        if ((r215 & 4) == 0) goto L13;
        long r103 = r110.end;
    L15:
        if ((r215 & 8) == 0) goto L17;
        boolean r104 = r110.open;
    L19:
        if ((r215 & 16) == 0) goto L21;
        Set r113 = r110.manualEntered;
    L23:
        if ((r215 & 32) == 0) goto L25;
        Set r114 = r110.availableUpdate;
    L27:
        if ((r215 & 64) == 0) goto L29;
        Set r115 = r110.attempted;
    L31:
        if ((r215 & 128) == 0) goto L33;
        Set r116 = r110.succeeded;
    L35:
        if ((r215 & 256) == 0) goto L37;
        Map r117 = r110.latestBlock;
    L39:
        if ((r215 & 512) == 0) goto L41;
        Map r105 = r110.attemptCount;
    L43:
        if ((r215 & 1024) == 0) goto L45;
        Map r106 = r110.latestFailure;
    L46:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r113, "manualEntered");
        Intrinsics.checkNotNullParameter(r114, "availableUpdate");
        Intrinsics.checkNotNullParameter(r115, "attempted");
        Intrinsics.checkNotNullParameter(r116, "succeeded");
        Intrinsics.checkNotNullParameter(r117, "latestBlock");
        Intrinsics.checkNotNullParameter(r105, "attemptCount");
        Intrinsics.checkNotNullParameter(r106, "latestFailure");
        return new u5(r101, r102, r103, r104, r113, r114, r115, r116, r117, r105, r106);
    L45:
        r106 = r214;
        goto L46
    L41:
        r105 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r116 = r211;
        goto L35
    L29:
        r115 = r210;
        goto L31
    L25:
        r114 = r112;
        goto L27
    L21:
        r113 = r111;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = 0;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u5(String r100, long r101, long r102, boolean r103, Set<e> r104, Set<e> r105, Set<e> r110, Set<e> r111, Map<e, ? extends BlockReason> r112, Map<e, Integer> r113, Map<e, ? extends FailureReason> r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r104, "manualEntered");
        Intrinsics.checkNotNullParameter(r105, "availableUpdate");
        Intrinsics.checkNotNullParameter(r110, "attempted");
        Intrinsics.checkNotNullParameter(r111, "succeeded");
        Intrinsics.checkNotNullParameter(r112, "latestBlock");
        Intrinsics.checkNotNullParameter(r113, "attemptCount");
        Intrinsics.checkNotNullParameter(r114, "latestFailure");
        this.f337736id = r100;
        this.start = r101;
        this.end = r102;
        this.open = r103;
        this.manualEntered = r104;
        this.availableUpdate = r105;
        this.attempted = r110;
        this.succeeded = r111;
        this.latestBlock = r112;
        this.attemptCount = r113;
        this.latestFailure = r114;
    }
}
