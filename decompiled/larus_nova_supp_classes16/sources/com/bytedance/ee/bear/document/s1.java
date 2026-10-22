package com.bytedance.ee.bear.document;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.util.deviceinfo.DeviceInfoDetector;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ttnet.TTNetInit;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s1 {
    public static long A;
    public static int B;
    public static long C;
    public static List<String> D;
    public static boolean E;
    public static int F;
    public static boolean G;
    public static String H;
    public static int I;
    public static int J;
    public static int K;
    public static boolean n;
    public static String o;
    public static String p;
    public static String q;
    public static int r;
    public static int s;
    public static final AtomicBoolean t = null;
    public static final AtomicBoolean u = null;
    public static long v;
    public static long w;
    public static long x;
    public static final String y = null;
    public static long z;
    public final ConnectionService a;
    public final com.bytedance.ee.bear.contract.d b;
    public final com.bytedance.ee.bear.contract.b0 c;
    public final com.bytedance.ee.bear.contract.f d;
    public final String e;
    public final boolean f;
    public String g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public String l;
    public String m;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class c {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class d {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderStage.values().length];
            r0[RenderStage.RENDERING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[RenderStage.RENDER_CACHE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[RenderStage.RENDER_CACHE_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RenderStage.PULL_DATA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[RenderStage.PULL_DATA_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[RenderStage.RENDER_DOC_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[RenderStage.RENDER_DOC_END.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
        o = "tab_other";
        r = 1;
        t = new AtomicBoolean(true);
        u = new AtomicBoolean(true);
        Lazy r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.b().p();
        y = "";
    }

    public final void n() {
        String r0 = this.b.e("wait_download_resource", "start_time");
        if (r0 != null) goto L5;
        long r1 = 0;
    L6:
        this.i = r1;
        this.b.c("wait_download_resource");
        return;
    L5:
        r1 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r0);
        goto L6
    }

    public final void o() {
        String r0 = this.b.e("wait_preload", "start_time");
        if (r0 != null) goto L5;
        long r5 = 0;
    L6:
        this.h = r5;
        this.b.c("wait_preload");
        String r1 = this.b.e("wait_preload_html", "end_time");
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        long r2 = CastLongProtector.parseLong(r1) - CastLongProtector.parseLong(r0);
    L12:
        this.j = r2;
        if (r2 >= 0) goto L15;
        this.j = 0;
    L15:
        this.b.c("wait_preload_html");
        return;
    L11:
        r2 = 0;
        goto L12
    L5:
        r5 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r0);
        goto L6
    }

    public static void c(JSONObject r4) {
        int r0 = d25.d.f;
        String r1 = d25.d.h;
        com.bytedance.ee.bear.document.forecast.a.d(r0);
        if (r0 == 16) goto L5;
    L7:
        r4.put("interrupt_webview_preload", String.valueOf(E));
        boolean r2 = DocOpenConfig.e().contains(d25.d.g);
        List<String> r3 = D;
        boolean r5 = false;
        if (r3 == null) goto L10;
        boolean r6 = r3.contains(d25.d.g);
    L11:
        if (r2 == false) goto L14;
        if (r6 == true) goto L14;
        r5 = true;
    L14:
        r4.put("interrupt_template_preload", String.valueOf(r5));
        return;
    L10:
        r6 = false;
        goto L11
    L5:
        if (Intrinsics.areEqual(r1, "unknown") == true) goto L7;
        com.bytedance.ee.bear.document.forecast.a.d(sbb.e.g(r1));
        goto L7
    }

    public final void a(JSONObject r6) {
        if (Intrinsics.areEqual(r6.optString("isDocHtmlCache"), "true") == false) goto L5;
        r6.put("ssr_preload_from", this.m);
    L14:
        if (Intrinsics.areEqual(r6.optString("clientvar_from"), "CACHE") == false) goto L16;
        r6.put("clientvar_preload_from", this.l);
        return;
    L16:
        Map<String, Set<String>> r0 = d25.d.a;
        tt5.a.b("OfflineUtils", "getClientVarUnusedReason");
        if (TextUtils.equals(d25.d.o, "no_cache") == true) goto L19;
    L21:
        String r1 = d25.d.o;
        if (r1 == null) goto L26;
        r6.put("clientvar_unused_reason", r1);
        return;
    L26:
        return;
    L19:
        if (d25.d.m == false) goto L21;
        d25.d.o = "no_memory_cache";
        goto L21
    L5:
        Map<String, Set<String>> r2 = d25.d.a;
        tt5.a.b("OfflineUtils", "getSsrUnusedReason");
        if (TextUtils.equals(d25.d.n, "no_cache") == true) goto L8;
    L10:
        String r3 = d25.d.n;
        if (r3 == null) goto L14;
        r6.put("ssr_unused_reason", r3);
        goto L14
    L8:
        if (d25.d.l == false) goto L10;
        d25.d.n = "no_memory_cache";
        goto L10
    }

    public final void b(JSONObject r6) {
        r6.put("is_first_open_docs", String.valueOf(t.get()));     // Catch: Exception -> L27
        DeviceInfoDetector.DeviceInfo r1 = this.c.getDeviceInfo();     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r1.d) == false) goto L5;
        String r2 = DiagramData$RESULT.SUCCESS;
    L6:
        r6.put("cpu_core_numbers", r2);     // Catch: Exception -> L27
        DeviceInfoDetector.DeviceInfo r3 = this.c.getDeviceInfo();     // Catch: Exception -> L27
        String r4 = "";
        if (TextUtils.isEmpty(r3.b) == false) goto L10;
        String r5 = "";
    L11:
        r6.put("cpu_name", r5);     // Catch: Exception -> L27
        DeviceInfoDetector.DeviceInfo r7 = this.c.getDeviceInfo();     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r7.c) == false) goto L14;
        String r8 = "";
    L15:
        r6.put("max_cpu_freq", r8);     // Catch: Exception -> L27
        DeviceInfoDetector.DeviceInfo r9 = this.c.getDeviceInfo();     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r9.e) == false) goto L18;
        String r10 = "";
    L19:
        r6.put("total_mem", r10);     // Catch: Exception -> L27
        r6.put("tt_web_so_version_code", y);     // Catch: Exception -> L27
        r6.put("doc_network_level", String.valueOf(((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().p().getValue()));     // Catch: Exception -> L27
        int r0 = d.a;     // Catch: Exception -> L27
        r6.put("network_quality_type", TTNetInit.getEffectiveConnectionType());     // Catch: Exception -> L27
        r6.put("render_process_kill_times", com.bytedance.ee.bear.document.reloadwebview.a.f);     // Catch: Exception -> L27
        r6.put("is_first_open_after_kill", com.bytedance.ee.bear.document.reloadwebview.a.e);     // Catch: Exception -> L27
        r6.put("file_id", du5.b.g(d25.d.d));     // Catch: Exception -> L27
        r6.put("render_gone_time", p35.e.e);     // Catch: Exception -> L27
        r6.put("render_gone_time_in_doc_opening", p35.e.f);     // Catch: Exception -> L27
        r6.put("render_gone_time_pre_doc", p35.e.g);     // Catch: Exception -> L27
        String r11 = d25.d.d();     // Catch: Exception -> L27
        if (r11 == null) goto L23;
        r4 = r11;
    L23:
        r6.put("doc_app_id", r4);     // Catch: Exception -> L27
        r6.put("is_emulator", ku5.c.j());     // Catch: Exception -> L27
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.forecast_enable_android") == false) goto L32;
        r6.put("render_process_memory", eu5.g.f(eu5.b.a));     // Catch: Exception -> L27
        return;
    L32:
        return;
    L18:
        r10 = r9.e;     // Catch: Exception -> L27
        goto L19
    L14:
        r8 = r7.c;     // Catch: Exception -> L27
        goto L15
    L10:
        r5 = r3.b;     // Catch: Exception -> L27
        goto L11
    L5:
        r2 = r1.d;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        tt5.a.m("DocReport", e);
    }

    public final void i(int r8) {
        tt5.a.h("DocReport", "reportLoginFail");
        String r2 = d25.d.j;     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2) == true) goto L6;
        int r3 = 1;
    L7:
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L12
        r4.put("stage", "pull_data");     // Catch: Throwable -> L12
        r4.put("docs_result_key", "login_fail");     // Catch: Throwable -> L12
        r4.put("docs_result_code", r8);     // Catch: Throwable -> L12
        r4.put("file_type", d25.d.g);     // Catch: Throwable -> L12
        r4.put("sub_type", d25.d.h);     // Catch: Throwable -> L12
        r4.put("file_id", du5.b.g(d25.d.d));     // Catch: Throwable -> L12
        r4.put("version_type", this.e);     // Catch: Throwable -> L12
        r4.put("scm_version", ow4.a.a);     // Catch: Throwable -> L12
        r4.put("doc_has_cache", r);     // Catch: Throwable -> L12
        r4.put("doc_from", o);     // Catch: Throwable -> L12
        r4.put("doc_sub_from", p);     // Catch: Throwable -> L12
        r4.put("open_doc_desc", q);     // Catch: Throwable -> L12
        r4.put("is_first_open_docs", String.valueOf(t.get()));     // Catch: Throwable -> L12
        r4.put("doc_has_info_cache", B);     // Catch: Throwable -> L12
        r4.put("is_version", r3);     // Catch: Throwable -> L12
        r4.put("edition_id", r2);     // Catch: Throwable -> L12
        String r5 = d25.d.d();     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r4.put("doc_app_id", r5);     // Catch: Throwable -> L12
        com.bytedance.ee.bear.contract.d r9 = this.b;     // Catch: Throwable -> L12
        int r6 = c.a;     // Catch: Throwable -> L12
        r9.a("dev_performance_stage", r4);     // Catch: Throwable -> L12
        MonitorUtils.monitorEvent("docs_dev_performance_stage", r4, r4, new JSONObject());     // Catch: Throwable -> L12
        return;
    L6:
        r2 = "none";
        r3 = 0;
    L12:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public final void m(String r3) {
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        HashMap r1 = new HashMap(this.b.m("docCommonParams"));
        r1.put("click", r3);
        r1.put("target", "none");
        this.b.n("ccm_space_docs_topbar_click", r1);
        tt5.a.b("DocReport", "reportTopBarClickEvent, params = " + r1);
    }

    public static void d(JSONObject r2, boolean r3) {
        r2.put("is_forseti_fg_on", ForsetiHelper.p());
        r2.put("is_in_forseti", r3);
    }

    public static void f(JSONObject r8, String r9) {
        Map<String, Long> r0 = r25.e.j;
        String r1 = d25.d.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Long r3 = (Long) ((ConcurrentHashMap) r0).remove(r1);
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
        if ((-1) != r4) goto L10;
        r8.put("time_to_preload_clientvar", -1);
        goto L11
    L10:
        r8.put("time_to_preload_clientvar", Math.max(CastLongProtector.parseLong(r9) - r4, -1));
    L11:
        Map<String, Long> r5 = q25.i.n;
        String r6 = d25.d.d;
        if (r6 == null) goto L15;
        r2 = r6;
    L15:
        Long r7 = (Long) ((ConcurrentHashMap) r5).remove(r2);
        if (r7 == null) goto L22;
        long r10 = r7.longValue();
        if ((-1) != r10) goto L20;
        r8.put("time_to_preload_ssr", -1);
        return;
    L20:
        r8.put("time_to_preload_ssr", Math.max(CastLongProtector.parseLong(r9) - r10, -1));
        return;
    }

    public static int g(DocLoadingState r1, u1 r2) {
        Intrinsics.checkNotNullParameter(r1, "state");
        Intrinsics.checkNotNullParameter(r2, "docStateTracker");
        int r0 = b.a;
        if (r1 != DocLoadingState.INIT) goto L6;
        return 400;
    L6:
        if (r1 != DocLoadingState.WAITING_DOWNLOAD) goto L9;
        return VersionPayLoadData.OPERATION_UPDATE;
    L9:
        if (r1 != DocLoadingState.WAITING_PRELOAD) goto L12;
        return 100;
    L12:
        if (r1 == DocLoadingState.RENDERING) goto L14;
        return 999;
    L14:
        if (r2.c == false) goto L26;
        RenderStage r3 = r2.b;
        switch(e.a[r3.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            default: goto L18;
        };
    L19:
        return 507;
    L20:
        return 506;
    L21:
        return 505;
    L22:
        return 504;
    L23:
        return 503;
    L24:
        return 502;
    L25:
        return 501;
    L18:
        throw new NoWhenBranchMatchedException();
    L26:
        RenderStage r4 = r2.b;
        switch(e.a[r4.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            default: goto L29;
        };
    L30:
        return 607;
    L31:
        return 606;
    L32:
        return 605;
    L33:
        return 604;
    L34:
        return 603;
    L35:
        return 602;
    L36:
        return 601;
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(JSONObject r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "map");
        if (r14 > 0) goto L16;
        return;
    L16:
        long r6 = SystemClock.uptimeMillis();     // Catch: Throwable -> L13
        long r16 = r6 - r14;     // Catch: Throwable -> L13
        tt5.a.b("DocReport", "reportJsReady duration = " + r16);     // Catch: Throwable -> L13
        r13.put("cost_time", r16);     // Catch: Throwable -> L13
        if (u.compareAndSet(true, false) == false) goto L8;
        long r7 = r6 - this.c.d();     // Catch: Throwable -> L13
        long r17 = this.c.d() - this.c.a();     // Catch: Throwable -> L13
        long r2 = Math.max(C - this.c.a(), 0);     // Catch: Throwable -> L13
        r13.put("doc_init_trace", this.c.i());     // Catch: Throwable -> L13
        r13.put("time_to_fill_pool", r2);     // Catch: Throwable -> L13
        r13.put("cost_time_preload_finish_to_doc_init", r7);     // Catch: Throwable -> L13
        r13.put("cost_time_p0_launch_to_open_doc", r7);     // Catch: Throwable -> L13
        r13.put("cost_time_app_launch_to_doc_init", r17);     // Catch: Throwable -> L13
        r13.put("cost_time_app_launch_to_open_doc", r7 + r17);     // Catch: Throwable -> L13
        this.c.u();     // Catch: Throwable -> L13
    L8:
        Object r3 = null;
        r13.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).a()));     // Catch: Throwable -> L13
        Application r18 = eu5.b.a;     // Catch: Throwable -> L13
        if (r18 == null) goto L11;
        r3 = r18.getSystemService("keyguard");     // Catch: Throwable -> L13
    L11:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Throwable -> L13
        r13.put("screen_status", String.valueOf(((KeyguardManager) r3).inKeyguardRestrictedInputMode()));     // Catch: Throwable -> L13
        r13.put("version_type", this.e);     // Catch: Throwable -> L13
        r13.put("enable_x5", this.f);     // Catch: Throwable -> L13
        r13.put("scm_version", ow4.a.a);     // Catch: Throwable -> L13
        com.bytedance.ee.bear.contract.d r19 = this.b;     // Catch: Throwable -> L13
        int r110 = c.a;     // Catch: Throwable -> L13
        r19.a("dev_performance_doc_template_preload", r13);     // Catch: Throwable -> L13
        MonitorUtils.monitorEvent("docs_dev_performance_doc_template_preload", r13, r13, new JSONObject());     // Catch: Throwable -> L13
        tt5.a.h("DocReport", "reportJsReady reportLoadFinish: " + r13);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public s1(ConnectionService r2, com.bytedance.ee.bear.contract.d r3, com.bytedance.ee.bear.contract.b0 r4, com.bytedance.ee.bear.contract.f r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "mConnectionService");
        Intrinsics.checkNotNullParameter(r3, "mAnalyticService");
        Intrinsics.checkNotNullParameter(r4, "infoService");
        Intrinsics.checkNotNullParameter(r5, "appVisibleService");
        Intrinsics.checkNotNullParameter(r6, "versionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        Lazy r7 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        this.f = false;
        this.g = "";
        this.l = "unknown";
        this.m = "unknown";
    }

    public final void l(Map<String, ? extends Object> r19, boolean r20, String r21, int r22, String r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "tag");
        long r8 = SystemClock.uptimeMillis();     // Catch: Throwable -> L66
        p35.e.e = 0;     // Catch: Throwable -> L66
        p35.e.g = 0;     // Catch: Throwable -> L66
        p35.e.f = 0;     // Catch: Throwable -> L66
        if (r19 == null) goto L6;
        JSONObject r10 = new JSONObject(r19);     // Catch: Throwable -> L66
    L7:
        r10.put("docs_result_key", "other");     // Catch: Throwable -> L66
        r10.put("docs_result_code", 0);     // Catch: Throwable -> L66
        r10.put("file_type", d25.d.g);     // Catch: Throwable -> L66
        r10.put("sub_type", d25.d.h);     // Catch: Throwable -> L66
        if (r20 == false) goto L10;
        Object r12 = "preload";
    L11:
        r10.put("docs_open_type", r12);     // Catch: Throwable -> L66
        r10.put("wait_preload_template_time", this.h);     // Catch: Throwable -> L66
        r10.put("wait_resource_time", this.i);     // Catch: Throwable -> L66
        r10.put("open_tag", r21);     // Catch: Throwable -> L66
        r10.put("version_type", this.e);     // Catch: Throwable -> L66
        r10.put("enable_x5", this.f);     // Catch: Throwable -> L66
        r10.put("scm_version", ow4.a.a);     // Catch: Throwable -> L66
        r10.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L66
        r10.put("doc_has_cache", r);     // Catch: Throwable -> L66
        r10.put("doc_from", o);     // Catch: Throwable -> L66
        r10.put("doc_sub_from", p);     // Catch: Throwable -> L66
        r10.put("open_doc_desc", q);     // Catch: Throwable -> L66
        int r11 = 1;
        r10.put("preload_html_enabled", 1);     // Catch: Throwable -> L66
        r10.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L66
        r10.put("isLarkWebview", n);     // Catch: Throwable -> L66
        r10.put("opening_count", l35.k.b);     // Catch: Throwable -> L66
        r10.put("doc_has_info_cache", B);     // Catch: Throwable -> L66
        r10.put("is_version", r22);     // Catch: Throwable -> L66
        r10.put("edition_id", r23);     // Catch: Throwable -> L66
        r10.put("is_blank_webview", this.k);     // Catch: Throwable -> L66
        a(r10);     // Catch: Throwable -> L66
        b(r10);     // Catch: Throwable -> L66
        d(r10, r24);     // Catch: Throwable -> L66
        String r2 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L66
        if (r2 == null) goto L33;
        if (r19 == null) goto L16;
        Object r0 = r19.get("timestamp");     // Catch: Throwable -> L66
    L17:
        String r1 = (String) r0;     // Catch: Throwable -> L66
        if (r1 == null) goto L20;
        long r14 = CastLongProtector.parseLong(r1);     // Catch: Throwable -> L66
    L21:
        long r16 = r14 - CastLongProtector.parseLong(r2);     // Catch: Throwable -> L66
        r10.put("cost_time", r16);     // Catch: Throwable -> L66
        Object r3 = this.b.f("render_cache", "start_time");     // Catch: Throwable -> L66
        if (r3 != null) goto L24;
        Object r17 = Long.valueOf(r16);     // Catch: Throwable -> L66
    L25:
        r10.put("time_to_visit", r17);     // Catch: Throwable -> L66
        if (idb.f.a().isCurrentEnable("ccm.docx.open_docs_record_optimize") == false) goto L30;
        if (r3 == null) goto L30;
        r10.put("isDocHtmlCache", true);     // Catch: Throwable -> L66
    L30:
        if (t.compareAndSet(true, false) == false) goto L32;
        long r9 = r8 - this.c.d();     // Catch: Throwable -> L66
        long r18 = this.c.d() - this.c.a();     // Catch: Throwable -> L66
        r10.put("cost_time_p0_launch_to_open_doc", r9);     // Catch: Throwable -> L66
        r10.put("cost_time_app_launch_to_doc_init", r18);     // Catch: Throwable -> L66
        r10.put("cost_time_app_launch_to_open_doc", r9 + r18);     // Catch: Throwable -> L66
    L32:
        v = CastLongProtector.parseLong(r2);     // Catch: Throwable -> L66
        f(r10, r2);     // Catch: Throwable -> L66
        goto L33
    L24:
        r17 = r3;
        goto L25
    L20:
        r14 = System.currentTimeMillis();     // Catch: Throwable -> L66
        goto L21
    L16:
        r0 = null;
    L33:
        Object r4 = this.b.e("render_cache", "render_cache_from");     // Catch: Throwable -> L66
        if (r4 == null) goto L36;
        r10.put("doc_html_cache_from", r4);     // Catch: Throwable -> L66
    L36:
        String r5 = this.b.e("render_cache", "value_render_cache_ssrwebview_wait_preload_time");     // Catch: Throwable -> L66
        if (r5 != null) goto L39;
    L42:
        boolean r6 = true;
    L43:
        if (r6 == false) goto L45;
        r5 = DiagramData$RESULT.FAIL;
    L45:
        r10.put("wait_ssrwebview_preload_time", r5);     // Catch: Throwable -> L66
        String r7 = this.b.e("render_cache", "value_render_cache_ssrwebview_is_ready");     // Catch: Throwable -> L66
        if (r7 != null) goto L48;
    L51:
        boolean r13 = true;
    L52:
        if (r13 == false) goto L54;
        r7 = "true";
    L54:
        r10.put("ssrwebview_is_ready", r7);     // Catch: Throwable -> L66
        Object r26 = this.b.e("render_cache", "value_render_cache_prompt_count");     // Catch: Throwable -> L66
        if (r26 == null) goto L57;
        r10.put("prompt_count", r26);     // Catch: Throwable -> L66
    L57:
        Object r27 = this.b.e("render_cache", "render_cache_over_limit");     // Catch: Throwable -> L66
        if (r27 == null) goto L60;
        r10.put("prompt_get_html_over_limit", r27);     // Catch: Throwable -> L66
    L60:
        r10.put("wait_preload_html_time", this.j);     // Catch: Throwable -> L66
        if (DocOpenConfig.m == true) goto L64;
        r11 = 0;
    L64:
        r10.put("load_ssr_after_preload_html", r11);     // Catch: Throwable -> L66
        c(r10);     // Catch: Throwable -> L66
        this.b.c("start_open");     // Catch: Throwable -> L66
        this.b.c("render_cache");     // Catch: Throwable -> L66
        com.bytedance.ee.bear.contract.d r28 = this.b;     // Catch: Throwable -> L66
        int r29 = c.a;     // Catch: Throwable -> L66
        r28.a("dev_performance_doc_open_finish", r10);     // Catch: Throwable -> L66
        MonitorUtils.monitorEvent("docs_dev_performance_doc_open_finish", r10, r10, new JSONObject());     // Catch: Throwable -> L66
        tt5.a.h("DocReport", "***reportOpenDoc*** Success  costtime: " + r10.opt("cost_time") + "    map:  " + r10);     // Catch: Throwable -> L66
        return;
    L48:
        if (r7.length() == 0) goto L51;
        r13 = false;
        goto L52
    L39:
        if (r5.length() == 0) goto L42;
        r6 = false;
        goto L43
    L10:
        r12 = "render";
        goto L11
    L6:
        r10 = new JSONObject();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public final void h(int r7, boolean r8, String r9, int r10, String r11, DocBridgeWebViewV2 r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        Intrinsics.checkNotNullParameter(r12, "webView");
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L18
        r3.put("docs_result_key", "cancel");     // Catch: Throwable -> L18
        r3.put("docs_result_code", r7);     // Catch: Throwable -> L18
        r3.put("file_type", d25.d.g);     // Catch: Throwable -> L18
        r3.put("sub_type", d25.d.h);     // Catch: Throwable -> L18
        if (r8 == false) goto L6;
        String r14 = "preload";
    L7:
        r3.put("docs_open_type", r14);     // Catch: Throwable -> L18
        int r16 = b.a;     // Catch: Throwable -> L18
        if (r7 != 100) goto L11;
        o();     // Catch: Throwable -> L18
    L13:
        r3.put("wait_preload_template_time", this.h);     // Catch: Throwable -> L18
        r3.put("wait_resource_time", this.i);     // Catch: Throwable -> L18
        r3.put("open_tag", r9);     // Catch: Throwable -> L18
        r3.put("version_type", this.e);     // Catch: Throwable -> L18
        r3.put("enable_x5", this.f);     // Catch: Throwable -> L18
        r3.put("scm_version", ow4.a.a);     // Catch: Throwable -> L18
        r3.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L18
        r3.put("doc_has_cache", r);     // Catch: Throwable -> L18
        r3.put("doc_from", o);     // Catch: Throwable -> L18
        r3.put("doc_sub_from", p);     // Catch: Throwable -> L18
        r3.put("open_doc_desc", q);     // Catch: Throwable -> L18
        r3.put("preload_html_enabled", 1);     // Catch: Throwable -> L18
        r3.put("file_length", s);     // Catch: Throwable -> L18
        r3.put("doc_webview_status_code", r12.getWebviewStatusCode());     // Catch: Throwable -> L18
        r3.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L18
        r3.put("isLarkWebview", n);     // Catch: Throwable -> L18
        r3.put("opening_count", l35.k.b);     // Catch: Throwable -> L18
        r3.put("doc_has_info_cache", B);     // Catch: Throwable -> L18
        r3.put("is_version", r10);     // Catch: Throwable -> L18
        r3.put("edition_id", r11);     // Catch: Throwable -> L18
        r3.put("is_blank_webview", this.k);     // Catch: Throwable -> L18
        c(r3);     // Catch: Throwable -> L18
        b(r3);     // Catch: Throwable -> L18
        d(r3, r13);     // Catch: Throwable -> L18
        String r17 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L18
        if (r17 == null) goto L16;
        r3.put("cost_time", ((System.currentTimeMillis() - CastLongProtector.parseLong(r17)) - this.i) - this.h);     // Catch: Throwable -> L18
        f(r3, r17);     // Catch: Throwable -> L18
    L16:
        this.b.c("start_open");     // Catch: Throwable -> L18
        this.b.c("render_cache");     // Catch: Throwable -> L18
        com.bytedance.ee.bear.contract.d r18 = this.b;     // Catch: Throwable -> L18
        int r19 = c.a;     // Catch: Throwable -> L18
        r18.a("dev_performance_doc_open_finish", r3);     // Catch: Throwable -> L18
        tt5.a.d("DocReport", "***reportOpenDoc*** CancelDoc : " + r3 + "    performanceTiming:  " + r12.getPerformanceTiming());     // Catch: Throwable -> L18
        return;
    L11:
        if (r7 != 101) goto L13;
        n();     // Catch: Throwable -> L18
        goto L13
    L6:
        r14 = "render";
    L18:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public final void j(Map<String, ? extends Object> r9, boolean r10, String r11, int r12, String r13, DocBridgeWebViewV2 r14, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r14, "webview");
    L40:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (eu5.i.b() == false) goto L6;
    L38:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  isWifiProxy");     // Catch: Throwable -> L40
        return;
    L6:
        if (eu5.i.a() == true) goto L38;
        if (r14.K2 == true) goto L11;
    L36:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  Render not Open");     // Catch: Throwable -> L40
        return;
    L11:
        if (r14.M2 == false) goto L36;
        if (TextUtils.isEmpty(d25.d.d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  no token");     // Catch: Throwable -> L40
        return;
    L18:
        if (this.c.getPackageName() != null) goto L20;
    L23:
        JSONObject r4 = new JSONObject(r9);     // Catch: Throwable -> L40
        r4.put("file_type", d25.d.g);     // Catch: Throwable -> L40
        r4.put("sub_type", d25.d.h);     // Catch: Throwable -> L40
        if (r10 == false) goto L26;
        String r17 = "preload";
    L27:
        r4.put("docs_open_type", r17);     // Catch: Throwable -> L40
        r4.put("wait_preload_template_time", this.h);     // Catch: Throwable -> L40
        r4.put("wait_resource_time", this.i);     // Catch: Throwable -> L40
        r4.put("open_tag", r11);     // Catch: Throwable -> L40
        r4.put("version_type", this.e);     // Catch: Throwable -> L40
        r4.put("enable_x5", this.f);     // Catch: Throwable -> L40
        r4.put("scm_version", ow4.a.a);     // Catch: Throwable -> L40
        r4.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L40
        r4.put("doc_has_cache", r);     // Catch: Throwable -> L40
        r4.put("doc_from", o);     // Catch: Throwable -> L40
        r4.put("doc_sub_from", p);     // Catch: Throwable -> L40
        r4.put("open_doc_desc", q);     // Catch: Throwable -> L40
        r4.put("preload_html_enabled", 1);     // Catch: Throwable -> L40
        r4.put("doc_webview_status_code", Long.valueOf(r14.getWebviewStatusCode()));     // Catch: Throwable -> L40
        r4.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L40
        r4.put("isLarkWebview", n);     // Catch: Throwable -> L40
        r4.put("opening_count", l35.k.b);     // Catch: Throwable -> L40
        r4.put("doc_has_info_cache", B);     // Catch: Throwable -> L40
        r4.put("is_version", r12);     // Catch: Throwable -> L40
        r4.put("edition_id", r13);     // Catch: Throwable -> L40
        r4.put("is_blank_webview", this.k);     // Catch: Throwable -> L40
        c(r4);     // Catch: Throwable -> L40
        a(r4);     // Catch: Throwable -> L40
        b(r4);     // Catch: Throwable -> L40
        d(r4, r16);     // Catch: Throwable -> L40
        String r18 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L40
        if (r18 == null) goto L35;
        String r19 = (String) r9.get("timestamp");     // Catch: Throwable -> L40
        if (r19 == null) goto L33;
        r4.put("cost_time", CastLongProtector.parseLong(r19) - CastLongProtector.parseLong(r18));     // Catch: Throwable -> L40
    L34:
        f(r4, r18);     // Catch: Throwable -> L40
        goto L35
    L33:
        r4.put("cost_time", System.currentTimeMillis() - CastLongProtector.parseLong(r18));     // Catch: Throwable -> L40
    L35:
        this.b.c("start_open");     // Catch: Throwable -> L40
        this.b.c("render_cache");     // Catch: Throwable -> L40
        com.bytedance.ee.bear.contract.d r20 = this.b;     // Catch: Throwable -> L40
        int r110 = c.a;     // Catch: Throwable -> L40
        r20.a("dev_performance_doc_open_finish", r4);     // Catch: Throwable -> L40
        tt5.a.d("DocReport", "***reportOpenDoc*** Failed : " + r4 + "    performanceTiming:  " + r14.getPerformanceTiming());     // Catch: Throwable -> L40
        return;
    L26:
        r17 = "render";
        goto L27
    L20:
        if (StringsKt.contains$default(this.c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed Filter the internal test package of the debug package name");     // Catch: Throwable -> L40
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(int r17, boolean r18, String r19, int r20, String r21, DocBridgeWebViewV2 r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r19, "tag");
        Intrinsics.checkNotNullParameter(r22, "webview");
    L47:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (eu5.i.b() == false) goto L6;
    L45:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  isWifiProxy");     // Catch: Throwable -> L47
        return;
    L6:
        if (eu5.i.a() == true) goto L45;
        if (r22.K2 == true) goto L11;
    L43:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  Render not Open");     // Catch: Throwable -> L47
        return;
    L11:
        if (r22.M2 == false) goto L43;
        if (TextUtils.isEmpty(d25.d.d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  no token");     // Catch: Throwable -> L47
        return;
    L18:
        if (this.c.getPackageName() != null) goto L20;
    L23:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L47
        r8.put("docs_result_key", "overtime");     // Catch: Throwable -> L47
        r8.put("docs_result_code", r17);     // Catch: Throwable -> L47
        r8.put("file_type", d25.d.g);     // Catch: Throwable -> L47
        r8.put("sub_type", d25.d.h);     // Catch: Throwable -> L47
        if (r18 == false) goto L26;
        String r10 = "preload";
    L27:
        r8.put("docs_open_type", r10);     // Catch: Throwable -> L47
        int r9 = b.a;     // Catch: Throwable -> L47
        if (r17 != 100) goto L31;
        o();     // Catch: Throwable -> L47
    L33:
        r8.put("wait_preload_template_time", this.h);     // Catch: Throwable -> L47
        r8.put("wait_resource_time", this.i);     // Catch: Throwable -> L47
        r8.put("open_tag", r19);     // Catch: Throwable -> L47
        r8.put("version_type", this.e);     // Catch: Throwable -> L47
        r8.put("enable_x5", this.f);     // Catch: Throwable -> L47
        r8.put("scm_version", ow4.a.a);     // Catch: Throwable -> L47
        r8.put("file_id", du5.b.g(d25.d.d));     // Catch: Throwable -> L47
        r8.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L47
        r8.put("doc_has_cache", r);     // Catch: Throwable -> L47
        r8.put("doc_from", o);     // Catch: Throwable -> L47
        r8.put("doc_sub_from", p);     // Catch: Throwable -> L47
        r8.put("open_doc_desc", q);     // Catch: Throwable -> L47
        boolean r2 = true;
        r8.put("preload_html_enabled", 1);     // Catch: Throwable -> L47
        r8.put("doc_webview_status_code", Long.valueOf(r22.getWebviewStatusCode()));     // Catch: Throwable -> L47
        int r0 = r22.getVisibility();     // Catch: Throwable -> L47
        int r11 = r22.getWindowVisibility();     // Catch: Throwable -> L47
        boolean r12 = this.d.a();     // Catch: Throwable -> L47
        if (r0 != 0) goto L38;
        if (r11 != 0) goto L38;
        if (r12 == false) goto L38;
    L39:
        r8.put("app_visible", r2);     // Catch: Throwable -> L47
        r8.put("isLarkWebview", n);     // Catch: Throwable -> L47
        r8.put("opening_count", l35.k.b);     // Catch: Throwable -> L47
        r8.put("doc_has_info_cache", B);     // Catch: Throwable -> L47
        r8.put("is_version", r20);     // Catch: Throwable -> L47
        r8.put("edition_id", r21);     // Catch: Throwable -> L47
        r8.put("is_blank_webview", this.k);     // Catch: Throwable -> L47
        c(r8);     // Catch: Throwable -> L47
        b(r8);     // Catch: Throwable -> L47
        d(r8, r23);     // Catch: Throwable -> L47
        String r3 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L47
        if (r3 == null) goto L42;
        r8.put("cost_time", System.currentTimeMillis() - CastLongProtector.parseLong(r3));     // Catch: Throwable -> L47
        f(r8, r3);     // Catch: Throwable -> L47
    L42:
        this.b.c("start_open");     // Catch: Throwable -> L47
        this.b.c("render_cache");     // Catch: Throwable -> L47
        com.bytedance.ee.bear.contract.d r4 = this.b;     // Catch: Throwable -> L47
        int r5 = c.a;     // Catch: Throwable -> L47
        r4.a("dev_performance_doc_open_finish", r8);     // Catch: Throwable -> L47
        tt5.a.d("DocReport", "***reportOpenDoc*** Overtime : " + r8 + "    performanceTiming:  " + r22.getPerformanceTiming() + "    visibility:  " + r0 + "    windowVisibility:  " + r11 + "    appIsVisible:  " + r12);     // Catch: Throwable -> L47
        return;
    L38:
        r2 = false;
        goto L39
    L31:
        if (r17 != 101) goto L33;
        n();     // Catch: Throwable -> L47
        goto L33
    L26:
        r10 = "render";
        goto L27
    L20:
        if (StringsKt.contains$default(this.c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime Filter the internal test package of the debug package name");     // Catch: Throwable -> L47
    }
}
