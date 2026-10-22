package t3a;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f544526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f544527f;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f544522a == r101.f544522a) goto L12;
        return false;
    L12:
        if (this.f544523b == r101.f544523b) goto L15;
        return false;
    L15:
        if (this.f544524c == r101.f544524c) goto L18;
        return false;
    L18:
        if (this.f544525d == r101.f544525d) goto L21;
        return false;
    L21:
        if (this.f544526e == r101.f544526e) goto L24;
        return false;
    L24:
        if (this.f544527f == r101.f544527f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f544522a * 31) + this.f544523b) * 31) + this.f544524c) * 31) + this.f544525d) * 31;
        int r101 = 1231;
        if (this.f544526e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f544527f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "GlobalFloatWindowConfig(width=" + this.f544522a + ", height=" + this.f544523b + ", initialX=" + this.f544524c + ", initialY=" + this.f544525d + ", enableDrag=" + this.f544526e + ", enableClick=" + this.f544527f + ')';
    }

    public e(int r100) {
        this.f544522a = 300;
        this.f544523b = 400;
        this.f544524c = 100;
        this.f544525d = 100;
        this.f544526e = true;
        this.f544527f = true;
    }
}
