package tw5;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f547761a;

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
        if (this.f547761a == ((a) r100).f547761a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f547761a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "KmpTtsTimeoutStrategy(timeoutDuration=" + this.f547761a + ')';
    }

    public /* synthetic */ a(int r100) {
        this(60000);
    }

    public a(long r100) {
        this.f547761a = r100;
    }
}
