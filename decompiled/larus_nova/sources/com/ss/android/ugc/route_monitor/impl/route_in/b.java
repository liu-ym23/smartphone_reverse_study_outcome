package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.os.SystemClock;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<d> f454502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f454503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f454505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f454506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f454507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f454508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<a> f454509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f454510i;

    public final long b() {
        monitor-enter(this);
        Iterator<T> r100 = this.f454502a.iterator();     // Catch: Throwable -> L14
        long r101 = 0;
    L5:
        if (r100.hasNext() == false) goto L11;
        d r102 = (d) r100.next();     // Catch: Throwable -> L14
        long r103 = r102.f454515b;     // Catch: Throwable -> L14
        if (r103 == 0) goto L5;
        long r104 = r102.f454514a;     // Catch: Throwable -> L14
        if (r104 == 0) goto L5;
        r101 = r101 + (r104 - r103);     // Catch: Throwable -> L14
        goto L5
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    public final long d() {
        monitor-enter(this);
        long r100 = this.f454507f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final long e() {
        monitor-enter(this);
        long r100 = this.f454508g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final int f() {
        monitor-enter(this);
        HashSet r100 = new HashSet();     // Catch: Throwable -> L10
        Iterator<T> r101 = this.f454509h.iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L7;
        r100.add(((a) r101.next()).f454497c);     // Catch: Throwable -> L10
        goto L5
    L7:
        int r102 = r100.size();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public final long g() {
        monitor-enter(this);
        long r100 = SystemClock.uptimeMillis() - this.f454504c;
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean h() {
        monitor-enter(this);
        boolean r100 = true;
        if ((!this.f454502a.isEmpty()) == false) goto L12;
        d r101 = (d) CollectionsKt.lastOrNull(this.f454502a);     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
    L9:
        if (this.f454503b == false) goto L12;
    L13:
        monitor-exit(this);
        return r100;
    L8:
        if (r101.f454514a == 0) goto L13;
    L12:
        r100 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean i() {
        monitor-enter(this);
        boolean r100 = this.f454505d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean j() {
        monitor-enter(this);
        boolean r100 = this.f454503b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final String l() {
        monitor-enter(this);
        String r100 = "{\"bg_ts_list\":" + this.f454502a + ", \"bg_dur\":" + b() + ", \"enter_bg_cnt\":" + this.f454502a.size() + ", \"mock_enter_fg\":" + this.f454503b + ",\"initial_in_fg\":" + this.f454505d + ",\"first_switch_dur\":" + this.f454507f + ",\"last_switch_dur\":" + this.f454508g + ",\"total_cost_time\":" + g() + ", \"launch_act_size\":" + f() + " ,\"launch_act_stage_list\":" + this.f454509h + '}';     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f454502a = new ArrayList();
        this.f454504c = SystemClock.uptimeMillis();
        boolean r100 = com.ss.android.ugc.route_monitor.utils.c.t();
        this.f454505d = r100;
        this.f454506e = r100;
        this.f454509h = new ArrayList();
    }

    public final String toString() {
        return l();
    }

    public final void c(boolean r100) {
        monitor-enter(this);
        if (r100 == false) goto L15;
    L6:
        k(r100);     // Catch: Throwable -> L12
        d r101 = (d) CollectionsKt.lastOrNull(this.f454502a);     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        r101.f454514a = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
    L9:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        this.f454506e = true;     // Catch: Throwable -> L12
        goto L6
    }

    public final void k(boolean r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f454507f != 0) goto L6;
        this.f454507f = SystemClock.uptimeMillis() - this.f454504c;     // Catch: Throwable -> L11
    L6:
        if (r100 == true) goto L8;
        this.f454508g = SystemClock.uptimeMillis() - this.f454504c;     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void a(Activity r110, String r111) {
        monitor-enter(this);
        long r112 = SystemClock.uptimeMillis() - this.f454504c;     // Catch: Throwable -> L21
        RouteMonitorManager r100 = RouteMonitorManager.f454384g;     // Catch: Throwable -> L21
        r100.getClass();     // Catch: Throwable -> L21
        i r101 = (i) RouteMonitorManager.f454382e.getValue(r100, RouteMonitorManager.f454378a[2]);     // Catch: Throwable -> L21
        if (r101 == null) goto L6;
        String r102 = r101.d(r110);     // Catch: Throwable -> L21
    L7:
        u r103 = t.b(r102);     // Catch: Throwable -> L21
        String r104 = r110.getClass().getSimpleName();     // Catch: Throwable -> L21
        if (r103 == null) goto L12;
        String r113 = r103.f454585y;     // Catch: Throwable -> L21
        if (r113 == null) goto L12;
    L13:
        long r105 = this.f454510i;     // Catch: Throwable -> L21
        this.f454510i = 1 + r105;     // Catch: Throwable -> L21
        a r106 = new a(r104, r111, r113, r105, r112);     // Catch: Throwable -> L21
        if (this.f454509h.size() <= 0) goto L18;
        a r114 = (a) CollectionsKt.lastOrNull(this.f454509h);     // Catch: Throwable -> L21
        if (r114 == null) goto L18;
        r114.f454496b = r106.f454495a - r114.f454495a;     // Catch: Throwable -> L21
    L18:
        this.f454509h.add(r106);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L12:
        r113 = "";
        goto L13
    L6:
        r102 = com.ss.android.ugc.route_monitor.utils.u.e(r110.getIntent());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
