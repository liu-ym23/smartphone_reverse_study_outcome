package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public interface ExpandCallback<T> extends Callback<T> {
    void onAsyncPreRequest(RequestBuilder r100);

    void onAsyncResponse(Call<T> r100, SsResponse<T> r101);
}
