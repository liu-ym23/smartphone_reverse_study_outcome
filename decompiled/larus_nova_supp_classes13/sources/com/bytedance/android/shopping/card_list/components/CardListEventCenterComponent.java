package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.eventcenter.event.CardListRefresh;
import com.bytedance.android.shopping.card_list.eventcenter.event.OpenCrossShopDiscountFunction;
import com.bytedance.android.shopping.card_list.eventcenter.event.OpenDiscountPanelFunction;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfAnchorScroll;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfChangeCounterActive;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfCloseHybridPopupView;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfHandleEventWhenAppearFunction;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfOpenHalfHybridView;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfPublishEvent;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfRecommendReset;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfSubscribeBridgeEvent;
import com.bytedance.android.shopping.card_list.eventcenter.event.SelfToastFunction;
import com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.AddToCart;
import com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.FindMore;
import com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.ProductClick;
import com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.RecommendShowTrackerFunction;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListEventCenterComponent extends com.bytedance.android.shopping.card_list.components.b {
    public final ConcurrentHashMap<String, String> d;
    public final g e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final String j;
    public final Lazy k;
    public final CardListEventCenterComponent$applyMarketingCoupon$1 l;
    public final c m;
    public final b n;
    public final CardListEventCenterComponent$cartChangeSkuSubscriber$1 o;
    public final CardListEventCenterComponent$nextPageEventSubScribe$1 p;
    public final d q;
    public final CardListObjectContainer r;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ CardListEventCenterComponent a;

        public b(CardListEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            JSONObject r11 = r10.optJSONObject("response");
            CardListEventCenterComponent r0 = this.a;
            if (r0.f == false) goto L19;
            Context r3 = r0.e();
            if (r3 == null) goto L19;
            if (r11 != null) goto L23;
        L12:
            if (r11 == null) goto L15;
            String r12 = r11.optString("msg");     // Catch: Exception -> L10
            if (r12 == null) goto L15;
        L16:
            ECToast r2 = ECToast.INSTANCE;     // Catch: Exception -> L10
            ECToast.showToast$default(r2, r3, r12, 0, null, 8, null);     // Catch: Exception -> L10
        L10:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L15:
            r12 = th.a.f(r3).getString(2131896360);     // Catch: Exception -> L10
            goto L16
        L23:
            if (r11.optInt("status_code") != 0) goto L12;
            r12 = th.a.f(r3).getString(2131896361);     // Catch: Exception -> L10
        L19:
            CardListQueryFetchComponent r13 = (CardListQueryFetchComponent) this.a.h.getValue();
            if (r13 == null) goto L25;
            int r1 = CardListQueryFetchComponent.x;
            r13.i(false, "add_cart_refresh", null);
            return;
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ CardListEventCenterComponent a;

        public c(CardListEventCenterComponent r1) {
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
            this.a.r.e.e.add(r1);
            return;
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ CardListEventCenterComponent a;

        public d(CardListEventCenterComponent r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            if (((h) this.a.i.getValue()) != null) goto L5;
            return;
        L5:
            HandleEventOpportunity r4 = HandleEventOpportunity.RECEIVE_PRODUCTS_CLEAN_UP;
            AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.a.r.e.c.invoke();
            Intrinsics.checkNotNullParameter(r4, "opportunity");
            Intrinsics.checkNotNullParameter(r0, "yataInstance");
            r4.getValue();
            throw null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        ECLiveHybridUtil.m("edit_select_cart_ids", this.m);
        ECLiveHybridUtil.m("cartListRefresh", this.l);
        ECLiveHybridUtil.m("ecom.sku.add.cart", this.n);
        ECLiveHybridUtil.m("cart_change_sku", this.o);
        ECLiveHybridUtil.m("next_page_event", this.p);
        ECLiveHybridUtil.m("productsCleanUp", this.q);
        this.r.e.k.put("edit_select_cart_ids", this.m);
        this.r.e.k.put("cartListRefresh", this.l);
        this.r.e.k.put("ecom.sku.add.cart", this.n);
        this.r.e.k.put("cart_change_sku", this.o);
        this.r.e.k.put("next_page_event", this.p);
        this.r.e.k.put("productsCleanUp", this.q);
        AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.r.e.c.invoke();
        r0.B("selfRecommendShowProduct", new RecommendShowTrackerFunction(this.r));
        r0.B("selfRecommendFindMore", new FindMore(this.r));
        r0.B("selfRecommendAddToCart", new AddToCart(this.r));
        r0.B("selfRecommendProductCardClick", new ProductClick(this.r));
        r0.B("selfQuitCart", new com.bytedance.android.shopping.card_list.eventcenter.event.e(this.r));
        r0.B("selfQuitCollect", new com.bytedance.android.shopping.card_list.eventcenter.event.e(this.r));
        r0.B("selfCartRefresh", new CardListRefresh(this.r));
        r0.B("selfOpenSkuPanel", new com.bytedance.android.shopping.card_list.eventcenter.event.d(this.e, this.r));
        r0.B("selfScrollToTop", new com.bytedance.android.shopping.card_list.eventcenter.event.b(this.r));
        r0.B("selfOpenCrossShopDiscount", new OpenCrossShopDiscountFunction(this.r));
        r0.B("selfOpenDiscountPanel", new OpenDiscountPanelFunction(this.r));
        r0.B("selfChangeCounterActive", new SelfChangeCounterActive(this.r));
        r0.A("selfShopSelectedWhenSelectCart", new bb3.b());
        r0.B("selfGetStorage", new com.bytedance.android.shopping.card_list.eventcenter.event.j());
        r0.B("selfDeleteSearchWord", new com.bytedance.android.shopping.card_list.eventcenter.event.c());
        r0.B("selfSetStorage", new com.bytedance.android.shopping.card_list.eventcenter.event.l());
        r0.A("selfSaveSearchWord", new com.bytedance.android.shopping.card_list.eventcenter.event.f());
        r0.B("selfAppendParamsToSchema", new com.bytedance.android.shopping.card_list.eventcenter.event.g(this.r));
        r0.B("selfOpenHybridPopupView", new SelfOpenHalfHybridView(this.r));
        r0.B("selfCartCloseHybridPopupView", new SelfCloseHybridPopupView(this.r));
        r0.B("selfPublishEvent", new SelfPublishEvent(this.r));
        r0.B("selfRecommendReset", new SelfRecommendReset(this.r));
        r0.B("selfSubscribeBridgeEvent", new SelfSubscribeBridgeEvent(this.r));
        r0.B("selfUnsubscribeBridgeEvent", new com.bytedance.android.shopping.card_list.eventcenter.event.n(this.r));
        r0.B("selfAnchorScroll", new SelfAnchorScroll(this.r));
        r0.B("selfHandleEventWhenAppear", new SelfHandleEventWhenAppearFunction(this.r));
        r0.B("selfDelay", new com.bytedance.android.shopping.card_list.eventcenter.event.h(this.r));
        r0.B("selfOpenOrCloseSortPanel", new com.bytedance.android.shopping.card_list.eventcenter.event.k(this.r));
        r0.B("selfPreCheck", new com.bytedance.android.shopping.card_list.eventcenter.event.m(this.r));
        r0.B("selfToast", new SelfToastFunction(this.r));
        r0.A("selfCheckFooter", new bb3.a());
        r0.B("cartHeaderTabChange", new com.bytedance.android.shopping.new_cart.eventcenter.event.o());
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        ECLiveHybridUtil.p("edit_select_cart_ids", this.m);
        ECLiveHybridUtil.p("cartListRefresh", this.l);
        ECLiveHybridUtil.p("ecom.sku.add.cart", this.n);
        ECLiveHybridUtil.p("cart_change_sku", this.o);
        ECLiveHybridUtil.p("next_page_event", this.p);
        Iterator<Map.Entry<String, ti.j>> r0 = this.r.e.k.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, ti.j> r1 = r0.next();
        ECLiveHybridUtil.p(r1.getKey(), r1.getValue());
        goto L4
    L6:
        this.r.e.k.clear();
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onStart() {
        super.onStart();
        this.f = true;
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onStop() {
        super.onStop();
        this.f = false;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.bytedance.android.shopping.card_list.components.CardListEventCenterComponent$cartChangeSkuSubscriber$1] */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.bytedance.android.shopping.card_list.components.CardListEventCenterComponent$nextPageEventSubScribe$1] */
    public CardListEventCenterComponent(CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.r = r3;
        this.d = new ConcurrentHashMap();
        this.e = new g(new CardListEventCenterComponent$actions$1(this));
        this.g = LazyKt.lazy(new CardListEventCenterComponent$bodyComponent$2(this));
        this.h = LazyKt.lazy(new CardListEventCenterComponent$queryComponent$2(this));
        this.i = LazyKt.lazy(new CardListEventCenterComponent$eventHandleComponent$2(this));
        CardPassThroughData r4 = r3.e.a;
        if (r4 == null) goto L5;
        String r5 = r4.getMonitorId();
    L6:
        this.j = r5;
        this.k = LazyKt.lazy(new CardListEventCenterComponent$monitorManager$2(this));
        this.l = new CardListEventCenterComponent$applyMarketingCoupon$1(this);
        this.m = new c(this);
        this.n = new b(this);
        this.o = new CardListEventCenterComponent$cartChangeSkuSubscriber$1(this);
        this.p = new CardListEventCenterComponent$nextPageEventSubScribe$1(this);
        this.q = new d(this);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
