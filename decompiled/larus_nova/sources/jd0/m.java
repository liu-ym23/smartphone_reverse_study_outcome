package jd0;

/* JADX INFO: loaded from: classes46.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498206a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == true) goto L6;
        return false;
    L6:
        if (this.f498206a == ((m) r100).f498206a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f498206a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "VideoTalkApplyVerifyModeChangeEvent(needVerify=" + this.f498206a + ")";
    }

    public m(boolean r100) {
        this.f498206a = r100;
    }
}
