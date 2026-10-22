package n0c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f516635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f516636c;

    public final int hashCode() {
        return (((this.f516634a.hashCode() * 31) + (this.f516635b ? 1 : 0)) * 31) + (this.f516636c ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.f516634a + "', granted=" + this.f516635b + ", shouldShowRequestPermissionRationale=" + this.f516636c + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L18;
        a r101 = (a) r100;
        if (this.f516635b == r101.f516635b) goto L14;
        return false;
    L14:
        if (this.f516636c == r101.f516636c) goto L17;
        return false;
    L17:
        return this.f516634a.equals(r101.f516634a);
    }

    public a(String r100, boolean r101, boolean r102) {
        this.f516634a = r100;
        this.f516635b = r101;
        this.f516636c = r102;
    }
}
