package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    private final e device;
    private final DownloadOwnerKind kind;
    private final long operationId;
    private final String requestId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r101.operationId) goto L15;
        return false;
    L15:
        if (this.kind == r101.kind) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.device.hashCode() * 31;
        long r101 = this.operationId;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.kind.hashCode()) * 31;
        String r103 = this.requestId;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "DownloadOwner(device=" + this.device + ", operationId=" + this.operationId + ", kind=" + this.kind + ", requestId=" + this.requestId + ')';
    }

    public final e b() {
        return this.device;
    }

    public final DownloadOwnerKind c() {
        return this.kind;
    }

    public final long d() {
        return this.operationId;
    }

    public final String e() {
        return this.requestId;
    }

    public static k a(k r100, DownloadOwnerKind r101) {
        e r102 = r100.device;
        long r103 = r100.operationId;
        String r104 = r100.requestId;
        Intrinsics.checkNotNullParameter(r102, "device");
        Intrinsics.checkNotNullParameter(r101, "kind");
        return new k(r102, r103, r101, r104);
    }

    public k(e r100, long r101, DownloadOwnerKind r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r102, "kind");
        this.device = r100;
        this.operationId = r101;
        this.kind = r102;
        this.requestId = r103;
    }
}
