package jub;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f500506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f500508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f500509d;

    public a() {
        this(0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f500506a == r101.f500506a) goto L12;
        return false;
    L12:
        if (this.f500507b == r101.f500507b) goto L15;
        return false;
    L15:
        if (this.f500508c == r101.f500508c) goto L18;
        return false;
    L18:
        if (this.f500509d == r101.f500509d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f500506a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f500507b) * 31;
        if (this.f500508c == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.f500509d;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingNotificationConfig(canClose=" + this.f500506a + ", priority=" + this.f500507b + ", persistent=" + this.f500508c + ", throttleInterval=" + this.f500509d + ')';
    }

    public a(long r100, int r101) {
        if ((r101 & 8) == 0) goto L5;
        r100 = 0;
    L5:
        this.f500506a = false;
        this.f500507b = 0;
        this.f500508c = false;
        this.f500509d = r100;
    }
}
