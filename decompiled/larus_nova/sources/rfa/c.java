package rfa;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f537649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f537650b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f537649a == r101.f537649a) goto L12;
        return false;
    L12:
        if (this.f537650b == r101.f537650b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f537649a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f537650b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "SourceAppInfo(versionCode=" + this.f537649a + ", lastUpdateTime=" + this.f537650b + ')';
    }

    public /* synthetic */ c(int r100) {
        this(-1, -1);
    }

    public c(long r100, long r101) {
        this.f537649a = r100;
        this.f537650b = r101;
    }
}
