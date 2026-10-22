package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486776a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t1) == true) goto L9;
        return false;
    L9:
        if (this.f486776a == ((t1) r100).f486776a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f486776a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ImageGenerateHeicConfig(thumbImageUseHeic=" + this.f486776a + ')';
    }

    public t1(boolean r100) {
        this.f486776a = r100;
    }
}
