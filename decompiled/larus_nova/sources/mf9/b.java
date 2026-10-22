package mf9;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f513651a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f513651a == ((b) r100).f513651a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f513651a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DeepResearchOptions(isPodcastEnable=" + this.f513651a + ')';
    }

    public b(boolean r100) {
        this.f513651a = r100;
    }
}
