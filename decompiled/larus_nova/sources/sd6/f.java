package sd6;

/* JADX INFO: loaded from: classes28.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541465a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f541465a == ((f) r100).f541465a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f541465a;
    }

    public final String toString() {
        return "ResultParamsNull(nullValue=" + this.f541465a + ')';
    }

    public f(int r100) {
        this.f541465a = 0;
    }
}
