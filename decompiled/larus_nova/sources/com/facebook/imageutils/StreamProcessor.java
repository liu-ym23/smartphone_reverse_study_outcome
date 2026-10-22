package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
class StreamProcessor {
    public StreamProcessor() {
    }

    public static int readPackedInt(InputStream r100, int r101, boolean r102) throws IOException {
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r101) goto L12;
        int r105 = r100.read();
        if (r105 == (-1)) goto L11;
        if (r102 == false) goto L8;
        int r106 = (r105 & 255) << (r103 * 8);
    L9:
        r104 = r104 | r106;
        r103 = r103 + 1;
        goto L3
    L8:
        r104 = r104 << 8;
        r106 = r105 & 255;
        goto L9
    L11:
        throw new IOException("no more bytes");
    L12:
        return r104;
    }
}
