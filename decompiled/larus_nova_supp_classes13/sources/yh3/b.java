package yh3;

import ai3.g;
import ai3.h;
import ai3.i;
import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.QueryMethod;
import com.bytedance.android.shopping.abscontainer.arch.platform.slice.PlatformSliceSDK;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.abscontainer.arch.core.starter.b {
    public final com.bytedance.android.shopping.abscontainer.arch.core.starter.a a;
    public final String b;
    public final Map<String, Object> c;
    public final SkuBuyPageInfo d;

    public static final class a {
    }

    static {
    }

    public final String e() {
        String r0 = this.d.getSchemaModel().getQueryParam("check_parallel_type");
        String r1 = this.d.getSchemaModel().getQueryParam("check_parallel_flag");
        if (Intrinsics.areEqual(r0, "prefetch") == true) goto L5;
        String r2 = "/order/component/confirmOrder/";
    L9:
        int r3 = j43.a.a();
        Lazy r4 = ECAppInfoService.a;
        if (we.a.a == false) goto L12;
        String r5 = String.valueOf(j43.a.a);
    L13:
        String r6 = this.d.getSchemaModel().getQueryParam("shape");
        String r7 = "";
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        String r8 = r2 + "?b_type_new=" + r3 + "&sub_b_type=" + r5 + "&buy_render_shape=" + r6;
        if (we.a.a == false) goto L24;
        String r9 = j43.a.b();
        if (r9 == null) goto L23;
        r7 = r9;
    L23:
        return r8 + "&webcast_appid=" + r7;
    L24:
        return r8;
    L12:
        r5 = "3";
        goto L13
    L5:
        if (Intrinsics.areEqual(r1, "HighFrequency") == false) goto L7;
        r2 = "/order/component/confirmOrderForLive/hot";
        goto L9
    L7:
        r2 = "/order/component/confirmOrderForLive/";
        goto L9
    }

    public final com.bytedance.android.shopping.abscontainer.arch.core.starter.a a() {
        return this.a;
    }

    public final Map<String, Object> b() {
        return this.c;
    }

    public final QueryMethod c() {
        return QueryMethod.POST;
    }

    public b(SkuBuyPageInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "pageInfo");
        this.d = r8;
        ECSettingKeys.d();
        boolean r1 = ECSettingKeys.d();
        ConcurrentHashMap r0 = a43.a.a;
        this.a = new com.bytedance.android.shopping.abscontainer.arch.core.starter.a(new YataPageInfo(r1, Intrinsics.areEqual(l43.a.a("ec_sku_buy_disable_compress"), 1), null, 4, null));
        this.b = "iesec_buy_finance_risk_post";
        this.c = new LinkedHashMap();
    }

    public final Map<String, Object> d(Object r18) {
        Object r0 = r18;
        if ((r0 instanceof v43.a) == true) goto L5;
        r0 = null;
    L5:
        v43.a r2 = (v43.a) r0;
        int r1 = PlatformSliceSDK.a;
        com.bytedance.android.ecom.arch.slice.render.context.b r4 = PlatformSliceSDK.a(com.bytedance.android.shopping.skubuy.platform.helper.b.b(this.d.d));
        int r3 = i.a;
        SkuBuyPageInfo r5 = this.d;
        String r6 = r5.getSchemaModel().getQueryParam("height_percent");
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        int r7 = k.r(i.a(r5, r6), 73);
        Pair[] r8 = new Pair[18];
        int r9 = j43.a.a;
        r8[0] = TuplesKt.to("user_id", r.a.getCurrentUserId());
        ECAppInfoService r10 = ECAppInfoService.e;
        r8[1] = TuplesKt.to("device_id", r10.getServerDeviceId());
        r8[2] = TuplesKt.to("app_id", String.valueOf(j43.a.a));
        r8[3] = TuplesKt.to("app_version", r10.getAppVersionName());
        String r11 = r10.getAppVersion();
        if (r11 == null) goto L11;
        Integer r12 = StringsKt.toIntOrNull(r11);
    L12:
        r8[4] = TuplesKt.to("version_code", r12);
        r8[5] = TuplesKt.to("os", "android");
        r8[6] = TuplesKt.to("page_type", "yata_android");
        int r14 = com.bytedance.android.shopping.skubuy.platform.helper.a.a;
        Intrinsics.checkNotNullParameter("HIDE_NO_PWD_CONFIRM", "key");
        Context r13 = r10.getApplicationContext();
        if (r13 != null) goto L15;
        String r15 = null;
    L16:
        r8[7] = TuplesKt.to("hide_pwd_confirm", Boolean.valueOf(k.n(r15, false)));
        Pair[] r16 = new Pair[4];
        r16[0] = TuplesKt.to("bottom_offset", 0);
        int r17 = g.a;
        r16[1] = TuplesKt.to("system_navigation_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(k1.e(r10.getApplicationContext())), r4)));
        r16[2] = TuplesKt.to("iesec_buy_now_opt_footer_margin", Boolean.TRUE);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L19
        Integer r20 = Integer.valueOf(j56.a.b(r10.getApplicationContext()));     // Catch: Throwable -> L19
    L21:
        if (r20 == null) goto L23;
        int r21 = r20.intValue();
    L24:
        r16[3] = TuplesKt.to("status_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r21), r4)));
        r8[8] = TuplesKt.to("client_params", MapsKt.mapOf(r16));
        ISkuBuySchemaModel r22 = this.d.getSchemaModel();
        if (r22 == null) goto L116;
        r8[9] = TuplesKt.to("entrance_info", r22.getFixEntranceInfoStr());
        r8[10] = TuplesKt.to("buynow_session_id", this.d.b);
        int r23 = j43.a.a;
        int r24 = com.bytedance.android.shopping.buynow.utils.r.a;
        ECAppInfoService r25 = ECAppInfoService.e;
        r8[11] = TuplesKt.to("is_accessible", Boolean.valueOf(com.bytedance.android.shopping.buynow.utils.r.c(r25.getApplicationContext())));
        r8[12] = TuplesKt.to("systemFontScale", r25.getCurrentFontScale());
        Pair[] r110 = new Pair[5];
        r110[0] = TuplesKt.to("page_type", "YATA_Android");
        String r26 = r25.getAppVersion();
        if (r26 == null) goto L29;
        Integer r27 = StringsKt.toIntOrNull(r26);
    L30:
        r110[1] = TuplesKt.to("version_code", r27);
        r110[2] = TuplesKt.to("app_id", String.valueOf(j43.a.a));
        int r28 = com.bytedance.android.shopping.abscontainer.arch.platform.yata.b.a;
        PackYataSdkConfig r29 = com.bytedance.kmp.ec.yata.common.init.b.a;
        r110[3] = TuplesKt.to("yata_version", "1.23.7");
        int r111 = PlatformSliceSDK.a;
        r110[4] = TuplesKt.to("slice_version", "2.34");
        r8[13] = TuplesKt.to("client_version", MapsKt.mapOf(r110));
        if (r7 <= 80) goto L33;
        r7 = 80;
    L33:
        r8[14] = TuplesKt.to("height_percent", Integer.valueOf(r7));
        r8[15] = TuplesKt.to("is_split_screen", Boolean.valueOf(this.d.d));
        r8[16] = TuplesKt.to("is_split_screen_open", Boolean.valueOf(this.d.e));
        Boolean r30 = Boolean.FALSE;
        r8[17] = TuplesKt.to("force_full_screen", r30);
        Map r31 = MapsKt.mapOf(r8);
        ISkuBuySchemaModel r32 = this.d.getSchemaModel();
        if (r32 == null) goto L114;
        Map r33 = r32.getSimplifyQueryParams();
        int r112 = ai3.b.a;
        int r113 = ECSdk.a;
        IAddressService r114 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r114 == null) goto L40;
        o83.a r115 = IAddressService.a.a(r114, null, "a1.b7411.c0.d0", 4);
        if (r115 == null) goto L40;
        String r116 = r115.a(true, null, null).toString();
    L41:
        if (r116 == null) goto L43;
        String r117 = (String) r33.put("ec_address_data", r116);
    L43:
        Lazy r118 = SkuBuyResponseCacheHelper.a;
        ISchemaModel r119 = this.d.getSchemaModel();
        Intrinsics.checkNotNullParameter(r119, "schemaModel");
        if (SkuBuyResponseCacheHelper.b(SkuBuyResponseCacheHelper.a(r119)) == null) goto L46;
        r33.put("has_used_client_cache", "true");
    L46:
        if (r2 != null) goto L48;
    L53:
        if (r2 == null) goto L58;
        Integer r120 = r2.d();
        if (r120 == null) goto L58;
        r120.intValue();
        r33.put("default_count", String.valueOf(r2.d()));
        r33.put("combo_num", String.valueOf(r2.d()));
        r33.put("sku_num", String.valueOf(r2.d()));
    L58:
        if (r2 == null) goto L72;
        int r34 = com.bytedance.android.shopping.skubuy.platform.helper.a.a;
        String r35 = (String) r33.get("id");
        if (r35 != null) goto L62;
        r35 = "";
    L62:
        Intrinsics.checkNotNullParameter(r35, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r36 = SkuCommonBigPicCacheController.a(r35);
        if (r36 != null) goto L65;
        String r121 = null;
    L70:
        r33.put("spec_mode", r121);
        int r37 = j43.d.a;
        r33.put("spec_mode_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        r33.put("disable_server_specs_default_select", "true");
        goto L72
    L65:
        if (r36.a == false) goto L67;
        int r38 = 1;
    L68:
        r121 = String.valueOf(r38);
        goto L70
    L67:
        r38 = 2;
    L72:
        int r39 = h.a;
        String r40 = this.d.getSchemaModel().getQueryParam("id");
        if (r40 != null) goto L75;
        r40 = "";
    L75:
        Intrinsics.checkNotNullParameter(r40, "productId");
        Map r41 = SkuYataSelfSaveBizFieldsCacheController.a(r40);
        if (r41 == null) goto L78;
        String r122 = k.x(r41);
    L79:
        if (r122 == null) goto L81;
        r33.put("sku_last_biz_fields", r122);
    L81:
        ISkuBuySchemaModel r42 = this.d.getSchemaModel();
        if (r42 == null) goto L112;
        Map r43 = r42.getMegaObject();
        if (r43 == null) goto L86;
        Map r123 = MapsKt.toMutableMap(r43);
    L87:
        if (r123 == null) goto L89;
        r123.remove("entrance_info");
    L89:
        if (r123 == null) goto L91;
        r123.remove("log_data");
    L91:
        if (r123 == null) goto L93;
        r123.remove("sku_log_data");
    L93:
        int r44 = j43.d.a;
        long r45 = System.currentTimeMillis();
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r46 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        this.c.put("biz_compose_query_cj_passthrough_duration", Long.valueOf(System.currentTimeMillis() - r45));
        Pair[] r47 = new Pair[7];
        r47[0] = TuplesKt.to("biometric_params", "1");
        TTCJPayUtils.Companion r48 = TTCJPayUtils.Companion;
        r47[1] = TuplesKt.to("is_jailbreak", r48.getInstance().getJailBreak());
        r47[2] = TuplesKt.to("cj_sdk", r48.getInstance().getSDKVersion());
        r47[3] = TuplesKt.to("bio_type", r48.getInstance().getBioType());
        int r49 = p.a;
        r47[4] = TuplesKt.to("installed_union_pay_app", r30);
        r47[5] = TuplesKt.to("cj_pass_through_info", "");
        ConcurrentHashMap r50 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a(this.b), 1) == true) goto L97;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW), TuplesKt.to("eztf_source_page", k.j(this.d.getSchemaModel().getQueryParam("eztf_sdk_extra")))});
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.c();
    L97:
        r47[6] = TuplesKt.to("finance_risk", null);
        Map r51 = MapsKt.mapOf(r47);
        Pair[] r52 = new Pair[6];
        b43.c r53 = b43.c.a;
        r52[0] = TuplesKt.to("ex_params", MapsKt.mapOf(new Pair[]{TuplesKt.to("extra_info", b43.c.e(r31)), TuplesKt.to("query_items", b43.c.e(r33)), TuplesKt.to("mega_object", b43.c.e(r123)), TuplesKt.to("cj_info", b43.c.e(r51))}));
        String r54 = this.d.getSchemaModel().getQueryParam("ultimate_buy_ab");
        if (r54 == null) goto L100;
        Integer r124 = StringsKt.toIntOrNull(r54);
    L101:
        r52[1] = TuplesKt.to("ultimate_buy_ab", r124);
        String r55 = this.d.getSchemaModel().getQueryParam("ultimate_buy_version");
        if (r55 == null) goto L104;
        Integer r125 = StringsKt.toIntOrNull(r55);
    L105:
        r52[2] = TuplesKt.to("ultimate_buy_version", r125);
        String r56 = this.d.getSchemaModel().getQueryParam("is_single_sku");
        if (r56 == null) goto L108;
        Integer r57 = StringsKt.toIntOrNull(r56);
    L109:
        r52[3] = TuplesKt.to("is_single_sku", r57);
        r52[4] = TuplesKt.to("yata_version", "1.23.7");
        r52[5] = TuplesKt.to("yata_protocol_info", this.a.a.addAndGetYataProtocolInfo());
        Map<String, Object> r58 = MapsKt.mapOf(r52);
        com.bytedance.android.shopping.abscontainer.common_biz.util.a.a("first_screen_api", this.d.getSchemaModel(), r58);
        return r58;
    L108:
        r57 = null;
        goto L109
    L104:
        r125 = null;
        goto L105
    L100:
        r124 = null;
        goto L101
    L86:
        r123 = null;
        goto L87
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L78:
        r122 = null;
        goto L79
    L48:
        if (r2.T() == null) goto L53;
        b43.c r126 = b43.c.a;
        String r127 = b43.c.e(r2.T());
        if (r127 != null) goto L52;
        r127 = "[]";
    L52:
        r33.put("default_spec_id", r127);
    L40:
        r116 = null;
        goto L41
    L114:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L29:
        r27 = null;
        goto L30
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L23:
        r21 = 0;
    L19:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        r20 = null;
        goto L21
    L15:
        r15 = ka3.b.a(r13, "HIDE_NO_PWD_CONFIRM");
        goto L16
    L11:
        r12 = null;
        goto L12
    }
}
