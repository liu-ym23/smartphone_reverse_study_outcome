package com.bytedance.sdk.account.log.util;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f269173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f269174b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L17;
        c r101 = (c) r100;
        if (this.f269173a != r101.f269173a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f269174b != r101.f269174b) goto L14;
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
        long r100 = this.f269173a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f269174b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return d.a(this.f269173a) + "ms (" + d.a(this.f269174b) + "ns)";
    }

    public c(long r100, long r101) {
        this.f269173a = r100;
        this.f269174b = r101;
    }
}
