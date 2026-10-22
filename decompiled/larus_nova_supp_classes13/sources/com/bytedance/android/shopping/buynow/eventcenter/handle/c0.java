package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.controller.BuyNowOrderLoadingController;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Completable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 implements Observer<SsResponse<ma3.k>> {
    public final /* synthetic */ z a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ String d;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        BuyNowLog.d("selfSubmit", "create order api failed, triggering onError");
        z r1 = this.a;
        r1.getClass();
        int r2 = BuyNowOrderLoadingController.a;
        BuyNowOrderLoadingController.a(r1.a, false, r1.b, r1.f, r1.d);
        com.bytedance.android.shopping.buynow.utils.m.a(2131894576);
        com.bytedance.android.shopping.buynow.tracker.a r3 = r1.h.getTracker();
        String r4 = r9.getMessage();
        Pair[] r5 = new Pair[2];
        if (r3.h.getStaticState().b() == false) goto L5;
        String r6 = "a1.b25587.c5642.d1959";
    L6:
        r5[0] = TuplesKt.to("btm", r6);
        r5[1] = TuplesKt.to("fail_reason", r4);
        r3.b("order_submit_request_fail", MapsKt.mapOf(r5));
        r1.h.setSubmitStatusFlag(true);
        Integer r7 = com.bytedance.android.shopping.utils.s.a(r9);
        com.bytedance.android.shopping.buynow.tracker.a r8 = r1.h.getTracker();
        if (r7 == null) goto L9;
        String r10 = "HTTP Error(" + r7.intValue() + ')';
    L10:
        r8.h(r7, r10);
        com.bytedance.android.shopping.buynow.monitor.error.a.d(r1.h.getTracker(), "selfSubmit", r9);
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r6 = "c5642.d1959";
        goto L6
    }

    public final void onNext(Object r23) {
        SsResponse r2 = (SsResponse) r23;
        Intrinsics.checkNotNullParameter(r2, "res");
        BuyNowLog.d("selfSubmit", "create order api response received");
        boolean r6 = false;
        this.a.h.updateTrackerCommonParams(((ma3.k) r2.body()).e(), false);
        com.bytedance.android.shopping.buynow.tracker.a r3 = this.a.h.getTracker();
        Map<String, ? extends Object> r7 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_virtual_click", Boolean.valueOf(this.b)), TuplesKt.to("input_device_id", this.c), TuplesKt.to("input_device_name", this.d)});
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "paramsMap");
        r3.d.appendEventParams(r7);
        z r4 = this.a;
        r4.getClass();
        Integer r8 = ((ma3.k) r2.body()).c();
        String r9 = ((ma3.k) r2.body()).d();
        ma3.n r11 = ((ma3.k) r2.body()).a();
        pa3.a r12 = r4.i;
        if (r12 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.order.a r13 = r12.b;
        if (r13 == null) goto L7;
        r13.a(BuyNowOrderNode.REQUEST_END, System.currentTimeMillis());
    L7:
        pa3.a r14 = r4.i;
        if (r14 == null) goto L12;
        com.bytedance.android.shopping.buynow.monitor.order.a r15 = r14.b;
        if (r15 == null) goto L12;
        r15.a(BuyNowOrderNode.ORDER_CREATE_NET_END, System.currentTimeMillis());
    L12:
        pa3.a r16 = r4.i;
        if (r16 == null) goto L17;
        com.bytedance.android.shopping.buynow.monitor.order.a r17 = r16.b;
        if (r17 == null) goto L17;
        r17.a(BuyNowOrderNode.STANDARD_RENDER_START, System.currentTimeMillis());
    L17:
        pa3.a r18 = r4.i;
        if (r18 == null) goto L22;
        com.bytedance.android.shopping.buynow.monitor.order.a r19 = r18.b;
        if (r19 == null) goto L22;
        r19.a(BuyNowOrderNode.ORDER_CREATE_END, System.currentTimeMillis());
    L22:
        TTCJPayUtils.Companion.getInstance().externalBizReport("request_end", "ecommerce_pay_desk", System.currentTimeMillis(), "电商提单", null);
        String r110 = "a1.b25587.c5642.d1959";
        if (r8 != null) goto L26;
    L27:
        com.bytedance.android.shopping.buynow.tracker.a r111 = r4.h.getTracker();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r2, "res");
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("error_code", Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(r8)));
        r0[1] = TuplesKt.to("fail_reason", r9);
        if (r111.h.getStaticState().b() == false) goto L30;
        Object r5 = "a1.b25587.c5642.d1959";
    L31:
        r0[2] = TuplesKt.to("btm", r5);
        Map<String, ? extends Object> r10 = MapsKt.mutableMapOf(r0);
        if (r8 != null) goto L35;
    L40:
        Unit r1 = Unit.INSTANCE;
        r111.b("create_order_request_fail", r10);
        JSONObject r20 = new JSONObject();
        r20.put("message", "createOnlineOrderFail");
        r20.put("error_type", 0);
        r20.put("type", "ORDER_SUBMIT_ERROR");
        r111.b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(TuplesKt.to("detail", r20)));
        r4.h.getTracker().h(r8, r9);
        if (r8 != null) goto L44;
    L54:
        r4.h.setSubmitStatusFlag(true);
    L55:
        com.bytedance.kmp.ec.yata.common.protocol.data.c r21 = ((ma3.k) r2.body()).e();
        if (r21 == null) goto L60;
        Map r22 = r21.g();
        if (r22 == null) goto L60;
        Object r24 = r22.get("create_order_result");
    L62:
        if ((r24 instanceof Map) == true) goto L64;
        r24 = null;
    L64:
        Map r25 = (Map) r24;
        if (r8 != null) goto L68;
    L69:
        if (r25 == null) goto L71;
        Object r26 = r25.get("OrderGroupIdList");
    L73:
        if ((r26 instanceof List) == true) goto L75;
        r26 = null;
    L75:
        List r27 = (List) r26;
        if (r27 == null) goto L78;
        Integer r28 = Integer.valueOf(r27.size());
    L80:
        if (com.bytedance.android.shopping.extensions.k.f(r28) <= 0) goto L87;
    L81:
        com.bytedance.android.shopping.buynow.tracker.a r29 = r4.h.getTracker();
        if (r29.h.getStaticState().b() == true) goto L85;
        r110 = "c5642.d1959";
    L85:
        r29.b("order_submit_success_yata", MapsKt.mapOf(TuplesKt.to("btm", r110)));
        com.bytedance.android.shopping.buynow.tracker.a r30 = r4.h.getTracker();
        r30.getClass();
        r30.b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.ORDER_REQUEST_SUCCESS), TuplesKt.to("desc", com.bytedance.android.shopping.buynow.viewmodel.b.a(r30.h.getStaticState()))}));
    L87:
        if (((ma3.k) r2.body()).e() == null) goto L106;
        String r31 = ma3.l.a(r2);
        if (r31 != null) goto L91;
    L92:
        r6 = true;
    L93:
        if (r6 == true) goto L99;
        this.a.h.getSkuService().s(r31);
        SlcRenderContext r32 = this.a.g.r;
        if (r32 == null) goto L99;
        if (r31 != null) goto L98;
        r31 = "";
    L98:
        r32.h = MapsKt.mapOf(TuplesKt.to("log_id", r31));
    L99:
        BuyNowLog.d("selfSubmit", "create order api success");
        int r33 = ra3.b.a;
        ra3.b.a("/order/yata/confirmOrderRender", r2, System.currentTimeMillis());
        com.bytedance.kmp.ec.yata.common.protocol.data.c r34 = ((ma3.k) r2.body()).e();
        if (r34 == null) goto L102;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r112 = com.bytedance.kmp.ec.yata.common.protocol.data.c.a(r34, null, this.a.c, 503);
    L103:
        AndroidYaTaInstance r35 = this.a.e;
        if (r35 == null) goto L121;
        r35.x(r112, aa6.a.b.b.b, new com.bytedance.kmp.ec.yata.common.perf.d("biz_create_order"), ma3.l.a(r2));
        return;
    L121:
        return;
    L102:
        r112 = null;
        goto L103
    L91:
        if (StringsKt.isBlank(r31) == false) goto L93;
    L106:
        BuyNowLog.d("selfSubmit", "create order api response received with no yataData");
        z r36 = this.a;
        ma3.k r37 = (ma3.k) r2.body();
        r36.getClass();
        int r38 = com.bytedance.android.shopping.buynow.utils.m.a;
        String r39 = r37.d();
        if (r39 != null) goto L109;
        r39 = "网络存在异常，请稍后重试";
    L109:
        com.bytedance.android.shopping.buynow.utils.m.b(r39);
        int r40 = BuyNowOrderLoadingController.a;
        BuyNowOrderLoadingController.a(r36.a, false, r36.b, r36.f, r36.d);
        if (r37.c() != null) goto L112;
        String r41 = null;
    L113:
        com.bytedance.android.shopping.buynow.tracker.a r42 = r36.h.getTracker();
        LogPbData r43 = r37.b();
        if (r43 == null) goto L116;
        String r113 = r43.getImprId();
    L117:
        com.bytedance.android.shopping.buynow.monitor.error.a.c(r42, "no yata_data", r41, com.bytedance.android.shopping.extensions.k.j(r113), "/order/yata/createOrder");
        return;
    L116:
        r113 = null;
        goto L117
    L112:
        r41 = String.valueOf(r37.c().intValue());
        goto L113
    L78:
        r28 = null;
        goto L80
    L71:
        r26 = null;
        goto L73
    L68:
        if (r8.intValue() == 0) goto L81;
    L60:
        r24 = null;
        goto L62
    L44:
        if (r8.intValue() != 201001075) goto L54;
        if (r11 == null) goto L47;
        Long r44 = r11.a();
    L49:
        if (com.bytedance.android.shopping.extensions.k.h(r44) <= 0) goto L54;
        if (r11 == null) goto L52;
        Long r45 = r11.a();
    L53:
        com.bytedance.android.ec.core.async.a.a(Completable.timer(com.bytedance.android.shopping.extensions.k.h(r45), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new a0(r4), new b0(r4)), r4.g);
        goto L55
    L52:
        r45 = null;
        goto L53
    L47:
        r44 = null;
        goto L49
    L35:
        if (r8.intValue() != (-1)) goto L40;
        r10.putAll(com.bytedance.android.shopping.buynow.tracker.a.e(r2));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L40
    L30:
        r5 = "c5642.d1959";
        goto L31
    L26:
        if (r8.intValue() == 0) goto L55;
        goto L27
    }

    public c0(z r1, boolean r2, Integer r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
