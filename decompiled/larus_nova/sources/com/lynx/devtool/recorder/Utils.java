package com.lynx.devtool.recorder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes32.dex */
public class Utils {
    public Utils() {
    }

    public static byte[] inputStreamToByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[1024];
    L3:
        int r103 = r100.read(r102, 0, 1024);
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r101.flush();
        return r101.toByteArray();
    }
}
