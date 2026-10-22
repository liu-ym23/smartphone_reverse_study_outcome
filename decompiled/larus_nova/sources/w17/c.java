package w17;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f557926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f557927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f557928c;

    public final int hashCode() {
        return (this.f557927b.hashCode() << 31) + this.f557926a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f557926a == r101.f557926a) goto L12;
        return false;
    L12:
        if (this.f557927b.equals(r101.f557927b) == true) goto L14;
        return false;
    L14:
        Object r102 = this.f557928c;
        if (r102 != null) goto L17;
    L18:
        Object r103 = r101.f557928c;
        if (r103 != null) goto L21;
        return true;
    L21:
        if (r103.equals(this.f557928c) == true) goto L26;
    L23:
        return false;
    L26:
        return true;
    L17:
        if (r102.equals(r101.f557928c) == false) goto L23;
        goto L18
    }

    public c(int r100, e r101, Object r102) {
        this.f557926a = r100;
        this.f557927b = r101;
        this.f557928c = r102;
    }
}
