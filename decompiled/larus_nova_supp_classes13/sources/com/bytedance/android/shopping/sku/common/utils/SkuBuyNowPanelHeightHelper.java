package com.bytedance.android.shopping.sku.common.utils;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuBuyNowPanelHeightHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(SkuBuyNowPanelHeightHelper$SKU_BUY_EIGHTY_PERCENT_SCENE_TYPE_LIST$2.INSTANCE);
    }

    @SettingPanel("sku一步提单二级页的面板高度配置")
    public static final SkuBuyHeightPercentConfig b() {
        int r0 = j.a;
        Object r2 = null;
        Object r1 = new SkuBuyHeightPercentConfig(0, null, 3, null);
        int r3 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        r5.getClass();     // Catch: Throwable -> L58
        Object r6 = SDKSettingsCacheManager.b.get("sku_buy_opt_sub_height_percent_config");     // Catch: Throwable -> L58
        if (r6 != null) goto L10;
    L55:
        Object r7 = null;
    L56:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L58
    L60:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L171
        if (r9 == null) goto L64;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L171
    L64:
        if (Result.isFailure-impl(r8) == false) goto L67;
        r8 = null;
    L67:
        if ((r8 instanceof SkuBuyHeightPercentConfig) == true) goto L69;
        r8 = null;
    L69:
        Object r10 = (SkuBuyHeightPercentConfig) r8;     // Catch: Throwable -> L171
        if (r10 != null) goto L76;
        r5.getClass();     // Catch: Throwable -> L171
        Object r11 = SDKSettingsCacheManager.a.get("sku_buy_opt_sub_height_percent_config");     // Catch: Throwable -> L171
        if ((r11 instanceof SkuBuyHeightPercentConfig) == true) goto L75;
        r11 = null;
    L75:
        r10 = (SkuBuyHeightPercentConfig) r11;     // Catch: Throwable -> L171
    L76:
        if (r10 != null) goto L181;
        int r12 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L171
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L160:
        Object r15 = r14;
        if (Result.exceptionOrNull-impl(r15) != null) goto L188;
    L168:
        r10 = r15;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("sku_buy_opt_sub_height_percent_config", r10);     // Catch: Throwable -> L171
        goto L181
    L188:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("sku_buy_opt_sub_height_percent_config", SkuBuyHeightPercentConfig.class, r1);     // Catch: Throwable -> L165
    L166:
        if (r15 != null) goto L168;
        r10 = r1;
    L165:
        r15 = r1;
        goto L166
    L194:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r16 = SDKSettingsCacheManager.b.get("sku_buy_opt_sub_height_percent_config");     // Catch: Throwable -> L132
        if (r16 != null) goto L84;
    L129:
        Object r17 = null;
    L130:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L132
    L134:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L158
        if (r19 == null) goto L138;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r18) == false) goto L141;
        r18 = null;
    L141:
        if ((r18 instanceof SkuBuyHeightPercentConfig) == true) goto L143;
        r18 = null;
    L143:
        r15 = (SkuBuyHeightPercentConfig) r18;     // Catch: Throwable -> L158
        if (r15 != null) goto L168;
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L158
        Object r21 = jj4.a.a("sku_buy_opt_sub_height_percent_config", SkuBuyHeightPercentConfig.class, r1, false);     // Catch: Throwable -> L158
        if (r21 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r21 instanceof SkuBuyHeightPercentConfig) == false) goto L153;
        r2 = r21;
    L153:
        Object r22 = (SkuBuyHeightPercentConfig) r2;     // Catch: Throwable -> L158
        if (r22 != null) goto L156;
        r22 = r1;
    L156:
        r14 = Result.constructor-impl(r22);     // Catch: Throwable -> L158
    L84:
        if ((r16 instanceof SkuBuyHeightPercentConfig) == true) goto L86;
        Object r23 = null;
    L87:
        r17 = (SkuBuyHeightPercentConfig) r23;     // Catch: Throwable -> L132
        if (r17 != null) goto L130;
        if ((r16 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L132
        if ((r24 instanceof SkuBuyHeightPercentConfig) == true) goto L97;
        r24 = null;
    L97:
        r17 = (SkuBuyHeightPercentConfig) r24;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L132
        if ((r25 instanceof SkuBuyHeightPercentConfig) == true) goto L103;
        r25 = null;
    L103:
        r17 = (SkuBuyHeightPercentConfig) r25;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r26 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L132
        if ((r26 instanceof SkuBuyHeightPercentConfig) == true) goto L109;
        r26 = null;
    L109:
        r17 = (SkuBuyHeightPercentConfig) r26;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L132
        if ((r27 instanceof SkuBuyHeightPercentConfig) == true) goto L115;
        r27 = null;
    L115:
        r17 = (SkuBuyHeightPercentConfig) r27;     // Catch: Throwable -> L132
    L117:
        if ((r16 instanceof JSONObject) == false) goto L119;
    L186:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), SkuBuyHeightPercentConfig.class);     // Catch: Throwable -> L125
        if ((r28 instanceof SkuBuyHeightPercentConfig) == true) goto L123;
        r28 = null;
    L123:
        Object r29 = Result.constructor-impl((SkuBuyHeightPercentConfig) r28);     // Catch: Throwable -> L125
    L127:
        r17 = r29;
        if (Result.isFailure-impl(r17) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L132
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r16 instanceof JSONArray) == false) goto L129;
    L86:
        r23 = r16;
    L132:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L158
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (SkuBuyHeightPercentConfig) r10;
    L10:
        if ((r6 instanceof SkuBuyHeightPercentConfig) == true) goto L12;
        Object r32 = null;
    L13:
        r7 = (SkuBuyHeightPercentConfig) r32;     // Catch: Throwable -> L58
        if (r7 != null) goto L56;
        if ((r6 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r33 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L58
        if ((r33 instanceof SkuBuyHeightPercentConfig) == true) goto L23;
        r33 = null;
    L23:
        r7 = (SkuBuyHeightPercentConfig) r33;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r34 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L58
        if ((r34 instanceof SkuBuyHeightPercentConfig) == true) goto L29;
        r34 = null;
    L29:
        r7 = (SkuBuyHeightPercentConfig) r34;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r35 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L58
        if ((r35 instanceof SkuBuyHeightPercentConfig) == true) goto L35;
        r35 = null;
    L35:
        r7 = (SkuBuyHeightPercentConfig) r35;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SkuBuyHeightPercentConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r36 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L58
        if ((r36 instanceof SkuBuyHeightPercentConfig) == true) goto L41;
        r36 = null;
    L41:
        r7 = (SkuBuyHeightPercentConfig) r36;     // Catch: Throwable -> L58
    L43:
        if ((r6 instanceof JSONObject) == false) goto L45;
    L192:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r6.toString(), SkuBuyHeightPercentConfig.class);     // Catch: Throwable -> L51
        if ((r37 instanceof SkuBuyHeightPercentConfig) == true) goto L49;
        r37 = null;
    L49:
        Object r38 = Result.constructor-impl((SkuBuyHeightPercentConfig) r37);     // Catch: Throwable -> L51
    L53:
        r7 = r38;
        if (Result.isFailure-impl(r7) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L58
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r6 instanceof JSONArray) == false) goto L55;
    L12:
        r32 = r6;
    L58:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L171
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L176;
        EnsureManager.ensureNotReachHere(r43);
    L176:
        if (Result.isFailure-impl(r42) == true) goto L179;
        r1 = r42;
    L179:
        r10 = r1;
        goto L181
    }

    public static Integer c(Integer r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.intValue() > 0) goto L8;
    L11:
        return null;
    L8:
        if (r3.intValue() >= 100) goto L11;
        return r3;
    }

    public static int a(String r0, Integer r1) {
        Integer r2 = c(r1);
        if (r2 != null) goto L5;
        JSONObject r3 = (JSONObject) a.getValue();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.optInt(r0));
    L10:
        Integer r5 = c(r4);
        if (r5 != null) goto L13;
        return 73;
    L13:
        return r5.intValue();
    L9:
        r4 = null;
        goto L10
    L5:
        return r2.intValue();
    }

    public static String d(String r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$handleHeightPercent");
        if (c(r7) == null) goto L28;
        if (r7 != null) goto L7;
    L9:
        UrlBuilderV2 r8 = new UrlBuilderV2(r6);
        String r1 = r8.getQuery("height_percent");
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return r6;
    L18:
        Iterator<T> r3 = b().getUrlWhiteList().iterator();
    L20:
        if (r3.hasNext() == false) goto L30;
        if (StringsKt.contains$default(r6, (String) r3.next(), false, 2, null) == false) goto L20;
        r8.addOrReplaceParam("height_percent", b().getSubHeightPercent());
        return r8.build();
    L30:
        return r6;
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L7:
        if (r7.intValue() != 73) goto L9;
        return r6;
    L28:
        return r6;
    }
}
