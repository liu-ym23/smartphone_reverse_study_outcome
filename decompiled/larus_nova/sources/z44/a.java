package z44;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f569931a;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f569931a == ((a) r100).f569931a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f569931a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "AosCollectConfig(isEnableCollect=" + this.f569931a + ')';
    }

    public a(int r100) {
        this.f569931a = true;
    }
}
