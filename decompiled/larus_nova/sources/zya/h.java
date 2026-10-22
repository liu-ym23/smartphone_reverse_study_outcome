package zya;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f574003b;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f574003b == ((h) r100).f574003b) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f574003b;
    }

    public final String toString() {
        return "SpaceMessageActionItem(height=" + this.f574003b + ')';
    }

    public h(int r100) {
        super(4);
        this.f574003b = 12;
    }
}
