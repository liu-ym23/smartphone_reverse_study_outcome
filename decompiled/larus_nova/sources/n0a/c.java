package n0a;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f516624a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f516624a == ((c) r100).f516624a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f516624a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "NotifyEvent(uniqueId=" + this.f516624a + ')';
    }

    public c(long r100) {
        this.f516624a = r100;
    }
}
