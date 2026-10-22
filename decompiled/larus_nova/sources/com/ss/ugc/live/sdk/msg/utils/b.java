package com.ss.ugc.live.sdk.msg.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static byte[] a(byte[] r100) throws Exception {
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        GZIPInputStream r103 = new GZIPInputStream(r101);
        byte[] r104 = new byte[4096];
    L3:
        int r105 = r103.read(r104, 0, 4096);
        if (r105 == (-1)) goto L6;
        r102.write(r104, 0, r105);
        goto L3
    L6:
        r103.close();
        byte[] r106 = r102.toByteArray();
        r102.flush();
        r102.close();
        r101.close();
        return r106;
    }
}
