package nv3;

/* JADX INFO: loaded from: classes14.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520856a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L9;
        return false;
    L9:
        if (this.f520856a == ((t) r100).f520856a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f520856a;
    }

    public final String toString() {
        return "HuaweiHealthCallbackSource(taskId=" + this.f520856a + ')';
    }

    public t(int r100) {
        this.f520856a = r100;
    }
}
