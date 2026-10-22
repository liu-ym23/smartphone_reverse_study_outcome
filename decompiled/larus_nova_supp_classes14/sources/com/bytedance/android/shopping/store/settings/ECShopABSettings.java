package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\bA\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\nR\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001a\u0004\b$\u0010\u0004R\u001a\u0010)\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\n\u001a\u0004\b'\u0010\u0004R\u001a\u0010,\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\n\u001a\u0004\b*\u0010\u0004R\u001a\u0010/\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\n\u001a\u0004\b-\u0010\u0004R\u001a\u00102\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\n\u001a\u0004\b0\u0010\u0004R\u001a\u00105\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\n\u001a\u0004\b3\u0010\u0004R\u001a\u00108\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\n\u001a\u0004\b6\u0010\u0004R\u001a\u0010;\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\n\u001a\u0004\b9\u0010\u0004R\u001a\u0010>\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010\n\u001a\u0004\b<\u0010\u0004R\u001a\u0010A\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\n\u001a\u0004\b?\u0010\u0004¨\u0006C"}, d2 = {"Lcom/bytedance/android/shopping/store/settings/ECShopABSettings;", "", "", "getEC_SHOP_HEADER_UI_OPT", "()I", "EC_SHOP_HEADER_UI_OPT", "getEC_SHOP_POPUP_LAYOUT_INFO", "EC_SHOP_POPUP_LAYOUT_INFO", "getEC_SHOP_SLICE_HEADER", "getEC_SHOP_SLICE_HEADER$annotations", "()V", "EC_SHOP_SLICE_HEADER", "getEC_SHOP_SELL_POINT_OPTIMIZE", "getEC_SHOP_SELL_POINT_OPTIMIZE$annotations", "EC_SHOP_SELL_POINT_OPTIMIZE", "getSHOP_SWITCH_TOP_SEARCH_INFO", "getSHOP_SWITCH_TOP_SEARCH_INFO$annotations", "SHOP_SWITCH_TOP_SEARCH_INFO", "getEC_SHOP_ACTIVITY_CHANGE", "getEC_SHOP_ACTIVITY_CHANGE$annotations", "EC_SHOP_ACTIVITY_CHANGE", "getEC_SHOP_CARD_PACK", "getEC_SHOP_CARD_PACK$annotations", "EC_SHOP_CARD_PACK", "getEC_SHOP_PRODUCT_BOTTOM_CARDPACK", "getEC_SHOP_PRODUCT_BOTTOM_CARDPACK$annotations", "EC_SHOP_PRODUCT_BOTTOM_CARDPACK", "getEC_SHOP_CARD_PACK_FORCE_LOCAL", "getEC_SHOP_CARD_PACK_FORCE_LOCAL$annotations", "EC_SHOP_CARD_PACK_FORCE_LOCAL", "getEC_SHOP_SEARCH_HOT_WORD_SCROLL", "getEC_SHOP_SEARCH_HOT_WORD_SCROLL$annotations", "EC_SHOP_SEARCH_HOT_WORD_SCROLL", "getEC_SHOP_SEARCH_GUIDE_STYLE", "getEC_SHOP_SEARCH_GUIDE_STYLE$annotations", "EC_SHOP_SEARCH_GUIDE_STYLE", "getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE", "getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE$annotations", "EC_SHOP_SEARCH_BAR_UI_OPTIMIZE", "getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT", "getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT$annotations", "EC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT", "getEC_SHOP_FRAMEWORK_OPT_V2", "getEC_SHOP_FRAMEWORK_OPT_V2$annotations", "EC_SHOP_FRAMEWORK_OPT_V2", "getEC_SHOP_CLASSIFY_FILTER_TAB", "getEC_SHOP_CLASSIFY_FILTER_TAB$annotations", "EC_SHOP_CLASSIFY_FILTER_TAB", "getEC_SHOP_SEARCH_HINT_GRADIENT", "getEC_SHOP_SEARCH_HINT_GRADIENT$annotations", "EC_SHOP_SEARCH_HINT_GRADIENT", "getEC_SHOP_SLICE_PRODUCT_FILTER", "getEC_SHOP_SLICE_PRODUCT_FILTER$annotations", "EC_SHOP_SLICE_PRODUCT_FILTER", "getEC_SHOP_BRAND_SHOP_UI_UPGRADE", "getEC_SHOP_BRAND_SHOP_UI_UPGRADE$annotations", "EC_SHOP_BRAND_SHOP_UI_UPGRADE", "getEC_SHOP_MINI_WINDOW_ANIM_OPT", "getEC_SHOP_MINI_WINDOW_ANIM_OPT$annotations", "EC_SHOP_MINI_WINDOW_ANIM_OPT", "getEC_SHOP_RECOMMEND_PAGE_OPT", "getEC_SHOP_RECOMMEND_PAGE_OPT$annotations", "EC_SHOP_RECOMMEND_PAGE_OPT", "getEC_SHOP_TAB_INTERACTION_OPT", "getEC_SHOP_TAB_INTERACTION_OPT$annotations", "EC_SHOP_TAB_INTERACTION_OPT", "<init>", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@OptSetting(business = "店铺AB实验参数")
public final class ECShopABSettings {
    public static final ConcurrentHashMap<String, Object> a = null;
    public static Integer b;
    public static volatile boolean c;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final ECShopABSettings k = null;

    public ECShopABSettings() {
    }

