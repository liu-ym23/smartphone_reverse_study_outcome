package com.huawei.secure.android.common.util;

import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.dora.impl.ota.g2.j0;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes23.dex */
public class ZipUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278231a = "ZipUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278232b = 104857600;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f278233c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f278234d = 6000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278235e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f278236f = null;

    static {
        f278236f = new String[]{"\\..", "/..", "..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};
    }

    public ZipUtil() {
    }

    private static boolean a(List<File> r100) {
        Iterator<File> r101 = r100.iterator();     // Catch: Exception -> L9
    L4:
        if (r101.hasNext() == false) goto L7;
        f(r101.next());     // Catch: Exception -> L9
        goto L4
    L7:
        return true;
    L9:
        e = move-exception;
        LogsUtil.e(f278231a, "unzip fail delete file failed" + e.getMessage());
        return false;
    }

    private static boolean b(File r100) {
        if (r100 != null) goto L4;
    L11:
        return false;
    L4:
        if (r100.exists() == false) goto L9;
        if (r100.isDirectory() == false) goto L11;
    L10:
        return true;
    L9:
        if (r100.mkdirs() == false) goto L11;
        goto L10
    }

    private static boolean c(File r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.exists() == false) goto L10;
        return r100.isFile();
    L10:
        if (b(r100.getParentFile()) == true) goto L15;
        return false;
    L15:
        return r100.createNewFile();
    L14:
        return false;
    }

    private static void d(File r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.delete() == true) goto L8;
        LogsUtil.e(f278231a, "delete file error");
        return;
    }

    private static String e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = r100.lastIndexOf(File.separator);
        if (r101 != (-1)) goto L9;
        return r100;
    L9:
        return r100.substring(r101 + 1);
    }

    private static void f(File r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFile() == false) goto L9;
        d(r100);
        return;
    L9:
        if (r100.isDirectory() == false) goto L22;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L13;
    L19:
        d(r100);
        return;
    L13:
        if (r101.length == 0) goto L19;
        int r102 = r101.length;
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L18;
        f(r101[r103]);
        r103 = r103 + 1;
        goto L16
    L18:
        d(r100);
        return;
    }

    private static boolean g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String[] r101 = f278236f;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        String r104 = r101[r103];
        if (r100.toUpperCase(Locale.ROOT).contains(r104) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static String h(String r100) {
        String r101 = File.separator;
        if (r100.endsWith(r101) == true) goto L5;
        return r100;
    L5:
        if (r100.length() > r101.length()) goto L7;
        return r100;
    L7:
        return r100.substring(0, r100.length() - r101.length());
    }

    private static boolean a(String r100) {
        String r101 = Normalizer.normalize(r100, Normalizer.Form.NFKC);
        if (g(r101) == false) goto L6;
        e(r101);
        return false;
    L6:
        return true;
    }

    private static void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (g(r100) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static File c(String r100) {
        b(r100);
        return new PolarisFileWrapper(r100);
    }

    private static File d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return c(r100);
    }

    private static void e(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L7;
        return;
    L7:
        if (r100.mkdirs() == true) goto L11;
        LogsUtil.e(f278231a, "mkdirs error , files exists or IOException.");
        return;
    }

    private static String f(String r100) {
        return r100.replaceAll("\\\\", HTTP.URL_DEFAULT);
    }

    private static void a(File r100) {
        File r101 = r100.getParentFile();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.exists() == true) goto L9;
        e(r101);
        return;
    }

    private static String a(ZipEntry r100) {
        return Normalizer.normalize(r100.getName(), Normalizer.Form.NFKC);
    }

    private static void a(boolean r100, File r101) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (r101.exists() == true) goto L6;
        return;
    L6:
        if (r101.isFile() == false) goto L11;
        f(r101);
        return;
    }

    private static ZipFile b(boolean r100, File r101) throws IOException {
        if (r100 == false) goto L6;
        LogsUtil.i(f278231a, "not a utf8 zip file, use gbk open zip file : " + r101);
        return new PolarisZipFileWrapper(r101, Charset.forName("GBK"));
    L6:
        return new PolarisZipFileWrapper(r101);
    }

    private static void a(boolean r100, List<File> r101) {
        if (r100 == true) goto L5;
        a(r101);
        r101.clear();
        return;
    }

    private static void a(FileInputStream r100, ZipInputStream r101) {
        IOUtil.closeSecure(r100);
        IOUtil.closeSecure(r101);
    }

    private static boolean a(ZipEntry r100, File r101, List<File> r102) {
        if (r100.isDirectory() == false) goto L6;
        e(r101);
        r102.add(r101);
        return true;
    L6:
        return false;
    }

    public static boolean unZip(String r100, String r101, boolean r102) throws SecurityCommonException {
        return unZip(r100, r101, j0.G2_OTA_SPACE_CHECK_BYTES, 100, r102);
    }

    public static List<File> unZipNew(String r100, String r101, boolean r102) throws SecurityCommonException {
        return unZipNew(r100, r101, j0.G2_OTA_SPACE_CHECK_BYTES, 100, r102);
    }

    public static List<File> unZipWithFilter(String r100, String r101, boolean r110, FilenameFilter r111) throws SecurityCommonException {
        return unZipWithFilter(r100, r101, j0.G2_OTA_SPACE_CHECK_BYTES, 100, r110, r111, 6000);
    }

    private static long a(ZipEntry r100, File r101, long r102, long r103, ZipFile r110) throws IOException {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101, f(a(r100)));
        if (r100.isDirectory() == false) goto L8;
        if (b(r104) == true) goto L27;
        return 1;
    L27:
        return r102;
    L8:
        if (c(r104) == true) goto L10;
        return 1;
    L10:
        PolarisFileOutputStreamWrapper r105 = null;
        BufferedInputStream r106 = new BufferedInputStream(r110.getInputStream(r100));     // Catch: Throwable -> L34
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L32
        BufferedOutputStream r111 = new BufferedOutputStream(r107);     // Catch: Throwable -> L30
        byte[] r108 = new byte[1024];     // Catch: Throwable -> L28
    L16:
        int r109 = r106.read(r108);     // Catch: Throwable -> L28
        if (r109 == (-1)) goto L26;
        r102 = r102 + ((long) r109);
        if (r102 > r103) goto L21;
        r111.write(r108, 0, r109);     // Catch: Throwable -> L28
        goto L16
    L21:
        IOUtil.closeSecure(r106);
        IOUtil.closeSecure(r111);
        IOUtil.closeSecure(r107);
        return -1;
    L26:
        IOUtil.closeSecure(r106);
        IOUtil.closeSecure(r111);
        IOUtil.closeSecure(r107);
    L28:
        th = move-exception;
        r105 = r107;
        th = th;
    L36:
        IOUtil.closeSecure(r106);
        IOUtil.closeSecure(r111);
        IOUtil.closeSecure(r105);
        throw th;
    L30:
        th = move-exception;
        r111 = null;
        r105 = r107;
        th = th;
    L32:
        th = th;
        r111 = null;
    L34:
        th = th;
        r111 = null;
        r106 = null;
        goto L36
    }

    public static boolean unZip(String r110, String r111, long r112, int r113, boolean r210) throws SecurityCommonException {
        boolean r100 = false;
        if (a(r110, r111, r112, r113, null, r113) == true) goto L5;
        return false;
    L5:
        String r101 = h(r111);
        ArrayList r114 = new ArrayList();
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r115 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L40 IOException -> L42
        ZipInputStream r116 = new ZipInputStream(new BufferedInputStream(r115));     // Catch: Throwable -> L34 IOException -> L37
        long r103 = 0;
    L57:
        ZipEntry r104 = r116.getNextEntry();     // Catch: Throwable -> L30 IOException -> L32
        if (r104 == null) goto L28;
        String r105 = r104.getName().replaceAll("\\\\", HTTP.URL_DEFAULT);     // Catch: Throwable -> L30 IOException -> L32
        if (a(r105) == false) goto L29;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101, r105);     // Catch: Throwable -> L30 IOException -> L32
        if (r210 == true) goto L21;
        if (r106.exists() == false) goto L21;
        if (r106.isFile() == true) goto L57;
    L21:
        a(r210, r106);     // Catch: Throwable -> L30 IOException -> L32
        if (a(r104, r106, r114) == true) goto L57;
        a(r106);     // Catch: Throwable -> L30 IOException -> L32
        r103 = a(r106, r116, r103, r112, r114);     // Catch: Throwable -> L30 IOException -> L32
        r116.closeEntry();     // Catch: Throwable -> L30 IOException -> L32
        if (r103 >= 0) goto L57;
    L29:
        a(r115, r116);
    L47:
        if (r100 == true) goto L49;
        a(r114);
    L49:
        return r100;
    L28:
        r100 = true;
        goto L29
    L32:
        e = e;
    L39:
        r102 = r115;
    L53:
        LogsUtil.e(f278231a, "Unzip IOException : " + e.getMessage());     // Catch: Throwable -> L50
        a(r102, r116);
    L50:
        th = th;
    L51:
        a(r102, r116);
        throw th;
    L30:
        th = th;
    L36:
        r102 = r115;
        goto L51
    L37:
        e = e;
        r116 = null;
    L34:
        th = th;
        r116 = null;
        goto L36
    L42:
        e = e;
        r116 = null;
    L40:
        th = th;
        r116 = null;
        goto L51
    }

    public static List<File> unZipNew(String r100, String r101, long r110, int r111, boolean r112) throws SecurityCommonException {
        return unZipWithFilter(r100, r101, r110, r111, r112, null, r111);
    }

    private static long a(File r110, ZipInputStream r111, long r112, long r113, List<File> r210) throws IOException {
        byte[] r100 = new byte[4096];
        long r101 = -1;
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L26 IOException -> L28
    L44:
        BufferedOutputStream r104 = new BufferedOutputStream(r103);     // Catch: Throwable -> L20 IOException -> L23
        long r105 = r112;
    L42:
        int r114 = r111.read(r100, 0, 4096);     // Catch: Throwable -> L16 IOException -> L18
        if (r114 == (-1)) goto L14;
        r105 = r105 + ((long) r114);     // Catch: Throwable -> L16 IOException -> L18
        if (r105 > r113) goto L11;
        r104.write(r100, 0, r114);     // Catch: Throwable -> L16 IOException -> L18
        goto L42
    L11:
        r105 = -1;
    L14:
        r210.add(r110);     // Catch: Throwable -> L16 IOException -> L18
        r104.flush();     // Catch: Throwable -> L16 IOException -> L18
        r101 = r105;
    L33:
        IOUtil.closeSecure(r104);
        IOUtil.closeSecure(r103);
        return r101;
    L18:
        e = e;
    L25:
        r102 = r103;
    L38:
        LogsUtil.e(f278231a, "Unzip IOException : " + e.getMessage());     // Catch: Throwable -> L35
        r103 = r102;
    L35:
        th = th;
    L36:
        IOUtil.closeSecure(r104);
        IOUtil.closeSecure(r102);
        throw th;
    L16:
        th = th;
    L22:
        r102 = r103;
        goto L36
    L23:
        e = e;
        r104 = null;
    L20:
        th = th;
        r104 = null;
    L28:
        e = e;
        r104 = null;
    L26:
        th = th;
        r104 = null;
        goto L36
    }

    private static int a(ZipEntry r100, List<File> r101, File r102, boolean r103, FilenameFilter r104) {
        if (TextUtils.isEmpty(r100.getName()) == false) goto L5;
        return 1;
    L5:
        String r105 = a(r100);
        if (g(r105) == false) goto L9;
        e(r105);
        return -1;
    L9:
        String r106 = f(r105);
        if (r104 != null) goto L12;
    L14:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102, r106);
        if (r103 == false) goto L17;
    L21:
        if (r103 == true) goto L23;
    L27:
        r101.add(r107);
        return 0;
    L23:
        if (r107.exists() == false) goto L27;
        if (r107.isFile() == false) goto L27;
        f(r107);
        goto L27
    L17:
        if (r107.exists() == false) goto L21;
        if (r107.isFile() == false) goto L21;
        return 1;
    L12:
        if (r104.accept(r102, r106) == true) goto L14;
        return 1;
    }

    private static List<File> a(File r110, File r111, long r112, boolean r210, boolean r211, FilenameFilter r212) {
        ArrayList r100 = new ArrayList();
        boolean r101 = false;
        ZipFile r102 = null;
        ZipFile r113 = b(r211, r110);     // Catch: Throwable -> L36 IOException -> L38
        Enumeration<? extends ZipEntry> r114 = r113.entries();     // Catch: Throwable -> L32 IOException -> L34
        long r103 = 0;
    L6:
        if (r114.hasMoreElements() == false) goto L30;
        ZipEntry r104 = r114.nextElement();     // Catch: IllegalArgumentException -> L22 Throwable -> L32 IOException -> L34
        int r105 = a(r104, r100, r111, r210, r212);     // Catch: Throwable -> L32 IOException -> L34
        if (r105 == (-1)) goto L31;
        if (r105 == 1) goto L6;
        r103 = a(r104, r111, r103, r112, r113);     // Catch: Throwable -> L32 IOException -> L34
        if (r103 == 1) goto L17;
        if (r103 != (-1)) goto L6;
    L17:
        IOUtil.closeSecure(r113);
        a(false, r100);
        return null;
    L31:
        IOUtil.closeSecure(r113);
        a(r101, r100);
    L41:
        return r100;
    L22:
        e = move-exception;
        LogsUtil.i(f278231a, "not a utf8 zip file, IllegalArgumentException : " + e.getMessage());     // Catch: Throwable -> L32 IOException -> L34
        if (Build.VERSION.SDK_INT >= 24) goto L25;
        LogsUtil.e(f278231a, "File is not a utf8 zip file and Build.VERSION_CODES < 24");     // Catch: Throwable -> L32 IOException -> L34
        goto L6
    L25:
        List<File> r106 = a(r110, r111, r112, r210, true, r212);     // Catch: Throwable -> L32 IOException -> L34
        IOUtil.closeSecure(r113);
        a(true, r100);
        return r106;
    L30:
        r101 = true;
    L34:
        e = e;
        r102 = r113;
    L47:
        e.getMessage();     // Catch: Throwable -> L42
        IOUtil.closeSecure(r102);
        a(false, r100);
    L42:
        th = th;
    L43:
        IOUtil.closeSecure(r102);
        a(r101, r100);
        throw th;
    L32:
        th = th;
        r102 = r113;
    L37:
        r101 = true;
        goto L43
    L38:
        e = e;
    L36:
        th = th;
        goto L37
    }

    private static boolean a(String r110, String r111, long r112, int r113, FilenameFilter r114, int r115) throws SecurityCommonException {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L20:
        LogsUtil.e(f278231a, "zip file is not valid");
        return false;
    L5:
        if (g(r110) == true) goto L20;
        if (TextUtils.isEmpty(r111) == false) goto L10;
    L18:
        LogsUtil.e(f278231a, "target directory is not valid");
        return false;
    L10:
        if (g(r111) == true) goto L18;
        if (a(r110, new PolarisFileWrapper(r111), r112, r113, false, r114, r115) == false) goto L16;
        return true;
    L16:
        LogsUtil.e(f278231a, "zip file contains valid chars or too many files");
        throw new SecurityCommonException("unsecure zipfile!");
    }

    private static boolean a(String r210, File r211, long r212, int r213, boolean r214, FilenameFilter r215, int r216) {
        PolarisZipFileWrapper r100 = null;
        if (r214 == true) goto L10;
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r210);     // Catch: Throwable -> L6 IOException -> L8
    L5:
        PolarisZipFileWrapper r110 = r101;
        Enumeration<? extends ZipEntry> r102 = r110.entries();     // Catch: Throwable -> L47 IOException -> L49
        long r103 = 0;
        boolean r104 = true;
        int r105 = 0;
        int r106 = 0;
    L14:
        if (r102.hasMoreElements() == false) goto L44;
        ZipEntry r111 = r102.nextElement();     // Catch: IllegalArgumentException -> L38 Throwable -> L47 IOException -> L49
        long r112 = r111.getSize();     // Catch: Throwable -> L47 IOException -> L49
        String r107 = r111.getName();     // Catch: Throwable -> L47 IOException -> L49
        if (r215 == null) goto L22;
        if (r215.accept(r211, r107) == true) goto L22;
    L23:
        r105 = r105 + 1;     // Catch: Throwable -> L47 IOException -> L49
        if (g(r107) == true) goto L31;
        if (r105 >= r216) goto L31;
        if (r106 >= r213) goto L31;
        boolean r108 = false;
    L32:
        if (r108 == true) goto L37;
        if (r103 > r212) goto L37;
        if (r111.getSize() != (-1)) goto L14;
    L37:
        LogsUtil.e(f278231a, "File name is invalid or too many files or too big");     // Catch: Throwable -> L47 IOException -> L49
        boolean r113 = false;
    L65:
        r110.close();     // Catch: IOException -> L64
        return r113;
    L56:
        LogsUtil.e(f278231a, "close zipFile IOException ");
        return r113;
    L31:
        r108 = true;
    L22:
        r103 = r103 + r112;     // Catch: Throwable -> L47 IOException -> L49
        r106 = r106 + 1;     // Catch: Throwable -> L47 IOException -> L49
    L38:
        e = move-exception;
        LogsUtil.i(f278231a, "not a utf8 zip file, IllegalArgumentException : " + e.getMessage());     // Catch: Throwable -> L47 IOException -> L49
        if (Build.VERSION.SDK_INT >= 24) goto L41;
        LogsUtil.e(f278231a, "File is not a utf8 zip file and Build.VERSION_CODES < 24");     // Catch: Throwable -> L47 IOException -> L49
        r104 = false;
        goto L14
    L41:
        r104 = a(r210, r211, r212, r213, true, r215, r216);     // Catch: Throwable -> L47 IOException -> L49
    L44:
        r113 = r104;
    L49:
        e = e;
        r100 = r110;
    L51:
        LogsUtil.e(f278231a, "not a valid zip file, IOException : " + e.getMessage());     // Catch: Throwable -> L6
        if (r100 != null) goto L69;
    L57:
        return false;
    L69:
        r100.close();     // Catch: IOException -> L55
    L55:
        r113 = false;
    L47:
        th = th;
        r100 = r110;
    L59:
        if (r100 != null) goto L71;
    L63:
        throw th;
    L71:
        r100.close();     // Catch: IOException -> L62
    L62:
        LogsUtil.e(f278231a, "close zipFile IOException ");
        goto L63
    L10:
        LogsUtil.i(f278231a, "not a utf8 zip file, use gbk open zip file : " + r210);     // Catch: Throwable -> L6 IOException -> L8
        r101 = new PolarisZipFileWrapper(r210, Charset.forName("GBK"));     // Catch: Throwable -> L6 IOException -> L8
    L8:
        e = e;
    L6:
        th = th;
        goto L59
    }

    public static List<File> unZipWithFilter(String r100, String r101, long r102, int r110, boolean r111, FilenameFilter r112, int r113) throws SecurityCommonException {
        if (a(r100, r101, r102, r110, r112, r113) == true) goto L5;
        return null;
    L5:
        String r114 = File.separator;
        if (r101.endsWith(r114) == true) goto L8;
    L10:
        File r103 = d(r100);
        File r104 = d(r101);
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        return a(r103, r104, r102, r111, false, r112);
    L16:
        return null;
    L8:
        if (r101.length() <= r114.length()) goto L10;
        r101 = r101.substring(0, r101.length() - r114.length());
        goto L10
    }
}
