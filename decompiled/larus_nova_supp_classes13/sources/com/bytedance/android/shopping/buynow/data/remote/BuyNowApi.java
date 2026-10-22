package com.bytedance.android.shopping.buynow.data.remote;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;
import ma3.d;
import ma3.j;
import ma3.k;
import ma3.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0018JQ\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\n2\b\b\u0001\u0010\u000e\u001a\u00020\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH'JQ\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b0\n2\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/remote/BuyNowApi;", "", "Lma3/d;", "data", "", "bTypeNew", "subBType", "shape", "", "webcastAppId", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "getQuery", "(Lma3/d;IILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "url", "Lorg/json/JSONObject;", "checkPayParams", "Lma3/p;", "queryPayStatus", "Lma3/j;", "params", "Lma3/k;", "createOrder", "(Lma3/j;IILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface BuyNowApi {
    public static final a a = null;

    public static final class a {
        public static final String a = null;
        public static final BuyNowApi b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            if (BuyNowPerformanceOpt.k() == false) goto L5;
            String r0 = "https://ec5-core.ecombdapi.com/";
        L6:
            a = r0;
            b = (BuyNowApi) n.a.create(r0, BuyNowApi.class);
            return;
        L5:
            r0 = OrderCommonApi.API_HOST;
            goto L6
        }
    }

    static {
        a = a.c;
    }

    @POST("/order/yata/createOrder")
    Observable<SsResponse<k>> createOrder(@Body j r1, @Query("b_type_new") int r2, @Query("sub_b_type") int r3, @Query("buy_render_shape") Integer r4, @Query("webcast_appid") String r5);

    @POST("/order/yata/confirmOrderRender")
    Observable<SsResponse<String>> getQuery(@Body d r1, @Query("b_type_new") int r2, @Query("sub_b_type") int r3, @Query("buy_render_shape") Integer r4, @Query("webcast_appid") String r5);

    @FormUrlEncoded
    @POST
    Observable<SsResponse<p>> queryPayStatus(@Url String r1, @Field("json_form") JSONObject r2, @Query("b_type_new") int r3, @Query("sub_b_type") int r4, @Query("webcast_appid") String r5);
}
