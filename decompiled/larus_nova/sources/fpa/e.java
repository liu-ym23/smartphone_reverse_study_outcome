package fpa;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    public static int a(InputStream r100, byte[] r101, int r102) throws IOException {
        int r103 = 0;
    L3:
        int r104 = r100.read(r101, 0 + r103, r102 - r103);
        if (r104 == (-1)) goto L5;
        r103 = r103 + r104;
        if (r103 < r102) goto L3;
        return r103;
    L5:
        if (r103 != 0) goto L14;
        return -1;
    L14:
        return r103;
    }
}
