package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\rJY\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042,\b\u0001\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0007H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/TabKitMixFrameApi;", "", "", "url", "", "cursor", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mixFrameConfig", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/tabkit/mixframe/ECTabKitMixFrameResponse;", "getMixFrameData", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/HashMap;)Lio/reactivex/Observable;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TabKitMixFrameApi {
    public static final a a = null;

    public static final class a {
        public static final TabKitMixFrameApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (TabKitMixFrameApi) n.a.create("https://ecom.snssdk.com", TabKitMixFrameApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET
    Observable<ECTabKitMixFrameResponse> getMixFrameData(@Url String r1, @Query("cursor") Long r2, @QueryMap HashMap<String, Object> r3);
}
