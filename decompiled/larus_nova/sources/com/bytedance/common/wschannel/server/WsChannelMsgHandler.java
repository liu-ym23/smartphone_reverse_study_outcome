package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;
import com.bytedance.common.wschannel.utils.Utils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
class WsChannelMsgHandler implements IMessageHandler {
    private static AtomicBoolean mDispatcherAlive;
    private final Context mContext;
    private ExecutorService mExecutorService;
    private final ChannelKeeper mKeeper;
    private ChannelManager mManager;
    private Runnable mMessageDispatcher;
    private Future<?> mMessageDispatcherFeature;
    private BlockingQueue<WsChannelService.Msg> mMessageQueue;
    private final ClientMsgSender mMessageSender;
    private final boolean traceEnable;

    static {
        mDispatcherAlive = new AtomicBoolean(true);
    }

    private Runnable createMessageDispatcher() {
        return new AnonymousClass1(this);
    }

    private long getTsIfEnable() {
        if (this.traceEnable == true) goto L5;
        return 0;
    L5:
        return TimeCompactUtil.getTimeStampNanos();
    }

    private void startMessageDispatcher() {
        if (this.mMessageDispatcher != null) goto L10;
        this.mMessageDispatcher = createMessageDispatcher();
    L10:
        this.mMessageDispatcherFeature = this.mExecutorService.submit(this.mMessageDispatcher);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void syncSocketState() {
        Intent r100 = new Intent();     // Catch: Throwable -> L4
        r100.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r100.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L4
        r100.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.mKeeper.mChannelState.values()));     // Catch: Throwable -> L4
        startOrBindService(r100);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void tryResendMsg() {
        this.mMessageSender.tryResendMsg();
    }

    public static /* synthetic */ AtomicBoolean access$000() {
        return mDispatcherAlive;
    }

    public static /* synthetic */ BlockingQueue access$100(WsChannelMsgHandler r100) {
        return r100.mMessageQueue;
    }

