package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes.dex */
public final class h implements e3 {
    public h() {
    }

    public static void b(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String[] c(Context r100, String r101) {
        StringBuilder r102 = new StringBuilder("lib");
        char r103 = File.separatorChar;
        r102.append(r103);
        r102.append("([^\\");
        r102.append(r103);
        r102.append("]*)");
        r102.append(r103);
        r102.append(r101);
        Pattern r104 = PatternProtector.compile(r102.toString());
        HashSet r105 = new HashSet();
        ApplicationInfo r106 = r100.getApplicationInfo();
        String[] r107 = r106.splitSourceDirs;
        int r108 = 0;
        if (r107 != null) goto L5;
    L7:
        String[] r109 = {r106.sourceDir};
    L8:
        int r110 = r109.length;
        PolarisZipFileWrapper r111 = null;
    L9:
        if (r108 >= r110) goto L20;
        PolarisZipFileWrapper r112 = new PolarisZipFileWrapper(new PolarisFileWrapper(r109[r108]), 1);     // Catch: IOException -> L24
        Enumeration<? extends ZipEntry> r113 = r112.entries();
    L14:
        if (r113.hasMoreElements() == false) goto L18;
        Matcher r114 = r104.matcher(r113.nextElement().getName());
        if (r114.matches() == false) goto L14;
        r105.add(r114.group(1));
        goto L14
    L18:
        r111 = r112;
    L19:
        r108 = r108 + 1;
        goto L9
    L20:
        if (r111 == null) goto L23;
        r111.close();     // Catch: IOException -> L25
    L23:
        return (String[]) r105.toArray(new String[r105.size()]);
    L5:
        if (r107.length == 0) goto L7;
        r109 = new String[r107.length + 1];
        r109[0] = r106.sourceDir;
        System.arraycopy(r107, 0, r109, 1, r107.length);
        goto L8
    }

    public static g a(Context r110, String[] r111, String r112, i3 r113) {
        ApplicationInfo r114 = r110.getApplicationInfo();
        String[] r115 = r114.splitSourceDirs;
        if (r115 != null) goto L5;
    L7:
        String[] r100 = {r114.sourceDir};
    L8:
        int r116 = r100.length;
        int r117 = 0;
    L9:
        PolarisZipFileWrapper r101 = null;
        if (r117 >= r116) goto L32;
        String r102 = r100[r117];
        int r103 = 0;
    L12:
        int r104 = r103 + 1;
        if (r103 >= 5) goto L17;
        r101 = new PolarisZipFileWrapper(new PolarisFileWrapper(r102), 1);     // Catch: IOException -> L16
    L16:
        r103 = r104;
    L17:
        if (r101 == null) goto L31;
        int r105 = 0;
    L20:
        int r106 = r105 + 1;
        if (r105 >= 5) goto L34;
        int r107 = r111.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L29;
        String r109 = r111[r108];
        StringBuilder r118 = new StringBuilder("lib");
        char r119 = File.separatorChar;
        r118.append(r119);
        r118.append(r109);
        r118.append(r119);
        r118.append(r112);
        String r120 = r118.toString();
        Locale r121 = Locale.US;
        ZipEntry r122 = r101.getEntry(r120);
        if (r122 != null) goto L27;
        r108 = r108 + 1;
        goto L23
    L27:
        return new g(r101, r122);
    L29:
        r105 = r106;
        goto L20
    L34:
        r101.close();     // Catch: IOException -> L33
    L31:
        r117 = r117 + 1;
        goto L9
    L32:
        return null;
    L5:
        if (r115.length == 0) goto L7;
        r100 = new String[r115.length + 1];
        r100[0] = r114.sourceDir;
        System.arraycopy(r115, 0, r100, 1, r115.length);
        goto L8
    }
}
