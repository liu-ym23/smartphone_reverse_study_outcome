package com.bytedance.ug.sdk.luckycat.container.prefetch;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IPrefetchNetworkApi {
    @GET
    Call<String> fetchGet(@Url String r100, @AddCommonParam boolean r101, @HeaderList List<Header> r102, @QueryMap Map<String, String> r103, @ExtraInfo Object r104);

    @POST
    Call<String> fetchPost(@Url String r100, @AddCommonParam boolean r101, @HeaderList List<Header> r102, @Body TypedByteArray r103, @ExtraInfo Object r104);

    @FormUrlEncoded
    @POST
    Call<String> fetchPost(@Url String r100, @AddCommonParam boolean r101, @HeaderList List<Header> r102, @FieldMap Map<String, String> r103, @ExtraInfo Object r104);
}
