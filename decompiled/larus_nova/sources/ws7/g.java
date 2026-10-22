package ws7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    public static String a(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = r100.read();     // Catch: IOException -> L9
    L5:
        if (r102 == (-1)) goto L7;
        r101.write(r102);     // Catch: IOException -> L9
        r102 = r100.read();     // Catch: IOException -> L9
        goto L5
    L7:
        return r101.toString();
    L9:
        return "";
    }
}
