package sd6;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541464a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f541464a == ((e) r100).f541464a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f541464a;
    }

    public final String toString() {
        return "ResultParamsMissing(missingValue=" + this.f541464a + ')';
    }

    public e(int r100) {
        this.f541464a = 0;
    }
}
