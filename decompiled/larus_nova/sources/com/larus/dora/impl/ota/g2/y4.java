package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y4 {
    private final e device;
    private final String requestId;
    private final long requestedAt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y4) == true) goto L8;
        return false;
    L8:
        y4 r101 = (y4) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
        return false;
    L15:
        if (this.requestedAt == r101.requestedAt) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.device.hashCode() * 31) + this.requestId.hashCode()) * 31;
        long r101 = this.requestedAt;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LegacyDownloadRequest(device=" + this.device + ", requestId=" + this.requestId + ", requestedAt=" + this.requestedAt + ')';
    }

    public final e a() {
        return this.device;
    }

    public final String b() {
        return this.requestId;
    }

    public final long c() {
        return this.requestedAt;
    }

    public y4(e r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        this.device = r100;
        this.requestId = r101;
        this.requestedAt = r102;
    }
}
