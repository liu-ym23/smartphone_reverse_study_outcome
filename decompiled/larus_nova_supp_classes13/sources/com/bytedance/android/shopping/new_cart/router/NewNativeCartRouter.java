package com.bytedance.android.shopping.new_cart.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectaggroup.SlcECTagGroupElementViewManager;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.components.CartListLauncher;
import com.bytedance.android.shopping.new_cart.container.CartDialogFragment;
import com.bytedance.android.shopping.new_cart.container.CartTemplateMgr;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.repo.CartRepository;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.utils.e;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.perf.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NewNativeCartRouter implements bf.c {
    public static long b;
    public static final /* synthetic */ int c = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_cart";
    }

    public NewNativeCartRouter() {
        this.a = LazyKt.lazy(NewNativeCartRouter$cardListKitEnable$2.INSTANCE);
    }

    public static void d(Context r45, Uri r46) {
        String r2 = UUID.randomUUID().toString();
        String r4 = UriProtector.getQueryParameter(r46, "new_source_type");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Map<String, Map<String, Long>> r6 = yf3.b.a;
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        yf3.b.a.put(r2, new LinkedHashMap());
        yf3.b.c.put(r2, Long.valueOf(System.currentTimeMillis()));
        yf3.b.b.put(r2, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("new_source_type", r4)}));
        NewCartStarter r5 = new NewCartStarter(r2);
        Intrinsics.checkNotNullParameter(r45, "context");
        Intrinsics.checkNotNullParameter(r46, "uri");
        r5.n.a(r5.o, r5.m, NewCartStarter$openDirectly$1.INSTANCE);
        ph.a.a(r45);
        int r8 = ECCartMonitorReporter.d;
        ECCartMonitorReporter.a.a().getClass();
        Map r9 = com.bytedance.android.ec.core.monitor.c.a;
        MonitorScenes r10 = MonitorScenes.EC_PERF_PAGE_START_CART;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r11.put("area_type", "104");
        r11.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        Unit r15 = Unit.INSTANCE;
        com.bytedance.android.ec.core.monitor.c.b(r10, null, r11);
        ECCartMonitorReporter.a.a().getClass();
        ECCartMonitorReporter.f.a = 0;
        SlcECTagGroupElementViewManager.d4.getClass();
        if (SlcECTagGroupElementViewManager.c4 != null) goto L9;
        SlcECTagGroupElementViewManager.c4 = ECCartMonitorReporter.g;
    L9:
        r5.k = i.a.create("ec_perf_duration_cart");
        ECCartMonitorReporter r12 = ECCartMonitorReporter.a.a();
        String r13 = r5.k;
        r12.getClass();
        ECCartMonitorReporter.d(r13, "initial");
        ECCartMonitorReporter r14 = ECCartMonitorReporter.a.a();
        String r16 = r5.k;
        r14.getClass();
        ECCartMonitorReporter.d(r16, "request_start");
        ECCartMonitorReporter r17 = ECCartMonitorReporter.a.a();
        r17.getClass();
        d r18 = new d("biz_first_enter");
        String r19 = String.valueOf(r18.hashCode());
        r17.c.put(r19, r18);
        r5.l = r19;
        ECCartMonitorReporter.a.a().f(r5.l, NewCartActivity.F);
        Lazy r20 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.a("cart");
    L12:
        com.bytedance.android.ec.core.cart.a r21 = yf3.a.a;
        Intrinsics.checkNotNullParameter(r45, "context");
        if (yf3.a.a.d() == false) goto L16;
        Map r22 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r45).a().a(2131563707, 1).a(2131560399, 1).a(2131563705, 1).commit();
    L16:
        String r23 = UriProtector.getQueryParameter(r46, "new_source_type");
        if (NewCartStarter.t != null) goto L19;
    L21:
        yf3.b.a(r5.s, "GetCartCacheResponse");
        CoroutineScope r110 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Lazy r24 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", NewCartStarter$getCartCacheResponse$1.INSTANCE);
        BuildersKt.launch$default(r110, null, null, new NewCartStarter$getCartCacheResponse$2(r5, r23, null), 3, null);
    L22:
        CartTemplateMgr.preload(r45);
        r5.n.a(r5.o, r5.m, NewCartStarter$openDirectly$2.INSTANCE);
        yf3.b.a(r5.s, "ParseRouterUri");
        String r3 = UriProtector.getQueryParameter(r46, "new_source_type");
        if (r3 != null) goto L25;
        r3 = "";
    L25:
        r5.a = r3;
        String r7 = UriProtector.getQueryParameter(r46, "history_path");
        if (r7 != null) goto L28;
        r7 = "";
    L28:
        r5.b = r7;
        String r25 = UriProtector.getQueryParameter(r46, "enter_from_live_saas");
        if (r25 != null) goto L31;
        r25 = "";
    L31:
        r5.c = r25;
        String r26 = UriProtector.getQueryParameter(r46, "ecom_scene_id");
        if (r26 != null) goto L34;
        r26 = "";
    L34:
        r5.d = r26;
        String r27 = UriProtector.getQueryParameter(r46, "cart_ids");
        if (r27 != null) goto L37;
        r27 = "";
    L37:
        r5.e = r27;
        String r28 = UriProtector.getQueryParameter(r46, "shop_ids");
        if (r28 != null) goto L40;
        r28 = "";
    L40:
        r5.f = r28;
        String r29 = UriProtector.getQueryParameter(r46, "show_shop_ids");
        if (r29 != null) goto L43;
        r29 = "";
    L43:
        r5.g = r29;
        String r30 = UriProtector.getQueryParameter(r46, "anchor_cart_id");
        if (r30 != null) goto L46;
        r30 = "";
    L46:
        r5.h = r30;
        String r31 = UriProtector.getQueryParameter(r46, "delivery_session_id");
        if (r31 != null) goto L49;
        r31 = "";
    L49:
        r5.i = r31;
        int r32 = db3.a.a;
        if (db3.a.C0188a.b() == false) goto L52;
        YataPageInfo r38 = new YataPageInfo(true, false, null, 6, null);
    L53:
        r5.j = k.r(UriProtector.getQueryParameter(r46, "cart_height_percent"), 0);
        String r111 = r5.a;
        String r112 = r5.b;
        String r33 = r5.c;
        String r34 = r5.d;
        String r35 = r5.e;
        String r36 = r5.f;
        String r113 = r5.g;
        String r114 = r5.h;
        HashMap r37 = j1.a(r46);
        String r115 = r5.k;
        String r116 = r5.l;
        String r210 = UriProtector.getQueryParameter(r46, "transparent_params");
        if (r210 != null) goto L56;
        String r39 = "";
    L57:
        CartParams r40 = new CartParams(r111, r112, r33, r34, r35, r36, r113, r114, r37, r115, r116, r39, r5.j, r5.i, r38, null, 32768, null);
        int r1 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        com.bytedance.android.shopping.base.event.a.d("cart", "schema_parse", "end", null, false, null, 56);
        r5.n.a(r5.o, r5.m, NewCartStarter$openDirectly$3.INSTANCE);
        yf3.b.a(r5.s, "LaunchCartActivity");
        Boolean r41 = Boolean.FALSE;
        int r42 = com.bytedance.android.shopping.new_cart.utils.c.a;
        Intrinsics.checkNotNullParameter(r45, "context");
        nj.d r43 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r43 == null) goto L62;
        r43.l();
    L62:
        if ((!Intrinsics.areEqual(r41, Boolean.TRUE)) == false) goto L97;
        Map r44 = null;
        r40.setSplitActivityScene(null);
        r40.setHeightPercent(r5.j);
        if (r5.j == 0) goto L68;
        HashMap<String, String> r47 = r40.getSchemaParams();
        if (r47 == null) goto L68;
        String r48 = r47.put("cart_height_percent", String.valueOf(r5.j));
    L68:
        List<String> r49 = r5.p;
        if (r49 == null) goto L73;
        int r50 = 1;
        if (CollectionsKt.contains(r49, r5.a) != true) goto L74;
    L78:
        com.bytedance.kmp.ec.yata.common.perf.c r51 = CartDialogFragment.R;
        CartDialogFragment r52 = CartDialogFragment.a.a(r40, r5.s);
        if ((r45 instanceof FragmentActivity) == true) goto L81;
        Context r53 = null;
    L82:
        FragmentActivity r54 = (FragmentActivity) r53;
        if (r54 != null) goto L85;
        NewCartActivity.a.a(r45, r40, r5.s);
    L98:
        Map<String, Map<String, Long>> r55 = yf3.b.a;
        yf3.b.a(r5.s, "FirstQuery");
        int r56 = ECCartMonitorReporter.d;
        ECCartMonitorReporter.a.a().f(r5.l, NewCartActivity.G);
        r5.n.a(r5.o, r5.m, NewCartStarter$queryData$1.INSTANCE);
        int r57 = r40.getHeightPercent();
        if (1 > r57) goto L103;
        if (99 < r57) goto L103;
        int r58 = r40.getHeightPercent();
    L104:
        CartRepository r59 = CartRepository.INSTANCE;
        LinkedHashMap r60 = new LinkedHashMap();
        r60.putAll(r40.getSchemaParamsOrCreate());
        Pair[] r61 = new Pair[11];
        String r62 = r40.getCartIds();
        if (r62 != null) goto L107;
        r62 = "";
    L107:
        r61[0] = TuplesKt.to("selected_cart_ids", r62);
        String r63 = r40.getShopIds();
        if (r63 != null) goto L110;
        r63 = "";
    L110:
        r61[1] = TuplesKt.to("selected_shop_ids", r63);
        r61[2] = TuplesKt.to("source_type", "104");
        r61[3] = TuplesKt.to("query_scene", "first_enter");
        r61[4] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        r61[5] = TuplesKt.to("page_type", "YATA_Android");
        String r64 = r40.getAnchorCartId();
        if (r64 != null) goto L113;
        r64 = "";
    L113:
        r61[6] = TuplesKt.to("anchor_cart_id", r64);
        String r65 = r40.getTransparentParams();
        if (r65 != null) goto L116;
        r65 = "";
    L116:
        r61[7] = TuplesKt.to("transparent_params", r65);
        r61[8] = TuplesKt.to("session_id", r5.s);
        r61[9] = TuplesKt.to("current_cart_height_percent", String.valueOf(r58));
        r61[10] = TuplesKt.to("is_in_split_mode", Boolean.valueOf(k.c(r40.getSplitActivityScene())));
        r60.putAll(MapsKt.mapOf(r61));
        Unit r66 = Unit.INSTANCE;
        PackYataSdkConfig r67 = com.bytedance.kmp.ec.yata.common.init.b.a;
        YataPageInfo r68 = r40.getPageInfo();
        if (r68 == null) goto L119;
        Map r117 = r68.addAndGetYataProtocolInfo();
    L120:
        r59.firstQuery(new wf3.c(r60, r117, "1.23.7", 6)).subscribeOn(Schedulers.newThread()).subscribe(new b(r5));
        yf3.b.a(r5.s, "OpenDirectlyEnd");
        yf3.b.a(r2, "CheckParams");
        t.b(new c(r45, r46));
        yf3.b.a(r2, "RouterOpenEnd");
        return;
    L119:
        r117 = r44;
    L103:
        r58 = 100;
        goto L104
    L85:
        if (r54.isDestroyed() == false) goto L87;
    L94:
        NewCartActivity.a.a(r45, r40, r5.s);
        goto L98
    L87:
        if (r54.isFinishing() == true) goto L94;
        FragmentManager r69 = r54.getSupportFragmentManager();
        r69.beginTransaction().remove(r52).commitAllowingStateLoss();
        LandscapeRestrictionOperation r70 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r52, "CartDialogFragment", r70);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r69, r52, r70) == true) goto L98;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L122
    L93:
        r52.show(r69, "CartDialogFragment");
        goto L98
    L81:
        r53 = r45;
    L74:
        int r71 = r5.j;
        if (r50 > r71) goto L96;
        if (99 >= r71) goto L78;
    L96:
        NewCartActivity.a.a(r45, r40, r5.s);
        goto L98
    L73:
        r50 = 1;
        goto L74
    L97:
        r44 = null;
        goto L98
    L56:
        r39 = r210;
        goto L57
    L52:
        r38 = null;
        goto L53
    L19:
        if (r5.b() == false) goto L21;
        ECCartMonitorReporter r72 = ECCartMonitorReporter.a.a();
        String r73 = r5.k;
        r72.getClass();
        ECCartMonitorReporter.d(r73, "request_end");
        ECCartMonitorReporter r74 = ECCartMonitorReporter.a.a();
        String r75 = r5.k;
        r74.getClass();
        ECCartMonitorReporter.d(r75, "render_start");
        r5.c(NewCartStarter.t);
        goto L22
    }

    public final boolean c(final Context r12, final Uri r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "uri");
        final String r0 = "";
        Object r1 = null;
        if (((List) this.a.getValue()).contains("cart") == false) goto L191;
        String r15 = UriProtector.getQueryParameter(r13, "new_source_type");
        if (r15 == null) goto L8;
        r0 = r15;
    L8:
        Intrinsics.checkNotNullParameter(r0, "sourceType");
        ECSettingKeys.j.getClass();
        List r16 = ECSettingKeys.h().a();
        com.bytedance.android.ec.core.cart.c r2 = ECSettingKeys.p();
        LinkedHashMap r4 = new LinkedHashMap();
        Boolean r5 = Boolean.TRUE;
        r4.put("need_check_login", r5);
        if (r16 == null) goto L11;
        boolean r17 = r16.contains(r0);
    L12:
        r4.put("use_dialog_fragment_open", Boolean.valueOf(r17));
        r4.put("opt_preload_layout", r5);
        r4.put("need_cache_manager", r5);
        r4.put("biz_type", Integer.valueOf(LauncherBizType.CART.ordinal()));
        r4.put("query_data_in_starter", r5);
        r4.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        r4.put("standard_show_event_name", "cart_list_tab_show");
        r4.put("standard_click_event_name", "cart_list_tab_click");
        r4.put("uplink_codes_need_reload", CollectionsKt.listOf(r2.p()));
        r4.put("cache_valid_duration", Integer.valueOf(r2.c()));
        int r18 = n.a;
        Object r3 = 3;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L169
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L63
        if (r8 != null) goto L18;
    L60:
        Object r9 = null;
    L61:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L63
    L65:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L169
        if (r11 == null) goto L69;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L169
    L69:
        if (Result.isFailure-impl(r10) == false) goto L72;
        r10 = null;
    L72:
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        Object r19 = (Integer) r10;     // Catch: Throwable -> L169
        if (r19 != null) goto L81;
        Object r20 = com.bytedance.android.ec.base.settings.d.a.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L169
        if ((r20 instanceof Integer) == true) goto L80;
        r20 = null;
    L80:
        r19 = (Integer) r20;     // Catch: Throwable -> L169
    L81:
        if (r19 != null) goto L178;
        int r21 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L169
        Object r22 = com.bytedance.android.ec.base.settings.d.c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L133
        if (r22 != null) goto L88;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L159
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof Integer) == true) goto L144;
        r24 = null;
    L144:
        r19 = (Integer) r24;     // Catch: Throwable -> L159
        if (r19 != null) goto L167;
        IHybridHostService r26 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L159
        if (r26 == null) goto L150;
        Object r27 = r26.getHostABValue("ec_cart_gul_preload_threshold", r3);     // Catch: Throwable -> L159
    L151:
        if (r27 != null) goto L153;
    L158:
        r19 = r3;
        goto L167
    L153:
        if ((r27 instanceof Integer) == false) goto L156;
        r1 = r27;
    L156:
        Object r28 = (Integer) r1;     // Catch: Throwable -> L159
        if (r28 == null) goto L158;
    L166:
        r19 = r28;
        goto L167
    L150:
        r27 = null;
    L167:
        com.bytedance.android.ec.base.settings.d.d("ec_cart_gul_preload_threshold", r19);     // Catch: Throwable -> L169
        goto L178
    L88:
        if ((r22 instanceof Integer) == true) goto L90;
        Object r29 = null;
    L91:
        r23 = (Integer) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L103;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof Integer) == true) goto L101;
        r30 = null;
    L101:
        r23 = (Integer) r30;     // Catch: Throwable -> L133
        goto L131
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L109;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Integer) == true) goto L107;
        r31 = null;
    L107:
        r23 = (Integer) r31;     // Catch: Throwable -> L133
        goto L131
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r32 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Integer) == true) goto L116;
        r32 = null;
    L116:
        r23 = (Integer) r32;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L210:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L126
        Object r33 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L126
        if ((r33 instanceof Integer) == true) goto L124;
        r33 = null;
    L124:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L126
    L128:
        r23 = r34;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L133
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L90:
        r29 = r22;
    L159:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L169
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
        Throwable r37 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L169
        if (r37 == null) goto L164;
        EnsureManager.ensureNotReachHere(r37);     // Catch: Throwable -> L169
    L164:
        if (Result.isFailure-impl(r28) == false) goto L166;
        r28 = r3;
    L133:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L159
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L178:
        int r110 = ((Number) r19).intValue();
        List r39 = r2.b();
        if (r39 != null) goto L181;
        r39 = CollectionsKt.emptyList();
    L181:
        r4.put("bottom_placeholder_enable_scenes", r39);
        r4.put("gul_preload_threshold", Integer.valueOf(r110));
        List r111 = r2.d();
        if (r111 != null) goto L184;
        r111 = CollectionsKt.emptyList();
    L184:
        r4.put("skip_explicit_loading_trigger_list", r111);
        r4.put("need_load_gul", Boolean.TRUE);
        r4.put("need_set_gradient_view", Boolean.FALSE);
        int r112 = db3.a.a;
        r4.put("need_frontier", Boolean.valueOf(db3.a.C0188a.b()));
        int r113 = CartListLauncher.f;
        CartListLauncher.Companion.a();
        int r114 = ECSdk.a;
        IEShoppingService r115 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r115 == null) goto L189;
        sc3.d r116 = r115.getCardKitService();
        if (r116 == null) goto L189;
        r116.b(r12, r13.toString(), r4);
    L189:
        return true;
    L18:
        if ((r8 instanceof Integer) == true) goto L20;
        Object r40 = null;
    L21:
        r9 = (Integer) r40;     // Catch: Throwable -> L63
        if (r9 != null) goto L61;
        if ((r8 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L33;
        Float r41 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L63
        if ((r41 instanceof Integer) == true) goto L31;
        r41 = null;
    L31:
        r9 = (Integer) r41;     // Catch: Throwable -> L63
        goto L61
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L39;
        Double r42 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L63
        if ((r42 instanceof Integer) == true) goto L37;
        r42 = null;
    L37:
        r9 = (Integer) r42;     // Catch: Throwable -> L63
        goto L61
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r43 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L63
        if ((r43 instanceof Integer) == true) goto L46;
        r43 = null;
    L46:
        r9 = (Integer) r43;     // Catch: Throwable -> L63
    L48:
        if ((r8 instanceof JSONObject) == false) goto L50;
    L208:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L56
        Object r44 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L56
        if ((r44 instanceof Integer) == true) goto L54;
        r44 = null;
    L54:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L56
    L58:
        r9 = r45;
        if (Result.isFailure-impl(r9) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L63
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r8 instanceof JSONArray) == false) goto L60;
    L20:
        r40 = r8;
    L63:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L169
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r117 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r117);
        if (r49 == null) goto L174;
        EnsureManager.ensureNotReachHere(r49);
    L174:
        if (Result.isFailure-impl(r117) == true) goto L177;
        r3 = r117;
    L177:
        r19 = r3;
        goto L178
    L11:
        r17 = false;
        goto L12
    L191:
        if ((System.currentTimeMillis() - b) >= 1500) goto L193;
        return true;
    L193:
        b = System.currentTimeMillis();
        int r118 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        ConcurrentHashMap<String, String> r119 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.a.clear();
        com.bytedance.android.shopping.base.event.a.d("cart", "schema_parse", "start", null, false, null, 56);
        Lazy r120 = ECAppInfoService.a;
        if (ECAppInfoService.m() == false) goto L206;
        String r121 = UriProtector.getQueryParameter(r13, "new_source_type");
        if (r121 == null) goto L200;
        r0 = r121;
    L200:
        if ((r12 instanceof Activity) == false) goto L203;
        r1 = r12;
    L203:
        Activity r50 = (Activity) r1;
        if (r50 == null) goto L207;
        int r122 = e.a;
        e.a(r50, r0, new NewNativeCartRouter$checkLoginAndOpen$$inlined$let$lambda$1(this, r0, r12, r13), NewNativeCartRouter$checkLoginAndOpen$1$2.INSTANCE);
    L207:
        return true;
    L206:
        d(r12, r13);
        goto L207
    }
}
