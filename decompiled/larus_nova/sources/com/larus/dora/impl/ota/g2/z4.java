package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z4 {
    private final long deadline;
    private final e device;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z4) == true) goto L8;
        return false;
    L8:
        z4 r101 = (z4) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (this.deadline == r101.deadline) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.device.hashCode() * 31;
        long r101 = this.deadline;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LegacyInstallBlocker(device=" + this.device + ", deadline=" + this.deadline + ')';
    }

    public final long b() {
        return this.deadline;
    }

    public final e c() {
        return this.device;
    }

    public z4(e r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "device");
        this.device = r100;
        this.deadline = r101;
    }

    public static z4 a(z4 r100, long r101) {
        e r102 = r100.device;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "device");
        return new z4(r102, r101);
    }
}
