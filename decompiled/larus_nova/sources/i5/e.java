package i5;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f488264a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f488264a == ((e) r100).f488264a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f488264a;
    }

    public final String toString() {
        return "ProgressChanged(newProgress=" + this.f488264a + ')';
    }

    public e(int r100) {
        this.f488264a = r100;
    }
}
