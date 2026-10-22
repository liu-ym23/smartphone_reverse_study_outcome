package na3;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowApi;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ma3.m;
import ma3.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final g a = null;

    public g() {
    }

    static {
        a = new g();
    }

    public static String b(IOrderSchema r2) {
        Intrinsics.checkNotNullParameter(r2, "orderSchema");
        if (k.r(r2.getQueryParam("ultimate_buy_ab"), 0) <= 0) goto L6;
        return "/order/component/confirmOrder/";
    L6:
        if (Intrinsics.areEqual(r2.getHost(), "continue_pay") == false) goto L8;
        return "/order/yata/getPayMethod";
    L8:
        return "/order/yata/confirmOrderRender";
    }

    public static Observable c(ma3.f r10, String r11) {
        m r0 = r10.a;
        if ((r0 instanceof ma3.d) == true) goto L5;
        m r1 = null;
    L6:
        ma3.d r2 = (ma3.d) r1;
        g r3 = a;
        if (r2 == null) goto L11;
        return r3.query(r2, r10.b, r10.c, r10.d);
    L11:
        if ((r0 instanceof r) == true) goto L13;
        r0 = null;
    L13:
        r r4 = (r) r0;
        if (r4 != null) goto L16;
        return null;
    L16:
        return d(r4, r10.b, r10.c, r10.d, false, r11, 16);
    L5:
        r1 = r0;
        goto L6
    }

    public static Observable a(String r7, Map r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "url");
        BuyNowApi.a.getClass();
        BuyNowApi r1 = BuyNowApi.a.b;
        JSONObject r3 = com.bytedance.android.ec.hybrid.list.util.k.b(r8);
        int r11 = ECSdk.a;
        IAdapterService r12 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r12 == null) goto L5;
        String r13 = r12.getWebcastAppId();
    L7:
        return r1.queryPayStatus(r7, r3, r9, r10, r13);
    L5:
        r13 = null;
        goto L7
    }

    public final Observable<SsResponse<String>> query(ma3.d r8, int r9, int r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "req");
        BuyNowApi.a.getClass();
        BuyNowApi r1 = BuyNowApi.a.b;
        int r0 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L5;
        String r3 = r2.getWebcastAppId();
    L7:
        return r1.getQuery(r8, r9, r10, r11, r3);
    L5:
        r3 = null;
        goto L7
    }

    public static Observable d(r r8, int r9, int r10, Integer r11, boolean r12, String r13, int r14) {
        if ((r14 & 16) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 32) == 0) goto L8;
        r13 = "/order/component/confirmOrder/";
    L8:
        Intrinsics.checkNotNullParameter(r8, "req");
        if (r12 == false) goto L11;
        UltimateBuyNowApi.a.getClass();
        return UltimateBuyNowApi.a.b.getPrefetchForUltimateBuy(r8, r9, r10, r11, null);
    L11:
        UltimateBuyNowApi.a.getClass();
        UltimateBuyNowApi r1 = UltimateBuyNowApi.a.b;
        if (r13 != null) goto L14;
        String r2 = "/order/component/confirmOrder/";
    L15:
        int r15 = ECSdk.a;
        IAdapterService r16 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r16 == null) goto L18;
        String r17 = r16.getWebcastAppId();
    L20:
        return r1.getQueryForUltimateBuy(r2, r8, r9, r10, r11, r17);
    L18:
        r17 = null;
        goto L20
    L14:
        r2 = r13;
        goto L15
    }
}
