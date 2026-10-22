package com.larksuite.framework.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes24.dex */
public final class e0 {
    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.length > 0) goto L6;
        return null;
    L6:
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() >= 2) goto L12;
        r101.append(0);
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L14:
        return r101.toString();
    }

    public static final byte[] b(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[100];
    L3:
        int r103 = r100.read(r102, 0, 100);
        if (r103 <= 0) goto L7;
        r101.write(r102, 0, r103);
        goto L3
    L7:
        return r101.toByteArray();
    }
}
