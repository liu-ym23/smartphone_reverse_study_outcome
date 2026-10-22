package ie;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f489456a = null;

    static {
        f489456a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r100) {
        byte[] r101 = MessageDigest.getInstance("MD5").digest(r100);     // Catch: Throwable -> L7
        char[] r102 = f489456a;     // Catch: Throwable -> L7
        int r103 = r101.length;     // Catch: Throwable -> L7
        char[] r104 = new char[r103 << 1];     // Catch: Throwable -> L7
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r103) goto L5;
        int r107 = r106 + 1;     // Catch: Throwable -> L7
        byte r108 = r101[r105];     // Catch: Throwable -> L7
        r104[r106] = r102[(r108 & 240) >>> 4];     // Catch: Throwable -> L7
        r106 = r107 + 1;     // Catch: Throwable -> L7
        r104[r107] = r102[r108 & 15];     // Catch: Throwable -> L7
        r105 = r105 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        return new String(r104);
    L7:
        return null;
    }
}
