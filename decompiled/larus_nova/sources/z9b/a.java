package z9b;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571076c;

    public a() {
        this(false, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f571074a == r101.f571074a) goto L12;
        return false;
    L12:
        if (this.f571075b == r101.f571075b) goto L15;
        return false;
    L15:
        if (this.f571076c == r101.f571076c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f571074a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f571075b) * 31) + this.f571076c;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "LinkStyleConfig(enable=" + this.f571074a + ", linkColorResFromMe=" + this.f571075b + ", linkColorResFromOther=" + this.f571076c + ')';
    }

    public a(boolean r100, int r101, int r102) {
        this.f571074a = r100;
        this.f571075b = r101;
        this.f571076c = r102;
    }
}
