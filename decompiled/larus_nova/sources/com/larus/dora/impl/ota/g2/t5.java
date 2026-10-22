package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t5 {
    private final e device;
    private final String ownerId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t5) == true) goto L8;
        return false;
    L8:
        t5 r101 = (t5) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.device.hashCode() * 31) + this.ownerId.hashCode();
    }

    public final String toString() {
        return "WifiLease(device=" + this.device + ", ownerId=" + this.ownerId + ')';
    }

    public final e a() {
        return this.device;
    }

    public final String b() {
        return this.ownerId;
    }
}
