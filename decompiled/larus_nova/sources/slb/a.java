package slb;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f542511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f542512b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f542511a == r101.f542511a) goto L12;
        return false;
    L12:
        if (this.f542512b == r101.f542512b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f542511a * 31) + this.f542512b;
    }

    public final String toString() {
        return "BottomSpace(withoutKeyboard=" + this.f542511a + ", withKeyboard=" + this.f542512b + ')';
    }

    public a() {
        this.f542511a = 0;
        this.f542512b = 0;
    }
}
