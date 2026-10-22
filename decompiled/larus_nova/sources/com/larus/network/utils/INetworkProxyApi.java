package com.larus.network.utils;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH'Jr\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH'Jr\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH'¨\u0006\u0013"}, d2 = {"Lcom/larus/network/utils/INetworkProxyApi;", "", MonitorConstants.CONNECT_TYPE_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonParams", "", "maxLength", "", "relativePath", "", "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "postByJson", ContainerPosition.BODY, "postByForm", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INetworkProxyApi {
    @GET
    @Streaming
    Call<TypedInput> get(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104);

    @FormUrlEncoded
    @POST
    @Streaming
    Call<TypedInput> postByForm(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @FieldMap Map<String, ? extends Object> r104, @HeaderList List<Header> r105);

    @POST
    @Streaming
    Call<TypedInput> postByJson(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @Body Map<String, ? extends Object> r104, @HeaderList List<Header> r105);
}
