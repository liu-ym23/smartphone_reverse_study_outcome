package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowBizCode;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.container.BuyNowFullscreenActivity;
import com.bytedance.android.shopping.buynow.container.BuyNowHalfScreenDialogFragment;
import com.bytedance.android.shopping.buynow.container.BuyNowSplitScreenFragment;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.slice.BuyNowTemplateMgr;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ma3.q;
import ma3.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowStarterOpt implements n, c53.d {
    public static final /* synthetic */ int q = 0;
    public final c a;
    public final YataPageInfo b;
    public s c;
    public final pa3.a d;
    public final Map<String, ? extends Object> e;
    public d f;
    public Function1<? super d, Unit> g;
    public boolean h;
    public Function0<Unit> i;
    public final String j;
    public final IOrderSchema k;
    public final sc3.b l;
    public final la3.e m;
    public final String n;
    public final boolean o;
    public final /* synthetic */ c53.b p;

    public static final class a {
        public a() {
        }

        public static BuyNowStarterOpt a(IOrderSchema r7, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r8, String r9, String r10, boolean r11, int r12) {
            int r0 = BuyNowStarterOpt.q;
            if ((r12 & 4) == 0) goto L6;
            r9 = null;
        L6:
            if ((r12 & 32) == 0) goto L8;
            boolean r6 = false;
        L9:
            Intrinsics.checkNotNullParameter(r7, "orderSchema");
            if (r9 != null) goto L13;
            r9 = UUID.randomUUID().toString();
        L13:
            return new BuyNowStarterOpt(r9, r7, r8, null, r10, r6);
        L8:
            r6 = r11;
            goto L9
        }
    }

    static {
        new a();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.p.add(r2);
        return r2;
    }

    public final void doClear() {
        this.p.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.p.remove(r2);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean f() {
        return Intrinsics.areEqual(this.k.getHost(), "continue_pay");
    }

    public final UltimateBuyStyleParams l() {
        int r0 = com.bytedance.android.shopping.extensions.k.r(this.k.getQueryParam("height_percent"), 0);
        String r1 = this.k.getQueryParam("scene_type");
        Float r3 = Float.valueOf(com.bytedance.android.shopping.extensions.k.p(this.k.getQueryParam("mask_alpha"), 0.5f));
        Lazy r4 = SkuBuyNowPanelHeightHelper.a;
        return new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(r1, Integer.valueOf(r0)), r3);
    }

    public final BuyNowBizCode n() {
        if (this.k.C() == false) goto L6;
        return BuyNowBizCode.YATA_SKUBUY;
    L6:
        if (f() == false) goto L9;
        return BuyNowBizCode.CONTINUE_PAY;
    L9:
        return BuyNowBizCode.BUY;
    }

    public final void q() {
        pa3.a r0 = this.d;
        if (r0 == null) goto L10;
        BuyNowFirstScreenMonitor r1 = r0.a;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter(MonitorScenes.EC_PERF_PAGE_START_BUY_NOW, "scene");
        if (r1.f == true) goto L10;
        r1.f = true;
    L10:
        pa3.a r2 = this.d;
        if (r2 == null) goto L16;
        BuyNowFirstScreenMonitor r3 = r2.a;
        if (r3 == null) goto L17;
        r3.a(BuyNowFirstScreenNode.INITIAL, System.currentTimeMillis());
        return;
    L17:
        return;
    }

    public final void r() {
        Map r0 = ECParamTrackerCenter.a;
        if (this.k.C() == false) goto L5;
        String r1 = "UltimateBuy";
    L6:
        ECParamTrackerCenter.d(r1, this.j);
        String r2 = this.j;
        IOrderSchema r3 = this.k;
        r3.B();
        com.bytedance.android.shopping.buynow.utils.a.a(r2, r3);
        EventActionImpl r4 = new EventActionImpl();
        LinkedHashMap r5 = new LinkedHashMap();
        IOrderSchema r6 = this.k;
        if (r6 == null) goto L11;
        Map<? extends String, ? extends Object> r7 = r6.b();
        if (r7 == null) goto L11;
        r5.putAll(r7);
    L11:
        r5.put("buynow_session_id", this.j);
        int r8 = com.bytedance.android.ec.core.buynow.d.a;
        com.bytedance.android.ec.core.buynow.d.b(this.k);
        Object r9 = null;
        r5.put("EVENT_PAGE_TECHNOLOGY", null);
        IOrderSchema r10 = this.k;
        if (r10 == null) goto L18;
        String r11 = r10.getQueryParam("eztf_sdk_extra");
        if (r11 == null) goto L18;
        JSONObject r12 = z1.g(r11);
        if (r12 == null) goto L18;
        r9 = r12.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
    L18:
        r5.put("eztf_source_page", r9);
        r4.doEventAction("enter_buynow_page", r5);
        if (this.k.C() == false) goto L22;
        new EventActionImpl().doEventAction("enter_submit_orders", MapsKt.mapOf(new Pair[]{TuplesKt.to("page_scene", "1"), TuplesKt.to("scene_type", this.k.getQueryParam("scene_type"))}));
        return;
    L22:
        return;
    L5:
        r1 = "BuyNow";
        goto L6
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void release() {
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.a("BuyNowStarter", "BuyNowStarter release " + this.j);
        doClear();
        Map<String, UltimateBuyCacheQueryHelper> r1 = UltimateBuyCacheHelper.b;
        String r2 = this.j;
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Map<String, UltimateBuyCacheQueryHelper> r3 = UltimateBuyCacheHelper.b;
        UltimateBuyCacheQueryHelper r4 = (UltimateBuyCacheQueryHelper) ((LinkedHashMap) r3).get(r2);
        if (r4 == null) goto L7;
        Disposable r5 = r4.c;
        if (r5 == null) goto L7;
        r5.dispose();
    L7:
        r3.remove(r2);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final nl.c a() {
        return this.k;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final s b() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final boolean g() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final YataPageInfo getPageInfo() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final String getSourceBtmToken() {
        return this.n;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final d h() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final Map<String, Object> j() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void d(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "btmNode");
        c r0 = this.a;
        r0.c = new WeakReference(r3);
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void e(Function1<? super d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.g = r2;
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.p.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void k(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.i = r2;
    }

    public final void m(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.k.replaceOrAppendParam("check_parallel_type", "prefetch");
        if (this.k.C() == true) goto L5;
        return;
    L5:
        c r0 = this.a;
        h43.a.a(r8);
        r0.d = false;
        c r1 = this.a;
        com.bytedance.android.shopping.buynow.cache.a r4 = null;
        if ((r8 instanceof FragmentActivity) == true) goto L8;
        Context r3 = null;
    L9:
        FragmentActivity r5 = (FragmentActivity) r3;
        nj.d r6 = h43.a.b();
        if (r6 == null) goto L12;
        r6.g();
    L12:
        r1.e = false;
        int r2 = ECSdk.a;
        cj.b r7 = (cj.b) ECSdk.a(cj.b.class);
        if (r7 == null) goto L15;
        r7.e(r8);
    L15:
        OrderSchema.b r9 = this.k.P0();
        if (r9 != null) goto L19;
        r9 = this.k.P();
    L19:
        if (this.c != null) goto L21;
        this.c = new s();
    L21:
        s r10 = this.c;
        if (r10 != null) goto L24;
    L30:
        int r11 = o43.b.a;
        if (r9 == null) goto L33;
        JSONObject r12 = r9.e();
    L34:
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.k.T(r12);
        if (this.o == false) goto L68;
        this.k.replaceOrAppendParam("check_parallel_type", "diff");
        na3.g r13 = na3.g.a;
        e r14 = new e(this.k, this.a, true);
        Intrinsics.checkNotNullParameter(r14, "requestBuilder");
        int r15 = com.bytedance.android.shopping.buynow.opt.d.a;
        com.bytedance.android.shopping.buynow.cache.a r16 = com.bytedance.android.shopping.buynow.opt.d.a(r14.c);
        Map<String, UltimateBuyCacheQueryHelper> r17 = UltimateBuyCacheHelper.b;
        IOrderSchema r18 = r14.c;
        c r19 = r14.d;
        if (r19 == null) goto L39;
        String r20 = r19.a;
    L40:
        if (r20 != null) goto L42;
        r20 = "";
    L42:
        UltimateBuyCacheQueryHelper r21 = UltimateBuyCacheHelper.d(r18, r20);
        if (UltimateBuyCacheHelper.c(r16) == null) goto L45;
        r14.c.replaceOrAppendParam("has_used_client_cache", "true");
    L45:
        ma3.f r22 = r14.a(false);
        ma3.m r23 = r14.a;
        if ((r23 instanceof r) == true) goto L48;
        r23 = null;
    L48:
        r r24 = (r) r23;
        if (r24 == null) goto L59;
        if (r21 == null) goto L59;
        if ((r16 instanceof com.bytedance.android.shopping.buynow.cache.a) == false) goto L55;
        r4 = r16;
    L55:
        Object r25 = r14.b;
        if (r25 != null) goto L58;
        r25 = new LinkedHashMap();
    L58:
        Pair<r, ? extends Map<String, String>> r26 = new Pair(r24, r25);
        Intrinsics.checkNotNullParameter(r26, "ultimateBuyRequestPair");
        r21.b = r4;
        r21.a = r26;
    L59:
        Observable r27 = na3.g.c(r22, r14.f());
        if (r27 == null) goto L70;
        Observable r28 = r27.subscribeOn(Schedulers.newThread());
        if (r28 == null) goto L71;
        Observable r29 = r28.observeOn(Schedulers.io());
        if (r29 == null) goto L72;
        Disposable r30 = r29.subscribe(na3.a.a, na3.b.a);
        if (r30 == null) goto L73;
        Intrinsics.checkNotNullParameter(r30, "$this$globalScope");
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L39:
        r20 = null;
        goto L40
    L68:
        int r31 = k.a;
        k.b(this.j, this, true);
        i(r8, true);
        return;
    L33:
        r12 = null;
        goto L34
    L24:
        if (r9 == null) goto L26;
        String r32 = r9.getString("recommend_info");
    L27:
        r10.b = r32;
        if (r9 == null) goto L30;
        r9.delete(new String[]{"recommend_info"});
        goto L30
    L26:
        r32 = null;
        goto L27
    L8:
        r3 = r8;
        goto L9
    }

    public final void o(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        int r0 = k.a;
        k.b(this.j, this, false);
        if (BuyNowPerformanceOpt.f() == false) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.d r1 = com.bytedance.android.ec.sdk.helper.d.b;
        nj.d r2 = r1.getPadSplitService();
        c r3 = this.a;
        if (r2 == null) goto L8;
        r2.l();
    L8:
        r3.d = false;
        c r4 = this.a;
        nj.d r5 = r1.getPadSplitService();
        JSONObject r6 = null;
        if (r5 != null) goto L11;
    L15:
        r4.e = false;
        int r8 = ECSdk.a;
        cj.b r9 = (cj.b) ECSdk.a(cj.b.class);
        if (r9 == null) goto L18;
        r9.e(r7);
    L18:
        q();
        pa3.a r10 = this.d;
        if (r10 == null) goto L23;
        BuyNowFirstScreenMonitor r11 = r10.a;
        if (r11 == null) goto L23;
        r11.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_START, System.currentTimeMillis());
    L23:
        pa3.a r12 = this.d;
        if (r12 == null) goto L28;
        BuyNowFirstScreenMonitor r13 = r12.a;
        if (r13 == null) goto L28;
        r13.a(BuyNowFirstScreenNode.PRELOAD_TEMPLATE_END, System.currentTimeMillis());
    L28:
        OrderSchema.b r14 = this.k.P0();
        if (r14 != null) goto L32;
        r14 = this.k.P();
    L32:
        if (BuyNowPerformanceOpt.b() == true) goto L34;
    L47:
        int r15 = o43.b.a;
        if (r14 == null) goto L50;
        r6 = r14.e();
    L50:
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.k.T(r6);
        i(r7, true);
        int r16 = BuyNowTemplateMgr.a;
        BuyNowTemplateMgr.a(r7, n(), true);
        if (ja3.a.c(this.k) == false) goto L53;
        com.bytedance.android.shopping.buynow.opt.a.a(r7);
    L53:
        p(r7, this.k);
        r();
        return;
    L34:
        if (this.k.C() == false) goto L47;
        if (this.c != null) goto L38;
        this.c = new s();
    L38:
        s r17 = this.c;
        if (r17 == null) goto L47;
        if (r14 == null) goto L43;
        String r18 = r14.getString("recommend_info");
    L44:
        r17.b = r18;
        if (r14 == null) goto L47;
        r14.delete(new String[]{"recommend_info"});
        goto L47
    L43:
        r18 = null;
        goto L44
    L11:
        if ((r7 instanceof FragmentActivity) == true) goto L13;
        Context r19 = null;
    L14:
        FragmentActivity r20 = (FragmentActivity) r19;
        r5.g();
        goto L15
    L13:
        r19 = r7;
        goto L14
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void c(Context r4, com.bytedance.android.shopping.sku.common.data.e r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "nextData");
        if (this.k.C() == false) goto L8;
        boolean r6 = Intrinsics.areEqual(String.valueOf(this.k.getQueryParam("enter_from_live_saas")), "1");
        int r0 = ja3.a.a(this.k);
        Map<String, UltimateBuyCacheQueryHelper> r1 = UltimateBuyCacheHelper.b;
        UltimateBuyCacheQueryHelper r2 = UltimateBuyCacheHelper.d(this.k, this.j);
        if (r2 == null) goto L9;
        r2.query(r6, r5, r0, new BuyNowStarterOpt$reFetchQueryByCacheOperation$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.buynow.starter.n
    public final void i(Context r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        pa3.a r13 = this.d;
        if (r13 == null) goto L7;
        BuyNowFirstScreenMonitor r14 = r13.a;
        if (r14 == null) goto L7;
        r14.a(BuyNowFirstScreenNode.REQUEST_START, System.currentTimeMillis());
    L7:
        e r15 = new e(this.k, this.a, r12);
        na3.g r0 = na3.g.a;
        pa3.a r9 = this.d;
        Intrinsics.checkNotNullParameter(r15, "requestBuilder");
        if (r9 == null) goto L12;
        BuyNowFirstScreenMonitor r1 = r9.a;
        if (r1 == null) goto L12;
        r1.a(BuyNowFirstScreenNode.QUERY_PARAM_START, System.currentTimeMillis());
    L12:
        int r2 = com.bytedance.android.shopping.buynow.opt.d.a;
        com.bytedance.android.shopping.buynow.cache.a r7 = com.bytedance.android.shopping.buynow.opt.d.a(r15.c);
        dm.a.a("BuyNowPrefetcher").a("queryBuyNow cache key " + r7);
        Map<String, UltimateBuyCacheQueryHelper> r3 = UltimateBuyCacheHelper.b;
        IOrderSchema r4 = r15.c;
        c r5 = r15.d;
        com.bytedance.android.shopping.buynow.cache.a r6 = null;
        if (r5 == null) goto L15;
        String r8 = r5.a;
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        UltimateBuyCacheQueryHelper r10 = UltimateBuyCacheHelper.d(r4, r8);
        q r16 = UltimateBuyCacheHelper.c(r7);
        if (r16 == null) goto L21;
        r15.c.replaceOrAppendParam("has_used_client_cache", "true");
    L21:
        ma3.f r17 = r15.a(false);
        ma3.m r18 = r15.a;
        if ((r18 instanceof r) == true) goto L24;
        r18 = null;
    L24:
        r r19 = (r) r18;
        if (r19 == null) goto L35;
        if (r10 == null) goto L35;
        if ((r7 instanceof com.bytedance.android.shopping.buynow.cache.a) == false) goto L31;
        r6 = r7;
    L31:
        Object r20 = r15.b;
        if (r20 != null) goto L34;
        r20 = new LinkedHashMap();
    L34:
        Pair<r, ? extends Map<String, String>> r21 = new Pair(r19, r20);
        Intrinsics.checkNotNullParameter(r21, "ultimateBuyRequestPair");
        r10.b = r6;
        r10.a = r21;
    L35:
        if (r9 == null) goto L39;
        BuyNowFirstScreenMonitor r22 = r9.a;
        if (r22 == null) goto L39;
        r22.a(BuyNowFirstScreenNode.QUERY_PARAM_END, System.currentTimeMillis());
    L39:
        if (r9 == null) goto L43;
        BuyNowFirstScreenMonitor r23 = r9.a;
        if (r23 == null) goto L43;
        BuyNowFirstScreenMonitor.b(r23, BuyNowFirstScreenNode.FETCH_START);
    L43:
        if (r9 == null) goto L47;
        BuyNowFirstScreenMonitor r24 = r9.a;
        if (r24 == null) goto L47;
        r24.a(BuyNowFirstScreenNode.NATIVE_NET_START, System.currentTimeMillis());
    L47:
        Observable.merge(Observable.create(new na3.f(r17, r15, null, r7, r10, r9)), Observable.defer(new na3.e(r16, r10, r15))).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this, r12));
        return;
    L15:
        r8 = null;
        goto L16
    }

    public final void p(Context r17, IOrderSchema r18) {
        BuyNowLog.a("BuyNowStarter", "presentNativeBuyNow");
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r4 = r3.getLiveWindowService();
        if (r4 == null) goto L7;
        r4.stopShowFloatInNextLifecycle();
    L7:
        pa3.a r5 = this.d;
        if (r5 == null) goto L12;
        BuyNowFirstScreenMonitor r6 = r5.a;
        if (r6 == null) goto L12;
        r6.a(BuyNowFirstScreenNode.CONTAINER_INIT_START, System.currentTimeMillis());
    L12:
        String r7 = null;
        if (this.k.C() == false) goto L25;
        if (this.a.d == false) goto L23;
        int r1 = BuyNowSplitScreenFragment.f;
        String r8 = this.j;
        UltimateBuyStyleParams r9 = l();
        la3.e r10 = this.m;
        String r11 = this.n;
        BuyNowOrderSchema r12 = la3.a.a(this.k);
        int r13 = com.bytedance.android.shopping.extensions.k.r(this.k.getQueryParam("ultimate_buy_ab"), 0);
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        BuyNowSplitScreenFragment r14 = new BuyNowSplitScreenFragment();
        Bundle r15 = new Bundle();
        r15.putString("PrefetchSessionId", r8);
        r15.putString("source_btm_token", r11);
        r15.putFloat("HeightPercent", r9.getHeightPercent() / 100.0f);
        Float r16 = r9.getMaskAlpha();
        if (r16 == null) goto L19;
        float r19 = r16.floatValue();
    L20:
        r15.putFloat("MaskAlpha", r19);
        r15.putSerializable("ultimate_buy_params", null);
        r15.putParcelable("Schema", null);
        r15.putParcelable("OrderSchema", r12);
        r15.putInt("ultimate_buy_ab", r13);
        r15.putString("SplitScreenType", "sku_buy");
        Unit r20 = Unit.INSTANCE;
        r14.setArguments(r15);
        r14.e = r10;
        nj.d r21 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r21 == null) goto L50;
        ECHybridExtensionsKt.a(r17);
        r21.k();
        return;
    L50:
        return;
    L19:
        r19 = 0.5f;
        goto L20
    L23:
        int r22 = BuyNowHalfScreenDialogFragment.f;
        BuyNowHalfScreenDialogFragment.a.c(r17, null, this.j, l(), this.m, this.n, null, la3.a.a(this.k), com.bytedance.android.shopping.extensions.k.r(this.k.getQueryParam("ultimate_buy_ab"), 0), 2);
        return;
    L25:
        if (ja3.a.c(r18) == false) goto L44;
        if (this.a.d == true) goto L44;
        int r23 = BuyNowHalfScreenDialogFragment.f;
        String r24 = this.j;
        if (r18 == null) goto L33;
        String r25 = r18.getQueryParam("mask_alpha");
        if (r25 == null) goto L33;
        Float r26 = Float.valueOf(CastFloatProtector.parseFloat(r25));
    L34:
        BuyNowOrderSchema r27 = la3.a.a(this.k);
        if (r18 == null) goto L37;
        String r28 = r18.getQueryParam("height_percent");
    L39:
        if ((r28 instanceof String) == false) goto L42;
        r7 = r28;
    L42:
        BuyNowHalfScreenDialogFragment.a.b(r17, r24, null, r26, r27, com.bytedance.android.shopping.extensions.k.p(r7, 73.0f) / 100.0f, this.n);
        return;
    L37:
        r28 = null;
    L33:
        r26 = null;
    L44:
        if (this.a.d == false) goto L48;
        int r29 = BuyNowSplitScreenFragment.f;
        BuyNowSplitScreenFragment.a.a(this.j, null, la3.a.a(this.k), this.n);
        nj.d r30 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r30 == null) goto L54;
        ECHybridExtensionsKt.a(r17);
        r30.k();
        return;
    L54:
        return;
    L48:
        int r31 = BuyNowFullscreenActivity.k;
        BuyNowFullscreenActivity.a.a(r17, this.j, null, la3.a.a(this.k), this.n);
    }

    public BuyNowStarterOpt(String r5, IOrderSchema r6, com.bytedance.android.shopping.buynow.monitor.firstscreen.a r7, la3.e r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "orderSchema");
        this.p = new c53.b();
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        boolean r0 = ECSettingKeys.d();
        if (r6.C() == false) goto L9;
        Map r1 = BuyNowPerformanceOpt.g();
        if (r1 == null) goto L7;
        Object r2 = r1.get("ec_sku_buy_disable_compress");
    L8:
        boolean r3 = Intrinsics.areEqual(r2, 1);
    L10:
        c r11 = new c(r5, new YataPageInfo(r0, r3, r5));
        this.a = r11;
        this.b = r11.b;
        r6.replaceOrAppendParam("use_new_self_event", String.valueOf(ECSettingKeys.k()));
        long r12 = System.currentTimeMillis();
        int r4 = com.bytedance.android.shopping.buynow.tracker.a.i;
        this.e = com.bytedance.android.shopping.buynow.tracker.a.C0029a.a(r5, r6.C(), f(), r6, null);
        BuyNowPerformanceOpt.l();
        if (r6.C() == false) goto L13;
        s r13 = new s();
        this.c = r13;
        r13.a(r6);
    L13:
        long r14 = System.currentTimeMillis();
        if (r10 == true) goto L16;
        this.d = pa3.a.d.b(r5, n().getValue(), r6, r7);
    L16:
        pa3.a r15 = this.d;
        if (r15 == null) goto L21;
        BuyNowFirstScreenMonitor r16 = r15.a;
        if (r16 == null) goto L21;
        r16.a(BuyNowFirstScreenNode.PARSE_SCHEMA_START, r12);
    L21:
        pa3.a r17 = this.d;
        if (r17 == null) goto L27;
        BuyNowFirstScreenMonitor r18 = r17.a;
        if (r18 == null) goto L28;
        r18.a(BuyNowFirstScreenNode.PARSE_SCHEMA_END, r14);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r2 = null;
        goto L8
    L9:
        r3 = false;
        goto L10
    }
}
