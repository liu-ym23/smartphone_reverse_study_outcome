package oo7;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static String a(byte[] r100) {
        String r101 = "";
        if (r100 != null) goto L19;
        return "";
    L19:
        MessageDigest r102 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L16
        r102.update(r100);     // Catch: Throwable -> L16
        byte[] r103 = r102.digest();     // Catch: Throwable -> L16
        if (r103 == null) goto L23;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        int r105 = r103.length;     // Catch: Throwable -> L13
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r104.append(String.format("%02x", new Object[]{Byte.valueOf(r103[r106])}));     // Catch: Throwable -> L13
        r106 = r106 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        r101 = r104.toString();     // Catch: Throwable -> L13
    L24:
        return r101;
    L13:
        th = move-exception;
        k.d("", "bytes2Hex()...error", th);     // Catch: Throwable -> L16
        return "";
    L23:
        return "";
    L16:
        th = move-exception;
        k.d(r101, "sha256()...error", th);
        return r101;
    }
}
