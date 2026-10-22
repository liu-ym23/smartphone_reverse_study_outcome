package com.bytedance.ee.util.io;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.LarkUriUtil;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.suite.lark.component.storage.ext.content.FileProvider;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f243139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f243140b = null;

    public static class MimeTypeCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[][] f243141a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, String> f243142b = null;

        static {
            f243141a = new String[][]{new String[]{MimeType.ZIP, "application/x-zip-compressed"}};
            f243142b = new AnonymousClass1();
        }
    }

    static {
        String[][] r100 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"3g2", "video/3gpp2"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", MimeType.AVI}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"wbmp", "image/vnd.wap.wbmp"}, new String[]{"webp", MimeType.WEBP}, new String[]{"ico", "image/x-icon"}, new String[]{"c", "text/plain"}, new String[]{"heif", "image/heif"}, new String[]{"heic", "image/heic"}, new String[]{"webm", "video/webm"}, new String[]{"mkv", "video/x-matroska"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"doc", MimeType.DOC}, new String[]{DocumentType.DOCX_NAME, MimeType.DOCX}, new String[]{"xls", MimeType.XLS}, new String[]{"xlsx", MimeType.XLSX}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", MimeType.GIF}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{LoadParams.ImageFormat.JPEG, "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{"jpe", "image/jpeg"}, new String[]{GXTemplateKey.GAIAX_JS, "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", MimeType.MOV}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "audio/x-mpeg"}, new String[]{"mpg4", MimeType.MP4}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mp4", MimeType.MP4}, new String[]{"mpga", MimeType.MP3}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{ExportFileExtension.PDF, MimeType.PDF}, new String[]{LoadParams.ImageFormat.PNG, "image/png"}, new String[]{"pps", MimeType.PPT}, new String[]{"ppt", MimeType.PPT}, new String[]{ExportFileExtension.PPTX, MimeType.PPTX}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", MimeType.WAVX}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/plain"}, new String[]{MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", MimeType.RAR}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        f243139a = new HashMap();
        f243140b = new HashMap();
        int r101 = 0;
    L3:
        if (r101 >= 78) goto L5;
        String[] r102 = r100[r101];
        ((HashMap) f243139a).put(r102[0], r102[1]);
        ((HashMap) f243140b).put(r102[1], r102[0]);
        r101 = r101 + 1;
        goto L3
    }

    public static String A(long r100) {
        DecimalFormat r101 = new DecimalFormat("#.00");
        if (r100 > 0) goto L7;
        return "0 B";
    L7:
        if (r100 >= 1024) goto L10;
        return r101.format(r100) + " B";
    L10:
        if (r100 >= 1048576) goto L13;
        return r101.format(r100 / 1024.0d) + " K";
    L13:
        if (r100 >= 1073741824) goto L16;
        return r101.format(r100 / 1048576.0d) + " M";
    L16:
        return r101.format(r100 / 1.073741824E9d) + " G";
    }

    public static long B(VFSPath r110) {
        VFSFile[] r111 = r110.toFile().listFiles();
        int r100 = r111.length;
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L24;
        VFSFile r103 = r111[r102];
        if (r103.isDirectory() == false) goto L7;
        long r104 = B(r103.getVfsPath());
    L23:
        r101 = r101 + r104;
        r102 = r102 + 1;
        goto L3
    L7:
        VFSPath r105 = r103.getVfsPath();
        if (r105.toFile().exists() == false) goto L22;
        InputStream r112 = null;
        r112 = r105.toFile().newInputStream();     // Catch: Throwable -> L12 IOException -> L14 FileNotFoundException -> L17
        r104 = r112.available();     // Catch: Throwable -> L12 IOException -> L14 FileNotFoundException -> L17
        e(new Closeable[]{r112});
        goto L23
    L12:
        th = move-exception;
        e(new Closeable[]{r112});
        throw th;
    L17:
        e = move-exception;
        tt5.a.d("FileUtils", e.toString());     // Catch: Throwable -> L12
        e(new Closeable[]{r112});
    L14:
        e = move-exception;
        tt5.a.d("FileUtils", e.toString());     // Catch: Throwable -> L12
        e(new Closeable[]{r112});
    L22:
        r104 = 0;
        goto L23
    L24:
        return r101;
    }

    public static String C(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        int r101 = r100.lastIndexOf(46);
        if (r101 > (-1)) goto L9;
        return "";
    L9:
        return r100.substring(r101 + 1);
    }

    public static String D(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "*/*";
    L5:
        String r101 = u(r100);
        String r102 = (String) ((HashMap) f243139a).get(r101);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return "*/*";
    L9:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.ss.android.lark.vfs.VFSPath] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.BufferedReader] */
    public static String E(VFSPath r100) {
        if (r100 != 0) goto L5;
        return "";
    L5:
        if (ay4.d.a().F(r100).exists() == true) goto L50;
        return "";
    L50:
        InputStreamReader r101 = new InputStreamReader(ay4.d.a().F(r100).newInputStream());     // Catch: Throwable -> L25 Exception -> L27
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Throwable -> L21 Exception -> L23
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L19 Throwable -> L38
    L10:
        String r104 = r102.readLine();     // Catch: Exception -> L19 Throwable -> L38
        if (r104 == null) goto L13;
        r103.append(r104);     // Catch: Exception -> L19 Throwable -> L38
        goto L10
    L13:
        String r105 = r103.toString();     // Catch: Exception -> L19 Throwable -> L38
        r101.close();     // Catch: Exception -> L16
        r102.close();     // Catch: Exception -> L16
    L18:
        return r105;
    L16:
        e = move-exception;
        tt5.a.f("FileUtils", e, false);
    L19:
        Exception e100 = e;
    L29:
        tt5.a.f("FileUtils", e100, false);     // Catch: Throwable -> L38
        if (r101 != null) goto L55;
    L34:
        if (r102 == null) goto L64;
        r102.close();     // Catch: Exception -> L32
        return "";
    L32:
        e = move-exception;
        tt5.a.f("FileUtils", e, false);
        return "";
    L64:
        return "";
    L55:
        r101.close();     // Catch: Exception -> L32
        goto L34
    L23:
        e = move-exception;
        e100 = e;
        r102 = null;
    L21:
        th = move-exception;
        Throwable th10 = th;
        r100 = 0;
    L39:
        if (r101 != null) goto L51;
    L43:
        if (r100 == 0) goto L47;
        r100.close();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        tt5.a.f("FileUtils", e, false);
    L47:
        throw th10;
    L51:
        r101.close();     // Catch: Exception -> L41
        goto L43
    L38:
        th10 = th;
    L27:
        e = move-exception;
        r101 = null;
        e100 = e;
        r102 = null;
    L25:
        th = move-exception;
        r101 = null;
        th10 = th;
        r100 = 0;
        goto L39
    }

    public static boolean G(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (UriProtector.parse(r100).getScheme() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean H(VFSPath r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (TextUtils.isEmpty(r100.getRealPath()) == true) goto L7;
        return false;
    }

    public static VFSFile[] L(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == false) goto L14;
        if (r100.toFile().isDirectory() == false) goto L12;
        VFSFile[] r101 = r100.toFile().listFiles();
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw new IOException("Failed to list contents of " + r100.getRealPath());
    L12:
        throw new IllegalArgumentException(r100.getRealPath() + " is not a directory");
    L14:
        throw new IllegalArgumentException(r100.getRealPath() + " does not exist");
    }

    public static void c(VFSPath r100) throws IOException {
        VFSFile[] r101 = L(r100);
        int r102 = r101.length;
        IOException e100 = null;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        p(r101[r103].getVfsPath());     // Catch: IOException -> L7
    L8:
        r103 = r103 + 1;
    L7:
        e100 = e;
        goto L8
    L9:
        if (e100 != null) goto L11;
        return;
    L11:
        throw e100;
    }

    public static void d(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("FileUtils", e, false);
        return;
    }

    public static void e(Closeable... r100) {
        if (r100.length <= 0) goto L15;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L22;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L14;
        r103.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        tt5.a.f("FileUtils", th, false);
    L14:
        r102 = r102 + 1;
        goto L6
    L22:
        return;
    }

    public static void k(VFSPath r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.toFile().exists() == true) goto L7;
        return;
    L7:
        if (r100.toFile().isDirectory() == false) goto L14;
        VFSFile[] r101 = r100.toFile().listFiles();
        if (r101 == null) goto L14;
        int r102 = 0;
    L12:
        if (r102 >= r101.length) goto L14;
        k(r101[r102].getVfsPath());
        r102 = r102 + 1;
    L14:
        r100.toFile().delete();
    }

    public static void l(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L5;
        return;
    L5:
        c(r100);
        if (r100.toFile().delete() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to delete directory " + r100.getRealPath() + ".");
    }

    public static void m(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r100.toFile().isDirectory() == false) goto L9;
        l(r100);
        return;
    L9:
        if (r100.toFile().isFile() == false) goto L13;
        p(r100);
        return;
    }

    public static void n(VFSPath r100) throws IOException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.toFile().exists() == true) goto L7;
        return;
    L7:
        if (r100.toFile().isDirectory() == false) goto L10;
        k(r100);
        return;
    L10:
        if (r100.toFile().isFile() == false) goto L15;
        r100.toFile().delete();
        return;
    }

    public static byte[] o(VFSPath r100) {
        InputStream r101 = null;
        if (r100 != null) goto L42;
        byte[] r102 = null;
    L39:
        d(r101);
        return r102;
    L42:
        InputStream r103 = r100.toFile().newInputStream();     // Catch: Throwable -> L30 Exception -> L32
        int r104 = (int) r100.toFile().length();     // Catch: Throwable -> L25 Exception -> L27
        if (r104 <= Integer.MAX_VALUE) goto L11;
        tt5.a.d("FileUtils", "this file is too large");     // Catch: Throwable -> L25 Exception -> L27
        d(r103);
        return null;
    L11:
        r102 = new byte[r104];     // Catch: Throwable -> L25 Exception -> L27
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L20;
        int r106 = r103.read(r102, r105, r104 - r105);     // Catch: Exception -> L18 Throwable -> L25
        if (r106 < 0) goto L20;
        r105 = r105 + r106;     // Catch: Exception -> L18 Throwable -> L25
    L18:
        e = e;
    L29:
        r101 = r103;
    L34:
        tt5.a.f("FileUtils", e, false);     // Catch: Throwable -> L30
    L20:
        if (r105 >= r104) goto L24;
        tt5.a.d("FileUtils", "file is error");     // Catch: Exception -> L18 Throwable -> L25
        d(r103);
        return null;
    L24:
        r101 = r103;
    L25:
        th = th;
        r101 = r103;
    L36:
        d(r101);
        throw th;
    L27:
        e = e;
        r102 = null;
    L32:
        e = e;
        r102 = null;
    L30:
        th = th;
        goto L36
    }

    public static void p(VFSPath r100) throws IOException {
        if (r100.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r100.toFile().isDirectory() == false) goto L8;
        l(r100);
        return;
    L8:
        boolean r101 = r100.toFile().exists();
        if (r100.toFile().delete() == true) goto L16;
        if (r101 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r100.getRealPath());
    L14:
        throw new IOException("Unable to delete file: " + r100.getRealPath());
    }

    public static List<VFSFile> q(VFSPath r100) {
        ArrayList r101 = new ArrayList();
        VFSFile[] r102 = r100.toFile().listFiles();
        if (r102 != null) goto L5;
        return r101;
    L5:
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r101.add(r102[r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        Collections.sort(r101, new c());
        return r101;
    }

    public static String r(long r100) {
        DecimalFormat r101 = new DecimalFormat("#.00");
        if (r100 > 0) goto L7;
        return "0 Byte";
    L7:
        if (r100 >= 1024) goto L10;
        return r101.format(r100) + " Byte";
    L10:
        if (r100 >= 1048576) goto L13;
        return r101.format(r100 / 1024.0d) + " KB";
    L13:
        if (r100 >= 1073741824) goto L16;
        return r101.format(r100 / 1048576.0d) + " MB";
    L16:
        return r101.format(r100 / 1.073741824E9d) + " GB";
    }

    public static String s(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() <= 0) goto L12;
        int r101 = r100.lastIndexOf(46);
        if (r101 > (-1)) goto L8;
        return r100;
    L8:
        if (r101 < (r100.length() - 1)) goto L10;
        return r100;
    L10:
        return r100.substring(r101 + 1);
    L12:
        return r100;
    }

    public static long t(VFSPath r100) {
        long r101 = 0;
        if (r100.toFile().exists() == true) goto L5;
        return 0;
    L5:
        VFSFile[] r102 = r100.toFile().listFiles();
        int r103 = 0;
    L7:
        if (r103 >= r102.length) goto L13;
        if (r102[r103].isDirectory() == false) goto L11;
        long r104 = t(r102[r103].getVfsPath());
    L12:
        r101 = r101 + r104;
        r103 = r103 + 1;
        goto L7
    L11:
        r104 = 1;
        goto L12
    L13:
        return r101;
    }

    public static String u(String r100) {
        if (r100.lastIndexOf(".") > 0) goto L7;
        return "";
    L7:
        return r100.substring(r100.lastIndexOf(".") + 1, r100.length()).toLowerCase();
    }

    public static long v(VFSPath r100) {
        if (r100 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r100.toFile().exists() == false) goto L14;
        if (r100.toFile().isDirectory() == true) goto L14;
        return Os.lstat(r100.getRealPath()).st_atime * 1000;
    L12:
        e = move-exception;
        tt5.a.e("FileUtils", "getFileLastAccessTime... err happens : ", e, false);
        goto L14
    }

    public static long y(String r100) {
        VFSFile r101 = ay4.d.a().i(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r101.exists() == false) goto L12;
        return r101.length();
    L12:
        return 0;
    }

    public static boolean F(boolean r100, String r101) {
        if (r100 == false) goto L10;
        Application r102 = eu5.b.f474075a;
        if (r102 != null) goto L8;
        tt5.a.k("FileUtils", "isFileExists failed because baseApplication is null");
        return false;
    L8:
        return LarkUriUtil.m(r102, UriProtector.parse(r101));
    L10:
        return ay4.d.a().i(r101).exists();
    }

    public static boolean a(byte[] r100, VFSPath r101) {
        OutputStream r102 = null;
        if (r100 != null) goto L20;
    L18:
        d(r102);
        return true;
    L20:
        if (r101 == null) goto L18;
    L12:
        e = move-exception;
        tt5.a.f("FileUtils", e, false);     // Catch: Throwable -> L10
        d(r102);
        return false;
    L6:
        if (r101.toFile().exists() == false) goto L8;
        r101.toFile().delete();     // Catch: Throwable -> L10 Exception -> L12
    L8:
        r102 = r101.toFile().newOutputStream();     // Catch: Throwable -> L10 Exception -> L12
        r102.write(r100);     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        d(r102);
        throw th;
    }

    public static void b(VFSPath r100, VFSPath r101) throws FileNotFoundException {
        if (r100 == null) goto L12;
        if (r101 == null) goto L10;
        if (r100.toFile().exists() == false) goto L8;
        return;
    L8:
        throw new FileNotFoundException("Source '" + r100.getRealPath() + "' does not exist");
    L10:
        throw new NullPointerException("Destination must not be null");
    L12:
        throw new NullPointerException("Source must not be null");
    }

    public static void g(VFSPath r100, VFSPath r101) throws IOException {
        b(r100, r101);
        if (r100.toFile().isDirectory() == false) goto L31;
        if (r100.toFile().getCanonicalPath().equals(r101.toFile().getCanonicalPath()) == true) goto L29;
        if (r101.toFile().exists() == true) goto L9;
    L13:
        String[] r102 = r100.toFile().list();
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.length <= 0) goto L36;
        int r103 = r102.length;
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L37;
        String r105 = r102[r104];
        VFSPath r106 = r100.subPath(r105);
        VFSPath r107 = r101.subPath(r105);
        if (r106.toFile().isDirectory() == false) goto L23;
        r107.toFile().mkdirs();
        g(r106, r107);
    L24:
        r104 = r104 + 1;
        goto L18
    L23:
        if (j(r106, r107) == true) goto L24;
        throw new IOException("copyFile Error " + r106.getRealPath() + " " + r107.getRealPath());
    L37:
        return;
    L36:
        return;
    L9:
        if (r101.toFile().canWrite() == true) goto L13;
        throw new IOException("Destination '" + r101.getRealPath() + "' exists but is read-only");
    L29:
        throw new IOException("Source '" + r100.getRealPath() + "' and destination '" + r101.getRealPath() + "' are the same");
    L31:
        throw new IOException("Source '" + r100.getRealPath() + "' exists but is not a directory");
    }

    public static void h(InputStream r100, OutputStream r101) {
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L9 IOException -> L11
    L4:
        int r103 = r100.read(r102);     // Catch: Throwable -> L9 IOException -> L11
        if (r103 <= 0) goto L8;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L9 IOException -> L11
    L8:
        com.larksuite.framework.utils.d.b(new Closeable[]{r100});
        com.larksuite.framework.utils.d.b(new Closeable[]{r101});
        return;
    L11:
        e = move-exception;
        tt5.a.e("FileUtils", "Copy file exception, ", e, false);     // Catch: Throwable -> L9
        com.larksuite.framework.utils.d.b(new Closeable[]{r100});
        com.larksuite.framework.utils.d.b(new Closeable[]{r101});
        return;
    L9:
        th = move-exception;
        com.larksuite.framework.utils.d.b(new Closeable[]{r100});
        com.larksuite.framework.utils.d.b(new Closeable[]{r101});
        throw th;
    }

    public static boolean j(VFSPath r210, VFSPath r211) throws IOException {
        b(r210, r211);
        if (r210.toFile().isDirectory() == true) goto L93;
        if (r210.toFile().getCanonicalPath().equals(r211.toFile().getCanonicalPath()) == true) goto L91;
        File r100 = r211.toFile().getParentFile();
        if (r100 == null) goto L16;
        if (r100.mkdirs() == true) goto L16;
        if (r100.isDirectory() == true) goto L16;
        throw new IOException("Destination '" + r100 + "' directory cannot be created");
    L16:
        if (r211.toFile().exists() == true) goto L18;
    L22:
        VFSFile r101 = r210.toFile();
        VFSFile r102 = r211.toFile();
        if (r102.exists() == true) goto L25;
    L29:
        int r103 = 0;
        int r104 = 0;
        boolean r105 = false;
        FileChannel r106 = null;
        FileChannel r107 = null;
        r107 = null;
        r107 = null;
        r106 = null;
        r107 = null;
        PolarisFileInputStreamWrapper r110 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L62 IOException -> L65
    L101:
        PolarisFileOutputStreamWrapper r111 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L57 IOException -> L59
        FileChannel r112 = r110.getChannel();     // Catch: Throwable -> L53 IOException -> L55
    L99:
        r107 = r111.getChannel();     // Catch: Throwable -> L49 IOException -> L51
        long r113 = r112.size();     // Catch: Throwable -> L49 IOException -> L51
        long r212 = 0;
    L35:
        if (r212 >= r113) goto L45;
        long r114 = r113 - r212;     // Catch: Throwable -> L49 IOException -> L51
        if (r114 <= 31457280) goto L39;
        long r115 = 31457280;
    L40:
        long r116 = r107.transferFrom(r112, r212, r115);     // Catch: Throwable -> L49 IOException -> L51
    L42:
        if (r116 == 0) goto L45;
        r212 = r212 + r116;
        goto L35
    L39:
        r115 = r114;
    L45:
        Closeable[] r108 = {r107, r111, r112, r110};
    L46:
        if (r104 >= 4) goto L48;
        d(r108[r104]);
        r104 = r104 + 1;
        goto L46
    L48:
        r105 = true;
    L73:
        long r109 = r101.length();
        long r117 = r102.length();
        if (r109 != r117) goto L78;
        r102.setLastModified(r101.lastModified());
        return r105;
    L78:
        throw new IOException("Failed to copy full contents from '" + r101 + "' to '" + r102 + "' Expected length: " + r109 + " Actual: " + r117);
    L51:
        e = e;
        PolarisFileOutputStreamWrapper r118 = r111;
        FileChannel r119 = r107;
        r106 = r112;
    L94:
    L80:
        th = th;
        r112 = r106;
        r107 = r119;
        r111 = r118;
    L86:
        Closeable[] r120 = {r107, r111, r112, r110};
    L87:
        if (r103 >= 4) goto L89;
        d(r120[r103]);
        r103 = r103 + 1;
        goto L87
    L89:
        throw th;
    L82:
        e = move-exception;
        iu5.d.a("FileUtils", e);     // Catch: Throwable -> L80
        throw e;     // Catch: Throwable -> L80
    L68:
        if (Build.VERSION.SDK_INT < 26) goto L79;
        tt5.a.h("FileUtils", "Use Files copy method");     // Catch: Throwable -> L80 IOException -> L82
        Files.copy(r101.toPath(), r102.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L80 IOException -> L82
        Closeable[] r121 = {r119, r118, r106, r110};
        int r122 = 0;
    L71:
        if (r122 >= 4) goto L73;
        d(r121[r122]);
        r122 = r122 + 1;
        goto L71
    L79:
        throw e;     // Catch: Throwable -> L80 IOException -> L82
    L49:
        th = th;
    L55:
        e = e;
    L61:
        r118 = r111;
        r119 = null;
    L53:
        th = th;
        r112 = null;
        goto L86
    L59:
        e = e;
        r111 = null;
    L57:
        th = th;
    L64:
        r111 = null;
        r112 = null;
    L65:
        e = e;
        r110 = null;
        r119 = null;
        r118 = null;
    L62:
        th = th;
        r110 = null;
        goto L64
    L25:
        if (r102.isDirectory() == false) goto L29;
        throw new IOException("Destination '" + r102 + "' exists but is a directory");
    L18:
        if (r211.toFile().canWrite() == true) goto L22;
        throw new IOException("Destination '" + r211.getRealPath() + "' exists but is read-only");
    L91:
        throw new IOException("Source '" + r210.getRealPath() + "' and destination '" + r211.getRealPath() + "' are the same");
    L93:
        throw new IOException("Source '" + r210.getRealPath() + "' exists but is a directory");
    }

    public static long w(boolean r100, String r101) {
        if (r100 == false) goto L14;
        Application r102 = eu5.b.f474075a;
        if (r102 != null) goto L7;
        tt5.a.k("FileUtils", "getFileLastAccessTime failed because baseApplication is null");
        return 0;
    L7:
        Long r103 = LarkUriUtil.k(r102, UriProtector.parse(r101));
        if (r103 != null) goto L12;
        tt5.a.k("FileUtils", "getFileLastAccessTime failed");
        return 0;
    L12:
        return r103.longValue();
    L14:
        return v(ay4.d.a().z(r101));
    }

    public static String x(boolean r100, String r101) {
        if (r100 == false) goto L13;
        Application r102 = eu5.b.f474075a;
        if (r102 != null) goto L7;
        tt5.a.k("FileUtils", "getFileName failed because baseApplication is null");
        return "";
    L7:
        String r103 = LarkUriUtil.e(r102, UriProtector.parse(r101));
        if (r103 != null) goto L11;
        tt5.a.k("FileUtils", "getFileName failed.");
        return "";
    L11:
        return r103;
    L13:
        return ay4.d.a().z(r101).getName();
    }

    public static long z(boolean r100, String r101) {
        if (r100 == false) goto L10;
        Application r102 = eu5.b.f474075a;
        if (r102 != null) goto L8;
        tt5.a.k("FileUtils", "getFileSize failed because baseApplication is null");
        return -1;
    L8:
        return LarkUriUtil.h(r102, UriProtector.parse(r101));
    L10:
        return ay4.d.a().i(r101).length();
    }

    public static void I(Context r100, VFSPath r101, String r102) {
        if (r101 != null) goto L4;
    L13:
        LKUIToast.show(r100, R.string.Doc_Util_OpenFail);
        return;
    L4:
        if (r101.toFile().exists() == false) goto L13;
        if (J(r100, r101, r102) == true) goto L15;
        String r103 = (String) ((HashMap) MimeTypeCompat.f243142b).get(r102);
        if (TextUtils.isEmpty(r103) == false) goto L10;
        LKUIToast.show(r100, R.string.Doc_Util_OpenNoApp);
        return;
    L10:
        if (J(r100, r101, r103) == true) goto L16;
        LKUIToast.show(r100, R.string.Doc_Util_OpenNoApp);
        return;
    L16:
        return;
    }

    public static boolean J(Context r100, VFSPath r101, String r102) {
        tt5.a.b("FileUtils", "openFile: " + r102);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = D(r101.getRealPath());
    L5:
        Intent r103 = new Intent();
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.addFlags(268435456);
        r103.setDataAndType(e.b(r100, r101), r102);
        if (Build.VERSION.SDK_INT < 24) goto L13;
        r103.addFlags(1);
        r103.addFlags(2);
    L13:
        r100.startActivity(r103);     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        tt5.a.k("FileUtils", "openFile: " + e.getMessage());
        return false;
    }

    public static void K(Context r100, VFSPath r101, String r102) {
        tt5.a.b("FileUtils", "openFile: ");
        String r103 = "";
        if (TextUtils.isEmpty("") == false) goto L5;
        r103 = D(r101.getRealPath());
    L5:
        Intent r104 = new Intent();
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r104.addFlags(268435456);
        Pattern r105 = e.f243146a;
        if (Build.VERSION.SDK_INT >= 24) goto L22;
        Uri r106 = Uri.fromFile(r101.toFile());
    L12:
        r104.setDataAndType(r106, r103);
        if (Build.VERSION.SDK_INT < 24) goto L20;
        r104.addFlags(1);
        r104.addFlags(2);
    L20:
        r100.startActivity(r104);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        tt5.a.k("FileUtils", "openFile: " + e.getMessage());
        return;
    L22:
        r106 = FileProvider.getUriForFile(r100, r102, r101.toFile());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        tt5.a.f("UriUtils", e, false);
        r106 = null;
        goto L12
    }

    public static boolean f(Context r110, String r111, String r112) {
        Closeable r100 = null;
        InputStream r101 = null;
        OutputStream r102 = null;
        r102 = null;
        r100 = null;
        String[] r103 = r110.getAssets().list(r111);     // Catch: Throwable -> L24 Exception -> L26
        if (r103 != null) goto L6;
    L11:
        InputStream r113 = r110.getAssets().open(r111);     // Catch: Throwable -> L24 Exception -> L26
        r102 = ay4.d.a().m(r112);     // Catch: Throwable -> L20 Exception -> L22
        byte[] r114 = new byte[1024];     // Catch: Throwable -> L20 Exception -> L22
    L13:
        int r115 = r113.read(r114);     // Catch: Throwable -> L20 Exception -> L22
        if (r115 == (-1)) goto L16;
        r102.write(r114, 0, r115);     // Catch: Throwable -> L20 Exception -> L22
        goto L13
    L16:
        r102.flush();     // Catch: Throwable -> L20 Exception -> L22
        r113.close();     // Catch: Throwable -> L20 Exception -> L22
        r102.close();     // Catch: Throwable -> L20 Exception -> L22
        r101 = r113;
        OutputStream r116 = r102;
    L18:
        e(new Closeable[]{r101, r116});
        return true;
    L22:
        e = move-exception;
        Closeable r117 = r102;
        r100 = r113;
        e = e;
        Closeable r118 = r117;
    L34:
        tt5.a.f("FileUtils", e, false);     // Catch: Throwable -> L31
        e(new Closeable[]{r100, r118});
        return false;
    L31:
        th = th;
    L32:
        e(new Closeable[]{r100, r118});
        throw th;
    L20:
        th = move-exception;
        Closeable r119 = r102;
        r100 = r113;
        th = th;
        r118 = r119;
        goto L32
    L6:
        if (r103.length <= 0) goto L11;
        ay4.d.a().i(r112).mkdirs();     // Catch: Throwable -> L24 Exception -> L26
        int r104 = r103.length;     // Catch: Throwable -> L24 Exception -> L26
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L10;
        String r106 = r103[r105];     // Catch: Throwable -> L24 Exception -> L26
        f(r110, r111 + HTTP.URL_DEFAULT + r106, r112 + HTTP.URL_DEFAULT + r106);     // Catch: Throwable -> L24 Exception -> L26
        r105 = r105 + 1;     // Catch: Throwable -> L24 Exception -> L26
        goto L8
    L10:
        r116 = null;
    L26:
        e = e;
        r118 = null;
    L24:
        th = th;
        r118 = null;
        goto L32
    }

    public static void i(boolean r100, String r101, VFSPath r102) {
        if (r100 == false) goto L13;
        Application r103 = eu5.b.f474075a;     // Catch: IOException -> L15
        if (r103 != null) goto L8;
        tt5.a.k("FileUtils", "copyFile failed because baseApplication is null");     // Catch: IOException -> L15
        return;
    L8:
        InputStream r104 = ContentResolverWrapper.openInputStream(r103.getContentResolver(), UriProtector.parse(r101));     // Catch: IOException -> L15
        if (r104 == null) goto L11;
        h(r104, r102.toFile().newOutputStream());     // Catch: IOException -> L15
        return;
    L11:
        tt5.a.k("FileUtils", "copyFile failed because inputStream is null");     // Catch: IOException -> L15
        throw new FileNotFoundException("Source uri " + r101 + "' does not exist");     // Catch: IOException -> L15
    L13:
        j(ay4.d.a().z(r101), r102);     // Catch: IOException -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.e("FileUtils", "Copy file exception, ", e, false);
    }
}
