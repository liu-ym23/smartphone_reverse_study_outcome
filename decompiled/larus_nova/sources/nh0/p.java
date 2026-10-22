package nh0;

/* JADX INFO: loaded from: classes46.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519152b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (this.f519151a == r101.f519151a) goto L8;
        return false;
    L8:
        if (this.f519152b == r101.f519152b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f519151a * 31) + this.f519152b;
    }

    public final String toString() {
        return "StateBeforeUpdateConfig(scene=" + this.f519151a + ", uiLayout=" + this.f519152b + ")";
    }

    public p(int r100, int r101) {
        this.f519151a = r100;
        this.f519152b = r101;
    }
}
