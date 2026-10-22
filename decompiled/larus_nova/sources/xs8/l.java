package xs8;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f565028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f565029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f565030c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f565028a == r101.f565028a) goto L12;
        return false;
    L12:
        if (this.f565029b == r101.f565029b) goto L15;
        return false;
    L15:
        if (this.f565030c == r101.f565030c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f565028a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f565029b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.f565030c == false) goto L5;
        int r104 = 1231;
    L7:
        return r103 + r104;
    L5:
        r104 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubscribedModelFallback(selectedId=" + this.f565028a + ", fallbackId=" + this.f565029b + ", syncVideoModel=" + this.f565030c + ')';
    }

    public l(long r100, long r101, boolean r102) {
        this.f565028a = r100;
        this.f565029b = r101;
        this.f565030c = r102;
    }
}
