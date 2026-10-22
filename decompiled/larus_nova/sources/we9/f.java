package we9;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements xe9.c, xe9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f559423a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f559423a == ((f) r100).f559423a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f559423a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "Ping(clientMs=" + this.f559423a + ')';
    }

    public f(long r100) {
        this.f559423a = r100;
    }
}
