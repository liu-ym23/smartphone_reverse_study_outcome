package com.bytedance.sdk.account.time;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import java.lang.reflect.Method;
import java.time.Clock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RealTimeManager {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, RealTimeManager> f269490j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile int f269491k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bytedance.sdk.account.time.a f269492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f269493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f269494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile SharedPreferences f269495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile c f269496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f269497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Method f269498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Method f269499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f269500i;

    public static final class a {
        public static RealTimeManager a() {
            Map<String, RealTimeManager> r100 = RealTimeManager.f269490j;
            RealTimeManager r101 = (RealTimeManager) ((ConcurrentHashMap) r100).get("_Default");
            if (r101 != null) goto L12;
            monitor-enter(r100);
            r101 = (RealTimeManager) ((ConcurrentHashMap) r100).get("_Default");     // Catch: Throwable -> L13
            if (r101 == null) goto L10;
            monitor-exit(r100);
            goto L12
        L10:
            r101 = new RealTimeManager();     // Catch: Throwable -> L13
            ((ConcurrentHashMap) r100).put("_Default", r101);     // Catch: Throwable -> L13
            monitor-exit(r100);
        L13:
            th = move-exception;
            throw th;
        L12:
            return r101;
        }
    }

    public static final RealTimeManager c() {
        return a.a();
    }

    static {
        f269490j = new ConcurrentHashMap();
    }

    public final Method d() {
        if (this.f269498g != null) goto L5;
        this.f269498g = SystemClock.class.getMethod("currentNetworkTimeClock", new Class[0]);
    L5:
        Method r100 = this.f269498g;
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }

    public final Method e() throws NoSuchMethodException {
        if (this.f269499h != null) goto L5;
        this.f269499h = SystemClock.class.getMethod("currentNetworkTimeMillis", new Class[0]);
    L5:
        Method r100 = this.f269499h;
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }

    public RealTimeManager() {
        this.f269500i = "_Default";
        this.f269496e = new c(0);
    }

    public final SharedPreferences f(Context r100) {
        if (this.f269495d != null) goto L19;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f269495d == null) goto L8;
    L12:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        goto L19
    L8:
        if (Intrinsics.areEqual(this.f269500i, "_Default") == false) goto L10;
        String r102 = "tt_token_time";
    L11:
        this.f269495d = r100.getSharedPreferences(r102, 0);     // Catch: Throwable -> L15
        goto L12
    L10:
        r102 = "tt_token_time_instance_" + this.f269500i;     // Catch: Throwable -> L15
    L19:
        return this.f269495d;
    }

    public final void g(Context r110) {
        if (this.f269494c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.f269494c == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        SharedPreferences r111 = f(r110);     // Catch: Throwable -> L22
        if (r111 == null) goto L19;
        long r100 = r111.getLong("serverTimeMillis", 0);     // Catch: Throwable -> L22
        long r101 = r111.getLong("systemTimeMillis", 0);     // Catch: Throwable -> L22
        long r102 = r111.getLong("elapsedRealTimeMillis", 0);     // Catch: Throwable -> L22
        int r112 = r111.getInt("systemBootTimes", -1);     // Catch: Throwable -> L22
        if (r100 <= 0) goto L19;
        if (r101 <= 0) goto L19;
        if (r102 <= 0) goto L19;
        this.f269492a = new com.bytedance.sdk.account.time.a(r100, r101, r102, r112);     // Catch: Throwable -> L22
    L19:
        this.f269494c = true;     // Catch: Throwable -> L22
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.bytedance.sdk.account.time.RealTimeManager$getCurrentTime$4] */
    public final b b(Context r210, final boolean r211) {
        final c r110 = this.f269496e;
        g(r210);
        monitor-enter(this);
        final long r111 = System.currentTimeMillis();     // Catch: Throwable -> L117
        long r112 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L117
        com.bytedance.sdk.account.time.a r100 = this.f269492a;     // Catch: Throwable -> L117
        boolean r101 = this.f269493b;     // Catch: Throwable -> L117
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L117
        monitor-exit(this);
        boolean r113 = e.b(r210, r111);
        if (r100 == null) goto L9;
        long r103 = r100.f269501a;
    L10:
        final long r104 = r103;
        if (r101 == false) goto L13;
        Pair r105 = TuplesKt.to(Boolean.FALSE, -1);
    L24:
        boolean r114 = ((Boolean) r105.component1()).booleanValue();
        int r106 = ((Number) r105.component2()).intValue();
        if (r114 == false) goto L36;
        if (r100 != null) goto L28;
    L31:
        boolean r107 = false;
    L32:
        if (r107 == false) goto L35;
        if (r211 == false) goto L35;
        Map<String, Long> r108 = d.f269516a;
        final String r109 = this.f269500i;
        d.c("passport_time_device_probably_changed", 3600000, new RealTimeMonitor$monitorDeviceProbablyChanged$1(r109));
    L35:
        boolean r115 = r107;
        boolean r116 = false;
    L42:
        boolean r117 = r110.f269515f;
        if (r100 == null) goto L45;
        final int r118 = 1;
    L46:
        if (r113 == false) goto L48;
        r118 = r118 | 8;
    L48:
        if (r114 == false) goto L50;
        r118 = r118 | 4;
    L50:
        if (r101 == false) goto L52;
        r118 = r118 | 16;
    L52:
        if (r116 == false) goto L54;
        r118 = r118 | 32;
    L54:
        if (r115 == false) goto L56;
        r118 = r118 | 64;
    L56:
        ?? r119 = new RealTimeManager$getCurrentTime$4(this, r104, r118, r110, r111, r211);
        if (r110.f269511b == true) goto L61;
        return r119.invoke(System.currentTimeMillis(), 4);
    L61:
        if (r110.f269514e == true) goto L63;
    L91:
        long r120 = 0;
    L93:
        if (r120 <= 0) goto L97;
        return r119.invoke(r120, 5);
    L97:
        if (r110.f269512c == false) goto L102;
        if (r113 == false) goto L102;
        return r119.invoke(r111, 4);
    L102:
        if (r100 == null) goto L104;
        if (r114 == false) goto L111;
        if (r113 == false) goto L116;
        return r119.invoke(r111, 4);
    L116:
        return r119.invoke(r100.f269501a + (r111 - r100.f269502b), 2);
    L111:
        return r119.invoke(r100.f269501a + (r112 - r100.f269503c), 1);
    L104:
        if (r110.f269513d == false) goto L108;
        if (r113 == false) goto L108;
        return r119.invoke(r111, 4);
    L108:
        return r119.invoke(r111, 4);
    L63:
        if (this.f269497f == true) goto L71;
        Flipped.invokeHiddenApiRestrictions();     // Catch: Exception -> L67
    L69:
        this.f269497f = true;
    L67:
        e = move-exception;
        tb7.a.c("RealTimeManager", "Flipped init failed", e);
    L71:
        if (Build.VERSION.SDK_INT < 33) goto L124;
        Object r121 = d().invoke(null, new Object[0]);     // Catch: Exception -> L77 NoSuchMethodException -> L79
        if (r121 == null) goto L76;
        r120 = ((Clock) r121).millis();     // Catch: Exception -> L77 NoSuchMethodException -> L79
        goto L93
    L76:
        throw new TypeCastException("null cannot be cast to non-null type java.time.Clock");     // Catch: Exception -> L77 NoSuchMethodException -> L79
    L79:
        e = move-exception;
        tb7.a.b("RealTimeManager", "currentNetworkTimeClock method not found: " + e);
    L77:
        e = move-exception;
        tb7.a.b("RealTimeManager", "currentNetworkTimeClock exception: " + e);
        goto L91
    L124:
        Object r122 = e().invoke(null, new Object[0]);     // Catch: Exception -> L87 NoSuchMethodException -> L89
        if (r122 == null) goto L86;
        r120 = ((Long) r122).longValue();     // Catch: Exception -> L87 NoSuchMethodException -> L89
        goto L93
    L86:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L87 NoSuchMethodException -> L89
    L89:
        e = move-exception;
        tb7.a.b("RealTimeManager", "currentNetworkTimeMillis method not found: " + e);
    L87:
        e = move-exception;
        tb7.a.b("RealTimeManager", "currentNetworkTimeMillis exception: " + e);
        goto L91
    L45:
        r118 = 0;
        goto L46
    L28:
        if (r100.f269504d <= r106) goto L31;
        if (r106 <= 0) goto L31;
        r107 = true;
        goto L32
    L36:
        if (r100 != null) goto L38;
    L40:
        r116 = false;
    L41:
        r115 = false;
        goto L42
    L38:
        if (Math.abs((r111 - r112) - (r100.f269502b - r100.f269503c)) <= 60000) goto L40;
        r116 = true;
        goto L41
    L13:
        int r123 = e.a(r210);
        if (r100 == null) goto L22;
        if (r123 == (-1)) goto L22;
        if (r100.f269504d != r123) goto L22;
        if (r112 < r100.f269503c) goto L22;
        boolean r124 = false;
    L23:
        r105 = TuplesKt.to(Boolean.valueOf(r124), Integer.valueOf(r123));
    L22:
        r124 = true;
        goto L23
    L9:
        r103 = -1;
    L117:
        th = move-exception;
        throw th;
    }

    public final void a(Context r110, long r111, long r210, long r211) {
        int r100 = e.a(r110);
        boolean r112 = e.b(r110, r210);
        monitor-enter(this);
        this.f269493b = true;     // Catch: Throwable -> L15
        this.f269492a = new com.bytedance.sdk.account.time.a(r111, r210, r211, r100);     // Catch: Throwable -> L15
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        tb7.a.d("RealTimeManager", "[Time Calibration] System time is quicker by " + (r210 - r111) + " ms");
        SharedPreferences r102 = f(r110);
        if (r102 == null) goto L13;
        com.bytedance.sdk.account.time.a r103 = this.f269492a;
        if (r103 != null) goto L12;
        r102.edit().clear().apply();
        goto L13
    L12:
        r102.edit().putLong("serverTimeMillis", r103.f269501a).putLong("systemTimeMillis", r103.f269502b).putLong("elapsedRealTimeMillis", r103.f269503c).putInt("systemBootTimes", r103.f269504d).apply();
    L13:
        tb7.a.d("RealTimeManager", "calibrateTime\nserverTimeMillis=" + r111 + "\ncurrentSystemTimeMillis=" + r210 + "\nelapsedRealTimeMillis=" + r211 + "\nsystemBootTimes=" + r100 + "\nisSystemTimeSyncWithNetwork=" + r112 + '\n');
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
