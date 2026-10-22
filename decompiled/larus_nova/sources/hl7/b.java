package hl7;

import android.app.Activity;
import android.app.Application;
import android.os.SystemClock;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.settings.e;
import com.bytedance.ug.sdk.luckydog.api.settings.h;
import gk7.j;
import il7.m;
import il7.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import rk7.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile b f485687g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f485688h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f485689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f485690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f485691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f485692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<j> f485693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f485694f;

    public class a extends uo7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f485695a;

        public a(b r100) {
            this.f485695a = r100;
        }

        @Override // uo7.c, uo7.b
        public final void onEnterBackground(Activity r100) {
            super.onEnterBackground(r100);
            b r101 = this.f485695a;
            long r102 = r101.f485690b;
            int r103 = e.f271651a;
            LuckyDogLocalSettings r104 = h.a();
            if (r104 != null) goto L5;
            m.b("activity_local.sp").j("key_last_server_time", r102);
        L6:
            long r105 = r101.f485689a;
            LuckyDogLocalSettings r106 = h.a();
            if (r106 != null) goto L9;
            m.b("activity_local.sp").j("key_time_interval", r105);
        L10:
            d.d("TimeManager", "setLocalTime update lastServerTime = " + r101.f485690b + " , interval = " + r101.f485689a);
            if (this.f485695a.f485691c == true) goto L13;
            d.a("TimeManager", "setBootTime can't update not update time");
            return;
        L13:
            long r107 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            if (Math.abs(r107 - e.b()) <= 1000) goto L21;
            LuckyDogLocalSettings r108 = h.a();
            if (r108 != null) goto L18;
            m.b("activity_local.sp").j("key_boot_time", r107);
            return;
        L18:
            r108.setTimeManagerOldBoot(r107);
            return;
        L21:
            return;
        L9:
            r106.setTimeInterval(r105);
            goto L10
        L5:
            r104.setLastServerTime(r102);
            goto L6
        }
    }

    public static b b() {
        if (f485687g != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f485687g != null) goto L9;
        f485687g = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f485687g;
    }

    public final long a() {
        long r100 = this.f485689a;
        d.a("TimeManager", "calibrateTime(), timeInterval = " + r100);
        if (r100 <= 0) goto L34;
        long r101 = this.f485690b;
        long r102 = SystemClock.elapsedRealtime() + r100;
        d.a("TimeManager", "calibrateTime(), now = " + r102 + ", lastServerTime = " + r101);
        boolean r110 = false;
        if (f485688h != (-1)) goto L11;
        if (m.a().f("lucky_time_enable_boot", Boolean.FALSE) == false) goto L9;
        f485688h = 1;
        goto L11
    L9:
        f485688h = 0;
    L11:
        if (f485688h != 1) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L17;
        d.d("TimeManager", "isBoot 开关关闭");
    L29:
        if (r110 == false) goto L32;
        d.e("TimeManager", "boot time err");
        c.a("boot time err", "luckydog");
    L35:
        r102 = 0;
    L36:
        d.a("TimeManager", "getCurrentTimeStamp() = " + r102);
        if (r102 != 0) goto L39;
        d.d("TimeManager", "calibrateHostTime mHostTime =  0");
        c.a("host time err", "host");
    L39:
        return r102;
    L32:
        if (r102 >= r101) goto L36;
        d.e("TimeManager", "current time < lastServerTime, current = " + r102);
        c.a("now < lastServerTime", "luckydog");
        goto L35
    L17:
        if (this.f485691c == true) goto L29;
        if (this.f485692d == true) goto L29;
        long r104 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        if (e.b() != 0) goto L24;
        long r111 = e.a();
    L26:
        if (Math.abs(r104 - r111) <= 2000) goto L28;
        d.e("TimeManager", "isBoot nowTime = " + r104 + ", oldBootTime = " + r111);
        r110 = true;
        goto L29
    L28:
        this.f485692d = true;
        d.a("TimeManager", "not boot nowTime = " + r104);
        goto L29
    L24:
        r111 = e.b();
        goto L26
    L13:
        r103 = false;
        goto L14
    L34:
        c.a("timeInterval <= 0", "luckydog");
        goto L35
    }

    public b() {
        this.f485689a = e.a();
        LuckyDogLocalSettings r100 = h.a();
        if (r100 != null) goto L5;
        long r101 = m.b("activity_local.sp").d("key_last_server_time", 0);
        d.d("LuckyDogLocalStorage", "getLastServerTime time = " + r101);
    L6:
        this.f485690b = r101;
        this.f485693e = new CopyOnWriteArrayList();
        this.f485694f = new a(this);
        to7.c.d(this.f485694f);
        return;
    L5:
        r101 = r100.getLastServerTime();
        goto L6
    }

    public final void c(long r110, long r111) {
        d.d("TimeManager", "serverTime: " + r110 + ", requestTime: " + r111);
        if (r110 >= 1000000000000L) goto L5;
    L69:
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_calibrator_time_invalid", null, null);
        return;
    L5:
        if (r111 <= 0) goto L69;
        long r112 = SystemClock.elapsedRealtime();
        long r100 = r112 - r111;
        d.d("TimeManager", "currentTimeStamp: " + r112 + ", duration: " + r100);
        if (r100 <= 10000) goto L10;
    L67:
        d.e("TimeManager", "duration not valid: " + r100);
        return;
    L10:
        if (r100 <= 0) goto L67;
        long r101 = r110 + (r100 / 2);
        long r113 = r101 - r112;
        d.d("TimeManager", "calculateServerTime: " + r101 + ", currentTimeInterval: " + r113 + ", localTimeInterval: " + this.f485689a + " , lastServerTime: " + this.f485690b);
        if (this.f485689a != 0) goto L15;
    L20:
        d.d("TimeManager", "mTimeInterval: " + this.f485689a + " -> " + r113);
        if (this.f485691c == true) goto L23;
    L32:
        this.f485689a = r113;
        this.f485690b = r101;
    L34:
        if (r101 <= 0) goto L53;
        boolean r102 = !this.f485691c;
        this.f485691c = true;
        long r114 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        int r103 = e.f271651a;
        LuckyDogLocalSettings r104 = h.a();
        if (r104 != null) goto L38;
        m.b("activity_local.sp").j("key_boot_time", r114);
    L39:
        Iterator<j> r105 = this.f485693e.iterator();
    L41:
        if (r105.hasNext() == false) goto L45;
        j r115 = r105.next();
        if (r115 == null) goto L41;
        r115.a(r102, r101);
        goto L41
    L45:
        if (r102 == false) goto L51;
        AtomicBoolean r106 = u.f538372v;
        u.c.f538395a.getClass();
        if (m.a().f("show_debug_tools", Boolean.FALSE) == false) goto L51;
        Application r107 = rk7.m.f538347a;
        if (rk7.m.f538357k == false) goto L51;
        o.a(rk7.m.g(), "首次时间校准成功\n" + r101);
    L51:
        if (r102 == false) goto L53;
        d.d("TimeManager", "首次时间校准成功 service_time = " + r101);
        goto L53
    L38:
        r104.setTimeManagerOldBoot(r114);
    L53:
        long r108 = hl7.a.f485685b;
        hl7.a.f485685b = r101;
        long r116 = hl7.a.f485686c;
        hl7.a.f485686c = r113;
        long r117 = r113 - r116;
        d.a("TimeManager", "oldLastCalculateTime: " + r108 + ", newLastCalculateTime: " + r101 + ", oldTimeInterval: " + r116 + ", newTimeInterval: " + r113);
        if (r116 > 0) goto L56;
        return;
    L56:
        if (Math.abs(r117) <= hl7.a.f485684a) goto L81;
        gk7.b.a(new hl7.a());
        JSONObject r109 = new JSONObject();
        JSONObject r118 = r109.put("last_server_time", r108);     // Catch: JSONException -> L64
        if (r117 <= 0) goto L61;
        int r119 = 1;
    L62:
        r118.put("change_type", r119);     // Catch: JSONException -> L64
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_calibrator_time_change", r109, null);     // Catch: JSONException -> L64
        return;
    L61:
        r119 = 0;
    L64:
        e = move-exception;
        e.printStackTrace();
        return;
    L81:
        return;
    L23:
        if (this.f485689a == 0) goto L32;
        if (Math.abs(r113 - this.f485689a) <= 1000) goto L32;
        float r120 = Math.abs(r113 - this.f485689a) / 1000.0f;
        JSONObject r121 = new JSONObject();
        r121.put("diff_time", r120).put("duration", r100);     // Catch: JSONException -> L29
    L31:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_calibrator_fluctuation", r121);
    L29:
        e = move-exception;
        d.c("sendCalibratorFluctuationEvent", e.getLocalizedMessage(), e);
        goto L31
    L15:
        if (this.f485690b == 0) goto L20;
        if (Math.abs(r113 - this.f485689a) > 10000) goto L20;
        if (r100 >= 5000) goto L34;
        goto L20
    }
}
