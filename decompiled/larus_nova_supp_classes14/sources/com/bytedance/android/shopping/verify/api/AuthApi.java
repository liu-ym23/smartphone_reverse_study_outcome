package com.bytedance.android.shopping.verify.api;

import cl3.b;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\rJ&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'J9\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/verify/api/AuthApi;", "", "", "userId", "appId", "Lio/reactivex/Observable;", "Lcl3/a;", "getAuthStatus", "", "authFlag", "Lcl3/b;", "authorizeSmallShop", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Observable;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AuthApi {
    public static final a a = null;

    public static final class a {
        public static final AuthApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (AuthApi) n.a.create("https://aweme.snssdk.com", AuthApi.class);
        }
    }

    static {
        a = a.b;
    }

    @GET("/aweme/v1/commerce/order/saveUserAuth/")
    Observable<b> authorizeSmallShop(@Query("user_id") String r1, @Query("app_id") String r2, @Query("auth_flag") Long r3);

    @GET("/aweme/v1/commerce/order/getUserAuth/")
    Observable<cl3.a> getAuthStatus(@Query("user_id") String r1, @Query("app_id") String r2);
}
