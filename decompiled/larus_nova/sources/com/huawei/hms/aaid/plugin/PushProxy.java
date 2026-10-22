package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public interface PushProxy {
    void deleteAllToken(Context r100) throws ApiException;

    void deleteToken(Context r100, String r101, String r102) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context r100, String r101, String r102) throws ApiException;

    Task<Void> subscribe(Context r100, String r101, String r102);

    Task<Void> turnOff(Context r100, String r101);

    Task<Void> turnOn(Context r100, String r101);

    Task<Void> unsubscribe(Context r100, String r101, String r102);
}
