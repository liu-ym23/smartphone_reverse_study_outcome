package com.bytedance.sdk.xbridge.cn.websocket.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes22.dex */
public interface BdpWsClient {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SocketDataType {
    }

    public interface a {
        void c(int r100, String r101, String r102);

        void onMessage(byte[] r100, int r101);
    }
}
