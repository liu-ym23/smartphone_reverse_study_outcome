package wh0;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559641a = 0;

    static {
    }

    public static boolean a(Integer r100, Integer r101) {
        if (r101 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
        return false;
    L11:
        if (r100.intValue() != 30) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r101.intValue() != 15) goto L8;
        return true;
    }

    public static boolean b(Integer r100, Integer r101) {
        if (r101 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
        return false;
    L11:
        if (r100.intValue() != 35) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r101.intValue() != 16) goto L8;
        return true;
    }
}
