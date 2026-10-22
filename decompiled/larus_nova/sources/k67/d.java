package k67;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f501969a = null;

    public d() {
    }

    static {
        f501969a = d.class.getSimpleName();
    }

    public static String a(String r100) {
        byte[] r101 = r100.getBytes(StandardCharsets.UTF_8);
        MessageDigest r102 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L5
        r102.update(r101);     // Catch: Exception -> L5
        byte[] r103 = r102.digest();     // Catch: Exception -> L5
    L6:
        StringBuilder r104 = new StringBuilder();
        int r105 = r103.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L10;
        r104.append(String.format("%02x", new Object[]{Byte.valueOf(r103[r106])}));
        r106 = r106 + 1;
        goto L7
    L10:
        return r104.toString();
    L5:
        b.c(f501969a, "SHA256 failed.");
        r103 = new byte[0];
        goto L6
    }
}
