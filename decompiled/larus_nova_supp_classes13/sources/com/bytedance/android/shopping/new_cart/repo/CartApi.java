package com.bytedance.android.shopping.new_cart.repo;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import wf3.b;
import wf3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u0001H'J;\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0002\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/repo/CartApi;", "", "data", "Lio/reactivex/Observable;", "Lwf3/b;", "getCouponSchema", "", "requestScene", "maxLength", "Lwf3/c;", "Lcom/bytedance/retrofit2/SsResponse;", "", "getQuery", "(Ljava/lang/Integer;ILwf3/c;)Lio/reactivex/Observable;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CartApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @POST("/cart/marketingResourceSchema")
    Observable<b> getCouponSchema(@Body Object r1);

    @POST("cart/yata/query")
    Observable<SsResponse<String>> getQuery(@Query("request_scene") Integer r1, @MaxLength int r2, @Body c r3);
}
