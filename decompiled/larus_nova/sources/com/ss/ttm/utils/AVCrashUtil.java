package com.ss.ttm.utils;

import android.content.Context;
import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes40.dex */
public final class AVCrashUtil {
    public AVCrashUtil() {
    }

    public static String getBase64SampleCrash(String r100) {
        return Base64.encodeToString(r100.getBytes(), 0);
    }

    public static void compress(InputStream r100, OutputStream r101) throws Exception {
        GZIPOutputStream r102 = new GZIPOutputStream(r101);
        byte[] r103 = new byte[10240];
    L3:
        int r104 = r100.read(r103, 0, 10240);
        if (r104 == (-1)) goto L6;
        r102.write(r103, 0, r104);
        goto L3
    L6:
        r102.flush();
        r102.finish();
        r102.close();
    }

    public static void deleteCrashFile(Context r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L8;
        r102.delete();
        return;
    }

    public static boolean existsCrashFile(Context r100, String r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r101).exists();
    }

    public static String getCrashFileContext(Context r100, String r101, StringBuilder r102) {
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L11;
        r102.append("file not exist.path:");
        r102.append(r101);
        r102.append("\r\n");
        return null;
    L11:
        if (r103.length() != 0) goto L14;
        r102.append("file size is zore.");
        r102.append("\r\n");
        return null;
    L14:
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r103);     // Catch: Exception -> L20
        compress(r105, r104);     // Catch: Exception -> L18
        r105.close();     // Catch: Exception -> L18
        String r106 = Base64.encodeToString(r104.toByteArray(), 0);     // Catch: Exception -> L18
        r104.close();     // Catch: Exception -> L18
        return r106;
    L18:
        e = e;
    L22:
        e.printStackTrace();
        if (r105 != null) goto L38;
    L36:
        r104.close();     // Catch: IOException -> L33
    L29:
        r102.append("gzip file is error.error:");
        r102.append(e.getMessage());
        return null;
    L38:
        r105.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = e;
        r105 = null;
    L31:
        r102.append("context or path is null.\r\n");
        return null;
    }

    public static final boolean moveFile(String r100, String r101, boolean r102) {
        return copyFile(r100, r101, r102, true);
    }

    public static final boolean copyFile(String r100, String r101, boolean r102, boolean r103) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.exists() == true) goto L6;
        return false;
    L6:
        if (r104.isFile() == true) goto L8;
        return false;
    L8:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100);
        if (r105.exists() == false) goto L13;
        if (r102 == false) goto L17;
        new PolarisFileWrapper(r100).delete();
    L17:
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L40 IOException -> L52 FileNotFoundException -> L62
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L38 IOException -> L72 FileNotFoundException -> L73
    L82:
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
    L22:
        int r110 = r107.read(r109);     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        if (r110 == (-1)) goto L25;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        goto L22
    L25:
        r108.close();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        r107.close();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        if (r103 == false) goto L76;
        r104.delete();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
    L76:
        r108.close();     // Catch: IOException -> L30
        r107.close();     // Catch: IOException -> L30
        return true;
    L30:
        e = move-exception;
        e.printStackTrace();
        return true;
    L37:
        r106 = r108;
    L36:
        r106 = r108;
    L34:
        Throwable th10 = th;
    L43:
        if (r108 != null) goto L80;
    L47:
        if (r107 == null) goto L51;
        r107.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th10;
    L80:
        r108.close();     // Catch: IOException -> L45
    L38:
        th = th;
        r108 = null;
    L42:
        th10 = th;
    L63:
        if (r106 != null) goto L78;
    L67:
        if (r107 == null) goto L71;
        r107.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L71:
        return false;
    L78:
        r106.close();     // Catch: IOException -> L65
    L53:
        if (r106 != null) goto L74;
    L57:
        if (r107 == null) goto L61;
        r107.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L61:
        return false;
    L74:
        r106.close();     // Catch: IOException -> L55
        goto L57
    L62:
        r107 = null;
    L52:
        r107 = null;
    L40:
        th = th;
        r107 = null;
        r108 = null;
        goto L42
    L13:
        if (r105.getParentFile().exists() == true) goto L17;
        if (r105.getParentFile().mkdirs() == true) goto L17;
        return false;
    }
}
