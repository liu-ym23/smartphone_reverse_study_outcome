package vr3;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends ss3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f556878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f556879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f556880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f556881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f556882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList<b> f556883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<b> f556884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f556885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f556886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f556887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f556888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f556889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f556890s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f556891t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f556892u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f556893a = null;

        static {
            f556893a = new k();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f556894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f556895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f556896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f556897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f556898e;

        public b() {
        }

        public final String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.f556894a, Long.valueOf(this.f556898e - this.f556896c), Long.valueOf(this.f556897d - this.f556895b), Double.valueOf(a())});
        }

        public final double a() {
            double r100 = (this.f556897d - this.f556895b) / 1000.0d;
            if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L5:
            return (Math.round((this.f556898e - this.f556896c) / r100) * 100) / 100.0d;
        }
    }

    @Override // ss3.a
    public final void f() {
    }

    public k() {
        this.f556882k = new ConcurrentHashMap();
        this.f556883l = new LinkedList();
        this.f556884m = new LinkedList();
        this.f556885n = 0;
        this.f556886o = 0;
        this.f556887p = 0;
        this.f556888q = 0;
        this.f556889r = 0;
        this.f556890s = 0;
        this.f556891t = 0;
        this.f543336e = Scraps.BATTERY;
    }

    @Override // ss3.a
    public final void e() {
        long r100 = com.bytedance.apm.util.b.a();
        long r101 = SystemClock.uptimeMillis();
        long r102 = this.f556887p;
        if (r102 != 0) goto L5;
    L14:
        this.f556888q = this.f556885n;
        this.f556886o = r100;
        this.f556887p = r101;
        long r103 = SystemClock.uptimeMillis();
        long r104 = this.f556890s;
        if ((this.f556880i + r104) > r103) goto L26;
        long r105 = r103 - r104;
        this.f556890s = r103;
        int r106 = ((BatteryManager) xu3.a.getContext().getSystemService("batterymanager")).getIntProperty(4);
        int r107 = r106 - this.f556889r;
        if (this.f556891t == this.f556885n) goto L20;
    L25:
        this.f556889r = r106;
        this.f556891t = this.f556885n;
        goto L26
    L20:
        if (this.f543333b == true) goto L25;
        if (r107 > 0) goto L25;
        int r108 = Math.abs(r107);
        if (r108 > 100) goto L25;
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L44
        r109.put(Scraps.BATTERY, Math.abs(r108));     // Catch: Exception -> L44
        r109.put("duraion", r105);     // Catch: Exception -> L44
        jt3.a.e("apm_battery_monitor", 0, null, r109, null);     // Catch: Exception -> L44
    L26:
        long r110 = SystemClock.uptimeMillis();
        if ((this.f556892u + this.f556881j) > r110) goto L57;
        this.f556892u = r110;
        LinkedList<b> r111 = this.f556884m;
        monitor-enter(r111);
        Iterator<b> r112 = this.f556884m.iterator();     // Catch: Throwable -> L40
    L33:
        if (r112.hasNext() == false) goto L37;
        b r113 = r112.next();     // Catch: Throwable -> L40
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L45 Throwable -> L40
        r114.put("scene", r113.f556894a);     // Catch: Exception -> L45 Throwable -> L40
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L45 Throwable -> L40
        r115.put("cpu_speed", r113.a());     // Catch: Exception -> L45 Throwable -> L40
        jt3.a.e("apm_proc_cpu_info", 0, r114, r115, null);     // Catch: Exception -> L45 Throwable -> L40
        goto L33
    L37:
        this.f556884m.clear();     // Catch: Throwable -> L40
        monitor-exit(r111);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L57:
        return;
    L5:
        if (this.f556888q != this.f556885n) goto L14;
        double r116 = (r101 - r102) / 60000.0d;
        if (r116 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        double r117 = Math.round(((r100 - this.f556886o) / r116) * 100.0d) / 100.0d;
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L43
        if (this.f543333b == false) goto L12;
        String r119 = "background";
    L13:
        r118.put("status", r119);     // Catch: Exception -> L43
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L43
        r120.put("cpu_speed_min", r117);     // Catch: Exception -> L43
        jt3.a.e("apm_cpu_speed", 0, r118, r120, null);     // Catch: Exception -> L43
        goto L14
    L12:
        r119 = "foreground";
        goto L13
    }

    @Override // ss3.a
    public final boolean c() {
        return this.f556878g;
    }

    @Override // ss3.a
    public final long h() {
        return this.f556879h;
    }

    @Override // ss3.a
    public final void a(JSONObject r100) {
        boolean r101 = false;
        if (r100.optInt("power_monitor_enable", 0) != 1) goto L5;
        r101 = true;
    L5:
        this.f556878g = r101;
        if (r101 == false) goto L8;
        this.f556879h = r100.optLong("power_cpu_monitor_interval", 60000);
        this.f556880i = r100.optLong("power_battery_monior_interval", 300000);
        this.f556881j = r100.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        bt3.b.d.f20539a.i(this);
    }

    @Override // ss3.a, ff7.c
    public final void onBackground(Activity r100) {
        super.onBackground(r100);
        this.f556885n++;
    }

    @Override // ss3.a, ff7.c
    public final void onFront(Activity r100) {
        super.onFront(r100);
        this.f556885n++;
    }
}
