package is8;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f495642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f495643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495644c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f495642a == r101.f495642a) goto L12;
        return false;
    L12:
        if (this.f495643b == r101.f495643b) goto L15;
        return false;
    L15:
        if (this.f495644c == r101.f495644c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495642a * 31;
        int r101 = 1231;
        if (this.f495643b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f495644c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "RetryPolicy(maxRetryCount=" + this.f495642a + ", retryOnAuthFailure=" + this.f495643b + ", retryOnNetworkFailure=" + this.f495644c + ')';
    }

    public b(int r100) {
        this.f495642a = 1;
        this.f495643b = true;
        this.f495644c = true;
    }
}
