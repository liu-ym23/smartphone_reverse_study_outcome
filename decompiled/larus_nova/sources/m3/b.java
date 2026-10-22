package m3;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511688a;

    public b() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f511688a == ((b) r100).f511688a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f511688a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoubaoBottomSheetBehavior(dismissOnMaskTap=" + this.f511688a + ')';
    }

    public b(boolean r100) {
        this.f511688a = r100;
    }
}
