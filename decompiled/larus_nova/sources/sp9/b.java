package sp9;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542913a = 0;

    static {
    }

    public static boolean a(float r100, float r101) {
        if (Math.abs(r100 - r101) >= 1.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(float r100, float r101) {
        if (r100 > r101) goto L5;
    L7:
        return false;
    L5:
        if (a(r100, r101) == true) goto L7;
        return true;
    }

    public static boolean c(float r100, float r101) {
        if (r100 < r101) goto L5;
    L8:
        return true;
    L5:
        if (a(r100, r101) == true) goto L8;
        return false;
    }

    public static boolean d(float r100, float r101) {
        if (r100 < r101) goto L5;
    L7:
        return false;
    L5:
        if (a(r100, r101) == true) goto L7;
        return true;
    }

    public static boolean e(float r100, float r101) {
        if (r100 > r101) goto L5;
    L8:
        return true;
    L5:
        if (a(r100, r101) == true) goto L8;
        return false;
    }
}
