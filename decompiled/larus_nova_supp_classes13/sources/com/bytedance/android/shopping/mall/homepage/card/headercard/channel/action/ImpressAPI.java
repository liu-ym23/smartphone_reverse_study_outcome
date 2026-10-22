package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ:\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/ImpressAPI;", "", "", "", "headerMap", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/ImpressionRequestBody;", "body", "pageName", "Lio/reactivex/Observable;", "postActivityListImpression", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ImpressAPI {
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

    @POST("/aweme/v2/commerce/activity/list/impression")
    Observable<Object> postActivityListImpression(@HeaderMap Map<String, String> r1, @Body ImpressionRequestBody r2, @Query(PdpOpenThirdParam.KEY_PAGE_NAME) String r3);
}
