package e27;

import android.content.Context;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.utils.logger.FLogger;
import d27.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f470835a = null;

    static {
        f470835a = new ArrayList();
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("monitorcollector-lib", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> monitorcollector-lib");
        com.bytedance.librarian.a.c("monitorcollector-lib");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> monitorcollector-lib");
    }

    public static synchronized boolean b(Context r110) {
        monitor-enter(b.class);
        List<String> r100 = f470835a;     // Catch: Throwable -> L42
        if (((ArrayList) r100).contains("monitorcollector-lib") == false) goto L48;
        monitor-exit(b.class);
        return true;
    L48:
        a();     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        ((ArrayList) r100).add("monitorcollector-lib");     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L38:
        monitor-exit(b.class);
        return true;
    L14:
        e = move-exception;
        String r101 = System.mapLibraryName("monitorcollector-lib");     // Catch: Throwable -> L42
        PolarisFileWrapper r102 = null;
        if (r110 != null) goto L18;
    L23:
        PolarisFileWrapper r103 = null;
    L24:
        if (r103 == null) goto L26;
        r102 = new PolarisFileWrapper(r103, r101);     // Catch: Throwable -> L42
    L26:
        if (r102 != null) goto L30;
        return false;
    L30:
        if (r102.exists() == false) goto L33;
        r102.delete();     // Catch: Throwable -> L42
    L33:
        if (c(r110, r102) == null) goto L46;
        e.getMessage();     // Catch: Throwable -> L42
        return false;
    L46:
        System.load(r102.getAbsolutePath());     // Catch: Throwable -> L40
        ((ArrayList) f470835a).add("monitorcollector-lib");     // Catch: Throwable -> L40
    L41:
        return false;
    L18:
        if (r110.getFilesDir() == null) goto L23;
        r103 = new PolarisFileWrapper(r110.getFilesDir(), "libso");     // Catch: Throwable -> L42
        if (r103.exists() == true) goto L24;
        new PolarisFileWrapper(r103.getAbsolutePath()).mkdirs();     // Catch: Throwable -> L42
    L13:
        return false;
    L42:
        th = move-exception;
        throw th;
    }

    public static String c(Context r100, PolarisFileWrapper r110) {
        PolarisFileOutputStreamWrapper r101 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r103 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        String r104 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r103.append(r104);     // Catch: Throwable -> L31
        r103.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r103.append(System.mapLibraryName("monitorcollector-lib"));     // Catch: Throwable -> L31
        ZipEntry r105 = r102.getEntry(r103.toString());     // Catch: Throwable -> L31
        if (r105 != null) goto L16;
        int r106 = r104.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r107 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        if (r106 > 0) goto L10;
        r106 = r104.length();     // Catch: Throwable -> L31
    L10:
        r107.append(r104.substring(0, r106));     // Catch: Throwable -> L31
        r107.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r107.append(System.mapLibraryName("monitorcollector-lib"));     // Catch: Throwable -> L31
        String r108 = r107.toString();     // Catch: Throwable -> L31
        ZipEntry r109 = r102.getEntry(r108);     // Catch: Throwable -> L31
        if (r109 != null) goto L15;
        String r111 = "Library entry not found:" + r108;     // Catch: Throwable -> L31
        r102.close();     // Catch: Throwable -> L47
    L14:
        return r111;
    L15:
        r105 = r109;
    L16:
        r110.createNewFile();     // Catch: Throwable -> L31
        InputStream r112 = r102.getInputStream(r105);     // Catch: Throwable -> L31
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L29
        byte[] r114 = new byte[4096];     // Catch: Throwable -> L27
    L20:
        int r115 = r112.read(r114);     // Catch: Throwable -> L27
        if (r115 <= 0) goto L23;
        r113.write(r114, 0, r115);     // Catch: Throwable -> L27
        goto L20
    L23:
        d.b(r110.getAbsolutePath());     // Catch: Throwable -> L27
        d.a(r113);
        d.a(r112);
        r102.close();     // Catch: Throwable -> L48
    L26:
        return null;
    L27:
        Throwable th10 = th;
        r101 = r113;
    L53:
        String r116 = th10.getMessage();     // Catch: Throwable -> L41
        d.a(r101);
        d.a(r112);
        if (r102 != null) goto L51;
    L40:
        return r116;
    L51:
        r102.close();     // Catch: Throwable -> L49
    L41:
        th = move-exception;
        d.a(r101);
        d.a(r112);
        if (r102 != null) goto L66;
    L46:
        throw th;
    L66:
        r102.close();     // Catch: Throwable -> L50
    L29:
        th10 = th;
    L31:
        th = move-exception;
        th10 = th;
        r112 = null;
    L33:
        th = move-exception;
        th10 = th;
        r112 = null;
        r102 = null;
        goto L53
    }
}
