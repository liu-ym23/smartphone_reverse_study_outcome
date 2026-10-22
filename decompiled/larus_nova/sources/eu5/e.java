package eu5;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f474078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f474079c;

    public final int hashCode() {
        return (((this.f474077a.hashCode() * 31) + (this.f474078b ? 1 : 0)) * 31) + (this.f474079c ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.f474077a + "', granted=" + this.f474078b + ", shouldShowRequestPermissionRationale=" + this.f474079c + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (e.class != r100.getClass()) goto L18;
        e r101 = (e) r100;
        if (this.f474078b == r101.f474078b) goto L14;
        return false;
    L14:
        if (this.f474079c == r101.f474079c) goto L17;
        return false;
    L17:
        return this.f474077a.equals(r101.f474077a);
    }

    public e(String r100, boolean r101, boolean r102) {
        this.f474077a = r100;
        this.f474078b = r101;
        this.f474079c = r102;
    }
}
