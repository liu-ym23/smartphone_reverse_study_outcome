package com.bytedance.ies.web.jsbridge2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface z<R> {

    public interface a {
        void a(JSONObject r100);

        void onFailed(Throwable r100);

        void onSucceed(Object r100);
    }

    CallContext a();

    a getCallBack();
}
