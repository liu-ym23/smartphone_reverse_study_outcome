package xg4;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static p f563716h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f563717i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f563718j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f563719k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f563720l = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f563721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f563722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f563723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f563724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f563725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PolarisFileWrapper f563726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f563727g;

    public static void d(d r100) {
        p r101 = f563716h;
        if (r101 == null) goto L13;
        monitor-enter(r101);
        p r102 = f563716h;     // Catch: Throwable -> L10
        if (r102.f563721a != r100) goto L8;
        r102.f563721a = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public p(Context r100, File r101) {
        this.f563725e = false;
        this.f563727g = 0;
        this.f563722b = new v();
        PolarisFileWrapper r102 = com.bytedance.crash.util.g.b(r101, "anr");
        this.f563726f = r102;
        this.f563723c = new i(r100, r102);
        this.f563724d = new s();
    }

    public static void b(long r100, PolarisFileWrapper r101) {
        p r102 = f563716h;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L15;
        return;
    L15:
        r102.a(r100, false, r101, 0, 1000);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        a.c(th);
        return;
    L5:
        if (r102.f563725e == false) goto L7;
        r103 = true;
        goto L8
    }

    public static synchronized void e(Context r100, PolarisFileWrapper r101) {
        monitor-enter(p.class);
        wh4.b.post(new m(r100, r101));     // Catch: Throwable -> L7
        monitor-exit(p.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(com.bytedance.crash.monitor.a r210, long r211) {
        this.f563723c.e(this.f563726f);     // Catch: Exception -> L5
    L7:
        File[] r100 = this.f563726f.listFiles(new k());
        int r101 = r100.length;
        char r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L51;
        File r104 = r100[r103];
        String[] r110 = r104.getName().split("-");     // Catch: Throwable -> L18
        if (r110.length != 2) goto L17;
        long r111 = CastLongProtector.parseLong(r110[r102]);     // Catch: Throwable -> L18
        long r112 = CastIntegerProtector.parseInt(r110[1]);     // Catch: Throwable -> L16
    L21:
        if (r111 == com.bytedance.crash.i.b()) goto L23;
    L25:
        File[] r113 = r104.listFiles(new l());
        if (r211 <= 0) goto L40;
        ArrayList r105 = new ArrayList();
        int r114 = r113.length;
        int r115 = 0;
    L28:
        if (r115 >= r114) goto L37;
        File r116 = r113[r115];
        w r106 = w.c(r116);
        if (r106 != null) goto L32;
        com.bytedance.crash.util.g.e(r116);
        a.c(new Exception("invalid summary : neither AnrInfo nor Stack"));
        File[] r117 = r100;
        int r118 = r103;
        File r212 = r104;
    L36:
        r115 = r115 + 1;
        r100 = r117;
        r103 = r118;
        r104 = r212;
        goto L28
    L32:
        r117 = r100;
        r118 = r103;
        r212 = r104;
        ai4.e.d(CrashType.ANR, r106.getProcessName(), r106.getPid(), r106.getCrashTime());
        if ((r106.getCrashTime() - r106.getStartTime()) > zg4.i.f572085a) goto L35;
        r106.upload(r210, null);
        goto L36
    L35:
        r105.add(r106);
        goto L36
    L37:
        File[] r119 = r100;
        int r120 = r103;
        File r213 = r104;
        if (r105.isEmpty() == true) goto L47;
        wh4.b.postDelayed(new o(this, r105, r210), r211);
    L47:
        File r107 = r213;
        if (r107.listFiles(new l()).length != 0) goto L50;
        com.bytedance.crash.util.g.e(r107);
    L50:
        r103 = r120 + 1;
        r100 = r119;
        r102 = 0;
        goto L8
    L40:
        r119 = r100;
        r120 = r103;
        r213 = r104;
        int r108 = r113.length;
        int r109 = 0;
    L41:
        if (r109 >= r108) goto L47;
        File r121 = r113[r109];
        w r122 = w.c(r121);
        if (r122 != null) goto L45;
        com.bytedance.crash.util.g.e(r121);
        a.c(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L46:
        r109 = r109 + 1;
        goto L41
    L45:
        ai4.e.d(CrashType.ANR, r122.getProcessName(), r122.getPid(), r122.getCrashTime());
        r122.upload(r210, null);
        goto L46
    L23:
        if (r112 != Process.myPid()) goto L25;
        r119 = r100;
        r120 = r103;
    L19:
        r112 = 0;
        goto L21
    L17:
        r111 = 0;
        r112 = 0;
    L18:
        r111 = 0;
        goto L19
    L51:
        return;
    L5:
        e = move-exception;
        a.c(e);
        goto L7
    }

    public final void c(long r110, int r111, int r112) {
        if (com.bytedance.crash.k.f203231a == true) goto L9;
        if ((r110 - this.f563727g) >= 5000) goto L7;
        return;
    L7:
        this.f563727g = r110;
    L9:
        if (f563720l == true) goto L13;
        if (r111 <= 200) goto L13;
        return;
    L13:
        if (Math.abs(f563717i - r110) >= 120000) goto L15;
        return;
    L15:
        if (Build.VERSION.SDK_INT >= 34) goto L17;
    L29:
        boolean r100 = a.b();
    L30:
        if (r100 == false) goto L49;
        f563717i = r110;
        i.c r101 = f563716h.f563723c.f563659e;
        if (com.bytedance.crash.k.f203231a == false) goto L35;
        r101.getClass();
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r101.f563664w.f563658d, i.b(r110, Process.myPid(), true)), "silent anr no anr info", false);     // Catch: Exception -> L37
    L35:
        r101.f563663v.add(Long.valueOf(r110));
        f563716h.a(r110, true, null, r111, r112);
        return;
    L49:
        return;
    L17:
        if (com.bytedance.crash.k.f203231a == false) goto L29;
        int r102 = 0;
    L20:
        if (r102 >= 100) goto L28;
        r102 = r102 + 1;
        if (a.b() == true) goto L24;
        Thread.sleep(20);     // Catch: Throwable -> L27
        goto L20
    L24:
        r100 = true;
        goto L30
    L28:
        r100 = false;
        goto L30
    }

    public final void a(long r100, boolean r110, PolarisFileWrapper r111, int r112, int r113) {
        monitor-enter(this);
        d r101 = this.f563721a;     // Catch: Throwable -> L21
        if (r101 != null) goto L11;
        i r102 = this.f563723c;     // Catch: Throwable -> L21
        PolarisFileWrapper r103 = this.f563726f;     // Catch: Throwable -> L21
        if (com.bytedance.crash.k.f203232b == false) goto L8;
        d r104 = new d.b(r102, r103, r100, r110);     // Catch: Throwable -> L21
    L9:
        this.f563721a = r104;     // Catch: Throwable -> L21
    L15:
        d r105 = this.f563721a;     // Catch: Throwable -> L21
        monitor-exit(this);
    L14:
        d r106 = r105;
        if (r106 == null) goto L26;
        r106.e(r100, r110, r111, r112, r113);
        return;
    L26:
        return;
    L8:
        r104 = new d.a(r102, r103, r100, r110);     // Catch: Throwable -> L21
        goto L9
    L11:
        if (r101.b(r110) == false) goto L15;
        monitor-exit(this);
        r105 = null;
    L21:
        th = move-exception;
        throw th;
    }
}
