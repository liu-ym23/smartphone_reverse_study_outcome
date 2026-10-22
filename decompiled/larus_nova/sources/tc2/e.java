package tc2;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f545379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f545380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f545381c;

    public e() {
        this(0, 0, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (this.f545379a == r101.f545379a) goto L8;
        return false;
    L8:
        if (this.f545380b == r101.f545380b) goto L10;
        return false;
    L10:
        if (this.f545381c == r101.f545381c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f545379a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f545380b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f545381c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "DanmakuStat(messageDecodeTime=" + this.f545379a + ", dataReceiveTime=" + this.f545380b + ", danmakuReceiveTime=" + this.f545381c + ")";
    }

    public e(long r100, long r101, long r102) {
        this.f545379a = r100;
        this.f545380b = r101;
        this.f545381c = r102;
    }

    public /* synthetic */ e(long r100, long r110, long r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        long r113 = 0;
    L14:
        this(r101, r102, r113);
        return;
    L13:
        r113 = r111;
        goto L14
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }
}
