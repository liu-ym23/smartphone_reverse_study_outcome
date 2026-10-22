package ta3;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.d;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.Starter;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyOrderExParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.slice.BuyNowTemplateMgr;
import com.bytedance.android.shopping.buynow.starter.BuyNowRouter;
import com.bytedance.android.shopping.buynow.starter.BuyNowStarter;
import com.bytedance.android.shopping.buynow.starter.BuyNowStarterOpt;
import com.bytedance.android.shopping.buynow.starter.e;
import com.bytedance.android.shopping.buynow.starter.m;
import com.bytedance.android.shopping.buynow.starter.n;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.model.abscontainer.PerformancePointType;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.inner.ultimate.g;
import com.bytedance.android.shopping.sku.inner.ultimate.j;
import com.bytedance.android.shopping.sku.outer.business.ultimate.UltimateBuyOrderSchemaParser;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ma3.r;
import nl.f;
import org.json.JSONObject;
import sc3.c;
import sc3.i;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements c {

    /* JADX INFO: renamed from: ta3.a$a, reason: collision with other inner class name */
    public static final class C0233a {
    }

    public static final class b implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            Uri r0 = UriProtector.parse(this.a);
            EventActionImpl r1 = new EventActionImpl();
            Pair[] r2 = new Pair[4];
            r2[0] = TuplesKt.to("btm", this.b);
            String r3 = null;
            if (r0 == null) goto L9;
            String r4 = UriProtector.getQueryParameter(r0, "eztf_sdk_extra");
            if (r4 == null) goto L9;
            JSONObject r5 = z1.g(r4);
            if (r5 == null) goto L9;
            Object r6 = r5.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        L10:
            r2[1] = TuplesKt.to("eztf_source_page", r6);
            if (r0 == null) goto L13;
            r3 = UriProtector.getQueryParameter(r0, "entrance_info");
        L13:
            r2[2] = TuplesKt.to("entrance_info", r3);
            r2[3] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", d.a(r0));
            r1.doEventAction("enter_submit_orders", MapsKt.mapOf(r2));
            return;
        L9:
            r6 = null;
            goto L10
        }
    }

    static {
    }

    @Override // sc3.c
    public final void b(IOrderSchema r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
    }

    public static com.bytedance.android.shopping.buynow.monitor.firstscreen.a s() {
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r0 = com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d;
        if (r0 == null) goto L9;
        com.bytedance.android.ec.model.d r1 = r0.c;
        if (r1 == null) goto L9;
        Long r2 = r1.b;
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L11:
        if ((System.currentTimeMillis() - r3) < 100000) goto L14;
        return null;
    L14:
        return r0;
    L9:
        r3 = 0;
        goto L11
    }

    @Override // sc3.c
    public final void c() {
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d = null;
    }

    @Override // sc3.c
    public final com.bytedance.android.shopping.skubuy.start_flow.a e() {
        return new com.bytedance.android.shopping.skubuy.start_flow.a();
    }

    public a() {
        Map r0 = bf.a.a;
        bf.a.a(new BuyNowRouter());
        bf.a.a(new m());
        int r1 = com.bytedance.android.ec.core.buynow.b.a;
    }

    @Override // sc3.c
    public final com.bytedance.android.shopping.buynow.monitor.firstscreen.a o() {
        return s();
    }

    @Override // sc3.c
    public final void i(IOrderSchema r3) {
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        r3.z0();
        int r1 = com.bytedance.android.shopping.buynow.opt.d.a;
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        dm.a.a("BuyNowPrefetcher").a("prefetchOnVideo");
        com.bytedance.android.shopping.buynow.opt.d.c(r3);
    }

    @Override // sc3.c
    public final String k(IOrderSchema r14) {
        Intrinsics.checkNotNullParameter(r14, "orderSchema");
        Intrinsics.checkNotNullParameter(r14, "orderSchema");
        r14.z0();
        f r0 = r14.i1();
        if (r0 == null) goto L16;
        int r7 = k.r(r14.getQueryParam("ultimate_buy_ab"), 0);
        UltimateBuyOrderExParams r5 = UltimateBuyOrderSchemaParser.b(r14);
        j r2 = new j(r14, r0);
        List<Integer> r15 = g.a;
        if (g.a(r7, r2.d, r2.c) == false) goto L13;
        SkuParams r16 = r2.h;
        Map<String, mh3.a> r1 = mh3.a.m;
        SkuAbilityType r3 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r3, r16, true);
        new com.bytedance.android.shopping.sku.common.controller.d(r3, r16, true).a();
        Map<String, Object> r6 = r2.a();
        int r17 = ECSdk.a;
        IEShoppingService r18 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r18 == null) goto L14;
        c r19 = r18.getBuyNowService();
        if (r19 == null) goto L15;
        UltimateBuyParams r4 = new UltimateBuyParams(r5, r6, r7, 1, r2.h, null, 32, null);
        SkuParams r8 = r2.h;
        Lazy r9 = SkuBuyNowPanelHeightHelper.a;
        return r19.h(null, r4, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r8.getSceneType()), r8.getHeightPercent()), Float.valueOf(r2.h.getMaskAlpha())), null);
    L15:
        return null;
    L14:
        return null;
    L13:
        return null;
    L16:
        return null;
    }

    @Override // sc3.c
    public final com.bytedance.android.shopping.buynow.monitor.firstscreen.a n(com.bytedance.android.ec.model.d r3) {
        Intrinsics.checkNotNullParameter(r3, "monitorContext");
        WeakReference r0 = r3.getContext();
        if (r0 == null) goto L7;
        Context r1 = (Context) r0.get();
        if (r1 == null) goto L7;
        int r2 = ka3.b.a;
        t.b(new ka3.a(r1));
    L7:
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.C0028a r4 = com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e;
        monitor-enter(r4);
        Intrinsics.checkNotNullParameter(r3, "monitorContext");     // Catch: Throwable -> L15
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r5 = com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d;     // Catch: Throwable -> L15
        if (r5 != null) goto L12;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r6 = new com.bytedance.android.shopping.buynow.monitor.firstscreen.a(r3);     // Catch: Throwable -> L15
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d = r6;     // Catch: Throwable -> L15
    L13:
        monitor-exit(r4);
        return r6;
    L12:
        r5.b = true;     // Catch: Throwable -> L15
        r6 = null;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d = null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // sc3.c
    public final void p(IOrderSchema r3) {
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        r3.z0();
        int r1 = com.bytedance.android.shopping.buynow.opt.d.a;
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        if (((Boolean) ECSettingKeys.c.getValue()).booleanValue() == false) goto L5;
        int r0 = com.bytedance.android.ec.core.buynow.b.a;
    L5:
        com.bytedance.android.shopping.buynow.opt.d.c(r3);
    }

    @Override // sc3.c
    public final void f(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "sessionId");
        n r0 = com.bytedance.android.shopping.buynow.starter.k.a(r7);
        if ((r0 instanceof BuyNowStarterOpt) == true) goto L5;
        r0 = null;
    L5:
        BuyNowStarterOpt r1 = (BuyNowStarterOpt) r0;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter("duplicate_request", "errorType");
        LinkedHashMap r3 = new LinkedHashMap();
        Map r4 = r1.k.b();
        if (r4 == null) goto L10;
        r3.putAll(r4);
    L10:
        r3.put("buynow_session_id", r1.j);
        int r5 = d.a;
        d.b(r1.k);
        r3.put("EVENT_PAGE_TECHNOLOGY", null);
        String r2 = r1.k.getQueryParam("eztf_sdk_extra");
        if (r2 == null) goto L15;
        JSONObject r6 = z1.g(r2);
        if (r6 == null) goto L15;
        Object r9 = r6.opt(PdpOpenThirdParam.KEY_SOURCE_PAGE);
    L16:
        r3.put("eztf_source_page", r9);
        com.bytedance.android.shopping.buynow.monitor.error.a.a(null, "duplicate_request", r8, r3);
    L15:
        r9 = null;
    L17:
        com.bytedance.android.shopping.buynow.starter.k.c(r7);
        com.bytedance.android.shopping.skubuy.start_flow.b.a.i(r7);
    }

    @Override // sc3.c
    public final void g(Context r14, IOrderSchema r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "orderSchema");
        r15.z0();
        HashMap r1 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.a(r15);
        String r2 = r15.getQueryParam("ultimate_buy_ab");
        if (r2 != null) goto L5;
        r2 = "0";
    L5:
        int r6 = k.r(r2, 0);
        r15.j1();
        String r10 = r15.getQueryParam("source_btm_token");
        ConcurrentHashMap r3 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("ec_sku_buy_arch_opt_host"), 1) == false) goto L17;
        if (r6 <= 0) goto L17;
        if (r15.C() == false) goto L17;
        String r4 = r15.getQueryParam("check_parallel_id");
        if (r4 == null) goto L15;
        int r16 = com.bytedance.android.shopping.skubuy.start_flow.a.c;
        Intrinsics.checkNotNullParameter(r4, "checkParallelID");
        d43.a<String, Starter> r17 = com.bytedance.android.shopping.skubuy.start_flow.b.a;
        Starter r18 = (Starter) r17.b(r4);
        if (r18 == null) goto L59;
        r18.b();
        r17.i(r4);
        return;
    L59:
        return;
    L15:
        com.bytedance.android.shopping.skubuy.start_flow.a r5 = new com.bytedance.android.shopping.skubuy.start_flow.a();
        EntranceInfoScene r7 = new EntranceInfoScene("ecomLive", "orderUrl");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "schemaModel");
        Intrinsics.checkNotNullParameter(r7, "entranceInfoScene");
        u43.a.e(r5, PerformancePointType.C_PAGE_START);
        u43.a.e(r5, PerformancePointType.PARSE_SCHEMA_START);
        ((u43.a) r5).b = r15;
        r5.a(r14);
        return;
    L17:
        String r9 = r15.getQueryParam("check_parallel_id");
        Object r8 = null;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r9) == false) goto L31;
        n r11 = com.bytedance.android.shopping.buynow.starter.k.a(r9);
        if ((r11 instanceof BuyNowStarterOpt) == false) goto L23;
        r8 = r11;
    L23:
        BuyNowStarterOpt r12 = (BuyNowStarterOpt) r8;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r14, "context");
        r12.q();
        int r19 = BuyNowTemplateMgr.a;
        BuyNowTemplateMgr.a(r14, r12.n(), true);
        if (ja3.a.c(r12.k) == false) goto L28;
        com.bytedance.android.shopping.buynow.opt.a.a(r14);
    L28:
        r12.p(r14, r12.k);
        r12.r();
        return;
    L29:
        int r0 = BuyNowStarterOpt.q;
        BuyNowStarterOpt.a.a(r15, s(), r9, r10, false, 40).o(r14);
        return;
    L31:
        Object r13 = Boolean.FALSE;
        if (r6 <= 0) goto L56;
        if (r15.C() == true) goto L56;
        String r20 = r15.getQueryParam("is_single_sku");
        if (r20 != null) goto L38;
        r20 = "-1";
    L38:
        int r21 = k.r(r20, -1);
        if (r21 <= 0) goto L54;
        BuyNowLog.d("BuyNowRouter", "try ultimate buy");
        Activity r22 = ECAppInfoService.e.getCurrentActivity();
        if ((r22 instanceof FragmentActivity) == true) goto L43;
        r22 = null;
    L43:
        FragmentActivity r23 = (FragmentActivity) r22;
        if (r23 == null) goto L56;
        FragmentManager r24 = r23.getSupportFragmentManager();
        if (r24 == null) goto L56;
        int r25 = ECSdk.a;
        IEShoppingService r26 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r26 == null) goto L50;
        i r27 = r26.getSkuYataService();
    L51:
        if (r27 == null) goto L53;
        r8 = Boolean.valueOf(r27.o(r24, r15, r6, r21, r10));
    L53:
        BuyNowLog.d("BuyNowRouter", "ultimate buy isUltimateBuyConsumed:" + r8);
        r13 = r8;
        goto L56
    L50:
        r27 = null;
        goto L51
    L54:
        Lazy r28 = BuyNowLog.a;
        BuyNowLog.d("BuyNowRouter", "isSingleSku is not Valid " + r21);
    L56:
        if ((!Intrinsics.areEqual(r13, Boolean.TRUE)) == false) goto L62;
        BuyNowLog.d("BuyNowRouter", "BuyNowStarter create open buy now");
        int r29 = BuyNowStarterOpt.q;
        BuyNowStarterOpt.a.a(r15, s(), null, r10, false, 44).o(r14);
        return;
    }

    @Override // sc3.c
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        fa3.c.b(Completable.fromAction(new b(r2, r3)).subscribeOn(Schedulers.io()).subscribe());
    }

    @Override // sc3.c
    public final String m(Context r8, IOrderSchema r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "orderSchema");
        String r0 = UUID.randomUUID().toString();
        r9.z0();
        HashMap r1 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.a(r9);
        r9.j1();
        r9.replaceOrAppendParam("check_parallel_id", r0);
        int r2 = BuyNowStarterOpt.q;
        BuyNowStarterOpt.a.a(r9, s(), r0, r9.getQueryParam("source_btm_token"), true, 8).m(r8);
        return r0;
    }

    @Override // sc3.c
    public final String q(String r3, EntranceInfoScene r4) {
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        Intrinsics.checkNotNullParameter(r4, "entranceInfoScene");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        int r2 = ECSdk.a;     // Catch: Throwable -> L17
        IECCommonService r5 = (IECCommonService) ECSdk.a(IECCommonService.class);     // Catch: Throwable -> L17
        if (r5 == null) goto L15;
        IOrderSchema r6 = r5.convertToOrderSchema(r3, r4);     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        r6.z0();     // Catch: Throwable -> L17
        HashMap r7 = com.bytedance.android.ec.core.hybrid.utils.j.a;     // Catch: Throwable -> L17
        com.bytedance.android.ec.core.hybrid.utils.j.a(r6);     // Catch: Throwable -> L17
        OrderSchema.b r8 = r6.P0();     // Catch: Throwable -> L17
        if (r8 != null) goto L10;
        r8 = r6.P();     // Catch: Throwable -> L17
    L10:
        if (r8 == null) goto L12;
        JSONObject r9 = r8.e();     // Catch: Throwable -> L17
    L13:
        r6.T(r9);     // Catch: Throwable -> L17
        return u0.d(new e(r6, null, true).a(true).a);
    L12:
        r9 = null;
    L15:
        Result.constructor-impl(null);     // Catch: Throwable -> L17
    L19:
        return null;
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // sc3.c
    public final String r(Context r8, IOrderSchema r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "orderSchema");
        r9.z0();
        HashMap r1 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.a(r9);
        r9.j1();
        String r2 = r9.getQueryParam("ultimate_buy_ab");
        if (r2 != null) goto L5;
        r2 = "0";
    L5:
        int r3 = k.r(r2, 0);
        ConcurrentHashMap r4 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("ec_sku_buy_arch_opt_host"), 1) == false) goto L12;
        if (r3 <= 0) goto L12;
        if (r9.C() == false) goto L12;
        com.bytedance.android.shopping.skubuy.start_flow.a r5 = new com.bytedance.android.shopping.skubuy.start_flow.a();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "schemaModel");
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        ((u43.a) r5).b = r9;
        r9.replaceOrAppendParam("check_parallel_type", "prefetch");
        com.bytedance.android.shopping.abscontainer.arch.core.starter.c r10 = r5.f(r8);
        Starter r0 = new Starter(r10, r8);
        com.bytedance.android.shopping.skubuy.start_flow.b.a.c(r10.a.getSessionID(), r0);
        com.bytedance.android.shopping.abscontainer.arch.core.starter.d r11 = r0.b.a;
        int r6 = j43.d.a;
        r11.a = Long.valueOf(System.currentTimeMillis());
        r0.a();
        return r10.a.getSessionID();
    L12:
        String r7 = UUID.randomUUID().toString();
        int r12 = BuyNowStarterOpt.q;
        BuyNowStarterOpt.a.a(r9, s(), r7, r9.getQueryParam("source_btm_token"), false, 40).m(r8);
        return r7;
    }

    @Override // sc3.c
    public final void l(ql.a r5, l r6, BuyNowPrefetchType r7) {
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(r7, "type");
        int r2 = com.bytedance.android.shopping.buynow.opt.d.a;
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(r7, "type");
        dm.a.a("BuyNowPrefetcher").a("prefetchOnLiveRoom");
        if (r5 != null) goto L6;
        return;
    L6:
        if (r7 != BuyNowPrefetchType.FIRST_SHOW) goto L8;
        fa3.c.b(Completable.timer(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.shopping.buynow.opt.b(r5, r6, r7), com.bytedance.android.shopping.buynow.opt.c.a));
        return;
    L8:
        dm.a.a("BuyNowPrefetchPitayaJudger").a("prefetchIfNeedWithDelay after 0s");
        com.bytedance.android.shopping.buynow.opt.d.d(r5, r6, r7);
    }

    @Override // sc3.c
    public final String a(Uri r11, UltimateBuyParams r12, UltimateBuyStyleParams r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "ultimateBuyParams");
        Intrinsics.checkNotNullParameter(r13, "styleParams");
        String r3 = UUID.randomUUID().toString();
        Activity r0 = ECAppInfoService.e.getCurrentActivity();
        if (r0 == null) goto L17;
        int r1 = BuyNowStarter.w;
        r12.getSkuParams();
        BuyNowStarter r15 = BuyNowStarter.a.a(r11, null, r3, r12, r13, new la3.e(null, null, null, null), r14, false);
        if (((Boolean) ECSettingKeys.c.getValue()).booleanValue() == false) goto L15;
        Map<String, UltimateBuyCacheQueryHelper> r16 = UltimateBuyCacheHelper.b;
        com.bytedance.android.shopping.buynow.starter.f r17 = r15.c;
        if (r17 == null) goto L9;
        com.bytedance.android.shopping.buynow.cache.a r18 = r17.a;
    L11:
        if (UltimateBuyCacheHelper.a(r18) == true) goto L14;
        BuyNowLog.d("BuyNowPrefetchPitayaJudger", "resp cache is NOT valid");
        r r19 = r15.s(r0, true, true);
        int r110 = t0.a;
        return GsonProtectorUtils.toJson(t0.a.a, r19);
    L14:
        BuyNowLog.d("BuyNowPrefetchPitayaJudger", "resp cache is valid");
        goto L17
    L9:
        r18 = null;
        goto L11
    L15:
        BuyNowLog.d("BuyNowPrefetchPitayaJudger", "Old Prefetch Chain");
        r r111 = r15.s(r0, true, true);
        int r112 = t0.a;
        return GsonProtectorUtils.toJson(t0.a.a, r111);
    L17:
        return null;
    }

    @Override // sc3.c
    public final String h(Uri r12, UltimateBuyParams r13, UltimateBuyStyleParams r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "ultimateBuyParams");
        Intrinsics.checkNotNullParameter(r14, "styleParams");
        Activity r0 = ECAppInfoService.e.getCurrentActivity();
        if (r0 == null) goto L6;
        int r2 = BuyNowStarter.w;
        r13.getSkuParams();
        r r16 = BuyNowStarter.a.a(r12, null, "forDiff", r13, r14, new la3.e(null, null, null, null), r15, true).s(r0, true, false);
        int r17 = t0.a;
        return GsonProtectorUtils.toJson(t0.a.a, r16);
    L6:
        return null;
    }

    @Override // sc3.c
    public final String d(Uri r12, UltimateBuyParams r13, UltimateBuyStyleParams r14, String r15, Object r16, Function1 r17, Function1 r18, Function1 r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r13, "ultimateBuyParams");
        Intrinsics.checkNotNullParameter(r14, "styleParams");
        fa3.c.b(Completable.fromAction(new ta3.b(r13)).subscribeOn(Schedulers.io()).subscribe());
        ECAppInfoService r0 = ECAppInfoService.e;
        Activity r8 = r0.getCurrentActivity();
        if (r8 == null) goto L13;
        Activity r9 = r0.c(r8, r20);
        String r10 = UUID.randomUUID().toString();
        int r1 = BuyNowStarter.w;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r2 = s();
        r13.getSkuParams();
        Object r3 = r16;
        if ((r3 instanceof cf.t) == true) goto L7;
        r3 = null;
    L7:
        BuyNowStarter r4 = BuyNowStarter.a.b(r12, r2, r10, r13, r14, new la3.e((cf.t) r3, r17, r18, r19), r15, 128);
        if (r9 == null) goto L11;
        r8 = r9;
    L11:
        r4.t(r8);
        return r10;
    L13:
        BuyNowLog.d("BuyNowService", "showSkuBuyNowPanel, current activity 为null");
        return null;
    }
}
