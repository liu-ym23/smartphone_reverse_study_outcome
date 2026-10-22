package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes41.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f463495a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f513a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Hashtable<Integer, Long> f463496a;

        static {
            f463496a = new Hashtable();
        }
    }

    static {
        f463495a = eh.f463445c.a();
        f513a = 0;
    }

    public static void a() {
        if (f513a != 0) goto L5;
    L6:
        f513a = SystemClock.elapsedRealtime();
        a(0, f463495a);
        return;
    L5:
        if ((SystemClock.elapsedRealtime() - f513a) > 7200000) goto L6;
    }

    public static void b() {
        a(0, f463495a, null, -1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m9056a() {
        ej r100 = en.m9050a().m9053a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ho.a(r100);
    }

    public static void a(int r100) {
        ei r101 = en.m9050a().m9052a();
        r101.a(eh.f463453k.a());
        r101.c(r100);
        en.m9050a().a(r101);
    }

    public static void a(String r100, Exception r101) {
        el.a r102 = el.b(r101);     // Catch: NullPointerException -> L13
        ei r103 = en.m9050a().m9052a();     // Catch: NullPointerException -> L13
        r103.a(r102.f463485a.a());     // Catch: NullPointerException -> L13
        r103.c(r102.f502a);     // Catch: NullPointerException -> L13
        r103.b(r100);     // Catch: NullPointerException -> L13
        if (en.a() != null) goto L5;
    L11:
        en.m9050a().a(r103);     // Catch: NullPointerException -> L13
        return;
    L5:
        if (en.a().f505a == null) goto L11;
        if (at.b(en.a().f505a) == false) goto L9;
        int r104 = 1;
    L10:
        r103.c(r104);     // Catch: NullPointerException -> L13
        goto L11
    L9:
        r104 = 0;
    }

    public static void b(String r100, Exception r101) {
        el.a r102 = el.d(r101);     // Catch: NullPointerException -> L13
        ei r103 = en.m9050a().m9052a();     // Catch: NullPointerException -> L13
        r103.a(r102.f463485a.a());     // Catch: NullPointerException -> L13
        r103.c(r102.f502a);     // Catch: NullPointerException -> L13
        r103.b(r100);     // Catch: NullPointerException -> L13
        if (en.a() != null) goto L5;
    L11:
        en.m9050a().a(r103);     // Catch: NullPointerException -> L13
        return;
    L5:
        if (en.a().f505a == null) goto L11;
        if (at.b(en.a().f505a) == false) goto L9;
        int r104 = 1;
    L10:
        r103.c(r104);     // Catch: NullPointerException -> L13
        goto L11
    L9:
        r104 = 0;
    }

    public static synchronized void a(int r100, int r101) {
        monitor-enter(eo.class);
        if (r101 >= 16777215) goto L8;
        int r102 = (r100 << 24) | r101;
        a.f463496a.put(Integer.valueOf(r102), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L11
    L9:
        monitor-exit(eo.class);
        return;
    L8:
        com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static void a(XMPushService r100, com.xiaomi.push.service.am.b r101) {
        new ek(r100, r101).a();
    }

    public static void a(String r100, int r101, Exception r102) {
        ei r103 = en.m9050a().m9052a();
        if (en.a() != null) goto L5;
    L7:
        if (r101 <= 0) goto L12;
        r103.a(eh.f463454l.a());
        r103.b(r100);
        r103.b(r101);
        en.m9050a().a(r103);
        return;
    L12:
        el.a r104 = el.a(r102);     // Catch: NullPointerException -> L11
        r103.a(r104.f463485a.a());     // Catch: NullPointerException -> L11
        r103.c(r104.f502a);     // Catch: NullPointerException -> L11
        r103.b(r100);     // Catch: NullPointerException -> L11
        en.m9050a().a(r103);     // Catch: NullPointerException -> L11
        return;
    L15:
        return;
    L5:
        if (en.a().f505a == null) goto L7;
        r103.c(at.b(en.a().f505a) ? 1 : 0);
        goto L7
    }

    public static synchronized void a(int r100, int r101, String r102, int r103) {
        monitor-enter(eo.class);
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L13
        int r105 = (r100 << 24) | r101;     // Catch: Throwable -> L13
        if (a.f463496a.containsKey(Integer.valueOf(r105)) == false) goto L10;
        ei r106 = en.m9050a().m9052a();     // Catch: Throwable -> L13
        r106.a(r101);     // Catch: Throwable -> L13
        r106.b((int) (r104 - a.f463496a.get(Integer.valueOf(r105)).longValue()));     // Catch: Throwable -> L13
        r106.b(r102);     // Catch: Throwable -> L13
        if (r103 <= (-1)) goto L9;
        r106.c(r103);     // Catch: Throwable -> L13
    L9:
        en.m9050a().a(r106);     // Catch: Throwable -> L13
        a.f463496a.remove(Integer.valueOf(r101));     // Catch: Throwable -> L13
    L11:
        monitor-exit(eo.class);
        return;
    L10:
        com.xiaomi.channel.commonutils.logger.b.d("stats key not found");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void a(int r100, int r101, int r102, String r103, int r104) {
        ei r105 = en.m9050a().m9052a();
        r105.a((byte) r100);
        r105.a(r101);
        r105.b(r102);
        r105.b(r103);
        r105.c(r104);
        en.m9050a().a(r105);
    }
}
