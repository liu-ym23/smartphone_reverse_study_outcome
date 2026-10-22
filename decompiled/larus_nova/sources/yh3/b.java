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
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
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
import com.bytedance.pia.core.metrics.ErrorType;
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

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.abscontainer.arch.core.starter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.abscontainer.arch.core.starter.a f567557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f567558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f567559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SkuBuyPageInfo f567560d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.b
    public final String e() {
        String r100 = this.f567560d.getSchemaModel().getQueryParam("check_parallel_type");
        String r101 = this.f567560d.getSchemaModel().getQueryParam("check_parallel_flag");
        if (Intrinsics.areEqual(r100, ErrorType.PREFETCH) == true) goto L5;
        String r102 = "/order/component/confirmOrder/";
    L9:
        int r103 = j43.a.a();
        Lazy r104 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L12;
        String r105 = String.valueOf(j43.a.f497353a);
    L13:
        String r106 = this.f567560d.getSchemaModel().getQueryParam("shape");
        String r107 = "";
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        String r108 = r102 + "?b_type_new=" + r103 + "&sub_b_type=" + r105 + "&buy_render_shape=" + r106;
        if (we.a.f559330a == false) goto L24;
        String r109 = j43.a.b();
        if (r109 == null) goto L23;
        r107 = r109;
    L23:
        return r108 + "&webcast_appid=" + r107;
    L24:
        return r108;
    L12:
        r105 = "3";
        goto L13
    L5:
        if (Intrinsics.areEqual(r101, "HighFrequency") == false) goto L7;
        r102 = "/order/component/confirmOrderForLive/hot";
        goto L9
    L7:
        r102 = "/order/component/confirmOrderForLive/";
        goto L9
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.b
    public final com.bytedance.android.shopping.abscontainer.arch.core.starter.a a() {
        return this.f567557a;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.b
    public final Map<String, Object> b() {
        return this.f567559c;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.b
    public final QueryMethod c() {
        return QueryMethod.POST;
    }

    public b(SkuBuyPageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        this.f567560d = r100;
        ECSettingKeys.d();
        boolean r101 = ECSettingKeys.d();
        ConcurrentHashMap<String, Object> r102 = a43.a.f1756a;
        this.f567557a = new com.bytedance.android.shopping.abscontainer.arch.core.starter.a(new YataPageInfo(r101, Intrinsics.areEqual(l43.a.a("ec_sku_buy_disable_compress"), 1), null, 4, null));
        this.f567558b = "iesec_buy_finance_risk_post";
        this.f567559c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.b
    public final Map<String, Object> d(Object r110) {
        Object r100 = r110;
        if ((r100 instanceof v43.a) == true) goto L5;
        r100 = null;
    L5:
        v43.a r101 = (v43.a) r100;
        int r102 = PlatformSliceSDK.f164190a;
        com.bytedance.android.ecom.arch.slice.render.context.b r103 = PlatformSliceSDK.a(com.bytedance.android.shopping.skubuy.platform.helper.b.b(this.f567560d.f183205d));
        int r104 = i.f3737a;
        SkuBuyPageInfo r105 = this.f567560d;
        String r106 = r105.getSchemaModel().getQueryParam(ECFindSimilarConfig.HEIGHT_PERCENT);
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        int r107 = k.r(i.a(r105, r106), 73);
        Pair[] r108 = new Pair[18];
        int r109 = j43.a.f497353a;
        r108[0] = TuplesKt.to("user_id", r.f48132a.getCurrentUserId());
        ECAppInfoService r111 = ECAppInfoService.f48114e;
        r108[1] = TuplesKt.to("device_id", r111.getServerDeviceId());
        r108[2] = TuplesKt.to("app_id", String.valueOf(j43.a.f497353a));
        r108[3] = TuplesKt.to("app_version", r111.getAppVersionName());
        String r112 = r111.getAppVersion();
        if (r112 == null) goto L11;
        Integer r113 = StringsKt.toIntOrNull(r112);
    L12:
        r108[4] = TuplesKt.to("version_code", r113);
        r108[5] = TuplesKt.to("os", "android");
        r108[6] = TuplesKt.to("page_type", "yata_android");
        int r114 = com.bytedance.android.shopping.skubuy.platform.helper.a.f183161a;
        Intrinsics.checkNotNullParameter("HIDE_NO_PWD_CONFIRM", "key");
        Context r115 = r111.getApplicationContext();
        if (r115 != null) goto L15;
        String r116 = null;
    L16:
        r108[7] = TuplesKt.to("hide_pwd_confirm", Boolean.valueOf(k.n(r116, false)));
        Pair[] r117 = new Pair[4];
        r117[0] = TuplesKt.to("bottom_offset", 0);
        int r118 = g.f3735a;
        r117[1] = TuplesKt.to("system_navigation_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(k1.e(r111.getApplicationContext())), r103)));
        r117[2] = TuplesKt.to("iesec_buy_now_opt_footer_margin", Boolean.TRUE);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L19
        Integer r120 = Integer.valueOf(j56.a.b(r111.getApplicationContext()));     // Catch: Throwable -> L19
    L21:
        if (r120 == null) goto L23;
        int r121 = r120.intValue();
    L24:
        r117[3] = TuplesKt.to("status_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r121), r103)));
        r108[8] = TuplesKt.to("client_params", MapsKt.mapOf(r117));
        ISchemaModel r122 = this.f567560d.getSchemaModel();
        if (r122 == null) goto L116;
        r108[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, ((ISkuBuySchemaModel) r122).getFixEntranceInfoStr());
        r108[10] = TuplesKt.to("buynow_session_id", this.f567560d.f183203b);
        int r123 = j43.a.f497353a;
        int r124 = com.bytedance.android.shopping.buynow.utils.r.f171224a;
        ECAppInfoService r125 = ECAppInfoService.f48114e;
        r108[11] = TuplesKt.to("is_accessible", Boolean.valueOf(com.bytedance.android.shopping.buynow.utils.r.c(r125.getApplicationContext())));
        r108[12] = TuplesKt.to("systemFontScale", r125.getCurrentFontScale());
        Pair[] r126 = new Pair[5];
        r126[0] = TuplesKt.to("page_type", "YATA_Android");
        String r127 = r125.getAppVersion();
        if (r127 == null) goto L29;
        Integer r128 = StringsKt.toIntOrNull(r127);
    L30:
        r126[1] = TuplesKt.to("version_code", r128);
        r126[2] = TuplesKt.to("app_id", String.valueOf(j43.a.f497353a));
        int r129 = com.bytedance.android.shopping.abscontainer.arch.platform.yata.b.f164212a;
        PackYataSdkConfig r130 = com.bytedance.kmp.ec.yata.common.init.b.f251424a;
        r126[3] = TuplesKt.to("yata_version", "1.23.7");
        int r131 = PlatformSliceSDK.f164190a;
        r126[4] = TuplesKt.to("slice_version", "2.34");
        r108[13] = TuplesKt.to("client_version", MapsKt.mapOf(r126));
        if (r107 <= 80) goto L33;
        r107 = 80;
    L33:
        r108[14] = TuplesKt.to(ECFindSimilarConfig.HEIGHT_PERCENT, Integer.valueOf(r107));
        r108[15] = TuplesKt.to("is_split_screen", Boolean.valueOf(this.f567560d.f183205d));
        r108[16] = TuplesKt.to("is_split_screen_open", Boolean.valueOf(this.f567560d.f183206e));
        Boolean r132 = Boolean.FALSE;
        r108[17] = TuplesKt.to("force_full_screen", r132);
        Map r133 = MapsKt.mapOf(r108);
        ISchemaModel r134 = this.f567560d.getSchemaModel();
        if (r134 == null) goto L114;
        Map<String, String> r135 = ((ISkuBuySchemaModel) r134).getSimplifyQueryParams();
        int r136 = ai3.b.f3730a;
        int r137 = ECSdk.f48106a;
        IAddressService r138 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r138 == null) goto L40;
        o83.a r139 = IAddressService.a.a(r138, null, "a1.b7411.c0.d0", 4);
        if (r139 == null) goto L40;
        String r140 = r139.a(true, null, null).toString();
    L41:
        if (r140 == null) goto L43;
        String r141 = r135.put("ec_address_data", r140);
    L43:
        Lazy r142 = SkuBuyResponseCacheHelper.f183110a;
        ISchemaModel r143 = this.f567560d.getSchemaModel();
        Intrinsics.checkNotNullParameter(r143, "schemaModel");
        if (SkuBuyResponseCacheHelper.b(SkuBuyResponseCacheHelper.a(r143)) == null) goto L46;
        r135.put("has_used_client_cache", "true");
    L46:
        if (r101 != null) goto L48;
    L53:
        if (r101 == null) goto L58;
        Integer r144 = r101.d();
        if (r144 == null) goto L58;
        r144.intValue();
        r135.put("default_count", String.valueOf(r101.d()));
        r135.put("combo_num", String.valueOf(r101.d()));
        r135.put("sku_num", String.valueOf(r101.d()));
    L58:
        if (r101 == null) goto L72;
        int r145 = com.bytedance.android.shopping.skubuy.platform.helper.a.f183161a;
        String r146 = r135.get("id");
        if (r146 != null) goto L62;
        r146 = "";
    L62:
        Intrinsics.checkNotNullParameter(r146, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r147 = SkuCommonBigPicCacheController.a(r146);
        if (r147 != null) goto L65;
        String r148 = null;
    L70:
        r135.put("spec_mode", r148);
        int r149 = j43.d.f497356a;
        r135.put("spec_mode_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        r135.put("disable_server_specs_default_select", "true");
        goto L72
    L65:
        if (r147.f182630a == false) goto L67;
        int r150 = 1;
    L68:
        r148 = String.valueOf(r150);
        goto L70
    L67:
        r150 = 2;
    L72:
        int r151 = h.f3736a;
        String r152 = this.f567560d.getSchemaModel().getQueryParam("id");
        if (r152 != null) goto L75;
        r152 = "";
    L75:
        Intrinsics.checkNotNullParameter(r152, "productId");
        Map r153 = SkuYataSelfSaveBizFieldsCacheController.a(r152);
        if (r153 == null) goto L78;
        String r154 = k.x(r153);
    L79:
        if (r154 == null) goto L81;
        r135.put("sku_last_biz_fields", r154);
    L81:
        ISchemaModel r155 = this.f567560d.getSchemaModel();
        if (r155 == null) goto L112;
        Map<String, Object> r156 = ((ISkuBuySchemaModel) r155).getMegaObject();
        if (r156 == null) goto L86;
        Map r157 = MapsKt.toMutableMap(r156);
    L87:
        if (r157 == null) goto L89;
        r157.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L89:
        if (r157 == null) goto L91;
        r157.remove("log_data");
    L91:
        if (r157 == null) goto L93;
        r157.remove("sku_log_data");
    L93:
        int r158 = j43.d.f497356a;
        long r159 = System.currentTimeMillis();
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r160 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.f164354a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        this.f567559c.put("biz_compose_query_cj_passthrough_duration", Long.valueOf(System.currentTimeMillis() - r159));
        Pair[] r161 = new Pair[7];
        r161[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        TTCJPayUtils.Companion r162 = TTCJPayUtils.Companion;
        r161[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, r162.getInstance().getJailBreak());
        r161[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, r162.getInstance().getSDKVersion());
        r161[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, r162.getInstance().getBioType());
        int r163 = p.f187156a;
        r161[4] = TuplesKt.to("installed_union_pay_app", r132);
        r161[5] = TuplesKt.to("cj_pass_through_info", "");
        ConcurrentHashMap<String, Object> r164 = a43.a.f1756a;
        if (Intrinsics.areEqual(l43.a.a(this.f567558b), 1) == true) goto L97;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW), TuplesKt.to("eztf_source_page", k.j(this.f567560d.getSchemaModel().getQueryParam("eztf_sdk_extra")))});
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.c();
    L97:
        r161[6] = TuplesKt.to("finance_risk", null);
        Map r165 = MapsKt.mapOf(r161);
        Pair[] r166 = new Pair[6];
        b43.c r167 = b43.c.f17507a;
        r166[0] = TuplesKt.to("ex_params", MapsKt.mapOf(new Pair[]{TuplesKt.to("extra_info", b43.c.e(r133)), TuplesKt.to("query_items", b43.c.e(r135)), TuplesKt.to("mega_object", b43.c.e(r157)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, b43.c.e(r165))}));
        String r168 = this.f567560d.getSchemaModel().getQueryParam("ultimate_buy_ab");
        if (r168 == null) goto L100;
        Integer r169 = StringsKt.toIntOrNull(r168);
    L101:
        r166[1] = TuplesKt.to("ultimate_buy_ab", r169);
        String r170 = this.f567560d.getSchemaModel().getQueryParam("ultimate_buy_version");
        if (r170 == null) goto L104;
        Integer r171 = StringsKt.toIntOrNull(r170);
    L105:
        r166[2] = TuplesKt.to("ultimate_buy_version", r171);
        String r172 = this.f567560d.getSchemaModel().getQueryParam("is_single_sku");
        if (r172 == null) goto L108;
        Integer r173 = StringsKt.toIntOrNull(r172);
    L109:
        r166[3] = TuplesKt.to("is_single_sku", r173);
        r166[4] = TuplesKt.to("yata_version", "1.23.7");
        r166[5] = TuplesKt.to("yata_protocol_info", this.f567557a.f164159a.addAndGetYataProtocolInfo());
        Map<String, Object> r174 = MapsKt.mapOf(r166);
        com.bytedance.android.shopping.abscontainer.common_biz.util.a.a("first_screen_api", this.f567560d.getSchemaModel(), r174);
        return r174;
    L108:
        r173 = null;
        goto L109
    L104:
        r171 = null;
        goto L105
    L100:
        r169 = null;
        goto L101
    L86:
        r157 = null;
        goto L87
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L78:
        r154 = null;
        goto L79
    L48:
        if (r101.T() == null) goto L53;
        b43.c r175 = b43.c.f17507a;
        String r176 = b43.c.e(r101.T());
        if (r176 != null) goto L52;
        r176 = "[]";
    L52:
        r135.put("default_spec_id", r176);
    L40:
        r140 = null;
        goto L41
    L114:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L29:
        r128 = null;
        goto L30
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel");
    L23:
        r121 = 0;
    L19:
        th = move-exception;
        Result.Companion r177 = Result.Companion;
        Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        r120 = null;
        goto L21
    L15:
        r116 = ka3.b.a(r115, "HIDE_NO_PWD_CONFIRM");
        goto L16
    L11:
        r113 = null;
        goto L12
    }
}
