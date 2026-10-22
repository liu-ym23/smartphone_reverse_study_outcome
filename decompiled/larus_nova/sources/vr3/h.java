package vr3;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import ws3.l;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends ss3.a implements ds3.a.InterfaceC5704a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f556842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f556843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f556844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f556845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f556846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f556847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f556848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f556849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f556850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f556851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f556852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f556853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList<Long> f556854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f556855t;

    public class a implements ykc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f556856a;

        public a(h r100) {
            this.f556856a = r100;
        }

        public final void a(float r100, long r101) {
            Object r102 = this.f556856a.f556847l;
            monitor-enter(r102);
        L37:
            th = move-exception;
            throw th;
        L5:
            if (TextUtils.isEmpty(this.f556856a.f556845j) == false) goto L8;
            monitor-exit(r102);     // Catch: Throwable -> L37
            return;
        L8:
            h r103 = this.f556856a;     // Catch: Throwable -> L37
            if (r103.f543333b == false) goto L11;
        L34:
            r103.i();     // Catch: Throwable -> L37
            monitor-exit(r102);     // Catch: Throwable -> L37
            return;
        L11:
            if (r103.f556852q == true) goto L34;
            if (r103.f556848m != 0) goto L16;
            r103.f556850o = com.bytedance.monitor.collector.c.e().a();     // Catch: Throwable -> L37
            h r104 = this.f556856a;     // Catch: Throwable -> L37
            r104.f556851p = r104.f556853r.a();     // Catch: Throwable -> L37
            this.f556856a.f556854s.clear();     // Catch: Throwable -> L37
        L16:
            h r105 = this.f556856a;     // Catch: Throwable -> L37
            long r106 = r105.f556848m + 1;     // Catch: Throwable -> L37
            r105.f556848m = r106;     // Catch: Throwable -> L37
            float r107 = r105.f556849n + r100;     // Catch: Throwable -> L37
            r105.f556849n = r107;     // Catch: Throwable -> L37
            if (r106 > 20) goto L19;
        L32:
            monitor-exit(r102);     // Catch: Throwable -> L37
            return;
        L19:
            if (r107 <= 200.0f) goto L31;
            b r108 = new b();     // Catch: Throwable -> L37
            r108.f556857a = r107 / r106;     // Catch: Throwable -> L37
            r108.f556860d = r101;     // Catch: Throwable -> L37
            long r109 = com.bytedance.monitor.collector.c.e().a();     // Catch: Throwable -> L37
            h r110 = this.f556856a;     // Catch: Throwable -> L37
            r108.f556858b = r109 - r110.f556850o;     // Catch: Throwable -> L37
            long r111 = r110.f556853r.a();     // Catch: Throwable -> L37
            h r112 = this.f556856a;     // Catch: Throwable -> L37
            r108.f556859c = r111 - r112.f556851p;     // Catch: Throwable -> L37
            CopyOnWriteArrayList<Long> r113 = r112.f556854s;     // Catch: Throwable -> L37
            if (r113 != null) goto L23;
        L30:
            h r114 = this.f556856a;     // Catch: Throwable -> L37
            r114.f556846k.put(r114.f556845j, r108);     // Catch: Throwable -> L37
            goto L31
        L23:
            if (r113.size() == 0) goto L30;
            int r115 = 0;
        L27:
            if (r115 >= (r113.size() - 1)) goto L29;
            StringBuilder r116 = r108.f556861e;     // Catch: Throwable -> L37
            r116.append(ListProtector.get(r113, r115));     // Catch: Throwable -> L37
            r116.append(',');     // Catch: Throwable -> L37
            r115 = r115 + 1;     // Catch: Throwable -> L37
            goto L27
        L29:
            r108.f556861e.append(ListProtector.get(r113, r113.size() - 1));     // Catch: Throwable -> L37
        L31:
            this.f556856a.j();     // Catch: Throwable -> L37
            goto L32
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f556857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f556858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f556859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f556860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StringBuilder f556861e;

        public b() {
            this.f556861e = new StringBuilder();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f556862a = null;

        static {
            f556862a = new h();
        }
    }

    @Override // ss3.a
    public final void f() {
    }

    @Override // ss3.a
    public final boolean c() {
        return !this.f543333b;
    }

    @Override // ss3.a
    public final void e() {
        Iterator<Map.Entry<String, b>> r100 = this.f556846k.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<String, b> r101 = r100.next();
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L8
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L8
        r103.put("scene", r101.getKey());     // Catch: JSONException -> L8
        r102.put("current", r101.getValue().f556857a);     // Catch: JSONException -> L8
        r102.put("capacity", r101.getValue().f556860d);     // Catch: JSONException -> L8
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L8
        r104.put("cpu_time", r101.getValue().f556858b);     // Catch: JSONException -> L8
        r104.put("traffic", r101.getValue().f556859c);     // Catch: JSONException -> L8
        r104.put("loc", r101.getValue().f556861e.toString());     // Catch: JSONException -> L8
        js3.e r105 = new js3.e(Scraps.BATTERY, "", r102, r103, r104);     // Catch: JSONException -> L8
        r105.f500222f = ss3.f.a().b(false);     // Catch: JSONException -> L8
        is3.a.h().b(r105);     // Catch: JSONException -> L8
        goto L4
    L9:
        this.f556846k.clear();
    }

    public final void i() {
        if (TextUtils.isEmpty(this.f556845j) == true) goto L9;
        this.f556845j = null;
        bt3.b.d.f20539a.i(this);
        PthreadHandlerThreadV2 r100 = ykc.a.f568293a;
        if (r100 == null) goto L7;
        r100.quit();
        ((a) ykc.a.f568295c).f556856a.j();
        ykc.a.f568293a = null;
        ykc.a.f568294b = null;
        ykc.a.f568295c = null;
    L7:
        j();
        return;
    }

    public final void j() {
        this.f556848m = 0;
        this.f556849n = 0.0f;
    }

    public h() {
        this.f556846k = new ConcurrentHashMap();
        this.f556847l = new Object();
        this.f556848m = 0;
        this.f556849n = 0.0f;
        this.f556850o = 0;
        this.f556851p = 0;
        this.f556853r = l.a.f561030a;
        this.f556854s = new CopyOnWriteArrayList();
        this.f556855t = new a(this);
        this.f543336e = Scraps.BATTERY;
    }

    @Override // ss3.a
    public final void d() {
        this.f556852q = ds3.a.b(com.bytedance.apm.d.getContext(), this);
    }

    @Override // ss3.a
    public final long h() {
        return this.f556844i;
    }

    @Override // ss3.a
    public final void a(JSONObject r100) {
        boolean r101 = false;
        if (r100.optInt("energy_enable", 0) != 1) goto L5;
        r101 = true;
    L5:
        this.f556842g = r101;
        if (r101 == false) goto L8;
        this.f556843h = r100.optInt("battery_energy_sample_interval", 3000);
        this.f556844i = r100.optLong("battery_energy_upload_interval", 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        bt3.b.d.f20539a.i(this);
    }

    @Override // ss3.a, ff7.c
    public final void onBackground(Activity r100) {
        super.onBackground(r100);
        bt3.b.d.f20539a.i(this);
        Object r101 = this.f556847l;
        monitor-enter(r101);
        i();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // ds3.a.InterfaceC5704a
    public final void onChange(boolean r100) {
        this.f556852q = r100;
        if (r100 == false) goto L12;
        Object r101 = this.f556847l;
        monitor-enter(r101);
        i();     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // ss3.a, ff7.c
    public final void onFront(Activity r100) {
        super.onFront(r100);
    }
}
