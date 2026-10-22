package com.bytedance.sdk.account.time;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f269501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f269502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f269503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f269504d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L28:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L27;
        a r101 = (a) r100;
        if (this.f269501a != r101.f269501a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        if (this.f269502b != r101.f269502b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L27;
        if (this.f269503c != r101.f269503c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L27;
        if (this.f269504d != r101.f269504d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L27;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L27:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f269501a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f269502b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f269503c;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f269504d;
    }

    public final String toString() {
        return "CalibrationRecord(serverTimeMillis=" + this.f269501a + ", systemTimeMillis=" + this.f269502b + ", elapsedRealTimeMillis=" + this.f269503c + ", systemBootTimes=" + this.f269504d + ")";
    }

    public a() {
        this(0, 0, 0, -1);
    }

    public a(long r100, long r101, long r102, int r103) {
        this.f269501a = r100;
        this.f269502b = r101;
        this.f269503c = r102;
        this.f269504d = r103;
    }
}
