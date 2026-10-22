package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.MainChannelManager;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelSingleProcessImpl implements WsChannelApi {
    public WsChannelSingleProcessImpl() {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(Context r100, int r101) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r100, boolean r101) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r100, boolean r101, boolean r102) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context r100) {
        sendAppState(r100, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context r100) {
        sendAppState(r100, 1);
    }

    private void sendAppState(Context r100, int r101) {
        if (r100 == null) goto L15;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r101 <= 3) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r101);
    L11:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L13;
        return;
    L13:
        Message r102 = new Message();
        r102.what = 2;
        r102.arg1 = r101;
        MainChannelManager.inst(r100).handleMsg(r102);
        return;
    }

    private void sendMsg(Context r100, WsChannelApi.ServiceHolder r101) {
        Message r102 = Message.obtain();
        r102.what = r101.what;
        r102.getData().putParcelable(r101.key, r101.obj);
        MainChannelManager.inst(r100).handleMsg(r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context r100, SsWsApp r101) {
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L5;
        return;
    L5:
        WsChannelApi.ServiceHolder r102 = new WsChannelApi.ServiceHolder();
        r102.key = WsConstants.KEY_WS_APP;
        r102.obj = r101;
        r102.what = 4;
        sendMsg(r100, r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context r100, SsWsApp r101) {
        WsChannelApi.ServiceHolder r102 = new WsChannelApi.ServiceHolder();
        r102.key = WsConstants.KEY_WS_APP;
        r102.obj = r101;
        r102.what = 0;
        sendMsg(r100, r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context r100, WsChannelMsg r101) {
        WsChannelApi.ServiceHolder r102 = new WsChannelApi.ServiceHolder();
        r102.key = WsConstants.KEY_PAYLOAD;
        r102.obj = r101;
        r102.what = 5;
        sendMsg(r100, r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context r100, int r101) {
        WsChannelApi.ServiceHolder r102 = new WsChannelApi.ServiceHolder();
        r102.key = WsConstants.KEY_WS_APP;
        r102.obj = new IntegerParcelable(r101);
        r102.what = 1;
        sendMsg(r100, r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context r100, int r101, int r102) {
        WsChannelApi.ServiceHolder r103 = new WsChannelApi.ServiceHolder();
        r103.key = WsConstants.KEY_WS_APP;
        r103.obj = new ServiceParcelable(r101, r102);
        r103.what = 12;
        sendMsg(r100, r103);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context r100, int r101, int r102) {
        WsChannelApi.ServiceHolder r103 = new WsChannelApi.ServiceHolder();
        r103.key = WsConstants.KEY_WS_APP;
        r103.obj = new ServiceParcelable(r101, r102);
        r103.what = 13;
        sendMsg(r100, r103);
    }
}
