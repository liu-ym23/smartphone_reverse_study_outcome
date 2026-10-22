package com.bytedance.android.window.shop.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.setting.WindowSettingKeys;
import com.bytedance.android.ec.window.base.utils.taskmanager.ECWindowTaskManager;
import com.bytedance.android.ec.window.base.utils.taskmanager.WindowExecutorType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import di.q;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uq3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowPrefMonitorLifecycle implements e {
    public g a;
    public d b;
    public final String c;

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void a() {
        g r0 = this.a;
        if (r0.k == (-1)) goto L5;
        return;
    L5:
        r0.k = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void b() {
        g r0 = this.a;
        if (r0.f == (-1)) goto L5;
        return;
    L5:
        r0.f = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void f() {
        g r0 = this.a;
        r0.h = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void k() {
        g r0 = this.a;
        if (r0.l == (-1)) goto L5;
        return;
    L5:
        r0.l = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void l() {
        g r0 = this.a;
        r0.m = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void r() {
        g r0 = this.a;
        r0.d = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void u() {
        g r0 = this.a;
        r0.i = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void v() {
        g r0 = this.a;
        r0.a = System.currentTimeMillis();
    }

    public WindowPrefMonitorLifecycle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceClassName");
        this.c = r2;
        this.a = new g();
        this.b = new d(new ConcurrentHashMap());
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void d(long r2) {
        this.a.q = r2;
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void g(ECWindowParam r3) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        g r4 = this.a;
        r4.j = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void h(ECWindowParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        g r4 = this.a;
        r4.b = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void j(WindowTabInfoProvider r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        g r0 = this.a;
        if (r0.g == (-1)) goto L5;
        return;
    L5:
        r0.g = System.currentTimeMillis();
        Iterator<T> r1 = r7.categories().iterator();
    L6:
        String r2 = null;
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((p) r3).b(), r7.getTargetSelectCategoryId()) == false) goto L6;
    L12:
        p r4 = (p) r3;
        d r8 = this.b;
        if (r4 == null) goto L15;
        String r5 = r4.c();
    L16:
        String r6 = "";
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        r8.a("category_name", r5);
        d r9 = this.b;
        if (r4 == null) goto L22;
        r2 = r4.b();
    L22:
        if (r2 == null) goto L25;
        r6 = r2;
    L25:
        r9.a("category_id", r6);
        return;
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void n(uq3.a r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        this.a.e = System.currentTimeMillis();
        d r0 = this.b;
        o r1 = r7.c;
        Integer r2 = null;
        if (r1 == null) goto L5;
        WindowV3LiveRoomVO r3 = r1.f;
    L6:
        String r4 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r3 == null) goto L9;
        String r5 = CommentScene.COMMENTSCENE_NO_AWEME;
    L10:
        r0.a("flag_has_header_live", r5);
        d r6 = this.b;
        o r8 = r7.c;
        if (r8 == null) goto L13;
        ECUrlModel r9 = r8.g;
    L14:
        if (r9 == null) goto L19;
        if (r8 == null) goto L17;
        r2 = r8.h;
    L17:
        if (r2 == null) goto L19;
    L20:
        r6.a("flag_use_custom_background", r4);
        return;
    L19:
        r4 = "0";
        goto L20
    L13:
        r9 = null;
        goto L14
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final e s(boolean r8) {
        WindowPrefMonitorLifecycle r0 = new WindowPrefMonitorLifecycle(this.c);
        g r1 = this.a;
        r1.getClass();
        g r2 = new g();
        r2.a = r1.a;
        r2.b = r1.b;
        r2.c = r1.c;
        r2.d = r1.d;
        r2.e = r1.e;
        long r3 = -1;
        if (r8 == false) goto L5;
        long r5 = r1.f;
    L6:
        r2.f = r5;
        if (r8 == false) goto L9;
        r3 = r1.g;
    L9:
        r2.g = r3;
        r2.h = r1.h;
        r2.i = r1.i;
        r2.j = r1.j;
        r2.s = r1.s;
        r0.a = r2;
        d r9 = this.b;
        r9.getClass();
        r0.b = new d(new ConcurrentHashMap(r9.a));
        return r0;
    L5:
        r5 = -1;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void o(Context r7, ECWindowParam r8) {
        Intrinsics.checkNotNullParameter(r8, "windowParam");
        d.c(this.b, "ec_perf_page_start_window", r8, null, null, 28);
        g r9 = this.a;
        r9.c = System.currentTimeMillis();
        this.b.a("sec_author_id", r8.getSecAuthorId());
        this.b.a("entrance_location", r8.getEntranceLocation());
        this.b.a("entrance_class_name", this.c);
        d r10 = this.b;
        if (r8.isCroppedStyle() == false) goto L5;
        String r0 = "split";
    L6:
        r10.a("modal", r0);
        d r11 = this.b;
        String r1 = WindowSettingKeys.getLYNX_WINDOW_PRELOAD_CARD_URL();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        String r3 = "0";
    L16:
        r11.a("flex_use_preload", r3);
        WindowLayoutType r12 = r8.getTargetLayoutType();
        if (r12 == null) goto L19;
        int r13 = Integer.valueOf(r12.getType()).intValue();
        this.b.a("goods_tab_layout", String.valueOf(r13));
    L19:
        this.b.a("select_category", String.valueOf(r8.getTargetCategory()));
        return;
    L15:
        r3 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L16
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    L5:
        r0 = "full";
        goto L6
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void p(final ECWindowParam r3, final WindowHeaderResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Intrinsics.checkNotNullParameter(r4, "response");
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r2 = new WindowPrefMonitorLifecycle$onHeaderDataReady$1(this, r4, r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "runnable");
        int r5 = com.bytedance.android.ec.window.base.utils.taskmanager.b.c;
        com.bytedance.android.ec.window.base.utils.taskmanager.b.b.a.a(WindowExecutorType.COMPUTE, r2);
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void q(Context r2, ECWindowParam r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        UUID.randomUUID().toString();
        System.currentTimeMillis();
    }

    public static void w(WindowPrefMonitorLifecycle r7, di.d r8, ECWindowParam r9) {
        d r0 = r7.b;
        JSONObject r3 = new JSONObject();
        r3.put("window_bhv_session_id", r9.getWindowSessionId());
        r3.put("path", r8.c.a);
        r3.put("method", r8.c.b);
        r3.put("code", r8.c.c);
        r3.put("socket_reused", r8.c.f);
        r3.put("connection_info", r8.c.g);
        r3.put("net_thread_priority", r8.c.h);
        r3.put("ttnet_version", r8.c.i);
        r3.put("priority_level", r8.c.j);
        r3.put("request_compress_type", r8.c.k);
        r3.put("response_compress_type", r8.c.l);
        r3.put("effective_net_type", r8.c.n);
        r3.put("real_net_type", r8.c.q);
        Unit r10 = Unit.INSTANCE;
        JSONObject r4 = new JSONObject();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        r4.put("window_bhv_session_id", r9.getWindowSessionId());     // Catch: Throwable -> L5
        r4.put("before_stream", r8.a.a);     // Catch: Throwable -> L5
        r4.put("body_recv", r8.a.b);     // Catch: Throwable -> L5
        r4.put("connect_delay", r8.a.c);     // Catch: Throwable -> L5
        r4.put("create_stream", r8.a.d);     // Catch: Throwable -> L5
        r4.put("dispatch", r8.a.e);     // Catch: Throwable -> L5
        r4.put("dns", r8.a.f);     // Catch: Throwable -> L5
        r4.put("edge", r8.a.g);     // Catch: Throwable -> L5
        r4.put("header_recv", r8.a.h);     // Catch: Throwable -> L5
        r4.put("inner", r8.a.i);     // Catch: Throwable -> L5
        r4.put("origin", r8.a.j);     // Catch: Throwable -> L5
        r4.put("proxy", r8.a.k);     // Catch: Throwable -> L5
        r4.put("rtt", r8.a.l);     // Catch: Throwable -> L5
        r4.put("security_callback", r8.a.m);     // Catch: Throwable -> L5
        r4.put("send", r8.a.n);     // Catch: Throwable -> L5
        r4.put("ssl", r8.a.o);     // Catch: Throwable -> L5
        r4.put("tcp", r8.a.p);     // Catch: Throwable -> L5
        r4.put("ttfb", r8.a.q);     // Catch: Throwable -> L5
        r4.put("pre_request_duration", r8.a.s);     // Catch: Throwable -> L5
        r4.put("net_total_duration", r8.a.t);     // Catch: Throwable -> L5
        r4.put("after_request_duration", r8.a.u);     // Catch: Throwable -> L5
        r4.put("response_serializer_duration", r8.a.v);     // Catch: Throwable -> L5
        r4.put("start_time", r8.b.a);     // Catch: Throwable -> L5
        r4.put("create_stream_start", r8.b.b);     // Catch: Throwable -> L5
        r4.put("create_stream_finish", r8.b.c);     // Catch: Throwable -> L5
        r4.put("request_sent_time", r8.b.d);     // Catch: Throwable -> L5
        r4.put("response_recv_time", r8.b.e);     // Catch: Throwable -> L5
        r4.put("end_time", r8.b.f);     // Catch: Throwable -> L5
        r4.put("ec_net_request_start", r8.b.g);     // Catch: Throwable -> L5
        r4.put("ec_net_request_end", r8.b.h);     // Catch: Throwable -> L5
        r4.put("app_level_request_start", r8.b.i);     // Catch: Throwable -> L5
        r4.put("before_all_interceptors", r8.b.j);     // Catch: Throwable -> L5
        r4.put("received_bytes", r8.c.d);     // Catch: Throwable -> L5
        r4.put("sent_bytes", r8.c.e);     // Catch: Throwable -> L5
        r4.put("downlink_throughput", r8.c.m);     // Catch: Throwable -> L5
        r4.put("http_rtt", r8.c.o);     // Catch: Throwable -> L5
        Result.constructor-impl(r4.put("tcp_rtt", r8.c.p));     // Catch: Throwable -> L5
    L7:
        Unit r12 = Unit.INSTANCE;
        d.c(r0, "ec_perf_duration_window_net", r9, r3, r4, 16);
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void e(ECWindowParam r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        g r6 = this.a;
        Object r7 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        Long r8 = Long.valueOf(JSONObjectProtectorUtils.getLong(r5, "t_page_show"));     // Catch: Throwable -> L9
    L7:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r9) == true) goto L15;
        r7 = r9;
    L15:
        Long r10 = (Long) r7;
        if (r10 == null) goto L18;
        long r11 = r10.longValue();
    L19:
        r6.n = r11;
        return;
    L18:
        r11 = System.currentTimeMillis();
        goto L19
    L6:
        r8 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void i(final ECWindowParam r2, final WindowTabInfoProvider r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "windowParam");
        Intrinsics.checkNotNullParameter(r3, "response");
        Lazy r5 = ECWindowTaskManager.a;
        ECWindowTaskManager r6 = ECWindowTaskManager.a.a();
        Function0<Unit> r0 = new WindowPrefMonitorLifecycle$onTabDataReady$1(this, r3, r2);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "runnable");
        int r7 = com.bytedance.android.ec.window.base.utils.taskmanager.b.c;
        com.bytedance.android.ec.window.base.utils.taskmanager.b.b.a.a(WindowExecutorType.COMPUTE, r0);
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void t(int r1, Integer r2, WindowTypeSeparatedAdapter r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r3, "adapter");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void c(ECWindowParam r10, long r11, JSONObject r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "windowParam");
        this.a.p = r11;
        d r12 = this.b;
        if (r14 != null) goto L5;
        r14 = new JSONObject();
    L5:
        r14.put("window_bhv_session_id", r10.getWindowSessionId());
        r14.put(TabkitFirstFramePref.T_PAGE_ROUTE_START, this.a.a);
        r14.put(TabkitFirstFramePref.T_PAGE_INIT_START, this.a.b);
        r14.put(TabkitFirstFramePref.T_PAGE_INIT_END, this.a.c);
        r14.put("t_request_header_start", this.a.d);
        r14.put("t_request_header_end", this.a.e);
        r14.put("t_request_tab_start", this.a.f);
        r14.put("t_request_tab_end", this.a.g);
        r14.put("t_render_header_start", this.a.h);
        r14.put("t_render_header_end", this.a.i);
        r14.put("t_render_live_end", this.a.j);
        r14.put("t_render_tab_start", this.a.k);
        r14.put("t_tab_container_start", this.a.l);
        r14.put("t_tab_container_ready", this.a.m);
        r14.put("t_page_show", this.a.n);
        r14.put("t_page_show_new", this.a.o);
        r14.put("t_page_show_with_lynx", this.a.p);
        r14.put("t_page_show_with_lynx_ssr", this.a.q);
        q r1 = this.a.s;
        if (r1 != null) goto L39;
    L11:
        q r2 = this.a.r;
        if (r2 != null) goto L37;
    L17:
        ECAppInfoService r3 = ECAppInfoService.e;
        if (r3.isLocalTest() == false) goto L20;
    L21:
        g r4 = this.a;
        r14.put("debug_router_duration", r4.b - r4.a);
        g r5 = this.a;
        r14.put("debug_page_init_duration", r5.c - r5.b);
        g r6 = this.a;
        r14.put("debug_header_duration", r6.e - r6.d);
        g r7 = this.a;
        r14.put("debug_tab_duration", r7.g - r7.f);
        g r8 = this.a;
        r14.put("debug_tab_render_duration", r8.n - r8.k);
        g r9 = this.a;
        r14.put("debug_tab_render_duration_lynx", r9.p - r9.k);
        g r15 = this.a;
        r14.put("debug_render_header_duration", r15.i - r15.h);
        g r16 = this.a;
        r14.put("debug_render_live_duration", r16.j - r16.i);
        g r17 = this.a;
        r14.put("debug_block_header_duration", r17.h - r17.e);
        g r18 = this.a;
        r14.put("debug_block_tab_duration", r18.k - r18.g);
        g r19 = this.a;
        r14.put("debug_tab_init_duration", r19.m - r19.l);
        g r20 = this.a;
        r14.put("debug_render_tab_duration", r20.n - r20.m);
        g r21 = this.a;
        r14.put("debug_total_duration", r21.n - r21.a);
        g r22 = this.a;
        r14.put("debug_total_duration_new", r22.o - r22.a);
        g r23 = this.a;
        r14.put("debug_total_duration_lynx", r23.p - r23.a);
        g r24 = this.a;
        r14.put("debug_total_render_duration", r24.n - r24.k);
        g r25 = this.a;
        r14.put("debug_total_render_duration_new", r25.o - r25.k);
        g r26 = this.a;
        r14.put("debug_total_render_duration_lynx", r26.p - r26.k);
    L22:
        Unit r27 = Unit.INSTANCE;
        r12.getClass();
        Intrinsics.checkNotNullParameter("ec_perf_duration_window", "eventName");
        Intrinsics.checkNotNullParameter(r10, "windowParam");
        Intrinsics.checkNotNullParameter(r14, "metric");
        if (r13 != null) goto L25;
        r13 = new JSONObject();
    L25:
        r12.b(r13);
        i r110 = i.a;
        com.bytedance.android.ec.monitor.duration.d r111 = r110.get(r110.create("ec_perf_duration_window"));
        if (r111 == null) goto L43;
        Iterator<String> r112 = r14.keys();
    L29:
        if (r112.hasNext() == false) goto L31;
        String r0 = r112.next();
        r111.b(r0, r14.get(r0).toString());
        goto L29
    L31:
        Iterator<String> r113 = r13.keys();
    L33:
        if (r113.hasNext() == false) goto L35;
        String r28 = r113.next();
        r111.b(r28, r13.get(r28).toString());
        goto L33
    L35:
        r111.d("initial", k.y(r14.get(TabkitFirstFramePref.T_PAGE_ROUTE_START).toString(), -1));
        r111.d("request_start", k.y(r14.get("t_request_header_start").toString(), -1));
        r111.d("request_end", k.y(r14.get("t_request_tab_end").toString(), -1));
        r111.d("render_start", k.y(r14.get("t_render_tab_start").toString(), -1));
        r111.d("render_end", k.y(r14.get("t_page_show").toString(), -1));
        r111.report();
        return;
    L43:
        return;
    L20:
        if (r3.isDebug() == false) goto L22;
    L37:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L15
        r14.put("net_tab_start_time", r2.a);     // Catch: Throwable -> L15
        r14.put("net_tab_create_stream_start", r2.b);     // Catch: Throwable -> L15
        r14.put("net_tab_create_stream_finish", r2.c);     // Catch: Throwable -> L15
        r14.put("net_tab_request_sent_time", r2.d);     // Catch: Throwable -> L15
        r14.put("net_tab_response_recv_time", r2.e);     // Catch: Throwable -> L15
        r14.put("net_tab_end_time", r2.f);     // Catch: Throwable -> L15
        r14.put("net_tab_ec_net_request_start", r2.g);     // Catch: Throwable -> L15
        Result.constructor-impl(r14.put("net_tab_ec_net_request_end", r2.h));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L39:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L9
        r14.put("net_header_start_time", r1.a);     // Catch: Throwable -> L9
        r14.put("net_header_create_stream_start", r1.b);     // Catch: Throwable -> L9
        r14.put("net_header_create_stream_finish", r1.c);     // Catch: Throwable -> L9
        r14.put("net_header_request_sent_time", r1.d);     // Catch: Throwable -> L9
        r14.put("net_header_response_recv_time", r1.e);     // Catch: Throwable -> L9
        r14.put("net_header_end_time", r1.f);     // Catch: Throwable -> L9
        r14.put("net_header_ec_net_request_start", r1.g);     // Catch: Throwable -> L9
        Result.constructor-impl(r14.put("net_header_ec_net_request_end", r1.h));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void m(ECWindowParam r1, long r2, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "windowParam");
        this.a.o = r2;
    }
}
