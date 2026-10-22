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
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h implements e3 {
    public h() {
    }

    public static void b(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String[] c(Context r8, String r9) {
        StringBuilder r0 = new StringBuilder("lib");
        char r1 = File.separatorChar;
        r0.append(r1);
        r0.append("([^\\");
        r0.append(r1);
        r0.append("]*)");
        r0.append(r1);
        r0.append(r9);
        Pattern r10 = PatternProtector.compile(r0.toString());
        HashSet r2 = new HashSet();
        ApplicationInfo r11 = r8.getApplicationInfo();
        String[] r3 = r11.splitSourceDirs;
        int r4 = 0;
        if (r3 != null) goto L5;
    L7:
        String[] r5 = {r11.sourceDir};
    L8:
        int r12 = r5.length;
        ZipFile r6 = null;
    L9:
        if (r4 >= r12) goto L20;
        ZipFile r7 = new PolarisZipFileWrapper(new PolarisFileWrapper(r5[r4]), 1);     // Catch: IOException -> L24
        Enumeration<? extends ZipEntry> r13 = r7.entries();
    L14:
        if (r13.hasMoreElements() == false) goto L18;
        Matcher r14 = r10.matcher(r13.nextElement().getName());
        if (r14.matches() == false) goto L14;
        r2.add(r14.group(1));
        goto L14
    L18:
        r6 = r7;
    L19:
        r4 = r4 + 1;
        goto L9
    L20:
        if (r6 == null) goto L23;
        r6.close();     // Catch: IOException -> L25
    L23:
        return (String[]) r2.toArray(new String[r2.size()]);
    L5:
        if (r3.length == 0) goto L7;
        r5 = new String[r3.length + 1];
        r5[0] = r11.sourceDir;
        System.arraycopy(r3, 0, r5, 1, r3.length);
        goto L8
    }

    public static g a(Context r11, String[] r12, String r13, i3 r14) {
        ApplicationInfo r15 = r11.getApplicationInfo();
        String[] r16 = r15.splitSourceDirs;
        if (r16 != null) goto L5;
    L7:
        String[] r2 = {r15.sourceDir};
    L8:
        int r17 = r2.length;
        int r18 = 0;
    L9:
        ZipFile r3 = null;
        if (r18 >= r17) goto L32;
        String r4 = r2[r18];
        int r5 = 0;
    L12:
        int r6 = r5 + 1;
        if (r5 >= 5) goto L17;
        r3 = new PolarisZipFileWrapper(new PolarisFileWrapper(r4), 1);     // Catch: IOException -> L16
    L16:
        r5 = r6;
    L17:
        if (r3 == null) goto L31;
        int r7 = 0;
    L20:
        int r8 = r7 + 1;
        if (r7 >= 5) goto L34;
        int r9 = r12.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L29;
        String r19 = r12[r10];
        StringBuilder r20 = new StringBuilder("lib");
        char r110 = File.separatorChar;
        r20.append(r110);
        r20.append(r19);
        r20.append(r110);
        r20.append(r13);
        String r21 = r20.toString();
        Locale r22 = Locale.US;
        ZipEntry r23 = r3.getEntry(r21);
        if (r23 != null) goto L27;
        r10 = r10 + 1;
        goto L23
    L27:
        return new g(r3, r23);
    L29:
        r7 = r8;
        goto L20
    L34:
        r3.close();     // Catch: IOException -> L33
    L31:
        r18 = r18 + 1;
        goto L9
    L32:
        return null;
    L5:
        if (r16.length == 0) goto L7;
        r2 = new String[r16.length + 1];
        r2[0] = r15.sourceDir;
        System.arraycopy(r16, 0, r2, 1, r16.length);
        goto L8
    }
}
