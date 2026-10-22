package hq9;

/* JADX INFO: loaded from: classes4.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f486739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486740d;

    public o4() {
        this(false, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r101 = (o4) r100;
        if (this.f486737a == r101.f486737a) goto L12;
        return false;
    L12:
        if (this.f486738b == r101.f486738b) goto L15;
        return false;
    L15:
        if (this.f486739c == r101.f486739c) goto L18;
        return false;
    L18:
        if (this.f486740d == r101.f486740d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f486737a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.f486738b) * 31) + this.f486739c) * 31) + this.f486740d;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SidebarPlatformCaseConfig(enableCase=" + this.f486737a + ", caseSize=" + this.f486738b + ", conversationCaseShowStyle=" + this.f486739c + ", sidebarCaseShowStyle=" + this.f486740d + ')';
    }

    public o4(boolean r100, int r101, int r102, int r103) {
        this.f486737a = r100;
        this.f486738b = r101;
        this.f486739c = r102;
        this.f486740d = r103;
    }
}
