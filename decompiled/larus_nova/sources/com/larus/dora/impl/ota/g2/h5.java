package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h5 {
    private final e device;
    private final String eventId;
    private final String ownerId;
    private final FailureReason reason;
    private final TerminalResult result;
    private final long retryAt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h5) == true) goto L8;
        return false;
    L8:
        h5 r101 = (h5) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.result == r101.result) goto L18;
        return false;
    L18:
        if (this.reason == r101.reason) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L24;
        return false;
    L24:
        if (this.retryAt == r101.retryAt) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.device.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.result.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.eventId.hashCode()) * 31;
        long r101 = this.retryAt;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PendingTerminal(device=" + this.device + ", ownerId=" + this.ownerId + ", result=" + this.result + ", reason=" + this.reason + ", eventId=" + this.eventId + ", retryAt=" + this.retryAt + ')';
    }

    public final e b() {
        return this.device;
    }

    public final String c() {
        return this.eventId;
    }

    public final String d() {
        return this.ownerId;
    }

    public final FailureReason e() {
        return this.reason;
    }

    public final TerminalResult f() {
        return this.result;
    }

    public final long g() {
        return this.retryAt;
    }

    public static h5 a(h5 r100, long r101) {
        e r102 = r100.device;
        String r103 = r100.ownerId;
        TerminalResult r104 = r100.result;
        FailureReason r105 = r100.reason;
        String r106 = r100.eventId;
        Intrinsics.checkNotNullParameter(r102, "device");
        Intrinsics.checkNotNullParameter(r103, "ownerId");
        Intrinsics.checkNotNullParameter(r104, "result");
        Intrinsics.checkNotNullParameter(r105, "reason");
        Intrinsics.checkNotNullParameter(r106, com.heytap.mcssdk.constant.b.f276361k);
        return new h5(r102, r103, r104, r105, r106, r101);
    }

    public h5(e r100, String r101, TerminalResult r102, FailureReason r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r103, "reason");
        Intrinsics.checkNotNullParameter(r104, com.heytap.mcssdk.constant.b.f276361k);
        this.device = r100;
        this.ownerId = r101;
        this.result = r102;
        this.reason = r103;
        this.eventId = r104;
        this.retryAt = r105;
    }
}
