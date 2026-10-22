package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571943a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t1) == true) goto L6;
        return false;
    L6:
        if (this.f571943a == ((t1) r100).f571943a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f571943a;
    }

    public final String toString() {
        return "MiniGameStatusEvent(state=" + this.f571943a + ")";
    }

    public t1(int r100) {
        this.f571943a = r100;
    }
}
