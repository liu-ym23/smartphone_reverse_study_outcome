package kb1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: kb1.a$a, reason: collision with other inner class name */
    public static final class C6528a {
    }

    static {
    }

    public a() {
    }

    public final rjc.a a(int r100, int r101, int r102, int r103) {
        float r104 = r103 / r102;
        float r105 = r100;
        float r106 = r105 * r104;
        if (r104 > 1.3333334f) goto L7;
        return new rjc.a(0.0f, (r101 - r106) / 2.0f, r105, r106);
    L7:
        return new rjc.a(0.0f, 0.0f, r105, r101);
    }
}
