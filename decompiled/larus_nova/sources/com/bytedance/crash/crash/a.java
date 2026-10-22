package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.i;
import com.bytedance.crash.dumper.n;
import com.bytedance.crash.dumper.o;
import com.bytedance.crash.dumper.q;
import com.bytedance.crash.h;
import com.bytedance.crash.monitor.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f203098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f203099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CrashType f203100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f203101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f203102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f203103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f203104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f203105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f203106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f203107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f203108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f203109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f203110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f203111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f203112o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f203113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f203114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f203115r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f203116s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f203117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f203118u;

    public a(PolarisFileWrapper r100) {
        this.f203102e = new AtomicBoolean(false);
        this.f203103f = new AtomicBoolean(false);
        this.f203104g = new AtomicBoolean(false);
        this.f203105h = new AtomicBoolean(false);
        this.f203106i = new AtomicBoolean(false);
        this.f203107j = new AtomicBoolean(false);
        this.f203108k = new AtomicBoolean(false);
        this.f203109l = new AtomicBoolean(false);
        this.f203110m = new AtomicBoolean(false);
        this.f203111n = new AtomicBoolean(false);
        this.f203112o = new AtomicBoolean(false);
        this.f203113p = new AtomicBoolean(false);
        this.f203114q = new AtomicBoolean(false);
        this.f203115r = new AtomicBoolean(false);
        this.f203116s = new AtomicBoolean(false);
        this.f203117t = new AtomicBoolean(false);
        this.f203118u = new AtomicBoolean(false);
        this.f203098a = r100;
        this.f203099b = 0;
        this.f203100c = CrashType.UNKNOWN;
        this.f203101d = 0;
    }

    public final void a(long r110, boolean r111, boolean r210, boolean r211, int r212) {
        CrashType r100 = CrashType.NATIVE;
        if (r110 == 0) goto L9;
        long r101 = this.f203099b;
        if (r101 != 0) goto L7;
    L8:
        this.f203099b = r110;
        this.f203100c = r100;
        goto L9
    L7:
        if (r101 > r110) goto L8;
    L9:
        this.f203101d = r212;
    L14:
        th = move-exception;
        ch4.c.a("dumpCommonParams", th);
    L17:
        if (this.f203104g.compareAndSet(false, true) == false) goto L20;
        LocaleInfo.dump(this.f203098a);
    L20:
        if (this.f203105h.compareAndSet(false, true) == false) goto L23;
        com.bytedance.crash.dumper.g.a(this.f203098a);
        com.bytedance.crash.dumper.g.b(this.f203098a);
    L23:
        if (this.f203106i.compareAndSet(false, true) == false) goto L26;
        MemoryInfo.a(this.f203098a);
    L26:
        if (this.f203107j.compareAndSet(false, true) == false) goto L28;
        Scraps.dump(this.f203098a);
    L28:
        if (r211 == false) goto L35;
        if (this.f203108k.compareAndSet(false, true) == false) goto L35;
        ih4.c.f489850c.c(this.f203098a);     // Catch: Throwable -> L33
    L35:
        if (this.f203109l.compareAndSet(false, true) == false) goto L38;
        o.a(this.f203098a);
    L38:
        if (this.f203110m.compareAndSet(false, true) == false) goto L40;
        bi4.a.b(this.f203098a);
    L40:
        if (r111 == false) goto L66;
        if (this.f203111n.compareAndSet(false, true) == false) goto L66;
        File r102 = this.f203098a;
        Map<Thread, StackTraceElement[]> r103 = Thread.getAllStackTraces();
        if (r103.isEmpty() == true) goto L66;
        dh4.f r104 = new dh4.f(r102.getAbsolutePath() + "/all_thread_stacks.json");
        r104.j();
        r104.h("all_thread_stacks");
        r104.j();
        r104.h("thread_all_count");
        r104.b(r103.size());
        r104.i();
        r104.h("thread_stacks");
        r104.a('[');
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r105 = r103.entrySet().iterator();
        boolean r106 = true;
    L48:
        if (r105.hasNext() == false) goto L64;
        Map.Entry<Thread, StackTraceElement[]> r107 = r105.next();
        StackTraceElement[] r108 = r107.getValue();
        if (r106 == false) goto L52;
        r106 = false;
    L53:
        r104.j();
        Thread r109 = r107.getKey();
        r104.h("thread_name");
        r104.f468608a.a(Typography.quote);
        r104.d(r109.getName());
        r104.f468608a.a('(');
        r104.f468608a.c(r109.getId());
        r104.f468608a.a(')');
        r104.a(Typography.quote);
        r104.i();
        r104.h("thread_stack");
        r104.a('[');
        if (r108.length <= 0) goto L62;
        int r112 = 0;
    L57:
        if (r112 >= r108.length) goto L63;
        StackTraceElement r113 = r108[r112];
        r104.f468608a.a(Typography.quote);
        r104.d(r113.getClassName());
        r104.f468608a.a('.');
        r104.d(r113.getMethodName());
        r104.f468608a.a('(');
        r104.d(r113.getFileName());
        r104.f468608a.a(':');
        r104.f468608a.b(r113.getLineNumber());
        r104.f468608a.a(')');
        r104.a(Typography.quote);
        if (r112 == (r108.length - 1)) goto L61;
        r104.i();
    L61:
        r112 = r112 + 1;
    L63:
        r104.a(']');
        r104.k();
        goto L48
    L62:
        r104.d("\"(Native Method)\"");
        goto L63
    L52:
        r104.i();
        goto L53
    L64:
        r104.a(']');
        r104.k();
        r104.k();
        r104.g();
    L66:
        if (this.f203112o.compareAndSet(false, true) == false) goto L68;
        i.b(this.f203098a);
    L68:
        if (r210 == true) goto L70;
    L72:
        com.bytedance.crash.monitor.a r114 = j.f203315a;
        if (r114 == null) goto L81;
        yh4.a r115 = r114.f203300l;
        if (r115 == null) goto L81;
        if (this.f203118u.compareAndSet(false, true) == false) goto L81;
        ((com.bytedance.crash.dumper.j) r115).a(this.f203098a);
    L81:
        if (this.f203115r.compareAndSet(false, true) == false) goto L84;
        com.bytedance.crash.dumper.e.b(this.f203098a, this.f203100c, this.f203101d);
    L84:
        if (this.f203116s.compareAndSet(false, true) == false) goto L87;
        com.bytedance.crash.dumper.f.a(this.f203098a, this.f203100c);
    L87:
        if (this.f203117t.compareAndSet(false, true) == false) goto L90;
        h.a();
    L90:
        if (this.f203113p.compareAndSet(false, true) == false) goto L102;
        n.a(this.f203098a);
        return;
    L102:
        return;
    L70:
        if (this.f203114q.compareAndSet(false, true) == false) goto L72;
        q.a(this.f203098a);
        goto L72
    L11:
        if (this.f203103f.compareAndSet(false, true) == false) goto L17;
        com.bytedance.crash.dumper.d.a(this.f203098a);     // Catch: Throwable -> L14
        goto L17
    }
}
