package w87;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void c(File r100) throws IOException {
        if (r100.exists() == false) goto L5;
        return;
    L5:
        d(r100);
        r100.createNewFile();
    }

    public static void d(File r100) {
        File r101 = r100.getParentFile();
        if (r101 == null) goto L9;
        if (r101.exists() == true) goto L10;
        r101.mkdirs();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("it's parent file is null. " + r100.getAbsolutePath());
    }

    public static void delete(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L7;
        return;
    L7:
        if (r100.isFile() == false) goto L10;
        r100.delete();
        return;
    L10:
        if (r100.isDirectory() == false) goto L23;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L14;
    L18:
        r100.delete();
        return;
    L14:
        if (r101.length <= 0) goto L18;
        int r102 = r101.length;
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L18;
        delete(r101[r103]);
        r103 = r103 + 1;
        goto L16
    }

    public static boolean f(File r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.isFile() == true) goto L8;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L12;
        return true;
    L12:
        if (r101.length == 0) goto L17;
        return false;
    L17:
        return true;
    L8:
        return !g(r100);
    }

    public static boolean g(File r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.exists() == false) goto L6;
        return true;
    }

    public static String h(PolarisFileWrapper r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: IOException -> L27
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r103 = new byte[4096];     // Catch: Throwable -> L15
    L7:
        int r104 = r101.read(r103);     // Catch: Throwable -> L15
        if (r104 == (-1)) goto L10;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L15
        goto L7
    L10:
        byte[] r105 = r102.toByteArray();     // Catch: Throwable -> L15
        r102.close();     // Catch: Throwable -> L21
        r101.close();     // Catch: IOException -> L27
        return new String(r105);
    L15:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
    L27:
        e = move-exception;
        throw new IllegalStateException("Failed to read file " + r100, e);
    }

    public static void b(PolarisFileWrapper r100, PolarisFileWrapper r101) throws IOException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(r100.getAbsolutePath(), r101.getAbsolutePath()) == false) goto L19;
        return;
    L19:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L12
        i(r102, r101);     // Catch: Throwable -> L10
        a(r102);
        return;
    L10:
        th = th;
    L14:
        a(r102);
        throw th;
    L12:
        th = th;
        r102 = null;
        goto L14
    }

    public static boolean e(File r100, File r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 == null) goto L10;
        if (r101 != null) goto L9;
        return false;
    L9:
        return TextUtils.equals(r100.getAbsolutePath(), r101.getAbsolutePath());
    L10:
        return false;
    }

    public static void i(InputStream r100, PolarisFileWrapper r101) throws IOException {
        if (r101.exists() == false) goto L5;
        r101.delete();
    L5:
        c(r101);
        Closeable r102 = null;
        BufferedInputStream r103 = new BufferedInputStream(r100);     // Catch: Throwable -> L24
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L21
        BufferedOutputStream r105 = new BufferedOutputStream(r104, 4096);     // Catch: Throwable -> L19
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L17
    L11:
        int r107 = r103.read(r106);     // Catch: Throwable -> L17
        if (r107 == (-1)) goto L14;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L17
        goto L11
    L14:
        r105.flush();     // Catch: Throwable -> L17
        a(r103);
        a(r104);
        a(r105);
        return;
    L17:
        th = move-exception;
        r102 = r105;
        Throwable th10 = th;
    L23:
        Closeable r108 = r102;
        r102 = r103;
    L26:
        a(r102);
        a(r104);
        a(r108);
        throw th10;
    L19:
        th10 = th;
    L21:
        th = move-exception;
        th10 = th;
        r104 = null;
    L24:
        th = move-exception;
        th10 = th;
        r104 = null;
        r108 = null;
        goto L26
    }

    public static void j(PolarisFileWrapper r100, String r101) throws IOException {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        r100.getParentFile().mkdirs();
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r100, false);     // Catch: Throwable -> L12
        r102.write(r101.getBytes());     // Catch: Throwable -> L10
        r102.flush();     // Catch: Throwable -> L10
        c.a(r102);
        return;
    L10:
        th = th;
    L14:
        c.a(r102);
        throw th;
    L12:
        th = th;
        r102 = null;
        goto L14
    }
}
