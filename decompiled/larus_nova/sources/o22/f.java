package o22;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f521780a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (this.f521780a == ((f) r100).f521780a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f521780a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ShowCarnivalTrayContentEvent(show=" + this.f521780a + ")";
    }

    public f(boolean r100) {
        this.f521780a = r100;
    }
}
