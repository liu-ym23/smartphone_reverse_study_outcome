package kj3;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503704a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f503704a == ((d) r100).f503704a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f503704a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "StoreAnimationControlEvent(playing=" + this.f503704a + ")";
    }

    public d(boolean r100) {
        this.f503704a = r100;
    }
}
