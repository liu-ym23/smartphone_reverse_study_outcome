package com.bytedance.kmp.performance.platform;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f252788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f252790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f252791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f252792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f252793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f252794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f252795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f252796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f252797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f252798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f252799l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f252788a == r101.f252788a) goto L12;
        return false;
    L12:
        if (this.f252789b == r101.f252789b) goto L15;
        return false;
    L15:
        if (this.f252790c == r101.f252790c) goto L18;
        return false;
    L18:
        if (this.f252791d == r101.f252791d) goto L21;
        return false;
    L21:
        if (this.f252792e == r101.f252792e) goto L24;
        return false;
    L24:
        if (this.f252793f == r101.f252793f) goto L27;
        return false;
    L27:
        if (this.f252794g == r101.f252794g) goto L30;
        return false;
    L30:
        if (this.f252795h == r101.f252795h) goto L33;
        return false;
    L33:
        if (this.f252796i == r101.f252796i) goto L36;
        return false;
    L36:
        if (this.f252797j == r101.f252797j) goto L39;
        return false;
    L39:
        if (this.f252798k == r101.f252798k) goto L42;
        return false;
    L42:
        if (this.f252799l == r101.f252799l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f252788a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f252789b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f252790c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f252791d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f252792e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f252793f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f252794g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f252795h;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.f252796i;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f252797j;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f252798k;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f252799l;
        return r121 + ((int) (r122 ^ (r122 >>> 32)));
    }

    public final String toString() {
        return "CpuTimes(user=" + this.f252788a + ", nice=" + this.f252789b + ", system=" + this.f252790c + ", idle=" + this.f252791d + ", iowait=" + this.f252792e + ", irq=" + this.f252793f + ", softirq=" + this.f252794g + ", steal=" + this.f252795h + ", guest=" + this.f252796i + ", guestNice=" + this.f252797j + ", total=" + this.f252798k + ", idleTotal=" + this.f252799l + ')';
    }

    public j(long r110, long r210, long r211, long r212, long r213, long r214, long r310) {
        this.f252788a = r110;
        this.f252789b = r210;
        this.f252790c = r211;
        this.f252791d = r212;
        this.f252792e = r213;
        this.f252793f = r214;
        this.f252794g = r310;
        this.f252795h = 0;
        this.f252796i = 0;
        this.f252797j = 0;
        this.f252798k = ((((((((r110 + r210) + r211) + r212) + r213) + r214) + r310) + 0) + 0) + 0;
        this.f252799l = r212 + r213;
    }
}
