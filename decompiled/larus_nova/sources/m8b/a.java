package m8b;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f512538a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f512538a == ((a) r100).f512538a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f512538a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DeviceCertInfo(needCertVerify=" + this.f512538a + ')';
    }

    public a(boolean r100) {
        this.f512538a = r100;
    }
}
