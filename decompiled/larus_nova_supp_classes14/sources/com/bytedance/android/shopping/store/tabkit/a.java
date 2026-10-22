package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.prefetch.PrefetchJobKey;
import com.bytedance.android.ec.store.prefetch.PrefetchScene;
import com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabKitApi;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetch;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetchJobKey;
import com.bytedance.android.shopping.store.tabkit.cache.TabKitRouterCache;
import com.bytedance.android.shopping.store.tabkit.cache.UrlInfo;
import com.bytedance.android.shopping.store.tabkit.events.SecSettingSource;
import com.bytedance.android.shopping.store.tabkit.model.c0;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabKitAppMonitor;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements bf.c {
    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_tabkit";
    }

    public static String d(String r7) {
        int r0 = hk3.b.a;
        Object r1 = null;
        boolean r2 = false;
        if (r7 == null) goto L15;
        String r3 = n.b(r7);
        if (r3 == null) goto L15;
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L15;
        if (hk3.b.g(hk3.b.h().d(), hk3.b.j().d(), r3) <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r7 == null) goto L28;
        String r5 = n.b(r7);
        if (r5 == null) goto L28;
        if ((!StringsKt.isBlank(r5)) == true) goto L23;
        r5 = null;
    L23:
        if (r5 == null) goto L28;
        if (hk3.b.g(hk3.b.h().c(), hk3.b.j().c(), r5) <= 0) goto L28;
        boolean r6 = true;
    L29:
        if (r4 == true) goto L31;
        if (r6 == true) goto L31;
    L84:
        return r7;
    L31:
        if (r7 == null) goto L43;
        String r8 = n.b(r7);
        if (r8 == null) goto L43;
        if ((!StringsKt.isBlank(r8)) == true) goto L38;
        r8 = null;
    L38:
        if (r8 == null) goto L43;
        if (hk3.b.g(hk3.b.h().i(), hk3.b.j().i(), r8) <= 0) goto L43;
        boolean r9 = true;
    L44:
        if (r9 == false) goto L75;
        Intrinsics.checkNotNullParameter(r7, "$this$safeAppendParamIfAbsent");
        Intrinsics.checkNotNullParameter("inject_cache_async", "key");
        Intrinsics.checkNotNullParameter(CommentScene.COMMENTSCENE_NO_AWEME, "value");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L62
        Uri r11 = UriProtector.parse(r7);     // Catch: Throwable -> L62
        String r12 = UriProtector.getQueryParameter(r11, "inject_cache_async");     // Catch: Throwable -> L62
        if (r12 != null) goto L49;
    L52:
        boolean r13 = true;
    L53:
        if (r13 == false) goto L60;
        Uri.Builder r14 = r11.buildUpon();     // Catch: Throwable -> L62
        if (r14 == null) goto L59;
        Uri.Builder r15 = r14.appendQueryParameter("inject_cache_async", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L62
        if (r15 == null) goto L59;
        r11 = r15.build();     // Catch: Throwable -> L62
    L59:
        r11 = null;
    L60:
        Object r16 = Result.constructor-impl(r11);     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r16) == true) goto L68;
        r1 = r16;
    L68:
        Uri r17 = (Uri) r1;
        if (r17 == null) goto L75;
        String r18 = r17.toString();
        if (r18 == null) goto L75;
        r7 = r18;
        goto L75
    L49:
        if (StringsKt.isBlank(r12) == true) goto L52;
        r13 = false;
    L62:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L75:
        if (hk3.b.a(r7) == false) goto L77;
    L78:
        r2 = true;
    L79:
        if (r2 == false) goto L81;
        r7 = n.a(r7);
    L81:
        int r20 = ECSdk.a;
        IECHostService r21 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r21 == null) goto L84;
        r21.getECAnnieXHostService();
        goto L84
    L77:
        if (hk3.b.b(r7) == false) goto L79;
    L43:
        r9 = false;
    L28:
        r6 = false;
    L15:
        r4 = false;
        goto L16
    }

    public static String e(String r13, String r14) {
        if ((!StringsKt.isBlank(r13)) == true) goto L5;
        return r14;
    L5:
        if (StringsKt.isBlank(r14) == false) goto L7;
        return r14;
    L7:
        if (StringsKt.isBlank(r13) == true) goto L34;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        Uri r3 = n.c(r14);     // Catch: Throwable -> L26
        if (r3 == null) goto L33;
        Uri.Builder r4 = r3.buildUpon();     // Catch: Throwable -> L26
        if (UriProtector.getQueryParameter(r3, "ec_request_id") != null) goto L16;
        r4.appendQueryParameter("ec_request_id", r13);     // Catch: Throwable -> L26
    L16:
        if (UriProtector.getQueryParameter(r3, "prefetch_config_tags") != null) goto L24;
        ConcurrentHashMap r15 = NativePrefetchUtil.a;     // Catch: Throwable -> L26
        List r16 = (List) NativePrefetchUtil.j(r14).getFirst();     // Catch: Throwable -> L26
        if (r16 == null) goto L24;
        String r17 = CollectionsKt.joinToString$default(r16, "_", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        String r18 = a2.c(r17);     // Catch: Throwable -> L26
        if (r18 == null) goto L24;
        r4.appendQueryParameter("prefetch_config_tags", r18);     // Catch: Throwable -> L26
    L24:
        return r4.build().toString();
    L33:
        return r14;
    L26:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r14;
    L34:
        return r14;
    }

    public final boolean c(Context r30, Uri r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "uri");
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L5;
        r0.n();
    L5:
        TabkitFirstFramePref r4 = new TabkitFirstFramePref();
        TabkitFramePref.recordTime$default(r4, TabkitFirstFramePref.T_PAGE_ROUTE_START, null, 2, null);
        Map<Long, TabkitFirstFramePref> r1 = ok3.a.e;
        Intrinsics.checkNotNullParameter(r4, "monitor");
        long r7 = System.currentTimeMillis();
        ok3.a.e.put(Long.valueOf(r7), r4);
        Lazy r2 = MallSessionMonitor.a;
        String r3 = r31.toString();
        double r9 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r3, "schema");
        IMallSessionService r11 = (IMallSessionService) MallSessionMonitor.a.getValue();
        if (r11 == null) goto L8;
        r11.a("receive_router", r3, r9);
    L8:
        TabKitRouterParams r10 = new TabKitRouterParams();
        dm.a.a("ECTabKitDebug").i("open uri == " + r31);
        Intrinsics.checkNotNullParameter(r10, "routerParams");
        Intrinsics.checkNotNullParameter(r31, "uri");
        int r5 = hk3.a.a;
        int r6 = p.a;
        Object r12 = Boolean.TRUE;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L13
        jj4.b r15 = jj4.b.b;     // Catch: Throwable -> L13
        Object r8 = jj4.a.a("ec_tabkit_mask_view_opt", Boolean.class, r12, false);     // Catch: Throwable -> L13
        if (r8 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Throwable -> L13
    L20:
        if (((Boolean) r8).booleanValue() == false) goto L22;
        r10.getParamsMap().put("_mask_alpha_opt", CommentScene.COMMENTSCENE_NO_AWEME);
    L22:
        Set r13 = UriProtector.getQueryParameterNames(r31);
        if (r13 == null) goto L28;
        Iterator r16 = r13.iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        String r17 = (String) r16.next();
        r10.getParamsMap().put(r17, UriProtector.getQueryParameter(r31, r17));
    L28:
        String r18 = r10.getParamsMap().get("fraction_listener_id");
        r10.getParamsMap().remove("fraction_listener_id");
        int r19 = qk3.a.a;
        Intrinsics.checkNotNullParameter(r10, "tabKitRouterParams");
        Intrinsics.checkNotNullParameter(r31, "uri");
        cl.d.a.getClass();
        cl.d r20 = cl.d.a.b();
        if (r20 == null) goto L31;
        r20.n();
    L31:
        int r21 = hk3.a.a;
        int r22 = com.bytedance.android.ec.core.opt.ab.n.a;
        c0 r110 = new c0();
        r110.a = true;
        int r23 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L192
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_schema_rules_aweme");     // Catch: Throwable -> L85
        if (r25 != null) goto L37;
    L82:
        Object r26 = null;
    L83:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L85
    L87:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L192
        if (r28 == null) goto L91;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L192
    L91:
        if (Result.isFailure-impl(r27) == false) goto L94;
        r27 = null;
    L94:
        if ((r27 instanceof c0) == true) goto L96;
        r27 = null;
    L96:
        c0 r29 = (c0) r27;     // Catch: Throwable -> L192
        if (r29 == null) goto L99;
        c0 r33 = r29;
    L103:
        if (r33 == null) goto L105;
        Object r34 = r33;
    L201:
        c0 r35 = (c0) r34;
        r35.b = SecSettingSource.APP_SETTING_AWEME;
        if ((!r35.a) == true) goto L205;
        r35 = null;
    L205:
        if (r35 != null) goto L218;
        int r36 = p.a;
        c0 r37 = new c0();
        r37.a = true;
        jj4.b r38 = jj4.b.b;     // Catch: Throwable -> L211
        Object r39 = jj4.a.a("ec_tabkit_schema_rules_v2", c0.class, r37, false);     // Catch: Throwable -> L211
        Object r40 = r39;
        if (r39 != null) goto L217;
        Intrinsics.throwNpe();     // Catch: Throwable -> L211
        r40 = r39;
    L217:
        r35 = (c0) r40;
        r35.b = SecSettingSource.LIBRA_SETTING;
    L211:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Object r43 = r37;
        if (Result.isFailure-impl(r42) == true) goto L216;
        r43 = r42;
    L216:
        r40 = r43;
    L218:
        String r44 = r10.getApiUrl();
        String r45 = r10.getAnchorUrl();
        String r111 = r10.getSsrUrl();
        String r112 = r10.getBizTag();
        if (com.bytedance.android.shopping.extensions.k.c(r44) == false) goto L226;
        TabkitFirstFramePref r113 = r4;
        int r46 = qk3.a.a(r44, r35.b(), r35.d());
        if (r46 == 1) goto L224;
        qk3.a.b(r35, r44, "api_url_host", r31, r112);
    L224:
        if (r46 != 3) goto L228;
        r10.getParamsMap().remove("api_url");
    L228:
        if (com.bytedance.android.shopping.extensions.k.c(r45) == false) goto L235;
        String r114 = "routerParams";
        int r47 = qk3.a.a(r45, r35.a(), r35.d());
        if (r47 == 1) goto L233;
        qk3.a.b(r35, r45, "anchor_url_host", r31, r112);
    L233:
        if (r47 != 3) goto L237;
        r10.getParamsMap().remove("anchor_url");
        r10.getParamsMap().remove("url");
    L237:
        if (com.bytedance.android.shopping.extensions.k.c(r111) == false) goto L244;
        int r48 = qk3.a.a(r111, r35.c(), r35.d());
        if (r48 == 1) goto L241;
        qk3.a.b(r35, r111, "ssr_url_host", r31, r112);
    L241:
        int r49 = 3;
        if (r48 != 3) goto L245;
        r10.getParamsMap().remove("ssr_url");
    L245:
        if (r46 == r49) goto L249;
        if (r47 == r49) goto L249;
        if (r48 == r49) goto L249;
        boolean r50 = true;
    L250:
        Bundle r51 = new Bundle();
        r51.putString("fraction_listener_id", r18);
        r51.putBoolean("url_check_result", r50);
        TabKitAbilityConfig r52 = new TabKitAbilityConfig(r10);
        if (r52.b("tabkit_fold_adapter") == false) goto L256;
        nj.d r53 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r53 == null) goto L256;
        r53.l();
    L256:
        Observable<Boolean> r54 = TabKitAppMonitor.a;
        TabKitAppMonitor.c(Long.valueOf(r7), null);
        if (Intrinsics.areEqual(r10.getParamsMap().get("ensure_live_init"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L434;
        int r55 = hk3.a.a;
        int r56 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r57 = Boolean.TRUE;
        int r58 = com.bytedance.android.ec.base.settings.a.a;
        Object r59 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_route_ensure_live_init");     // Catch: Throwable -> L311
        if (r59 != null) goto L263;
    L308:
        Object r60 = null;
    L309:
        Object r61 = Result.constructor-impl(r60);     // Catch: Throwable -> L311
    L313:
        Throwable r62 = Result.exceptionOrNull-impl(r61);     // Catch: Throwable -> L418
        if (r62 == null) goto L317;
        EnsureManager.ensureNotReachHere(r62);     // Catch: Throwable -> L418
    L317:
        if (Result.isFailure-impl(r61) == false) goto L320;
        r61 = null;
    L320:
        if ((r61 instanceof Boolean) == true) goto L322;
        r61 = null;
    L322:
        Object r63 = (Boolean) r61;     // Catch: Throwable -> L418
        if (r63 != null) goto L329;
        Object r64 = com.bytedance.android.ec.base.settings.d.a.get("tabkit_route_ensure_live_init");     // Catch: Throwable -> L418
        if ((r64 instanceof Boolean) == true) goto L328;
        r64 = null;
    L328:
        r63 = (Boolean) r64;     // Catch: Throwable -> L418
    L329:
        if (r63 != null) goto L428;
        int r65 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L418
        Object r66 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_route_ensure_live_init");     // Catch: Throwable -> L384
        if (r66 != null) goto L336;
    L381:
        Object r67 = null;
    L382:
        Object r68 = Result.constructor-impl(r67);     // Catch: Throwable -> L384
    L386:
        Throwable r69 = Result.exceptionOrNull-impl(r68);     // Catch: Throwable -> L409
        if (r69 == null) goto L390;
        EnsureManager.ensureNotReachHere(r69);     // Catch: Throwable -> L409
    L390:
        if (Result.isFailure-impl(r68) == false) goto L393;
        r68 = null;
    L393:
        if ((r68 instanceof Boolean) == true) goto L395;
        r68 = null;
    L395:
        r63 = (Boolean) r68;     // Catch: Throwable -> L409
        if (r63 != null) goto L416;
        IHybridHostService r70 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L409
        if (r70 == null) goto L401;
        Object r71 = r70.getHostABValue("tabkit_route_ensure_live_init", r57);     // Catch: Throwable -> L409
    L402:
        if (r71 != null) goto L404;
    L415:
        r63 = r57;
        goto L416
    L404:
        if ((r71 instanceof Boolean) == true) goto L406;
        r71 = null;
    L406:
        r63 = (Boolean) r71;     // Catch: Throwable -> L409
        if (r63 != null) goto L416;
    L409:
        th = move-exception;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L418
        r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L418
        Throwable r73 = Result.exceptionOrNull-impl(r63);     // Catch: Throwable -> L418
        if (r73 == null) goto L414;
        EnsureManager.ensureNotReachHere(r73);     // Catch: Throwable -> L418
    L414:
        if (Result.isFailure-impl(r63) == false) goto L416;
    L401:
        r71 = null;
    L416:
        com.bytedance.android.ec.base.settings.d.d("tabkit_route_ensure_live_init", r63);     // Catch: Throwable -> L418
        goto L428
    L336:
        if ((r66 instanceof Boolean) == true) goto L338;
        Object r74 = null;
    L339:
        Boolean r75 = (Boolean) r74;     // Catch: Throwable -> L384
        if (r75 == null) goto L343;
        r67 = r75;
        goto L382
    L343:
        if ((r66 instanceof Number) == false) goto L369;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L351;
        Object r76 = Float.valueOf(((Number) r66).floatValue());     // Catch: Throwable -> L384
        if ((r76 instanceof Boolean) == true) goto L349;
        r76 = null;
    L349:
        r67 = (Boolean) r76;     // Catch: Throwable -> L384
        goto L382
    L351:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L357;
        Object r77 = Double.valueOf(((Number) r66).doubleValue());     // Catch: Throwable -> L384
        if ((r77 instanceof Boolean) == true) goto L355;
        r77 = null;
    L355:
        r67 = (Boolean) r77;     // Catch: Throwable -> L384
        goto L382
    L357:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L363;
        Object r78 = Integer.valueOf(((Number) r66).intValue());     // Catch: Throwable -> L384
        if ((r78 instanceof Boolean) == true) goto L361;
        r78 = null;
    L361:
        r67 = (Boolean) r78;     // Catch: Throwable -> L384
        goto L382
    L363:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L369;
        Object r79 = Long.valueOf(((Number) r66).longValue());     // Catch: Throwable -> L384
        if ((r79 instanceof Boolean) == true) goto L367;
        r79 = null;
    L367:
        r67 = (Boolean) r79;     // Catch: Throwable -> L384
    L369:
        if ((r66 instanceof JSONObject) == false) goto L371;
    L745:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L377
        Object r80 = SDKSettingsCacheManager.a().fromJson(r66.toString(), Boolean.class);     // Catch: Throwable -> L377
        if ((r80 instanceof Boolean) == true) goto L375;
        r80 = null;
    L375:
        r67 = Result.constructor-impl((Boolean) r80);     // Catch: Throwable -> L377
    L380:
        if (Result.isFailure-impl(r67) == false) goto L382;
    L377:
        th = move-exception;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L384
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L384
        goto L380
    L371:
        if ((r66 instanceof JSONArray) == false) goto L381;
    L338:
        r74 = r66;
    L384:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L409
        r68 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L409
    L428:
        if (((Boolean) r63).booleanValue() == false) goto L434;
        int r83 = ECSdk.a;
        s83.g r84 = (s83.g) ECSdk.a(s83.g.class);
        if (r84 == null) goto L434;
        if (r84.P() == true) goto L434;
        r84.b0();
        goto L434
    L263:
        if ((r59 instanceof Boolean) == true) goto L265;
        Object r85 = null;
    L266:
        Boolean r86 = (Boolean) r85;     // Catch: Throwable -> L311
        if (r86 == null) goto L270;
        r60 = r86;
        goto L309
    L270:
        if ((r59 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L278;
        Object r87 = Float.valueOf(((Number) r59).floatValue());     // Catch: Throwable -> L311
        if ((r87 instanceof Boolean) == true) goto L276;
        r87 = null;
    L276:
        r60 = (Boolean) r87;     // Catch: Throwable -> L311
        goto L309
    L278:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L284;
        Object r88 = Double.valueOf(((Number) r59).doubleValue());     // Catch: Throwable -> L311
        if ((r88 instanceof Boolean) == true) goto L282;
        r88 = null;
    L282:
        r60 = (Boolean) r88;     // Catch: Throwable -> L311
        goto L309
    L284:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        Object r89 = Integer.valueOf(((Number) r59).intValue());     // Catch: Throwable -> L311
        if ((r89 instanceof Boolean) == true) goto L288;
        r89 = null;
    L288:
        r60 = (Boolean) r89;     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Object r90 = Long.valueOf(((Number) r59).longValue());     // Catch: Throwable -> L311
        if ((r90 instanceof Boolean) == true) goto L294;
        r90 = null;
    L294:
        r60 = (Boolean) r90;     // Catch: Throwable -> L311
    L296:
        if ((r59 instanceof JSONObject) == false) goto L298;
    L737:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r91 = SDKSettingsCacheManager.a().fromJson(r59.toString(), Boolean.class);     // Catch: Throwable -> L304
        if ((r91 instanceof Boolean) == true) goto L302;
        r91 = null;
    L302:
        r60 = Result.constructor-impl((Boolean) r91);     // Catch: Throwable -> L304
    L307:
        if (Result.isFailure-impl(r60) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r92 = Result.Companion;     // Catch: Throwable -> L311
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L307
    L298:
        if ((r59 instanceof JSONArray) == false) goto L308;
    L265:
        r85 = r59;
    L418:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        Object r94 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r95 = Result.exceptionOrNull-impl(r94);
        if (r95 == null) goto L423;
        EnsureManager.ensureNotReachHere(r95);
    L423:
        if (Result.isFailure-impl(r94) == true) goto L426;
        r57 = r94;
    L426:
        r63 = r57;
    L311:
        th = move-exception;
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L418
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L418
    L434:
        Map<String, Long> r97 = TabkitPrefetch.a;
        String r98 = r114;
        Intrinsics.checkNotNullParameter(r10, r98);
        String r99 = r10.getApiUrl();
        if (r99 != null) goto L437;
        PrefetchJobKey r100 = null;
    L454:
        dm.a.a("ECTabKitDebug").i("Router NA Prefetch ---> " + System.currentTimeMillis());
        int r101 = com.bytedance.android.shopping.store.tabkit.ssr.c.a;
        Intrinsics.checkNotNullParameter(r10, r98);
        Intrinsics.checkNotNullParameter(r52, "abilityConfig");
        String r102 = r10.getAnchorUrl();
        if (r102 != null) goto L457;
    L460:
        boolean r103 = true;
    L462:
        if (r103 == true) goto L596;
        String r104 = r10.getSsrUrl();
        if (r104 != null) goto L466;
    L469:
        boolean r105 = true;
    L470:
        if (r105 == true) goto L596;
        Lazy r106 = ECAppInfoService.a;
        if (we.a.a == true) goto L596;
        if ((!Intrinsics.areEqual(r10.getAnchorUrlType(), "lynx")) == true) goto L596;
        Integer r107 = r10.getAnchorHybridContainer();
        if (r107 == null) goto L596;
        if (r107.intValue() != 1) goto L596;
        if (r52.b("disable_anniex_container") == true) goto L596;
        int r108 = nk3.a.a;
        String r109 = r10.getAnchorUrl();
        if (r109 != null) goto L488;
        long r210 = r7;
    L513:
        r51 = r51;
        String r211 = "disable_anniex_container";
        Object r212 = CommentScene.COMMENTSCENE_NO_AWEME;
    L592:
        boolean r115 = false;
    L593:
        if (r115 == true) goto L597;
        boolean r116 = true;
    L599:
        if (r116 == false) goto L614;
        String r117 = r10.getAnchorUrl();
        if (r117 == null) goto L614;
        String r118 = a2.c(r117);
        if (r118 == null) goto L614;
        TabKitViewModel.a r119 = TabKitViewModel.Companion;
        boolean r120 = r52.b("na_prefetch_sync_update");
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, "url");
        Intrinsics.checkNotNullParameter(r10, r98);
        String r121 = TabKitViewModel.a.a(r118, r10, true, r120, false);
        if (r121 == null) goto L614;
        if (n.c(r121) == null) goto L614;
        int r122 = ECSdk.a;
        IECHostService r123 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r123 == null) goto L614;
        r123.getECAnnieXHostService();
    L614:
        if (r52.b("na_prefetch_opt") == false) goto L683;
        String r124 = a2.d(r10.getAnchorUrl());
        if (r124 == null) goto L681;
        boolean r125 = r52.b("na_prefetch_sync_update");
        TabKitViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(r124, "url");
        Intrinsics.checkNotNullParameter(r10, r98);
        String r126 = TabKitViewModel.a.a(r124, r10, true, r125, false);
        if (com.bytedance.android.shopping.store.tabkit.drainageprefetch.b.c(r126) == false) goto L648;
        if (StringsKt.isBlank(r126) == true) goto L643;
        com.bytedance.android.shopping.store.tabkit.cache.a r127 = TabKitRouterCache.a(r126);
        LinkedHashMap r128 = new LinkedHashMap();
        r128.put("prefetch_request_state", String.valueOf(r127.b));
        r128.put("na_prefetch_strategy", String.valueOf(com.bytedance.android.shopping.store.tabkit.drainageprefetch.b.b(r126)));
        String r129 = new UrlInfo(r126).getPath();
        if (r129 == null) goto L629;
        com.bytedance.android.shopping.store.tabkit.cache.b r130 = (com.bytedance.android.shopping.store.tabkit.cache.b) TabKitRouterCache.b().get(r129);
        if (r130 == null) goto L629;
        r130.a = r128;
        TabKitRouterCache.b().put(r129, r130);
    L629:
        String r131 = r127.a;
        if (r131 != null) goto L632;
    L635:
        boolean r132 = true;
    L636:
        if (r132 == true) goto L643;
        ConcurrentHashMap r133 = NativePrefetchUtil.a;
        if (NativePrefetchUtil.l(r127.a) == false) goto L643;
        if (NativePrefetchUtil.b(r126, false, 6) == false) goto L643;
        String r134 = r127.a;
    L644:
        if (r134 == null) goto L667;
        String r135 = e(r134, r126);
    L668:
        if (r135 != null) goto L676;
        boolean r213 = r52.b("na_prefetch_thread_opt");
        boolean r136 = hk3.b.c(r126);
        boolean r214 = Intrinsics.areEqual(r10.getAnchorUrlType(), "lynx");
        String r215 = a2.c(r10.getNaPrefetchCert());
        if (r125 == true) goto L674;
        if (r136 == true) goto L674;
        boolean r216 = false;
    L675:
        r135 = TabkitPrefetch.a(r126, r214, r215, r213, r216, 32).a;
    L674:
        r216 = true;
    L676:
        String r137 = d(r135);
        if (com.bytedance.android.shopping.extensions.k.c(r10.getParamsMap().get("url")) == false) goto L679;
        r10.getParamsMap().put("url", r137);
        goto L681
    L679:
        r10.getParamsMap().put("anchor_url", r137);
    L667:
        r135 = null;
        goto L668
    L632:
        if (StringsKt.isBlank(r131) == true) goto L635;
        r132 = false;
    L643:
        r134 = null;
        goto L644
    L648:
        if (StringsKt.isBlank(r126) == true) goto L664;
        com.bytedance.android.shopping.store.tabkit.cache.a r138 = TabKitRouterCache.a(r126);
        String r139 = r138.a;
        if (r139 != null) goto L653;
    L656:
        boolean r140 = true;
    L657:
        if (r140 == true) goto L664;
        ConcurrentHashMap r141 = NativePrefetchUtil.a;
        if (NativePrefetchUtil.l(r138.a) == false) goto L664;
        if (NativePrefetchUtil.b(r126, false, 6) == false) goto L664;
        String r142 = r138.a;
    L665:
        if (r142 == null) goto L667;
        r135 = e(r142, r126);
        goto L668
    L653:
        if (StringsKt.isBlank(r139) == true) goto L656;
        r140 = false;
    L664:
        r142 = null;
    L681:
        TabkitPrefetch.c(r10.getBizTag());
    L683:
        Integer r143 = r10.getAnchorHybridContainer();
        if (r143 != null) goto L687;
    L699:
        TabkitFirstFramePref r144 = r113;
    L700:
        String r145 = r10.getAnchorUrl();
        int r146 = hk3.b.a;
        if (r145 == null) goto L713;
        String r147 = n.b(r145);
        if (r147 == null) goto L713;
        if ((!StringsKt.isBlank(r147)) == true) goto L708;
        r147 = null;
    L708:
        if (r147 == null) goto L713;
        if (hk3.b.g(hk3.b.h().b(), hk3.b.j().b(), r147) <= 0) goto L713;
        boolean r148 = true;
    L714:
        TabkitPrefetch.b(r10, r148, r52.b("preload_anchor_url"));
        if (Intrinsics.areEqual(r10.getParamsMap().get("enable_tabkit_lite_page"), r212) == true) goto L717;
    L719:
        boolean r149 = false;
    L720:
        Bundle r150 = r51;
        r150.putSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS, r10);
        r150.putSerializable("tabkit_prefetch", r100);
        r150.putSerializable(TabkitFirstFramePref.KEY_TABKIT_MONITOR, Long.valueOf(r210));
        r150.putSerializable("pre_create_anniex_uid", null);
        r150.putBoolean("tabkit_lite_page", r149);
        TabkitFramePref.recordTime$default(r144, TabkitFirstFramePref.T_PAGE_INIT_START, null, 2, null);
        int r151 = TabKitFragment.h;
        TabKitFragment.a.a(r30, DefaultTabKitFragment.class, r150, r149);
        return true;
    L717:
        if (r52.b("tabkit_lite_page") == false) goto L719;
        r149 = true;
    L713:
        r148 = false;
        goto L714
    L687:
        if (r143.intValue() != 1) goto L699;
        if (r52.b(r211) == true) goto L699;
        if (r52.b("enable_anniex_async_create") == false) goto L699;
        r144 = r113;
        TabkitFramePref.recordTime$default(r144, "t_start_pre_create_annie", null, 2, null);
        if (r10.getAnchorUrl() == null) goto L700;
        int r152 = ECSdk.a;
        IECHostService r153 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r153 == null) goto L700;
        r153.getECAnnieXHostService();
    L597:
        r116 = false;
        goto L599
    L488:
        String r154 = UriProtector.parse(r109).getPath();
        if (r154 != null) goto L491;
        r154 = "";
    L491:
        List r155 = StringsKt.split$default(r154, new String[]{"/"}, false, 0, 6, null);
        if (r155.isEmpty() == true) goto L497;
        r210 = r7;
        if (r155.size() < 6) goto L498;
        String r156 = "/" + ((String) ListProtector.get(r155, 1)) + '/' + ((String) ListProtector.get(r155, 2)) + '/' + ((String) ListProtector.get(r155, 3)) + '/' + ((String) ListProtector.get(r155, 4)) + '/' + ((String) ListProtector.get(r155, 5));
    L499:
        if (r156 == null) goto L513;
        com.bytedance.geckox.b r157 = com.bytedance.geckox.b.a.a;
        GlobalConfigSettings r158 = com.bytedance.geckox.b.b();
        if (r158 == null) goto L506;
        GlobalConfigSettings.ResourceMeta r159 = r158.getResourceMeta();
        if (r159 == null) goto L506;
        GlobalConfigSettings.CurrentLevelConfig r160 = r159.getConfig();
    L507:
        if (r160 == null) goto L511;
        Map r161 = r160.getPrefix2AccessKey();
        if (r161 == null) goto L511;
        String r162 = (String) r161.get(r156);
    L512:
        if (r162 == null) goto L513;
        if (r109.length() <= 0) goto L517;
        boolean r163 = true;
    L518:
        if (r163 == true) goto L520;
    L580:
        r51 = r51;
        r211 = "disable_anniex_container";
        r212 = CommentScene.COMMENTSCENE_NO_AWEME;
    L581:
        Pair r164 = null;
    L582:
        if (r164 == null) goto L592;
        String r165 = (String) r164.getFirst();
        if (r165 == null) goto L592;
        Intrinsics.checkNotNullParameter(r162, "accessKey");
        Intrinsics.checkNotNullParameter(r165, "channel");
        Map r166 = GlobalManager.d;
        if (r166 == null) goto L592;
        String r167 = (String) ((ConcurrentHashMap) r166).get(r162);
        if (r167 == null) goto L592;
        r115 = ResLoadUtils.checkExist(new PolarisFileWrapper(r167), r162, r165);
        goto L593
    L520:
        if (r156.length() <= 0) goto L522;
        boolean r168 = true;
    L523:
        if (r168 == false) goto L580;
        Integer r169 = Integer.valueOf(StringsKt.indexOf$default(r109, '?', 0, false, 6, null));
        Integer r170 = r169;
        if (r169.intValue() == (-1)) goto L527;
        boolean r171 = true;
    L528:
        if (r171 == true) goto L531;
        r170 = null;
    L531:
        if (r170 == null) goto L533;
        r109 = r109.substring(0, r170.intValue());
    L533:
        Integer r172 = Integer.valueOf(StringsKt.indexOf$default(r109, '#', 0, false, 6, null));
        Integer r173 = r172;
        if (r172.intValue() == (-1)) goto L536;
        boolean r174 = true;
    L537:
        if (r174 == true) goto L541;
        r173 = null;
    L541:
        if (r173 == null) goto L547;
        int r175 = r173.intValue();
        if (r109 == null) goto L546;
        boolean r176 = false;
        r109 = r109.substring(0, r175);
    L548:
        r211 = "disable_anniex_container";
        r212 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (StringsKt.endsWith$default(r156, '/', r176, 2, null) == true) goto L551;
        r156 = r156.concat("/");
    L551:
        Integer r177 = Integer.valueOf(StringsKt.indexOf$default(r109, r156, 0, false, 6, null));
        if (r177.intValue() == (-1)) goto L554;
        boolean r178 = true;
    L555:
        if (r178 == true) goto L558;
        r177 = null;
    L558:
        if (r177 == null) goto L581;
        int r179 = r177.intValue() + r156.length();
        if (r109 == null) goto L579;
        String r180 = r109.substring(r179);
        Integer r181 = Integer.valueOf(StringsKt.indexOf$default(r180, '/', 0, false, 6, null));
        if (r181.intValue() == (-1)) goto L564;
        boolean r182 = true;
    L565:
        if (r182 == true) goto L568;
        r181 = null;
    L568:
        if (r181 == null) goto L581;
        int r183 = r181.intValue();
        if (r180 == null) goto L577;
        String r184 = r180.substring(0, r183);
        String r185 = r180.substring(r183 + 1);
        if ((!StringsKt.isBlank(r184)) == false) goto L581;
        if ((!StringsKt.isBlank(r185)) == false) goto L581;
        r164 = TuplesKt.to(r184, r185);
        goto L582
    L577:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L564:
        r182 = false;
        goto L565
    L579:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L554:
        r178 = false;
        goto L555
    L546:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L547:
        r176 = false;
        goto L548
    L536:
        r174 = false;
        goto L537
    L527:
        r171 = false;
        goto L528
    L522:
        r168 = false;
        goto L523
    L517:
        r163 = false;
    L511:
        r162 = null;
    L506:
        r160 = null;
    L498:
        r156 = null;
        goto L499
    L497:
        r210 = r7;
        goto L498
    L466:
        if (StringsKt.isBlank(r104) == true) goto L469;
        r105 = false;
    L596:
        r51 = r51;
        r210 = r7;
        r211 = "disable_anniex_container";
        r212 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L597
    L457:
        if (StringsKt.isBlank(r102) == true) goto L460;
        r103 = false;
        goto L462
    L437:
        ReplaySubject r186 = ReplaySubject.a();
        Map<Long, TabkitFirstFramePref> r187 = ok3.a.e;
        TabkitFirstFramePref r188 = ok3.a.C0149a.a(r7);
        if (r188 == null) goto L440;
        TabkitFramePref.recordTime$default(r188, TabkitFirstFramePref.T_REQUEST_START, null, 2, null);
    L440:
        TabKitApi.a.getClass();
        TabKitApi r189 = TabKitApi.a.a;
        if (r189 == null) goto L449;
        int r190 = DefaultTabKitFragment.n;
        Observable<z> r191 = r189.fetchCustomTab(r99, DefaultTabKitFragment.a.a(r10));
        if (r191 == null) goto L449;
        Observable r192 = r191.subscribeOn(Schedulers.io());
        if (r192 == null) goto L449;
        Observable r193 = r192.map(new com.bytedance.android.shopping.store.tabkit.brandmall.b(r188));
        if (r193 == null) goto L449;
        r193.subscribe(r186);
    L449:
        r100 = new TabkitPrefetchJobKey();
        ConcurrentHashMap r194 = com.bytedance.android.ec.store.prefetch.a.a;
        PrefetchScene r195 = PrefetchScene.TABKIT;
        Intrinsics.checkNotNullParameter(r195, "scene");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r186, "subject");
        ConcurrentHashMap r196 = com.bytedance.android.ec.store.prefetch.a.a;
        ConcurrentHashMap r197 = (ConcurrentHashMap) r196.get(r195);
        if (r197 != null) goto L453;
        r197 = new ConcurrentHashMap();
        r196.put(r195, r197);
    L453:
        r197.put(r100, r186);
    L249:
        r50 = false;
        goto L250
    L244:
        r49 = 3;
        r48 = 1;
        goto L245
    L235:
        r114 = "routerParams";
        r47 = 1;
        goto L237
    L226:
        r113 = r4;
        r46 = 1;
        goto L228
    L105:
        int r198 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L192
        Object r199 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_schema_rules_aweme");     // Catch: Throwable -> L158
        if (r199 != null) goto L110;
    L155:
        Object r200 = null;
    L156:
        Object r201 = Result.constructor-impl(r200);     // Catch: Throwable -> L158
    L160:
        Throwable r202 = Result.exceptionOrNull-impl(r201);     // Catch: Throwable -> L183
        if (r202 == null) goto L164;
        EnsureManager.ensureNotReachHere(r202);     // Catch: Throwable -> L183
    L164:
        if (Result.isFailure-impl(r201) == false) goto L167;
        r201 = null;
    L167:
        if ((r201 instanceof c0) == true) goto L169;
        r201 = null;
    L169:
        c0 r203 = (c0) r201;     // Catch: Throwable -> L183
        if (r203 == null) goto L172;
        Object r204 = r203;
    L190:
        com.bytedance.android.ec.base.settings.d.d("ec_tabkit_schema_rules_aweme", r204);     // Catch: Throwable -> L192
        r34 = r204;
        goto L201
    L172:
        IHybridHostService r205 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L183
        if (r205 == null) goto L175;
        Object r206 = r205.getHostABValue("ec_tabkit_schema_rules_aweme", r110);     // Catch: Throwable -> L183
    L176:
        if (r206 != null) goto L178;
    L189:
        r204 = r110;
        goto L190
    L178:
        if ((r206 instanceof c0) == true) goto L180;
        r206 = null;
    L180:
        c0 r207 = (c0) r206;     // Catch: Throwable -> L183
        r204 = r207;
        if (r207 != null) goto L190;
    L183:
        th = move-exception;
        Result.Companion r208 = Result.Companion;     // Catch: Throwable -> L192
        Object r209 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L192
        Throwable r217 = Result.exceptionOrNull-impl(r209);     // Catch: Throwable -> L192
        if (r217 == null) goto L187;
        EnsureManager.ensureNotReachHere(r217);     // Catch: Throwable -> L192
    L187:
        boolean r218 = Result.isFailure-impl(r209);     // Catch: Throwable -> L192
        r204 = r209;
        if (r218 == false) goto L190;
    L175:
        r206 = null;
        goto L176
    L110:
        if ((r199 instanceof c0) == true) goto L112;
        Object r219 = null;
    L113:
        c0 r220 = (c0) r219;     // Catch: Throwable -> L158
        if (r220 == null) goto L117;
        r200 = r220;
        goto L156
    L117:
        if ((r199 instanceof Number) == false) goto L143;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L125;
        Object r221 = Float.valueOf(((Number) r199).floatValue());     // Catch: Throwable -> L158
        if ((r221 instanceof c0) == true) goto L123;
        r221 = null;
    L123:
        r200 = (c0) r221;     // Catch: Throwable -> L158
        goto L156
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L131;
        Object r222 = Double.valueOf(((Number) r199).doubleValue());     // Catch: Throwable -> L158
        if ((r222 instanceof c0) == true) goto L129;
        r222 = null;
    L129:
        r200 = (c0) r222;     // Catch: Throwable -> L158
        goto L156
    L131:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L137;
        Object r223 = Integer.valueOf(((Number) r199).intValue());     // Catch: Throwable -> L158
        if ((r223 instanceof c0) == true) goto L135;
        r223 = null;
    L135:
        r200 = (c0) r223;     // Catch: Throwable -> L158
        goto L156
    L137:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L143;
        Object r224 = Long.valueOf(((Number) r199).longValue());     // Catch: Throwable -> L158
        if ((r224 instanceof c0) == true) goto L141;
        r224 = null;
    L141:
        r200 = (c0) r224;     // Catch: Throwable -> L158
    L143:
        if ((r199 instanceof JSONObject) == false) goto L145;
    L747:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L151
        Object r225 = SDKSettingsCacheManager.a().fromJson(r199.toString(), c0.class);     // Catch: Throwable -> L151
        if ((r225 instanceof c0) == true) goto L149;
        r225 = null;
    L149:
        r200 = Result.constructor-impl((c0) r225);     // Catch: Throwable -> L151
    L154:
        if (Result.isFailure-impl(r200) == false) goto L156;
    L151:
        th = move-exception;
        Result.Companion r226 = Result.Companion;     // Catch: Throwable -> L158
        r200 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L154
    L145:
        if ((r199 instanceof JSONArray) == false) goto L155;
    L112:
        r219 = r199;
    L158:
        th = move-exception;
        Result.Companion r227 = Result.Companion;     // Catch: Throwable -> L183
        r201 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L183
        goto L160
    L99:
        Object r228 = com.bytedance.android.ec.base.settings.d.a.get("ec_tabkit_schema_rules_aweme");     // Catch: Throwable -> L192
        if ((r228 instanceof c0) == true) goto L102;
        r228 = null;
    L102:
        r33 = (c0) r228;     // Catch: Throwable -> L192
        goto L103
    L37:
        if ((r25 instanceof c0) == true) goto L39;
        Object r1100 = null;
    L40:
        c0 r1101 = (c0) r1100;     // Catch: Throwable -> L85
        if (r1101 == null) goto L44;
        r26 = r1101;
        goto L83
    L44:
        if ((r25 instanceof Number) == false) goto L70;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L52;
        Object r229 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L85
        if ((r229 instanceof c0) == true) goto L50;
        r229 = null;
    L50:
        r26 = (c0) r229;     // Catch: Throwable -> L85
        goto L83
    L52:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L58;
        Object r230 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L85
        if ((r230 instanceof c0) == true) goto L56;
        r230 = null;
    L56:
        r26 = (c0) r230;     // Catch: Throwable -> L85
        goto L83
    L58:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L64;
        Object r231 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L85
        if ((r231 instanceof c0) == true) goto L62;
        r231 = null;
    L62:
        r26 = (c0) r231;     // Catch: Throwable -> L85
        goto L83
    L64:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c0.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L70;
        Object r232 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L85
        if ((r232 instanceof c0) == true) goto L68;
        r232 = null;
    L68:
        r26 = (c0) r232;     // Catch: Throwable -> L85
    L70:
        if ((r25 instanceof JSONObject) == false) goto L72;
    L741:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L78
        Object r233 = SDKSettingsCacheManager.a().fromJson(r25.toString(), c0.class);     // Catch: Throwable -> L78
        if ((r233 instanceof c0) == true) goto L76;
        r233 = null;
    L76:
        r26 = Result.constructor-impl((c0) r233);     // Catch: Throwable -> L78
    L81:
        if (Result.isFailure-impl(r26) == false) goto L83;
    L78:
        th = move-exception;
        Result.Companion r234 = Result.Companion;     // Catch: Throwable -> L85
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L85
        goto L81
    L72:
        if ((r25 instanceof JSONArray) == false) goto L82;
    L39:
        r1100 = r25;
    L85:
        th = move-exception;
        Result.Companion r235 = Result.Companion;     // Catch: Throwable -> L192
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L192
    L192:
        th = move-exception;
        Result.Companion r236 = Result.Companion;
        Object r237 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r238 = Result.exceptionOrNull-impl(r237);
        if (r238 == null) goto L196;
        EnsureManager.ensureNotReachHere(r238);
    L196:
        Object r1102 = r110;
        if (Result.isFailure-impl(r237) == true) goto L200;
        r1102 = r237;
    L200:
        r34 = r1102;
    L13:
        th = move-exception;
        Result.Companion r1103 = Result.Companion;
        Object r239 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r239) == true) goto L18;
        r12 = r239;
    L18:
        r8 = r12;
        goto L20
    }
}
