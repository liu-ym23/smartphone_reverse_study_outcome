package com.lynx.tasm;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes32.dex */
public final class StaticPageHost {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> f381758i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f381759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f381760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f381761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f381762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f381763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Object> f381764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Object> f381765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x1 f381766h;

    static {
        f381758i = new ConcurrentHashMap();
    }

    public final void a() {
        Object r100 = this.f381759a;
        monitor-enter(r100);
        g();     // Catch: Throwable -> L9
        this.f381763e++;     // Catch: Throwable -> L9
        this.f381762d = false;     // Catch: Throwable -> L9
        this.f381761c = -1;     // Catch: Throwable -> L9
        final x1 r101 = this.f381766h;     // Catch: Throwable -> L9
        this.f381766h = null;     // Catch: Throwable -> L9
        this.f381764f = Collections.emptyMap();     // Catch: Throwable -> L9
        this.f381765g = null;     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        b(MapMonitorConst.EVENT_DESTROY, new u1(r101));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r100 = this.f381759a;
        monitor-enter(r100);
        boolean r101 = this.f381762d;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g() {
        int r100 = this.f381761c;
        if (r100 >= 0) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> r101 = f381758i;
        WeakReference<StaticPageHost> r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.get() != this) goto L12;
        r101.remove(Integer.valueOf(this.f381761c), r102);
        return;
    }

    public StaticPageHost(Executor r100) {
        this.f381759a = new Object();
        this.f381761c = -1;
        this.f381764f = Collections.emptyMap();
        this.f381760b = r100;
    }

    public static StaticPageHost c(int r100) {
        ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> r101 = f381758i;
        WeakReference<StaticPageHost> r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L6;
        return null;
    L6:
        StaticPageHost r103 = r102.get();
        if (r103 != null) goto L9;
        r101.remove(Integer.valueOf(r100), r102);
    L9:
        return r103;
    }

    private static boolean renderPageForNative(int r100) {
        StaticPageHost r101 = c(r100);
        if (r101 == null) goto L24;
        Object r102 = r101.f381759a;
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (r101.f381762d == false) goto L17;
        x1 r103 = r101.f381766h;     // Catch: Throwable -> L21
        if (r103 == null) goto L17;
        Map<String, Object> r104 = r101.f381764f;     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        r103.b(r104);     // Catch: RuntimeException -> L15
        boolean r105 = true;
    L19:
        if (r105 == true) goto L29;
        return false;
    L29:
        return true;
    L15:
        e = move-exception;
        e("renderPage", e);
    L18:
        r105 = false;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L21
        goto L18
    L24:
        return false;
    }

    public static void e(String r100, Throwable r101) {
        LLog.e("StaticPageHost", "Static page direct " + r100 + " failed:\n" + CallStackUtil.a(r101));
    }

    public final void b(final String r100, final Runnable r101) {
        this.f381760b.execute(new w1(r101, r100));     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        e(r100.concat(" dispatch"), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> h(TemplateData r100, TemplateData r110) {
        Object r101 = this.f381759a;
        monitor-enter(r101);
        x1 r102 = null;
        if (r100 != null) goto L36;
        Map r103 = null;
    L8:
        if (r103 != null) goto L10;
        final Map<String, Object> r104 = null;
    L15:
        if (r110 != null) goto L17;
        Map r105 = null;
    L18:
        if (r105 != null) goto L20;
        Map<String, Object> r106 = null;
    L26:
        if (this.f381762d == false) goto L28;
        r102 = this.f381766h;     // Catch: Throwable -> L33
    L28:
        final x1 r107 = r102;
        final long r108 = this.f381763e;     // Catch: Throwable -> L33
        monitor-exit(r101);     // Catch: Throwable -> L33
        if (r107 == null) goto L32;
        final Map<String, Object> r109 = r106;
        b("updateMetaData", new v1(this, r107, r108, r104, r109));
    L32:
        return r106;
    L33:
        th = move-exception;
        throw th;
    L20:
        if (this.f381765g != null) goto L22;
        this.f381765g = r105;     // Catch: Throwable -> L33
    L23:
        r106 = this.f381765g;     // Catch: Throwable -> L33
        goto L26
    L22:
        HashMap r111 = new HashMap(this.f381765g);     // Catch: Throwable -> L33
        r111.putAll(r105);     // Catch: Throwable -> L33
        this.f381765g = r111;     // Catch: Throwable -> L33
        goto L23
    L17:
        r105 = r110.toMap();     // Catch: Throwable -> L33
        goto L18
    L10:
        if (this.f381764f.isEmpty() == false) goto L12;
        this.f381764f = r103;     // Catch: Throwable -> L33
    L13:
        r104 = this.f381764f;     // Catch: Throwable -> L33
        goto L15
    L12:
        HashMap r112 = new HashMap(this.f381764f);     // Catch: Throwable -> L33
        r112.putAll(r103);     // Catch: Throwable -> L33
        this.f381764f = r112;     // Catch: Throwable -> L33
        goto L13
    L36:
        r103 = r100.toMap();     // Catch: Throwable -> L33
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> f(int r100, TemplateData r101, TemplateData r102, TemplateData r110, TemplateData r111) {
        boolean r103 = false;
        TemplateData[] r104 = {r102, r110, r111};
        Map r105 = null;
        int r112 = 0;
    L3:
        if (r112 >= 3) goto L14;
        TemplateData r106 = r104[r112];
        if (r106 != null) goto L7;
        Map r107 = null;
    L8:
        if (r107 == null) goto L13;
        if (r105 != null) goto L12;
        r105 = r107;
        goto L13
    L12:
        HashMap r108 = new HashMap(r105);
        r108.putAll(r107);
        r105 = r108;
    L13:
        r112 = r112 + 1;
        r105 = r105;
        goto L3
    L7:
        r107 = r106.toMap();
        goto L8
    L14:
        Object r113 = this.f381759a;
        monitor-enter(r113);
        g();     // Catch: Throwable -> L39
        this.f381763e++;     // Catch: Throwable -> L39
        if (r101 != null) goto L19;
        Map r109 = null;
    L20:
        if (r109 != null) goto L22;
    L25:
        if (r105 != null) goto L27;
    L30:
        this.f381761c = r100;     // Catch: Throwable -> L39
        this.f381766h = null;     // Catch: Throwable -> L39
        if (r100 < 0) goto L33;
        r103 = true;
    L33:
        this.f381762d = r103;     // Catch: Throwable -> L39
        if (r103 == false) goto L36;
        f381758i.put(Integer.valueOf(r100), new WeakReference(this));     // Catch: Throwable -> L39
    L36:
        Map<String, Object> r114 = this.f381765g;     // Catch: Throwable -> L39
        monitor-exit(r113);     // Catch: Throwable -> L39
        return r114;
    L27:
        if (this.f381765g != null) goto L29;
        this.f381765g = r105;     // Catch: Throwable -> L39
        goto L30
    L29:
        HashMap r115 = new HashMap(r105);     // Catch: Throwable -> L39
        r115.putAll(this.f381765g);     // Catch: Throwable -> L39
        this.f381765g = r115;     // Catch: Throwable -> L39
        goto L30
    L22:
        if (this.f381764f.isEmpty() == false) goto L24;
        this.f381764f = r109;     // Catch: Throwable -> L39
        goto L25
    L24:
        HashMap r116 = new HashMap(r109);     // Catch: Throwable -> L39
        r116.putAll(this.f381764f);     // Catch: Throwable -> L39
        this.f381764f = r116;     // Catch: Throwable -> L39
        goto L25
    L19:
        r109 = r101.toMap();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }
}
