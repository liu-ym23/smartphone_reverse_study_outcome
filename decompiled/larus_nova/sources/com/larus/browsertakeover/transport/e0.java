package com.larus.browsertakeover.transport;

/* JADX INFO: loaded from: classes26.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f319689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f319690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f319691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f319692d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f319689a == r101.f319689a) goto L12;
        return false;
    L12:
        if (this.f319690b == r101.f319690b) goto L15;
        return false;
    L15:
        if (this.f319691c == r101.f319691c) goto L18;
        return false;
    L18:
        if (this.f319692d == r101.f319692d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f319689a * 31;
        long r101 = this.f319690b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f319691c) * 31;
        long r103 = this.f319692d;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "RtsQueueBudgetSnapshot(queuedPackets=" + this.f319689a + ", queuedBytes=" + this.f319690b + ", maxQueuedPackets=" + this.f319691c + ", maxQueuedBytes=" + this.f319692d + ')';
    }

    public e0(int r100, long r101, int r102, long r103) {
        this.f319689a = r100;
        this.f319690b = r101;
        this.f319691c = r102;
        this.f319692d = r103;
    }
}
