package com.bytedance.android.shopping.sku.common.controller.uplink;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import com.bytedance.android.shopping.sku.common.utils.e;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import com.bytedance.kmp.ec.yata.event.common.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v96.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonUplinkController {
    public static final /* synthetic */ int e = 0;
    public final d a;
    public final long b;
    public final String c;
    public final mh3.a d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        final long r0 = this.a.c.addAndGet(1);
        f(new SkuCommonUplinkController$addAndGetCurVersion$1(r0));
    }

    public final long c() {
        final long r0 = this.a.c.get();
        f(new SkuCommonUplinkController$getCurVersion$1(r0));
        return r0;
    }

    public SkuCommonUplinkController(mh3.a r3) {
        this.d = r3;
        this.a = new d();
        this.b = System.currentTimeMillis();
        this.c = "";
    }

    public final boolean b(com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        final String r5 = r4.b;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        d r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "triggerType");
        Iterator<T> r1 = r0.a.b.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((c) r2).b, r5) == false) goto L7;
    L13:
        if (r2 == null) goto L15;
        boolean r3 = true;
    L16:
        final boolean r6 = true ^ r3;
        f(new SkuCommonUplinkController$canShowLoading$1(r6, r5));
        return r6;
    L15:
        r3 = false;
        goto L16
    L11:
        r2 = null;
        goto L13
    }

    public final void f(final Function0<String> r2) {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonUplinkController", new SkuCommonUplinkController$printLog$1(this, r2));
    }

    public final void g(com.bytedance.android.shopping.sku.inner.repo.a r5) {
        Intrinsics.checkNotNullParameter(r5, "queryResponse");
        f(SkuCommonUplinkController$updateInstanceAfterQuery$1.INSTANCE);
        d r0 = this.a;
        long r1 = r0.d;
        Intrinsics.checkNotNullParameter(r5, "resp");
        r0.d = r1;
        r0.e = r5;
    }

    public final void h(final com.bytedance.android.shopping.sku.common.controller.uplink.a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Lazy r1 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonUplinkController", new SkuCommonUplinkController$updateSkipTriggerInfos$1(r4));
        SkuCommonLog.a("SkuCommonUplinkController", new SkuCommonUplinkController$updateSkipTriggerInfos$2(r4));
        d r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        r2.a = r4;
    }

    public final com.bytedance.kmp.ec.yata.event.ability.uplink.b d(final AndroidYaTaInstance r13, com.bytedance.kmp.ec.yata.event.ability.uplink.a r14) {
        Intrinsics.checkNotNullParameter(r13, "yataInstance");
        Intrinsics.checkNotNullParameter(r14, "info");
        f(SkuCommonUplinkController$handleResponse$1.INSTANCE);
        final com.bytedance.kmp.ec.yata.common.protocol.data.a r1 = r14.c;
        final j r15 = r14.b;
        String r2 = this.c;
        monitor-enter(r2);
        if (r1 == null) goto L72;
        com.bytedance.kmp.ec.yata.common.protocol.data.a r4 = r1;
    L10:
        Map r5 = r15.b;     // Catch: Throwable -> L7
        if (r5 == null) goto L13;
        Object r6 = r5.get("uplink_version");     // Catch: Throwable -> L7
    L15:
        if ((r6 instanceof Long) == true) goto L17;
        r6 = null;
    L17:
        final Long r7 = (Long) r6;     // Catch: Throwable -> L7
        f(new SkuCommonUplinkController$handleResponse$2$1(r7));     // Catch: Throwable -> L7
        if (r7 == null) goto L25;
        if (r7.longValue() < this.a.d) goto L25;
        if (f.d(r4) == false) goto L25;
        f(SkuCommonUplinkController$handleResponse$2$2.INSTANCE);     // Catch: Throwable -> L7
        d r8 = this.a;     // Catch: Throwable -> L7
        long r9 = r7.longValue();     // Catch: Throwable -> L7
        com.bytedance.android.shopping.sku.inner.repo.a r10 = ma3.c.b(r4);     // Catch: Throwable -> L7
        r8.getClass();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r10, "resp");     // Catch: Throwable -> L7
        r8.d = r9;     // Catch: Throwable -> L7
        r8.e = r10;     // Catch: Throwable -> L7
    L25:
        if (r7 != null) goto L27;
        this.a.b();     // Catch: Throwable -> L7
        f(SkuCommonUplinkController$handleResponse$2$11.INSTANCE);     // Catch: Throwable -> L7
        mh3.a r16 = this.d;     // Catch: Throwable -> L7
        if (r16 == null) goto L67;
        com.bytedance.android.shopping.sku.common.monitor.error.a r17 = r16.c;     // Catch: Throwable -> L7
        if (r17 == null) goto L67;
        SkuErrorMonitorType r18 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;     // Catch: Throwable -> L7
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r3 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;     // Catch: Throwable -> L7
        r17.a(r18, "UplinkController 数据非法", null);     // Catch: Throwable -> L7
    L67:
        com.bytedance.kmp.ec.yata.event.ability.uplink.b r19 = new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r19;
    L27:
        if (r7.longValue() >= this.a.c.get()) goto L31;
        f(SkuCommonUplinkController$handleResponse$2$3.INSTANCE);     // Catch: Throwable -> L7
        com.bytedance.kmp.ec.yata.event.ability.uplink.b r110 = new com.bytedance.kmp.ec.yata.event.ability.uplink.b(false);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r110;
    L31:
        final b r11 = this.a.a();     // Catch: Throwable -> L7
        if (r11.a == true) goto L36;
        f(SkuCommonUplinkController$handleResponse$2$4.INSTANCE);     // Catch: Throwable -> L7
        com.bytedance.kmp.ec.yata.event.ability.uplink.b r111 = new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r111;
    L36:
        f(new SkuCommonUplinkController$handleResponse$2$5(r11));     // Catch: Throwable -> L7
        this.a.b();     // Catch: Throwable -> L7
        if (f.d(r4) == true) goto L59;
        String r12 = r4.b();     // Catch: Throwable -> L7
        if (r12 != null) goto L41;
    L44:
        boolean r20 = true;
    L46:
        if ((true ^ r20) == true) goto L49;
        r12 = null;
    L49:
        if (r12 == null) goto L51;
        SkuCommonToast.c(r12);     // Catch: Throwable -> L7
    L51:
        e.a r21 = e.a;     // Catch: Throwable -> L7
        e.b(new SkuCommonUplinkController$handleResponse$$inlined$synchronized$lambda$1(this, r1, r15, r13));     // Catch: Throwable -> L7
        mh3.a r112 = this.d;     // Catch: Throwable -> L7
        if (r112 == null) goto L56;
        com.bytedance.android.shopping.sku.common.monitor.error.a r113 = r112.c;     // Catch: Throwable -> L7
        if (r113 == null) goto L56;
        SkuErrorMonitorType r114 = SkuErrorMonitorType.UPLINK_ROLLBACK;     // Catch: Throwable -> L7
        String r0 = "inOperationModuleKey:" + r11.b;     // Catch: Throwable -> L7
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r22 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;     // Catch: Throwable -> L7
        r113.a(r114, r0, null);     // Catch: Throwable -> L7
    L56:
        f(SkuCommonUplinkController$handleResponse$2$9.INSTANCE);     // Catch: Throwable -> L7
        com.bytedance.kmp.ec.yata.event.ability.uplink.b r115 = new com.bytedance.kmp.ec.yata.event.ability.uplink.b(false);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r115;
    L41:
        if (StringsKt.isBlank(r12) == true) goto L44;
        r20 = false;
        goto L46
    L59:
        f(SkuCommonUplinkController$handleResponse$2$10.INSTANCE);     // Catch: Throwable -> L7
        com.bytedance.kmp.ec.yata.event.ability.uplink.b r116 = new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r116;
    L13:
        r6 = null;
        goto L15
    L72:
        r4 = new com.bytedance.kmp.ec.yata.common.protocol.data.e(null);     // Catch: Throwable -> L7
        r4.d(-1);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final h e(EventTriggerInfo r20, AndroidYaTaInstance r21) {
        Intrinsics.checkNotNullParameter(r20, "eventTriggerInfo");
        final String r4 = r20.b();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Map<String, UltimateBuyCacheQueryHelper> r6 = UltimateBuyCacheHelper.b;
        boolean r7 = UltimateBuyCacheHelper.e(r21, null);
        if (r7 == false) goto L86;
        d r9 = this.a;
        if (r21 == null) goto L10;
        Map r10 = r21.j();
    L11:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r20, "eventTriggerInfo");
        String r11 = r20.b();
        if (r11 != null) goto L14;
        r11 = "";
        String r17 = r11;
    L16:
        if (r10 == null) goto L18;
        Object r12 = r10.get("cache_trigger_list");
    L20:
        if ((r12 instanceof Map) == true) goto L22;
        r12 = null;
    L22:
        Map r13 = (Map) r12;
        if (r13 == null) goto L25;
        Object r8 = r13.get("black_triggers");
    L27:
        if ((r8 instanceof List) == true) goto L29;
        r8 = null;
    L29:
        List r14 = (List) r8;
        if (r14 == null) goto L34;
        boolean r15 = CollectionsKt.contains(r14, r11);
        boolean r16 = true;
        if (r15 != true) goto L35;
        SkuCommonLog.c("SkuCommonUplinkDataHelper", "isInCacheBlackTriggerList: true");
        boolean r18 = true;
    L36:
        if (r18 == true) goto L38;
        d r19 = this.a;
        if (r21 == null) goto L42;
        Map r2 = r21.j();
    L43:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "eventTriggerInfo");
        String r22 = r20.b();
        if (r22 != null) goto L46;
        r22 = r17;
    L46:
        if (r2 == null) goto L48;
        Object r3 = r2.get("cache_trigger_list");
    L50:
        if ((r3 instanceof Map) == true) goto L52;
        r3 = null;
    L52:
        Map r5 = (Map) r3;
        if (r5 == null) goto L55;
        Object r23 = r5.get("white_triggers");
    L57:
        if ((r23 instanceof List) == true) goto L59;
        r23 = null;
    L59:
        List r24 = (List) r23;
        if (r24 == null) goto L65;
        if (CollectionsKt.contains(r24, r22) != true) goto L65;
    L77:
        boolean r25 = true;
    L78:
        if (r25 == true) goto L87;
        f(new SkuCommonUplinkController$handleTrigger$1(r4));
        SkuCommonToast.c("加载中，请稍等");
        mh3.a r1 = this.d;
        if (r1 == null) goto L85;
        com.bytedance.android.shopping.sku.common.monitor.error.a r26 = r1.c;
        if (r26 == null) goto L85;
        SkuErrorMonitorType r27 = SkuErrorMonitorType.CACHE_TRIGGER_INTERCEPTED;
        String r28 = "trigger:" + r4 + "  inOperationModule:isClientCache";
        JSONObject r29 = new JSONObject();
        r29.put("trigger", r4);
        r29.put("in_operation_module", "isClientCache");
        Unit r30 = Unit.INSTANCE;
        r26.a(r27, r28, r29);
    L85:
        return new h(true);
    L87:
        d r31 = this.a;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r20, "eventTriggerInfo");
        String r32 = r20.b();
        if (r32 != null) goto L91;
        r32 = r17;
    L91:
        if (r31.a.a.contains(r32) == true) goto L99;
        Map r33 = ((com.bytedance.kmp.ec.yata.event.common.f) r20.b.getValue()).e;
        if (r33 == null) goto L96;
        Object r34 = r33.get("slc_exposure_ratio");
    L97:
        if (r34 == null) goto L100;
        Lazy r35 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonUplinkDataHelper", "slc_exposure_ratio: " + r34);
        goto L99
    L100:
        boolean r36 = false;
    L101:
        if (r36 == true) goto L103;
        b r37 = this.a.a();
        d r38 = this.a;
        r38.getClass();
        Intrinsics.checkNotNullParameter(r4, "triggerType");
        Iterator<T> r39 = r38.a.b.iterator();
    L106:
        if (r39.hasNext() == false) goto L110;
        Object r40 = r39.next();
        if (Intrinsics.areEqual(((c) r40).b, r4) == false) goto L106;
        Object r41 = r40;
    L111:
        c r42 = (c) r41;
        if (r42 == null) goto L117;
        String r43 = r42.a;
        if (r43 == null) goto L117;
        String r44 = r43;
    L118:
        String r45 = r37.b;
        if (r37.a == true) goto L121;
    L133:
        f(new SkuCommonUplinkController$handleTrigger$result$3(r4));
        if (r7 == true) goto L140;
        d r46 = this.a;
        r46.getClass();
        Intrinsics.checkNotNullParameter(r44, "moduleKey");
        if (StringsKt.isBlank(r44) == true) goto L140;
        r46.b.put(r44, Boolean.TRUE);
    L140:
        return new h(false);
    L121:
        if ((!Intrinsics.areEqual(r45, r44)) == false) goto L133;
        f(new SkuCommonUplinkController$handleTrigger$result$1(r4));
        if (ECAppInfoService.e.i() == false) goto L127;
        cl.d r47 = k.a();
        if (r47 == null) goto L127;
        r47.b();
    L127:
        SkuCommonToast.c("加载中，请稍等");
        mh3.a r48 = this.d;
        if (r48 == null) goto L144;
        com.bytedance.android.shopping.sku.common.monitor.error.a r49 = r48.c;
        if (r49 == null) goto L144;
        SkuErrorMonitorType r50 = SkuErrorMonitorType.TRIGGER_INTERCEPTED;
        String r51 = "trigger:" + r4 + "  inOperationModule:" + r45;
        JSONObject r52 = new JSONObject();
        r52.put("trigger", r4);
        r52.put("in_operation_module", r45);
        Unit r53 = Unit.INSTANCE;
        r49.a(r50, r51, r52);
    L144:
        return new h(true);
    L117:
        r44 = r17;
        goto L118
    L110:
        r41 = null;
        goto L111
    L103:
        return new h(false);
    L96:
        r34 = null;
    L99:
        r36 = true;
    L65:
        if (Intrinsics.areEqual(r22, "AfterRender") == false) goto L67;
    L76:
        Lazy r54 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonUplinkDataHelper", "AfterRender or AutoExposure : ".concat(r22));
        goto L77
    L67:
        if (Intrinsics.areEqual(r22, "AutoExposure") == true) goto L76;
        Map r55 = ((com.bytedance.kmp.ec.yata.event.common.f) r20.b.getValue()).e;
        if (r55 == null) goto L72;
        Object r56 = r55.get("slc_exposure_ratio");
    L73:
        if (r56 == null) goto L75;
        Lazy r57 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonUplinkDataHelper", "slc_exposure_ratio: " + r56);
        goto L77
    L75:
        r25 = false;
        goto L78
    L72:
        r56 = null;
        goto L73
    L55:
        r23 = null;
        goto L57
    L48:
        r3 = null;
        goto L50
    L42:
        r2 = null;
        goto L43
    L38:
        return new h(r16);
    L35:
        r18 = false;
        goto L36
    L34:
        r16 = true;
        goto L35
    L25:
        r8 = null;
        goto L27
    L18:
        r12 = null;
        goto L20
    L14:
        r17 = "";
        goto L16
    L10:
        r10 = null;
        goto L11
    L86:
        r17 = "";
        r7 = r7;
        goto L87
    }
}
