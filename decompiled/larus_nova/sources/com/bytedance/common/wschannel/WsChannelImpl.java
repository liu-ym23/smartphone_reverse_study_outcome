package com.bytedance.common.wschannel;

import android.content.Context;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class WsChannelImpl implements WsChannel {
    private ChannelInfo mChannelInfo;
    private final Context mContext;
    private final WsChannelApi mImpl;
    private AtomicBoolean mPendingUnRegister;
    private boolean mPrivateProtocolEnabled;
    private final OnMessageReceiveListener mReceiver;
    private ConcurrentHashMap<Integer, Boolean> mServiceState;
    private ConnectionState mState;
    private SsWsApp mWsApp;

    public void onReceiveServiceConnectEvent(ServiceConnectEvent r100) {
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public int getChannelId() {
        return this.mChannelInfo.channelId;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isConnected() {
        if (this.mState != ConnectionState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    public void register() {
        this.mImpl.registerApp(this.mContext, this.mWsApp);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void unregister() {
        this.mImpl.unRegisterApp(this.mContext, this.mChannelInfo.channelId);
        this.mPendingUnRegister.set(true);
    }

    public void onReceive(WsChannelMsg r100) {
        if (this.mReceiver != null) goto L5;
        return;
    L5:
        if (r100.isAckMsg() == true) goto L9;
        this.mReceiver.onReceiveMsg(r100);
        return;
    }

    public void syncServiceState(ServiceConnectEvent r100) {
        this.mServiceState.put(Integer.valueOf(r100.getServiceId()), Boolean.valueOf(r100.isServiceConnected()));
    }

    public void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101) {
        OnMessageReceiveListener r102 = this.mReceiver;
        if (r102 == null) goto L6;
        r102.onReceiveConnectEvent(r100, r101);
    L6:
        if (r100.connectionState == ConnectionState.CONNECT_CLOSED) goto L8;
        return;
    L8:
        if (this.mPendingUnRegister.get() == false) goto L12;
        WsChannelSdk2.unregister(getChannelId());
        return;
    }

    public void replySendMsgResult(WsChannelMsg r100, boolean r101) {
        if ((r100 instanceof MainProcessMsg) == false) goto L8;
        MainProcessMsg r102 = (MainProcessMsg) r100;
        WsChannelMsg r103 = r102.getOrigin();
        MsgSendListener r104 = r102.getListener();
        if (r104 == null) goto L9;
        r104.onSendResult(r103, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void sendMsg(WsChannelMsg r100, MsgSendListener r101) {
        if (r100.getChannelId() != this.mChannelInfo.channelId) goto L12;
        if (this.mPendingUnRegister.get() == false) goto L9;
        if (r101 == null) goto L13;
        r101.onSendResult(r100, false);
        return;
    L13:
        return;
    L9:
        this.mImpl.sendPayload(this.mContext, new MainProcessMsg(r100, r101));
        return;
    L12:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    public void syncState(ConnectionState r100, boolean r101) {
        this.mState = r100;
        this.mPrivateProtocolEnabled = r101;
    }

    public WsChannelImpl(Context r100, WsChannelApi r101, ChannelInfo r102, OnMessageReceiveListener r103, OnServiceConnectListener r104, OnMessageAckListener r105) {
        this.mPendingUnRegister = new AtomicBoolean(false);
        this.mServiceState = new ConcurrentHashMap();
        this.mContext = r100;
        this.mImpl = r101;
        this.mChannelInfo = r102;
        this.mReceiver = r103;
        this.mWsApp = WsChannelSdk2.createParameterMap(r102);
    }
}
