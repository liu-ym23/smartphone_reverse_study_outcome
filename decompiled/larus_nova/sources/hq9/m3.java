package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486681b;

    public m3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m3) == true) goto L8;
        return false;
    L8:
        m3 r101 = (m3) r100;
        if (this.f486680a == r101.f486680a) goto L12;
        return false;
    L12:
        if (this.f486681b == r101.f486681b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f486680a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f486681b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "NetworkAutoSwitchConfig(enable=" + this.f486680a + ", dialogInterval=" + this.f486681b + ')';
    }

    public /* synthetic */ m3(int r100) {
        this(false, 24);
    }

    public m3(boolean r100, int r101) {
        this.f486680a = r100;
        this.f486681b = r101;
    }
}
