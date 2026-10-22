package com.bytedance.android.shopping.store.tabkit.brandmall;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJB\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabKitApi;", "", "", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/tabkit/model/z;", "fetchCustomTab", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TabKitApi {
    public static final a a = null;

    public static final class a {
        public static final TabKitApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (TabKitApi) n.a.create("https://ecom.snssdk.com", TabKitApi.class);
        }
    }

    static {
        a = a.b;
    }

    @Headers({"x-security-argus: tabkit"})
    @GET
    Observable<z> fetchCustomTab(@Url String r1, @QueryMap HashMap<String, Object> r2);
}
