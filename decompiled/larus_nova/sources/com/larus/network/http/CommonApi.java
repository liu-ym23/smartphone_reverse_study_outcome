package com.larus.network.http;

import androidx.core.app.NotificationCompat;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.larus.network.FlowHttpConnection;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014JV\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'Jn\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'J`\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'JR\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H'J^\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0001H'J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¨\u0006\u0015"}, d2 = {"Lcom/larus/network/http/CommonApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "", "relativePath", "queryMap", "", "headerMap", "extraInfo", "doPost", "fieldMap", ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "streamPull", "Lcom/bytedance/retrofit2/mime/TypedInput;", "headers", "requestContext", "startChunkHttp", "Lokhttp3/ResponseBody;", "Companion", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CommonApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f360115a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f360116a = null;

        static {
            f360116a = new a();
        }

        public a() {
        }

        public static dm9.a a(String r110, Type r111, String r112, boolean r113, Map r114, juc.d r115, Function1 r116) {
            Intrinsics.checkNotNullParameter(r110, "tag");
            Intrinsics.checkNotNullParameter(r111, "outType");
            Intrinsics.checkNotNullParameter(r116, NotificationCompat.CATEGORY_CALL);
            return FlowHttpConnection.f359975a.e(r110, r111, r112, CommonApi.class, r113, r114, r115, r116);
        }
    }

    static {
        f360115a = a.f360116a;
    }

    @GET
    Call<String> doGet(@Url String r100, @QueryMap Map<String, String> r101, @HeaderMap Map<String, String> r102, @ExtraInfo Object r103);

    @POST
    Call<String> doPost(@Url String r100, @QueryMap Map<String, String> r101, @Body TypedOutput r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @QueryMap Map<String, String> r101, @FieldMap(encode = true) Map<String, String> r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @GET
    @Streaming
    Call<ResponseBody> startChunkHttp(@Url String r100);

    @POST
    @Streaming
    Call<TypedInput> streamPull(@Url String r100, @QueryMap Map<String, String> r101, @Body TypedOutput r102, @HeaderMap Map<String, String> r103);

    @POST
    @Streaming
    Call<TypedInput> streamPull(@Url String r100, @QueryMap Map<String, String> r101, @Body TypedOutput r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);
}
