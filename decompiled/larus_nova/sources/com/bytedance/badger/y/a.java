package com.bytedance.badger.y;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f199432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f199433b;

    public a(long r100, long r101) {
        this.f199432a = r100;
        this.f199433b = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L17;
        a r101 = (a) r100;
        if (this.f199432a != r101.f199432a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f199433b != r101.f199433b) goto L14;
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
        long r100 = this.f199432a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f199433b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "EventTimes(createTimeMs=" + this.f199432a + ", updateTimeMs=" + this.f199433b + ")";
    }
}
