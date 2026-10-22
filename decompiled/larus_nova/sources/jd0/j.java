package jd0;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498202a;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (this.f498202a == ((j) r100).f498202a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f498202a;
    }

    public final String toString() {
        return "RTChorusSentenceEvent(index=" + this.f498202a + ")";
    }

    public j(int r100) {
        this.f498202a = r100;
    }
}
