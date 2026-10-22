package com.larus.platform.api;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f365223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365224c;

    public p() {
        this(false, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f365222a == r101.f365222a) goto L12;
        return false;
    L12:
        if (this.f365223b == r101.f365223b) goto L15;
        return false;
    L15:
        if (this.f365224c == r101.f365224c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f365222a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f365223b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f365224c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DriveUserStorageData(showSizeLimit=" + this.f365222a + ", totalBytes=" + this.f365223b + ", usedBytes=" + this.f365224c + ')';
    }

    public p(boolean r100, long r101, long r102) {
        this.f365222a = r100;
        this.f365223b = r101;
        this.f365224c = r102;
    }
}
