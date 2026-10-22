package com.huawei.secure.android.common.ssl.util;

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
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278186a = "IOUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278187b = 4096;

    public d() {
    }

    public static void a(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.delete() == true) goto L11;
        e.b(f278186a, "deleteSecure exception");
        return;
    }

    public static byte[] b(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        a(r100, r101);
        return r101.toByteArray();
    }

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        a(new PolarisFileWrapper(r100));
        return;
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e.b(f278186a, "closeSecure IOException");
        return;
    }

    public static InputStream a(byte[] r100) throws IOException {
        return new ByteArrayInputStream(r100);
    }

    public static void a(Cursor r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }

    public static void a(InputStream r100) {
        a(r100);
    }

    public static void a(OutputStream r100) {
        a(r100);
    }

    public static void a(Reader r100) {
        a(r100);
    }

    public static void a(Writer r100) {
        a(r100);
    }

    public static long a(InputStream r100, OutputStream r101) throws IOException {
        return a(r100, r101, new byte[4096]);
    }

    public static long a(InputStream r100, OutputStream r101, byte[] r102) throws IOException {
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
