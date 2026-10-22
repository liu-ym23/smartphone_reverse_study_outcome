package com.bytedance.common.wschannel.heartbeat.monitor;

/* JADX INFO: loaded from: classes15.dex */
public interface IHeartBeatMonitor {
    void onPingFail(Throwable r100);

    void onPingSuccess();

    void onPingTimeout();
}
