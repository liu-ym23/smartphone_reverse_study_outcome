package com.bytedance.bdp.bdpbase.util;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    public static String a(PolarisFileWrapper r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L16
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        byte[] r103 = new byte[8192];
    L18:
        int r104 = r102.read(r103);     // Catch: Throwable -> L9 IOException -> L11
        if (r104 <= 0) goto L7;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L9 IOException -> L11
        goto L18
    L7:
        String r105 = String.format("%32s", new Object[]{new BigInteger(1, r101.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L9 IOException -> L11
        b(r102);
        return r105;
    L9:
        th = move-exception;
        b(r102);
        throw th;
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to process MD5", e);     // Catch: Throwable -> L9
    L16:
        return null;
    }

    public static void b(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String c(PolarisFileInputStreamWrapper r100) {
        byte[] r101 = m.a();
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L10 Exception -> L13
    L4:
        int r103 = r100.read(r101);     // Catch: Throwable -> L10 Exception -> L13
        if (r103 == (-1)) goto L7;
        r102.write(r101, 0, r103);     // Catch: Throwable -> L10 Exception -> L13
        goto L4
    L7:
        String r104 = r102.toString("UTF-8");     // Catch: Throwable -> L10 Exception -> L13
        m.b(r101);
        return r104;
    L13:
        m.b(r101);
        return "";
    L10:
        th = move-exception;
        m.b(r101);
        throw th;
    }

    public static void d(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isFile() == false) goto L7;
        return;
    L7:
        if (r100.isDirectory() == false) goto L9;
        return;
    L9:
        int r101 = 0;
    L11:
        if (r101 >= 5) goto L18;
        r100.mkdirs();
        if (r100.isDirectory() == true) goto L14;
        Thread.sleep(1);     // Catch: InterruptedException -> L20
    L17:
        r101 = r101 + 1;
        goto L11
    L14:
        return;
    L18:
        r100.isDirectory();
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

    public static byte[] e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L17;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L25;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);     // Catch: IOException -> L19
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: IOException -> L19
        byte[] r104 = m.a();     // Catch: IOException -> L19
    L20:
        int r105 = r102.read(r104);     // Catch: Throwable -> L14
        if (r105 == (-1)) goto L12;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L14
        goto L26
    L12:
        m.b(r104);     // Catch: IOException -> L19
        r102.close();     // Catch: IOException -> L19
        return r103.toByteArray();
    L14:
        th = move-exception;
        m.b(r104);     // Catch: IOException -> L19
        r102.close();     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L26:
        return null;
    L25:
        return null;
    L17:
        return null;
    }

    public static boolean f(String r100, String r101) throws IOException {
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
