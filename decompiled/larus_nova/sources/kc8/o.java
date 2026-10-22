package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502536a;

    public o() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L9;
        return false;
    L9:
        if (this.f502536a == ((o) r100).f502536a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f502536a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ContainerVmConfig(enableRoundCorner=" + this.f502536a + ')';
    }

    public o(boolean r100) {
        this.f502536a = r100;
    }
}
