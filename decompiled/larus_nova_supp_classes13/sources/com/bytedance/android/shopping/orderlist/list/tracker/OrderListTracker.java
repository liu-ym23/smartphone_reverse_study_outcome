package com.bytedance.android.shopping.orderlist.list.tracker;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.o;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListTracker implements com.bytedance.android.shopping.orderlist.common.monitor.error.a {
    public final EventActionImpl a;
    public boolean b;
    public Long c;
    public final Map<String, Object> d;
    public final OrderListViewModel e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/tracker/OrderListTracker$ChangeTabType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SLIDE", "CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChangeTabType extends Enum<ChangeTabType> {
        public static final ChangeTabType CLICK = null;
        public static final ChangeTabType SLIDE = null;
        public static final /* synthetic */ ChangeTabType[] a = null;
        private final String value;

        static {
            ChangeTabType r1 = new ChangeTabType("SLIDE", 0, PageScrollStatus.slide);
            SLIDE = r1;
            ChangeTabType r2 = new ChangeTabType("CLICK", 1, "click");
            CLICK = r2;
            a = new ChangeTabType[]{r1, r2};
        }

        public static ChangeTabType valueOf(String r1) {
            return (ChangeTabType) r27.a.a(ChangeTabType.class, r1);
        }

        public static ChangeTabType[] values() {
            return (ChangeTabType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public ChangeTabType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final void a() {
        b("ecom_page_screenshot", MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final Map<String, Object> c() {
        Map<String, Object> r0 = MapsKt.toMutableMap(this.a.c());
        r0.putAll(d());
        return r0;
    }

    public final Map<String, Object> d() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.e.getStaticState().a());
        r0.put("log_id", this.e.getStaticState().e);
        return r0;
    }

    public final void e() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        OrderListParams r0 = this.e.getStaticState().g;
        if (r0 == null) goto L8;
        Map<String, String> r1 = r0.getSchemaParamsMap();
    L9:
        if (r1 == null) goto L15;
        String r2 = r1.get("log_pv");
        if (r2 == null) goto L15;
        JSONObject r3 = z1.g(o.a(r2));
        if (r3 == null) goto L15;
        Map<String, ? extends Object> r4 = z1.j(r3);
    L16:
        b("page_view", r4);
        return;
    L15:
        r4 = MapsKt.emptyMap();
        goto L16
    L8:
        r1 = null;
        goto L9
    }

    public OrderListTracker(OrderListViewModel r18) {
        Intrinsics.checkNotNullParameter(r18, "viewModel");
        this.e = r18;
        EventActionImpl r1 = new EventActionImpl();
        this.a = r1;
        r1.appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_page"), TuplesKt.to("btm", "a1.b6871.c0.d0"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("spma", "a1.b6871.c0.d0"), TuplesKt.to("font_scale", ECAppInfoService.e.getCurrentFontScale()), TuplesKt.to("gecko_channel_version", String.valueOf(wh.a.a("ecommerce_order_list_component")))}));
        this.d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("page", BuyNowUrlType.ORDER_LIST), TuplesKt.to("received_count", 0), TuplesKt.to("is_failover", 0)});
    }

    public final void f(Map<String, j> r11) {
        Intrinsics.checkNotNullParameter(r11, "selfRegisterJsSubscriber");
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        final Map<String, ? extends Object> r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "BRIDGE_ERROR"), TuplesKt.to("desc", "jsb_unregister"), TuplesKt.to("detail", CollectionsKt.joinToString$default(r11.keySet(), ",", null, null, 0, null, null, 62, null))});
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListTracker", new OrderListTracker$reportJsbUnRegister$1(this, r12));
        b("ies_ecommerce_fe_custom_log", r12);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
    public final void b(String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "params");
        EventActionImpl r0 = this.a;
        PageFinder r1 = this.e.getBtmPageFinder();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(d());
        r2.putAll(r6);
        Unit r7 = Unit.INSTANCE;
        r0.doEventAction(r5, r1, r2);
    }

    public final void g(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.d.put(r2, r3);
    }
}
