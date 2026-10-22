package kqc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static void a(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        r100.getClass();
        r101.getClass();
        int r104 = 0;
        if (r103 < 0) goto L20;
        int r105 = r102 + r103;
        int r106 = r101.length;
        if (r102 < 0) goto L18;
        if (r105 < r102) goto L18;
        if (r105 > r106) goto L18;
    L8:
        if (r104 >= r103) goto L13;
        int r107 = r100.read(r101, r102 + r104, r103 - r104);
        if (r107 == (-1)) goto L13;
        r104 = r104 + r107;
    L13:
        if (r104 != r103) goto L16;
        return;
    L16:
        throw new EOFException("reached end of stream after reading " + r104 + " bytes; " + r103 + " bytes expected");
    L18:
        throw new IndexOutOfBoundsException("" + r102 + "" + r105 + "" + r106);
    L20:
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(r103)}));
    }
}
