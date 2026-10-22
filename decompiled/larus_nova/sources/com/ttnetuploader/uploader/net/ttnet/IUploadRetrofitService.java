package com.ttnetuploader.uploader.net.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes41.dex */
public interface IUploadRetrofitService {
    @GET
    Call<TypedInput> getCall(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102, @ExtraInfo Object r103);

    @POST
    Call<TypedInput> postCall(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102, @Body RequestBody r103, @ExtraInfo Object r104);

    @POST
    Call<String> postJsonCall(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102, @Body RequestBody r103, @ExtraInfo Object r104);

    @PUT
    Call<String> putCall(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102, @Body TypedOutput r103, @ExtraInfo Object r104);

    @Headers({"Content-Type: application/octet-stream"})
    @POST
    @Streaming
    Call<TypedInput> uploadFile(@Url String r100, @Body TypedOutput r101, @HeaderList List<Header> r102, @AddCommonParam boolean r103, @ExtraInfo Object r104);

    @POST
    Call<String> uploadMultipart(@Url String r100, @HeaderList List<Header> r101, @AddCommonParam boolean r102, @Body RequestBody r103, @ExtraInfo Object r104);
}
