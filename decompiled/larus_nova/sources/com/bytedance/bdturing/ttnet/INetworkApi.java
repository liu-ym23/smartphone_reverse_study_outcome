package com.bytedance.bdturing.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkApi {
    @GET
    Call<TypedInput> doGet(@AddCommonParam boolean r100, @Url String r101, @QueryMap Map<String, String> r102, @HeaderList List<Header> r103);

    @POST
    @Streaming
    Call<TypedInput> doPost(@Url String r100, @QueryMap Map<String, String> r101, @Body TypedOutput r102, @HeaderList List<Header> r103);
}
