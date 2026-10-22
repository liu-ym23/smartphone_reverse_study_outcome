package bp3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (this.a == ((b) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "FollowStatusChangeEvent(status=" + this.a + ")";
    }

    public b(int r1) {
        this.a = r1;
    }
}
