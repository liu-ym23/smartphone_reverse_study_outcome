package com.huawei.secure.android.common.zip;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.huawei.secure.android.common.zip.config.ZipConfig;
import com.huawei.secure.android.common.zip.exception.UnZipException;
import com.huawei.secure.android.common.zip.exception.ZipParamException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes23.dex */
public class ZipUtil2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278260a = "ZipUtil2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278261b = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f278262c = null;

    static {
        f278262c = new String[]{"\\..", "/..", "..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};
    }

    public ZipUtil2() {
    }

    private static void a(ZipConfig r100) throws ZipParamException {
        if (r100 == null) goto L27;
        if (TextUtils.isEmpty(r100.getZipFile()) == true) goto L25;
        if (c(r100.getZipFile()) == true) goto L23;
        if (r100.isLoadDisk() == false) goto L15;
        if (TextUtils.isEmpty(r100.getTargetDir()) == false) goto L15;
        throw new ZipParamException("zipConfig isLoadDisk param is true, but targetDir is null.");
    L15:
        if (r100.isLoadDisk() == true) goto L17;
        return;
    L17:
        if (c(r100.getTargetDir()) == true) goto L20;
        return;
    L20:
        throw new ZipParamException("zipConfig targetDir path is danger.");
    L23:
        throw new ZipParamException("zipConfig zipFile path is danger.");
    L25:
        throw new ZipParamException("zipConfig zipFile is null.");
    L27:
        throw new ZipParamException("zipConfig is null.");
    }

    private static List<File> b(ZipConfig r110) throws IOException, UnZipException {
        ArrayList r100 = new ArrayList();
        ZipFile r101 = a(r110.isGbkZipFile(), new PolarisFileWrapper(r110.getZipFile()));
        a(r110.getTopSizeThreshold(), r101.size());     // Catch: Throwable -> L66
        Enumeration<? extends ZipEntry> r102 = r101.entries();     // Catch: Throwable -> L66
        long r103 = 0;
    L5:
        if (r102.hasMoreElements() == false) goto L64;
        ZipEntry r104 = r102.nextElement();     // Catch: IllegalArgumentException -> L62 Throwable -> L66
        a(r104);     // Catch: Throwable -> L66
        a(r104, r110);     // Catch: Throwable -> L66
        PolarisFileWrapper r105 = new PolarisFileWrapper(r110.getTargetDir(), b(b(r104)));     // Catch: Throwable -> L66
        r100.add(r105);     // Catch: Throwable -> L66
        a(r110.getFileNumThreshold(), r100.size());     // Catch: Throwable -> L66
        if (r110.isLoadDisk() == false) goto L11;
        a(r104, r105);     // Catch: Throwable -> L66
    L11:
        if (r105.isDirectory() == true) goto L5;
        BufferedInputStream r106 = new BufferedInputStream(r101.getInputStream(r104));     // Catch: Throwable -> L66
        BufferedOutputStream r107 = null;
        if (r110.isLoadDisk() == false) goto L18;
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L54
    L80:
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        if (r108 != null) goto L94;
    L53:
        throw th;     // Catch: Throwable -> L54
    L94:
        r108.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L54
        goto L53
    L20:
        if (r110.isLoadDisk() == false) goto L83;
        r107 = new BufferedOutputStream(r108);     // Catch: Throwable -> L45
    L83:
        byte[] r109 = new byte[4096];     // Catch: Throwable -> L36
    L24:
        int r111 = r106.read(r109);     // Catch: Throwable -> L36
        if (r111 == (-1)) goto L30;
        r103 = r103 + ((long) r111);     // Catch: Throwable -> L36
        a(r110.getTopSizeThreshold(), r103);     // Catch: Throwable -> L36
        if (r107 == null) goto L24;
        r107.write(r109, 0, r111);     // Catch: Throwable -> L36
    L30:
        if (r107 == null) goto L32;
        r107.close();     // Catch: Throwable -> L45
    L32:
        if (r108 == null) goto L34;
        r108.close();     // Catch: Throwable -> L54
    L34:
        r106.close();     // Catch: Throwable -> L66
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r107 != null) goto L96;
    L44:
        throw th;     // Catch: Throwable -> L45
    L96:
        r107.close();     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L45
        goto L44
    L18:
        r108 = null;
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L59
    L61:
        throw th;     // Catch: Throwable -> L66
    L59:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L66
        goto L61
    L63:
        throw new UnZipException("open zip entry error.");     // Catch: Throwable -> L66
    L64:
        r101.close();
        return r100;
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        if (r101 != null) goto L76;
    L74:
        throw th;
    L76:
        r101.close();     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        th.addSuppressed(th);
        goto L74
    }

    private static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String[] r101 = f278262c;
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

    public static String getFileNameLowerSuffix(String r100) {
        int r101 = r100.lastIndexOf(".");
        if (r101 >= 0) goto L7;
        return "";
    L7:
        return r100.substring(r101 + 1).toLowerCase(Locale.ROOT);
    }

    public static List<File> unZipOrCheck(ZipConfig r100) throws ZipParamException, IOException, UnZipException {
        a(r100);
        return b(r100);
    }

    private static void a(ZipEntry r100) throws UnZipException {
        if (TextUtils.isEmpty(r100.getName()) == true) goto L10;
        String r101 = b(r100);
        if (c(r101) == true) goto L8;
        return;
    L8:
        throw new UnZipException("entry is a invalid path: " + a(r101));
    L10:
        throw new UnZipException("entry name is null");
    }

    private static String b(ZipEntry r100) {
        return Normalizer.normalize(r100.getName(), Normalizer.Form.NFKC);
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = r100.lastIndexOf(File.separator);
        if (r101 != (-1)) goto L9;
        return r100;
    L9:
        return r100.substring(r101 + 1);
    }

    private static String b(String r100) {
        return r100.replaceAll("\\\\", HTTP.URL_DEFAULT);
    }

    private static void a(ZipEntry r100, File r101) throws UnZipException, IOException {
        if (r100.isDirectory() == true) goto L5;
        File r102 = r101.getParentFile();
        if (r102 == null) goto L19;
        if (r102.exists() == true) goto L19;
        if (r102.mkdirs() == true) goto L19;
        throw new IOException("mkdir dir error, path is " + r101.getName());
    L19:
        if (r101.createNewFile() == false) goto L22;
        return;
    L22:
        throw new IOException("create file error, name is " + r101.getName());
    L5:
        if (r101.mkdirs() == false) goto L8;
        return;
    L8:
        throw new IOException("mkdir dir error, path is " + r101.getName());
    }

    private static void a(ZipEntry r100, ZipConfig r101) throws UnZipException {
        if (r100.isDirectory() == false) goto L5;
        return;
    L5:
        if (r101.getWhiteListSuffix() == null) goto L7;
    L8:
        String r102 = getFileNameLowerSuffix(r100.getName());
        if (r101.getWhiteListSuffix() == null) goto L16;
        if (Arrays.asList(r101.getWhiteListSuffix()).contains(r102) == false) goto L14;
        return;
    L14:
        throw new UnZipException("entry name suffix is not in whitelist suffix");
    L16:
        if (Arrays.asList(r101.getBlackListSuffix()).contains(r102) == true) goto L19;
        return;
    L19:
        throw new UnZipException("entry name suffix is in blacklist suffix");
    L7:
        if (r101.getBlackListSuffix() != null) goto L8;
    }

    private static ZipFile a(boolean r100, File r101) throws IOException {
        if (r100 == true) goto L6;
        return new PolarisZipFileWrapper(r101, StandardCharsets.UTF_8);
    L6:
        return new PolarisZipFileWrapper(r101, Charset.forName("GBK"));
    }

    private static void a(long r100, long r101) throws UnZipException {
        if (r101 > r100) goto L6;
        return;
    L6:
        throw new UnZipException("over than TopSizeThreshold");
    }

    private static void a(int r100, int r101) throws UnZipException {
        if (r101 > r100) goto L5;
        return;
    L5:
        throw new UnZipException("over than FileNumThreshold");
    }
}
