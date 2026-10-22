package y6a;

/* JADX INFO: loaded from: classes32.dex */
public final class l {
    public l() {
    }

    public static boolean a(float r100) {
        if (Float.compare(r100, 1.0E9f) < 0) goto L5;
    L8:
        return true;
    L5:
        if (Float.compare(r100, -1.0E9f) <= 0) goto L8;
        return false;
    }
}
