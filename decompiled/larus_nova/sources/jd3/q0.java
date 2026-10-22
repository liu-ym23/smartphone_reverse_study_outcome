package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498415a;

    public q0() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q0) == true) goto L6;
        return false;
    L6:
        if (this.f498415a == ((q0) r100).f498415a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f498415a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ShowNavBtnMaskEvent(isShowMask=" + this.f498415a + ")";
    }

    public q0(boolean r100) {
        this.f498415a = r100;
    }
}
