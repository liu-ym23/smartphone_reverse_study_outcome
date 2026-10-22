package com.bytedance.awemeopen.infra.util;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String b(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 Exception -> L12
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L9 Exception -> L12
    L3:
        int r103 = r100.read(r102);     // Catch: Throwable -> L9 Exception -> L12
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L9 Exception -> L12
        goto L3
    L6:
        String r104 = r101.toString("UTF-8");     // Catch: Throwable -> L9 Exception -> L12
        a(r100);
        return r104;
    L12:
        a(r100);
        return "";
    L9:
        th = move-exception;
        a(r100);
        throw th;
    }

    public static byte[] c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L28:
        return null;
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L28;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L22 Throwable -> L26
    L34:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L19 Throwable -> L21
    L32:
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L17 Throwable -> L29
    L11:
        int r104 = r101.read(r103);     // Catch: Throwable -> L17 Throwable -> L29
        if (r104 == (-1)) goto L14;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L17 Throwable -> L29
        goto L11
    L14:
        byte[] r105 = r102.toByteArray();     // Catch: Throwable -> L17 Throwable -> L29
        a(r101);
        a(r102);
        return r105;
    L17:
        Throwable th10 = th;
    L24:
        a(r101);
        a(r102);
        throw th10;
    L27:
        a(r101);
        a(r102);
    L21:
        r102 = null;
    L19:
        th = move-exception;
        th10 = th;
        r102 = null;
    L26:
        r102 = null;
        r101 = null;
    L22:
        th = move-exception;
        r101 = null;
        th10 = th;
        r102 = null;
        goto L24
    }

    public static void delete(File r100) {
        if (r100.isFile() == false) goto L7;
        r100.delete();
        return;
    L7:
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L11;
    L18:
        r100.delete();
        return;
    L11:
        if (r101.length == 0) goto L18;
        int r102 = 0;
    L15:
        if (r102 >= r101.length) goto L17;
        delete(r101[r102]);
        r102 = r102 + 1;
        goto L15
    L17:
        r100.delete();
        return;
    }

    public static boolean d(String r100, String r101) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L9;
        r102.createNewFile();
    L9:
        BufferedWriter r103 = new BufferedWriter(new PolarisFileWriterWrapper(r102));
        r103.write(r101);
        r103.flush();
        r103.close();
        return true;
    }
}
