package com.larus.init.task.accountsdk;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0014\b\u0003\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J^\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J^\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0001\u0010\r\u001a\u00020\u00012\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0011"}, d2 = {"Lcom/larus/init/task/accountsdk/FlowAccountSaasApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "", "relativePath", "addCommonPara", "", "queryMap", "", "headerMap", "requestContext", "doPostWithRequestBody", ContainerPosition.BODY, "Lokhttp3/RequestBody;", "headers", "doPost", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface FlowAccountSaasApi {
    @GET
    Call<String> doGet(@Url String r100, @AddCommonParam boolean r101, @QueryMap Map<String, String> r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @POST
    Call<String> doPost(@Url String r100, @QueryMap Map<String, String> r101, @Body Object r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @POST
    Call<String> doPostWithRequestBody(@Url String r100, @QueryMap Map<String, String> r101, @Body RequestBody r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);
}
