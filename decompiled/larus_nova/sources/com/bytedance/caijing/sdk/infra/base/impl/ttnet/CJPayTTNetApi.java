package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public interface CJPayTTNetApi {
    @GET
    Call<String> doGet(@MaxLength int r100, @AddCommonParam boolean r101, @Url String r102, @QueryMap Map<String, String> r103, @HeaderList List<Header> r104);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @FieldMap Map<String, String> r103, @HeaderList List<Header> r104);

    @FormUrlEncoded
    @POST
    @Priority(3)
    Call<String> doPostHighPriority(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @FieldMap Map<String, String> r103, @HeaderList List<Header> r104);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@Url String r100, @HeaderList List<Header> r101);

    @POST
    Call<String> postBody(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @Body TypedString r103, @HeaderList List<Header> r104);

    @POST
    @Priority(3)
    Call<String> postBodyHighPriority(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @Body TypedString r103, @HeaderList List<Header> r104);

    @POST
    Call<String> postMultiPart(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @HeaderList List<Header> r103, @Body TypedOutput r104);

    @Multipart
    @POST
    Call<String> postMultiPart(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @PartMap Map<String, TypedOutput> r103);

    @CJProtoRequest
    @POST
    Call<TypedInput> postPb(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @Body RequestBody r103, @HeaderList List<Header> r104);

    @CJProtoRequest
    @POST
    @Priority(3)
    Call<TypedInput> postPbHighPriority(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @Body RequestBody r103, @HeaderList List<Header> r104);
}
