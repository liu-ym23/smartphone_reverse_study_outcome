package kza;

/* JADX INFO: loaded from: classes34.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506821a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L9;
        return false;
    L9:
        if (this.f506821a == ((s) r100).f506821a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f506821a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "OpenFeishuMediaSecurityCheckResult(allowed=" + this.f506821a + ')';
    }

    public s(boolean r100) {
        this.f506821a = r100;
    }
}
