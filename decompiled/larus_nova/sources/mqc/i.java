package mqc;

import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f514950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f514951b;

    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void b(PolarisZipFileWrapper r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void e(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L25;
        int r101 = 0;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        Files.walkFileTree(Paths.get(r100.getAbsolutePath(), new String[0]), new k());     // Catch: IOException -> L20
        return;
    L27:
        return;
    L12:
        if (r100.isDirectory() == false) goto L18;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L18;
    L16:
        if (r101 >= r102.length) goto L18;
        e(r102[r101]);
        r101 = r101 + 1;
    L18:
        r100.delete();
        return;
    }

    public static void c(String r100, String r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L36;
        if (r102.isDirectory() == false) goto L34;
        if (r103.exists() == true) goto L10;
        r103.mkdirs();
    L10:
        if (r103.isDirectory() == false) goto L32;
        File[] r104 = r102.listFiles();
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.length == 0) goto L42;
        int r105 = r104.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L43;
        File r107 = r104[r106];
        String r108 = r103 + File.separator + r107.getName();
        if (r107.isDirectory() == false) goto L22;
        c(r107.getAbsolutePath(), r108);
    L29:
        r106 = r106 + 1;
        goto L17
    L22:
        if (new PolarisFileWrapper(r108).exists() == true) goto L29;
        BufferedInputStream r109 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r107));
        BufferedOutputStream r110 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r108));
        byte[] r111 = new byte[8192];
    L25:
        int r112 = r109.read(r111);
        if (r112 == (-1)) goto L28;
        r110.write(r111, 0, r112);
        goto L25
    L28:
        r110.close();
        r109.close();
        goto L29
    L43:
        return;
    L42:
        return;
    L32:
        throw new Exception("目标文件夹不是目录");
    L34:
        throw new Exception("源文件夹不是目录");
    L36:
        throw new Exception("文件夹不存在");
    }

    public static void d(InputStream r100, PolarisFileOutputStreamWrapper r101) throws IOException {
        if (r100 == null) goto L13;
        BufferedInputStream r102 = new BufferedInputStream(r100);
        BufferedOutputStream r103 = new BufferedOutputStream(r101);
        byte[] r104 = new byte[1048576];     // Catch: Throwable -> L10
    L5:
        int r105 = r102.read(r104);     // Catch: Throwable -> L10
        if (r105 == (-1)) goto L8;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L10
        goto L5
    L8:
        r103.flush();     // Catch: Throwable -> L10
        r102.close();
        r103.close();
        return;
    L10:
        th = move-exception;
        r102.close();
        r103.close();
        throw th;
    }
}
