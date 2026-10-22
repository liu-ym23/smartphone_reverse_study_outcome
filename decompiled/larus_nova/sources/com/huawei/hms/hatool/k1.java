package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes23.dex */
public final class k1 {
    public static String a(File r100) {
        FileInputStream r101 = null;
        FileInputStream r102 = new FileInputStream(r100);     // Catch: Throwable -> L19 IOException -> L30 FileNotFoundException -> L31
    L34:
        h r103 = new h(1024);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L18
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L18
    L5:
        int r105 = r102.read(r104);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L18
        if (r105 == (-1)) goto L9;
        r103.a(r104, r105);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L18
        goto L5
    L9:
        if (r103.b() != 0) goto L12;
        a(r102);
        return "";
    L12:
        String r106 = new String(r103.a(), "UTF-8");     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L18
        a(r102);
        return r106;
    L18:
        r101 = r102;
    L17:
        r101 = r102;
    L15:
        th = th;
    L28:
        a(r102);
        throw th;
    L19:
        th = th;
        r102 = null;
    L24:
        v.f("hmsSdk", "getInfoFromFile(): No files need to be read");     // Catch: Throwable -> L19
        a(r101);
        return "";
    L21:
        v.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");     // Catch: Throwable -> L19
        a(r101);
        return "";
    }

    public static String a(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r103 = r100.read(r102);     // Catch: Throwable -> L10
        if (r103 == (-1)) goto L7;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L10
        goto L4
    L7:
        String r104 = r101.toString("UTF-8");     // Catch: Throwable -> L10
        a(r101);
        return r104;
    L10:
        th = move-exception;
        a(r101);
        throw th;
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        v.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
        return;
    }

    public static void a(File r100, String r101) {
        FileOutputStream r102 = null;
        FileOutputStream r103 = new FileOutputStream(r100);     // Catch: Throwable -> L10 IOException -> L21 FileNotFoundException -> L22
        r103.write(r101.getBytes("UTF-8"));     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L9
        r103.flush();     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L9
    L17:
        a(r103);
        return;
    L9:
        r102 = r103;
    L8:
        r102 = r103;
        goto L12
    L6:
        th = th;
        r102 = r103;
    L19:
        a(r102);
        throw th;
    L10:
        th = th;
    L14:
        String r104 = "saveInfoToFile(): No files need to be read";
    L13:
        r103 = r102;
        v.f("hmsSdk", r104);     // Catch: Throwable -> L6
    L12:
        r104 = "saveInfoToFile(): io exc from write info to file!";
        goto L13
    }

    private static void a(OutputStream r100) {
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        v.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
        return;
    }

    public static void a(HttpURLConnection r100) {
        r100.getInputStream().close();     // Catch: Exception -> L5
    L6:
        r100.disconnect();
        v.a("hmsSdk", " connHttp disconnect");
        return;
    L5:
        v.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        goto L6
    }

    public static byte[] a(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        Deflater r102 = new Deflater();
        r102.setInput(r100);
        r102.finish();
        byte[] r103 = new byte[1024];
    L4:
        if (r102.finished() == true) goto L6;
        r101.write(r103, 0, r102.deflate(r103));
        goto L4
    L6:
        byte[] r104 = r101.toByteArray();
        r102.end();
        a(r101);
        return r104;
    }
}
