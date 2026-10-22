package mqc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f514949a = null;

    static {
        f514949a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L5;
    L11:
        byte[] r101 = null;
    L12:
        if (r101 == null) goto L25;
        int r102 = r101.length;
        if (r102 <= 0) goto L26;
        char[] r103 = new char[r102 << 1];
        int r104 = 0;
        int r105 = 0;
    L18:
        if (r104 >= r102) goto L21;
        int r106 = r105 + 1;
        char[] r107 = f514949a;
        byte r108 = r101[r104];
        r103[r105] = r107[(r108 >>> 4) & 15];
        r105 = r106 + 1;
        r103[r106] = r107[r108 & 15];
        r104 = r104 + 1;
        goto L18
    L21:
        return new String(r103);
    L26:
        return null;
    L25:
        return null;
    L5:
        if (r100.length <= 0) goto L11;
        MessageDigest r109 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
        r109.update(r100);     // Catch: NoSuchAlgorithmException -> L9
        r101 = r109.digest();     // Catch: NoSuchAlgorithmException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
