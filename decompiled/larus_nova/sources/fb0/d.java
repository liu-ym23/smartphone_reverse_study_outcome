package fb0;

import android.os.Build;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f476209a = null;

    static {
        f476209a = new long[256];
        String r100 = Build.TYPE;
        if (r100.equals("eng") == true) goto L5;
        r100.equals("userdebug");
    L5:
        int r101 = 0;
    L6:
        if (r101 >= 256) goto L16;
        long r102 = r101;
        int r103 = 0;
    L9:
        if (r103 >= 8) goto L15;
        if ((((int) r102) & 1) == 0) goto L13;
        long r104 = -7661587058870466123L;
    L14:
        r102 = (r102 >> 1) ^ r104;
        r103 = r103 + 1;
        goto L9
    L13:
        r104 = 0;
        goto L14
    L15:
        f476209a[r101] = r102;
        r101 = r101 + 1;
        goto L6
    }

    public static int a(int r100) {
        if (r100 <= 0) goto L8;
        if (r100 > 1073741824) goto L8;
        int r101 = r100 - 1;
        int r102 = r101 | (r101 >> 16);
        int r103 = r102 | (r102 >> 8);
        int r104 = r103 | (r103 >> 4);
        int r105 = r104 | (r104 >> 2);
        return (r105 | (r105 >> 1)) + 1;
    L8:
        throw new IllegalArgumentException("n is invalid: " + r100);
    }
}
