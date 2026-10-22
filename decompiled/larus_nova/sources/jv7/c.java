package jv7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static void a(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[32768];
    L3:
        int r103 = r100.read(r102);
        if (r103 < 0) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    }

    public static void b(InputStream r100, byte[] r101, int r102) throws IOException {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = r100.read(r101, 0 + r103, r102 - r103);
        if (r104 == (-1)) goto L8;
        r103 = r103 + r104;
        goto L3
    L8:
        throw new IOException("truncated input stream");
    }
}
