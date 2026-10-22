package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class bk {
    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context r100) {
        String r101 = bl.a(r100).a("sp_client_report_status", "sp_client_report_key", "");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        String r102 = ba.a(20);
        bl.a(r100).m8856a("sp_client_report_status", "sp_client_report_key", r102);
        return r102;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8852a(Context r100) {
        if (r100.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode < 108) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static byte[] a(String r100) {
        byte[] r101 = Arrays.copyOf(ax.m8829a(r100), 16);
        r101[0] = 68;
        r101[15] = 84;
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8853a(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        long r103 = com.xiaomi.clientreport.manager.a.a(r100).m8727a().getMaxFileLength();
        if (r102.exists() == true) goto L14;
        v.m9433a(r102);
        return true;
    L14:
        if (r102.length() <= r103) goto L16;
    L11:
        return false;
    L16:
        return true;
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L11
    }

    public static void a(Context r100, List<String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() > 0) goto L7;
        return;
    L7:
        if (m8852a(r100) == false) goto L21;
        Iterator<String> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L10;
        a(r100, r103);
        goto L10
    L23:
        return;
    }

    public static void a(Context r100, String r101) {
        Intent r102 = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        r102.putExtra("pkgname", r100.getPackageName());
        r102.putExtra("category", "category_client_report_data");
        r102.putExtra("name", "quality_support");
        r102.putExtra("data", r101);
        r100.sendBroadcast(r102, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static File[] m8854a(Context r100, String r101) {
        return new PolarisFileWrapper(r100.getFilesDir(), r101).listFiles(new AnonymousClass2());
    }

    public static void a(Context r110, String r111, String r112) {
        if (r110 == null) goto L88;
        if (r111 == null) goto L110;
        if (r112 == null) goto L112;
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.getFilesDir(), r112);
        if (r100.exists() == true) goto L9;
        r100.mkdirs();
    L9:
        PolarisFileWrapper r113 = new PolarisFileWrapper(r110.getFilesDir(), r111);
        if (r113.exists() == true) goto L13;
        r113.mkdirs();
        return;
    L13:
        File[] r114 = r113.listFiles(new AnonymousClass1());
        if (r114 != null) goto L16;
        return;
    L16:
        if (r114.length <= 0) goto L113;
        long r115 = System.currentTimeMillis();
        int r101 = r114.length;
        FileLock r102 = null;
        RandomAccessFile r103 = null;
        PolarisFileWrapper r104 = null;
        int r105 = 0;
    L19:
        if (r105 >= r101) goto L114;
        File r106 = r114[r105];
        if (r106 != null) goto L103;
    L77:
        if (r102 != null) goto L79;
    L84:
        v.a(r103);
        if (r104 == null) goto L87;
        r104.delete();
    L87:
        r105 = r105 + 1;
        goto L19
    L79:
        if (r102.isValid() == false) goto L84;
        r102.release();     // Catch: IOException -> L82
    L82:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L84
    L103:
    L49:
        e = move-exception;
        PolarisFileWrapper r107 = r104;
        RandomAccessFile r108 = r103;
        Exception e100 = e;
    L51:
        com.xiaomi.channel.commonutils.logger.b.a(e100);     // Catch: Throwable -> L63
        if (r102 != null) goto L54;
    L59:
        v.a(r108);
        if (r107 == null) goto L62;
    L61:
        r107.delete();
    L62:
        r103 = r108;
        r104 = r107;
        goto L87
    L54:
        if (r102.isValid() == false) goto L59;
        r102.release();     // Catch: IOException -> L57
    L57:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L47:
        th = th;
    L66:
        if (r102 != null) goto L68;
    L73:
        v.a(r103);
        if (r104 == null) goto L109;
        r104.delete();
        throw th;
    L109:
        throw th;
    L68:
        if (r102.isValid() == false) goto L73;
        r102.release();     // Catch: IOException -> L71
    L71:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L73
    L23:
        if (TextUtils.isEmpty(r106.getAbsolutePath()) == true) goto L77;
        r107 = new PolarisFileWrapper(r106.getAbsolutePath() + ".lock");     // Catch: Throwable -> L47 Exception -> L49
        v.m9433a(r107);     // Catch: Throwable -> L43 Exception -> L45
        r108 = new RandomAccessFile(r107, "rw");     // Catch: Throwable -> L43 Exception -> L45
        r102 = r108.getChannel().lock();     // Catch: Exception -> L41 Throwable -> L63
        PolarisFileWrapper r109 = new PolarisFileWrapper(r100.getAbsolutePath() + File.separator + r106.getName() + r115);     // Catch: Exception -> L41 Throwable -> L63
    L97:
        v.b(r106, r109);     // Catch: IOException -> L30 Exception -> L41 Throwable -> L63
    L32:
        r106.delete();     // Catch: Exception -> L41 Throwable -> L63
        if (r102 != null) goto L35;
    L40:
        v.a(r108);
        goto L61
    L35:
        if (r102.isValid() == false) goto L40;
        r102.release();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L41 Throwable -> L63
        r106.delete();     // Catch: Exception -> L41 Throwable -> L63
        r109.delete();     // Catch: Exception -> L41 Throwable -> L63
    L41:
        e100 = e;
    L63:
        th = th;
        r103 = r108;
    L65:
        r104 = r107;
        goto L66
    L45:
        e = move-exception;
        r108 = r103;
        e100 = e;
    L43:
        th = th;
        goto L65
    L114:
        return;
    L113:
        return;
    L112:
        return;
    L110:
        return;
    }
}
