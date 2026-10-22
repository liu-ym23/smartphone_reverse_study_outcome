package hq9;

/* JADX INFO: loaded from: classes4.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f486826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486827b;

    public z4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z4) == true) goto L8;
        return false;
    L8:
        z4 r101 = (z4) r100;
        if (this.f486826a == r101.f486826a) goto L12;
        return false;
    L12:
        if (this.f486827b == r101.f486827b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f486826a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f486827b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "VibrateConfig(vibrateDuration=" + this.f486826a + ", extraFeedbackEnable=" + this.f486827b + ')';
    }

    public /* synthetic */ z4(int r100) {
        this(20, false);
    }

    public z4(long r100, boolean r101) {
        this.f486826a = r100;
        this.f486827b = r101;
    }
}
