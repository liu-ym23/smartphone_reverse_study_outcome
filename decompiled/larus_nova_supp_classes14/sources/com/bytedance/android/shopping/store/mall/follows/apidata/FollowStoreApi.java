package com.bytedance.android.shopping.store.mall.follows.apidata;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJO\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022,\b\u0001\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0006H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApi;", "", "", "cursor", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mixFrameConfig", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreResponse;", "getFollowTabFeed", "(Ljava/lang/Long;Ljava/util/HashMap;)Lio/reactivex/Observable;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FollowStoreApi {
    public static final a a = null;

    public static final class a {
        public static final FollowStoreApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (FollowStoreApi) n.a.create("https://ecom.snssdk.com", FollowStoreApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("/ecom/repurchase/v1/follow/tab/feed/")
    Observable<FollowStoreResponse> getFollowTabFeed(@Query("cursor") Long r1, @QueryMap HashMap<String, Object> r2);
}
