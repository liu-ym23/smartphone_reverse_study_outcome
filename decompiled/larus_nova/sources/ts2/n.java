package ts2;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547357a;

    public n() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == true) goto L6;
        return false;
    L6:
        if (this.f547357a == ((n) r100).f547357a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f547357a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "OnRoomVisibleData(isRoomVisible=" + this.f547357a + ")";
    }

    public n(boolean r100) {
        this.f547357a = r100;
    }
}
