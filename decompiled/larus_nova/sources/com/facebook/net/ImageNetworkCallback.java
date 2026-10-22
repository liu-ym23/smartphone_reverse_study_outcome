package com.facebook.net;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageNetworkCallback {
    void onImageErrorCallBack(long r100, long r101, ResponseWrap r102, HttpRequestInfo r103, Throwable r104, JSONObject r105);

    void onImageOkCallBack(long r100, long r101, ResponseWrap r102, HttpRequestInfo r103, Throwable r104, JSONObject r105);
}
