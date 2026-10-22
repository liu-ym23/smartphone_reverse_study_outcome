package com.bytedance.ug.sdk.luckydog.tokenunion.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface CommonApi {
    @POST
    Call<String> getDataForPost(@Url String r100, @Body Map<String, String> r101, @HeaderList List<Header> r102);
}
