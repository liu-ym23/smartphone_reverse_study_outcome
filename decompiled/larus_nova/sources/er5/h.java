package er5;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f473603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473604b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f473603a == r101.f473603a) goto L12;
        return false;
    L12:
        if (this.f473604b == r101.f473604b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f473603a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f473604b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TenantInfo(isSoloUser=" + this.f473603a + ", isSoloBase=" + this.f473604b + ')';
    }

    public h(boolean r100, boolean r101) {
        this.f473603a = r100;
        this.f473604b = r101;
    }
}
