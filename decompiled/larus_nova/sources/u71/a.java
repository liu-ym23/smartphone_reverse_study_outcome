package u71;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f549033a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f549033a == ((a) r100).f549033a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f549033a;
    }

    public final String toString() {
        return "CommonCardCycleDisplayEvent(cardType=" + this.f549033a + ")";
    }

    public a(int r100) {
        this.f549033a = r100;
    }
}
