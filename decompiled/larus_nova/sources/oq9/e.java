package oq9;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f524902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524903b;

    public e() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f524902a == r101.f524902a) goto L12;
        return false;
    L12:
        if (this.f524903b == r101.f524903b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f524902a * 31) + this.f524903b;
    }

    public final String toString() {
        return "CameraFreeInputConfig(mainBotInputStyle=" + this.f524902a + ", ugcBotInputStyle=" + this.f524903b + ')';
    }

    public e(int r100, int r101) {
        this.f524902a = r100;
        this.f524903b = r101;
    }
}
