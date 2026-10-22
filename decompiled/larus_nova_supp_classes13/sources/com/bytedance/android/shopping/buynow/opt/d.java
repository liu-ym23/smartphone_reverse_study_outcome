package com.bytedance.android.shopping.buynow.opt;

import android.net.Uri;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ma3.r;
import org.json.JSONArray;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.android.shopping.buynow.cache.a a(IOrderSchema r8) {
        Intrinsics.checkNotNullParameter(r8, "orderSchema");
        String r1 = null;
        if (r8.C() == false) goto L19;
        String r0 = r8.getQueryParam("id");
        String r2 = r8.getQueryParam("sku_promotion_id");
        String r3 = r8.getQueryParam("scene_type");
        String r4 = r8.getQueryParam("default_spec_id");
        if (r4 == null) goto L17;
        JSONArray r5 = z1.e(r4);
        if (r5 == null) goto L17;
        boolean r6 = false;
        String r7 = r5.optString(0);
        if (r7 == null) goto L17;
        HashMap r9 = j.a;
        if (j.e(r7) == true) goto L13;
    L15:
        if (r6 == false) goto L17;
        r1 = r7;
        goto L17
    L13:
        if ((!Intrinsics.areEqual(r7, "null")) == false) goto L15;
        r6 = true;
    L17:
        com.bytedance.android.shopping.buynow.cache.a r10 = new com.bytedance.android.shopping.buynow.cache.a(r2, r0, r3, r1);
        r8.X(r10);
        return r10;
    L19:
        return null;
    }

    public static void c(IOrderSchema r7) {
        com.bytedance.android.shopping.buynow.cache.a r0 = a(r7);
        String r2 = null;
        if ((r0 instanceof com.bytedance.android.shopping.buynow.cache.a) == true) goto L5;
        r0 = null;
    L5:
        dm.a.a("BuyNowPrefetcher").a("cache key " + r0);
        Map<String, UltimateBuyCacheQueryHelper> r3 = UltimateBuyCacheHelper.b;
        if (UltimateBuyCacheHelper.a(r0) == true) goto L24;
        Lazy r4 = SkuBuyResponseCacheHelper.a;
        if (r0 == null) goto L10;
        String r5 = r0.a;
    L11:
        if (r0 == null) goto L13;
        String r6 = r0.b;
    L14:
        if (r0 == null) goto L16;
        String r8 = r0.c;
    L17:
        if (r0 == null) goto L19;
        r2 = r0.d;
    L19:
        com.bytedance.android.shopping.skubuy.cache.a r9 = new com.bytedance.android.shopping.skubuy.cache.a(r5, r6, r8, r2);
        com.bytedance.android.shopping.abscontainer.arch.core.cache.b r1 = (com.bytedance.android.shopping.abscontainer.arch.core.cache.b) SkuBuyResponseCacheHelper.b.getValue();
        String r10 = r9.a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "cacheKey");
        if (SkuBuyResponseCacheHelper.c((com.bytedance.android.shopping.abscontainer.arch.core.cache.a) r1.a.b(r10)) == true) goto L24;
        dm.a.a("BuyNowPrefetcher").a("prefetchBuyOrderSchema cache INVALID");
        new s().a(r7);
        e(r7);
        return;
    L16:
        r8 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L10:
        r5 = null;
    L24:
        dm.a.a("BuyNowPrefetcher").a("prefetchBuyOrderSchema cache VALID");
    }

    public static void e(IOrderSchema r11) {
        dm.a.a("BuyNowPrefetcher").a("prefetchDirectly");
        if (r11 != null) goto L5;
        return;
    L5:
        na3.g r1 = na3.g.a;
        Integer r3 = null;
        com.bytedance.android.shopping.buynow.starter.e r2 = new com.bytedance.android.shopping.buynow.starter.e(r11, null, true);
        Intrinsics.checkNotNullParameter(r2, "requestBuilder");
        ma3.f r4 = r2.a(false);
        if ((r4.a instanceof r) == false) goto L19;
        com.bytedance.android.shopping.buynow.cache.a r5 = a(r2.c);
        dm.a.a("BuyNowPrefetcher").a("prefetch api cache key " + r5);
        r r6 = (r) r4.a;
        int r7 = r4.b;
        int r8 = r4.c;
        String r0 = r2.c.getQueryParam("shape");
        if (r0 == null) goto L11;
        r3 = StringsKt.toIntOrNull(r0);
    L11:
        String r10 = r2.c.getQueryParam("biz_identity");
        Intrinsics.checkNotNullParameter(r6, "req");
        UltimateBuyNowApi.a.getClass();
        Observable<SsResponse<String>> r9 = UltimateBuyNowApi.a.b.getPrefetchForUltimateBuy(r6, r7, r8, r3, r10);
        Intrinsics.checkNotNullParameter(r9, "$this$putCache");
        Observable r12 = r9.doOnNext(new com.bytedance.android.shopping.buynow.cache.b(r5, false)).subscribeOn(Schedulers.io());
        if (r12 == null) goto L17;
        Disposable r13 = r12.subscribe(na3.c.a, na3.d.a);
        if (r13 == null) goto L18;
        Intrinsics.checkNotNullParameter(r13, "$this$globalScope");
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void b(ql.a r7, l r8) {
        dm.a.a("BuyNowPrefetcher").a("prefetchAsyncOnLiveRoom");
        com.bytedance.android.shopping.buynow.cache.a r1 = new com.bytedance.android.shopping.buynow.cache.a(r7.getPromotionId(), r7.getProductId(), String.valueOf(201), k.x(r8.a));
        dm.a.a("BuyNowPrefetcher").a(" prefetchAsyncOnLiveRoomcache key " + r1);
        Map<String, UltimateBuyCacheQueryHelper> r2 = UltimateBuyCacheHelper.b;
        if (UltimateBuyCacheHelper.a(r1) == false) goto L6;
        dm.a.a("BuyNowPrefetcher").a("prefetch cache VALID");
        return;
    L6:
        dm.a.a("BuyNowPrefetcher").a("prefetch cache INVALID");
        Uri.Builder r0 = new Uri.Builder().scheme("sslocal").authority("buy_now");
        r0.appendQueryParameter("id", r7.getProductId());
        r0.appendQueryParameter("is_single_sku", String.valueOf(r7.getSingleSku()));
        r0.appendQueryParameter("group_type", String.valueOf(r7.isMultiGroupBuy()));
        r0.appendQueryParameter("scene_type", String.valueOf(201));
        r0.appendQueryParameter("auto_apply_coupon", String.valueOf(false));
        List<String> r9 = r8.a;
        if (r9 == null) goto L9;
        r0.appendQueryParameter("default_spec_id", k.x(r9));
    L9:
        String r10 = r7.getChannelId();
        if (r10 == null) goto L12;
        r0.appendQueryParameter("product_channel_id", r10);
    L12:
        Integer r11 = r7.getChannelType();
        if (r11 == null) goto L15;
        r0.appendQueryParameter("product_channel_type", String.valueOf(r11.intValue()));
    L15:
        r0.appendQueryParameter("sku_enter_from", "live");
        r0.appendQueryParameter("disable_server_specs_default_select", String.valueOf(false));
        Lazy r12 = ECAppInfoService.a;
        r0.appendQueryParameter("enter_from_live_saas", String.valueOf(we.a.a));
        r0.appendQueryParameter("ultimate_buy_version", "1");
        r0.appendQueryParameter("ultimate_buy_ab", "2");
        r0.appendQueryParameter("sku_promotion_id", r7.getPromotionId());
        r0.appendQueryParameter("panel_width", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(false)));
        r0.appendQueryParameter("panel_height", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        r0.appendQueryParameter("biz_identity", r7.getBizIdentity());
        Uri r13 = r0.build();
        int r14 = ECSdk.a;
        IECCommonService r15 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r15 == null) goto L18;
        IOrderSchema r16 = r15.convertToOrderSchema(r13, new EntranceInfoScene("ecomLive", "enterOrderPage"));
    L19:
        if (r16 == null) goto L21;
        r16.z0();
    L21:
        e(r16);
        return;
    L18:
        r16 = null;
        goto L19
    }

    public static void d(ql.a r7, l r8, BuyNowPrefetchType r9) {
        if (r9 != BuyNowPrefetchType.FIRST_SHOW) goto L12;
        Lazy r10 = ECSettingKeys.d;
        if (((Number) r10.getValue()).intValue() != 2) goto L8;
        dm.a.a("BuyNowPrefetcher").a("prefetch use pitaya");
        dm.a.a("BuyNowPrefetcher").a("prefetchByPitaya");
        int r11 = com.bytedance.android.ec.core.buynow.b.a;
        b(r7, r8);
        return;
    L8:
        if (((Number) r10.getValue()).intValue() != 1) goto L10;
        dm.a.a("BuyNowPrefetcher").a("prefetch not use pitaya");
        b(r7, r8);
        return;
    L10:
        dm.a.a("BuyNowPrefetcher").a("do not prefetch");
        return;
    L12:
        if (r9 != BuyNowPrefetchType.CLICK) goto L23;
        Lazy r12 = ECSettingKeys.e;
        if (((Number) r12.getValue()).intValue() != 2) goto L17;
        dm.a.a("BuyNowPrefetcher").a("prefetch use pitaya");
        dm.a.a("BuyNowPrefetcher").a("prefetchByPitaya");
        int r13 = com.bytedance.android.ec.core.buynow.b.a;
        b(r7, r8);
        return;
    L17:
        if (((Number) r12.getValue()).intValue() != 1) goto L25;
        dm.a.a("BuyNowPrefetcher").a("prefetch not use pitaya");
        b(r7, r8);
        return;
    L25:
        return;
    }
}
