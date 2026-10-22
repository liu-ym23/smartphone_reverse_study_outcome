package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface IWsClient {
    boolean isConnected();

    void onParameterChange(Map<String, String> r100, Map<String, String> r101, List<String> r102, boolean r103, boolean r104);

    void openConnection(Map<String, String> r100, Map<String, String> r101, List<String> r102, boolean r103, boolean r104);

    boolean sendMessage(byte[] r100, int r101) throws Exception;

    void stopConnection();
}
