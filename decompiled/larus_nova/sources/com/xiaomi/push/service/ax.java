package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.dn;
import com.xiaomi.push.fx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ax f464282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.ae.b f1072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private dn.a f1073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f1074a;

    public static abstract class a {
        public a() {
        }

        public void a(dn.a r100) {
        }

        public void a(Cdo.b r100) {
        }
    }

    static {
        f464282a = new ax();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m9373a() {
        monitor-enter(ax.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f1071a != null) goto L11;
        SharedPreferences r100 = com.xiaomi.push.q.m9304a().getSharedPreferences("XMPushServiceConfig", 0);     // Catch: Throwable -> L14
        String r101 = r100.getString("DeviceUUID", null);     // Catch: Throwable -> L14
        f1071a = r101;     // Catch: Throwable -> L14
        if (r101 != null) goto L11;
        String r102 = com.xiaomi.push.i.a(com.xiaomi.push.q.m9304a(), false);     // Catch: Throwable -> L14
        f1071a = r102;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        r100.edit().putString("DeviceUUID", f1071a).commit();     // Catch: Throwable -> L14
    L11:
        String r103 = f1071a;     // Catch: Throwable -> L14
        monitor-exit(ax.class);
        return r103;
    }

    private void b() {
        if (this.f1073a != null) goto L6;
        d();
        return;
    }

    private void c() {
        if (this.f1072a == null) goto L5;
        return;
    L5:
        com.xiaomi.push.ae.b r100 = new AnonymousClass1(this);
        this.f1072a = r100;
        fx.a(r100);
    }

    private void d() {
        BufferedInputStream r100 = null;
        BufferedInputStream r101 = new BufferedInputStream(com.xiaomi.push.q.m9304a().openFileInput("XMCloudCfg"));     // Catch: Throwable -> L8 Exception -> L10
        this.f1073a = dn.a.b(com.xiaomi.push.b.a(r101));     // Catch: Exception -> L6 Throwable -> L18
        r101.close();     // Catch: Exception -> L6 Throwable -> L18
    L5:
        com.xiaomi.push.v.a(r101);
        if (this.f1073a != null) goto L27;
        this.f1073a = new dn.a();
        return;
    L27:
        return;
    L6:
        Exception e100 = e;
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("load config failure: " + e100.getMessage());     // Catch: Throwable -> L18
        goto L5
    L18:
        th = th;
        r100 = r101;
    L20:
        com.xiaomi.push.v.a(r100);
        throw th;
    L10:
        e = move-exception;
        r101 = null;
        e100 = e;
    L8:
        th = th;
        goto L20
    }

    private void e() {
    L6:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("save config failure: " + e.getMessage());
        return;
    L3:
        if (this.f1073a == null) goto L11;
        BufferedOutputStream r100 = new BufferedOutputStream(com.xiaomi.push.q.m9304a().openFileOutput("XMCloudCfg", 0));     // Catch: Exception -> L6
        com.xiaomi.push.c r101 = com.xiaomi.push.c.a(r100);     // Catch: Exception -> L6
        this.f1073a.a(r101);     // Catch: Exception -> L6
        r101.m8864a();     // Catch: Exception -> L6
        r100.close();     // Catch: Exception -> L6
        return;
    }

    private ax() {
        this.f1074a = new ArrayList();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m9376a() {
        b();
        dn.a r100 = this.f1073a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9378a() {
        monitor-enter(this);
        this.f1074a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public dn.a m9377a() {
        b();
        return this.f1073a;
    }

    public static ax a() {
        return f464282a;
    }

    public void a(Cdo.b r100) {
        if (r100.m8968d() == true) goto L5;
    L7:
        monitor-enter(this);
        List<a> r101 = this.f1074a;     // Catch: Throwable -> L14
        a[] r102 = (a[]) r101.toArray(new a[r101.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        int r103 = r102.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L13;
        r102[r104].a(r100);
        r104 = r104 + 1;
        goto L11
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r100.d() <= m9376a()) goto L7;
        c();
        goto L7
    }

    public synchronized void a(a r100) {
        monitor-enter(this);
        this.f1074a.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m9375a(ax r100) {
        r100.e();
    }

    public static /* synthetic */ dn.a a(ax r100) {
        return r100.f1073a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ List m9374a(ax r100) {
        return r100.f1074a;
    }

    public static /* synthetic */ com.xiaomi.push.ae.b a(ax r100, com.xiaomi.push.ae.b r101) {
        r100.f1072a = r101;
        return r101;
    }

    public static /* synthetic */ dn.a a(ax r100, dn.a r101) {
        r100.f1073a = r101;
        return r101;
    }
}
