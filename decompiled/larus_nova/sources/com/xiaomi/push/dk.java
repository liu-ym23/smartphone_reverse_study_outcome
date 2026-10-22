package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public abstract class dk extends ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f463340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f383a;

    public abstract gg a();

    public abstract String b();

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m8940b() {
        return true;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m8941c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_xiaomi_push_dk_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private String c() {
        return "dc_job_result_time_" + mo8851a();
    }

    private String d() {
        return "dc_job_result_" + mo8851a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8939a() {
        return dh.a(this.f383a, String.valueOf(mo8851a()), this.f463340a);
    }

    public void com_xiaomi_push_dk__run$___twin___() {
        String r100 = b();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (m8939a() == false) goto L9;
        com.xiaomi.channel.commonutils.logger.b.m8718a("DC run job mutual: " + mo8851a());
        return;
    L9:
        de r101 = df.a().m8937a();
        if (r101 != null) goto L12;
        String r102 = "";
    L14:
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return;
    L17:
        if (m8940b() == true) goto L20;
        return;
    L20:
        if (m8941c() == false) goto L29;
        SharedPreferences r103 = this.f383a.getSharedPreferences("mipush_extra", 0);
        if (ba.a(r100).equals(r103.getString(d(), null)) == false) goto L29;
        long r104 = r103.getLong(c(), 0);
        int r105 = com.xiaomi.push.service.ah.a(this.f383a).a(gj.f463739ba.a(), 604800);
        if (((System.currentTimeMillis() - r104) / 1000) >= this.f463340a) goto L27;
        return;
    L27:
        if (((System.currentTimeMillis() - r104) / 1000) >= r105) goto L29;
        r100 = "same_" + r104;
    L29:
        gm r106 = new gm();
        r106.a(r100);
        r106.a(System.currentTimeMillis());
        r106.a(a());
        a(this.f383a, r106, r102);
        return;
    L12:
        r102 = r101.a();
        goto L14
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_dk_com_larus_apm_impl_protector_RunnableLancet_run(dk r100) {
        r100.com_xiaomi_push_dk__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public dk(Context r100, int r101) {
        this.f463340a = r101;
        this.f383a = r100;
    }

    public static void a(Context r100, gm r101) {
        de r102 = df.a().m8937a();
        if (r102 != null) goto L5;
        String r103 = "";
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101.a()) == false) goto L12;
        return;
    L12:
        a(r100, r101, r103);
        return;
    L5:
        r103 = r102.a();
        goto L7
    }

    private static void a(Context r100, gm r101, String r102) {
        byte[] r103 = dh.b(r102, ho.a(r101));
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.length == 0) goto L81;
        Object r104 = di.f463336a;
        monitor-enter(r104);
        FileLock r105 = null;
        BufferedOutputStream r106 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r100.getFilesDir(), "push_cdata.lock");     // Catch: Throwable -> L38 IOException -> L40
        v.m9433a(r107);     // Catch: Throwable -> L38 IOException -> L40
        RandomAccessFile r108 = new RandomAccessFile(r107, "rw");     // Catch: Throwable -> L38 IOException -> L40
    L79:
        FileLock r109 = r108.getChannel().lock();     // Catch: Throwable -> L34 IOException -> L36
        PolarisFileWrapper r110 = new PolarisFileWrapper(r100.getFilesDir(), "push_cdata.data");     // Catch: Throwable -> L28 IOException -> L31
        if (u.m9432a(r110) == false) goto L21;
        BufferedOutputStream r111 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r110, true));     // Catch: Throwable -> L28 IOException -> L31
        r111.write(x.a(r103.length));     // Catch: Throwable -> L17 IOException -> L19
        r111.write(r103);     // Catch: Throwable -> L17 IOException -> L19
        r111.flush();     // Catch: Throwable -> L17 IOException -> L19
        r110.setLastModified(0);     // Catch: Throwable -> L17 IOException -> L19
        r106 = r111;
        goto L21
    L19:
        e = e;
    L33:
        r105 = r109;
    L68:
        e.printStackTrace();     // Catch: Throwable -> L52
        if (r105 != null) goto L45;
    L47:
        v.a(r111);     // Catch: Throwable -> L50
    L26:
        v.a(r108);     // Catch: Throwable -> L50
        monitor-exit(r104);     // Catch: Throwable -> L50
        return;
    L45:
        if (r105.isValid() == false) goto L47;
        r105.release();     // Catch: IOException -> L63 Throwable -> L50
    L52:
        th = th;
    L53:
        if (r105 != null) goto L55;
    L57:
        v.a(r111);     // Catch: Throwable -> L50
        v.a(r108);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L55:
        if (r105.isValid() == false) goto L57;
        r105.release();     // Catch: Throwable -> L50 IOException -> L62
    L17:
        th = th;
    L30:
        r105 = r109;
        goto L53
    L21:
        if (r109 != null) goto L23;
    L25:
        v.a(r106);     // Catch: Throwable -> L50
        goto L26
    L23:
        if (r109.isValid() == false) goto L25;
        r109.release();     // Catch: IOException -> L64 Throwable -> L50
    L31:
        e = e;
        r111 = null;
    L28:
        th = th;
        r111 = null;
        goto L30
    L36:
        e = e;
        r111 = null;
    L34:
        th = th;
        r111 = null;
    L50:
        th = move-exception;
        throw th;
    L40:
        e = e;
        r111 = null;
        r108 = null;
    L38:
        th = th;
        r111 = null;
        r108 = null;
        goto L53
    }
}
