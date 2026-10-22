package dr9;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469789a;

    public d() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.f469789a == ((d) r100).f469789a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f469789a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MediaInputHostPolicy(mobilePreviewEnabled=" + this.f469789a + ')';
    }

    public d(boolean r100) {
        this.f469789a = r100;
    }
}
