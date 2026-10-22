package nv3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t) == true) goto L9;
        return false;
    L9:
        if (this.a == ((t) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "HuaweiHealthCallbackSource(taskId=" + this.a + ')';
    }

    public t(int r1) {
        this.a = r1;
    }
}
