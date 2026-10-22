package com.bytedance.common.wschannel.heartbeat;

import com.bytedance.common.wschannel.heartbeat.model.AppState;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public interface IHeartBeatPolicy {
    void onAppStateUpdate(AppState r100);

    void onConnected(Response r100);

    void onDisconnected();

    void onPingSendSuccess();

    void onReceivePong();
}
