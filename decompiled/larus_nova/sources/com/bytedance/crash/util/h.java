package com.bytedance.crash.util;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean b(File r100) {
        boolean r101 = true;
        if (r100.exists() == true) goto L6;
        return true;
    L6:
        if (r100.canWrite() == true) goto L9;
        return false;
    L9:
        if (r100.isFile() == false) goto L13;
        return r100.delete();
    L13:
        if (r100.isDirectory() == false) goto L33;
        File[] r102 = r100.listFiles();
        int r103 = 0;
    L15:
        if (r102 == null) goto L28;
        if (r103 >= r102.length) goto L28;
        if (r102[r103].isFile() == true) goto L21;
        boolean r104 = b(r102[r103]);
    L25:
        r101 = r101 & r104;
    L26:
        r103 = r103 + 1;
        goto L15
    L21:
        if (r102[r103].canWrite() == false) goto L23;
        r104 = r102[r103].delete();
        goto L25
    L23:
        r101 = false;
    L28:
        return r101 & r100.delete();
    L33:
        return true;
    }

    public static String c(File r100) throws IOException {
        if (r100 != null) goto L5;
    L23:
        return "";
    L5:
        if (r100.exists() == false) goto L23;
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L19
    L25:
        String r103 = r102.readLine();     // Catch: Throwable -> L17
        if (r103 == null) goto L16;
        if (r101.length() == 0) goto L14;
        r101.append("\n");     // Catch: Throwable -> L17
    L14:
        r101.append(r103);     // Catch: Throwable -> L17
        goto L25
    L16:
        g.a(r102);
        return r101.toString();
    L17:
        th = th;
    L21:
        g.a(r102);
        throw th;
    L19:
        th = th;
        r102 = null;
        goto L21
    }

    public static String d(String r100) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return c(new PolarisFileWrapper(r100));
    }

    public static JSONArray e(File r100) throws IOException {
        JSONArray r101 = new JSONArray();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L12
    L16:
        String r103 = r102.readLine();     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r101.put(r103);     // Catch: Throwable -> L10
        goto L16
    L8:
        g.a(r102);
        return r101;
    L10:
        th = th;
    L14:
        g.a(r102);
        throw th;
    L12:
        th = th;
        r102 = null;
        goto L14
    }

    public static JSONArray f(String r100) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return e(new PolarisFileWrapper(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static void g(PolarisFileWrapper r100, JSONArray r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getParentFile().mkdirs();
        if (r101 != null) goto L9;
        ?? r102 = new PolarisFileOutputStreamWrapper(r100, false);     // Catch: Throwable -> L12
        r102.write("".getBytes());     // Catch: Throwable -> L15
        r102.flush();     // Catch: Throwable -> L15
        r102 = r102;
    L19:
    L13:
        g.a(r102);
        return;
    L9:
        BufferedWriter r103 = new BufferedWriter(new PolarisFileWriterWrapper(r100, false));     // Catch: Throwable -> L12
        new JSONWriter(r103).a(r101);     // Catch: Throwable -> L16
        r103.flush();     // Catch: Throwable -> L16
    L11:
        r102 = r103;
    L12:
        r102 = 0;
        goto L13
    }

    public static void i(File r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        r100.getParentFile().mkdirs();
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r100, false));     // Catch: Throwable -> L8
        new JSONWriter(r102).c(r101);     // Catch: Throwable -> L11
        r102.flush();     // Catch: Throwable -> L11
    L9:
        g.a(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static void j(String r100, String r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        new PolarisFileWrapper(r101).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r103 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L9
        k(r103, r102, "");     // Catch: Throwable -> L7
        g.a(r103);
        return;
    L7:
        Throwable th10 = th;
    L11:
        g.a(r103);
        throw th10;
    L9:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L11
    }

    public static void a(File r100, PolarisFileWrapper r101, boolean r102) {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r101.exists() == false) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = null;
        PolarisFileOutputStreamWrapper r105 = null;
        PolarisFileInputStreamWrapper r106 = null;
        r101.getParentFile().mkdirs();     // Catch: Throwable -> L26 Exception -> L30
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L26 Exception -> L30
    L39:
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r101, r102);     // Catch: Throwable -> L22 Exception -> L34
        goto L25
    L35:
        byte[] r109 = new byte[8192];     // Catch: Throwable -> L19 Exception -> L21
        int r110 = 0;
    L13:
        int r111 = r107.read(r109);     // Catch: Throwable -> L19 Exception -> L21
        if (r111 <= 0) goto L18;
        r108.write(r109, 0, r111);     // Catch: Throwable -> L19 Exception -> L21
        r110 = r110 + r111;
        if (r110 < Integer.MAX_VALUE) goto L13;
    L18:
        g.a(r107);
    L32:
        g.a(r108);
        return;
    L21:
        r104 = r108;
    L19:
        Throwable th10 = th;
        r105 = r108;
    L24:
        PolarisFileOutputStreamWrapper r112 = r105;
        r103 = r107;
    L28:
        g.a(r103);
        g.a(r112);
        throw th10;
    L22:
        th = move-exception;
        th10 = th;
    L25:
        r108 = r104;
        r106 = r107;
    L31:
        g.a(r106);
    L30:
        r108 = null;
    L26:
        th = move-exception;
        th10 = th;
        r112 = null;
        goto L28
    }

    public static void h(File r100, String r101, boolean r102) throws IOException {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        r100.getParentFile().mkdirs();
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100, r102);     // Catch: Throwable -> L12
        r104.write(r101.getBytes());     // Catch: Throwable -> L10
        r104.flush();     // Catch: Throwable -> L10
        g.a(r104);
        return;
    L10:
        th = th;
        r103 = r104;
    L13:
        g.a(r103);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void k(ZipOutputStream r100, File r101, String r102) throws IOException {
        if (r101.exists() == true) goto L5;
        return;
    L5:
        int r103 = 0;
        if (r101.isDirectory() == false) goto L17;
        File[] r104 = r101.listFiles();
        if (r104 != null) goto L10;
        return;
    L10:
        r100.putNextEntry(new ZipEntry(r102 + HTTP.URL_DEFAULT));
        if (r102.length() != 0) goto L13;
        String r105 = "";
    L14:
        int r106 = r104.length;
    L15:
        if (r103 >= r106) goto L40;
        File r107 = r104[r103];
        k(r100, r107, r105 + r107.getName());
        r103 = r103 + 1;
        goto L15
    L40:
        return;
    L13:
        r105 = r102.concat(HTTP.URL_DEFAULT);
        goto L14
    L17:
        r100.putNextEntry(new ZipEntry(r102));
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L29
        byte[] r109 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r110 = r108.read(r109);     // Catch: Throwable -> L27
        if ((-1) == r110) goto L25;
        r100.write(r109, 0, r110);     // Catch: Throwable -> L27
        goto L21
    L25:
        g.a(r108);
        return;
    L27:
        th = th;
    L31:
        g.a(r108);
        throw th;
    L29:
        th = th;
        r108 = null;
        goto L31
    }
}
