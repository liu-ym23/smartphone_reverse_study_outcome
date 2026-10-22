package t3;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544293b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f544292a == r101.f544292a) goto L12;
        return false;
    L12:
        if (this.f544293b == r101.f544293b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f544292a * 31;
        if (this.f544293b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BatteryInfoSnapshot(level=" + this.f544292a + ", isCharging=" + this.f544293b + ')';
    }

    public g(int r100, boolean r101) {
        this.f544292a = r100;
        this.f544293b = r101;
    }
}
