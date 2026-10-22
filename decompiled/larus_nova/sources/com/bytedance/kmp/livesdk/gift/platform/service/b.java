package com.bytedance.kmp.livesdk.gift.platform.service;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f252436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f252438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f252439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f252440e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.f252436a == r101.f252436a) goto L8;
        return false;
    L8:
        if (this.f252437b == r101.f252437b) goto L10;
        return false;
    L10:
        if (this.f252438c == r101.f252438c) goto L12;
        return false;
    L12:
        if (this.f252439d == r101.f252439d) goto L14;
        return false;
    L14:
        if (this.f252440e == r101.f252440e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f252436a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f252437b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f252438c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f252439d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f252440e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "GiftEventTime(openDialog=" + this.f252436a + ", giftPreview=" + this.f252437b + ", giftDoubleClick=" + this.f252438c + ", sendGift=" + this.f252439d + ", giftShow=" + this.f252440e + ")";
    }

    public b() {
        this.f252436a = 0;
        this.f252437b = 0;
        this.f252438c = 0;
        this.f252439d = 0;
        this.f252440e = 0;
    }
}
