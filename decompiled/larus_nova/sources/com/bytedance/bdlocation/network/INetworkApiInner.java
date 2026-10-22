package com.bytedance.bdlocation.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface INetworkApiInner {
    @GET
    Call<String> doGet(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @FieldMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105, @AddCommonParam boolean r106);
}
