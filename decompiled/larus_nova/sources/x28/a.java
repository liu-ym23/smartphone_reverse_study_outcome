package x28;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static byte[] a(String r100) {
        Charset r101 = Charsets.UTF_8;
        if (r100 != null) goto L5;
        byte[] r102 = null;
    L13:
        return MessageDigest.getInstance("MD5").digest(r102);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        r102 = r100.getBytes(r101);
        goto L13
    }

    public static byte[] b(String r100) {
        Charset r101 = Charsets.UTF_8;
        if (r100 != null) goto L5;
        byte[] r102 = null;
    L13:
        return MessageDigest.getInstance("SHA-1").digest(r102);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        r102 = r100.getBytes(r101);
        goto L13
    }
}
