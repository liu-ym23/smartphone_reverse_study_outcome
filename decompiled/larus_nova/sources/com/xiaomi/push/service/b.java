package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes41.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f464288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f1085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f1086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f464289b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f1087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f464290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f464291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile String f464292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f464293f;

    public String a() {
        if (TextUtils.isEmpty(this.f464292e) == false) goto L6;
        this.f464292e = a(this.f1084a, "mipush_region", "mipush_region.lock", this.f1085a);
    L6:
        return this.f464292e;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f464293f) == false) goto L6;
        this.f464293f = a(this.f1084a, "mipush_country_code", "mipush_country_code.lock", this.f464289b);
    L6:
        return this.f464293f;
    }

    public b(Context r100) {
        this.f1085a = new Object();
        this.f464289b = new Object();
        this.f1086a = "mipush_region";
        this.f1087b = "mipush_country_code";
        this.f464290c = "mipush_region.lock";
        this.f464291d = "mipush_country_code.lock";
        this.f1084a = r100;
    }

    public static b a(Context r100) {
        if (f464288a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464288a != null) goto L9;
        f464288a = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f464288a;
    }

    public void a(String r100, boolean r101) {
        if (TextUtils.equals(r100, this.f464292e) == true) goto L5;
        this.f464292e = r100;
    L5:
        if (r101 == false) goto L8;
        a(this.f1084a, r100, "mipush_region", "mipush_region.lock", this.f1085a);
        return;
    }

    public void b(String r100, boolean r101) {
        if (TextUtils.equals(r100, this.f464293f) == true) goto L5;
        this.f464293f = r100;
    L5:
        if (r101 == false) goto L8;
        a(this.f1084a, r100, "mipush_country_code", "mipush_region.lock", this.f1085a);
        return;
    }

    private String a(Context r100, String r101, String r102, Object r103) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getFilesDir(), r101);
        FileLock r105 = null;
        if (r104.exists() == true) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("No ready file to get data from " + r101);
        return null;
    L6:
        monitor-enter(r103);
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100.getFilesDir(), r102);     // Catch: Throwable -> L26 Exception -> L28
        com.xiaomi.push.v.m9433a(r106);     // Catch: Throwable -> L26 Exception -> L28
        RandomAccessFile r107 = new RandomAccessFile(r106, "rw");     // Catch: Throwable -> L26 Exception -> L28
        FileLock r108 = r107.getChannel().lock();     // Catch: Throwable -> L22 Exception -> L24
        String r109 = com.xiaomi.push.v.a(r104);     // Catch: Exception -> L20 Throwable -> L41
        if (r108 != null) goto L12;
    L17:
        com.xiaomi.push.v.a(r107);     // Catch: Throwable -> L52
        monitor-exit(r103);     // Catch: Throwable -> L52
        return r109;
    L12:
        if (r108.isValid() == false) goto L17;
        r108.release();     // Catch: IOException -> L15 Throwable -> L52
    L15:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L52
    L20:
        e = e;
    L30:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L41
        if (r108 != null) goto L33;
    L38:
        com.xiaomi.push.v.a(r107);     // Catch: Throwable -> L52
        monitor-exit(r103);     // Catch: Throwable -> L52
        return null;
    L33:
        if (r108.isValid() == false) goto L38;
        r108.release();     // Catch: IOException -> L36 Throwable -> L52
    L36:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L52
    L41:
        th = th;
        r105 = r108;
    L43:
        if (r105 != null) goto L45;
    L50:
        com.xiaomi.push.v.a(r107);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L45:
        if (r105.isValid() == false) goto L50;
        r105.release();     // Catch: IOException -> L48 Throwable -> L52
    L48:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L52
        goto L50
    L24:
        e = e;
        r108 = null;
    L22:
        th = th;
        goto L43
    L52:
        th = move-exception;
        throw th;
    L28:
        e = e;
        r107 = null;
        r108 = null;
    L26:
        th = th;
        r107 = null;
        goto L43
    }

    private void a(Context r100, String r101, String r102, String r103, Object r104) {
        monitor-enter(r104);
        FileLock r105 = null;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100.getFilesDir(), r103);     // Catch: Throwable -> L17 Exception -> L19
        com.xiaomi.push.v.m9433a(r106);     // Catch: Throwable -> L17 Exception -> L19
        RandomAccessFile r107 = new RandomAccessFile(r106, "rw");     // Catch: Throwable -> L17 Exception -> L19
        r105 = r107.getChannel().lock();     // Catch: Exception -> L15 Throwable -> L33
        com.xiaomi.push.v.a(new PolarisFileWrapper(r100.getFilesDir(), r102), r101);     // Catch: Exception -> L15 Throwable -> L33
        if (r105 != null) goto L8;
    L13:
        com.xiaomi.push.v.a(r107);     // Catch: Throwable -> L31
        monitor-exit(r104);     // Catch: Throwable -> L31
        return;
    L8:
        if (r105.isValid() == false) goto L13;
        r105.release();     // Catch: IOException -> L11 Throwable -> L31
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L31
    L15:
        e = e;
    L21:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L33
        if (r105 == null) goto L13;
        if (r105.isValid() == false) goto L13;
        r105.release();     // Catch: IOException -> L27 Throwable -> L31
    L27:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L31
    L33:
        th = th;
    L34:
        if (r105 != null) goto L36;
    L41:
        com.xiaomi.push.v.a(r107);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L36:
        if (r105.isValid() == false) goto L41;
        r105.release();     // Catch: Throwable -> L31 IOException -> L39
    L39:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L31
        goto L41
    L31:
        th = move-exception;
        throw th;
    L19:
        e = e;
        r107 = null;
    L17:
        th = th;
        r107 = null;
        goto L34
    }
}
