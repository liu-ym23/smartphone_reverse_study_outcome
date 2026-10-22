package com.bytedance.sdk.account.log.util;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f269171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f269172b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L17;
        b r101 = (b) r100;
        if (this.f269171a != r101.f269171a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f269172b != r101.f269172b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L17:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f269171a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f269172b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "EventTime(millis=" + this.f269171a + ", nanos=" + this.f269172b + ")";
    }

    public b(long r100, long r101) {
        this.f269171a = r100;
        this.f269172b = r101;
    }
}
