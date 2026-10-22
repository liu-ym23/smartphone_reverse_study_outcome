package e84;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile k f471310k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f471311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f471312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f471313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f471314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f471315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f471316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future<n> f471317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f471318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k74.c f471319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile o0 f471320j;

    public class a implements Callable<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f471321a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public n call() {
            k r100 = this.f471321a;
            r100.getClass();
            com.bytedance.bdinstall.t.a("Oaid#initOaid");
            if (o.f471333b > 0) goto L35;
            o.f471333b = System.currentTimeMillis();
        L35:
            com.bytedance.bdinstall.t.a("Oaid#initOaid exec");     // Catch: Throwable -> L28
            n r101 = n.a(r100.f471312b.f471339a.getString("oaid", ""));     // Catch: Throwable -> L28
            com.bytedance.bdinstall.t.a("Oaid#initOaid fetch=" + r101);     // Catch: Throwable -> L28
            if (r101 == null) goto L10;
            r100.f471318h = r101;     // Catch: Throwable -> L28
        L10:
            if (o.f471334c > 0) goto L13;
            o.f471334c = System.currentTimeMillis();     // Catch: Throwable -> L28
        L13:
            n r102 = r100.a(r100.f471314d, r101);     // Catch: Throwable -> L28
            if (o.f471335d > 0) goto L17;
            o.f471335d = System.currentTimeMillis();     // Catch: Throwable -> L28
        L17:
            if (r102 == null) goto L19;
            r100.f471312b.f471339a.edit().putString("oaid", r102.b().toString()).apply();     // Catch: Throwable -> L28
        L19:
            if (r102 == null) goto L21;
            r100.f471318h = r102;     // Catch: Throwable -> L28
        L21:
            com.bytedance.bdinstall.t.a("Oaid#initOaid oaidModel=" + r102);     // Catch: Throwable -> L28
            if (o.f471336e > 0) goto L26;
            o.f471336e = System.currentTimeMillis();
        L26:
            r100.f471316f = new l(r100);
            r100.h();
            return r102;
        L28:
            th = move-exception;
            if (o.f471336e > 0) goto L33;
            o.f471336e = System.currentTimeMillis();
        L33:
            r100.f471316f = new l(r100);
            r100.h();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ n call() throws Exception {
            return call();
        }

        public a(k r100) {
            this.f471321a = r100;
        }
    }

    public final synchronized void h() {
        monitor-enter(this);
        Runnable r100 = this.f471316f;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.run();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f471315e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (o.f471332a > 0) goto L8;
        o.f471332a = System.currentTimeMillis();
    L8:
        a r100 = new a(this);
        this.f471317g = com.bytedance.bdinstall.v.c(com.bytedance.bdinstall.v.a(com.bytedance.bdinstall.v.f199798b)).submit(r100);
    }

    public final String c() {
        d();
        n r100 = this.f471318h;
        if (r100 == null) goto L5;
        String r101 = r100.f471325a;
    L6:
        com.bytedance.bdinstall.t.d("Oaid#getOaidId sOaidId=" + r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public k(Context r100) {
        this.f471315e = new AtomicBoolean(false);
        Context r101 = r100.getApplicationContext();
        this.f471314d = r101;
        String r102 = Build.BRAND;
        if (r102.equals("Pico") == false) goto L6;
        m r103 = new s();
    L118:
        this.f471311a = r103;
        if (r103 == null) goto L121;
        this.f471313c = r103.a(r100);
    L122:
        this.f471312b = new p(r101);
        return;
    L121:
        this.f471313c = false;
        goto L122
    L6:
        if (i84.p.g() == false) goto L8;
        r103 = new r(new v());
        goto L118
    L8:
        String r104 = Build.MANUFACTURER;
        boolean r105 = true;
        if (r104.equalsIgnoreCase("XIAOMI") == false) goto L11;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L28;
        if (v.f471353b != null) goto L21;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L28;
    L35:
        r103 = new v();
        goto L118
    L21:
        if (v.f471352a == null) goto L25;
        if (v.f471354c == null) goto L25;
        r107 = true;
    L28:
        if ("BlackShark".equalsIgnoreCase(r104) == false) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == true) goto L35;
        if (q.f471340a.b(new Object[0]).booleanValue() == false) goto L40;
        r103 = new q();
        goto L118
    L40:
        if (i84.p.i() == false) goto L45;
        if (i84.p.e() == false) goto L45;
        com.bytedance.bdinstall.t.a("honor# old honor oaid");
        r103 = new e();
    L45:
        if (i84.p.i() == false) goto L50;
        if (i84.p.e() == true) goto L50;
        com.bytedance.bdinstall.t.a("honor# new honor oaid");
        r103 = new g();
    L50:
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(r104) == false) goto L53;
        r103 = new e();
        goto L118
    L53:
        if ("OnePlus".equalsIgnoreCase(r104) == false) goto L55;
    L58:
        boolean r109 = true;
    L60:
        if (r109 == false) goto L62;
        r103 = new r(null);
        goto L118
    L62:
        if (r102 != null) goto L64;
        boolean r110 = false;
    L65:
        if (r110 == false) goto L68;
        r103 = new i();
        goto L118
    L68:
        if (Build.VERSION.SDK_INT <= 28) goto L113;
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(r102) == false) goto L72;
    L75:
        boolean r111 = true;
    L76:
        if (r111 == false) goto L78;
        r103 = new t();
        goto L118
    L78:
        String r112 = "";
        if (r104 != null) goto L81;
        String r113 = "";
    L83:
        if (r113.toUpperCase().contains(RomUtils.ROM_NUBIA) == false) goto L86;
        r103 = new j();
        goto L118
    L86:
        if ("lenovo".equalsIgnoreCase(r102) == false) goto L88;
    L99:
        boolean r114 = r105;
    L100:
        if (r114 == false) goto L102;
        r103 = new h();
        goto L118
    L102:
        if (r104 == null) goto L106;
        r112 = r104.trim();
    L106:
        if (r112.toUpperCase().contains("ASUS") == false) goto L108;
        r103 = new e84.a();
        goto L118
    L108:
        r103 = new d(r100);
        if (r103.a(r100) == true) goto L118;
        r103 = new c();
        goto L118
    L88:
        if ("motorola".equalsIgnoreCase(r104) == true) goto L99;
        String r115 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r115) == true) goto L93;
        r114 = r115.contains("VIBEUI_V2");
        goto L100
    L93:
        String r116 = i84.p.d("ro.build.version.incremental");
        if (TextUtils.isEmpty(r116) == false) goto L96;
    L98:
        r105 = false;
        goto L99
    L96:
        if (r116.contains("VIBEUI_V2") == false) goto L98;
    L81:
        r113 = r104.trim();
        goto L83
    L72:
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(r104) == true) goto L75;
        r111 = false;
        goto L76
    L113:
        if (i84.p.j() == false) goto L115;
    L117:
        r103 = null;
        goto L118
    L115:
        if (e.f471304a.b(new Object[]{r100}).booleanValue() == false) goto L117;
        r103 = new e();
        goto L118
    L64:
        r110 = r102.toLowerCase(Locale.ENGLISH).contains("meizu");
        goto L65
    L55:
        if ("OnePlus".equalsIgnoreCase(r102) == true) goto L58;
        r109 = false;
        goto L60
    L30:
        if ("BlackShark".equalsIgnoreCase(r102) == true) goto L33;
        r108 = false;
        goto L34
    L11:
        if (r102.equalsIgnoreCase("XIAOMI") == true) goto L16;
        if (r102.equalsIgnoreCase("REDMI") == true) goto L16;
        r106 = false;
        goto L17
    }

    public static k e(Context r100) {
        if (f471310k != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f471310k != null) goto L9;
        f471310k = new k(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f471310k;
    }

    public final Map<String, String> b(long r110) {
        HashMap r100 = null;
        if (this.f471313c == true) goto L5;
        return null;
    L5:
        d();
        n r101 = this.f471318h;
        if (r101 != null) goto L19;
        long r102 = SystemClock.elapsedRealtime();
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r102) + " ms");
    L16:
        th = move-exception;
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r102) + " ms");
        throw th;
    L9:
        if ((this.f471311a instanceof g) == false) goto L11;
        r110 = r110 + 100;     // Catch: Throwable -> L13
    L11:
        com.bytedance.bdinstall.t.d("Oaid#getOaid timeoutMills=" + r110);     // Catch: Throwable -> L13
        n r111 = this.f471317g.get(r110, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r102) + " ms");
        r101 = r111;
    L19:
        if (r101 != null) goto L21;
        r101 = this.f471318h;
    L21:
        if (r101 == null) goto L32;
        r100 = new HashMap();
        g(r100, "id", r101.f471325a);
        g(r100, "req_id", r101.f471326b);
        g(r100, "is_track_limited", String.valueOf(r101.f471327c));
        g(r100, "take_ms", String.valueOf(r101.f471328d));
        g(r100, "time", String.valueOf(r101.f471329e));
        g(r100, "query_times", String.valueOf(r101.f471330f));
        g(r100, "hw_id_version_code", String.valueOf(r101.f471331g));
        if (this.f471320j == null) goto L32;
        z74.b r112 = i84.d.b().c(this.f471320j.f199728a);
        Boolean r113 = r101.f471327c;
        if (r113 != null) goto L27;
    L29:
        r112.f570656c = 0;
    L30:
        r112.f570655b = !TextUtils.isEmpty(r101.f471325a) ? 1 : 0;
        r112.f570654a = 1;
        r112.f570657d = o.f471335d - o.f471334c;
        goto L32
    L27:
        if (r113.booleanValue() == false) goto L29;
        r112.f570656c = 1;
    L32:
        if (this.f471320j == null) goto L34;
        o0 r114 = this.f471320j;
        i84.d.b().c(r114.f199728a).b(r114, "dr_register_param");
    L34:
        com.bytedance.bdinstall.t.d("Oaid#getOaid return apiMap=" + r100);
        return r100;
    }

    public final n a(Context r110, n r111) {
        long r100 = SystemClock.elapsedRealtime();
        m r101 = this.f471311a;
        String r102 = null;
        if (r101 == null) goto L27;
        m.a r112 = r101.getOaid(r110);
        if (r112 == null) goto L27;
        int r103 = 1;
        if (r111 == null) goto L13;
        r102 = r111.f471326b;
        Integer r113 = r111.f471330f;
        if (r113 != null) goto L11;
        int r114 = 0;
    L12:
        int r115 = r114 + 1;
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L17;
        r102 = UUID.randomUUID().toString();
    L17:
        String r104 = r102;
        if (r115 <= 0) goto L21;
        r103 = r115;
    L21:
        long r105 = SystemClock.elapsedRealtime() - r100;
        if ((r112 instanceof e.b) == false) goto L24;
        long r106 = ((e.b) r112).f471305c;
    L26:
        return new n(r112.f471323a, r104, Boolean.valueOf(r112.f471324b), Long.valueOf(r105), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r103), Long.valueOf(r106));
    L24:
        r106 = 0;
        goto L26
    L11:
        r114 = r113.intValue();
        goto L12
    L13:
        r115 = -1;
    L27:
        return null;
    }

    public static void f(JSONObject r100, String r101, Object r102) {
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r102 == null) goto L13;
        r100.put(r101, r102);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    public static <K, V> void g(Map<K, V> r100, K r101, V r102) {
        if (r102 == null) goto L5;
        ((HashMap) r100).put(r101, r102);
        return;
    }
}
