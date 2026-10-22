package zh4;

import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static String a(String r100, String r101, PolarisFileWrapper r110) {
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisZipFileWrapper r103 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100), 1);     // Catch: Throwable -> L31
        StringBuilder r104 = new StringBuilder("lib/");     // Catch: Throwable -> L29
        String r105 = Build.CPU_ABI;     // Catch: Throwable -> L29
        r104.append(r105);     // Catch: Throwable -> L29
        r104.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L29
        r104.append(System.mapLibraryName(r101));     // Catch: Throwable -> L29
        ZipEntry r106 = r103.getEntry(r104.toString());     // Catch: Throwable -> L29
        if (r106 != null) goto L15;
        int r107 = r105.indexOf(45);     // Catch: Throwable -> L29
        StringBuilder r108 = new StringBuilder("lib/");     // Catch: Throwable -> L29
        if (r107 > 0) goto L10;
        r107 = r105.length();     // Catch: Throwable -> L29
    L10:
        r108.append(r105.substring(0, r107));     // Catch: Throwable -> L29
        r108.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L29
        r108.append(System.mapLibraryName(r101));     // Catch: Throwable -> L29
        String r109 = r108.toString();     // Catch: Throwable -> L29
        ZipEntry r111 = r103.getEntry(r109);     // Catch: Throwable -> L29
        if (r111 == null) goto L13;
        r106 = r111;
        goto L15
    L13:
        return "Library entry not found:" + r109;
    L15:
        r110.createNewFile();     // Catch: Throwable -> L29
        InputStream r112 = r103.getInputStream(r106);     // Catch: Throwable -> L29
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L27
        byte[] r114 = new byte[4096];     // Catch: Throwable -> L25
    L19:
        int r115 = r112.read(r114);     // Catch: Throwable -> L25
        if (r115 <= 0) goto L22;
        r113.write(r114, 0, r115);     // Catch: Throwable -> L25
        goto L19
    L22:
        g.g(r110.getAbsolutePath());     // Catch: Throwable -> L25
        g.a(r113);
        g.a(r112);
        return null;
    L25:
        Throwable th10 = th;
        r102 = r113;
    L45:
        String r116 = th10.getMessage();     // Catch: Throwable -> L38
        g.a(r102);
        g.a(r112);
        if (r103 == null) goto L51;
    L37:
        return r116;
    L51:
        r103.close();     // Catch: IOException -> L43
    L38:
        th = move-exception;
        g.a(r102);
        g.a(r112);
        if (r103 == null) goto L54;
    L42:
        throw th;
    L54:
        r103.close();     // Catch: IOException -> L44
    L27:
        th = move-exception;
        th10 = th;
    L29:
        th = move-exception;
        th10 = th;
        r112 = null;
    L31:
        th = move-exception;
        th10 = th;
        r112 = null;
        r103 = null;
        goto L45
    }
}
