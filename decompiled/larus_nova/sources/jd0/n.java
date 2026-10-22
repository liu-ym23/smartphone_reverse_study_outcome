package jd0;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498207a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == true) goto L6;
        return false;
    L6:
        if (this.f498207a == ((n) r100).f498207a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f498207a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "VoiceTalkApplyVerifyModeChangeEvent(needVerify=" + this.f498207a + ")";
    }

    public n(boolean r100) {
        this.f498207a = r100;
    }
}
