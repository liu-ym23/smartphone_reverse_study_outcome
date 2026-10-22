package y88;

/* JADX INFO: loaded from: classes23.dex */
public final class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566930a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (this.f566930a == ((g) r100).f566930a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f566930a;
    }

    public final String toString() {
        return "DoraAvlinkTimeoutSessionConfig(userTimeoutSeconds=" + this.f566930a + ')';
    }

    public g() {
        this(8);
    }

    public g(int r100) {
        this.f566930a = r100;
    }
}
