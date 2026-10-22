package com.larus.init.task.imsdk;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.im.internal.delegate.y0;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017Jh\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0014\b\u0003\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010\f\u001a\u00020\rH'Jt\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0014\b\u0003\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010\f\u001a\u00020\rH'Jh\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010\f\u001a\u00020\rH'Jh\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010\f\u001a\u00020\rH'J^\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J^\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0018"}, d2 = {"Lcom/larus/init/task/imsdk/IApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "", "relativePath", "addCommonPara", "", "queryMap", "", "headerMap", "requestContext", "maxLength", "", "doPost", "fieldMap", "doPostWithRequestBody", ContainerPosition.BODY, "Lokhttp3/RequestBody;", "headers", "streamPull", "Lcom/bytedance/retrofit2/mime/TypedInput;", "streamPullWithRequestBody", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface IApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a f351340a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f351341a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile int f351342b;

        public a() {
        }

        static {
            f351341a = new a();
            f351342b = -1;
        }

        public static int a() {
            if (f351342b != (-1)) goto L6;
            f351342b = y0.d().f348559y;
            com.larus.im.internal.delegate.c0.f348199b.i("NetworkDependImpl", "getNetPackageMaxLength:" + f351342b);
        L6:
            return f351342b;
        }
    }

    public static final class b {
        public static /* synthetic */ Call a(IApi r100, String r101, Map r102, Map r110, RequestContext r111) {
            IApi.f351340a.getClass();
            return r100.doGet(r101, true, r102, r110, r111, a.a());
        }

        public static /* synthetic */ Call b(IApi r100, String r101, Map r110, Object r111, Map r112, RequestContext r113) {
            IApi.f351340a.getClass();
            return r100.doPost(r101, r110, r111, r112, r113, a.a());
        }

        public static /* synthetic */ Call c(IApi r100, String r101, Map r110, RequestBody r111, Map r112, RequestContext r113) {
            IApi.f351340a.getClass();
            return r100.doPostWithRequestBody(r101, r110, r111, r112, r113, a.a());
        }
    }

    static {
        f351340a = a.f351341a;
    }

    @GET
    Call<String> doGet(@Url String r100, @AddCommonParam boolean r101, @QueryMap Map<String, String> r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104, @MaxLength int r105);

    @POST
    Call<String> doPost(@Url String r100, @QueryMap Map<String, String> r101, @Body Object r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104, @MaxLength int r105);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @QueryMap Map<String, String> r101, @FieldMap(encode = true) Map<String, String> r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104, @MaxLength int r105);

    @POST
    Call<String> doPostWithRequestBody(@Url String r100, @QueryMap Map<String, String> r101, @Body RequestBody r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104, @MaxLength int r105);

    @POST
    @Streaming
    Call<TypedInput> streamPull(@Url String r100, @QueryMap Map<String, String> r101, @Body Object r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @POST
    @Streaming
    Call<TypedInput> streamPullWithRequestBody(@Url String r100, @QueryMap Map<String, String> r101, @Body RequestBody r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);
}
