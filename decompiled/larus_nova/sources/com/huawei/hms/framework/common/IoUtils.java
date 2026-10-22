package com.huawei.hms.framework.common;

import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes23.dex */
public class IoUtils {
    private static final int BUFF_SIZE = 4096;
    private static final int MAX_SIZE = 16777216;

    private IoUtils() {
    }

    public static void close(Cursor r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }

    public static void closeSecure(Closeable r100) {
        if (r100 != null) goto L10;
        Logger.w("IOUtil", "closeable is null");
        return;
    L10:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Logger.w("IOUtil", "closeSecure IOException", e);
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static void closeSecure(InputStream r100) {
        closeSecure(r100);
    }

    public static void closeSecure(OutputStream r100) {
        closeSecure(r100);
    }

    public static void closeSecure(Reader r100) {
        closeSecure(r100);
    }

    public static void closeSecure(Writer r100) {
        closeSecure(r100);
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        if (ContextHolder.getAppContext() == null) goto L5;
        String r102 = ContextHolder.getAppContext().getPackageName();
    L6:
        byte[] r103 = new byte[4096];
        long r104 = 0;
    L7:
        int r105 = r100.read(r103);
        if ((-1) == r105) goto L17;
        if (r104 <= 16777216) goto L16;
        if ("com.huawei.health".equals(r102) == true) goto L16;
        throw new IOException("input data too large for byte.");
    L16:
        r101.write(r103, 0, r105);
        r104 = r104 + ((long) r105);
        goto L7
    L17:
        return r104;
    L5:
        r102 = "";
        goto L6
    }
}
