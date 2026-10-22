package hq9;

/* JADX INFO: loaded from: classes4.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f486671e;

    public m1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m1) == true) goto L8;
        return false;
    L8:
        m1 r101 = (m1) r100;
        if (this.f486667a == r101.f486667a) goto L12;
        return false;
    L12:
        if (this.f486668b == r101.f486668b) goto L15;
        return false;
    L15:
        if (this.f486669c == r101.f486669c) goto L18;
        return false;
    L18:
        if (this.f486670d == r101.f486670d) goto L21;
        return false;
    L21:
        if (this.f486671e == r101.f486671e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486667a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486668b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486669c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (((r104 + r100) * 31) + this.f486670d) * 31;
        long r106 = this.f486671e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FrontierOptConfig(reconnectEnable=" + this.f486667a + ", connectInfoEnable=" + this.f486668b + ", doraBackgroundDisable=" + this.f486669c + ", backgroundMode=" + this.f486670d + ", backgroundDelayTime=" + this.f486671e + ')';
    }

    public /* synthetic */ m1(int r100) {
        this(true, false, true, 0, 0);
    }

    public m1(boolean r100, boolean r101, boolean r102, int r103, long r104) {
        this.f486667a = r100;
        this.f486668b = r101;
        this.f486669c = r102;
        this.f486670d = r103;
        this.f486671e = r104;
    }
}
