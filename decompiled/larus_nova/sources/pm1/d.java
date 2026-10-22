package pm1;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f529816b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f529817a;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f529817a == ((d) r100).f529817a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f529817a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "RequestConfig(needCacheVideo=" + this.f529817a + ")";
    }

    static {
        f529816b = new d();
    }

    public d() {
        this.f529817a = true;
    }
}
