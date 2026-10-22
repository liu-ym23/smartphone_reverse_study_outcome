package d10;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f466250a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (this.f466250a == ((e) r100).f466250a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f466250a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "MultiLinkGameStartEvent(targetUiLayout=" + this.f466250a + ")";
    }

    public e() {
        this(0);
    }

    public e(long r100) {
        this.f466250a = r100;
    }
}
