package com.bytedance.lynx.service.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface NetApi {
    @GET
    Call<TypedInput> doGet(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @GET
    @Priority(2)
    Call<TypedInput> doGetHigh(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @GET
    @Priority(3)
    Call<TypedInput> doGetImmediate(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @GET
    @Priority(0)
    Call<TypedInput> doGetLow(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @GET
    @Streaming
    Call<TypedInput> doGetStreaming(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @POST
    @Streaming
    Call<TypedInput> doPost(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @Body TypedOutput r105, @ExtraInfo Object r106);

    @POST
    @Priority(2)
    @Streaming
    Call<TypedInput> doPostHigh(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @Body TypedOutput r105, @ExtraInfo Object r106);

    @POST
    @Priority(3)
    @Streaming
    Call<TypedInput> doPostImmediate(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @Body TypedOutput r105, @ExtraInfo Object r106);

    @POST
    @Priority(0)
    @Streaming
    Call<TypedInput> doPostLow(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @Body TypedOutput r105, @ExtraInfo Object r106);

    @POST
    @Streaming
    Call<TypedInput> doPostStreaming(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @Body TypedOutput r105, @ExtraInfo Object r106);
}
