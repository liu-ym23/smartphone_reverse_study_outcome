package fs9;

/* JADX INFO: loaded from: classes31.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f478681a;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (this.f478681a == ((q) r100).f478681a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f478681a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ProfileBotListEmptyData(isSelfProfileInfo=" + this.f478681a + ')';
    }

    public q(int r100) {
        this.f478681a = true;
    }
}
