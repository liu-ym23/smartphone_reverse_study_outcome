package com.bytedance.awemeopen.infra.plugs.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface BdpNetworkTTNetApi {
    @HTTP(hasBody = true, method = "DELETE")
    Call<TypedInput> delete(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);

    @GET
    Call<TypedInput> getRaw(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @HeaderList List<Header> r103, @ExtraInfo Object r104, @AddCommonParam boolean r105);

    @GET
    @Streaming
    Call<TypedInput> getStream(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @HeaderList List<Header> r103, @ExtraInfo Object r104, @AddCommonParam boolean r105);

    @HEAD
    Call<Void> head(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @HeaderList List<Header> r103, @ExtraInfo Object r104, @AddCommonParam boolean r105);

    @OPTIONS
    Call<TypedInput> options(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);

    @PATCH
    Call<TypedInput> patch(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);

    @POST
    Call<TypedInput> post(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);

    @POST
    Call<String> postBody(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @PUT
    Call<TypedInput> put(@MaxLength int r100, @Url String r101, @QueryMap(encode = true) Map<String, String> r102, @Body TypedOutput r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);
}
