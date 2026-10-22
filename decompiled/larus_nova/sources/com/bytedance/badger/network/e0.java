package com.bytedance.badger.network;

/* JADX INFO: loaded from: classes47.dex */
public final class e0 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f199097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f199099d;

    @Override // com.bytedance.badger.network.l0
    public final boolean a() {
        return this.f199096a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L23:
        return true;
    L5:
        if ((r100 instanceof e0) == false) goto L22;
        e0 r101 = (e0) r100;
        if (this.f199097b != r101.f199097b) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L22;
        if (this.f199098c != r101.f199098c) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L22;
        if (this.f199099d != r101.f199099d) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L22:
        return false;
    }

    public final int hashCode() {
        return (((this.f199097b * 31) + this.f199098c) * 31) + this.f199099d;
    }

    public final String toString() {
        return "DelayedRetry(immediateRetryCount=" + this.f199097b + ", currentRetryCount=" + this.f199098c + ", remainingRetryCount=" + this.f199099d + ")";
    }

    public e0(int r100, int r101, int r102) {
        this.f199097b = r100;
        this.f199098c = r101;
        this.f199099d = r102;
        if (r102 > 0) goto L5;
        boolean r103 = true;
    L6:
        this.f199096a = r103;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
