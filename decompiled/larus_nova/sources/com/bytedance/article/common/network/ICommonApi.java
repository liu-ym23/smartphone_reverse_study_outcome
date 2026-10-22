package com.bytedance.article.common.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r100, @Url String r101, @HeaderList List<Header> r102, @AddCommonParam boolean r103);

    @POST
    Call<String> postData(@MaxLength int r100, @Url String r101, @Body TypedOutput r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @POST
    Call<TypedInput> postDataStream(@MaxLength int r100, @Url String r101, @Body TypedOutput r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r100, @Url String r101, @FieldMap(encode = true) Map<String, String> r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);
}
