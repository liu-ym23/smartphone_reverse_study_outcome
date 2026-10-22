package com.bytedance.android.shopping.card_list.repo;

import ab3.b;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0001H'J2\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\nH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/card_list/repo/CardListApi;", "", "", "url", "data", "Lio/reactivex/Observable;", "Lab3/a;", "getCouponSchema", "", "maxLength", "Lab3/b;", "Lcom/bytedance/retrofit2/SsResponse;", "getQuery", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CardListApi {
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

    @POST
    Observable<ab3.a> getCouponSchema(@Url String r1, @Body Object r2);

    @POST
    Observable<SsResponse<String>> getQuery(@Url String r1, @MaxLength int r2, @Body b r3);
}
