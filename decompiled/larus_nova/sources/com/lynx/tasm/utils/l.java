package com.lynx.tasm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class l {
    public static byte[] a(InputStream r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[4096];
    L13:
        int r103 = r100.read(r102, 0, 4096);     // Catch: IOException -> L12
        if (r103 == (-1)) goto L10;
        r101.write(r102, 0, r103);     // Catch: IOException -> L12
        goto L13
    L10:
        return r101.toByteArray();
    L12:
        return null;
    }
}
