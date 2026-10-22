package com.bytedance.android.shopping.deepfeed.slice;

import android.content.Context;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.deepfeed.ui.vh.p;
import com.bytedance.android.shopping.deepfeed.utlis.k;
import com.bytedance.common.utility.Logger;
import com.bytedance.forest.Forest;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements wc3.b {
    public static final int e = 0;
    public SlcRenderContext a;
    public com.bytedance.android.ecom.slice.ext.template.gecko.c b;
    public final Map<String, com.bytedance.android.ecom.arch.slice.render.context.a> c;
    public final Map<String, List<r>> d;

    public static final class a {
    }

    static {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = 1;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L160
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("deep_feed_fix_vivo_navigation");     // Catch: Throwable -> L54
        if (r4 != null) goto L9;
    L51:
        Object r5 = null;
    L52:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L54
    L56:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L160
        if (r7 == null) goto L60;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r6) == false) goto L63;
        r6 = null;
    L63:
        if ((r6 instanceof Integer) == true) goto L65;
        r6 = null;
    L65:
        Object r8 = (Integer) r6;     // Catch: Throwable -> L160
        if (r8 != null) goto L72;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("deep_feed_fix_vivo_navigation");     // Catch: Throwable -> L160
        if ((r9 instanceof Integer) == true) goto L71;
        r9 = null;
    L71:
        r8 = (Integer) r9;     // Catch: Throwable -> L160
    L72:
        if (r8 != null) goto L169;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("deep_feed_fix_vivo_navigation");     // Catch: Throwable -> L124
        if (r11 != null) goto L79;
    L121:
        Object r12 = null;
    L122:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L124
    L126:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L150
        if (r14 == null) goto L130;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r13) == false) goto L133;
        r13 = null;
    L133:
        if ((r13 instanceof Integer) == true) goto L135;
        r13 = null;
    L135:
        r8 = (Integer) r13;     // Catch: Throwable -> L150
        if (r8 != null) goto L158;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r15 == null) goto L141;
        Object r16 = r15.getHostABValue("deep_feed_fix_vivo_navigation", r1);     // Catch: Throwable -> L150
    L142:
        if (r16 != null) goto L144;
    L149:
        r8 = r1;
        goto L158
    L144:
        if ((r16 instanceof Integer) == false) goto L147;
        r3 = r16;
    L147:
        Object r17 = (Integer) r3;     // Catch: Throwable -> L150
        if (r17 == null) goto L149;
    L157:
        r8 = r17;
        goto L158
    L141:
        r16 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("deep_feed_fix_vivo_navigation", r8);     // Catch: Throwable -> L160
        goto L169
    L79:
        if ((r11 instanceof Integer) == true) goto L81;
        Object r18 = null;
    L82:
        r12 = (Integer) r18;     // Catch: Throwable -> L124
        if (r12 != null) goto L122;
        if ((r11 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L124
        if ((r19 instanceof Integer) == true) goto L92;
        r19 = null;
    L92:
        r12 = (Integer) r19;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L124
        if ((r20 instanceof Integer) == true) goto L98;
        r20 = null;
    L98:
        r12 = (Integer) r20;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r12 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r21 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L124
        if ((r21 instanceof Integer) == true) goto L107;
        r21 = null;
    L107:
        r12 = (Integer) r21;     // Catch: Throwable -> L124
    L109:
        if ((r11 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r22 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r22 instanceof Integer) == true) goto L115;
        r22 = null;
    L115:
        Object r23 = Result.constructor-impl((Integer) r22);     // Catch: Throwable -> L117
    L119:
        r12 = r23;
        if (Result.isFailure-impl(r12) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L124
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r11 instanceof JSONArray) == false) goto L121;
    L81:
        r18 = r11;
    L150:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L160
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r26 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L160
        if (r26 == null) goto L155;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r17) == false) goto L157;
        r17 = r1;
    L124:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L150
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L169:
        e = ((Number) r8).intValue();
        return;
    L9:
        if ((r4 instanceof Integer) == true) goto L11;
        Object r28 = null;
    L12:
        r5 = (Integer) r28;     // Catch: Throwable -> L54
        if (r5 != null) goto L52;
        if ((r4 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r29 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L54
        if ((r29 instanceof Integer) == true) goto L22;
        r29 = null;
    L22:
        r5 = (Integer) r29;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r30 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L54
        if ((r30 instanceof Integer) == true) goto L28;
        r30 = null;
    L28:
        r5 = (Integer) r30;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r5 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r31 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L54
        if ((r31 instanceof Integer) == true) goto L37;
        r31 = null;
    L37:
        r5 = (Integer) r31;     // Catch: Throwable -> L54
    L39:
        if ((r4 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r32 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r32 instanceof Integer) == true) goto L45;
        r32 = null;
    L45:
        Object r33 = Result.constructor-impl((Integer) r32);     // Catch: Throwable -> L47
    L49:
        r5 = r33;
        if (Result.isFailure-impl(r5) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L54
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r4 instanceof JSONArray) == false) goto L51;
    L11:
        r28 = r4;
    L54:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L160
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Object r37 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r38 = Result.exceptionOrNull-impl(r37);
        if (r38 == null) goto L165;
        EnsureManager.ensureNotReachHere(r38);
    L165:
        if (Result.isFailure-impl(r37) == true) goto L168;
        r1 = r37;
    L168:
        r8 = r1;
        goto L169
    }

    public e() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    @Override // wc3.b
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "unitId");
        com.bytedance.android.ecom.arch.slice.render.context.a r4 = this.c.remove(r3);
        if (r4 == null) goto L11;
        SlcRenderContext r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L7:
        r0.getClass();
        nq.a.a();
        ArrayList r1 = r0.n;
        if (r1 == null) goto L12;
        r1.remove(r4);
        return;
    L12:
        return;
    }

    public final void d(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        AtomicBoolean r0 = DeepFeedSliceUtil.a;
        Map<String, LinkedTreeMap<String, Object>> r1 = g.a;
        final List r2 = CollectionsKt.toList(((LinkedHashMap) g.a.a()).values());
        if (r2.isEmpty() == false) goto L6;
    L10:
        DeepFeedSliceUtil.a();
        Map r3 = HybridForestLoader.a;
        Forest r4 = (Forest) HybridForestLoader.d.getValue();
        if (r4 == null) goto L13;
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "mall_deep_feed", "ecom_deep_feed_template", r4, null);
    L13:
        SlcGeckoTemplateMgr.l.getClass();
        this.b = SlcGeckoTemplateMgr.e(r8, "mall_deep_feed");
        com.bytedance.android.ecom.slice.ext.template.gecko.c r5 = this.b;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("slcLoader");
    L16:
        com.bytedance.android.ecom.arch.slice.expr.b r6 = r5.c();
        if (r6 != null) goto L19;
        r6 = new com.bytedance.android.ecom.arch.slice.expr.b(null);
    L19:
        SlcRenderContext r7 = new SlcRenderContext(r8, "mall_deep_feed", new SlcExprContext(r6));
        this.a = r7;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r9 = this.b;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("slcLoader");
    L22:
        r7.a0 = new SlcDefaultTemplateProvider(r9);
        SlcRenderContext r10 = this.a;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L26:
        if (e != 1) goto L28;
        Object r11 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(k.a(r8)));
    L29:
        r10.p(MapsKt.mapOf(TuplesKt.to("safe_area", MapsKt.mapOf(TuplesKt.to("margin_bottom", r11)))));
        com.bytedance.android.ecom.slice.ext.template.gecko.c r12 = this.b;
        if (r12 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("slcLoader");
    L32:
        SlcRenderContext r13 = this.a;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L35:
        r12.b(r13);
        SlcRenderContext r14 = this.a;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L38:
        f r15 = new f(this);
        r14.getClass();
        nq.a.a();
        ArrayList r16 = r14.n;
        if (r16 != null) goto L41;
        r16 = new ArrayList();
        r14.n = r16;
    L41:
        r16.add(r15);
        return;
    L28:
        r11 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(k1.g()));
        goto L29
    L6:
        if (DeepFeedSliceUtil.b.compareAndSet(false, true) == false) goto L10;
        Logger.i("caihn", "start preload template  !! ");
        Map r17 = HybridForestLoader.a;
        Forest r18 = (Forest) HybridForestLoader.d.getValue();
        if (r18 == null) goto L10;
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "mall_deep_feed", "ecom_deep_feed_template", r18, new DeepFeedSliceUtil$preloadTemplate$$inlined$let$lambda$1(r2));
        goto L10
    }

    @Override // wc3.b
    public final void a(String r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "unitId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.c.put(r2, r3);
    }

    @Override // wc3.b
    public final r c(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "version");
        SlcRenderContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L6:
        return r0.c(new i(r3, r4, r5), null);
    }
}
