package com.bytedance.android.shopping.feed.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.feed.model.SaveMoneyCardMarketingInfoResponse;
import com.bytedance.retrofit2.http.GET;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/InnerAdditionalApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/feed/model/SaveMoneyCardMarketingInfoResponse;", "fetchMarketingMember", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface InnerAdditionalApi {
    public static final a a = null;

    public static final class a {
        public static final InnerAdditionalApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (InnerAdditionalApi) n.a.create("https://ecom.snssdk.com", InnerAdditionalApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("https://ecom.snssdk.com/marketing/member/marketing_info")
    Observable<SaveMoneyCardMarketingInfoResponse> fetchMarketingMember();
}
