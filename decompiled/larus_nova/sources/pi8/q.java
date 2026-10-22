package pi8;

/* JADX INFO: loaded from: classes25.dex */
public final class q extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f529388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529390c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f529388a == r101.f529388a) goto L12;
        return false;
    L12:
        if (this.f529389b == r101.f529389b) goto L15;
        return false;
    L15:
        if (this.f529390c == r101.f529390c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f529388a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f529389b) * 31) + this.f529390c;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SearchTinyAdapterCreateParam(useSearchDetailBox=" + this.f529388a + ", indicator=" + this.f529389b + ", abVersion=" + this.f529390c + ')';
    }

    public q(boolean r100, int r101, int r102) {
        this.f529388a = r100;
        this.f529389b = r101;
        this.f529390c = r102;
    }
}
