package com.bytedance.pia.core.worker.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes21.dex */
public interface IWorkerRetrofitApi {
    @DELETE
    @Streaming
    Call<TypedInput> deleteStreamRequest(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102);

    @GET
    @Streaming
    Call<TypedInput> getStreamRequest(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102);

    @HEAD
    @Streaming
    Call<TypedInput> headStreamRequest(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102);

    @OPTIONS
    @Streaming
    Call<TypedInput> optionsStreamRequest(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102);

    @PATCH
    @Streaming
    Call<TypedInput> patchStreamRequest(@AddCommonParam boolean r100, @Url String r101, @Body RequestBody r102, @HeaderList List<Header> r103);

    @POST
    @Streaming
    Call<TypedInput> postStreamRequest(@AddCommonParam boolean r100, @Url String r101, @Body RequestBody r102, @HeaderList List<Header> r103);

    @PUT
    @Streaming
    Call<TypedInput> putStreamRequest(@AddCommonParam boolean r100, @Url String r101, @Body RequestBody r102, @HeaderList List<Header> r103);
}
