package z9b;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571079c;

    public b() {
        this(false, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f571077a == r101.f571077a) goto L12;
        return false;
    L12:
        if (this.f571078b == r101.f571078b) goto L15;
        return false;
    L15:
        if (this.f571079c == r101.f571079c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f571077a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f571078b) * 31) + this.f571079c;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PhoneStyleConfig(enable=" + this.f571077a + ", phoneColorResFromMe=" + this.f571078b + ", phoneColorResFromOther=" + this.f571079c + ')';
    }

    public b(boolean r100, int r101, int r102) {
        this.f571077a = r100;
        this.f571078b = r101;
        this.f571079c = r102;
    }
}
