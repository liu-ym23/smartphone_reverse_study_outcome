package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: loaded from: classes41.dex */
public final class dy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String f471a = null;

    public interface a {
        void a();

        void a(boolean r100);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean mo9040a();
    }

    static {
        f471a = XMJobService.class.getCanonicalName();
        f463420a = 0;
    }

    public static synchronized void a() {
        monitor-enter(dy.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f470a != null) goto L8;
        monitor-exit(dy.class);
        return;
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] stop alarm.");     // Catch: Throwable -> L11
        f470a.a();     // Catch: Throwable -> L11
        monitor-exit(dy.class);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m9039a() {
        monitor-enter(dy.class);
        a r100 = f470a;     // Catch: Throwable -> L12
        if (r100 != null) goto L9;
        monitor-exit(dy.class);
        return false;
    L9:
        boolean r101 = r100.mo9040a();     // Catch: Throwable -> L12
        monitor-exit(dy.class);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(Context r100) {
        Context r101 = r100.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(r101.getPackageName()) == false) goto L5;
        f470a = new dz(r101);
        return;
    L5:
        int r102 = 0;
        ServiceInfo[] r103 = r101.getPackageManager().getPackageInfo(r101.getPackageName(), 4).services;     // Catch: Exception -> L31
        if (r103 == null) goto L33;
        int r104 = r103.length;     // Catch: Exception -> L31
        int r105 = 0;
    L10:
        if (r102 >= r104) goto L30;
        ServiceInfo r106 = r103[r102];     // Catch: Exception -> L28
        if ("android.permission.BIND_JOB_SERVICE".equals(r106.permission) == false) goto L23;
        String r107 = f471a;     // Catch: Exception -> L28
        if (r107.equals(r106.name) == false) goto L41;
    L15:
        r105 = 1;
    L20:
        if (r105 != 1) goto L23;
    L41:
        if (r107.equals(q.a(r101, r106.name).getSuperclass().getCanonicalName()) == false) goto L20;
    L23:
        if (f471a.equals(r106.name) == false) goto L27;
        if ("android.permission.BIND_JOB_SERVICE".equals(r106.permission) == false) goto L27;
        r102 = 1;
    L27:
        r102 = r102 + 1;
    L28:
        e = e;
        r102 = r105;
    L32:
        com.xiaomi.channel.commonutils.logger.b.m8718a("check service err : " + e.getMessage());
    L30:
        r102 = r105;
    L33:
        if (r102 == 0) goto L35;
    L39:
        f470a = new dz(r101);
        return;
    L35:
        if (q.m9307a(r101) == false) goto L39;
        throw new RuntimeException("Should export service: " + f471a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
    L31:
        e = e;
        goto L32
    }

    public static synchronized void a(boolean r100) {
        monitor-enter(dy.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f470a != null) goto L9;
        com.xiaomi.channel.commonutils.logger.b.m8718a("timer is not initialized");     // Catch: Throwable -> L12
        monitor-exit(dy.class);
        return;
    L9:
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] register alarm. (" + r100 + ")");     // Catch: Throwable -> L12
        f470a.a(r100);     // Catch: Throwable -> L12
        monitor-exit(dy.class);
    }

    public static synchronized void a(Context r100, int r101) {
        monitor-enter(dy.class);
        int r102 = f463420a;     // Catch: Throwable -> L15
        if ("com.xiaomi.xmsf".equals(r100.getPackageName()) == true) goto L9;
        if (r101 != 2) goto L8;
        f463420a = 2;     // Catch: Throwable -> L15
        goto L9
    L8:
        f463420a = 0;     // Catch: Throwable -> L15
    L9:
        int r103 = f463420a;     // Catch: Throwable -> L15
        if (r102 == r103) goto L13;
        if (r103 != 2) goto L13;
        a();     // Catch: Throwable -> L15
        f470a = new eb(r100);     // Catch: Throwable -> L15
    L13:
        monitor-exit(dy.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
