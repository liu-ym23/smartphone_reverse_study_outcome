package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenInterceptor {

    public interface Chain {
        OpenHostResponse proceed(OpenHostRequest r100) throws Exception;

        OpenHostRequest request();
    }

    OpenHostResponse intercept(Chain r100) throws Exception;
}
