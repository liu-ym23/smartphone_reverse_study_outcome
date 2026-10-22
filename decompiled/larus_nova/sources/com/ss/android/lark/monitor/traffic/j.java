package com.ss.android.lark.monitor.traffic;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class j extends com.ss.android.lark.monitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.monitor.i f432484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f432485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f432486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<c> f432487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f432488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f432489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f432490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f432491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f432492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f432493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RustSdkTrafficHandler f432494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f432495l;

    public final void d() {
        k r100 = new k();
        r100.K = "1";
        Iterator r101 = ((ArrayList) this.f432487d).iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((c) r101.next()).a(r100);
        goto L4
    L7:
        if (((((((r100.f432497a + r100.f432502f) + r100.f432507k) + r100.f432512p) + r100.f432517u) + r100.f432522z) + r100.E) > 0.0f) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        r100.f432496J = (System.currentTimeMillis() - this.f432485b) / 1000.0f;
        JSONObject r103 = r100.a();     // Catch: Exception -> L26
        if (r103 != null) goto L16;
        return;
    L16:
        isb.a.c("app_network_cost", r103);     // Catch: Exception -> L26
        Log.i("TrafficMonitor", "network consumption reportResult:" + r103);     // Catch: Exception -> L26
        int r104 = this.f432495l;     // Catch: Exception -> L26
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L19;
    L20:
        float r105 = r100.f432498b;     // Catch: Exception -> L26
        if (r105 > 400000.0f) goto L23;
        return;
    L23:
        if ((r105 / r100.f432496J) <= 165.0f) goto L33;
        Log.e("App Mobile TrafficException", new Throwable("foreground/background cost " + (r100.f432498b / 1024.0f) + " M mobile traffic, time interval is(s) " + r100.f432496J), true);     // Catch: Exception -> L26
        return;
    L33:
        return;
    L19:
        this.f432491h.c();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.i("TrafficMonitor", "[onTriggerTrafficMetrics]" + e);
        return;
    L9:
        r102 = false;
        goto L10
    }

    public j(com.ss.android.lark.monitor.i r100) {
        this.f432486c = false;
        this.f432484a = r100;
        this.f432487d = new ArrayList();
        this.f432488e = new n();
        this.f432490g = new d();
        this.f432491h = new b();
        this.f432492i = new m();
        this.f432493j = new g();
        this.f432494k = new RustSdkTrafficHandler();
        List<c> r101 = this.f432487d;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new f(r100));
        List<c> r103 = this.f432487d;
        ArrayList r104 = (ArrayList) r103;
        r104.add(this.f432494k);
        List<c> r105 = this.f432487d;
        ArrayList r106 = (ArrayList) r105;
        r106.add(this.f432488e);
        List<c> r107 = this.f432487d;
        ArrayList r108 = (ArrayList) r107;
        r108.add(this.f432490g);
        List<c> r109 = this.f432487d;
        ArrayList r110 = (ArrayList) r109;
        r110.add(this.f432491h);
        List<c> r111 = this.f432487d;
        ArrayList r112 = (ArrayList) r111;
        r112.add(this.f432492i);
        List<c> r113 = this.f432487d;
        ArrayList r114 = (ArrayList) r113;
        r114.add(this.f432493j);
        this.f432486c = true;
        this.f432485b = System.currentTimeMillis();
        if (this.f432484a.f432400d == false) goto L6;
        i r115 = new i();
        this.f432489f = r115;
        Log.d("Verify", "start get app current traffic statistics ");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r115));
        this.f432484a.f432398b.b();
        return;
    }

    @Override // com.ss.android.lark.monitor.a
    public final void a(y r100, int r101) {
        if (this.f432486c == true) goto L5;
        return;
    L5:
        this.f432495l = r101;
        if (this.f432484a.f432400d == false) goto L8;
        i r102 = this.f432489f;
        r102.getClass();
        Log.d("Verify", "start get app current traffic statistics ");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r102));
    L8:
        monitor-enter(this);
        Iterator r103 = ((ArrayList) this.f432487d).iterator();     // Catch: Throwable -> L20
    L11:
        if (r103.hasNext() == false) goto L13;
        ((c) r103.next()).b();     // Catch: Throwable -> L20
        goto L11
    L13:
        d();     // Catch: Throwable -> L20
        Iterator r104 = ((ArrayList) this.f432487d).iterator();     // Catch: Throwable -> L20
    L15:
        if (r104.hasNext() == false) goto L17;
        ((c) r104.next()).reset();     // Catch: Throwable -> L20
        goto L15
    L17:
        this.f432485b = System.currentTimeMillis();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void c(long r100, String r101) {
        m r102 = this.f432492i;
        if (r102 == null) goto L25;
        com.ss.android.lark.monitor.i r103 = this.f432484a;
        if (r103 == null) goto L30;
        String r104 = r103.f432401e;
        r102.getClass();
        StringBuilder r105 = new StringBuilder();
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r105.append(r101);
        r105.append(" cost(Kb) ");
        r105.append(r100 / 1024);
        Log.i("VideoPlayTraffic", r105.toString());
        if (isb.a.b() == true) goto L18;
        monitor-enter(r102);
        r102.f432530b.mobileBytesRx += r100;     // Catch: Throwable -> L15
        r102.f432530b.mobileBytesTx += 0;     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        monitor-enter(r102);
        r102.f432530b.wifiBytesRx += r100;     // Catch: Throwable -> L22
        r102.f432530b.wifiBytesTx += 0;     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L30:
        return;
    }

    public final void b(String r100, long r101, long r102) {
        b r103 = this.f432491h;
        if (r103 == null) goto L19;
        String r104 = this.f432484a.f432401e;
        r103.getClass();
        monitor-enter(r103);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (r103.f432474b.containsKey(r100) == false) goto L9;
        TrafficMetrics r105 = r103.f432474b.get(r100);     // Catch: Throwable -> L16
    L10:
        r105.from = r100;     // Catch: Throwable -> L16
        if (isb.a.b() == true) goto L13;
        r105.mobileBytesRx += r101;     // Catch: Throwable -> L16
        r105.mobileBytesTx += r102;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
        return;
    L13:
        r105.wifiBytesRx += r101;     // Catch: Throwable -> L16
        r105.wifiBytesTx += r102;     // Catch: Throwable -> L16
        goto L14
    L9:
        r105 = new TrafficMetrics();     // Catch: Throwable -> L16
        r103.f432474b.put(r100, r105);     // Catch: Throwable -> L16
        goto L10
    }
}
