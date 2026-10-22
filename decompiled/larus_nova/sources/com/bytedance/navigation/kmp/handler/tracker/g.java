package com.bytedance.navigation.kmp.handler.tracker;

import com.bytedance.navigation.kmp.data.NavigationTraceLevel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f265910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<e37.j, b37.k, Unit> f265911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f265912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f265913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f265914e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e37.j f265915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b37.k f265916b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f265915a, r101.f265915a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f265916b, r101.f265916b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f265915a.hashCode() * 31) + this.f265916b.hashCode();
        }

        public final String toString() {
            return "PreparedReport(context=" + this.f265915a + ", event=" + this.f265916b + ")";
        }

        public final e37.j getContext() {
            return this.f265915a;
        }

        public b(e37.j r100, b37.k r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "event");
            this.f265915a = r100;
            this.f265916b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f265917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f265918b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f265917a, r101.f265917a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f265918b, r101.f265918b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f265917a.hashCode() * 31) + this.f265918b.hashCode();
        }

        public final String toString() {
            return "TraceSession(startSnapshot=" + this.f265917a + ", navigationId=" + this.f265918b + ")";
        }

        public c(k r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "startSnapshot");
            Intrinsics.checkNotNullParameter(r101, "navigationId");
            this.f265917a = r100;
            this.f265918b = r101;
        }
    }

    static {
    }

    public final l a() {
        Object r100 = this.f265912c;     // Catch: Throwable -> L15
        monitor-enter(r100);     // Catch: Throwable -> L15
        c r101 = this.f265913d;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        l r102 = new l(r101.f265917a.getContext(), r101.f265918b);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return r102;
    L9:
        r102 = null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        g("voice_control_begin", th);
        return null;
    }

    public final void c() {
        Object r100 = this.f265912c;     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        c r101 = this.f265913d;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        this.f265914e = r101;     // Catch: Throwable -> L10
    L7:
        this.f265913d = null;     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        g("clear_navigation", th);
    }

    public final long e() {
        return RangesKt.coerceAtLeast(this.f265910a.invoke().longValue(), 0);
    L5:
        th = move-exception;
        g("clock", th);
        return 0;
    }

    public g(int r100) {
        NavigationLifecycleTraceCoordinator$1 r101 = new NavigationLifecycleTraceCoordinator$1(i.f265919a);
        Function2<e37.j, b37.k, Unit> r102 = new d();
        Intrinsics.checkNotNullParameter(r101, "nowMs");
        Intrinsics.checkNotNullParameter(r102, "reportEvent");
        this.f265910a = r101;
        this.f265911b = r102;
        this.f265912c = new Object();
    }

    public final c f(String r100) {
        Object r101 = this.f265912c;     // Catch: Throwable -> L31
        monitor-enter(r101);     // Catch: Throwable -> L31
        if (r100 != null) goto L34;
    L25:
        c r102 = this.f265913d;     // Catch: Throwable -> L28
    L26:
        monitor-exit(r101);     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L38:
        return r102;
    L34:
        if ((!StringsKt.isBlank(r100)) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L25;
        r102 = this.f265913d;     // Catch: Throwable -> L28
        if (r102 != null) goto L15;
    L19:
        r102 = this.f265914e;     // Catch: Throwable -> L28
        if (r102 != null) goto L22;
    L24:
        r102 = null;
        goto L26
    L22:
        if (Intrinsics.areEqual(r102.f265918b, r100) == false) goto L24;
    L15:
        if (Intrinsics.areEqual(r102.f265918b, r100) == true) goto L18;
        r102 = null;
    L18:
        if (r102 != null) goto L26;
    L31:
        th = move-exception;
        g("find_navigation", th);
        return null;
    }

    public final void h(Function0<b> r100) {
        b r101 = r100.invoke();     // Catch: Throwable -> L9
        if (r101 == null) goto L16;
        this.f265911b.invoke(r101.getContext(), r101.f265916b);     // Catch: Throwable -> L6
    L17:
        return;
    L6:
        th = move-exception;
        g(r101.f265916b.f17270a, th);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        g("trace_dispatch", th);
    }

    public static void g(String r100, Throwable r101) {
        d37.i r102 = d37.i.f466749a;     // Catch: Throwable -> L5
        d37.i.e("Navigation Trace failed, event=" + r100, r101);     // Catch: Throwable -> L5
        return;
    }

    public final void b(k r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "navigationId");
        if (r100 != null) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L31;
        Object r102 = this.f265912c;     // Catch: Throwable -> L23
        monitor-enter(r102);     // Catch: Throwable -> L23
        c r103 = this.f265913d;     // Catch: Throwable -> L20
        if (r103 != null) goto L12;
    L17:
        r100.f265927d = r101;     // Catch: Throwable -> L20
        this.f265913d = new c(r100, r101);     // Catch: Throwable -> L20
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L12:
        if ((!Intrinsics.areEqual(r103.f265918b, r101)) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        this.f265914e = r103;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        g("bind_navigation", th);
        return;
    }

    public final void i(String r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        if (r101 == false) goto L5;
        int r103 = 2049;
    L6:
        int r104 = j.f265921a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        h(new f(this, r100, false, MapsKt.mapOf(new Pair[]{TuplesKt.to("navigation_id", r100), TuplesKt.to("reason", Integer.valueOf(r103)), TuplesKt.to("is_success", 0), TuplesKt.to("error_code", Integer.valueOf(r102))})));
        return;
    L5:
        r103 = 2048;
        goto L6
    }

    public final b d(k r100, String r101, boolean r102, Integer r103, String r110) {
        long r104 = RangesKt.coerceAtLeast(e() - r100.f265925b, 0);
        Map r105 = MapsKt.toMutableMap(r100.f265926c);
        r105.put("is_success", Integer.valueOf(r102 ? 1 : 0));
        if (r101 != null) goto L5;
    L10:
        if (r102 == true) goto L16;
        if (r103 == null) goto L13;
        r105.put("error_code", Integer.valueOf(r103.intValue()));
    L13:
        if (r110 != null) goto L15;
        r110 = "";
    L15:
        r105.put("error_msg", r110);
    L16:
        e37.j r106 = r100.getContext();
        if (r102 == false) goto L19;
        NavigationTraceLevel r107 = NavigationTraceLevel.INFO;
    L21:
        return new b(r106, new b37.k("lbs_client_navi_navigation_start", r107, Long.valueOf(r104), r105));
    L19:
        r107 = NavigationTraceLevel.ERROR;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r105.put("navigation_id", r101);
        goto L10
    }

    public final void j(final l r100, final String r110, final boolean r111, final boolean r112, final long r113) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if (r100 != null) goto L5;
        return;
    L5:
        h(new e(r100, r112, r113, r110, r111));
    }
}
