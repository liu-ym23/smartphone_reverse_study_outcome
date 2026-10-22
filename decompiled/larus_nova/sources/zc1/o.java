package zc1;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.wallet.model.PayChannel;
import com.bytedance.android.live.wallet.monitor.WalletMonitorEvent;
import com.bytedance.android.live.wallet.monitor.WalletMonitorService;
import com.bytedance.android.live.wallet.platform.api.IWalletApi;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class o {

    public class a implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f571261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ zc1.a f571262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f571263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f571264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ DetailChargeDeal f571265e;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r110) throws Exception {
            Throwable r100 = r110;
            com.bytedance.android.live.wallet.e.c r111 = new com.bytedance.android.live.wallet.e.c();
            r111.f102670a = 3;
            com.bytedance.android.live.recharge.trace.g r101 = com.bytedance.android.live.recharge.trace.f.f90392a;
            com.bytedance.android.live.recharge.trace.f.b(false, null, r100, this.f571261a);
            HashMap<String, Object> r102 = this.f571262b.d("get_order_data_fail");
            String r103 = "";
            if (r100 == null) goto L5;
            String r104 = r100.getMessage();
        L7:
            if ((r100 instanceof ApiServerException) == false) goto L25;
            ApiServerException r105 = (ApiServerException) r100;
            r111.f102671b = r105.getPrompt();
            int r106 = r105.getErrorCode();
            String r107 = String.valueOf(r106);
            String r108 = r105.getErrorMsg();
            if (r105.getProcessed() == true) goto L24;
            com.bytedance.android.live.wallet.e.a r109 = new com.bytedance.android.live.wallet.e.a();
            r111.f102674e = r109;
            r109.f102669f = new HashMap();
            r111.f102674e.f102669f.put("failure_code", r107);
            r111.f102674e.f102669f.put("diamond_intercept", r105.getExtra());
            if (r106 != 4005370) goto L14;
            r111.f102674e.f102669f.put("diamond_refresh_panel", "1");
            goto L24
        L14:
            if (r106 != (-666666)) goto L24;
            String r112 = r105.getExtra();
            com.bytedance.android.live.wallet.model.m r113 = (com.bytedance.android.live.wallet.model.m) GsonProtectorUtils.fromJson(GsonHelper.get(), r112, com.bytedance.android.live.wallet.model.m.class);
            if (r112 == null) goto L24;
            if (r113.d() == false) goto L21;
            r111.f102674e.f102669f.put("open_recharge_security_tip_dialog", "1");
        L23:
            r111.f102674e.f102669f.put("two_factory_auth_verify_info", r112);
            goto L24
        L21:
            if (r113.c() == false) goto L23;
            r111.f102674e.f102669f.put("open_recharge_security_confirm_dialog", "1");
        L24:
            r103 = r107;
            r104 = r108;
        L25:
            this.f571261a.put("failure_code", r103);
            this.f571261a.put("failure_msg", r104);
            int r114 = ed1.a.f472185a;
            ed1.a.a("livesdk_recharge_order_fail", this.f571261a);
            int r115 = fd1.b.f476458a;
            fd1.b.d(false, WalletMonitorEvent.WALLET_ORDER_RESULT_FAIL, r102, r100);
            int r116 = v.f91009a;
            v.f("wallet_pay_alog_tag", r102);
            if (TextUtils.isEmpty(r111.f102671b) == false) goto L28;
            r111.f102671b = "下单失败";
        L28:
            this.f571263c.a(r111);
            r.b(this.f571264d, 1, PayChannel.CJ, this.f571265e.getDiamondId(), r100);
            return;
        L5:
            r104 = "";
            goto L7
        }

        public a(Map r100, zc1.a r101, b r102, long r103, DetailChargeDeal r104) {
            this.f571261a = r100;
            this.f571262b = r101;
            this.f571263c = r102;
            this.f571264d = r103;
            this.f571265e = r104;
        }
    }

    public static void b(JSONObject r110, DetailChargeDeal r111) {
        r110.put("authorid", r111.getOwnerUserId());     // Catch: JSONException -> L28
        r110.put("roomid", r111.getIdStr());     // Catch: JSONException -> L28
        r110.put("live_type", r111.getLiveType());     // Catch: JSONException -> L28
        r110.put("function_type", r111.getFunctionType());     // Catch: JSONException -> L28
        r110.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r111.getExtra().get(PdpOpenThirdParam.KEY_PROMOTION_SOURCE));     // Catch: JSONException -> L28
        r110.put("promotion_id", r111.getExtra().get("promotion_id"));     // Catch: JSONException -> L28
        r110.put("create_pay_type", r111.getExtra().get("create_pay_type"));     // Catch: JSONException -> L28
        r110.put("caijing_pay_params", r111.getExtra().get("caijing_pay_params"));     // Catch: JSONException -> L28
        r110.put("sdk_version", r111.getExtra().get("sdk_version"));     // Catch: JSONException -> L28
        if (r111.getExtra().get(IPerformanceManager.SCENE_LIVE_PK) == null) goto L7;
        r110.put(IPerformanceManager.SCENE_LIVE_PK, CastIntegerProtector.valueOf(r111.getExtra().get(IPerformanceManager.SCENE_LIVE_PK)));     // Catch: JSONException -> L28
    L7:
        if (r111.getExtra().get("roomid") == null) goto L10;
        r110.put("roomid", r111.getExtra().get("roomid"));     // Catch: JSONException -> L28
    L10:
        if (r111.getChargeOrderBusinessScene() == (-1)) goto L13;
        r110.put("business_scene", r111.getChargeOrderBusinessScene());     // Catch: JSONException -> L28
    L13:
        if (r111.getExtra().get("accept_recharge_agreement") == null) goto L16;
        r110.put("accept_recharge_agreement", CastIntegerProtector.valueOf(r111.getExtra().get("accept_recharge_agreement")));     // Catch: JSONException -> L28
    L16:
        if (r111.getExtra().get("cj_extra") == null) goto L19;
        r110.put("cj_extra", r111.getExtra().get("cj_extra"));     // Catch: JSONException -> L28
    L19:
        if (r111.getExtraMap() == null) goto L36;
        Iterator<Map.Entry<String, String>> r112 = r111.getExtraMap().entrySet().iterator();     // Catch: Exception -> L25
    L22:
        if (r112.hasNext() == false) goto L38;
        Map.Entry<String, String> r100 = r112.next();     // Catch: Exception -> L25
        r110.put(r100.getKey(), r100.getValue());     // Catch: Exception -> L25
    L38:
        return;
    L25:
        e = move-exception;
        ALogger.e("WalletPay", "charge deal extra map something wrong!" + e.getMessage());     // Catch: JSONException -> L28
        return;
    L36:
        return;
    L28:
        e = move-exception;
        int r113 = v.f91009a;
        v.b("wallet_pay_alog_tag", "putCommonParamsIntoExtra", e);
    }

    public static void a(final Activity r310, final DetailChargeDeal r311, final com.bytedance.android.live.wallet.e.b r312) {
        final com.bytedance.android.live.wallet.d r110 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b());
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.f90484u.getValue(null, com.bytedance.android.live.recharge.utils.j.f90464a[18])).booleanValue() == true) goto L5;
    L8:
        final long r111 = SystemClock.uptimeMillis();
        b r112 = new b(r312);
        final zc1.a r113 = new zc1.a(r112, r311, r310);
        final HashMap<String, String> r100 = r113.e();
        HashMap<String, Object> r101 = r113.d("start_order");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r112.f571230a = r101;
        int r102 = fd1.b.f476458a;
        fd1.b.c(WalletMonitorService.WALLET_START_ORDER, r101, null);
        int r103 = v.f91009a;
        v.f("wallet_pay_alog_tag", r101);
        long r114 = SystemClock.uptimeMillis();
        long r115 = r114 - dd1.d.f467923a;
        dd1.d.f467923a = r114;
        if (r115 >= 1000) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        ed1.a.a("livesdk_recharge_invaild_pay", r100);
        return;
    L15:
        r100.put("is_pb_enable", "0");
        if (r311.getBizExtra() == null) goto L22;
        JSONObject r105 = r311.getBizExtra();
        HashMap r106 = new HashMap();
        Iterator<String> r116 = r105.keys();
    L19:
        if (r116.hasNext() == false) goto L21;
        String r107 = r116.next();
        r106.put(r107, r105.optString(r107));
        goto L19
    L21:
        r100.putAll(r106);
    L22:
        ed1.a.a("livesdk_ttlive_rd_wallet_diamond_buy", r100);
        if (r311.getChargeOrderSource() == (-1)) goto L25;
        int r108 = r311.getChargeOrderSource();
    L26:
        HashMap r109 = new HashMap();
        r109.put("diamond_id", Long.valueOf(r311.getDiamondId()));
        if (r311.getCombineAmount() <= 0) goto L29;
        int r117 = 3;
    L30:
        r109.put("way", Integer.valueOf(r117));
        if (r311.getExtra().get("pk_pay_method") == null) goto L34;
        r109.put("way", r311.getExtra().get("pk_pay_method"));
    L34:
        if (r311.isIapPay() == false) goto L36;
        r109.put("way", 4);
    L36:
        r109.put("source", Integer.valueOf(r108));
        r109.put("currency", "cny");
        r109.put("room_id", Long.valueOf(r311.getRoomId()));
        r109.put("customized_price", Long.valueOf(r311.getCustomPrice()));
        r109.put("trade_type", Integer.valueOf(r311.getTradeType()));
        JSONObject r118 = new JSONObject();
        if (r311.getExtra() != null) goto L131;
    L47:
        HashMap<String, Object> r210 = r101;
    L49:
        if (r311.getCombineAmount() > 0) goto L51;
    L61:
        b r211 = r112;
        b(r118, r311);
        String r119 = r118.toString();
    L62:
        r109.put("extra", r119);
        JSONObject r120 = r311.getBizExtra();
        if (r120 == null) goto L65;
        String r121 = r120.toString();
    L66:
        r109.put("biz_extra", r121);
        if (r311.getExtra().get("two_factory_auth_verify_info") == null) goto L70;
        r109.put("two_factory_auth_verify_info", r311.getExtra().get("two_factory_auth_verify_info"));
    L70:
        if (r311.getExtra().get("anchor_id") == null) goto L73;
        r109.put("anchor_id", r311.getExtra().get("anchor_id"));
    L73:
        if (r311.getExtra().get("diamond_info") == null) goto L76;
        r109.put("diamond_info", r311.getExtra().get("diamond_info"));
    L76:
        if (r311.getExtra().get("diamond_safe") == null) goto L79;
        r109.put("diamond_safe", r311.getExtra().get("diamond_safe"));
    L79:
        if (r311.getExtra().get("diamond_extra_safe") == null) goto L82;
        r109.put("diamond_extra_safe", r311.getExtra().get("diamond_extra_safe"));
    L82:
        if (r311.getExtra().get(IPerformanceManager.Params.room_type) == null) goto L85;
        r109.put(IPerformanceManager.Params.room_type, r311.getExtra().get(IPerformanceManager.Params.room_type));
    L85:
        if (r311.getExtra().get("continue_pay_info") == null) goto L88;
        r109.put("continue_pay_info", r311.getExtra().get("continue_pay_info"));
    L88:
        if (r311.getExtra().get(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO) == null) goto L91;
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO, r311.getExtra().get(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO));
    L91:
        if (r311.getExtra().get("pre_calc_info") == null) goto L94;
        r109.put("pre_calc_info", r311.getExtra().get("pre_calc_info"));
    L94:
        if (r311.getExtra().get("guide_source") == null) goto L97;
        r109.put("guide_source", r311.getExtra().get("guide_source"));
    L97:
        if (r311.getQueriesMap() != null) goto L129;
    L107:
        com.bytedance.android.live.recharge.trace.g r122 = com.bytedance.android.live.recharge.trace.f.f90392a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_DIAMOND_BUY_PRE, r109);
        if (((Boolean) dd1.e.f467928e.getValue(null, dd1.e.f467924a[3])).booleanValue() == false) goto L116;
        int r123 = q.f571267a;
        Intrinsics.checkNotNullParameter(r310, "activity");
        Intrinsics.checkNotNullParameter(r311, "chargeDeal");
        Intrinsics.checkNotNullParameter(r109, "params");
        tz0.b r124 = tz0.b.f548039a;
        uz0.c r125 = new uz0.c();
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "$this$beforeConfigureRequest");
        Map<String, String> r126 = r125.f552161b;
        Intrinsics.checkNotNullParameter(r126, "queriesMap");
        Iterator r127 = r109.entrySet().iterator();
    L111:
        if (r127.hasNext() == false) goto L115;
        Map.Entry r128 = (Map.Entry) r127.next();
        String r129 = (String) r128.getKey();
        String r130 = r128.getValue().toString();
        Intrinsics.checkNotNullParameter(r129, "$this$setTo");
        if (r130 == null) goto L111;
        r126.put(r129, r130);
        goto L111
    L115:
        x.a(r125, false);
        r125.a(new zw0.a());
        Intrinsics.checkNotNullParameter(r125, "$this$afterConfigureRequest");
        Single r131 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_api/diamond_buy/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.wallet.model.d.class)), MinorExtra.class, r125.f552163d, r125.f552160a, r125.f552161b, r125.f552162c).map(p.f571266a).compose(new dd1.b(r310, r311.getRequestPage())).compose(new com.bytedance.android.live.wallet.platform.business.verify.h(r310, r109)).compose(RxUtil.rxSchedulerHelper()).singleOrError().map(new i());
    L120:
        final HashMap<String, Object> r132 = r210;
        final b r133 = r211;
        r131.subscribe(new j(r111, r100, r311, r113, r132, r310, r312, r110, r133), new a(r100, r113, r211, r111, r311));
        return;
    L116:
        Observable<com.bytedance.android.live.recharge.model.c> r134 = com.bytedance.android.live.recharge.core.f.j(RechargeServices.b()).N0(r311.getPrice(), r311.getDiamondId(), r109);
        if (r134 == null) goto L119;
        r131 = r134.map(new k()).compose(RxUtil.rxSchedulerHelper()).compose(new dd1.b(r310, r311.getRequestPage())).compose(new com.bytedance.android.live.wallet.platform.business.verify.h(r310, r109)).firstOrError();
        goto L120
    L119:
        r131 = ((IWalletApi) ((com.bytedance.android.livesdk.revenue.service.network.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.network.a.class)).getService(IWalletApi.class)).createPreOrder(r109).doOnNext(new l()).map(new m()).map(new n()).compose(RxUtil.rxSchedulerHelper()).compose(new dd1.b(r310, r311.getRequestPage())).compose(new com.bytedance.android.live.wallet.platform.business.verify.h(r310, r109)).singleOrError();
        goto L120
    L129:
        Iterator<Map.Entry<String, String>> r135 = r311.getQueriesMap().entrySet().iterator();     // Catch: Exception -> L105
    L100:
        if (r135.hasNext() == false) goto L107;
        Map.Entry<String, String> r136 = r135.next();     // Catch: Exception -> L105
        if (r136.getValue() == null) goto L100;
        r109.put(r136.getKey(), r136.getValue());     // Catch: Exception -> L105
    L105:
        e = move-exception;
        ALogger.e("WalletPay", "put common params into query is something wrong!" + e.getMessage());
        goto L107
    L65:
        r121 = SliceInitService.DEFAULT_SWITCH;
        goto L66
    L51:
        if (r311.getCombineAmount() >= r311.getPrice()) goto L61;
        JSONArray r137 = new JSONArray();     // Catch: JSONException -> L58
        JSONObject r138 = new JSONObject();     // Catch: JSONException -> L58
        r138.put("combineMethod", 18);     // Catch: JSONException -> L58
        r138.put("combineAmount", r311.getCombineAmount());     // Catch: JSONException -> L58
        JSONObject r139 = new JSONObject();     // Catch: JSONException -> L58
        r211 = r112;
        r139.put("combineMethod", 200);     // Catch: JSONException -> L56
        r139.put("combineAmount", r311.getPrice() - r311.getCombineAmount());     // Catch: JSONException -> L56
        r137.put(0, r138);     // Catch: JSONException -> L56
        r137.put(1, r139);     // Catch: JSONException -> L56
        r118.put("combineStruct", r137.toString());     // Catch: JSONException -> L56
        b(r118, r311);     // Catch: JSONException -> L56
        r119 = r118.toString();     // Catch: JSONException -> L56
    L56:
        e = e;
    L60:
        e.printStackTrace();
        r119 = "";
    L58:
        e = e;
        r211 = r112;
        goto L60
    L131:
        Iterator<Map.Entry<String, String>> r140 = r311.getExtra().entrySet().iterator();     // Catch: JSONException -> L45
    L40:
        if (r140.hasNext() == false) goto L47;
        Map.Entry<String, String> r212 = r140.next();     // Catch: JSONException -> L45
        Iterator<Map.Entry<String, String>> r213 = r140;
        r210 = r101;
        r118.put(r212.getKey(), r212.getValue());     // Catch: JSONException -> L122
        r101 = r210;
        r140 = r213;
    L46:
        ALogger.e("WalletPay", "error in extra parse");
    L45:
        r210 = r101;
        goto L46
    L29:
        r117 = 0;
        goto L30
    L25:
        r108 = 0;
        goto L26
    L11:
        r104 = false;
        goto L12
    L5:
        if (((dr2.j) com.bytedance.android.live.revenue.core.util.e.a(dr2.j.class)).isFinancialVisible() == true) goto L8;
        com.bytedance.android.live.wallet.e.c r141 = new com.bytedance.android.live.wallet.e.c();
        r141.f102670a = 3;
        r141.f102671b = s1.C(R.string.ttlive_go_to_douyin_recharge, new Object[]{e4.a()});
        r312.a(r141);
    }
}
