package ld7;

/* JADX INFO: loaded from: classes22.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f508752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f508754c;

    public static final class a {
    }

    static {
    }

    public l() {
        this(0, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f508752a == r101.f508752a) goto L12;
        return false;
    L12:
        if (this.f508753b == r101.f508753b) goto L15;
        return false;
    L15:
        if (this.f508754c == r101.f508754c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508752a * 31;
        int r101 = 1231;
        if (this.f508753b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f508754c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxAuthSwitch(signVerifyMode=" + this.f508752a + ", enableJsbAuth=" + this.f508753b + ", enableJsbCallLimit=" + this.f508754c + ')';
    }

    public l(int r100, boolean r101, boolean r102) {
        this.f508752a = r100;
        this.f508753b = r101;
        this.f508754c = r102;
    }
}
