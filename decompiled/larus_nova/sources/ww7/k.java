package ww7;

/* JADX INFO: loaded from: classes23.dex */
public final class k {
    public k() {
    }

    public static void b(String r100) {
        if (r100.length() <= 4000) goto L12;
        int r101 = 0;
    L6:
        if (r101 >= r100.length()) goto L16;
        int r102 = r101 + 4000;
        if (r100.length() <= r102) goto L10;
        r100.substring(r101, r102);
    L11:
        r101 = r102;
        goto L6
    L10:
        r100.substring(r101);
        goto L11
    L16:
        return;
    }

    public static void a(String r100) {
        StackTraceElement[] r101 = new Throwable().fillInStackTrace().getStackTrace();
        int r102 = 2;
    L4:
        if (r102 >= r101.length) goto L9;
        if (r101[r102].getClass().equals(k.class) == false) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        String r103 = r101[r102].getClassName();
        r103.substring(r103.lastIndexOf(46) + 1);
    L9:
        b(r100);
    }
}
