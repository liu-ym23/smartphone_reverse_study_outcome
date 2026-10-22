package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes23.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        HMSLog.e("IOUtils", "An exception occurred while closing the 'Closeable' object.");
        return;
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static InputStream toInputStream(byte[] r100) throws IOException {
        return new ByteArrayInputStream(r100);
    }

    public static void closeQuietly(InputStream r100) {
        closeQuietly(r100);
    }

    public static void closeQuietly(OutputStream r100) {
        closeQuietly(r100);
    }

    public static void closeQuietly(Reader r100) {
        closeQuietly(r100);
    }

    public static void closeQuietly(Writer r100) {
        closeQuietly(r100);
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        return copy(r100, r101, new byte[4096]);
    }

    public static long copy(InputStream r100, OutputStream r101, byte[] r102) throws IOException {
        long r103 = 0;
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        if (r102 != null) goto L8;
        r102 = new byte[4096];
    L8:
        int r104 = r100.read(r102);
        if ((-1) == r104) goto L11;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
    L11:
        return r103;
    }
}
