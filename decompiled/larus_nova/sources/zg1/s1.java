package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571936a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s1) == true) goto L6;
        return false;
    L6:
        if (this.f571936a == ((s1) r100).f571936a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f571936a;
    }

    public final String toString() {
        return "MiniAppStatusEvent(state=" + this.f571936a + ")";
    }

    public s1(int r100) {
        this.f571936a = r100;
    }
}
