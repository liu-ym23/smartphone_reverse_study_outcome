package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f463316a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final SimpleDateFormat f353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<File> f354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f463317b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f463318c;

    public cz() {
        this.f353a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f463317b = 2097152;
        this.f354a = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.xiaomi.push.cz] */
    private void a(File r100) {
        ?? r101 = "model :";
        Pattern r102 = PatternProtector.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter r103 = null;
        ?? r104 = 0;
        r104 = 0;
        r104 = 0;
        r104 = 0;
        r103 = null;
        r103 = null;
        r103 = null;
        BufferedWriter r105 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r100)));     // Catch: Throwable -> L27 IOException -> L29 FileNotFoundException -> L32
        r105.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ax.m9373a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");     // Catch: Throwable -> L18 IOException -> L21 FileNotFoundException -> L24
        this.f352a = 0;     // Catch: Throwable -> L18 IOException -> L21 FileNotFoundException -> L24
        Iterator<File> r106 = this.f354a.iterator();     // Catch: Throwable -> L18 IOException -> L21 FileNotFoundException -> L24
    L6:
        if (r106.hasNext() == false) goto L16;
        r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r106.next())));     // Catch: Throwable -> L18 IOException -> L21 FileNotFoundException -> L24
        a(r101, r105, r102);     // Catch: Throwable -> L10 IOException -> L12 FileNotFoundException -> L14
        r101.close();     // Catch: Throwable -> L10 IOException -> L12 FileNotFoundException -> L14
        r104 = r101;
        goto L6
    L14:
        e = e;
    L26:
        r103 = r105;
        ?? r107 = r101;
    L34:
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());     // Catch: Throwable -> L37
        r101 = r107;
    L35:
        v.a(r103);
        v.a(r101);
        return;
    L12:
        e = e;
    L23:
        r103 = r105;
        ?? r108 = r101;
    L31:
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());     // Catch: Throwable -> L37
        r101 = r108;
    L10:
        th = th;
    L20:
        r103 = r105;
    L38:
        v.a(r103);
        v.a(r101);
        throw th;
    L16:
        r105.write(cf.a().c());     // Catch: Throwable -> L18 IOException -> L21 FileNotFoundException -> L24
        v.a(r105);
        v.a(r104);
        return;
    L24:
        e = e;
        r101 = r104;
    L21:
        e = e;
        r101 = r104;
    L18:
        th = th;
        r101 = r104;
        goto L20
    L37:
        th = th;
    L32:
        e = e;
        r107 = 0;
    L29:
        e = e;
        r108 = 0;
    L27:
        th = th;
        r101 = 0;
        goto L38
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public cz m8929a(File r100) {
        if (r100.exists() == false) goto L5;
        this.f354a.add(r100);
    L5:
        return this;
    }

    public void a(int r100) {
        if (r100 == 0) goto L5;
        this.f463317b = r100;
        return;
    }

    public cz a(Date r100, Date r101) {
        if (r100.after(r101) == false) goto L5;
        this.f356b = this.f353a.format(r101);
        this.f463318c = this.f353a.format(r100);
    L6:
        return this;
    L5:
        this.f356b = this.f353a.format(r100);
        this.f463318c = this.f353a.format(r101);
        goto L6
    }

    private void a(BufferedReader r110, BufferedWriter r111, Pattern r112) {
        char[] r100 = new char[4096];
        int r101 = r110.read(r100);
        boolean r102 = false;
    L4:
        if (r101 == (-1)) goto L45;
        if (r102 == true) goto L46;
        String r103 = new String(r100, 0, r101);
        Matcher r104 = r112.matcher(r103);
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r101) goto L25;
        if (r104.find(r105) == false) goto L25;
        int r107 = r104.start();
        String r113 = r103.substring(r107, this.f356b.length() + r107);
        if (this.f355a == true) goto L17;
        if (r113.compareTo(this.f356b) < 0) goto L19;
        this.f355a = true;
        r106 = r107;
    L19:
        int r114 = r103.indexOf(10, r107);
        if (r114 != (-1)) goto L23;
        r114 = this.f356b.length();
    L23:
        r105 = r107 + r114;
        goto L8
    L17:
        if (r113.compareTo(this.f463318c) <= 0) goto L19;
        r101 = r107;
        r102 = true;
    L25:
        if (this.f355a == false) goto L32;
        int r108 = r101 - r106;
        this.f352a += r108;
        if (r102 == true) goto L28;
        r111.write(r100, r106, r108);
        if (this.f352a <= this.f463317b) goto L32;
        return;
    L28:
        r111.write(r100, r106, r108);
        return;
    L32:
        r101 = r110.read(r100);
        goto L4
    L46:
        return;
    }

    public File a(Context r100, Date r101, Date r102, File r103) {
        if ("com.xiaomi.xmsf".equalsIgnoreCase(r100.getPackageName()) == false) goto L8;
        File r104 = cy.a(r100);
        if (r104 != null) goto L7;
        return null;
    L7:
        m8929a(new PolarisFileWrapper(r104, "xmsf.log.1"));
        m8929a(new PolarisFileWrapper(r104, "xmsf.log"));
    L13:
        if (r104.isDirectory() == true) goto L15;
        return null;
    L15:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, r101.getTime() + "-" + r102.getTime() + ".zip");
        if (r105.exists() == false) goto L18;
        return null;
    L18:
        a(r101, r102);
        long r106 = System.currentTimeMillis();
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103, "log.txt");
        a(r107);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - r106));
        if (r107.exists() == false) goto L23;
        long r108 = System.currentTimeMillis();
        v.a(r105, r107);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - r108));
        r107.delete();
        if (r105.exists() == false) goto L23;
        return r105;
    L23:
        return null;
    L8:
        PolarisFileWrapper r109 = new PolarisFileWrapper(r100.getFilesDir() + f463316a);
        if (u.m9432a(r109) == true) goto L11;
        return null;
    L11:
        m8929a(new PolarisFileWrapper(r109, "log0.txt"));
        m8929a(new PolarisFileWrapper(r109, "log1.txt"));
        r104 = r109;
        goto L13
    }
}
