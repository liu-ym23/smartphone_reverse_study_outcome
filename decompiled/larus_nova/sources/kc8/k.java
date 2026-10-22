package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f502517a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (this.f502517a == ((k) r100).f502517a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f502517a;
    }

    public final String toString() {
        return "CodeArtifactUIConfig(rootBackgroundRes=" + this.f502517a + ')';
    }

    public k(int r100) {
        this.f502517a = r100;
    }
}
