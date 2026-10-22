package com.bytedance.bdp.appbase.chain;

import android.util.SparseArray;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.BdpTrace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f200696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f200697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f200698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f200699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<ArrayList<Chain<?>>> f200700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Integer> f200701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<f> f200702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f200703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m<?, ?> f200704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f200705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, Object> f200706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BdpTask.Builder f200707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i0 f200708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f200709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f200710p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<Integer, e0> f200711q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BdpTask.Builder f200712r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f0<?> f200713s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BdpTask.Builder f200714t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BdpTask f200715u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f200716v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f200717w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashSet<Object> f200718x;

    public final void b() {
        if (this.f200705k == false) goto L5;
        return;
    L5:
        ArrayList<Integer> r100 = this.f200701g;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (this.f200705k == false) goto L12;
        monitor-exit(r100);
        return;
    L12:
        this.f200705k = true;     // Catch: Throwable -> L27
        if ((true ^ this.f200701g.isEmpty()) == false) goto L15;
        ArrayList r101 = new ArrayList(this.f200701g);     // Catch: Throwable -> L27
    L16:
        this.f200701g.clear();     // Catch: Throwable -> L27
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r100);
        if (r101 == null) goto L23;
        Iterator r103 = r101.iterator();
    L21:
        if (r103.hasNext() == false) goto L23;
        BdpPool.cancelTask(((Number) r103.next()).intValue());
    L23:
        c();
        f0<?> r104 = this.f200713s;
        if (r104 == null) goto L33;
        r104.a();
        return;
    L33:
        return;
    L15:
        r101 = null;
        goto L16
    }

    public final void c() {
        SparseArray<f> r100 = this.f200702h;
        monitor-enter(r100);
        int r101 = this.f200702h.size();     // Catch: Throwable -> L10
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        this.f200702h.valueAt(r102).b();     // Catch: Throwable -> L10
        r102 = r102 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f200702h.clear();     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> d() {
        HashMap<String, Object> r100 = this.f200706l;
        if (r100 == null) goto L11;
        monitor-enter(r100);
        HashMap r101 = new HashMap(r100);     // Catch: Throwable -> L8
        monitor-exit(r100);
        return r101;
    L8:
        th = move-exception;
        throw th;
    L11:
        return null;
    }

    public final HashMap<String, Object> e() {
        HashMap<String, Object> r100 = this.f200706l;
        if (r100 != null) goto L16;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.f200706l != null) goto L8;
        this.f200706l = new HashMap();     // Catch: Throwable -> L13
    L8:
        r100 = this.f200706l;     // Catch: Throwable -> L13
        if (r100 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    L16:
        return r100;
    }

    public f() {
        AtomicInteger r100 = Chain.f200668k;
        this.f200695a = r100.incrementAndGet();
        this.f200697c = r100.incrementAndGet();
        this.f200700f = new SparseArray();
        this.f200701g = new ArrayList();
        this.f200702h = new SparseArray();
        this.f200708n = i0.b.f200743a;
        this.f200711q = new HashMap();
        if (BdpTrace.ENABLE == false) goto L5;
        int r101 = 2;
    L6:
        this.f200717w = r101;
        this.f200718x = new HashSet();
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public final <R> void a(Chain<R> r100) {
        Integer r101 = this.f200703i;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        ArrayList<Chain<?>> r103 = this.f200700f.get(r102);
        if (r103 != null) goto L9;
        r103 = new ArrayList();
        this.f200700f.put(r102, r103);
    L9:
        r103.add(r100);
        return;
    L5:
        r102 = this.f200697c;
        goto L6
    }

    public final void g(Map<String, ? extends Object> r100) {
        HashMap<String, Object> r101 = e();
        monitor-enter(r101);
        r101.putAll(r100);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final Object h(String r100) {
        HashMap<String, Object> r101 = this.f200706l;
        if (r101 == null) goto L11;
        monitor-enter(r101);
        Object r102 = r101.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);
        return r102;
    L8:
        th = move-exception;
        throw th;
    L11:
        return null;
    }

    public final void i(f r100) {
        SparseArray<f> r101 = this.f200702h;
        monitor-enter(r101);
        this.f200702h.delete(r100.f200697c);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void j(int r100) {
        ArrayList<Integer> r101 = this.f200701g;
        monitor-enter(r101);
        this.f200701g.remove(Integer.valueOf(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final <V> void f(String r100, V r101) {
        HashMap<String, Object> r102 = e();
        monitor-enter(r102);
        r102.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
