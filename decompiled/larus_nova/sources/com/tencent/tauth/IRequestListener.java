package com.tencent.tauth;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public interface IRequestListener {
    void onComplete(JSONObject r100);

    void onHttpStatusException(HttpUtils.HttpStatusException r100);

    void onIOException(IOException r100);

    void onJSONException(JSONException r100);

    void onMalformedURLException(MalformedURLException r100);

    void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException r100);

    void onSocketTimeoutException(SocketTimeoutException r100);

    void onUnknowException(Exception r100);
}
