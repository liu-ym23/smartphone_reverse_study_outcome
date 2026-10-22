package com.bytedance.common.wschannel.channel;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r100, IWsChannelClient r101);

    boolean isConnected();

    void onAppStateChanged(int r100);

    void onConnection(JSONObject r100);

    void onMessage(WsChannelMsg r100);

    void onMessage(byte[] r100);

    void onNetworkStateChanged(int r100);

    void onParameterChange(Map<String, Object> r100, List<String> r101);

    void onServiceConnectEvent(int r100, boolean r101, String r102);

    void openConnection(Map<String, Object> r100, List<String> r101);

    boolean privateProtocolEnabled();

    boolean privateProtocolProxyEnabled();

    void registerService(int r100);

    boolean sendMessage(WsChannelMsg r100);

    boolean sendMessage(byte[] r100);

    void stopConnection();

    void unregisterService(int r100);
}
