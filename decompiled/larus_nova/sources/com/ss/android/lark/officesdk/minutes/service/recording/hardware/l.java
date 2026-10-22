package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

/* JADX INFO: loaded from: classes37.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f435574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f435575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f435576c;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f435574a == r101.f435574a) goto L12;
        return false;
    L12:
        if (this.f435575b == r101.f435575b) goto L15;
        return false;
    L15:
        if (this.f435576c == r101.f435576c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f435574a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f435575b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f435576c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "RecordingInterruptionTimeoutConfig(callInterruptionConfirmTimeoutMs=" + this.f435574a + ", callRecoveryMaxDurationMs=" + this.f435575b + ", inputRecoveryMaxDurationMs=" + this.f435576c + ')';
    }

    public l(int r100) {
        this.f435574a = 2000;
        this.f435575b = 7200000;
        this.f435576c = 90000;
    }
}
