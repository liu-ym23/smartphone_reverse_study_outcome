package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f486763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486764b;

    public s0() {
        this(null, null);
    }

    public final boolean a() {
        Integer r100 = this.f486763a;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        if (r101 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public s0(Integer r100, String r101) {
        this.f486763a = r100;
        this.f486764b = r101;
    }
}
