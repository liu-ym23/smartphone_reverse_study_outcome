package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.controller.BuyNowOrderLoadingController;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowApi;
import com.bytedance.android.shopping.buynow.data.remote.ContinuePayApi;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z extends com.bytedance.kmp.ec.yata.event.common.a {
    public Boolean a;
    public Map<?, ?> b;
    public Map<String, ? extends Object> c;
    public final Context d;
    public final AndroidYaTaInstance e;
    public final ia3.b f;
    public final BuyNowFragment g;
    public final BuyNowViewModel h;
    public final pa3.a i;

    public static final class a {
    }

    static {
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r26, Function1 r27) {
        Intrinsics.checkNotNullParameter(r26, "input");
        Intrinsics.checkNotNullParameter(r27, "chainNextCallback");
        String r2 = "selfSubmit";
        BuyNowLog.d("selfSubmit", "selfSubmit starts");
        pa3.a r3 = this.i;
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.order.a r4 = r3.b;
        if (r4 == null) goto L7;
        r4.a(BuyNowOrderNode.ORDER_CREATE_START, System.currentTimeMillis());
    L7:
        TTCJPayUtils.Companion.getInstance().externalBizReport(CheckPointType.PAY_START, "ecommerce_pay_desk", System.currentTimeMillis(), "", null);
        AndroidYaTaInstance r5 = this.e;
        if (r5 == null) goto L14;
        YataPageInfo r6 = ((YataStoreWrapper) r5).c;
        if (r6 == null) goto L14;
        com.bytedance.kmp.ec.yata.common.biz.a r7 = r6.addAndGetYataProtocolInfoModel();
        if (r7 == null) goto L14;
        Map r10 = r7.a;
    L15:
        if (r10 == null) goto L17;
        Object r8 = r10.get("disable_compress");
    L19:
        if ((r8 instanceof Boolean) == true) goto L21;
        r8 = null;
    L21:
        String r9 = "";
        if (Intrinsics.areEqual((Boolean) r8, Boolean.TRUE) == false) goto L28;
        AndroidYaTaInstance r11 = this.e;
        if (r11 == null) goto L26;
        ea6.c r12 = ea6.b.b(r11, r26);
        int r13 = com.bytedance.kmp.ec.yata.common.platform.n.a;
        String r14 = GsonProtectorUtils.toJson(com.bytedance.kmp.ec.yata.common.platform.k.a(), r12);
    L27:
        String r15 = r14;
        String r16 = "";
    L33:
        if (r16 != null) goto L35;
        BuyNowLog.d("selfSubmit", "yataparam is null");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.h.getTracker(), "selfSubmit", "yata_param is empty", r26);
    L35:
        Object r17 = r26.p(Reflection.getOrCreateKotlinClass(Boolean.class), "is_no_pwd_combined");
        if ((r17 instanceof Boolean) == true) goto L38;
        r17 = null;
    L38:
        this.a = (Boolean) r17;
        Object r18 = r26.p(Reflection.getOrCreateKotlinClass(Map.class), "sdk_show_info");
        if ((r18 instanceof Map) == true) goto L41;
        r18 = null;
    L41:
        this.b = (Map) r18;
        Object r19 = r26.p(Reflection.getOrCreateKotlinClass(List.class), "publish_event_list");
        if ((r19 instanceof List) == true) goto L44;
        r19 = null;
    L44:
        List r20 = (List) r19;
        this.h.setCreateOrderLoadingData(this.a, this.b);
        int r21 = BuyNowOrderLoadingController.a;
        BuyNowOrderLoadingController.a(this.a, true, this.b, this.f, this.d);
        if (r20 == null) goto L47;
        Boolean r22 = Boolean.valueOf(!r20.isEmpty());
    L49:
        if (com.bytedance.android.shopping.extensions.k.i(r22) == false) goto L67;
        if (r20 == null) goto L67;
        Iterator r23 = r20.iterator();
    L53:
        if (r23.hasNext() == false) goto L67;
        Object r24 = ((Map) r23.next()).get("event_name");
        if ((r24 instanceof String) == true) goto L57;
        r24 = null;
    L57:
        String r25 = (String) r24;
        if (com.bytedance.android.shopping.extensions.k.c(r25) == false) goto L53;
        if (r25 == null) goto L53;
        if (r25.hashCode() != (-654096686)) goto L53;
        if (r25.equals("closeHalfSku") == false) goto L53;
        ECLiveHybridUtil.f("closeHalfSku", new JSONObject());
    L67:
        nl.c r28 = this.h.getStaticState().a;
        if (r28 == null) goto L70;
        String r29 = r28.getQueryParam("enter_from_live_saas");
    L71:
        boolean r30 = Intrinsics.areEqual(String.valueOf(r29), "1");
        pa3.a r31 = this.i;
        if (r31 == null) goto L76;
        com.bytedance.android.shopping.buynow.monitor.order.a r32 = r31.b;
        if (r32 == null) goto L76;
        r32.a(BuyNowOrderNode.REQUEST_START, System.currentTimeMillis());
    L76:
        pa3.a r33 = this.i;
        if (r33 == null) goto L81;
        com.bytedance.android.shopping.buynow.monitor.order.a r34 = r33.b;
        if (r34 == null) goto L81;
        r34.a(BuyNowOrderNode.ORDER_CREATE_NET_START, System.currentTimeMillis());
    L81:
        TTCJPayUtils.Companion.getInstance().externalBizReport("request_start", "ecommerce_pay_desk", System.currentTimeMillis(), "电商提单", null);
        com.bytedance.android.shopping.buynow.tracker.a r35 = this.h.getTracker();
        if (r35.h.getStaticState().b() == false) goto L84;
        String r36 = "a1.b25587.c5642.d1959";
    L85:
        r35.b("order_submit_request_sent", MapsKt.mapOf(TuplesKt.to("btm", r36)));
        this.h.getAsyncTwoStageController().b(this.h);
        AndroidYaTaInstance r37 = this.e;
        if (r37 == null) goto L88;
        ea6.c r38 = ea6.b.b(r37, r26);
    L89:
        if (r38 == null) goto L91;
        Map<String, ? extends Object> r39 = r38.a();
    L92:
        this.c = r39;
        Map r40 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r26.e).a;
        if (r40 == null) goto L95;
        Object r41 = r40.get("is_virtual_click");
    L96:
        boolean r110 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r41);
        Map r42 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r26.e).a;
        if (r42 == null) goto L99;
        Object r43 = r42.get("input_device_id");
    L101:
        if ((r43 instanceof Number) == true) goto L103;
        r43 = null;
    L103:
        Number r44 = (Number) r43;
        if (r44 == null) goto L106;
        Integer r111 = Integer.valueOf(r44.intValue());
    L107:
        Map r1 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r26.e).a;
        if (r1 == null) goto L110;
        Object r45 = r1.get("input_device_name");
    L112:
        if ((r45 instanceof String) == true) goto L114;
        r45 = null;
    L114:
        String r46 = (String) r45;
        com.bytedance.android.shopping.buynow.tracker.a r47 = this.h.getTracker();
        r47.getClass();
        r47.b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.ORDER_REQUEST_START), TuplesKt.to("desc", com.bytedance.android.shopping.buynow.viewmodel.b.a(r47.h.getStaticState()))}));
        BuyNowLog.d("selfSubmit", "create order api requested");
        na3.g r48 = na3.g.a;
        Long r49 = Long.valueOf(System.currentTimeMillis());
        String r112 = EcomBcmTracker.i().getBcmChainWithStandardContent(PageFinder.via(this.g));
        if (r112 == null) goto L118;
        r9 = r112;
    L118:
        String r113 = String.valueOf(r110);
        if (BuyNowPerformanceOpt.h() == true) goto L121;
        r46 = r46;
        r2 = "selfSubmit";
        r110 = r110;
        String r50 = null;
        String r51 = null;
    L130:
        ma3.j r52 = new ma3.j(r16, r15, r49, new ma3.i(r9, r113, r51), r10);
        int r53 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r54 = com.bytedance.android.shopping.buynow.utils.e.b(r30);
        String r55 = this.h.getStaticState().g;
        Integer r210 = Integer.valueOf(ja3.a.a(this.h.getStaticState().a));
        Intrinsics.checkNotNullParameter(r52, "params");
        if (Intrinsics.areEqual(r55, PageType.ULTIMATEBUYNOW) == false) goto L138;
        UltimateBuyNowApi.a.getClass();
        UltimateBuyNowApi r114 = UltimateBuyNowApi.a.b;
        int r56 = ECSdk.a;
        IAdapterService r57 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r57 == null) goto L135;
        String r211 = r57.getWebcastAppId();
    L136:
        Observable<SsResponse<ma3.k>> r58 = r114.createOrderForUltimateBuy(r52, r53, r54, r210, r211);
    L145:
        r58.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this, r110, r111, r46));
        BuyNowLog.d(r2, "selfSubmit finishes");
        AndroidYaTaInstance r59 = this.e;
        if (r59 == null) goto L148;
        Object r60 = r59.i("extra_map");
    L150:
        if ((r60 instanceof Map) == true) goto L152;
        r60 = r50;
    L152:
        Map r61 = (Map) r60;
        if (r61 == null) goto L155;
        Object r62 = r61.get("selected_pay_type");
    L157:
        if (Intrinsics.areEqual(r62, "8") == false) goto L159;
        int r63 = com.bytedance.android.shopping.utils.p.a;
    L159:
        Map r64 = BuyNowPerformanceOpt.g();
        if (r64 == null) goto L162;
        Object r65 = r64.get("buynow_enable_close_sku_opt");
    L164:
        if (Intrinsics.areEqual(r65, 1) == false) goto L178;
        ECLiveHybridUtil.f("closeHalfSku", new JSONObject());
        return;
    L178:
        return;
    L162:
        r65 = r50;
        goto L164
    L155:
        r62 = r50;
        goto L157
    L148:
        r60 = r50;
        goto L150
    L135:
        r211 = r50;
        goto L136
    L138:
        if (Intrinsics.areEqual(r55, PageType.CONTINUEPAY) == false) goto L140;
        ContinuePayApi.a.getClass();
        r58 = ContinuePayApi.a.a.createContinuePay(r52, r53, r54);
        goto L145
    L140:
        BuyNowApi.a.getClass();
        BuyNowApi r115 = BuyNowApi.a.b;
        int r66 = ECSdk.a;
        IAdapterService r67 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r67 == null) goto L143;
        String r212 = r67.getWebcastAppId();
    L144:
        r58 = r115.createOrder(r52, r53, r54, r210, r212);
        goto L145
    L143:
        r212 = r50;
        goto L144
    L121:
        if (this.h.getStaticState().l != null) goto L127;
        com.bytedance.android.shopping.buynow.viewmodel.a r116 = this.h.getStaticState();
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r117 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        Pair[] r68 = new Pair[2];
        r68[0] = TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW);
        nl.c r69 = this.h.getStaticState().a;
        if (r69 == null) goto L125;
        String r70 = r69.getQueryParam("eztf_sdk_extra");
    L126:
        r68[1] = TuplesKt.to("eztf_source_page", com.bytedance.android.shopping.extensions.k.j(r70));
        MapsKt.mapOf(r68);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.c();
        r50 = null;
        r116.l = com.bytedance.android.shopping.extensions.k.x(MapsKt.mapOf(TuplesKt.to("finance_risk", null)));
    L128:
        r51 = this.h.getStaticState().l;
        goto L130
    L125:
        r70 = null;
        goto L126
    L127:
        r110 = r110;
        r50 = null;
        goto L128
    L110:
        r45 = null;
        goto L112
    L106:
        r111 = null;
        goto L107
    L99:
        r43 = null;
        goto L101
    L95:
        r41 = null;
        goto L96
    L91:
        r39 = null;
        goto L92
    L88:
        r38 = null;
        goto L89
    L84:
        r36 = "c5642.d1959";
        goto L85
    L70:
        r29 = null;
        goto L71
    L47:
        r22 = null;
        goto L49
    L26:
        r14 = null;
        goto L27
    L28:
        AndroidYaTaInstance r71 = this.e;
        if (r71 == null) goto L31;
        String r72 = ea6.b.a(ea6.b.b(r71, r26), r71, r26, null);
    L32:
        r16 = r72;
        r15 = null;
        goto L33
    L31:
        r72 = null;
        goto L32
    L17:
        r8 = null;
    L14:
        r10 = null;
        goto L15
    }

    public z(Context r2, AndroidYaTaInstance r3, ia3.b r4, BuyNowFragment r5, BuyNowViewModel r6, pa3.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "buyNowViewModel");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.a = Boolean.FALSE;
    }
}
