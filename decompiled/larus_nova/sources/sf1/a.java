package sf1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f541724a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f541724a == ((a) r100).f541724a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f541724a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "CeremonyEffectPlayEvent(effectId=" + this.f541724a + ")";
    }

    public a(long r100) {
        this.f541724a = r100;
    }
}
