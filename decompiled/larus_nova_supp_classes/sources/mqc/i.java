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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i {
    public static String a;
    public static String b;

    public static void a(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void b(PolarisZipFileWrapper r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void e(File r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.exists() == false) goto L25;
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        Files.walkFileTree(Paths.get(r3.getAbsolutePath(), new String[0]), new k());     // Catch: IOException -> L20
        return;
    L27:
        return;
    L12:
        if (r3.isDirectory() == false) goto L18;
        File[] r0 = r3.listFiles();
        if (r0 == null) goto L18;
    L16:
        if (r2 >= r0.length) goto L18;
        e(r0[r2]);
        r2 = r2 + 1;
    L18:
        r3.delete();
        return;
    }

    public static void c(String r8, String r9) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8);
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9);
        if (r0.exists() == false) goto L36;
        if (r0.isDirectory() == false) goto L34;
        if (r10.exists() == true) goto L10;
        r10.mkdirs();
    L10:
        if (r10.isDirectory() == false) goto L32;
        File[] r11 = r0.listFiles();
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.length == 0) goto L42;
        int r1 = r11.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L43;
        File r3 = r11[r2];
        String r4 = r10 + File.separator + r3.getName();
        if (r3.isDirectory() == false) goto L22;
        c(r3.getAbsolutePath(), r4);
    L29:
        r2 = r2 + 1;
        goto L17
    L22:
        if (new PolarisFileWrapper(r4).exists() == true) goto L29;
        BufferedInputStream r5 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r3));
        BufferedOutputStream r6 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r4));
        byte[] r7 = new byte[8192];
    L25:
        int r12 = r5.read(r7);
        if (r12 == (-1)) goto L28;
        r6.write(r7, 0, r12);
        goto L25
    L28:
        r6.close();
        r5.close();
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

    public static void d(InputStream r3, PolarisFileOutputStreamWrapper r4) throws IOException {
        if (r3 == null) goto L13;
        BufferedInputStream r0 = new BufferedInputStream(r3);
        BufferedOutputStream r5 = new BufferedOutputStream(r4);
        byte[] r6 = new byte[1048576];     // Catch: Throwable -> L10
    L5:
        int r1 = r0.read(r6);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L8;
        r5.write(r6, 0, r1);     // Catch: Throwable -> L10
        goto L5
    L8:
        r5.flush();     // Catch: Throwable -> L10
        r0.close();
        r5.close();
        return;
    L10:
        th = move-exception;
        r0.close();
        r5.close();
        throw th;
    }
}
