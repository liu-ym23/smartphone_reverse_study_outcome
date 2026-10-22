package com.bytedance.android.livesdk.livecommerce.room.host.network;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;
import okhttp3.k;
import si2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0015J0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'JH\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\nH'J<\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'J0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'JH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'J<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'JT\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/host/network/LiveCommerceApi;", "", "", "url", "", "fieldMap", "Lcom/bytedance/retrofit2/Call;", "post", "headerMap", "postWithCustomHeader", "Lokhttp3/RequestBody;", "body", "postBody", "postBodyWithHeader", "queryMap", "get", "getWithCustomHeader", "Lokhttp3/k$b;", "file", "postMultipart", "postMultipartWithHeader", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveCommerceApi {
    public static final a a = null;

    public static final class a {
        public static LiveCommerceApi a;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (LiveCommerceApi) n.a.create(g.a, LiveCommerceApi.class);
        }

        public static LiveCommerceApi a() {
            if (a != null) goto L6;
            a = (LiveCommerceApi) n.a.create(g.a, LiveCommerceApi.class);
        L6:
            return a;
        }
    }

    static {
        a = a.b;
    }

    @GET
    Call<String> get(@Url String r1, @QueryMap Map<String, String> r2);

    @GET
    Call<String> getWithCustomHeader(@Url String r1, @QueryMap Map<String, String> r2, @HeaderMap Map<String, String> r3);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String r1, @FieldMap Map<String, String> r2);

    @POST
    Call<String> postBody(@Url String r1, @Body RequestBody r2);

    @POST
    Call<String> postBodyWithHeader(@Url String r1, @Body RequestBody r2, @HeaderMap Map<String, String> r3);

    @Multipart
    @POST
    Call<String> postMultipart(@Url String r1, @QueryMap Map<String, String> r2, @Part k.b r3);

    @Multipart
    @POST
    Call<String> postMultipartWithHeader(@Url String r1, @QueryMap Map<String, String> r2, @Part k.b r3, @HeaderMap Map<String, String> r4);

    @FormUrlEncoded
    @POST
    Call<String> postWithCustomHeader(@Url String r1, @FieldMap Map<String, String> r2, @HeaderMap Map<String, String> r3);
}
