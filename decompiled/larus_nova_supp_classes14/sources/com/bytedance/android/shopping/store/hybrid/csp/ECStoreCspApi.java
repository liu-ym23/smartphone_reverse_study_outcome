package com.bytedance.android.shopping.store.hybrid.csp;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ=\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u001c\b\u0001\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004H'¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/csp/ECStoreCspApi;", "", "", "url", "", "", "content", "Lio/reactivex/Observable;", "report", "(Ljava/lang/String;[Ljava/util/Map;)Lio/reactivex/Observable;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECStoreCspApi {
    public static final a a = null;

    public static final class a {
        public static final ECStoreCspApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (ECStoreCspApi) n.a.create(gn.a.a(), ECStoreCspApi.class);
        }
    }

    static {
        a = a.b;
    }

    @Headers({"content-type: application/reports+json"})
    @POST
    Observable<String> report(@Url String r1, @Body Map<String, Object>[] r2);
}
