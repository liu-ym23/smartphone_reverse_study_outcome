package com.bytedance.android.shopping.buynow.data.remote;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import ma3.h;
import ma3.j;
import ma3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'J2\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00072\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/remote/ContinuePayApi;", "", "Lma3/h;", "data", "", "bTypeNew", "subBType", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "", "getContinuePayQuery", "Lma3/j;", "params", "Lma3/k;", "createContinuePay", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ContinuePayApi {
    public static final a a = null;

    public static final class a {
        public static final ContinuePayApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            if (BuyNowPerformanceOpt.k() == false) goto L5;
            String r0 = "https://ec5-core.ecombdapi.com/";
        L6:
            a = (ContinuePayApi) n.a.create(r0, ContinuePayApi.class);
            return;
        L5:
            r0 = OrderCommonApi.API_HOST;
            goto L6
        }
    }

    static {
        a = a.b;
    }

    @POST("/order/yata/createPay")
    Observable<SsResponse<k>> createContinuePay(@Body j r1, @Query("b_type_new") int r2, @Query("sub_b_type") int r3);

    @POST("/order/yata/getPayMethod")
    Observable<SsResponse<String>> getContinuePayQuery(@Body h r1, @Query("b_type_new") int r2, @Query("sub_b_type") int r3);
}
