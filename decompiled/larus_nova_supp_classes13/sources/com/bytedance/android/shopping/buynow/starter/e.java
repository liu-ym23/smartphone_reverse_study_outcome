package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import android.content.res.Resources;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public ma3.m a;
    public Map<String, String> b;
    public final IOrderSchema c;
    public final c d;
    public final boolean e;

    public final JSONObject b() {
        if (this.c.C() == false) goto L5;
        String r0 = PageType.ULTIMATEBUYNOW;
    L7:
        if (BuyNowPerformanceOpt.h() == true) goto L10;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("buy_now_page_type", r0), TuplesKt.to("eztf_source_page", com.bytedance.android.shopping.extensions.k.j(this.c.getQueryParam("eztf_sdk_extra")))});
        p.a();
    L10:
        JSONObject r1 = new JSONObject();
        r1.put("biometric_params", "1");
        TTCJPayUtils.Companion r2 = TTCJPayUtils.Companion;
        r1.put("is_jailbreak", r2.getInstance().getJailBreak());
        r1.put("cj_sdk", r2.getInstance().getSDKVersion());
        r1.put("bio_type", r2.getInstance().getBioType());
        int r3 = p.a;
        r1.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r4 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r1.put("cj_pass_through_info", "");
        KtSafeMethodExtensionKt.safePut(r1, "finance_risk", null);
        return r1;
    L5:
        r0 = PageType.BUYNOW;
        goto L7
    }

    public final String e() {
        ECAppInfoService r0 = ECAppInfoService.e;
        Context r1 = r0.getApplicationContext();
        JSONObject r2 = this.c.B();
        Boolean r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.toString();
    L6:
        boolean r11 = true;
        boolean r5 = !this.c.C();
        boolean r6 = !this.c.C();
        c r7 = this.d;
        if (r7 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        com.bytedance.android.ecom.arch.slice.render.context.b r9 = new b(r5, r6, r8, 0.0f, 8).a();
        JSONObject r10 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r10, "user_id", r.a.getCurrentUserId());
        KtSafeMethodExtensionKt.safePut(r10, "device_id", r0.getServerDeviceId());
        KtSafeMethodExtensionKt.safePut(r10, "app_id", r0.getAppId());
        KtSafeMethodExtensionKt.safePut(r10, "app_version", r0.getAppVersionName());
        String r12 = r0.getAppVersion();
        if (r12 == null) goto L15;
        Integer r13 = StringsKt.toIntOrNull(r12);
    L16:
        KtSafeMethodExtensionKt.safePut(r10, "version_code", r13);
        KtSafeMethodExtensionKt.safePut(r10, "os", "android");
        KtSafeMethodExtensionKt.safePut(r10, "page_type", "yata_android");
        if (r1 == null) goto L19;
        KtSafeMethodExtensionKt.safePut(r10, "hide_pwd_confirm", Boolean.valueOf(com.bytedance.android.shopping.extensions.k.n(ka3.b.a(r1, "HIDE_NO_PWD_CONFIRM"), false)));
    L19:
        JSONObject r14 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r14, "bottom_offset", 0);
        r14.put("system_navigation_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(k1.e(r1)), r9)));
        r14.put("iesec_buy_now_opt_footer_margin", ((Boolean) ECSettingKeys.a.getValue()).booleanValue());
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L28
        c r16 = this.d;     // Catch: Throwable -> L28
        if (r16 != null) goto L23;
    L25:
        int r17 = j56.a.b(r1);     // Catch: Throwable -> L28
    L26:
        Object r18 = Result.constructor-impl(Integer.valueOf(r17));     // Catch: Throwable -> L28
    L30:
        Result.isFailure-impl(r18);
        if (Result.isFailure-impl(r18) == false) goto L33;
        r18 = 0;
    L33:
        KtSafeMethodExtensionKt.safePut(r14, "status_bar_height", Float.valueOf(SlcDimensExtensionsKt.d((Number) r18, r9)));
        Unit r19 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r10, "client_params", r14);
        if (r4 == null) goto L36;
        KtSafeMethodExtensionKt.safePut(r10, "entrance_info", r4);
    L36:
        c r20 = this.d;
        if (r20 == null) goto L39;
        String r21 = r20.a;
    L40:
        KtSafeMethodExtensionKt.safePut(r10, "buynow_session_id", r21);
        int r22 = com.bytedance.android.shopping.buynow.utils.r.a;
        ECAppInfoService r23 = ECAppInfoService.e;
        KtSafeMethodExtensionKt.safePut(r10, "is_accessible", Boolean.valueOf(com.bytedance.android.shopping.buynow.utils.r.c(r23.getApplicationContext())));
        KtSafeMethodExtensionKt.safePut(r10, "systemFontScale", r23.getCurrentFontScale());
        JSONObject r24 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r24, "page_type", "YATA_Android");
        String r25 = r23.getAppVersion();
        if (r25 == null) goto L43;
        Integer r26 = StringsKt.toIntOrNull(r25);
    L44:
        KtSafeMethodExtensionKt.safePut(r24, "version_code", r26);
        KtSafeMethodExtensionKt.safePut(r24, "app_id", r23.getAppId());
        PackYataSdkConfig r27 = com.bytedance.kmp.ec.yata.common.init.b.a;
        KtSafeMethodExtensionKt.safePut(r24, "yata_version", "1.23.7");
        KtSafeMethodExtensionKt.safePut(r24, "slice_version", "2.34");
        KtSafeMethodExtensionKt.safePut(r10, "client_version", r24);
        Lazy r28 = SkuBuyNowPanelHeightHelper.a;
        int r29 = SkuBuyNowPanelHeightHelper.a(this.c.getQueryParam("scene_type"), Integer.valueOf(com.bytedance.android.shopping.extensions.k.r(this.c.getQueryParam("height_percent"), 0)));
        this.c.replaceOrAppendParam("height_percent", String.valueOf(r29));
        KtSafeMethodExtensionKt.safePut(r10, "height_percent", Integer.valueOf(r29));
        KtSafeMethodExtensionKt.safePut(r10, "sub_height_percent", Integer.valueOf(SkuBuyNowPanelHeightHelper.b().getSubHeightPercent()));
        c r30 = this.d;
        if (r30 == null) goto L47;
        Boolean r31 = Boolean.valueOf(r30.d);
    L48:
        KtSafeMethodExtensionKt.safePut(r10, "is_split_screen", r31);
        c r32 = this.d;
        if (r32 == null) goto L51;
        r3 = Boolean.valueOf(r32.e);
    L51:
        KtSafeMethodExtensionKt.safePut(r10, "is_split_screen_open", r3);
        c r33 = this.d;
        if (r33 != null) goto L54;
    L58:
        r11 = false;
    L59:
        KtSafeMethodExtensionKt.safePut(r10, "force_full_screen", Boolean.valueOf(r11));
        return r10.toString();
    L54:
        if (r33.d != true) goto L58;
        if (this.c.C() == true) goto L58;
    L47:
        r31 = null;
        goto L48
    L43:
        r26 = null;
        goto L44
    L39:
        r21 = null;
        goto L40
    L23:
        if (r16.d != true) goto L25;
        int r34 = com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(j56.a.b(r1)));     // Catch: Throwable -> L28
        float r35 = r9.a;     // Catch: Throwable -> L28
        Resources r110 = Resources.getSystem();     // Catch: Throwable -> L28
        float r36 = r34;
        r17 = SlcDimensExtensionsKt.a(Float.valueOf(r36 + (28 - (11 * (r35 / WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density)))), r9);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L15:
        r13 = null;
        goto L16
    L9:
        if (r7.d != true) goto L11;
        r8 = true;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final String f() {
        if (this.e == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(this.c.getQueryParam("check_parallel_type"), "prefetch") == true) goto L12;
        if (Intrinsics.areEqual(this.c.getQueryParam("check_parallel_type"), "diff") == true) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(this.c.getQueryParam("check_parallel_flag"), "HighFrequency") == false) goto L15;
        return "/order/component/confirmOrderForLive/hot";
    L15:
        return "/order/component/confirmOrderForLive/";
    }

    public final String c() {
        if (BuyNowPerformanceOpt.j() == false) goto L7;
        return this.c.r0(SetsKt.setOf(new String[]{"log_data", "entrance_info"}));
    L7:
        return this.c.a();
    }

    public final ma3.f a(boolean r15) {
        boolean r0 = Intrinsics.areEqual(this.c.getQueryParam("enter_from_live_saas"), "1");
        int r1 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r2 = com.bytedance.android.shopping.buynow.utils.e.b(r0);
        int r3 = ja3.a.a(this.c);
        Map r4 = null;
        if (this.c.C() == false) goto L46;
        String r5 = this.c.getQueryParam("spec_mode");
        boolean r6 = false;
        if (r5 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == false) goto L22;
        String r8 = this.c.getQueryParam("id");
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        com.bytedance.android.shopping.sku.common.controller.b r9 = SkuCommonBigPicCacheController.a(r8);
        if (r9 == null) goto L22;
        if (r9.a == false) goto L20;
        int r10 = 1;
    L21:
        long r11 = r9.b / ((long) 1000);
        this.c.replaceOrAppendParam("spec_mode", String.valueOf(r10));
        this.c.replaceOrAppendParam("spec_mode_time", String.valueOf(r11));
        goto L22
    L20:
        r10 = 2;
    L22:
        IOrderSchema r12 = this.c;
        int r13 = com.bytedance.android.shopping.sku.inner.ultimate.b.a;
        c r14 = this.d;
        if (r14 != null) goto L25;
    L27:
        r12.replaceOrAppendParam("panel_width", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(r6)));
        this.c.replaceOrAppendParam("panel_height", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        this.b = d(r15);
        ma3.e r16 = new ma3.e(e(), com.bytedance.android.shopping.extensions.k.x(this.b), c(), b().toString());
        String r17 = this.c.getQueryParam("ultimate_buy_ab");
        if (r17 == null) goto L30;
        Integer r18 = StringsKt.toIntOrNull(r17);
    L31:
        String r19 = this.c.getQueryParam("ultimate_buy_version");
        if (r19 == null) goto L34;
        Integer r20 = StringsKt.toIntOrNull(r19);
    L35:
        String r21 = this.c.getQueryParam("is_single_sku");
        if (r21 == null) goto L38;
        Integer r110 = StringsKt.toIntOrNull(r21);
    L39:
        PackYataSdkConfig r22 = com.bytedance.kmp.ec.yata.common.init.b.a;
        c r23 = this.d;
        if (r23 == null) goto L44;
        YataPageInfo r24 = r23.b;
        if (r24 == null) goto L44;
        r4 = r24.addAndGetYataProtocolInfo();
    L44:
        ma3.r r111 = new ma3.r(r16, null, r18, r20, r110, "1.23.7", r4, 262);
        this.a = r111;
        return new ma3.f(r111, r1, r2, Integer.valueOf(r3));
    L38:
        r110 = null;
        goto L39
    L34:
        r20 = null;
        goto L35
    L30:
        r18 = null;
        goto L31
    L25:
        if (r14.d != true) goto L27;
        r6 = true;
        goto L27
    L7:
        if (r5.length() == 0) goto L10;
        r7 = false;
        goto L11
    L46:
        this.b = d(r15);
        ma3.e r25 = new ma3.e(e(), com.bytedance.android.shopping.extensions.k.x(d(r15)), c(), b().toString());
        PackYataSdkConfig r112 = com.bytedance.kmp.ec.yata.common.init.b.a;
        c r113 = this.d;
        if (r113 == null) goto L51;
        YataPageInfo r114 = r113.b;
        if (r114 == null) goto L51;
        r4 = r114.addAndGetYataProtocolInfo();
    L51:
        ma3.d r26 = new ma3.d(r25, r4);
        this.a = r26;
        return new ma3.f(r26, r1, r2, Integer.valueOf(r3));
    }

    public final Map<String, String> d(boolean r7) {
        IECAIHostService r1 = null;
        if (BuyNowPerformanceOpt.j() == false) goto L12;
        Map r0 = this.c.b();
        if (r0 == null) goto L11;
        Map<String, String> r2 = MapsKt.toMutableMap(r0);
        if (r2 == null) goto L11;
        r2.remove("mega_object");
        r2.remove("buynow_time");
        r2.remove("log_data");
        r2.remove("entrance_info");
        if (BuyNowPerformanceOpt.a() == false) goto L14;
        r2.put("show_detail_entrance", String.valueOf(com.bytedance.android.shopping.extensions.k.c(r2.get("detail_url"))));
        r2.remove("detail_url");
    L14:
        if (TypeIntrinsics.isMutableMap(r2) == true) goto L16;
        Map<String, String> r3 = null;
    L17:
        if (r3 != null) goto L19;
        r3 = new LinkedHashMap();
    L19:
        if (r7 == false) goto L22;
        r3 = com.bytedance.android.ec.core.monitor.param.c.b(r3);
    L22:
        if ((!Intrinsics.areEqual(r3, r2)) == false) goto L25;
        if (r2 == null) goto L25;
        r3.putAll(r2);
    L25:
        int r8 = ECSdk.a;
        IAddressService r9 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r9 == null) goto L38;
        c r4 = this.d;
        if (r4 == null) goto L32;
        WeakReference<Object> r5 = r4.c;
        if (r5 == null) goto L32;
        Object r6 = r5.get();
    L33:
        o83.a r10 = IAddressService.a.a(r9, r6, "a1.b7411.c0.d0", 4);
        if (r10 == null) goto L38;
        String r11 = r10.a(true, null, null).toString();
        if (r11 == null) goto L38;
        String r12 = r3.put("ec_address_data", r11);
    L32:
        r6 = null;
    L38:
        SkuYataSelfSaveBizFieldsCacheController.a r13 = SkuYataSelfSaveBizFieldsCacheController.a;
        String r14 = this.c.getQueryParam("id");
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        Map r15 = SkuYataSelfSaveBizFieldsCacheController.a(r14);
        if (r15 == null) goto L44;
        String r16 = r3.put("sku_last_biz_fields", com.bytedance.android.ec.hybrid.list.util.k.d(r15));
    L44:
        IECHostService r17 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r17 == null) goto L47;
        r1 = r17.getECHostAIService();
    L47:
        Pair[] r18 = new Pair[2];
        int r19 = 0;
        if (r1 != null) goto L50;
    L52:
        int r20 = 0;
    L53:
        r18[0] = TuplesKt.to("is_in_applet", Integer.valueOf(r20));
        if (r1 != null) goto L56;
    L58:
        r18[1] = TuplesKt.to("is_in_first_applet_page", Integer.valueOf(r19));
        r3.put("saas_extra_info", com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mapOf(r18)));
        return r3;
    L56:
        if (r1.isLandingPage() != true) goto L58;
        r19 = 1;
        goto L58
    L50:
        if (r1.isInApplet() != true) goto L52;
        r20 = 1;
        goto L53
    L16:
        r3 = r2;
    L11:
        r2 = null;
        goto L14
    L12:
        r2 = this.c.b();
        goto L14
    }

    public e(IOrderSchema r2, c r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "orderSchema");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
