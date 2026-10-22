package com.bytedance.locallife.hybrid.bridge.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface CommonApi {
    @DELETE
    Call<String> doDelete(@Url String r100);

    @DELETE
    Call<String> doDelete(@Url String r100, @MaxLength int r101, @HeaderList List<Header> r102);

    @DELETE
    Call<String> doDelete(@Url String r100, @HeaderList List<Header> r101);

    @DELETE
    Call<String> doDelete(@Url String r100, @QueryMap Map<String, String> r101);

    @GET
    Call<String> doGet(@Url String r100);

    @GET
    Call<String> doGet(@Url String r100, @MaxLength int r101);

    @GET
    Call<String> doGet(@Url String r100, @MaxLength int r101, @QueryMap Map<String, String> r102);

    @GET
    Call<String> doGet(@Url String r100, @QueryMap Map<String, String> r101);

    @GET
    Call<String> doGet(@Url String r100, @QueryMap Map<String, String> r101, @HeaderList List<Header> r102);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @MaxLength int r101, @FieldMap Map<String, String> r102);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @MaxLength int r101, @FieldMap Map<String, String> r102, @QueryMap Map<String, String> r103);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @FieldMap Map<String, String> r101);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @FieldMap Map<String, String> r101, @HeaderList List<Header> r102);

    @POST
    Call<String> postBody(@Url String r100, @Body TypedOutput r101, @HeaderList List<Header> r102);

    @PUT
    Call<String> putBody(@Url String r100, @Body TypedOutput r101, @HeaderList List<Header> r102);
}
