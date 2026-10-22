package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571888a;

    public n2() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n2) == true) goto L6;
        return false;
    L6:
        if (this.f571888a == ((n2) r100).f571888a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f571888a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "RechargeDialogShowChangeEvent(isShow=" + this.f571888a + ")";
    }

    public n2(boolean r100) {
        this.f571888a = r100;
    }
}
