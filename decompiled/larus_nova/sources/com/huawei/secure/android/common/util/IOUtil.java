package com.huawei.secure.android.common.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes23.dex */
public class IOUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278207a = "IOUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278208b = 4096;

    public IOUtil() {
    }

    public static void close(Cursor r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }

    public static void closeSecure(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void deleteSecure(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        deleteSecure(new PolarisFileWrapper(r100));
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

    public static void closeSecure(InputStream r100) {
        closeSecure(r100);
    }

    public static void deleteSecure(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L8;
        r100.delete();
        return;
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
        return copy(r100, r101, new byte[4096]);
    }

    public static long copy(InputStream r100, OutputStream r101, byte[] r102) throws IOException {
        long r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if ((-1) == r104) goto L6;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
        goto L3
    L6:
        return r103;
    }
}
