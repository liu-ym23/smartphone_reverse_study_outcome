package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571848a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.f571848a == ((i) r100).f571848a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f571848a;
    }

    public final String toString() {
        return "AppLifecycleEvent(state=" + this.f571848a + ")";
    }

    public i(int r100) {
        this.f571848a = r100;
    }
}
