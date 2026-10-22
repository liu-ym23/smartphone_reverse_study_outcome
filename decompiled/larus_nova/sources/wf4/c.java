package wf4;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f559473b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f559472a == r101.f559472a) goto L8;
        return false;
    L8:
        if (this.f559473b == r101.f559473b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f559472a * 31) + this.f559473b;
    }

    public final String toString() {
        return "Size(width=" + this.f559472a + ", height=" + this.f559473b + ")";
    }

    public c(int r100) {
        this.f559472a = -1;
        this.f559473b = -1;
    }
}
