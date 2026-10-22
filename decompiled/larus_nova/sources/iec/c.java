package iec;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489513a;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f489513a == ((c) r100).f489513a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f489513a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "CodeBlockV2DigestParams(showDigest=" + this.f489513a + ')';
    }

    public c(int r100) {
        this.f489513a = true;
    }
}
