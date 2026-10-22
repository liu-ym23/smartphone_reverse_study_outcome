package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571862a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (this.f571862a == ((j) r100).f571862a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f571862a;
    }

    public final String toString() {
        return "AudienceInteractChangedEvent(state=" + this.f571862a + ")";
    }

    public j(int r100) {
        this.f571862a = r100;
    }
}
