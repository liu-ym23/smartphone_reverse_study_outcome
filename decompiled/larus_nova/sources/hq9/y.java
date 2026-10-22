package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486821d;

    public y() {
        this(true, true, true, true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f486818a == r101.f486818a) goto L12;
        return false;
    L12:
        if (this.f486819b == r101.f486819b) goto L15;
        return false;
    L15:
        if (this.f486820c == r101.f486820c) goto L18;
        return false;
    L18:
        if (this.f486821d == r101.f486821d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486818a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486819b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486820c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486821d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicExperienceBugFixConfig(fullScreenEditFragmentContainerViewFix=" + this.f486818a + ", messageInputFocusFix=" + this.f486819b + ", lowVersionImeInsetsCompatFix=" + this.f486820c + ", selectTextReferenceProtocolFix=" + this.f486821d + ')';
    }

    public y(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f486818a = r100;
        this.f486819b = r101;
        this.f486820c = r102;
        this.f486821d = r103;
    }
}
