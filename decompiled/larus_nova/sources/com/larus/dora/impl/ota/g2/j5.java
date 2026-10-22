package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j5 {
    private final int downloadFailures;
    private final long downloadRetryAt;
    private final long installCooldownUntil;
    private final int md5Failures;
    private final String noUpdateFingerprint;
    private final long noUpdateUntil;

    public j5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j5) == true) goto L8;
        return false;
    L8:
        j5 r101 = (j5) r100;
        if (this.noUpdateUntil == r101.noUpdateUntil) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.noUpdateFingerprint, r101.noUpdateFingerprint) == true) goto L15;
        return false;
    L15:
        if (this.downloadRetryAt == r101.downloadRetryAt) goto L18;
        return false;
    L18:
        if (this.downloadFailures == r101.downloadFailures) goto L21;
        return false;
    L21:
        if (this.md5Failures == r101.md5Failures) goto L24;
        return false;
    L24:
        if (this.installCooldownUntil == r101.installCooldownUntil) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.noUpdateUntil;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.noUpdateFingerprint.hashCode()) * 31;
        long r102 = this.downloadRetryAt;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.downloadFailures) * 31) + this.md5Failures) * 31;
        long r104 = this.installCooldownUntil;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "RetryState(noUpdateUntil=" + this.noUpdateUntil + ", noUpdateFingerprint=" + this.noUpdateFingerprint + ", downloadRetryAt=" + this.downloadRetryAt + ", downloadFailures=" + this.downloadFailures + ", md5Failures=" + this.md5Failures + ", installCooldownUntil=" + this.installCooldownUntil + ')';
    }

    public final int b() {
        return this.downloadFailures;
    }

    public final long c() {
        return this.downloadRetryAt;
    }

    public final long d() {
        return this.installCooldownUntil;
    }

    public final int e() {
        return this.md5Failures;
    }

    public final String f() {
        return this.noUpdateFingerprint;
    }

    public final long g() {
        return this.noUpdateUntil;
    }

    public /* synthetic */ j5(int r110) {
        this(0, "", 0, 0, 0, 0);
    }

    public j5(long r100, String r101, long r102, int r103, int r104, long r105) {
        Intrinsics.checkNotNullParameter(r101, "noUpdateFingerprint");
        this.noUpdateUntil = r100;
        this.noUpdateFingerprint = r101;
        this.downloadRetryAt = r102;
        this.downloadFailures = r103;
        this.md5Failures = r104;
        this.installCooldownUntil = r105;
    }

    public static j5 a(j5 r110, long r111, String r112, long r113, int r114, int r115, long r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.noUpdateUntil;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.noUpdateFingerprint;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.downloadRetryAt;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.downloadFailures;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.md5Failures;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.installCooldownUntil;
    L26:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "noUpdateFingerprint");
        return new j5(r100, r101, r102, r103, r104, r105);
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
