package sza;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544108a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f544108a == ((e) r100).f544108a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f544108a;
    }

    public final String toString() {
        return "OfficeUrlPreviewRenderConfig(maxWidth=" + this.f544108a + ')';
    }

    public e(int r100) {
        this.f544108a = r100;
    }
}
