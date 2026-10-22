package com.bytedance.android.shopping.deepfeed.data.api;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/DeepFeedProductFeedBFFApi;", "", "", "", "params", "Lio/reactivex/Single;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductResponse;", "loadInflowFeed", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DeepFeedProductFeedBFFApi {
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

    @GET("/aweme/v2/commerce/bff/deep/feed")
    Single<InFeedProductResponse> loadInflowFeed(@QueryMap Map<String, String> r1);
}
