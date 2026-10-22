package dw8;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f470326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f470327b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f470326a == r101.f470326a) goto L12;
        return false;
    L12:
        if (this.f470327b == r101.f470327b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f470326a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f470327b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "AIChatAbilityHostState(generation=" + this.f470326a + ", isReady=" + this.f470327b + ')';
    }

    public a(long r100, boolean r101) {
        this.f470326a = r100;
        this.f470327b = r101;
    }
}
