package com.bytedance.android.livesdk.livecommerce.opt;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.n;
import com.bytedance.android.ec.monitor.duration.h;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.g1;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ECToolbarHandler;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLivePerformanceMonitor {
    public static final b x = null;
    public static final a y = null;
    public String a;
    public String b;
    public Long c;
    public boolean d;
    public String e;
    public String f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public boolean q;
    public String r;
    public String s;
    public Long t;
    public Long u;
    public final Map<String, String> v;
    public final Map<String, g1> w;

    public static final class a implements n {
        public a() {
        }

        public final Long b(Map<String, Long> r2) {
            Intrinsics.checkNotNullParameter(r2, "durationOfMetrics");
            return null;
        }

        public final void a(Map<String, Long> r4) {
            Intrinsics.checkNotNullParameter(r4, "durationOfMetrics");
            Lazy r0 = ECToolbarHandler.a;
            boolean r1 = ECToolbarHandler.c;
            ECToolbarHandler.c = false;
            if (r1 == false) goto L6;
            r4.put(MetricNames.DURATION.getMetricNames(), 1L);
            return;
        }
    }

    public static final class b implements n {
        public b() {
        }

        public final Long b(Map<String, Long> r2) {
            Intrinsics.checkNotNullParameter(r2, "durationOfMetrics");
            return null;
        }

        public final void a(Map<String, Long> r2) {
            Intrinsics.checkNotNullParameter(r2, "durationOfMetrics");
            Intrinsics.checkNotNullParameter(r2, "durationOfMetrics");
        }
    }

    public static final class c {
        @JvmStatic
        public static ECLivePerformanceMonitor a(String r1, String r2) {
            int r0 = RoomContextController.h;
            ECContext r3 = RoomContextController.a.b(r1, r2).r();
            if (r3 == null) goto L7;
            i<ECLivePerformanceMonitor> r4 = r3.getEcLivePerformanceMonitor();
            if (r4 == null) goto L7;
            return (ECLivePerformanceMonitor) r4.getValue();
        L7:
            return null;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ECLivePerformanceMonitor a;

        public d(ECLivePerformanceMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.p(2, ((Boolean) r3).booleanValue());
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map r0 = com.bytedance.android.ec.core.monitor.c.a;     // Catch: Throwable -> L4
            com.bytedance.android.ec.core.monitor.c.d(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        x = new b();
        y = new a();
    }

    public final void e() {
        int r0 = ECSdk.a;
        ECSdk.b(IAdapterService.class, new ECLivePerformanceMonitor$initBasicInfo$1(this));
        int r1 = RoomContextController.h;
        ECContext r2 = RoomContextController.a.b(this.a, this.b).r();
        if (r2 == null) goto L10;
        m<Boolean> r3 = r2.isBottomCardVisible();
        if (r3 == null) goto L11;
        Observable r4 = r3.a();
        if (r4 == null) goto L12;
        r4.subscribe(new d(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void g() {
        String r0 = this.p;
        if (r0 == null) goto L6;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.POP_CARD_ANIM_DELAY_DURATION);
        com.bytedance.android.ec.core.monitor.c.h(r0, MetricNames.POP_CARD_ANIM_DURATION, null);
        return;
    }

    public final void h() {
        v("ec_perf_duration_shopping_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        v("ec_perf_duration_intro_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        String r0 = this.p;
        if (r0 == null) goto L6;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.ENTER_ROOM_DURATION);
        return;
    }

    public final void j() {
        final String r0 = this.o;
        if (r0 == null) goto L6;
        v("ec_perf_duration_live_shopping_bag", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end", "real_render_start", "render_start"}), Long.valueOf(SystemClock.elapsedRealtime()));
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.ENTER_ROOM_DURATION);
        com.bytedance.android.ec.core.monitor.c.h(r0, MetricNames.RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r0, MetricNames.LIVE_CART_REAL_RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r0, MetricNames.LIVE_CART_NEXT_FRAME_RENDER_DURATION, null);
        int r2 = ECSdk.a;
        ECSdk.b(IAdapterService.class, new ECLivePerformanceMonitor$onCartEnterRoom$$inlined$let$lambda$1(r0, this));
        return;
    }

    public final void k() {
        v("ec_perf_duration_live_shopping_bag", CollectionsKt.listOf(new String[]{"real_end", "real_render_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        String r0 = this.o;
        if (r0 == null) goto L5;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.LIVE_CART_REAL_SHOW_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.LIVE_CART_REAL_RENDER_DURATION);
    L5:
        Function0<Unit> r2 = new ECLivePerformanceMonitor$recordNextFrameDuration$1(this);
        Choreographer.getInstance().postFrameCallback(new com.bytedance.android.livesdk.livecommerce.opt.a(r2));
    }

    public ECLivePerformanceMonitor() {
        this.e = "";
        this.f = "";
        this.v = new LinkedHashMap();
        this.w = new LinkedHashMap();
    }

    public final void i() {
        u("ec_perf_duration_shopping_card", "request_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r0 = this.p;
        if (r0 == null) goto L6;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.POP_API_DURATION);
        return;
    }

    public final void l() {
        u("ec_perf_duration_intro_card", "request_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r0 = this.p;
        if (r0 == null) goto L6;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.POP_API_DURATION);
        return;
    }

    public final void B(boolean r6) {
        String r0 = "1";
        if (r6 == false) goto L5;
        String r2 = "1";
    L6:
        b("ec_perf_duration_shopping_card", "is_preload_ready", r2);
        String r3 = this.p;
        if (r3 == null) goto L14;
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        if (r6 == true) goto L12;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L12:
        com.bytedance.android.ec.core.monitor.c.e(r3, "is_preload_ready", r0);
        return;
    L14:
        return;
    L5:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void C(boolean r6) {
        String r0 = "1";
        if (r6 == false) goto L5;
        String r2 = "1";
    L6:
        b("ec_perf_duration_intro_card", "is_preload_ready", r2);
        String r3 = this.p;
        if (r3 == null) goto L14;
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        if (r6 == true) goto L12;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L12:
        com.bytedance.android.ec.core.monitor.c.e(r3, "is_preload_ready", r0);
        return;
    L14:
        return;
    L5:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void n(boolean r4) {
        u("ec_perf_duration_promotion_list", "request_start", null);
        if (r4 == false) goto L5;
        String r5 = "1";
    L6:
        b("ec_perf_duration_promotion_list", "is_request_on_show_fragment", r5);
        String r6 = this.r;
        if (r6 == null) goto L10;
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.LIVE_PROMOTIONS_API_DURATION, null);
        return;
    L10:
        return;
    L5:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void o(String r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        String r1 = this.s;
        if (r1 == null) goto L6;
        Map r2 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r1, MetricNames.DURATION);
        com.bytedance.android.ec.core.monitor.c.e(r1, "scene", r4);
        com.bytedance.android.ec.core.monitor.c.d(r1);
        return;
    }

    public final void q(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        String r1 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.DURATION_LIVE_EC_ROOM_ENTER_AUTO_POP, null);
        this.s = r1;
        com.bytedance.android.ec.core.monitor.c.e(r1, "room_id", r5);
        String r2 = this.n;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        com.bytedance.android.ec.core.monitor.c.e(r1, "enter_room_type", r2);
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.ENTER_ROOM_DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.e(r1, "room_id", r5);
        com.bytedance.android.ec.core.monitor.c.e(r1, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r1, "enter_method", l0.e());
    }

    public final void z(int r4) {
        if (r4 == 2) goto L5;
        String r5 = null;
    L6:
        w(this, "ec_perf_duration_intro_card", null, r5, 2);
        String r6 = this.p;
        if (r6 == null) goto L9;
        UtilityKotlinExtentionsKt.b.post(new e(r6));
    L9:
        this.p = null;
        return;
    L5:
        r5 = "ec_perf_duration_intro_related_card";
        goto L6
    }

    public final void c(Long r5, Long r6) {
        if (r5 == null) goto L9;
        r5.longValue();
        if (r6 == null) goto L10;
        r6.longValue();
        u("ec_perf_duration_shopping_card", "request_start", r5);
        u("ec_perf_duration_shopping_card", "request_end", r6);
        String r0 = this.p;
        if (r0 == null) goto L11;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.a(r0, MetricNames.POP_API_DURATION, r6.longValue() - r5.longValue());
        return;
    L11:
        return;
    L10:
        return;
    }

    public final String d(String r2, boolean r3) {
        if (r3 == true) goto L9;
        Map<String, String> r4 = this.v;
        String r0 = (String) ((LinkedHashMap) r4).get(r2);
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.monitor.duration.i.a.create(r2);
    L7:
        r4.put(r2, r0);
        return (String) ((LinkedHashMap) this.v).get(r2);
    L9:
        return (String) ((LinkedHashMap) this.v).get(r2);
    }

    public final void f(Long r5, Long r6) {
        if (r5 == null) goto L9;
        r5.longValue();
        if (r6 == null) goto L10;
        r6.longValue();
        u("ec_perf_duration_intro_card", "request_start", r5);
        u("ec_perf_duration_intro_card", "request_end", r6);
        String r0 = this.p;
        if (r0 == null) goto L11;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.a(r0, MetricNames.POP_API_DURATION, r6.longValue() - r5.longValue());
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void p(int r4, boolean r5) {
        if (r4 != 0) goto L4;
        this.h = r5;
    L20:
        LinkedHashMap r6 = new LinkedHashMap();
        String r0 = "1";
        if (this.h == false) goto L23;
        Object r7 = "1";
    L24:
        r6.put("is_shopping", r7);
        if (this.i == false) goto L27;
        Object r8 = "1";
    L28:
        r6.put("shopping_list_show", r8);
        if (this.j == false) goto L31;
        Object r9 = "1";
    L32:
        r6.put("shopping_card_show", r9);
        if (this.m == false) goto L35;
        Object r10 = "1";
    L36:
        r6.put("shopping_detail_show", r10);
        if (this.l == false) goto L39;
        Object r11 = "1";
    L40:
        r6.put("shopping_preload_view", r11);
        if (this.k == true) goto L44;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L44:
        r6.put("shopping_preload_data", r0);
        if (this.h == false) goto L49;
        int r12 = ECSdk.a;
        IAdapterService r13 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r13 == null) goto L53;
        r13.getLivePerformanceManager();
        return;
    L53:
        return;
    L49:
        int r14 = ECSdk.a;
        IAdapterService r15 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r15 == null) goto L55;
        r15.getLivePerformanceManager();
        return;
    L55:
        return;
    L39:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L40
    L35:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L36
    L31:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L32
    L27:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L28
    L23:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L24
    L4:
        if (r4 != 1) goto L6;
        this.i = r5;
        goto L20
    L6:
        if (r4 != 2) goto L8;
        this.j = r5;
        goto L20
    L8:
        if (r4 != 3) goto L10;
        this.m = r5;
        goto L20
    L10:
        if (r4 != 4) goto L12;
        this.k = r5;
        goto L20
    L12:
        if (r4 != 5) goto L20;
        this.l = r5;
        goto L20
    }

    public final void t(boolean r5, int r6) {
        String r0 = this.n;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        b("ec_perf_duration_shopping_related_card", "enter_room_type", r0);
        b("ec_perf_duration_shopping_related_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_shopping_related_card", "enter_method", l0.e());
        b("ec_perf_duration_shopping_related_card", "instant_type", String.valueOf(r6));
        if (r5 == false) goto L8;
        String r7 = "message";
    L9:
        b("ec_perf_duration_shopping_related_card", "scene", r7);
        if (r5 == false) goto L12;
        u("ec_perf_duration_shopping_related_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L12:
        v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.c);
        return;
    L8:
        r7 = "enter_room";
        goto L9
    }

    public static /* synthetic */ void y(ECLivePerformanceMonitor r6, Boolean r7, gf.a r8) {
        r6.x(true, r7, r8, null, null);
    }

    public final void b(String r2, String r3, String r4) {
        String r5 = d(r2, false);
        if (r5 == null) goto L9;
        if (r4 == null) goto L10;
        com.bytedance.android.ec.monitor.duration.d r6 = com.bytedance.android.ec.monitor.duration.i.a.get(r5);
        if (r6 == null) goto L11;
        r6.b(r3, r4);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void m(boolean r5, boolean r6, int r7) {
        if (r6 == false) goto L5;
        u("ec_perf_duration_intro_card", "render_end", Long.valueOf(SystemClock.elapsedRealtime()));
    L7:
        if (r5 == true) goto L9;
    L13:
        String r8 = this.p;
        if (r8 == null) goto L19;
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r8, MetricNames.POP_CARD_ANIM_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r8, MetricNames.RENDER_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r8, MetricNames.DURATION);
        if (r5 == false) goto L20;
        com.bytedance.android.ec.core.monitor.c.d(r8);
        this.p = null;
        return;
    L20:
        return;
    L19:
        return;
    L9:
        if (r7 == 2) goto L11;
        String r9 = null;
    L12:
        w(this, "ec_perf_duration_intro_card", null, r9, 2);
        goto L13
    L11:
        r9 = "ec_perf_duration_intro_related_card";
        goto L12
    L5:
        v("ec_perf_duration_intro_card", CollectionsKt.listOf("render_end"), Long.valueOf(SystemClock.elapsedRealtime()));
        goto L7
    }

    public final void r(boolean r17, String r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "roomId");
        String r3 = this.p;
        if (r3 == null) goto L5;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.a).remove(r3);
        this.p = null;
    L5:
        this.q = r17;
        b("ec_perf_duration_shopping_card", "room_id", r18);
        String r2 = this.n;
        String r5 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        b("ec_perf_duration_shopping_card", "enter_room_type", r2);
        b("ec_perf_duration_shopping_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_shopping_card", "enter_method", l0.e());
        b("ec_perf_duration_shopping_card", "instant_type", String.valueOf(r19));
        String r4 = "message";
        if (r17 == false) goto L11;
        String r11 = "message";
    L12:
        b("ec_perf_duration_shopping_card", "scene", r11);
        if (r17 == false) goto L15;
        u("ec_perf_duration_shopping_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
    L16:
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        String r7 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_LIVE_SHOP_CARD_SHOW_DURATION, x);
        this.p = r7;
        String r8 = this.n;
        if (r8 == null) goto L20;
        r5 = r8;
    L20:
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_room_type", r5);
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.e(r7, "instant_type", String.valueOf(r19));
        if (r17 == true) goto L24;
        r4 = "enter_room";
    L24:
        com.bytedance.android.ec.core.monitor.c.e(r7, "scene", r4);
        if (r17 == false) goto L27;
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.DURATION, null);
        return;
    L27:
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.ENTER_ROOM_DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.POP_CARD_VISIBLE_DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION, this.c);
        return;
    L15:
        v("ec_perf_duration_shopping_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.c);
        goto L16
    L11:
        r11 = "enter_room";
        goto L12
    }

    public final void s(boolean r17, String r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "roomId");
        String r3 = this.p;
        if (r3 == null) goto L5;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.a).remove(r3);
        this.p = null;
    L5:
        this.q = r17;
        b("ec_perf_duration_intro_card", "room_id", r18);
        String r2 = this.n;
        String r5 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        b("ec_perf_duration_intro_card", "enter_room_type", r2);
        b("ec_perf_duration_intro_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_intro_card", "enter_method", l0.e());
        b("ec_perf_duration_intro_card", "instant_type", String.valueOf(r19));
        String r4 = "message";
        if (r17 == false) goto L11;
        String r11 = "message";
    L12:
        b("ec_perf_duration_intro_card", "scene", r11);
        if (r17 == false) goto L15;
        u("ec_perf_duration_intro_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
    L16:
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        String r7 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_LIVE_INTRO_CARD_SHOW_DURATION, x);
        this.p = r7;
        String r8 = this.n;
        if (r8 == null) goto L20;
        r5 = r8;
    L20:
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_room_type", r5);
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r7, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.e(r7, "instant_type", String.valueOf(r19));
        if (r17 == true) goto L24;
        r4 = "enter_room";
    L24:
        com.bytedance.android.ec.core.monitor.c.e(r7, "scene", r4);
        if (r17 == false) goto L27;
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.DURATION, null);
        return;
    L27:
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.ENTER_ROOM_DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.POP_CARD_VISIBLE_DURATION, this.c);
        com.bytedance.android.ec.core.monitor.c.h(r7, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION, this.c);
        return;
    L15:
        v("ec_perf_duration_intro_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.c);
        goto L16
    L11:
        r11 = "enter_room";
        goto L12
    }

    public final void u(String r3, String r4, Long r5) {
        String r6 = d(r3, false);
        if (r6 == null) goto L12;
        if (r5 == null) goto L8;
        com.bytedance.android.ec.monitor.duration.d r7 = com.bytedance.android.ec.monitor.duration.i.a.get(r6);
        if (r7 == null) goto L13;
        r7.d(r4, r5.longValue());
        return;
    L13:
        return;
    L8:
        com.bytedance.android.ec.monitor.duration.d r8 = com.bytedance.android.ec.monitor.duration.i.a.get(r6);
        if (r8 == null) goto L15;
        r8.a(r4);
        return;
    L15:
        return;
    }

    public final void v(String r2, List<String> r3, Long r4) {
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        u(r2, (String) r5.next(), r4);
        goto L4
    }

    public static void A(ECLivePerformanceMonitor r6, boolean r7, String r8, View r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r8 = "";
    L6:
        if ((r10 & 8) == 0) goto L8;
        r9 = null;
    L8:
        Intrinsics.checkNotNullParameter(r8, "status");
        if (r7 == false) goto L11;
        String r0 = "ec_perf_page_start_live_product_list";
    L12:
        Map<String, g1> r1 = r6.w;
        g1 r2 = (g1) ((LinkedHashMap) r1).get(r0);
        if (r2 != null) goto L15;
        r2 = new g1(r0);
    L15:
        PageFinder r11 = PageFinder.via(r9);
        BtmItemBuilder r12 = new BtmItemBuilder("a1.b0715", Boolean.FALSE).withPageFinder(r11);
        String r13 = BtmSDK.INSTANCE.createBtmId(r12.build());
        r2.f("scene", r6.e);
        r2.f("live_list_from", r6.f);
        r2.f("btm_id", r13);
        if (r7 == true) goto L18;
        r2.f("status", r8);
    L18:
        r2.k();
        Unit r14 = Unit.INSTANCE;
        r1.put(r0, r2);
        return;
    L11:
        r0 = "ec_perf_page_show_live_product_list";
        goto L12
    }

    public static void w(ECLivePerformanceMonitor r2, String r3, h r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "business");
        String r7 = r2.d(r3, true);
        if (r7 == null) goto L23;
        if (r4 == null) goto L14;
        com.bytedance.android.ec.monitor.duration.d r0 = com.bytedance.android.ec.monitor.duration.i.a.get(r7);
        if (r0 == null) goto L14;
        r0.e(new com.bytedance.android.livesdk.livecommerce.opt.c(r4));
    L14:
        if (r5 == null) goto L18;
        com.bytedance.android.ec.monitor.duration.d r8 = com.bytedance.android.ec.monitor.duration.i.a.get(r7);
        if (r8 == null) goto L21;
        r8.c(r5);
    L21:
        String r9 = r2.v.remove(r3);
        return;
    L18:
        com.bytedance.android.ec.monitor.duration.d r10 = com.bytedance.android.ec.monitor.duration.i.a.get(r7);
        if (r10 == null) goto L21;
        r10.report();
        goto L21
    }

    public final void x(boolean r7, Boolean r8, gf.a r9, View r10, String r11) {
        if (r7 == false) goto L4;
        String r0 = "ec_perf_page_start_live_guide_card";
    L5:
        Map<String, g1> r1 = this.w;
        g1 r2 = (g1) ((LinkedHashMap) r1).get(r0);
        if (r2 != null) goto L8;
        r2 = new g1(r0);
    L8:
        BtmItemBuilder r12 = new BtmItemBuilder("c2627.d4434", Boolean.FALSE).withPageFinder(PageFinder.via(r10));
        String r13 = BtmSDK.INSTANCE.createBtmId(r12.build());
        if (r8 != null) goto L11;
    L15:
        if (r9 != null) goto L17;
    L21:
        r2.f("btm_id", r13);
        if (r7 == true) goto L24;
        r2.f("status", r11);
    L24:
        r2.k();
        Unit r14 = Unit.INSTANCE;
        r1.put(r0, r2);
        return;
    L17:
        if (r9.a() == false) goto L19;
        String r15 = "live";
    L20:
        r2.f("from_type", r15);
        goto L21
    L19:
        r15 = "store";
        goto L20
    L11:
        if (r8.booleanValue() == false) goto L13;
        String r16 = "message";
    L14:
        r2.f("scene", r16);
        goto L15
    L13:
        r16 = "enter_room";
        goto L14
    L4:
        r0 = "ec_perf_page_show_live_guide_card";
        goto L5
    }

    public static final void a(ECLivePerformanceMonitor r3, com.bytedance.android.ec.adapter.api.i r4, String r5, boolean r6, String r7, MetricNames r8) {
        r3.getClass();
        if (r6 == false) goto L5;
        r4.getSingleTimeStamp(r5);
        long r9 = 0;
    L6:
        long r10 = r4.a("enter_room");
        if (r10 > 0) goto L9;
    L11:
        long r11 = 0;
    L13:
        if (r11 <= 0) goto L16;
        Map r12 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.a(r7, r8, r11);
        return;
    L16:
        return;
    L9:
        if (r9 <= 0) goto L11;
        r11 = r9 - r10;
        goto L13
    L5:
        r9 = r4.a(r5);
        goto L6
    }
}
