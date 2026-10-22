package iv8;

/* JADX INFO: loaded from: classes26.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f495980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495981b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (this.f495980a == r101.f495980a) goto L12;
        return false;
    L12:
        if (this.f495981b == r101.f495981b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f495980a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f495981b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "RemoteInputEnqueueResult(accepted=" + this.f495980a + ", addedUnits=" + this.f495981b + ')';
    }

    public b1(boolean r100, int r101) {
        this.f495980a = r100;
        this.f495981b = r101;
    }
}
