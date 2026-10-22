package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f463642a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f463643a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private gd f609a;

        @Override // java.lang.Runnable
        public void run() {
            com_xiaomi_push_ga$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_xiaomi_push_ga$a__run$___twin___() {
            ga.b(this.f463643a, this.f609a);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_ga$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_xiaomi_push_ga$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, gd r101) {
            this.f609a = r101;
            this.f463643a = r100;
        }
    }

    private static void a(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir() + "/tdReadTemp");
        if (r101.exists() == true) goto L6;
        r101.mkdirs();
        return;
    }

    private static void b(Context r100) {
        SharedPreferences.Editor r101 = r100.getSharedPreferences("mipush_extra", 4).edit();
        r101.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        r101.commit();
    }

    public static void a(Context r100, gd r101) {
        ad.a(r100).a(new a(r100, r101));
    }

    public static /* synthetic */ void b(Context r100, gd r101) {
        c(r100, r101);
    }

    private static void c(Context r100, gd r110) {
        if (f463642a == true) goto L48;
        f463642a = true;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "tiny_data.data");
        if (r101.exists() == true) goto L8;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData no ready file to get data.");
        return;
    L8:
        a(r100);
        byte[] r102 = com.xiaomi.push.service.ba.a(r100);
        FileLock r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getFilesDir(), "tiny_data.lock");     // Catch: Throwable -> L20 Exception -> L22
        v.m9433a(r104);     // Catch: Throwable -> L20 Exception -> L22
        RandomAccessFile r105 = new RandomAccessFile(r104, "rw");     // Catch: Throwable -> L20 Exception -> L22
        r103 = r105.getChannel().lock();     // Catch: Exception -> L18 Throwable -> L38
        r101.renameTo(new PolarisFileWrapper(r100.getFilesDir() + "/tdReadTemp/tiny_data.data"));     // Catch: Exception -> L18 Throwable -> L38
        if (r103 != null) goto L13;
    L32:
        v.a(r105);
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (r106.exists() == true) goto L36;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData no ready file to get data.");
        return;
    L36:
        a(r100, r110, r106, r102);
        fz.a(false);
        b(r100);
        f463642a = false;
        return;
    L13:
        if (r103.isValid() == false) goto L32;
        r103.release();     // Catch: IOException -> L16
    L16:
        e = e;
    L31:
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L18:
        e = e;
    L24:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L38
        if (r103 == null) goto L32;
        if (r103.isValid() == false) goto L32;
        r103.release();     // Catch: IOException -> L30
    L30:
        e = e;
    L38:
        th = th;
    L39:
        if (r103 != null) goto L41;
    L46:
        v.a(r105);
        throw th;
    L41:
        if (r103.isValid() == false) goto L46;
        r103.release();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L46
    L22:
        e = e;
        r105 = null;
    L20:
        th = th;
        r105 = null;
        goto L39
    L48:
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData extractTinyData is running");
    }

    private static void a(Context r110, gd r111, File r112, byte[] r113) {
        ArrayList r100 = new ArrayList();
        byte[] r101 = new byte[4];
        BufferedInputStream r102 = null;
        BufferedInputStream r103 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r112));     // Catch: Throwable -> L42 Exception -> L44
        r102 = null;
    L5:
        int r104 = 0;
        int r105 = 0;
    L54:
        int r106 = r103.read(r101);     // Catch: Throwable -> L38 Exception -> L40
        if (r106 == (-1)) goto L30;
        if (r106 != 4) goto L10;
        int r107 = x.a(r101);     // Catch: Throwable -> L38 Exception -> L40
        if (r107 < 1) goto L29;
        if (r107 > 30720) goto L29;
        byte[] r108 = new byte[r107];     // Catch: Throwable -> L38 Exception -> L40
        int r114 = r103.read(r108);     // Catch: Throwable -> L38 Exception -> L40
        if (r114 != r107) goto L18;
        byte[] r109 = h.a(r113, r108);     // Catch: Throwable -> L38 Exception -> L40
        if (r109 == null) goto L28;
        if (r109.length == 0) goto L28;
        gi r115 = new gi();     // Catch: Throwable -> L38 Exception -> L40
        ho.a(r115, r109);     // Catch: Throwable -> L38 Exception -> L40
        r115.a("item_size", String.valueOf(r109.length));     // Catch: Throwable -> L38 Exception -> L40
        r100.add(r115);     // Catch: Throwable -> L38 Exception -> L40
        r104 = r104 + 1;     // Catch: Throwable -> L38 Exception -> L40
        r105 = r105 + r109.length;     // Catch: Throwable -> L38 Exception -> L40
        if (r104 >= 8) goto L27;
        if (r105 < 30720) goto L54;
    L27:
        gb.a(r110, r111, r100);     // Catch: Throwable -> L38 Exception -> L40
        r100.clear();     // Catch: Throwable -> L38 Exception -> L40
    L28:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");     // Catch: Throwable -> L38 Exception -> L40
        goto L54
    L18:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + r114 + "__length:" + r107);     // Catch: Throwable -> L38 Exception -> L40
    L29:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r107);     // Catch: Throwable -> L38 Exception -> L40
        goto L30
    L10:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer error. size:" + r106);     // Catch: Throwable -> L38 Exception -> L40
    L30:
        gb.a(r110, r111, r100);     // Catch: Throwable -> L38 Exception -> L40
        if (r112 != null) goto L33;
    L37:
        v.a(r103);
    L50:
        return;
    L33:
        if (r112.exists() == false) goto L37;
        if (r112.delete() == true) goto L37;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData delete reading temp file failed");     // Catch: Throwable -> L38 Exception -> L40
    L40:
        e = e;
        r102 = r103;
    L45:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L42
        v.a(r102);
    L38:
        th = th;
        r102 = r103;
    L48:
        v.a(r102);
        throw th;
    L42:
        th = th;
    L44:
        e = e;
        goto L45
    }
}
