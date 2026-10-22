package com.larus.im.internal.rtcsdk.impl.trace;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f350017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f350018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f350019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f350020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f350021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f350022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f350023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f350024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f350025i;

    public a() {
        this(0, 0, 0, 0, false, 0, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f350017a == r101.f350017a) goto L12;
        return false;
    L12:
        if (this.f350018b == r101.f350018b) goto L15;
        return false;
    L15:
        if (this.f350019c == r101.f350019c) goto L18;
        return false;
    L18:
        if (this.f350020d == r101.f350020d) goto L21;
        return false;
    L21:
        if (this.f350021e == r101.f350021e) goto L24;
        return false;
    L24:
        if (this.f350022f == r101.f350022f) goto L27;
        return false;
    L27:
        if (this.f350023g == r101.f350023g) goto L30;
        return false;
    L30:
        if (this.f350024h == r101.f350024h) goto L33;
        return false;
    L33:
        if (this.f350025i == r101.f350025i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f350017a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f350018b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f350019c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f350020d;
        int r107 = (((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f350021e) * 31;
        int r108 = 1231;
        if (this.f350022f == false) goto L5;
        int r109 = 1231;
    L6:
        int r110 = (r107 + r109) * 31;
        if (this.f350023g == true) goto L10;
        r108 = 1237;
    L10:
        int r111 = (((r110 + r108) * 31) + this.f350024h) * 31;
        long r112 = this.f350025i;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L5:
        r109 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioFrameTrace(receiveTime=" + this.f350017a + ", enqueueTime=" + this.f350018b + ", takeTime=" + this.f350019c + ", dequeueTime=" + this.f350020d + ", samiProcessCost=" + this.f350021e + ", isFirstPkg=" + this.f350022f + ", isLastPkg=" + this.f350023g + ", pkgDuration=" + this.f350024h + ", processedTime=" + this.f350025i + ')';
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final long a() {
        return this.f350018b;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final long b() {
        return this.f350019c;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final long c() {
        return this.f350020d;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final boolean d() {
        return this.f350022f;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final boolean e() {
        return this.f350023g;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final long f() {
        return this.f350025i;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final int g() {
        return this.f350024h;
    }

    @Override // com.larus.im.internal.rtcsdk.impl.trace.b
    public final long getReceiveTime() {
        return this.f350017a;
    }

    public a(long r110, long r111, long r210, long r211, boolean r212, long r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = com.larus.im.internal.network.stragery.a.b();
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r214 & 4) == 0) goto L13;
        long r102 = -1;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r112 = -1;
    L18:
        int r113 = -1;
        if ((r214 & 16) == 0) goto L21;
        int r103 = -1;
    L23:
        if ((r214 & 32) == 0) goto L25;
        boolean r114 = false;
    L27:
        if ((r214 & 128) != 0) goto L31;
        r113 = 0;
    L31:
        if ((r214 & 256) == 0) goto L33;
        long r104 = -1;
    L34:
        this.f350017a = r100;
        this.f350018b = r101;
        this.f350019c = r102;
        this.f350020d = r112;
        this.f350021e = r103;
        this.f350022f = r114;
        this.f350023g = false;
        this.f350024h = r113;
        this.f350025i = r104;
        return;
    L33:
        r104 = r213;
        goto L34
    L25:
        r114 = r212;
        goto L27
    L21:
        r103 = 0;
        goto L23
    L17:
        r112 = r211;
        goto L18
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
