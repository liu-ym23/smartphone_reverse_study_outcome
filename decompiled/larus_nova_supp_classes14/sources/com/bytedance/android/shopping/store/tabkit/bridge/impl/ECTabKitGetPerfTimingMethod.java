package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.cache.TabKitRouterCache;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.monitor.TabKitAppMonitor;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.android.shopping.store.utils.f;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n83.h;
import ok3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitGetPerfTimingMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitGetPerfTimingMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final HashMap<String, Integer> f;
    public final TabKitBridge g;

    public final String getName() {
        return "ecTabKitGetPerfTiming";
    }

    public final JSONObject d(JSONObject r12) {
        String r13 = r12.optString("perf_flag", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        Integer r0 = this.f.get(r13);
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        int r1 = r0.intValue() + 1;
        this.f.put(r13, Integer.valueOf(r1));
        JSONObject r14 = new JSONObject();
        Integer r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        String r5 = this.g.e.getRouterParams().getAnchorUrl();     // Catch: Throwable -> L19
        boolean r6 = ECServiceManager.a;     // Catch: Throwable -> L19
        h r7 = ((IEShoppingService) ECServiceManager.c(IEShoppingService.class)).getMallService();     // Catch: Throwable -> L19
        if (r7 == null) goto L9;
        r7.b();     // Catch: Throwable -> L19
    L9:
        JSONObject r8 = TabKitRouterCache.c(r5);     // Catch: Throwable -> L19
        if (r8 != null) goto L372;
        Result r9 = null;
    L17:
        Result.constructor-impl(r9);     // Catch: Throwable -> L19
    L370:
        TabKitViewModel r10 = this.g.e;     // Catch: Throwable -> L130
        a r11 = r10.getTabKitMonitor();     // Catch: Throwable -> L130
        if (r11 == null) goto L24;
        TabkitFirstFramePref r15 = r11.d;     // Catch: Throwable -> L130
    L25:
        k r16 = this.e;     // Catch: Throwable -> L130
        if (r16 != null) goto L28;
    L30:
        a r17 = r10.getTabKitMonitor();     // Catch: Throwable -> L130
        if (r17 == null) goto L39;
        k r18 = this.e;     // Catch: Throwable -> L130
        if (r18 == null) goto L37;
        Integer r19 = r18.n();     // Catch: Throwable -> L130
        if (r19 == null) goto L37;
        int r20 = r19.intValue();     // Catch: Throwable -> L130
    L38:
        Map r21 = r17.c(r20);     // Catch: Throwable -> L130
    L40:
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L130
        if (r15 == null) goto L44;
        Long r23 = (Long) r15.get(TabkitFirstFramePref.T_PAGE_ROUTE_START);     // Catch: Throwable -> L130
    L45:
        r22.putOpt(TabkitFirstFramePref.T_PAGE_ROUTE_START, r23);     // Catch: Throwable -> L130
        if (r15 == null) goto L49;
        Long r24 = (Long) r15.get(TabkitFirstFramePref.T_PAGE_INIT_START);     // Catch: Throwable -> L130
    L50:
        r22.putOpt(TabkitFirstFramePref.T_PAGE_INIT_START, r24);     // Catch: Throwable -> L130
        if (r15 == null) goto L54;
        Long r25 = (Long) r15.get(TabkitFirstFramePref.T_PAGE_INIT_END);     // Catch: Throwable -> L130
    L55:
        r22.putOpt(TabkitFirstFramePref.T_PAGE_INIT_END, r25);     // Catch: Throwable -> L130
        if (r15 == null) goto L59;
        Long r26 = (Long) r15.get(TabkitFirstFramePref.T_REQUEST_START);     // Catch: Throwable -> L130
    L60:
        r22.putOpt(TabkitFirstFramePref.T_REQUEST_START, r26);     // Catch: Throwable -> L130
        if (r15 == null) goto L64;
        Long r27 = (Long) r15.get(TabkitFirstFramePref.T_REQUEST_END);     // Catch: Throwable -> L130
    L65:
        r22.putOpt(TabkitFirstFramePref.T_REQUEST_END, r27);     // Catch: Throwable -> L130
        if (r15 == null) goto L69;
        Long r28 = (Long) r15.get("t_start_pre_create_annie");     // Catch: Throwable -> L130
    L70:
        r22.putOpt("t_start_pre_create_annie", r28);     // Catch: Throwable -> L130
        if (r15 == null) goto L74;
        Long r29 = (Long) r15.get("t_finish_pre_create_annie_model");     // Catch: Throwable -> L130
    L75:
        r22.putOpt("t_finish_pre_create_annie_model", r29);     // Catch: Throwable -> L130
        if (r15 == null) goto L79;
        Long r30 = (Long) r15.get("t_finish_pre_create_annie_web");     // Catch: Throwable -> L130
    L80:
        r22.putOpt("t_finish_pre_create_annie_web", r30);     // Catch: Throwable -> L130
        if (r21 == null) goto L84;
        Long r110 = (Long) r21.get("t_tab_click_time");     // Catch: Throwable -> L130
    L85:
        r22.putOpt("t_tab_click_time", r110);     // Catch: Throwable -> L130
        if (r21 == null) goto L89;
        Long r111 = (Long) r21.get("t_tab_init");     // Catch: Throwable -> L130
    L90:
        r22.putOpt("t_tab_init", r111);     // Catch: Throwable -> L130
        if (r21 == null) goto L94;
        Long r112 = (Long) r21.get(TabkitSwitchTabPref.T_TAB_CHECK_ENV_START_TIME);     // Catch: Throwable -> L130
    L95:
        r22.putOpt(TabkitSwitchTabPref.T_TAB_CHECK_ENV_START_TIME, r112);     // Catch: Throwable -> L130
        if (r21 == null) goto L99;
        Long r113 = (Long) r21.get(TabkitSwitchTabPref.T_TAB_CHECK_ENV_END_TIME);     // Catch: Throwable -> L130
    L100:
        r22.putOpt(TabkitSwitchTabPref.T_TAB_CHECK_ENV_END_TIME, r113);     // Catch: Throwable -> L130
        if (r21 == null) goto L104;
        Long r114 = (Long) r21.get("t_tab_container_init_start");     // Catch: Throwable -> L130
    L105:
        r22.putOpt("t_tab_container_init_start", r114);     // Catch: Throwable -> L130
        if (r21 == null) goto L109;
        Long r115 = (Long) r21.get("t_tab_container_init_end");     // Catch: Throwable -> L130
    L110:
        r22.putOpt("t_tab_container_init_end", r115);     // Catch: Throwable -> L130
        if (r21 == null) goto L113;
        Long r31 = (Long) r21.get("t_finish_pre_create_annie_model");     // Catch: Throwable -> L130
    L114:
        r22.putOpt("t_finish_pre_create_annie_model", r31);     // Catch: Throwable -> L130
        if (r21 == null) goto L117;
        Long r32 = (Long) r21.get("t_finish_pre_create_annie_web");     // Catch: Throwable -> L130
    L118:
        r22.putOpt("t_finish_pre_create_annie_web", r32);     // Catch: Throwable -> L130
        if (r21 == null) goto L122;
        Long r33 = (Long) r21.get(TabkitSwitchTabPref.T_TAB_CONTAINER_LOAD_SUCCESS);     // Catch: Throwable -> L130
    L123:
        r22.putOpt(TabkitSwitchTabPref.T_TAB_CONTAINER_LOAD_SUCCESS, r33);     // Catch: Throwable -> L130
        if (r21 == null) goto L127;
        Long r34 = (Long) r21.get(TabkitSwitchTabPref.T_TAB_CONTAINER_RUNTIME_READY);     // Catch: Throwable -> L130
    L128:
        r22.putOpt(TabkitSwitchTabPref.T_TAB_CONTAINER_RUNTIME_READY, r34);     // Catch: Throwable -> L130
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L130
        Result.constructor-impl(r14.putOpt("tabkit_container_timing", r22));     // Catch: Throwable -> L130
    L364:
        TabKitViewModel r36 = this.g.e;     // Catch: Throwable -> L187
        k r37 = this.e;     // Catch: Throwable -> L187
        if (r37 != null) goto L135;
    L139:
        a r38 = r36.getTabKitMonitor();     // Catch: Throwable -> L187
        if (r38 == null) goto L148;
        k r39 = this.e;     // Catch: Throwable -> L187
        if (r39 == null) goto L146;
        Integer r40 = r39.n();     // Catch: Throwable -> L187
        if (r40 == null) goto L146;
        int r41 = r40.intValue();     // Catch: Throwable -> L187
    L147:
        Map r42 = r38.c(r41);     // Catch: Throwable -> L187
    L149:
        k r43 = this.e;     // Catch: Throwable -> L187
        if (r43 == null) goto L152;
        Integer r44 = r43.n();     // Catch: Throwable -> L187
    L153:
        v r45 = r36.getTabState(r44);     // Catch: Throwable -> L187
        JSONObject r46 = new JSONObject();     // Catch: Throwable -> L187
        if (r42 == null) goto L157;
        Long r47 = (Long) r42.get(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME);     // Catch: Throwable -> L187
    L158:
        r46.putOpt(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, r47);     // Catch: Throwable -> L187
        if (r42 == null) goto L162;
        Long r48 = (Long) r42.get(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME);     // Catch: Throwable -> L187
    L163:
        r46.putOpt(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, r48);     // Catch: Throwable -> L187
        if (r42 == null) goto L167;
        Long r49 = (Long) r42.get(TabkitSwitchTabPref.T_TAB_NET_START_TIME);     // Catch: Throwable -> L187
    L168:
        r46.putOpt(TabkitSwitchTabPref.T_TAB_NET_START_TIME, r49);     // Catch: Throwable -> L187
        if (r42 == null) goto L172;
        Long r50 = (Long) r42.get(TabkitSwitchTabPref.T_TAB_NET_END_TIME);     // Catch: Throwable -> L187
    L173:
        r46.putOpt(TabkitSwitchTabPref.T_TAB_NET_END_TIME, r50);     // Catch: Throwable -> L187
        if (r45 == null) goto L176;
        JSONObject r51 = r45.a;     // Catch: Throwable -> L187
    L177:
        f.a(r46, r51);     // Catch: Throwable -> L187
        Unit r52 = Unit.INSTANCE;     // Catch: Throwable -> L187
        r14.putOpt("tabkit_prefetch_timing", r46);     // Catch: Throwable -> L187
        if (r45 == null) goto L180;
        JSONObject r53 = r45.b;     // Catch: Throwable -> L187
    L181:
        r14.putOpt("tabkit_prefetch_net_detail", r53);     // Catch: Throwable -> L187
        if (r45 == null) goto L184;
        JSONObject r54 = r45.c;     // Catch: Throwable -> L187
    L185:
        Result.constructor-impl(r14.putOpt("tabkit_prefetch_extra_info", r54));     // Catch: Throwable -> L187
    L362:
        TabKitViewModel r55 = this.g.e;     // Catch: Throwable -> L268
        k r56 = this.e;     // Catch: Throwable -> L268
        if (r56 != null) goto L192;
    L196:
        a r57 = r55.getTabKitMonitor();     // Catch: Throwable -> L268
        if (r57 == null) goto L205;
        k r58 = this.e;     // Catch: Throwable -> L268
        if (r58 == null) goto L203;
        Integer r59 = r58.n();     // Catch: Throwable -> L268
        if (r59 == null) goto L203;
        int r60 = r59.intValue();     // Catch: Throwable -> L268
    L204:
        Map r61 = r57.c(r60);     // Catch: Throwable -> L268
    L206:
        JSONObject r62 = new JSONObject();     // Catch: Throwable -> L268
        if (r61 == null) goto L210;
        Long r63 = (Long) r61.get("t_tab_ssr_request_start");     // Catch: Throwable -> L268
    L211:
        r62.putOpt("t_tab_ssr_request_start", r63);     // Catch: Throwable -> L268
        if (r61 == null) goto L215;
        Long r64 = (Long) r61.get("t_tab_ssr_rcv_header");     // Catch: Throwable -> L268
    L216:
        r62.putOpt("t_tab_ssr_rcv_header", r64);     // Catch: Throwable -> L268
        if (r61 == null) goto L220;
        Long r65 = (Long) r61.get("t_tab_ssr_rcv_ssr_render_data_start");     // Catch: Throwable -> L268
    L221:
        r62.putOpt("t_tab_ssr_rcv_ssr_render_data_start", r65);     // Catch: Throwable -> L268
        if (r61 == null) goto L225;
        Long r66 = (Long) r61.get("t_tab_ssr_rcv_ssr_render_data_end");     // Catch: Throwable -> L268
    L226:
        r62.putOpt("t_tab_ssr_rcv_ssr_render_data_end", r66);     // Catch: Throwable -> L268
        if (r61 == null) goto L230;
        Long r67 = (Long) r61.get("t_tab_ssr_render_start");     // Catch: Throwable -> L268
    L231:
        r62.putOpt("t_tab_ssr_render_start", r67);     // Catch: Throwable -> L268
        if (r61 == null) goto L235;
        Long r68 = (Long) r61.get("t_tab_ssr_rcv_ssr_biz_data_start");     // Catch: Throwable -> L268
    L236:
        r62.putOpt("t_tab_ssr_rcv_ssr_biz_data_start", r68);     // Catch: Throwable -> L268
        if (r61 == null) goto L240;
        Long r69 = (Long) r61.get("t_tab_ssr_rcv_ssr_biz_data_end");     // Catch: Throwable -> L268
    L241:
        r62.putOpt("t_tab_ssr_rcv_ssr_biz_data_end", r69);     // Catch: Throwable -> L268
        if (r61 == null) goto L245;
        Long r70 = (Long) r61.get("t_tab_ssr_hydrate_start");     // Catch: Throwable -> L268
    L246:
        r62.putOpt("t_tab_ssr_hydrate_start", r70);     // Catch: Throwable -> L268
        if (r61 == null) goto L250;
        Long r71 = (Long) r61.get("t_tab_ssr_fetch_anchor_url_res");     // Catch: Throwable -> L268
    L251:
        r62.putOpt("t_tab_ssr_fetch_anchor_url_res", r71);     // Catch: Throwable -> L268
        if (r61 == null) goto L255;
        Long r72 = (Long) r61.get("t_tab_ssr_rcv_anchor_url_res");     // Catch: Throwable -> L268
    L256:
        r62.putOpt("t_tab_ssr_rcv_anchor_url_res", r72);     // Catch: Throwable -> L268
        if (r61 == null) goto L260;
        Long r73 = (Long) r61.get("t_tab_ssr_fetch_hydrate_url_res");     // Catch: Throwable -> L268
    L261:
        r62.putOpt("t_tab_ssr_fetch_hydrate_url_res", r73);     // Catch: Throwable -> L268
        if (r61 == null) goto L265;
        Long r74 = (Long) r61.get("t_tab_ssr_rcv_hydrate_url_res");     // Catch: Throwable -> L268
    L266:
        r62.putOpt("t_tab_ssr_rcv_hydrate_url_res", r74);     // Catch: Throwable -> L268
        Unit r75 = Unit.INSTANCE;     // Catch: Throwable -> L268
        Result.constructor-impl(r14.putOpt("tabkit_ssr_timing", r62));     // Catch: Throwable -> L268
    L368:
        TabKitViewModel r76 = this.g.e;     // Catch: Throwable -> L359
        k r77 = this.e;     // Catch: Throwable -> L359
        if (r77 != null) goto L273;
    L277:
        a r78 = r76.getTabKitMonitor();     // Catch: Throwable -> L359
        if (r78 == null) goto L286;
        k r79 = this.e;     // Catch: Throwable -> L359
        if (r79 == null) goto L284;
        Integer r80 = r79.n();     // Catch: Throwable -> L359
        if (r80 == null) goto L284;
        int r81 = r80.intValue();     // Catch: Throwable -> L359
    L285:
        Map r82 = r78.c(r81);     // Catch: Throwable -> L359
    L287:
        k r83 = this.e;     // Catch: Throwable -> L359
        if (r83 == null) goto L290;
        Integer r84 = r83.n();     // Catch: Throwable -> L359
    L291:
        v r85 = r76.getTabState(r84);     // Catch: Throwable -> L359
        k r86 = this.e;     // Catch: Throwable -> L359
        if (r86 == null) goto L294;
        Integer r87 = r86.n();     // Catch: Throwable -> L359
    L295:
        r14.putOpt("tab_id", r87);     // Catch: Throwable -> L359
        TabKitViewModel r88 = this.g.e;     // Catch: Throwable -> L359
        boolean r89 = com.bytedance.android.shopping.extensions.k.c(r88.getRouterParams().getAnchorUrl());     // Catch: Throwable -> L359
        boolean r90 = com.bytedance.android.shopping.extensions.k.c(r88.getRouterParams().getApiUrl());     // Catch: Throwable -> L359
        if (r89 == false) goto L299;
        if (r90 == false) goto L299;
        int r91 = 2;
    L302:
        r14.putOpt("biz_mode", Integer.valueOf(r91));     // Catch: Throwable -> L359
        r14.putOpt("page_modal", r76.getRouterParams().getPageModal());     // Catch: Throwable -> L359
        Integer r92 = r76.getAnchorTabId();     // Catch: Throwable -> L359
        k r93 = this.e;     // Catch: Throwable -> L359
        if (r93 == null) goto L305;
        Integer r94 = r93.n();     // Catch: Throwable -> L359
    L306:
        r14.putOpt("is_anchor_tab", Boolean.valueOf(Intrinsics.areEqual(r92, r94)));     // Catch: Throwable -> L359
        int r95 = com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r76.getAbilityConfig().b("enable_anniex_async_create")));     // Catch: Throwable -> L359
        if (r82 == null) goto L310;
        Long r96 = (Long) r82.get("hit_pre_create_annie_web_cache");     // Catch: Throwable -> L359
    L311:
        r14.putOpt("hit_pre_create_annie_web_cache", r96);     // Catch: Throwable -> L359
        if (r82 == null) goto L315;
        Long r97 = (Long) r82.get("hit_pre_create_annie_model_cache");     // Catch: Throwable -> L359
    L316:
        r14.putOpt("hit_pre_create_annie_model_cache", r97);     // Catch: Throwable -> L359
        r14.putOpt("enable_pre_create_annie", Integer.valueOf(r95));     // Catch: Throwable -> L359
        r14.putOpt("invoke_cnt", Integer.valueOf(r1));     // Catch: Throwable -> L359
        boolean r98 = r76.isLitePage();     // Catch: Throwable -> L359
        String r99 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r98 == false) goto L320;
        Object r100 = CommentScene.COMMENTSCENE_NO_AWEME;
    L321:
        r14.putOpt("is_lite_page", r100);     // Catch: Throwable -> L359
        k r101 = this.e;     // Catch: Throwable -> L359
        if (r101 == null) goto L326;
        s r102 = r101.f();     // Catch: Throwable -> L359
        if (r102 == null) goto L326;
        Integer r103 = r102.c();     // Catch: Throwable -> L359
    L327:
        r14.putOpt("container_type", Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r103, -1)));     // Catch: Throwable -> L359
        k r104 = this.e;     // Catch: Throwable -> L359
        if (r104 == null) goto L332;
        s r105 = r104.f();     // Catch: Throwable -> L359
        if (r105 == null) goto L332;
        Integer r106 = r105.d();     // Catch: Throwable -> L359
    L333:
        r14.putOpt("hybrid_container_type", Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r106, 0)));     // Catch: Throwable -> L359
        if (r85 == null) goto L336;
        String r2 = r85.d;     // Catch: Throwable -> L359
    L337:
        r14.putOpt("tabkit_res_from", r2);     // Catch: Throwable -> L359
        if (r85 == null) goto L340;
        String r107 = r85.e;     // Catch: Throwable -> L359
    L341:
        r14.putOpt("tabkit_update_data_source", r107);     // Catch: Throwable -> L359
        if (r85 != null) goto L344;
    L346:
        Object r108 = "0";
    L347:
        r14.putOpt("tabkit_anniex_force", r108);     // Catch: Throwable -> L359
        Long r109 = r76.getTabKitMonitorId();     // Catch: Throwable -> L359
        Observable<Boolean> r116 = TabKitAppMonitor.a;     // Catch: Throwable -> L359
        k r117 = this.e;     // Catch: Throwable -> L359
        if (r117 == null) goto L350;
        r3 = r117.n();     // Catch: Throwable -> L359
    L350:
        Boolean r118 = TabKitAppMonitor.b(r109, r3, r76.getAnchorTabId());     // Catch: Throwable -> L359
        if (r118 != null) goto L353;
    L357:
        Result.constructor-impl(r14.putOpt("tabs_container_id", r76.getTabsContainerId()));     // Catch: Throwable -> L359
    L361:
        return r14;
    L353:
        if (r118.booleanValue() == true) goto L356;
        r99 = "0";
    L356:
        r14.putOpt("tabkit_has_leave", r99);     // Catch: Throwable -> L359
        goto L357
    L344:
        if (r85.f != true) goto L346;
        r108 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L347
    L340:
        r107 = null;
        goto L341
    L336:
        r2 = null;
    L332:
        r106 = null;
    L326:
        r103 = null;
        goto L327
    L320:
        r100 = "0";
        goto L321
    L315:
        r97 = null;
        goto L316
    L310:
        r96 = null;
        goto L311
    L305:
        r94 = null;
    L299:
        if (r89 == false) goto L301;
        r91 = 1;
        goto L302
    L301:
        r91 = 0;
        goto L302
    L294:
        r87 = null;
        goto L295
    L290:
        r84 = null;
    L284:
        r81 = 0;
    L286:
        r82 = null;
        goto L287
    L273:
        if (r77.e != true) goto L277;
        a r119 = r76.getTabKitMonitor();     // Catch: Throwable -> L359
        if (r119 == null) goto L286;
        r82 = r119.d;     // Catch: Throwable -> L359
    L359:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L361
    L265:
        r74 = null;
        goto L266
    L260:
        r73 = null;
        goto L261
    L255:
        r72 = null;
        goto L256
    L250:
        r71 = null;
        goto L251
    L245:
        r70 = null;
        goto L246
    L240:
        r69 = null;
        goto L241
    L235:
        r68 = null;
        goto L236
    L230:
        r67 = null;
        goto L231
    L225:
        r66 = null;
        goto L226
    L220:
        r65 = null;
        goto L221
    L215:
        r64 = null;
        goto L216
    L210:
        r63 = null;
    L203:
        r60 = 0;
    L205:
        r61 = null;
        goto L206
    L192:
        if (r56.e != true) goto L196;
        a r121 = r55.getTabKitMonitor();     // Catch: Throwable -> L268
        if (r121 == null) goto L205;
        r61 = r121.d;     // Catch: Throwable -> L268
    L268:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L368
    L184:
        r54 = null;
        goto L185
    L180:
        r53 = null;
        goto L181
    L176:
        r51 = null;
        goto L177
    L172:
        r50 = null;
        goto L173
    L167:
        r49 = null;
        goto L168
    L162:
        r48 = null;
        goto L163
    L157:
        r47 = null;
        goto L158
    L152:
        r44 = null;
    L146:
        r41 = 0;
    L148:
        r42 = null;
        goto L149
    L135:
        if (r37.e != true) goto L139;
        a r123 = r36.getTabKitMonitor();     // Catch: Throwable -> L187
        if (r123 == null) goto L148;
        r42 = r123.d;     // Catch: Throwable -> L187
    L187:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L362
    L127:
        r34 = null;
        goto L128
    L122:
        r33 = null;
        goto L123
    L117:
        r32 = null;
        goto L118
    L113:
        r31 = null;
        goto L114
    L109:
        r115 = null;
        goto L110
    L104:
        r114 = null;
        goto L105
    L99:
        r113 = null;
        goto L100
    L94:
        r112 = null;
        goto L95
    L89:
        r111 = null;
        goto L90
    L84:
        r110 = null;
        goto L85
    L79:
        r30 = null;
        goto L80
    L74:
        r29 = null;
        goto L75
    L69:
        r28 = null;
        goto L70
    L64:
        r27 = null;
        goto L65
    L59:
        r26 = null;
        goto L60
    L54:
        r25 = null;
        goto L55
    L49:
        r24 = null;
        goto L50
    L44:
        r23 = null;
    L37:
        r20 = 0;
        goto L38
    L39:
        r21 = null;
        goto L40
    L28:
        if (r16.e != true) goto L30;
        r21 = r15;
        goto L40
    L24:
        r15 = null;
    L130:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L364
    L372:
        Object r126 = Result.constructor-impl(r14.putOpt("tabkit_delivery_prefetch_timing", r8));     // Catch: Throwable -> L13
    L15:
        r9 = Result.box-impl(r126);     // Catch: Throwable -> L19
        goto L17
    L13:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L19
        r126 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L370
    }

    public ECTabKitGetPerfTimingMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.g = r2;
        this.f = new HashMap();
    }

    public final void c(JSONObject r2, ECBaseBridgeMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "iReturn");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.a(d(r2));     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        r3.onFailed(0, r5.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
