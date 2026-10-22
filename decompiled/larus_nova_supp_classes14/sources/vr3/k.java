package vr3;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends ss3.a {
    public boolean g;
    public long h;
    public long i;
    public long j;
    public final ConcurrentHashMap<String, Long> k;
    public final LinkedList<b> l;
    public final LinkedList<b> m;
    public int n;
    public long o;
    public long p;
    public int q;
    public int r;
    public long s;
    public long t;
    public long u;

    public static final class a {
        public static final k a = null;

        static {
            a = new k();
        }
    }

    public static class b {
        public String a;
        public long b;
        public long c;
        public long d;
        public long e;

        public b() {
        }

        public final String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.a, Long.valueOf(this.e - this.c), Long.valueOf(this.d - this.b), Double.valueOf(a())});
        }

        public final double a() {
            double r0 = (this.d - this.b) / 1000.0d;
            if (r0 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round((this.e - this.c) / r0) * 100) / 100.0d;
        }
    }

    public final void f() {
    }

    public k() {
        this.k = new ConcurrentHashMap();
        this.l = new LinkedList();
        this.m = new LinkedList();
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        ((ss3.a) this).e = "battery";
    }

    public final void e() {
        long r0 = com.bytedance.apm.util.b.a();
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.p;
        if (r4 != 0) goto L5;
    L14:
        this.q = this.n;
        this.o = r0;
        this.p = r2;
        long r1 = SystemClock.uptimeMillis();
        long r3 = this.s;
        if ((this.i + r3) > r1) goto L26;
        long r5 = r1 - r3;
        this.s = r1;
        int r6 = ((BatteryManager) xu3.a.getContext().getSystemService("batterymanager")).getIntProperty(4);
        int r7 = r6 - this.r;
        if (this.t == this.n) goto L20;
    L25:
        this.r = r6;
        this.t = this.n;
        goto L26
    L20:
        if (((ss3.a) this).b == true) goto L25;
        if (r7 > 0) goto L25;
        int r8 = Math.abs(r7);
        if (r8 > 100) goto L25;
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L44
        r9.put("battery", Math.abs(r8));     // Catch: Exception -> L44
        r9.put("duraion", r5);     // Catch: Exception -> L44
        jt3.a.e("apm_battery_monitor", 0, null, r9, null);     // Catch: Exception -> L44
    L26:
        long r10 = SystemClock.uptimeMillis();
        if ((this.u + this.j) > r10) goto L57;
        this.u = r10;
        LinkedList<b> r11 = this.m;
        monitor-enter(r11);
        Iterator<b> r12 = this.m.iterator();     // Catch: Throwable -> L40
    L33:
        if (r12.hasNext() == false) goto L37;
        b r13 = r12.next();     // Catch: Throwable -> L40
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L45 Throwable -> L40
        r14.put("scene", r13.a);     // Catch: Exception -> L45 Throwable -> L40
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L45 Throwable -> L40
        r15.put("cpu_speed", r13.a());     // Catch: Exception -> L45 Throwable -> L40
        jt3.a.e("apm_proc_cpu_info", 0, r14, r15, null);     // Catch: Exception -> L45 Throwable -> L40
        goto L33
    L37:
        this.m.clear();     // Catch: Throwable -> L40
        monitor-exit(r11);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L57:
        return;
    L5:
        if (this.q != this.n) goto L14;
        double r16 = (r2 - r4) / 60000.0d;
        if (r16 <= 0.0d) goto L14;
        double r17 = Math.round(((r0 - this.o) / r16) * 100.0d) / 100.0d;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L43
        if (((ss3.a) this).b == false) goto L12;
        String r19 = "background";
    L13:
        r18.put("status", r19);     // Catch: Exception -> L43
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L43
        r20.put("cpu_speed_min", r17);     // Catch: Exception -> L43
        jt3.a.e("apm_cpu_speed", 0, r18, r20, null);     // Catch: Exception -> L43
        goto L14
    L12:
        r19 = "foreground";
        goto L13
    }

    public final boolean c() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final void a(JSONObject r4) {
        boolean r1 = false;
        if (r4.optInt("power_monitor_enable", 0) != 1) goto L5;
        r1 = true;
    L5:
        this.g = r1;
        if (r1 == false) goto L8;
        this.h = r4.optLong("power_cpu_monitor_interval", 60000);
        this.i = r4.optLong("power_battery_monior_interval", 300000);
        this.j = r4.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        bt3.b.d.a.i(this);
    }

    public final void onBackground(Activity r1) {
        super.onBackground(r1);
        this.n++;
    }

    public final void onFront(Activity r1) {
        super.onFront(r1);
        this.n++;
    }
}
