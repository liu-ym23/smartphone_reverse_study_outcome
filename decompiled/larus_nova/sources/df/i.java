package df;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f468104a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.f468104a == ((i) r100).f468104a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f468104a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "EnterCartOptional(promotionSource=" + this.f468104a + ")";
    }

    public i() {
        this(0);
    }

    public i(long r100) {
        this.f468104a = r100;
    }
}
