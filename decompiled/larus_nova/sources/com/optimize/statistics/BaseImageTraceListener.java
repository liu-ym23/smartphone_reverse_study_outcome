package com.optimize.statistics;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public abstract class BaseImageTraceListener implements ImageTraceListener {
    public BaseImageTraceListener() {
    }

    @Override // com.optimize.statistics.ImageTraceListener
    public void imageNetCallBack(long r100, long r101, String r102, HttpRequestInfo r103, Throwable r104, JSONObject r105) {
    }
}
