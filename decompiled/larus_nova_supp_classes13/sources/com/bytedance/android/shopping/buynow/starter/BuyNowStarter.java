package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowBizCode;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyOrderExParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyQueryResponseCache;
import com.bytedance.android.shopping.buynow.container.BuyNowFullscreenActivity;
import com.bytedance.android.shopping.buynow.container.BuyNowHalfScreenDialogFragment;
import com.bytedance.android.shopping.buynow.container.BuyNowSplitScreenFragment;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.controller.t;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.data.remote.ContinuePayApi;
import com.bytedance.android.shopping.buynow.data.remote.LogPB;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.slice.BuyNowTemplateMgr;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import ma3.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowStarter implements n, c53.d {
    public static final /* synthetic */ int w = 0;
    public final YataPageInfo a;
    public final pa3.a b;
    public final f c;
    public final Map<String, ? extends Object> d;
    public s e;
    public final Lazy f;
    public final com.bytedance.android.ecom.arch.slice.render.context.b g;
    public d h;
    public Function1<? super d, Unit> i;
    public boolean j;
    public Function0<Unit> k;
    public WeakReference<Object> l;
    public boolean m;
    public final String n;
    public final Uri o;
    public final sc3.b p;
    public final UltimateBuyParams q;
    public final UltimateBuyStyleParams r;
    public final la3.e s;
    public final String t;
    public final boolean u;
    public final /* synthetic */ c53.b v;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BuyNowStarter a(Uri r10, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r11, String r12, UltimateBuyParams r13, UltimateBuyStyleParams r14, la3.e r15, String r16, boolean r17) {
            if (r12 != null) goto L5;
            String r1 = UUID.randomUUID().toString();
        L7:
            return new BuyNowStarter(r1, r10, r11, r13, r14, r15, r16, r17);
        L5:
            r1 = r12;
            goto L7
        }

        public static /* synthetic */ BuyNowStarter b(Uri r10, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r11, String r12, UltimateBuyParams r13, UltimateBuyStyleParams r14, la3.e r15, String r16, int r17) {
            if ((r17 & 4) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r17 & 8) == 0) goto L9;
            UltimateBuyParams r5 = null;
        L11:
            if ((r17 & 16) == 0) goto L13;
            UltimateBuyStyleParams r6 = null;
        L15:
            if ((r17 & 32) == 0) goto L17;
            la3.e r7 = null;
        L19:
            return a(r10, r11, r4, r5, r6, r7, r16, false);
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r4 = r12;
            goto L7
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ BuyNowStarter a;

        public b(BuyNowStarter r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            SsResponse r4 = (SsResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            BuyNowStarter r0 = this.a;
            r0.j = true;
            Function0<Unit> r1 = r0.k;
            if (r1 == null) goto L5;
            Unit r2 = (Unit) r1.invoke();
        L5:
            return r4;
        }
    }

    public static final class c implements Observer<SsResponse<String>> {
        public final /* synthetic */ BuyNowStarter a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ com.bytedance.android.shopping.buynow.cache.a d;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onError(Throwable r14) {
            Intrinsics.checkNotNullParameter(r14, "e");
            if (this.a.o().f == false) goto L5;
            return;
        L5:
            BuyNowStarter r0 = this.a;
            String r2 = r0.n;
            ma3.b r4 = new ma3.b(null, 6);
            r4.d(1);
            Unit r1 = Unit.INSTANCE;
            r0.u(new d(r2, null, r4, this.c, r14, com.bytedance.android.shopping.utils.s.a(r14), 0, false, false, 384));
            if (this.b == false) goto L9;
            int r15 = SkuCommonToast.a;
            SkuCommonToast.a("商详预取极致提单Fail");
            return;
        }

        public final void onNext(Object r20) {
            final SsResponse r1 = (SsResponse) r20;
            Intrinsics.checkNotNullParameter(r1, "retrofitResponse");
            if (this.a.o().f == false) goto L5;
            Lazy r2 = BuyNowLog.a;
            BuyNowLog.b("BuyNowStarter", BuyNowStarter$loadUltimateBuyRenderData$4$onNext$1.INSTANCE);
            return;
        L5:
            Lazy r3 = BuyNowLog.a;
            BuyNowLog.b("BuyNowStarter", BuyNowStarter$loadUltimateBuyRenderData$4$onNext$2.INSTANCE);
            long r4 = System.currentTimeMillis();
            pa3.a r5 = this.a.b;
            Boolean r6 = null;
            if (r5 == null) goto L13;
            BuyNowFirstScreenMonitor r7 = r5.a;
            if (r7 == null) goto L13;
            Object r8 = r1.raw().getExtraInfo();
            if ((r8 instanceof HttpRequestInfo) == true) goto L12;
            r8 = null;
        L12:
            r7.g = (HttpRequestInfo) r8;
        L13:
            pa3.a r9 = this.a.b;
            if (r9 == null) goto L18;
            BuyNowFirstScreenMonitor r10 = r9.a;
            if (r10 == null) goto L18;
            r10.a(BuyNowFirstScreenNode.NATIVE_NET_END, r4);
        L18:
            pa3.a r11 = this.a.b;
            if (r11 == null) goto L23;
            BuyNowFirstScreenMonitor r12 = r11.a;
            if (r12 == null) goto L23;
            r12.a(BuyNowFirstScreenNode.PARSE_RESPONSE_START, System.currentTimeMillis());
        L23:
            ma3.b r13 = (ma3.b) GsonProtectorUtils.fromJson(u0.c(), (String) r1.body(), ma3.b.class);
            pa3.a r14 = this.a.b;
            if (r14 == null) goto L28;
            BuyNowFirstScreenMonitor r15 = r14.a;
            if (r15 == null) goto L28;
            r15.a(BuyNowFirstScreenNode.PARSE_RESPONSE_END, System.currentTimeMillis());
        L28:
            if (r13 == null) goto L41;
            LogPB r16 = r13.h();
            if (r16 == null) goto L41;
            Map<String, Long> r17 = r16.getServerTiming();
            if (r17 == null) goto L41;
            Iterator<Map.Entry<String, Long>> r18 = r17.entrySet().iterator();
        L35:
            if (r18.hasNext() == false) goto L41;
            Map.Entry<String, Long> r19 = r18.next();
            pa3.a r21 = this.a.b;
            if (r21 == null) goto L35;
            BuyNowFirstScreenMonitor r22 = r21.a;
            if (r22 == null) goto L35;
            String r23 = r19.getKey();
            long r110 = com.bytedance.android.shopping.extensions.k.h(r19.getValue());
            Intrinsics.checkNotNullParameter(r23, "node");
            r22.c(r23, r110);
        L41:
            if (r13 == null) goto L44;
            r6 = Boolean.valueOf(com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r13));
        L44:
            if (com.bytedance.android.shopping.extensions.k.i(r6) == false) goto L53;
            int r24 = ra3.b.a;
            if (this.b == false) goto L48;
            String r25 = "/order/component/confirmOrderPrefetch/";
        L49:
            ra3.b.a(r25, r1, r4);
            this.a.o().a();
            if (this.b == false) goto L55;
            int r26 = SkuCommonToast.a;
            SkuCommonToast.a("商详预取极致提单Success");
        L55:
            final String r27 = ma3.l.a(r1);
            pa3.a r28 = this.a.b;
            if (r28 == null) goto L60;
            BuyNowFirstScreenMonitor r29 = r28.a;
            if (r29 == null) goto L60;
            r29.a(BuyNowFirstScreenNode.REQUEST_END, System.currentTimeMillis());
        L60:
            pa3.a r30 = this.a.b;
            if (r30 == null) goto L65;
            BuyNowFirstScreenMonitor r31 = r30.a;
            if (r31 == null) goto L65;
            r31.a(BuyNowFirstScreenNode.RENDER_START, System.currentTimeMillis());
        L65:
            pa3.a r32 = this.a.b;
            if (r32 == null) goto L70;
            BuyNowFirstScreenMonitor r33 = r32.a;
            if (r33 == null) goto L70;
            r33.a(BuyNowFirstScreenNode.STANDARD_RENDER_START, System.currentTimeMillis());
        L70:
            final int r34 = ((String) r1.body()).length();
            BuyNowStarter r35 = this.a;
            r35.u(new d(r35.n, r27, r13, this.c, null, null, r34, false, false, 400));
            pa3.a r36 = this.a.b;
            if (r36 == null) goto L75;
            BuyNowFirstScreenMonitor r37 = r36.a;
            if (r37 == null) goto L75;
            BuyNowFirstScreenMonitor.b(r37, BuyNowFirstScreenNode.FETCH_END);
        L75:
            Map r38 = ECParamTrackerCenter.a;
            com.bytedance.android.ec.core.monitor.param.a r39 = ECParamTrackerCenter.c(this.a.n);
            if (r39 == null) goto L78;
            r39.l("/order/component/confirmOrder/", new BuyNowStarter$loadUltimateBuyRenderData$4$onNext$4(r27));
        L78:
            b2.b(new BuyNowStarter$loadUltimateBuyRenderData$4$onNext$5(this, r1, r27, r34));
            return;
        L48:
            r25 = "/order/component/confirmOrder/";
            goto L49
        L53:
            if (this.b == false) goto L55;
            int r40 = SkuCommonToast.a;
            SkuCommonToast.a("商详预取极致提单Fail");
            goto L55
        }

        public c(BuyNowStarter r1, boolean r2, boolean r3, com.bytedance.android.shopping.buynow.cache.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        new a();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.v.add(r2);
        return r2;
    }

    public final void doClear() {
        this.v.doClear();
    }

    public final UltimateBuyCacheQueryHelper o() {
        return (UltimateBuyCacheQueryHelper) this.f.getValue();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.v.remove(r2);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean f() {
        Uri r0 = this.o;
        if (r0 == null) goto L5;
        String r1 = r0.getHost();
    L7:
        return Intrinsics.areEqual(r1, "continue_pay");
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void release() {
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.a("BuyNowStarter", "BuyNowStarter release " + this.n);
        doClear();
        if (this.q == null) goto L8;
        Disposable r1 = o().c;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final nl.c a() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final s b() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean g() {
        return this.j;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final YataPageInfo getPageInfo() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final String getSourceBtmToken() {
        return this.t;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final d h() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final Map<String, Object> j() {
        return this.d;
    }

    public static JSONObject l(JSONObject r1) {
        if (BuyNowPerformanceOpt.j() == false) goto L11;
        if (r1 == null) goto L6;
        r1 = x0.a(r1);
    L7:
        if (r1 == null) goto L9;
        r1.remove("log_data");
    L9:
        if (r1 == null) goto L11;
        r1.remove("entrance_info");
        goto L11
    L6:
        r1 = null;
    L11:
        return r1;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void d(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "btmNode");
        this.l = new WeakReference(r2);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void e(Function1<? super d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.i = r2;
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.v.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void k(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.k = r2;
    }

    public final void t(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Lazy r1 = BuyNowLog.a;
        BuyNowLog.d("BuyNowStarter", "openDirectly, schema is " + this.o);
        int r2 = ECSdk.a;
        cj.b r3 = (cj.b) ECSdk.a(cj.b.class);
        if (r3 == null) goto L5;
        r3.e(r12);
    L5:
        EventActionImpl r4 = new EventActionImpl();
        LinkedHashMap r5 = new LinkedHashMap();
        f r6 = this.c;
        if (r6 == null) goto L10;
        Map<String, String> r7 = r6.b;
        if (r7 == null) goto L10;
        r5.putAll(r7);
    L10:
        r5.put("buynow_session_id", this.n);
        int r8 = com.bytedance.android.ec.core.buynow.d.a;
        r5.put("EVENT_PAGE_TECHNOLOGY", com.bytedance.android.ec.core.buynow.d.a(this.o));
        Uri r9 = this.o;
        if (r9 == null) goto L17;
        String r10 = UriProtector.getQueryParameter(r9, "eztf_sdk_extra");
        if (r10 == null) goto L17;
        JSONObject r11 = z1.g(r10);
        if (r11 == null) goto L17;
        Object r13 = r11.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
    L18:
        r5.put("eztf_source_page", r13);
        r4.doEventAction("enter_buynow_page", r5);
        if (this.q == null) goto L21;
        Map r14 = ECParamTrackerCenter.a;
        ECParamTrackerCenter.d("UltimateBuy", this.n);
    L22:
        Uri r15 = this.o;
        if (r15 == null) goto L27;
        com.bytedance.android.ec.core.monitor.param.a r16 = ECParamTrackerCenter.c(this.n);
        if (r16 == null) goto L27;
        r16.a(r15);
    L27:
        com.bytedance.android.ec.core.monitor.param.a r17 = ECParamTrackerCenter.c(this.n);
        if (r17 == null) goto L30;
        r17.b(new BuyNowStarter$trackEnterPage$3(this));
    L30:
        b2.b(new BuyNowStarter$reportSchema$1(this));
        pa3.a r18 = this.b;
        if (r18 == null) goto L38;
        BuyNowFirstScreenMonitor r19 = r18.a;
        if (r19 == null) goto L38;
        Intrinsics.checkNotNullParameter(MonitorScenes.EC_PERF_PAGE_START_BUY_NOW, "scene");
        if (r19.f == true) goto L38;
        r19.f = true;
    L38:
        pa3.a r20 = this.b;
        if (r20 == null) goto L43;
        BuyNowFirstScreenMonitor r21 = r20.a;
        if (r21 == null) goto L43;
        r21.a(BuyNowFirstScreenNode.INITIAL, System.currentTimeMillis());
    L43:
        pa3.a r22 = this.b;
        if (r22 == null) goto L48;
        BuyNowFirstScreenMonitor r23 = r22.a;
        if (r23 == null) goto L48;
        r23.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_START, System.currentTimeMillis());
    L48:
        pa3.a r24 = this.b;
        if (r24 == null) goto L53;
        BuyNowFirstScreenMonitor r25 = r24.a;
        if (r25 == null) goto L53;
        r25.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_END, System.currentTimeMillis());
    L53:
        i(r12, true);
        int r26 = BuyNowTemplateMgr.a;
        if (this.q == null) goto L57;
        BuyNowBizCode r27 = BuyNowBizCode.YATA_SKUBUY;
    L60:
        BuyNowTemplateMgr.a(r12, r27, true);
        if (ja3.a.c(this.c) == false) goto L63;
        com.bytedance.android.shopping.buynow.opt.a.a(r12);
    L63:
        f r28 = this.c;
        BuyNowLog.a("BuyNowStarter", "presentNativeBuyNow");
        IAdapterService r29 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r29 == null) goto L68;
        com.bytedance.android.ec.adapter.api.j r30 = r29.getLiveWindowService();
        if (r30 == null) goto L68;
        r30.stopShowFloatInNextLifecycle();
    L68:
        pa3.a r31 = this.b;
        if (r31 == null) goto L73;
        BuyNowFirstScreenMonitor r32 = r31.a;
        if (r32 == null) goto L73;
        r32.a(BuyNowFirstScreenNode.CONTAINER_INIT_START, System.currentTimeMillis());
    L73:
        UltimateBuyParams r33 = this.q;
        if (r33 == null) goto L77;
        int r34 = BuyNowHalfScreenDialogFragment.f;
        BuyNowHalfScreenDialogFragment.a.c(r12, r33, this.n, this.r, this.s, this.t, this.o, null, 0, 384);
        return;
    L77:
        if (this.m == false) goto L82;
        int r35 = BuyNowSplitScreenFragment.f;
        BuyNowSplitScreenFragment.a.a(this.n, this.o, null, this.t);
        nj.d r36 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r36 == null) goto L95;
        ECHybridExtensionsKt.a(r12);
        r36.k();
        return;
    L95:
        return;
    L82:
        if (ja3.a.c(r28) == false) goto L92;
        int r37 = BuyNowHalfScreenDialogFragment.f;
        String r38 = this.n;
        Uri r39 = this.o;
        if (r28 == null) goto L90;
        Map<String, String> r40 = r28.b;
        if (r40 == null) goto L90;
        String r41 = r40.get("mask_alpha");
        if (r41 == null) goto L90;
        Float r42 = Float.valueOf(CastFloatProtector.parseFloat(r41));
    L91:
        BuyNowHalfScreenDialogFragment.a.b(r12, r38, r39, r42, null, p(r28, r12), this.t);
        return;
    L90:
        r42 = null;
        goto L91
    L92:
        int r43 = BuyNowFullscreenActivity.k;
        BuyNowFullscreenActivity.a.a(r12, this.n, this.o, null, this.t);
        return;
    L57:
        if (ja3.a.b(this.o) == false) goto L59;
        r27 = BuyNowBizCode.CONTINUE_PAY;
        goto L60
    L59:
        r27 = BuyNowBizCode.BUY;
        goto L60
    L21:
        Map r44 = ECParamTrackerCenter.a;
        ECParamTrackerCenter.d("BuyNow", this.n);
    L17:
        r13 = null;
        goto L18
    }

    public final void u(d r2) {
        this.h = r2;
        if (r2 == null) goto L8;
        Function1<? super d, Unit> r0 = this.i;
        if (r0 == null) goto L9;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void c(Context r4, com.bytedance.android.shopping.sku.common.data.e r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "nextData");
        if (this.q == null) goto L12;
        f r6 = this.c;
        if (r6 == null) goto L9;
        Map<String, String> r7 = r6.b;
        if (r7 == null) goto L9;
        String r8 = r7.get("enter_from_live_saas");
    L10:
        boolean r9 = Intrinsics.areEqual(String.valueOf(r8), "1");
        int r0 = ja3.a.a(this.c);
        o().query(r9, r5, r0, new BuyNowStarter$reFetchQueryByCacheOperation$1(this));
        return;
    L9:
        r8 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void i(Context r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        if (this.q == null) goto L6;
        s(r21, r22, false);
        return;
    L6:
        if (ja3.a.b(this.o) == false) goto L50;
        Lazy r3 = BuyNowLog.a;
        BuyNowLog.a("BuyNowStarter", "loadContinuePayRenderData " + r22);
        pa3.a r4 = this.b;
        if (r4 == null) goto L13;
        BuyNowFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L13;
        r5.a(BuyNowFirstScreenNode.REQUEST_START, System.currentTimeMillis());
    L13:
        f r6 = this.c;
        if (r6 == null) goto L18;
        Map<String, String> r7 = r6.b;
        if (r7 == null) goto L18;
        String r8 = r7.get("enter_from_live_saas");
    L19:
        boolean r9 = Intrinsics.areEqual(String.valueOf(r8), "1");
        pa3.a r10 = this.b;
        if (r10 == null) goto L24;
        BuyNowFirstScreenMonitor r11 = r10.a;
        if (r11 == null) goto L24;
        r11.a(BuyNowFirstScreenNode.QUERY_PARAM_START, System.currentTimeMillis());
    L24:
        JSONObject r12 = new JSONObject();
        r12.put("biometric_params", "1");
        TTCJPayUtils.Companion r1 = TTCJPayUtils.Companion;
        r12.put("is_jailbreak", r1.getInstance().getJailBreak());
        r12.put("cj_sdk", r1.getInstance().getSDKVersion());
        r12.put("bio_type", r1.getInstance().getBioType());
        int r2 = p.a;
        r12.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r13 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r12.put("cj_pass_through_info", "");
        Pair[] r14 = new Pair[2];
        r14[0] = TuplesKt.to("buy_now_page_type", PageType.CONTINUEPAY);
        f r15 = this.c;
        if (r15 == null) goto L29;
        Map<String, String> r16 = r15.b;
        if (r16 == null) goto L29;
        String r17 = r16.get("eztf_sdk_extra");
    L30:
        r14[1] = TuplesKt.to("eztf_source_page", com.bytedance.android.shopping.extensions.k.j(r17));
        MapsKt.mapOf(r14);
        p.a();
        r12.put("finance_risk", null);
        String r18 = r12.toString();
        f r19 = this.c;
        if (r19 == null) goto L33;
        Map<String, String> r20 = r19.b;
    L34:
        ma3.h r23 = new ma3.h(com.bytedance.android.shopping.extensions.k.x(m(r20, false, false)), r18, n(r21, null), 28);
        int r24 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r25 = com.bytedance.android.shopping.buynow.utils.e.b(r9);
        pa3.a r26 = this.b;
        if (r26 == null) goto L39;
        BuyNowFirstScreenMonitor r27 = r26.a;
        if (r27 == null) goto L39;
        r27.a(BuyNowFirstScreenNode.QUERY_PARAM_END, System.currentTimeMillis());
    L39:
        pa3.a r28 = this.b;
        if (r28 == null) goto L44;
        BuyNowFirstScreenMonitor r29 = r28.a;
        if (r29 == null) goto L44;
        BuyNowFirstScreenMonitor.b(r29, BuyNowFirstScreenNode.FETCH_START);
    L44:
        pa3.a r30 = this.b;
        if (r30 == null) goto L49;
        BuyNowFirstScreenMonitor r31 = r30.a;
        if (r31 == null) goto L49;
        r31.a(BuyNowFirstScreenNode.NATIVE_NET_START, System.currentTimeMillis());
    L49:
        na3.g r32 = na3.g.a;
        Intrinsics.checkNotNullParameter(r23, "req");
        ContinuePayApi.a.getClass();
        ContinuePayApi.a.a.getContinuePayQuery(r23, r24, r25).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r22));
        return;
    L33:
        r20 = null;
    L29:
        r17 = null;
    L18:
        r8 = null;
        goto L19
    L50:
        nj.d r110 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r110 == null) goto L53;
        r110.l();
    L53:
        this.m = false;
        pa3.a r33 = this.b;
        if (r33 == null) goto L59;
        BuyNowFirstScreenMonitor r34 = r33.a;
        if (r34 == null) goto L59;
        r34.a(BuyNowFirstScreenNode.REQUEST_START, System.currentTimeMillis());
    L59:
        f r35 = this.c;
        if (r35 == null) goto L64;
        Map<String, String> r36 = r35.b;
        if (r36 == null) goto L64;
        String r37 = r36.get("enter_from_live_saas");
    L65:
        boolean r38 = Intrinsics.areEqual(String.valueOf(r37), "1");
        pa3.a r39 = this.b;
        if (r39 == null) goto L71;
        BuyNowFirstScreenMonitor r40 = r39.a;
        if (r40 == null) goto L71;
        r40.a(BuyNowFirstScreenNode.QUERY_PARAM_START, System.currentTimeMillis());
    L71:
        if (BuyNowPerformanceOpt.h() == true) goto L80;
        Pair[] r41 = new Pair[2];
        r41[0] = TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW);
        f r42 = this.c;
        if (r42 == null) goto L78;
        Map<String, String> r43 = r42.b;
        if (r43 == null) goto L78;
        String r44 = r43.get("eztf_sdk_extra");
    L79:
        r41[1] = TuplesKt.to("eztf_source_page", com.bytedance.android.shopping.extensions.k.j(r44));
        MapsKt.mapOf(r41);
        p.a();
    L78:
        r44 = null;
    L80:
        f r45 = this.c;
        if (r45 == null) goto L83;
        String r46 = r45.d;
    L84:
        String r47 = n(r21, r46);
        f r48 = this.c;
        if (r48 == null) goto L87;
        Map<String, String> r49 = r48.b;
    L88:
        String r50 = com.bytedance.android.shopping.extensions.k.x(m(r49, true, false));
        f r51 = this.c;
        if (r51 == null) goto L91;
        JSONObject r52 = r51.c;
    L92:
        JSONObject r53 = l(r52);
        if (r53 == null) goto L95;
        String r54 = r53.toString();
    L96:
        JSONObject r55 = new JSONObject();
        r55.put("biometric_params", "1");
        TTCJPayUtils.Companion r56 = TTCJPayUtils.Companion;
        r55.put("is_jailbreak", r56.getInstance().getJailBreak());
        r55.put("cj_sdk", r56.getInstance().getSDKVersion());
        r55.put("bio_type", r56.getInstance().getBioType());
        int r57 = p.a;
        r55.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r58 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r55.put("cj_pass_through_info", "");
        r55.put("finance_risk", null);
        Unit r59 = Unit.INSTANCE;
        ma3.e r60 = new ma3.e(r47, r50, r54, r55.toString());
        PackYataSdkConfig r61 = com.bytedance.kmp.ec.yata.common.init.b.a;
        ma3.d r62 = new ma3.d(r60, this.a.addAndGetYataProtocolInfo());
        int r63 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r64 = com.bytedance.android.shopping.buynow.utils.e.b(r38);
        int r65 = ja3.a.a(this.c);
        pa3.a r66 = this.b;
        if (r66 == null) goto L101;
        BuyNowFirstScreenMonitor r67 = r66.a;
        if (r67 == null) goto L101;
        r67.a(BuyNowFirstScreenNode.QUERY_PARAM_END, System.currentTimeMillis());
    L101:
        pa3.a r68 = this.b;
        if (r68 == null) goto L106;
        BuyNowFirstScreenMonitor r69 = r68.a;
        if (r69 == null) goto L106;
        BuyNowFirstScreenMonitor.b(r69, BuyNowFirstScreenNode.FETCH_START);
    L106:
        pa3.a r70 = this.b;
        if (r70 == null) goto L111;
        BuyNowFirstScreenMonitor r71 = r70.a;
        if (r71 == null) goto L111;
        r71.a(BuyNowFirstScreenNode.NATIVE_NET_START, System.currentTimeMillis());
    L111:
        na3.g.a.query(r62, r63, r64, Integer.valueOf(r65)).subscribeOn(Schedulers.newThread()).map(new g(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r22));
        return;
    L95:
        r54 = null;
        goto L96
    L91:
        r52 = null;
        goto L92
    L87:
        r49 = null;
        goto L88
    L83:
        r46 = null;
    L64:
        r37 = null;
        goto L65
    }

    public final String n(Context r12, String r13) {
        JSONObject r0 = new JSONObject();
        r0.put("user_id", r.a.getCurrentUserId());
        ECAppInfoService r1 = ECAppInfoService.e;
        r0.put("device_id", r1.getServerDeviceId());
        r0.put("app_id", r1.getAppId());
        r0.put("app_version", r1.getAppVersionName());
        String r2 = r1.getAppVersion();
        String r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = StringsKt.toIntOrNull(r2);
    L6:
        r0.put("version_code", r4);
        r0.put("os", "android");
        r0.put("page_type", "yata_android");
        r0.put("hide_pwd_confirm", com.bytedance.android.shopping.extensions.k.n(ka3.b.a(r12, "HIDE_NO_PWD_CONFIRM"), false));
        JSONObject r5 = new JSONObject();
        r5.put("bottom_offset", 0);
        r5.put("system_navigation_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(k1.e(r12)), this.g)));
        r5.put("iesec_buy_now_opt_footer_margin", ((Boolean) ECSettingKeys.a.getValue()).booleanValue());
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        if (this.m == false) goto L10;
        int r8 = com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(j56.a.b(r12)));     // Catch: Throwable -> L13
        float r9 = this.g.a;     // Catch: Throwable -> L13
        Resources r10 = Resources.getSystem();     // Catch: Throwable -> L13
        float r11 = r8;
        int r14 = SlcDimensExtensionsKt.a(Float.valueOf(r11 + (28 - (22 * (r9 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density)))), this.g);     // Catch: Throwable -> L13
    L11:
        Object r15 = Result.constructor-impl(Integer.valueOf(r14));     // Catch: Throwable -> L13
    L15:
        Result.isFailure-impl(r15);
        if (Result.isFailure-impl(r15) == false) goto L18;
        r15 = 0;
    L18:
        r5.put("status_bar_height", Float.valueOf(SlcDimensExtensionsKt.d((Number) r15, this.g)));
        r5.put("bottom_bar_height", 0);
        Unit r16 = Unit.INSTANCE;
        r0.put("client_params", r5);
        if (r13 == null) goto L21;
        r0.put("entrance_info", r13);
    L21:
        r0.put("buynow_session_id", this.n);
        int r17 = com.bytedance.android.shopping.buynow.utils.r.a;
        ECAppInfoService r18 = ECAppInfoService.e;
        r0.put("is_accessible", com.bytedance.android.shopping.buynow.utils.r.c(r18.getApplicationContext()));
        r0.put("systemFontScale", r18.getCurrentFontScale());
        JSONObject r6 = new JSONObject();
        r6.put("page_type", "YATA_Android");
        String r19 = r18.getAppVersion();
        if (r19 == null) goto L24;
        Integer r20 = StringsKt.toIntOrNull(r19);
    L25:
        r6.put("version_code", r20);
        r6.put("app_id", r18.getAppId());
        PackYataSdkConfig r110 = com.bytedance.kmp.ec.yata.common.init.b.a;
        r6.put("yata_version", "1.23.7");
        r6.put("slice_version", "2.34");
        r0.put("client_version", r6);
        if (this.q == null) goto L65;
        UltimateBuyStyleParams r111 = this.r;
        if (r111 == null) goto L30;
        int r112 = r111.getHeightPercent();
    L31:
        f r21 = this.c;
        if (r21 == null) goto L36;
        Map<String, String> r22 = r21.b;
        if (r22 == null) goto L36;
        String r23 = r22.get("scene_type");
    L37:
        f r24 = this.c;
        if (r24 == null) goto L42;
        Map<String, String> r25 = r24.b;
        if (r25 == null) goto L42;
        r3 = r25.get("force_height");
    L42:
        int r26 = com.bytedance.android.shopping.extensions.k.r(r3, 0);
        if (BuyNowPerformanceOpt.m() == false) goto L46;
    L60:
        r112 = 88;
    L62:
        if (r112 <= 80) goto L64;
        r112 = 80;
    L64:
        r0.put("height_percent", r112);
        r0.put("sub_height_percent", SkuBuyNowPanelHeightHelper.b().getSubHeightPercent());
    L66:
        boolean r113 = this.m;
        if (r113 == false) goto L73;
        KtSafeMethodExtensionKt.safePut(r0, "is_split_screen", Boolean.valueOf(r113));
        nj.d r114 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r114 == null) goto L71;
        l0.c(r12);
        r114.g();
    L71:
        KtSafeMethodExtensionKt.safePut(r0, "is_split_screen_open", false);
        KtSafeMethodExtensionKt.safePut(r0, "force_full_screen", Boolean.valueOf(this.m));
    L73:
        return r0.toString();
    L46:
        if (BuyNowPerformanceOpt.p() == false) goto L51;
        ECSettingKeys.j.getClass();
        if (CollectionsKt.contains(ECSettingKeys.W(), r23) == false) goto L62;
    L51:
        if (BuyNowPerformanceOpt.o() == false) goto L56;
        ECSettingKeys.j.getClass();
        if (CollectionsKt.contains(ECSettingKeys.W(), r23) == true) goto L62;
    L56:
        if (BuyNowPerformanceOpt.n() == false) goto L59;
        if (r26 == 1) goto L62;
    L59:
        if (r26 != 1) goto L62;
    L36:
        r23 = null;
        goto L37
    L30:
        r112 = 73;
        goto L31
    L65:
        r0.put("height_percent", Float.valueOf(p(this.c, r12)));
        goto L66
    L24:
        r20 = null;
        goto L25
    L10:
        r14 = eh.b.b(r12);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r4 = null;
        goto L6
    }

    public final float p(f r4, Context r5) {
        String r2 = null;
        if (ja3.a.b(this.o) == false) goto L26;
        if (r4 == null) goto L8;
        Map<String, String> r0 = r4.b;
        if (r0 == null) goto L8;
        String r1 = r0.get("height_percent");
    L10:
        if ((r1 instanceof String) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L16;
        Float r3 = StringsKt.toFloatOrNull(r1);
        if (r3 == null) goto L16;
        float r6 = r3.floatValue();
    L37:
        return r6 / 100.0f;
    L16:
        if (r4 == null) goto L20;
        Map<String, String> r7 = r4.b;
        if (r7 == null) goto L20;
        String r8 = r7.get("height");
    L22:
        if ((r8 instanceof String) == false) goto L25;
        r2 = r8;
    L25:
        float r9 = com.bytedance.android.shopping.extensions.k.p(r2, 470.0f);
        Resources r10 = r5.getResources();
        r6 = ((r9 * WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density) / com.bytedance.android.shopping.buynow.utils.g.a(r5).b) * 100;
    L20:
        r8 = null;
    L8:
        r1 = null;
        goto L10
    L26:
        if (r4 == null) goto L30;
        Map<String, String> r11 = r4.b;
        if (r11 == null) goto L30;
        String r12 = r11.get("height_percent");
    L32:
        if ((r12 instanceof String) == false) goto L35;
        r2 = r12;
    L35:
        r6 = com.bytedance.android.shopping.extensions.k.p(r2, 73.0f);
    L30:
        r12 = null;
        goto L32
    }

    public final Map<String, String> m(Map<String, String> r5, boolean r6, boolean r7) {
        IECAIHostService r1 = null;
        if (BuyNowPerformanceOpt.j() == false) goto L10;
        if (r5 == null) goto L8;
        r5 = MapsKt.toMutableMap(r5);
        if (r5 == null) goto L8;
        r5.remove("mega_object");
        r5.remove("buynow_time");
        r5.remove("log_data");
        r5.remove("entrance_info");
    L8:
        r5 = null;
    L10:
        if (TypeIntrinsics.isMutableMap(r5) == true) goto L12;
        Map<String, String> r0 = null;
    L13:
        if (r0 != null) goto L16;
        r0 = new LinkedHashMap();
    L16:
        if ((!Intrinsics.areEqual(r0, r5)) == false) goto L19;
        if (r5 == null) goto L19;
        r0.putAll(r5);
    L19:
        if (r7 == false) goto L21;
        r0.put("sku_unique_id", this.n);
    L21:
        if (r6 == false) goto L34;
        int r8 = ECSdk.a;
        IAddressService r9 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r9 == null) goto L31;
        WeakReference<Object> r10 = this.l;
        if (r10 == null) goto L27;
        Object r11 = r10.get();
    L28:
        o83.a r12 = IAddressService.a.a(r9, r11, "a1.b7411.c0.d0", 4);
        if (r12 == null) goto L31;
        String r13 = r12.a(true, null, null).toString();
    L32:
        if (r13 == null) goto L34;
        String r14 = r0.put("ec_address_data", r13);
        goto L34
    L27:
        r11 = null;
    L31:
        r13 = null;
    L34:
        int r15 = ECSdk.a;
        IECHostService r16 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r16 == null) goto L37;
        r1 = r16.getECHostAIService();
    L37:
        Pair[] r17 = new Pair[2];
        int r18 = 0;
        if (r1 != null) goto L40;
    L42:
        int r19 = 0;
    L43:
        r17[0] = TuplesKt.to("is_in_applet", Integer.valueOf(r19));
        if (r1 != null) goto L46;
    L48:
        r17[1] = TuplesKt.to("is_in_first_applet_page", Integer.valueOf(r18));
        r0.put("saas_extra_info", com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mapOf(r17)));
        return r0;
    L46:
        if (r1.isGoToLandingPage() != true) goto L48;
        r18 = 1;
        goto L48
    L40:
        if (r1.isInApplet() != true) goto L42;
        r19 = 1;
        goto L43
    L12:
        r0 = r5;
        goto L13
    }

    public final Pair<ma3.r, Map<String, String>> q(Context r13, String r14, boolean r15) {
        UltimateBuyParams r0 = this.q;
        Integer r2 = null;
        if (r0 == null) goto L7;
        Map<String, Object> r1 = r0.getSkuExParams();
        if (r1 == null) goto L7;
        Object r3 = r1.get("sku_schema_param");
    L9:
        if (TypeIntrinsics.isMutableMap(r3) == true) goto L11;
        r3 = null;
    L11:
        Map r4 = (Map) r3;
        String r16 = n(r13, r14);
        if (r4 == null) goto L14;
        Object r17 = r4.get("order_params");
    L16:
        if (TypeIntrinsics.isMutableMap(r17) == true) goto L18;
        r17 = null;
    L18:
        Map r18 = (Map) r17;
        if (r18 == null) goto L21;
        r18.put("extra_info", r16);
        r16 = null;
    L21:
        if (r15 == false) goto L41;
        UltimateBuyParams r19 = this.q;
        if (r19 == null) goto L27;
        Map<String, Object> r110 = r19.getSkuExParams();
        if (r110 == null) goto L27;
        Object r111 = r110.get("sku_schema_param");
    L29:
        if (TypeIntrinsics.isMutableMap(r111) == true) goto L31;
        r111 = null;
    L31:
        Map r112 = (Map) r111;
        if (r112 == null) goto L34;
        Object r113 = r112.get("client_params");
    L36:
        if (TypeIntrinsics.isMutableMap(r113) == true) goto L38;
        r113 = null;
    L38:
        Map r114 = (Map) r113;
        if (r114 == null) goto L41;
        r114.put("has_used_client_cache", Boolean.TRUE);
        goto L41
    L34:
        r113 = null;
    L27:
        r111 = null;
    L41:
        f r115 = this.c;
        if (r115 == null) goto L44;
        Map<String, String> r116 = r115.b;
    L45:
        Map<String, String> r117 = m(r116, true, false);
        String r5 = com.bytedance.android.shopping.extensions.k.x(r117);
        f r6 = this.c;
        if (r6 == null) goto L48;
        JSONObject r7 = r6.c;
    L49:
        JSONObject r8 = l(r7);
        if (r8 == null) goto L52;
        String r9 = r8.toString();
    L53:
        UltimateBuyParams r10 = this.q;
        if (r10 == null) goto L58;
        UltimateBuyOrderExParams r11 = r10.getOrderExParams();
        if (r11 == null) goto L58;
        String r12 = r11.getCjInfo();
    L59:
        ma3.e r20 = new ma3.e(r16, r5, r9, r12);
        UltimateBuyParams r118 = this.q;
        if (r118 == null) goto L62;
        Map<? extends String, ? extends Object> r119 = r118.getSkuExParams();
    L64:
        if (TypeIntrinsics.isMutableMap(r119) == true) goto L66;
        Map<String, Object> r21 = null;
    L67:
        if (r21 != null) goto L69;
        r21 = new LinkedHashMap();
    L69:
        Map<String, Object> r22 = r21;
        if ((!Intrinsics.areEqual(r22, r119)) == false) goto L73;
        if (r119 == null) goto L73;
        r22.putAll(r119);
    L73:
        int r120 = ECSdk.a;
        IAddressService r121 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r121 == null) goto L84;
        WeakReference<Object> r23 = this.l;
        if (r23 == null) goto L78;
        Object r24 = r23.get();
    L79:
        o83.a r122 = IAddressService.a.a(r121, r24, "a1.b7411.c0.d0", 4);
        if (r122 == null) goto L84;
        String r123 = r122.a(true, null, null).toString();
        if (r123 == null) goto L84;
        r22.put("address_detail", r123);
        goto L84
    L78:
        r24 = null;
    L84:
        r22.put("sku_unique_id", this.n);
        UltimateBuyParams r124 = this.q;
        if (r124 == null) goto L87;
        Integer r25 = Integer.valueOf(r124.getUltimateBuyType());
    L88:
        UltimateBuyParams r125 = this.q;
        if (r125 == null) goto L91;
        r2 = Integer.valueOf(r125.isSingleSku());
    L91:
        PackYataSdkConfig r126 = com.bytedance.kmp.ec.yata.common.init.b.a;
        return TuplesKt.to(new ma3.r(r20, r22, r25, null, r2, "1.23.7", this.a.addAndGetYataProtocolInfo(), 276), r117);
    L87:
        r25 = null;
        goto L88
    L66:
        r21 = r119;
        goto L67
    L62:
        r119 = null;
    L58:
        r12 = null;
        goto L59
    L52:
        r9 = null;
        goto L53
    L48:
        r7 = null;
        goto L49
    L44:
        r116 = null;
        goto L45
    L14:
        r17 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final Pair<ma3.r, Map<String, String>> r(Context r13, String r14, boolean r15) {
        f r0 = this.c;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Map<String, String> r2 = r0.b;
    L6:
        Map<String, String> r3 = m(r2, true, true);
        SkuYataSelfSaveBizFieldsCacheController.a r4 = SkuYataSelfSaveBizFieldsCacheController.a;
        String r5 = r3.get("id");
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        Map r6 = SkuYataSelfSaveBizFieldsCacheController.a(r5);
        if (r6 == null) goto L12;
        r3.put("sku_last_biz_fields", com.bytedance.android.ec.hybrid.list.util.k.d(r6));
    L12:
        if (r15 == false) goto L15;
        r3.put("has_used_client_cache", "true");
    L15:
        if (BuyNowPerformanceOpt.h() == true) goto L24;
        Pair[] r16 = new Pair[2];
        r16[0] = TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW);
        f r7 = this.c;
        if (r7 == null) goto L22;
        Map<String, String> r8 = r7.b;
        if (r8 == null) goto L22;
        String r9 = r8.get("eztf_sdk_extra");
    L23:
        r16[1] = TuplesKt.to("eztf_source_page", com.bytedance.android.shopping.extensions.k.j(r9));
        MapsKt.mapOf(r16);
        p.a();
    L22:
        r9 = null;
    L24:
        String r17 = n(r13, r14);
        String r18 = com.bytedance.android.shopping.extensions.k.x(r3);
        f r19 = this.c;
        if (r19 == null) goto L27;
        JSONObject r110 = r19.c;
    L28:
        JSONObject r111 = l(r110);
        if (r111 == null) goto L31;
        String r112 = r111.toString();
    L32:
        JSONObject r10 = new JSONObject();
        r10.put("biometric_params", "1");
        TTCJPayUtils.Companion r11 = TTCJPayUtils.Companion;
        r10.put("is_jailbreak", r11.getInstance().getJailBreak());
        r10.put("cj_sdk", r11.getInstance().getSDKVersion());
        r10.put("bio_type", r11.getInstance().getBioType());
        int r12 = p.a;
        r10.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r20 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r10.put("cj_pass_through_info", "");
        r10.put("finance_risk", null);
        Unit r21 = Unit.INSTANCE;
        ma3.e r22 = new ma3.e(r17, r18, r112, r10.toString());
        UltimateBuyParams r113 = this.q;
        if (r113 == null) goto L35;
        Integer r23 = Integer.valueOf(r113.getUltimateBuyType());
    L36:
        UltimateBuyParams r114 = this.q;
        if (r114 == null) goto L39;
        Integer r24 = r114.getUltimateBuyVersion();
    L40:
        UltimateBuyParams r115 = this.q;
        if (r115 == null) goto L43;
        r1 = Integer.valueOf(r115.isSingleSku());
    L43:
        PackYataSdkConfig r116 = com.bytedance.kmp.ec.yata.common.init.b.a;
        return TuplesKt.to(new ma3.r(r22, null, r23, r24, r1, "1.23.7", this.a.addAndGetYataProtocolInfo(), 262), r3);
    L39:
        r24 = null;
        goto L40
    L35:
        r23 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L27:
        r110 = null;
        goto L28
    L5:
        r2 = null;
        goto L6
    }

    public final ma3.r s(Context r25, boolean r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Lazy r6 = BuyNowLog.a;
        BuyNowLog.d("BuyNowStarter", "isFirstRequest:" + r26 + ", forDiff: " + this.u + ", forPrefetch: " + r27);
        pa3.a r7 = this.b;
        if (r7 == null) goto L7;
        BuyNowFirstScreenMonitor r8 = r7.a;
        if (r8 == null) goto L7;
        r8.a(BuyNowFirstScreenNode.REQUEST_START, System.currentTimeMillis());
    L7:
        f r9 = this.c;
        if (r9 == null) goto L12;
        Map<String, String> r10 = r9.b;
        if (r10 == null) goto L12;
        String r11 = r10.get("enter_from_live_saas");
    L13:
        boolean r12 = Intrinsics.areEqual(String.valueOf(r11), "1");
        pa3.a r13 = this.b;
        if (r13 == null) goto L18;
        BuyNowFirstScreenMonitor r14 = r13.a;
        if (r14 == null) goto L18;
        r14.a(BuyNowFirstScreenNode.QUERY_PARAM_START, System.currentTimeMillis());
    L18:
        boolean r15 = false;
        if (this.u == true) goto L21;
        int r16 = com.bytedance.android.shopping.buynow.utils.e.a();
        int r17 = com.bytedance.android.shopping.buynow.utils.e.b(r12);
        f r18 = this.c;
        if (r18 == null) goto L37;
        com.bytedance.android.shopping.buynow.cache.a r19 = r18.a;
    L38:
        if (r27 == true) goto L55;
        if (r26 == false) goto L55;
        dm.a.a("BuyNowPrefetcher").a("queryBuyNow cache key " + r19);     // Catch: Exception -> L52
        Map<String, UltimateBuyCacheQueryHelper> r5 = UltimateBuyCacheHelper.b;     // Catch: Exception -> L52
        q r20 = UltimateBuyCacheHelper.c(r19);     // Catch: Exception -> L52
        if (r20 != null) goto L97;
    L50:
        BuyNowLog.d("BuyNowPrefetcher", "hitCache = " + r15);     // Catch: Exception -> L52
        goto L55
    L97:
        this.j = true;     // Catch: Exception -> L48
        Function0<Unit> r110 = this.k;     // Catch: Exception -> L48
        if (r110 == null) goto L46;
        Unit r111 = (Unit) r110.invoke();     // Catch: Exception -> L48
    L46:
        u(new d(this.n, r20.b, r20.a, true, null, null, r20.d, true, r20.e, 16));     // Catch: Exception -> L48
        o().d = this.h;     // Catch: Exception -> L48
        r15 = true;
    L48:
        e = e;
        r15 = true;
    L53:
        ECExceptionMonitor.e(e);
    L52:
        e = e;
    L55:
        if (this.o != null) goto L61;
        f r0 = this.c;
        if (r0 == null) goto L59;
        String r1 = r0.d;
    L60:
        Pair<ma3.r, Map<String, String>> r2 = q(r25, r1, r15);
    L66:
        final ma3.r r3 = (ma3.r) r2.getFirst();
        UltimateBuyCacheQueryHelper r4 = o();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "ultimateBuyRequestPair");
        r4.b = r19;
        r4.a = r2;
        if (r27 == false) goto L69;
        Map<String, UltimateBuyCacheQueryHelper> r21 = UltimateBuyCacheHelper.b;
        EventActionImpl r22 = new EventActionImpl();
        LinkedHashMap r23 = new LinkedHashMap();
        r23.put("type", "ultimate_buy_prefetch");
        r22.doEventAction("sku_cache_monitor", r23);
    L69:
        pa3.a r24 = this.b;
        if (r24 == null) goto L74;
        BuyNowFirstScreenMonitor r28 = r24.a;
        if (r28 == null) goto L74;
        r28.a(BuyNowFirstScreenNode.QUERY_PARAM_END, System.currentTimeMillis());
    L74:
        pa3.a r29 = this.b;
        if (r29 == null) goto L79;
        BuyNowFirstScreenMonitor r30 = r29.a;
        if (r30 == null) goto L79;
        BuyNowFirstScreenMonitor.b(r30, BuyNowFirstScreenNode.FETCH_START);
    L79:
        pa3.a r31 = this.b;
        if (r31 == null) goto L84;
        BuyNowFirstScreenMonitor r32 = r31.a;
        if (r32 == null) goto L84;
        r32.a(BuyNowFirstScreenNode.NATIVE_NET_START, System.currentTimeMillis());
    L84:
        Map r33 = ECParamTrackerCenter.a;
        com.bytedance.android.ec.core.monitor.param.a r34 = ECParamTrackerCenter.c(this.n);
        if (r34 == null) goto L87;
        r34.l("/order/component/confirmOrder/", new BuyNowStarter$loadUltimateBuyRenderData$2(r3));
    L87:
        na3.g r35 = na3.g.a;
        f r36 = this.c;
        if (r36 == null) goto L92;
        String r37 = r36.getQueryParam("shape");
        if (r37 == null) goto L92;
        Integer r38 = StringsKt.toIntOrNull(r37);
    L93:
        na3.g.d(r3, r16, r17, r38, r27, null, 32).subscribeOn(Schedulers.newThread()).map(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r27, r26, r19));
        return r3;
    L92:
        r38 = null;
        goto L93
    L59:
        r1 = null;
        goto L60
    L61:
        f r39 = this.c;
        if (r39 == null) goto L64;
        String r40 = r39.d;
    L65:
        r2 = r(r25, r40, r15);
        goto L66
    L64:
        r40 = null;
        goto L65
    L37:
        r19 = null;
        goto L38
    L21:
        if (this.o != null) goto L27;
        f r41 = this.c;
        if (r41 == null) goto L25;
        String r42 = r41.d;
    L26:
        Pair<ma3.r, Map<String, String>> r43 = q(r25, r42, false);
    L32:
        BuyNowLog.a("BuyNowStarter", "forDiff so return");
        int r44 = k.a;
        k.c(this.n);
        return (ma3.r) r43.getFirst();
    L25:
        r42 = null;
        goto L26
    L27:
        f r45 = this.c;
        if (r45 == null) goto L30;
        String r46 = r45.d;
    L31:
        r43 = r(r25, r46, false);
        goto L32
    L30:
        r46 = null;
    L12:
        r11 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12, types: [com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    public BuyNowStarter(String r19, final Uri r20, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r21, UltimateBuyParams r22, UltimateBuyStyleParams r23, la3.e r24, String r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        this.v = new c53.b();
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        this.t = r25;
        this.u = r26;
        boolean r5 = ECSettingKeys.d();
        if (r22 == null) goto L9;
        Map r9 = BuyNowPerformanceOpt.g();
        if (r9 == null) goto L7;
        Object r10 = r9.get("ec_sku_buy_disable_compress");
    L8:
        boolean r11 = Intrinsics.areEqual(r10, 1);
    L10:
        this.a = new YataPageInfo(r5, r11, r19);
        this.f = LazyKt.lazy(new BuyNowStarter$cacheQueryHelper$2(this));
        if (r22 != null) goto L13;
        boolean r12 = true;
    L14:
        if (r22 != null) goto L16;
        boolean r13 = true;
    L17:
        this.g = new com.bytedance.android.shopping.buynow.starter.b(r12, r13, false, 0.0f, 12).a();
        int r4 = k.a;
        k.b(this.n, this, false);
        long r6 = System.currentTimeMillis();
        if (r22 == null) goto L32;
        if (r20 != null) goto L32;
        UltimateBuyOrderExParams r14 = r22.getOrderExParams();
        if (r14 == null) goto L24;
        Map<String, String> r15 = r14.getQueryParams();
        if (r15 == null) goto L24;
    L25:
        UltimateBuyOrderExParams r16 = r22.getOrderExParams();
        if (r16 == null) goto L30;
        String r17 = r16.getMegaObjectJsonString();
        if (r17 == null) goto L30;
        JSONObject r18 = z1.g(r17);
    L31:
        f r27 = new f(r15, r18);
    L45:
        f r110 = r27;
    L47:
        if (r22 == null) goto L169;
        UltimateBuyCacheConfig r111 = UltimateBuyQueryResponseCache.a;
        Intrinsics.checkNotNullParameter(r110, "schemaQuery");
        Intrinsics.checkNotNullParameter(r22, "ultimateBuyParams");
        Integer r112 = r22.getUltimateBuyVersion();
        if (r112 != null) goto L52;
    L156:
        Object r113 = null;
        String r2 = r110.getQueryParam("id");
        String r7 = r110.getQueryParam("sku_promotion_id");
        String r8 = r110.getQueryParam("scene_type");
        String r28 = r110.getQueryParam("default_spec_id");
        if (r28 == null) goto L166;
        JSONArray r29 = z1.e(r28);
        if (r29 == null) goto L166;
        String r30 = r29.optString(0);
        if (r30 == null) goto L166;
        HashMap r114 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r30) == false) goto L166;
    L167:
        com.bytedance.android.shopping.buynow.cache.a r115 = new com.bytedance.android.shopping.buynow.cache.a(r7, r2, r8, r30);
    L168:
        r110.a = r115;
    L170:
        int r3 = com.bytedance.android.shopping.buynow.tracker.a.i;
        if (r22 == null) goto L173;
        boolean r31 = true;
    L174:
        this.d = com.bytedance.android.shopping.buynow.tracker.a.C0029a.a(r19, r31, ja3.a.b(r20), r110, r22);
        long r32 = System.currentTimeMillis();
        this.c = r110;
        BuyNowPerformanceOpt.l();
        this.e = new s();
        if (r22 == null) goto L177;
        Integer r0 = r22.getUltimateBuyVersion();
    L178:
        String r33 = "track.client";
        if (r0 != null) goto L182;
    L230:
        String r210 = "track.client";
        if (r22 == null) goto L233;
        Integer r1 = r22.getUltimateBuyVersion();
    L234:
        if (r1 != null) goto L237;
    L243:
        pa3.a.C0222a r34 = pa3.a.d;
        String r35 = this.n;
        if (this.q == null) goto L247;
        BuyNowBizCode r36 = BuyNowBizCode.YATA_SKUBUY;
    L250:
        pa3.a r37 = r34.b(r35, r36.getValue(), r110, this.p);
        this.b = r37;
        if (this.o == null) goto L259;
        BuyNowFirstScreenMonitor r38 = r37.a;
        if (r38 == null) goto L255;
        r38.a(BuyNowFirstScreenNode.PARSE_SCHEMA_START, r6);
    L255:
        BuyNowFirstScreenMonitor r39 = r37.a;
        if (r39 == null) goto L259;
        r39.a(BuyNowFirstScreenNode.PARSE_SCHEMA_END, r32);
    L259:
        if (this.q == null) goto L351;
        JSONObject r40 = r110.c;
        if (r40 == null) goto L263;
        Object r41 = r40.get("entrance_info");
    L265:
        if ((r41 instanceof String) == true) goto L267;
        r41 = null;
    L267:
        String r42 = (String) r41;
        if (r42 == null) goto L271;
        JSONObject r43 = z1.g(r42);
        if (r43 == null) goto L271;
    L281:
        if (r43 != null) goto L283;
        r43 = new JSONObject();
    L283:
        JSONObject r44 = r43;
        UltimateBuyParams r45 = this.q;
        if (r45 == null) goto L286;
        Integer r46 = r45.getUltimateBuyVersion();
    L288:
        if (r46 == null) goto L343;
        if (r46.intValue() != 1) goto L343;
        if (BuyNowPerformanceOpt.c() == false) goto L343;
        if (this.e != null) goto L297;
        this.e = new s();
    L297:
        s r47 = this.e;
        if (r47 == null) goto L343;
        Intrinsics.checkNotNullParameter(r44, "entranceInfo");
        Intrinsics.checkNotNullParameter(r110, "schemaQuery");
        String r48 = r110.getQueryParam("pass_through");
        int r49 = t0.a;     // Catch: Exception -> L302
        List r50 = (List) t0.a.a.fromJson(r48, new t().getType());     // Catch: Exception -> L302
    L304:
        if (r50 == null) goto L341;
        Iterator r51 = r50.iterator();
    L307:
        if (r51.hasNext() == false) goto L341;
        SkuPassThroughItem r52 = (SkuPassThroughItem) r51.next();
        List<String> r53 = r52.getTo();
        if (r53 == null) goto L307;
        Iterator r54 = r53.iterator();
    L312:
        if (r54.hasNext() == false) goto L307;
        String r55 = (String) r54.next();
        int r56 = r55.hashCode();
        if (r56 == (-1793220942)) goto L324;
        if (r56 != 1278258638) goto L312;
        String r57 = r210;
        if (r55.equals(r57) == false) goto L340;
        Map<String, ? extends Object> r58 = r52.getRawMap();
        if (r58 != null) goto L323;
        r58 = com.bytedance.android.shopping.extensions.k.z(r52.getData());
    L323:
        r47.a = r58;
    L340:
        r210 = r57;
        goto L312
    L324:
        r57 = r210;
        if (r55.equals("api.sku.entrance_info") == false) goto L340;
        Map r59 = r52.getRawMap();
        if (r59 != null) goto L329;
        r59 = com.bytedance.android.shopping.extensions.k.z(r52.getData());
    L329:
        if (r59 == null) goto L340;
        Iterator r116 = s.c.iterator();
    L332:
        if (r116.hasNext() == false) goto L340;
        String r117 = (String) r116.next();
        if (r44.has(r117) == true) goto L332;
        if (r59.containsKey(r117) == false) goto L332;
        if (r59.get(r117) == null) goto L332;
        KtSafeMethodExtensionKt.safePut(r44, r117, r59.get(r117));
    L341:
        r110.c("pass_through");
    L302:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r50 = null;
    L343:
        if (BuyNowPerformanceOpt.b() == true) goto L345;
    L350:
        int r60 = o43.b.a;
        Intrinsics.checkNotNullParameter(PageType.ULTIMATEBUYNOW, "pageType");
        r110.d = String.valueOf(r44);
        return;
    L345:
        if (this.e != null) goto L347;
        this.e = new s();
    L347:
        s r61 = this.e;
        if (r61 == null) goto L350;
        Intrinsics.checkNotNullParameter(r44, "entranceInfo");
        r61.b = a2.d(r44.optString("recommend_info"));
        r44.remove("recommend_info");
        goto L350
    L286:
        r46 = null;
    L271:
        Map<String, String> r62 = r110.b;
        if (r62 == null) goto L274;
        String r63 = r62.get("entrance_info");
    L276:
        if ((r63 instanceof String) == true) goto L278;
        r63 = null;
    L278:
        if (r63 == null) goto L280;
        r43 = z1.g(r63);
        goto L281
    L280:
        r43 = null;
        goto L281
    L274:
        r63 = null;
        goto L276
    L263:
        r41 = null;
        goto L265
    L351:
        JSONObject r64 = r110.c;
        if (r64 == null) goto L359;
        String r65 = r64.optString("entrance_info");
        if (r65 == null) goto L359;
        JSONObject r66 = z1.g(r65);
        if (r66 == null) goto L359;
        JSONObject r67 = r66;
    L365:
        int r68 = o43.b.a;
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        r110.d = String.valueOf(r67);
        return;
    L359:
        Map<String, String> r69 = r110.b;
        if (r69 == null) goto L364;
        String r70 = r69.get("entrance_info");
        if (r70 == null) goto L364;
        r67 = z1.g(r70);
    L364:
        r67 = null;
        goto L365
    L247:
        if (ja3.a.b(this.o) == false) goto L249;
        r36 = BuyNowBizCode.CONTINUE_PAY;
        goto L250
    L249:
        r36 = BuyNowBizCode.BUY;
        goto L250
    L237:
        if (r1.intValue() != 1) goto L243;
        if (BuyNowPerformanceOpt.c() == true) goto L243;
        s r71 = this.e;
        if (r71 == null) goto L243;
        r71.b(r110);
        goto L243
    L233:
        r1 = null;
        goto L234
    L182:
        if (r0.intValue() != 0) goto L230;
        if (r22 == null) goto L187;
        Map<String, Object> r72 = r22.getSkuExParams();
        if (r72 == null) goto L187;
        Object r73 = r72.get("sku_schema_param");
    L189:
        if (TypeIntrinsics.isMutableMap(r73) == true) goto L191;
        r73 = r113;
    L191:
        Map r74 = (Map) r73;
        s r75 = this.e;
        if (r75 == null) goto L229;
        if (r74 == null) goto L195;
        Object r76 = r74.get("pass_through");
    L197:
        if ((r76 instanceof List) == true) goto L199;
        r76 = r113;
    L199:
        List r77 = (List) r76;
        if (r77 == null) goto L229;
        ArrayList r118 = new ArrayList();
        Iterator r78 = r77.iterator();
        ?? r119 = r113;
    L204:
        if (r78.hasNext() == false) goto L228;
        SkuPassThroughItem r120 = (SkuPassThroughItem) r78.next();
        List<String> r121 = r120.getTo();
        if (r121 == null) goto L226;
        Iterator r122 = r121.iterator();
        r119 = r119;
    L209:
        if (r122.hasNext() == false) goto L225;
        String r79 = (String) r122.next();
        Iterator r211 = r78;
        int r80 = r79.hashCode();
        ?? r212 = r119;
        if (r80 != 54623351) goto L213;
        String r213 = r33;
        if (r79.equals("track.client.entrance_info") == true) goto L223;
    L222:
        r118.add(r120);
    L223:
        ?? r123 = r212;
    L224:
        r78 = r211;
        r33 = r213;
        r119 = r123;
        goto L209
    L213:
        if (r80 == 1278258638) goto L216;
    L218:
        r213 = r33;
        goto L222
    L216:
        if (r79.equals(r33) == false) goto L218;
        r213 = r33;
        r123 = new SkuPassThroughItem(CollectionsKt.listOf(r33), r120.getData(), r120.getRawMap());
        goto L224
    L225:
        String r214 = r33;
        Iterator r215 = r78;
    L227:
        r78 = r215;
        r33 = r214;
        r119 = r119;
        goto L204
    L226:
        r214 = r33;
        r215 = r78;
        goto L227
    L228:
        r210 = r33;
        r75.a = s.c(r119);
        r74.put("pass_through", r118);
        goto L243
    L195:
        r76 = r113;
    L229:
        r210 = "track.client";
    L187:
        r73 = r113;
        goto L189
    L177:
        r0 = r113;
        goto L178
    L173:
        r31 = false;
    L166:
        r30 = null;
        goto L167
    L52:
        if (r112.intValue() != 0) goto L156;
        if (r22.isSingleSku() != 0) goto L130;
        Map<String, Object> r124 = r22.getSkuExParams();
        if (r124 == null) goto L58;
        Object r125 = r124.get("sku_schema_param");
    L60:
        if (TypeIntrinsics.isMutableMap(r125) == true) goto L62;
        r125 = null;
    L62:
        Map r126 = (Map) r125;
        if (r126 == null) goto L65;
        Object r127 = r126.get("product_info");
    L67:
        if (TypeIntrinsics.isMutableMap(r127) == true) goto L69;
        r127 = null;
    L69:
        Map r128 = (Map) r127;
        Map<String, Object> r129 = r22.getSkuExParams();
        if (r129 == null) goto L72;
        Object r130 = r129.get("sku_schema_param");
    L74:
        if (TypeIntrinsics.isMutableMap(r130) == true) goto L76;
        r130 = null;
    L76:
        Map r131 = (Map) r130;
        if (r131 == null) goto L79;
        Object r81 = r131.get("biz_context");
    L81:
        if (TypeIntrinsics.isMutableMap(r81) == true) goto L83;
        r81 = null;
    L83:
        Map r82 = (Map) r81;
        Map<String, Object> r132 = r22.getSkuExParams();
        if (r132 == null) goto L86;
        Object r133 = r132.get("sku_schema_param");
    L88:
        if (TypeIntrinsics.isMutableMap(r133) == true) goto L90;
        r133 = null;
    L90:
        Map r134 = (Map) r133;
        if (r134 == null) goto L93;
        Object r84 = r134.get("client_params");
    L95:
        if (TypeIntrinsics.isMutableMap(r84) == true) goto L97;
        r84 = null;
    L97:
        Map r85 = (Map) r84;
        if (r128 == null) goto L100;
        Object r86 = r128.get(PdpOpenThirdParam.KEY_PROMOTION_ID);
    L102:
        if ((r86 instanceof String) == true) goto L104;
        r86 = null;
    L104:
        String r87 = (String) r86;
        if (r128 == null) goto L107;
        Object r88 = r128.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
    L109:
        if ((r88 instanceof String) == true) goto L111;
        r88 = null;
    L111:
        String r89 = (String) r88;
        if (r82 == null) goto L114;
        Object r90 = r82.get("scene_type");
    L116:
        if ((r90 instanceof String) == true) goto L118;
        r90 = null;
    L118:
        String r91 = (String) r90;
        if (r85 == null) goto L121;
        Object r92 = r85.get("default_spec_id");
    L123:
        if ((r92 instanceof List) == true) goto L125;
        r92 = null;
    L125:
        List r94 = (List) r92;
        if (r94 == null) goto L128;
        String r95 = (String) CollectionsKt.firstOrNull(r94);
    L129:
        r115 = new com.bytedance.android.shopping.buynow.cache.a(r87, r89, r91, r95);
        r113 = null;
        goto L168
    L128:
        r95 = null;
        goto L129
    L121:
        r92 = null;
        goto L123
    L114:
        r90 = null;
        goto L116
    L107:
        r88 = null;
        goto L109
    L100:
        r86 = null;
        goto L102
    L93:
        r84 = null;
        goto L95
    L86:
        r133 = null;
        goto L88
    L79:
        r81 = null;
        goto L81
    L72:
        r130 = null;
        goto L74
    L65:
        r127 = null;
        goto L67
    L58:
        r125 = null;
        goto L60
    L130:
        Map<String, Object> r96 = r22.getSkuExParams();
        if (r96 == null) goto L133;
        Object r97 = r96.get("sku_schema_param");
    L135:
        if (TypeIntrinsics.isMutableMap(r97) == true) goto L137;
        r97 = null;
    L137:
        Map r98 = (Map) r97;
        if (r98 == null) goto L140;
        Object r99 = r98.get("biz_context");
    L142:
        if (TypeIntrinsics.isMutableMap(r99) == true) goto L144;
        r99 = null;
    L144:
        Map r100 = (Map) r99;
        String r101 = r110.getQueryParam("id");
        SkuParams r102 = r22.getSkuParams();
        if (r102 == null) goto L147;
        String r103 = r102.getPromotionId();
    L148:
        if (r100 == null) goto L150;
        Object r104 = r100.get("scene_type");
    L152:
        if ((r104 instanceof String) == true) goto L154;
        r104 = null;
    L154:
        r113 = null;
        r115 = new com.bytedance.android.shopping.buynow.cache.a(r103, r101, (String) r104, null);
        goto L168
    L150:
        r104 = null;
        goto L152
    L147:
        r103 = null;
        goto L148
    L140:
        r99 = null;
        goto L142
    L133:
        r97 = null;
        goto L135
    L169:
        r113 = null;
    L30:
        r18 = null;
    L24:
        r15 = new LinkedHashMap();
    L32:
        if (r20 == null) goto L44;
        int r105 = o.a;
        Intrinsics.checkNotNullParameter(r20, "uri");
        Map r106 = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence(UriProtector.getQueryParameterNames(r20)), new SchemaParser$getQueryFromUri$queryParams$1(r20)), new LinkedHashMap());
        String r135 = (String) r106.get("mega_object_id");
        if (r135 != null) goto L36;
        r135 = (String) r106.get("rifle_mega_object_id");
    L36:
        if (r135 == null) goto L39;
        HashMap r136 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r137 = com.bytedance.android.ec.core.hybrid.utils.j.d(r135);
        if (r137 == null) goto L39;
    L43:
        r110 = new f(r106, r137);
    L39:
        String r138 = (String) r106.get("mega_object");
        if (r138 == null) goto L42;
        r137 = com.bytedance.android.shopping.extensions.k.w(r138);
        goto L43
    L42:
        r137 = null;
        goto L43
    L44:
        r27 = new f(null, null);
        goto L45
    L16:
        r13 = false;
        goto L17
    L13:
        r12 = false;
        goto L14
    L7:
        r10 = null;
        goto L8
    L9:
        r11 = false;
        goto L10
    }
}
