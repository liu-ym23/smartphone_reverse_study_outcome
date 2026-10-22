package hc4;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import qb4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length <= 0) goto L14;
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = r100.length;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= r103) goto L10;
        byte r106 = r100[r104];
        int r107 = r105 + 1;
        r102[r105] = r101[(r106 >>> 4) & 15];
        r105 = r107 + 1;
        r102[r107] = r101[r106 & 15];
        r104 = r104 + 1;
        goto L7
    L10:
        return new String(r102);
    L14:
        return "";
    }

    public static void e(String r100) {
        f(new PolarisFileWrapper(r100));
    }

    public static boolean f(File r100) {
        int r101 = 0;
        if (r100.exists() == true) goto L6;
        return false;
    L6:
        if (r100.isFile() == false) goto L10;
        return r100.delete();
    L10:
        if (r100.isDirectory() == false) goto L19;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L19;
        if (r102.length <= 0) goto L19;
    L16:
        if (r101 >= r102.length) goto L19;
        f(r102[r101]);
        r101 = r101 + 1;
    L19:
        return r100.delete();
    }

    public static String g(File r100) {
        if (r100.exists() == true) goto L5;
    L39:
        return "";
    L5:
        if (r100.isFile() == false) goto L39;
        byte[] r101 = new byte[8192];
        BufferedInputStream r102 = null;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L22 Exception -> L24
        BufferedInputStream r104 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L22 Exception -> L24
    L50:
        int r105 = r104.read(r101);     // Catch: Throwable -> L18 Exception -> L20
        if (r105 == (-1)) goto L12;
        r103.update(r101, 0, r105);     // Catch: Throwable -> L18 Exception -> L20
        goto L50
    L12:
        String r106 = a(r103.digest());     // Catch: Throwable -> L18 Exception -> L20
        r104.close();     // Catch: Exception -> L15
    L17:
        return r106;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
        r102 = r104;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r102 != null) goto L48;
    L31:
        return "";
    L48:
        r102.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = th;
    L33:
        if (r104 != null) goto L40;
    L38:
        throw th;
    L40:
        r104.close();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L22:
        th = th;
        r104 = r102;
    L24:
        e = e;
        goto L25
    }

    public static File b(InputStream r100, PolarisFileWrapper r101) {
        if (r100 != null) goto L4;
    L36:
        return r101;
    L4:
        if (r101.exists() == true) goto L36;
        File r102 = r101.getParentFile();
        if (r102.exists() == true) goto L9;
        r102.mkdirs();
    L9:
        PolarisFileOutputStreamWrapper r103 = null;
        byte[] r104 = new byte[8192];     // Catch: Throwable -> L21 Exception -> L23
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L21 Exception -> L23
    L45:
        int r106 = r100.read(r104);     // Catch: Throwable -> L17 Exception -> L19
        if (r106 == (-1)) goto L15;
        r105.write(r104, 0, r106);     // Catch: Throwable -> L17 Exception -> L19
    L15:
        r100.close();     // Catch: Exception -> L27
        r105.close();     // Catch: Exception -> L27
    L40:
    L29:
        return r101;
    L19:
        e = e;
        r103 = r105;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        r100.close();     // Catch: Exception -> L27
        r103.close();     // Catch: Exception -> L27
    L17:
        th = th;
    L43:
        r100.close();     // Catch: Exception -> L33
        r105.close();     // Catch: Exception -> L33
    L35:
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        r105 = r103;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public static File c(InputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r100 == null) goto L10;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        b(r100, r102);
        return r102;
    L10:
        return null;
    L8:
        return null;
    }

    public static boolean d(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L36:
        int r102 = n.f532367a;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L36;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L10;
        r103.mkdirs();
    L10:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);
        if (r104.exists() == true) goto L38;
        return false;
    L38:
        PolarisZipFileWrapper r105 = new PolarisZipFileWrapper(r104);     // Catch: Exception -> L33
        Enumeration<? extends ZipEntry> r106 = r105.entries();     // Catch: Exception -> L33
    L14:
        if (r106.hasMoreElements() == false) goto L31;
        ZipEntry r107 = r106.nextElement();     // Catch: Exception -> L33
        if (r107.getName() == null) goto L22;
        if (r107.getName().contains(DownloadConstants.VULNERABILITY_PATH + File.separator) == true) goto L14;
    L22:
        if (r107.isDirectory() == true) goto L14;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r101, r107.getName());     // Catch: Exception -> L33
        File r109 = r108.getParentFile();     // Catch: Exception -> L33
        if (r109.exists() == true) goto L27;
        r109.mkdirs();     // Catch: Exception -> L33
    L27:
        if (r108.getCanonicalPath().startsWith(r103.getCanonicalPath()) == false) goto L14;
        b(r105.getInputStream(r107), r108);     // Catch: Exception -> L33
        goto L14
    L31:
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static Pair h(File r100, PolarisFileWrapper r101) {
        if (r100.exists() == false) goto L83;
        if (r100.isDirectory() == false) goto L83;
        if (r101.exists() == false) goto L10;
    L13:
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L16;
        int r103 = r102.length;
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L81;
        File r105 = r102[r104];
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101, r105.getName());
        if (r105.isDirectory() == true) goto L22;
        File r107 = r106.getParentFile();
        if (r107 != null) goto L28;
    L32:
        PolarisFileInputStreamWrapper r108 = null;
        PolarisFileOutputStreamWrapper r109 = null;
        PolarisFileOutputStreamWrapper r110 = null;
        r108 = null;
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper(r105);     // Catch: Throwable -> L52 Exception -> L54
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r106);     // Catch: Throwable -> L47 Exception -> L49
    L92:
        byte[] r113 = new byte[4096];     // Catch: Throwable -> L43 Exception -> L45
    L37:
        int r114 = r111.read(r113);     // Catch: Throwable -> L43 Exception -> L45
        if (r114 <= 0) goto L40;
        r112.write(r113, 0, r114);     // Catch: Throwable -> L43 Exception -> L45
        goto L37
    L40:
        r111.close();     // Catch: Throwable -> L43 Exception -> L45
        r112.close();     // Catch: Throwable -> L43 Exception -> L45
        r111.close();     // Catch: Exception -> L59
    L62:
        r112.close();     // Catch: Exception -> L59
    L65:
        boolean r115 = true;
    L66:
        if (r115 == true) goto L69;
        return new Pair(Boolean.FALSE, "copy file fail");
    L69:
        r104 = r104 + 1;
    L59:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L45:
        Exception e100 = e;
        r109 = r112;
    L51:
        r112 = r109;
        r108 = r111;
    L84:
        e100.printStackTrace();     // Catch: Throwable -> L70
        if (r108 == null) goto L61;
        r108.close();     // Catch: Exception -> L59
    L61:
        if (r112 == null) goto L65;
    L70:
        th = th;
    L71:
        if (r108 != null) goto L86;
    L75:
        if (r112 == null) goto L79;
        r112.close();     // Catch: Exception -> L73
    L73:
        e = move-exception;
        e.printStackTrace();
    L79:
        throw th;
    L86:
        r108.close();     // Catch: Exception -> L73
    L43:
        th = th;
        r110 = r112;
    L48:
        r112 = r110;
        r108 = r111;
    L49:
        e = move-exception;
        e100 = e;
    L47:
        th = th;
        goto L48
    L54:
        e = move-exception;
        e100 = e;
        r112 = null;
    L52:
        th = th;
        r112 = null;
        goto L71
    L28:
        if (r107.exists() == true) goto L32;
        if (r107.mkdirs() == true) goto L32;
        r115 = false;
        goto L66
    L22:
        if (((Boolean) h(r105, r101).first).booleanValue() == true) goto L69;
        return new Pair(Boolean.FALSE, "copy dir fail");
    L81:
        return new Pair(Boolean.TRUE, "");
    L16:
        return new Pair(Boolean.TRUE, "sourceDir is Empty");
    L10:
        if (r101.mkdirs() == true) goto L13;
        return new Pair(Boolean.FALSE, "make target dir fail");
    L83:
        return new Pair(Boolean.FALSE, "sourceDir not exists");
    }
}
