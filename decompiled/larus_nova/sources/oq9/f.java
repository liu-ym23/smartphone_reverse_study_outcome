package oq9;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f524904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f524906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f524907d;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f524904a == r101.f524904a) goto L12;
        return false;
    L12:
        if (this.f524905b == r101.f524905b) goto L15;
        return false;
    L15:
        if (this.f524906c == r101.f524906c) goto L18;
        return false;
    L18:
        if (this.f524907d == r101.f524907d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f524904a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f524905b) * 31;
        if (this.f524906c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f524907d;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraRecordFeatureConfig(enableTips=" + this.f524904a + ", recordMaxDuration=" + this.f524905b + ", enablePreviewRatio3to4=" + this.f524906c + ", longPressDurationMs=" + this.f524907d + ')';
    }

    public /* synthetic */ f(int r100) {
        this(false, 60, false, 300);
    }

    public f(boolean r100, int r101, boolean r102, int r103) {
        this.f524904a = r100;
        this.f524905b = r101;
        this.f524906c = r102;
        this.f524907d = r103;
    }
}
