package com.bytedance.android.shopping.deepfeed.data.api;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Single;
import kotlin.Metadata;
import uc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/DeepFeedImpressionApi;", "", "Luc3/d;", "data", "Lio/reactivex/Single;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "impressionReport", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DeepFeedImpressionApi {
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

    @POST("/aweme/v2/commerce/common/impression")
    Single<CommerceBaseResponse> impressionReport(@Body d r1);
}
