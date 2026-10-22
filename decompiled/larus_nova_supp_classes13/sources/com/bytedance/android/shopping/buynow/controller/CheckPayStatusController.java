package com.bytedance.android.shopping.buynow.controller;

import android.content.Context;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ObservableRetryWhenCompat;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.data.model.BuyNowShape;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.data.model.GoodsType;
import com.bytedance.android.shopping.buynow.data.model.PayShowType;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CheckPayStatusController {
    public static final /* synthetic */ int j = 0;
    public ma3.o a;
    public Map<String, ? extends Object> b;
    public boolean c;
    public int d;
    public final Context e;
    public final BuyNowFragment f;
    public final ia3.b g;
    public final com.bytedance.android.ec.core.async.b h;
    public final pa3.a i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/CheckPayStatusController$QueryPayStatusException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "logId", "", "(Ljava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class QueryPayStatusException extends RuntimeException {
        private final String logId;

        public final String getLogId() {
            return this.logId;
        }

        public QueryPayStatusException(String r1) {
            this.logId = r1;
        }
    }

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ CheckPayStatusController a;
        public final /* synthetic */ String b;

        public b(CheckPayStatusController r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            CheckPayStatusController r0 = this.a;
            f.b(r0.e, this.b, r0.f);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CheckPayStatusController a;

        public c(CheckPayStatusController r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            com.bytedance.android.shopping.buynow.monitor.error.a.b(this.a.f.W90().getTracker(), "runtime_error", "error closing buy_now page");
        }
    }

    static {
    }

    public final void d() {
        ECLiveHybridUtil.f("orderSubmitCompleted", new JSONObject());
        ma3.o r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.e();
    L7:
        if (r2 != null) goto L10;
    L15:
        BtmSDK r3 = BtmSDK.INSTANCE;
        if (this.f.W90().getStaticState().b() == false) goto L18;
        String r4 = "a1.b25587.c5642.d1959";
    L19:
        r3.willJumpToNextPage(new BtmItemBuilder(r4, null, 2, null).withPageFinder(this.f.W90().getStaticState().d).setTargetPagesBtm(CollectionsKt.listOf(new String[]{"a1.b2298.c0.d0", "a1.b4943.c0.d0", "a1.b31.c0.d0", "a1.b32.c0.d0", "a1.b6871.c0.d0"})).build());
        ma3.o r5 = this.a;
        if (r5 == null) goto L22;
        String r6 = r5.b();
    L23:
        com.bytedance.android.ec.core.hybrid.utils.r.a(r6, this.f.requireActivity());
        com.bytedance.android.shopping.buynow.tracker.a r7 = this.f.W90().getTracker();
        ma3.o r8 = this.a;
        if (r8 == null) goto L26;
        r1 = r8.b();
    L26:
        r7.getClass();
        r7.b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.GOTO_PAGE), TuplesKt.to("target_schema", r1)}));
        return;
    L22:
        r6 = null;
        goto L23
    L18:
        r4 = "a1.b7411.c5642.d1959";
        goto L19
    L10:
        if (r2.hashCode() != (-1594640105)) goto L15;
        if (r2.equals(BuyNowUrlType.XTAB_MALL_HOMEPAGE) == false) goto L15;
        JSONObject r9 = new JSONObject();
        r9.put("feedTabPause", true);
        r9.put("shouldPauseWithoutAnimation", true);
        Unit r10 = Unit.INSTANCE;
        ECLiveHybridUtil.f("closeInnerHalfPanel", r9);
        JSONObject r11 = new JSONObject();
        r11.put("feedTabPause", true);
        r11.put("unPlay", true);
        ECLiveHybridUtil.f("closePDPHalfPanel", r11);
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public final boolean e() {
        nl.c r0 = this.f.W90().getStaticState().a;
        if (r0 == null) goto L5;
        String r1 = r0.getQueryParam(SimilarProductParam.ENTER_FROM);
    L7:
        return Intrinsics.areEqual(r1, "confirm_order");
    L5:
        r1 = null;
        goto L7
    }

    public final void c(String r5) {
        com.bytedance.android.ec.core.async.a.a(Completable.timer(400, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(this, r5), new c(this)), this.h);
    }

    public static final void a(final CheckPayStatusController r24, boolean r25, int r26) {
        ma3.o r3 = r24.a;
        Object r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.e();
    L7:
        if (Intrinsics.areEqual(r5, "continue_pay_panel") == false) goto L9;
        r24.d();
        return;
    L9:
        int r6 = com.bytedance.android.shopping.buynow.utils.d.a;
        Object r7 = com.bytedance.android.shopping.buynow.utils.d.a(r24.f.W90().getStaticState().a, "create_order_type");
        Object r8 = com.bytedance.android.shopping.buynow.utils.d.a(r24.f.W90().getStaticState().a, "enable_close_event");
        boolean r9 = true;
        if (Intrinsics.areEqual(r7, PayShowType.ONLY_METHOD.getType()) == true) goto L12;
    L14:
        boolean r10 = false;
    L15:
        pa3.a r11 = r24.i;
        if (r11 == null) goto L20;
        com.bytedance.android.shopping.buynow.monitor.order.a r12 = r11.b;
        if (r12 == null) goto L20;
        Map<String, Object> r13 = r24.f.W90().getTracker().d.c();
        BuyNowFragment r14 = r24.f;
        Intrinsics.checkNotNullParameter(r13, "commonEventParams");
        Intrinsics.checkNotNullParameter(r14, "fragment");
        r12.e.putAll(r13);
        BtmSDK r15 = BtmSDK.INSTANCE;
        int r16 = com.bytedance.android.shopping.buynow.utils.c.a;
        r12.e.putAll(r15.createReportParams(com.bytedance.android.shopping.buynow.utils.c.a(r14.W90().getStaticState().g), PageFinder.via(r14)));
    L20:
        pa3.a r17 = r24.i;
        if (r17 == null) goto L25;
        com.bytedance.android.shopping.buynow.monitor.order.a r18 = r17.b;
        if (r18 == null) goto L25;
        r18.c("result", Integer.valueOf(r25 ? 1 : 0));
    L25:
        pa3.a r19 = r24.i;
        if (r19 == null) goto L30;
        com.bytedance.android.shopping.buynow.monitor.order.a r20 = r19.b;
        if (r20 == null) goto L30;
        r20.a(BuyNowOrderNode.STANDARD_RENDER_END, System.currentTimeMillis());
    L30:
        pa3.a r21 = r24.i;
        if (r21 == null) goto L35;
        com.bytedance.android.shopping.buynow.monitor.order.a r22 = r21.b;
        if (r22 == null) goto L35;
        r22.a(BuyNowOrderNode.ORDER_CHECK_END, System.currentTimeMillis());
    L35:
        pa3.a r23 = r24.i;
        if (r23 == null) goto L40;
        com.bytedance.android.shopping.buynow.monitor.order.a r27 = r23.b;
        if (r27 == null) goto L40;
        r27.a(BuyNowOrderNode.END, System.currentTimeMillis());
    L40:
        TTCJPayUtils.Companion r28 = TTCJPayUtils.Companion;
        r28.getInstance().externalBizReport("request_end", "ecommerce_pay_desk", System.currentTimeMillis(), "电商查单", null);
        r28.getInstance().externalBizReport("pay_end", "ecommerce_pay_desk", System.currentTimeMillis(), "", null);
        String r110 = "";
        String r111 = "pay_success";
        if (r24.f.W90().getStaticState().b() == false) goto L162;
        if (r24.e() == false) goto L54;
        r24.d();
        if (r25 == false) goto L47;
        String r29 = "pay_success";
    L48:
        r24.c(r29);
        JSONObject r30 = new JSONObject();
        nl.c r112 = r24.f.W90().getStaticState().a;
        if (r112 == null) goto L51;
        String r113 = r112.getQueryParam("pre_session_id");
    L52:
        KtSafeMethodExtensionKt.safePut(r30, "pre_session_id", r113);
        Unit r114 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.continue.check.jump", r30);
        goto L54
    L51:
        r113 = null;
        goto L52
    L47:
        r29 = BuyNowCloseMethod.PAY_FAIL;
    L54:
        if (r25 == false) goto L75;
        nl.c r2 = r24.f.W90().getStaticState().a;
        if (r2 == null) goto L58;
        String r31 = r2.getQueryParam("enable_close_event");
    L59:
        boolean r32 = Intrinsics.areEqual(r31, "1");
        nl.c r115 = r24.f.W90().getStaticState().a;
        if (r115 == null) goto L62;
        String r116 = r115.getQueryParam("is_from_yata");
    L64:
        if (Intrinsics.areEqual(r116, "1") == false) goto L71;
        JSONObject r33 = new JSONObject();
        r33.put("type", "yata_event");
        r33.put("name", "continue_to_pay_popup");
        r33.put("event_name", "continuePaySuccess");
        nl.c r34 = r24.f.W90().getStaticState().a;
        if (r34 == null) goto L69;
        String r35 = r34.getQueryParam("yata_session_id");
        if (r35 == null) goto L69;
    L70:
        r33.put("yata_session_id", r35);
    L72:
        ECLiveHybridUtil.f("continue_pay_success", r33);
        if (r32 == false) goto L162;
        r24.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L69:
        r35 = "";
        goto L70
    L71:
        r33 = new JSONObject();
        r33.put("data", r32);
        goto L72
    L62:
        r116 = null;
        goto L64
    L58:
        r31 = null;
        goto L59
    L75:
        r24.d = 0;
        String r36 = r24.f.W90().getFailMsg();
        r24.f.W90().getTracker().i(r25);
        JSONObject r1 = new JSONObject();
        TuplesKt.to("data", r36);
        Unit r37 = Unit.INSTANCE;
        ECLiveHybridUtil.f("continue_pay_fail", r1);
        if (r26 != 116) goto L78;
        boolean r38 = true;
    L79:
        nl.c r39 = r24.f.W90().getStaticState().a;
        if (r39 == null) goto L84;
        String r40 = r39.getQueryParam("goods_type");
        if (r40 == null) goto L84;
        Integer r41 = StringsKt.toIntOrNull(r40);
    L85:
        int r42 = GoodsType.TAILGOOD.getType();
        if (r41 != null) goto L89;
    L91:
        boolean r43 = false;
    L92:
        if (r38 == false) goto L94;
        r24.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L94:
        if (r43 == false) goto L96;
        r24.d();
        return;
    L96:
        if (r24.f.W90().getNeedToast() == false) goto L102;
        if (r26 == 118) goto L102;
        int r44 = com.bytedance.android.shopping.buynow.utils.m.a;
        if (r36 != null) goto L101;
        r36 = com.bytedance.android.shopping.extensions.j.c(2131894590);
    L101:
        com.bytedance.android.shopping.buynow.utils.m.b(r36);
    L102:
        if (r26 != 118) goto L104;
        r24.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L104:
        AndroidYaTaInstance r45 = r24.f.W90().getYataInstance();
        if (r45 == null) goto L107;
        Object r46 = r45.i("submit_bar");
    L109:
        if ((r46 instanceof Map) == true) goto L111;
        r46 = null;
    L111:
        Map r47 = (Map) r46;
        if (r47 == null) goto L114;
        Object r48 = r47.get("target_component_name");
    L116:
        if ((r48 instanceof String) == true) goto L118;
        r48 = null;
    L118:
        String r49 = (String) r48;
        if (r47 == null) goto L121;
        Object r50 = r47.get("target_yata_key");
    L123:
        if ((r50 instanceof String) == true) goto L125;
        r50 = null;
    L125:
        String r51 = (String) r50;
        if (r47 == null) goto L128;
        Object r52 = r47.get("refresh_events");
    L130:
        if ((r52 instanceof String) == false) goto L133;
        r4 = r52;
    L133:
        String r117 = (String) r4;
        r24.f.W90().setSubmitStatusFlag(true);
        if (r47 != null) goto L136;
    L139:
        boolean r53 = true;
    L140:
        if (r53 == true) goto L242;
        if (r49 != null) goto L143;
    L146:
        boolean r54 = true;
    L147:
        if (r54 == true) goto L243;
        if (r51 != null) goto L150;
    L153:
        if (r9 == true) goto L244;
        com.bytedance.kmp.ec.yata.store.node.c r55 = com.bytedance.android.shopping.buynow.utils.h.a(r24.f.W90().getYataInstance(), r49, r51);
        if (r55 != null) goto L157;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r24.f.W90().getTracker(), "yata_error", "submitBar t is null");
        return;
    L157:
        AndroidYaTaInstance r118 = r24.f.W90().getYataInstance();
        if (r118 == null) goto L246;
        r118.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r118, null, r55.getKey(), r117, null, "handlePayResult"));
        return;
    L246:
        return;
    L244:
        return;
    L150:
        if (r51.length() == 0) goto L153;
        r9 = false;
        goto L153
    L243:
        return;
    L143:
        if (r49.length() == 0) goto L146;
        r54 = false;
        goto L147
    L242:
        return;
    L136:
        if (r47.isEmpty() == true) goto L139;
        r53 = false;
        goto L140
    L128:
        r52 = null;
        goto L130
    L121:
        r50 = null;
        goto L123
    L114:
        r48 = null;
        goto L116
    L107:
        r46 = null;
        goto L109
    L89:
        if (r41.intValue() != r42) goto L91;
        r43 = true;
    L84:
        r41 = null;
        goto L85
    L78:
        r38 = false;
    L162:
        if (r10 == false) goto L171;
        if (r25 == false) goto L165;
        com.bytedance.android.shopping.buynow.utils.m.a(2131894594);
    L165:
        JSONObject r56 = new JSONObject();
        if (r25 == false) goto L168;
        String r57 = "success";
    L169:
        TuplesKt.to("status", r57);
        Unit r58 = Unit.INSTANCE;
        ECLiveHybridUtil.f("submit_orders_pay_result", r56);
    L232:
        r24.f.W90().getTracker().i(r25);
        if (r25 == true) goto L236;
        r111 = BuyNowCloseMethod.PAY_FAIL;
    L236:
        r24.c(r111);
        return;
    L168:
        r57 = "failure";
        goto L169
    L171:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(com.bytedance.android.shopping.buynow.utils.d.a(r24.f.W90().getStaticState().a, "shape")), 0) != BuyNowShape.REFUEL.getShape()) goto L173;
        boolean r59 = true;
    L175:
        if (Intrinsics.areEqual(String.valueOf(r7), PayShowType.AUCTION.getType()) == true) goto L180;
        if (r25 == true) goto L179;
        if (r59 == true) goto L180;
    L179:
        boolean r60 = false;
    L181:
        if (r25 == false) goto L230;
        if (r60 == false) goto L184;
        com.bytedance.android.shopping.buynow.utils.m.a(2131894594);
        goto L232
    L184:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(com.bytedance.android.shopping.buynow.utils.d.a(r24.f.W90().getStaticState().a, "shape")), 0) != BuyNowShape.ZERO_BUY.getShape()) goto L186;
        boolean r61 = true;
    L187:
        if (r61 == false) goto L189;
        com.bytedance.android.shopping.buynow.utils.m.a(2131894601);
    L189:
        Map<String, ? extends Object> r62 = r24.b;
        if (r62 == null) goto L192;
        Object r63 = r62.get("pay_params");
    L194:
        if ((r63 instanceof Map) == true) goto L196;
        r63 = null;
    L196:
        Map r64 = (Map) r63;
        if (r64 == null) goto L199;
        Object r65 = r64.get("sdk_info");
    L201:
        if ((r65 instanceof Map) == true) goto L203;
        r65 = null;
    L203:
        Map r66 = (Map) r65;
        if (r66 == null) goto L206;
        Object r67 = r66.get("guide_info");
    L208:
        if ((r67 instanceof Map) == true) goto L210;
        r67 = null;
    L210:
        Map r68 = (Map) r67;
        if (r68 == null) goto L213;
        Object r69 = r68.get("guide_url");
    L215:
        if ((r69 instanceof String) == false) goto L218;
        r4 = r69;
    L218:
        String r70 = (String) r4;
        if (r70 == null) goto L223;
        r110 = r70;
    L223:
        if (r110.length() == 0) goto L226;
        r9 = false;
    L226:
        if (r9 == false) goto L228;
        r24.d();
        goto L232
    L228:
        int r71 = TTPay.a;
        Context r72 = r24.f.requireContext();
        JSONObject r73 = new JSONObject();
        r73.put("sdk_info", new JSONObject().put("schema", r110));
        r73.put("service", 98);
        Unit r74 = Unit.INSTANCE;
        TTPay.a(r72, r73, new CheckPayStatusController$invokeGuidePage$2(r24));
        goto L232
    L213:
        r69 = null;
        goto L215
    L206:
        r67 = null;
        goto L208
    L199:
        r65 = null;
        goto L201
    L192:
        r63 = null;
        goto L194
    L186:
        r61 = false;
        goto L187
    L230:
        if (r60 == true) goto L232;
        r24.d();
    L180:
        r60 = true;
        goto L181
    L173:
        r59 = false;
        goto L175
    L12:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(r8), 0) != 1) goto L14;
        r10 = true;
        goto L15
    L5:
        r5 = null;
        goto L7
    }

    public final void f(int r4, ma3.o r5, boolean r6) {
        this.a = r5;
        if (r4 != 116) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r5 == null) goto L16;
        if (r7 == true) goto L11;
    L14:
        String r8 = r5.b();
    L15:
        r5.f(r8);
        goto L16
    L11:
        if (e() == true) goto L14;
        if (r6 == true) goto L14;
        r8 = r5.b() + "&show_pay_form=1";
    L16:
        String r9 = null;
        if (r5 != null) goto L19;
    L27:
        ma3.o r10 = this.a;
        if (r10 == null) goto L30;
        String r11 = r10.e();
    L32:
        if (Intrinsics.areEqual(r11, "continue_pay_panel") == false) goto L40;
        ma3.o r12 = this.a;
        if (r12 == null) goto L41;
        String r13 = r12.b();
        if (r13 == null) goto L38;
        r9 = l0.a(r13, "pre_session_id", this.f.W90().getContinuePayPreSessionId());
    L38:
        r12.f(r9);
        return;
    L41:
        return;
    L40:
        return;
    L30:
        r11 = null;
        goto L32
    L19:
        if (r5.d() == null) goto L27;
        BtmSDK r14 = BtmSDK.INSTANCE;
        String r0 = r5.d();
        PageFinder r1 = PageFinder.via(this.f);
        BcmParams.a r2 = BcmParams.Companion;
        String r15 = r5.c();
        r2.getClass();
        String r16 = r14.createJumpSourceBtmToken(r0, r1, BcmParams.a.a(r15));
        ma3.o r17 = this.a;
        if (r17 == null) goto L27;
        String r3 = r17.b();
        if (r3 == null) goto L25;
        String r18 = l0.a(r3, "source_btm_token", r16);
    L26:
        r17.f(r18);
        goto L27
    L25:
        r18 = null;
        goto L26
    L5:
        if (r4 == 118) goto L7;
        r7 = true;
        goto L8
    }

    public final void b(com.bytedance.android.shopping.buynow.eventcenter.handle.b r10, int r11, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r10, "checkPayStatusParamsWrapper");
        Intrinsics.checkNotNullParameter(r12, "checkStatus");
        boolean r0 = true;
        this.f.W90().setHasCheck(true);
        this.b = r13;
        this.f.W90().updateCheckStatus(CheckStatus.CHECKING);
        boolean r14 = false;
        if (Intrinsics.areEqual(this.f.W90().isNoPwdCombined(), Boolean.TRUE) == false) goto L5;
        BuyNowLog.d("selfPayAndCheck", "isNoPwdCombined is true, toggleLoading flag == false");
        int r15 = BuyNowOrderLoadingController.a;
        BuyNowOrderLoadingController.a(this.f.W90().isNoPwdCombined(), false, this.f.W90().getSdkInfo(), this.g, this.e);
    L5:
        ia3.b r16 = this.g;
        if (r16 == null) goto L8;
        r16.b(new ia3.c(false, false));
    L8:
        pa3.a r17 = this.i;
        if (r17 == null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.order.a r18 = r17.b;
        if (r18 == null) goto L13;
        r18.a(BuyNowOrderNode.ORDER_CHECK_START, System.currentTimeMillis());
    L13:
        TTCJPayUtils.Companion.getInstance().externalBizReport("request_start", "ecommerce_pay_desk", System.currentTimeMillis(), "电商查单", null);
        Map<?, ?> r19 = r10.a;
        Long r2 = null;
        if (r19 == null) goto L16;
        Object r110 = r19.get("api_path");
    L18:
        if ((r110 instanceof String) == true) goto L20;
        r110 = null;
    L20:
        String r111 = (String) r110;
        Map<?, ?> r3 = r10.a;
        if (r3 == null) goto L23;
        Object r4 = r3.get("params");
    L25:
        if ((r4 instanceof Map) == true) goto L27;
        r4 = null;
    L27:
        Map r5 = (Map) r4;
        if (r5 == null) goto L30;
        Map r6 = MapsKt.toMutableMap(r5);
    L31:
        int r7 = r10.b;
        if (r11 != 0) goto L37;
        List<Integer> r8 = r10.c;
        if (r8 == null) goto L36;
        r7 = r8.size();
    L36:
        int r9 = r7 - 1;
    L38:
        if (r111 == null) goto L67;
        if (r6 == null) goto L67;
        if (r11 != 118) goto L44;
        int r20 = 1;
    L45:
        r6.put("ttpay_result", Integer.valueOf(r20));
        List<Integer> r21 = r10.c;
        if (r21 != null) goto L48;
    L56:
        List<Integer> r112 = CollectionsKt.emptyList();
    L57:
        TimeUnit r22 = TimeUnit.MILLISECONDS;
        ha3.b r1 = new ha3.b(r9, r112, r22);
        nl.c r113 = this.f.W90().getStaticState().a;
        if (r113 == null) goto L60;
        String r114 = r113.getQueryParam("enter_from_live_saas");
    L61:
        boolean r115 = Intrinsics.areEqual(String.valueOf(r114), "1");
        BuyNowLog.d("selfPayAndCheck", "check pay status api request starts");
        List<Integer> r116 = r10.c;
        if (r116 == null) goto L66;
        Integer r117 = (Integer) CollectionsKt.first(r116);
        if (r117 == null) goto L66;
        r2 = Long.valueOf(r117.intValue());
    L66:
        Completable r118 = Completable.timer(com.bytedance.android.shopping.extensions.k.h(r2), r22);
        na3.g r23 = na3.g.a;
        Observable r119 = bg4.b.b(r118.andThen(na3.g.a(r111, r6, com.bytedance.android.shopping.buynow.utils.e.a(), com.bytedance.android.shopping.buynow.utils.e.b(r115)))).doOnNext(new g(this, r11, r111));
        Intrinsics.checkNotNullParameter(r119, "$this$retryWhenCompat");
        Intrinsics.checkNotNullParameter(r1, "handler");
        ObjectHelper.requireNonNull(r1, "handler is null");
        com.bytedance.android.ec.core.async.a.a(RxJavaPlugins.onAssembly(new ObservableRetryWhenCompat(r119, r1)).doOnError(new h(this, r11)).subscribe(i.a, j.a), this.h);
        return;
    L60:
        r114 = null;
        goto L61
    L48:
        if (r21.size() <= 1) goto L50;
        r14 = true;
    L50:
        if (r14 == true) goto L53;
        r21 = null;
    L53:
        if (r21 == null) goto L56;
        r112 = r21.subList(1, r21.size());
        if (r112 != null) goto L57;
    L44:
        r20 = 0;
    L67:
        BuyNowLog.d("selfPayAndCheck", "api_path or params are both null");
        com.bytedance.android.shopping.buynow.tracker.a r120 = this.f.W90().getTracker();
        StringBuilder r121 = new StringBuilder("url == null is ");
        if (r111 != null) goto L70;
    L73:
        boolean r122 = true;
    L74:
        r121.append(r122);
        r121.append(", params == null is ");
        if (r6 != null) goto L77;
    L80:
        r121.append(r0);
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r120, "blank_params", r121.toString());
        return;
    L77:
        if (r6.isEmpty() == true) goto L80;
        r0 = false;
        goto L80
    L70:
        if (r111.length() == 0) goto L73;
        r122 = false;
        goto L74
    L37:
        r9 = 0;
        goto L38
    L30:
        r6 = null;
        goto L31
    L23:
        r4 = null;
        goto L25
    L16:
        r110 = null;
        goto L18
    }

    public CheckPayStatusController(Context r2, BuyNowFragment r3, ia3.b r4, BuyNowFragment r5, pa3.a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "buyNowFragment");
        Intrinsics.checkNotNullParameter(r5, "disposableScope");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }
}
