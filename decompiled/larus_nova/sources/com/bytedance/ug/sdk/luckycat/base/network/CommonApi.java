package com.bytedance.ug.sdk.luckycat.base.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface CommonApi {
    @GET
    Call<String> getDataForGet(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102);

    @POST
    Call<String> getDataForPost(@Url String r100, @Body TypedOutput r101);

    @POST
    Call<String> getDataForPost(@Url String r100, @Body TypedOutput r101, @HeaderList List<Header> r102);

    @POST
    Call<String> getDataForPost(@Url String r100, @Body Map<String, String> r101);
}
