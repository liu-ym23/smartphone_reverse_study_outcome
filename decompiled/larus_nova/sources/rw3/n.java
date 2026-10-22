package rw3;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.applog.EventType;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.o0;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final List<String> f539658r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f539659s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicInteger f539660t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile boolean f539661u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static a f539662v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f539663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f539664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f539665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f539666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f539667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f539668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jx3.j f539669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jx3.j f539670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f539671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f539672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f539673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f539674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f539675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f539676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f539677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile String f539678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f539679q;

    public static class a extends jx3.k {
        public a() {
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.f539668f.f539604d.f573806b.getClass();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f539658r = Collections.singletonList("Session");
        f539659s = UUID.randomUUID().toString();
        f539660t = new AtomicInteger(0);
        f539661u = true;
    }

    public static String c() {
        if (f539661u == false) goto L6;
        String r100 = f539659s + "#" + f539660t.getAndIncrement();
        com.bytedance.applog.log.n.w().j("Session:genSessionId#: {}", new Object[]{r100});
        return r100;
    L6:
        String r101 = UUID.randomUUID().toString();
        com.bytedance.applog.log.n.w().j("Session:genSessionId: {}", new Object[]{r101});
        return r101;
    }

    public n(f r100) {
        this.f539664b = 0;
        this.f539665c = 0;
        this.f539666d = 0;
        this.f539667e = 0;
        this.f539672j = new AtomicLong(1000);
        this.f539673k = -1;
        this.f539668f = r100;
        this.f539679q = r100.f539604d.f573808d.getLong("latest_forground_session_time", 0);
    }

    public final void a(jx3.a r100) {
        if (r100 == null) goto L5;
        b(r100, this.f539663a);
        com.bytedance.applog.b r101 = this.f539668f.f539603c;
        r100.f500769m = r101.f192413j;
        r100.f500763g = r101.getUserUniqueID();
        r100.f500760d = this.f539671i;
        r100.f500759c = this.f539672j.incrementAndGet();
        r100.f500765i = NetworkUtils.getNetworkTypeFast(this.f539668f.getContext()).getValue();
        return;
    }

    public final void b(jx3.a r100, long r101) {
        IBDAccountCallback r102 = this.f539668f.f539603c.f192396a0;
        if (this.f539668f.f539603c.f192441x == false) goto L11;
        if (r102 == null) goto L11;
        Pair<Integer, Long> r103 = r102.getOdinUserInfo();
        if (((Long) r103.second).longValue() <= 0) goto L9;
        r100.f500761e = ((Long) r103.second).longValue();
        r100.f500767k = 1;
        r100.f500768l = 1;
        r100.f500766j = ((Integer) r103.first).intValue();
        r100.f500762f = ((Long) r103.second).longValue();
    L12:
        com.bytedance.applog.b r104 = this.f539668f.f539603c;
        String.valueOf(r100.f500761e);
        r100.f500764h = r104.N1();
        return;
    L9:
        if (this.f539666d != 0) goto L12;
        r100.f500762f = this.f539664b;
        r100.f500766j = this.f539665c;
        r100.f500767k = this.f539666d;
        r100.f500768l = this.f539667e;
    L11:
        r100.f500761e = r101;
        goto L12
    }

    public final synchronized jx3.g e(jx3.a r210, ArrayList<jx3.a> r211, boolean r212) {
        monitor-enter(this);
        long r100 = 0;
        if (r210 != null) goto L71;
        long r101 = 0;
    L13:
        this.f539671i = c();     // Catch: Throwable -> L10
        if (r212 == false) goto L18;
        this.f539679q = r101;     // Catch: Throwable -> L10
        zw3.b r110 = this.f539668f.f539604d;     // Catch: Throwable -> L10
        r110.f573808d.edit().putLong("latest_forground_session_time", this.f539679q).apply();     // Catch: Throwable -> L10
        this.f539668f.getClass();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(this.f539678p) == false) goto L18;
        this.f539678p = this.f539671i;     // Catch: Throwable -> L10
    L18:
        this.f539672j.set(10000);     // Catch: Throwable -> L10
        this.f539673k = r101;     // Catch: Throwable -> L10
        this.f539674l = r212;     // Catch: Throwable -> L10
        this.f539675m = 0;     // Catch: Throwable -> L10
        if (r212 == false) goto L29;
        Calendar r102 = Calendar.getInstance();     // Catch: Throwable -> L10
        String r103 = "" + r102.get(1) + r102.get(2) + r102.get(5);     // Catch: Throwable -> L10
        zw3.b r104 = this.f539668f.f539604d;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(this.f539677o) == false) goto L24;
        this.f539677o = r104.f573808d.getString("session_last_day", "");     // Catch: Throwable -> L10
        this.f539676n = r104.f573808d.getInt("session_order", 0);     // Catch: Throwable -> L10
    L24:
        if (r103.equals(this.f539677o) == true) goto L26;
        this.f539677o = r103;     // Catch: Throwable -> L10
        this.f539676n = 1;     // Catch: Throwable -> L10
    L27:
        r104.f573808d.edit().putString("session_last_day", r103).putInt("session_order", this.f539676n).apply();     // Catch: Throwable -> L10
        goto L29
    L26:
        this.f539676n++;     // Catch: Throwable -> L10
    L29:
        if (r101 == (-1)) goto L58;
        jx3.g r105 = new jx3.g();     // Catch: Throwable -> L10
        r105.f500769m = this.f539668f.f539603c.f192413j;     // Catch: Throwable -> L10
        r105.f500760d = this.f539671i;     // Catch: Throwable -> L10
        if (this.f539674l == true) goto L33;
        boolean r106 = true;
    L34:
        r105.A = r106;     // Catch: Throwable -> L10
        r105.f500759c = this.f539672j.incrementAndGet();     // Catch: Throwable -> L10
        r105.m(this.f539673k);     // Catch: Throwable -> L10
        o0 r107 = ((nw3.f) this.f539668f.f539608h.f573831a).f520960b;     // Catch: Throwable -> L10
        if (r107 == null) goto L37;
        String r108 = r107.e();     // Catch: Throwable -> L10
    L38:
        r105.f500802z = r108;     // Catch: Throwable -> L10
        o0 r109 = ((nw3.f) this.f539668f.f539608h.f573831a).f520960b;     // Catch: Throwable -> L10
        if (r109 == null) goto L41;
        r100 = r109.f();     // Catch: Throwable -> L10
    L41:
        r105.f500801y = r100;     // Catch: Throwable -> L10
        b(r105, this.f539663a);     // Catch: Throwable -> L10
        r105.f500763g = this.f539668f.f539603c.getUserUniqueID();     // Catch: Throwable -> L10
        r105.f500775s = ax3.b.a(this.f539668f.f539603c.W, r105);     // Catch: Throwable -> L10
        if ((r210 instanceof jx3.j) == false) goto L45;
        r105.C = ((jx3.j) r210).D;     // Catch: Throwable -> L10
    L45:
        if (this.f539668f.f539603c.D == true) goto L47;
    L51:
        r211.add(r105);     // Catch: Throwable -> L10
        if (r105.f500775s <= 0) goto L54;
        ax3.b.c(this.f539668f.f539603c.W, EventStage.COLLECTED, r105);     // Catch: Throwable -> L10
    L54:
        this.f539668f.f539603c.W.b(StatsCountKeys.COLLECT_LAUNCH_COUNT, 1);     // Catch: Throwable -> L10
        if (this.f539674l == false) goto L57;
        this.f539668f.f539603c.W.b(StatsCountKeys.COLLECT_FRONT_LAUNCH_COUNT, 1);     // Catch: Throwable -> L10
    L57:
        this.f539668f.f539603c.f192398b0.a(r105.f500760d, r105.f500758b, r105.A);     // Catch: Throwable -> L10
    L59:
        com.bytedance.applog.b r111 = this.f539668f.f539603c;     // Catch: Throwable -> L10
        if (r111.f192411i > 0) goto L62;
        r111.f192411i = 6;     // Catch: Throwable -> L10
    L62:
        com.bytedance.applog.log.n r112 = r111.f192434t0;     // Catch: Throwable -> L10
        List<String> r113 = f539658r;     // Catch: Throwable -> L10
        StringBuilder r114 = new StringBuilder("startSession, ");     // Catch: Throwable -> L10
        if (this.f539674l == false) goto L65;
        String r115 = AppConstants.APP_FG;
    L66:
        r114.append(r115);     // Catch: Throwable -> L10
        r114.append(", ");     // Catch: Throwable -> L10
        r114.append(this.f539671i);     // Catch: Throwable -> L10
        r114.append(", ");     // Catch: Throwable -> L10
        r114.append(r101);     // Catch: Throwable -> L10
        r112.g(0, r113, r114.toString(), new Object[0]);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L10:
        th = move-exception;
        throw th;
    L65:
        r115 = "bg";
        goto L66
    L47:
        if (this.f539668f.f539603c.S1() == null) goto L51;
        if (this.f539668f.f539603c.S1().f(EventType.Launch.value()) == false) goto L51;
        this.f539668f.f539603c.S1().g(this.f539671i, this.f539674l, r105.f500758b, r105.C);     // Catch: Throwable -> L10
        r105.D = false;     // Catch: Throwable -> L10
        this.f539668f.f539603c.W.c("priority_launch_sent", 1);     // Catch: Throwable -> L10
        goto L51
    L37:
        r108 = "";
        goto L38
    L33:
        r106 = false;
        goto L34
    L58:
        r105 = null;
        goto L59
    L71:
        if ((r210 instanceof a) == false) goto L9;
        r101 = -1;
        goto L13
    L9:
        r101 = r210.f500758b;     // Catch: Throwable -> L10
        goto L13
    }
}
