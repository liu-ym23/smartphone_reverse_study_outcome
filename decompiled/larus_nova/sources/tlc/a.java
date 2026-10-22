package tlc;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546756a;

    /* JADX INFO: renamed from: tlc.a$a, reason: collision with other inner class name */
    public static final class C7742a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f546756a == ((a) r100).f546756a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f546756a;
    }

    public final String toString() {
        return "HistoryMessageFetchParams(fetchMessageCount=" + this.f546756a + ")";
    }

    public a(int r100) {
        this.f546756a = r100;
    }
}
