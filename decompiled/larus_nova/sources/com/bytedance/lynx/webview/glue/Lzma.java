package com.bytedance.lynx.webview.glue;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import d17.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import l17.g;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public class Lzma {
    public Lzma() {
    }

    public static boolean decompress(File r100, File r110) {
        BufferedInputStream r101 = null;
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L60 Exception -> L62
        BufferedOutputStream r103 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r110));     // Catch: Throwable -> L54 Exception -> L57
    L92:
        byte[] r104 = new byte[5];     // Catch: Throwable -> L50 Exception -> L52
        if (r102.read(r104, 0, 5) == 5) goto L15;
        k.b(new String[]{"LZMA", "input .lzma is too short"});     // Catch: Throwable -> L50 Exception -> L52
        r102.close();     // Catch: Exception -> L12
        r103.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        a r111 = new a();     // Catch: Throwable -> L50 Exception -> L52
        if (r111.b(r104) == true) goto L23;
        k.b(new String[]{"LZMA", "Incorrect stream properties"});     // Catch: Throwable -> L50 Exception -> L52
        r102.close();     // Catch: Exception -> L20
        r103.close();     // Catch: Exception -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L23:
        long r105 = 0;
        int r106 = 0;
    L25:
        if (r106 >= 8) goto L36;
        int r107 = r102.read();     // Catch: Throwable -> L50 Exception -> L52
        if (r107 < 0) goto L28;
        r105 = r105 | (((long) r107) << (r106 * 8));
        r106 = r106 + 1;
        goto L25
    L28:
        k.b(new String[]{"LZMA", "Can't read stream size"});     // Catch: Throwable -> L50 Exception -> L52
        r102.close();     // Catch: Exception -> L31
        r103.close();     // Catch: Exception -> L31
    L33:
        return false;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L36:
        if (r111.a(r102, r103, r105) == true) goto L43;
        k.b(new String[]{"LZMA", "Error in data stream"});     // Catch: Throwable -> L50 Exception -> L52
        r102.close();     // Catch: Exception -> L40
        r103.close();     // Catch: Exception -> L40
    L42:
        return false;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        r103.flush();     // Catch: Throwable -> L50 Exception -> L52
        r102.close();     // Catch: Exception -> L46
        r103.close();     // Catch: Exception -> L46
        return true;
    L46:
        e = move-exception;
        e.printStackTrace();
        return true;
    L52:
        e = e;
    L59:
        r101 = r102;
    L78:
        e.printStackTrace();     // Catch: Throwable -> L70
        r101.close();     // Catch: Exception -> L67
        r103.close();     // Catch: Exception -> L67
    L69:
        return false;
    L67:
        e = move-exception;
        e.printStackTrace();
    L70:
        th = th;
    L80:
        r101.close();     // Catch: Exception -> L73
        r103.close();     // Catch: Exception -> L73
    L75:
        throw th;
    L73:
        e = move-exception;
        e.printStackTrace();
    L50:
        th = th;
    L56:
        r101 = r102;
    L57:
        e = e;
        r103 = null;
    L54:
        th = th;
        r103 = null;
        goto L56
    L62:
        e = e;
        r103 = null;
    L60:
        th = th;
        r103 = null;
        goto L80
    }

    public static boolean decompressAndUnzip(String r110, String r111) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        String r112 = r111 + "/tmp.zip";
        PolarisFileWrapper r101 = new PolarisFileWrapper(r112);
        BufferedInputStream r102 = null;
        BufferedOutputStream r103 = null;
        BufferedOutputStream r104 = null;
        r102 = null;
        BufferedInputStream r105 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L58 Exception -> L60
        BufferedOutputStream r106 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L54 Exception -> L56
    L90:
        byte[] r107 = new byte[5];     // Catch: Throwable -> L50 Exception -> L52
        if (r105.read(r107, 0, 5) == 5) goto L15;
        k.b(new String[]{"LZMA", "input .lzma is too short"});     // Catch: Throwable -> L50 Exception -> L52
        r105.close();     // Catch: Exception -> L12
        r106.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        a r108 = new a();     // Catch: Throwable -> L50 Exception -> L52
        if (r108.b(r107) == true) goto L23;
        k.b(new String[]{"LZMA", "Incorrect stream properties"});     // Catch: Throwable -> L50 Exception -> L52
        r105.close();     // Catch: Exception -> L20
        r106.close();     // Catch: Exception -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L23:
        long r109 = 0;
        int r113 = 0;
    L25:
        if (r113 >= 8) goto L36;
        int r114 = r105.read();     // Catch: Throwable -> L50 Exception -> L52
        if (r114 < 0) goto L28;
        r109 = r109 | (((long) r114) << (r113 * 8));
        r113 = r113 + 1;
        goto L25
    L28:
        k.b(new String[]{"LZMA", "Can't read stream size"});     // Catch: Throwable -> L50 Exception -> L52
        r105.close();     // Catch: Exception -> L31
        r106.close();     // Catch: Exception -> L31
    L33:
        return false;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L36:
        if (r108.a(r105, r106, r109) == true) goto L43;
        k.b(new String[]{"LZMA", "Error in data stream"});     // Catch: Throwable -> L50 Exception -> L52
        r105.close();     // Catch: Exception -> L40
        r106.close();     // Catch: Exception -> L40
    L42:
        return false;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        r106.flush();     // Catch: Throwable -> L50 Exception -> L52
        g.i(r112, r111);     // Catch: Throwable -> L50 Exception -> L52
        r101.delete();     // Catch: Throwable -> L50 Exception -> L52
        r105.close();     // Catch: Exception -> L46
        r106.close();     // Catch: Exception -> L46
        return true;
    L46:
        e = move-exception;
        e.printStackTrace();
        return true;
    L52:
        e = e;
        r103 = r106;
    L57:
        BufferedOutputStream r115 = r103;
        r102 = r105;
    L84:
        e.printStackTrace();     // Catch: Throwable -> L68
        r102.close();     // Catch: Exception -> L65
        r115.close();     // Catch: Exception -> L65
    L67:
        return false;
    L65:
        e = move-exception;
        e.printStackTrace();
    L68:
        th = th;
    L82:
        r102.close();     // Catch: Exception -> L71
        r115.close();     // Catch: Exception -> L71
    L73:
        throw th;
    L71:
        e = move-exception;
        e.printStackTrace();
    L50:
        th = th;
        r104 = r106;
    L55:
        r115 = r104;
        r102 = r105;
    L56:
        e = e;
    L54:
        th = th;
        goto L55
    L60:
        e = e;
        r115 = null;
    L58:
        th = th;
        r115 = null;
        goto L82
    }

    public static boolean decompress(String r100, String r101) {
        return decompress(new PolarisFileWrapper(r100), new PolarisFileWrapper(r101));
    }
}
