package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes24.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f285888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f285889b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f285890c = null;

    public static class MimeTypeCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[][] f285891a = null;

        static {
            f285891a = new String[][]{new String[]{MimeType.ZIP, "application/x-zip-compressed"}};
            new AnonymousClass1();
        }
    }

    static {
        f285888a = new String[]{" Byte", " KB", " MB", " GB"};
        f285889b = new String[]{"Byte", "KB", "MB", "GB"};
        f285890c = new HashSet(Arrays.asList(new String[]{".tar.gz", ".tar.xz", ".tar.bz2"}));
    }

    public static boolean f(File r100) {
        if (r100.isDirectory() == false) goto L12;
        String[] r101 = r100.list();
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L12;
        if (f(new PolarisFileWrapper(r100, r101[r102])) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L12:
        return r100.delete();
    }

    public static boolean g(String r100) {
        return new PolarisFileWrapper(r100).delete();
    L4:
        e = move-exception;
        Log.e("FileUtils", e.getMessage());
        return false;
    }

    public static String h(long r100) {
        return i(r100, f285888a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] j(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        byte[] r102 = null;
        r102 = null;
        Closeable r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L10 IOException -> L12
        r102 = new byte[(int) r101.length()];     // Catch: Throwable -> L6 IOException -> L8
        r104.read(r102);     // Catch: Throwable -> L6 IOException -> L8
        r104.close();     // Catch: Throwable -> L6 IOException -> L8
        d.b(new Closeable[]{r104});
    L19:
        return r102;
    L8:
        e = e;
        byte[] r105 = r102;
        r103 = r104;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L10
        d.b(new Closeable[]{r103});
        r102 = r105;
    L6:
        th = th;
        r102 = r104;
    L17:
        d.b(new Closeable[]{r102});
        throw th;
    L10:
        th = th;
    L12:
        e = e;
        r105 = null;
        goto L14
    }

    public static String k(String r100) {
        if (r100.lastIndexOf(".") > 0) goto L7;
        return "";
    L7:
        return r100.substring(r100.lastIndexOf(".") + 1, r100.length()).toLowerCase();
    }

    public static String l(String r100) {
        return new PolarisFileWrapper(r100).getName();
    }

    public static String m(String r100) {
        int r101 = o(r100);
        if (r101 > 0) goto L7;
        return "";
    L7:
        return r100.substring(r101);
    }

    public static String n(String r100) {
        int r101 = o(r100);
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r100.substring(0, r101);
    }

    public static int o(String r100) {
        int r101 = r100.lastIndexOf(".");
        if (r101 <= 0) goto L9;
        int r102 = r100.substring(0, r101).lastIndexOf(".");
        if (r102 <= 0) goto L9;
        String r103 = r100.substring(r102);
        if (((HashSet) f285890c).contains(r103) == false) goto L9;
        return r102;
    L9:
        return r101;
    }

    public static String p(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "*/*";
    L5:
        String r101 = k(r100);
        String r102 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r101);
        if (r102 != null) goto L9;
        r102 = "*/*";
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return "*/*";
    L12:
        return r102;
    }

    public static boolean r(String r100) {
        if (new PolarisFileWrapper(r100).exists() == true) goto L6;
        return false;
    L6:
        return true;
    L8:
        return false;
    }

    public static boolean s(String r100) {
        if (URLUtil.isNetworkUrl(r100) == false) goto L6;
        return false;
    L6:
        if (r100 != null) goto L9;
        return true;
    L9:
        if (r100.startsWith(File.separator) == false) goto L15;
        return true;
    L15:
        return "file".equals(new URL(r100).getProtocol());
    L13:
        Log.w("FileUtils", "donot know url is local or not, path: ".concat(r100));
        return false;
    }

    public static void t(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L6;
        r101.mkdirs();
        return;
    }

    public static void c(File r110, VFSFile r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.exists() == false) goto L46;
        if (r111 != null) goto L8;
        return;
    L8:
        PolarisFileInputStreamWrapper r100 = null;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L26 Exception -> L28
    L23:
        e = move-exception;
        Exception e100 = e;
        PolarisFileOutputStreamWrapper r112 = null;
    L25:
        r100 = r101;
    L37:
        e100.printStackTrace();     // Catch: Throwable -> L33
        d.b(new Closeable[]{r100, r112});
        return;
    L33:
        Throwable th10 = th;
    L34:
        d.b(new Closeable[]{r100, r112});
        throw th10;
    L20:
        th = move-exception;
        th10 = th;
        r112 = null;
    L22:
        r100 = r101;
        goto L34
    L11:
        if (r111.exists() == true) goto L13;
        r111.createNewFile();     // Catch: Throwable -> L20 Exception -> L23
    L13:
        r112 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L20 Exception -> L23
    L43:
        FileChannel r102 = r101.getChannel();     // Catch: Throwable -> L16 Exception -> L18
        r102.transferTo(0, r102.size(), r112.getChannel());     // Catch: Throwable -> L16 Exception -> L18
        d.b(new Closeable[]{r101, r112});
        return;
    L18:
        e100 = e;
    L16:
        th10 = th;
        goto L22
    L28:
        e = move-exception;
        e100 = e;
        r112 = null;
    L26:
        th = move-exception;
        th10 = th;
        r112 = null;
        goto L34
    }

    public static void d(InputStream r100, OutputStream r101) {
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L9 IOException -> L11
    L4:
        int r103 = r100.read(r102);     // Catch: Throwable -> L9 IOException -> L11
        if (r103 <= 0) goto L8;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L9 IOException -> L11
    L8:
        d.b(new Closeable[]{r100});
        d.b(new Closeable[]{r101});
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        d.b(new Closeable[]{r100});
        d.b(new Closeable[]{r101});
        return;
    L9:
        th = move-exception;
        d.b(new Closeable[]{r100});
        d.b(new Closeable[]{r101});
        throw th;
    }

    public static void e(String r110, String r111) {
        new PolarisFileWrapper(r111).mkdirs();     // Catch: Exception -> L25
        String[] r100 = new PolarisFileWrapper(r110).list();     // Catch: Exception -> L25
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L34;
        String r102 = File.separator;     // Catch: Exception -> L25
        if (r110.endsWith(r102) == false) goto L9;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r110 + r100[r101]);     // Catch: Exception -> L25
    L12:
        if (r103.isFile() == false) goto L22;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r111 + HTTP.URL_DEFAULT + r103.getName());     // Catch: Exception -> L25
        if (r104.exists() == true) goto L22;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r103);     // Catch: Exception -> L25
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r111 + HTTP.URL_DEFAULT + r103.getName());     // Catch: Exception -> L25
        byte[] r107 = new byte[65536];     // Catch: Exception -> L25
    L17:
        int r112 = r105.read(r107);     // Catch: Exception -> L25
        if (r112 == (-1)) goto L20;
        r106.write(r107, 0, r112);     // Catch: Exception -> L25
        goto L17
    L20:
        r106.flush();     // Catch: Exception -> L25
        r106.close();     // Catch: Exception -> L25
        r105.close();     // Catch: Exception -> L25
        Log.i("FileUtils", "destinationFile exists, overwriteExistFile: false, destinationFile: " + r104.getAbsolutePath());     // Catch: Exception -> L25
    L22:
        if (r103.isDirectory() == false) goto L24;
        e(r110 + HTTP.URL_DEFAULT + r100[r101], r111 + HTTP.URL_DEFAULT + r100[r101]);     // Catch: Exception -> L25
    L24:
        r101 = r101 + 1;
        goto L4
    L9:
        r103 = new PolarisFileWrapper(r110 + r102 + r100[r101]);     // Catch: Exception -> L25
        goto L12
    L34:
        return;
    L25:
        e = move-exception;
        Log.e("FileUtils", "copy folder error:", e);
    }

    public static String i(long r100, String[] r110) {
        if (r100 >= 0) goto L6;
        r100 = 0;
    L6:
        if (r100 < 1024) goto L8;
        long r101 = r100 / 1024;
        if (r101 >= 1024) goto L14;
        return String.valueOf(r101) + r110[1];
    L14:
        if (r101 >= 1048576) goto L18;
        return String.format("%.2f%s", new Object[]{Double.valueOf(r101 / 1024.0d), r110[2]});
    L18:
        return String.format("%.2f%s", new Object[]{Double.valueOf((((r101 * 100) / 1024) / 1024) / 100.0d), r110[3]});
    L8:
        return String.valueOf(r100) + r110[0];
    }

    public static String q(Context r100, Uri r101) {
        PolarisFileWrapper r102 = m0.b(r100, r101, false);
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.getAbsolutePath();
    }

    public static void u(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r101))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap] */
    public static String w(Bitmap r100, String r101) {
        ?? r102 = 0;
        if (r100 != 0) goto L5;
        return null;
    L5:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L22 Exception -> L24
    L20:
        e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r104 != null) goto L41;
    L32:
        return null;
    L41:
        r104.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L8:
        if (r100.compress(Bitmap.CompressFormat.JPEG, 100, r104) == false) goto L45;
        r104.flush();     // Catch: Exception -> L20 Throwable -> L33
        String r105 = r103.getAbsolutePath();     // Catch: Exception -> L20 Throwable -> L33
        r104.close();     // Catch: Exception -> L12
    L14:
        return r105;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L45:
        r104.close();     // Catch: Exception -> L17
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L33:
        th = th;
        r102 = r101;
    L35:
        if (r102 != 0) goto L43;
    L40:
        throw th;
    L43:
        r102.close();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        r104 = null;
    L22:
        th = th;
        goto L35
    }

    public static void x(ZipInputStream r100, String r101) throws Exception {
    L2:
        ZipEntry r102 = r100.getNextEntry();
        if (r102 == null) goto L34;
        String r103 = r102.getName();
        if (r103.contains("../") == true) goto L2;
        if (r102.isDirectory() == true) goto L9;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        String r105 = File.separator;
        r104.append(r105);
        r104.append(r103);
        Log.d("FileUtils", r104.toString());
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101 + r105 + r103);
        if (r106.exists() == true) goto L13;
        Log.d("FileUtils", "Create the file:" + r101 + r105 + r103);
        r106.getParentFile().mkdirs();
        r106.createNewFile();
    L13:
        BufferedOutputStream r107 = null;
        BufferedOutputStream r108 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L26 IOException -> L28
    L37:
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L22 IOException -> L24
    L17:
        int r110 = r100.read(r109);     // Catch: Throwable -> L22 IOException -> L24
        if (r110 == (-1)) goto L20;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L22 IOException -> L24
        r108.flush();     // Catch: Throwable -> L22 IOException -> L24
        goto L17
    L20:
        r108.close();     // Catch: Throwable -> L22 IOException -> L24
        d.b(new Closeable[]{r108});
    L24:
        e = e;
        r107 = r108;
    L29:
        Log.i("FileUtils", e.getMessage());     // Catch: Throwable -> L26
        d.b(new Closeable[]{r107});
    L22:
        th = th;
    L32:
        d.b(new Closeable[]{r108});
        throw th;
    L28:
        e = e;
    L26:
        th = th;
        r108 = null;
        goto L32
    L9:
        new PolarisFileWrapper(r101 + File.separator + r103.substring(0, r103.length() - 1)).mkdirs();
        goto L2
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    public static void b(Context r100, String r101, String r102) {
        String[] r103 = r100.getAssets().list(r101);     // Catch: Exception -> L39
        int r104 = 0;
        if (r103.length <= 0) goto L9;
        new PolarisFileWrapper(r102).mkdirs();     // Catch: Exception -> L39
        int r105 = r103.length;     // Catch: Exception -> L39
    L6:
        if (r104 >= r105) goto L55;
        String r106 = r103[r104];     // Catch: Exception -> L39
        b(r100, r101 + HTTP.URL_DEFAULT + r106, r102 + HTTP.URL_DEFAULT + r106);     // Catch: Exception -> L39
        r104 = r104 + 1;
        goto L6
    L55:
        return;
    L9:
        InputStream r107 = null;
        InputStream r108 = r100.getAssets().open(r101);     // Catch: Throwable -> L30 IOException -> L32
    L47:
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r102));     // Catch: Throwable -> L24 IOException -> L27
    L49:
        byte[] r110 = new byte[1024];     // Catch: Throwable -> L20 IOException -> L22
    L14:
        int r111 = r108.read(r110);     // Catch: Throwable -> L20 IOException -> L22
        if (r111 == (-1)) goto L17;
        r109.write(r110, 0, r111);     // Catch: Throwable -> L20 IOException -> L22
        goto L14
    L17:
        r109.flush();     // Catch: Throwable -> L20 IOException -> L22
        d.b(new Closeable[]{r108});     // Catch: Exception -> L39
        d.b(new Closeable[]{r109});     // Catch: Exception -> L39
        return;
    L22:
        e = e;
    L29:
        r107 = r108;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L36
        d.b(new Closeable[]{r107});     // Catch: Exception -> L39
        d.b(new Closeable[]{r109});     // Catch: Exception -> L39
        return;
    L36:
        th = th;
    L37:
        d.b(new Closeable[]{r107});     // Catch: Exception -> L39
        d.b(new Closeable[]{r109});     // Catch: Exception -> L39
        throw th;     // Catch: Exception -> L39
    L20:
        th = th;
    L26:
        r107 = r108;
    L27:
        e = e;
        r109 = null;
    L24:
        th = th;
        r109 = null;
    L32:
        e = e;
        r109 = null;
    L30:
        th = th;
        r109 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
    }

    public static void v(Context r100, String r101, Token r102) {
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return;
    L13:
        uf7.a.a(r102);     // Catch: Exception -> L7
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r101))));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if ((e instanceof SensitiveAPIException) == false) goto L12;
        Log.e("FileUtils", "notifySystemScanFile failed", e);
        return;
    L12:
        throw e;
    }
}
