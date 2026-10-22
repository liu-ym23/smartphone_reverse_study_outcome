package gla;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f481630a = null;

    public b() {
    }

    static {
        f481630a = Logger.getLogger(b.class.getName());
    }

    public static void b(Context r100, String[] r110) throws IOException {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "ologs.zip");
        if (r101.exists() == false) goto L39;
        r101.delete();
    L39:
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);     // Catch: IOException -> L34
        ZipOutputStream r103 = new ZipOutputStream(r102);     // Catch: Throwable -> L28
        int r104 = r110.length;     // Catch: Throwable -> L16
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L20;
        String r106 = r110[r105];     // Catch: Throwable -> L16
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106);     // Catch: Throwable -> L16
        if (r107.exists() == true) goto L13;
    L18:
        f481630a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r106);     // Catch: Throwable -> L16
    L19:
        r105 = r105 + 1;
        goto L9
    L13:
        if (r107.isDirectory() == false) goto L18;
        a(r107, r107.getName(), r103, r101);     // Catch: Throwable -> L16
        goto L19
    L20:
        r103.close();     // Catch: Throwable -> L28
        r102.close();     // Catch: IOException -> L34
        return;
    L16:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Throwable -> L28
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: IOException -> L34
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L34
    L34:
        e = move-exception;
        f481630a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r101.getAbsolutePath(), e.getMessage()});
        throw e;
    }

    public static void a(File r100, String r101, ZipOutputStream r110, PolarisFileWrapper r111) throws IOException {
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L29;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L41;
        File r105 = r102[r104];
        if (r105.equals(r111) == true) goto L19;
        if (r105.isDirectory() == false) goto L32;
        a(r105, r101 + HTTP.URL_DEFAULT + r105.getName(), r110, r111);
        goto L19
    L32:
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r105);     // Catch: IOException -> L26
        r110.putNextEntry(new ZipEntry(r101 + HTTP.URL_DEFAULT + r105.getName()));     // Catch: Throwable -> L20
        byte[] r107 = new byte[8192];     // Catch: Throwable -> L20
    L14:
        int r108 = r106.read(r107);     // Catch: Throwable -> L20
        if (r108 < 0) goto L17;
        r110.write(r107, 0, r108);     // Catch: Throwable -> L20
        goto L14
    L17:
        r110.closeEntry();     // Catch: Throwable -> L20
        r106.close();     // Catch: IOException -> L26
        goto L19
    L20:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        f481630a.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r105.getAbsolutePath(), e.getMessage()});
        throw e;
    L19:
        r104 = r104 + 1;
        goto L5
    L41:
        return;
    }
}
