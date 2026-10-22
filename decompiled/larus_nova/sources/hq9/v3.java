package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f486796a;

    public v3() {
        this(2);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v3) == true) goto L9;
        return false;
    L9:
        if (this.f486796a == ((v3) r100).f486796a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f486796a;
    }

    public final String toString() {
        return "ProgressLoadingStyleData(loadingStyle=" + this.f486796a + ')';
    }

    public v3(int r100) {
        this.f486796a = r100;
    }
}
