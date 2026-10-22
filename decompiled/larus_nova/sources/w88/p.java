package w88;

/* JADX INFO: loaded from: classes23.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f558699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558700b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f558699a == r101.f558699a) goto L12;
        return false;
    L12:
        if (this.f558700b == r101.f558700b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558699a * 31;
        long r101 = this.f558700b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GalleryStoragePolicyConfig(packRetentionDays=" + this.f558699a + ", packMaxBytes=" + this.f558700b + ')';
    }

    public p() {
        this(3, 3221225472L);
    }

    public p(int r100, long r101) {
        this.f558699a = r100;
        this.f558700b = r101;
    }
}
