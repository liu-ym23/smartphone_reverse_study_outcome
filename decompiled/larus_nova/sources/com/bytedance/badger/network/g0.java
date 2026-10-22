package com.bytedance.badger.network;

/* JADX INFO: loaded from: classes47.dex */
public final class g0 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f199105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199106c;

    @Override // com.bytedance.badger.network.l0
    public final boolean a() {
        return this.f199104a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof g0) == false) goto L17;
        g0 r101 = (g0) r100;
        if (this.f199105b != r101.f199105b) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f199106c != r101.f199106c) goto L14;
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
        return (this.f199105b * 31) + this.f199106c;
    }

    public final String toString() {
        return "ImmediateRetry(currentRetryCount=" + this.f199105b + ", remainingRetryCount=" + this.f199106c + ")";
    }

    public g0(int r100, int r101) {
        this.f199105b = r100;
        this.f199106c = r101;
        if (r101 > 0) goto L5;
        boolean r102 = true;
    L6:
        this.f199104a = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
