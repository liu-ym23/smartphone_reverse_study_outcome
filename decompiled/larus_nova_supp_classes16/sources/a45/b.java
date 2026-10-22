package a45;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements a {
    public int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "TipsItem(count=" + this.a + ')';
    }

    @Override // a45.a
    public final int type() {
        return 1;
    }
}
