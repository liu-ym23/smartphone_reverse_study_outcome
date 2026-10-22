package com.ss.android.bytedcert.adapter.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface NetService {
    @GET
    Call<String> doGet(@AddCommonParam boolean r100, @Url String r101, @QueryMap Map<String, String> r102, @HeaderList List<Header> r103, @ExtraInfo Object r104);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102, @FieldMap Map<String, String> r103, @ExtraInfo Object r104);

    @POST
    Call<String> postBody(@AddCommonParam boolean r100, @Url String r101, @HeaderList List<Header> r102, @Body TypedString r103, @ExtraInfo Object r104);

    @Multipart
    @POST
    Call<String> postMultiPart(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap Map<String, String> r103, @PartMap Map<String, TypedOutput> r104, @HeaderList List<Header> r105);
}
