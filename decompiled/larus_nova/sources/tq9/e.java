package tq9;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547230a;

    public e() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f547230a == ((e) r100).f547230a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f547230a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DocFusionConfig(hit=" + this.f547230a + ')';
    }

    public e(boolean r100) {
        this.f547230a = r100;
    }
}
