package com.bytedance.android.shopping.deepfeed.data.api;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import uc3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/DeepFeedCouponApi;", "", "", "creativeId", "requestId", "scene", "Lio/reactivex/Observable;", "Luc3/c;", "checkCouponStatus", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DeepFeedCouponApi {
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

    @GET("/api/incentive/coupon/qcpx/info")
    Observable<c> checkCouponStatus(@Query("cid") String r1, @Query("req_id") String r2, @Query("scene") String r3);
}
