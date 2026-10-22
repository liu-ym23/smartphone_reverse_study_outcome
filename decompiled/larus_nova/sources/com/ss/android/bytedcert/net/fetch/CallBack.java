package com.ss.android.bytedcert.net.fetch;

import com.ss.android.bytedcert.net.fetch.BaseRequest;
import com.ss.android.bytedcert.net.fetch.BaseResponse;

/* JADX INFO: loaded from: classes34.dex */
public interface CallBack<T extends BaseRequest, R extends BaseResponse> {
    void onError(T r100, R r101);

    void onSuccess(T r100, R r101, boolean r102);
}
