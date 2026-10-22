package lw8;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511091a;

    public n() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (this.f511091a == ((n) r100).f511091a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f511091a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "SyntaxErrorCoverConfig(refineTableInList=" + this.f511091a + ')';
    }

    public n(boolean r100) {
        this.f511091a = r100;
    }
}
