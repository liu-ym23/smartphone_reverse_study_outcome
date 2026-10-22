package ek4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import pk4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f472939a = null;

    static {
        f472939a = "0123456789abcdef".toCharArray();
    }

    public static boolean a(String r100) {
        String r101 = c.a.f529617a.a();
        if (r101 != null) goto L5;
    L9:
        String r102 = "";
    L11:
        return r102.equals(r100);
    L5:
        if (r101.isEmpty() == true) goto L9;
        r102 = r101.trim();
        if (r102.isEmpty() == false) goto L11;
        goto L9
    }

    public static String b(String r100) {
        if (r100 != null) goto L4;
    L8:
        String r101 = "";
    L10:
        if (r101.isEmpty() == false) goto L13;
        return "anonymous_scope";
    L13:
        StringBuilder r102 = new StringBuilder("uid_");
        byte[] r103 = MessageDigest.getInstance("SHA-256").digest(r101.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L21
        StringBuilder r104 = new StringBuilder(16);     // Catch: NoSuchAlgorithmException -> L21
        int r105 = 0;
    L16:
        if (r105 >= 8) goto L18;
        int r106 = r103[r105] & UByte.MAX_VALUE;     // Catch: NoSuchAlgorithmException -> L21
        char[] r107 = f472939a;     // Catch: NoSuchAlgorithmException -> L21
        r104.append(r107[r106 >>> 4]);     // Catch: NoSuchAlgorithmException -> L21
        r104.append(r107[r106 & 15]);     // Catch: NoSuchAlgorithmException -> L21
        r105 = r105 + 1;     // Catch: NoSuchAlgorithmException -> L21
        goto L16
    L18:
        r102.append(r104.toString());
        return r102.toString();
    L21:
        e = move-exception;
        throw new IllegalStateException("Build offline user scope key failed", e);
    L4:
        if (r100.isEmpty() == true) goto L8;
        r101 = r100.trim();
        if (r101.isEmpty() == false) goto L10;
        goto L8
    }
}
