package rdb;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f537348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537349b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f537348a == r101.f537348a) goto L12;
        return false;
    L12:
        if (this.f537349b == r101.f537349b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f537348a * 31) + this.f537349b;
    }

    public final String toString() {
        return "FeedScrollState(firstPosition=" + this.f537348a + ", offset=" + this.f537349b + ')';
    }

    public a(int r100, int r101) {
        this.f537348a = r100;
        this.f537349b = r101;
    }
}
