package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.eventcenter.event.CartSelfRecommendReset;
import com.bytedance.android.shopping.new_cart.eventcenter.event.OpenDiscountPanelFunction;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfAnchorScroll;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfCartCloseHybridPopupView;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfOpenHalfHybridView;
import com.bytedance.android.shopping.new_cart.eventcenter.event.SelfSubscribeBridgeEvent;
import com.bytedance.android.shopping.new_cart.eventcenter.event.m;
import com.bytedance.android.shopping.new_cart.eventcenter.event.n;
import com.bytedance.android.shopping.new_cart.eventcenter.event.o;
import com.bytedance.android.shopping.new_cart.eventcenter.event.s;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartEventCenterComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public final CartViewModel b;
    public final ConcurrentHashMap<String, String> c;
    public final com.bytedance.android.shopping.new_cart.components.e d;
    public boolean e;
    public final Lazy f;
    public final CartEventCenterComponent$applyMarketingCoupon$1 g;
    public final d h;
    public final CartEventCenterComponent$addCartSubscriber$1 i;
    public final c j;
    public final CartEventCenterComponent$deleteCartId$1 k;
    public final CartEventCenterComponent$deleteShops$1 l;
    public final b m;
    public final e n;
    public final CartObjectContainer o;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ CartEventCenterComponent a;

        public static final class a implements Runnable {
            public final /* synthetic */ AndroidYaTaInstance a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Map c;

            public a(AndroidYaTaInstance r1, String r2, Map r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                YataEventCenter r0 = this.a.k();     // Catch: Throwable -> L8
                com.bytedance.kmp.ec.yata.event.common.e.a r1 = com.bytedance.kmp.ec.yata.event.common.e.a;     // Catch: Throwable -> L8
                AndroidYaTaInstance r2 = this.a;     // Catch: Throwable -> L8
                String r4 = this.b;     // Catch: Throwable -> L8
                Map r6 = this.c;     // Catch: Throwable -> L8
                if (r6 == null) goto L5;
                Map r7 = MapsKt.toMap(r6);     // Catch: Throwable -> L8
            L6:
                r0.d(r1.a(r2, null, r4, "cartChangeSku", r7, "cartChangeSkuSubscriber"));     // Catch: Throwable -> L8
                return;
            L5:
                r7 = null;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public b(CartEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r8) {
            Intrinsics.checkNotNullParameter(r8, "params");
            String r0 = r8.optString("uri", "");
            String r3 = r8.optString("skuInfo", "");
            boolean r5 = false;
            if (r0.length() != 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L8;
            return;
        L8:
            if (r3.length() != 0) goto L10;
            boolean r6 = true;
        L11:
            if (r6 == true) goto L32;
            JSONObject r7 = com.bytedance.android.ec.hybrid.list.util.k.c(r3);
            if (r7 != null) goto L16;
            return;
        L16:
            String r1 = this.a.c.get(r0);
            String r2 = r7.optString("sku_id", "");
            if (r1 == null) goto L30;
            if (r2 == null) goto L31;
            String r9 = r1;
            if (r2.length() != 0) goto L22;
            r5 = true;
        L22:
            if (r5 == false) goto L24;
            return;
        L24:
            Map<String, Object> r10 = com.bytedance.android.shopping.extensions.k.z(r8.optString("skuInfo"));
            if (r10 == null) goto L27;
            r10.put("combo_id", r2);
        L27:
            AndroidYaTaInstance r11 = (AndroidYaTaInstance) this.a.o.e.d.invoke();
            bg3.a r12 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.c(this.a.b, "cartChangeSkuSubscriber", new a(r11, r9, r10), null);
            return;
        L31:
            return;
        L30:
            return;
        L32:
            return;
        L10:
            r6 = false;
            goto L11
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ CartEventCenterComponent a;

        public c(CartEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            double r0 = r4.optDouble("slot_top_to_viewport_top_distance", 0.0d);
            float r1 = (float) r0;
            this.a.o.e.a = r1;
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ CartEventCenterComponent a;

        public d(CartEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            String r1 = null;
            String r4 = r3.optString("cart_ids", null);
            if (r4 != null) goto L5;
            return;
        L5:
            if (com.bytedance.android.shopping.extensions.k.c(r4) == false) goto L7;
            r1 = r4;
        L7:
            if (r1 == null) goto L11;
            this.a.o.e.f.add(r1);
            return;
        }
    }

    public static final class e implements ti.j {
        public final /* synthetic */ CartEventCenterComponent a;

        public static final class a implements Runnable {
            public final /* synthetic */ AndroidYaTaInstance a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Map d;

            public a(AndroidYaTaInstance r1, String r2, String r3, Map r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a, null, this.b, this.c, this.d, "nextPageEventSubScribe"));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(CartEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r7) {
            Intrinsics.checkNotNullParameter(r7, "params");
            JSONObject r0 = r7.optJSONObject("fields");
            if (r0 == null) goto L5;
            Map r1 = z1.k(r0);
        L6:
            JSONObject r2 = z1.f(r7.optString("session_params"));
            if ((!Intrinsics.areEqual(r2.optString("session_id", "none"), this.a.o.e.m)) == false) goto L9;
            return;
        L9:
            String r3 = r7.optString("type", "");
            String r4 = r2.optString("node_id", "");
            String r8 = r7.optString("cart_id", "");
            if (com.bytedance.android.shopping.extensions.k.c(r8) == true) goto L13;
            r8 = null;
        L13:
            if (r8 == null) goto L15;
            this.a.o.e.f.add(r8);
        L15:
            AndroidYaTaInstance r9 = (AndroidYaTaInstance) this.a.o.e.d.invoke();
            bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.c(this.a.b, "nextPageEventSubScribe", new a(r9, r4, r3, r1), null);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void l() {
        this.e = true;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void m() {
        this.e = false;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        ECLiveHybridUtil.m("edit_select_cart_ids", this.h);
        ECLiveHybridUtil.m("cartListRefresh", this.g);
        Lazy r0 = CartSettingUtils.a;
        Function0<Unit> r1 = new CartEventCenterComponent$registerJsEvents$1(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke();
        ECLiveHybridUtil.m("cart_change_sku", this.m);
        ECLiveHybridUtil.m("next_page_event", this.n);
        this.o.e.o.put("edit_select_cart_ids", this.h);
        this.o.e.o.put("cartListRefresh", this.g);
        this.o.e.o.put("ecom.sku.add.cart", this.i);
        this.o.e.o.put("cart_change_sku", this.m);
        this.o.e.o.put("next_page_event", this.n);
        c r2 = this.j;
        ECLiveHybridUtil.m("coudan_slot_info", r2);
        this.o.e.o.put("coudan_slot_info", r2);
        CartEventCenterComponent$deleteCartId$1 r3 = this.k;
        ECLiveHybridUtil.m("edit_unselect_cart_ids", r3);
        this.o.e.o.put("edit_unselect_cart_ids", r3);
        CartEventCenterComponent$deleteShops$1 r4 = this.l;
        ECLiveHybridUtil.m("edit_unselect_shop_ids", r4);
        this.o.e.o.put("edit_unselect_shop_ids", r4);
        AndroidYaTaInstance r5 = (AndroidYaTaInstance) this.o.e.d.invoke();
        r5.B("selfRecommendShowProduct", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.e(this.b));
        r5.B("selfRecommendFindMore", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.b(this.o));
        r5.B("selfRecommendAddToCart", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.a(this.o));
        r5.B("selfRecommendProductCardClick", new com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.d(this.o));
        r5.B("selfQuitCart", new m(this.o));
        r5.B("selfCartRefresh", new com.bytedance.android.shopping.new_cart.eventcenter.event.c(this.b));
        r5.B("selfCartModifyNetworkParam", new com.bytedance.android.shopping.new_cart.eventcenter.event.l(this.b));
        r5.B("selfOpenSkuPanel", new com.bytedance.android.shopping.new_cart.eventcenter.event.k(this.d, this.o));
        r5.B("selfScrollToTop", new com.bytedance.android.shopping.new_cart.eventcenter.event.f(this.b, this.o));
        r5.B("selfOpenCrossShopDiscount", new com.bytedance.android.shopping.new_cart.eventcenter.event.j(this.o));
        r5.B("selfOpenDiscountPanel", new OpenDiscountPanelFunction(this.o));
        r5.B("selfChangeCounterActive", new com.bytedance.android.shopping.new_cart.eventcenter.event.b(this.b, r5));
        r5.A("selfShopSelectedWhenSelectCart", new xf3.a());
        r5.B("selfGetStorage", new ib3.c());
        r5.B("selfDeleteSearchWord", new ib3.a());
        r5.B("selfSetStorage", new ib3.d());
        r5.A("selfSaveSearchWord", new ib3.b());
        r5.B("selfAppendParamsToSchema", new n(this.o));
        r5.B("selfOpenHybridPopupView", new SelfOpenHalfHybridView(this.o));
        r5.B("selfCartCloseHybridPopupView", new SelfCartCloseHybridPopupView(this.o));
        r5.B("selfPublishEvent", new com.bytedance.android.shopping.new_cart.eventcenter.event.g(this.b));
        r5.B("selfRecommendReset", new CartSelfRecommendReset(this.o));
        r5.B("selfSubscribeBridgeEvent", new SelfSubscribeBridgeEvent(this.o));
        r5.B("selfUnsubscribeBridgeEvent", new s(this.o));
        r5.B("selfAnchorScroll", new SelfAnchorScroll(this.o));
        r5.B("cartHeaderTabChange", new o());
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        ECLiveHybridUtil.p("edit_select_cart_ids", this.h);
        ECLiveHybridUtil.p("cartListRefresh", this.g);
        Lazy r0 = CartSettingUtils.a;
        Function0<Unit> r1 = new CartEventCenterComponent$unregisterJsEvents$1(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke();
        ECLiveHybridUtil.p("cart_change_sku", this.m);
        ECLiveHybridUtil.p("next_page_event", this.n);
        Iterator<Map.Entry<String, ti.j>> r2 = this.o.e.o.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, ti.j> r3 = r2.next();
        ECLiveHybridUtil.p(r3.getKey(), r3.getValue());
        goto L4
    L6:
        this.o.e.o.clear();
    }

    public CartEventCenterComponent(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.o = r2;
        this.b = this.a.d;
        this.c = new ConcurrentHashMap();
        this.d = new com.bytedance.android.shopping.new_cart.components.e(new CartEventCenterComponent$actions$1(this));
        this.f = LazyKt.lazy(new CartEventCenterComponent$bodyComponent$2(this));
        this.g = new CartEventCenterComponent$applyMarketingCoupon$1(this);
        this.h = new d(this);
        this.i = new CartEventCenterComponent$addCartSubscriber$1(this);
        this.j = new c(this);
        this.k = new CartEventCenterComponent$deleteCartId$1(this);
        this.l = new CartEventCenterComponent$deleteShops$1(this);
        this.m = new b(this);
        this.n = new e(this);
    }

    public static final void n(CartEventCenterComponent r2, JSONObject r3, Function0 r4) {
        r2.getClass();
        if ((!Intrinsics.areEqual(z1.f(r3.optString("session_params")).optString("session_id", "none"), r2.o.e.m)) == true) goto L7;
        r4.invoke();
        return;
    }
}
