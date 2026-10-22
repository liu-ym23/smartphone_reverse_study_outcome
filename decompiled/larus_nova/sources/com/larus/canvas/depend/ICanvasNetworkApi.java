package com.larus.canvas.depend;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\u00012\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\f"}, d2 = {"Lcom/larus/canvas/depend/ICanvasNetworkApi;", "", "streamPull", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "relativePath", "", "queryMap", "", ContainerPosition.BODY, "headers", "requestContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICanvasNetworkApi {
    @POST
    @Streaming
    Call<TypedInput> streamPull(@Url String r100, @QueryMap Map<String, String> r101, @Body Object r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);
}
