package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.api.RouteLazyConfigProxy;
import com.ss.android.ugc.route_monitor.impl.PresetStageEnum;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f454519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f454520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ihc.g> f454521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f454522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f454523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f454524f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f454525a;

        public a(Runnable r100) {
            this.f454525a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f454525a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Logger.f454747c.d(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f454526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f454527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f454528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f454529d;

        public b(i r100, Activity r101, boolean r102, Ref.ObjectRef r103) {
            this.f454526a = r100;
            this.f454527b = r101;
            this.f454528c = r102;
            this.f454529d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            Logger r100 = Logger.f454747c;
            Objects.toString(this.f454527b);
            r100.b();
            Objects.toString(this.f454527b.getIntent());
            r100.b();
            if (this.f454528c == false) goto L14;
            Handler r101 = com.ss.android.ugc.route_monitor.utils.r.f454781a;
            com.ss.android.ugc.route_monitor.utils.r.f454781a.removeCallbacks((Runnable) this.f454526a.f454520b.getValue());
            if (com.ss.android.ugc.route_monitor.utils.c.t() == true) goto L14;
            boolean r102 = com.ss.android.ugc.route_monitor.impl.launch_info.h.f454476a;
            Activity r103 = this.f454527b;
            Intent r104 = (Intent) this.f454529d.element;
            Objects.toString(r103);
            r100.b();
            if (com.ss.android.ugc.route_monitor.impl.launch_info.h.f454476a == true) goto L14;
            if (com.ss.android.ugc.route_monitor.utils.c.t() == true) goto L14;
            com.ss.android.ugc.route_monitor.impl.launch_info.f r105 = khc.a.a(r103, r104);
            if (Intrinsics.areEqual(r105.f454465a, ihc.p.f489954g) == true) goto L15;
            com.ss.android.ugc.route_monitor.impl.launch_info.h.c(r105);
        L15:
            i r106 = this.f454526a;
            Intent r107 = (Intent) this.f454529d.element;
            String r108 = r106.d(this.f454527b);
            Activity r109 = this.f454527b;
            boolean r110 = this.f454528c;
            boolean r111 = true;
            if ((!com.ss.android.ugc.route_monitor.impl.a.f454402a.isEmpty()) == false) goto L18;
        L25:
            u r112 = t.b(r108);
            if (r112 != null) goto L33;
            if (r110 == false) goto L48;
            if (r105 != null) goto L31;
            r105 = khc.a.a(r109, r107);
        L31:
            r108 = i.f(r105, false).f454585y;
        L48:
            if (r108.length() > 0) goto L51;
            r111 = false;
        L51:
            if (r111 == false) goto L53;
            r106.g(r108, r109);
        L53:
            i.b(this.f454526a, r108, false, this.f454527b, this.f454528c);
            return;
        L33:
            if (r112.f454586z.f454469e.length() != 0) goto L35;
            boolean r113 = true;
        L36:
            if (r113 == false) goto L48;
            if (r110 == false) goto L48;
            if (r105 != null) goto L41;
            r105 = khc.a.a(r109, r107);
        L41:
            r100.b();
            String r114 = r105.f454469e;
            com.ss.android.ugc.route_monitor.impl.launch_info.f r115 = r112.f454586z;
            if (r115.f454469e.length() != 0) goto L44;
            boolean r116 = true;
        L45:
            if (r116 == false) goto L48;
            r115.f454469e = r114;
            r115.f454475k.b(new com.ss.android.ugc.route_monitor.impl.launch_info.g(r115, r114));
            goto L48
        L44:
            r116 = false;
            goto L45
        L35:
            r113 = false;
            goto L36
        L18:
            if (r108.length() != 0) goto L20;
            boolean r117 = true;
        L22:
            if (r117 == false) goto L24;
            r108 = r106.f454519a;
            r106.f454519a = "";
            goto L25
        L24:
            r106.f454519a = "";
            goto L25
        L20:
            r117 = false;
        L14:
            r105 = null;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public i() {
        this.f454524f = false;
        f r100 = new f();
        com.ss.android.ugc.route_monitor.utils.c.f454750b.a(r100);
        g r101 = new g(this);
        com.ss.android.ugc.route_monitor.utils.c.f454751c.a(r101);
        h r102 = new h();
        com.ss.android.ugc.route_monitor.utils.c.f454752d.a(r102);
        this.f454519a = "";
        this.f454520b = LazyKt.lazy(new RouteInMonitor$setWarmBootRunnable$2(this));
        this.f454521c = new HashMap();
        this.f454522d = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("outeInMonitor"));
        this.f454523e = new ConcurrentHashMap();
    }

    public final void c(Runnable r100) {
        if (this.f454524f == false) goto L5;
        this.f454522d.execute(new a(r100));
        return;
    L5:
        r100.run();
    }

    public final String d(Activity r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (this.f454524f == false) goto L10;
        String r101 = this.f454523e.get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L21;
        return "";
    L21:
        return r101;
    L10:
        String r102 = com.ss.android.ugc.route_monitor.utils.u.e(r100.getIntent());
        if (r102.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L19;
        r101 = this.f454523e.get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L21;
        return "";
    L19:
        return r102;
    L13:
        r103 = false;
        goto L14
    }

    public static u f(com.ss.android.ugc.route_monitor.impl.launch_info.f r100, boolean r101) {
        Logger r102 = Logger.f454747c;
        Objects.toString(r100);
        r102.b();
        ConcurrentHashMap<String, u> r103 = t.f454558a;
        StringBuilder r104 = new StringBuilder("RouteInMonitor-");
        boolean r105 = false;
        r104.append(com.ss.android.ugc.route_monitor.utils.u.h(false));
        String r106 = r104.toString();
        ihc.r r107 = ihc.r.f489957b;
        Objects.toString(r100);
        r102.b();
        u r108 = new u(r106, r100);
        RouteMonitorManager.f454384g.b().getClass();
        r108.f454562b = 15000;
        String r109 = r108.f454585y;
        t.f454558a.put(r109, r108);
        com.ss.android.ugc.route_monitor.c.a().getClass();
        long r110 = r108.f454562b;
        com.ss.android.ugc.route_monitor.c.a().getClass();
        r102.b();
        com.ss.android.ugc.route_monitor.utils.r.a(new s(r109), r110);
        if (Intrinsics.areEqual(r100.f454465a, ihc.p.f489949b) == false) goto L5;
    L9:
        r108.f454561a = r105;
        return r108;
    L5:
        if (r100.f454467c == false) goto L7;
    L8:
        r105 = true;
        goto L9
    L7:
        if (Intrinsics.areEqual(r100.f454465a, ihc.p.f489953f) == true) goto L9;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.content.Intent] */
    public final void e(Activity r100, boolean r101) {
        if (r101 == false) goto L9;
        String r102 = com.ss.android.ugc.route_monitor.utils.u.e(r100.getIntent());
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        g(r102, r100);
        goto L9
    L6:
        r103 = false;
    L9:
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = null;
        if (r101 == false) goto L12;
        r104.element = new Intent(r100.getIntent());
    L12:
        c(new b(this, r100, r101, r104));
    }

    public final void g(String r100, Activity r101) {
        this.f454523e.put(Integer.valueOf(r101.hashCode()), r100);
        if (this.f454524f == true) goto L6;
        com.ss.android.ugc.route_monitor.utils.u.i(r100, r101.getIntent());
        return;
    }

    public static final void a(i r100, Application r101, com.ss.android.ugc.route_monitor.impl.launch_info.f r102) {
        r100.getClass();
        com.ss.android.ugc.route_monitor.impl.launch_info.h.c(r102);
        if (r102.f454473i == ComponentType.ACTIVITY) goto L8;
        if (com.ss.android.ugc.route_monitor.utils.u.f() == true) goto L8;
        Handler r103 = com.ss.android.ugc.route_monitor.utils.r.f454781a;
        com.ss.android.ugc.route_monitor.utils.r.a((Runnable) r100.f454520b.getValue(), KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
        Logger.f454747c.b();
    L8:
        if (RouteLazyConfigProxy.f454387b.isLazy() == true) goto L10;
    L11:
        boolean r104 = true;
        u r105 = f(r102, true);
        r100.f454519a = r105.f454585y;
        LinkedList<ihc.o> r106 = r105.f454568h;
        monitor-enter(r106);
        boolean r107 = r105.f454568h.isEmpty();     // Catch: Throwable -> L28
        monitor-exit(r106);
        if (r107 == false) goto L26;
        RouteMonitorManager.f454384g.b().getClass();
        Long r108 = 0L;
        if (r108.longValue() != 0) goto L21;
        r104 = false;
    L21:
        if (r104 == true) goto L24;
        r108 = null;
    L24:
        if (r108 == null) goto L26;
        long r109 = r108.longValue();
        com.ss.android.ugc.route_monitor.impl.f r110 = new com.ss.android.ugc.route_monitor.impl.f(r105.f(), r101.getClass().getName(), PresetStageEnum.APPLICATION_ATTACH_BASE_CONTEXT_START);
        r110.f454406c = r109;
        r105.f454563c = r109;
        r105.a(r110);
    L26:
        r105.a(new com.ss.android.ugc.route_monitor.impl.f(r105.f(), r101.getClass().getName(), PresetStageEnum.APPLICATION_ON_CREATE_START));
        return;
    L28:
        th = move-exception;
        throw th;
    L10:
        if (Intrinsics.areEqual(r102.f454465a, ihc.p.f489949b) == false) goto L11;
    }

    public static final void b(i r100, String r101, boolean r102, Activity r103, boolean r110) {
        r100.getClass();
        Logger r104 = Logger.f454747c;
        Objects.toString(r103);
        r104.b();
        boolean r105 = false;
        if (r101.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L57;
        u r107 = t.b(r101);
        if (r107 != null) goto L11;
        return;
    L11:
        if (r107.f454574n == true) goto L41;
        String r108 = r103.getClass().getName();
        RouteMonitorManager r109 = RouteMonitorManager.f454384g;
        r109.getClass();
        String r111 = r103.getClass().getName();
        if (r109.b().b().contains(r111) == false) goto L21;
        if (Intrinsics.areEqual(r107.f454586z.f454465a, ihc.p.f489950c) == false) goto L21;
        if (r110 == false) goto L19;
        com.ss.android.ugc.route_monitor.impl.f r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.PUSH_ACTIVITY_ON_CREATE_START);
    L31:
        if (r112 != null) goto L33;
    L39:
        r103.toString();
        r104.b();
        goto L41
    L33:
        if (r107.f454574n == true) goto L38;
        u.b r113 = new u.b(r103, WidgetCostModule.TYPE_ON_CREATE);
        if (r107.f454573m.contains(r113) == true) goto L38;
        r107.f454573m.add(r113);
    L38:
        Boolean r114 = Boolean.valueOf(r102);
        ((ConcurrentHashMap) r112.f454411h).put("is_on_new_intent", r114);
        r107.a(r112);
        goto L39
    L19:
        r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.PUSH_ACTIVITY_ON_CREATE_END);
    L21:
        if (r109.c(r103.getClass().getName()) == false) goto L26;
        if (r110 == false) goto L24;
        r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.DEEPLINK_ACTIVITY_ON_CREATE_START);
        goto L31
    L24:
        r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.DEEPLINK_ACTIVITY_ON_CREATE_END);
        goto L31
    L26:
        if (r107.b(r103) == false) goto L30;
        if (r110 == false) goto L29;
        r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.TRANSITION_PAGE_ON_CREATE_START);
        goto L31
    L29:
        r112 = new com.ss.android.ugc.route_monitor.impl.f(r107.f(), r108, PresetStageEnum.TRANSITION_PAGE_ON_CREATE_END);
        goto L31
    L30:
        r112 = null;
    L41:
        if (r107.i() == false) goto L55;
        String r115 = r103.getClass().getName();
        HashMap<String, ihc.g> r116 = r100.f454521c;
        monitor-enter(r116);
        ihc.g r117 = r100.f454521c.get(r103.getClass().getName());     // Catch: Throwable -> L49
        if (r117 == null) goto L47;
        r105 = r117.a();     // Catch: Throwable -> L49
    L47:
        monitor-exit(r116);
        Map<String, Boolean> r118 = r107.f454577q;
        ConcurrentHashMap r119 = (ConcurrentHashMap) r118;
        r119.put(r115, Boolean.valueOf(r105));
        return;
    L49:
        th = move-exception;
        throw th;
    L55:
        return;
    L57:
        return;
    L5:
        r106 = false;
        goto L6
    }
}
