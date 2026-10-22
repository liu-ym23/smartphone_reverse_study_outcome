package com.bytedance.android.shopping.new_cart.widgets.gul;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedConfigGenerator {
    public final HashMap<String, Object> a;
    public final Lazy b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public ECMallFeedConfigGenerator(boolean r5, boolean r6) {
        int r7 = p.a;
        HashMap r8 = new HashMap();
        Object r1 = null;
        r8.put("api_cache_valid_period", null);
        r8.putAll(((IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class)).c().a());
        Unit r0 = Unit.INSTANCE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r9 = jj4.a.a("ec_cart_gul_config", HashMap.class, r8, false);     // Catch: Throwable -> L7
        Object r10 = r9;
        if (r9 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
        r10 = r9;
    L13:
        this.a = (HashMap) r10;
        this.b = LazyKt.lazy(ECMallFeedConfigGenerator$preloadThreshold$2.INSTANCE);
        int r11 = n.a;
        Object r12 = Boolean.FALSE;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        Object r13 = d.c.get("ec_cart_gul_image_prefetch_enable");     // Catch: Throwable -> L66
        if (r13 != null) goto L18;
    L63:
        Object r14 = null;
    L64:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L66
    L68:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L175
        if (r16 == null) goto L72;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L175
    L72:
        if (Result.isFailure-impl(r15) == false) goto L75;
        r15 = null;
    L75:
        if ((r15 instanceof Boolean) == true) goto L77;
        r15 = null;
    L77:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L175
        if (r17 != null) goto L84;
        Object r18 = d.a.get("ec_cart_gul_image_prefetch_enable");     // Catch: Throwable -> L175
        if ((r18 instanceof Boolean) == true) goto L83;
        r18 = null;
    L83:
        r17 = (Boolean) r18;     // Catch: Throwable -> L175
    L84:
        if (r17 != null) goto L184;
        int r19 = c.a;     // Catch: Throwable -> L175
        Object r20 = d.c.get("ec_cart_gul_image_prefetch_enable");     // Catch: Throwable -> L139
        if (r20 != null) goto L91;
    L136:
        Object r21 = null;
    L137:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L139
    L141:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L166
        if (r23 == null) goto L145;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L166
    L145:
        if (Result.isFailure-impl(r22) == false) goto L148;
        r22 = null;
    L148:
        if ((r22 instanceof Boolean) == true) goto L150;
        r22 = null;
    L150:
        r17 = (Boolean) r22;     // Catch: Throwable -> L166
        if (r17 != null) goto L173;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
        if (r24 == null) goto L156;
        Object r25 = r24.getHostABValue("ec_cart_gul_image_prefetch_enable", r12);     // Catch: Throwable -> L166
    L157:
        if (r25 != null) goto L159;
    L172:
        r17 = r12;
        goto L173
    L159:
        if ((r25 instanceof Boolean) == false) goto L162;
        r1 = r25;
    L162:
        Boolean r26 = (Boolean) r1;     // Catch: Throwable -> L166
        if (r26 == null) goto L172;
        r17 = r26;
        goto L173
    L166:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L175
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        Throwable r28 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L175
        if (r28 == null) goto L171;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L175
    L171:
        if (Result.isFailure-impl(r17) == false) goto L173;
    L156:
        r25 = null;
    L173:
        d.d("ec_cart_gul_image_prefetch_enable", r17);     // Catch: Throwable -> L175
        goto L184
    L91:
        if ((r20 instanceof Boolean) == true) goto L93;
        Object r29 = null;
    L94:
        r21 = (Boolean) r29;     // Catch: Throwable -> L139
        if (r21 != null) goto L137;
        if ((r20 instanceof Number) == false) goto L124;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L106;
        Float r30 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L139
        if ((r30 instanceof Boolean) == true) goto L104;
        r30 = null;
    L104:
        r21 = (Boolean) r30;     // Catch: Throwable -> L139
        goto L137
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L112;
        Double r31 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L139
        if ((r31 instanceof Boolean) == true) goto L110;
        r31 = null;
    L110:
        r21 = (Boolean) r31;     // Catch: Throwable -> L139
        goto L137
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L118;
        Integer r32 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L139
        if ((r32 instanceof Boolean) == true) goto L116;
        r32 = null;
    L116:
        r21 = (Boolean) r32;     // Catch: Throwable -> L139
        goto L137
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L124;
        Long r33 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L139
        if ((r33 instanceof Boolean) == true) goto L122;
        r33 = null;
    L122:
        r21 = (Boolean) r33;     // Catch: Throwable -> L139
    L124:
        if ((r20 instanceof JSONObject) == false) goto L126;
    L186:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r34 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L132
        if ((r34 instanceof Boolean) == true) goto L130;
        r34 = null;
    L130:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L132
    L134:
        r21 = r35;
        if (Result.isFailure-impl(r21) == false) goto L137;
    L132:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L139
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L139
        goto L134
    L126:
        if ((r20 instanceof JSONArray) == false) goto L136;
    L93:
        r29 = r20;
    L139:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L184:
        this.c = ((Boolean) r17).booleanValue();
        return;
    L18:
        if ((r13 instanceof Boolean) == true) goto L20;
        Object r38 = null;
    L21:
        r14 = (Boolean) r38;     // Catch: Throwable -> L66
        if (r14 != null) goto L64;
        if ((r13 instanceof Number) == false) goto L51;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L33;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L66
        if ((r39 instanceof Boolean) == true) goto L31;
        r39 = null;
    L31:
        r14 = (Boolean) r39;     // Catch: Throwable -> L66
        goto L64
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L39;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L66
        if ((r40 instanceof Boolean) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Boolean) r40;     // Catch: Throwable -> L66
        goto L64
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L45;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L66
        if ((r41 instanceof Boolean) == true) goto L43;
        r41 = null;
    L43:
        r14 = (Boolean) r41;     // Catch: Throwable -> L66
        goto L64
    L45:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L51;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L66
        if ((r42 instanceof Boolean) == true) goto L49;
        r42 = null;
    L49:
        r14 = (Boolean) r42;     // Catch: Throwable -> L66
    L51:
        if ((r13 instanceof JSONObject) == false) goto L53;
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L59
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L57;
        r43 = null;
    L57:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L59
    L61:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L64;
    L59:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L66
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L66
        goto L61
    L53:
        if ((r13 instanceof JSONArray) == false) goto L63;
    L20:
        r38 = r13;
    L66:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L175
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L180;
        EnsureManager.ensureNotReachHere(r49);
    L180:
        if (Result.isFailure-impl(r48) == true) goto L183;
        r12 = r48;
    L183:
        r17 = r12;
    L7:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Object r52 = r8;
        if (Result.isFailure-impl(r51) == true) goto L12;
        r52 = r51;
    L12:
        r10 = r52;
        goto L13
    }
}
