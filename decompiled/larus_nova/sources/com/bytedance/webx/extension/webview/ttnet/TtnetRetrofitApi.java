package com.bytedance.webx.extension.webview.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface TtnetRetrofitApi {
    @GET
    @Streaming
    Call<TypedInput> streamRequest(@Url String r100, @HeaderList List<Header> r101);
}
