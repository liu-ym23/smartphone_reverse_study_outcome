package com.bytedance.android.shopping.prepurchase.business.pdp.services.event;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.anchorv3.utils.r;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4Repository;
import com.bytedance.android.shopping.anchorv4.data.api.AnchorV4Api;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.l;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.n;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vg3.w;
import vg3.x;
import vg3.y;
import vg3.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductDetailEventService extends b0 implements w {
    public static final /* synthetic */ int u = 0;
    public PageMeta i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public LocalTestEventRecorder o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public PageMeta t;

    public final class a implements com.bytedance.android.ecom.arch.slice.render.context.c {
        public boolean a;
        public final /* synthetic */ ProductDetailEventService b;

        public final void c() {
            Intrinsics.checkNotNullParameter("slice_sdk_error", "eventName");
        }

        public final Function1<com.bytedance.android.ecom.arch.slice.render.event.a, Unit> a() {
            y r0 = (y) this.b.R1().getService(y.class);
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r1 = r0.V();
            if (r1 == null) goto L7;
            return r1.h;
        L7:
            return null;
        }

        public a(ProductDetailEventService r1) {
            this.b = r1;
            this.a = true;
        }

        public final void b(String r8, Map<String, ? extends Object> r9) {
            Intrinsics.checkNotNullParameter(r8, "eventName");
            if (this.a == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual("create_view", r8) == true) goto L8;
            return;
        L8:
            if (r9 == null) goto L10;
            Object r0 = r9.get("success");
        L12:
            if (Intrinsics.areEqual(r0, "1") == false) goto L29;
            Object r1 = r9.get("template_url");
            if ((r1 instanceof String) == true) goto L16;
            r1 = null;
        L16:
            String r2 = (String) r1;
            if (r2 != null) goto L20;
            r2 = "";
        L20:
            if (this.b.r != null) goto L25;
            if (StringsKt.contains$default(r2, "ecom_pdp_card_template", false, 2, null) == false) goto L25;
            this.b.r = String.valueOf(r9.get("gecko_version"));
            ProductDetailEventService r3 = this.b;
            r3.c2("ecom_gecko_version", r3.r);
        L25:
            if (this.b.s != null) goto L29;
            if (StringsKt.contains$default(r2, "pdp_slice_template", false, 2, null) == false) goto L29;
            this.b.s = String.valueOf(r9.get("gecko_version"));
            ProductDetailEventService r10 = this.b;
            r10.c2("pdp_gecko_version", r10.s);
        L29:
            ProductDetailEventService r11 = this.b;
            if (r11.r != null) goto L32;
            return;
        L32:
            if (r11.s == null) goto L37;
            this.a = false;
            return;
        L37:
            return;
        L10:
            r0 = null;
            goto L12
        }
    }

    public final class b implements z, m {
        public final m a;

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final boolean a(String r2, boolean r3, String r4, PageFinder r5) {
            Intrinsics.checkNotNullParameter(r2, "actionName");
            return this.a.a(r2, r3, r4, r5);
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "actionName");
            return this.a.b(r2);
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m c(View r2, String r3, PageFinder r4) {
            Intrinsics.checkNotNullParameter(r3, "btmId");
            return this.a.c(r2, r3, r4);
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m d(Map<String, ? extends Object> r2) {
            return this.a.d(r2);
        }

        public b(m r2) {
            Intrinsics.checkNotNullParameter(r2, "stdTracker");
            this.a = r2;
        }
    }

    public static final class c implements com.bytedance.android.shopping.anchorv3.utils.d {
        public final /* synthetic */ ProductDetailEventService a;

        public final ECAdLogExtra getAdLogExtra() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            CommonMeta r1 = r0.getCommonMeta();
            if (r1 == null) goto L7;
            return r1.getAdLogExtra();
        L7:
            return null;
        }

        public final Object getButtonStatus() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            LinkedTreeMap r1 = r0.getTrackMeta();
            if (r1 == null) goto L7;
            return r1.get("button_status");
        L7:
            return null;
        }

        public final String getProductId() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            CommonMeta r1 = r0.getCommonMeta();
            if (r1 == null) goto L7;
            return r1.getProductId();
        L7:
            return null;
        }

        public final long getDuration() {
            return SystemClock.uptimeMillis() - this.a.l;
        }

        public c(ProductDetailEventService r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.bytedance.android.shopping.anchorv3.utils.d {
        public final /* synthetic */ ProductDetailEventService a;

        public final ECAdLogExtra getAdLogExtra() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            CommonMeta r1 = r0.getCommonMeta();
            if (r1 == null) goto L7;
            return r1.getAdLogExtra();
        L7:
            return null;
        }

        public final Object getButtonStatus() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            LinkedTreeMap r1 = r0.getTrackMeta();
            if (r1 == null) goto L7;
            return r1.get("button_status");
        L7:
            return null;
        }

        public final String getProductId() {
            PageMeta r0 = this.a.i;
            if (r0 == null) goto L7;
            CommonMeta r1 = r0.getCommonMeta();
            if (r1 == null) goto L7;
            return r1.getProductId();
        L7:
            return null;
        }

        public final long getDuration() {
            return SystemClock.uptimeMillis() - this.a.l;
        }

        public d(ProductDetailEventService r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements g {
        public final /* synthetic */ ProductDetailEventService a;

        public e(ProductDetailEventService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r10) {
            boolean r11 = ((Boolean) r10).booleanValue();
            ProductDetailEventService r0 = this.a;
            if (r11 == true) goto L5;
            r0.getClass();
            r0.n = SystemClock.uptimeMillis();
        L10:
            if (r0.a2().getNativeParams().getFullMode() == true) goto L23;
            if (r11 == true) goto L13;
        L15:
            CommonMeta r12 = r0.d2();
            if (r12 == null) goto L24;
            String r13 = r12.getEntranceInfo();
            if (r13 == null) goto L25;
            JSONObject r14 = k.w(r13);
            if (r14 == null) goto L26;
            String r1 = r14.optString("creative_id");
            s83.g r2 = AdLogUtils.a;
            AdLogUtils.g(r1, r14.optString("log_extra"));
            return;
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L13:
            if (m.a.a(r0.m().d(MapsKt.mapOf(TuplesKt.to("btm", "a1.b8094.c0.d0"))), "draw_product_detail_page", false, null, PageFinder.via(r0.O1().getContainerAbility().k7()), 4) != true) goto L15;
            w.a.a(r0, "draw_product_detail_page", null, 6);
            goto L15
        L23:
            return;
        L5:
            if (r0.n <= 0) goto L7;
            r0.m += SystemClock.uptimeMillis() - r0.n;
        L7:
            r0.n = 0;
            goto L10
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        LocalTestEventRecorder r0 = this.o;
        if (r0 == null) goto L12;
        List r1 = (List) r0.a.getValue();
        HashSet r2 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();
        com.bytedance.android.shopping.anchorv4.tracker.b r6 = (com.bytedance.android.shopping.anchorv4.tracker.b) r5;
        if (r2.add(new Pair(r6.b(), r6.a())) == false) goto L6;
        r3.add(r5);
        goto L6
    L10:
        String r7 = GsonProtectorUtils.toJson(new Gson(), CollectionsKt.toMutableList(r3));
        AnchorV4Api.a.getClass();
        bg4.b.b(AnchorV4Api.a.a.saveEventRelations(MapsKt.mapOf(new Pair[]{TuplesKt.to("events", r7), TuplesKt.to("os", "android")}))).subscribe(com.bytedance.android.shopping.prepurchase.business.pdp.services.event.a.a, com.bytedance.android.shopping.prepurchase.business.pdp.services.event.b.a);
    L12:
        if (this.p == true) goto L14;
        Set r8 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.d r9 = ECProcessMonitor.o();
        int r10 = com.bytedance.android.ec.core.monitor.listener.d.k;
        r9.j(-6, null);
    L14:
        Set r11 = ECProcessMonitor.a;
        ECProcessMonitor.s(this.j, a2().getSessionId());
        if ((O1().d().q0() instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c) == false) goto L21;
        b r12 = m();
        if (a2().getNativeParams().getFullMode() == false) goto L19;
        String r13 = "full_screen";
    L20:
        m.a.a(r12.d(MapsKt.mapOf(TuplesKt.to("page_type", r13))), "close_product_detail_preload", false, null, null, 14);
        goto L21
    L19:
        r13 = "half_screen";
    L21:
        super.U1();
    }

    @Override // vg3.w
    public final LinkedTreeMap<String, Object> getTrackMeta() {
        PageMeta r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTrackMeta();
    }

    @Override // vg3.w
    public final b m() {
        return new b(O1().a().m());
    }

    @Override // vg3.w
    public final void t1() {
        CommonMeta r6 = O1().d().getData().a().a();
        Pair[] r2 = new Pair[13];
        r2[0] = TuplesKt.to("log_id", O1().d().getData().d());
        if (r6 == null) goto L5;
        String r0 = r6.getSkuId();
    L6:
        r2[1] = TuplesKt.to("sku_id", r0);
        if (r6 == null) goto L9;
        Long r1 = r6.getProductMinPrice();
    L10:
        r2[2] = TuplesKt.to("effective_min_price", r1);
        if (r6 == null) goto L13;
        Long r3 = r6.getDiscountMinPrice();
    L14:
        r2[3] = TuplesKt.to("discount_min_price", r3);
        if (r6 == null) goto L17;
        Long r4 = r6.getRegularPrice();
    L18:
        r2[4] = TuplesKt.to("regular_price", r4);
        if (r6 == null) goto L21;
        Long r5 = r6.getSubsidyPrice();
    L22:
        r2[5] = TuplesKt.to("subsidy_price", r5);
        if (r6 == null) goto L25;
        Long r7 = r6.getSubsidyMarketPrice();
    L26:
        r2[6] = TuplesKt.to("subsidy_market_price", r7);
        if (r6 == null) goto L29;
        String r8 = r6.getProductBuyStatus();
    L30:
        r2[7] = TuplesKt.to("product_buy_status", r8);
        if (this.q == false) goto L33;
        String r9 = "3_4";
    L34:
        r2[8] = TuplesKt.to("main_pic_size", r9);
        boolean r10 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getIECHostUserService().isLogin() == false) goto L37;
        String r11 = "1";
    L38:
        r2[9] = TuplesKt.to("is_auth", r11);
        r2[10] = TuplesKt.to("has_frame_image", Boolean.valueOf(k.c(a2().getNativeParams().getFrameCovImage())));
        if (r6 == null) goto L41;
        String r12 = r6.getSourcePage();
    L42:
        r2[11] = TuplesKt.to("frame_image_identifier", r12);
        r2[12] = TuplesKt.to("is_new_pdp", Boolean.TRUE);
        Map<? extends String, ? extends Object> r13 = MapsKt.mutableMapOf(r2);
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "logEnterProductDetail " + a2().getSessionId() + ' ' + O1().a().u1());
        b r14 = m();
        Map<String, ? extends Object> r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("btm", "a1.b8094.c0.d0"), TuplesKt.to("friends_ecom_tag", a2().getNativeParams().getTopLabelText())});
        r15.putAll(r13);
        Unit r16 = Unit.INSTANCE;
        m.a.a(r14.d(r15), "enter_product_detail", false, null, getPageFinder(), 6);
        Map r17 = com.bytedance.android.ec.core.monitor.k.a;
        Pair[] r18 = new Pair[2];
        if (r6 == null) goto L48;
        if (r6.getFromLive() != true) goto L48;
        String r19 = "live";
    L51:
        r18[0] = TuplesKt.to("pdp_type", r19);
        r18[1] = TuplesKt.to("status", "0");
        Map r20 = MapsKt.mutableMapOf(r18);
        r20.putAll(r13);
        PageMeta r21 = (PageMeta) O1().d().getData().b.a();
        if (r21 == null) goto L56;
        LinkedTreeMap r22 = r21.getTrackMeta();
        if (r22 == null) goto L56;
        r20.putAll(r22);
    L56:
        int r23 = ECSdk.a;
        pi.b r24 = (pi.b) ECSdk.a(pi.b.class);
        if (r24 == null) goto L59;
        r24.monitorEvent("ec_perf_page_show_product_detail", new JSONObject(r20), null, null);
    L59:
        this.p = true;
        int r25 = com.bytedance.android.shopping.base.event.c.a;
        com.bytedance.android.shopping.base.event.c.h(a2().getSessionId());
        return;
    L48:
        if (a2().getNativeParams().getFullMode() != true) goto L50;
        r19 = "full";
        goto L51
    L50:
        r19 = "video";
        goto L51
    L41:
        r12 = null;
        goto L42
    L37:
        r11 = "0";
        goto L38
    L33:
        r9 = "1_1";
        goto L34
    L29:
        r8 = null;
        goto L30
    L25:
        r7 = null;
        goto L26
    L21:
        r5 = null;
        goto L22
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        this.l = SystemClock.uptimeMillis();
        if (e2() == true) goto L5;
        long r0 = SystemClock.uptimeMillis();
    L6:
        this.n = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        this.j = System.currentTimeMillis();
        og3.a r0 = O1().f().a.c;
        Object r1 = O1().getContainerAbility().k7();
        if ((r1 instanceof Activity) == false) goto L6;
        BtmSDK.INSTANCE.registerBtmPageOnCreate((Activity) r1, r0.a, r0.b);
    L8:
        com.bytedance.android.shopping.anchorv4.data.k r2 = AnchorV4DataManager.a;
        String r3 = a2().getSessionId();
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        AnchorV4Repository r4 = AnchorV4DataManager.m(r3);
        if (r1 == null) goto L11;
        r4.g = new WeakReference(r1);
    L11:
        Z1(x.class, new ProductDetailEventService$onAttach$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new e(this));
        O1().e().r().K1(new a(this));
        AbsComponent.Y1(this, w.class, this, false, 12);
        if (ECAppInfoService.e.isDebug() == true) goto L14;
        return;
    L14:
        if (ECSettingKeys.G0() == false) goto L20;
        this.o = new LocalTestEventRecorder();
        O1().a().y1(new ProductDetailEventService$onAttach$3(this));
        return;
    L20:
        return;
    L6:
        if ((r1 instanceof Fragment) == false) goto L18;
        BtmSDK.INSTANCE.registerBtmPageOnCreate((Fragment) r1, r0.a, r0.b);
        goto L8
    L18:
        throw new IllegalStateException("Unsupported type " + r1);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        this.k += SystemClock.uptimeMillis() - this.l;
        boolean r0 = e2();
        CommonMeta r1 = d2();
        if (r1 == null) goto L29;
        String r2 = h73.a.b(r1);
        if (r2 == null) goto L29;
        CommonMeta r4 = d2();
        if (r4 == null) goto L11;
        Map r5 = h73.a.a(r4);
        if (r5 == null) goto L11;
        r5.put("duration", String.valueOf(this.k));
    L12:
        CommonMeta r6 = d2();
        if (r6 == null) goto L18;
        ECAdLogExtra r7 = r6.getAdLogExtra();
        if (r7 == null) goto L18;
        String r8 = r7.getLogExtra();
        if (r8 == null) goto L18;
    L26:
        AdLogUtils.s(r2, r5, r8, "product_detail_ad");
        if (r0 == true) goto L29;
        AdLogUtils.s(r2, r5, r8, "landing_ad");
    L18:
        CommonMeta r9 = d2();
        if (r9 == null) goto L25;
        String r10 = r9.getEntranceInfo();
        if (r10 == null) goto L25;
        JSONObject r11 = k.w(r10);
        if (r11 == null) goto L25;
        r8 = r11.optString("log_extra");
    L25:
        r8 = null;
    L11:
        r5 = null;
    L29:
        b r3 = m();
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(SystemClock.uptimeMillis() - this.l)), TuplesKt.to("btm", "a1.b8094.c0.d0")});
        if (a2().getNativeParams().getFullMode() == false) goto L32;
    L37:
        Unit r13 = Unit.INSTANCE;
        if (m.a.a(r3.d(r12).c(null, "a1.b8094.c0.d0", getPageFinder()), "commodity_duration", false, null, PageFinder.via(this), 6) != true) goto L41;
        w.a.a(this, "commodity_duration", null, 6);
        return;
    L41:
        return;
    L32:
        if (e2() == false) goto L34;
    L36:
        r12.put("half_duration", Long.valueOf(this.m));
        goto L37
    L34:
        if (this.n <= 0) goto L36;
        this.m += SystemClock.uptimeMillis() - this.n;
        goto L36
    }

    public final CommonMeta d2() {
        return O1().d().getData().a().a();
    }

    public final boolean e2() {
        return !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.FALSE);
    }

    @Override // vg3.w
    public final PageFinder getPageFinder() {
        return O1().a().getPageFinder();
    }

    public ProductDetailEventService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b2(ProductDetailEventService r9, l r10) {
        r9.getClass();
        PageMeta r1 = ((n) r10.b).a;
        if (r1 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r9.t, r1) == false) goto L8;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r9, "same pageMeta, skip " + r9.a2().getSessionId());
        return;
    L8:
        r9.t = r1;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r9, "try proceed pageMeta, " + r9.a2().getSessionId());
        PageFinder r0 = r9.O1().a().getPageFinder();
        LinkedTreeMap r2 = r1.getTrackMeta();
        if (r2 == null) goto L11;
        Object r3 = r2.get("entrance_info");
    L13:
        if ((r3 instanceof String) == true) goto L15;
        r3 = null;
    L15:
        String r4 = EcomBcmTracker.b(r0, (String) r3);
        BcmParams r5 = new BcmParams();
        CommonMeta r6 = r1.getCommonMeta();
        if (r6 == null) goto L18;
        String r7 = r6.getProductId();
    L19:
        r5.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r7);
        CommonMeta r8 = r1.getCommonMeta();
        if (r8 == null) goto L22;
        String r11 = r8.getPromotionId();
    L23:
        r5.put("commodity_id", r11);
        JSONObject r12 = k.w(((com.bytedance.android.shopping.prepurchase.business.pdp.e) r9.O1().f().b).a.getNativeParams().getBcmParams());
        if (r12 == null) goto L26;
        String r13 = r12.optString("bcm_share_id");
    L27:
        String r14 = a2.d(r13);
        if (r14 == null) goto L30;
        r5.put("bcm_share_id", r14);
    L30:
        Unit r15 = Unit.INSTANCE;
        com.bytedance.android.bcm.api.b.e(r0, "page_show", r5);
        BtmSDK r16 = BtmSDK.INSTANCE;
        BcmParams.a r17 = BcmParams.Companion;
        CommonMeta r18 = r1.getCommonMeta();
        if (r18 == null) goto L33;
        Map r19 = r18.getPdpBcmParams();
    L34:
        r17.getClass();
        r16.setBcmPageParams(r0, BcmParams.a.c(r19), true);
        LinkedTreeMap r20 = r1.getTrackMeta();
        if (r20 == null) goto L37;
        r20.put("entrance_info", r4);
        r20.put("gecko_channel_version", Long.valueOf(wh.a.a("ecom_pdp_card_template")));
        r20.put("pdp_session_id", r9.a2().getSessionId());
        LinkedTreeMap r21 = r20;
    L38:
        PageMeta r22 = PageMeta.copy$default(r1, null, r21, null, null, null, 29, null);
        ((n) r10.b).a = r22;
        r9.c2("ecom_gecko_version", r9.r);
        r9.c2("pdp_gecko_version", r9.s);
        Map<String, ? extends Object> r110 = r22.getTrackMeta();
        if (r110 == null) goto L41;
        r9.O1().a().appendEventParams(r110);
    L41:
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r9, "try proceed pageMeta end " + r9.a2().getSessionId());
        r9.i = r22;
        return;
    L37:
        r21 = null;
        goto L38
    L33:
        r19 = null;
        goto L34
    L26:
        r13 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r7 = null;
        goto L19
    L11:
        r3 = null;
        goto L13
    }

    public final void c2(String r4, String r5) {
        O1().a().appendEventParams(new Pair[]{TuplesKt.to(r4, r5)});
    }

    @Override // vg3.w
    public final void E0(String r2, Map<String, Object> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        PageMeta r0 = this.i;
        if (r0 == null) goto L5;
        CommonMeta r1 = r0.getCommonMeta();
    L6:
        if (r4 == false) goto L11;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isLuban() == true) goto L11;
        return;
    L11:
        d r5 = new d(this);
        int r6 = r.a;
        r.a(r2, r5, r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // vg3.w
    public final void n1(jq.a r3, Map<String, ? extends Object> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "logData");
        Intrinsics.checkNotNullParameter(r4, "extra");
        PageMeta r0 = this.i;
        if (r0 == null) goto L5;
        CommonMeta r1 = r0.getCommonMeta();
    L6:
        if (r5 == false) goto L11;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isLuban() == true) goto L11;
        return;
    L11:
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = ((LinkedHashMap) r4).entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r7.next();
        String r8 = (String) r2.getKey();
        Object r9 = r2.getValue();
        if (r9 == null) goto L13;
        r6.put(r8, r9);
        goto L13
    L17:
        Map r10 = r3.i();
        if (r10 == null) goto L20;
        r6.putAll(r10);
    L20:
        int r11 = r.a;
        r.a(r3.g(), new c(this), r6);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
