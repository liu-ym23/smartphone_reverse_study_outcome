package n4a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes32.dex */
public final class b5 {
    public static String a(String r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        MessageDigest r101 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L7
        r101.update(f5.j(r100));     // Catch: Throwable -> L7
        byte[] r102 = r101.digest();     // Catch: Throwable -> L7
    L14:
        return f5.s(r102);
    L11:
        th = move-exception;
        n.a(th, "ut", "h2s");
        return null;
    L7:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r102 = new byte[0];
        goto L14
    }
}