    private void handleMessage(WsChannelService.Msg r110) {
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.data != null) goto L11;
        if (r110.message != null) goto L11;
        return;
    L11:
        if (r110.message == null) goto L13;
        boolean r100 = true;
    L60:
        long r101 = getTsIfEnable();     // Catch: Throwable -> L52
        if (r100 == false) goto L18;
        WsChannelMsg r102 = r110.message;     // Catch: Throwable -> L52
    L22:
        long r103 = getTsIfEnable();     // Catch: Throwable -> L52
        if (r102 != WsChannelMsg.EMPTY) goto L25;
    L50:
        Logger.e("WsChannelService", "handleMessage decode msg is EMPTY!");     // Catch: Throwable -> L52
        return;
    L25:
        if (FrontierMessageManager.shouldDropMessageByFilter(r102) == true) goto L50;
        r102.setNewMsgTimeHolder(new NewMsgTimeHolder(r110.f202965ts, r101, r103));     // Catch: Throwable -> L52
        r102.setChannelId(r110.channelId);     // Catch: Throwable -> L52
        r102.setReplayToComponentName(new ComponentName(this.mContext, WsChannelService.class));     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "version =  seqId = " + r102.getSeqId() + " logId = " + r102.getLogId() + " wsChannelMsg = " + r102.toString());     // Catch: Throwable -> L52
    L30:
        Map<Integer, IWsApp> r111 = this.mKeeper.mWsAppMap;     // Catch: Throwable -> L52
        if (r111 != null) goto L33;
    L48:
        Logger.e("WsChannelService", "mKeeper.mWsAppMap is empty!");     // Catch: Throwable -> L52
        return;
    L33:
        if (r111.size() <= 0) goto L48;
        Iterator<Map.Entry<Integer, IWsApp>> r112 = this.mKeeper.mWsAppMap.entrySet().iterator();     // Catch: Throwable -> L52
    L37:
        if (r112.hasNext() == false) goto L70;
        IWsApp r104 = r112.next().getValue();     // Catch: Throwable -> L52
        if (r104 == null) goto L40;
        if (r104.getChannelId() != r102.getChannelId()) goto L37;
        Intent r105 = new Intent();     // Catch: Throwable -> L46
        r105.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L46
        r105.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L46
        r105.putExtra(WsConstants.KEY_PAYLOAD, r102);     // Catch: Throwable -> L46
        startOrBindService(r105);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Logger.e("WsChannelService", "deliver fail,reason:" + th);     // Catch: Throwable -> L52
        goto L37
    L40:
        Logger.e("WsChannelService", "wsApp is null!");     // Catch: Throwable -> L52
        goto L37
    L70:
        return;
    L18:
        byte[] r106 = r110.data;     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L21;
        Logger.d("WsChannelService", "data = " + Utils.byte2HexStr(r106) + " data.length = " + r106.length);     // Catch: Throwable -> L52
    L21:
        r102 = MsgConverterFactory.getConverter().decode(r106);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L56;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L56:
        th.printStackTrace();
        return;
    L13:
        r100 = false;
        goto L60
    }

    private void startOrBindService(Intent r100) {
        this.mMessageSender.sendMsg(r100);
    }

    private void trySyncCurrentState(IWsChannelClient r100) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        this.mManager.syncCurrentState(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onServiceConnectEvent(ServiceConnectEvent r100) {
        Intent r101 = new Intent();     // Catch: Throwable -> L4
        r101.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r101.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L4
        r101.putExtra("service", r100);     // Catch: Throwable -> L4
        startOrBindService(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setChannelManager(ChannelManager r100) {
        this.mManager = r100;
    }

    public WsChannelMsgHandler(Context r100, ChannelKeeper r101) {
        this.mMessageQueue = new LinkedBlockingQueue();
        this.mExecutorService = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("WsChannelMsgHandler"));
        this.mMessageDispatcher = createMessageDispatcher();
        this.mMessageDispatcherFeature = null;
        this.mContext = r100;
        this.mKeeper = r101;
        this.mMessageSender = new ClientMsgSender(r100, WsClientService.class);
        this.traceEnable = true;
        startMessageDispatcher();
    }

    public static /* synthetic */ void access$200(WsChannelMsgHandler r100, WsChannelService.Msg r101) {
        r100.handleMessage(r101);
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r100, SocketState r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.mKeeper.mChannelState.put(Integer.valueOf(r101.getChannelId()), r101);
        Intent r102 = new Intent();     // Catch: Throwable -> L7
        r102.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r102.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L7
        r102.putExtra(WsConstants.KEY_CONNECTION, r101);     // Catch: Throwable -> L7
        startOrBindService(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r100, WsChannelMsg r101) {
        if (r101 != null) goto L9;
        return;
    L9:
        WsChannelService.Msg r102 = new WsChannelService.Msg(r100, r101, getTsIfEnable());     // Catch: Throwable -> L6
        this.mMessageQueue.offer(r102);     // Catch: Throwable -> L6
        mDispatcherAlive.getAndSet(true);     // Catch: Throwable -> L6
        startMessageDispatcher();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void replySendMsgResult(WsChannelMsg r100, boolean r101) {
        ComponentName r102 = r100.getReplayToComponentName();
        if (r102 == null) goto L17;
        byte[] r103 = r100.getPayload();     // Catch: Throwable -> L12
        if (r103 != null) goto L7;
        r103 = new byte[1];     // Catch: Throwable -> L12
    L7:
        Intent r104 = new Intent();     // Catch: Throwable -> L12
        r104.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L12
        r104.setComponent(r102);     // Catch: Throwable -> L12
        r104.putExtra(WsConstants.KEY_SEND_RESULT, r101);     // Catch: Throwable -> L12
        r104.putExtra(WsConstants.KEY_PAYLOAD_MD5, DigestUtils.md5Hex(r103));     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelService", "send result = " + r101 + " payloadMd5 = " + r104.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L12
    L10:
        this.mContext.startService(r104);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r100, byte[] r101) {
        if (r101 != null) goto L9;
        return;
    L9:
        WsChannelService.Msg r102 = new WsChannelService.Msg(r100, r101, getTsIfEnable());     // Catch: Throwable -> L6
        this.mMessageQueue.offer(r102);     // Catch: Throwable -> L6
        mDispatcherAlive.getAndSet(true);     // Catch: Throwable -> L6
        startMessageDispatcher();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r100, int r101, JSONObject r102) {
        if (r102 != null) goto L12;
        return;
    L12:
        r102.put("channel_id", r101);     // Catch: JSONException -> L6
    L8:
        SocketState r103 = SocketState.fromJson(r102);
        onConnection(r100, r103);
        trySyncCurrentState(r100);
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelService", "onConnection: state=" + r103.connectionState + " | type=" + r103.connectionType + " | error=" + r103.error);
        return;
    L14:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
