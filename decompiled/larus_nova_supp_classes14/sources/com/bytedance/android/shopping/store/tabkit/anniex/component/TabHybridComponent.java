package com.bytedance.android.shopping.store.tabkit.anniex.component;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.hybrid.prefetch.q;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService;
import com.bytedance.android.shopping.store.tabkit.MallSessionMonitor;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.view.TabRootView;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetch;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.ssr.d;
import com.bytedance.android.shopping.store.utils.f;
import com.bytedance.android.shopping.store.utils.g;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.q1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabHybridComponent {
    public static final /* synthetic */ int k = 0;
    public jk3.a a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final AtomicInteger e;
    public boolean f;
    public boolean g;
    public final TabHybridComponent$prefetchCallbackV2$1 h;
    public final TabHybridComponent$prefetchCallback$1 i;
    public final TabKitAnnieXTabFragment j;

    public static final class a {
    }

    public static final class b extends IECAnnieXLynxLifecycle.Base {
        public final /* synthetic */ TabHybridComponent a;

        public b(TabHybridComponent r1) {
            this.a = r1;
        }

        public final void onLoadUriSuccess(Uri r3, View r4) {
            super.onLoadUriSuccess(r3, r4);
            TabRootView r5 = this.a.f();
            if (r5 == null) goto L7;
            StatusView r6 = r5.getStatusView();
            if (r6 == null) goto L7;
            r6.reset();
        L7:
            this.a.b();
            int r7 = lk3.a.a;
            TabHybridComponent r8 = this.a;
            r8.getClass();
            String r9 = r8.e();
            Intrinsics.checkNotNullParameter(r9, "type");
            lk3.a.b(null, r9, true, null);
        }

        public final void onTemplateReady(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "resFrom");
            super.onTemplateReady(r2, r3);
            v r4 = this.a.h();
            if (r4 == null) goto L6;
            r4.d = r2;
        L6:
            if (this.a.j.isLandingTab() == true) goto L13;
            kk3.a r5 = this.a.c();
            if (r5 == null) goto L14;
            Intrinsics.checkNotNullParameter("t_render_tab_end", "key");
            TabkitSwitchTabPref r6 = r5.a();
            if (r6 == null) goto L15;
            r6.recordTime("t_render_tab_end", null);
            return;
        L15:
            return;
        L14:
            return;
        }

        public final void onLoadFailed(View r3, int r4, String r5) {
            super.onLoadFailed(r3, r4, r5);
            int r6 = this.a.e.get();
            if (r6 == 1) goto L7;
            if (r6 != 2) goto L22;
            this.a.j(d.a(309, r5, Integer.valueOf(r4)));
            return;
        L22:
            return;
        L7:
            TabRootView r7 = this.a.f();
            if (r7 == null) goto L12;
            StatusView r8 = r7.getStatusView();
            if (r8 == null) goto L12;
            r8.setVisibility(0);
            r8.setECStatus(2);
        L12:
            this.a.b();
            if (this.a.j.isLandingTab() == false) goto L19;
            kk3.a r9 = this.a.c();
            if (r9 == null) goto L19;
            ok3.a r10 = r9.b().getTabKitMonitor();
            if (r10 == null) goto L19;
            r10.e(3, null, null);
        L19:
            int r11 = lk3.a.a;
            this.a.getClass();
            Intrinsics.checkNotNullParameter("csr", "type");
            lk3.a.b(null, "csr", false, null);
        }
    }

    public static final class c extends q1 {
        public final /* synthetic */ TabHybridComponent a;

        public final void onFirstScreen() {
            super.onFirstScreen();
            int r0 = lk3.a.a;
            TabHybridComponent r1 = this.a;
            r1.getClass();
            String r2 = r1.e();
            boolean r3 = this.a.f;
            Intrinsics.checkNotNullParameter(r2, "type");
            lk3.a.c(null, r2, "first_screen", r3);
        }

        public final void onLoadSuccess() {
            super.onLoadSuccess();
            if (this.a.i() == false) goto L10;
            Lazy r0 = MallSessionMonitor.a;
            String r1 = this.a.g().getRouterParams().getAnchorUrl();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            double r2 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r1, "schema");
            IMallSessionService r3 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r3 == null) goto L10;
            r3.a("finish_load_main_url", r1, r2);
        L10:
            kk3.a r4 = this.a.c();
            if (r4 == null) goto L13;
            r4.c(TabkitSwitchTabPref.T_TAB_CONTAINER_LOAD_SUCCESS, null);
        L13:
            TabHybridComponent r5 = this.a;
            if (r5.b == true) goto L16;
            return;
        L16:
            if (r5.c == false) goto L18;
            jk3.a r6 = r5.a;
            String r7 = r6.c;
            String r8 = r6.d;
            ConcurrentHashMap r9 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(r7, r8, r5.h);
            return;
        L18:
            jk3.a r10 = r5.a;
            if (r10.a == false) goto L24;
            String r11 = r10.c;
            String r12 = r10.d;
            ConcurrentHashMap r13 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(r11, r12, r5.i);
            return;
        }

        public final void onLynxViewAndJSRuntimeDestroy() {
            super.onLynxViewAndJSRuntimeDestroy();
            TabHybridComponent r0 = this.a;
            if (r0.c == false) goto L5;
        L6:
            jk3.a r1 = r0.a;
            String r2 = r1.c;
            String r3 = r1.d;
            ConcurrentHashMap r4 = NativePrefetchUtil.a;
            NativePrefetchUtil.o(r2, r3);
            return;
        L5:
            if (r0.a.a == true) goto L6;
        }

        public final void onRuntimeReady() {
            super.onRuntimeReady();
            if (this.a.i() == false) goto L10;
            Lazy r0 = MallSessionMonitor.a;
            String r1 = this.a.g().getRouterParams().getAnchorUrl();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            double r2 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r1, "schema");
            IMallSessionService r3 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r3 == null) goto L10;
            r3.a("lynx_js_runtime_ready", r1, r2);
        L10:
            kk3.a r4 = this.a.c();
            if (r4 == null) goto L13;
            r4.c(TabkitSwitchTabPref.T_TAB_CONTAINER_RUNTIME_READY, null);
        L13:
            TabHybridComponent r5 = this.a;
            if (r5.b == false) goto L16;
        L21:
            int r6 = lk3.a.a;
            TabHybridComponent r7 = this.a;
            r7.getClass();
            String r8 = r7.e();
            boolean r9 = this.a.f;
            Intrinsics.checkNotNullParameter(r8, "type");
            lk3.a.c(null, r8, "runtime_ready", r9);
            return;
        L16:
            if (r5.c == false) goto L18;
            jk3.a r10 = r5.a;
            String r11 = r10.c;
            String r12 = r10.d;
            ConcurrentHashMap r13 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(r11, r12, r5.h);
            goto L21
        L18:
            jk3.a r14 = r5.a;
            if (r14.a == false) goto L21;
            String r15 = r14.c;
            String r16 = r14.d;
            ConcurrentHashMap r17 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(r15, r16, r5.i);
            goto L21
        }

        public c(TabHybridComponent r1) {
            this.a = r1;
        }

        public final void onReceivedError(LynxError r7) {
            super.onReceivedError(r7);
            Integer r0 = null;
            boolean r1 = false;
            if (r7 == null) goto L23;
            LynxEnv r2 = LynxEnv.inst();
            if (r2 == null) goto L17;
            String r3 = r2.getLynxVersion();
            if (r3 == null) goto L17;
            if (StringsKt.startsWith$default(r3, "2", false, 2, null) != true) goto L17;
            int r4 = r7.getErrorCode();
            if (10001 > r4) goto L23;
            if (10099 < r4) goto L23;
        L22:
            r1 = true;
        L17:
            int r5 = r7.getErrorCode();
            if (1400 > r5) goto L23;
            if (1499 >= r5) goto L22;
        L23:
            if (r1 == false) goto L32;
            TabHybridComponent r6 = this.a;
            if (r7 == null) goto L27;
            String r8 = r7.getMsg();
        L28:
            if (r7 == null) goto L30;
            r0 = Integer.valueOf(r7.getErrorCode());
        L30:
            r6.j(d.a(308, r8, r0));
            return;
        L27:
            r8 = null;
            goto L28
        }

        public final void onTimingSetup(Map<String, Object> r5) {
            if (this.a.i() == false) goto L13;
            TabHybridComponent r6 = this.a;
            if (r6.g == true) goto L14;
            r6.g = true;
            Lazy r0 = MallSessionMonitor.a;
            String r7 = r6.g().getRouterParams().getAnchorUrl();
            if (r7 != null) goto L9;
            r7 = "";
        L9:
            double r1 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r7, "schema");
            IMallSessionService r2 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r2 == null) goto L15;
            r2.a("lynx_first_setup", r7, r1);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    static {
    }

    public final LynxView b() {
        Object r0 = null;
        boolean r1 = r0 instanceof LynxView;
        LynxView r2 = (LynxView) null;
        return null;
    }

    public final void j(Map<String, String> r1) {
    }

    private final Context getContext() {
        return this.j.getContext();
    }

    public final void a() {
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L5;
        r0.n();
    L5:
        k r3 = this.j.getTab();
        if (r3 != null) goto L8;
        return;
    L8:
        FragmentActivity r4 = getContext();
        if (r4 != null) goto L11;
        return;
    L11:
        s r1 = r3.f();
        if (r1 == null) goto L211;
        String r5 = r1.b();
        if (r5 == null) goto L214;
        boolean r6 = e.l(r3);
        if (r6 == true) goto L19;
        return;
    L19:
        kk3.a r2 = c();
        if (r2 == null) goto L22;
        r2.c("t_tab_container_init_start", null);
    L22:
        ok3.a r7 = g().getTabKitMonitor();
        if (r7 == null) goto L25;
        r7.g(this.j.getTabId(), this.j.isLandingTab());
    L25:
        Integer r8 = r3.n();
        if (r8 == null) goto L31;
        int r9 = r8.intValue();
        SparseArray<Long> r10 = com.bytedance.android.shopping.store.tabkit.k.b;
        if (r10.get(r9) != null) goto L31;
        r10.put(r9, Long.valueOf(System.currentTimeMillis()));
    L31:
        if (g().getAbilityConfig().b("na_prefetch_opt") == false) goto L33;
        Map<String, Long> r11 = TabkitPrefetch.a;
        TabkitPrefetch.c(g().getRouterParams().getBizTag());
    L33:
        boolean r12 = g().getAbilityConfig().b("na_prefetch_thread_opt");
        boolean r13 = g().getAbilityConfig().b("na_prefetch_sync_update");
        boolean r15 = true;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L47
        Uri r16 = UriProtector.parse(r5);     // Catch: Throwable -> L47
        Uri.Builder r17 = r16.buildUpon();     // Catch: Throwable -> L47
        if (r13 == false) goto L45;
        String r18 = UriProtector.getQueryParameter(r16, "na_prefetch_sync_update");     // Catch: Throwable -> L47
        if (r18 != null) goto L39;
    L42:
        boolean r19 = true;
    L43:
        if (r19 == false) goto L45;
        r17.appendQueryParameter("na_prefetch_sync_update", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L47
        goto L45
    L39:
        if (StringsKt.isBlank(r18) == true) goto L42;
        r19 = false;
    L45:
        r5 = r17.build().toString();     // Catch: Throwable -> L47
    L49:
        this.c = hk3.b.c(r5);
        this.d = hk3.b.e(r5);
        Map<String, Long> r20 = TabkitPrefetch.a;
        if (r13 == false) goto L52;
    L55:
        boolean r110 = true;
    L56:
        String r21 = TabkitPrefetch.a(r5, true, null, r12, r110, 36).a;
        int r22 = jk3.a.e;
        Intrinsics.checkNotNullParameter(r21, "url");
        Uri r23 = UriProtector.parse(r21);     // Catch: Throwable -> L63
        jk3.a r24 = new jk3.a();     // Catch: Throwable -> L63
        r24.a = Intrinsics.areEqual(UriProtector.getQueryParameter(r23, "na_prefetch_sync_update"), CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L63
        r24.c = UriProtector.getQueryParameter(r23, "ec_request_id");     // Catch: Throwable -> L63
        r24.d = UriProtector.getQueryParameter(r23, "ec_prefetch_api_key");     // Catch: Throwable -> L63
        r24.b = UriProtector.getQueryParameter(r23, "ec_prefetch_bff_flag");     // Catch: Throwable -> L63
        r23.getBooleanQueryParameter("tabkit_bridge_v2", false);     // Catch: Throwable -> L63
        UriProtector.getQueryParameter(r23, "ec_ssr_request_id");     // Catch: Throwable -> L63
        String r25 = UriProtector.getQueryParameter(r23, "na_prefetch_strategy");     // Catch: Throwable -> L63
        if (r25 == null) goto L65;
        Integer r26 = StringsKt.toIntOrNull(r25);     // Catch: Throwable -> L63
        if (r26 == null) goto L65;
        r26.intValue();     // Catch: Throwable -> L63
    L65:
        if (r24 == null) goto L68;
        this.a = r24;
    L68:
        if (this.a.a == true) goto L72;
        if (this.c == true) goto L72;
    L76:
        HashMap r27 = new HashMap();
        TabKitRouterParams r28 = g().getRouterParams();
        if (r28 == null) goto L79;
        HashMap<String, String> r29 = r28.getParamsMap();
    L81:
        if ((r29 instanceof Map) == true) goto L83;
        r29 = null;
    L83:
        JSONObject r30 = new JSONObject(r29);
        int r31 = !g().isAnchorFinished() ? 1 : 0;
        HashMap r111 = new HashMap();
        r111.put("frame_data", GsonProtectorUtils.toJson(new Gson(), g().getTabResponse().getValue()));
        r111.put("tab_data", GsonProtectorUtils.toJson(new Gson(), this.j.getTab()));
        r111.put("router_params", r30);
        r111.put("screen_state", g().getScreenState().getValue());
        r111.put("monitor_enter_type", Integer.valueOf(r31 ^ 1));
        if (r31 == 0) goto L86;
        r111.put("monitor_page_begin_time", com.bytedance.android.shopping.store.tabkit.k.a);
        g().setAnchorFinished(true);
    L86:
        Long r32 = com.bytedance.android.shopping.store.tabkit.k.a;
        k r33 = this.j.getTab();
        if (r33 == null) goto L89;
        Integer r34 = r33.n();
    L90:
        r111.put("monitor_tab_begin_time", com.bytedance.android.shopping.store.tabkit.k.a(r34));
        r27.put("meta_info", r111);
        r27.put("tabs_container_id", g().getTabsContainerId());
        boolean r35 = this.c;
        if (r35 == false) goto L108;
        if (r35 == false) goto L97;
        jk3.a r36 = this.a;
        String r37 = r36.c;
        String r38 = r36.d;
        ConcurrentHashMap r112 = NativePrefetchUtil.a;
        String r39 = NativePrefetchUtil.d(r37, r38);
        if (r39 == null) goto L97;
        Map<String, Object> r40 = f.c(r39);
    L98:
        if (r40 == null) goto L137;
        k();
        r27.put("na_prefetch_inject_raw", r40);
        r27.put("na_prefetch_inject_info", d());
        long r113 = System.currentTimeMillis();
        kk3.a r41 = c();
        if (r41 == null) goto L102;
        r41.c(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, Long.valueOf(r113));
    L102:
        kk3.a r42 = c();
        if (r42 == null) goto L105;
        r42.c(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, Long.valueOf(r113));
    L105:
        v r43 = h();
        if (r43 == null) goto L137;
        r43.e = "init_data";
    L137:
        Fragment r44 = this.j.getParentFragment();
        if (r44 == null) goto L140;
        Fragment r45 = r44.getParentFragment();
    L142:
        if ((r45 instanceof TabKitDialogFragment) == true) goto L144;
        r45 = null;
    L144:
        TabKitDialogFragment r46 = (TabKitDialogFragment) r45;
        if (r46 == null) goto L148;
        Lifecycle r47 = r46.getLifecycle();
        if (r47 == null) goto L148;
    L159:
        if (r47 == null) goto L161;
    L167:
        kk3.a r48 = c();
        if (r48 == null) goto L170;
        r48.c(TabkitSwitchTabPref.T_TAB_CHECK_ENV_START_TIME, null);
    L170:
        int r49 = ECSdk.a;
        IECHostService r50 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r50 == null) goto L173;
        r50.getECAnnieXHostService();
    L173:
        kk3.a r51 = c();
        if (r51 == null) goto L176;
        r51.c(TabkitSwitchTabPref.T_TAB_CHECK_ENV_END_TIME, null);
    L176:
        FrameLayout r52 = new FrameLayout(r4);
        r52.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        TabRootView r53 = f();
        if (r53 == null) goto L180;
        r53.addView(r52);
    L180:
        if (hk3.b.a(r21) == false) goto L182;
    L185:
        if (r15 == false) goto L187;
        r21 = n.a(r21);
    L187:
        IECHostService r54 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r54 == null) goto L190;
        r54.getECAnnieXHostService();
    L190:
        StringBuilder r55 = new StringBuilder("createAnnieXLynxComponent return null, type:");
        s r56 = r3.f();
        if (r56 == null) goto L193;
        Integer r57 = r56.d();
    L194:
        r55.append(r57);
        ECExceptionMonitor.c(r55.toString());
        int r58 = lk3.a.a;
        if (r6 == false) goto L197;
        String r59 = "lynx";
    L198:
        lk3.a.a(r21, r59, false);
        kk3.a r60 = c();
        if (r60 == null) goto L201;
        r60.c("t_tab_container_init_end", null);
    L201:
        TabRootView r61 = f();
        if (r61 == null) goto L212;
        FrameLayout r62 = r61.getTitleContainer();
        if (r62 == null) goto L213;
        r62.bringToFront();
        return;
    L213:
        return;
    L212:
        return;
    L197:
        r59 = "web";
        goto L198
    L193:
        r57 = null;
        goto L194
    L182:
        if (hk3.b.b(r21) == true) goto L185;
        r15 = false;
        goto L185
    L161:
        if ((r4 instanceof FragmentActivity) == true) goto L163;
        FragmentActivity r63 = null;
    L164:
        FragmentActivity r64 = r63;
        if (r64 == null) goto L167;
        r64.getLifecycle();
        goto L167
    L163:
        r63 = r4;
    L148:
        Fragment r65 = this.j.getParentFragment();
        if (r65 == null) goto L151;
        Fragment r66 = r65.getParentFragment();
    L153:
        if ((r66 instanceof TabKitFoldFragment) == true) goto L155;
        r66 = null;
    L155:
        TabKitFoldFragment r67 = (TabKitFoldFragment) r66;
        if (r67 == null) goto L158;
        r47 = r67.getLifecycle();
        goto L159
    L158:
        r47 = null;
        goto L159
    L151:
        r66 = null;
        goto L153
    L140:
        r45 = null;
    L97:
        r40 = null;
        goto L98
    L108:
        jk3.a r68 = this.a;
        boolean r114 = r68.a;
        if (r114 == false) goto L137;
        if (r114 == false) goto L126;
        String r115 = r68.c;
        String r116 = r68.d;
        String r69 = r68.b;
        ConcurrentHashMap r117 = NativePrefetchUtil.a;
        String r118 = NativePrefetchUtil.d(r115, r116);
        if (r118 == null) goto L126;
        Map<String, Object> r119 = f.c(r118);
        if (r119 == null) goto L126;
        if (r69 == null) goto L126;
        Object r70 = r119.get(r69);
        if (r70 == null) goto L126;
        if (Intrinsics.areEqual(r70, CommentScene.COMMENTSCENE_NO_AWEME) == true) goto L124;
        r70 = null;
    L124:
        if (r70 == null) goto L126;
    L127:
        if (r119 == null) goto L137;
        k();
        r27.putAll(r119);
        long r120 = System.currentTimeMillis();
        kk3.a r71 = c();
        if (r71 == null) goto L131;
        r71.c(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, Long.valueOf(r120));
    L131:
        kk3.a r72 = c();
        if (r72 == null) goto L134;
        r72.c(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, Long.valueOf(r120));
    L134:
        v r73 = h();
        if (r73 == null) goto L137;
        r73.e = "init_data";
    L126:
        r119 = null;
        goto L127
    L89:
        r34 = null;
        goto L90
    L79:
        r29 = null;
    L72:
        if (hk3.b.f(r21) <= 0) goto L74;
        boolean r74 = true;
    L75:
        this.b = r74;
        goto L76
    L74:
        r74 = false;
    L63:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r24 = null;
        goto L65
    L52:
        if (this.c == true) goto L55;
        r110 = false;
    L47:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L214:
        return;
    }

    public final kk3.a c() {
        return this.j.getMonitor();
    }

    public final Map<String, Object> d() {
        if (this.c == true) goto L6;
        return null;
    L6:
        jk3.a r0 = this.a;
        String r1 = r0.c;
        String r2 = r0.d;
        LinkedHashMap r3 = new LinkedHashMap();
        ConcurrentHashMap r4 = NativePrefetchUtil.a;
        q r5 = NativePrefetchUtil.h(r1, r2);
        if (r5 == null) goto L9;
        r3.put("perf_timing", r5.a());
        r3.put("net_detail", r5.a);
    L9:
        JSONObject r6 = NativePrefetchUtil.g(r1, r2);
        if (r6 == null) goto L12;
        r3.put("extra_info", r6);
    L12:
        return r3;
    }

    public final String e() {
        int r0 = this.e.get();
        if (r0 != 1) goto L5;
        return "csr";
    L5:
        if (r0 == 2) goto L7;
        return CommentPublishScene.UNKNOWN;
    L7:
        return "ssr";
    }

    public final TabRootView f() {
        return this.j.getRootView();
    }

    public final TabKitViewModel g() {
        return this.j.getTabKitViewModel();
    }

    public final v h() {
        return this.j.getTabState();
    }

    public final void k() {
        jk3.a r0 = this.a;
        String r1 = r0.c;
        String r2 = r0.d;
        ConcurrentHashMap r3 = NativePrefetchUtil.a;
        q r4 = NativePrefetchUtil.h(r1, r2);
        if (r4 == null) goto L22;
        Long r5 = r4.c();
        if (r5 == null) goto L9;
        long r6 = r5.longValue();
        kk3.a r7 = c();
        if (r7 == null) goto L9;
        r7.c(TabkitSwitchTabPref.T_TAB_NET_START_TIME, Long.valueOf(r6));
    L9:
        Long r8 = r4.b();
        if (r8 == null) goto L14;
        long r9 = r8.longValue();
        kk3.a r10 = c();
        if (r10 == null) goto L14;
        r10.c(TabkitSwitchTabPref.T_TAB_NET_END_TIME, Long.valueOf(r9));
    L14:
        JSONObject r11 = r4.a();
        v r12 = h();
        if (r12 == null) goto L17;
        r12.a = r11;
    L17:
        JSONObject r13 = r4.a;
        if (r13 == null) goto L22;
        v r14 = h();
        if (r14 == null) goto L22;
        r14.b = r13;
    L22:
        JSONObject r15 = NativePrefetchUtil.g(r1, r2);
        if (r15 == null) goto L28;
        v r16 = h();
        if (r16 == null) goto L29;
        r16.c = r15;
        return;
    L29:
        return;
    }

    public final boolean i() {
        Integer r0 = g().getAnchorTabId();
        k r1 = this.j.getTab();
        if (r1 == null) goto L5;
        Integer r2 = r1.n();
    L7:
        return Intrinsics.areEqual(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    public TabHybridComponent(TabKitAnnieXTabFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "tabFragment");
        this.j = r2;
        this.a = new jk3.a();
        this.e = new AtomicInteger(0);
        new c(this);
        new b(this);
        this.h = new TabHybridComponent$prefetchCallbackV2$1(this);
        this.i = new TabHybridComponent$prefetchCallback$1(this);
    }

    public final void l(Pair<Integer, Integer> r4) {
        if (g().isFoldPage() == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        int r5 = TabKitFoldFragment.f;
        TabKitFoldFragment.a.a(this.j.getActivity());
        r4 = null;
    L7:
        if (r4 == null) goto L20;
        LinkedHashMap r0 = new LinkedHashMap();
        g.a(r0, "ec_split_screen_width", com.bytedance.android.shopping.extensions.b.f((Number) r4.getFirst()));
        String r1 = g().getFoldType();
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        g.a(r0, "split_screen_type", r1);
        g.a(r0, "is_split", Boolean.TRUE);
        b();
        b();
        TabRootView r2 = f();
        if (r2 == null) goto L16;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L16;
        r3.width = ((Number) r4.getFirst()).intValue();
    L16:
        TabRootView r6 = f();
        if (r6 == null) goto L21;
        r6.requestLayout();
        return;
    L21:
        return;
    }
}
