package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public interface WsChannelApi {

    public static class ServiceHolder {
        String key;
        Parcelable obj;
        int what;

        public ServiceHolder() {
        }
    }

    void onEnterToBackground(Context r100);

    void onEnterToForeground(Context r100);

    void onParameterChange(Context r100, SsWsApp r101);

    void onTrimMemory(Context r100, int r101);

    void registerApp(Context r100, SsWsApp r101);

    void registerServiceId(Context r100, int r101, int r102);

    void sendPayload(Context r100, WsChannelMsg r101);

    void tryStartPushProcess(Context r100, boolean r101);

    void tryStartPushProcess(Context r100, boolean r101, boolean r102);

    void unRegisterApp(Context r100, int r101);

    void unregisterServiceId(Context r100, int r101, int r102);
}
