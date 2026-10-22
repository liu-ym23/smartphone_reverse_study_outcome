package u10;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes45.dex */
public final class d {
    public static final byte[] a(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        if (r100 == null) goto L10;
        byte[] r102 = new byte[4096];
    L5:
        int r103 = r100.read(r102);
        if (r103 == (-1)) goto L10;
        r101.write(r102, 0, r103);
    L10:
        return r101.toByteArray();
    }
}
