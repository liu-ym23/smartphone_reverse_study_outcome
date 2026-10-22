package com.bytedance.android.shopping.collect.repo;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/collect/repo/CollectYataApi;", "", "Lqb3/b;", "request", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "", "getQuery", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CollectYataApi {
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

    @POST("aweme/v2/collects/yata/query")
    Observable<SsResponse<String>> getQuery(@Body qb3.b r1);
}