    @HostExperimentKey(author = "zhengjiali", desc = "券体验优化")
    @SettingReport
    public static final int a() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_coupon_style", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_coupon_style", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_coupon_style", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_coupon_style");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_coupon_style");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_coupon_style");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_coupon_style", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_coupon_style", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    public static boolean c() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "店铺大字适配")
    public static final int d() {
        Object r0 = 1;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_adapt_font_size", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r1 = n.a;
        Object r2 = 0;
        int r3 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L163
        Object r6 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r6 != null) goto L12;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L163
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof Integer) == true) goto L68;
        r8 = null;
    L68:
        Object r10 = (Integer) r8;     // Catch: Throwable -> L163
        if (r10 != null) goto L75;
        Object r11 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r11 instanceof Integer) == true) goto L74;
        r11 = null;
    L74:
        r10 = (Integer) r11;     // Catch: Throwable -> L163
    L75:
        if (r10 != null) goto L172;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r13 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r13 != null) goto L82;
    L124:
        Object r14 = null;
    L125:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L127
    L129:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L154
        if (r16 == null) goto L133;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r15) == false) goto L136;
        r15 = null;
    L136:
        if ((r15 instanceof Integer) == true) goto L138;
        r15 = null;
    L138:
        r10 = (Integer) r15;     // Catch: Throwable -> L154
        if (r10 != null) goto L161;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r17 == null) goto L144;
        Object r18 = r17.getHostABValue("ec_shop_launch_opt_common_2", r2);     // Catch: Throwable -> L154
    L145:
        if (r18 != null) goto L147;
    L160:
        r10 = r2;
        goto L161
    L147:
        if ((r18 instanceof Integer) == false) goto L150;
        r5 = r18;
    L150:
        Integer r19 = (Integer) r5;     // Catch: Throwable -> L154
        if (r19 == null) goto L160;
        r10 = r19;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r21 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r21 == null) goto L159;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r10) == false) goto L161;
    L144:
        r18 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r10);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r13 instanceof Integer) == true) goto L84;
        Object r22 = null;
    L85:
        r14 = (Integer) r22;     // Catch: Throwable -> L127
        if (r14 != null) goto L125;
        if ((r13 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r23 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L95;
        r23 = null;
    L95:
        r14 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r24 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L101;
        r24 = null;
    L101:
        r14 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r25 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L110;
        r25 = null;
    L110:
        r14 = (Integer) r25;     // Catch: Throwable -> L127
    L112:
        if ((r13 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r26 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r26 instanceof Integer) == true) goto L118;
        r26 = null;
    L118:
        Object r27 = Result.constructor-impl((Integer) r26);     // Catch: Throwable -> L120
    L122:
        r14 = r27;
        if (Result.isFailure-impl(r14) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L127
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r13 instanceof JSONArray) == false) goto L124;
    L84:
        r22 = r13;
    L127:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L154
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r10;
        goto L173
    L12:
        if ((r6 instanceof Integer) == true) goto L14;
        Object r30 = null;
    L15:
        r7 = (Integer) r30;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r6 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r31 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L25;
        r31 = null;
    L25:
        r7 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r32 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L31;
        r32 = null;
    L31:
        r7 = (Integer) r32;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r7 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L40;
        r33 = null;
    L40:
        r7 = (Integer) r33;     // Catch: Throwable -> L57
    L42:
        if ((r6 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r34 instanceof Integer) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L50
    L52:
        r7 = r35;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r6 instanceof JSONArray) == false) goto L54;
    L14:
        r30 = r6;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L163
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L168;
        EnsureManager.ensureNotReachHere(r40);
    L168:
        if (Result.isFailure-impl(r39) == true) goto L171;
        r2 = r39;
    L171:
        r10 = r2;
    L173:
        r0 = b;
        if (r0 == null) goto L177;
    L352:
        a.put("ec_shop_adapt_font_size", r0);
        return ((Number) r0).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        Object r44 = jj4.a.a("ec_shop_adapt_font_size", Integer.class, r0, false);     // Catch: Throwable -> L185
        if (r44 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r0 = r44;
    L185:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r44) == false) goto L189;
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L346
        Object r49 = d.c.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L346
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r44 = (Integer) r51;     // Catch: Throwable -> L346
        if (r44 != null) goto L259;
        Object r53 = d.a.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L346
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r44 = (Integer) r53;     // Catch: Throwable -> L346
    L259:
        if (r44 != null) goto L189;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r55 = d.c.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L337
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r44 = (Integer) r57;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_adapt_font_size", r0);     // Catch: Throwable -> L337
    L329:
        if (r60 != null) goto L331;
    L343:
        r44 = r0;
        goto L344
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        r44 = (Integer) r5;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
    L328:
        r60 = null;
    L344:
        d.d("ec_shop_adapt_font_size", r44);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r61 = null;
    L269:
        r56 = (Integer) r61;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r62 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r62 instanceof Integer) == true) goto L279;
        r62 = null;
    L279:
        r56 = (Integer) r62;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r63 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L285;
        r63 = null;
    L285:
        r56 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r64 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L294;
        r64 = null;
    L294:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r65 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r65 instanceof Integer) == true) goto L302;
        r65 = null;
    L302:
        Object r66 = Result.constructor-impl((Integer) r65);     // Catch: Throwable -> L304
    L306:
        r56 = r66;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L311
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r61 = r55;
    L337:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L346
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r69 = Result.exceptionOrNull-impl(r44);     // Catch: Throwable -> L346
        if (r69 == null) goto L342;
        EnsureManager.ensureNotReachHere(r69);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r44) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L337
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r71 = null;
    L199:
        r50 = (Integer) r71;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r72 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r72 instanceof Integer) == true) goto L209;
        r72 = null;
    L209:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r73 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L215;
        r73 = null;
    L215:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r74 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L224;
        r74 = null;
    L224:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r75 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r75 instanceof Integer) == true) goto L232;
        r75 = null;
    L232:
        Object r76 = Result.constructor-impl((Integer) r75);     // Catch: Throwable -> L234
    L236:
        r50 = r76;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L241
        r76 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r71 = r49;
    L241:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L346
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r80 = Result.exceptionOrNull-impl(r44);
        if (r80 == null) goto L351;
        EnsureManager.ensureNotReachHere(r80);
    L351:
        if (Result.isFailure-impl(r44) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "店铺大屏适配")
    public static final int e() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_big_screen_adapt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_big_screen_adapt", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_big_screen_adapt", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_big_screen_adapt", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_big_screen_adapt", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @SettingReport
    public static boolean f() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_biz_extra_no_transfer", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r4 = n.a;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L163
        Object r8 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r8 != null) goto L12;
    L54:
        Object r9 = null;
    L55:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L57
    L59:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r11 == null) goto L63;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r10) == false) goto L66;
        r10 = null;
    L66:
        if ((r10 instanceof Integer) == true) goto L68;
        r10 = null;
    L68:
        Object r12 = (Integer) r10;     // Catch: Throwable -> L163
        if (r12 != null) goto L75;
        Object r13 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r13 instanceof Integer) == true) goto L74;
        r13 = null;
    L74:
        r12 = (Integer) r13;     // Catch: Throwable -> L163
    L75:
        if (r12 != null) goto L172;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r15 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r15 != null) goto L82;
    L124:
        Object r16 = null;
    L125:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L127
    L129:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L154
        if (r18 == null) goto L133;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r17) == false) goto L136;
        r17 = null;
    L136:
        if ((r17 instanceof Integer) == true) goto L138;
        r17 = null;
    L138:
        r12 = (Integer) r17;     // Catch: Throwable -> L154
        if (r12 != null) goto L161;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r19 == null) goto L144;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r20 != null) goto L147;
    L160:
        r12 = r1;
        goto L161
    L147:
        if ((r20 instanceof Integer) == false) goto L150;
        r5 = r20;
    L150:
        Integer r21 = (Integer) r5;     // Catch: Throwable -> L154
        if (r21 == null) goto L160;
        r12 = r21;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L163
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L163
        if (r23 == null) goto L159;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r12) == false) goto L161;
    L144:
        r20 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r15 instanceof Integer) == true) goto L84;
        Object r24 = null;
    L85:
        r16 = (Integer) r24;     // Catch: Throwable -> L127
        if (r16 != null) goto L125;
        if ((r15 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L95;
        r25 = null;
    L95:
        r16 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L101;
        r26 = null;
    L101:
        r16 = (Integer) r26;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L127
        if ((r27 instanceof Integer) == true) goto L110;
        r27 = null;
    L110:
        r16 = (Integer) r27;     // Catch: Throwable -> L127
    L112:
        if ((r15 instanceof JSONObject) == false) goto L114;
    L368:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r28 instanceof Integer) == true) goto L118;
        r28 = null;
    L118:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L120
    L122:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L127
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r15 instanceof JSONArray) == false) goto L124;
    L84:
        r24 = r15;
    L127:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L154
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r12;
        goto L173
    L12:
        if ((r8 instanceof Integer) == true) goto L14;
        Object r32 = null;
    L15:
        r9 = (Integer) r32;     // Catch: Throwable -> L57
        if (r9 != null) goto L55;
        if ((r8 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r33 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L25;
        r33 = null;
    L25:
        r9 = (Integer) r33;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r34 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Integer) == true) goto L31;
        r34 = null;
    L31:
        r9 = (Integer) r34;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r35 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L57
        if ((r35 instanceof Integer) == true) goto L40;
        r35 = null;
    L40:
        r9 = (Integer) r35;     // Catch: Throwable -> L57
    L42:
        if ((r8 instanceof JSONObject) == false) goto L44;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r36 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r36 instanceof Integer) == true) goto L48;
        r36 = null;
    L48:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L50
    L52:
        r9 = r37;
        if (Result.isFailure-impl(r9) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L57
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r8 instanceof JSONArray) == false) goto L54;
    L14:
        r32 = r8;
    L57:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r3 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r3);
        if (r41 == null) goto L168;
        EnsureManager.ensureNotReachHere(r41);
    L168:
        if (Result.isFailure-impl(r3) == true) goto L171;
        r1 = r3;
    L171:
        r12 = r1;
    L173:
        r1 = b;
        if (r1 == null) goto L177;
    L352:
        a.put("ec_shop_biz_extra_no_transfer", r1);
        if (((Number) r1).intValue() != 1) goto L355;
    L356:
        return true;
    L355:
        if (h() == true) goto L356;
        return false;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r42 = p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L185
        Object r45 = jj4.a.a("ec_shop_biz_extra_no_transfer", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r45 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r1 = r45;
    L185:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == false) goto L189;
    L190:
        int r47 = n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L346
        Object r50 = d.c.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L241
        if (r50 != null) goto L196;
    L238:
        Object r51 = null;
    L239:
        Object r52 = Result.constructor-impl(r51);     // Catch: Throwable -> L241
    L243:
        Throwable r53 = Result.exceptionOrNull-impl(r52);     // Catch: Throwable -> L346
        if (r53 == null) goto L247;
        EnsureManager.ensureNotReachHere(r53);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r52) == false) goto L250;
        r52 = null;
    L250:
        if ((r52 instanceof Integer) == true) goto L252;
        r52 = null;
    L252:
        r45 = (Integer) r52;     // Catch: Throwable -> L346
        if (r45 != null) goto L259;
        Object r54 = d.a.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L346
        if ((r54 instanceof Integer) == true) goto L258;
        r54 = null;
    L258:
        r45 = (Integer) r54;     // Catch: Throwable -> L346
    L259:
        if (r45 != null) goto L189;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r56 = d.c.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L311
        if (r56 != null) goto L266;
    L308:
        Object r57 = null;
    L309:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L311
    L313:
        Throwable r59 = Result.exceptionOrNull-impl(r58);     // Catch: Throwable -> L337
        if (r59 == null) goto L317;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r58) == false) goto L320;
        r58 = null;
    L320:
        if ((r58 instanceof Integer) == true) goto L322;
        r58 = null;
    L322:
        r45 = (Integer) r58;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
        IHybridHostService r60 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r60 == null) goto L328;
        Object r61 = r60.getHostABValue("ec_shop_biz_extra_no_transfer", r1);     // Catch: Throwable -> L337
    L329:
        if (r61 != null) goto L331;
    L343:
        r45 = r1;
        goto L344
    L331:
        if ((r61 instanceof Integer) == false) goto L334;
        r5 = r61;
    L334:
        r45 = (Integer) r5;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
    L328:
        r61 = null;
    L344:
        d.d("ec_shop_biz_extra_no_transfer", r45);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r56 instanceof Integer) == true) goto L268;
        Object r62 = null;
    L269:
        r57 = (Integer) r62;     // Catch: Throwable -> L311
        if (r57 != null) goto L309;
        if ((r56 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r63 = Float.valueOf(((Number) r56).floatValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L279;
        r63 = null;
    L279:
        r57 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r64 = Double.valueOf(((Number) r56).doubleValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L285;
        r64 = null;
    L285:
        r57 = (Integer) r64;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r57 = Integer.valueOf(((Number) r56).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r65 = Long.valueOf(((Number) r56).longValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L294;
        r65 = null;
    L294:
        r57 = (Integer) r65;     // Catch: Throwable -> L311
    L296:
        if ((r56 instanceof JSONObject) == false) goto L298;
    L381:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r66 = SDKSettingsCacheManager.a().fromJson(r56.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r66 instanceof Integer) == true) goto L302;
        r66 = null;
    L302:
        Object r67 = Result.constructor-impl((Integer) r66);     // Catch: Throwable -> L304
    L306:
        r57 = r67;
        if (Result.isFailure-impl(r57) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L311
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r56 instanceof JSONArray) == false) goto L308;
    L268:
        r62 = r56;
    L337:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L346
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r70 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L346
        if (r70 == null) goto L342;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r45) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L337
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r50 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r51 = (Integer) r72;     // Catch: Throwable -> L241
        if (r51 != null) goto L239;
        if ((r50 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r50).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r51 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r50).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r51 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r51 = Integer.valueOf(((Number) r50).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r50).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r51 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r50 instanceof JSONObject) == false) goto L228;
    L379:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r50.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r51 = r77;
        if (Result.isFailure-impl(r51) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r50 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r50;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L346
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L351;
        EnsureManager.ensureNotReachHere(r81);
    L351:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    public static boolean g() {
        return ((Boolean) g.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "营销接口迁移开关")
    @SettingReport
    public static final int getEC_SHOP_ACTIVITY_CHANGE() {
        Object r0 = 1;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_activity_api_change", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r1 = n.a;
        Object r2 = 0;
        int r3 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L163
        Object r6 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r6 != null) goto L12;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L163
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof Integer) == true) goto L68;
        r8 = null;
    L68:
        Object r10 = (Integer) r8;     // Catch: Throwable -> L163
        if (r10 != null) goto L75;
        Object r11 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r11 instanceof Integer) == true) goto L74;
        r11 = null;
    L74:
        r10 = (Integer) r11;     // Catch: Throwable -> L163
    L75:
        if (r10 != null) goto L172;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r13 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r13 != null) goto L82;
    L124:
        Object r14 = null;
    L125:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L127
    L129:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L154
        if (r16 == null) goto L133;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r15) == false) goto L136;
        r15 = null;
    L136:
        if ((r15 instanceof Integer) == true) goto L138;
        r15 = null;
    L138:
        r10 = (Integer) r15;     // Catch: Throwable -> L154
        if (r10 != null) goto L161;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r17 == null) goto L144;
        Object r18 = r17.getHostABValue("ec_shop_launch_opt_common_2", r2);     // Catch: Throwable -> L154
    L145:
        if (r18 != null) goto L147;
    L160:
        r10 = r2;
        goto L161
    L147:
        if ((r18 instanceof Integer) == false) goto L150;
        r5 = r18;
    L150:
        Integer r19 = (Integer) r5;     // Catch: Throwable -> L154
        if (r19 == null) goto L160;
        r10 = r19;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r21 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r21 == null) goto L159;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r10) == false) goto L161;
    L144:
        r18 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r10);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r13 instanceof Integer) == true) goto L84;
        Object r22 = null;
    L85:
        r14 = (Integer) r22;     // Catch: Throwable -> L127
        if (r14 != null) goto L125;
        if ((r13 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r23 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L95;
        r23 = null;
    L95:
        r14 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r24 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L101;
        r24 = null;
    L101:
        r14 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r25 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L110;
        r25 = null;
    L110:
        r14 = (Integer) r25;     // Catch: Throwable -> L127
    L112:
        if ((r13 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r26 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r26 instanceof Integer) == true) goto L118;
        r26 = null;
    L118:
        Object r27 = Result.constructor-impl((Integer) r26);     // Catch: Throwable -> L120
    L122:
        r14 = r27;
        if (Result.isFailure-impl(r14) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L127
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r13 instanceof JSONArray) == false) goto L124;
    L84:
        r22 = r13;
    L127:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L154
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r10;
        goto L173
    L12:
        if ((r6 instanceof Integer) == true) goto L14;
        Object r30 = null;
    L15:
        r7 = (Integer) r30;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r6 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r31 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L25;
        r31 = null;
    L25:
        r7 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r32 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L31;
        r32 = null;
    L31:
        r7 = (Integer) r32;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r7 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L40;
        r33 = null;
    L40:
        r7 = (Integer) r33;     // Catch: Throwable -> L57
    L42:
        if ((r6 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r34 instanceof Integer) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L50
    L52:
        r7 = r35;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r6 instanceof JSONArray) == false) goto L54;
    L14:
        r30 = r6;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L163
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L168;
        EnsureManager.ensureNotReachHere(r40);
    L168:
        if (Result.isFailure-impl(r39) == true) goto L171;
        r2 = r39;
    L171:
        r10 = r2;
    L173:
        r0 = b;
        if (r0 == null) goto L177;
    L352:
        a.put("ec_shop_activity_api_change", r0);
        return ((Number) r0).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        Object r44 = jj4.a.a("ec_shop_activity_api_change", Integer.class, r0, false);     // Catch: Throwable -> L185
        if (r44 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r0 = r44;
    L185:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r44) == false) goto L189;
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L346
        Object r49 = d.c.get("ec_shop_activity_api_change");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L346
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r44 = (Integer) r51;     // Catch: Throwable -> L346
        if (r44 != null) goto L259;
        Object r53 = d.a.get("ec_shop_activity_api_change");     // Catch: Throwable -> L346
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r44 = (Integer) r53;     // Catch: Throwable -> L346
    L259:
        if (r44 != null) goto L189;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r55 = d.c.get("ec_shop_activity_api_change");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L337
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r44 = (Integer) r57;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_activity_api_change", r0);     // Catch: Throwable -> L337
    L329:
        if (r60 != null) goto L331;
    L343:
        r44 = r0;
        goto L344
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        r44 = (Integer) r5;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
    L328:
        r60 = null;
    L344:
        d.d("ec_shop_activity_api_change", r44);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r61 = null;
    L269:
        r56 = (Integer) r61;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r62 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r62 instanceof Integer) == true) goto L279;
        r62 = null;
    L279:
        r56 = (Integer) r62;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r63 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L285;
        r63 = null;
    L285:
        r56 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r64 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L294;
        r64 = null;
    L294:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r65 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r65 instanceof Integer) == true) goto L302;
        r65 = null;
    L302:
        Object r66 = Result.constructor-impl((Integer) r65);     // Catch: Throwable -> L304
    L306:
        r56 = r66;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L311
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r61 = r55;
    L337:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L346
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r69 = Result.exceptionOrNull-impl(r44);     // Catch: Throwable -> L346
        if (r69 == null) goto L342;
        EnsureManager.ensureNotReachHere(r69);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r44) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L337
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r71 = null;
    L199:
        r50 = (Integer) r71;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r72 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r72 instanceof Integer) == true) goto L209;
        r72 = null;
    L209:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r73 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L215;
        r73 = null;
    L215:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r74 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L224;
        r74 = null;
    L224:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r75 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r75 instanceof Integer) == true) goto L232;
        r75 = null;
    L232:
        Object r76 = Result.constructor-impl((Integer) r75);     // Catch: Throwable -> L234
    L236:
        r50 = r76;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L241
        r76 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r71 = r49;
    L241:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L346
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r80 = Result.exceptionOrNull-impl(r44);
        if (r80 == null) goto L351;
        EnsureManager.ensureNotReachHere(r80);
    L351:
        if (Result.isFailure-impl(r44) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺UI升级")
    @SettingReport
    public static final int getEC_SHOP_BRAND_SHOP_UI_UPGRADE() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("brand_shop_ui_upgrade", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("brand_shop_ui_upgrade", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("brand_shop_ui_upgrade", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("brand_shop_ui_upgrade", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("brand_shop_ui_upgrade", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "商列接cardpack")
    @SettingReport
    public static final int getEC_SHOP_CARD_PACK() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_product_cardpack", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_product_cardpack", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_product_cardpack", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_product_cardpack");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_product_cardpack");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_product_cardpack");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_product_cardpack", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_product_cardpack", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "cardpack强制走本地")
    @SettingReport
    public static final int getEC_SHOP_CARD_PACK_FORCE_LOCAL() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_product_cardpack_force_local", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_product_cardpack_force_local", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_product_cardpack_force_local", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_product_cardpack_force_local", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_product_cardpack_force_local", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "分类页筛选Tab")
    @SettingReport
    public static final int getEC_SHOP_CLASSIFY_FILTER_TAB() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_classify_filter_tab", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_classify_filter_tab", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_classify_filter_tab", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_classify_filter_tab", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_classify_filter_tab", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "店铺tab框架优化V2")
    @SettingReport
    public static final int getEC_SHOP_FRAMEWORK_OPT_V2() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("opt_tab_frame_v4", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("opt_tab_frame_v4", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("opt_tab_frame_v4", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("opt_tab_frame_v4");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("opt_tab_frame_v4");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("opt_tab_frame_v4");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("opt_tab_frame_v4", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("opt_tab_frame_v4", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "店铺tab框架优化")
    @SettingReport
    public static final int getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("opt_tab_frame_v3", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("opt_tab_frame_v3", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("opt_tab_frame_v3", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("opt_tab_frame_v3");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("opt_tab_frame_v3");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("opt_tab_frame_v3");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("opt_tab_frame_v3", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("opt_tab_frame_v3", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "店铺直播小窗下滑变icon")
    @SettingReport
    public static final int getEC_SHOP_MINI_WINDOW_ANIM_OPT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_mini_window_anim_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_mini_window_anim_opt", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_mini_window_anim_opt", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_mini_window_anim_opt", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_mini_window_anim_opt", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengjiali", desc = "商列跨店商卡接cardpack")
    @SettingReport
    public static final int getEC_SHOP_PRODUCT_BOTTOM_CARDPACK() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_product_bottom_cardpack", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_product_bottom_cardpack", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_product_bottom_cardpack", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_product_bottom_cardpack", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_product_bottom_cardpack", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "推荐>精选二出一展示")
    @SettingReport
    public static final int getEC_SHOP_RECOMMEND_PAGE_OPT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_recommend_page_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_recommend_page_opt", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_recommend_page_opt", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_recommend_page_opt", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_recommend_page_opt", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索框UI优化")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_search_bar_ui_optimize", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_search_bar_ui_optimize", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_search_bar_ui_optimize", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_search_bar_ui_optimize", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_search_bar_ui_optimize", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索中间页样式实验")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_GUIDE_STYLE() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_search_guide_style", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_search_guide_style", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_search_guide_style", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_search_guide_style");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_search_guide_style");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_search_guide_style");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_search_guide_style", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_search_guide_style", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "搜索词提示词渐隐")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_HINT_GRADIENT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_search_hint_gradient", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_search_hint_gradient", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_search_hint_gradient", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_search_hint_gradient", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_search_hint_gradient", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索底纹词轮播")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_HOT_WORD_SCROLL() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_search_placeholder_upgrade", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_search_placeholder_upgrade", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_search_placeholder_upgrade", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_search_placeholder_upgrade", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_search_placeholder_upgrade", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺商卡埋点迭代优化")
    @SettingReport
    public static final int getEC_SHOP_SELL_POINT_OPTIMIZE() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("shop_product_sell_point_type", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("shop_product_sell_point_type", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("shop_product_sell_point_type", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("shop_product_sell_point_type");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("shop_product_sell_point_type");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("shop_product_sell_point_type");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("shop_product_sell_point_type", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("shop_product_sell_point_type", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "店铺店招slice实验")
    @SettingReport
    public static final int getEC_SHOP_SLICE_HEADER() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_slice_profile_card", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_slice_profile_card", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_slice_profile_card", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_slice_profile_card", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_slice_profile_card", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "商列slice筛选条")
    @SettingReport
    public static final int getEC_SHOP_SLICE_PRODUCT_FILTER() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("shop_slice_filter", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("shop_slice_filter", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("shop_slice_filter", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("shop_slice_filter");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("shop_slice_filter");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("shop_slice_filter");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("shop_slice_filter", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("shop_slice_filter", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "品牌店商列交互优化")
    @SettingReport
    public static final int getEC_SHOP_TAB_INTERACTION_OPT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_tab_interaction_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_tab_interaction_opt", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_tab_interaction_opt", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_tab_interaction_opt", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_tab_interaction_opt", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "热搜词切接口")
    @SettingReport
    public static final int getSHOP_SWITCH_TOP_SEARCH_INFO() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_switch_top_search_info", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_switch_top_search_info", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_switch_top_search_info", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_switch_top_search_info", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_switch_top_search_info", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    public static boolean h() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_chunk", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r4 = n.a;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L163
        Object r8 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r8 != null) goto L12;
    L54:
        Object r9 = null;
    L55:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L57
    L59:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r11 == null) goto L63;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r10) == false) goto L66;
        r10 = null;
    L66:
        if ((r10 instanceof Integer) == true) goto L68;
        r10 = null;
    L68:
        Object r12 = (Integer) r10;     // Catch: Throwable -> L163
        if (r12 != null) goto L75;
        Object r13 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r13 instanceof Integer) == true) goto L74;
        r13 = null;
    L74:
        r12 = (Integer) r13;     // Catch: Throwable -> L163
    L75:
        if (r12 != null) goto L172;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r15 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r15 != null) goto L82;
    L124:
        Object r16 = null;
    L125:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L127
    L129:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L154
        if (r18 == null) goto L133;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r17) == false) goto L136;
        r17 = null;
    L136:
        if ((r17 instanceof Integer) == true) goto L138;
        r17 = null;
    L138:
        r12 = (Integer) r17;     // Catch: Throwable -> L154
        if (r12 != null) goto L161;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r19 == null) goto L144;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r20 != null) goto L147;
    L160:
        r12 = r1;
        goto L161
    L147:
        if ((r20 instanceof Integer) == false) goto L150;
        r5 = r20;
    L150:
        Integer r21 = (Integer) r5;     // Catch: Throwable -> L154
        if (r21 == null) goto L160;
        r12 = r21;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L163
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L163
        if (r23 == null) goto L159;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r12) == false) goto L161;
    L144:
        r20 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r15 instanceof Integer) == true) goto L84;
        Object r24 = null;
    L85:
        r16 = (Integer) r24;     // Catch: Throwable -> L127
        if (r16 != null) goto L125;
        if ((r15 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L95;
        r25 = null;
    L95:
        r16 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L101;
        r26 = null;
    L101:
        r16 = (Integer) r26;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L127
        if ((r27 instanceof Integer) == true) goto L110;
        r27 = null;
    L110:
        r16 = (Integer) r27;     // Catch: Throwable -> L127
    L112:
        if ((r15 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r28 instanceof Integer) == true) goto L118;
        r28 = null;
    L118:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L120
    L122:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L127
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r15 instanceof JSONArray) == false) goto L124;
    L84:
        r24 = r15;
    L127:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L154
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r12;
        goto L173
    L12:
        if ((r8 instanceof Integer) == true) goto L14;
        Object r32 = null;
    L15:
        r9 = (Integer) r32;     // Catch: Throwable -> L57
        if (r9 != null) goto L55;
        if ((r8 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r33 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L25;
        r33 = null;
    L25:
        r9 = (Integer) r33;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r34 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Integer) == true) goto L31;
        r34 = null;
    L31:
        r9 = (Integer) r34;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r35 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L57
        if ((r35 instanceof Integer) == true) goto L40;
        r35 = null;
    L40:
        r9 = (Integer) r35;     // Catch: Throwable -> L57
    L42:
        if ((r8 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r36 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r36 instanceof Integer) == true) goto L48;
        r36 = null;
    L48:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L50
    L52:
        r9 = r37;
        if (Result.isFailure-impl(r9) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L57
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r8 instanceof JSONArray) == false) goto L54;
    L14:
        r32 = r8;
    L57:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r3 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r3);
        if (r41 == null) goto L168;
        EnsureManager.ensureNotReachHere(r41);
    L168:
        if (Result.isFailure-impl(r3) == true) goto L171;
        r1 = r3;
    L171:
        r12 = r1;
    L173:
        r1 = b;
        if (r1 == null) goto L177;
    L352:
        a.put("ec_shop_chunk", r1);
        if (((Number) r1).intValue() != 1) goto L381;
        return true;
    L381:
        return false;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r42 = p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L185
        Object r45 = jj4.a.a("ec_shop_chunk", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r45 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r1 = r45;
    L185:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == false) goto L189;
    L190:
        int r47 = n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L346
        Object r50 = d.c.get("ec_shop_chunk");     // Catch: Throwable -> L241
        if (r50 != null) goto L196;
    L238:
        Object r51 = null;
    L239:
        Object r52 = Result.constructor-impl(r51);     // Catch: Throwable -> L241
    L243:
        Throwable r53 = Result.exceptionOrNull-impl(r52);     // Catch: Throwable -> L346
        if (r53 == null) goto L247;
        EnsureManager.ensureNotReachHere(r53);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r52) == false) goto L250;
        r52 = null;
    L250:
        if ((r52 instanceof Integer) == true) goto L252;
        r52 = null;
    L252:
        r45 = (Integer) r52;     // Catch: Throwable -> L346
        if (r45 != null) goto L259;
        Object r54 = d.a.get("ec_shop_chunk");     // Catch: Throwable -> L346
        if ((r54 instanceof Integer) == true) goto L258;
        r54 = null;
    L258:
        r45 = (Integer) r54;     // Catch: Throwable -> L346
    L259:
        if (r45 != null) goto L189;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r56 = d.c.get("ec_shop_chunk");     // Catch: Throwable -> L311
        if (r56 != null) goto L266;
    L308:
        Object r57 = null;
    L309:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L311
    L313:
        Throwable r59 = Result.exceptionOrNull-impl(r58);     // Catch: Throwable -> L337
        if (r59 == null) goto L317;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r58) == false) goto L320;
        r58 = null;
    L320:
        if ((r58 instanceof Integer) == true) goto L322;
        r58 = null;
    L322:
        r45 = (Integer) r58;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
        IHybridHostService r60 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r60 == null) goto L328;
        Object r61 = r60.getHostABValue("ec_shop_chunk", r1);     // Catch: Throwable -> L337
    L329:
        if (r61 != null) goto L331;
    L343:
        r45 = r1;
        goto L344
    L331:
        if ((r61 instanceof Integer) == false) goto L334;
        r5 = r61;
    L334:
        r45 = (Integer) r5;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
    L328:
        r61 = null;
    L344:
        d.d("ec_shop_chunk", r45);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r56 instanceof Integer) == true) goto L268;
        Object r62 = null;
    L269:
        r57 = (Integer) r62;     // Catch: Throwable -> L311
        if (r57 != null) goto L309;
        if ((r56 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r63 = Float.valueOf(((Number) r56).floatValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L279;
        r63 = null;
    L279:
        r57 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r64 = Double.valueOf(((Number) r56).doubleValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L285;
        r64 = null;
    L285:
        r57 = (Integer) r64;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r57 = Integer.valueOf(((Number) r56).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r65 = Long.valueOf(((Number) r56).longValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L294;
        r65 = null;
    L294:
        r57 = (Integer) r65;     // Catch: Throwable -> L311
    L296:
        if ((r56 instanceof JSONObject) == false) goto L298;
    L379:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r66 = SDKSettingsCacheManager.a().fromJson(r56.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r66 instanceof Integer) == true) goto L302;
        r66 = null;
    L302:
        Object r67 = Result.constructor-impl((Integer) r66);     // Catch: Throwable -> L304
    L306:
        r57 = r67;
        if (Result.isFailure-impl(r57) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L311
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r56 instanceof JSONArray) == false) goto L308;
    L268:
        r62 = r56;
    L337:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L346
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r70 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L346
        if (r70 == null) goto L342;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r45) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L337
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r50 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r51 = (Integer) r72;     // Catch: Throwable -> L241
        if (r51 != null) goto L239;
        if ((r50 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r50).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r51 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r50).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r51 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r51 = Integer.valueOf(((Number) r50).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r50).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r51 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r50 instanceof JSONObject) == false) goto L228;
    L377:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r50.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r51 = r77;
        if (Result.isFailure-impl(r51) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r50 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r50;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L346
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L351;
        EnsureManager.ensureNotReachHere(r81);
    L351:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    public static boolean i() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺头图UI优化")
    @SettingReport
    public final int getEC_SHOP_HEADER_UI_OPT() {
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_header_interaction_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r0 = n.a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L163
        Object r4 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r4 != null) goto L12;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L163
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof Integer) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L163
        if (r9 != null) goto L75;
        Object r10 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r10 instanceof Integer) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Integer) r10;     // Catch: Throwable -> L163
    L75:
        if (r9 != null) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r12 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r12 != null) goto L82;
    L124:
        Object r13 = null;
    L125:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L127
    L129:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L154
        if (r15 == null) goto L133;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r14) == false) goto L136;
        r14 = null;
    L136:
        if ((r14 instanceof Integer) == true) goto L138;
        r14 = null;
    L138:
        r9 = (Integer) r14;     // Catch: Throwable -> L154
        if (r9 != null) goto L161;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r16 == null) goto L144;
        Object r17 = r16.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r17 != null) goto L147;
    L160:
        r9 = r1;
        goto L161
    L147:
        if ((r17 instanceof Integer) == false) goto L150;
        r5 = r17;
    L150:
        Integer r18 = (Integer) r5;     // Catch: Throwable -> L154
        if (r18 == null) goto L160;
        r9 = r18;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r20 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r20 == null) goto L159;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r9) == false) goto L161;
    L144:
        r17 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r9);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r12 instanceof Integer) == true) goto L84;
        Object r21 = null;
    L85:
        r13 = (Integer) r21;     // Catch: Throwable -> L127
        if (r13 != null) goto L125;
        if ((r12 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L127
        if ((r22 instanceof Integer) == true) goto L95;
        r22 = null;
    L95:
        r13 = (Integer) r22;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L101;
        r23 = null;
    L101:
        r13 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r24 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L110;
        r24 = null;
    L110:
        r13 = (Integer) r24;     // Catch: Throwable -> L127
    L112:
        if ((r12 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r25 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r25 instanceof Integer) == true) goto L118;
        r25 = null;
    L118:
        Object r26 = Result.constructor-impl((Integer) r25);     // Catch: Throwable -> L120
    L122:
        r13 = r26;
        if (Result.isFailure-impl(r13) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L127
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r12 instanceof JSONArray) == false) goto L124;
    L84:
        r21 = r12;
    L127:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L154
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r9;
        goto L173
    L12:
        if ((r4 instanceof Integer) == true) goto L14;
        Object r29 = null;
    L15:
        r6 = (Integer) r29;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Integer) == true) goto L25;
        r30 = null;
    L25:
        r6 = (Integer) r30;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L31;
        r31 = null;
    L31:
        r6 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r6 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r32 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L40;
        r32 = null;
    L40:
        r6 = (Integer) r32;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r33 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r33 instanceof Integer) == true) goto L48;
        r33 = null;
    L48:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L50
    L52:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L57
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L14:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L163
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L168;
        EnsureManager.ensureNotReachHere(r39);
    L168:
        if (Result.isFailure-impl(r38) == true) goto L171;
        r1 = r38;
    L171:
        r9 = r1;
    L173:
        Object r40 = b;
        if (r40 == null) goto L177;
    L354:
        a.put("ec_shop_header_interaction_opt", r40);
        return ((Number) r40).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        r40 = jj4.a.a("ec_shop_header_interaction_opt", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r40 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == true) goto L353;
    L189:
        r1 = r45;
    L353:
        r40 = r1;
        goto L354
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L347
        Object r49 = d.c.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L347
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L347
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r40 = (Integer) r51;     // Catch: Throwable -> L347
        if (r40 != null) goto L259;
        Object r53 = d.a.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L347
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r40 = (Integer) r53;     // Catch: Throwable -> L347
    L259:
        if (r40 != null) goto L354;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L347
        Object r55 = d.c.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L338
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L338
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r40 = (Integer) r57;     // Catch: Throwable -> L338
        if (r40 != null) goto L345;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_header_interaction_opt", r1);     // Catch: Throwable -> L338
    L329:
        if (r60 != null) goto L331;
    L344:
        r40 = r1;
        goto L345
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        Integer r61 = (Integer) r5;     // Catch: Throwable -> L338
        if (r61 == null) goto L344;
        r40 = r61;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L347
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r63 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L347
        if (r63 == null) goto L343;
        EnsureManager.ensureNotReachHere(r63);     // Catch: Throwable -> L347
    L343:
        if (Result.isFailure-impl(r40) == false) goto L345;
    L328:
        r60 = null;
    L345:
        d.d("ec_shop_header_interaction_opt", r40);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r64 = null;
    L269:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r65 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L279;
        r65 = null;
    L279:
        r56 = (Integer) r65;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r66 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r66 instanceof Integer) == true) goto L285;
        r66 = null;
    L285:
        r56 = (Integer) r66;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r67 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r67 instanceof Integer) == true) goto L294;
        r67 = null;
    L294:
        r56 = (Integer) r67;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r68 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r68 instanceof Integer) == true) goto L302;
        r68 = null;
    L302:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L304
    L306:
        r56 = r69;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L311
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r64 = r55;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L338
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r50 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r50 = r77;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r49;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L347
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);
    L352:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺弹窗layout改动")
    @SettingReport
    public final int getEC_SHOP_POPUP_LAYOUT_INFO() {
        Object r0 = 1;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_popup_layout_info", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (b != null) goto L173;
        int r1 = n.a;
        Object r2 = 0;
        int r3 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L163
        Object r6 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r6 != null) goto L12;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L163
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof Integer) == true) goto L68;
        r8 = null;
    L68:
        Object r10 = (Integer) r8;     // Catch: Throwable -> L163
        if (r10 != null) goto L75;
        Object r11 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r11 instanceof Integer) == true) goto L74;
        r11 = null;
    L74:
        r10 = (Integer) r11;     // Catch: Throwable -> L163
    L75:
        if (r10 != null) goto L172;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r13 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r13 != null) goto L82;
    L124:
        Object r14 = null;
    L125:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L127
    L129:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L154
        if (r16 == null) goto L133;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r15) == false) goto L136;
        r15 = null;
    L136:
        if ((r15 instanceof Integer) == true) goto L138;
        r15 = null;
    L138:
        r10 = (Integer) r15;     // Catch: Throwable -> L154
        if (r10 != null) goto L161;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r17 == null) goto L144;
        Object r18 = r17.getHostABValue("ec_shop_launch_opt_common_2", r2);     // Catch: Throwable -> L154
    L145:
        if (r18 != null) goto L147;
    L160:
        r10 = r2;
        goto L161
    L147:
        if ((r18 instanceof Integer) == false) goto L150;
        r5 = r18;
    L150:
        Integer r19 = (Integer) r5;     // Catch: Throwable -> L154
        if (r19 == null) goto L160;
        r10 = r19;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r21 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r21 == null) goto L159;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r10) == false) goto L161;
    L144:
        r18 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r10);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r13 instanceof Integer) == true) goto L84;
        Object r22 = null;
    L85:
        r14 = (Integer) r22;     // Catch: Throwable -> L127
        if (r14 != null) goto L125;
        if ((r13 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r23 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L127
        if ((r23 instanceof Integer) == true) goto L95;
        r23 = null;
    L95:
        r14 = (Integer) r23;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r24 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L101;
        r24 = null;
    L101:
        r14 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r25 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L110;
        r25 = null;
    L110:
        r14 = (Integer) r25;     // Catch: Throwable -> L127
    L112:
        if ((r13 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r26 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r26 instanceof Integer) == true) goto L118;
        r26 = null;
    L118:
        Object r27 = Result.constructor-impl((Integer) r26);     // Catch: Throwable -> L120
    L122:
        r14 = r27;
        if (Result.isFailure-impl(r14) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L127
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r13 instanceof JSONArray) == false) goto L124;
    L84:
        r22 = r13;
    L127:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L154
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        b = (Integer) r10;
        goto L173
    L12:
        if ((r6 instanceof Integer) == true) goto L14;
        Object r30 = null;
    L15:
        r7 = (Integer) r30;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r6 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r31 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Integer) == true) goto L25;
        r31 = null;
    L25:
        r7 = (Integer) r31;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r32 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L31;
        r32 = null;
    L31:
        r7 = (Integer) r32;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r7 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L40;
        r33 = null;
    L40:
        r7 = (Integer) r33;     // Catch: Throwable -> L57
    L42:
        if ((r6 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r34 instanceof Integer) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L50
    L52:
        r7 = r35;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r6 instanceof JSONArray) == false) goto L54;
    L14:
        r30 = r6;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L163
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L168;
        EnsureManager.ensureNotReachHere(r40);
    L168:
        if (Result.isFailure-impl(r39) == true) goto L171;
        r2 = r39;
    L171:
        r10 = r2;
    L173:
        r0 = b;
        if (r0 == null) goto L177;
    L352:
        a.put("ec_shop_popup_layout_info", r0);
        return ((Number) r0).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r41 = p.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L185
        Object r44 = jj4.a.a("ec_shop_popup_layout_info", Integer.class, r0, false);     // Catch: Throwable -> L185
        if (r44 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r0 = r44;
    L185:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r44) == false) goto L189;
    L190:
        int r46 = n.a;
        int r47 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L346
        Object r49 = d.c.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L241
        if (r49 != null) goto L196;
    L238:
        Object r50 = null;
    L239:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L241
    L243:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L346
        if (r52 == null) goto L247;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r51) == false) goto L250;
        r51 = null;
    L250:
        if ((r51 instanceof Integer) == true) goto L252;
        r51 = null;
    L252:
        r44 = (Integer) r51;     // Catch: Throwable -> L346
        if (r44 != null) goto L259;
        Object r53 = d.a.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L346
        if ((r53 instanceof Integer) == true) goto L258;
        r53 = null;
    L258:
        r44 = (Integer) r53;     // Catch: Throwable -> L346
    L259:
        if (r44 != null) goto L189;
        int r54 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r55 = d.c.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L311
        if (r55 != null) goto L266;
    L308:
        Object r56 = null;
    L309:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L311
    L313:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L337
        if (r58 == null) goto L317;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r57) == false) goto L320;
        r57 = null;
    L320:
        if ((r57 instanceof Integer) == true) goto L322;
        r57 = null;
    L322:
        r44 = (Integer) r57;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r59 == null) goto L328;
        Object r60 = r59.getHostABValue("ec_shop_popup_layout_info", r0);     // Catch: Throwable -> L337
    L329:
        if (r60 != null) goto L331;
    L343:
        r44 = r0;
        goto L344
    L331:
        if ((r60 instanceof Integer) == false) goto L334;
        r5 = r60;
    L334:
        r44 = (Integer) r5;     // Catch: Throwable -> L337
        if (r44 != null) goto L344;
    L328:
        r60 = null;
    L344:
        d.d("ec_shop_popup_layout_info", r44);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r55 instanceof Integer) == true) goto L268;
        Object r61 = null;
    L269:
        r56 = (Integer) r61;     // Catch: Throwable -> L311
        if (r56 != null) goto L309;
        if ((r55 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r62 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L311
        if ((r62 instanceof Integer) == true) goto L279;
        r62 = null;
    L279:
        r56 = (Integer) r62;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r63 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L285;
        r63 = null;
    L285:
        r56 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r64 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L294;
        r64 = null;
    L294:
        r56 = (Integer) r64;     // Catch: Throwable -> L311
    L296:
        if ((r55 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r65 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r65 instanceof Integer) == true) goto L302;
        r65 = null;
    L302:
        Object r66 = Result.constructor-impl((Integer) r65);     // Catch: Throwable -> L304
    L306:
        r56 = r66;
        if (Result.isFailure-impl(r56) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L311
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r55 instanceof JSONArray) == false) goto L308;
    L268:
        r61 = r55;
    L337:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L346
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r69 = Result.exceptionOrNull-impl(r44);     // Catch: Throwable -> L346
        if (r69 == null) goto L342;
        EnsureManager.ensureNotReachHere(r69);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r44) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L337
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r49 instanceof Integer) == true) goto L198;
        Object r71 = null;
    L199:
        r50 = (Integer) r71;     // Catch: Throwable -> L241
        if (r50 != null) goto L239;
        if ((r49 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r72 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L241
        if ((r72 instanceof Integer) == true) goto L209;
        r72 = null;
    L209:
        r50 = (Integer) r72;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r73 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L215;
        r73 = null;
    L215:
        r50 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r50 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r74 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L224;
        r74 = null;
    L224:
        r50 = (Integer) r74;     // Catch: Throwable -> L241
    L226:
        if ((r49 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r75 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r75 instanceof Integer) == true) goto L232;
        r75 = null;
    L232:
        Object r76 = Result.constructor-impl((Integer) r75);     // Catch: Throwable -> L234
    L236:
        r50 = r76;
        if (Result.isFailure-impl(r50) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L241
        r76 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r49 instanceof JSONArray) == false) goto L238;
    L198:
        r71 = r49;
    L241:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L346
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r80 = Result.exceptionOrNull-impl(r44);
        if (r80 == null) goto L351;
        EnsureManager.ensureNotReachHere(r80);
    L351:
        if (Result.isFailure-impl(r44) == false) goto L189;
        goto L189
    }

    static {
        k = new ECShopABSettings();
        a = new ConcurrentHashMap();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.PUBLICATION;
        d = LazyKt.lazy(r0, ECShopABSettings$NEW_SHOP_FIRST_SCREEN_METRIC$2.INSTANCE);
        e = LazyKt.lazy(r0, ECShopABSettings$STORE_API_NO_BLOCK$2.INSTANCE);
        f = LazyKt.lazy(r0, ECShopABSettings$STORE_MULTI_VIEW_PAGER$2.INSTANCE);
        g = LazyKt.lazy(r0, ECShopABSettings$SHOP_Q4_PERF_REVERT$2.INSTANCE);
        h = LazyKt.lazy(r0, ECShopABSettings$FIX_VIEW_CONFIGURATION$2.INSTANCE);
        i = LazyKt.lazy(r0, ECShopABSettings$SHOP_Q3_PERF_OPT$2.INSTANCE);
        j = LazyKt.lazy(r0, ECShopABSettings$SHOP_SLICE_FROM_GECKO$2.INSTANCE);
    }

    public static void j() {
        Method[] r0 = ECShopABSettings.class.getDeclaredMethods();
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L24;
        Method r5 = r0[r4];
        if (Modifier.isPublic(r5.getModifiers()) == false) goto L20;
        Annotation[] r6 = r5.getDeclaredAnnotations();
        int r7 = r6.length;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L12;
        Annotation r9 = r6[r8];
        if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(r9), Reflection.getOrCreateKotlinClass(SettingReport.class)) == true) goto L13;
        r8 = r8 + 1;
    L13:
        if (r9 == null) goto L20;
        boolean r10 = true;
        if (r5.getParameterTypes().length != 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
    L21:
        if (r10 == false) goto L23;
        r1.add(r5);
    L23:
        r4 = r4 + 1;
        goto L3
    L17:
        r11 = false;
        goto L18
    L12:
        r9 = null;
    L20:
        r10 = false;
        goto L21
    L24:
        Iterator r3 = r1.iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        ((Method) r3.next()).invoke(k, new Object[0]);
        goto L26
    }

    public final Map<String, Object> b() {
        if (c == true) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (c == true) goto L10;
        k.getClass();     // Catch: Throwable -> L13
        j();     // Catch: Throwable -> L13
        c = true;     // Catch: Throwable -> L13
    L10:
        ConcurrentHashMap<String, Object> r0 = a;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r0;
    L5:
        return a;
    }
}
