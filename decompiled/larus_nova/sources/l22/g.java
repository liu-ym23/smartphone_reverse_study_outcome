package l22;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f507109a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (this.f507109a == ((g) r100).f507109a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f507109a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ShowBubbleEvent(openSettingDialog=" + this.f507109a + ")";
    }

    public g() {
        this.f507109a = false;
    }
}
