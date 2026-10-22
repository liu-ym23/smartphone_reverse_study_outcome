package com.getkeepsafe.relinker;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements ReLinker.a {

    /* JADX INFO: renamed from: com.getkeepsafe.relinker.a$a, reason: collision with other inner class name */
    public static class C3842a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZipFile f274231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ZipEntry f274232b;

        public C3842a(PolarisZipFileWrapper r100, ZipEntry r101) {
            this.f274231a = r100;
            this.f274232b = r101;
        }
    }

    public a() {
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String[] d(Context r100) {
        ApplicationInfo r101 = r100.getApplicationInfo();
        String[] r102 = r101.splitSourceDirs;
        if (r102 == null) goto L9;
        if (r102.length == 0) goto L9;
        String[] r103 = new String[r102.length + 1];
        r103[0] = r101.sourceDir;
        System.arraycopy(r102, 0, r103, 1, r102.length);
        return r103;
    L9:
        return new String[]{r101.sourceDir};
    }

    public static String[] c(Context r100, String r101) {
        Pattern r102 = PatternProtector.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + r101);
        HashSet r103 = new HashSet();
        String[] r104 = d(r100);
        int r105 = r104.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L14;
        Enumeration<? extends ZipEntry> r107 = new PolarisZipFileWrapper(new PolarisFileWrapper(r104[r106]), 1).entries();
    L8:
        if (r107.hasMoreElements() == false) goto L12;
        Matcher r108 = r102.matcher(r107.nextElement().getName());
        if (r108.matches() == false) goto L8;
        r103.add(r108.group(1));
    L12:
        r106 = r106 + 1;
        goto L3
    L14:
        return (String[]) r103.toArray(new String[r103.size()]);
    }

    public static C3842a b(Context r110, String[] r111, String r112, b r113) {
        String[] r100 = d(r110);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        PolarisZipFileWrapper r103 = null;
        if (r102 >= r101) goto L27;
        String r104 = r100[r102];
        int r105 = 0;
    L6:
        int r106 = r105 + 1;
        if (r105 >= 5) goto L11;
        r103 = new PolarisZipFileWrapper(new PolarisFileWrapper(r104), 1);     // Catch: IOException -> L10
    L10:
        r105 = r106;
    L11:
        if (r103 == null) goto L26;
        int r107 = 0;
    L14:
        int r108 = r107 + 1;
        if (r107 >= 5) goto L29;
        int r109 = r111.length;
        int r114 = 0;
    L17:
        if (r114 >= r109) goto L23;
        String r115 = "lib" + File.separatorChar + r111[r114] + File.separatorChar + r112;
        r113.getClass();
        b.d("Looking for %s in APK %s...", new Object[]{r115, r104});
        ZipEntry r116 = r103.getEntry(r115);
        if (r116 != null) goto L21;
        r114 = r114 + 1;
        goto L17
    L21:
        return new C3842a(r103, r116);
    L23:
        r107 = r108;
        goto L14
    L29:
        r103.close();     // Catch: IOException -> L28
    L26:
        r102 = r102 + 1;
        goto L3
    L27:
        return null;
    }
}
