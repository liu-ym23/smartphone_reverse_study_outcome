package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.apm.d;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384389a = 0;

    public a() {
    }

    static {
    }

    public static void d(File r100) {
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L16;
        File[] r101 = r100.listFiles();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L16;
        File r104 = r101[r103];
        if (r104.isFile() == false) goto L13;
        r104.delete();
    L15:
        r103 = r103 + 1;
        goto L8
    L13:
        if (r100.isDirectory() == false) goto L15;
        d(r104);
    L16:
        r100.delete();
    }

    public static File e(Context r100) {
        File r101 = r100.getExternalFilesDir("cloudMessage");
        if (r101 != null) goto L6;
        r101 = new PolarisFileWrapper(r100.getFilesDir(), "cloudMessage");
    L6:
        if (r101.exists() == true) goto L8;
        r101.mkdir();
    L8:
        return r101;
    }

    public static boolean g(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        return true;
    L5:
        if (r101.isDirectory() == false) goto L30;
        File[] r102 = r101.listFiles();
        int r103 = r102.length;
        int r104 = 0;
        boolean r105 = true;
    L7:
        if (r104 >= r103) goto L20;
        if (r102[r104].isDirectory() == false) goto L15;
        if (r105 == true) goto L12;
    L14:
        r105 = false;
    L19:
        r104 = r104 + 1;
        goto L7
    L12:
        if (g(r102[r104].getAbsolutePath()) == false) goto L14;
    L13:
        r105 = true;
        goto L19
    L15:
        if (r105 == false) goto L14;
        if (r102[r104].delete() == false) goto L14;
    L20:
        if (r105 == true) goto L22;
    L24:
        return false;
    L22:
        if (r101.delete() == false) goto L24;
        return true;
    L30:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.security.android.aopcheck.PolarisFileWrapper, java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void b(String r100, String... r101) {
        ?? r102 = new PolarisFileWrapper(r100);
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L25 Exception -> L28
    L42:
        CheckedOutputStream r104 = new CheckedOutputStream(r103, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
        ZipOutputStream r105 = new ZipOutputStream(r104);     // Catch: Throwable -> L17 Exception -> L19
        int r106 = r101.length;     // Catch: Exception -> L15 Throwable -> L33
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L13;
        String r108 = r101[r107];     // Catch: Exception -> L15 Throwable -> L33
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108);     // Catch: Exception -> L15 Throwable -> L33
        if (r109.exists() == false) goto L12;
        a(r109, r105, "");     // Catch: Exception -> L15 Throwable -> L33
        r107 = r107 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r108 + "不存在！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        xu3.c.a(r105);
        xu3.c.a(r104);
        xu3.c.a(r103);
        return;
    L15:
        Exception e100 = e;
    L32:
        throw new RuntimeException(e100);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e100 = e;
    L17:
        th = th;
        Closeable r110 = null;
        r102 = r104;
    L27:
        th = th;
    L34:
        xu3.c.a(r110);
        xu3.c.a(r102);
        xu3.c.a(r103);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r102 = 0;
        r110 = null;
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r102 = 0;
        r103 = null;
        r110 = null;
        goto L27
    }

    public static PolarisFileWrapper f(String r100, String r101) {
        Context r102 = x8a.c.b().getContext();
        r100.getClass();
        switch(r100.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L29;
        };
    L29:
        byte r103 = -1;
    L30:
        if (r103 == 0) goto L49;
        if (r103 == 1) goto L47;
        if (r103 == 2) goto L45;
        if (r103 == 3) goto L43;
        if (r103 == 4) goto L41;
        if (r103 == 5) goto L39;
        return null;
    L39:
        return new PolarisFileWrapper(r102.getFilesDir(), r101);
    L41:
        return new PolarisFileWrapper(r102.getExternalFilesDir(null).getParentFile(), r101);
    L43:
        return new PolarisFileWrapper(r102.getCacheDir(), r101);
    L45:
        return new PolarisFileWrapper(r102.getExternalCacheDir(), r101);
    L47:
        return new PolarisFileWrapper(r102.getExternalFilesDir(null), r101);
    L49:
        return new PolarisFileWrapper(r102.getFilesDir().getParentFile(), r101);
    L6:
        if (r100.equals("data_package_file") == false) goto L29;
        r103 = 5;
        goto L30
    L10:
        if (r100.equals("sd_package") == false) goto L29;
        r103 = 4;
        goto L30
    L14:
        if (r100.equals("data_package_cache") == false) goto L29;
        r103 = 3;
        goto L30
    L18:
        if (r100.equals("sd_package_cache") == false) goto L29;
        r103 = 2;
        goto L30
    L22:
        if (r100.equals("sd_package_file") == false) goto L29;
        r103 = 1;
        goto L30
    L26:
        if (r100.equals("data_package") == false) goto L29;
        r103 = 0;
        goto L30
    }

    public static void i(String r100, String r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        ZipOutputStream r103 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L9
        j(r103, r102, "");     // Catch: Throwable -> L7
        xu3.c.a(r103);
        return;
    L7:
        Throwable th10 = th;
    L11:
        xu3.c.a(r103);
        throw th10;
    L9:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L11
    }

    public static void a(File r100, ZipOutputStream r101, String r102) {
        int r103 = 0;
        if (r100.isDirectory() == false) goto L12;
        String r104 = r102 + r100.getName() + File.separator;
        if (r100.exists() == false) goto L56;
        File[] r105 = r100.listFiles();
    L9:
        if (r103 >= r105.length) goto L58;
        a(r105[r103], r101, r104);
        r103 = r103 + 1;
        goto L9
    L58:
        return;
    L56:
        return;
    L12:
        if (d.j() == false) goto L15;
        ps3.b.a(new String[]{"压缩：" + r102 + r100.getName()});
    L15:
        if (r100.exists() == false) goto L57;
        InputStream r106 = null;
        InputStream r107 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L35 Exception -> L37
        BufferedInputStream r108 = new BufferedInputStream(r107);     // Catch: Throwable -> L31 Exception -> L33
        r101.putNextEntry(new ZipEntry(r102 + r100.getName()));     // Catch: Throwable -> L27 Exception -> L29
        byte[] r109 = new byte[8192];     // Catch: Throwable -> L27 Exception -> L29
    L21:
        int r110 = r108.read(r109, 0, 8192);     // Catch: Throwable -> L27 Exception -> L29
        if (r110 == (-1)) goto L25;
        r101.write(r109, 0, r110);     // Catch: Throwable -> L27 Exception -> L29
    L25:
        xu3.c.a(r108);
        xu3.c.a(r107);
        return;
    L29:
        e = e;
        r106 = r108;
    L34:
        InputStream r111 = r106;
        r106 = r107;
    L45:
    L41:
        th = th;
        r107 = r106;
        r106 = r111;
    L43:
        xu3.c.a(r106);
        xu3.c.a(r107);
        throw th;
    L40:
        throw new RuntimeException(e);     // Catch: Throwable -> L41
    L27:
        th = th;
        r106 = r108;
        goto L43
    L33:
        e = e;
    L31:
        th = th;
        goto L43
    L37:
        e = e;
        r111 = null;
    L35:
        th = th;
        r107 = null;
        goto L43
    }

    public static boolean c(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L29:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        if (TextUtils.isEmpty(r102) == true) goto L29;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L18 Exception -> L20
        boolean r105 = h(r104, r101, r102);     // Catch: Throwable -> L14 Exception -> L16
        r104.close();     // Catch: Exception -> L30
    L13:
        return r105;
    L16:
        e = e;
        r103 = r104;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r103 != null) goto L38;
    L24:
        return false;
    L38:
        r103.close();     // Catch: Exception -> L32
    L14:
        th = th;
    L26:
        if (r104 != null) goto L33;
    L28:
        throw th;
    L33:
        r104.close();     // Catch: Exception -> L31
    L20:
        e = e;
    L18:
        th = th;
        r104 = r103;
        goto L26
    }

    public static boolean h(PolarisFileInputStreamWrapper r100, String r101, String r102) {
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L24 Exception -> L26
        if (r104.exists() == false) goto L6;
    L9:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r104, r102));     // Catch: Throwable -> L24 Exception -> L26
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L20 Exception -> L22
    L12:
        int r107 = r100.read(r106);     // Catch: Throwable -> L20 Exception -> L22
        if (r107 == (-1)) goto L15;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L20 Exception -> L22
        goto L12
    L15:
        r105.flush();     // Catch: Throwable -> L20 Exception -> L22
        r105.close();     // Catch: Throwable -> L20 Exception -> L22
        r100.close();     // Catch: Throwable -> L24 Exception -> L26
        r100.close();     // Catch: Exception -> L38
        return true;
    L61:
        return true;
    L22:
        e = e;
        r103 = r105;
    L27:
        e.toString();     // Catch: Throwable -> L24
        if (r103 == null) goto L55;
        r103.close();     // Catch: Exception -> L41
    L55:
        r100.close();     // Catch: Exception -> L42
    L31:
        return false;
    L20:
        th = th;
    L33:
        if (r105 != null) goto L50;
    L45:
        r100.close();     // Catch: Exception -> L40
        throw th;
    L60:
        throw th;
    L50:
        r105.close();     // Catch: Exception -> L39
        goto L45
    L6:
        if (r104.mkdirs() == true) goto L9;
        r100.close();     // Catch: Exception -> L37
    L8:
        return false;
    L24:
        th = th;
        r105 = null;
    L26:
        e = e;
        goto L27
    }

    public static void j(ZipOutputStream r100, File r101, String r102) throws Exception {
        if (r101.isDirectory() == false) goto L12;
        File[] r103 = r101.listFiles();
        r100.putNextEntry(new ZipEntry(r102 + HTTP.URL_DEFAULT));
        if (r102.length() != 0) goto L7;
        String r104 = "";
    L8:
        int r105 = 0;
    L10:
        if (r105 >= r103.length) goto L33;
        j(r100, r103[r105], r104 + r103[r105].getName());
        r105 = r105 + 1;
        goto L10
    L33:
        return;
    L7:
        r104 = r102.concat(HTTP.URL_DEFAULT);
        goto L8
    L12:
        r100.putNextEntry(new ZipEntry(r102));
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L22
    L28:
        int r107 = r106.read();     // Catch: Throwable -> L20
        if (r107 == (-1)) goto L18;
        r100.write(r107);     // Catch: Throwable -> L20
        goto L28
    L18:
        xu3.c.a(r106);
        return;
    L20:
        th = th;
    L24:
        xu3.c.a(r106);
        throw th;
    L22:
        th = th;
        r106 = null;
        goto L24
    }
}
