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
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface ITuringNetworkApi {
    @GET
    Call<String> doGet(@AddCommonParam boolean r1, @Url String r2, @QueryMap Map<String, String> r3, @HeaderList List<Header> r4);

    @POST
    @Streaming
    Call<String> doPost(@Url String r1, @QueryMap Map<String, String> r2, @Body TypedOutput r3, @HeaderList List<Header> r4);
}
