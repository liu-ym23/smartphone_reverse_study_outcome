package com.optimize.statistics;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface ImageTraceListener {
    void imageNetCallBack(long r100, long r101, String r102, HttpRequestInfo r103, Throwable r104, JSONObject r105);

    void onImageLoaded(boolean r100, String r101, JSONObject r102);
}
