package com.larus.office.base.net;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H§@¢\u0006\u0002\u0010\bJB\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005H'¨\u0006\u0010"}, d2 = {"Lcom/larus/office/base/net/FlowDocNetApi;", "", "httpGet", "Lcom/larus/office/base/net/FlowDocNetResponse;", "url", "", "headers", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpPost", ContainerPosition.BODY, "Lokhttp3/RequestBody;", "(Ljava/lang/String;Ljava/util/Map;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lokhttp3/Call;", "fileUrl", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FlowDocNetApi {
    @GET
    @Streaming
    Call downloadFile(@Url String r100);

    @GET
    Object httpGet(@Url String r100, @HeaderMap Map<String, String> r101, Continuation<? super FlowDocNetResponse<Object>> r102);

    @POST
    Object httpPost(@Url String r100, @HeaderMap Map<String, String> r101, @Body RequestBody r102, Continuation<? super FlowDocNetResponse<Object>> r103);
}
