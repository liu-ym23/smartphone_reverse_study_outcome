package o87;

/* JADX INFO: loaded from: classes21.dex */
public final class b<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f522386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f522387b;

    public final int hashCode() {
        A r100 = this.f522386a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        B r104 = this.f522387b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (b.class == r100.getClass()) goto L11;
        return false;
    L11:
        b r101 = (b) r100;
        A r102 = this.f522386a;
        if (r102 != null) goto L17;
        if (r101.f522386a == null) goto L19;
        return false;
    L19:
        B r103 = this.f522387b;
        if (r103 != null) goto L25;
        if (r101.f522387b == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r103.equals(r101.f522387b) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f522386a) == true) goto L19;
        return false;
    }

    public b(A r100, B r101) {
        this.f522386a = r100;
        this.f522387b = r101;
    }
}
