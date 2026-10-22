package com.bytedance.push.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes21.dex */
public final class o {
    public static String a(byte[] r100) {
        Inflater r101 = new Inflater();
        r101.reset();
        r101.setInput(r100, 0, r100.length);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(r100.length);
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r101.finished() == true) goto L7;
        r102.write(r103, 0, r101.inflate(r103));     // Catch: Throwable -> L9 Exception -> L11
        goto L5
    L7:
        r100 = r102.toByteArray();     // Catch: Throwable -> L9 Exception -> L11
    L28:
        r102.close();     // Catch: IOException -> L15
    L17:
        r101.end();
        return new String(r100);
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r102.close();     // Catch: IOException -> L21
    L23:
        throw th;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }
}
