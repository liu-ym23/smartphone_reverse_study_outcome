package et3;

import android.os.SystemClock;
import com.bytedance.apm.constant.FilterTypeStringDef;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static es3.e f473912k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f473914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public es3.e.a f473915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.d f473916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile c.InterfaceC5817c f473917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile c.b f473918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkedList<Integer> f473919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f473920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f473921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f473922j;

    public h() {
        throw null;
    }

    public final synchronized void d() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        String r100 = this.f473913a;     // Catch: Throwable -> L6
        com.bytedance.apm.block.g.f190348c = true;     // Catch: Throwable -> L6
        com.bytedance.apm.block.g.f190346a.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void b() {
        es3.e r100 = f473912k;
        if (r100 == null) goto L20;
        es3.h.f473717z.f473732o.a(new es3.d(r100, this));
        if (this.f473914b == true) goto L7;
        return;
    L7:
        SystemClock.uptimeMillis();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.f473919g.isEmpty() == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L17
    L16:
        this.f473914b = false;
        return;
    L13:
        LinkedList<Integer> r101 = this.f473919g;     // Catch: Throwable -> L17
        this.f473919g = new LinkedList();     // Catch: Throwable -> L17
        es3.e.a r102 = this.f473915c;     // Catch: Throwable -> L17
        this.f473915c = new es3.e.a();     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        HashMap r103 = new HashMap();
        r103.putAll(this.f473920h);
        bt3.b.d.f20539a.e(new g(this, r101, r103, r102));
        goto L16
    }

    public final void c() {
        if (this.f473914b == false) goto L6;
        return;
    L6:
        if (this.f473921i == true) goto L28;
        if (es3.h.f473717z.f473740w == false) goto L17;
        if (com.bytedance.apm.d.f190533u == false) goto L23;
        String r100 = this.f473913a;
        if (zs3.c.f573475a.d(FilterTypeStringDef.FPS_DROP, r100) == true) goto L24;
        String r101 = this.f473913a;
        if (zs3.c.f573475a.d("fps", r101) == false) goto L23;
    L24:
        boolean r102 = true;
    L25:
        if (r102 == true) goto L28;
        return;
    L23:
        r102 = false;
        goto L25
    L17:
        if (com.bytedance.apm.d.f190533u == true) goto L24;
        String r103 = this.f473913a;
        if (zs3.c.f573475a.d(FilterTypeStringDef.FPS_DROP, r103) == true) goto L24;
        String r104 = this.f473913a;
        if (zs3.c.f573475a.d("fps", r104) == false) goto L23;
    L28:
        if (f473912k == null) goto L30;
        this.f473914b = true;
        es3.e r105 = f473912k;
        r105.getClass();
        es3.h.f473717z.f473732o.a(new es3.c(r105, this));
    L30:
        String r106 = this.f473913a;
        com.bytedance.apm.block.g.f190348c = true;
        com.bytedance.apm.block.g.f190346a.add(r106);
        SystemClock.uptimeMillis();
        this.f473914b = true;
    }

    public final void a(long r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f473919g.size() <= 20000) goto L9;
        this.f473919g.poll();     // Catch: Throwable -> L12
    L9:
        this.f473919g.add(Integer.valueOf(((int) r100) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public h(String r100, boolean r101, JSONObject r102) {
        this.f473914b = false;
        this.f473915c = new es3.e.a();
        this.f473920h = new HashMap();
        this.f473913a = r100;
        this.f473921i = r101;
        this.f473922j = r102;
        this.f473919g = new LinkedList();
    }
}
