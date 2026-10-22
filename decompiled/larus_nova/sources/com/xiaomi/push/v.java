package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes41.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f464369a = null;

    static {
        f464369a = new String[]{"jpg", LoadParams.ImageFormat.PNG, "bmp", "gif", "webp"};
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0062: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:16777314), block:B:22:0x0062 */
    public static String a(File r100) {
        StringWriter r101 = new StringWriter();
        Closeable r102 = null;
        InputStreamReader r103 = new InputStreamReader(new BufferedInputStream(new PolarisFileInputStreamWrapper(r100)));     // Catch: Throwable -> L14 IOException -> L16
    L26:
        char[] r104 = new char[2048];     // Catch: IOException -> L12 Throwable -> L21
    L6:
        int r105 = r103.read(r104);     // Catch: IOException -> L12 Throwable -> L21
        if (r105 == (-1)) goto L9;
        r101.write(r104, 0, r105);     // Catch: IOException -> L12 Throwable -> L21
        goto L6
    L9:
        String r106 = r101.toString();     // Catch: IOException -> L12 Throwable -> L21
        a(r103);
        a(r101);
        return r106;
    L12:
        e = e;
    L18:
        com.xiaomi.channel.commonutils.logger.b.c("read file :" + r100.getAbsolutePath() + " failure :" + e.getMessage());     // Catch: Throwable -> L21
        a(r103);
        a(r101);
        return null;
    L21:
        th = th;
        r102 = r2;
    L23:
        a(r102);
        a(r101);
        throw th;
    L16:
        e = e;
        r103 = null;
    L14:
        th = th;
        goto L23
    }

    public static byte[] a(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
    L18:
        int r103 = r100.read(r102, 0, 8192);     // Catch: Throwable -> L10 Exception -> L12
        if (r103 <= 0) goto L7;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L10 Exception -> L12
        goto L18
    L7:
        byte[] r104 = r101.toByteArray();     // Catch: Throwable -> L10 Exception -> L12
        a(r100);
        a(r101);
        return r104;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        a(r100);
        a(r101);
        return null;
    L10:
        th = move-exception;
        a(r100);
        a(r101);
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9433a(File r100) {
    L17:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (r100.isDirectory() == false) goto L7;
        return false;
    L7:
        if (r100.exists() == false) goto L10;
        return true;
    L10:
        File r101 = r100.getParentFile();     // Catch: Throwable -> L17
        if (r101.exists() == false) goto L13;
    L15:
        return r100.createNewFile();
    L13:
        if (r101.mkdirs() == true) goto L15;
        return false;
    }

    public static byte[] a(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L5
        GZIPOutputStream r102 = new GZIPOutputStream(r101);     // Catch: Exception -> L5
        r102.write(r100);     // Catch: Exception -> L5
        r102.finish();     // Catch: Exception -> L5
        r102.close();     // Catch: Exception -> L5
        byte[] r103 = r101.toByteArray();     // Catch: Exception -> L5
        r101.close();     // Catch: Exception -> L5
        return r103;
    L8:
        return r100;
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public static void a(File r100, String r101) {
        if (r100.exists() == true) goto L5;
        com.xiaomi.channel.commonutils.logger.b.c("mkdir " + r100.getAbsolutePath());
        r100.getParentFile().mkdirs();
    L5:
        BufferedWriter r102 = null;
        BufferedWriter r103 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r100)));     // Catch: Throwable -> L13 IOException -> L15
        r103.write(r101);     // Catch: Throwable -> L9 IOException -> L11
        a(r103);
    L21:
        return;
    L11:
        e = e;
        r102 = r103;
    L16:
        com.xiaomi.channel.commonutils.logger.b.c("write file :" + r100.getAbsolutePath() + " failure :" + e.getMessage());     // Catch: Throwable -> L13
        a(r102);
    L9:
        th = th;
        r102 = r103;
    L19:
        a(r102);
        throw th;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    public static void b(File r100, File r101) {
        if (r100.getAbsolutePath().equals(r101.getAbsolutePath()) == false) goto L5;
        return;
    L5:
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L21
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L18
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L16
    L10:
        int r106 = r103.read(r105);     // Catch: Throwable -> L16
        if (r106 < 0) goto L14;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L16
        goto L10
    L14:
        r103.close();
        r104.close();
        return;
    L16:
        th = th;
    L20:
        r102 = r103;
    L23:
        if (r102 == null) goto L25;
        r102.close();
    L25:
        if (r104 == null) goto L27;
        r104.close();
    L27:
        throw th;
    L18:
        th = th;
        r104 = null;
    L21:
        th = th;
        r104 = null;
        goto L23
    }

    public static void a(File r100, File r101) {
        ZipOutputStream r102 = null;
        ZipOutputStream r103 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r100, false));     // Catch: Throwable -> L11 IOException -> L13 FileNotFoundException -> L20
        goto L18
    L25:
        a(r103, r101, null, null);     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L10
        a(r103);
    L21:
        return;
    L10:
        r102 = r103;
    L8:
        e = e;
        r102 = r103;
    L14:
        com.xiaomi.channel.commonutils.logger.b.m8718a("zip file failure + " + e.getMessage());     // Catch: Throwable -> L11
    L6:
        th = th;
        r102 = r103;
    L16:
        a(r102);
        throw th;
    L11:
        th = th;
    L13:
        e = e;
    L18:
        a(r102);
        goto L21
    }

    public static void a(ZipOutputStream r100, File r101, String r102, FileFilter r110) {
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        PolarisFileInputStreamWrapper r104 = null;
        int r105 = 0;
        if (r101.isDirectory() == false) goto L25;
        if (r110 == null) goto L10;
        File[] r106 = r101.listFiles(r110);     // Catch: Throwable -> L40 IOException -> L42
    L11:
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L40 IOException -> L42
        r107.append(r102);     // Catch: Throwable -> L40 IOException -> L42
        String r108 = File.separator;     // Catch: Throwable -> L40 IOException -> L42
        r107.append(r108);     // Catch: Throwable -> L40 IOException -> L42
        r100.putNextEntry(new ZipEntry(r107.toString()));     // Catch: Throwable -> L40 IOException -> L42
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r103 = r102 + r108;     // Catch: Throwable -> L40 IOException -> L42
    L15:
        int r109 = 0;
    L17:
        if (r109 >= r106.length) goto L19;
        a(r100, r106[r109], r103 + r106[r109].getName(), null);     // Catch: Throwable -> L40 IOException -> L42
        r109 = r109 + 1;     // Catch: Throwable -> L40 IOException -> L42
        goto L17
    L19:
        File[] r111 = r101.listFiles(new AnonymousClass1());     // Catch: Throwable -> L40 IOException -> L42
        if (r111 == null) goto L44;
        int r112 = r111.length;     // Catch: Throwable -> L40 IOException -> L42
    L22:
        if (r105 >= r112) goto L44;
        File r113 = r111[r105];     // Catch: Throwable -> L40 IOException -> L42
        a(r100, r113, r103 + File.separator + r113.getName(), r110);     // Catch: Throwable -> L40 IOException -> L42
        r105 = r105 + 1;     // Catch: Throwable -> L40 IOException -> L42
    L44:
        a(r104);
        return;
    L10:
        r106 = r101.listFiles();     // Catch: Throwable -> L40 IOException -> L42
        goto L11
    L25:
        if (TextUtils.isEmpty(r102) == true) goto L27;
        r100.putNextEntry(new ZipEntry(r102));     // Catch: Throwable -> L40 IOException -> L42
    L28:
        PolarisFileInputStreamWrapper r114 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L40 IOException -> L42
        byte[] r115 = new byte[1024];     // Catch: Throwable -> L36 IOException -> L38
    L31:
        int r116 = r114.read(r115);     // Catch: Throwable -> L36 IOException -> L38
        if (r116 == (-1)) goto L35;
        r100.write(r115, 0, r116);     // Catch: Throwable -> L36 IOException -> L38
    L35:
        r104 = r114;
    L38:
        e = e;
        r104 = r114;
    L43:
        com.xiaomi.channel.commonutils.logger.b.d("zipFiction failed with exception:" + e.toString());     // Catch: Throwable -> L40
    L36:
        th = th;
        r104 = r114;
    L46:
        a(r104);
        throw th;
    L27:
        r100.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + Global.SUFFIX_TXT_FILE));     // Catch: Throwable -> L40 IOException -> L42
    L42:
        e = e;
    L40:
        th = th;
        goto L46
    }
}
