package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.os.Bundle;
import com.alipay.sdk.m.p.e;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.log.WsChannelLog;
import java.io.UnsupportedEncodingException;
import okhttp3.Response;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
class WsStatusChangedListener implements WsOkClient.WsStatusListener {
    private final Context mContext;
    private final IWsChannelClient mWsChannelClient;
    private final WsOkClient mWsClient;

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onConnecting(String r100) {
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r101 = new JSONObject();
        r101.put("type", 1);     // Catch: Exception -> L7
        r101.put("state", 1);     // Catch: Exception -> L7
        r101.put("url", r100);     // Catch: Exception -> L7
        r101.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(String r100) {
        Logger.d("WsChannelSdk_ok", "onMessage():" + r100);
        IWsChannelClient r101 = this.mWsChannelClient;
        if (r101 == null) goto L11;
        r101.onMessage(r100.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onOpen(Response r100) {
        Logger.d("WsChannelSdk_ok", "onOpen(): " + r100.toString());
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r101 = new JSONObject();
        r101.put("type", 1);     // Catch: Exception -> L7
        r101.put("state", 4);     // Catch: Exception -> L7
        r101.put("url", r100.request().url().toString());     // Catch: Exception -> L7
        r101.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(ByteString r100) {
        Logger.d("WsChannelSdk_ok", "onMessage() : " + r100.toString());
        IWsChannelClient r101 = this.mWsChannelClient;
        if (r101 == null) goto L6;
        r101.onMessage(r100.toByteArray());
        return;
    }

    public WsStatusChangedListener(Context r100, WsOkClient r101, IWsChannelClient r102) {
        this.mWsClient = r101;
        this.mWsChannelClient = r102;
        this.mContext = r100;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onClosed(String r100, int r101, String r102) {
        Logger.d("WsChannelSdk_ok", "onClosed() : " + r102);
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r103 = new JSONObject();
        r103.put("type", 0);     // Catch: Exception -> L7
        r103.put("state", 3);     // Catch: Exception -> L7
        r103.put("url", r100);     // Catch: Exception -> L7
        r103.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onFailure(String r100, int r101, String r102) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r102);
        Bundle r103 = new Bundle();
        r103.putString("url", r100);
        r103.putInt("error_code", r101);
        r103.putString("error_msg", r102);
        r103.putString(e.f25671s, "onFailure");
        WsChannelLog.onEventV3Bundle(this.mContext, "WsChannelSdk_ok", r103);
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r104 = new JSONObject();
        r104.put("type", 0);     // Catch: Exception -> L7
        r104.put("state", 2);     // Catch: Exception -> L7
        r104.put("url", r100);     // Catch: Exception -> L7
        r104.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r104.put("error", r102);     // Catch: Exception -> L7
        r104.put("error_code", r101);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r104);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
