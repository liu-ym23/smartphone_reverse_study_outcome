package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c5 {
    private final long effectId;
    private final long retryAt;
    private final e5 spec;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c5) == true) goto L8;
        return false;
    L8:
        c5 r101 = (c5) r100;
        if (Intrinsics.areEqual(this.spec, r101.spec) == true) goto L12;
        return false;
    L12:
        if (this.effectId == r101.effectId) goto L15;
        return false;
    L15:
        if (this.retryAt == r101.retryAt) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.spec.hashCode() * 31;
        long r101 = this.effectId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.retryAt;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "PackageCleanup(spec=" + this.spec + ", effectId=" + this.effectId + ", retryAt=" + this.retryAt + ')';
    }

    public final long b() {
        return this.effectId;
    }

    public final long c() {
        return this.retryAt;
    }

    public final e5 d() {
        return this.spec;
    }

    public static c5 a(c5 r100, long r101) {
        e5 r102 = r100.spec;
        long r103 = r100.effectId;
        Intrinsics.checkNotNullParameter(r102, "spec");
        return new c5(r102, r103, r101);
    }

    public c5(e5 r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        this.spec = r100;
        this.effectId = r101;
        this.retryAt = r102;
    }
}
