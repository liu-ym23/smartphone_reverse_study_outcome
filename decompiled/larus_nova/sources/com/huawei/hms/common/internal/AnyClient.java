package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

/* JADX INFO: loaded from: classes23.dex */
public interface AnyClient {

    public interface CallBack {
        void onCallback(IMessageEntity r100, String r101);
    }

    void connect(int r100);

    void connect(int r100, boolean r101);

    void disconnect();

    int getRequestHmsVersionCode();

    String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(IMessageEntity r100, String r101, CallBack r102);
}
