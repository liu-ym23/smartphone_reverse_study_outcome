package kq9;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f505654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f505655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505656c;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f505654a == r101.f505654a) goto L12;
        return false;
    L12:
        if (this.f505655b == r101.f505655b) goto L15;
        return false;
    L15:
        if (this.f505656c == r101.f505656c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f505654a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f505655b == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f505656c;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastSendImageConfig(enableMainBot=" + this.f505654a + ", enableOtherBot=" + this.f505655b + ", albumSpanCount=" + this.f505656c + ')';
    }

    public /* synthetic */ p(int r100) {
        this(false, false, 3);
    }

    public p(boolean r100, boolean r101, int r102) {
        this.f505654a = r100;
        this.f505655b = r101;
        this.f505656c = r102;
    }
}
