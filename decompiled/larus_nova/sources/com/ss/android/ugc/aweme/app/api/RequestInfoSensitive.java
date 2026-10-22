package com.ss.android.ugc.aweme.app.api;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes40.dex */
public interface RequestInfoSensitive {
    public static final Gson X1 = null;

    BaseHttpRequestInfo getRequestInfo();

    void setRequestInfo(BaseHttpRequestInfo r100);

    static {
        X1 = new Gson();
    }
}
