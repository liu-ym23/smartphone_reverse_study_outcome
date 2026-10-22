package lg3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.orderlist.common.monitor.error.a {
    public final EventActionImpl a;
    public boolean b;
    public Long c;
    public final OrderSearchResultViewModel d;

    /* JADX INFO: renamed from: lg3.a$a, reason: collision with other inner class name */
    public static final class C0216a {
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
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("log_id", this.d.getStaticState().f);
        r0.putAll(r1);
        return r0;
    }

    public a(OrderSearchResultViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.d = r5;
        EventActionImpl r6 = new EventActionImpl();
        this.a = r6;
        r6.appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_search"), TuplesKt.to("btm", "a1.b5418.c0.d0"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("spma", "a1.b5418.c0.d0"), TuplesKt.to("font_scale", ECAppInfoService.e.getCurrentFontScale()), TuplesKt.to("gecko_channel_version", String.valueOf(wh.a.a("ecommerce_order_list_component")))}));
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
    public final void b(String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r7, "name");
        Intrinsics.checkNotNullParameter(r8, "params");
        EventActionImpl r0 = this.a;
        PageFinder r1 = this.d.getBtmPageFinder();
        LinkedHashMap r2 = new LinkedHashMap();
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("log_id", this.d.getStaticState().f);
        r2.putAll(r3);
        r2.putAll(r8);
        Unit r9 = Unit.INSTANCE;
        r0.doEventAction(r7, r1, r2);
    }
}
