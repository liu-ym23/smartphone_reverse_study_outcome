package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486525c;

    public a0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f486523a == r101.f486523a) goto L12;
        return false;
    L12:
        if (this.f486524b == r101.f486524b) goto L15;
        return false;
    L15:
        if (this.f486525c == r101.f486525c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486523a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486524b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486525c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicExperienceFeatureConfig(enableEnterpriseColdStartNewTask=" + this.f486523a + ", mainConversationDowngradeExperimentEnabled=" + this.f486524b + ", enableNewWorkTaskButtonThemeColorInversion=" + this.f486525c + ')';
    }

    public /* synthetic */ a0(int r100) {
        this(true, false, false);
    }

    public a0(boolean r100, boolean r101, boolean r102) {
        this.f486523a = r100;
        this.f486524b = r101;
        this.f486525c = r102;
    }
}
