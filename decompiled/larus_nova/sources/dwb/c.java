package dwb;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f470402a;

    public c() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f470402a == ((c) r100).f470402a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f470402a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MmRecordingSlotsContentPolicy(disableAiNotes=" + this.f470402a + ')';
    }

    public c(boolean r100) {
        this.f470402a = r100;
    }
}
