package com.ss.android.bytedcert.net.fetch;

import com.ss.android.bytedcert.net.fetch.BaseRequest;
import com.ss.android.bytedcert.net.fetch.BaseResponse;

/* JADX INFO: loaded from: classes34.dex */
public interface RequestService<T extends BaseRequest, R extends BaseResponse> {

    public interface Callback<R extends BaseResponse> {
        void onResponse(R r100);
    }

    void request(T r100, Callback<R> r101);
}
