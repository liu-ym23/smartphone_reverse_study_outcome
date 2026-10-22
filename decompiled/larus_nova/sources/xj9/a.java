package xj9;

import java.util.Calendar;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564110a = 0;

    static {
    }

    public static int a(int r100) {
        if (r100 >= 13) goto L6;
        return 1;
    L6:
        if (r100 >= 18) goto L9;
        return 2;
    L9:
        if (r100 >= 25) goto L12;
        return 3;
    L12:
        if (r100 >= 41) goto L15;
        return 4;
    L15:
        if (r100 >= 61) goto L17;
        return 5;
    L17:
        return 6;
    }

    public static long b(int r100, int r101, int r102) {
        Calendar r103 = Calendar.getInstance();
        r103.set(r100, r101 - 1, r102);
        return r103.getTime().getTime();
    }
}
