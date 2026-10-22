package m1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.apm.lite.k.h;
import com.apm.lite.k.j;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes39.dex */
public final class d {
    static {
        new ArrayList();
    }

    public d() {
    }

    public static String a(Context r100, String r101, PolarisFileWrapper r102) {
        ApplicationInfo r103 = r100.getApplicationInfo();
        String r104 = b(r103.sourceDir, r101, r102);
        if (r104 != null) goto L5;
        return null;
    L5:
        String[] r105 = r103.splitSourceDirs;
        int r106 = 0;
        if (r105 == null) goto L33;
        int r107 = r105.length;
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L33;
        r104 = b(r105[r108], r101, r102);
        if (r104 == null) goto L11;
        r108 = r108 + 1;
        goto L8
    L11:
        return null;
    L33:
        ClassLoader r109 = d.class.getClassLoader();     // Catch: Throwable -> L30
    L15:
        if ((r109 instanceof BaseDexClassLoader) == true) goto L20;
        if (r109.getParent() == null) goto L20;
        r109 = r109.getParent();     // Catch: Throwable -> L30
    L20:
        if ((r109 instanceof BaseDexClassLoader) == false) goto L40;
        Field r110 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Throwable -> L30
        r110.setAccessible(true);     // Catch: Throwable -> L30
        Object r111 = r110.get(r109);     // Catch: Throwable -> L30
        Field r112 = r111.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Throwable -> L30
        r112.setAccessible(true);     // Catch: Throwable -> L30
        String[] r113 = (String[]) r112.get(r111);     // Catch: Throwable -> L30
        int r114 = r113.length;     // Catch: Throwable -> L30
    L22:
        if (r106 >= r114) goto L28;
        PolarisFileWrapper r115 = new PolarisFileWrapper(r113[r106], System.mapLibraryName(r101));     // Catch: Throwable -> L30
        if (r115.exists() == true) goto L25;
        r106 = r106 + 1;     // Catch: Throwable -> L30
        goto L22
    L25:
        h.e(r115, r102);     // Catch: Throwable -> L30
        j.b(r102.getAbsolutePath());     // Catch: Throwable -> L30
        return null;
    L28:
        return "not_found";
    L40:
        return r104;
    L30:
        th = move-exception;
        return th.getMessage();
    }

    public static String b(String r100, String r101, PolarisFileWrapper r110) {
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisZipFileWrapper r103 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100), 1);     // Catch: Throwable -> L33
        StringBuilder r104 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        String r105 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r104.append(r105);     // Catch: Throwable -> L31
        r104.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r104.append(System.mapLibraryName(r101));     // Catch: Throwable -> L31
        ZipEntry r106 = r103.getEntry(r104.toString());     // Catch: Throwable -> L31
        if (r106 != null) goto L16;
        int r107 = r105.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r108 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        if (r107 > 0) goto L10;
        r107 = r105.length();     // Catch: Throwable -> L31
    L10:
        r108.append(r105.substring(0, r107));     // Catch: Throwable -> L31
        r108.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r108.append(System.mapLibraryName(r101));     // Catch: Throwable -> L31
        String r109 = r108.toString();     // Catch: Throwable -> L31
        ZipEntry r111 = r103.getEntry(r109);     // Catch: Throwable -> L31
        if (r111 != null) goto L15;
        String r112 = "Library entry not found:" + r109;     // Catch: Throwable -> L31
        r103.close();     // Catch: IOException -> L47
    L14:
        return r112;
    L15:
        r106 = r111;
    L16:
        r110.createNewFile();     // Catch: Throwable -> L31
        InputStream r113 = r103.getInputStream(r106);     // Catch: Throwable -> L31
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L29
        byte[] r115 = new byte[4096];     // Catch: Throwable -> L27
    L20:
        int r116 = r113.read(r115);     // Catch: Throwable -> L27
        if (r116 <= 0) goto L23;
        r114.write(r115, 0, r116);     // Catch: Throwable -> L27
        goto L20
    L23:
        j.b(r110.getAbsolutePath());     // Catch: Throwable -> L27
        j.a(r114);
        j.a(r113);
        r103.close();     // Catch: IOException -> L48
    L26:
        return null;
    L27:
        Throwable th10 = th;
        r102 = r114;
    L60:
        String r117 = th10.getMessage();     // Catch: Throwable -> L41
        j.a(r102);
        j.a(r113);
        if (r103 != null) goto L54;
    L40:
        return r117;
    L54:
        r103.close();     // Catch: IOException -> L49
    L41:
        th = move-exception;
        j.a(r102);
        j.a(r113);
        if (r103 != null) goto L58;
    L46:
        throw th;
    L58:
        r103.close();     // Catch: IOException -> L50
    L29:
        th = move-exception;
        th10 = th;
    L31:
        th = move-exception;
        th10 = th;
        r113 = null;
    L33:
        th = move-exception;
        th10 = th;
        r113 = null;
        r103 = null;
        goto L60
    }
}
