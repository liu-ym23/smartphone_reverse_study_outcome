package el1;

import o70.b;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f473004a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f473004a == ((a) r100).f473004a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f473004a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "SeekbarSlideEvent(slide=" + this.f473004a + ")";
    }

    public a(boolean r100) {
        this.f473004a = r100;
    }
}
