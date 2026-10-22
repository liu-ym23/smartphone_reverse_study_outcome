package ix8;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f496408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f496409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496410c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f496408a == r101.f496408a) goto L12;
        return false;
    L12:
        if (this.f496409b == r101.f496409b) goto L15;
        return false;
    L15:
        if (this.f496410c == r101.f496410c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f496408a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f496409b) * 31) + this.f496410c;
    }

    public final String toString() {
        return "VLMIntentPreProcessInfo(durationMs=" + this.f496408a + ", originImageSize=" + this.f496409b + ", compressedImageSize=" + this.f496410c + ')';
    }

    public /* synthetic */ g(int r100) {
        this(0, 0, 0);
    }

    public g(long r100, int r101, int r102) {
        this.f496408a = r100;
        this.f496409b = r101;
        this.f496410c = r102;
    }
}
