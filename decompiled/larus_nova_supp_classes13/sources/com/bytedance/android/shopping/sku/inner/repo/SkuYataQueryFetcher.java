package com.bytedance.android.shopping.sku.inner.repo;

import android.content.res.Resources;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.sku.CpsParams;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAptChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataOpenSkuChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataPageShowChain;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenPoint;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.container.SkuYataQueryFrom;
import com.bytedance.android.shopping.sku.inner.container.SkuYataSkeletonLoadingStatus;
import com.bytedance.android.shopping.sku.inner.container.f0;
import com.bytedance.android.shopping.sku.inner.container.o;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.sku.inner.repo.composer.SkuYataExParamsComposer;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.sku.inner.tracker.SkuYataTracker;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.SsResponse;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataQueryFetcher {
    public final Lazy a;
    public final SkuYataTracker b;
    public final Lazy c;
    public Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> d;
    public Disposable e;
    public volatile boolean f;
    public WeakReference<Object> g;
    public volatile com.bytedance.android.shopping.sku.inner.repo.b h;
    public final String i;
    public final SkuParams j;
    public final PageFinder k;
    public final SkuSchemaParams l;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SkuYataQueryFetcher a;
        public final /* synthetic */ SkuYataQueryFrom b;
        public final /* synthetic */ ph3.b c;

        public a(SkuYataQueryFetcher r1, SkuYataQueryFrom r2, ph3.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            Pair r11 = (Pair) r10;
            mh3.a r0 = this.a.a();
            if (r0 == null) goto L11;
            SkuYataFirstScreenDurationMonitor r1 = r0.a;
            if (r1 == null) goto L11;
            Object r2 = ((SsResponse) r11.getSecond()).raw().getExtraInfo();
            hd3.d r3 = ((com.bytedance.android.shopping.sku.inner.repo.a) r11.getFirst()).h();
            if (r1.f != null) goto L10;
            if (r2 == null) goto L10;
            r1.f = r2;
        L10:
            r1.g = r3;
        L11:
            com.bytedance.android.shopping.sku.inner.repo.a r12 = (com.bytedance.android.shopping.sku.inner.repo.a) r11.getFirst();
            int r4 = 0;
            if (f.d(r12) == false) goto L53;
            mh3.a r5 = this.a.a();
            if (r5 == null) goto L16;
            r5.a(f.b(r12));
        L16:
            Lazy r6 = SkuCommonLog.a;
            SkuCommonLog.c("SkuYataQueryFetcher", this.b.getValue() + ":接口请求成功  logId:" + f.b(r12));
            mh3.a r7 = this.a.a();
            if (r7 == null) goto L21;
            SkuYataFirstScreenDurationMonitor r8 = r7.a;
            if (r8 == null) goto L21;
            SkuYataFirstScreenDurationMonitor.b(r8, SkuYataFirstScreenPoint.REQUEST_END);
        L21:
            SkuYataQueryFetcher r9 = this.a;
            r9.getClass();
            com.bytedance.kmp.ec.yata.common.protocol.data.c r13 = r12.i();
            if (r13 == null) goto L32;
            Map r14 = r13.g();
            if (r14 == null) goto L26;
            Object r15 = r14.get("track_common_info");
        L28:
            if ((r15 instanceof Map) == true) goto L30;
            r15 = null;
        L30:
            Map<String, ? extends Object> r16 = (Map) r15;
            if (r16 == null) goto L32;
        L33:
            r9.b.f(r16, true, r9.k);
            Object r17 = r16.get("entrance_info");
            if ((r17 instanceof String) == true) goto L36;
            r17 = null;
        L36:
            String r18 = (String) r17;
            if (r18 == null) goto L44;
            SkuPerformanceOpt.a();
            String r19 = EcomBcmTracker.b(r9.k, r18);
            if (r19 == null) goto L42;
            r18 = r19;
        L42:
            r9.b.e(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_info", r18)}));
        L44:
            if (r16.isEmpty() == false) goto L50;
            mh3.a r20 = r9.a();
            if (r20 == null) goto L50;
            com.bytedance.android.shopping.sku.common.monitor.error.a r21 = r20.c;
            if (r21 == null) goto L50;
            SkuErrorMonitorType r22 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r23 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
            r21.a(r22, "首屏请求track_common_info为空", null);
        L50:
            SkuYataQueryFetcher r24 = this.a;
            com.bytedance.android.shopping.sku.inner.repo.b r25 = new com.bytedance.android.shopping.sku.inner.repo.b(new f0(this.b, r12), new o(SkuYataSkeletonLoadingStatus.SUCCESS, 0, 0));
            r24.h = r25;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r26 = r24.d;
            if (r26 == null) goto L71;
            Unit r27 = (Unit) r26.invoke(r25);
        L71:
            mh3.a r28 = this.a.a();
            if (r28 == null) goto L76;
            SkuYataAptChain r29 = r28.f;
            if (r29 == null) goto L76;
            r29.e(r12);
        L76:
            mh3.a r30 = this.a.a();
            if (r30 == null) goto L81;
            SkuYataOpenSkuChain r31 = r30.h;
            if (r31 == null) goto L81;
            r31.c(this.c, r12, null);
        L81:
            mh3.a r32 = this.a.a();
            if (r32 == null) goto L87;
            SkuYataPageShowChain r33 = r32.g;
            if (r33 == null) goto L88;
            r33.b(this.c, r12, null);
            return;
        L88:
            return;
        L87:
            return;
        L26:
            r15 = null;
        L32:
            r16 = MapsKt.emptyMap();
            goto L33
        L53:
            Lazy r34 = SkuCommonLog.a;
            StringBuilder r35 = new StringBuilder();
            r35.append(this.b.getValue() + ":接口请求失败  statusCode:" + r12.a() + "  statusmsg:" + r12.b() + "  logId:" + f.b(r12));
            Unit r36 = Unit.INSTANCE;
            SkuCommonLog.b("SkuYataQueryFetcher", r35.toString());
            SkuYataQueryFetcher r37 = this.a;
            f0 r38 = new f0(this.b, r12);
            SkuYataSkeletonLoadingStatus r39 = SkuYataSkeletonLoadingStatus.ERROR;
            Integer r40 = r12.a();
            if (r40 == null) goto L56;
            int r41 = r40.intValue();
        L57:
            String r42 = r12.g();
            if (r42 == null) goto L60;
            r4 = CastIntegerProtector.parseInt(r42);
        L60:
            com.bytedance.android.shopping.sku.inner.repo.b r43 = new com.bytedance.android.shopping.sku.inner.repo.b(r38, new o(r39, r41, r4));
            r37.h = r43;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r44 = r37.d;
            if (r44 == null) goto L63;
            Unit r45 = (Unit) r44.invoke(r43);
        L63:
            mh3.a r46 = this.a.a();
            if (r46 == null) goto L71;
            com.bytedance.android.shopping.sku.common.monitor.error.a r47 = r46.c;
            if (r47 == null) goto L71;
            SkuErrorMonitorType r48 = SkuErrorMonitorType.SKU_QUERY_API_ERROR;
            String r49 = "code:" + r12.a() + "   msg:" + r12.b();
            JSONObject r50 = new JSONObject();
            r50.put("error_code", String.valueOf(r12.a()));
            String r51 = r12.b();
            if (r51 != null) goto L70;
            r51 = "";
        L70:
            r50.put("error_msg", r51);
            r50.put("log_id", f.b(r12));
            r47.a(r48, r49, r50);
            goto L71
        L56:
            r41 = 0;
            goto L57
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SkuYataQueryFetcher a;
        public final /* synthetic */ SkuYataQueryFrom b;
        public final /* synthetic */ ph3.b c;

        public b(SkuYataQueryFetcher r1, SkuYataQueryFrom r2, ph3.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Lazy r0 = SkuCommonLog.a;
            SkuCommonLog.b("SkuYataQueryFetcher", this.b.getValue() + ":接口请求网络异常  " + r7);
            SkuYataQueryFetcher r1 = this.a;
            com.bytedance.android.shopping.sku.inner.repo.b r2 = new com.bytedance.android.shopping.sku.inner.repo.b(null, new o(SkuYataSkeletonLoadingStatus.ERROR, 0, 0));
            r1.h = r2;
            Function1<? super com.bytedance.android.shopping.sku.inner.repo.b, Unit> r3 = r1.d;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke(r2);
        L5:
            mh3.a r5 = this.a.a();
            if (r5 == null) goto L10;
            SkuYataOpenSkuChain r8 = r5.h;
            if (r8 == null) goto L10;
            r8.c(this.c, null, r7);
        L10:
            mh3.a r9 = this.a.a();
            if (r9 == null) goto L16;
            SkuYataPageShowChain r10 = r9.g;
            if (r10 == null) goto L17;
            r10.b(this.c, null, r7);
            return;
        L17:
            return;
        }
    }

    public final mh3.a a() {
        return (mh3.a) this.c.getValue();
    }

    public final void b(SkuYataQueryFrom r30) {
        Intrinsics.checkNotNullParameter(r30, "queryFrom");
        if (r30 == SkuYataQueryFrom.FIRST_SCREEN) goto L5;
    L8:
        this.f = true;
        if (r30 != SkuYataQueryFrom.ERROR_RETRY) goto L11;
        Set r0 = ECProcessMonitor.a;
        ECProcessMonitor.p().j.invoke();
        ((ActionRateListener) ECProcessMonitor.p()).f = "retry_page";
        ECProcessMonitor.p().k();
    L11:
        Lazy r1 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataQueryFetcher", r30.getValue() + ":开始请求接口");
        mh3.a r2 = a();
        if (r2 == null) goto L16;
        SkuYataFirstScreenDurationMonitor r3 = r2.a;
        if (r3 == null) goto L16;
        SkuYataFirstScreenDurationMonitor.b(r3, SkuYataFirstScreenPoint.REQUEST_START);
    L16:
        SkuYataExParamsComposer r4 = new SkuYataExParamsComposer(this.j, this.i, this.l, this.g);
        Pair[] r5 = new Pair[4];
        if (Intrinsics.areEqual(r4.b, "forDiff") == true) goto L19;
        Map r6 = MapsKt.emptyMap();
    L47:
        SkuSchemaParams r7 = r4.c;
        if (r7 == null) goto L53;
        com.bytedance.android.shopping.sku.inner.repo.composer.b r8 = new com.bytedance.android.shopping.sku.inner.repo.composer.b(r7, r4.a);
        List<SkuPassThroughItem> r9 = r4.a();
        Intrinsics.checkNotNullParameter(r9, "passThrough");
        Map r10 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("product_info", r8.a.getProductInfo().getMap()), TuplesKt.to("biz_context", r8.a.getBizContext().getMap()), TuplesKt.to("user_info", r8.a.getUserInfo().getMap()), TuplesKt.to("client_params", r8.a.getClientParams().getMap()), TuplesKt.to("chain_info", r8.a.getChainInfo().getMap()), TuplesKt.to("custom_params", r8.a.getCustomParams().getMap()), TuplesKt.to("platform_params", r8.a.getPlatformParams().getMap()), TuplesKt.to("pass_through", r9), TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(r8.b, false))}));
        Iterator r11 = r6.entrySet().iterator();
    L51:
        if (r11.hasNext() == false) goto L261;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), r12.getValue());
    L261:
        r5[0] = TuplesKt.to("sku_schema_param", r10);
        int r13 = ECSdk.a;
        IAddressService r14 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r14 == null) goto L270;
        WeakReference<Object> r15 = r4.d;
        if (r15 == null) goto L266;
        Object r16 = r15.get();
    L267:
        o83.a r17 = IAddressService.a.a(r14, r16, "a1.b5267.c0.d0", 4);
        if (r17 == null) goto L270;
        char r18 = 1;
        String r19 = r17.a(true, null, null).toString();
    L271:
        r5[r18] = TuplesKt.to("address_detail", r19);
        LinkedHashMap r20 = new LinkedHashMap();
        com.bytedance.android.ec.core.abtest.d r21 = com.bytedance.android.ec.core.abtest.d.a;
        jj4.b r22 = jj4.b.b;
        Object r23 = jj4.a.a("iesec_sku_ab_keys_ab_sdk", List.class, new ArrayList(), false);
        if (r23 != null) goto L274;
        Intrinsics.throwNpe();
    L274:
        Iterator r24 = ((List) r23).iterator();
    L276:
        if (r24.hasNext() == false) goto L294;
        String r25 = (String) r24.next();
        if (r25.length() <= 0) goto L280;
        boolean r26 = true;
    L281:
        if (r26 == false) goto L276;
        String r27 = "ab_sdk_".concat(r25);
        int r28 = p.a;
        Object r29 = 0;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L287
        jj4.b r32 = jj4.b.b;     // Catch: Throwable -> L287
        Object r33 = jj4.a.a(r25, Integer.class, r29, false);     // Catch: Throwable -> L287
        if (r33 != null) goto L293;
        Intrinsics.throwNpe();     // Catch: Throwable -> L287
    L293:
        r20.put(r27, r33);
    L287:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Object r35 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r35) == true) goto L292;
        r29 = r35;
    L292:
        r33 = r29;
        goto L293
    L280:
        r26 = false;
        goto L281
    L294:
        r5[2] = TuplesKt.to("ab_params", k.d(r20));
        r5[3] = TuplesKt.to("sku_unique_id", r4.b);
        Map r36 = MapsKt.mutableMapOf(r5);
        int r37 = g0.a;
        ECAppInfoService r38 = ECAppInfoService.e;
        boolean r39 = true;
        r36.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("gps_on", Integer.valueOf(g0.a(r38.getApplicationContext()) ? 1 : 0)), TuplesKt.to("is_auth", Boolean.valueOf(g0.a(r38.getApplicationContext()))), TuplesKt.to("biz_identifier", r4.a.getBizIdentifier())}));
        PackYataSdkConfig r40 = com.bytedance.kmp.ec.yata.common.init.b.a;
        ph3.b r41 = new ph3.b(r36, "1.23.7", 2);
        mh3.a r42 = a();
        if (r42 == null) goto L299;
        SkuYataAptChain r43 = r42.f;
        if (r43 == null) goto L299;
        r43.d(r41);
    L299:
        mh3.a r44 = a();
        if (r44 == null) goto L304;
        SkuYataFirstScreenDurationMonitor r45 = r44.a;
        if (r45 == null) goto L304;
        SkuYataFirstScreenDurationMonitor.b(r45, SkuYataFirstScreenPoint.QUERY_NET_START);
    L304:
        Disposable r46 = this.e;
        if (r46 == null) goto L307;
        r46.dispose();
    L307:
        c r47 = (c) this.a.getValue();
        if (r30 == SkuYataQueryFrom.FIRST_SCREEN) goto L311;
        r39 = false;
    L311:
        this.e = r47.query(r39, r41, new SkuYataQueryFetcher$requestQuery$1(this), new SkuYataQueryFetcher$requestQuery$2(this)).subscribeOn(Schedulers.computation()).subscribe(new a(this, r30, r41), new b(this, r30, r41));
        return;
    L266:
        r16 = null;
    L270:
        r18 = 1;
        r19 = null;
        goto L271
    L53:
        Pair[] r48 = new Pair[9];
        Pair[] r49 = new Pair[7];
        String r50 = r4.a.getProductId();
        if ((r50 instanceof String) == true) goto L56;
        r50 = null;
    L56:
        r49[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r50);
        String r51 = r4.a.getPromotionId();
        Map r210 = r6;
        if (r51 == null) goto L322;
        r49[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_ID, r51);
        String r52 = r4.a.getCommodityType();
        if (r52 == null) goto L61;
        Integer r53 = StringsKt.toIntOrNull(r52);
    L63:
        if ((r53 instanceof Integer) == true) goto L65;
        r53 = null;
    L65:
        r49[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r53);
        r49[3] = TuplesKt.to("is_multi", Boolean.valueOf(r4.a.isMulti()));
        String r54 = r4.a.getShopId();
        if ((r54 instanceof String) == true) goto L68;
        r54 = null;
    L68:
        r49[4] = TuplesKt.to("shop_id", r54);
        String r55 = r4.a.getCombinationId();
        if ((r55 instanceof String) == true) goto L71;
        r55 = null;
    L71:
        r49[5] = TuplesKt.to("combination_id", r55);
        DefaultSelect r56 = r4.a.getDefaultSelect();
        if (r56 == null) goto L74;
        String r57 = r56.getSkuId();
    L76:
        if ((r57 instanceof String) == true) goto L78;
        r57 = null;
    L78:
        r49[6] = TuplesKt.to("hot_sale_sku_id", r57);
        r48[0] = TuplesKt.to("product_info", MapsKt.mapOf(r49));
        Pair[] r58 = new Pair[19];
        String r110 = r4.a.getAuthorId();
        if (r110 == null) goto L320;
        r58[0] = TuplesKt.to("author_id", r110);
        String r59 = r4.a.getSecAuthorId();
        if (r59 == null) goto L318;
        r58[1] = TuplesKt.to(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r59);
        String r60 = r4.a.getItemId();
        if ((r60 instanceof String) == true) goto L85;
        r60 = null;
    L85:
        r58[2] = TuplesKt.to(PdpOpenThirdParam.KEY_ITEM_ID, r60);
        String r61 = r4.a.getRoomId();
        if ((r61 instanceof String) == true) goto L88;
        r61 = null;
    L88:
        r58[3] = TuplesKt.to("live_room_id", r61);
        r58[4] = TuplesKt.to("is_group_buy", Boolean.valueOf(r4.a.isGroupingBuy()));
        String r62 = String.valueOf(r4.a.getActionType());
        if (r62 == null) goto L316;
        r58[5] = TuplesKt.to("action_type", r62);
        String r63 = String.valueOf(r4.a.getSceneType());
        if (r63 == null) goto L314;
        r58[6] = TuplesKt.to("scene_type", r63);
        DefaultSelect r64 = r4.a.getDefaultSelect();
        if (r64 == null) goto L95;
        String r65 = r64.getLastSelectedSkuId();
    L97:
        if ((r65 instanceof String) == true) goto L99;
        r65 = null;
    L99:
        r58[7] = TuplesKt.to("sku_id", r65);
        DefaultSelect r66 = r4.a.getDefaultSelect();
        if (r66 == null) goto L102;
        Integer r67 = r66.getType();
    L104:
        if ((r67 instanceof Integer) == true) goto L106;
        r67 = null;
    L106:
        r58[8] = TuplesKt.to("hot_sale_type", r67);
        Lazy r68 = SkuPerformanceOpt.a;
        BuyNowPerformanceOpt.l();
        r58[9] = TuplesKt.to(PdpOpenThirdParam.KEY_ORDER_URL, null);
        String r111 = r4.a.getDetailUrl();
        if ((r111 instanceof String) == true) goto L109;
        r111 = null;
    L109:
        r58[10] = TuplesKt.to("detail_url", r111);
        r58[11] = TuplesKt.to("auto_apply_coupon", Boolean.FALSE);
        List r69 = r4.a.getBenefitLabels();
        if ((r69 instanceof List) == true) goto L112;
        r69 = null;
    L112:
        r58[12] = TuplesKt.to("coupon_tags", r69);
        JSONObject r70 = new JSONObject();
        r70.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r4.a.getCommodityType());
        r70.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r4.a.getProductId());
        r70.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r4.a.getPromotionId());
        Unit r71 = Unit.INSTANCE;
        r58[13] = TuplesKt.to("live_product_raw_data", r70.toString());
        String r72 = r4.a.getSelectCarId();
        if ((r72 instanceof String) == true) goto L115;
        r72 = null;
    L115:
        r58[14] = TuplesKt.to("car_id", r72);
        r58[15] = TuplesKt.to("ngroup_buy_token", r4.a.getNGroupBuyToken());
        r58[16] = TuplesKt.to("biz_identifier", r4.a.getBizIdentifier());
        r58[17] = TuplesKt.to("warehouse_list_id", r4.a.getWarehouseListID());
        r58[18] = TuplesKt.to("live_shop_mode", r4.a.getLiveShopMode());
        r48[1] = TuplesKt.to("biz_context", MapsKt.mapOf(r58));
        String r73 = r4.a.getReceiveAddressId();
        if ((r73 instanceof String) == true) goto L118;
        r73 = null;
    L118:
        r48[2] = TuplesKt.to("user_info", MapsKt.mapOf(TuplesKt.to("user_addr_id", r73)));
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.V() == false) goto L121;
        int r74 = 390;
    L125:
        int r75 = r4.a.getHeightPercent();
        String r112 = String.valueOf(r4.a.getSceneType());
        Integer r113 = r4.a.getForceHeight();
        if (BuyNowPerformanceOpt.m() == false) goto L129;
        r75 = 88;
    L151:
        Pair[] r76 = new Pair[16];
        SkuRestoreState r114 = r4.a.getSkuState();
        if (r114 == null) goto L154;
        String[] r115 = r114.getSelectSkuKeys();
    L156:
        if ((r115 instanceof String[]) == true) goto L158;
        r115 = null;
    L158:
        r76[0] = TuplesKt.to("default_spec_id", r115);
        DefaultSelect r116 = r4.a.getDefaultSelect();
        if (r116 == null) goto L161;
        Long r117 = r116.getBuyNum();
    L163:
        if ((r117 instanceof Long) == true) goto L165;
        r117 = null;
    L165:
        r76[1] = TuplesKt.to("default_count", r117);
        SkuPoiInfo r118 = r4.a.getPoiInfo();
        if ((r118 instanceof SkuPoiInfo) == true) goto L168;
        r118 = null;
    L168:
        r76[2] = TuplesKt.to("poi_info", r118);
        Boolean r119 = r4.a.getPopOnWindow();
        if ((r119 instanceof Boolean) == true) goto L171;
        r119 = null;
    L171:
        r76[3] = TuplesKt.to("pop_on_window", r119);
        String r120 = r4.a.getSkuSessionId();
        if ((r120 instanceof String) == true) goto L174;
        r120 = null;
    L174:
        r76[4] = TuplesKt.to("sku_session_id", r120);
        r76[5] = TuplesKt.to("scroll_to_installment", Boolean.valueOf(r4.a.getScrollToDouInstallment()));
        String r121 = r4.a.getMaskBackgroundColor();
        if ((r121 instanceof String) == true) goto L177;
        r121 = null;
    L177:
        r76[6] = TuplesKt.to("mask_background_color", r121);
        DefaultSelect r122 = r4.a.getDefaultSelect();
        if (r122 == null) goto L180;
        Boolean r123 = Boolean.valueOf(r122.getDisableServerSpecsDefaultSelect());
    L182:
        if ((r123 instanceof Boolean) == true) goto L184;
        r123 = null;
    L184:
        r76[7] = TuplesKt.to("disable_server_specs_default_select", r123);
        Integer r124 = r4.a.getTermCount();
        if (r124 == null) goto L187;
        String r125 = String.valueOf(r124.intValue());
    L189:
        if ((r125 instanceof String) == true) goto L191;
        r125 = null;
    L191:
        r76[8] = TuplesKt.to("dou_installment_term", r125);
        Integer r126 = r4.a.getSpecMode();
        if ((r126 instanceof Integer) == true) goto L194;
        r126 = null;
    L194:
        r76[9] = TuplesKt.to("spec_mode", r126);
        Long r127 = r4.a.getSpecModeTime();
        if (r127 == null) goto L197;
        String r128 = String.valueOf(r127.longValue());
    L199:
        if ((r128 instanceof String) == true) goto L201;
        r128 = null;
    L201:
        r76[10] = TuplesKt.to("spec_mode_time", r128);
        SkuYataSelfSaveBizFieldsCacheController.a r129 = SkuYataSelfSaveBizFieldsCacheController.a;
        Map r130 = SkuYataSelfSaveBizFieldsCacheController.a(r4.a.getPromotionId());
        if (r130 != null) goto L205;
        r130 = null;
    L205:
        r76[11] = TuplesKt.to("sku_last_biz_fields", k.d(r130));
        r76[12] = TuplesKt.to("height_percent", r75);
        r76[13] = TuplesKt.to("force_height", r113);
        r76[14] = TuplesKt.to("panel_width", Integer.valueOf(r74));
        int r77 = com.bytedance.android.shopping.sku.common.utils.c.a;
        Integer r78 = Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).b);
        List<String> r79 = com.bytedance.android.shopping.sku.inner.repo.composer.a.a;
        Resources r80 = Resources.getSystem();
        float r81 = WindowDisplayMetricsOverride.apply(r80, r80.getDisplayMetrics()).density;
        if (r81 == 0.0f) goto L208;
        int r82 = (int) (r78.floatValue() / r81);
    L209:
        r76[15] = TuplesKt.to("panel_height", Integer.valueOf(r82));
        r48[3] = TuplesKt.to("client_params", MapsKt.mapOf(r76));
        Pair[] r84 = new Pair[8];
        SkuExtraData r85 = r4.a.getSkuExtraData();
        if (r85 == null) goto L212;
        String r131 = r85.getMarketChannel();
    L214:
        if ((r131 instanceof String) == true) goto L216;
        r131 = null;
    L216:
        r84[0] = TuplesKt.to("marketing_channel", r131);
        String r132 = r4.a.getEnterFrom();
        if ((r132 instanceof String) == true) goto L219;
        r132 = null;
    L219:
        r84[1] = TuplesKt.to(SimilarProductParam.ENTER_FROM, r132);
        String r133 = r4.a.getChannelId();
        if ((r133 instanceof String) == true) goto L222;
        r133 = null;
    L222:
        r84[2] = TuplesKt.to("channel_id", r133);
        Integer r86 = r4.a.getChannelType();
        if (r86 == null) goto L225;
        String r134 = String.valueOf(r86.intValue());
    L227:
        if ((r134 instanceof String) == true) goto L229;
        r134 = null;
    L229:
        r84[3] = TuplesKt.to("channel_type", r134);
        Integer r87 = r4.a.getTouTiaoAppId();
        if (r87 == null) goto L232;
        String r135 = String.valueOf(r87.intValue());
    L234:
        if ((r135 instanceof String) == true) goto L236;
        r135 = null;
    L236:
        r84[4] = TuplesKt.to("toutiao_app_id", r135);
        String r136 = r4.a.getEcomEntranceForm();
        if ((r136 instanceof String) == true) goto L239;
        r136 = null;
    L239:
        r84[5] = TuplesKt.to("ecom_entrance_form", r136);
        String r137 = r4.a.getProductSourcePage();
        if ((r137 instanceof String) == true) goto L242;
        r137 = null;
    L242:
        r84[6] = TuplesKt.to("product_source_page", r137);
        String r138 = r4.a.getBizCampaignType();
        if ((r138 instanceof String) == true) goto L245;
        r138 = null;
    L245:
        r84[7] = TuplesKt.to("biz_campaign_type", r138);
        r48[4] = TuplesKt.to("chain_info", MapsKt.mapOf(r84));
        Pair[] r88 = new Pair[3];
        ECAdLogExtra r139 = r4.a.getAdLogExtra();
        if ((r139 instanceof ECAdLogExtra) == true) goto L248;
        r139 = null;
    L248:
        r88[0] = TuplesKt.to("ad_params", r139);
        ECBoltParam r140 = r4.a.getBoltParam();
        if ((r140 instanceof ECBoltParam) == true) goto L251;
        r140 = null;
    L251:
        r88[1] = TuplesKt.to("bolt_param", r140);
        CpsParams r141 = r4.a.getCpsParams();
        if ((r141 instanceof CpsParams) == true) goto L254;
        r141 = null;
    L254:
        r88[2] = TuplesKt.to("cps_params", r141);
        r48[5] = TuplesKt.to("custom_params", MapsKt.mapOf(r88));
        Boolean r142 = r4.a.getOpenWithSass();
        if ((r142 instanceof Boolean) == true) goto L257;
        r142 = null;
    L257:
        r48[6] = TuplesKt.to("platform_params", MapsKt.mapOf(TuplesKt.to("open_with_saas", r142)));
        r48[7] = TuplesKt.to("pass_through", r4.a());
        r48[8] = TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(r4.a, false));
        r10 = MapsKt.toMutableMap(MapsKt.mapOf(r48));
        Iterator r89 = r210.entrySet().iterator();
    L259:
        if (r89.hasNext() == false) goto L261;
        Map.Entry r90 = (Map.Entry) r89.next();
        r10.put(r90.getKey(), r90.getValue());
        goto L259
    L232:
        r135 = null;
        goto L234
    L225:
        r134 = null;
        goto L227
    L212:
        r131 = null;
        goto L214
    L208:
        r82 = 0;
        goto L209
    L197:
        r128 = null;
        goto L199
    L187:
        r125 = null;
        goto L189
    L180:
        r123 = null;
        goto L182
    L161:
        r117 = null;
        goto L163
    L154:
        r115 = null;
        goto L156
    L129:
        if (BuyNowPerformanceOpt.p() == false) goto L134;
        if (ECSettingKeys.W().contains(r112) == false) goto L151;
        r75 = 88;
        goto L151
    L134:
        if (BuyNowPerformanceOpt.o() == false) goto L139;
        if (ECSettingKeys.W().contains(r112) == true) goto L151;
        r75 = 88;
        goto L151
    L139:
        if (BuyNowPerformanceOpt.n() == false) goto L146;
        if (r113 != null) goto L143;
    L144:
        r75 = 88;
        goto L151
    L143:
        if (r113.intValue() == 1) goto L151;
    L146:
        if (r113 == null) goto L151;
        if (r113.intValue() != 1) goto L151;
        r75 = 88;
        goto L151
    L121:
        int r91 = com.bytedance.android.shopping.sku.common.utils.c.a;
        Integer r92 = Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).a);
        List<String> r94 = com.bytedance.android.shopping.sku.inner.repo.composer.a.a;
        Resources r95 = Resources.getSystem();
        float r96 = WindowDisplayMetricsOverride.apply(r95, r95.getDisplayMetrics()).density;
        if (r96 == 0.0f) goto L124;
        r74 = (int) (r92.floatValue() / r96);
        goto L125
    L124:
        r74 = 0;
        goto L125
    L102:
        r67 = null;
        goto L104
    L95:
        r65 = null;
        goto L97
    L314:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L316:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L318:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L320:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L74:
        r57 = null;
        goto L76
    L61:
        r53 = null;
        goto L63
    L322:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L19:
        if (Intrinsics.areEqual(r4.b, "forDiff") == true) goto L21;
    L44:
        String r97 = r4.a.getTrackExtra();
    L45:
        String r98 = (String) r4.a.getEventParams().get("entrance_info");
        int r99 = com.bytedance.android.ec.core.hybrid.utils.k.a;
        r6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("api_add_extra", r97), TuplesKt.to("track_client_entrance_info", r98), TuplesKt.to("track_client", com.bytedance.android.ec.core.hybrid.utils.k.b(r4.a.getEventParams()).toString()), TuplesKt.to("api_sku_entrance_info", r4.a.getEntranceInfo())});
        goto L47
    L21:
        if (a2.b(r4.a.getAddCartEntranceInfo()) == false) goto L44;
        JSONObject r100 = z1.g(r4.a.getTrackExtra());
        if (r100 == null) goto L43;
        JSONObject r143 = com.bytedance.android.shopping.extensions.k.u(r100.optString("cart_track"));
        SkuExtraData r144 = r4.a.getSkuExtraData();
        if (r144 == null) goto L34;
        String r145 = r144.getTransitionTrackerData();
        if (r145 == null) goto L34;
        JSONObject r146 = z1.g(r145);
        if (r146 == null) goto L34;
        Iterator<String> r147 = r146.keys();
    L32:
        if (r147.hasNext() == false) goto L34;
        String r148 = r147.next();
        r143.put(r148, r146.optString(r148));
    L34:
        String r149 = r4.a.getAddCartEntranceInfo();
        if (r149 == null) goto L42;
        JSONObject r150 = z1.g(r149);
        if (r150 == null) goto L42;
        Iterator<String> r151 = r150.keys();
    L40:
        if (r151.hasNext() == false) goto L42;
        String r152 = r151.next();
        r143.put(r152, r150.optString(r152));
    L42:
        KtSafeMethodExtensionKt.safePut(r100, "cart_track", r143.toString());
        r97 = r100.toString();
        goto L45
    L43:
        r97 = null;
        goto L45
    L5:
        if (this.f == false) goto L8;
        SkuCommonLog.c("SkuYataQueryFetcher", "hasStartFirstQuery so return");
    }

    public SkuYataQueryFetcher(String r4, SkuParams r5, PageFinder r6, SkuSchemaParams r7) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "skuParams");
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.a = LazyKt.lazy(SkuYataQueryFetcher$repository$2.INSTANCE);
        this.b = new SkuYataTracker(r5);
        this.c = LazyKt.lazy(new SkuYataQueryFetcher$monitorManager$2(this));
        this.h = new com.bytedance.android.shopping.sku.inner.repo.b(null, new o(SkuYataSkeletonLoadingStatus.LOADING, 0, 0));
        SkuYataQueryFetcherHolder.INSTANCE.put(r4, this);
        r5.setEntranceInfo(EcomBcmTracker.b(r6, r5.getEntranceInfo()));
        SkuPerformanceOpt.a();
        SkuCommonLog.c("SkuYataQueryFetcher", "enableClientSkuOpt so not append");
    }
}
